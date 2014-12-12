package uk.ac.leeds.sog.moses.populationmodel.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.apache.log4j.Logger;
import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class SimulationRecorder {
	
	public static final String s_AGEING_Analyser_FILENAME = "ageing";
	public static final String s_FERTILITY_Analyser_FILENAME = "fertility";
	public static final String s_MORTALITY_Analyser_FILENAME = "mortality";
	public static final String s_HEALTH_Analyser_FILENAME = "health";
	public static final String s_MARRIAGE_Analyser_FILENAME = "marriage";
	public static final String s_LEAVINGHOME_Analyser_FILENAME = "leavinghome";
	public static final String s_MIGRATION_Analyser_FILENAME = "migration";
	public static final String s_EMIGRATION_Analyser_FILENAME = "emigration";
	public static final String YEAR_MARK = "-------------------------------";
	
	private static PrintStream s_ageing = null;
	private static PrintStream s_fertility = null;
	private static PrintStream s_mortality = null;
	private static PrintStream s_health = null;
	private static PrintStream s_marriage = null;
	private static PrintStream s_migration = null;
	
	private static Logger s_logger = MosesLogger.getLogger(SimulationRecorder.class);
	
	private SimulationRecorder() {
	}
	
	public static void initialise(String simuYear) {
		if(!simuYear.equals("2001") && !simuYear.equals("2002") && !simuYear.equals("2003")
				&& !simuYear.equals("2010") && !simuYear.equals("2020") && !simuYear.equals("2030")) {
			return;
		}
		try {
			File resultDir = new File("result" + System.getProperty("file.separator") + "simuYear");
			if(!resultDir.exists()) {
				resultDir.mkdirs();
			}
			
			File resultDirAgeing = new File("result" + System.getProperty("file.separator") + "simuYear" + System.getProperty("file.separator") + "ageing");
			if(!resultDirAgeing.exists()) {
				resultDirAgeing.mkdirs();
			}
			
			File resultDirMortality = new File("result" + System.getProperty("file.separator") + "simuYear" + System.getProperty("file.separator") + "mortality");
			if(!resultDirMortality.exists()) {
				resultDirMortality.mkdirs();
			}
			
			File resultDirFertility = new File("result" + System.getProperty("file.separator") + "simuYear" + System.getProperty("file.separator") + "fertility");
			if(!resultDirFertility.exists()) {
				resultDirFertility.mkdirs();
			}
			
			File resultDirMarriage = new File("result" + System.getProperty("file.separator") + "simuYear" + System.getProperty("file.separator") + "marriage");
			if(!resultDirMarriage.exists()) {
				resultDirMarriage.mkdirs();
			}
			
			File resultDirHealthChange= new File("result" + System.getProperty("file.separator") + "simuYear" + System.getProperty("file.separator") + "healthchange");
			if(!resultDirHealthChange.exists()) {
				resultDirHealthChange.mkdirs();
			}
			
			File resultDirMigration= new File("result" + System.getProperty("file.separator") + "simuYear" + System.getProperty("file.separator") + "migration");
			if(!resultDirMigration.exists()) {
				resultDirMigration.mkdirs();
			}
			
			if(s_ageing != null) {
				s_ageing.close();
			}
			if(System.getProperty("Ageing") != null && System.getProperty("Ageing").equalsIgnoreCase("true")) {
				s_ageing = new PrintStream(new FileOutputStream(new File(resultDirAgeing, s_AGEING_Analyser_FILENAME + simuYear + ".csv")));
			}
			
			if(s_fertility != null) {
				s_fertility.close();
			}
			if(System.getProperty("Fertility") != null && System.getProperty("Fertility").equalsIgnoreCase("true")) {
				s_fertility = new PrintStream(new FileOutputStream(new File(resultDirFertility, s_FERTILITY_Analyser_FILENAME + simuYear + ".csv")));
			}
			
			if(s_mortality != null) {
				s_mortality.close();
			}
			if(System.getProperty("Mortality") != null && System.getProperty("Mortality").equalsIgnoreCase("true")) {
				s_mortality = new PrintStream(new FileOutputStream(new File(resultDirMortality, s_MORTALITY_Analyser_FILENAME + simuYear + ".csv")));
			}
			
			if(s_health != null) {
				s_health.close();
			}
			if(System.getProperty("HealthChange") != null && System.getProperty("HealthChange").equalsIgnoreCase("true")) {
				s_health = new PrintStream(new FileOutputStream(new File(resultDirHealthChange, s_HEALTH_Analyser_FILENAME + simuYear + ".csv")));
			}
			
			if(s_marriage != null) {
				s_marriage.close();
			}
			if(System.getProperty("Marriage") != null && System.getProperty("Marriage").equalsIgnoreCase("true")) {
				s_marriage = new PrintStream(new FileOutputStream(new File(resultDirMarriage, s_MARRIAGE_Analyser_FILENAME + simuYear + ".csv")));
			}
			
			if(s_migration != null) {
				s_migration.close();
			}
			if(System.getProperty("Migration") != null && System.getProperty("Migration").equalsIgnoreCase("true")) {
				s_migration = new PrintStream(new FileOutputStream(new File(resultDirMigration, s_MIGRATION_Analyser_FILENAME + simuYear + ".csv")));
			}
		} catch (IOException e) {
			s_logger.error("cannot create file " + e.toString());
			e.printStackTrace();
	    }
	}

	public static void ageing(Person a_person, String an_event, String a_simulationYear) {
		if(!a_simulationYear.equals("2001") && !a_simulationYear.equals("2002") && !a_simulationYear.equals("2003")
				&& !a_simulationYear.equals("2010") && !a_simulationYear.equals("2020") && !a_simulationYear.equals("2030")) {
			return;
		}
		if(System.getProperty("Ageing") != null && System.getProperty("Ageing").equalsIgnoreCase("true")) {
			StringBuffer result = new StringBuffer();
			result.append(an_event);
			result.append(",pid=" + a_person.getPid());
			result.append(",year=" + a_simulationYear);
			s_ageing.println(result.toString());
			s_ageing.flush();
		}
	}
	
	public static void ferility(Person a_mother, Person a_baby, String a_simulationYear, boolean a_twinFlag) {
		if(!a_simulationYear.equals("2001") && !a_simulationYear.equals("2002") && !a_simulationYear.equals("2003")
				&& !a_simulationYear.equals("2010") && !a_simulationYear.equals("2020") && !a_simulationYear.equals("2030")) {
			return;
		}
		if(System.getProperty("Fertility") != null && System.getProperty("Fertility").equalsIgnoreCase("true")) {
			StringBuffer result = new StringBuffer();
			if(a_twinFlag) {
				result.append("new_baby_pid_twin=" + a_baby.getPid());
			} else {
			    result.append("new_baby_pid=" + a_baby.getPid());
			}
			result.append(",new_baby_gender=" + a_baby.getGender());
			result.append(",mother_pid=" + a_mother.getPid());
			result.append(",mother_age=" + a_mother.getAge().intValue());
			result.append(",mother_marital_status=" + a_mother.getMaritalStatus());
			result.append(",location=" + a_baby.getLocation());
			result.append(",year=" + a_simulationYear);
			s_fertility.println(result.toString());
			s_fertility.flush();
		}
	}
	
	public static void mortality(Person a_deadPerson, Person a_newHRP, String a_simulationYear) {
		if(!a_simulationYear.equals("2001") && !a_simulationYear.equals("2002") && !a_simulationYear.equals("2003")
				&& !a_simulationYear.equals("2010") && !a_simulationYear.equals("2020") && !a_simulationYear.equals("2030")) {
			return;
		}
		if(System.getProperty("Mortality") != null && System.getProperty("Mortality").equalsIgnoreCase("true")) {
			StringBuffer result = new StringBuffer();
			if(a_newHRP != null) {
				result.append("dead_HRP_pid=" + a_deadPerson.getPid());
				result.append(" new_hrp_pid=" + a_newHRP.getPid());
			} else {
				result.append("dead_Non-HRP_pid=" + a_deadPerson.getPid());
			}
			result.append(",dead_person_age=" + a_deadPerson.getAge().intValue());
			result.append(",dead_person_gender=" + a_deadPerson.getGender());
			result.append(",location=" + a_deadPerson.getLocation());
			result.append(",year=" + a_simulationYear);
			s_mortality.println(result.toString());
			s_mortality.flush();
		}
	}
	
	public static void health(Person a_person, String an_event, String a_simulationYear) {
		if(!a_simulationYear.equals("2001") && !a_simulationYear.equals("2002") && !a_simulationYear.equals("2003")
				&& !a_simulationYear.equals("2010") && !a_simulationYear.equals("2020") && !a_simulationYear.equals("2030")) {
			return;
		}
		if(System.getProperty("HealthChange") != null && System.getProperty("HealthChange").equalsIgnoreCase("true")) {
			StringBuffer result = new StringBuffer();
			result.append(an_event);
			result.append(",person_pid=" + a_person.getPid());
			result.append(",person_gender=" + a_person.getGender());
			result.append(",person_age=" + a_person.getAge());
			result.append(",person_hrp_status=" + a_person.getHrpStatus());
			result.append(",person_location=" + a_person.getLocation());
			result.append(",year=" + a_simulationYear);
			s_health.println(result.toString());
			s_health.flush();
		}
	}
	
	public static void marriage(Person a_person, Person a_spouse, String a_simulationYear) {
		if(!a_simulationYear.equals("2001") && !a_simulationYear.equals("2002") && !a_simulationYear.equals("2003")
				&& !a_simulationYear.equals("2010") && !a_simulationYear.equals("2020") && !a_simulationYear.equals("2030")) {
			return;
		}
		if(System.getProperty("Marriage") != null && System.getProperty("Marriage").equalsIgnoreCase("true")) {
			StringBuffer result = new StringBuffer();
			result.append("person_pid=" + a_person.getPid());
			result.append(",person_hrp_status=" + a_person.getHrpStatus());
			result.append(",person_age=" + a_person.getAge());
			result.append(",person_gender=" + a_person.getGender());
			result.append(",person_location=" + a_person.getLocation());
			result.append(",spouse_pid=" + a_spouse.getPid());
			result.append(",spouse_hrp_status=" + a_spouse.getHrpStatus());
			result.append(",spouse_age=" + a_spouse.getAge());
			result.append(",spouse_gender=" + a_spouse.getGender());
			result.append(",spouse_location=" + a_spouse.getLocation());
			result.append(",year=" + a_simulationYear);
			s_marriage.println(result.toString());
			s_marriage.flush();
		}
	}
	
	public static void migration(Person migrant, String a_oldLocation, String a_newLocation, String a_simulationYear, String migrationType) {
		if(!a_simulationYear.equals("2001") && !a_simulationYear.equals("2002") && !a_simulationYear.equals("2003")
				&& !a_simulationYear.equals("2010") && !a_simulationYear.equals("2020") && !a_simulationYear.equals("2030")) {
			return;
		}
		if(System.getProperty("Migration") != null && System.getProperty("Migration").equalsIgnoreCase("true")) {
			StringBuffer result = new StringBuffer();
			result.append("migrant_pid=" + migrant.getPid());
			result.append(",migrant_old_location=" + a_oldLocation);
			result.append(",migrant_new_location=" + a_newLocation);
			result.append(",migration_type=" + migrationType);
			result.append(",year=" + a_simulationYear);
			s_migration.println(result.toString());
			s_migration.flush();
		}
	}
	
	public static void close() {
		if(s_ageing != null) {
			s_ageing.close();
		}
		if(s_fertility != null) {
			s_fertility.close();
		}
		if(s_mortality != null) {
			s_mortality.close();
		}
		if(s_health != null) {
			s_health.close();
		}
		if(s_marriage != null) {
			s_marriage.close();
		}
		if(s_migration != null) {
			s_migration.close();
		}
	}
	
	public static void main(String args[]) {
		initialise("2001");
		// sageing();
		// ferility();
		// mortality();
		// health();
		// marriage();
		// migration();
	}
	
	public static void setYearMark(int a_simulationYear) {
		String mark = YEAR_MARK + " " + a_simulationYear + " " + YEAR_MARK;
		if(s_ageing != null) {
			s_ageing.println(mark);
			s_ageing.flush();
		}
		if(s_fertility != null) {
			s_fertility.println(mark);
			s_fertility.flush();
		}
		if(s_mortality != null) {
			s_mortality.println(mark);
			s_mortality.flush();
		}
		if(s_health != null) {
			s_health.println(mark);
			s_health.flush();
		}
		if(s_marriage != null) {
			s_marriage.println(mark);
			s_marriage.flush();
		}
		if(s_migration != null) {
			s_migration.println(mark);
			s_migration.flush();
		}
	}
	
}
