package uk.ac.leeds.sog.moses.populationmodel.migration;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Location;
import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.HouseholdImpl;
import uk.ac.leeds.sog.moses.populationmodel.PersonAgent;
import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.populationmodel.probability.Determinator;
import uk.ac.leeds.sog.moses.populationmodel.probability.RandomProbabilityDeterminator;
import uk.ac.leeds.sog.moses.populationmodel.student.StudentSimulationHelper;
import uk.ac.leeds.sog.moses.populationmodel.tools.SimulationRecorder;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class Migration {
	private static Migration s_instance = null;
	private MigrationDataHelper i_dataHelper = null;
	private Determinator i_migrationDeterminator;
	private Determinator i_householdDeterminator;
	private MigrationLocationDeterminator i_locationDeterminator = null;
	private String i_simulationYear;
	private String i_newLocation;
	private String i_oldLocation;
	
	private static Logger s_logger = MosesLogger.getLogger(Migration.class);
	
	private boolean i_studentSimulationEnabled = false;
	
	private static List stdStayingList = new ArrayList(10000);
	private static int stdStayingListIndex = 0;
	
	private Migration(PopulationDataHelper dataHelper) {
		s_logger.info("Migration - constructing migration module");
		i_dataHelper = new MigrationDataHelper(dataHelper);
		i_migrationDeterminator = new RandomProbabilityDeterminator(0.1485, 10000, true);
		i_householdDeterminator = new RandomProbabilityDeterminator(0.4452, 10000, true);
		i_locationDeterminator =  new MigrationLocationDeterminator();
		if(System.getProperty("StudentSimulation") != null 
				&& System.getProperty("StudentSimulation").equalsIgnoreCase("true")) {
			i_studentSimulationEnabled = true;
		}
		resetStdStayingList();
	}

	public static Migration getInstance(PopulationDataHelper dataHelper) {
		if(s_instance == null) {
			s_instance = new Migration(dataHelper);
		}
		return s_instance;
	}
	
	public void migrate(PersonAgent a_personAgent, HouseholdImpl household) {
		// s_logger.info("migrate");
		i_simulationYear = i_dataHelper.getSimulationYearString();
		Person person = a_personAgent.getPerson();
		i_oldLocation = new String(person.getLocation());
		int oldHouseholdSize = household.getHouseholdSize();
		String stdType = person.getStudentType();
		
		boolean hasStudent = household.hasStudent();
		
		// person must not be dead
		if(person.getDeathStatus().equals("Y")) {
			s_logger.info("person must not be already dead");
			System.exit(1);
		}
		
		// a person must not be already in formal care
		if(person.getInFormalCare().equals("Y")) {
			// s_logger.info("person must not be already in formal care");
			return;
		}
		
		// student migration
		// leaving student
		if(stdType != null && stdType.indexOf("LeavingStudent") != -1) {
			if(stayingInLeeds()) {
				// s_logger.info("student staying");
			} else {
				person.setStudentType(stdType.replaceAll("LeavingStudent", "StudentLeft"));
				household.moveStudentOut(person);
				StudentSimulationHelper.addLeavingStudents(a_personAgent);
				// s_logger.info("student leaving");
				return; 
			}
		}
		
		if(i_studentSimulationEnabled && stdType != null && (stdType.equals(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE) 
				                           || stdType.equals(ApplicationConstants.STUDENT_TYPE_MSC)
				                           || stdType.equals(ApplicationConstants.STUDENT_TYPE_PHD))) {
			if(stdType.equals(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE)) {
				if(person.getYearInUniversity().equals("1")) {
					String newLocation = StudentSimulationHelper.getUAccommodationLocation();
					if(newLocation.equals(person.getWardLocation())) {
						// same location
						return;
					}
					person.setHasMigrated("Y");
					person.setOutputArea(newLocation);
					person.setWardLocation(newLocation);
					person.setLocation(newLocation);
					household.moveMigratedPerson(person);
					
				} else if(person.getYearInUniversity().equals("2") || person.getYearInUniversity().equals("3")) {
					String newLocation = StudentSimulationHelper.getPAccommodationLocation();
					if(newLocation.equals(person.getWardLocation())) {
						// same location
						return;
					}
					person.setHasMigrated("Y");
					person.setOutputArea(newLocation);
					person.setWardLocation(newLocation);
					person.setLocation(newLocation);
					household.moveMigratedPerson(person);
				} else {
					s_logger.info("student year incorrect: " + person.getYearInUniversity());
					System.exit(1);
				}
			}
			if(stdType.equals(ApplicationConstants.STUDENT_TYPE_MSC)) {
				String newLocation = StudentSimulationHelper.getPAccommodationLocation();
				if(newLocation.equals(person.getWardLocation())) {
					// same location
					return;
				}
				person.setHasMigrated("Y");
				person.setOutputArea(newLocation);
				person.setWardLocation(newLocation);
				person.setLocation(newLocation);
				household.moveMigratedPerson(person);
			}
			if(stdType.equals(ApplicationConstants.STUDENT_TYPE_PHD)) {
				String newLocation = StudentSimulationHelper.getPAccommodationLocation();
				if(newLocation.equals(person.getWardLocation())) {
					// same location
					return;
				}
				person.setHasMigrated("Y");
				person.setOutputArea(newLocation);
				person.setWardLocation(newLocation);
				person.setLocation(newLocation);
				household.moveMigratedPerson(person);
			}
			if(oldHouseholdSize > 1) {
				i_dataHelper.updateHouseholdStatus(household, "student migration");
			}
			return;
		}
		
		if(hasStudent && i_studentSimulationEnabled) {
			return;
		}
		
		if(!i_migrationDeterminator.determine(person)) {
			// not migrate
			return;
		}
		
		if(i_householdDeterminator.determine(person)) {
			processHouseholdMove(person, household);
			SimulationRecorder.migration(person, i_oldLocation, i_newLocation, i_simulationYear, "Household");
		} else {
			if(household.getHouseholdSize() == 1) {
				processHouseholdMove(person, household);
				SimulationRecorder.migration(person, i_oldLocation, i_newLocation, i_simulationYear, "Household");
			} else {
				processSingleMove(person, household);
			}
		}
	}
	
	private void processSingleMove(Person a_person, HouseholdImpl household) {
		// s_logger.info("processSingleMove");
		if(a_person.getHrpStatus().equals("Y")) {
			processSingleHRPMove(a_person, household);
			SimulationRecorder.migration(a_person, i_oldLocation, i_newLocation, i_simulationYear, "Single HRP");
		} else {
			if(a_person.getAge().intValue() <= ApplicationConstants.CHILD_AGE) {
				// s_logger.info("A child cannot move alone");
				return;
			}
			processSingleNonHRPMove(a_person, household);
			SimulationRecorder.migration(a_person, i_oldLocation, i_newLocation, i_simulationYear, "Single Non-HRP");
		}
	}
	
	private void processSingleHRPMove(Person a_person, HouseholdImpl household) {
		// s_logger.info("processSingleHRPMove");
		if(household.getHouseholdSize() == 1) {
			processHouseholdMove(a_person, household);
		} else if(household.getHouseholdSize() > 1) {
			// s_logger.info("household size: " + household.getHouseholdSize());
			String newLocation = i_locationDeterminator.getDetination(a_person);
			i_newLocation = newLocation;
			if(newLocation.equals(a_person.getWardLocation())) {
				// stay in same location
				// s_logger.info("stay in same location " + a_person.getWardLocation());
				return;
			} else {
				// s_logger.info("move from location " + a_person.getWardLocation() + " to " + i_newLocation);
			}
			a_person.setHasMigrated("Y");
			a_person.setOutputArea(newLocation);
			a_person.setWardLocation(newLocation);
			a_person.setLocation(newLocation);
			a_person.setHouseholdSize(new Integer(1));
			a_person.setComment("HRP migration");
			a_person.setHouseholdId(i_dataHelper.getNextHouseholdId());
			household.moveMigratedPerson(a_person);
			
			Person newHRP = i_dataHelper.findNewHRP(household.getHouseholdMembers());
			/*if(newHRP == null) {
				int debug = 1;
				debug++;
			}*/
			newHRP.setHrpStatus("Y");
			i_dataHelper.updateHouseholdStatus(household, newHRP, "updated in HRP Migration");
			
			HouseholdImpl newHousehold = new HouseholdImpl();
			Location location = new Location();
			location.setAreaLocation(newLocation);
			location.setWardLocation(newLocation);
			location.setOutputArea(newLocation);
			newHousehold.addMember(new PersonAgent(a_person));
			newHousehold.setLocation(location);
			i_dataHelper.updateHouseholdStatus(newHousehold, a_person, "updated in HRP Migration");
		} else {
			s_logger.info("household size is not correct. Simulation stops in migration");
			System.exit(1);
		}
	}
	
	private void processSingleNonHRPMove(Person a_person, HouseholdImpl household) {
		// s_logger.info("processSingleNonHRPMove");
		String newLocation = i_locationDeterminator.getDetination(a_person);
		i_newLocation = newLocation;
		if(newLocation.equals(a_person.getWardLocation())) {
			// stay in same location
			// s_logger.info("stay in same location " + a_person.getWardLocation());
			return;
		} else {
			// s_logger.info("move from location " + a_person.getWardLocation() + " to " + i_newLocation);
		}
		household.moveMigratedPerson(a_person);
		a_person.setHasMigrated("Y");
		a_person.setHrpStatus("Y");
		a_person.setFamilyRole(ApplicationConstants.HRP_ROLE);
		a_person.setOutputArea(newLocation);
		a_person.setWardLocation(newLocation);
		a_person.setLocation(newLocation);
		a_person.setHouseholdId(i_dataHelper.getNextHouseholdId());
		a_person.setHouseholdSize(new Integer(1));
		a_person.setComment("Non-HRP migration");
		
		i_dataHelper.updateHouseholdStatus(household, null, "updated in Non-HRP Migration");
		
		HouseholdImpl newHousehold = new HouseholdImpl();
		Location location = new Location();
		location.setAreaLocation(newLocation);
		location.setWardLocation(newLocation);
		location.setOutputArea(newLocation);
		newHousehold.addMember(new PersonAgent(a_person));
		newHousehold.setLocation(location);
		newHousehold.setHouseholdId(a_person.getHouseholdId());
		i_dataHelper.updateHouseholdStatus(newHousehold, a_person, "updated in Non-HRP Migration");
	}
	
	private void processHouseholdMove(Person a_person, HouseholdImpl household) {
		// s_logger.info("processHouseholdMove");
		String newLocation = i_locationDeterminator.getDetination(a_person);
		i_newLocation = newLocation;
		if(newLocation.equals(a_person.getWardLocation())) {
			// stay in same location
			// s_logger.info("stay in same location " + a_person.getWardLocation());
			return;
		} else {
			// s_logger.info("move from location " + a_person.getWardLocation() + " to " + i_newLocation);
		}
		List householdMembers = household.getHouseholdMembersWithInFormalCare();
		for(int i=0; i<householdMembers.size(); i++) {
			Person member = ((PersonAgent) householdMembers.get(i)).getPerson();
			member.setHasMigrated("Y");
			member.setOutputArea(newLocation);
			member.setWardLocation(newLocation);
			member.setLocation(newLocation);
			member.setComment("Household Migration");
		}
		household.migrateAllPeople();
	}
	
	private void resetStdStayingList() {
		stdStayingListIndex = 0;
		List temp = new ArrayList(10000);
		for(int i=0; i<=10000; i++) {
			temp.add(new Integer(i));
		}
		for(int i=0; i<10000; i++) {
			int a = (int)Math.round(Math.random() * temp.size() -1);
			if(a == -1 && temp.size() == 1) {
				a = 0;
			}
			stdStayingList.add(temp.get(Math.abs(a)));
		    temp.remove(Math.abs(a));
		}
	}
	
	private boolean stayingInLeeds() {
		boolean res = false;
		Integer value = (Integer) stdStayingList.get(stdStayingListIndex);
		if(value.intValue() < 3000) {
			res = true;
		}
		stdStayingListIndex++;
		if(stdStayingListIndex >= 10000) {
			resetStdStayingList();
		}
		return res;
	}
}
