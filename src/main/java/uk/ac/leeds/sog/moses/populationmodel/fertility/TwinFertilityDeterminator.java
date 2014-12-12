package uk.ac.leeds.sog.moses.populationmodel.fertility;

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

public class TwinFertilityDeterminator implements Determinator {
	private List i_twinDeterminators;
	private static Logger s_logger = MosesLogger.getLogger(FertilityDeterminator.class);
			
	public TwinFertilityDeterminator() {
		s_logger.info("Constructing TwinFertilityDeterminator");
		i_twinDeterminators = new ArrayList();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("probability", "probability-fertility-twin.csv")));
			String s = in.readLine();
			while(s != null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				double probability = Double.parseDouble(st.nextToken());
				int minAge = Integer.parseInt(st.nextToken());
				int maxAge = Integer.parseInt(st.nextToken());
				i_twinDeterminators.add(new TwiFertilityProbabilityDeterminator(minAge, maxAge, probability));
				s = in.readLine();
			}
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean determine(Object an_object) {
		Person person = (Person) an_object;
		TwiFertilityProbabilityDeterminator determinator = null;
		for(int i=0; i<i_twinDeterminators.size(); i++) {
			TwiFertilityProbabilityDeterminator deter = (TwiFertilityProbabilityDeterminator) i_twinDeterminators.get(i);
			if(person.getAge().intValue() >= deter.getMinAge() && person.getAge().intValue() <= deter.getMaxAge()) {
				determinator = deter;
				break;
			}
		}
		if(determinator == null) {
			return false;
		}
		return determinator.determine();
	}

	public class TwiFertilityProbabilityDeterminator {
		private int i_minAge;
		private int i_maxAge;
		private double i_probability;
		private RandomProbabilityDeterminator i_determinator;
		private static final int PROBABILITY_UPPER_BOUND = 10000;
		public TwiFertilityProbabilityDeterminator(int minAge, int maxAge, double probability) {
			i_minAge = minAge;
			i_maxAge = maxAge;
			i_probability = probability;
			i_determinator = new RandomProbabilityDeterminator(1.0 - i_probability, PROBABILITY_UPPER_BOUND);
		}
		
		public boolean determine() {
			return i_determinator.determine(null);
		}
		
		public int getMinAge() {
			return i_minAge;
		}
		
		public int getMaxAge() {
			return i_maxAge;
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TwinFertilityDeterminator determinator = new TwinFertilityDeterminator();
		Person person = new Person();
		person.setAge(new Integer(49));
		person.setGender("F");
		int count = 0;
		for(int i=0; i<10000; i++) {
			if(determinator.determine(person)) {
				s_logger.info(i + " twin fertility");
				count++;
			}
		}
		s_logger.info("Total number of twin fertility persons: " + count);
	}
}

