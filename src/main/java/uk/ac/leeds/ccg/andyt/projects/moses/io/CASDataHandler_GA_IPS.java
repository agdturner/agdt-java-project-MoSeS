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

import uk.ac.leeds.ccg.andyt.census.cas.ks.Census_CASKS008DataRecord;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS044DataRecord;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS044DataHandler;
import uk.ac.leeds.ccg.andyt.census.cas.ks.Census_CASKS006DataRecord;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS001DataHandler;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataRecord;
import uk.ac.leeds.ccg.andyt.census.cas.ks.Census_CASKS006DataHandler;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS003DataRecord;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS003DataHandler;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataHandler;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS001DataRecord;
import uk.ac.leeds.ccg.andyt.census.cas.ks.Census_CASKS008DataHandler;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile; //import java.util.HashMap;

/**
 * A <code>class</code> for holding the following collection of
 * <code>AbstractCASDataHandlers</code> so as to access respective
 * <code>AbstractCASDataRecords</code>:
 * <ul>
 * <li>Census_CAS001DataHandler</li>
 * <li>Census_CAS003DataHandler</li>
 * <li>Census_CAS044DataHandler</li>
 * <li>Census_CASKS006DataHandler</li>
 * <li>Census_CASKS008DataHandler</li>
 * </ul>
 * <ul>
 * <li>Developed for <a href="http://www.ncess.ac.uk/moses">MoSeS</a>.</li>
 * <li>Copyright (C) 2006 <a
 * href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy Turner</a>, <a
 * href="http://www.leeds.ac.uk//">University of Leeds</a>.</li>
 * </ul>
 * 
 * @author <a href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy
 *         Turner</a>
 * @version 1.0.0, 2007-06-13
 * @see CASDataRecord
 */
public class CASDataHandler_GA_IPS extends Census_AbstractDataHandler {

    /**
     * Serializable class version number for swapping
     * (serialization/deserialization)
     */
    private static final long serialVersionUID = 1L;

    // /**
    // * Census_CAS001DataHandler
    // */
    // protected Census_CAS001DataHandler _CAS001DataHandler;

    // /**
    // * Census_CAS003DataHandler
    // */
    // protected Census_CAS003DataHandler _CAS003DataHandler;
    /**
     * Census_CAS044DataHandler
     */
    protected Census_CAS044DataHandler _CAS044DataHandler;
    /**
     * Census_CASKS006DataHandler
     */
    protected Census_CASKS006DataHandler _CASKS006DataHandler;
    /**
     * Census_CASKS008DataHandler
     */
    protected Census_CASKS008DataHandler _CASKS008DataHandler;

    /**
     * Creates a new CASDataHandler_GA_IPS
     * @throws java.io.IOException
     */
    public CASDataHandler_GA_IPS() throws IOException {
        init();
    }

    /**
     * Creates a new CASDataHandler_GA_IPS using <code>Files</code> in directory
     *
     * @param directory
     *            The directory containing <code>Files</code>
     * @param aggregation
     *            A <code>String</code> part of the filename indicating the
     *            aggregation (e.g. OA, MSOA, WARD, etc... )
     * @throws java.io.IOException
     */
    public CASDataHandler_GA_IPS(File directory, String aggregation)
            throws IOException {
        this.init(directory);
        this._CAS001DataHandler = new Census_CAS001DataHandler(new File(directory, ("CAS001DataRecords" + aggregation + ".dat")));
        this._CAS003DataHandler = new Census_CAS003DataHandler(new File(directory, ("CAS003DataRecords" + aggregation + ".dat")));
        this._CAS044DataHandler = new Census_CAS044DataHandler(new File(directory, ("CAS044DataRecords" + aggregation + ".dat")));
        this._CASKS006DataHandler = new Census_CASKS006DataHandler(new File(directory, ("CASKS006DataRecords" + aggregation + ".dat")));
        this._CASKS008DataHandler = new Census_CASKS008DataHandler(new File(directory, ("CASKS008DataRecords" + aggregation + ".dat")));
    }

    /**
     * Initialises all fields.
     * @throws java.io.IOException
     */
    protected void init() throws IOException {
        this._CAS001DataHandler = new Census_CAS001DataHandler();
        this._CAS003DataHandler = new Census_CAS003DataHandler();
        this._CAS044DataHandler = new Census_CAS044DataHandler();
        this._CASKS006DataHandler = new Census_CASKS006DataHandler();
        this._CASKS008DataHandler = new Census_CASKS008DataHandler();
    }

    /**
     * @param args
     *            the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        CASDataHandler_GA_IPS _CASDataHandler_1 = new CASDataHandler_GA_IPS();
        _CASDataHandler_1.run();
    }

    /**
     * Top level run method
     * @throws java.io.IOException
     */
    // private void run() throws IOException {
    public void run() throws IOException {
        // loadSourceData();
        aggregateOAToMSOAForLeeds();
    // aggregateOAToWardForLeeds();
    }

    // /**
    // * Returns this._CAS001DataHandler
    // */
    // public Census_CAS001DataHandler getCAS001DataHandler() {
    // return this._CAS001DataHandler;
    // }

    // /**
    // * Returns this._CAS003DataHandler
    // */
    // public Census_CAS003DataHandler getCAS003DataHandler() {
    // return this._CAS003DataHandler;
    // }
    /**
     * Returns this._CAS044DataHandler
     * @return 
     */
    public Census_CAS044DataHandler getCAS044DataHandler() {
        return this._CAS044DataHandler;
    }

    /**
     * Returns this._CASKS006DataHandler
     * @return 
     */
    public Census_CASKS006DataHandler getCASKS006DataHandler() {
        return this._CASKS006DataHandler;
    }

    /**
     * Returns this._CASKS008DataHandler
     * @return 
     */
    public Census_CASKS008DataHandler getCASKS008DataHandler() {
        return this._CASKS008DataHandler;
    }

    /**
     * @param aRecordID
     * The RecordID of the Census_AbstractDataRecord to be returned.
     * @return 
     */
    public Census_AbstractDataRecord getDataRecord(long aRecordID) {
        return new CASDataRecord_1(
                this, aRecordID);
    }

    /**
     * Load Source Data
     * @throws java.io.IOException
     */
    public void loadSourceData() throws IOException {

    }

    /**
     * Aggregate From OA To Ward For Leeds
     * @throws java.io.IOException
     */
    public void aggregateOAToWardForLeeds() throws IOException {
        // Aggregate to Ward for Leeds
        long nrecordsInLeeds = 2439L; // 2439L
        long startRecordIDForLeeds = 56750L; // 56749L
        long startRecordID = startRecordIDForLeeds;
        long endRecordID = startRecordIDForLeeds + nrecordsInLeeds;
        File aFile;
        RandomAccessFile _RandomAccessFile;
        long nDataRecords;
        long along;
        PrintWriter _PrintWriter;

        // CAS001DataRecords
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS001DataRecordsWard.dat");
        aFile.createNewFile();
        _RandomAccessFile = new RandomAccessFile(aFile, "rw");
        _CAS001DataHandler.aggregateOAToWard(_RandomAccessFile, startRecordID,
                endRecordID);
        _RandomAccessFile.close();
        _CAS001DataHandler = new Census_CAS001DataHandler(aFile);
        nDataRecords = _CAS001DataHandler.getNDataRecords();
        System.out.println("nDataRecords " + nDataRecords);
        Census_CAS001DataRecord _CAS001DataRecord = new Census_CAS001DataRecord();
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS001DataRecordsWard.csv");
        _PrintWriter = new PrintWriter(aFile);
        _PrintWriter.println(_CAS001DataRecord.toCSVStringFields());
        for (along = 0L; along < nDataRecords; along++) {
            _CAS001DataRecord = _CAS001DataHandler.getCAS001DataRecord(along);
            _PrintWriter.println(_CAS001DataRecord.toCSVString());
            System.out.println(_CAS001DataRecord.toString());
        }
        _PrintWriter.flush();
        _PrintWriter.close();

        // CAS003DataRecords
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS003DataRecordsWard.dat");
        aFile.createNewFile();
        _RandomAccessFile = new RandomAccessFile(aFile, "rw");
        _CAS003DataHandler.aggregateOAToWard(_RandomAccessFile, startRecordID,
                endRecordID);
        _RandomAccessFile.close();
        _CAS003DataHandler = new Census_CAS003DataHandler(aFile);
        nDataRecords = _CAS003DataHandler.getNDataRecords();
        System.out.println("nDataRecords " + nDataRecords);
        Census_CAS003DataRecord _CAS003DataRecord = new Census_CAS003DataRecord();
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS003DataRecordsWard.csv");
        _PrintWriter = new PrintWriter(aFile);
        _PrintWriter.println(_CAS003DataRecord.toCSVStringFields());
        for (along = 0L; along < nDataRecords; along++) {
            _CAS003DataRecord = _CAS003DataHandler.getCAS003DataRecord(along);
            _PrintWriter.println(_CAS003DataRecord.toCSVString());
            System.out.println(_CAS003DataRecord.toString());
        }
        _PrintWriter.flush();
        _PrintWriter.close();

        // CAS044DataRecords
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS044DataRecordsWard.dat");
        aFile.createNewFile();
        _RandomAccessFile = new RandomAccessFile(aFile, "rw");
        _CAS003DataHandler.aggregateOAToWard(_RandomAccessFile, startRecordID,
                endRecordID);
        _RandomAccessFile.close();
        _CAS044DataHandler = new Census_CAS044DataHandler(aFile);
        nDataRecords = _CAS044DataHandler.getNDataRecords();
        System.out.println("nDataRecords " + nDataRecords);
        Census_CAS044DataRecord _CAS044DataRecord = new Census_CAS044DataRecord();
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS044DataRecordsWard.csv");
        _PrintWriter = new PrintWriter(aFile);
        _PrintWriter.println(_CAS003DataRecord.toCSVStringFields());
        for (along = 0L; along < nDataRecords; along++) {
            _CAS044DataRecord = _CAS044DataHandler.getCAS044DataRecord(along);
            _PrintWriter.println(_CAS044DataRecord.toCSVString());
            System.out.println(_CAS044DataRecord.toString());
        }
        _PrintWriter.flush();
        _PrintWriter.close();

        // CASKS006DataRecords
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS006DataRecordsWard.dat");
        aFile.createNewFile();
        _RandomAccessFile = new RandomAccessFile(aFile, "rw");
        _CASKS006DataHandler.aggregateOAToWard(_RandomAccessFile,
                startRecordID, endRecordID);
        _RandomAccessFile.close();
        _CASKS006DataHandler = new Census_CASKS006DataHandler(aFile);
        nDataRecords = _CASKS006DataHandler.getNDataRecords();
        System.out.println("nDataRecords " + nDataRecords);
        Census_CASKS006DataRecord aCASKS006DataRecord = new Census_CASKS006DataRecord();
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS006DataRecordsWard.csv");
        _PrintWriter = new PrintWriter(aFile);
        _PrintWriter.println(aCASKS006DataRecord.toCSVStringFields());
        for (along = 0L; along < nDataRecords; along++) {
            aCASKS006DataRecord = _CASKS006DataHandler.getCASKS006DataRecord(along);
            _PrintWriter.println(aCASKS006DataRecord.toCSVString());
            System.out.println(aCASKS006DataRecord.toString());
        }
        _PrintWriter.flush();
        _PrintWriter.close();

        // CASKS008DataRecords
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS008DataRecordsWard.dat");
        aFile.createNewFile();
        _RandomAccessFile = new RandomAccessFile(aFile, "rw");
        _CASKS008DataHandler.aggregateOAToWard(_RandomAccessFile,
                startRecordID, endRecordID);
        _RandomAccessFile.close();
        _CASKS008DataHandler = new Census_CASKS008DataHandler(aFile);
        nDataRecords = _CASKS008DataHandler.getNDataRecords();
        System.out.println("nDataRecords " + nDataRecords);
        Census_CASKS008DataRecord aCASKS008DataRecord = new Census_CASKS008DataRecord();
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS008DataRecordsWard.csv");
        _PrintWriter = new PrintWriter(aFile);
        _PrintWriter.println(aCASKS008DataRecord.toCSVStringFields());
        for (along = 0L; along < nDataRecords; along++) {
            aCASKS008DataRecord = _CASKS008DataHandler.getCASKS008DataRecord(along);
            _PrintWriter.println(aCASKS008DataRecord.toCSVString());
            System.out.println(aCASKS008DataRecord.toString());
        }
        _PrintWriter.flush();
        _PrintWriter.close();
    }

    /**
     * Aggregate From OA To MSOA For Leeds
     * @throws java.io.IOException
     */
    public void aggregateOAToMSOAForLeeds() throws IOException {
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

        // CAS001DataRecords
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS001DataRecordsMSOA.dat");
        aFile.createNewFile();
        aRandomAccessFile = new RandomAccessFile(aFile, "rw");
        _CAS001DataHandler.aggregateOAToMSOA(aRandomAccessFile, startRecordID,
                endRecordID);
        aRandomAccessFile.close();
        _CAS001DataHandler = new Census_CAS001DataHandler(aFile);
        nDataRecords = _CAS001DataHandler.getNDataRecords();
        System.out.println("nDataRecords " + nDataRecords);
        Census_CAS001DataRecord aCAS001DataRecord = new Census_CAS001DataRecord();
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS001DataRecordsMSOA.csv");
        aPrintWriter = new PrintWriter(aFile);
        aPrintWriter.println(aCAS001DataRecord.toCSVStringFields());
        for (along = 0L; along < nDataRecords; along++) {
            aCAS001DataRecord = _CAS001DataHandler.getCAS001DataRecord(along);
            aPrintWriter.println(aCAS001DataRecord.toCSVString());
            System.out.println(aCAS001DataRecord.toString());
        }
        aPrintWriter.flush();
        aPrintWriter.close();

        // CAS003DataRecords
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS003DataRecordsMSOA.dat");
        aFile.createNewFile();
        aRandomAccessFile = new RandomAccessFile(aFile, "rw");
        _CAS003DataHandler.aggregateOAToMSOA(aRandomAccessFile, startRecordID,
                endRecordID);
        aRandomAccessFile.close();
        _CAS003DataHandler = new Census_CAS003DataHandler(aFile);
        nDataRecords = _CAS003DataHandler.getNDataRecords();
        System.out.println("nDataRecords " + nDataRecords);
        Census_CAS003DataRecord aCAS003DataRecord = new Census_CAS003DataRecord();
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS003DataRecordsMSOA.csv");
        aPrintWriter = new PrintWriter(aFile);
        aPrintWriter.println(aCAS003DataRecord.toCSVStringFields());
        for (along = 0L; along < nDataRecords; along++) {
            aCAS003DataRecord = _CAS003DataHandler.getCAS003DataRecord(along);
            aPrintWriter.println(aCAS003DataRecord.toCSVString());
            System.out.println(aCAS003DataRecord.toString());
        }
        aPrintWriter.flush();
        aPrintWriter.close();

        // CAS044DataRecords
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS044DataRecordsMSOA.dat");
        aFile.createNewFile();
        aRandomAccessFile = new RandomAccessFile(aFile, "rw");
        _CAS044DataHandler.aggregateOAToMSOA(aRandomAccessFile, startRecordID,
                endRecordID);
        aRandomAccessFile.close();
        _CAS044DataHandler = new Census_CAS044DataHandler(aFile);
        nDataRecords = _CAS044DataHandler.getNDataRecords();
        System.out.println("nDataRecords " + nDataRecords);
        Census_CAS044DataRecord aCAS044DataRecord = new Census_CAS044DataRecord();
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS044DataRecordsMSOA.csv");
        aPrintWriter = new PrintWriter(aFile);
        aPrintWriter.println(aCAS044DataRecord.toCSVStringFields());
        for (along = 0L; along < nDataRecords; along++) {
            aCAS044DataRecord = _CAS044DataHandler.getCAS044DataRecord(along);
            aPrintWriter.println(aCAS044DataRecord.toCSVString());
            System.out.println(aCAS044DataRecord.toString());
        }
        aPrintWriter.flush();
        aPrintWriter.close();

        // CASKS006DataRecords
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS006DataRecordsMSOA.dat");
        aFile.createNewFile();
        aRandomAccessFile = new RandomAccessFile(aFile, "rw");
        _CASKS006DataHandler.aggregateOAToMSOA(aRandomAccessFile,
                startRecordID, endRecordID);
        aRandomAccessFile.close();
        _CASKS006DataHandler = new Census_CASKS006DataHandler(aFile);
        nDataRecords = _CASKS006DataHandler.getNDataRecords();
        System.out.println("nDataRecords " + nDataRecords);
        Census_CASKS006DataRecord aCASKS006DataRecord = new Census_CASKS006DataRecord();
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS006DataRecordsMSOA.csv");
        aPrintWriter = new PrintWriter(aFile);
        aPrintWriter.println(aCASKS006DataRecord.toCSVStringFields());
        for (along = 0L; along < nDataRecords; along++) {
            aCASKS006DataRecord = _CASKS006DataHandler.getCASKS006DataRecord(along);
            aPrintWriter.println(aCASKS006DataRecord.toCSVString());
            System.out.println(aCASKS006DataRecord.toString());
        }
        aPrintWriter.flush();
        aPrintWriter.close();

        // CASKS008DataRecords
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS008DataRecordsMSOA.dat");
        aFile.createNewFile();
        aRandomAccessFile = new RandomAccessFile(aFile, "rw");
        _CASKS008DataHandler.aggregateOAToMSOA(aRandomAccessFile,
                startRecordID, endRecordID);
        aRandomAccessFile.close();
        _CASKS008DataHandler = new Census_CASKS008DataHandler(aFile);
        nDataRecords = _CASKS008DataHandler.getNDataRecords();
        System.out.println("nDataRecords " + nDataRecords);
        Census_CASKS008DataRecord aCASKS008DataRecord = new Census_CASKS008DataRecord();
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS008DataRecordsMSOA.csv");
        aPrintWriter = new PrintWriter(aFile);
        aPrintWriter.println(aCASKS008DataRecord.toCSVStringFields());
        for (along = 0L; along < nDataRecords; along++) {
            aCASKS008DataRecord = _CASKS008DataHandler.getCASKS008DataRecord(along);
            aPrintWriter.println(aCASKS008DataRecord.toCSVString());
            System.out.println(aCASKS008DataRecord.toString());
        }
        aPrintWriter.flush();
        aPrintWriter.close();
    }

    /**
     * @return The number of <code>AbstractDataRecords</code> in
     *         <code>this.tRandomAccessFile</code> For full UK file this should
     *         be 18435255
     */
    @Override
    public long getNDataRecords() {
        return this._CAS003DataHandler.getNDataRecords();
    }
}