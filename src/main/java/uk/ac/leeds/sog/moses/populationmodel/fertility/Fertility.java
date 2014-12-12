package uk.ac.leeds.sog.moses.populationmodel.fertility;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.HouseholdImpl;
import uk.ac.leeds.sog.moses.populationmodel.PersonAgent;
import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.populationmodel.probability.Determinator;
import uk.ac.leeds.sog.moses.populationmodel.tools.SimulationRecorder;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class Fertility {
	private static Logger s_logger = MosesLogger.getLogger(Fertility.class);
	private static Fertility s_instance = null;
	
	private FertilityDataHelper i_dataHelper = null;
	private String i_simulationYear;
	private Determinator i_birthDeterminator = new FertilityDeterminator();
	private Determinator i_twinsDeterminator;
	private Determinator i_maleGenderDeterminator;
	private boolean i_studentSimulationEnabled = false;
	
	private Fertility(PopulationDataHelper dataHelper) {
		s_logger.info("Fertility - constructing fertility module");
		i_dataHelper = new FertilityDataHelper(dataHelper);
		i_simulationYear = i_dataHelper.getSimulationYearString();
		// i_birthDeterminator = new RandomProbabilityDeterminator(1, 100);
		i_birthDeterminator = new FertilityDeterminator();
		i_twinsDeterminator = new TwinFertilityDeterminator();
		i_maleGenderDeterminator = new MaleGenderDeterminator();
		if(System.getProperty("StudentSimulation") != null 
				&& System.getProperty("StudentSimulation").equalsIgnoreCase("true")) {
			i_studentSimulationEnabled = true;
		}
	}
	
	public static Fertility getInstance(PopulationDataHelper dataHelper) {
		if(s_instance == null) {
			s_instance = new Fertility(dataHelper);
		}
		return s_instance;
	}
	
	public void fertilise(PersonAgent a_personAgent, HouseholdImpl household) {
		i_simulationYear = i_dataHelper.getSimulationYearString();
		Person person = a_personAgent.getPerson();

		// a person must not be in formal care
		if(person.getInFormalCare().equals("Y")) {
			return;
		}
		
		// male does not fertilise
		if(person.getGender().equalsIgnoreCase("M")) {
			return;
		}
		
		// students do not participate fertility
		if(i_dataHelper.isStudent(person) && i_studentSimulationEnabled) {
			return;
		}
		
		// fertility age
		int age = person.getAge().intValue();
		if(age < ApplicationConstants.FERTILITY_MIN_AGE || age > ApplicationConstants.FERTILITY_MAX_AGE) {
			s_logger.debug("fertlise: not suitable age");
			return;
		}
		
		if(i_birthDeterminator.determine(person)) {
			if(i_twinsDeterminator.determine(person)) {
				// first baby
				String gender1 = null;
				if(i_maleGenderDeterminator.determine(person)) {
					gender1 = "M";
				} else {
					gender1 = "F";
				}
				Person baby1 = createNewbaby(person, gender1);
				baby1.setComment("create twin 1 in fertility");
				household.addNewBornMember(new PersonAgent(baby1));
				
				// second baby
				String gender2 = null;
				if(i_maleGenderDeterminator.determine(person)) {
					gender2 = "M";
				} else {
					gender2 = "F";
				}
				Person baby2 = createNewbaby(person, gender2);
				baby2.setComment("create twin 2 in fertility");
				household.addNewBornMember(new PersonAgent(baby2));
				
				// i_dataHelper.updateHouseholdStatus(household, null, "update status in twin fertility");
				
				SimulationRecorder.ferility(person, baby1, i_simulationYear, true);
				SimulationRecorder.ferility(person, baby2, i_simulationYear, true);
			} else {
				String gender = null;
				if(i_maleGenderDeterminator.determine(person)) {
					gender = "M";
				} else {
					gender = "F";
				}
				Person baby = createNewbaby(person, gender);
				baby.setComment("create baby in fertility");
				household.addNewBornMember(new PersonAgent(baby));
				
				// i_dataHelper.updateHouseholdStatus(household, null, "update status in fertility");
				
				SimulationRecorder.ferility(person, baby, i_simulationYear, false);
			}
		}
	}
	
	private Person createNewbaby(Person a_mother, String a_gender) {
		Person baby = new Person();
		baby.setPid(i_dataHelper.getNextPID());
		baby.setAge(new Integer(0));
		baby.setBirthYear(i_simulationYear);
		baby.setGender(a_gender);
		baby.setMaritalStatus("N");
		baby.setCareerStatus("N");
		baby.setSocialClass(a_mother.getSocialClass()); // assign the social class of the baby's mother to baby
		baby.setHealthStatus(a_mother.getHealthStatus());
		baby.setWithLongTermIllness("N");
		baby.setInFormalCare("N");
		baby.setDeathStatus("N");
		baby.setFamilyRole(ApplicationConstants.CHILD_DEPENDENT_ROLE);
		baby.setHasChildDependent("N");
		baby.setNumberElderly(new Integer(0));
		baby.setHrpStatus("N");
		baby.setHouseholdId(a_mother.getHouseholdId());
		baby.setHouseholdSize(a_mother.getHouseholdSize());
		baby.setWardLocation(a_mother.getWardLocation());
		baby.setOutputArea(a_mother.getOutputArea());
		baby.setLocation(a_mother.getLocation());
		baby.setHasMigrated("N");
		baby.setFitness(a_mother.getFitness());
		baby.setDataId(null);
		baby.setSarrecordId(null);
		baby.setHasAgentSimulated("Y");
		baby.setHasMigrated("Y");
		baby.setHasMicroSimulated("Y");
		baby.setStudent("2");
		return baby;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		s_logger.info("running");
	}

}
