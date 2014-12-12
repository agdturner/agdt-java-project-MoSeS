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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;

/**
 * Class for handling output that compares some non-constraint variables in the 
 * CAS and IndividualCensus outputs.
 * (For IPS and GA comparison runs.)
 */
public class OutputDataHandler_NonConstraints_1 extends AbstractOutputDataHandler {

    public OutputDataHandler_NonConstraints_1() {
    }

    /**
     * @param args
     *            the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        new OutputDataHandler_NonConstraints_1().run();
    }

    /**
     * TODO docs
     * @throws java.io.IOException
     */
    public void run() throws IOException {
    }

    /**
     * Writes out header.
     * @throws java.io.IOException
     */
    public void writeHeader() throws IOException {
        String header = "_ZoneCode," + "_PeopleAged16to74WithNoQualifications," + "_PeopleAged16to74WithHighestQualificationAttainedLevel1," + "_PeopleAged16to74WithHighestQualificationAttainedLevel2," + "_PeopleAged16to74WithHighestQualificationAttainedLevel3," + "_PeopleAged16to74WithHighestQualificationAttainedLevel4and5," + "_NoCarOwnershipHouseholds";
        System.out.println(header);
        this._FileOutputStream.write(header.getBytes());
        this._FileOutputStream.write(StreamTokenizer.TT_EOL);
        this._FileOutputStream.flush();
    }

    public void writeObserved(
            String _CASDataDirectory,
            String _OutputFileName,
            long _StartRecordID,
            long _EndRecordID,
            String _AreaLevel,
            ISARDataHandler tISARDataHandler)
            throws IOException {
        this._OutputFile = new File(_OutputFileName);
        this._OutputFile.getParentFile().mkdir();
        _FileOutputStream = new FileOutputStream(_OutputFile);
        File _File = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/CASKS013DataRecordsMSOA.dat");
        CASKS013DataHandler _CASKS013DataHandler = new CASKS013DataHandler(
                _File);
        writeHeader();
        this._CASDataHandler = new CASDataHandler(new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/"), "MSOA");
        CASDataRecord _CASDataRecord;
        CASKS013DataRecord _CASKS013DataRecord;
        Counts _Counts = new Counts();
        for (long RecordID = _StartRecordID; RecordID <= _EndRecordID; RecordID++) {
            // System.out.println("RecordID " + RecordID);
            _CASDataRecord = (CASDataRecord) this._CASDataHandler.getDataRecord(RecordID);
            _CASKS013DataRecord = (CASKS013DataRecord) _CASKS013DataHandler.getDataRecord(RecordID);
            _Counts._PeopleAged16to74WithNoQualifications = _CASKS013DataRecord._PeopleAged16to74WithNoQualifications;
            _Counts._PeopleAged16to74WithHighestQualificationAttainedLevel1 = _CASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel1;
            _Counts._PeopleAged16to74WithHighestQualificationAttainedLevel2 = _CASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel2;
            _Counts._PeopleAged16to74WithHighestQualificationAttainedLevel3 = _CASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel3;
            _Counts._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = _CASKS013DataRecord._PeopleAged16to74WithHighestQualificationAttainedLevel4and5;
            _Counts._NoCarOwnershipHouseholds = _CASDataRecord.tCASKS017DataRecord.getHouseholdsWith0CarsOrVans();
            write(_Counts, String.valueOf(_CASDataRecord.getZone_Code()));
        }
    }

    /**
     * @param _Aggregation
     *            OA, MSOA, Ward
     * @param filenamePrefix
     * @param filenameSuffix
     * @throws java.io.IOException
     */
    public void writeEstimated_HSARHP(String directory, String filenamePrefix,
            String filenameSuffix, String _Aggregation) throws IOException {
        this._OutputFile = new File(directory + filenamePrefix + filenameSuffix);
        this._OutputFile.createNewFile();
        File _InputFile = new File(directory + filenamePrefix + ".csv");
        writeEstimated_HSARHP(_InputFile, _OutputFile, _Aggregation);
    }

    @Override
    public void writeEstimated_HSARHP(File _InputFile, File _OutputFile,
            String _Aggregation) throws IOException {
        ToyModelDataHandler tToyModelDataHandler = new ToyModelDataHandler();
        _OutputFile.getParentFile().mkdirs();
        this._FileOutputStream = new FileOutputStream(_OutputFile);
        writeHeader();
        CASDataRecord aCASDataRecord;
        int _EthnicityWhite;
        int _PeopleAged16to74WithNoQualifications;
        int _PeopleAged16to74WithHighestQualificationAttainedLevel1;
        int _PeopleAged16to74WithHighestQualificationAttainedLevel2;
        int _PeopleAged16to74WithHighestQualificationAttainedLevel3;
        int _PeopleAged16to74WithHighestQualificationAttainedLevel4and5;
        int _NoCarOwnershipHouseholds;
        HSARDataHandler tHSARDataHandler = new HSARDataHandler(
                new File("C:/Work/Projects/MoSeS/Workspace/",
                "uk.ac.leeds.ccg.andyt.projects.moses.io.HSARDataHandler.thisFile"));
        ISARDataHandler tISARDataHandler = new ISARDataHandler(
                new File("C:/Work/Projects/MoSeS/Workspace/",
                "uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataHandler_AGE0Indexed.thisFile"));
        HSARDataRecord _HSARDataRecord;
        ISARDataRecord _ISARDataRecord;
        BufferedReader tBufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(_InputFile)));
        StreamTokenizer tStreamTokenizer = new StreamTokenizer(tBufferedReader);
        Generic_StaticIO.setStreamTokenizerSyntax1(tStreamTokenizer);
        int tokenType = tStreamTokenizer.nextToken();
        ToyModelDataRecord_2 aToyModelDataRecord2;
        String aZoneCode;
        HashMap tLookUpMSOAfromOAHashMap = null;
        CASDataHandler tCASDataHandler = new CASDataHandler();
        if (_Aggregation.equalsIgnoreCase("MSOA")) {
            tLookUpMSOAfromOAHashMap = tCASDataHandler.get_LookUpMSOAfromOAHashMap();
        }
        short _HSARDataRecordQUALVEWN;
        short _ISARDataRecordQUALVEWN;
        short _ISARDataRecordQUALVS;
        Counts _Counts;
        TreeMap result = new TreeMap();
        while (tokenType != StreamTokenizer.TT_EOF) {
            switch (tokenType) {
                case StreamTokenizer.TT_WORD:
                    _EthnicityWhite = 0;
                    _NoCarOwnershipHouseholds = 0;
                    aToyModelDataRecord2 = new ToyModelDataRecord_2(
                            tToyModelDataHandler, tStreamTokenizer.sval);
                    if (_Aggregation.equalsIgnoreCase("MSOA")) {
                        aZoneCode = (String) tLookUpMSOAfromOAHashMap.get(new String(aToyModelDataRecord2.getZone_Code()));
                    } else {
                        aZoneCode = String.valueOf(aToyModelDataRecord2.getZone_Code());
                        if (_Aggregation.equalsIgnoreCase("Ward")) {
                            aZoneCode = aZoneCode.substring(0, 6);
                        }
                    }
                    _PeopleAged16to74WithNoQualifications = 0;
                    _PeopleAged16to74WithHighestQualificationAttainedLevel1 = 0;
                    _PeopleAged16to74WithHighestQualificationAttainedLevel2 = 0;
                    _PeopleAged16to74WithHighestQualificationAttainedLevel3 = 0;
                    _PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = 0;
                    _NoCarOwnershipHouseholds = 0;
                    if (aToyModelDataRecord2.tHSARDataRecordID != -9) {
                        _HSARDataRecord = (HSARDataRecord) tHSARDataHandler.getDataRecord(aToyModelDataRecord2.tHSARDataRecordID);
                        _HSARDataRecordQUALVEWN = _HSARDataRecord.get_QUALVEWN();
                        if (_HSARDataRecordQUALVEWN == 1) {
                            _PeopleAged16to74WithNoQualifications = 1;
                        }
                        if (_HSARDataRecordQUALVEWN == 2) {
                            _PeopleAged16to74WithHighestQualificationAttainedLevel1 = 1;
                        }
                        if (_HSARDataRecordQUALVEWN == 3) {
                            _PeopleAged16to74WithHighestQualificationAttainedLevel2 = 1;
                        }
                        if (_HSARDataRecordQUALVEWN == 4) {
                            _PeopleAged16to74WithHighestQualificationAttainedLevel3 = 1;
                        }
                        if (_HSARDataRecordQUALVEWN == 5) {
                            _PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = 1;
                        }
                        if (_HSARDataRecord.get_CARSH() == 0) {
                            if (_HSARDataRecord.get_HRP()) {
                                _NoCarOwnershipHouseholds = 1;
                            }
                        }
                    } else {
                        _ISARDataRecord = (ISARDataRecord) tISARDataHandler.getDataRecord(aToyModelDataRecord2.tISARDataRecordID);
                        _ISARDataRecordQUALVEWN = _ISARDataRecord.get_QUALVEWN();
                        _ISARDataRecordQUALVS = _ISARDataRecord.get_QUALVS();
                        if (_ISARDataRecordQUALVS == -9) {
                            if (_ISARDataRecordQUALVEWN == 1) {
                                _PeopleAged16to74WithNoQualifications = 1;
                            }
                            if (_ISARDataRecordQUALVEWN == 2) {
                                _PeopleAged16to74WithHighestQualificationAttainedLevel1 = 1;
                            }
                            if (_ISARDataRecordQUALVEWN == 3) {
                                _PeopleAged16to74WithHighestQualificationAttainedLevel2 = 1;
                            }
                            if (_ISARDataRecordQUALVEWN == 4) {
                                _PeopleAged16to74WithHighestQualificationAttainedLevel3 = 1;
                            }
                            if (_ISARDataRecordQUALVEWN == 5) {
                                _PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = 1;
                            }
                        } else {
                            if (_ISARDataRecordQUALVS == 1) {
                                _PeopleAged16to74WithNoQualifications = 1;
                            }
                            if (_ISARDataRecordQUALVS == 2) {
                                _PeopleAged16to74WithHighestQualificationAttainedLevel1 = 1;
                            }
                            if (_ISARDataRecordQUALVS == 3) {
                                _PeopleAged16to74WithHighestQualificationAttainedLevel2 = 1;
                            }
                            if (_ISARDataRecordQUALVS == 4) {
                                _PeopleAged16to74WithHighestQualificationAttainedLevel3 = 1;
                            }
                            if (_ISARDataRecordQUALVS == 5) {
                                _PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = 1;
                            }
                        }
                    }
                    if (result.containsKey(aZoneCode)) {
                        _Counts = (Counts) result.get(aZoneCode);
                        result.remove(aZoneCode);
                        _Counts.addToCounts(
                                _PeopleAged16to74WithNoQualifications,
                                _PeopleAged16to74WithHighestQualificationAttainedLevel1,
                                _PeopleAged16to74WithHighestQualificationAttainedLevel2,
                                _PeopleAged16to74WithHighestQualificationAttainedLevel3,
                                _PeopleAged16to74WithHighestQualificationAttainedLevel4and5,
                                _NoCarOwnershipHouseholds);
                        result.put(aZoneCode, _Counts);
                    } else {
                        _Counts = new Counts();
                        _Counts.addToCounts(
                                _PeopleAged16to74WithNoQualifications,
                                _PeopleAged16to74WithHighestQualificationAttainedLevel1,
                                _PeopleAged16to74WithHighestQualificationAttainedLevel2,
                                _PeopleAged16to74WithHighestQualificationAttainedLevel3,
                                _PeopleAged16to74WithHighestQualificationAttainedLevel4and5,
                                _NoCarOwnershipHouseholds);
                        result.put(aZoneCode, _Counts);
                    }
            }
            tokenType = tStreamTokenizer.nextToken();
        }
        Iterator aIterator = result.keySet().iterator();
        Object key;
        while (aIterator.hasNext()) {
            key = aIterator.next();
            _Counts = (Counts) result.get(key);
            aZoneCode = (String) key;
            write(_Counts, aZoneCode);
        }
        this._FileOutputStream.close();
    }

    protected void write(Counts _Counts, String _ZoneCode) throws IOException {
        String record = _ZoneCode + "," + _Counts._PeopleAged16to74WithNoQualifications + "," + _Counts._PeopleAged16to74WithHighestQualificationAttainedLevel1 + "," + _Counts._PeopleAged16to74WithHighestQualificationAttainedLevel2 + "," + _Counts._PeopleAged16to74WithHighestQualificationAttainedLevel3 + "," + _Counts._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 + "," + _Counts._NoCarOwnershipHouseholds;
        System.out.println(record);
        this._FileOutputStream.write(record.getBytes());
        this._FileOutputStream.write(StreamTokenizer.TT_EOL);
        this._FileOutputStream.flush();
    }

    public class Counts {

        int _PeopleAged16to74WithNoQualifications;
        int _PeopleAged16to74WithHighestQualificationAttainedLevel1;
        int _PeopleAged16to74WithHighestQualificationAttainedLevel2;
        int _PeopleAged16to74WithHighestQualificationAttainedLevel3;
        int _PeopleAged16to74WithHighestQualificationAttainedLevel4and5;
        int _NoCarOwnershipHouseholds;

        public Counts() {
            _PeopleAged16to74WithNoQualifications = 0;
            _PeopleAged16to74WithHighestQualificationAttainedLevel1 = 0;
            _PeopleAged16to74WithHighestQualificationAttainedLevel2 = 0;
            _PeopleAged16to74WithHighestQualificationAttainedLevel3 = 0;
            _PeopleAged16to74WithHighestQualificationAttainedLevel4and5 = 0;
            _NoCarOwnershipHouseholds = 0;
        }

        public void addToCounts(
                int _PeopleAged16to74WithNoQualifications,
                int _PeopleAged16to74WithHighestQualificationAttainedLevel1,
                int _PeopleAged16to74WithHighestQualificationAttainedLevel2,
                int _PeopleAged16to74WithHighestQualificationAttainedLevel3,
                int _PeopleAged16to74WithHighestQualificationAttainedLevel4and5,
                int _NoCarOwnershipHouseholds) {
            this._PeopleAged16to74WithNoQualifications += _PeopleAged16to74WithNoQualifications;
            this._PeopleAged16to74WithHighestQualificationAttainedLevel1 += _PeopleAged16to74WithHighestQualificationAttainedLevel1;
            this._PeopleAged16to74WithHighestQualificationAttainedLevel2 += _PeopleAged16to74WithHighestQualificationAttainedLevel2;
            this._PeopleAged16to74WithHighestQualificationAttainedLevel3 += _PeopleAged16to74WithHighestQualificationAttainedLevel3;
            this._PeopleAged16to74WithHighestQualificationAttainedLevel4and5 += _PeopleAged16to74WithHighestQualificationAttainedLevel4and5;
            this._NoCarOwnershipHouseholds += _NoCarOwnershipHouseholds;
        }
    }
}