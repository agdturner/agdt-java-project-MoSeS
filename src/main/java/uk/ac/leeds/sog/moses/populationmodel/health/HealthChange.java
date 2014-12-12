package uk.ac.leeds.sog.moses.populationmodel.health;

import java.util.List;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.HouseholdImpl;
import uk.ac.leeds.sog.moses.populationmodel.PersonAgent;
import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.populationmodel.probability.Determinator;
import uk.ac.leeds.sog.moses.populationmodel.tools.SimulationRecorder;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class HealthChange {
	private static HealthChange s_instance = null;
	private HealthChangeDataHelper i_dataHelper = null;
	private Determinator i_healthChangeDeterminator;
	private Determinator i_inFormalCareDeterminator;
	private String i_simulationYear;
	
	private static Logger s_logger = MosesLogger.getLogger(HealthChange.class);

	private HealthChange(PopulationDataHelper dataHelper) {
		s_logger.info("HealthChange - constructing health change module");
		i_dataHelper = new HealthChangeDataHelper(dataHelper);
		i_healthChangeDeterminator = new HealthChangeDeterminator();
		i_inFormalCareDeterminator = new FormalCareDeterminator();
	}

	public static HealthChange getInstance(PopulationDataHelper dataHelper) {
		if(s_instance == null) {
			s_instance = new HealthChange(dataHelper);
		}
		return s_instance;
	}
	
	public void change(PersonAgent a_personAgent, HouseholdImpl household) {
		i_simulationYear = i_dataHelper.getSimulationYearString();
		
		Person person = a_personAgent.getPerson();
		
		// a person must not be in formal care
		if(person.getInFormalCare().equals("Y")) {
			s_logger.debug("Person must not be in formal care");
			return;
		}
		
		// a person must not be under elderly age
		if(person.getAge().intValue() < ApplicationConstants.ELDERLY_AGE) {
			s_logger.debug("Person must not be under " + ApplicationConstants.ELDERLY_AGE);
			return;
		}
		
		// person must be in formal care if he/she is 100 year old
		if(person.getAge().intValue() >= 100) {
			s_logger.debug("Person who is 100 year old or over must be in formal care " + person.getPid());
			processFormalCare(person, household);
			SimulationRecorder.health(person, "Person goes into formal care when he/she is 100 year old", i_simulationYear);
			return;
		}
		
		// decide if person should be moved into formal care
		if(i_inFormalCareDeterminator.determine(person)) {
			processFormalCare(person, household);
			String oldStatus = null;
			if(person.getHealthStatus().intValue() == ApplicationConstants.HEALTH_FAIRLY_GOOD) {
				oldStatus = "FAIRLY GOOD";
			} else if(person.getHealthStatus().intValue() == ApplicationConstants.HEALTH_GOOD) {
				oldStatus = "GOOD";
			} else if(person.getHealthStatus().intValue() == ApplicationConstants.HEALTH_NOT_GOOD) {
				oldStatus = "NOT GOOD";
			}
			SimulationRecorder.health(person, oldStatus + " to Formal Care", i_simulationYear);
			return;
		}
		
		// person with good health
		if(person.getHealthStatus().intValue() == ApplicationConstants.HEALTH_GOOD) {
			if(i_healthChangeDeterminator.determine(person)) {
				person.setHealthStatus(new Integer(ApplicationConstants.HEALTH_FAIRLY_GOOD));
				person.setComment("health change from Good to Fairly Good");
				// i_dataHelper.update(person, person.getId(), Person.class);
				SimulationRecorder.health(person, "GOOD to FAIRLY GOOD", i_simulationYear);
			}
			return;
		}
		
		// person with fairly good health
		if(person.getHealthStatus().intValue() == ApplicationConstants.HEALTH_FAIRLY_GOOD) {
			if(i_healthChangeDeterminator.determine(person)) {
				person.setHealthStatus(new Integer(ApplicationConstants.HEALTH_NOT_GOOD));
				person.setComment("health change from Fairly Good to Not Good");
				// i_dataHelper.update(person, person.getId(), Person.class);
				SimulationRecorder.health(person, "FAIRLY GOOD to NOT GOOD", i_simulationYear);
			}
			return;
		}
	}
	
	private void processFormalCare(Person a_person, HouseholdImpl household) {
		// move person to be in formal cares
		a_person.setInFormalCare("Y");
		a_person.setComment("move into formal care in health change");
		boolean hrpFormalcare = false;
		if(a_person.getHrpStatus().equals("Y")) {
			hrpFormalcare = true;
		} else {
			hrpFormalcare = false;
		}
		a_person.setHrpStatus("N");
		a_person.setFamilyRole(ApplicationConstants.In_FORAML_CARE_ROLE);
		// i_dataHelper.update(a_person, a_person.getId(), Person.class);
		if(hrpFormalcare) {
			// HRP
			processHRPFormalCare(a_person, household);
		} else {
			// non-HRP
			processNonHRPFormalCare(a_person, household);
		}
	}
	
	private void processHRPFormalCare(Person a_person, HouseholdImpl household) {
		household.moveFormalCarePerson(a_person);
		List householdmembers = household.getHouseholdMembers();
		if(householdmembers.size() == 0) {
			// do nothing
		} else if (householdmembers.size() > 0) {
			// with other members
			PersonAgent newHRP = i_dataHelper.findNewHRP(householdmembers);
			Person person = newHRP.getPerson();
			person.setHrpStatus("Y");
			person.setFamilyRole(ApplicationConstants.HRP_ROLE);
			// person.setHouseholdId(newHRP.getPid());
			// i_dataHelper.updateHouseholdStatus(household, newHRP, "update statuses in HRP formal care");
		} else {
			s_logger.info("data error in processHRPFormalCare ");
			System.exit(1);
		}
	}
	
	private void processNonHRPFormalCare(Person a_person, HouseholdImpl household) {
		// i_dataHelper.updateHouseholdStatus(household, null, "update statuses in non-HRP formal care");
		household.moveFormalCarePerson(a_person);
	}

}
