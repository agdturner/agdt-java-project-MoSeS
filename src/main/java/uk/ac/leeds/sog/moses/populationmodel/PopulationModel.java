package uk.ac.leeds.sog.moses.populationmodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Location;
import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.datamodel.Simulationcontrol;
import uk.ac.leeds.sog.moses.populationmodel.student.StudentSimulationHelper;
import uk.ac.leeds.sog.moses.populationmodel.tools.DataIntegrityChecker;
import uk.ac.leeds.sog.moses.populationmodel.tools.SimulationRecorder;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class PopulationModel {

	public static final int SIMULATION_END_YAER = ApplicationConstants.SIMULATION_END_YAER;
	
	private List i_models = null;
	private int i_simulationYear = 0;
	private Simulationcontrol i_simControl = null;
	private List i_locations = null;
	private PopulationDataHelper i_dataHelper;
	
	private static boolean s_manualControl = false;
	static{
		if(System.getProperty("ManualControl") != null && System.getProperty("ManualControl").equalsIgnoreCase("true")) {
			s_manualControl = true;
		}
	}
	private static Logger s_logger = MosesLogger.getLogger(PopulationModel.class);
	
	public PopulationModel() {
		s_logger.info("Constructing PopulationModel");
		i_models = new ArrayList();
		i_dataHelper = new PopulationDataHelper();
		i_locations = i_dataHelper.getAllLocations();
		i_simControl = i_dataHelper.getSimControl();
		i_simControl.setSimulationStarted("Y");
		i_simControl.setSimulationStopped("N");
		i_simControl.setSimulationPaused("N");
		i_simulationYear = ApplicationConstants.SIMULATION_START_YAER;
		i_dataHelper.setSimulationYear(i_simulationYear);
		i_simControl.setSimulationYear(String.valueOf(i_simulationYear));
		i_dataHelper.setSimControl(i_simControl);
		for(int i=0; i<i_locations.size(); i++) {
			Location location = (Location) i_locations.get(i);
			i_models.add(new AreaPopulationModel(location, i_dataHelper, this));
		}
		
		// i_dataHelper.updateSimulationControl(i_simControl);
	}
	
	public void step() {
		i_dataHelper.setTotalNumberOfPeople(getTotalNumberOfPeople());
		i_dataHelper.setSimulationYear(i_simulationYear);
		i_simControl.setSimulationYear(String.valueOf(i_simulationYear));
		SimulationRecorder.initialise(String.valueOf(i_simulationYear));
		
		StudentSimulationHelper.initialise(i_dataHelper);
		StudentSimulationHelper.generateStudents();
		StudentSimulationHelper.resetPAccomDistributionList();
		StudentSimulationHelper.resetUAccomDistributionList();
		
		// simulate
		s_logger.info("\n------------- Start simluation for " + i_simulationYear + "-------------\n");
		if(System.getProperty("AutoTest") != null && System.getProperty("AutoTest").equalsIgnoreCase("true")) {
			s_logger.info("\n------------- Checking data -------------\n");
			DataIntegrityChecker.check();
		}
		
		for(int i=0; i<i_models.size(); i++) {
			AreaPopulationModel model = (AreaPopulationModel) i_models.get(i);
			model.initialise();
		}
		
		recordPopulation();
		
		for(int i=0; i<i_models.size(); i++) {
			AreaPopulationModel model = (AreaPopulationModel) i_models.get(i);
			model.step();
		}
		
		List leavingStudents = StudentSimulationHelper.getLeavingStudents();
		/*for(int i=0; i<leavingStudents.size(); i++) {
			Person std = ((PersonAgent) leavingStudents.get(i)).getPerson();
			s_logger.info("leaving student type: " + std.getStudentType());
		}*/
		s_logger.info("students left: " + leavingStudents.size());
		s_logger.info("\n------------- End simluation for " + i_simulationYear + "-------------\n");
		
		i_simulationYear++;
	}
	
	public void pause() {
		// i_simControl = i_dataHelper.getSimulationcontrol();
		i_simControl.setSimulationPaused("Y");
		// i_dataHelper.updateSimulationControl(i_simControl);
	}
	
	public boolean isPaused() {
		// i_simControl = i_dataHelper.getSimulationcontrol();
		if(i_simControl.getSimulationPaused().equals("Y")) {
			return true;
		} else {
			return false;
		}
	}

	public void restart() {
		// i_simControl = i_dataHelper.getSimulationcontrol();
		i_simControl.setSimulationPaused("N");
		i_simControl.setSimulationStopped("N");
		// i_dataHelper.updateSimulationControl(i_simControl);
	}
	
	public void stop() {
		// i_simControl = i_dataHelper.getSimulationcontrol();
		i_simControl.setSimulationStopped("Y");
		// i_dataHelper.updateSimulationControl(i_simControl);
	}
	
	public boolean isStopped() {
		if(i_simControl.getSimulationStopped().equals("Y")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void start() {
		int startYear = ApplicationConstants.SIMULATION_START_YAER;
		int endYear = ApplicationConstants.SIMULATION_END_YAER;
		for(int year=startYear; year<=endYear; year++) {
			s_logger.info("\nSimulation for " +  year);
			try {
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				// do nothing
			}
			if(isPaused()) {
				// paused
				s_logger.info("Simulation is paused in: " + year);
				year--;
				continue;
			}
			
			step();
			
			// manual control
			if(s_manualControl) {
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				    String s;
				    System.out.print("Do you want to continue simulation(y/n): ");
				    s = in.readLine();
				    if(s.equalsIgnoreCase("N")) {
				    	// stop
				    	stop();
				    	s_logger.info("Simulation stops before " +  (getSimulationYear() + 1));
				    	System.exit(0);
				    }
				    
				} catch(IOException e) {
					// do nothing
				}
			} 
			
			if(isStopped()) {
				stop();
				s_logger.info("Simulation stops before " +  (getSimulationYear() + 1));
				System.exit(0);
			}
			
			// System.out.println("Simulation continues...");
		}
		s_logger.info("Simulation stops before " + (SIMULATION_END_YAER + 1));
		
		SimulationRecorder.close();
	}
	
	public int getSimulationYear() {
		return i_simulationYear;
	}
	
	private int getTotalNumberOfPeople() {
		int num = 0;
		for(int i=0; i<i_locations.size(); i++) {
			Location location = (Location) i_locations.get(i);
			List persons = i_dataHelper.getPersonsByLocation(location);
			num += persons.size();
		}
		return num;
	}
	
	private void recordPopulation() {
		try {
			// Simulationcontrol i_simControl = i_dataHelper.getSimulationcontrol();
			String year = i_simControl.getSimulationYear();
			Calendar c = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss s");
			s_logger.info("Record population data in " + year + " " + format.format(c.getTime()));
			String fileName = "population_" + year + ".csv";
			PrintStream out = new PrintStream(new FileOutputStream(new File("result", fileName)));
			out.println("Year " + " " + year);
			out.flush();
			
			PrintStream outStudent = new PrintStream(new FileOutputStream(new File("result", "students_" + year + ".csv")));
			outStudent.println("Year " + " " + year);
			outStudent.flush();
			
			List counters = new ArrayList();
			List counterListOfStudents = new ArrayList();
			for(int i=0; i<i_locations.size(); i++) {
				Location location = (Location) i_locations.get(i);
				CounterOfPeopleByLocation counter = new CounterOfPeopleByLocation(location.getWardLocation());
				CounterOfStudentsByLocation counterStudents = new CounterOfStudentsByLocation(location.getWardLocation());
				
				c = Calendar.getInstance();
				List persons = i_dataHelper.getPersonsByLocation(location);
				s_logger.info("record " + persons.size() + " persons in location "+ location.getWardLocation() + " at " + format.format(c.getTime()));
				
				for(int j=0; j<persons.size(); j++) {
					Person person = (Person) persons.get(j);
					if(person.getGender().equals("M")) {
						counter.addMale(person.getAge().intValue());
					} else if(person.getGender().equals("F")) {
						counter.addFemale(person.getAge().intValue());	
					}
					if(person.getStudent().equals("1") && person.getStudentType() != null) {
						counterStudents.count(person);
					}
				}
				counters.add(counter);
				counterListOfStudents.add(counterStudents);
			}
			
			StringBuffer buffer = new StringBuffer("Male");
			for(int i=0; i<counters.size(); i++) {
				buffer.append(",Ward ");
				CounterOfPeopleByLocation counter = (CounterOfPeopleByLocation) counters.get(i);
				buffer.append(counter.getLocation());
			}
			out.println(buffer.toString());
			out.flush();
			for(int age=0; age<=100; age++) {
				buffer = new StringBuffer("Year ");
				buffer.append(age);
				for(int i=0; i<counters.size(); i++) {
					CounterOfPeopleByLocation counter = (CounterOfPeopleByLocation) counters.get(i);
					buffer.append(",");
					buffer.append(counter.getNumberOfMale(age));
				}
				out.println(buffer.toString());
				out.flush();
			}
			
			
			buffer = new StringBuffer("Female");
			for(int i=0; i<i_locations.size(); i++) {
				buffer.append(",Ward ");
				Location location = (Location) i_locations.get(i);
				buffer.append(location.getWardLocation());
			}
			out.println(buffer.toString());
			out.flush();
			for(int age=0; age<=100; age++) {
				buffer = new StringBuffer("Year ");
				buffer.append(age);
				for(int i=0; i<i_locations.size(); i++) {
					CounterOfPeopleByLocation counter = (CounterOfPeopleByLocation) counters.get(i);
					buffer.append(",");
					buffer.append(counter.getNumberOfFemale(age));
				}
				out.println(buffer.toString());
				out.flush();
			}
			out.close();
			
			// record students
			// for(int i=0; i<i_locations.size(); i++) {
			StringBuffer tempBuffer= new StringBuffer();
			tempBuffer.append("Student Type");
			for(int i=0; i<counterListOfStudents.size(); i++) {
				CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(i);
				tempBuffer.append(",");
				tempBuffer.append(counter.getLocation());
			}
			outStudent.println(tempBuffer.toString());
			outStudent.flush();
			
			// undergraduate 1
			tempBuffer= new StringBuffer();
			tempBuffer.append("undergraduate1(17)");
			for(int i=0; i<counterListOfStudents.size(); i++) {
				CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(i);
				tempBuffer.append(",");
				tempBuffer.append(counter.getI_numberOfUnder1_17());
			}
			outStudent.println(tempBuffer.toString());
			outStudent.flush();
			tempBuffer= new StringBuffer();
			tempBuffer.append("undergraduate1(18)");
			for(int i=0; i<counterListOfStudents.size(); i++) {
				CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(i);
				tempBuffer.append(",");
				tempBuffer.append(counter.getI_numberOfUnder1_18());
			}
			outStudent.println(tempBuffer.toString());
			outStudent.flush();
			
			// undergraduate 2
			tempBuffer= new StringBuffer();
			tempBuffer.append("undergraduate2(18)");
			for(int i=0; i<counterListOfStudents.size(); i++) {
				CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(i);
				tempBuffer.append(",");
				tempBuffer.append(counter.getI_numberOfUnder2_18());
			}
			outStudent.println(tempBuffer.toString());
			outStudent.flush();	
			tempBuffer= new StringBuffer();
			tempBuffer.append("undergraduate2(19)");
			for(int i=0; i<counterListOfStudents.size(); i++) {
				CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(i);
				tempBuffer.append(",");
				tempBuffer.append(counter.getI_numberOfUnder2_19());
			}
			outStudent.println(tempBuffer.toString());
			outStudent.flush();
			
			// undergraduate 3
			tempBuffer= new StringBuffer();
			tempBuffer.append("undergraduate3(19)");
			for(int i=0; i<counterListOfStudents.size(); i++) {
				CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(i);
				tempBuffer.append(",");
				tempBuffer.append(counter.getI_numberOfUnder3_19());
			}
			outStudent.println(tempBuffer.toString());
			outStudent.flush();	
			tempBuffer= new StringBuffer();
			tempBuffer.append("undergraduate3(20)");
			for(int i=0; i<counterListOfStudents.size(); i++) {
				CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(i);
				tempBuffer.append(",");
				tempBuffer.append(counter.getI_numberOfUnder3_20());
			}
			outStudent.println(tempBuffer.toString());
			outStudent.flush();
			
			// MSc
			tempBuffer= new StringBuffer();
			tempBuffer.append("MSc(20)");
			for(int i=0; i<counterListOfStudents.size(); i++) {
				CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(i);
				tempBuffer.append(",");
				tempBuffer.append(counter.getI_numberOfMsc_20());
			}
			outStudent.println(tempBuffer.toString());
			outStudent.flush();	
			tempBuffer= new StringBuffer();
			tempBuffer.append("MSc(21)");
			for(int i=0; i<counterListOfStudents.size(); i++) {
				CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(i);
				tempBuffer.append(",");
				tempBuffer.append(counter.getI_numberOfMsc_21());
			}
			outStudent.println(tempBuffer.toString());
			outStudent.flush();	
			tempBuffer= new StringBuffer();
			tempBuffer.append("MSc(22)");
			for(int i=0; i<counterListOfStudents.size(); i++) {
				CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(i);
				tempBuffer.append(",");
				tempBuffer.append(counter.getI_numberOfMsc_22());
			}
			outStudent.println(tempBuffer.toString());
			outStudent.flush();	
			
			
			// PhD 1
			for(int i=22; i<=32; i++) {
				tempBuffer= new StringBuffer();
				tempBuffer.append("PhD1(" + i + ")");
				for(int j=0; j<counterListOfStudents.size(); j++) {
					CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(j);
					tempBuffer.append(",");
					tempBuffer.append(counter.getNumberOfPhD1(i));
				}
				outStudent.println(tempBuffer.toString());
				outStudent.flush();
			}
			
			// PhD 2
			for(int i=22; i<=32; i++) {
				tempBuffer= new StringBuffer();
				tempBuffer.append("PhD2(" + i + ")");
				for(int j=0; j<counterListOfStudents.size(); j++) {
					CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(j);
					tempBuffer.append(",");
					tempBuffer.append(counter.getNumberOfPhD2(i));
				}
				outStudent.println(tempBuffer.toString());
				outStudent.flush();
			}
			// PhD3
			for(int i=22; i<=32; i++) {
				tempBuffer= new StringBuffer();
				tempBuffer.append("PhD3(" + i + ")");
				for(int j=0; j<counterListOfStudents.size(); j++) {
					CounterOfStudentsByLocation counter = (CounterOfStudentsByLocation) counterListOfStudents.get(j);
					tempBuffer.append(",");
					tempBuffer.append(counter.getNumberOfPhD3(i));
				}
				outStudent.println(tempBuffer.toString());
				outStudent.flush();
			}
			outStudent.close();
			
			// count total number of people
			int totalNumber = 0;
			for(int i=0; i<counters.size(); i++) {
				CounterOfPeopleByLocation counter = (CounterOfPeopleByLocation) counters.get(i);
				for(int age=0; age<=100; age++) {
					totalNumber += counter.getNumberOfFemale(age);
					totalNumber += counter.getNumberOfMale(age);
				}
			}
			s_logger.info("Total number of people: " + totalNumber);
			// i_dataHelper.setTotalNumberOfPeople(totalNumber);
		} catch(IOException e) {
			s_logger.error("IOException: " + e.toString());
			e.printStackTrace();
		}
	}
	
	class CounterOfPeopleByLocation {
		private static final int MAX_AGE = 100;
		private String i_location;
		private int i_numberOfMaleByAge[];
		private int i_numberOfFemaleByAge[];
		
		CounterOfPeopleByLocation(String location) {
			i_location = location;
			i_numberOfMaleByAge = new int[MAX_AGE + 1];
			i_numberOfFemaleByAge = new int[MAX_AGE + 1];
			for(int i=0; i<=MAX_AGE; i++) {
				i_numberOfMaleByAge[i] = 0;
				i_numberOfFemaleByAge[i] = 0;
			}
		}
		
		public void addMale(int age) {
			if(age >= MAX_AGE) {
				age = MAX_AGE;
			}
			i_numberOfMaleByAge[age]++;
		}
		
		public void addFemale(int age) {
			if(age >= MAX_AGE) {
				age = MAX_AGE;
			}
			i_numberOfFemaleByAge[age]++;
		}
		
		public int getNumberOfMale(int age) {
			return i_numberOfMaleByAge[age];
		}
		
		public int getNumberOfFemale(int age) {
			return i_numberOfFemaleByAge[age];
		}
		
		public String getLocation() {
			return i_location;
		}
	}
	
	class CounterOfStudentsByLocation {
		private String i_location;
		private int i_numberOfUnder1_17;
		private int i_numberOfUnder1_18;
		private int i_numberOfUnder2_18;
		private int i_numberOfUnder2_19;
		private int i_numberOfUnder3_19;
		private int i_numberOfUnder3_20;
		private int i_numberOfMsc_20;
		private int i_numberOfMsc_21;
		private int i_numberOfMsc_22;
		private int[] numberOfPhD1 = new int[11];
		private int[] numberOfPhD2 = new int[11];
		private int[] numberOfPhD3 = new int[11];
		
		CounterOfStudentsByLocation(String location) {
			i_location = location;
			i_numberOfUnder1_17 = 0;
			i_numberOfUnder1_18 = 0;
			i_numberOfUnder2_18 = 0;
			i_numberOfUnder2_19 = 0;
			i_numberOfUnder3_19 = 0;
			i_numberOfUnder3_20 = 0;
			i_numberOfMsc_20 = 0;
			i_numberOfMsc_21 = 0;
			i_numberOfMsc_22 = 0;
			for(int i=0; i<11; i++) {
				numberOfPhD1[i] = 0;
				numberOfPhD2[i] = 0;
				numberOfPhD3[i] = 0;
			}
		}
		
		public void count(Person student) {
			int ageInt = student.getAge().intValue();
			if(student.getStudentType().equals(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE)) {
				if(student.getYearInUniversity().equals("1")) {
					if(ageInt == 17) {
						i_numberOfUnder1_17++;
					} else if(ageInt == 18) {
						i_numberOfUnder1_18++;
					}
				}
				if(student.getYearInUniversity().equals("2")) {
					if(ageInt == 18) {
						i_numberOfUnder2_18++;
					} else if(ageInt == 19) {
						i_numberOfUnder2_19++;
					}
				}
				if(student.getYearInUniversity().equals("3")) {
					if(ageInt == 19) {
						i_numberOfUnder3_19++;
					} else if(ageInt == 20) {
						i_numberOfUnder3_20++;
					}
				}
			}
			if(student.getStudentType().equals(ApplicationConstants.STUDENT_TYPE_MSC)) {
				if(ageInt == 20) {
					i_numberOfMsc_20++;
				} else if(ageInt == 21) {
					i_numberOfMsc_21++;
				} else if(ageInt == 22) {
					i_numberOfMsc_22++;
				}
			}
			if(student.getStudentType().equals(ApplicationConstants.STUDENT_TYPE_PHD)) {
				if(ageInt > 32) {
					s_logger.info("PhD student age is over 29: " + student.getPid());
					return;
				}
				if(student.getYearInUniversity().equals("1")) {
					numberOfPhD1[ageInt - 22]++;
				}
				if(student.getYearInUniversity().equals("2")) {
					numberOfPhD2[ageInt - 22]++;
				}
				if(student.getYearInUniversity().equals("3")) {
					numberOfPhD3[ageInt -22]++;
				}
			}
		}

		public int getNumberOfPhD1(int age) {
			return numberOfPhD1[age - 22];
		}
		
		public int getNumberOfPhD2(int age) {
			return numberOfPhD2[age - 22];
		}
		
		public int getNumberOfPhD3(int age) {
			return numberOfPhD3[age - 22];
		}
		
		public String getLocation() {
			return i_location;
		}

		public int getI_numberOfUnder1_17() {
			return i_numberOfUnder1_17;
		}

		public void setI_numberOfUnder1_17(int ofUnder1_17) {
			i_numberOfUnder1_17 = ofUnder1_17;
		}

		public int getI_numberOfUnder1_18() {
			return i_numberOfUnder1_18;
		}

		public void setI_numberOfUnder1_18(int ofUnder1_18) {
			i_numberOfUnder1_18 = ofUnder1_18;
		}

		public int getI_numberOfUnder2_18() {
			return i_numberOfUnder2_18;
		}

		public void setI_numberOfUnder2_18(int ofUnder2_18) {
			i_numberOfUnder2_18 = ofUnder2_18;
		}

		public int getI_numberOfUnder2_19() {
			return i_numberOfUnder2_19;
		}

		public void setI_numberOfUnder2_19(int ofUnder2_19) {
			i_numberOfUnder2_19 = ofUnder2_19;
		}

		public int getI_numberOfUnder3_19() {
			return i_numberOfUnder3_19;
		}

		public void setI_numberOfUnder3_19(int ofUnder3_19) {
			i_numberOfUnder3_19 = ofUnder3_19;
		}

		public int getI_numberOfUnder3_20() {
			return i_numberOfUnder3_20;
		}

		public void setI_numberOfUnder3_20(int ofUnder3_20) {
			i_numberOfUnder3_20 = ofUnder3_20;
		}

		public int getI_numberOfMsc_20() {
			return i_numberOfMsc_20;
		}

		public void setI_numberOfMsc_20(int ofMsc_20) {
			i_numberOfMsc_20 = ofMsc_20;
		}

		public int getI_numberOfMsc_21() {
			return i_numberOfMsc_21;
		}

		public void setI_numberOfMsc_21(int ofMsc_21) {
			i_numberOfMsc_21 = ofMsc_21;
		}

		public int getI_numberOfMsc_22() {
			return i_numberOfMsc_22;
		}
		
		

		public void setI_numberOfMsc_22(int ofMsc_22) {
			i_numberOfMsc_22 = ofMsc_22;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		s_logger.info("Starting PopulationModel");
		PopulationModel populationModel = new PopulationModel();
		populationModel.start();
	}

}
