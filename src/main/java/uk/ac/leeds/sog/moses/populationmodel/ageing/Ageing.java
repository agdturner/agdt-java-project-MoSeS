package uk.ac.leeds.sog.moses.populationmodel.ageing;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.populationmodel.HouseholdImpl;
import uk.ac.leeds.sog.moses.populationmodel.PersonAgent;
import uk.ac.leeds.sog.moses.populationmodel.PopulationDataHelper;
import uk.ac.leeds.sog.moses.populationmodel.tools.SimulationRecorder;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class Ageing {
	private static Ageing s_instance = null;
	private String i_simulationYear;
	private AgeingDataHelper i_dataHelper = null;
	
	private static Logger s_logger = MosesLogger.getLogger(Ageing.class);
	
	private Ageing(PopulationDataHelper dataHelper) {
		s_logger.info("Ageing - constructing ageing module");
		i_dataHelper = new AgeingDataHelper(dataHelper);
		if(System.getProperty("StudentSimulation") != null 
				&& System.getProperty("StudentSimulation").equalsIgnoreCase("true")) {
		}
	}
	
	public static Ageing getInstance(PopulationDataHelper dataHelper) {
		if(s_instance == null) {
			s_instance = new Ageing(dataHelper);
		}
		return s_instance;
	}
	
	public void age(PersonAgent a_personAgent, HouseholdImpl household) {
		i_simulationYear = i_dataHelper.getSimulationYearString();
		
		Person person = a_personAgent.getPerson();
		
		int oldAge = person.getAge().intValue();
		int newAge = oldAge + 1;
		person.setAge(new Integer(newAge));
		
		if(person.getInFormalCare().equals("Y")) {
			// person is in formal care
			return;
		}
		
		// family role
		if(person.getHrpStatus().equals("N")) {
			// Non-HRP household member: a child dependent becomes an adult dependent
			if(person.getFamilyRole().equals(ApplicationConstants.CHILD_DEPENDENT_ROLE) && 
					        oldAge <= ApplicationConstants.CHILD_AGE && newAge > ApplicationConstants.CHILD_AGE) {
				person.setFamilyRole(ApplicationConstants.ADULT_DEPENDENT_ROLE);
				SimulationRecorder.ageing(person, "Child dependent is now an adult dependent", i_simulationYear);
			}
			
			// Non-HRP household member: an adult dependent becomes an elderly dependent
			if(person.getFamilyRole().equals(ApplicationConstants.ADULT_DEPENDENT_ROLE)  && 
			        oldAge < ApplicationConstants.ELDERLY_AGE && newAge >= ApplicationConstants.ELDERLY_AGE) {
				person.setFamilyRole(ApplicationConstants.ELDERLY_DEPENDENT_ROLE);
				SimulationRecorder.ageing(person, "Adult dependent or a spouse dependent is now a dependent over 65", i_simulationYear);
			}
			
			if(person.getFamilyRole().equals(ApplicationConstants.SPOUSE_DEPENDENT_ROLE)  && 
			        oldAge < ApplicationConstants.ELDERLY_AGE && newAge >= ApplicationConstants.ELDERLY_AGE) {
				SimulationRecorder.ageing(person, "Spouse dependent is over 65", i_simulationYear);
			}
		} else {
			// HRP household member
			if(oldAge < ApplicationConstants.ELDERLY_AGE && newAge >= ApplicationConstants.ELDERLY_AGE) {
				SimulationRecorder.ageing(person, "HRP is over 65", i_simulationYear);
			}
		}
		
		// process student type
		if(person.getStudentType() != null) {
			String type = person.getStudentType();
			if(type.equals(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE)) {
				if(person.getYearInUniversity().equals("0")) {
					person.setYearInUniversity("1");
				} else if(person.getYearInUniversity().equals("1")) {
					person.setYearInUniversity("2");
				} else if(person.getYearInUniversity().equals("2")) {
					person.setYearInUniversity("3");
				} else if(person.getYearInUniversity().equals("3")) {
					person.setStudentType("Undergraduate-" + person.getYearInUniversity() + "-" +  "LeavingStudent");
					person.setYearLeavingUnversity(i_simulationYear);
					person.setYearInUniversity("-10");
					person.setStudent("2");
				}
			}
			if(type.equals(ApplicationConstants.STUDENT_TYPE_MSC)) {
				if(person.getYearInUniversity().equals("0")) {
					person.setYearInUniversity("1");
				} else if(person.getYearInUniversity().equals("1")) {
					person.setStudentType("MSc-" + person.getYearInUniversity() + "-" +  "LeavingStudent");
					person.setYearLeavingUnversity(i_simulationYear);
					person.setStudent("2");
					person.setYearInUniversity("-10");
				}
			}
			if(type.equals(ApplicationConstants.STUDENT_TYPE_PHD)) {
				if(person.getYearInUniversity().equals("0")) {
					person.setYearInUniversity("1");
				} else if(person.getYearInUniversity().equals("1")) {
					person.setYearInUniversity("2");
				} else if(person.getYearInUniversity().equals("2")) {
					person.setYearInUniversity("3");
				} else if(person.getYearInUniversity().equals("3")) {
					person.setStudentType("PhD-" + person.getYearInUniversity() + "-" +  "LeavingStudent");
					person.setYearLeavingUnversity(i_simulationYear);
					person.setStudent("2");
					person.setYearInUniversity("-10");
				}
			}
		}
	}
	
	public static void main(String args[]) {
		s_logger.info("main");
		/*Ageing ageing = Ageing.getInstance(null);
		int num = 0;
		for(int i= 0;  i<10000; i++) {
			if(ageing.stayingInLeeds() == true) {
				s_logger.info("staying");
				num++;
			} else {
				s_logger.info("leaving");
			}
		}
		s_logger.info("number staying in leeds: " + num);*/
	}

}
