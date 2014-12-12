package uk.ac.leeds.sog.moses.populationmodel.fertility;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class FertilityDataHelper {

	private PopulationDataHelper populationDataHelper;
	private static Logger s_logger = MosesLogger.getLogger(FertilityDataHelper.class);
	
	public FertilityDataHelper(PopulationDataHelper populationDataHelper) {
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
	
	public Long getNextPID() {
		return populationDataHelper.getNextPID();
	}
	
	public boolean isStudent(Person person) {
		boolean res = false;
		String type = person.getStudentType();
		if(type == null) {
			return false;
		}
		if(type.equals(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE)
		            || type.equals(ApplicationConstants.STUDENT_TYPE_MSC) 
		            || type.equals(ApplicationConstants.STUDENT_TYPE_PHD)) {
			res = true;
		}
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		s_logger.info("running");
	}

}

