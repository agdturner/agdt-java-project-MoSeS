package uk.ac.leeds.sog.moses.populationmodel.probability;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class FertilityProbabilityCalculator {
	private static final int AREA_NUMBER = 33;
	private static final int MIN_AGE = 15;
	private static final int MAX_AGE = 46;
	private static final int NUM_GROUPS = 8;
	
	private double[] i_fertilityProbabilitySingle;
	private double[] i_fertilityProbabilityMarriage;
	private int[] i_wardBirth;
	private int[][] i_syaFemaleWard;
	private FemaleAgeGroup[][] i_femaleAgeGroups;
	private double[][] survProbability;
	private double[][] probabilityMarriage;
	private double[][] probabilitySingle;
	private String dataDir;
	
	private static final String PATH = "document.probability.fertility";
	private static final String CODE1 = "N00DA";
	private static final String CODE2 = "00DA";
	
	private static Logger s_logger = MosesLogger.getLogger(FertilityProbabilityCalculator.class);

	public FertilityProbabilityCalculator() {
		s_logger.info("Cacalculating fertility probability");
		String separator = System.getProperty("file.separator");
		dataDir = PATH.replace('.', separator.charAt(0));
		i_fertilityProbabilitySingle = new double[MAX_AGE - MIN_AGE +1];
		i_fertilityProbabilityMarriage = new double[MAX_AGE - MIN_AGE + 1];
		i_syaFemaleWard = new int[AREA_NUMBER][MAX_AGE - MIN_AGE + 1 + 3];
		i_wardBirth = new int[AREA_NUMBER];
		i_femaleAgeGroups = new FemaleAgeGroup[AREA_NUMBER][NUM_GROUPS];
		survProbability = new double[AREA_NUMBER][MAX_AGE - MIN_AGE + 1];
		probabilityMarriage = new double[AREA_NUMBER][MAX_AGE - MIN_AGE + 1];
		probabilitySingle = new double[AREA_NUMBER][MAX_AGE - MIN_AGE + 1];
		initialise();
		setFerilityProbability();
		outputProbability();
	}
	
	private void initialise() {
		try {
			// read probability-fertility-single.csv
			BufferedReader in = new BufferedReader(new FileReader(new File(dataDir, "probability-fertility-single.csv")));
			String s = in.readLine();
			int count = 0;
			while(s !=null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				st.nextToken();
				i_fertilityProbabilitySingle[count] = Double.parseDouble(st.nextToken());
				count++;
				s = in.readLine();
			}
			in.close();
			
			// read probability-fertility-marriage.csv
			in = new BufferedReader(new FileReader(new File(dataDir, "probability-fertility-marriage.csv")));
			s = in.readLine();
			count = 0;
			while(s !=null && !s.equals("")) {
				StringTokenizer st = new StringTokenizer(s, ",");
				st.nextToken();
				i_fertilityProbabilityMarriage[count] = Double.parseDouble(st.nextToken());
				count++;
				s = in.readLine();
			}
			in.close();
			
			// read Ward Birth.csv
			in = new BufferedReader(new FileReader(new File(dataDir, "Ward Birth.csv")));
			s = in.readLine();
			count = 0;
			while(s !=null && !s.equals("")) {
				if(s != null && s.startsWith(CODE1)) {
					StringTokenizer st = new StringTokenizer(s, ",");
					st.nextToken();
					st.nextToken();
					i_wardBirth[count] = Integer.parseInt(st.nextToken());
					count++;
				}
				s = in.readLine();
			}
			in.close();
			
			// read sya female ward.csv (15 - 46)
			in = new BufferedReader(new FileReader(new File(dataDir, "sya female ward.csv")));
			s = in.readLine();
			count = 0;
			while(s !=null && !s.equals("")) {
				if(s != null && s.startsWith(CODE2)) {
					StringTokenizer st = new StringTokenizer(s, ",");
					st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken();
					st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken();
					st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken();
					
					for(int i=0; i<(MAX_AGE - MIN_AGE  +1 + 3); i++) {
						i_syaFemaleWard[count][i] = Integer.parseInt(st.nextToken());
					}
					
					count++;
				}
				s = in.readLine();
			}
			in.close();
			
			// read leedswomanmaritalcs002.csv 
			in = new BufferedReader(new FileReader(new File(dataDir, "leedswomanmaritalcs002.csv")));
			s = in.readLine();
			count = 0;
			int minAge = 16;
			int maxAge = 19;
			while(s !=null && !s.equals("")) {
				if(s != null && s.startsWith(CODE2)) {
					StringTokenizer st = new StringTokenizer(s, ",");
					String code = st.nextToken(); 
					
					st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken(); st.nextToken();
					st.nextToken(); st.nextToken();
					
					i_femaleAgeGroups[count][0] = new FemaleAgeGroup(code, 15, 15, 0, i_syaFemaleWard[count][0]);
					for(int i=1; i<NUM_GROUPS; i++) {
						st.nextToken();
						int married = Integer.parseInt(st.nextToken());
						int single = Integer.parseInt(st.nextToken());
						i_femaleAgeGroups[count][i] = new FemaleAgeGroup(code, minAge, maxAge, married, single);
						if(minAge == 16) {
							minAge += 4;
							maxAge += 5;
						} else {
							minAge += 5;
							maxAge += 5;
						}
					}
					
					minAge = 16;
					maxAge = 19;
					count++;
				}
				s = in.readLine();
			}
			in.close();
			
			// read surv probaility
			in = new BufferedReader(new FileReader(new File(dataDir, "probability-surv-female15-46.csv")));
			for(int i=0; i<(MAX_AGE - MIN_AGE + 1); i++) {
				s = in.readLine();
				if(s != null) {
					StringTokenizer st = new StringTokenizer(s, ",");
					for(int ward=0; ward<AREA_NUMBER; ward++) {
						survProbability[ward][i] = Double.parseDouble(st.nextToken());
					}
				}
			}
			in.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setFerilityProbability() {
		//step 1
		int[][] marriedSya = new int[AREA_NUMBER][MAX_AGE - MIN_AGE + 1];
		int[][] singleSya = new int[AREA_NUMBER][MAX_AGE - MIN_AGE + 1];
		for(int ward=0;ward<AREA_NUMBER; ward++) {  // ares
			for(int age=0; age<(MAX_AGE - MIN_AGE + 1); age++) {  // 15 - 46 year
				// married
				if(age == 0) {
					marriedSya[ward][age] = 0;
					singleSya[ward][age] = i_syaFemaleWard[ward][age];
				} else {
					FemaleAgeGroup group = getFemaleAgeGroup(ward, age+15);
					int temp = i_syaFemaleWard[ward][age];
					if(age == (MAX_AGE - MIN_AGE)) {
						temp = i_syaFemaleWard[ward][age] + i_syaFemaleWard[ward][age+1] + i_syaFemaleWard[ward][age+2] + i_syaFemaleWard[ward][age+3];
					}
					float valueM = (float) temp * (float) group.getNumOfMarried() / (float) group.getTotal();
					marriedSya[ward][age] = Math.round(valueM);
					float valueS = (float) temp * (float) group.getNumOfSingle() / (float) group.getTotal();
					singleSya[ward][age] = Math.round(valueS);
				}
			}
		}
		
		// step 2
		double[][] birthWardMarriage = new double[AREA_NUMBER][MAX_AGE - MIN_AGE + 1];
		double[][] birthWardSingle = new double[AREA_NUMBER][MAX_AGE - MIN_AGE + 1];
		for(int ward=0;ward<AREA_NUMBER; ward++) {  // ward
			for(int age=0; age<(MAX_AGE - MIN_AGE + 1); age++) {  // 15 - 46 year
				birthWardMarriage[ward][age] = marriedSya[ward][age] * i_fertilityProbabilityMarriage[age];
				birthWardSingle[ward][age] = singleSya[ward][age] * i_fertilityProbabilitySingle[age];
			}
		}
		
		// step 3
		double[][] probabilityMarriageWard = new double[AREA_NUMBER][MAX_AGE - MIN_AGE + 1];
		double[][] probabilitySingleWard = new double[AREA_NUMBER][MAX_AGE - MIN_AGE + 1];
		for(int ward=0;ward<AREA_NUMBER; ward++) {  // ward
			int wardBirth = i_wardBirth[ward];
			
			double total = 0.0;
			for(int age=0; age<(MAX_AGE - MIN_AGE + 1); age++) {  // 15 - 46 year
				total = total + birthWardMarriage[ward][age] + birthWardSingle[ward][age];
			}
			
			for(int age=0; age<(MAX_AGE - MIN_AGE + 1); age++) {  // 15 - 46 year
				probabilityMarriageWard[ward][age] = i_fertilityProbabilityMarriage[age] * wardBirth / total;
				probabilitySingleWard[ward][age] = i_fertilityProbabilitySingle[age] * wardBirth / total;
			}
		}
		
		// step 4
		double[][] survMarriageWard = new double[AREA_NUMBER][MAX_AGE - MIN_AGE + 1];
		double[][] survSingleWard = new double[AREA_NUMBER][MAX_AGE - MIN_AGE + 1];
		for(int ward=0;ward<AREA_NUMBER; ward++) { // ward
			for(int age=0; age<(MAX_AGE - MIN_AGE + 1); age++) {  // 15 - 46 year
				survMarriageWard[ward][age] = probabilityMarriageWard[ward][age] * Math.sqrt(survProbability[ward][age]);
				survSingleWard[ward][age] = probabilitySingleWard[ward][age] * Math.sqrt(survProbability[ward][age]);
			}
		}
		
		
		// step 5
		for(int ward=0;ward<AREA_NUMBER; ward++) { // ward
			for(int age=0; age<(MAX_AGE - MIN_AGE + 1); age++) {  // 15 - 46 year
				if(age < MAX_AGE - MIN_AGE) {
					probabilityMarriage[ward][age] = (survMarriageWard[ward][age] + survMarriageWard[ward][age +1]) / 2.0;
					probabilitySingle[ward][age] = (survSingleWard[ward][age] + survSingleWard[ward][age + 1]) / 2.0;
				} else {
					probabilityMarriage[ward][age] = survMarriageWard[ward][age] / 2.0;
					probabilitySingle[ward][age] = survSingleWard[ward][age] / 2.0;
				}
			}
		}
	}
	
	private FemaleAgeGroup getFemaleAgeGroup(int area, int age) {
		FemaleAgeGroup group = null;
		for(int i=0; i<i_femaleAgeGroups[area].length; i++) {
			FemaleAgeGroup temp = i_femaleAgeGroups[area][i];
			if(age >= temp.getMinAge() && age <= temp.getMaxAge()) {
				group = temp;
				break;
			}
		}
		return group;
	}
	
	private void outputProbability() {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(new File(dataDir, "fertility_probability_marriage.csv")));
			for(int age=0; age<(MAX_AGE - MIN_AGE + 1); age++) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(age + MIN_AGE);
				for(int ward=0; ward<AREA_NUMBER; ward++) {
					buffer.append(",");
					buffer.append(probabilityMarriage[ward][age]);
				}
				out.println(buffer.toString());
				out.flush();
			}
			out.close();
			
			out = new PrintStream(new FileOutputStream(new File(dataDir, "fertility_probability_single.csv")));
			for(int age=0; age<(MAX_AGE - MIN_AGE + 1); age++) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(age + MIN_AGE);
				for(int ward=0; ward<AREA_NUMBER; ward++) {
					buffer.append(",");
					buffer.append(probabilitySingle[ward][age]);
				}
				out.println(buffer.toString());
				out.flush();
			}
			out.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return "FertilityProbabilityCalculator";
	}
	
	public class FemaleAgeGroup {
		private String i_code;
		private int i_minAge;
		private int i_maxAge;
		private int i_numOfMarried;
		private int i_numOfSingle;
		
		public FemaleAgeGroup(String code, int minAge, int maxAge, int numOfMarried, int numOfSingle) {
			i_code = code;
			i_minAge = minAge;
			i_maxAge = maxAge;
			i_numOfMarried = numOfMarried;
			i_numOfSingle = numOfSingle;
		}
		
		public int getMinAge() {
			return i_minAge;
		}
		
		public int getMaxAge() {
			return i_maxAge;
		}
		
		public int getNumOfMarried() {
			return i_numOfMarried;
		}
		
		public int getNumOfSingle() {
			return i_numOfSingle;
		}
		
		public int getTotal() {
			return i_numOfMarried + i_numOfSingle;
		}
		
		public String getCode() {
			return i_code;
		}
	}
	
	public static void main(String args[]) {
		FertilityProbabilityCalculator calculator = new FertilityProbabilityCalculator();
		calculator.toString();
	}
	
}
