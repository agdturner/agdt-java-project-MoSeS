package uk.ac.leeds.sog.moses.utilities.datagenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;


public class DataGenerator {
	private String i_dirName = "populationdata";
	private List i_rawDataList = new ArrayList();
	private List i_selectedData = new ArrayList();
	private String i_fieldnames = "";
	
	public DataGenerator() {
	}
	
	public void generate(String dataFile1, String dataFile2) {
		try {
			// read raw data
			BufferedReader in = new BufferedReader(new FileReader(new File(i_dirName, dataFile1)));
			String s = in.readLine();
			while(s !=null) {
				StringTokenizer st = new StringTokenizer(s);
				RawData data = new RawData(st.nextToken(), st.nextToken(), s);
				i_rawDataList.add(data);
				s = in.readLine();
			}
			
			// read selected data
			in = new BufferedReader(new FileReader(new File(i_dirName, dataFile2)));
			s = in.readLine();
			while(s !=null) {
				StringTokenizer st = new StringTokenizer(s);
				SelectedData data = new SelectedData(st.nextToken(), st.nextToken(), st.nextToken(), s);
				i_selectedData.add(data);
				s = in.readLine();
			}
			
			PrintWriter out =  new PrintWriter(new FileWriter(new File(i_dirName, "FullLeedsData.csv")));
			if(!i_fieldnames.equals("")) {
				out.println(i_fieldnames);
				out.flush();
			}
			
			// generate new data
			long pid = 1;
			long household_id = 1;
			int size1 = i_selectedData.size();
			for(int i=0; i<size1; i++) {
				SelectedData selectedData = (SelectedData) i_selectedData.get(i);			
				String location = selectedData.getLocation();
				String householdId = selectedData.getHouseholdId();
				String pnum = selectedData.getPnum();
				int size2 = i_rawDataList.size();
				List temp = new ArrayList();
				temp.add(selectedData);
				int j=0;
				while(j < size2) {
					RawData rawData = (RawData) i_rawDataList.get(j);
					if(rawData.getHouseholdId().equals(householdId) && !rawData.getpnum().equals(pnum)) {
						SelectedData newData = new SelectedData(rawData.getHouseholdId(), 
								rawData.getpnum(), rawData.getData());
						newData.addLocation(location);
						temp.add(newData);
					}
					j++;
				}
				
				Collections.sort(temp);
				for(int k=0; k<temp.size(); k++) {
					SelectedData newSelecteData = (SelectedData) temp.get(k);
					StringTokenizer st = new StringTokenizer(newSelecteData.getData());
					StringBuffer buffer = new StringBuffer();
					buffer.append(pid);
					buffer.append(",");
					buffer.append(household_id);
					while(st.hasMoreTokens()) {
						buffer.append(",");
						buffer.append(st.nextToken());
					}
					out.println(buffer.toString());
					out.flush();
					pid++;
				}
				household_id++;
			}
			out.flush();
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		System.out.print("Start - ");
		System.out.println(new Date(System.currentTimeMillis()));
		DataGenerator generator = new DataGenerator();
		generator.generate("lichhd-051019.tab", "LINKLS.TXT");
		System.out.print("Finish - ");
		System.out.println(new Date(System.currentTimeMillis()));
    }
	
	public class RawData {
		private String i_householdId;
		private String i_pnum;
		private String i_data;
		
		public RawData(String householdId, String pnum, String data) {
			i_householdId = householdId;
			i_pnum = pnum;
			i_data = data;
		}
		
		public String getHouseholdId() {
			return i_householdId;
		}
		
		public String getData() {
			return i_data;
		}
		
		public String getpnum() {
			return i_pnum;
		}
	}
	
	public class SelectedData implements Comparable {
		private String i_location;
		private String i_householdId;
		private String i_pnum;
		private String i_data;
		
		public SelectedData(String location, String householdId, String pnum, String data) {
			i_location = location;
			i_householdId = householdId;
			i_pnum = pnum;
			i_data = data;
		}
		
		public SelectedData(String householdId, String pnum, String data) {
			i_householdId = householdId;
			i_pnum = pnum;
			i_data = data;
		}
		
		public void addLocation(String location) {
			i_location = location;
			i_data = Integer.parseInt(location) + "        " + i_data;
		}
		
		public String getHouseholdId() {
			return i_householdId;
		}
		
		public String getData() {
			return i_data;
		}
		
		public String getPnum() {
			return i_pnum;
		}
		
		public String getLocation() {
			return i_location;
		}
		
		public int compareTo(Object object) {
			SelectedData that = (SelectedData) object;
			int thisPnum = Integer.parseInt(this.getPnum());
			int thatPnum = Integer.parseInt(that.getPnum());
			if(thisPnum < thatPnum) {
				return -1;
			} else if(thisPnum == thatPnum) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
