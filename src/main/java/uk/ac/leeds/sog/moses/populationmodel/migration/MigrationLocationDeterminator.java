package uk.ac.leeds.sog.moses.populationmodel.migration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class MigrationLocationDeterminator  {
	private List i_migrationDeterminators;
	private static String[] s_locations = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
		                                   "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
		                                   "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
		                                   "31", "32", "33"};
	
	private static Logger s_logger = MosesLogger.getLogger(MigrationLocationDeterminator.class);
			
	public MigrationLocationDeterminator() {
		s_logger.info("Constructing FertilityDeterminator");
		i_migrationDeterminators = new ArrayList();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("probability", "probability-migration-location.csv")));
			String s = in.readLine();
			while(s != null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				LocationProbabilityDeterminator determinator = new LocationProbabilityDeterminator(st.nextToken());
				int i = 0;
				while(st.hasMoreTokens()) {
					double probability = Double.parseDouble(st.nextToken());
					if(i > s_locations.length) {
						break;
					}
					determinator.addLocationProbability(s_locations[i], probability);
					i++;
				}
				i_migrationDeterminators.add(determinator);
				s = in.readLine();
			}
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDetination(Object an_object) {
		Person person = (Person) an_object;
		LocationProbabilityDeterminator determinator = null;
		for(int i=0; i<i_migrationDeterminators.size(); i++) {
			LocationProbabilityDeterminator temp = (LocationProbabilityDeterminator) i_migrationDeterminators.get(i);
			if(temp.getLocation().equals(person.getLocation())) {
				determinator = temp;
				break;
			}
		}
		if(determinator == null) {
			s_logger.info("cannot find location determinator. person stays in the same location");
			return person.getLocation();
		}
		
		return determinator.getDestination();
	}

	public static class LocationProbabilityDeterminator {
		private static Random s_random = new Random();
		private String i_fromLocation;
		private List i_toLocations;
		private List i_probability;
		public LocationProbabilityDeterminator(String fromLocation) {
			i_fromLocation = fromLocation;
			i_toLocations = new ArrayList();
			i_probability = new ArrayList();
		}
		
		public String getLocation() {
			return i_fromLocation;
		}
		
		public void addLocationProbability(String toLocation, double probability) {
			i_toLocations.add(toLocation);
			i_probability.add(new Double(probability));
		}
		
		public String getDestination() {
			double randomValue = s_random.nextDouble();
			
			double value = ((Double) i_probability.get(0)).doubleValue();
			if(randomValue < value) {
				return (String) i_toLocations.get(0);
			}
			
			/*value1 = ((Double) i_probability.get(i_probability.size() - 1)).doubleValue();
			double value2 = ((Double) i_probability.get(i_probability.size() - 1)).doubleValue();
			if(randomValue >= value) {
				return (String) i_toLocations.get(i_toLocations.size() - 1);
			}*/
			
			String toLocation = null;
			for(int i=1; i<i_probability.size(); i++) {
				double value1 = ((Double) i_probability.get(i-1)).doubleValue();
				double value2 = ((Double) i_probability.get(i)).doubleValue();
				if(randomValue >= value1 && randomValue < value2) {
					toLocation = (String) i_toLocations.get(i);
					break;
				}
			}
			
			if(toLocation == null) {
				int count = 10;
				count++;
			}
			
			return toLocation;
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MigrationLocationDeterminator determinator = new MigrationLocationDeterminator();
		Person person = new Person();
		person.setLocation("1");
		Counter counter = new Counter("1");
		for(int i=0; i<10000; i++) {
			String newLocation = determinator.getDetination(person);
			counter.count(newLocation);
			if(newLocation.equals(person.getLocation())) {
				s_logger.debug("person stays in the same location: " + person.getLocation());
			} else {
				s_logger.debug("person moves from " + person.getLocation() + " to new location " + newLocation);
			}
		}
		counter.showResults();
	}
	
	public static class Counter {
		private String i_location;
		private Map i_counters = null;
		public Counter(String location) {
			i_location = location;
			i_counters = new HashMap();
			for(int i=1; i<=s_locations.length; i++) {
				i_counters.put(new Integer(i), new Integer(0));
			}
		}
		
		public void count(String location) {
			Integer key = Integer.valueOf(location);
			Integer value = (Integer) i_counters.get(key);
			int newValue = value.intValue() + 1;
			i_counters.put(key, new Integer(newValue));
		}
		
		public void showResults(){
			Iterator itr = i_counters.keySet().iterator();
			while(itr.hasNext()) {
				Integer key = (Integer) itr.next();
				Integer value = (Integer) i_counters.get(key);
				System.out.println("move from " + i_location + " to " + key + " is " + value);
			}
		}
	}
}

