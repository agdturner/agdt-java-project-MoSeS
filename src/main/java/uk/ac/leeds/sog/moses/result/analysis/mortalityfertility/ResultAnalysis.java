package uk.ac.leeds.sog.moses.result.analysis.mortalityfertility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ResultAnalysis {
	private static final String SRC_LOCATION = "src";
	private static final String PATH = "uk.ac.leeds.sog.moses.result.analysis.mortalityfertility";
	
	private static final int NUM_OF_LOCATIONS = 33;
	private static final int MAX_OF_AGE = 100;
	
	private static final int STRAT_YEAR = 2001;
	private static final int END_YEAR  = 2003;
	
	private static String CURRDIR = null;
	static {
		String separator = System.getProperty("file.separator");
		String temp = new String(SRC_LOCATION + separator + PATH);
		CURRDIR = temp.replace('.', separator.charAt(0));
	}
	
	private static final String output_file_prefix = "output_ward";
	
	private List simResults = null;
	
	int[] wardTotalStartPopulation = new int[3];
	int[] wardTotalEndPopulation = new int[3];
	int[] wardTotalDeaths = new int[3];
	int[] wardTotalBirths = new int[3];
	
	public ResultAnalysis() {
		simResults = new ArrayList();
		for(int i=STRAT_YEAR; i<=END_YEAR; i++) {
			simResults.add(new SimulationYear(Integer.toString(i)));
		}
	}
	
	public void analyze() {
		try {
			for(int i=1; i<=33; i++) {  // 1 - 33
				for(int k=0; k<3; k++) {
					 wardTotalStartPopulation[k] = 0;
					 wardTotalEndPopulation[k] = 0;
					 wardTotalDeaths[k] = 0;
					 wardTotalBirths[k] = 0;
				}
				
				String outputFile = output_file_prefix + Integer.toString(i) + ".csv";
				PrintStream out = new PrintStream(new FileOutputStream(new File(CURRDIR, outputFile)));
				
				outputMale(i, out);
				
				out.println();
				out.println();
				out.println();
				
				outputFemale(i, out);
				
				out.println();
				out.println();
				out.println();
				
				outputWard(i, out);
				
				out.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private void outputMale(int ward, PrintStream out) {
		SimulationYear sim2001 = (SimulationYear) simResults.get(0);
		SimulationYear sim2002 = (SimulationYear) simResults.get(1);
		SimulationYear sim2003 = (SimulationYear) simResults.get(2);
		out.println("Male");
		out.print("Age,Start Population(2001),Deaths(2001),Births(2001),End Population(2001)");
		out.print(",,Age,Start Population(2002),Deaths(2002),Births(2002),End Population(2002)");
		out.print(",,Age,Start Population(2003),Deaths(2003),Births(2003),End Population(2003)");
		out.println();
		int[] totalStartPopulation = new int[3];
		int[] totalEndPopulation = new int[3];
		int[] totalDeaths = new int[3];
		int[] totalBirths = new int[3];
		for(int i=0; i<3; i++) {
			totalStartPopulation[i] = 0;
			totalEndPopulation[i] = 0;
			totalDeaths[i] = 0;
			totalBirths[i] = 0;
		}
		for(int i=0; i<=MAX_OF_AGE; i++) {
			StringBuffer buffer = new StringBuffer();
			
			// 2001
			int[][] numberOfMales = sim2001.getMales();
			int startPopulation = numberOfMales[ward-1][i];
			int deaths = sim2001.getMortality(0, ward-1, i);
			int births = 0;
			buffer.append(i);
			buffer.append(",");
			buffer.append(startPopulation);
			buffer.append(",");
			buffer.append(deaths);
			buffer.append(",0,");
			buffer.append(startPopulation - deaths + births);
			totalStartPopulation[0] += startPopulation;
			totalDeaths[0] += deaths;
			totalBirths[0] += births;
			totalEndPopulation[0] += (startPopulation - deaths + births);
			
			// 2002
			numberOfMales = sim2002.getMales();
			startPopulation = numberOfMales[ward-1][i];
			deaths = sim2002.getMortality(0, ward-1, i);
			births = 0;
			buffer.append(",,");
			buffer.append(i);
			buffer.append(",");
			buffer.append(startPopulation);
			buffer.append(",");
			buffer.append(deaths);
			buffer.append(",0,");
			buffer.append(startPopulation - deaths + births);
			totalStartPopulation[1] += startPopulation;
			totalDeaths[1] += deaths;
			totalBirths[1] += births;
			totalEndPopulation[1] += (startPopulation - deaths + births);
			
			// 2003
			numberOfMales = sim2003.getMales();
			startPopulation = numberOfMales[ward-1][i];
			deaths = sim2003.getMortality(0, ward-1, i);
			births = 0;
			buffer.append(",,");
			buffer.append(i);
			buffer.append(",");
			buffer.append(startPopulation);
			buffer.append(",");
			buffer.append(deaths);
			buffer.append(",0,");
			buffer.append(startPopulation - deaths + births);
			totalStartPopulation[2] += startPopulation;
			totalDeaths[2] += deaths;
			totalBirths[2] += births;
			totalEndPopulation[2] += (startPopulation - deaths + births);
			
			out.println(buffer.toString());
		}
		out.print("Male Total,");
		out.print(totalStartPopulation[0] + ",");
		out.print(totalDeaths[0] + ",");
		out.print(totalBirths[0] + ",");
		out.print(totalEndPopulation[0] + ",");
		out.print(",");
		out.print("Male Total,");
		out.print(totalStartPopulation[1] + ",");
		out.print(totalDeaths[1] + ",");
		out.print(totalBirths[1] + ",");
		out.print(totalEndPopulation[1] + ",");
		out.print(",");
		out.print("Male Total,");
		out.print(totalStartPopulation[2] + ",");
		out.print(totalDeaths[2] + ",");
		out.print(totalBirths[2] + ",");
		out.print(totalEndPopulation[2] + ",");
		out.println();
		
		wardTotalStartPopulation[0] += totalStartPopulation[0];
		wardTotalStartPopulation[1] += totalStartPopulation[1];
		wardTotalStartPopulation[2] += totalStartPopulation[2];
		
		wardTotalEndPopulation[0] += totalEndPopulation[0];
		wardTotalEndPopulation[1] += totalEndPopulation[1];
		wardTotalEndPopulation[2] += totalEndPopulation[2];
		
		wardTotalDeaths[0] += totalDeaths[0];
		wardTotalDeaths[1] += totalDeaths[1];
		wardTotalDeaths[2] += totalDeaths[2];
		
		wardTotalBirths[0] += totalBirths[0];
		wardTotalBirths[1] += totalBirths[1];
		wardTotalBirths[2] += totalBirths[2];
	}
	
	private void outputFemale(int ward, PrintStream out) {
		SimulationYear sim2001 = (SimulationYear) simResults.get(0);
		SimulationYear sim2002 = (SimulationYear) simResults.get(1);
		SimulationYear sim2003 = (SimulationYear) simResults.get(2);
		out.println("Female");
		out.print("Age,Start Population(2001),Deaths(2001),Births(2001),End Population(2001)");
		out.print(",,Age,Start Population(2002),Deaths(2002),Births(2002),End Population(2002)");
		out.print(",,Age,Start Population(2003),Deaths(2003),Births(2003),End Population(2003)");
		out.println();
		int[] totalStartPopulation = new int[3];
		int[] totalEndPopulation = new int[3];
		int[] totalDeaths = new int[3];
		int[] totalBirths = new int[3];
		for(int i=0; i<3; i++) {
			totalStartPopulation[i] = 0;
			totalEndPopulation[i] = 0;
			totalDeaths[i] = 0;
			totalBirths[i] = 0;
		}
		for(int i=0; i<=MAX_OF_AGE; i++) {
			StringBuffer buffer = new StringBuffer();
			
			// 2001
			int[][] numberOfFemales = sim2001.getFemales();
			int startPopulation = numberOfFemales[ward-1][i];
			int deaths = sim2001.getMortality(1, ward-1, i);
			int births = sim2001.getFertility(ward-1, i);
			buffer.append(i);
			buffer.append(",");
			buffer.append(startPopulation);
			buffer.append(",");
			buffer.append(deaths);
			buffer.append(",");
			buffer.append(births);
			buffer.append(",");
			buffer.append(startPopulation - deaths + births);
			totalStartPopulation[0] += startPopulation;
			totalDeaths[0] += deaths;
			totalBirths[0] += births;
			totalEndPopulation[0] += (startPopulation - deaths + births);
			
			//2002
			numberOfFemales = sim2002.getFemales();
			startPopulation = numberOfFemales[ward-1][i];
			deaths = sim2002.getMortality(1, ward-1, i);
			births = sim2002.getFertility(ward-1, i);
			buffer.append(",,");
			buffer.append(i);
			buffer.append(",");
			buffer.append(startPopulation);
			buffer.append(",");
			buffer.append(deaths);
			buffer.append(",");
			buffer.append(births);
			buffer.append(",");
			buffer.append(startPopulation - deaths + births);
			totalStartPopulation[1] += startPopulation;
			totalDeaths[1] += deaths;
			totalBirths[1] += births;
			totalEndPopulation[1] += (startPopulation - deaths + births);
			
			//2003
			numberOfFemales = sim2003.getFemales();
			startPopulation = numberOfFemales[ward-1][i];
			deaths = sim2003.getMortality(1, ward-1, i);
			births = sim2003.getFertility(ward-1, i);
			buffer.append(",,");
			buffer.append(i);
			buffer.append(",");
			buffer.append(startPopulation);
			buffer.append(",");
			buffer.append(deaths);
			buffer.append(",");
			buffer.append(births);
			buffer.append(",");
			buffer.append(startPopulation - deaths + births);
			totalStartPopulation[2] += startPopulation;
			totalDeaths[2] += deaths;
			totalBirths[2] += births;
			totalEndPopulation[2] += (startPopulation - deaths + births);
			
			out.println(buffer.toString());
		}
		out.print("Female Total,");
		out.print(totalStartPopulation[0] + ",");
		out.print(totalDeaths[0] + ",");
		out.print(totalBirths[0] + ",");
		out.print(totalEndPopulation[0] + ",");
		out.print(",");
		out.print("Female Total,");
		out.print(totalStartPopulation[1] + ",");
		out.print(totalDeaths[1] + ",");
		out.print(totalBirths[1] + ",");
		out.print(totalEndPopulation[1] + ",");
		out.print(",");
		out.print("Female Total,");
		out.print(totalStartPopulation[2] + ",");
		out.print(totalDeaths[2] + ",");
		out.print(totalBirths[2] + ",");
		out.print(totalEndPopulation[2] + ",");
		out.println();
		
		wardTotalStartPopulation[0] += totalStartPopulation[0];
		wardTotalStartPopulation[1] += totalStartPopulation[1];
		wardTotalStartPopulation[2] += totalStartPopulation[2];
		
		wardTotalEndPopulation[0] += totalEndPopulation[0];
		wardTotalEndPopulation[1] += totalEndPopulation[1];
		wardTotalEndPopulation[2] += totalEndPopulation[2];
		
		wardTotalDeaths[0] += totalDeaths[0];
		wardTotalDeaths[1] += totalDeaths[1];
		wardTotalDeaths[2] += totalDeaths[2];
		
		wardTotalBirths[0] += totalBirths[0];
		wardTotalBirths[1] += totalBirths[1];
		wardTotalBirths[2] += totalBirths[2];
	}
	
	private void outputWard(int ward, PrintStream out) {
		out.print("Ward Total,");
		out.print(wardTotalStartPopulation[0] + ",");
		out.print(wardTotalDeaths[0] + ",");
		out.print(wardTotalBirths[0] + ",");
		out.print(wardTotalEndPopulation[0] + ",");
		out.print(",");
		out.print("Ward Total,");
		out.print(wardTotalStartPopulation[1] + ",");
		out.print(wardTotalDeaths[1] + ",");
		out.print(wardTotalBirths[1] + ",");
		out.print(wardTotalEndPopulation[1] + ",");
		out.print(",");
		out.print("Ward Total,");
		out.print(wardTotalStartPopulation[2] + ",");
		out.print(wardTotalDeaths[2] + ",");
		out.print(wardTotalBirths[2] + ",");
		out.print(wardTotalEndPopulation[2] + ",");
		out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ResultAnalysis analysis = new ResultAnalysis();
		analysis.analyze();
	}
	
	private static class SimulationYear {
		private String year;
		
		// start population
		private int[][] number_of_males;
		private int[][] number_of_females;
		
		// mortality[gender][location][age]
		private int[][][] mortality;  //0:male, 1:female
	    private static String MORTALITY_PATH;
		static {
			MORTALITY_PATH = "uk.ac.leeds.sog.moses.result.analysis.mortalityfertility.simuYear.mortality";
			String separator = System.getProperty("file.separator");
			String temp = new String(SRC_LOCATION + separator + MORTALITY_PATH);
			MORTALITY_PATH = temp.replace('.', separator.charAt(0));
		}
		
		// fertility
		// ferility[gender][location][age][mother_marital_status] 0:male, 1:female; 0:mother_marital_status(N), 1: mother_marital_status(Y)
		private int[][][][] fertility;
	    private static String FERTILITY_PATH;
		static {
			FERTILITY_PATH = "uk.ac.leeds.sog.moses.result.analysis.mortalityfertility.simuYear.fertility";
			String separator = System.getProperty("file.separator");
			String temp = new String(SRC_LOCATION + separator + FERTILITY_PATH);
			FERTILITY_PATH = temp.replace('.', separator.charAt(0));
		}
		
		public SimulationYear(String a_year) {
			year = a_year;
			number_of_males = new int[NUM_OF_LOCATIONS][MAX_OF_AGE + 1];
			number_of_females = new int[NUM_OF_LOCATIONS][MAX_OF_AGE + 1];
			setPopulation("population_default_" + year + ".csv");
			
			mortality = new int[2][NUM_OF_LOCATIONS][MAX_OF_AGE + 1];
			for(int i=0; i<=1; i++)
				for(int j=0; j<NUM_OF_LOCATIONS; j++) 
					for(int k=0; k<=MAX_OF_AGE; k++)
						mortality[i][j][k] = 0;
			setMortality("mortality" + year + ".csv");
			
			fertility = new int[2][NUM_OF_LOCATIONS][MAX_OF_AGE + 1][2];
			for(int i=0; i<=1; i++)
				for(int j=0; j<NUM_OF_LOCATIONS; j++) 
					for(int k=0; k<=MAX_OF_AGE; k++)
						for(int l=0; l<=1; l++)
						fertility[i][j][k][l] = 0;
			setFertility("fertility" + year + ".csv");
		}
		
		public int[][] getMales() {
			return number_of_males;
		}
		
		public int[][] getFemales() {
			return number_of_females;
		}
		
		public int getMortality(int gender, int ward, int age) {
			return mortality[gender][ward][age];
		}
		
		public int getFertility(int ward, int motherAge) {
			// ferility[gender][location][age][mother_marital_status]
			return fertility[0][ward][motherAge][0] + fertility[0][ward][motherAge][1] + 
			       fertility[1][ward][motherAge][0] + fertility[1][ward][motherAge][1];
		}
		
		private void setPopulation(String filename) {
			try {
				String gender = "";
				BufferedReader in = new BufferedReader(new FileReader(new File(CURRDIR, filename)));
				int age = 0;
				String s = in.readLine();
				while(s !=null && !s.equals("")) {
					if(s.startsWith("Male")) {
						gender = "Male";
						age = 0;
					} else if(s.startsWith("Female")) {
						gender = "Female";
						age = 0;
					}
					
					if(s.startsWith("Year")) {
						StringTokenizer st1 = new StringTokenizer(s, ",");
						
						st1.nextToken();
						
						if(gender.equals("Male")) {
							for(int i=0; i<NUM_OF_LOCATIONS; i++) {
								number_of_males[i][age] = Integer.parseInt(st1.nextToken());
							}
							age++;
						} else if(gender.equals("Female")) {
							for(int i=0; i<NUM_OF_LOCATIONS; i++) {
								number_of_females[i][age] = Integer.parseInt(st1.nextToken());
							}
							age++;
						}
					}
					s = in.readLine();
				}
				
			} catch(IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		private void setMortality(String filename) {
			try {
				BufferedReader in = new BufferedReader(new FileReader(new File(MORTALITY_PATH, filename)));
				String s = in.readLine();
				while(s !=null && !s.equals("")) {
					StringTokenizer st1 = new StringTokenizer(s, ",");
					
					st1.nextToken();
					
					StringTokenizer ageToken = new StringTokenizer(st1.nextToken(), "=");
					StringTokenizer genderToken = new StringTokenizer(st1.nextToken(), "=");
					StringTokenizer wardToken = new StringTokenizer(st1.nextToken(), "=");
					
					ageToken.nextToken();
					int age = Integer.parseInt(ageToken.nextToken());
					if(age > 100) {
						age = 100;
					}
					
					genderToken.nextToken();
					String genderStr = genderToken.nextToken();
					int gender = 0; // male by default
					if(genderStr.equals("F")) {
						gender = 1;
					} else if(genderStr.equals("M")) {
						gender = 0; 
					} else {
						System.out.println("wrong data for gender: " + genderStr);
						System.exit(1);
					}
					
					wardToken.nextToken();
					int ward = Integer.parseInt(wardToken.nextToken());
					
					mortality[gender][ward - 1][age]++;
					
					s = in.readLine();
				}
				
			} catch(IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		private void setFertility(String filename) {
			try {
				BufferedReader in = new BufferedReader(new FileReader(new File(FERTILITY_PATH, filename)));
				String s = in.readLine();
				while(s !=null && !s.equals("")) {
					StringTokenizer st1 = new StringTokenizer(s, ",");
					
					st1.nextToken(); // new baby pid
					
					StringTokenizer genderToken = new StringTokenizer(st1.nextToken(), "=");
					
					st1.nextToken(); // mother pid
					
					StringTokenizer motherAgeToken = new StringTokenizer(st1.nextToken(), "=");
					StringTokenizer motherMartitalToken = new StringTokenizer(st1.nextToken(), "=");
					StringTokenizer wardToken = new StringTokenizer(st1.nextToken(), "=");
					
					motherAgeToken.nextToken();
					int motherAge = Integer.parseInt(motherAgeToken.nextToken());
					
					genderToken.nextToken();
					String genderStr = genderToken.nextToken();
					int gender = 0; // male by default
					if(genderStr.equals("F")) {
						gender = 1;
					} else if(genderStr.equals("M")) {
						gender = 0; 
					} else {
						System.out.println("wrong data for gender: " + genderStr);
						System.exit(1);
					}
					
					wardToken.nextToken();
					int ward = Integer.parseInt(wardToken.nextToken());
					
					motherMartitalToken.nextToken();
					String motherMaritalStr = motherMartitalToken.nextToken();
					int motherMarital = 0;
					if(motherMaritalStr.equals("Y")) {
						motherMarital = 1;
					} else if(motherMaritalStr.equals("N")) {
						motherMarital = 0;
					} else {
						System.out.println("wrong data for mother marital status: " + motherMaritalStr);
						System.exit(1);
					}
					
					fertility[gender][ward - 1][motherAge][motherMarital]++;
					
					s = in.readLine();
				}
				
			} catch(IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		
	}
}
	
