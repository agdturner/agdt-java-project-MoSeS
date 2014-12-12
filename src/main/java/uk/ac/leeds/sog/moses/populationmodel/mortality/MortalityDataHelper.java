package uk.ac.leeds.sog.moses.populationmodel.mortality;

import java.util.List;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.PersonAgent;
import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class MortalityDataHelper {

	private PopulationDataHelper populationDataHelper;
	private static Logger s_logger = MosesLogger.getLogger(MortalityDataHelper.class);
	
	public MortalityDataHelper(PopulationDataHelper populationDataHelper) {
		this.populationDataHelper = populationDataHelper;
	}

	public String getSimulationYearString() {
		return String.valueOf(populationDataHelper.getSimulationYear());
	}
	
	public PersonAgent findNewHRP(List householdMembers) {
		PersonAgent newHRP = null;
		
		// spouse
		for(int i=0; i<householdMembers.size(); i++) {
			PersonAgent member = (PersonAgent) householdMembers.get(i);
			Person person = member.getPerson();
			if(person.getFamilyRole().equals(ApplicationConstants.SPOUSE_DEPENDENT_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		// adult
		for(int i=0; i<householdMembers.size(); i++) {
			PersonAgent member = (PersonAgent) householdMembers.get(i);
			Person person = member.getPerson();
			if(person.getFamilyRole().equals(ApplicationConstants.ADULT_DEPENDENT_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		// elderly
		for(int i=0; i<householdMembers.size(); i++) {
			PersonAgent member = (PersonAgent) householdMembers.get(i);
			Person person = member.getPerson();
			if(person.getFamilyRole().equals(ApplicationConstants.ELDERLY_DEPENDENT_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		// child
		for(int i=0; i<householdMembers.size(); i++) {
			PersonAgent member = (PersonAgent) householdMembers.get(i);
			Person person = member.getPerson();
			if(person.getFamilyRole().equals(ApplicationConstants.CHILD_DEPENDENT_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		return newHRP;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		s_logger.info("running");
	}

}
