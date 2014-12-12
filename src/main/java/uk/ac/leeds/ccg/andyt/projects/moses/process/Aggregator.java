/**
 * A component of a library for
 * <a href="http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS">MoSeS</a>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA.
 */
package uk.ac.leeds.ccg.andyt.projects.moses.process;

/**
 * This class is to provide a method to aggregate records with variables for
 * distinct variable values
 */
public class Aggregator {

	/** Creates a new instance of Aggregator */
	public Aggregator() {
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Aggregator aAggregator = new Aggregator();
		aAggregator.run();
	}

	public void run() {
		try {
			_AggregateHSAR();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Error e) {
			e.printStackTrace();
		}
	}

	public void _AggregateHSAR() throws Exception {
		// File inputDirectory = new File("C:/Work/Projects/MoSeS/Workspace/" );
		//        
		// File thisFile = new File( inputDirectory,
		// HSARDataHandler.class.getName() + ".thisFile" );
		// HSARDataHandler tHSARDataHandler = new HSARDataHandler( thisFile );
		// System.out.println("tHSARDataHandler.getNDataRecords() " +
		// tHSARDataHandler.getNDataRecords() );
		// HSARDataRecord aHSARDataRecord = ( HSARDataRecord )
		// tHSARDataHandler.getDataRecord( 0L );
		// String aHSARDataRecord_toCSVStringFields =
		// aHSARDataRecord.toCSVStringFields();
		// String[] variables = aHSARDataRecord_toCSVStringFields.split(",");
		//        
		// for ( int variableID = 2; variableID < variables.length; variableID
		// ++ ) {
		// System.out.println( "" + variables[ variableID ] );
		// // Field aField = aHSARDataRecord.getClass().getField( variables[
		// variableID ] );
		// // System.out.println( "" + aField );
		// }
		//        
		// Field[] tFields = aHSARDataRecord.getClass().getFields();
		// for ( int fieldID = 0; fieldID < tFields.length; fieldID ++ ) {
		// System.out.println( "" + tFields[ fieldID ] );
		// }
		//        
		// Method[] tMethods = aHSARDataRecord.getClass().getMethods();
		// for ( int methodID = 0; methodID < tMethods.length; methodID ++ ) {
		// System.out.println( "" + tMethods[ methodID ] );
		// //Runtime.getRuntime(). =
		// java.beans.Statement s = new java.beans.Statement();
		// }

	}

}
