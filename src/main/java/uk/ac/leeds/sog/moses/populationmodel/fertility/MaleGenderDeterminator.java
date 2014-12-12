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

public class MaleGenderDeterminator implements Determinator {
	private List i_fertilityDeterminators;
	private static Logger s_logger = MosesLogger.getLogger(FertilityDeterminator.class);
			
	public MaleGenderDeterminator() {
		s_logger.info("Constructing MaleGenderDeterminator");
		i_fertilityDeterminators = new ArrayList();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("probability", "probability-gender-male.csv")));
			String s = in.readLine();
			while(s != null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				double probability = Double.parseDouble(st.nextToken());
				String maritalStatus = st.nextToken();
				i_fertilityDeterminators.add(new GenderProbabilityDeterminator(probability, maritalStatus));
				s = in.readLine();
			}
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean determine(Object an_object) {
		Person person = (Person) an_object;
		GenderProbabilityDeterminator determinator = null;
		for(int i=0; i<i_fertilityDeterminators.size(); i++) {
			GenderProbabilityDeterminator deter = (GenderProbabilityDeterminator) i_fertilityDeterminators.get(i);
			if(deter.getMarritalStatus().equals(person.getMaritalStatus())) {
				determinator = deter;
				break;
			}
		}
		if(determinator == null) {
			return false;
		}
		return determinator.determine();
	}

	public class GenderProbabilityDeterminator {
		private String i_marritalStatus;  // M: married  S:single
		private double i_probability;
		private RandomProbabilityDeterminator i_determinator;
		private static final int PROBABILITY_UPPER_BOUND = 10000;
		public GenderProbabilityDeterminator(double probability, String status) {
			i_probability = probability;
			i_determinator = new RandomProbabilityDeterminator(i_probability, PROBABILITY_UPPER_BOUND, true);
			i_marritalStatus = status;
		}
		
		public boolean determine() {
			return i_determinator.determine(null);
		}
		
		public String getMarritalStatus() {
			return i_marritalStatus;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaleGenderDeterminator determinator = new MaleGenderDeterminator();
		Person person = new Person();
		person.setMaritalStatus("Y");
		int count = 0;
		for(int i=0; i<10000; i++) {
			if(determinator.determine(person)) {
				s_logger.debug(i + " male");
				count++;
			} else {
				s_logger.debug(i + " female");
			}
		}
		s_logger.debug("Total number of born males: " + count);
	}
}
