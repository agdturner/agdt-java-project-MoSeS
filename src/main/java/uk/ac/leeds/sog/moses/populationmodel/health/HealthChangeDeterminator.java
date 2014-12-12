package uk.ac.leeds.sog.moses.populationmodel.health;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.probability.Determinator;
import uk.ac.leeds.sog.moses.populationmodel.probability.RandomProbabilityDeterminator;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class HealthChangeDeterminator implements Determinator {
	private List i_healthChangeDeterminators;
	private static Logger s_logger = MosesLogger.getLogger(HealthChangeDeterminator.class);
	
	public HealthChangeDeterminator() {
		s_logger.info("Constructing HealthChangeDeterminator");
		i_healthChangeDeterminators = new ArrayList();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("probability", "probability-healthchange-male.csv")));
			String s = in.readLine();
			while(s != null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				int minAge = Integer.parseInt(st.nextToken());
				int maxAge = Integer.parseInt(st.nextToken());
				double probability_1 = Double.parseDouble(st.nextToken());
				double probability_2 = Double.parseDouble(st.nextToken());
				i_healthChangeDeterminators.add(new HealthChangeProbabilityDeterminator(minAge, maxAge, probability_1, "M", 1));
				i_healthChangeDeterminators.add(new HealthChangeProbabilityDeterminator(minAge, maxAge, probability_2, "M", 2));
				s = in.readLine();
			}
			in.close();
			
			in = new BufferedReader(new FileReader(new File("probability", "probability-healthchange-female.csv")));
			s = in.readLine();
			while(s != null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				int minAge = Integer.parseInt(st.nextToken());
				int maxAge = Integer.parseInt(st.nextToken());
				double probability_1 = Double.parseDouble(st.nextToken());
				double probability_2 = Double.parseDouble(st.nextToken());
				i_healthChangeDeterminators.add(new HealthChangeProbabilityDeterminator(minAge, maxAge, probability_1, "F", 1));
				i_healthChangeDeterminators.add(new HealthChangeProbabilityDeterminator(minAge, maxAge, probability_2, "F", 2));
				s = in.readLine();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean determine(Object an_object) {
		Person person = (Person) an_object;
		HealthChangeProbabilityDeterminator determinator = null;
		for(int i=0; i<i_healthChangeDeterminators.size(); i++) {
			HealthChangeProbabilityDeterminator temp = (HealthChangeProbabilityDeterminator) i_healthChangeDeterminators.get(i);
			if(person.getAge().intValue() >= temp.getMinAge() && person.getAge().intValue() < temp.getMaxAge()
					&& person.getGender().equals(temp.getGender()) && person.getHealthStatus().intValue() == temp.getHealthStatus()) {
				determinator = temp;
				break;
			}
		}
		if(determinator == null) {
			return false;
		}
		return determinator.determine();
	}
	
	class HealthChangeProbabilityDeterminator {
		private int i_minAge;
		private int i_maxAge;
		private String i_gender;  // M: Male  F:Female
		private int i_healthStatus;
		private double i_probability;
		private RandomProbabilityDeterminator i_determinator;
		private static final int PROBABILITY_UPPER_BOUND = 10000;
		public HealthChangeProbabilityDeterminator(int minAge, int maxAge, double probability, String gender, int healthStatus) {
			i_minAge = minAge;
			i_maxAge = maxAge;
			i_probability = probability;
			i_determinator = new RandomProbabilityDeterminator(1.0 - i_probability, PROBABILITY_UPPER_BOUND);
			i_gender = gender;
			i_healthStatus = healthStatus;
		}
		
		public boolean determine() {
			return i_determinator.determine(null);
		}
		
		public String getGender() {
			return i_gender;
		}
		
		public int getMinAge() {
			return i_minAge;
		}
		
		public int getMaxAge() {
			return i_maxAge;
		}
		
		public int getHealthStatus() {
			return i_healthStatus;
		}
	}
	
	public static void main(String[] args) {
		HealthChangeDeterminator determinator = new HealthChangeDeterminator();
		Person person = new Person();
		person.setAge(new Integer(86));
		person.setGender("F");
		person.setHealthStatus(new Integer(1));
		int count = 0;
		for(int i=0; i<10000; i++) {
			if(determinator.determine(person)) {
				s_logger.debug(i + " health changes");
				count++;
			}
		}
		s_logger.debug("Total number of persons with health changed: " + count);
	}
	
}
