package uk.ac.leeds.sog.moses.populationmodel;

public class ApplicationConstants {

	public static final int NUMBER_OF_AREAS = 33;
	public static final int SIMULATION_START_YAER = 2001;
	public static final int SIMULATION_END_YAER = 2031;
	
	public static final int NUMBER_OF_DATA_FIELDS = 18;
	
	public static final String HRP_ROLE = "HRP"; // role for living inside household
	public static final String SPOUSE_DEPENDENT_ROLE = "SpouseDependent"; // role for living inside household
	public static final String CHILD_DEPENDENT_ROLE = "ChildDependent"; // role for living inside household
	public static final String ADULT_DEPENDENT_ROLE = "AdultDependent"; // role for living inside household
	public static final String ELDERLY_DEPENDENT_ROLE = "ElderlyDependent"; // role for living inside household
	public static final String In_FORAML_CARE_ROLE = "In Formal Care"; // role for living outside household
	
	public static final int FERTILITY_MIN_AGE = 15;
	public static final int FERTILITY_MAX_AGE = 46;
	
	public static final int CHILD_AGE = 15;
	public static final int ELDERLY_AGE = 65;
	public static final int MAX_LEAVE_HOME_AGE = 22;
	public static final int MARRIAGE_MAXIMUM_AGE = 99;
	
	public static final int HEALTH_GOOD = 1;
	public static final int HEALTH_FAIRLY_GOOD = 2;
	public static final int HEALTH_NOT_GOOD = 3;
	
	public static final Integer HOUSEHOLD_VACANT = new Integer(0);
	public static final Integer HOUSEHOLD_OCCUPIED = new Integer(1);
	
	public static final int STUDENT_AGE_MIN = 17;
	public static final int STUDENT_AGE_MAX = 29;
	public static final int STUDENT_AGE_MIN_UNDERGRADUATE = 16;
	public static final int STUDENT_AGE_MAX_UNDERGRADUATE = 21;
	public static final int STUDENT_AGE_MIN_MSC = 22;
	public static final int STUDENT_AGE_MAX_MSC = 23;
	public static final int STUDENT_AGE_MIN_PHD = 24;
	public static final int STUDENT_AGE_MAX_PHD = 29;
	public static final String STUDENT_TYPE_UNDERGRADUATE = "Undergraduate";
	public static final String STUDENT_TYPE_MSC = "MSc";
	public static final String STUDENT_TYPE_PHD = "PhD";
	
}
