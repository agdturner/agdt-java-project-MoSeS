package uk.ac.leeds.sog.moses.populationmodel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Location;
import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.datamodel.Simulationcontrol;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class PopulationDataHelper {
	private List i_locations = null;
	private Simulationcontrol simControl = null;
	private List i_locationSeq = null;
	private Random random = null;
	
	int totalNumberOfPeople;
	
	private static Logger s_logger = MosesLogger.getLogger(PopulationDataHelper.class);
	
	private static final String s_simulationControlFile = "simulationcontrol.ser";
	private static final String s_locationFile = "locations.ser";
	
	public PopulationDataHelper() {
		s_logger.info("Construct");
		i_locations = this.getAllLocations();
		simControl = this.getSimulationcontrol();
		random = new Random(System.currentTimeMillis());
		i_locationSeq = new ArrayList();
		resetLocationSeq();
	}
		
	//  A person must be alive and not in formal care
	public List getPersonsByLocation(Location a_location) {
		String fileName = "persons_" + a_location.getWardLocation() + ".ser";
		List persons = new ArrayList();
		ObjectInput input = null;
	    try{
	      //use buffering
	      InputStream file = new FileInputStream(new File("populationdata", fileName));
	      InputStream buffer = new BufferedInputStream( file );
	      input = new ObjectInputStream ( buffer );
	      persons = (ArrayList)input.readObject();
	    }
	    catch(IOException ex){
	      s_logger.error("Cannot perform input.", ex);
	    }
	    catch (ClassNotFoundException ex){
	    	s_logger.error("Unexpected class found upon input.", ex);
	    }
	    finally{
	      try {
	        if ( input != null ) {
	          input.close();
	        }
	      }
	      catch (IOException ex){
	    	  s_logger.error("Cannot close input stream.", ex);
	      }
	    }
	    return persons;
	}
	
	public List getPersonsByLocation(String wardLocation) {
		String fileName = "persons_" + wardLocation+ ".ser";
		List persons = new ArrayList();
		ObjectInput input = null;
	    try{
	      //use buffering
	      InputStream file = new FileInputStream(new File("populationdata", fileName));
	      InputStream buffer = new BufferedInputStream( file );
	      input = new ObjectInputStream ( buffer );
	      persons = (ArrayList)input.readObject();
	    }
	    catch(IOException ex){
	      s_logger.error("Cannot perform input.", ex);
	    }
	    catch (ClassNotFoundException ex){
	    	s_logger.error("Unexpected class found upon input.", ex);
	    }
	    finally{
	      try {
	        if ( input != null ) {
	          input.close();
	        }
	      }
	      catch (IOException ex){
	    	  s_logger.error("Cannot close input stream.", ex);
	      }
	    }
	    return persons;
	}
	
	public void updatePersonsByLocation(Location a_location, List persons) {
		// s_logger.info("writing data to location: " + a_location.getWardLocation() + " " + persons.size());
		String fileName = "persons_" + a_location.getWardLocation() + ".ser";
		ObjectOutput output = null;
	    try{
	      //use buffering
	      OutputStream file = new FileOutputStream(new File("populationdata", fileName));
	      OutputStream buffer = new BufferedOutputStream(file);
	      output = new ObjectOutputStream(buffer);
	      output.writeObject(persons);
	      output.flush();
	    }
	    catch(IOException ex){
	    	s_logger.error("Cannot perform output.", ex);
	    }
	    finally{
	      try {
	        if (output != null) {
	          //flush and close "output" and its underlying streams
	          output.close();
	        }
	      }
	      catch (IOException ex ){
	    	  s_logger.error("Cannot close output stream.", ex);
	      }
	    }
	}
	
	public void addPersonsByLocation(String wardLocation, List persons) {
		// s_logger.info("writing data to location: " + wardLocation + " " + persons.size());
		List currPersons = this.getPersonsByLocation(wardLocation);
		currPersons.addAll(persons);
		Collections.sort(currPersons);
		String fileName = "persons_" + wardLocation + ".ser";
		ObjectOutput output = null;
	    try{
	      //use buffering
	      OutputStream file = new FileOutputStream(new File("populationdata", fileName));
	      OutputStream buffer = new BufferedOutputStream(file);
	      output = new ObjectOutputStream(buffer);
	      output.writeObject(currPersons);
	      output.flush();
	    }
	    catch(IOException ex){
	    	s_logger.error("Cannot perform output.", ex);
	    }
	    finally{
	      try {
	        if (output != null) {
	          //flush and close "output" and its underlying streams
	          output.close();
	        }
	      }
	      catch (IOException ex ){
	    	  s_logger.error("Cannot close output stream.", ex);
	      }
	    }
	}
	
	public void setTotalNumberOfPeople(int number) {
		totalNumberOfPeople = number;
	}
	
	public int getTotalNumberOfPeople() {
		return totalNumberOfPeople;
	}
	
	public int getNumberOfChildDependents(List a_listOfPersons) {
		int number = 0;
		
		int size = a_listOfPersons.size();
		for(int i=0; i<size; i++) {
			Person person = (Person) a_listOfPersons.get(i);
			if(person.getAge().intValue() <= ApplicationConstants.CHILD_AGE 
					&& person.getFamilyRole().equals(ApplicationConstants.CHILD_DEPENDENT_ROLE)) {
				number++;
			}
		}
		
		return number;
	}
	
	public Integer getNumberOfElderly(List a_listOfPersons) {
		int number = 0;
		
		int size = a_listOfPersons.size();
		for(int i=0; i<size; i++) {
			Person person = (Person) a_listOfPersons.get(i);
			if(person.getAge().intValue() >= ApplicationConstants.ELDERLY_AGE) {
				number++;
			}
		}
		
		return new Integer(number);
	}
	
	public Integer getNumberOfElderlyDependents(List a_listOfPersons) {
		int number = 0;
		
		int size = a_listOfPersons.size();
		for(int i=0; i<size; i++) {
			Person person = (Person) a_listOfPersons.get(i);
			if(person.getAge().intValue() >= ApplicationConstants.ELDERLY_AGE 
					&& person.getFamilyRole().equals(ApplicationConstants.ELDERLY_DEPENDENT_ROLE)) {
				number++;
			}
		}
		
		return new Integer(number);
	}
	
	public Person findNewHRP(List householdMembers) {
		Person newHRP = null;
		
		if(householdMembers.size() == 0) {
			return newHRP;
		}
		
		// spouse
		for(int i=0; i<householdMembers.size(); i++) {
			Person member = (Person) householdMembers.get(i);
			if(member.getFamilyRole().equals(ApplicationConstants.SPOUSE_DEPENDENT_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		// adult
		for(int i=0; i<householdMembers.size(); i++) {
			Person member = (Person) householdMembers.get(i);
			if(member.getFamilyRole().equals(ApplicationConstants.ADULT_DEPENDENT_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		// elderly
		for(int i=0; i<householdMembers.size(); i++) {
			Person member = (Person) householdMembers.get(i);
			if(member.getFamilyRole().equals(ApplicationConstants.ELDERLY_DEPENDENT_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		// child
		for(int i=0; i<householdMembers.size(); i++) {
			Person member = (Person) householdMembers.get(i);
			if(member.getFamilyRole().equals(ApplicationConstants.CHILD_DEPENDENT_ROLE)) {
				newHRP = member;
				return newHRP;
			}
		}
		
		return newHRP;
	}
	
	// methods to get all location
	public List getAllLocations() {
		List locations = null;
		ObjectInput input = null;
	    try{
	      //use buffering
	      InputStream file = new FileInputStream(new File("populationdata", s_locationFile));
	      InputStream buffer = new BufferedInputStream( file );
	      input = new ObjectInputStream ( buffer );
	      locations = (ArrayList)input.readObject();
	    }
	    catch(IOException ex){
	      s_logger.error("Cannot perform input.", ex);
	    }
	    catch (ClassNotFoundException ex){
	    	s_logger.error("Unexpected class found upon input.", ex);
	    }
	    finally{
	      try {
	        if ( input != null ) {
	          input.close();
	        }
	      }
	      catch (IOException ex){
	    	  s_logger.error("Cannot close input stream.", ex);
	      }
	    }
	    return locations;
	}
	
	// method to get max pid
	public Long getNextHouseholdID() {
		return simControl.getNextHouseholdID();
	}
	
	public Long getNextPID() {
		return simControl.getNextPID();
	}
	
	// methods to control simulation
	public void setSimulationYear(int a_year) {
		simControl.setSimulationYear(String.valueOf(a_year));
	}
	
	public int getSimulationYear() {
		return Integer.valueOf(simControl.getSimulationYear()).intValue();
	}
	
	public String getSimulationYearString() {
		return simControl.getSimulationYear();
		// Simulationcontrol simulationCotrol = getSimulationcontrol();
		// return simulationCotrol.getSimulationYear();
	}
	
	private Simulationcontrol getSimulationcontrol() {
		Simulationcontrol simulationCotrol = null;
		ObjectInput input = null;
	    try{
	      //use buffering
	      InputStream file = new FileInputStream(new File("populationdata", s_simulationControlFile));
	      InputStream buffer = new BufferedInputStream( file );
	      input = new ObjectInputStream ( buffer );
	      simulationCotrol = (Simulationcontrol) input.readObject();
	    }
	    catch(IOException ex){
	      s_logger.error("Cannot perform input.", ex);
	    }
	    catch (ClassNotFoundException ex){
	    	s_logger.error("Unexpected class found upon input.", ex);
	    }
	    finally{
	      try {
	        if ( input != null ) {
	          input.close();
	        }
	      }
	      catch (IOException ex){
	    	  s_logger.error("Cannot close input stream.", ex);
	      }
	    }
	    return simulationCotrol;
	}
	
	// update migration flag
	public void setMigrationFlag(String value) {
		// i_dataManager.setMigrationFlag(value);
	}
	
	private void resetLocationSeq() {
		i_locationSeq.clear();
		List temp = new ArrayList();
		for(int i=0; i<i_locations.size(); i++) {
			temp.add(new Integer(i));
		}
		for(int i=0; i<i_locations.size(); i++) {
			int a = (int)Math.round(random.nextDouble() * temp.size() -1);
			if(a == -1 || temp.size() == 1) {
				a = 0;
			}
			i_locationSeq.add(temp.get(a));
			temp.remove(a);
		}
	}

	public List getLocations() {
		return i_locations;
	}

	public void setLocations(List locations) {
		this.i_locations = locations;
	}

	public Simulationcontrol getSimControl() {
		return simControl;
	}

	public void setSimControl(Simulationcontrol simControl) {
		this.simControl = simControl;
	}
}
