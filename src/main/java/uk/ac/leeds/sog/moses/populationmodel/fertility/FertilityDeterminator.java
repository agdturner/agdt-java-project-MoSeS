package uk.ac.leeds.sog.moses.populationmodel.fertility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.probability.Determinator;
import uk.ac.leeds.sog.moses.populationmodel.probability.RandomProbabilityDeterminator;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class FertilityDeterminator implements Determinator {
	private static final int NUMBER_OF_AREAS = ApplicationConstants.NUMBER_OF_AREAS;
	public static final int FERTILITY_MIN_AGE = ApplicationConstants.FERTILITY_MIN_AGE;
	public static final int FERTILITY_MAX_AGE = ApplicationConstants.FERTILITY_MAX_AGE;
	
	private FertilityProbabilityDeterminator[][] i_marriage = 
		     new FertilityProbabilityDeterminator[FERTILITY_MAX_AGE - FERTILITY_MIN_AGE + 1][NUMBER_OF_AREAS];
	private FertilityProbabilityDeterminator[][] i_single = 
		    new FertilityProbabilityDeterminator[FERTILITY_MAX_AGE - FERTILITY_MIN_AGE + 1][NUMBER_OF_AREAS];
	private static Logger s_logger = MosesLogger.getLogger(FertilityDeterminator.class);
			
	public FertilityDeterminator() {
		s_logger.info("Constructing FertilityDeterminator");
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("probability", "fertility-probability-marriage.csv")));
			String s = in.readLine();
			int count = 0;
			while(s != null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				int age = Integer.parseInt(st.nextToken());
				for(int i=0; i<NUMBER_OF_AREAS; i++) {
					i_marriage[count][i] = new FertilityProbabilityDeterminator(age, age, Double.parseDouble(st.nextToken()), "Y");
				}
				s = in.readLine();
				count++;
			}
			in.close();
			
			in = new BufferedReader(new FileReader(new File("probability", "fertility-probability-single.csv")));
			s = in.readLine();
			count = 0;
			while(s != null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				int age = Integer.parseInt(st.nextToken());
				for(int i=0; i<NUMBER_OF_AREAS; i++) {
					i_single[count][i] = new FertilityProbabilityDeterminator(age, age, Double.parseDouble(st.nextToken()), "N");
				}
				s = in.readLine();
				count++;
			}
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean determine(Object an_object) {
		Person person = (Person) an_object;
		FertilityProbabilityDeterminator determinator = null;
		int age = person.getAge().intValue();
		String ward = person.getWardLocation();
		try {
			if(person.getMaritalStatus().equals("Y")) {
				determinator = i_marriage[age - FERTILITY_MIN_AGE][Integer.parseInt(ward) - 1];
			} else {
				determinator = i_single[age - FERTILITY_MIN_AGE][Integer.parseInt(ward) - 1];
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(determinator == null) {
			return false;
		}
		return determinator.determine();
	}

	public class FertilityProbabilityDeterminator {
		private int i_minAge;
		private int i_maxAge;
		private String i_marritalStatus;  // M: married  S:single
		private double i_probability;
		private RandomProbabilityDeterminator i_determinator;
		private static final int PROBABILITY_UPPER_BOUND = 10000;
		public FertilityProbabilityDeterminator(int minAge, int maxAge, double probability, String status) {
			i_minAge = minAge;
			i_maxAge = maxAge;
			i_probability = probability;
			i_determinator = new RandomProbabilityDeterminator(1.0 - i_probability, PROBABILITY_UPPER_BOUND);
			i_marritalStatus = status;
		}
		
		public boolean determine() {
			return i_determinator.determine(null);
		}
		
		public String getMarritalStatus() {
			return i_marritalStatus;
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
		FertilityDeterminator determinator = new FertilityDeterminator();
		Person person = new Person();
		person.setAge(new Integer(26));
		person.setGender("F");
		person.setMaritalStatus("Y");
		int count = 0;
		for(int i=0; i<10000; i++) {
			if(determinator.determine(person)) {
				s_logger.debug(i + " fertility");
				count++;
			}
		}
		s_logger.debug("Total number of fertility persons: " + count);
	}
}
