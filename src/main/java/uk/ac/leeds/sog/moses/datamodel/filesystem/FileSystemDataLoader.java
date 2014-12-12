package uk.ac.leeds.sog.moses.datamodel.filesystem;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Location;
import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.datamodel.Simulationcontrol;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.tools.AgeAdjuster;
import uk.ac.leeds.sog.moses.populationmodel.tools.StudentGenerator;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class FileSystemDataLoader {
	private static Logger s_logger = MosesLogger.getLogger(FileSystemDataLoader.class);
	private static String s_dataFileName = "ward-test-data.csv"; // "FullLeedsData.csv";ward1-33.csv;ward-test-data.csv
	private static String s_dataErrorFileName = "FileSystemDataLoaderror.csv";
	private static PrintStream s_out;
	private static List s_healthNumers;
	private static int s_healthNumIndex;
	private static final boolean CHECK = true;
	private static int s_duplicate = 0;
	private static long maxPID = 0L;
	private static long maxHouseholdID = 0L;
	private static int totalNum = 0;
	
	private static List students_17 = new ArrayList();
	private static List students_18 = new ArrayList();
	private static List students_19 = new ArrayList();
	private static List students_under1_new = new ArrayList();
	private static List students_under2_new = new ArrayList();
	private static List students_under3_new = new ArrayList();
	
	private static List students_20 = new ArrayList();
	private static List students_21 = new ArrayList();
	private static List students_22 = new ArrayList();
	
	private static List students_23 = new ArrayList();
	private static List students_24Over = new ArrayList();
	
	private static List students_under = new ArrayList();
	
	private static List students_msc = new ArrayList();
	private static List students_msc_new = new ArrayList();
	
	private static List students_phd = new ArrayList();
	
	private static List phdStdYearList = new ArrayList(300);
	private static int phdStdYearIndex = 0;
	
	private static List phdStdList = new ArrayList(5928);
	private static int phdStdIndex = 0;
	
	private static int studentsNum = 0;
	// private static int students15Num = 0;
	// private static int students16Num = 0;
	private static int students17Num = 0;
	private static int students18Num = 0;
	private static int students19Num = 0;
	
	private static int students20Num = 0;
	private static int students21Num = 0;
	private static int students22Num = 0;
	
	private static int students23Num = 0;
	private static int studentsOver24Num = 0;
	// private static int studentsOver30Num = 0;
	
	private static  int NEW_STUDENTS_SEQ = 0;;
	
	private static List newStudents = new ArrayList();
	
	static {
		if(System.getProperty("DataFile") != null) {
			s_dataFileName = System.getProperty("DataFile");
		}
		try {
			File dir = new File("log");
			if(!dir.exists()) {
				dir.mkdir();
			}
			File logFile = new File("log", s_dataErrorFileName);
			s_out = new PrintStream(new FileOutputStream(logFile));
			s_out.println("new pid,ward,hhid,pnum,id,error message");
			s_out.flush();
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		s_healthNumers = new ArrayList();
		s_healthNumIndex = 0;
		resetHealthNums();
		resetPhdStdYearDistribution();
		resetPhdStdDistribution();
	}
	
	private FileSystemDataLoader() {
	}
	
	public synchronized static void load() {
		// load data
		loadLocations();
		loadPersonsAndHouseholds();
		
		List students_under1_lib = new ArrayList();
		students_under1_lib.addAll(students_17);
		students_under1_lib.addAll(students_18);
		StudentGenerator sample_under1 = new StudentGenerator(students_under1_lib, "student_under1_sample.ser");
		
		List students_under2_lib = new ArrayList();
		students_under2_lib.addAll(students_18);
		students_under2_lib.addAll(students_19);
		new StudentGenerator(students_under2_lib, "student_under2_sample.ser");
		
		List students_under3_lib = new ArrayList();
		students_under3_lib.addAll(students_19);
		students_under3_lib.addAll(students_20);
		new StudentGenerator(students_under3_lib, "student_under3_sample.ser");
		
		StudentGenerator sample_msc =  new StudentGenerator(students_msc, "student_msc_sample.ser");
		
		List students_phd_lib = new ArrayList();
		students_phd_lib.addAll(students_23);
		students_phd_lib.addAll(students_24Over);
		StudentGenerator sample_phd = new StudentGenerator(students_phd_lib, "student_phd_sample.ser");
		
		// check data
		if(s_duplicate != 0) {
			String message = "have " + s_duplicate + " duplicate data";
			recordDataError("", "", "", "", "", message);
		}
		
		s_logger.info("total number of students with flag 1: " + studentsNum);
		s_logger.info("total number of undergraduate students with 17(under1): " + students17Num);
		s_logger.info("total number of undergraduate students with 18(under2): " + students18Num);
		s_logger.info("total number of undetgraduate students with 19(under3): " + students19Num);
		s_logger.info("total number of MSC students with 20(Msc): " + students20Num);
		s_logger.info("total number of MSc students with 21(Msc): " + students21Num);
		s_logger.info("total number of MSc students with 22(Msc): " + students22Num);
		s_logger.info("total number of students with 23 with flag 1: " + students23Num);
		s_logger.info("total number of students over 24 less than 30 with flag 1: " + studentsOver24Num);
		s_logger.info("Undergraduate: " + students_under.size());
		s_logger.info("MSc: " + students_msc.size());
		s_logger.info("PhD: " + students_phd.size());
		int number_phd1 = 0;
		int number_phd2 = 0;
		int number_phd3 = 0;
		for(int i=0; i<students_phd.size(); i++) {
			Person std = (Person) students_phd.get(i);
			if(std.getYearInUniversity().equals("1")) {
				number_phd1++;
			} else if(std.getYearInUniversity().equals("2")) {
				number_phd2++;
			} else if(std.getYearInUniversity().equals("3")) {
				number_phd3++;
			}
		}
		s_logger.info("PhD 1: " + number_phd1);
		s_logger.info("PhD 2: " + number_phd2);
		s_logger.info("PhD 3: " + number_phd3);
		
		maxPID++;
		maxHouseholdID++;
		
		// create new students
		createNewUndergraduate1(16763 - students_17.size());
		createNewUndergraduate2(16763 - students_18.size());
		createNewUndergraduate3(16763 - students_19.size());
		createNewMSc(12950 - students_msc.size());
		/*if(number_phd1 <320) {
			
		}
		if(number_phd1 <320) {
			
		}
		if(number_phd1 <320) {
			
		}*/

		// healthCheckNewStudents(newStudents);
		
		// create first year students
		List students_firstyear = new ArrayList();
		List students_under1 = new ArrayList();
		List students_msc = new ArrayList();
		List students_phd1 = new ArrayList();
		students_under1 = sample_under1.getStudents(16763);
		for(int i=0; i<students_under1.size(); i++) {
			Person student = (Person) students_under1.get(i);
			student.setStudentType(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE);
			student.setYearInUniversity("0");
		}
		students_msc = sample_msc.getStudents(12950);
		for(int i=0; i<students_msc.size(); i++) {
			Person student = (Person) students_msc.get(i);
			student.setStudentType(ApplicationConstants.STUDENT_TYPE_MSC);
			student.setYearInUniversity("0");
		}
		students_phd1 = sample_phd.getStudents(320);
		for(int i=0; i<students_phd1.size(); i++) {
			Person student = (Person) students_phd1.get(i);
			student.setStudentType(ApplicationConstants.STUDENT_TYPE_PHD);
			student.setYearInUniversity("0");
		}
		students_firstyear.addAll(students_under1);
		students_firstyear.addAll(students_msc);
		students_firstyear.addAll(students_phd1);
		new StudentGenerator(students_firstyear, "students_firstyear_sample.ser");
		
		// write new students
		writeNewStudents();
		
		loadSimulationControls();
	}
	
	private static void createNewUndergraduate1(int number) {
		StudentGenerator generator = new StudentGenerator("student_under1_sample.ser");
		List stds = generator.getUndergraduate1(number);
		convertStudent(stds);
		newStudents.addAll(stds);
		students_under1_new = stds;
		totalNum += stds.size();
		s_logger.info("New undergraduate 1: " + students_under1_new.size());
	}
	
	private static void createNewUndergraduate2(int number) {
		StudentGenerator generator = new StudentGenerator("student_under2_sample.ser");
		List stds = generator.getUndergraduate2(number);
		convertStudent(stds);
		newStudents.addAll(stds);
		students_under2_new = stds;
		totalNum += stds.size();
		s_logger.info("New undergraduate 2: " + students_under2_new.size());
	}
	
	private static void createNewUndergraduate3(int number) {
		StudentGenerator generator = new StudentGenerator("student_under3_sample.ser");
		List stds = generator.getUndergraduate3(number);
		convertStudent(stds);
		newStudents.addAll(stds);
		students_under3_new = stds;
		totalNum += stds.size();
		s_logger.info("New undergraduate 3: " + students_under3_new.size());
	}
	
	private static void createNewMSc(int number) {
		StudentGenerator generator = new StudentGenerator("student_msc_sample.ser");
		List stds = generator.getMsc(number);
		convertStudent(stds);
		newStudents.addAll(stds);
		students_msc_new = stds;
		totalNum += stds.size();
		s_logger.info("New MSc: " + students_msc_new.size());
	}
	
	private static void convertStudent(List students) {
		for(int i=0; i<students.size(); i++) {
			Person student = (Person) students.get(i);
			student.setPid(new Long(getNextPID()));
			student.setHrpStatus("Y");
			student.setFamilyRole(ApplicationConstants.HRP_ROLE);
			student.setHouseholdId(new Long(getNextHouseholdID()));
			student.setHouseholdSize(new Integer(1));
			student.setHasChildDependent("N");
			student.setNumberElderly(new Integer(0));
			student.setComment("cloned in data initialisation " + NEW_STUDENTS_SEQ);
			NEW_STUDENTS_SEQ++;
			student.setHasAgentSimulated("N");
			student.setHasMigrated("N");
			student.setHasMicroSimulated("Y");
		}
	}
	
	/*private static void healthCheckNewStudents(List newStudents) {
		List pids = new ArrayList();
		List householdids = new ArrayList();
		for(int i=0; i<newStudents.size(); i++) {
			Person student = (Person) newStudents.get(i);
			Long pid = student.getPid();
			Long householdid = student.getHouseholdId();
			if(pids.contains(pid) || householdids.contains(householdid)) {
				s_logger.info("duplicate data: pid=" + pid + " householdid=" + householdid);
				System.exit(1);
			}
			if(!student.getFamilyRole().equals("HRP") || student.getHouseholdSize().intValue() != 1) {
				s_logger.info("incorrect  data");
				System.exit(1);
			}
			pids.add(pid);
			householdids.add(householdid);
		}
	}*/
	
	private static void writeNewStudents() {
		List locations = null;
		ObjectInput input = null;
	    try{
	      //use buffering
	      InputStream file = new FileInputStream(new File("populationdata", "locations.ser"));
	      InputStream buffer = new BufferedInputStream( file );
	      input = new ObjectInputStream ( buffer );
	      locations = (ArrayList)input.readObject();
	    }
	    catch(IOException ex){
	      s_logger.error("Cannot perform input.", ex);
	    }
	    catch (ClassNotFoundException ex){
	    	s_logger.error("Unexpected class found upon input.", ex);
	    }
	    finally{
	      try {
	        if ( input != null ) {
	          input.close();
	        }
	      }
	      catch (IOException ex){
	    	  s_logger.error("Cannot close input stream.", ex);
	      }
	    }
	    
	    int number_old_std = 0;
	    for(int i=0; i<locations.size(); i++) {
	    	Location location = (Location) locations.get(i);
	    	List persons = getPersonsByLocation(location);
	    	for(int k=0; k<persons.size(); k++) {
	    		Person person = (Person) persons.get(k);
	    		if(person.getStudentType() != null) {
	    			if(person.getStudentType().equals(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE)
		    				|| person.getStudentType().equals(ApplicationConstants.STUDENT_TYPE_MSC)
		    				|| person.getStudentType().equals(ApplicationConstants.STUDENT_TYPE_PHD)) {
		    			person.setFirstMigration("Y");
		    			number_old_std++;
		    		}
	    		}
	    	}
	    	List temp = new ArrayList();
	    	for(int j=0; j<newStudents.size(); j++) {
	    		Person std = (Person) newStudents.get(j);
	    		std.setFirstMigration("Y");
	    		if(std.getWardLocation().equals(location.getWardLocation())) {
	    			temp.add(std);
	    		}
	    	}
	    	persons.addAll(temp);
	    	Collections.sort(persons);
	    	writePersonsByLocation(persons, location);
	    }
	    s_logger.info("number of old students: " + number_old_std);
	}
	
	private static List getPersonsByLocation(Location a_location) {
		String fileName = "persons_" + a_location.getWardLocation() + ".ser";
		List persons = new ArrayList();
		ObjectInput input = null;
	    try{
	      //use buffering
	      InputStream file = new FileInputStream(new File("populationdata", fileName));
	      InputStream buffer = new BufferedInputStream( file );
	      input = new ObjectInputStream ( buffer );
	      persons = (ArrayList)input.readObject();
	    }
	    catch(IOException ex){
	      s_logger.error("Cannot perform input.", ex);
	    }
	    catch (ClassNotFoundException ex){
	    	s_logger.error("Unexpected class found upon input.", ex);
	    }
	    finally{
	      try {
	        if ( input != null ) {
	          input.close();
	        }
	      }
	      catch (IOException ex){
	    	  s_logger.error("Cannot close input stream.", ex);
	      }
	    }
	    return persons;
	}
	
	private static void writePersonsByLocation(List persons, Location a_location) {
		String fileName = "persons_" + a_location.getWardLocation() + ".ser";
		ObjectOutput output = null;
	    try{
	      //use buffering
	      OutputStream file = new FileOutputStream(new File("populationdata", fileName));
	      OutputStream buffer = new BufferedOutputStream(file);
	      output = new ObjectOutputStream(buffer);
	      output.writeObject(persons);
	      output.flush();
	    }
	    catch(IOException ex){
	    	s_logger.error("Cannot perform output.", ex);
	    }
	    finally{
	      try {
	        if (output != null) {
	          output.close();
	        }
	      }
	      catch (IOException ex ){
	    	  s_logger.error("Cannot close output stream.", ex);
	      }
	    }
	}
	
	public synchronized static void load(String dataFileName) {
		// load data
		s_logger.info("loading locations");
		s_dataFileName = dataFileName;
		loadLocations();
		loadPersonsAndHouseholds();
		loadSimulationControls();
		
		// check data
		if(s_duplicate != 0) {
			String message = "have " + s_duplicate + " duplicate data";
			recordDataError("", "", "", "", "", message);
		}
		
		// s_logger.info("total number of students: " + numOfStudent);
	}
	
	private static void loadPersonsAndHouseholds() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("populationdata", s_dataFileName)));
			List householdmembers = new ArrayList();
			List personsByLocation = new ArrayList(); // 
			String s = in.readLine();
			Person person = createPerson(s);
			householdmembers.add(person);
			personsByLocation.add(person);
			// personsByLocation.add(person);
			String location = person.getWardLocation();
			long householdid = person.getHouseholdId().longValue();
			maxPID = person.getPid().longValue();
			maxHouseholdID = person.getHouseholdId().longValue();
			s = in.readLine();
			while(s != null && !s.equals("")) {
				person = createPerson(s);
				if(person.getPid().longValue() > maxPID) {
					maxPID = person.getPid().longValue();
				}
				if(person.getHouseholdId().longValue() < maxHouseholdID) {
					s_logger.info("household id decrease");
					System.exit(1);
				}
				if(person.getHouseholdId().longValue() > maxHouseholdID) {
					maxHouseholdID = person.getHouseholdId().longValue();
				}
				if(person.getHouseholdId().longValue() != householdid) {
					createHousehold(householdmembers);
					householdmembers.clear();
					householdmembers.add(person);
					householdid = person.getHouseholdId().longValue();
				} else {
					householdmembers.add(person);
				}
				
				if(location.equals(person.getWardLocation())) {
					personsByLocation.add(person);
				} else {
					// serialise perons by location
					s_logger.info("writing data from location: " + location + " " + personsByLocation.size());
					ObjectOutput output = null;
				    try{
				      //use buffering
				      OutputStream file = new FileOutputStream(new File("populationdata", "persons_" + location + ".ser"));
				      OutputStream buffer = new BufferedOutputStream(file);
				      output = new ObjectOutputStream(buffer);
				      List addedList = new ArrayList();
				      for(int k=0; k<personsByLocation.size(); k++) {
				    	  Person tempPerson = (Person) personsByLocation.get(k);
				    	  if(tempPerson.getHouseholdSize() != null) {
				    		  addedList.add(tempPerson);
				    	  }
				      }
				      output.writeObject(addedList);
				      totalNum += addedList.size();
				    }
				    catch(IOException ex){
				    	s_logger.error("Cannot perform output.", ex);
				    }
				    finally{
				      try {
				        if (output != null) {
				          //flush and close "output" and its underlying streams
				          output.close();
				        }
				      }
				      catch (IOException ex ){
				    	  s_logger.error("Cannot close output stream.", ex);
				      }
				    }
				    
					personsByLocation.clear();
					personsByLocation.add(person);
					location = person.getWardLocation();
				}
				s = in.readLine();
			}
			
			if(personsByLocation.size() != 0) {
				// serialise perons by location
				createHousehold(householdmembers);
				s_logger.info("writing data from location: " + location + " " + personsByLocation.size());
				ObjectOutput output = null;
			    try{
			      //use buffering
			      OutputStream file = new FileOutputStream(new File("populationdata", "persons_" + location + ".ser"));
			      OutputStream buffer = new BufferedOutputStream(file);
			      output = new ObjectOutputStream(buffer);
			      List addedList = new ArrayList();
			      for(int k=0; k<personsByLocation.size(); k++) {
			    	  Person tempPerson = (Person) personsByLocation.get(k);
			    	  if(tempPerson.getHouseholdSize() != null) {
			    		  addedList.add(tempPerson);
			    	  }
			      }
			      output.writeObject(addedList);
			      totalNum += addedList.size();
			    }
			    catch(IOException ex){
			    	s_logger.error("Cannot perform output.", ex);
			    }
			    finally{
			      try {
			        if (output != null) {
			          //flush and close "output" and its underlying streams
			          output.close();
			        }
			      }
			      catch (IOException ex ){
			    	  s_logger.error("Cannot close output stream.", ex);
			      }
			    }
			    personsByLocation.clear();
			}
			
			if(householdmembers.size() != 0) {
			    createHousehold(householdmembers);
				householdmembers.clear();
			}
			in.close();
			
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		s_logger.info("total number people from data sheet: " + totalNum);
	}
	
	private static void createHousehold(List householdmembers) {
		// remove duplicate data
		List temp = new ArrayList();
		List members = new ArrayList();
		Person hrp = null;
		for(int i=0; i<householdmembers.size(); i++) {
			Person member = (Person) householdmembers.get(i);
			Long dataid = member.getDataId();
			if(!temp.contains(dataid)) {
				temp.add(dataid);
				members.add(member);
			} else {
				s_logger.info("dataid is duplicated " + dataid);
				recordDataError("", "", "", "", "", "dataid is duplicate: " + dataid);
				s_duplicate++;
			}
			if(member.getHrpStatus().equals("Y") && hrp == null) {
				hrp = member;
			}
		}
		
		if(hrp == null) {
			Person person = (Person) members.get(0);
			s_logger.error("No HRP: " + person.getPid());
			System.exit(1);
		}
		
		for(int i=0; i<members.size(); i++) {
			Person member = (Person) members.get(i);
			if(!member.getPid().equals(hrp.getPid())) {
				member.setHrpStatus("N");
			}
		}
		
		if(CHECK) {
			boolean hasHRP = false;
			int numOfHRP = 0;
			for(int i=0; i<members.size(); i++) {
				Person member = (Person) members.get(i);
				if(member.getHrpStatus().equals("Y")) {
					hasHRP = true;
					numOfHRP++;
				}
			}
			if(!hasHRP) {
				String message = "Warning: there is no HRP in the household";
				Person member = (Person) members.get(0);
				recordDataError(String.valueOf(member.getPid().longValue()), member.getWardLocation(), "", "", "", message);
			}
			if(numOfHRP != 1) {
				String message = "Warning: number of HRP in the household is incorrect: " + numOfHRP;
				Person member = (Person) members.get(0);
				StringBuffer buffer = new StringBuffer();
				for(int i=0; i<members.size(); i++) {
					member = (Person) members.get(i);
					buffer.append(member.getPid());
					buffer.append(" ");
				}
				recordDataError(buffer.toString(), member.getWardLocation(), "", "", "", message);
			}
		}
		
		// search spouse
		Person spouse = null;
		if(hrp.getMaritalStatus().equals("Y")) {
			spouse = findSpouse(members, hrp);
		}
		
		// Family Role
		for(int i=0; i<members.size(); i++) {
			Person member = (Person) members.get(i);
			member.setComments("Created in ward " + member.getWardLocation());
			if(member.getHrpStatus().equals("Y")) {
				member.setFamilyRole(ApplicationConstants.HRP_ROLE);
			} else if (spouse != null && spouse.getPid().equals(member.getPid())) {
				member.setFamilyRole(ApplicationConstants.SPOUSE_DEPENDENT_ROLE);
			} else if(member.getAge().intValue() <= ApplicationConstants.CHILD_AGE) {
				member.setFamilyRole(ApplicationConstants.CHILD_DEPENDENT_ROLE);
			} else if(member.getAge().intValue() >= ApplicationConstants.ELDERLY_AGE) {
				member.setFamilyRole(ApplicationConstants.ELDERLY_DEPENDENT_ROLE);
			} else {
				member.setFamilyRole(ApplicationConstants.ADULT_DEPENDENT_ROLE);
			}
		}
		
		int numberOfChildDependent = 0;
		int numberOfElderly = 0;
		for(int i=0; i<members.size(); i++) {
			Person member = (Person) members.get(i);
			if(member.getFamilyRole().equals(ApplicationConstants.CHILD_DEPENDENT_ROLE)) {
				numberOfChildDependent++;
			}
			if(member.getAge().intValue() >= ApplicationConstants.ELDERLY_AGE) {
				numberOfElderly++;
			}
		}
		
		String hasChildDependent = "N";
		if(numberOfChildDependent > 0) {
			hasChildDependent = "Y";
		}
		
		int householdsize = members.size();
		for(int i=0; i<members.size(); i++) {
			Person member = (Person) members.get(i);
			member.setHasChildDependent(hasChildDependent);
			member.setNumberElderly(new Integer(numberOfElderly));
			member.setHouseholdSize(new Integer(householdsize));
			// member.setHouseholdId(hrp.getPid());  // set household id as HRP pid
		}
	}
	
	private static Person findSpouse(List members, Person hrp) {
		if(members == null || hrp == null) {
			s_logger.error("Wrong data in finding spouse");
			System.exit(1);
		}
		Person spouse = null;
		for(int i=0; i<members.size(); i++) {
			Person member = (Person) members.get(i);
			int ageGap = Math.abs(member.getAge().intValue() - hrp.getAge().intValue());
			if(member.getPid().equals(hrp.getPid())) {
				continue;
			} else {
				if(member.getMaritalStatus().equals("Y") && !member.getGender().equals(hrp.getGender())
						&& (ageGap <= 10)) {
					spouse = member;
					break;
				}
			}
		}
		return spouse;
	}
	
	private static Person createPerson(String s) {
		Person person = new Person();
		StringBuffer buffer = new StringBuffer();
		
		String str = reorganise(s);
		
		StringTokenizer st = new StringTokenizer(str, ",");
		
		String pid = st.nextToken();
		person.setPid(new Long(pid));
		buffer.append("PID,");
		
		String householdId = st.nextToken();
		person.setHouseholdId(new Long(householdId));
		buffer.append("HOUSEHOLD_ID,");
		
		String ward = st.nextToken();
		person.setWardLocation(ward);
		person.setOutputArea(ward);
		person.setLocation(ward);
		
		String hhid = st.nextToken(); // not used
		String pnum = st.nextToken(); //not used
		
		String id = st.nextToken(); // used to remove the duplicate data
		person.setDataId(new Long(id));
		
		st.nextToken(); // not used: String acctype= 
		
		String age = st.nextToken();
		int ageInt = new Integer(age).intValue();
		if(ageInt >= 0) {
			person.setAge(new Integer(age));
			person.setBirthYear(getBirthYear(new Integer(age)));
		} else {
			String message = "Warning for age value: " + age;
			recordDataError(pid, ward, hhid, pnum, id, message);
		}
		
		st.nextToken(); // not used: String bathwc=
		st.nextToken();  // not used: String carsh= 
		st.nextToken(); // not used: String cenheat=
		st.nextToken(); // not used: String cobirt= 
		st.nextToken(); // not used: String density = 
		st.nextToken(); // not used: String distmov= 
		st.nextToken(); // not used: String distwrk= 
		st.nextToken(); // not used: String econach= 
		st.nextToken(); // not used: String edisdono= 
		st.nextToken(); // not used: String ethew= 
		st.nextToken(); // not used: String everwork= 
		st.nextToken(); // not used: String famnum= 
		st.nextToken(); // not used: String famtyp= 
		st.nextToken(); // not used: String frp= 
		st.nextToken(); // not used: String genind= 
		
		String health= st.nextToken();
		if(health.equals("1") || health.equals("2") || health.equals("3")) {
			person.setHealthStatus(new Integer(health));
		} else {
			String message = "Warning for health value: " + health;
			recordDataError(pid, ward, hhid, pnum, id, message);
			health = getHealthValue();
			// String message = "Warning for health value: " + health;
			// recordDataError(pid, ward, hhid, pnum, id, message);
			person.setHealthStatus(new Integer(health));
		}
		
		st.nextToken(); // not used: String hedind= 
		st.nextToken(); // not used: String hedisdon= 
		st.nextToken(); // not used: String hempind= 
		st.nextToken(); // not used: String hhlthind= 
		st.nextToken(); // not used: String hhsgind= 
		st.nextToken(); // not used: String hmigind= 
		st.nextToken(); // not used: String hnresidn= 
		st.nextToken(); // not used: String hourspw=
		
		String hrp= st.nextToken();
		if(hrp.equals("1")) {
			person.setHrpStatus("Y");
		} else {
			person.setHrpStatus("N");
		}
		
		String hrsocgrd= st.nextToken(); // socila class: -9, 1,2,3,4,5
		person.setSocialClass(hrsocgrd);
		
		st.nextToken(); // not used: String indstry= 
		st.nextToken(); // not used: String isco= 
		st.nextToken(); // not used: String lastwork= 
		st.nextToken(); // not used: String llti= 
		st.nextToken(); // not used: String lowflor= 
		
		String marstah= st.nextToken();
		if(marstah.equals("2")) {
			person.setMaritalStatus("Y");
		} else if(marstah.equals("1") || marstah.equals("3") || marstah.equals("4") || marstah.equals("5")) {
			person.setMaritalStatus("N");
		} else {
			String message = "Warning for marstah value: " + marstah;
			recordDataError(pid, ward, hhid, pnum, id, message);
		}
		
		st.nextToken();  // not used: String migind= 
		st.nextToken(); // not used: String nssec= 
		st.nextToken(); // not used: String oncperim= 
		st.nextToken(); // not used: String popbase= 
		st.nextToken(); // not used: String profqual= 
		st.nextToken(); // not used: String provcare= 
		st.nextToken(); // not used: String qualvewn= 
		st.nextToken(); // not used: String relgew= 
		st.nextToken(); // not used: String reltohr= 
		st.nextToken(); // not used: String roomreq= 
		st.nextToken(); // not used: String roomsnmh= 
		st.nextToken(); // not used: String selcont= 
		
		String sex= st.nextToken();
		if(sex.equals("1")) {
			person.setGender("M");
		} else if(sex.equals("2")) {
			person.setGender("F");
		} else {
			String message = "Warning for sex value: " + sex;
			recordDataError(pid, ward, hhid, pnum, id, message);
		}
		
		st.nextToken(); // not used: String socmin= 
		st.nextToken(); // not used: String stahukh= 
		st.nextToken(); // not used: String stapuk= 
		
		String student= st.nextToken();
		person.setStudent(student);
		
		st.nextToken(); // not used: String supervsr= 
		st.nextToken(); // not used: String tenureh= 
		st.nextToken(); // not used: String termtime= 
		st.nextToken(); // not used: String tranwrk= 
		st.nextToken(); // not used: String workforc= 
		st.nextToken(); // not used: String wrkplce= 
		
		person.setInFormalCare("N");
		person.setCareerStatus("");
		person.setWithLongTermIllness("N");
		person.setDeathStatus("N");
		// person.setFitness("");
		//person.setComments("");
		
		if(System.getProperty("AdjustAge").equalsIgnoreCase("Y") && person.getAge() != null) {
			int newAge = AgeAdjuster.getNewAge(ward, age, person.getGender());
			person.setAge(new Integer(newAge));
			ageInt = person.getAge().intValue();
		}
		
		if(person.getStudent().equals("1")) {
			studentsNum++;
		}
		
		if(person.getStudent().equals("1") && ageInt == 17) {
			students_17.add(person);
			students17Num++;
		}
		if(person.getStudent().equals("1") && ageInt == 18) {
			students_18.add(person);
			students18Num++;
		}
		if(person.getStudent().equals("1") && ageInt == 19) {
			students_19.add(person);
			students19Num++;
		}
		
		if(person.getStudent().equals("1") && ageInt == 20) {
			students_20.add(person);
			students20Num++;
		}
		if(person.getStudent().equals("1") && ageInt == 21) {
			students_21.add(person);
			students21Num++;
		}
		if(person.getStudent().equals("1") && ageInt == 22) {
			students_22.add(person);
			students22Num++;
		}
		if(person.getStudent().equals("1") && ageInt == 23) {
			students_23.add(person);
			students23Num++;
		}
		if(person.getStudent().equals("1") && ageInt >= 24 && ageInt <= 29) {
			students_24Over.add(person);
			studentsOver24Num++;
		}
		
		if(person.getStudent().equals("1") && ageInt >= ApplicationConstants.STUDENT_AGE_MIN 
				&& ageInt <= (ApplicationConstants.STUDENT_AGE_MAX)) {
			if(ageInt == 17) {
				person.setStudentType(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE);
				person.setYearInUniversity("1");
				person.setYearEnteringUnversity("2000");
				person.setYearLeavingUnversity("");
				students_under.add(person);
			}
			if(ageInt == 18) {
				person.setStudentType(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE);
				person.setYearInUniversity("2");
				person.setYearEnteringUnversity("1999");
				person.setYearLeavingUnversity("");
				students_under.add(person);
			}
			if(ageInt == 19) {
				person.setStudentType(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE);
				person.setYearInUniversity("3");
				person.setYearEnteringUnversity("1998");
				person.setYearLeavingUnversity("");
				students_under.add(person);
			}
			if(ageInt >= 20 && ageInt <= 22) {
				person.setStudentType(ApplicationConstants.STUDENT_TYPE_MSC);
				person.setYearInUniversity("1");
				person.setYearEnteringUnversity("2000");
				person.setYearLeavingUnversity("");
				students_msc.add(person);
			}
			if(ageInt >=  23 && ageInt <= 29 && isPhDStd()) {
				person.setStudentType(ApplicationConstants.STUDENT_TYPE_PHD);
				person.setYearInUniversity(getPhDStdYear());
				person.setYearLeavingUnversity("");
				if(person.getYearInUniversity().equals("1")) {
					person.setYearEnteringUnversity("2000");
				}
				if(person.getYearInUniversity().equals("2")) {
					person.setYearEnteringUnversity("1999");
				}
				if(person.getYearInUniversity().equals("3")) {
					person.setYearEnteringUnversity("1998");
				}
				students_phd.add(person);
			}
			// numOfStudent++;
			// s_logger.info("Student Age: " + person.getAge() + " Student type: " + person.getStudentType() 
			//		+ " year: " + person.getYearInUniversity());
		}
		
		// create srudent samples
		if(student.equals("1") && ageInt >= ApplicationConstants.STUDENT_AGE_MIN 
				&& ageInt <= ApplicationConstants.STUDENT_AGE_MAX) {
			// students.add(person);
		}
		
		return person;
	}
	
	private static String getBirthYear(Integer an_age) {
		Calendar cal = Calendar.getInstance();
		Integer year = new Integer(cal.get(Calendar.YEAR) - an_age.intValue());
		return year.toString();
	}
	
	private static String reorganise(String s) {
		StringTokenizer st = new StringTokenizer(s, ",");
		String pid = st.nextToken();	
		String householdId = st.nextToken();		
		String ward = st.nextToken();	
		String hhid = st.nextToken(); // not used
		String pnum = st.nextToken(); //not used
		// long pnumValue = Long.parseLong(pnum);
		if(pnum.length() >= 3) {
			StringBuffer buffer = new StringBuffer(pnum);
			char c = buffer.charAt(0);
			String str = buffer.substring(1);
			StringBuffer result = new StringBuffer();
			result.append(pid);
			result.append(",");
			result.append(householdId);
			result.append(",");
			result.append(ward);
			result.append(",");
			result.append(hhid);
			result.append(",");
			result.append(c);
			result.append(",");
			result.append(str);
			while(st.hasMoreTokens()) {
				result.append(",");
				result.append(st.nextToken());
			}
			return result.toString();
		} else {
			return s;
		}
	}
	
	private static void recordDataError(String newpid, String ward, String hhid, String pnum, String id, String message) {
		StringBuffer buffer= new StringBuffer();
		buffer.append(newpid);
		buffer.append(",");
		buffer.append(ward);
		buffer.append(",");
		buffer.append(hhid);
		buffer.append(",");
		buffer.append(pnum);
		buffer.append(",");
		buffer.append(id);
		buffer.append(",");
		buffer.append(message);
		s_out.println(buffer.toString());
		s_out.flush();
	}
	
	private static String getHealthValue() {
		if(s_healthNumIndex >= 100) {
			resetHealthNums();
		}
		
		int temp = ((Integer) s_healthNumers.get(s_healthNumIndex)).intValue();
		if(temp < 9) {
			s_healthNumIndex++;
			return "3";
		} else if(temp < 31) {
			s_healthNumIndex++;
			return "2";
		} else {
			s_healthNumIndex++;
			return "1";
		}
	}
	
	private static void resetHealthNums() {
		for(int i=0; i<=99; i++) {
			s_healthNumers.add(new Integer(i));
		}
		s_healthNumIndex = 0;
	}
	
	private static void resetPhdStdYearDistribution() {
		phdStdYearIndex = 0;
		List temp = new ArrayList(300);
		for(int i=0; i<=99; i++) {
			temp.add(new String("1"));
		}
		for(int i=100; i<=199; i++) {
			temp.add(new String("2"));
		}
		for(int i=200; i<=299; i++) {
			temp.add(new String("3"));
		}
		for(int i=0; i<300; i++) {
			int a = (int)Math.round(Math.random() * temp.size() -1);
			if(a == -1 && temp.size() == 1) {
				a = 0;
			}
			phdStdYearList.add(temp.get(Math.abs(a)));
		    temp.remove(Math.abs(a));
		}
	}
	
	private static String getPhDStdYear() {
		String year = (String) phdStdYearList.get(phdStdYearIndex);
		phdStdYearIndex++;
		if(phdStdYearIndex >= 300) {
			resetPhdStdYearDistribution();
		}
		return year;
	}
	
	private static void resetPhdStdDistribution() {
		phdStdIndex = 0;
		List temp = new ArrayList(5928);
		for(int i=0; i<=5928; i++) {
			temp.add(new Integer(i));
		}
		for(int i=0; i<5928; i++) {
			int a = (int)Math.round(Math.random() * temp.size() -1);
			if(a == -1 && temp.size() == 1) {
				a = 0;
			}
			phdStdList.add(temp.get(Math.abs(a)));
		    temp.remove(Math.abs(a));
		}
	}
	
	private static boolean isPhDStd() {
		Integer value = (Integer) phdStdList.get(phdStdIndex);
		phdStdIndex++;
		if(phdStdIndex >= 5928) {
			resetPhdStdDistribution();
		}
		if(value.intValue() <960) {
			return true;
		} else {
			return false;
		}
	}
	
	private static long getNextPID() {
		long nextID = maxPID + 1L;
		maxPID++;
		return nextID;
	}
	
	private static long getNextHouseholdID() {
		long nextId = maxHouseholdID + 1L;
		maxHouseholdID++;
		return nextId;
	}
	
	private static void loadLocations() {
		List locations = new ArrayList();
		for(int i=1; i<=33; i++) {
			Location location = new Location();
			String str = String.valueOf(i);
			location.setAreaLocation(str);
			location.setOutputArea(str);
			location.setWardLocation(str);
			locations.add(location);
		}
		
		// serialise locations object
		ObjectOutput output = null;
	    try{
	      //use buffering
	      OutputStream file = new FileOutputStream(new File("populationdata", "locations.ser"));
	      OutputStream buffer = new BufferedOutputStream(file);
	      output = new ObjectOutputStream(buffer);
	      output.writeObject(locations);
	    }
	    catch(IOException ex){
	    	s_logger.error("Cannot perform output.", ex);
	    }
	    finally{
	      try {
	        if (output != null) {
	          //flush and close "output" and its underlying streams
	          output.close();
	        }
	      }
	      catch (IOException ex ){
	    	  s_logger.error("Cannot close output stream.", ex);
	      }
	    }
	}
	
	/*
	private static List processPhDStudents(List students) {
		int count = NUMER_OF_PHD_STUDENTS;
		List temp1 = new ArrayList();
		for(int i=0; i<students.size(); i++) {
			temp1.add(new Integer(i));
		}
		List temp2 = new ArrayList();
		for(int i=0; i<count; i++) {
			int a = (int)Math.round(Math.random() * temp1.size() -1);
			if(a == -1 && temp1.size() == 1) {
				a = 0;
			}
			temp2.add(temp1.get(Math.abs(a)));
			temp1.remove(Math.abs(a));
		}
		temp1.clear();
		for(int i=0; i<temp2.size(); i++) {
			Integer index = (Integer) temp2.get(i);
			s_logger.info("index " + index);
			temp1.add(students.get(index.intValue()));
		}
		return temp1;
	}*/
	
	private static void loadSimulationControls() {
		Simulationcontrol control = new Simulationcontrol();
		control.setSardataInputComplete("Y");
		control.setSimulationPaused("N");
		control.setSimulationStarted("N");
		control.setSimulationStopped("N");
		control.setNextPID(new Long(maxPID++));
		control.setNextHouseholdID(new Long(maxHouseholdID++));
		control.setTotalNumberOfPeople(totalNum);
		s_logger.info("total number people after creating new students: " + totalNum);
		
		// serialise Simulationcontrol object
		ObjectOutput output = null;
	    try{
	      //use buffering
	      OutputStream file = new FileOutputStream(new File("populationdata", "simulationcontrol.ser"));
	      OutputStream buffer = new BufferedOutputStream(file);
	      output = new ObjectOutputStream(buffer);
	      output.writeObject(control);
	    }
	    catch(IOException ex){
	    	s_logger.error("Cannot perform output.", ex);
	    }
	    finally{
	      try {
	        if (output != null) {
	          //flush and close "output" and its underlying streams
	          output.close();
	        }
	      }
	      catch (IOException ex ){
	    	  s_logger.error("Cannot close output stream.", ex);
	      }
	    }
	}
}
