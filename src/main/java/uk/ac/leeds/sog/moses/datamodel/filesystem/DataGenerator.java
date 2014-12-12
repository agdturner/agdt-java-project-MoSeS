package uk.ac.leeds.sog.moses.datamodel.filesystem;

import org.apache.log4j.Logger;
import uk.ac.leeds.sog.moses.datamodel.filesystem.FileSystemDataLoader;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class DataGenerator {

	private static Logger s_logger = MosesLogger.getLogger(DataGenerator.class);
	
	private DataGenerator() {
	}
	
	public synchronized static void generate() {
		s_logger.info("generating data");
		loadData();
	}
	
	public synchronized static void generate(String dataFileName) {
		loadData(dataFileName);
	}
	
	private static void loadData() {
		FileSystemDataLoader.load();
	}
	
	private static void loadData( String dataFileName) {
		s_logger.info("generating data from " + dataFileName);
		FileSystemDataLoader.load(dataFileName);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataGenerator.generate();
	}

}
