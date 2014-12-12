package uk.ac.leeds.sog.moses.populationmodel.migration;

import java.util.List;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.HouseholdImpl;
import uk.ac.leeds.sog.moses.populationmodel.PersonAgent;
import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class MigrationDataHelper {

	private PopulationDataHelper populationDataHelper;
	private static Logger s_logger = MosesLogger.getLogger(MigrationDataHelper.class);
	
	public MigrationDataHelper(PopulationDataHelper populationDataHelper) {
		this.populationDataHelper = populationDataHelper;
	}

	public String getSimulationYearString() {
		return String.valueOf(populationDataHelper.getSimulationYear());
	}
	
	public Long getNextHouseholdId() {
		return populationDataHelper.getNextHouseholdID();
	}
	
	public void updateHouseholdStatus(HouseholdImpl household, Person newHRP, String comments) {
		if(newHRP != null) {
			household.setHouseholdId(newHRP.getHouseholdId());
		}
		List members = household.getHouseholdMembers();
		Integer numberOfElderly = new Integer(household.getNumberOfElderly());
		int numberOfChildDependent = household.getNumberOfChildrenDependents();
		Integer sizeH = new Integer(household.getHouseholdSize());
		for(int i=0; i<members.size(); i++) {
			Person member = ((PersonAgent) members.get(i)).getPerson();
			// if(!member.getWardLocation().equals(household.getLocation().getWardLocation())) {
			//	break;
			// }
			if(newHRP != null) {
				member.setHouseholdId(newHRP.getHouseholdId());
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
	}
	
	public void updateHouseholdStatus(HouseholdImpl household, String comments) {
		List members = household.getHouseholdMembers();
		Person newHRP = findNewHRP(members);
		if(newHRP == null) {
			s_logger.info("cannot find new HRP in MigrationDataHelper");
			System.exit(1);
		}
		Integer numberOfElderly = new Integer(household.getNumberOfElderly());
		int numberOfChildDependent = household.getNumberOfChildrenDependents();
		Integer sizeH = new Integer(household.getHouseholdSize());
		for(int i=0; i<members.size(); i++) {
			Person member = ((PersonAgent) members.get(i)).getPerson();
			if(newHRP != null) {
				member.setHouseholdId(newHRP.getHouseholdId());
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
	}
	
	public Person findNewHRP(List householdMembers) {
		Person newHRP = null;
		
		// existing HRP
		for(int i=0; i<householdMembers.size(); i++) {
			Person member = ((PersonAgent) householdMembers.get(i)).getPerson();
			if(member.getFamilyRole().equals(ApplicationConstants.HRP_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		// spouse
		for(int i=0; i<householdMembers.size(); i++) {
			Person member = ((PersonAgent) householdMembers.get(i)).getPerson();
			if(member.getFamilyRole().equals(ApplicationConstants.SPOUSE_DEPENDENT_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		// adult
		for(int i=0; i<householdMembers.size(); i++) {
			Person member = ((PersonAgent) householdMembers.get(i)).getPerson();
			if(member.getFamilyRole().equals(ApplicationConstants.ADULT_DEPENDENT_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		// elderly
		for(int i=0; i<householdMembers.size(); i++) {
			Person member = ((PersonAgent) householdMembers.get(i)).getPerson();
			if(member.getFamilyRole().equals(ApplicationConstants.ELDERLY_DEPENDENT_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		// child
		for(int i=0; i<householdMembers.size(); i++) {
			Person member = ((PersonAgent) householdMembers.get(i)).getPerson();
			if(member.getFamilyRole().equals(ApplicationConstants.CHILD_DEPENDENT_ROLE)) {
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


