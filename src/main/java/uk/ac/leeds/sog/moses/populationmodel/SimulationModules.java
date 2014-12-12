package uk.ac.leeds.sog.moses.populationmodel;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.populationmodel.ageing.Ageing;
import uk.ac.leeds.sog.moses.populationmodel.fertility.Fertility;
import uk.ac.leeds.sog.moses.populationmodel.health.HealthChange;
import uk.ac.leeds.sog.moses.populationmodel.marriage.Marriage;
import uk.ac.leeds.sog.moses.populationmodel.migration.Migration;
import uk.ac.leeds.sog.moses.populationmodel.mortality.Mortality;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class SimulationModules {

	// population modules
	private Ageing agingModule = null;
	private HealthChange healthChangeModule = null;
	private Fertility fertilityModule = null;
	private Mortality mortalityModule = null;
	private Marriage marriageModule = null;
	private Migration migrationModule = null;
	
	// private static Map s_instances = new HashMap();
	private static SimulationModules s_instance = null;
	private static Logger s_logger = MosesLogger.getLogger(SimulationModules.class);
	
	private SimulationModules(PopulationDataHelper dataHelper) {
		s_logger.info("SimulationModules - constructing simulation modules");
		agingModule = Ageing.getInstance(dataHelper);
		healthChangeModule = HealthChange.getInstance(dataHelper);
		fertilityModule = Fertility.getInstance(dataHelper);
		mortalityModule = Mortality.getInstance(dataHelper);
		marriageModule = Marriage.getInstance(dataHelper);
		migrationModule = Migration.getInstance(dataHelper);
	}
	
	public static SimulationModules getInstance(PopulationDataHelper dataHelper) {
		if(s_instance == null) {
			s_instance = new SimulationModules(dataHelper);
		}
		return s_instance;
	}

	public Ageing getAgingModule() {
		return agingModule;
	}

	public Fertility getFertilityModule() {
		return fertilityModule;
	}

	public HealthChange getHealthChangeModule() {
		return healthChangeModule;
	}

	public Marriage getMarriageModule() {
		return marriageModule;
	}

	public Migration getMigrationModule() {
		return migrationModule;
	}

	public Mortality getMortalityModule() {
		return mortalityModule;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		s_logger.info("running");
	}
}
