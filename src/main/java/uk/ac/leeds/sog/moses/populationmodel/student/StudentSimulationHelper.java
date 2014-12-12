package uk.ac.leeds.sog.moses.populationmodel.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.PersonAgent;
import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.populationmodel.tools.StudentGenerator;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class StudentSimulationHelper {
	
	private static PopulationDataHelper populationDataHelper;
	private static int i_simulationYear;
	private static StudentGenerator generator = new StudentGenerator();
	private static float probability = 0.03950655f; // 30033/760203
	private static Logger s_logger = MosesLogger.getLogger(StudentSimulationHelper.class);
	
	private static List students = new ArrayList();
	private static List leavingStudents = new ArrayList();
	
	private static List universityAccommodation = new ArrayList();
	private static int totalPlacesOfUniversityAccommodation = 0;
	private static List privateAccommodation = new ArrayList();
	private static int totalPlacesOfPrivateAccommodation = 0;
	
	private static List uAccomDistributionList;
	private static int uAccomDistributionListIndex = 0;
	
	private static List pAccomDistributionList;
	private static int pAccomDistributionListIndex = 0;
	
	private static boolean initialised = false;
	
	private static void readAccommodationPlaces() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("probability", "university_accommodation.csv")));
			String s = in.readLine();
			while(s !=null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				if(st.countTokens() != 3) {
					s_logger.error("number of data in each row must be 3: " + st.countTokens());
					System.exit(1);
				}
				String ward = st.nextToken();
				String name = st.nextToken();
				String num = st.nextToken();
				universityAccommodation.add(new Accommodation(ward, name, Integer.parseInt(num)));
				totalPlacesOfUniversityAccommodation +=  Integer.parseInt(num);
				s = in.readLine();
			}
			in.close();
			
			in = new BufferedReader(new FileReader(new File("probability", "private_accommodation.csv")));
			s = in.readLine();
			while(s !=null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				if(st.countTokens() != 3) {
					s_logger.error("number of data in each row must be 3: " + st.countTokens());
					System.exit(1);
				}
				String ward = st.nextToken();
				String name = st.nextToken();
				String num = st.nextToken();
				privateAccommodation.add(new Accommodation(ward, name, Integer.parseInt(num)));
				totalPlacesOfPrivateAccommodation +=  Integer.parseInt(num);
				s = in.readLine();
			}
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void resetUAccomDistributionList() {
		uAccomDistributionListIndex = 0;
		uAccomDistributionList = new ArrayList();
		List temp = new ArrayList();
		for(int i=0; i<universityAccommodation.size(); i++) {
			Accommodation accommo = (Accommodation) universityAccommodation.get(i);
			for(int j=0; j<accommo.getPlace(); j++) {
				temp.add(accommo.getLocation());
			}
		}
		for(int i=0; i<totalPlacesOfUniversityAccommodation; i++) {
			int a = (int)Math.round(Math.random() * temp.size() -1);
			if(a == -1 && temp.size() == 1) {
				a = 0;
			}
			uAccomDistributionList.add(temp.get(Math.abs(a)));
		    temp.remove(Math.abs(a));
		}
	}
	
	public static String getUAccommodationLocation() {
		if(uAccomDistributionListIndex >= totalPlacesOfUniversityAccommodation) {
			resetUAccomDistributionList();
		}
		String location =  (String) uAccomDistributionList.get(uAccomDistributionListIndex);
		uAccomDistributionListIndex++;
		return location;
	}
	
	public static void resetPAccomDistributionList() {
		pAccomDistributionListIndex = 0;
		pAccomDistributionList = new ArrayList();
		List temp = new ArrayList();
		for(int i=0; i<privateAccommodation.size(); i++) {
			Accommodation accommo = (Accommodation) privateAccommodation.get(i);
			for(int j=0; j<accommo.getPlace(); j++) {
				temp.add(accommo.getLocation());
			}
		}
		for(int i=0; i<totalPlacesOfPrivateAccommodation; i++) {
			int a = (int)Math.round(Math.random() * temp.size() -1);
			if(a == -1 && temp.size() == 1) {
				a = 0;
			}
			pAccomDistributionList.add(temp.get(Math.abs(a)));
		    temp.remove(Math.abs(a));
		}
	}
	
	public static String getPAccommodationLocation() {
		if(pAccomDistributionListIndex >= totalPlacesOfPrivateAccommodation) {
			resetPAccomDistributionList();
		}
		String location =  (String) pAccomDistributionList.get(pAccomDistributionListIndex);
		pAccomDistributionListIndex++;
		return location;
	}
	
	public static void initialise(PopulationDataHelper dataHelper) {
		s_logger.info("initialise StudentMigrationHelper");
		populationDataHelper = dataHelper;
		i_simulationYear = dataHelper.getSimulationYear();
		leavingStudents.clear();
		if(!initialised) {
			readAccommodationPlaces();
			resetUAccomDistributionList();
			resetPAccomDistributionList();
			initialised = true;
		}
	}
	
	public static void generateStudents() {
		s_logger.info("total number " + populationDataHelper.getTotalNumberOfPeople());
		s_logger.info("propability: " + probability);
		int number = Math.round(probability * populationDataHelper.getTotalNumberOfPeople());
		s_logger.info("students generated in " + i_simulationYear + " are " + number);
		students.clear();
		students =  generator.getStudents(number);
		int number_under1 = 0;
		int number_msc = 0;
		int number_phd1 = 0;
		for(int i=0; i<students.size(); i++) {
			Person student = (Person) students.get(i);
			if(student.getStudentType().equals(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE) &&
					student.getYearInUniversity().equals("0")) {
				number_under1++;
			}
			if(student.getStudentType().equals(ApplicationConstants.STUDENT_TYPE_MSC) &&
					student.getYearInUniversity().equals("0")) {
				number_msc++;
			}
			if(student.getStudentType().equals(ApplicationConstants.STUDENT_TYPE_PHD) &&
					student.getYearInUniversity().equals("0")) {
				number_phd1++;
			}
		}
		s_logger.info("Undergradaute1 generated: " + number_under1);
		s_logger.info("MSc generated: " + number_msc);
		s_logger.info("PhD1 generated: " + number_phd1);
	}
	
	public static List getStudents(String location) {
		List res = new ArrayList();
		int size = students.size();
		for(int i=0; i<size; i++) {
			Person student = (Person) students.get(i);
			if(student.getLocation().equals(location)) {
				convertStudent(student);
				res.add(student);
			}
		}
		return res;
	}
	
	private static void convertStudent(Person student) {
		student.setPid(populationDataHelper.getNextPID());
		student.setHrpStatus("Y");
		student.setFamilyRole(ApplicationConstants.HRP_ROLE);
		student.setHouseholdId(populationDataHelper.getNextHouseholdID());
		student.setHouseholdSize(new Integer(1));
		student.setHasChildDependent("N");
		student.setNumberElderly(new Integer(0));
		student.setComment("cloned in student migration");
		student.setHasAgentSimulated("N");
		student.setHasMigrated("N");
		student.setHasMicroSimulated("Y");
	}
	
	public static void addLeavingStudents(PersonAgent student) {
		leavingStudents.add(student);
	}
	
	public static List getLeavingStudents() {
		return leavingStudents;
	}
	
	static class Accommodation {
		private String location;
		private String locationName;
		int place;
		
		Accommodation(String loc, String name, int number) {
			location = loc;
			locationName = name;
			place = number;
		}
		
		public String getLocation() {
			return location;
		}
		
		public void setLocation(String location) {
			this.location = location;
		}
		
		public String getLocationName() {
			return locationName;
		}
		
		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}
		
		public int getPlace() {
			return place;
		}
		
		public void setPlace(int place) {
			this.place = place;
		}
		
	}
}
