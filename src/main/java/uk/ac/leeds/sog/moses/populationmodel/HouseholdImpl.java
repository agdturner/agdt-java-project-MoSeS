package uk.ac.leeds.sog.moses.populationmodel;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Location;
import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class HouseholdImpl {
	private List members;
	private List newBornMembers;
	private List deadMembers;
	private List memebersInFormalCare;
	private List migratedMembers;
	private List leavingStudents;
	
	private Location location = null;
	private Long id = null;
	private static Logger s_logger = MosesLogger.getLogger(HouseholdImpl.class);
	
	public HouseholdImpl() {
		members = new ArrayList();
		newBornMembers = new ArrayList();
		deadMembers = new ArrayList();
		memebersInFormalCare = new ArrayList();
		migratedMembers = new ArrayList();
		leavingStudents = new ArrayList();
	}
	
	public List getTotalMembers() {
		List totalMembers = new ArrayList();
		totalMembers.addAll(members);
		totalMembers.addAll(newBornMembers);
		return totalMembers;
	}
	
	public List getMembers() {
		List result = new ArrayList();
		result.addAll(members);
		result.addAll(newBornMembers);
		return result;
	}
	
	public List getDeadMembers() {
		return deadMembers;
	}

	public List getMemebersInFormalCare() {
		return memebersInFormalCare;
	}

	public List getMigratedMembers() {
		return migratedMembers;
	}

	public List getNewBornMembers() {
		return newBornMembers;
	}
	
	public boolean hasStudent() {
		boolean res = false;
		for(int i=0; i<members.size(); i++) {
			Person person = ((PersonAgent) members.get(i)).getPerson();
			String stdType = person.getStudentType();
			if(stdType != null && (stdType.equals(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE) 
                    || stdType.equals(ApplicationConstants.STUDENT_TYPE_MSC)
                    || stdType.equals(ApplicationConstants.STUDENT_TYPE_PHD))) {
				res = true;
			}
		}
		return res;
	}
	
	public void addMember(PersonAgent member) {
		Person person = ((PersonAgent) member).getPerson();
		if(person.getInFormalCare().equals("N")) {
			members.add(member);
		} else if(person.getInFormalCare().equals("Y")) {
			memebersInFormalCare.add(member);
		} else {
			s_logger.info("addMember(agent) - HouseholdImpl");
			System.exit(1);
		}
	}
	
	public void moveFormalCarePerson(Person person) {
		PersonAgent agent = null;
		for(int i=0; i<members.size(); i++) {
			Person tempPerson = ((PersonAgent) members.get(i)).getPerson();
			if(tempPerson.getPid().longValue() == person.getPid().intValue()) {
				agent = (PersonAgent) members.get(i);
				break;
			}
		}
		members.remove(agent);
		memebersInFormalCare.add(agent);
	}
	
	public void moveMigratedPerson(Person person) {
		PersonAgent agent = null;
		for(int i=0; i<members.size(); i++) {
			Person tempPerson = ((PersonAgent) members.get(i)).getPerson();
			if(tempPerson.getPid().longValue() == person.getPid().intValue()) {
				agent = (PersonAgent) members.get(i);
				break;
			}
		}
		if(agent != null) {
			members.remove(agent);
			migratedMembers.add(agent);
		} else {
			s_logger.info("cannot find migrated person");
			System.exit(1);
		}
	}
	
	public void moveStudentOut(Person person) {
		PersonAgent agent = null;
		for(int i=0; i<members.size(); i++) {
			Person tempPerson = ((PersonAgent) members.get(i)).getPerson();
			if(tempPerson.getPid().longValue() == person.getPid().intValue()) {
				agent = (PersonAgent) members.get(i);
				break;
			}
		}
		if(agent != null) {
			members.remove(agent);
			leavingStudents.add(agent);
		} else {
			s_logger.info("student left university");
			System.exit(1);
		}
	}
	
	public void migrateAllPeople() {
		migratedMembers.addAll(members);
		migratedMembers.addAll(newBornMembers);
		migratedMembers.addAll(memebersInFormalCare);
		members.clear();
		newBornMembers.clear();
		memebersInFormalCare.clear();
	}
	
	public void addDeadMember(PersonAgent member) {
		deadMembers.add(member);
	}
	
	public void removeDeadMember(PersonAgent member) {
		if(members.contains(member)) {
			members.remove(member);
			return;
		}
		if(memebersInFormalCare.contains(member)) {
			memebersInFormalCare.remove(member);
			return;
		}
		if(newBornMembers.contains(member)) {
			newBornMembers.remove(member);
			return;
		}
	}
	
	public void addNewBornMember(Object member) {
		newBornMembers.add(member);
	}
	
	public List getHouseholdMembers() {
		List result = new ArrayList();
		result.addAll(members);
		result.addAll(newBornMembers);
		return result;
	}
	
	public List getHouseholdMembersWithInFormalCare() {
		List result = new ArrayList();
		result.addAll(members);
		result.addAll(newBornMembers);
		result.addAll(memebersInFormalCare);
		return result;
	}
	
	public int getHouseholdSize() {
		List result = new ArrayList();
		result.addAll(members);
		result.addAll(newBornMembers);
		return result.size();
	}
	
	public String getWardLocation() {
		return location.getWardLocation();
	}
	
	public Long getHouseholdId() {
		return id;
	}
	
	public void setHouseholdId(Long id) {
		this.id = id;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public int getNumberOfPersonsInFormalCare() {
		return memebersInFormalCare.size();
	}
	
	public boolean isEmpty() {
		if(members.size() == 0 && newBornMembers.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasMemberInFormalCare() {
		if(memebersInFormalCare.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void stepMicroSimulation(AreaPopulationModel areaPopulationModel) {
		// micro simulation
		for(int i=0; i<members.size(); i++) {
			PersonAgent personAgent = (PersonAgent) members.get(i);
			personAgent.stepMicroSimulation(this, areaPopulationModel);
		}
		for(int i=0; i<memebersInFormalCare.size(); i++) {
			PersonAgent personAgent = (PersonAgent) memebersInFormalCare.get(i);
			if(personAgent == null) {
				int test = 1;
				test++;
			}
			personAgent.stepMicroSimulation(this, areaPopulationModel);
		}
		updateStatus();
	}
	
	public void stepAgentSimulation(AreaPopulationModel areaPopulationModel) {
		// agent simulation
		for(int i=0; i<members.size(); i++) {
			PersonAgent personAgent = (PersonAgent) members.get(i);
			personAgent.stepAgentSimulation(this, areaPopulationModel);
		}
		for(int i=0; i<memebersInFormalCare.size(); i++) {
			PersonAgent personAgent = (PersonAgent) memebersInFormalCare.get(i);
			personAgent.stepAgentSimulation(this, areaPopulationModel);
		}
		updateStatus();
	}
	
	public void updateStatus() {
		List members = getHouseholdMembers();
		Integer numberOfElderly = new Integer(getNumberOfElderly());
		int numberOfChildDependent = getNumberOfChildrenDependents();
		Integer sizeH = new Integer(getHouseholdSize());
		for(int i=0; i<members.size(); i++) {
			Person member = ((PersonAgent) members.get(i)).getPerson();
			member.setHouseholdSize(sizeH);
			member.setNumberElderly(numberOfElderly);
			member.setHouseholdId(id);
			if(numberOfChildDependent > 0) {
				member.setHasChildDependent("Y");
			} else if(numberOfChildDependent == 0) {
				member.setHasChildDependent("N");
			}
		}
	}
	
	/*public int getHouseholdSizeWithFormalCare() {
		List temp = new ArrayList();
		temp.addAll(members);
		temp.addAll(this.newMembers);
		int count = 0;
		for(int i=0; i<temp.size(); i++) {
			Person member = ((PersonAgent) temp.get(i)).getPerson();
			if(member.getDeathStatus().equals("N") && member.getHouseholdId().longValue() == id) {
				count++;
			}
		}
		return count;
	}*/
	
	public Person getHRP() {
		Person hrp = null;
		List result = new ArrayList();
		result.addAll(members);
		result.addAll(newBornMembers);
		for(int i=0; i<members.size(); i++) {
			Person member = ((PersonAgent) members.get(i)).getPerson();
			if(member.getHrpStatus().equals("Y")) {
				hrp = member;
				break;
			}
		}
		if(hrp == null) {
			s_logger.info("Cannot find HRP - HouseholdImpl");
			System.exit(1);
		}
		return hrp;
	}
	
	public int getNumberOfChildrenDependents() {
		List temp = new ArrayList();
		temp.addAll(members);
		temp.addAll(newBornMembers);
		int number = 0;
		for(int i=0; i<temp.size(); i++) {
			Person member = ((PersonAgent) temp.get(i)).getPerson();
			if(member.getAge().intValue() <= ApplicationConstants.CHILD_AGE && member.getHrpStatus().equals("N")) {
				number++;
			}
		}
		return number;
	}
	
	public int getNumberOfElderly() {
		int number = 0;
		for(int i=0; i<members.size(); i++) {
			Person member = ((PersonAgent) members.get(i)).getPerson();
			if(member.getAge().intValue() >=  ApplicationConstants.ELDERLY_AGE) {
				number++;
			}
		}
		return number;
	}
	
	public boolean test(String message) {
		// s_logger.info(message);
		int numberOfChildren = this.getNumberOfChildrenDependents();
		int numberOfElderly = this.getNumberOfElderly();
		List members = this.getHouseholdMembers();
		boolean hasHrp = false;
		Person hrp = null;
		long householdid = -1L;
		for(int i=0; i<members.size(); i++) {
			Person member = ((PersonAgent) members.get(i)).getPerson();
			if(householdid != -1L && householdid != member.getHouseholdId().longValue()) {
				s_logger.info("household id is not correct");
				System.exit(1);
			}
			householdid = member.getHouseholdId().longValue();
			if(member.getFamilyRole() == null || member.getFamilyRole().equals("")) {
				s_logger.info("no family role");
				int test = 1;
				test++;
			}
			if(member.getHrpStatus().equals("Y")) {
				hasHrp = true;
				hrp = member;
			}
			if(member == null || member.getNumberElderly() == null) {
				int test = 1;
				test++;
			}
			if(member.getNumberElderly().intValue() != numberOfElderly) {
				s_logger.info("number of elderly is not correct. Household is is " + this.getHouseholdId());
				s_logger.info("number of elderly: " + numberOfElderly);
				s_logger.info("member " + member.getPid() + " getNumberOfElderly " +  member.getNumberElderly());
				return false;
			}
			if(member.getHouseholdSize().intValue() != members.size()) {
				s_logger.info("household size is not correct: " + this.getHouseholdId());
				return false;
			}
		}
		if(!hasHrp) { 
			if(this.getHouseholdSize() == 1) {
				if(hrp != null && !(hrp.getInFormalCare().equals("Y") && !hrp.getDeathStatus().equals("Y"))) {
					s_logger.info("no Hrp: " + this.getHouseholdId());
					return false;
				}
			}
		}
		if(numberOfChildren > 0 && hrp != null && hrp.getHasChildDependent().equals("N")) {
			s_logger.info("should have child dependent: " + this.getHouseholdId());
			System.exit(1);
		}
		if(numberOfChildren == 0 && hrp != null && hrp.getHasChildDependent().equals("Y")) {
			s_logger.info("should not have child dependent: " + this.getHouseholdId());
			return false;
		}
		if(numberOfChildren < 0) {
			s_logger.info("number of child dependent is not correct: " + numberOfChildren);
			return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		s_logger.info("running");
	}

	public List getLeavingStudents() {
		return leavingStudents;
	}

	public void setLeavingStudents(List leavingStudents) {
		this.leavingStudents = leavingStudents;
	}
	
	public void processLeavingStudents(PersonAgent member) {
		members.remove(member);
		leavingStudents.add(member);
	}

}
