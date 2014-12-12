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
import java.io.RandomAccessFile;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;
import uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataHandler.AgeSexType;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;

/**
 * Class for handling an individual CAS003DataRecords.
 */
public class CAS003DataHandler extends AbstractCASDataHandler {

    /**
     * Creates a new instance of CAS003DataHandler loading a default file.
     */
    public CAS003DataHandler() {
        File directory = new File("C:/Work/Projects/MoSeS/Workspace/");
        this.init(directory);
        try {
            this._File = new File(directory, "CAS003DataRecords.dat");
            if (!this._File.exists()) {
                this._File.createNewFile();
            }
            this._RecordLength = new CAS003DataRecord().getSizeInBytes();
            // log("this.recordLength " + this.recordLength);
            this._RandomAccessFile = new RandomAccessFile(this._File, "r");
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    /**
     * Creates a new instance of CAS003DataHandler with Records loaded from
     * aFile.
     * @param aFile
     * Formatted file of CAS003DataRecords.
     */
    public CAS003DataHandler(File aFile) {
        // initMemoryReserve();
        this.init(aFile.getParentFile());
        this._RecordLength = new CAS003DataRecord().getSizeInBytes();
        load(aFile);
        log("CAS003DataRecords loaded successfully");
    }

    protected void formatSourceData(
            File directory,
            int n)
            throws IOException {
        _RandomAccessFile = new RandomAccessFile(this._File, "rw");
        File infile;
        long long0 = 0L;
        long RecordID = 0L;
        // Load England
        infile = new File(
                directory,
                "CAS003EnglandOA.csv");
        RecordID = format(infile, RecordID);
        log(infile.toString() + " formatted successfully " + RecordID + " records"); // 165665
        long0 = RecordID;
        // Load Wales
        infile = new File(
                directory,
                "CAS003WalesOA.csv");
        RecordID = format(infile, RecordID);
        log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 9769
        long0 = RecordID;
        // Load Scotland
        infile = new File(
                directory,
                "CAS003ScotlandOA.csv");
        RecordID = format(infile, RecordID);
        log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 42604
        long0 = RecordID;
        // Different Table Layout for Northern Ireland
        // Load Northern Ireland
        infile = new File(
                directory,
                "CAS003NorthernIrelandOA.csv");
        RecordID = format(infile, RecordID, true);
        log(infile.toString() + " formatted successfully " + (RecordID - long0) + " records"); // 5022
        _RandomAccessFile.close();
        load(_File);
        print(20, new Random());
    }

    protected long format(
            File sourceFile,
            long RecordID) throws IOException {
        BufferedReader aBufferedReader =
                new BufferedReader(
                new InputStreamReader(
                new FileInputStream(sourceFile)));
        StreamTokenizer aStreamTokenizer =
                new StreamTokenizer(aBufferedReader);
        Generic_StaticIO.setStreamTokenizerSyntax1(aStreamTokenizer);
        String string0 = new String();
        String string1;
        String string2;
        long long0;
        long longZero = 0L;
        CAS003DataRecord aCAS003DataRecord = new CAS003DataRecord();
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
                        string2 = aCAS003DataRecord.toString();
                        log(string2);
                        string2 = string0;
                    }
                    // Write out
                    aCAS003DataRecord.write(_RandomAccessFile);
                    RecordID++;
                    break;
                case StreamTokenizer.TT_WORD:
                    string1 = aStreamTokenizer.sval;
                    aCAS003DataRecord = new CAS003DataRecord(RecordID, string1);
                    break;
            }
            string1 = string0;
            tokenType = aStreamTokenizer.nextToken();
        }
        log("Number of Records loaded = " + RecordID);
        return RecordID;
    }

    protected long format(
            File sourceFile,
            long RecordID,
            boolean Northern_Ireland) {
        try {
            BufferedReader aBufferedReader =
                    new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(sourceFile)));
            StreamTokenizer aStreamTokenizer =
                    new StreamTokenizer(aBufferedReader);
            Generic_StaticIO.setStreamTokenizerSyntax1(aStreamTokenizer);
            String string0 = new String();
            String string1;
            String string2;
            long long0;
            long longZero = 0L;
            CAS003DataRecord aCAS003DataRecord = new CAS003DataRecord();
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
                            string2 = aCAS003DataRecord.toString();
                            log(string2);
                            string2 = string0;
                        }
                        // Write out
                        aCAS003DataRecord.write(_RandomAccessFile);
                        RecordID++;
                        break;
                    case StreamTokenizer.TT_WORD:
                        string1 = aStreamTokenizer.sval;
                        aCAS003DataRecord = new CAS003DataRecord(RecordID, string1,
                                Northern_Ireland);
                        break;
                }
                string1 = string0;
                tokenType = aStreamTokenizer.nextToken();
            }
            log("Number of Records loaded = " + RecordID);
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        return RecordID;
    }

    /**
     * @return a <code>CAS003DataRecord</code> with
     *         <code>AbstractCASDataRecord.RecordID = RecordID</code>
     * @param RecordID
     *            The RecordID of the CAS003DataRecord to be returned.
     */
    public AbstractCASDataRecord getDataRecord(long RecordID) {
        return getCAS003DataRecord(RecordID);
    }

    /**
     * @return a <code>CAS003DataRecord</code> with
     *         <code>CAS003DataRecord.RecordID = RecordID</code>
     * @param RecordID
     *            The RecordID of the CAS003DataRecord to be returned.
     */
    public CAS003DataRecord getCAS003DataRecord(long RecordID) {
        CAS003DataRecord result = null;
        try {
            this._RandomAccessFile.seek(_RecordLength * RecordID);
            result = new CAS003DataRecord(this._RandomAccessFile);
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        return result;
    }

    /**
     * Aggregates <code>CAS003DataRecords</code> from OA To Ward for the OA
     * records in the range [startRecordID,endRecordID] and writes the results
     * to aRandomAccessFile
     *
     * @param aRandomAccessFile
     *            <code>RandomAccessFile</code> to which results are written
     * @param startRecordID
     *            The first OA RecordID in the sequence to be aggregated.
     * @param endRecordID
     *            The last OA RecordID in the sequence to be aggregated.
     */
    public void aggregateOAToWard(
            RandomAccessFile aRandomAccessFile,
            long startRecordID,
            long endRecordID) {
        TreeMap result = new TreeMap();
        CAS003DataRecord aCAS003DataRecord;
        CAS003DataRecord bCAS003DataRecord;
        String zoneCode;
        Object zoneCodeWard;
        // long newRecordID = startRecordIDForLeeds - 1L;
        long newRecordID = -1L;
        for (long RecordID = startRecordID; RecordID < endRecordID; RecordID++) {
            aCAS003DataRecord = (CAS003DataRecord) getDataRecord(RecordID);
            zoneCode = new String(aCAS003DataRecord.getZone_Code());
            zoneCodeWard = zoneCode.substring(0, 6);
            if (result.containsKey(zoneCodeWard)) {
                bCAS003DataRecord = (CAS003DataRecord) result.get(zoneCodeWard);
                result.remove(zoneCodeWard);
                result.put(zoneCodeWard, aCAS003DataRecord.aggregate(bCAS003DataRecord));
            } else {
                result.put(zoneCodeWard, aCAS003DataRecord);
            }
        }
        try {
            write(aRandomAccessFile, result);
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    /**
     * Aggregates <code>CAS003DataRecords</code> from OA To MSOA for the OA
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
            long endRecordID) throws IOException {
        TreeMap result = new TreeMap();
        HashMap lookUpMSOAfromOAHashMap = get_LookUpMSOAfromOAHashMap();
        CAS003DataRecord aCAS003DataRecord;
        CAS003DataRecord bCAS003DataRecord;
        String zoneCode;
        Object zoneCodeMSOA;
        // long newRecordID = startRecordIDForLeeds - 1L;
        long newRecordID = -1L;
        for (long RecordID = startRecordID; RecordID < endRecordID; RecordID++) {
            aCAS003DataRecord = (CAS003DataRecord) getDataRecord(RecordID);
            zoneCode = new String(aCAS003DataRecord.getZone_Code());
            zoneCodeMSOA = lookUpMSOAfromOAHashMap.get(zoneCode);
            if (result.containsKey(zoneCodeMSOA)) {
                bCAS003DataRecord = (CAS003DataRecord) result.get(zoneCodeMSOA);
                result.remove(zoneCodeMSOA);
                result.put(zoneCodeMSOA, aCAS003DataRecord.aggregate(bCAS003DataRecord));
            } else {
                result.put(zoneCodeMSOA, aCAS003DataRecord);
            }
        }
        write(aRandomAccessFile, result);
    }

    /**
     * @param tCAS003DataRecord
     * @param tISARDataHandler
     * @return HashMap with keys as AgeSexType and values as Integer.
     * These are counts for male and female household reference persons of
     * the following ages:
     * 0,20,30,60 
     */
    public HashMap getCAS003AgeSex1_AgeSexType_Count_HashMap(
            CAS003DataRecord tCAS003DataRecord,
            ISARDataHandler tISARDataHandler) {
        HashMap tCAS003_AgeSexType_Count_HashMap = new HashMap();
        short type = 1;
        boolean sex;
        AgeSexType aAgeSexType;
        int ageCount = 0;

        short[] ages = new short[4];
        ages[0] = 0;
        ages[1] = 20;
        ages[2] = 30;
        ages[3] = 60;

        // Male
        sex = true;
        for (int i = 0; i < ages.length; i++) {
            aAgeSexType = tISARDataHandler.new AgeSexType(
                    ages[i],
                    sex,
                    type);
            if (ages[i] == 0) {
                ageCount =
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge19AndUnder();
            }
            if (ages[i] == 20) {
                ageCount =
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge20to24() +
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge25to29();
            }
            if (ages[i] == 30) {
                ageCount =
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge30to44() +
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge45to59();
            }
            if (ages[i] == 60) {
                ageCount =
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge60to64() +
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge65to74() +
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge75to84() +
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge85AndOver();
            }
            tCAS003_AgeSexType_Count_HashMap.put(aAgeSexType, ageCount);
        }
        // Female
        sex = false;
        for (int i = 0; i < ages.length; i++) {
            aAgeSexType = tISARDataHandler.new AgeSexType(
                    ages[i],
                    sex,
                    type);
            if (ages[i] == 0) {
                ageCount =
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge19AndUnder();
            }
            if (ages[i] == 20) {
                ageCount =
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge20to24() +
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge25to29();
            }
            if (ages[i] == 30) {
                ageCount =
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge30to44() +
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge45to59();
            }
            if (ages[i] == 60) {
                ageCount =
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge60to64() +
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge65to74() +
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge75to84() +
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge85AndOver();
            }
            tCAS003_AgeSexType_Count_HashMap.put(aAgeSexType, ageCount);
        }
        return tCAS003_AgeSexType_Count_HashMap;
    }

    /**
     * @param tCAS003DataRecord
     * @return HashMap with keys as Integer for age and values as Integer for
     * counts of these ages of female household reference persons for the
     * following ages:
     * 0,20,30,60
     */
    public HashMap getCAS003HPHRPAgeFemaleCount_HashMap(
            CAS003DataRecord tCAS003DataRecord) {
        HashMap tCAS003_AgeSexType_Count_HashMap = new HashMap();
        int ageCount = 0;

        short[] ages = new short[4];
        ages[0] = 0;
        ages[1] = 20;
        ages[2] = 30;
        ages[3] = 60;

        for (int i = 0; i < ages.length; i++) {
            if (ages[i] == 0) {
                ageCount =
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge19AndUnder();
            }
            if (ages[i] == 20) {
                ageCount =
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge20to24() +
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge25to29();
            }
            if (ages[i] == 30) {
                ageCount =
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge30to44() +
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge45to59();
            }
            if (ages[i] == 60) {
                ageCount =
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge60to64() +
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge65to74() +
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge75to84() +
                        tCAS003DataRecord.getFemaleHRPHouseholdsTotalAge85AndOver();
            }
            tCAS003_AgeSexType_Count_HashMap.put(ages[i], ageCount);
        }
        return tCAS003_AgeSexType_Count_HashMap;
    }

    /**
     * @param tCAS003DataRecord
     * @return HashMap with keys as Integer for age and values as Integer for
     * counts of these ages of male household reference persons for the
     * following ages:
     * 0,20,30,60
     */
    public HashMap getCAS003HPHRPAgeMaleCount_HashMap(
            CAS003DataRecord tCAS003DataRecord) {
        HashMap tCAS003_AgeSexType_Count_HashMap = new HashMap();
        int ageCount = 0;

        short[] ages = new short[4];
        ages[0] = 0;
        ages[1] = 20;
        ages[2] = 30;
        ages[3] = 60;

        for (int i = 0; i < ages.length; i++) {
            if (ages[i] == 0) {
                ageCount =
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge19AndUnder();
            }
            if (ages[i] == 20) {
                ageCount =
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge20to24() +
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge25to29();
            }
            if (ages[i] == 30) {
                ageCount =
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge30to44() +
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge45to59();
            }
            if (ages[i] == 60) {
                ageCount =
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge60to64() +
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge65to74() +
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge75to84() +
                        tCAS003DataRecord.getMaleHRPHouseholdsTotalAge85AndOver();
            }
            tCAS003_AgeSexType_Count_HashMap.put(ages[i], ageCount);
        }
        return tCAS003_AgeSexType_Count_HashMap;
    }
}