package uk.ac.leeds.sog.moses.populationmodel.probability;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class MortalityProbabilityCalculator {
	private static final int AREA_NUMBER = 33;
	private static final int AGE_MAX = 100;
	
	private int[][] i_malepop;
	private int[][] i_femalepop;
	
	private List i_maleAgeMortalityMapList;
	private List i_femaleAgeMortalityMapList;
	
	private List i_maleMortalityRate;
	private List i_femaleMortalityRate;
	
	private double[][] i_probabilityMale;
	private double[][] i_probabilityFemale;
	private String[] i_areaCodes;
	private String[] i_areaNames;
	
	private double[][] i_survProbabilityMale;
	private double[][] i_survProbabilityFemale;
	
	private static Logger s_logger = MosesLogger.getLogger(MortalityProbabilityCalculator.class);

	public MortalityProbabilityCalculator() {
		i_malepop = new int[AREA_NUMBER][AGE_MAX + 1];
		i_femalepop = new int[AREA_NUMBER][AGE_MAX + 1];
		i_maleAgeMortalityMapList = new ArrayList();
		i_femaleAgeMortalityMapList = new ArrayList();
		i_maleMortalityRate = new ArrayList();
		i_femaleMortalityRate = new ArrayList();
		i_probabilityMale = new double[AREA_NUMBER][AGE_MAX + 1];
		i_probabilityFemale = new double[AREA_NUMBER][AGE_MAX + 1];
		i_survProbabilityMale = new double[AREA_NUMBER][AGE_MAX + 1];
		i_survProbabilityFemale = new double[AREA_NUMBER][AGE_MAX + 1];
		i_areaCodes = new String[AREA_NUMBER];
		i_areaNames = new String[AREA_NUMBER];
		initialise();
		setMortalityProbability();
		setSurvProbability();
		outputProbability();
	}
	
	private void initialise() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("probability", "leedspop-male.csv")));
			String s = in.readLine();
			int countArea = 0;
			while(s !=null && !s.equals("")) {
				// s_logger.debug("data: " + s);
				StringTokenizer st = new StringTokenizer(s, ",");
				if(st.countTokens() != 103) {
					s_logger.error("number of data in each row must be 101: " + st.countTokens());
					System.exit(1);
				}
				int countAge = 0;
				i_areaCodes[countArea] = st.nextToken();
				i_areaNames[countArea] = st.nextToken();
				while(st.hasMoreTokens()) {
					String value = st.nextToken();
					i_malepop[countArea][countAge] = Integer.parseInt(value);
					countAge++;
				}
				countArea++;
				s = in.readLine();
			}
			in.close();
			
			in = new BufferedReader(new FileReader(new File("probability", "leedspop-female.csv")));
			s = in.readLine();
			countArea = 0;
			while(s !=null && !s.equals("")) {
				// s_logger.debug("data: " + s);
				StringTokenizer st = new StringTokenizer(s, ",");
				if(st.countTokens() != 103) {
					s_logger.error("number of data in each row must be 101: " + st.countTokens());
					System.exit(1);
				}
				int countAge = 0;
				i_areaCodes[countArea] = st.nextToken();
				i_areaNames[countArea] = st.nextToken();
				while(st.hasMoreTokens()) {
					String value = st.nextToken();
					i_femalepop[countArea][countAge] = Integer.parseInt(value);
					countAge++;
				}
				countArea++;
				s = in.readLine();
			}
			in.close();
			
			in = new BufferedReader(new FileReader(new File("probability", "maleagemortality.csv")));
			s = in.readLine();
			while(s !=null && !s.equals("")) {
				// s_logger.debug("data: " + s);
				StringTokenizer st = new StringTokenizer(s, ",");
				if(st.countTokens() != 14) {
					s_logger.error("number of data in each row must be 14: " + st.countTokens());
					System.exit(1);
				}
				String areaName = st.nextToken();
				String areaCode = st.nextToken();
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 0, 0, Integer.parseInt(st.nextToken())));
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 1, 4, Integer.parseInt(st.nextToken())));
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 5, 14, Integer.parseInt(st.nextToken())));
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 15, 24, Integer.parseInt(st.nextToken())));
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 25, 34, Integer.parseInt(st.nextToken())));
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 35, 44, Integer.parseInt(st.nextToken())));
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 45, 54, Integer.parseInt(st.nextToken())));
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 55, 64, Integer.parseInt(st.nextToken())));
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 65, 74, Integer.parseInt(st.nextToken())));
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 75, 84, Integer.parseInt(st.nextToken())));
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 85, 89, Integer.parseInt(st.nextToken())));
				i_maleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 90, 100, Integer.parseInt(st.nextToken())));
				s = in.readLine();
			}
			in.close();
			
			in = new BufferedReader(new FileReader(new File("probability", "femaleagemortality.csv")));
			s = in.readLine();
			while(s !=null && !s.equals("")) {
				// s_logger.debug("data: " + s);
				StringTokenizer st = new StringTokenizer(s, ",");
				if(st.countTokens() != 14) {
					s_logger.error("number of data in each row must be 14: " + st.countTokens());
					System.exit(1);
				}
				String areaName = st.nextToken();
				String areaCode = st.nextToken();
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 0, 0, Integer.parseInt(st.nextToken())));
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 1, 4, Integer.parseInt(st.nextToken())));
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 5, 14, Integer.parseInt(st.nextToken())));
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 15, 24, Integer.parseInt(st.nextToken())));
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 25, 34, Integer.parseInt(st.nextToken())));
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 35, 44, Integer.parseInt(st.nextToken())));
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 45, 54, Integer.parseInt(st.nextToken())));
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 55, 64, Integer.parseInt(st.nextToken())));
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 65, 74, Integer.parseInt(st.nextToken())));
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 75, 84, Integer.parseInt(st.nextToken())));
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 85, 89, Integer.parseInt(st.nextToken())));
				i_femaleAgeMortalityMapList.add(new AgeMortalityMap(areaName, areaCode, 90, 100, Integer.parseInt(st.nextToken())));
				s = in.readLine();
			}
			in.close();
			
			in = new BufferedReader(new FileReader(new File("probability", "malemortalityrate.csv")));
			s = in.readLine();
			while(s !=null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s);
				if(st.countTokens() != 1) {
					s_logger.error("number of data in each row must be 1: " + st.countTokens());
					System.exit(1);
				}
				String value = st.nextToken();
				i_maleMortalityRate.add(new Double(value));
				s = in.readLine();
			}
			in.close();
			
			in = new BufferedReader(new FileReader(new File("probability", "femalemortalityrate.csv")));
			s = in.readLine();
			while(s !=null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s);
				if(st.countTokens() != 1) {
					s_logger.error("number of data in each row must be 1: " + st.countTokens());
					System.exit(1);
				}
				String value = st.nextToken();
				i_femaleMortalityRate.add(new Double(value));
				s = in.readLine();
			}
			in.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setMortalityProbability() {
		for(int area=0; area<AREA_NUMBER; area++) {
			for(int age=0; age<101; age++) {
				i_probabilityMale[area][age] = calculate(age, area, i_areaCodes[area], "M");
				i_probabilityFemale[area][age] = calculate(age, area, i_areaCodes[area], "F");
			}
		}
	}
	
	private double calculate(int an_age, int an_area, String areaCode, String a_gender) {
		int minAge = 0;
		int maxAge = 0;
		int numberOfMortality = 0;
		
		List ageMortalityMapList;
		if(a_gender.equalsIgnoreCase("M")) {
			ageMortalityMapList = i_maleAgeMortalityMapList;
		} else {
			ageMortalityMapList = i_femaleAgeMortalityMapList;
		}
		
		for(int i=0; i<ageMortalityMapList.size(); i++) {
			AgeMortalityMap map = (AgeMortalityMap) ageMortalityMapList.get(i);
			String code = map.getAreaCode();
			if(code.equalsIgnoreCase(areaCode) && an_age >= map.getMinAge() && an_age <= map.getMaxAge()) {
				minAge = map.getMinAge();
				maxAge = map.getMaxAge();
				numberOfMortality = map.getNumOfMortalitys();
				break;
			}
		}
		
		Double mortalityRateAtAge= null;
		if(a_gender.equalsIgnoreCase("M")) {
			mortalityRateAtAge = (Double) i_maleMortalityRate.get(an_age);
		} else {
			mortalityRateAtAge = (Double) i_maleMortalityRate.get(an_age);
		}
		
		double sum = 0.0;
		for(int age=minAge; age<= maxAge; age++) {
			int population = 0;
			Double mortalityrate = null;
			if(a_gender.equalsIgnoreCase("M")) {
				population = i_malepop[an_area][age];
				mortalityrate = (Double) i_maleMortalityRate.get(age);
			} else {
				population = i_femalepop[an_area][age];
				mortalityrate = (Double) i_femaleMortalityRate.get(age);
			}
			sum += population*mortalityrate.doubleValue();
		}
		
		double value = mortalityRateAtAge.doubleValue() * (numberOfMortality / 3.0) / sum;
		
		return value;
	}
	
	private void setSurvProbability() {
		// i_probabilityMale = new double[AREA_NUMBER][AGE_MAX + 1];
		for(int area=0; area<AREA_NUMBER; area++) {
			i_survProbabilityMale[area][0] = 1.0*(1.0-(1.0-getFraction(0))*(1.0*i_probabilityMale[area][0])
					/(1.0+1.0*i_probabilityMale[area][0]*(1.0-getFraction(0))));
			i_survProbabilityFemale[area][0] = 1.0*(1.0-(1.0-getFraction(0))*(1.0*i_probabilityFemale[area][0])
					/(1.0+1.0*i_probabilityFemale[area][0]*(1.0-getFraction(0))));
		}
		
		for(int area=0; area<AREA_NUMBER; area++) {
			// male
			double F106 = 1.0 * 3.3 * (1.0 - 1.0 * i_probabilityMale[area][99] * 0.5);
			double F107 = 1.0 * (1.0 - getFraction(99)) * (1.0 + i_probabilityMale[area][99] * getFraction(99) * 
					(1.0 - 1.0)) + getFraction(99);
			i_survProbabilityMale[area][100] = F106/(F106 + F107);
			
			F106 = 1.0 * getFraction(100) * (1.0 - 1.0 * i_probabilityFemale[area][99] * getFraction(99));
			F107 = 1.0 * (1.0 - getFraction(99)) * (1.0 + i_probabilityFemale[area][99] * getFraction(99) * 
					(1.0 - 1.0)) + getFraction(99);
			i_survProbabilityFemale[area][100] = F106/(F106 + F107);
		}
		
		for(int area=0; area<AREA_NUMBER; area++) {
			for(int age=1; age<=99; age++) {
				i_survProbabilityMale[area][age] = 1.0 * (1.0 - 1.0*getFraction(age-1)*i_probabilityMale[area][age-1])/
				                                   (1.0*(1.0 + 1.0*i_probabilityMale[area][age]*(1.0 - getFraction(age))));
				i_survProbabilityFemale[area][age] = 1.0 * (1.0 - 1.0*getFraction(age-1)*i_probabilityFemale[area][age-1])/
                                                   (1.0*(1.0 + 1.0*i_probabilityFemale[area][age]*(1.0 - getFraction(age))));
			}
		}
		
		
	}
	
	private void outputProbability() {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(new File("probability", "probability-mortality-male.csv")));
			for(int age=0; age<=AGE_MAX; age++) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(i_probabilityMale[0][age]);
				for(int area=1; area<AREA_NUMBER; area++) {
					buffer.append(",");
					buffer.append(i_probabilityMale[area][age]);
				}
				out.println(buffer.toString());
				out.flush();
			}
			out.close();
			
			out = new PrintStream(new FileOutputStream(new File("probability", "probability-mortality-female.csv")));
			for(int age=0; age<=AGE_MAX; age++) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(i_probabilityFemale[0][age]);
				for(int area=1; area<AREA_NUMBER; area++) {
					buffer.append(",");
					buffer.append(i_probabilityFemale[area][age]);
				}
				out.println(buffer.toString());
				out.flush();
			}
			out.close();
			
			out = new PrintStream(new FileOutputStream(new File("probability", "probability-surv-male.csv")));
			for(int age=0; age<=AGE_MAX; age++) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(i_survProbabilityMale[0][age]);
				for(int area=1; area<AREA_NUMBER; area++) {
					buffer.append(",");
					buffer.append(i_survProbabilityMale[area][age]);
				}
				out.println(buffer.toString());
				out.flush();
			}
			out.close();
			
			out = new PrintStream(new FileOutputStream(new File("probability", "probability-surv-female.csv")));
			for(int age=0; age<=AGE_MAX; age++) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(i_survProbabilityFemale[0][age]);
				for(int area=1; area<AREA_NUMBER; area++) {
					buffer.append(",");
					buffer.append(i_survProbabilityFemale[area][age]);
				}
				out.println(buffer.toString());
				out.flush();
			}
			out.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private double getFraction(int age) {
		if(age == 0) {
			return 0.1;
		} else if(age >= 100) {
			return 3.3;
		} else {
			return 0.5;
		}
	}
	
	public class AgeMortalityMap {
		private String i_areaName;
		private String i_areaCode;
		private int i_minAge;
		private int i_maxAge;
		private int i_numOfMortalitys; // 2000-2002
		
		public AgeMortalityMap(String areaName, String areaCode, int minAge, int maxAge, int deathNum) {
			i_areaName = areaName;
			i_areaCode = areaCode;
			i_minAge = minAge;
			i_maxAge = maxAge;
			i_numOfMortalitys = deathNum;
		}
		
		public int getMinAge() {
			return i_minAge;
		}
		
		public void setMinAge(int age) {
			i_minAge = age;
		}
		
		public int getMaxAge() {
			return i_maxAge;
		}
		
		public void setMaxAge(int age) {
			i_maxAge = age;
		}
		
		public int getNumOfMortalitys() {
			return i_numOfMortalitys;
		}
		
		public void setNumOfMortalitys(int num) {
			i_numOfMortalitys = num;
		}
		
		public String getAreaName() {
			return i_areaName;
		}
		
		public String getAreaCode() {
			return i_areaCode;
		}
	}
	
	public String toString() {
		return "MortalityProbabilityCalculator";
	}
	
	public static void main(String args[]) {
		MortalityProbabilityCalculator calculator = new MortalityProbabilityCalculator();
		calculator.toString();
	}
	
}
