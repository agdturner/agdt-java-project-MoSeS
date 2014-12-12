package uk.ac.leeds.sog.moses.populationmodel.tools;

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
import java.util.List;

import org.apache.log4j.Logger;

import uk.ac.leeds.sog.moses.datamodel.Person;
import uk.ac.leeds.sog.moses.populationmodel.ApplicationConstants;
import uk.ac.leeds.sog.moses.utilities.MosesLogger;

public class StudentGenerator {
	
	private List students;
	private int index;
	private List numbers;
	int upperBound;
	private String students_filename = "students_firstyear_sample.ser";
	private static Logger s_logger = MosesLogger.getLogger(StudentGenerator.class);
	
	public StudentGenerator() {
		students = new ArrayList();
		readData();
	    upperBound = students.size();
	    numbers = new ArrayList();
	    setRandomNumbers();
	}
	
	public StudentGenerator(String filename) {
		students_filename = filename;
		students = new ArrayList();
		readData();
	    upperBound = students.size();
	    numbers = new ArrayList();
	    setRandomNumbers();
	}
	
	public StudentGenerator(List students, String filename) {
		students_filename = filename;
		writeData(students);
	    this.students = students;
	    upperBound = students.size();
	    numbers = new ArrayList();
	    setRandomNumbers();
	}
	
	public Person getStudent() {
		if(index >= (upperBound -1)) {
			setRandomNumbers();
		}
		int count = ((Integer)numbers.get(index)).intValue();
		Person student = (Person) students.get(count);
		index++;
		return student;
	}
	
	public List getStudents(int number) {
		List results = new ArrayList();
		for(int i=0; i<number; i++) {
			results.add(getStudent());
		}
		return results;
	}
	
	public List getUndergraduate1(int number) {
		List results = new ArrayList();
		for(int i=0; i<number; i++) {
			Person student = (Person) getStudent();
			student.setStudentType(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE);
			student.setYearInUniversity("1");
			results.add(student);
		}
		return results;
	}
	
	public List getUndergraduate2(int number) {
		List results = new ArrayList();
		for(int i=0; i<number; i++) {
			Person student = (Person) getStudent();
			student.setStudentType(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE);
			student.setYearInUniversity("2");
			results.add(student);
		}
		return results;
	}
	
	public List getUndergraduate3(int number) {
		List results = new ArrayList();
		for(int i=0; i<number; i++) {
			Person student = (Person) getStudent();
			student.setStudentType(ApplicationConstants.STUDENT_TYPE_UNDERGRADUATE);
			student.setYearInUniversity("3");
			results.add(student);
		}
		return results;
	}
	
	public List getMsc(int number) {
		List results = new ArrayList();
		for(int i=0; i<number; i++) {
			Person student = (Person) getStudent();
			student.setStudentType(ApplicationConstants.STUDENT_TYPE_MSC);
			student.setYearInUniversity("1");
			results.add(student);
		}
		return results;
	}
	
	public List getPhD1(int number) {
		List results = new ArrayList();
		for(int i=0; i<number; i++) {
			Person student = (Person) getStudent();
			student.setStudentType(ApplicationConstants.STUDENT_TYPE_PHD);
			student.setYearInUniversity("1");
			results.add(student);
		}
		return results;
	}
	
	private void setRandomNumbers() {
		readData();
		index = 0;
		numbers.clear();
		int upperbound = students.size() - 1;
		List temp = new ArrayList(upperbound);
		for(int i=0; i<upperbound; i++) {
			temp.add(new Integer(i+1));
		}
		
		// int count =  upperbound- number;
		int count =  upperbound;
		for(int i=0; i<count; i++) {
			int a = (int)Math.round(Math.random() * temp.size() -1);
			if(a == -1 && temp.size() == 1) {
				a = 0;
			}
			numbers.add(temp.get(Math.abs(a)));
		    temp.remove(Math.abs(a));
		}
	}
	
	private void readData() {
		ObjectInput input = null;
	    try{
	      //use buffering
	      InputStream file = new FileInputStream(new File("populationdata", students_filename));
	      InputStream buffer = new BufferedInputStream( file );
	      input = new ObjectInputStream ( buffer );
	      students = (ArrayList)input.readObject();
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
	}
	
	private void writeData(List students) {
		ObjectOutput output = null;
	    try{
	      //use buffering
	      OutputStream file = new FileOutputStream(new File("populationdata", students_filename));
	      OutputStream buffer = new BufferedOutputStream(file);
	      output = new ObjectOutputStream(buffer);
	      output.writeObject(students);
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
	
	public List getAllStudents() {
		return students;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StudentGenerator generator = new StudentGenerator();
		List stds = generator.getStudents(30000);
		stds.clear();
	}

}
