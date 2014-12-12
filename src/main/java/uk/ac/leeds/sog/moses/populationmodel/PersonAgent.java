package uk.ac.leeds.sog.moses.populationmodel;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class PersonAgent {
	
	// attributes for person
	private Person i_person;
	
	private static Logger s_logger = MosesLogger.getLogger(PersonAgent.class);;
	
	public PersonAgent(Person a_person) {
		i_person = a_person;
	}
	
	public void stepMicroSimulation(HouseholdImpl household, AreaPopulationModel areaPopulationModel) {
		// s_logger.info("stepMicroSimulation");
		
		if(i_person.getHasMicroSimulated().equals("Y")) {
			// s_logger.info("PID has migrated: " + i_person.getPid());
			return;
		}
		// ageing
		if(System.getProperty("Ageing") != null && System.getProperty("Ageing").equalsIgnoreCase("true")) {
			areaPopulationModel.getSimulationModules().getAgingModule().age(this, household);
		}
		
		// fertility
		if(System.getProperty("Fertility") != null && System.getProperty("Fertility").equalsIgnoreCase("true")) {
			areaPopulationModel.getSimulationModules().getFertilityModule().fertilise(this, household);
		}
		
		// health change
		if(System.getProperty("HealthChange") != null && System.getProperty("HealthChange").equalsIgnoreCase("true")) {
			areaPopulationModel.getSimulationModules().getHealthChangeModule().change(this, household);
		}
		
		// mortality
		if(System.getProperty("Mortality") != null && System.getProperty("Mortality").equalsIgnoreCase("true")) {
			areaPopulationModel.getSimulationModules().getMortalityModule().mortalise(this, household);
		}
		
		i_person.setHasMicroSimulated("Y");
	}
	
	public void stepAgentSimulation(HouseholdImpl household, AreaPopulationModel areaPopulationModel) {	
		// s_logger.info("stepAgentSimulation");
		
		/*if(i_person.getHasMigrated() == null) {
			int test = 1;
			test++;
		}*/
		
		if(i_person.getHasAgentSimulated().equals("Y")) {
			return;
		}
		
		// Migration
		if(System.getProperty("Migration") != null && System.getProperty("Migration").equalsIgnoreCase("true")) {
			String stdType = i_person.getStudentType();
			if(i_person.getHasMigrated().equals("Y")) {
				if(stdType != null && (stdType.equals(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE) 
						               || stdType.equals(ApplicationConstants.STUDENT_TYPE_MSC)
						               || stdType.equals(ApplicationConstants.STUDENT_TYPE_PHD))) {
					areaPopulationModel.getSimulationModules().getMigrationModule().migrate(this, household);
				} else {
					return;
				}
			} else {
				areaPopulationModel.getSimulationModules().getMigrationModule().migrate(this, household);
			}
		}
		
		// marriage
		if(System.getProperty("Marriage") != null && System.getProperty("Marriage").equalsIgnoreCase("true")) {
			areaPopulationModel.getSimulationModules().getMarriageModule().marray(this);
		}
		
		i_person.setHasAgentSimulated("Y");
	}
	
	public void setPerson(Person a_person) {
		i_person = a_person;
	}
	
	public Person getPerson() {
		return i_person;
	}
	
	public Long getAgentID() {
		return i_person.getPid();
	}
	
	public boolean isAlive() {
		if(i_person.getDeathStatus().equals("N")) {
			return true;
		} else {
			return false;
		}
	}
	
	// overide toString method
	public String toString() {
		s_logger.info("toString");
		return "";
	}
	
}
