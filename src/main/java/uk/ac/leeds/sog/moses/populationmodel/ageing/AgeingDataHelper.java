package uk.ac.leeds.sog.moses.populationmodel.ageing;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class AgeingDataHelper {
	private PopulationDataHelper populationDataHelper;
	private static Logger s_logger = MosesLogger.getLogger(AgeingDataHelper.class);
	
	public AgeingDataHelper(PopulationDataHelper populationDataHelper) {
		this.populationDataHelper = populationDataHelper;
	}
	
	public String getSimulationYearString() {
		return String.valueOf(populationDataHelper.getSimulationYear());
	}
	
	/*public void updateHouseholdStatus(HouseholdImpl household, Person newHRP, String comments) {
		List members = household.getHouseholdMembers();
		Integer numberOfElderly = new Integer(household.getNumberOfElderly());
		int numberOfChildDependent = household.getNumberOfChildrenDependents();
		Integer sizeH = new Integer(household.getHouseholdSize());
		for(int i=0; i<members.size(); i++) {
			Person member = (Person) members.get(i);
			if(newHRP != null) {
				member.setHouseholdId(newHRP.getPid());
			}
			member.setHouseholdSize(sizeH);
			member.setNumberElderly(numberOfElderly);
			if(numberOfChildDependent > 0) {
				member.setHasChildDependent("Y");
			} else if(numberOfChildDependent == 0) {
				member.setHasChildDependent("N");
			}
			member.setComment(comments);
		}
	}*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		s_logger.info("running");
	}

}
