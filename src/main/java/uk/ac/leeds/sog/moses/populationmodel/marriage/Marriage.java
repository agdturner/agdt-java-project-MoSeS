package uk.ac.leeds.sog.moses.populationmodel.marriage;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.PersonAgent;
import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.populationmodel.probability.Determinator;
import uk.ac.leeds.sog.moses.populationmodel.tools.SimulationRecorder;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class Marriage {
	private static Marriage s_instance = null;
	private PopulationDataHelper i_dataHelper = null;
	private Determinator i_marriageDeterminator;
	private Person i_spouse = null;
	private String i_simulationYear;
	
	private static Logger s_logger = MosesLogger.getLogger(Marriage.class);
	
	private Marriage(PopulationDataHelper dataHelper) {
		s_logger.info("Marriage - constructing marriage module");
		i_dataHelper = dataHelper;
		i_marriageDeterminator = new MarriageDeterminator();
	}
	
	public static Marriage getInstance(PopulationDataHelper dataHelper) {
		if(s_instance == null) {
			s_instance = new Marriage(dataHelper);
		}
		return s_instance;
	}
	
	public void marray(PersonAgent a_personAgent) {
		i_simulationYear = i_dataHelper.getSimulationYearString();
		
		Person person = a_personAgent.getPerson();
		
		// person must be not be in formal care
		if(person.getInFormalCare().equals("Y")) {
			s_logger.debug("Person must not be in formal care");
			return;
		}
		
		// person must not be marriaged
		if(person.getMaritalStatus().equals("Y")) {
			// married already
			return;
		}
		
		// person mmust not be child
		if(person.getAge().intValue() <= ApplicationConstants.CHILD_AGE) {
			// under 16
			return;
		}
		
		if(person.getAge().intValue() > ApplicationConstants.MARRIAGE_MAXIMUM_AGE) {
			// > 99
			return;
		}
		
		// test if a marriage would happen
		if(!i_marriageDeterminator.determine(person)) {
			// not marry
			return;
		}
		
		// marry
		if(person.getGender().equals("M")) {
			handleMaleMarriage(a_personAgent);
		} else if(person.getGender().equals("F")) {
			handleFemaleMarriage(a_personAgent);
		} else {
			String msg = "person " + person.getPid() + " gender data error: " + person.getGender();
			s_logger.error(msg);
		}
		
		if(i_spouse == null) {
			// no candidate to marry
			return;
		}
		
		SimulationRecorder.marriage(person, i_spouse, i_simulationYear);
		
		i_spouse = null;
	}
	
	private void handleMaleMarriage(PersonAgent a_personAgent) {
	}
	
	private void handleFemaleMarriage(PersonAgent a_personAgent) {
	}
}