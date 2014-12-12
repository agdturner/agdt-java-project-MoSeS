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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;

/**
 * Class for handling an individual CAS001DataRecords.
 */
public class CAS002DataHandler extends AbstractCASDataHandler {

    /**
     * Creates a new instance of CAS002DataHandler loading a default file.
     */
    public CAS002DataHandler() {
        File directory = new File("C:/Work/Projects/MoSeS/Workspace/");
        this.init(directory);
        try {
            this._File = new File(directory, "CAS002DataRecords.dat");
            if (!this._File.exists()) {
                this._File.createNewFile();
            }
            this._RecordLength = new CAS002DataRecord().getSizeInBytes();
            // log("this.recordLength " + this.recordLength);
            this._RandomAccessFile = new RandomAccessFile(this._File, "r");
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    /**
     * Creates a new instance of CAS002DataHandler with Records loaded from
     * aFile.
     * @param aFile
     * Formatted file of CAS002DataRecords.
     */
    public CAS002DataHandler(File aFile) {
        // initMemoryReserve();
        init(aFile.getParentFile());
        this._RecordLength = new CAS002DataRecord().getSizeInBytes();
        load(aFile);
        log("CAS002DataRecords loaded successfully");
    }

    /**
     * Loads <code>CAS002DataRecords</code> and prints out n randomly
     * @param directory to load source data from
     * @param n the number of loaded data records to print out.
     * @throws java.io.IOException
     */
    protected void formatSourceData(
            File directory,
            int n)
            throws IOException {
        _RandomAccessFile = new RandomAccessFile(this._File, "rw");
        // Load from source
        File infile;
        long long0 = 0L;
        long RecordID = 0L;
        // Load England
        infile = new File(
                directory,
                "CAS002EnglandOA.csv");
        RecordID = format(infile, RecordID);
        log(infile.toString() + " formatted successfully " + RecordID + " records"); // 165665
        long0 = RecordID;
        // Load Wales
        infile = new File(
                directory,
                "CAS002WalesOA.csv");
        RecordID = format(infile, RecordID);
        log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 9769
        long0 = RecordID;
        // Load Scotland
        infile = new File(
                directory,
                "CAS002ScotlandOA.csv");
        RecordID = format(infile, RecordID);
        log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 42604
        long0 = RecordID;
        // Load Northern Ireland
        infile = new File(
                directory,
                "CAS002NorthernIrelandOA.csv");
        RecordID = format(infile, RecordID);
        log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 5022
        _RandomAccessFile.close();
        load(_File);
        print(20, new Random());
    }

    /**
     * Aggregate From OA To Ward For Leeds
     * @throws java.io.IOException
     */
    public void aggregateOAToWardForLeeds() throws IOException {
        long nrecordsInLeeds = 2439L;
        long startRecordIDForLeeds = 56749L;
        long startRecordID = startRecordIDForLeeds;
        long endRecordID = startRecordIDForLeeds + nrecordsInLeeds;
        File aFile;
        RandomAccessFile aRandomAccessFile;
        long nDataRecords;
        long along;
        PrintWriter aPrintWriter;
        // CAS002DataRecords
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS002DataRecordsWard.dat");
        aFile.createNewFile();
        aRandomAccessFile = new RandomAccessFile(aFile, "rw");
        aggregateOAToWard(aRandomAccessFile, startRecordID, endRecordID);
        aRandomAccessFile.close();
        CAS002DataHandler tCAS002DataHandler = new CAS002DataHandler(aFile);
        nDataRecords = tCAS002DataHandler.getNDataRecords();
        log("nDataRecords " + nDataRecords);
        CAS002DataRecord aCAS002DataRecord = new CAS002DataRecord();
        aFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS002DataRecordsWard.csv");
        aPrintWriter = new PrintWriter(aFile);
        aPrintWriter.println(aCAS002DataRecord.toCSVStringFields());
        for (along = 0L; along < nDataRecords; along++) {
            aCAS002DataRecord = tCAS002DataHandler.getCAS002DataRecord(along);
            aPrintWriter.println(aCAS002DataRecord.toCSVString());
            log(aCAS002DataRecord.toString());
        }
        aPrintWriter.flush();
        aPrintWriter.close();
    }

    /**
     * Uses a <code>BufferedReader<code> and a <code>StreamTokenizer</code> to
     * read lines from the sourceFile <code>File</code>. The lines are converted
     * to <code>CAS002DataRecords</code> and written to
     * <code>this.tRandomAccessFile</code>.
     *
     * @param sourceFile
     *            The source CAS002DataRecords file to be formatted and written
     *            to <code>this.tRandomAccessFile</code>.
     * @param RecordID
     *            The <code>RecordID</code> to assign to the first
     *            <code>CAS002DataRecord</code>.
     * @return The <code>RecordID</code> assigned to the last
     *         <code>CAS002DataRecords</code>.
     * @throws java.io.IOException
     */
    protected long format(
            File sourceFile,
            long RecordID)
            throws IOException {
        BufferedReader aBufferedReader =
                new BufferedReader(
                new InputStreamReader(
                new FileInputStream(sourceFile)));
        StreamTokenizer aStreamTokenizer = new StreamTokenizer(aBufferedReader);
        Generic_StaticIO.setStreamTokenizerSyntax1(aStreamTokenizer);
        String string0 = new String();
        String string1;
        String string2;
        long long0;
        long longZero = 0L;
        CAS002DataRecord aCAS002DataRecord = new CAS002DataRecord();
        boolean print = false;
        int int10000 = 10000;
        // Skip the first line
        int tokenType = aStreamTokenizer.nextToken();
        while (tokenType != StreamTokenizer.TT_EOL) {
            tokenType = aStreamTokenizer.nextToken();
        }
        tokenType = aStreamTokenizer.nextToken();
        while (tokenType != StreamTokenizer.TT_EOF) {
            switch (tokenType) {
                case StreamTokenizer.TT_EOL:
                    long0 = RecordID % int10000;
                    print = (long0 == longZero);
                    if (print) {
                        string2 = aCAS002DataRecord.toString();
                        log(string2);
                        string2 = string0;
                    }
                    // Write out
                    aCAS002DataRecord.write(_RandomAccessFile);
                    RecordID++;
                    break;
                case StreamTokenizer.TT_WORD:
                    string1 = aStreamTokenizer.sval;
                    aCAS002DataRecord = new CAS002DataRecord(RecordID, string1);
                    break;
            }
            string1 = string0;
            tokenType = aStreamTokenizer.nextToken();
        }
        log("Number of Records loaded = " + RecordID);
        return RecordID;
    }

    /**
     * @return a <code>CAS002DataRecord</code> with
     *         <code>AbstractCASDataRecord.RecordID = RecordID</code>
     * @param RecordID
     *            The RecordID of the CAS002DataRecord to be returned.
     */
    public AbstractCASDataRecord getDataRecord(long RecordID) {
        return getCAS002DataRecord(RecordID);
    }

    /**
     * @return a <code>CAS002DataRecord</code> with
     *         <code>CAS002DataRecord.RecordID = RecordID</code>
     * @param RecordID
     *            The RecordID of the CAS002DataRecord to be returned.
     */
    public CAS002DataRecord getCAS002DataRecord(long RecordID) {
        CAS002DataRecord result = null;
        try {
            this._RandomAccessFile.seek(_RecordLength * RecordID);
            result = new CAS002DataRecord(this._RandomAccessFile);
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        return result;
    }

    /**
     * Aggregates <code>CAS002DataRecords</code> from OA To Ward for the OA
     * records in the range [startRecordID,endRecordID] and writes the results
     * to aRandomAccessFile
     *
     * @param aRandomAccessFile
     *            <code>RandomAccessFile</code> to which results are written
     * @param startRecordID
     *            The first OA RecordID in the sequence to be aggregated.
     * @param endRecordID
     *            The last OA RecordID in the sequence to be aggregated.
     * @throws java.io.IOException
     */
    public void aggregateOAToWard(
            RandomAccessFile aRandomAccessFile,
            long startRecordID,
            long endRecordID)
            throws IOException {
        TreeMap result = new TreeMap();
        CAS002DataRecord aCAS002DataRecord;
        CAS002DataRecord bCAS002DataRecord;
        String zoneCode;
        Object zoneCodeWard;
        // long newRecordID = startRecordIDForLeeds - 1L;
        long newRecordID = -1L;
        for (long RecordID = startRecordID; RecordID < endRecordID; RecordID++) {
            aCAS002DataRecord = (CAS002DataRecord) getDataRecord(RecordID);
            zoneCode = new String(aCAS002DataRecord.getZone_Code());
            zoneCodeWard = zoneCode.substring(0, 6);
            if (result.containsKey(zoneCodeWard)) {
                bCAS002DataRecord = (CAS002DataRecord) result.get(zoneCodeWard);
                result.remove(zoneCodeWard);
                result.put(zoneCodeWard, aCAS002DataRecord.aggregate(bCAS002DataRecord));
            } else {
                result.put(zoneCodeWard, aCAS002DataRecord);
            }
        }
        write(aRandomAccessFile, result);
    }

    /**
     * Aggregates <code>CAS002DataRecords</code> from OA To MSOA for the OA
     * records in the range [startRecordID,endRecordID] and writes the results
     * to aRandomAccessFile
     *
     * @param aRandomAccessFile
     *            <code>RandomAccessFile</code> to which results are written
     * @param startRecordID
     *            The first OA RecordID in the sequence to be aggregated.
     * @param endRecordID
     *            The last OA RecordID in the sequence to be aggregated.
     * @throws java.io.IOException
     */
    public void aggregateOAToMSOA(
            RandomAccessFile aRandomAccessFile,
            long startRecordID,
            long endRecordID)
            throws IOException {
        TreeMap result = new TreeMap();
        HashMap lookUpMSOAfromOAHashMap = get_LookUpMSOAfromOAHashMap();
        CAS002DataRecord aCAS002DataRecord;
        CAS002DataRecord bCAS002DataRecord;
        String zoneCode;
        Object zoneCodeMSOA;
        // long newRecordID = startRecordIDForLeeds - 1L;
        long newRecordID = -1L;
        for (long RecordID = startRecordID; RecordID < endRecordID; RecordID++) {
            aCAS002DataRecord = (CAS002DataRecord) getDataRecord(RecordID);
            zoneCode = new String(aCAS002DataRecord.getZone_Code());
            zoneCodeMSOA = lookUpMSOAfromOAHashMap.get(zoneCode);
            if (result.containsKey(zoneCodeMSOA)) {
                bCAS002DataRecord = (CAS002DataRecord) result.get(zoneCodeMSOA);
                result.remove(zoneCodeMSOA);
                result.put(zoneCodeMSOA, aCAS002DataRecord.aggregate(bCAS002DataRecord));
            } else {
                result.put(zoneCodeMSOA, aCAS002DataRecord);
            }
        }
        write(aRandomAccessFile, result);
    }
}