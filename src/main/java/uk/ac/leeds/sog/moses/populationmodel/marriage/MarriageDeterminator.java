package uk.ac.leeds.sog.moses.populationmodel.marriage;

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

public class MarriageDeterminator implements Determinator {
	private List i_marriageDeterminators;
	private static Logger s_logger = MosesLogger.getLogger(MarriageDeterminator.class);
	
	public MarriageDeterminator() {
		s_logger.info("Constructing MarriageDeterminator");
		i_marriageDeterminators = new ArrayList();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("probability", "probability-marriage-male.csv")));
			String s = in.readLine();
			while(s != null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				double probability = Double.parseDouble(st.nextToken());
				int minAge = Integer.parseInt(st.nextToken());
				int maxAge = Integer.parseInt(st.nextToken());
				i_marriageDeterminators.add(new MarriageProbabilityDeterminator(minAge, maxAge, probability, "M"));
				s = in.readLine();
			}
			in.close();
			
			in = new BufferedReader(new FileReader(new File("probability", "probability-marriage-female.csv")));
			s = in.readLine();
			while(s != null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				double probability = Double.parseDouble(st.nextToken());
				int minAge = Integer.parseInt(st.nextToken());
				int maxAge = Integer.parseInt(st.nextToken());
				i_marriageDeterminators.add(new MarriageProbabilityDeterminator(minAge, maxAge, probability, "F"));
				s = in.readLine();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean determine(Object an_object) {
		Person person = (Person) an_object;
		MarriageProbabilityDeterminator determinator = null;
		for(int i=0; i<i_marriageDeterminators.size(); i++) {
			MarriageProbabilityDeterminator temp = (MarriageProbabilityDeterminator) i_marriageDeterminators.get(i);
			if(person.getAge().intValue() >= temp.getMinAge() && person.getAge().intValue() < temp.getMaxAge()
					&& person.getGender().equals(temp.getGender())) {
				determinator = temp;
				break;
			}
		}
		if(determinator == null) {
			return false;
		}
		return determinator.determine();
	}
	
	class MarriageProbabilityDeterminator {
		private int i_minAge;
		private int i_maxAge;
		private String i_gender;  // M: Male  F:Female
		private double i_probability;
		private RandomProbabilityDeterminator i_determinator;
		private static final int PROBABILITY_UPPER_BOUND = 10000;
		public MarriageProbabilityDeterminator(int minAge, int maxAge, double probability, String gender) {
			i_minAge = minAge;
			i_maxAge = maxAge;
			i_probability = probability;
			i_determinator = new RandomProbabilityDeterminator(1.0 - i_probability, PROBABILITY_UPPER_BOUND);
			i_gender = gender;
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
	}
	
	public static void main(String[] args) {
		MarriageDeterminator determinator = new MarriageDeterminator();
		Person person = new Person();
		person.setAge(new Integer(30));
		person.setGender("F");
		int count = 0;
		for(int i=0; i<10000; i++) {
			if(determinator.determine(person)) {
				s_logger.debug(i + " marraies");
				count++;
			}
		}
		s_logger.debug("Total number of married persons: " + count);
	}
}
