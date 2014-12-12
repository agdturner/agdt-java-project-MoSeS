package uk.ac.leeds.sog.moses.populationmodel.migration.student;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.populationmodel.tools.StudentGenerator;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class StudentMigrationHelper {
	
	private static PopulationDataHelper populationDataHelper;
	private static StudentGenerator generator = new StudentGenerator();
	private static float probability = 0.02086073f; // 14926/715508
	private static Logger s_logger = MosesLogger.getLogger(StudentMigrationHelper.class);
	
	private static List students = new ArrayList();
	
	public static void initialise(PopulationDataHelper dataHelper) {
		s_logger.info("initialise StudentMigrationHelper");
		populationDataHelper = dataHelper;
	}
	
	public static void generateStudents() {
		s_logger.info("total number " + populationDataHelper.getTotalNumberOfPeople());
		s_logger.info("propability: " + probability);
		int number = Math.round(probability * populationDataHelper.getTotalNumberOfPeople());
		students.clear();
		students =  generator.getStudents(number);
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

}
