package uk.ac.leeds.sog.moses.result.analysis.migration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class ResultAnalysis {
	
	private static final String src_location = "src";
	
	private static final int NUM_OF_LOCATIONS = 33;
	private static final String[][] files = {{"2001","migration2001.csv"}, {"2002", "migration2002.csv"},
	                                   {"2003", "migration2003.csv"}, {"2010","migration2010.csv"},
	                                   {"2020","migration2020.csv"}, {"2030","migration2030.csv"}};
	
	private int[][] totalMovingPersons = new int[NUM_OF_LOCATIONS][NUM_OF_LOCATIONS];
	private String dir = null;
	
	public ResultAnalysis() {
		reset();
		String separator = System.getProperty("file.separator");
		String temp = new String(src_location + separator + "uk.ac.leeds.sog.moses.result.analysis.migration");
		dir = temp.replace('.', separator.charAt(0));
	}
	
	public void analyze() {
		for(int i=0; i<files.length; i++) {
			String inputFileName = files[i][1];
			String outputFileName = "analysis_" + inputFileName;
			try {
				BufferedReader in = new BufferedReader(new FileReader(new File(dir, inputFileName)));
				String s = in.readLine();
				while(s !=null && !s.equals("")) {
					StringTokenizer st1 = new StringTokenizer(s, ",");
					
					st1.nextToken();
					
					String oldLocationField = st1.nextToken();
					StringTokenizer st2 = new StringTokenizer(oldLocationField, "=");
					st2.nextToken();
					String oldLocationString = st2.nextToken();
					
					String newLocationField = st1.nextToken();
					StringTokenizer st3 = new StringTokenizer(newLocationField, "=");
					st3.nextToken();
					String newLocationString = st3.nextToken();
					
					totalMovingPersons[Integer.parseInt(oldLocationString) - 1][Integer.parseInt(newLocationString) - 1]++;
					
					s = in.readLine();
				}
				
				PrintStream out = new PrintStream(new FileOutputStream(new File(dir, outputFileName)));
				for(int j=0; j<NUM_OF_LOCATIONS; j++) {
					StringBuffer buffer = new StringBuffer();
					buffer.append(totalMovingPersons[j][0]);
					for(int k=1; k<NUM_OF_LOCATIONS; k++) {
						buffer.append(",");
						buffer.append(totalMovingPersons[j][k]);
					}
					out.println(buffer.toString());
					out.flush();
				}
				
			} catch(IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	private void reset() {
		for(int i=0; i<NUM_OF_LOCATIONS; i++) {
			for(int j=0; j<NUM_OF_LOCATIONS; j++) {
				totalMovingPersons[i][j] = 0;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ResultAnalysis analysis = new ResultAnalysis();
		analysis.analyze();
	}

}
