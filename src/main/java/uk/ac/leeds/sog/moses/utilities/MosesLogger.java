package uk.ac.leeds.sog.moses.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.xml.DOMConfigurator;

public class MosesLogger {
	
	static {
	    String logPropertyFile = System.getProperty("log4j.properties");
	    
	     if (null != logPropertyFile) {
	    	 PropertyConfigurator.configure("log4j.properties");
	    	 if (logPropertyFile.endsWith("xml")) {
	             DOMConfigurator.configure(logPropertyFile);
	         } else if (logPropertyFile.endsWith("properties")) {
	        	 Properties property = new Properties();
	        	 try {
	        	     property.load(new FileInputStream(new File(logPropertyFile)));
	        	 } catch(IOException e) {
	        		 System.out.println("Cannot load log properties");
	        		 e.printStackTrace();
	        		 System.exit(1);
	        	 }
	             PropertyConfigurator.configure(property);
	         }

	     } else {
	    	 BasicConfigurator.configure();
	         Logger root = Logger.getRootLogger();
	         try {
	             Layout layout = new PatternLayout("%d{HH:mm:ssSSS} %-5p [%-15t]: %c{1} - %m%n");
	             ((Appender)root.getAllAppenders().nextElement()).setLayout(layout);
	             RollingFileAppender appender = new RollingFileAppender(layout, "log/moseslog.txt", false);
	             appender.setMaxBackupIndex(10);
	             appender.setMaxFileSize("50MB");
	             // appender.setThreshold(Priority.ERROR);
                 root.addAppender(appender);
             } catch (IOException e) {
	             e.printStackTrace();
	         }
         }
	}

	private MosesLogger() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Logger getLogger(Class a_class) {
		return Logger.getLogger(a_class);
	}

}
