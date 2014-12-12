package uk.ac.leeds.sog.moses.populationmodel.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.populationmodel.probability.MultiValueDeterminator;
import uk.ac.leeds.sog.moses.populationmodel.probability.RandomProbabilityDeterminator;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class AgeAdjuster {
	private static Logger s_logger = MosesLogger.getLogger(AgeAdjuster.class);
	private static final int AREA_NUMBER = 33;
	private static final int MAX_AGE = 100;
	private static Map s_probability = new HashMap();
	static {
		initialise();
	}
	
	private AgeAdjuster() {
	}
	
	private static void initialise() {
		// read data
		int temp[][][] = new int[AREA_NUMBER][MAX_AGE + 1][2];
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("probability", "probability-age.csv")));
			String s = in.readLine();
			int count = 0;
			while(s !=null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				st.nextToken(); // Zone Code
				st.nextToken();  // Zone Name
				for(int age=0; age<=MAX_AGE; age++) {
					try {
						temp[count][age][0] = Integer.parseInt(st.nextToken());
						temp[count][age][1] = Integer.parseInt(st.nextToken());
					} catch(NumberFormatException ne) {
						//s_logger.error("data string: " + s);
						count--;
						break;
					}
					// i_survProbabilityMale[area][count] = new RandomProbabilityDeterminator(Double.parseDouble(value), PROBABILITY_UPPER_BOUND);
				}
				count++;
				s = in.readLine();
			}
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// calculate probability
		double probability[][][] = new double[AREA_NUMBER][MAX_AGE + 1][2];
		for(int area=0; area<AREA_NUMBER; area++) {
			for(int age=0; age<80; age++) {
				if(age % 2 == 0) {
					probability[area][age][0] = (double) temp[area][age][0] / (temp[area][age][0] + temp[area][age + 1][0]);
					StringBuffer keyBuf = new StringBuffer();
					keyBuf.append(area+1);
					keyBuf.append("M");
					keyBuf.append(age);
					// s_logger.debug("key: " + keyBuf.toString());
					s_probability.put(keyBuf.toString(), new RandomProbabilityDeterminator(probability[area][age][0], 100, true));
				} else {
					probability[area][age][0] = (double) temp[area][age][0] / (temp[area][age][0] + temp[area][age - 1][0]);
				}
				if(age % 2 == 0) {
					probability[area][age][1] = (double) temp[area][age][1] / (temp[area][age][1] + temp[area][age + 1][1]);
					StringBuffer keyBuf = new StringBuffer();
					keyBuf.append(area+1);
					keyBuf.append("F");
					keyBuf.append(age);
					// s_logger.debug("key: " + keyBuf.toString());
					s_probability.put(keyBuf.toString(), new RandomProbabilityDeterminator(probability[area][age][1], 100, true));
				} else {
					probability[area][age][1] = (double) temp[area][age][1] / (temp[area][age][1] + temp[area][age - 1][1]);
				}
			}
			
			List ageList = new ArrayList();
			List maleNumbers = new ArrayList();
			List femaleNumbers = new ArrayList();
			for(int age=80; age<=100; age++) {
				ageList.add(new Integer(age));
				maleNumbers.add(new Integer(temp[area][age][0]));
				femaleNumbers.add(new Integer(temp[area][age][1]));
			}
			MultiValueDeterminator determinatorM = new MultiValueDeterminator(ageList, maleNumbers);
			StringBuffer keyBufMale = new StringBuffer();
			keyBufMale.append(area+1);
			keyBufMale.append("M");
			s_probability.put(keyBufMale.toString(), determinatorM);
			MultiValueDeterminator determinatorF = new MultiValueDeterminator(ageList, femaleNumbers);
			StringBuffer keyBuFemale = new StringBuffer();
			keyBuFemale.append(area+1);
			keyBuFemale.append("F");
			s_probability.put(keyBuFemale.toString(), determinatorF);
		}
	}
	
	public static int getNewAge(String location, String age, String gender) {
		if(Integer.parseInt(age) >= 80) {
			StringBuffer keyBuff = new StringBuffer();
			keyBuff.append(location);
			keyBuff.append(gender);
			MultiValueDeterminator determinator = (MultiValueDeterminator) s_probability.get(keyBuff.toString());
			return determinator.getValue();
		}
		StringBuffer keyBuff = new StringBuffer();
		keyBuff.append(location);
		keyBuff.append(gender);
		if(Integer.parseInt(age) % 2 == 0) {
			keyBuff.append(Integer.parseInt(age));
		} else {
			keyBuff.append(Integer.parseInt(age) - 1);
		}
		RandomProbabilityDeterminator determinator = (RandomProbabilityDeterminator) s_probability.get(keyBuff.toString());
		if(determinator == null) {
			StringBuffer log = new StringBuffer();
			log.append("location=" + location);
			log.append(" age=" + age);
			log.append(" gender=" + gender);
			s_logger.error("data error: " + log.toString());
			return Integer.parseInt(age);
		}
		if(determinator.determine(null)) {
			return Integer.parseInt(age);
		} else {
			return Integer.parseInt(age) + 1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialise();
		String location = "1";
		String age = "80";
		String gender = "M";
		int count = 0;
		for(int i=0; i<340; i++) {
			int newAge = getNewAge(location, age, gender);
			s_logger.info("new age: " + newAge);
			if(newAge == 83) {
				count++;
			}
		}
		s_logger.info("Number of 83 persons: " + count);
	}

}
