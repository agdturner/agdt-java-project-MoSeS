package uk.ac.leeds.sog.moses.populationmodel.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Household;
import uk.ac.leeds.sog.moses.datamodel.Location;
import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class DataIntegrityChecker {

	private static PopulationDataHelper s_dataHelper = new PopulationDataHelper();
	private static Logger s_logger = MosesLogger.getLogger(DataIntegrityChecker.class);
			
	private DataIntegrityChecker() {
	}

	public static void check() {
		List locations = s_dataHelper.getAllLocations();
		for(int i=0; i<locations.size(); i++) {
			// s_dataHelper.clear();
			Location location = (Location) locations.get(i);
			if(location.getAreaLocation().equals("2")) {
				int tempint=1;
				tempint++;
			}
			s_logger.info("check ward location: " + location.getWardLocation());
			
			// List households = s_dataHelper.getAllHouseholds();
			// List households = s_dataHelper.getHouseholdsByLocation(location.getAreaLocation());
			// List vacantHouseholds = getVacantHouseholds(households);
			// List occupiedHouseholds = getOccupiedHouseholds(households);
			
			// Map personsByHousehold = organisePersonsByHousehold(personsInHousehold, occupiedHouseholds);
			
			/*if(checkHouseholdStatus(households) == false) {
				// failed to pass household size test
				System.exit(1);
			}*/
			
			// if(checkHouseholdStatus(vacantHouseholds) == false) {
				// failed to pass household size test
				// System.exit(1);
			// }
			
			/*if(checkHouseholdSize(personsByHousehold) == false) {
				// failed to pass household size test
				System.exit(1);
			}*/
		}
		s_logger.info("Complete checking all the ward locations");
	}
	
	public static Map organisePersonsByHousehold(List a_listOfPersons, List a_listOfHouseholds) {
		Map result = new HashMap();
		int sizeOfListOfhouseholds = a_listOfHouseholds.size();
		for(int i=0; i<sizeOfListOfhouseholds; i++) {
			Household household = (Household) a_listOfHouseholds.get(i);
			int sizeOfListOfPersons = a_listOfPersons.size();
			List persons = new ArrayList();
			for(int j=0; j<sizeOfListOfPersons; j++) {
				Person person = (Person) a_listOfPersons.get(j);
				if(person.getHouseholdId().equals(household.getHouseholdId())) {
					persons.add(person);
				}
			}
			result.put(household, persons);
		}
		
		return result;
	}
	
	public static void main(String args[]) {
		DataIntegrityChecker.check();
	}
	
}
