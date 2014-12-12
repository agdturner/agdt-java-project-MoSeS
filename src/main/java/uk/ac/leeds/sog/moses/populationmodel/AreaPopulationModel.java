package uk.ac.leeds.sog.moses.populationmodel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Location;
import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.student.StudentSimulationHelper;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class AreaPopulationModel {
	private Location i_location;
	private PopulationDataHelper i_dataHelper;
	private SimulationModules simulationModules = null;
	private PopulationModel populationModel = null;
	
	private static Logger s_logger = MosesLogger.getLogger(AreaPopulationModel.class);

	public AreaPopulationModel(Location a_location, PopulationDataHelper dataHelper, PopulationModel populationModel) {
		s_logger.info("construct AreaPopulationModel " + a_location.getAreaLocation());
		this.populationModel= populationModel;
		i_location = a_location;
		i_dataHelper = dataHelper;
		simulationModules = SimulationModules.getInstance(dataHelper);
	}
	
	public void initialise() {
		List persons = i_dataHelper.getPersonsByLocation(i_location);
		List students = StudentSimulationHelper.getStudents(i_location.getAreaLocation());
		s_logger.info("number of students generated in location " + i_location.getAreaLocation() + " :" + students.size());
		persons.addAll(students);
		int size = persons.size();
		for(int i=0; i<size; i++) {
			Person person = (Person) persons.get(i);
			person.setHasMigrated("N");
			person.setHasMicroSimulated("N");
			person.setHasAgentSimulated("N");
		}
		i_dataHelper.updatePersonsByLocation(i_location, persons);
	}
	
	public void step() {
		// get all perople and sort them by household id
		List households = new ArrayList();
		List persons = i_dataHelper.getPersonsByLocation(i_location);
		
		if(persons.size() == 0) {
			s_logger.info("no person in location " + i_location.getWardLocation());
			return;
		}
		Collections.sort(persons);
		
		// create household id
		int size = persons.size();
		Person person = (Person) persons.get(0);
		HouseholdImpl household = new HouseholdImpl();
		household.setLocation(i_location);
		household.addMember(new PersonAgent(person));
		household.setHouseholdId(person.getHouseholdId());
		long householdId = person.getHouseholdId().longValue();
		for(int i=1; i<size; i++) {
			person = (Person) persons.get(i);
			if(person.getHouseholdId().longValue() == householdId) {
				household.addMember(new PersonAgent(person));
			} else {
				households.add(household);
				household = new HouseholdImpl();
				household.setLocation(i_location);
				household.addMember(new PersonAgent(person));
				household.setHouseholdId(person.getHouseholdId());
				householdId = person.getHouseholdId().longValue();
			}
		}
		if(!households.contains(household)) {
			households.add(household);
		}
		
		// create student households
		/*if(System.getProperty("StudentSimulation") != null 
				&& System.getProperty("StudentSimulation").equalsIgnoreCase("true")) {
			List students = StudentSimulationHelper.getStudents(i_location.getAreaLocation());
			s_logger.info("number of students in location " + i_location.getAreaLocation() + " :" + students.size());
			for(int i=0; i<students.size(); i++) {
				Person student = (Person) students.get(i);
				household = new HouseholdImpl();
				household.setLocation(i_location);
				household.addMember(new PersonAgent(student));
				household.setHouseholdId(student.getHouseholdId());
				households.add(household);
			}
		}*/
		
		// test
		// test(households);
		
		size = households.size();
		
		// display number of persons
		int numOfAgents = 0;
		for(int i=0; i<size; i++) {
			household = (HouseholdImpl) households.get(i);
			numOfAgents = numOfAgents + household.getHouseholdSize() + household.getNumberOfPersonsInFormalCare();
		}
		Calendar c = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss s");
		s_logger.info("Area " + i_location.toString() + " has the number of persons to simulate: " 
				              + numOfAgents + " " + format.format(c.getTime()));
		
		// start to simulate
		/*for(int i=0; i<size; i++) {
			household = (HouseholdImpl) households.get(i);
			household.test("test in area model before micro simulation household ID: " + household.getHouseholdId());
		}*/
		for(int i=0; i<size; i++) {
			// simulate
			household = (HouseholdImpl) households.get(i);
			// household.test("test in area model household ID: " + household.getHouseholdId());
			household.stepMicroSimulation(this);
		}
		/*for(int i=0; i<size; i++) {
			household = (HouseholdImpl) households.get(i);
			household.test("test in area model after micro simulation before agent simulation household ID: " + household.getHouseholdId());
		}*/
		for(int i=0; i<size; i++) {
			// simulate
			household = (HouseholdImpl) households.get(i);
			// household.test("test in area model");
			household.stepAgentSimulation(this);
		}
		/*for(int i=0; i<size; i++) {
			household = (HouseholdImpl) households.get(i);
			household.test("test in area model after agent simulation household ID: " + household.getHouseholdId());
		}*/
		
		// print out dead and new born people
		int numOfDead = 0;
		int numOfNewBorn = 0;
		int numOfFormcare = 0;
		for(int i=0; i<size; i++) {
			// simulate
			household = (HouseholdImpl) households.get(i);
			numOfDead += household.getDeadMembers().size();
			numOfNewBorn += household.getNewBornMembers().size();
			numOfFormcare += household.getMemebersInFormalCare().size();
		}
		
		s_logger.info("number of dead people after simulation: " + numOfDead);
		s_logger.info("number of new born people after simulation: " + numOfNewBorn);
		s_logger.info("number of people in formal care after simulation: " + numOfFormcare);
		
		// update
		Map personsByLocationMap = new HashMap();
		List locations = i_dataHelper.getAllLocations();
		for(int i=0; i<locations.size(); i++) {
			Location location = (Location) locations.get(i);
			if(location.getWardLocation().equals(i_location.getWardLocation())) {
				continue;
			}
			personsByLocationMap.put(location.getWardLocation(), new ArrayList());
		}
		persons.clear();
		int numberOfMigratedPeople = 0;
		for(int i=0; i<size; i++) {
			household = (HouseholdImpl) households.get(i);
			
			List temp = new ArrayList();
			temp.addAll(household.getHouseholdMembers());
			temp.addAll(household.getMemebersInFormalCare());
			for(int k=0; k<temp.size(); k++) {
				person = ((PersonAgent) temp.get(k)).getPerson();
				persons.add(person);
			}
			
			List migratedPeople = household.getMigratedMembers();
			numberOfMigratedPeople += migratedPeople.size();
			for(int j=0; j<migratedPeople.size(); j++) {
				person = ((PersonAgent) migratedPeople.get(j)).getPerson();
				List personsByLocation = (List) personsByLocationMap.get(person.getWardLocation());
				if(personsByLocation == null) {
					int test = 1;
					test++;
				}
				personsByLocation.add(person);
			}
		}
		
		// s_logger.info("after simulation people left in this location: " + persons.size());
		// s_logger.info("after simulation people moved to other locations: " + numberOfMigratedPeople);
		
		// update for this location
		Collections.sort(persons);
		i_dataHelper.updatePersonsByLocation(i_location, persons);
		persons.clear();
		
		// move people to other locations
		updateOtherLocations(personsByLocationMap);
	}
	
	private void updateOtherLocations(Map personsByLocationMap) {
		Iterator itr = personsByLocationMap.keySet().iterator();
		while(itr.hasNext()) {
			String wardlocation = (String) itr.next();
			List personsByLocation = (List) personsByLocationMap.get(wardlocation);
			i_dataHelper.addPersonsByLocation(wardlocation, personsByLocation);
		}
	}
	
	/*private void test(List households) {
		// s_logger.info("check data in area " + i_location.getAreaLocation());
		for(int i=0; i<households.size(); i++) {
			HouseholdImpl household = (HouseholdImpl) households.get(i);
			testHousehold(household);
		}
	}
	
	private void testHousehold(HouseholdImpl household) {
		int numberOfChildDependents = household.getNumberOfChildrenDependents();
		int numberOfElderly = household.getNumberOfElderly();
		List members = household.getHouseholdMembers();
		boolean hasHrp = false;
		Person hrp = null;
		for(int i=0; i<members.size(); i++) {
			Person member = (Person) members.get(i);
			if(member.getHrpStatus().equals("Y")) {
				hasHrp = true;
				hrp = member;
			}
			
			if(member.getNumberElderly() == null) {
				s_logger.info("number of elderly is null pointer. Household is is " + household.getHouseholdId());
				System.exit(1);
			}
			
			if(member.getNumberElderly().intValue() != numberOfElderly) {
				s_logger.info("number of elderly is not correct. Household is is " + household.getHouseholdId());
				s_logger.info("number of elderly: " + numberOfElderly);
				s_logger.info("member " + member.getPid() + " getNumberOfElderly " +  member.getNumberElderly());
				System.exit(1);
			}
			if(member.getHouseholdSize().intValue() != members.size()) {
				s_logger.info("household size is not correct: " + household.getHouseholdId());
				System.exit(1);
			}
		}
		if(!hasHrp) { 
			if(household.getHouseholdSize() == 1) {
				if(hrp != null && !(hrp.getInFormalCare().equals("Y") && !hrp.getDeathStatus().equals("Y"))) {
					s_logger.info("no Hrp: " + household.getHouseholdId());
					System.exit(1);
				}
			}
		}
		if(numberOfChildDependents > 0 && hrp != null && hrp.getHasChildDependent().equals("N")) {
			s_logger.info("should have child dependent: " + household.getHouseholdId());
			System.exit(1);
		}
		if(numberOfChildDependents == 0 && hrp != null && hrp.getHasChildDependent().equals("Y")) {
			s_logger.info("should not have child dependent: " + household.getHouseholdId());
			System.exit(1);
		}
		if(numberOfChildDependents < 0) {
			s_logger.info("number of child dependent is not correct: " + numberOfChildDependents);
			System.exit(1);
		}
	}*/

	public SimulationModules getSimulationModules() {
		return simulationModules;
	}

	public void setSimulationModules(SimulationModules simulationModules) {
		this.simulationModules = simulationModules;
	}

	public PopulationModel getPopulationModel() {
		return populationModel;
	}

	public void setPopulationModel(PopulationModel populationModel) {
		this.populationModel = populationModel;
	}
}
