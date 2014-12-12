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
package uk.ac.leeds.ccg.andyt.projects.moses.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile; //import java.util.HashMap;

/**
 * A <code>class</code> for holding the following collection of
 * <code>AbstractCASDataHandlers</code> so as to access respective
 * <code>AbstractCASDataRecords</code>:
 * <ul>
 * <li>CAS001DataHandler</li>
 * <li>CAS002DataHandler</li>
 * <li>CAS003DataHandler</li>
 * <li>CASKS002DataHandler</li>
 * <li>CASKS006DataHandler</li>
 * <li>CASKS008DataHandler</li>
 * <li>CASKS010DataHandler</li>
 * <li>CASKS017DataHandler</li>
 * <li>CASKS020DataHandler</li>
 * <li>CASKS09bDataHandler</li>
 * <li>CASKS09cDataHandler</li>
 * <li>CASKS12bDataHandler</li>
 * <li>CASKS12cDataHandler</li>
 * <li>CASKS14bDataHandler</li>
 * <li>CASKS14cDataHandler</li>
 * </ul>
 * <ul>
 * <li>Developed for <a href="http://www.ncess.ac.uk/moses">MoSeS</a>.</li>
 * <li>Copyright (C) 2007 <a
 * href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy Turner</a>, <a
 * href="http://www.leeds.ac.uk//">University of Leeds</a>.</li>
 * </ul>
 * 
 * @author <a href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy
 *         Turner</a>
 * @version 1.0.0, 2007-11-16
 * @see CASDataRecord
 */
public class CASDataHandler_2 extends CASDataHandler {

	/**
	 * Serializable class version number for swapping
	 * (serialization/deserialization)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * CASKS006DataHandler
	 */
	protected CASKS006DataHandler _CASKS006DataHandler;

	/**
	 * Creates a new CASDataHandler
     * @throws java.io.IOException
	 */
	public CASDataHandler_2() throws IOException {
		init();
	}

	/**
	 * Creates a new CASDataHandler using <code>Files</code> in directory
	 * 
	 * @param directory
	 *            The directory containing <code>Files</code>
	 * @param aggregation
	 *            A <code>String</code> part of the filename indicating the
	 *            aggregation (e.g. OA, MSOA, WARD, etc... )
     * @throws java.io.IOException
	 */
	public CASDataHandler_2(
            File directory,
            String aggregation)
			throws IOException {
		if (aggregation.equalsIgnoreCase("OA")) {
			aggregation = "";
		}
		this.init(directory);
		this._CAS001DataHandler = new CAS001DataHandler(new File(directory, ("CAS001DataRecords" + aggregation + ".dat")));
		this._CAS002DataHandler = new CAS002DataHandler(new File(directory, ("CAS002DataRecords" + aggregation + ".dat")));
		this._CAS003DataHandler = new CAS003DataHandler(new File(directory, ("CAS003DataRecords" + aggregation + ".dat")));
		this._CASKS002DataHandler = new CASKS002DataHandler(new File(directory, ("CASKS002DataRecords" + aggregation + ".dat")));
		this._CASKS006DataHandler = new CASKS006DataHandler(new File(directory, ("CASKS006DataRecords" + aggregation + ".dat")));
		this._CASKS008DataHandler = new CASKS008DataHandler(new File(directory, ("CASKS008DataRecords" + aggregation + ".dat")));
		this._CASKS010DataHandler = new CASKS010DataHandler(new File(directory, ("CASKS010DataRecords" + aggregation + ".dat")));
		this._CASKS015DataHandler = new CASKS015DataHandler(new File(directory, ("CASKS015DataRecords" + aggregation + ".dat")));
		this._CASKS017DataHandler = new CASKS017DataHandler(new File(directory, ("CASKS017DataRecords" + aggregation + ".dat")));
		this._CASKS020DataHandler = new CASKS020DataHandler(new File(directory, ("CASKS020DataRecords" + aggregation + ".dat")));
		this._CASKS023DataHandler = new CASKS023DataHandler(new File(directory, ("CASKS023DataRecords" + aggregation + ".dat")));
		this._CASKS09bDataHandler = new CASKS09bDataHandler(new File(directory, ("CASKS09bDataRecords" + aggregation + ".dat")));
		this._CASKS09cDataHandler = new CASKS09cDataHandler(new File(directory, ("CASKS09cDataRecords" + aggregation + ".dat")));
		this._CASKS12bDataHandler = new CASKS12bDataHandler(new File(directory, ("CASKS12bDataRecords" + aggregation + ".dat")));
		this._CASKS12cDataHandler = new CASKS12cDataHandler(new File(directory, ("CASKS12cDataRecords" + aggregation + ".dat")));
		this._CASKS14bDataHandler = new CASKS14bDataHandler(new File(directory, ("CASKS14bDataRecords" + aggregation + ".dat")));
		this._CASKS14cDataHandler = new CASKS14cDataHandler(new File(directory, ("CASKS14cDataRecords" + aggregation + ".dat")));
		this._CASUV003DataHandler = new CASUV003DataHandler(new File(directory, ("CASUV003DataRecords" + aggregation + ".dat")));
	}

	/**
	 * Initialises all fields.
     * @throws java.io.IOException
	 */
	protected void init() throws IOException {
		this._CAS001DataHandler = new CAS001DataHandler();
		this._CAS002DataHandler = new CAS002DataHandler();
		this._CAS003DataHandler = new CAS003DataHandler();
		this._CASKS002DataHandler = new CASKS002DataHandler();
		this._CASKS006DataHandler = new CASKS006DataHandler();
		this._CASKS008DataHandler = new CASKS008DataHandler();
		this._CASKS010DataHandler = new CASKS010DataHandler();
		this._CASKS015DataHandler = new CASKS015DataHandler();
		this._CASKS017DataHandler = new CASKS017DataHandler();
		this._CASKS020DataHandler = new CASKS020DataHandler();
		this._CASKS023DataHandler = new CASKS023DataHandler();
		this._CASKS09bDataHandler = new CASKS09bDataHandler();
		this._CASKS09cDataHandler = new CASKS09cDataHandler();
		this._CASKS12bDataHandler = new CASKS12bDataHandler();
		this._CASKS12cDataHandler = new CASKS12cDataHandler();
		this._CASKS14bDataHandler = new CASKS14bDataHandler();
		this._CASKS14cDataHandler = new CASKS14cDataHandler();
		this._CASUV003DataHandler = new CASUV003DataHandler();
	}

	/**
	 * @param args
	 *            the command line arguments
     * @throws java.io.IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO code application logic here
		CASDataHandler aCASDataHandler = new CASDataHandler();
		aCASDataHandler.run();
	}

	/**
	 * Top level run method
     * @throws java.io.IOException
	 */
	// private void run() throws IOException {
	public void run() throws IOException {
		// formatSourceData();
		aggregateOAToMSOAForLeeds();
		// aggregateOAToWardForLeeds();
	}

	/**
	 * Returns this._CASKS006DataHandler
     * @return 
	 */
	public CASKS006DataHandler getCASKS006DataHandler() {
		return this._CASKS006DataHandler;
	}

	/**
	 * @param aRecordID
	 *            The RecordID of the AbstractCASDataRecord to be returned.
     * @return 
	 */
	public AbstractCASDataRecord getDataRecord(long aRecordID) {
		return new CASDataRecord_2(this, aRecordID);
	}

	/**
	 * Load Source Data
     * @throws java.io.IOException
	 */
	public void formatSourceData() throws IOException {
		// Load source data
		boolean loadFromSource = true;
		int n = 5;
        File directory;
        directory = new File(
					"C:/work/data/census/2001/CAS/CAS/");
		_CAS001DataHandler.formatSourceData(directory,n);
		_CAS002DataHandler.formatSourceData(directory,n);
		_CAS003DataHandler.formatSourceData(directory,n);
        directory = new File(
					"C:/work/data/census/2001/CAS/KeyStatistics/");
		_CASKS002DataHandler.formatSourceData(directory,n);
		_CASKS006DataHandler.formatSourceData(directory,n);
		_CASKS008DataHandler.formatSourceData(directory,n);
		_CASKS09bDataHandler.formatSourceData(directory,n);
		_CASKS09cDataHandler.formatSourceData(directory,n);
		_CASKS010DataHandler.formatSourceData(directory,n);
		_CASKS12bDataHandler.formatSourceData(directory,n);
		_CASKS12cDataHandler.formatSourceData(directory,n);
		_CASKS14bDataHandler.formatSourceData(directory,n);
		_CASKS14cDataHandler.formatSourceData(directory,n);
		_CASKS015DataHandler.formatSourceData(directory,n);
		_CASKS017DataHandler.formatSourceData(directory,n);
		_CASKS020DataHandler.formatSourceData(directory,n);
		_CASKS023DataHandler.formatSourceData(directory,n);
        directory = new File(
					"C:/work/data/census/2001/CAS/UV/");
		_CASUV003DataHandler.formatSourceData(directory,n);
	}

	/**
	 * Aggregate From OA To Ward For Leeds
     * @throws java.io.IOException
	 */
	public void aggregateOAToWardForLeeds() throws IOException {
		super.aggregateOAToWardForLeeds();
		// Aggregate to Ward for Leeds
		long nrecordsInLeeds = 2439L; // 2439L
		long startRecordIDForLeeds = 56750L; // 56749L
		long startRecordID = startRecordIDForLeeds;
		long endRecordID = startRecordIDForLeeds + nrecordsInLeeds;
		File aFile;
		RandomAccessFile aRandomAccessFile;
		long nDataRecords;
		long along;
		PrintWriter aPrintWriter;

		// CASKS006DataRecords
		aFile = new File(
				"C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS006DataRecordsWard.dat");
		aFile.createNewFile();
		aRandomAccessFile = new RandomAccessFile(aFile, "rw");
		_CASKS006DataHandler.aggregateOAToWard(aRandomAccessFile,
				startRecordID, endRecordID);
		aRandomAccessFile.close();
		_CASKS006DataHandler = new CASKS006DataHandler(aFile);
		nDataRecords = _CASKS006DataHandler.getNDataRecords();
		System.out.println("nDataRecords " + nDataRecords);
		CASKS006DataRecord aCASKS006DataRecord = new CASKS006DataRecord();
		aFile = new File(
				"C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS006DataRecordsWard.csv");
		aPrintWriter = new PrintWriter(aFile);
		aPrintWriter.println(aCASKS006DataRecord.toCSVStringFields());
		for (along = 0L; along < nDataRecords; along++) {
			aCASKS006DataRecord = _CASKS006DataHandler
					.getCASKS006DataRecord(along);
			aPrintWriter.println(aCASKS006DataRecord.toCSVString());
			System.out.println(aCASKS006DataRecord.toString());
		}
		aPrintWriter.flush();
		aPrintWriter.close();
	}

	/**
	 * Aggregate From OA To MSOA For Leeds
     * @throws java.io.IOException
	 */
	public void aggregateOAToMSOAForLeeds() throws IOException {
		super.aggregateOAToMSOAForLeeds();
		// Aggregate to MSOA for Leeds
		long nrecordsInLeeds = 2439L;
		long startRecordIDForLeeds = 56749L;
		long startRecordID = startRecordIDForLeeds;
		long endRecordID = startRecordIDForLeeds + nrecordsInLeeds;
		File aFile;
		RandomAccessFile aRandomAccessFile;
		long nDataRecords;
		long along;
		PrintWriter aPrintWriter;

		// CASKS006DataRecords
		aFile = new File(
				"C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS006DataRecordsMSOA.dat");
		aFile.createNewFile();
		aRandomAccessFile = new RandomAccessFile(aFile, "rw");
		_CASKS006DataHandler.aggregateOAToMSOA(aRandomAccessFile,
				startRecordID, endRecordID);
		aRandomAccessFile.close();
		_CASKS006DataHandler = new CASKS006DataHandler(aFile);
		nDataRecords = _CASKS006DataHandler.getNDataRecords();
		System.out.println("nDataRecords " + nDataRecords);
		CASKS006DataRecord aCASKS006DataRecord = new CASKS006DataRecord();
		aFile = new File(
				"C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS006DataRecordsMSOA.csv");
		aPrintWriter = new PrintWriter(aFile);
		aPrintWriter.println(aCASKS006DataRecord.toCSVStringFields());
		for (along = 0L; along < nDataRecords; along++) {
			aCASKS006DataRecord = _CASKS006DataHandler
					.getCASKS006DataRecord(along);
			aPrintWriter.println(aCASKS006DataRecord.toCSVString());
			System.out.println(aCASKS006DataRecord.toString());
		}
		aPrintWriter.flush();
		aPrintWriter.close();
	}
}