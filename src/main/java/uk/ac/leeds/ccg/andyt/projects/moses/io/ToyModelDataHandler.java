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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.StreamTokenizer;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;

/**
 * A specialist handler for accessing CASKS002Records and information about the
 * collection.
 */
public class ToyModelDataHandler extends AbstractCASDataHandler {

    /**
     * A reference to a FileOutputStream for writing data
     */
    public FileOutputStream _ToyModelFileOutputStream = null;

    /** Creates a new instance of ToyModelDataHandler */
    public ToyModelDataHandler() {
    }

    /**
     * Creates a new ToyModelDataHandler for Records loaded from infile.
     *
     * @param _ToyModelDataRecord_1
     * @param _FormattedFile
     *            Formatted File of ToyModelDataRecords
     * @throws java.io.IOException
     */
    public ToyModelDataHandler(
            ToyModelDataRecord_1 _ToyModelDataRecord_1,
            File _FormattedFile)
            throws IOException {
        // initMemoryReserve();
        init(_FormattedFile.getParentFile());
        this._File = _FormattedFile;
        this._RecordLength = new ToyModelDataRecord_1().getSizeInBytes();
        load(_FormattedFile);
        System.out.println("ToyModelDataRecord loaded successfully");
    }

    /**
     * Creates a new ToyModelDataHandler for Records loaded from infile.
     *
     * @param _ToyModelDataRecord
     * @param _FormattedFile
     *            Formatted File of ToyModelDataRecords
     * @throws java.io.IOException
     */
    public ToyModelDataHandler(
            ToyModelDataRecord _ToyModelDataRecord,
            File _FormattedFile)
            throws IOException {
        // initMemoryReserve();
        init(_FormattedFile.getParentFile());
        this._File = _FormattedFile;
        this._RecordLength = new ToyModelDataRecord().getSizeInBytes();
        load(_FormattedFile);
        System.out.println("ToyModelDataRecords loaded successfully");
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        try {
            ToyModelDataHandler aToyModelDataHandler = new ToyModelDataHandler();
            aToyModelDataHandler.run();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    /**
     * Highest level controller for processing runs
     */
    private void run() throws IOException {
        // run1();
        // run2();
        // run3();
    }

    /**
     * Formats input csv input
     */
    private void run1() {
        // initMemoryReserve();
        this._RecordLength = new ToyModelDataRecord_1().getSizeInBytes();
        // File toyModelCSVFile = new File(
        // "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile3.csv" );
        File toyModelCSVFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile0.4.1.csv");
        // this.file = new File(
        // "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile3.dat" );
        this._File = new File(
                "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile0.4.1.dat");
        try {
            this._RandomAccessFile = new RandomAccessFile(this._File, "rw");
        } catch (FileNotFoundException fnfe0) {
            fnfe0.printStackTrace();
        }
        _FormatToyModelDataRecord_1(toyModelCSVFile);
    }

    /**
     * Loads formatted file and prints out some values
     */
    private void run2() {
        // initMemoryReserve();
        this._RecordLength = new ToyModelDataRecord_1().getSizeInBytes();
        // File toyModelCSVFile = new File(
        // "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile3.csv" );
        // File toyModelCSVFile = new File(
        // "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile0.4.1.csv" );
        // this.file = new File(
        // "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile3.dat" );
        this._File = new File(
                "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile0.4.1.dat");
        try {
            this._RandomAccessFile = new RandomAccessFile(this._File, "r");
            long length = this._RandomAccessFile.length();
            int numberOfRecords = (int) (length / _RecordLength);
            long RecordID;
            Random random = new Random();
            ToyModelDataRecord_1 toyModelDataRecord = null;
            for (int i = 0; i < 20; i++) {
                this._RandomAccessFile.seek((long) (random.nextInt(numberOfRecords)) * _RecordLength);
                toyModelDataRecord = new ToyModelDataRecord_1(
                        this._RandomAccessFile);

                System.out.println(toyModelDataRecord.toString());
            }
        } catch (IOException ioe0) {
            ioe0.printStackTrace();
        }
    }

    /**
     * Formats the ToyModelDataRecord_1 File file.
     *
     * @param file
     *            The ToyModelDataRecord_1 csv File to be formatted for
     *            RandomAccess.
     */
    protected void _FormatToyModelDataRecord_1(
            File file) {
        boolean handleOutOfMemoryError = true;
        try {
            BufferedReader tBufferedReader =
                    new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(file)));
            StreamTokenizer tStreamTokenizer =
                    new StreamTokenizer(tBufferedReader);
            Generic_StaticIO.setStreamTokenizerSyntax1(tStreamTokenizer);
            long lineCount = 0L;
            ToyModelDataRecord_1 _ToyModelDataRecord_1 = new ToyModelDataRecord_1();
            // Skip header
            int tokenType = tStreamTokenizer.nextToken();
            tokenType = tStreamTokenizer.nextToken();
            String[] fields;
            tokenType = tStreamTokenizer.nextToken();
            while (tokenType != StreamTokenizer.TT_EOF) {
                switch (tokenType) {
                    case StreamTokenizer.TT_EOL:
                        lineCount++;
                        break;
                    case StreamTokenizer.TT_WORD:
                        _ToyModelDataRecord_1 = new ToyModelDataRecord_1(this,
                                tStreamTokenizer.sval);
                        _ToyModelDataRecord_1.write(this._RandomAccessFile);
                }
                tokenType = tStreamTokenizer.nextToken();
            }
            tBufferedReader.close();
            System.out.println("Number of Records loaded = " + lineCount);
        } catch (IOException ioe0) {
            ioe0.printStackTrace();
        }
    }

    /**
     * Formats the ToyModelDataRecord_1 File file.
     *
     * @return A HashSet of _ZoneCodes.
     * @param _ToyModelDataRecord1CSVFile
     *            The ToyModelDataRecord_1 csv File to be formatted for
     *            RandomAccess.
     */
    public HashSet _Format_ToyModelDataRecord_1CSV_To_ToyModelDataRecord_2DAT(
            File _ToyModelDataRecord1CSVFile) {
         try {
            HashSet result = new HashSet();
            BufferedReader tBufferedReader =
                    new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(
                    _ToyModelDataRecord1CSVFile)));
            StreamTokenizer tStreamTokenizer =
                    new StreamTokenizer(
                    tBufferedReader);
            Generic_StaticIO.setStreamTokenizerSyntax1(tStreamTokenizer);
            File _ToyModelDataRecord_2DATFile =
                    new File(
                    _ToyModelDataRecord1CSVFile.getParentFile(),
                    _ToyModelDataRecord1CSVFile.getName().substring(0,
                    _ToyModelDataRecord1CSVFile.getName().length() - 3) + "dat");
            _ToyModelDataRecord_2DATFile.createNewFile();
            RandomAccessFile _ToyModelDataRecord_2DAT_RandomAccessFile = null;
            try {
                _ToyModelDataRecord_2DAT_RandomAccessFile =
                        new RandomAccessFile(
                        _ToyModelDataRecord_2DATFile, "rw");
            } catch (java.io.IOException _IOException) {
                _IOException.printStackTrace();
            }
            long lineCount = 0L;
            ToyModelDataRecord_2 aToyModelDataRecord2 = new ToyModelDataRecord_2();
            ToyModelDataRecord aToyModelDataRecord3 = new ToyModelDataRecord();
            // Skip header
            int tokenType = tStreamTokenizer.nextToken();
            tokenType = tStreamTokenizer.nextToken();
            String[] fields;
            tokenType = tStreamTokenizer.nextToken();
            while (tokenType != StreamTokenizer.TT_EOF) {
                switch (tokenType) {
                    case StreamTokenizer.TT_EOL:
                        lineCount++;
                        break;
                    case StreamTokenizer.TT_WORD:
                        aToyModelDataRecord2 = new ToyModelDataRecord_2(this,
                                tStreamTokenizer.sval);
                        aToyModelDataRecord3 = new ToyModelDataRecord(
                                aToyModelDataRecord2);
                        // aToyModelDataRecord3.write( this._RandomAccessFile );
                        aToyModelDataRecord3.write(_ToyModelDataRecord_2DAT_RandomAccessFile);
                        result.add(new String(aToyModelDataRecord3.getZone_Code()));
                }
                tokenType = tStreamTokenizer.nextToken();
            }
            tBufferedReader.close();
            System.out.println("Number of Records loaded = " + lineCount);
            return result;
        } catch (IOException ioe0) {
            ioe0.printStackTrace();
        }
        return null;
    }

    /**
     * @param RecordID
     *            The RecordID of the ISAR to be returned.
     * @return 
     */
    public AbstractCASDataRecord getDataRecord(long RecordID) {
        // return getCASKS002Record( RecordID );
        return new ToyModelDataRecord(this._RandomAccessFile);
    }

    /**
     *
     * @param string
     * @return 
     */
    protected int parseInt(String string) {
        try {
            return Integer.valueOf(string);
        } catch (NumberFormatException nfe0) {
            return Integer.MIN_VALUE;
        }
    }

    /**
     * @param RecordID
     *            The RecordID of the ToyModelDataRecord to be returned.
     * @return 
     * @throws java.io.IOException 
     */
    protected ToyModelDataRecord_1 getToyModelDataRecord1(long RecordID)
            throws IOException {
        ToyModelDataRecord_1 result = null;
        try {
            this._RandomAccessFile.seek(this._RecordLength * RecordID);
            result = new ToyModelDataRecord_1(this._RandomAccessFile);
        } catch (IOException ioe) {
            System.out.println("Problem in getToyModelDataRecord(RecordID(" + RecordID + "))");
            System.out.println("this.recordLength * RecordID = " + _RandomAccessFile.getFilePointer());
            System.out.println("this.tRandomAccessFile.length() = " + this._RandomAccessFile.length());
            throw ioe;
        }
        return result;
    }

    /**
     * Writes out ToyModel output via this._ToyModelFileOutputStream
     *
     * @param random
     * @param aPersonIDHouseholdID
     * @return long[] result
     *         <ul>
     *         <li>result[0] is the next sequential personID</li>
     *         <li>result[1] is the next sequential householdID</li>
     *         </ul>
     * @throws java.io.IOException
     */
    public long[] write1(
            ISARDataRecord[] aISARDataRecords,
            CASDataRecord aCASDataRecord,
            BigDecimal fitness,
            long[] aPersonIDHouseholdID, 
            Random random)
            throws IOException {
        String toyModelRecord;
        int ageInt;
        long aISARDataRecordID;
        long ID;
        short HRSOCGRD;
        boolean SEX;
        int SEXint;
        short MARSTAT;
        int MARSTATReclassed;
        short LLTI;
        short HEALTH;
        String zoneCode = new String(aCASDataRecord.getZone_Code());
        short RELTOHR;
        short PROVCARE;
        short CETYPE;
        short FNDEPCH;
        short HNRESDNT;
        short HNELDERS;
        for (int aISARDataRecordIndex = 0; aISARDataRecordIndex < aISARDataRecords.length; aISARDataRecordIndex++) {
            aPersonIDHouseholdID[0]++;
            toyModelRecord = "" + aPersonIDHouseholdID[0] + ",";
            aISARDataRecordID = aISARDataRecords[aISARDataRecordIndex].get_RecordID();
            toyModelRecord = toyModelRecord + aISARDataRecordID + ",";
            ID = aISARDataRecords[aISARDataRecordIndex].get_ID();
            toyModelRecord = toyModelRecord + ID + ",";
            ageInt = aISARDataRecords[aISARDataRecordIndex].getAgeInt();
            toyModelRecord = toyModelRecord + ageInt + ",";
            HRSOCGRD = aISARDataRecords[aISARDataRecordIndex].get_HRSOCGRD();
            if (HRSOCGRD == -9) {
                // HRSOCGRD = new Integer( random.nextInt( 4 ) + 1
                // ).shortValue();
                HRSOCGRD = (short) (random.nextInt(4) + 1);
            }
            toyModelRecord = toyModelRecord + HRSOCGRD + ",";
            SEX = aISARDataRecords[aISARDataRecordIndex].get_SEX();
            if (SEX) {
                SEXint = 1;
            } else {
                SEXint = 2;
            }
            toyModelRecord = toyModelRecord + SEXint + ",";
            MARSTAT = aISARDataRecords[aISARDataRecordIndex].get_MARSTAT();
            if ((MARSTAT == 2) || (MARSTAT == 3)) {
                MARSTATReclassed = 1;
            } else {
                MARSTATReclassed = 0;
            }
            toyModelRecord = toyModelRecord + MARSTATReclassed + ",";
            LLTI = aISARDataRecords[aISARDataRecordIndex].get_LLTI();
            LLTI--;
            if (LLTI == -10) {
                LLTI = (short) (random.nextInt(1));
            }
            toyModelRecord = toyModelRecord + LLTI + ",";
            HEALTH = aISARDataRecords[aISARDataRecordIndex].get_HEALTH();
            if (HEALTH == -9) {
                HEALTH = (short) (random.nextInt(2) + 1);
            }
            toyModelRecord = toyModelRecord + HEALTH + ",";
            toyModelRecord = toyModelRecord + zoneCode + ",";
            RELTOHR = aISARDataRecords[aISARDataRecordIndex].get_RELTOHR();
            if (RELTOHR == 1) {
                RELTOHR = 1;
            } else {
                RELTOHR = 0;
            }
            toyModelRecord = toyModelRecord + RELTOHR + ",";
            if (RELTOHR == 1) {
                aPersonIDHouseholdID[1]++;
                toyModelRecord = toyModelRecord + aPersonIDHouseholdID[1] + ",";
            } else {
                toyModelRecord = toyModelRecord + ",";
            }
            PROVCARE = aISARDataRecords[aISARDataRecordIndex].get_PROVCARE();
            if (PROVCARE == -9) {
                PROVCARE = 0;
            }
            if (PROVCARE == 1) {
                PROVCARE = 0;
            } else {
                PROVCARE = 1;
            }
            toyModelRecord = toyModelRecord + PROVCARE + ",";
            CETYPE = aISARDataRecords[aISARDataRecordIndex].get_CETYPE();
            if (CETYPE > 0) {
                CETYPE = 1;
            } else {
                CETYPE = 0;
            }
            toyModelRecord = toyModelRecord + CETYPE + ",";
            FNDEPCH = aISARDataRecords[aISARDataRecordIndex].get_FNDEPCH();
            if (FNDEPCH == 1) {
                FNDEPCH = 1;
            } else {
                FNDEPCH = 0;
            }
            toyModelRecord = toyModelRecord + FNDEPCH + ",";
            HNRESDNT = aISARDataRecords[aISARDataRecordIndex].get_HNRESDNT();
            if (HNRESDNT == -9 || HNRESDNT == 0) {
                HNRESDNT = 1;
            }
            toyModelRecord = toyModelRecord + HNRESDNT + ",";
            HNELDERS = aISARDataRecords[aISARDataRecordIndex].get_HNELDERS();
            if (HNELDERS == -9) {
                HNELDERS = 0;
            }
            toyModelRecord = toyModelRecord + HNELDERS + ",";
            toyModelRecord = toyModelRecord + fitness;
            this._ToyModelFileOutputStream.write(toyModelRecord.getBytes());
            this._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
            this._ToyModelFileOutputStream.flush();
        }
        return aPersonIDHouseholdID;
    }

    /**
     * Writes out ToyModel output via this._ToyModelFileOutputStream
     *
     * @param population
     *            A set of populations where:
     *            <ul>
     *            <li>population[0] are <code>HSARDataRecords</code> of
     *            constrained Household Population HRPs;</li>
     *            <li>population[1] are <code>HSARDataRecords</code> of
     *            additional Household Population HRPs;</li>
     *            <li>population[2] are <code>ISARDataRecords</code> of Communal
     *            Establishment Population</li>
     *            </ul>
     * @param aPersonIDHouseholdID
     * @param fitness
     * @return long[] result
     *         <ul>
     *         <li>result[0] is the next sequential personID</li>
     *         <li>result[1] is the next sequential householdID</li>
     *         </ul>
     * @throws java.io.IOException
     */
    public long[] write2_SWR_HSARHP_ISARCEP(
            Object[] population,
            HSARDataHandler tHSARDataHandler,
            CASDataRecord aCASDataRecord,
            BigDecimal fitness, 
            long[] aPersonIDHouseholdID)
            throws IOException {
        // Write tHP
        if (true) {
            Vector tHP = tHSARDataHandler.getHSARDataRecords((HSARDataRecord[]) population[0]);
            // Add from tHP
            Iterator tHPIterator = tHP.iterator();
            HSARDataRecord aHSARDataRecord;
            while (tHPIterator.hasNext()) {
                aHSARDataRecord = (HSARDataRecord) tHPIterator.next();
                aPersonIDHouseholdID = write2_HSARHP(aHSARDataRecord,
                        aCASDataRecord, fitness, aPersonIDHouseholdID);
            }
            aPersonIDHouseholdID[0] = 0;
            aPersonIDHouseholdID[1]++;
        }
        // Write CEP
        if (true) {
            aPersonIDHouseholdID[0] = -1;
            ISARDataRecord[] tISARDataRecords = (ISARDataRecord[]) population[1];
            for (int i = 0; i < tISARDataRecords.length; i++) {
                aPersonIDHouseholdID = write2_ISARCEP(tISARDataRecords[i],
                        aCASDataRecord, fitness, aPersonIDHouseholdID);
            }
        }
        return aPersonIDHouseholdID;
    }

    /**
     * Writes out ToyModel output via this._ToyModelFileOutputStream
     *
     * @param population
     *            A set of populations where:
     *            <ul>
     *            <li>population[0] are <code>HSARDataRecords</code> of
     *            constrained Household Population HRPs;</li>
     *            <li>population[1] are <code>HSARDataRecords</code> of
     *            additional Household Population HRPs;</li>
     *            <li>population[2] are <code>ISARDataRecords</code> of Communal
     *            Establishment Population</li>
     *            </ul>
     * @param aPersonIDHouseholdID
     * @param fitness
     * @return long[] result
     *         <ul>
     *         <li>result[0] is the next sequential personID</li>
     *         <li>result[1] is the next sequential householdID</li>
     *         </ul>
     * @throws java.io.IOException
     */
    public long[] write2_SWR_HSARHP_ISARCEP(
            Object[] population,
            HSARDataHandler tHSARDataHandler,
            CASDataRecord_1 _CASDataRecord_1,
            BigDecimal fitness, 
            long[] aPersonIDHouseholdID)
            throws IOException {
        // Write tHP
        if (true) {
            Vector tHP = tHSARDataHandler.getHSARDataRecords((HSARDataRecord[]) population[0]);
            // Add from tHP
            Iterator tHPIterator = tHP.iterator();
            HSARDataRecord aHSARDataRecord;
            while (tHPIterator.hasNext()) {
                aHSARDataRecord = (HSARDataRecord) tHPIterator.next();
                aPersonIDHouseholdID = write2_HSARHP(aHSARDataRecord,
                        _CASDataRecord_1, fitness, aPersonIDHouseholdID);
            }
            aPersonIDHouseholdID[0] = 0;
            aPersonIDHouseholdID[1]++;
        }
        // Write CEP
        if (true) {
            aPersonIDHouseholdID[0] = -1;
            ISARDataRecord[] tISARDataRecords = (ISARDataRecord[]) population[1];
            for (int i = 0; i < tISARDataRecords.length; i++) {
                aPersonIDHouseholdID = write2_ISARCEP(tISARDataRecords[i],
                        _CASDataRecord_1, fitness, aPersonIDHouseholdID);
            }
        }
        return aPersonIDHouseholdID;
    }

    /**
     * Writes out ToyModel output via this._ToyModelFileOutputStream
     *
     * @param populations
     *            A set of populations where:
     *            <ul>
     *            <li>population[0] are <code>HSARDataRecords</code> of
     *            constrained Household Population HRPs;</li>
     *            <li>population[1] are <code>HSARDataRecords</code> of
     *            additional Household Population HRPs;</li>
     *            <li>population[2] are <code>ISARDataRecords</code> of Communal
     *            Establishment Population</li>
     *            </ul>
     * @param aPersonIDHouseholdID
     * @param fitness
     * @return long[] result
     *         <ul>
     *         <li>result[0] is the next sequential personID</li>
     *         <li>result[1] is the next sequential householdID</li>
     *         </ul>
     * @throws java.io.IOException
     */
    public long[] write2_HSARHP_ISARCEP(Object[] populations,
            HSARDataHandler tHSARDataHandler, CASDataRecord aCASDataRecord,
            BigDecimal fitness, long[] aPersonIDHouseholdID) throws IOException {
        // Write constrained HP
        if (true) {
            Vector tHSARVectorOfVectors = tHSARDataHandler.getHSARDataRecordsVectors((HashSet) populations[0]);
            Iterator tHSARVectorOfVectorsIterator = tHSARVectorOfVectors.iterator();
            while (tHSARVectorOfVectorsIterator.hasNext()) {
                Vector aHPVector = (Vector) tHSARVectorOfVectorsIterator.next();
                Iterator aHPVectorIterator = aHPVector.iterator();
                while (aHPVectorIterator.hasNext()) {
                    HSARDataRecord aHSARDataRecord = (HSARDataRecord) aHPVectorIterator.next();
                    aPersonIDHouseholdID = write2_HSARHP(aHSARDataRecord,
                            aCASDataRecord, fitness, aPersonIDHouseholdID);
                }
                aPersonIDHouseholdID[0] = 0;
                aPersonIDHouseholdID[1]++;
            }
        }
        // Write additional HP
        if (true) {
            Vector tHSARVectorOfVectors = tHSARDataHandler.getHSARDataRecordsVectors((HashSet) populations[1]);
            Iterator tHSARVectorOfVectorsIterator = tHSARVectorOfVectors.iterator();
            while (tHSARVectorOfVectorsIterator.hasNext()) {
                Vector aHPVector = (Vector) tHSARVectorOfVectorsIterator.next();
                Iterator aHPVectorIterator = aHPVector.iterator();
                while (aHPVectorIterator.hasNext()) {
                    HSARDataRecord aHSARDataRecord = (HSARDataRecord) aHPVectorIterator.next();
                    aPersonIDHouseholdID = write2_HSARHP(aHSARDataRecord,
                            aCASDataRecord, fitness, aPersonIDHouseholdID);
                }
                aPersonIDHouseholdID[0] = 0;
                aPersonIDHouseholdID[1]++;
            }
        }
        // Write CEP
        if (true) {
            HashSet aISARDataRecordsHashSet = (HashSet) populations[2];
            Iterator aISARDataRecordsHashSetIterator = aISARDataRecordsHashSet.iterator();
            ISARDataRecord aISARDataRecord;
            while (aISARDataRecordsHashSetIterator.hasNext()) {
                aISARDataRecord = (ISARDataRecord) aISARDataRecordsHashSetIterator.next();
                write2_ISARCEP(aISARDataRecord, aCASDataRecord, fitness,
                        aPersonIDHouseholdID);
                aPersonIDHouseholdID[0] = 0;
                aPersonIDHouseholdID[1]++;
            }
        }
        return aPersonIDHouseholdID;
    }

    /**
     * Writes out ToyModel output via this._ToyModelFileOutputStream
     *
     * @param population
     *            A set of populations where:
     *            <ul>
     *            <li>population[0] are <code>ISARDataRecords</code> of
     *            Household Population HRPs;</li>
     *            <li>population[1] are <code>ISARDataRecords</code> of Communal
     *            Establishment Population</li>
     *            </ul>
     * @param aPersonIDHouseholdID
     * @param fitness
     * @return long[] result
     *         <ul>
     *         <li>result[0] is the next sequential personID</li>
     *         <li>result[1] is the next sequential householdID</li>
     *         </ul>
     * @throws java.io.IOException
     */
    public long[] write2_ISARHP_ISARCEP(
            Random tRandom,
            Object[] population,
            CASDataRecord aCASDataRecord,
            BigDecimal fitness,
            long[] aPersonIDHouseholdID)
            throws IOException {
        // // Arrange into households using AreaModel and write out
        // ISARDataRecord[] tHPHRPs = ( ISARDataRecord[] ) population[ 0 ];
        // ISARDataRecord[] tHPNonHRPs = ( ISARDataRecord[] ) population[ 1 ];
        // ISARDataRecord[] tISARDataRecords = new ISARDataRecord[
        // tHPHRPs.length + tHPNonHRPs.length ];
        // System.arraycopy( tHPHRPs, 0, tISARDataRecords, 0, tHPHRPs.length );
        // System.arraycopy( tHPNonHRPs, 0, tISARDataRecords, tHPHRPs.length,
        // tHPNonHRPs.length );
        // AreaModelExtension areaModelExtension = new AreaModelExtension(
        // tRandom,
        // new String( aCASDataRecord.getZone_Code() ) );
        // List tListOfHouseholds = areaModelExtension.getListOfHouseholds();
        // List tListOfChildren;
        // List tListOfAdultDependents;
        // List tListOfElderlyDependents;
        // Household aHousehold;
        // HRP aHRP;
        // Spouse aSpouse;
        // int aPid;
        // Iterator tListOfHouseholdsIterator = tListOfHouseholds.iterator();
        // while ( tListOfHouseholdsIterator.hasNext() ) {
        // aHousehold = ( Household ) tListOfHouseholdsIterator.next();
        // aHRP = aHousehold.getHrp();
        // aSpouse = aHousehold.getSpouse();
        // tListOfChildren = aHousehold.getListOfChildren();
        // tListOfAdultDependents = aHousehold.getListOfAdultDependents();
        // tListOfElderlyDependents = aHousehold.getListOfElderlyDependents();
        //
        // Child aChild = ( Child ) tListOfChildren.get( 0 );
        // aChild.getPid()
        // aPersonIDHouseholdID = write2_ISARHP(
        // aHRP, aSpouse, tListOfChildren, tListOfAdultDependents,
        // tListOfElderlyDependents );
        // }
        // List tUnassignedHRP = areaModelExtension.getUnassignedHRP();
        // List tUnknownTypePerson = areaModelExtension.getUnknownTypePerson();
        // Write HP
        if (true) {
            ISARDataRecord[] tISARDataRecords = (ISARDataRecord[]) population[0];
            for (int i = 0; i < tISARDataRecords.length; i++) {
                aPersonIDHouseholdID = write2_ISARHP(tISARDataRecords[i],
                        aCASDataRecord, fitness, aPersonIDHouseholdID);
            }
        }
        // Write HPNonHRPs
        if (true) {
            ISARDataRecord[] tISARDataRecords = (ISARDataRecord[]) population[1];
            for (int i = 0; i < tISARDataRecords.length; i++) {
                aPersonIDHouseholdID = write2_ISARHP(tISARDataRecords[i],
                        aCASDataRecord, fitness, aPersonIDHouseholdID);
            }
        }
        // Write CEP
        if (true) {
            aPersonIDHouseholdID[0] = -1;
            ISARDataRecord[] tISARDataRecords = (ISARDataRecord[]) population[2];
            for (int i = 0; i < tISARDataRecords.length; i++) {
                aPersonIDHouseholdID = write2_ISARCEP(tISARDataRecords[i],
                        aCASDataRecord, fitness, aPersonIDHouseholdID);
            }
        }
        return aPersonIDHouseholdID;
    }

    /**
     * Writes out ToyModel output via this._ToyModelFileOutputStream. The format
     * is String,String,Long representing Area_Code, CEP or HP depending on
     * whether the record represents part of the Communal Establishment
     * Population or the Household Population, and the ISAR ID for the
     * individual. This output does not indicate household or communal
     * establishment groups.
     *
     * @param population
     *            A set of populations where:
     *            <ul>
     *            <li>population[0] are <code>ISARDataRecords</code> of
     *            Household Population HRPs;</li>
     *            <li>population[1] are <code>ISARDataRecords</code> of Communal
     *            Establishment Population</li>
     *            </ul>
     * @param aPersonIDHouseholdID
     * @param fitness
     * @throws java.io.IOException
     */
    public void write2_ISARHP_ISARCEP(
            Object[] population,
            CASDataRecord aCASDataRecord,
            BigDecimal fitness,
            long[] aPersonIDHouseholdID) throws IOException {
        // Run AreaModel to work out and output who are in what households?
        // Write HP
        String line;
        String line0 = new String(aCASDataRecord.getZone_Code());
        if (true) {
            ISARDataRecord[] tISARDataRecords = (ISARDataRecord[]) population[0];
            for (int i = 0; i < tISARDataRecords.length; i++) {
                // line = line0 + ",HP," + tISARDataRecords[i].get_RecordID();
                line = line0 + ",HP," + tISARDataRecords[i].get_ID();
                this._ToyModelFileOutputStream.write(line.getBytes());
                this._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
            }
        }
        // Write CEP
        if (true) {
            ISARDataRecord[] tISARDataRecords = (ISARDataRecord[]) population[1];
            for (int i = 0; i < tISARDataRecords.length; i++) {
                // line = line0 + ",CEP," + tISARDataRecords[i].get_RecordID();
                line = line0 + ",CEP," + tISARDataRecords[i].get_ID();
                this._ToyModelFileOutputStream.write(line.getBytes());
                this._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
            }
        }
        this._ToyModelFileOutputStream.flush();
    }

        /**
     * Writes out ToyModel output type 2 via this._ToyModelFileOutputStream
     *
     * @param aISARDataRecord
     *            The ISARDataRecord.
     * @param aCASDataRecord
     *            The CASDataRecord.
     * @param fitness
     *            The BigDecimal.
     * @param aPersonIDHouseholdID
     *            A long[].
     *            <ul>
     *            <li>result[0] is the next sequential personID</li>
     *            <li>result[1] is the next sequential householdID</li>
     *            </ul>
     * @return 
     * @throws java.io.IOException 
     */
    public long[] write2_ISARCEP(
            ISARDataRecord aISARDataRecord,
            CASDataRecord aCASDataRecord,
            BigDecimal fitness,
            long[] aPersonIDHouseholdID)
            throws IOException {
        // AREACODE,PERSONID,HOUSEHOLDID,HSARRECORDID,INDIVIDUALSARRECORDID,AGE,SEX,LLTI,HEALTH,ETHNICITY,CAROWNERSHIP
        // -9 used for HOUSEHOLDID to signify CEP
        // -9 used for CAROWNERSHIP
        aPersonIDHouseholdID[0]++;
        String toyModelRecord = String.valueOf(aCASDataRecord.getZone_Code());
        toyModelRecord += "," + Long.toString(aPersonIDHouseholdID[0]);
        toyModelRecord += ",-9";
        toyModelRecord += ",-9";
        toyModelRecord += "," + aISARDataRecord.get_RecordID();
        toyModelRecord += "," + aISARDataRecord.get_AGE0();
        boolean SEX = aISARDataRecord.get_SEX();
        if (SEX) {
            toyModelRecord += ",1";
        } else {
            toyModelRecord += ",0";
        }
        toyModelRecord += "," + aISARDataRecord.get_LLTI();
        toyModelRecord += "," + aISARDataRecord.get_HEALTH();
        short ETHEW = aISARDataRecord.get_ETHEW();
        if (ETHEW > 0) {
            if (ETHEW < 4) {
                toyModelRecord += ",0";
            } else {
                if ((ETHEW > 3 && ETHEW < 6) || (ETHEW > 11 && ETHEW < 15)) {
                    toyModelRecord += ",1";
                } else {
                    if (ETHEW == 6 || (ETHEW > 7 && ETHEW < 12)) {
                        toyModelRecord += ",2";
                    } else {
                        toyModelRecord += ",3";
                    }
                }
            }
        } else {
            short ETHS = aISARDataRecord.get_ETHS();
            if (ETHS > 0) {
                if (ETHS < 5) {
                    toyModelRecord += ",0";
                } else {
                    if (ETHS > 9 && ETHS < 13) {
                        toyModelRecord += ",1";
                    } else {
                        if (ETHS > 5 && ETHS < 10) {
                            toyModelRecord += ",2";
                        } else {
                            toyModelRecord += ",3";
                        }
                    }
                }
            } else {
                short ETHN = aISARDataRecord.get_ETHN();
                if (ETHN == 1) {
                    toyModelRecord += ",0";
                } else {
                    toyModelRecord += ",-9";
                }
            }
        }
        // toyModelRecord += "," + aISARDataRecord.getCARS0();
        toyModelRecord += ",-9";
        this._ToyModelFileOutputStream.write(toyModelRecord.getBytes());
        this._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
        this._ToyModelFileOutputStream.flush();
        return aPersonIDHouseholdID;
    }

    /**
     * Writes out ToyModel output type 2 via this._ToyModelFileOutputStream
     *
     *
     * @param aISARDataRecord
     *            The ISARDataRecord.
     * @param _CASDataRecord_1
     *            The CASDataRecord.
     * @param fitness
     *            The BigDecimal.
     * @param aPersonIDHouseholdID
     *            A long[].
     *            <ul>
     *            <li>result[0] is the next sequential personID</li>
     *            <li>result[1] is the next sequential householdID</li>
     *            </ul>
     * @return 
     * @throws java.io.IOException 
     */
    public long[] write2_ISARCEP(
            ISARDataRecord aISARDataRecord,
            CASDataRecord_1 _CASDataRecord_1,
            BigDecimal fitness,
            long[] aPersonIDHouseholdID)
            throws IOException {
        // AREACODE,PERSONID,HOUSEHOLDID,HSARRECORDID,INDIVIDUALSARRECORDID,AGE,SEX,LLTI,HEALTH,ETHNICITY,CAROWNERSHIP
        // -9 used for HOUSEHOLDID to signify CEP
        // -9 used for CAROWNERSHIP
        aPersonIDHouseholdID[0]++;
        String toyModelRecord = String.valueOf(_CASDataRecord_1.getZone_Code());
        toyModelRecord += "," + Long.toString(aPersonIDHouseholdID[0]);
        toyModelRecord += ",-9";
        toyModelRecord += ",-9";
        toyModelRecord += "," + aISARDataRecord.get_RecordID();
        toyModelRecord += "," + aISARDataRecord.get_AGE0();
        boolean SEX = aISARDataRecord.get_SEX();
        if (SEX) {
            toyModelRecord += ",1";
        } else {
            toyModelRecord += ",0";
        }
        toyModelRecord += "," + aISARDataRecord.get_LLTI();
        toyModelRecord += "," + aISARDataRecord.get_HEALTH();
        short ETHEW = aISARDataRecord.get_ETHEW();
        if (ETHEW > 0) {
            if (ETHEW < 4) {
                toyModelRecord += ",0";
            } else {
                if ((ETHEW > 3 && ETHEW < 6) || (ETHEW > 11 && ETHEW < 15)) {
                    toyModelRecord += ",1";
                } else {
                    if (ETHEW == 6 || (ETHEW > 7 && ETHEW < 12)) {
                        toyModelRecord += ",2";
                    } else {
                        toyModelRecord += ",3";
                    }
                }
            }
        } else {
            short ETHS = aISARDataRecord.get_ETHS();
            if (ETHS > 0) {
                if (ETHS < 5) {
                    toyModelRecord += ",0";
                } else {
                    if (ETHS > 9 && ETHS < 13) {
                        toyModelRecord += ",1";
                    } else {
                        if (ETHS > 5 && ETHS < 10) {
                            toyModelRecord += ",2";
                        } else {
                            toyModelRecord += ",3";
                        }
                    }
                }
            } else {
                short ETHN = aISARDataRecord.get_ETHN();
                if (ETHN == 1) {
                    toyModelRecord += ",0";
                } else {
                    toyModelRecord += ",-9";
                }
            }
        }
        // toyModelRecord += "," + aISARDataRecord.getCARS0();
        toyModelRecord += ",-9";
        this._ToyModelFileOutputStream.write(toyModelRecord.getBytes());
        this._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
        this._ToyModelFileOutputStream.flush();
        return aPersonIDHouseholdID;
    }

    /**
     * Writes out ToyModel output type 2 via this._ToyModelFileOutputStream
     *
     * @param aPersonIDHouseholdID
     * @param fitness
     * @return long[] result
     *         <ul>
     *         <li>result[0] is the next sequential personID</li>
     *         <li>result[1] is the next sequential householdID</li>
     *         </ul>
     * @throws java.io.IOException
     */
    public long[] write2_ISARHP(
            ISARDataRecord aISARDataRecord,
            CASDataRecord aCASDataRecord,
            BigDecimal fitness,
            long[] aPersonIDHouseholdID)
            throws IOException {
        // AREACODE,PERSONID,HOUSEHOLDID,HSARRECORDID,INDIVIDUALSARRECORDID,AGE,SEX,LLTI,HEALTH,ETHNICITY,CAROWNERSHIP
        String toyModelRecord = String.valueOf(aCASDataRecord.getZone_Code());
        if (aISARDataRecord.get_RELTOHR() == 1) {
            aPersonIDHouseholdID[0] = 0;
            aPersonIDHouseholdID[1]++;
        } else {
            aPersonIDHouseholdID[0]++;
        }
        toyModelRecord += "," + Long.toString(aPersonIDHouseholdID[0]);
        toyModelRecord += "," + Long.toString(aPersonIDHouseholdID[1]);
        toyModelRecord += ",-9";
        toyModelRecord += "," + aISARDataRecord.get_RecordID();
        toyModelRecord += "," + aISARDataRecord.get_AGE0();
        boolean SEX = aISARDataRecord.get_SEX();
        if (SEX) {
            toyModelRecord += ",1";
        } else {
            toyModelRecord += ",0";
        }
        toyModelRecord += "," + aISARDataRecord.get_LLTI();
        toyModelRecord += "," + aISARDataRecord.get_HEALTH();
        short ETHEW = aISARDataRecord.get_ETHEW();
        if (ETHEW > 0) {
            if (ETHEW < 4) {
                toyModelRecord += ",0";
            } else {
                if ((ETHEW > 3 && ETHEW < 6) || (ETHEW > 11 && ETHEW < 15)) {
                    toyModelRecord += ",1";
                } else {
                    if (ETHEW == 6 || (ETHEW > 7 && ETHEW < 12)) {
                        toyModelRecord += ",2";
                    } else {
                        toyModelRecord += ",3";
                    }
                }
            }
        } else {
            short ETHS = aISARDataRecord.get_ETHS();
            if (ETHS > 0) {
                if (ETHS < 5) {
                    toyModelRecord += ",0";
                } else {
                    if (ETHS > 9 && ETHS < 13) {
                        toyModelRecord += ",1";
                    } else {
                        if (ETHS > 5 && ETHS < 10) {
                            toyModelRecord += ",2";
                        } else {
                            toyModelRecord += ",3";
                        }
                    }
                }
            } else {
                short ETHN = aISARDataRecord.get_ETHN();
                if (ETHN == 1) {
                    toyModelRecord += ",0";
                } else {
                    toyModelRecord += ",-9";
                }
            }
        }
        if (aISARDataRecord.get_RELTOHR() == 1) {
            toyModelRecord += "," + aISARDataRecord.get_CARS0();
        } else {
            toyModelRecord += ",-9";
        }
        this._ToyModelFileOutputStream.write(toyModelRecord.getBytes());
        this._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
        this._ToyModelFileOutputStream.flush();
        return aPersonIDHouseholdID;
    }

    /**
     * Writes out ToyModel output type 2 via this._ToyModelFileOutputStream
     *
     * @param aPersonIDHouseholdID
     * @param fitness
     * @return long[] result
     *         <ul>
     *         <li>result[0] is the next sequential personID</li>
     *         <li>result[1] is the next sequential householdID</li>
     *         </ul>
     * @throws java.io.IOException
     */
    public long[] write2_HSARHP(
            HSARDataRecord aHSARDataRecord,
            CASDataRecord aCASDataRecord,
            BigDecimal fitness,
            long[] aPersonIDHouseholdID)
            throws IOException {
        // AREACODE,PERSONID,HOUSEHOLDID,HSARRECORDID,INDIVIDUALSARRECORDID,AGE,SEX,LLTI,HEALTH,ETHNICITY,CAROWNERSHIP
        String toyModelRecord = String.valueOf(aCASDataRecord.getZone_Code());
        if (aHSARDataRecord.get_HRP()) {
            aPersonIDHouseholdID[0] = 0;
            aPersonIDHouseholdID[1]++;
        } else {
            aPersonIDHouseholdID[0]++;
        }
        toyModelRecord += "," + Long.toString(aPersonIDHouseholdID[0]);
        // toyModelRecord += "," + aHSARDataRecord.getPNUM();
        toyModelRecord += "," + Long.toString(aPersonIDHouseholdID[1]);
        toyModelRecord += "," + aHSARDataRecord.get_RecordID();
        toyModelRecord += ",-9";
        toyModelRecord += "," + aHSARDataRecord.get_AGEH();
        boolean SEX = aHSARDataRecord.get_SEX();
        if (SEX) {
            toyModelRecord += ",1";
        } else {
            toyModelRecord += ",0";
        }
        toyModelRecord += "," + aHSARDataRecord.get_LLTI();
        toyModelRecord += "," + aHSARDataRecord.get_HEALTH();
        short ETHEW = aHSARDataRecord.get_ETHEW();
        if (ETHEW > 0) {
            if (ETHEW < 4) {
                toyModelRecord += ",0";
            } else {
                if ((ETHEW > 3 && ETHEW < 6) || (ETHEW > 11 && ETHEW < 15)) {
                    toyModelRecord += ",1";
                } else {
                    if (ETHEW == 6 || (ETHEW > 7 && ETHEW < 12)) {
                        toyModelRecord += ",2";
                    } else {
                        toyModelRecord += ",3";
                    }
                }
            }
        } else {
            toyModelRecord += ",-9";
        }
        if (aHSARDataRecord.get_HRP()) {
            toyModelRecord += "," + aHSARDataRecord.get_CARSH();
        } else {
            toyModelRecord += ",-9";
        }
        this._ToyModelFileOutputStream.write(toyModelRecord.getBytes());
        this._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
        this._ToyModelFileOutputStream.flush();
        return aPersonIDHouseholdID;
    }

    /**
     * Writes out ToyModel output type 2 via this._ToyModelFileOutputStream
     *
     * @param aPersonIDHouseholdID
     * @param fitness
     * @return long[] result
     *         <ul>
     *         <li>result[0] is the next sequential personID</li>
     *         <li>result[1] is the next sequential householdID</li>
     *         </ul>
     * @throws java.io.IOException
     */
    public long[] write2_HSARHP(
            HSARDataRecord aHSARDataRecord,
            CASDataRecord_1 _CASDataRecord_1,
            BigDecimal fitness,
            long[] aPersonIDHouseholdID)
            throws IOException {
        // AREACODE,PERSONID,HOUSEHOLDID,HSARRECORDID,INDIVIDUALSARRECORDID,AGE,SEX,LLTI,HEALTH,ETHNICITY,CAROWNERSHIP
        String toyModelRecord = String.valueOf(_CASDataRecord_1.getZone_Code());
        if (aHSARDataRecord.get_HRP()) {
            aPersonIDHouseholdID[0] = 0;
            aPersonIDHouseholdID[1]++;
        } else {
            aPersonIDHouseholdID[0]++;
        }
        toyModelRecord += "," + Long.toString(aPersonIDHouseholdID[0]);
        // toyModelRecord += "," + aHSARDataRecord.getPNUM();
        toyModelRecord += "," + Long.toString(aPersonIDHouseholdID[1]);
        toyModelRecord += "," + aHSARDataRecord.get_RecordID();
        toyModelRecord += ",-9";
        toyModelRecord += "," + aHSARDataRecord.get_AGEH();
        boolean SEX = aHSARDataRecord.get_SEX();
        if (SEX) {
            toyModelRecord += ",1";
        } else {
            toyModelRecord += ",0";
        }
        toyModelRecord += "," + aHSARDataRecord.get_LLTI();
        toyModelRecord += "," + aHSARDataRecord.get_HEALTH();
        short ETHEW = aHSARDataRecord.get_ETHEW();
        if (ETHEW > 0) {
            if (ETHEW < 4) {
                toyModelRecord += ",0";
            } else {
                if ((ETHEW > 3 && ETHEW < 6) || (ETHEW > 11 && ETHEW < 15)) {
                    toyModelRecord += ",1";
                } else {
                    if (ETHEW == 6 || (ETHEW > 7 && ETHEW < 12)) {
                        toyModelRecord += ",2";
                    } else {
                        toyModelRecord += ",3";
                    }
                }
            }
        } else {
            toyModelRecord += ",-9";
        }
        if (aHSARDataRecord.get_HRP()) {
            toyModelRecord += "," + aHSARDataRecord.get_CARSH();
        } else {
            toyModelRecord += ",-9";
        }
        this._ToyModelFileOutputStream.write(toyModelRecord.getBytes());
        this._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
        this._ToyModelFileOutputStream.flush();
        return aPersonIDHouseholdID;
    }
}