package uk.ac.leeds.sog.moses.populationmodel.mortality;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.probability.Determinator;
import uk.ac.leeds.sog.moses.populationmodel.probability.RandomProbabilityDeterminator;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class MortalityDeterminator implements Determinator {

	private static final int AREA_NUMBER = 33;
	private static final int MAX_AGE = 100;
	private static final int PROBABILITY_UPPER_BOUND = 10000;
	private RandomProbabilityDeterminator[][] i_survProbabilityMale;
	private RandomProbabilityDeterminator[][] i_survProbabilityFemale;
	
	private static Logger s_logger = MosesLogger.getLogger(MortalityDeterminator.class);
	
	public MortalityDeterminator() {
		s_logger.info("Constructing MortalityDeterminator");
		i_survProbabilityMale = new RandomProbabilityDeterminator[AREA_NUMBER][MAX_AGE + 1];
		i_survProbabilityFemale = new RandomProbabilityDeterminator[AREA_NUMBER][MAX_AGE + 1];
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("probability", "probability-surv-male.csv")));
			String s = in.readLine();
			int count = 0;
			while(s !=null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				if(st.countTokens() != AREA_NUMBER) {
					s_logger.error("number of data in each row must be 101: " + st.countTokens());
					System.exit(1);
				}
				for(int area=0; area<AREA_NUMBER; area++) {
					String value = st.nextToken();
					double doubleValue = Double.parseDouble(value);
					i_survProbabilityMale[area][count] = new RandomProbabilityDeterminator(doubleValue, PROBABILITY_UPPER_BOUND);
				}
				count++;
				s = in.readLine();
			}
			in.close();
			
			in = new BufferedReader(new FileReader(new File("probability", "probability-surv-female.csv")));
			s = in.readLine();
			count = 0;
			while(s !=null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				if(st.countTokens() != AREA_NUMBER) {
					s_logger.error("number of data in each row must be 101: " + st.countTokens());
					System.exit(1);
				}
				
				for(int area=0; area<AREA_NUMBER; area++) {
					String value = st.nextToken();
					double doubleValue = Double.parseDouble(value);
					i_survProbabilityFemale[area][count] = new RandomProbabilityDeterminator(doubleValue, PROBABILITY_UPPER_BOUND);
				}
				count++;
				s = in.readLine();
			}
			
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean determine(Object an_object) {
		Person person = (Person) an_object;
		int areaNum = Integer.parseInt(person.getWardLocation());
		int age = person.getAge().intValue();
		if(age >= 100) {
			age = 100;
		}
		RandomProbabilityDeterminator determinator = null;
		if(person.getGender().equals("M")) {
			determinator = i_survProbabilityMale[areaNum - 1][age];
		} else if(person.getGender().equals("F")) {
			determinator = i_survProbabilityFemale[areaNum - 1][age];
		} else {
			s_logger.error("gender data is wrong: " + person.getGender());
			System.exit(1);
		}
		
		if(s_logger.isDebugEnabled()) {
			s_logger.info("probability: " + determinator.getProbability());
		}
		
		return determinator.determine(an_object);
	}
	
	public static void main(String args[]) {
		MortalityDeterminator determinator = new MortalityDeterminator();
		Person person = new Person();
		person.setAge(new Integer(1));
		person.setGender("M");
		person.setWardLocation("1");
		int count = 0;
		for(int i=0; i<10000; i++) {
			if(determinator.determine(person)) {
				s_logger.error(i + " die");
				count++;
			}
		}
		s_logger.error("Total number of dead persons: " + count);
	}
	
	
}
