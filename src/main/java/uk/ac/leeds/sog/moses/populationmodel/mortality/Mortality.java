package uk.ac.leeds.sog.moses.populationmodel.mortality;

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

public class Mortality {
	private static Mortality s_instance = null;
	private MortalityDataHelper i_dataHelper = null;
	private Determinator i_deathDeterminator;
	private Person i_newHRP = null;
	private String i_simulationYear;
	
	private static Logger s_logger = MosesLogger.getLogger(Mortality.class);

	private Mortality(PopulationDataHelper dataHelper) {
		s_logger.info("Mortality - constructing mortality module");
		i_dataHelper = new MortalityDataHelper(dataHelper);
		i_deathDeterminator = new MortalityDeterminator();
	}
	
	public static Mortality getInstance(PopulationDataHelper dataHelper) {
		if(s_instance == null) {
			s_instance = new Mortality(dataHelper);
		}
		return s_instance;
	}
	
	public void mortalise(PersonAgent a_personAgent, HouseholdImpl household) {
		i_simulationYear = i_dataHelper.getSimulationYearString();
		Person person = a_personAgent.getPerson();
		
		if(!i_deathDeterminator.determine(person)) {
			// person is still alive
			return;
		}
		
		person.setDeathStatus("Y");
		household.removeDeadMember(a_personAgent);
		household.addDeadMember(a_personAgent);
		
		if(person.getHrpStatus().equals("Y")) {
			// s_logger.info("HRP mortality: " + person.getPid());
			handleHRP(person, household);
		} else {
			// s_logger.info("Non-HRP mortality: " + person.getPid());
		}
		
		if(i_newHRP == null) {
			SimulationRecorder.mortality(person, null, i_simulationYear);
		} else {
			SimulationRecorder.mortality(person, i_newHRP, i_simulationYear);
		}
	}
	
	private void handleHRP(Person a_person, HouseholdImpl household) {
		a_person.setComment("HRP mortality");
		List householdmembers = household.getHouseholdMembers();
		if(household.getHouseholdSize() == 0) {
			// empty household - do nothing
		} else if(household.getHouseholdSize() > 0) {
			// update household status
			// s_logger.info("household size: " + household.getHouseholdSize());
			PersonAgent newHRP = i_dataHelper.findNewHRP(householdmembers);
			/*if(newHRP == null) {
				int debug = 1;
				debug++;
			}*/
			Person hrpPerson = newHRP.getPerson();
			hrpPerson.setHrpStatus("Y");
			hrpPerson.setFamilyRole(ApplicationConstants.HRP_ROLE);
			// hrpPerson.setHouseholdId(hrpPerson.getPid());
		} else {
			s_logger.error("household size is wrong: " + a_person.getHouseholdSize().intValue());
			s_logger.info("household size is wrong: " + a_person.getHouseholdSize().intValue());
			System.exit(1);
		}
	}
}
