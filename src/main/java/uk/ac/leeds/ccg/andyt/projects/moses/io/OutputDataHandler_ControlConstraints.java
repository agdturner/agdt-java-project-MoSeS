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

import uk.ac.leeds.ccg.andyt.census.core.Census_CASDataRecord;
import uk.ac.leeds.ccg.andyt.census.core.Census_CASDataHandler;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS003DataRecord;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS001DataRecord;
import uk.ac.leeds.ccg.andyt.census.sar.Census_HSARDataHandler;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataHandler;
import uk.ac.leeds.ccg.andyt.census.sar.Census_HSARDataRecord;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataRecord;
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
import uk.ac.leeds.ccg.andyt.generic.io.Generic_IO;

/**
 * Class for handling output that confirms results control constrain.
 */
public class OutputDataHandler_ControlConstraints extends AbstractOutputDataHandler {

    public OutputDataHandler_ControlConstraints() {
    }

    /**
     * @param args
     *            the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        new OutputDataHandler_ControlConstraints().run();
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
        String header = "_ZoneCode," + "_AllHousehold," +
                "_HRPAge0to19,_HRPAge20to29,_HRPAge30to39,_HRPAge40to49,_HRPAge50to59,_HRPAge60to69,_HRPAge70to79,_HRPAge80AndOver," + "_CEPAgeAllAges,_CEPAge0,_CEPAge1,_CEPAge2,_CEPAge3,_CEPAge4,_CEPAge5,_CEPAge6,_CEPAge7,_CEPAge8,_CEPAge9,_CEPAge10,_CEPAge11,_CEPAge12,_CEPAge13,_CEPAge14,_CEPAge15,_CEPAge16to19,_CEPAge20to24,_CEPAge25to29,_CEPAge30to44,_CEPAge45to59,_CEPAge60to64,_CEPAge65to69,_CEPAge70to74,_CEPAge75to79,_CEPAge80to84,_CEPAge85to89,_CEPAge90AndOver";
        System.out.println(header);
        this._FileOutputStream.write(header.getBytes());
        this._FileOutputStream.write(StreamTokenizer.TT_EOL);
        this._FileOutputStream.flush();
    }

    /**
     *
     * @param tISARDataHandler
     * @param _AreaLevel
     * @throws java.io.IOException
     */
    public void writeObserved(
            String _CASDataDirectory,
            String _OutputFileName,
            long _StartRecordID,
            long _EndRecordID,
            String _AreaLevel,
            Census_ISARDataHandler tISARDataHandler)
            throws IOException {
        this._OutputFile = new File(_OutputFileName);
        this._OutputFile.getParentFile().mkdir();
        // this._OutputFile = new File(
        // "C:/Work/Projects/MoSeS/Workspace/Leeds/MarkOutputConstraintsOA.csv"
        // );
        _FileOutputStream = new FileOutputStream(_OutputFile);
        this._CASDataHandler = new Census_CASDataHandler(new File(_CASDataDirectory),
                _AreaLevel);
        // this._CASDataHandler = new Census_CASDataHandler( new File(
        // "C:/Work/Projects/MoSeS/Workspace/" ), "" );
        writeHeader();
        Census_CASDataRecord _CASDataRecord;
        Census_CAS003DataRecord _CAS003DataRecord;
        Census_CAS001DataRecord _CAS001DataRecord;
        Counts _Counts = new Counts();
        HashMap _CAS003AgeCountConstraintHashMap;
        HashMap _CAS001AgeCountHPConstraintHashMap;
        HashMap _CAS001AgeCountCEPConstraintHashMap;
        for (long RecordID = _StartRecordID; RecordID <= _EndRecordID; RecordID++) {
            // System.out.println("RecordID " + RecordID);
            _CASDataRecord = (Census_CASDataRecord) this._CASDataHandler.getDataRecord(RecordID);
            _CAS003DataRecord = _CASDataRecord.getCAS003DataRecord();
            _CAS001DataRecord = _CASDataRecord.getCAS001DataRecord();
            // Initialise _Counts
            _Counts._AllHouseholds = _CAS003DataRecord.getAllHouseholdsTotal();
            // Census_CAS003DataRecord Constraints
            _CAS003AgeCountConstraintHashMap = _CASDataHandler.getCAS003DataHandler().getCAS003AgeSex1_AgeSexType_Count_HashMap(
                    _CAS003DataRecord,
                    tISARDataHandler);
            _Counts._HRPAge0to19 = (Integer) _CAS003AgeCountConstraintHashMap.get(0);
            _Counts._HRPAge20to29 = (Integer) _CAS003AgeCountConstraintHashMap.get(20);
            _Counts._HRPAge30to39 = (Integer) _CAS003AgeCountConstraintHashMap.get(30);
            _Counts._HRPAge40to49 = (Integer) _CAS003AgeCountConstraintHashMap.get(40);
            _Counts._HRPAge50to59 = (Integer) _CAS003AgeCountConstraintHashMap.get(50);
            _Counts._HRPAge60to69 = (Integer) _CAS003AgeCountConstraintHashMap.get(60);
            _Counts._HRPAge70to79 = (Integer) _CAS003AgeCountConstraintHashMap.get(70);
            _Counts._HRPAge80AndOver = (Integer) _CAS003AgeCountConstraintHashMap.get(80);
            // CAS001Data Records CEP Constraints
            _CAS001AgeCountCEPConstraintHashMap = this._CASDataHandler.getCAS001DataHandler().getCAS001CEPAgeCount3_HashMap(
                    _CAS001DataRecord);
            _Counts._CEPAge0AndOver = _CAS001DataRecord.getCommunalEstablishmentResidentsFemales() + _CAS001DataRecord.getCommunalEstablishmentResidentsMales();
            _Counts._CEPAge0 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(0);
            _Counts._CEPAge1 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(1);
            _Counts._CEPAge2 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(2);
            _Counts._CEPAge3 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(3);
            _Counts._CEPAge4 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(4);
            _Counts._CEPAge5 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(5);
            _Counts._CEPAge6 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(6);
            _Counts._CEPAge7 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(7);
            _Counts._CEPAge8 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(8);
            _Counts._CEPAge9 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(9);
            _Counts._CEPAge10 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(10);
            _Counts._CEPAge11 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(11);
            _Counts._CEPAge12 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(12);
            _Counts._CEPAge13 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(13);
            _Counts._CEPAge14 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(14);
            _Counts._CEPAge15 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(15);
            _Counts._CEPAge16to19 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(16);
            _Counts._CEPAge20to24 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(20);
            _Counts._CEPAge25to29 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(25);
            _Counts._CEPAge30to44 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(30);
            _Counts._CEPAge45to59 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(45);
            _Counts._CEPAge60to64 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(60);
            _Counts._CEPAge65to69 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(65);
            _Counts._CEPAge70to74 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(70);
            _Counts._CEPAge75to79 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(75);
            _Counts._CEPAge80to84 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(80);
            _Counts._CEPAge85to89 = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(85);
            _Counts._CEPAge90AndOver = (Integer) _CAS001AgeCountCEPConstraintHashMap.get(90);
            write(_Counts, String.valueOf(_CASDataRecord.getZone_Code()));
        }
    }

    /**
     * writeEstimated_HSARHP
     *
     * @param _Aggregation
     *            OA, MSOA, Ward
     * @param filenamePrefix
     * @param filenameSuffix
     * @throws java.io.IOException
     */
    public void writeEstimated_HSARHP(
            String directory,
            String filenamePrefix,
            String filenameSuffix, 
            String _Aggregation)
            throws IOException {
        this._OutputFile = new File(directory + filenamePrefix + filenameSuffix);
        this._OutputFile.createNewFile();
        File _InputFile = new File(directory + filenamePrefix + ".csv");
        writeEstimated_HSARHP(_InputFile, _OutputFile, _Aggregation);
    }

    /**
     * writeEstimated_HSARHP
     * @param _Aggregation
     * @param _OutputFile
     * @throws java.io.IOException
     */
    @Override
    public void writeEstimated_HSARHP(
            File _InputFile,
            File _OutputFile,
            String _Aggregation)
            throws IOException {
        ToyModelDataHandler tToyModelDataHandler = new ToyModelDataHandler();
        _OutputFile.getParentFile().mkdirs();
        this._FileOutputStream = new FileOutputStream(_OutputFile);
        writeHeader();
        Census_CASDataRecord _CASDataRecord;
        int _AllHouseholds = 0;
        int _HRPAge0to19 = 0;
        int _HRPAge20to29 = 0;
        int _HRPAge30to39 = 0;
        int _HRPAge40to49 = 0;
        int _HRPAge50to59 = 0;
        int _HRPAge60to69 = 0;
        int _HRPAge70to79 = 0;
        int _HRPAge80AndOver = 0;
        int _CEPAge0AndOver = 0;
        int _CEPAge0;
        int _CEPAge1;
        int _CEPAge2;
        int _CEPAge3;
        int _CEPAge4;
        int _CEPAge5;
        int _CEPAge6;
        int _CEPAge7;
        int _CEPAge8;
        int _CEPAge9;
        int _CEPAge10;
        int _CEPAge11;
        int _CEPAge12;
        int _CEPAge13;
        int _CEPAge14;
        int _CEPAge15;
        int _CEPAge16to19;
        int _CEPAge20to24;
        int _CEPAge25to29;
        int _CEPAge30to44;
        int _CEPAge45to59;
        int _CEPAge60to64;
        int _CEPAge65to69;
        int _CEPAge70to74;
        int _CEPAge75to79;
        int _CEPAge80to84;
        int _CEPAge85to89;
        int _CEPAge90AndOver;
        Census_HSARDataHandler tHSARDataHandler = new Census_HSARDataHandler(
                new File(
                //"C:/Work/Projects/MoSeS/Workspace/",
                "/scratch01/Work/Projects/MoSeS/Workspace/",
                "uk.ac.leeds.ccg.andyt.projects.moses.io.HSARDataHandler.thisFile"));
        Census_ISARDataHandler _ISARDataHandler = new Census_ISARDataHandler(
                new File(
                //"C:/Work/Projects/MoSeS/Workspace/",
                "/scratch01/Work/Projects/MoSeS/Workspace/",
                //"uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataHandler_AGE0Indexed.thisFile"));
                "uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataHandler.thisFile"));
        Census_HSARDataRecord _HSARDataRecord;
        Census_ISARDataRecord _ISARDataRecord;
        BufferedReader tBufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(_InputFile)));
        StreamTokenizer tStreamTokenizer = new StreamTokenizer(tBufferedReader);
        Generic_IO.setStreamTokenizerSyntax1(tStreamTokenizer);
        int tokenType = tStreamTokenizer.nextToken();



        ToyModelDataRecord_2 aToyModelDataRecord2;
        String aZoneCode;
        HashMap tLookUpMSOAfromOAHashMap = null;
        Census_CASDataHandler tCASDataHandler = new Census_CASDataHandler();
        if (_Aggregation.equalsIgnoreCase("MSOA")) {
            tLookUpMSOAfromOAHashMap = tCASDataHandler.get_LookUpMSOAfromOAHashMap();
        }
        short _HSARDataRecordAGEH;
        short _HSARDataRecordETHEW;
        short _ISARDataRecordAGE0;
        int _int_ISARDataRecordAGE0;
        short _ISARDataRecordECONACT;
        short _ISARDataRecordETHEW;
        short _ISARDataRecordETHN;
        short _ISARDataRecordETHS;
        Counts aCounts;
        TreeMap result = new TreeMap();
        while (tokenType != StreamTokenizer.TT_EOF) {
            switch (tokenType) {
                case StreamTokenizer.TT_WORD:
                    _AllHouseholds = 0;
                    _HRPAge0to19 = 0;
                    _HRPAge20to29 = 0;
                    _HRPAge30to39 = 0;
                    _HRPAge40to49 = 0;
                    _HRPAge50to59 = 0;
                    _HRPAge60to69 = 0;
                    _HRPAge70to79 = 0;
                    _HRPAge80AndOver = 0;
                    _CEPAge0AndOver = 0;
                    _CEPAge0 = 0;
                    _CEPAge1 = 0;
                    _CEPAge2 = 0;
                    _CEPAge3 = 0;
                    _CEPAge4 = 0;
                    _CEPAge5 = 0;
                    _CEPAge6 = 0;
                    _CEPAge7 = 0;
                    _CEPAge8 = 0;
                    _CEPAge9 = 0;
                    _CEPAge10 = 0;
                    _CEPAge11 = 0;
                    _CEPAge12 = 0;
                    _CEPAge13 = 0;
                    _CEPAge14 = 0;
                    _CEPAge15 = 0;
                    _CEPAge16to19 = 0;
                    _CEPAge20to24 = 0;
                    _CEPAge25to29 = 0;
                    _CEPAge30to44 = 0;
                    _CEPAge45to59 = 0;
                    _CEPAge60to64 = 0;
                    _CEPAge65to69 = 0;
                    _CEPAge70to74 = 0;
                    _CEPAge75to79 = 0;
                    _CEPAge80to84 = 0;
                    _CEPAge85to89 = 0;
                    _CEPAge90AndOver = 0;
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
                    if (aToyModelDataRecord2.tHSARDataRecordID != -9) {
                        _HSARDataRecord = (Census_HSARDataRecord) tHSARDataHandler.getDataRecord(aToyModelDataRecord2.tHSARDataRecordID);
                        _HSARDataRecordAGEH = _HSARDataRecord.get_AGEH();
                        if (_HSARDataRecord.get_HRP()) {
                            _AllHouseholds = 1;
                            if (_HSARDataRecordAGEH < 20) {
                                _HRPAge0to19 = 1;
                            } else {
                                if (_HSARDataRecordAGEH < 30) {
                                    _HRPAge20to29 = 1;
                                } else {
                                    if (_HSARDataRecordAGEH < 40) {
                                        _HRPAge30to39 = 1;
                                    } else {
                                        if (_HSARDataRecordAGEH < 50) {
                                            _HRPAge40to49 = 1;
                                        } else {
                                            if (_HSARDataRecordAGEH < 60) {
                                                _HRPAge50to59 = 1;
                                            } else {
                                                if (_HSARDataRecordAGEH < 70) {
                                                    _HRPAge60to69 = 1;
                                                } else {
                                                    if (_HSARDataRecordAGEH < 80) {
                                                        _HRPAge70to79 = 1;
                                                    } else {
                                                        _HRPAge80AndOver = 1;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        _ISARDataRecord = (Census_ISARDataRecord) _ISARDataHandler.getDataRecord(aToyModelDataRecord2.tISARDataRecordID);
                        _ISARDataRecordAGE0 = _ISARDataRecord.get_AGE0();
                        _int_ISARDataRecordAGE0 = _ISARDataRecordAGE0;
                        _CEPAge0AndOver = 1;
                        switch (_int_ISARDataRecordAGE0) {
                            case 0:
                                _CEPAge0 = 1;
                                break;
                            case 1:
                                _CEPAge1 = 1;
                                break;
                            case 2:
                                _CEPAge2 = 1;
                                break;
                            case 3:
                                _CEPAge3 = 1;
                                break;
                            case 4:
                                _CEPAge4 = 1;
                                break;
                            case 5:
                                _CEPAge5 = 1;
                                break;
                            case 6:
                                _CEPAge6 = 1;
                                break;
                            case 7:
                                _CEPAge7 = 1;
                                break;
                            case 8:
                                _CEPAge8 = 1;
                                break;
                            case 9:
                                _CEPAge9 = 1;
                                break;
                            case 10:
                                _CEPAge10 = 1;
                                break;
                            case 11:
                                _CEPAge11 = 1;
                                break;
                            case 12:
                                _CEPAge12 = 1;
                                break;
                            case 13:
                                _CEPAge13 = 1;
                                break;
                            case 14:
                                _CEPAge14 = 1;
                                break;
                            case 15:
                                _CEPAge15 = 1;
                                break;
                            case 16:
                                _CEPAge16to19 = 1;
                                break;
                            case 20:
                                _CEPAge20to24 = 1;
                                break;
                            case 25:
                                _CEPAge25to29 = 1;
                                break;
                            case 30:
                                _CEPAge30to44 = 1;
                                break;
                            case 45:
                                _CEPAge45to59 = 1;
                                break;
                            case 60:
                                _CEPAge60to64 = 1;
                                break;
                            case 65:
                                _CEPAge65to69 = 1;
                                break;
                            case 70:
                                _CEPAge70to74 = 1;
                                break;
                            case 75:
                                _CEPAge75to79 = 1;
                                break;
                            case 76:
                                _CEPAge75to79 = 1;
                                break;
                            case 77:
                                _CEPAge75to79 = 1;
                                break;
                            case 78:
                                _CEPAge75to79 = 1;
                                break;
                            case 79:
                                _CEPAge75to79 = 1;
                                break;
                            case 80:
                                _CEPAge80to84 = 1;
                                break;
                            case 81:
                                _CEPAge80to84 = 1;
                                break;
                            case 82:
                                _CEPAge80to84 = 1;
                                break;
                            case 83:
                                _CEPAge80to84 = 1;
                                break;
                            case 84:
                                _CEPAge80to84 = 1;
                                break;
                            case 85:
                                _CEPAge85to89 = 1;
                                break;
                            case 86:
                                _CEPAge85to89 = 1;
                                break;
                            case 87:
                                _CEPAge85to89 = 1;
                                break;
                            case 88:
                                _CEPAge85to89 = 1;
                                break;
                            case 89:
                                _CEPAge85to89 = 1;
                                break;
                            case 90:
                                _CEPAge90AndOver = 1;
                                break;
                            case 91:
                                _CEPAge90AndOver = 1;
                                break;
                            case 92:
                                _CEPAge90AndOver = 1;
                                break;
                            case 93:
                                _CEPAge90AndOver = 1;
                                break;
                            case 94:
                                _CEPAge90AndOver = 1;
                                break;
                            case 95:
                                _CEPAge90AndOver = 1;
                                break;
                            default:
                                System.out.println("Unrecognized case " + _int_ISARDataRecordAGE0 + " not in (1-15,16,20,25,30,45,60,65,70,75-90) in writeEstimated_HSARHP(String,String,String,String)");
                                break;
                        }
                    }
                    if (result.containsKey(aZoneCode)) {
                        aCounts = (Counts) result.get(aZoneCode);
                        result.remove(aZoneCode);
                        aCounts.addToCounts(_AllHouseholds, _HRPAge0to19,
                                _HRPAge20to29, _HRPAge30to39, _HRPAge40to49,
                                _HRPAge50to59, _HRPAge60to69, _HRPAge70to79,
                                _HRPAge80AndOver, _CEPAge0AndOver, _CEPAge0,
                                _CEPAge1, _CEPAge2, _CEPAge3, _CEPAge4, _CEPAge5,
                                _CEPAge6, _CEPAge7, _CEPAge8, _CEPAge9, _CEPAge10,
                                _CEPAge11, _CEPAge12, _CEPAge13, _CEPAge14,
                                _CEPAge15, _CEPAge16to19, _CEPAge20to24,
                                _CEPAge25to29, _CEPAge30to44, _CEPAge45to59,
                                _CEPAge60to64, _CEPAge65to69, _CEPAge70to74,
                                _CEPAge75to79, _CEPAge80to84, _CEPAge85to89,
                                _CEPAge90AndOver);
                        result.put(aZoneCode, aCounts);
                    } else {
                        aCounts = new Counts();
                        aCounts.addToCounts(_AllHouseholds, _HRPAge0to19,
                                _HRPAge20to29, _HRPAge30to39, _HRPAge40to49,
                                _HRPAge50to59, _HRPAge60to69, _HRPAge70to79,
                                _HRPAge80AndOver, _CEPAge0AndOver, _CEPAge0,
                                _CEPAge1, _CEPAge2, _CEPAge3, _CEPAge4, _CEPAge5,
                                _CEPAge6, _CEPAge7, _CEPAge8, _CEPAge9, _CEPAge10,
                                _CEPAge11, _CEPAge12, _CEPAge13, _CEPAge14,
                                _CEPAge15, _CEPAge16to19, _CEPAge20to24,
                                _CEPAge25to29, _CEPAge30to44, _CEPAge45to59,
                                _CEPAge60to64, _CEPAge65to69, _CEPAge70to74,
                                _CEPAge75to79, _CEPAge80to84, _CEPAge85to89,
                                _CEPAge90AndOver);
                        result.put(aZoneCode, aCounts);
                    }
            }
            tokenType = tStreamTokenizer.nextToken();
        }
        Iterator aIterator = result.keySet().iterator();
        Object key;
        while (aIterator.hasNext()) {
            key = aIterator.next();
            aCounts = (Counts) result.get(key);
            aZoneCode = (String) key;
            write(aCounts, aZoneCode);
        }
        this._FileOutputStream.close();
    }

    /**
     *
     * @param _Counts
     * @param _ZoneCode
     * @throws java.io.IOException
     */
    protected void write(Counts _Counts, String _ZoneCode) throws IOException {
        String record = _ZoneCode + "," + _Counts._AllHouseholds + "," + _Counts._HRPAge0to19 + "," + _Counts._HRPAge20to29 + "," + _Counts._HRPAge30to39 + "," + _Counts._HRPAge40to49 + "," + _Counts._HRPAge50to59 + "," + _Counts._HRPAge60to69 + "," + _Counts._HRPAge70to79 + "," + _Counts._HRPAge80AndOver + "," + _Counts._CEPAge0AndOver + "," + _Counts._CEPAge0 + "," + _Counts._CEPAge1 + "," + _Counts._CEPAge2 + "," + _Counts._CEPAge3 + "," + _Counts._CEPAge4 + "," + _Counts._CEPAge5 + "," + _Counts._CEPAge6 + "," + _Counts._CEPAge7 + "," + _Counts._CEPAge8 + "," + _Counts._CEPAge9 + "," + _Counts._CEPAge10 + "," + _Counts._CEPAge11 + "," + _Counts._CEPAge12 + "," + _Counts._CEPAge13 + "," + _Counts._CEPAge14 + "," + _Counts._CEPAge15 + "," + _Counts._CEPAge16to19 + "," + _Counts._CEPAge20to24 + "," + _Counts._CEPAge25to29 + "," + _Counts._CEPAge30to44 + "," + _Counts._CEPAge45to59 + "," + _Counts._CEPAge60to64 + "," + _Counts._CEPAge65to69 + "," + _Counts._CEPAge70to74 + "," + _Counts._CEPAge75to79 + "," + _Counts._CEPAge80to84 + "," + _Counts._CEPAge85to89 + "," + _Counts._CEPAge90AndOver;
        System.out.println(record);
        this._FileOutputStream.write(record.getBytes());
        this._FileOutputStream.write(StreamTokenizer.TT_EOL);
        this._FileOutputStream.flush();
    }

    public class Counts {

        int _AllHouseholds;
        int _HRPAge0to19;
        int _HRPAge20to29;
        int _HRPAge30to39;
        int _HRPAge40to49;
        int _HRPAge50to59;
        int _HRPAge60to69;
        int _HRPAge70to79;
        int _HRPAge80AndOver;
        int _CEPAge0AndOver;
        int _CEPAge0;
        int _CEPAge1;
        int _CEPAge2;
        int _CEPAge3;
        int _CEPAge4;
        int _CEPAge5;
        int _CEPAge6;
        int _CEPAge7;
        int _CEPAge8;
        int _CEPAge9;
        int _CEPAge10;
        int _CEPAge11;
        int _CEPAge12;
        int _CEPAge13;
        int _CEPAge14;
        int _CEPAge15;
        int _CEPAge16to19;
        int _CEPAge20to24;
        int _CEPAge25to29;
        int _CEPAge30to44;
        int _CEPAge45to59;
        int _CEPAge60to64;
        int _CEPAge65to69;
        int _CEPAge70to74;
        int _CEPAge75to79;
        int _CEPAge80to84;
        int _CEPAge85to89;
        int _CEPAge90AndOver;

        public Counts() {
            _AllHouseholds = 0;
            _HRPAge0to19 = 0;
            _HRPAge20to29 = 0;
            _HRPAge30to39 = 0;
            _HRPAge40to49 = 0;
            _HRPAge50to59 = 0;
            _HRPAge60to69 = 0;
            _HRPAge70to79 = 0;
            _HRPAge80AndOver = 0;
            _CEPAge0AndOver = 0;
            _CEPAge0 = 0;
            _CEPAge1 = 0;
            _CEPAge2 = 0;
            _CEPAge3 = 0;
            _CEPAge4 = 0;
            _CEPAge5 = 0;
            _CEPAge6 = 0;
            _CEPAge7 = 0;
            _CEPAge8 = 0;
            _CEPAge9 = 0;
            _CEPAge10 = 0;
            _CEPAge11 = 0;
            _CEPAge12 = 0;
            _CEPAge13 = 0;
            _CEPAge14 = 0;
            _CEPAge15 = 0;
            _CEPAge16to19 = 0;
            _CEPAge20to24 = 0;
            _CEPAge25to29 = 0;
            _CEPAge30to44 = 0;
            _CEPAge45to59 = 0;
            _CEPAge60to64 = 0;
            _CEPAge65to69 = 0;
            _CEPAge70to74 = 0;
            _CEPAge75to79 = 0;
            _CEPAge80to84 = 0;
            _CEPAge85to89 = 0;
            _CEPAge90AndOver = 0;
        }

        public void addToCounts(int _AllHouseholds, int _HRPAge0to19,
                int _HRPAge20to29, int _HRPAge30to39, int _HRPAge40to49,
                int _HRPAge50to59, int _HRPAge60to69, int _HRPAge70to79,
                int _HRPAge80AndOver, int _CEPAge0AndOver, int _CEPAge0,
                int _CEPAge1, int _CEPAge2, int _CEPAge3, int _CEPAge4,
                int _CEPAge5, int _CEPAge6, int _CEPAge7, int _CEPAge8,
                int _CEPAge9, int _CEPAge10, int _CEPAge11, int _CEPAge12,
                int _CEPAge13, int _CEPAge14, int _CEPAge15, int _CEPAge16to19,
                int _CEPAge20to24, int _CEPAge25to29, int _CEPAge30to44,
                int _CEPAge45to59, int _CEPAge60to64, int _CEPAge65to69,
                int _CEPAge70to74, int _CEPAge75to79, int _CEPAge80to84,
                int _CEPAge85to89, int _CEPAge90AndOver) {
            this._AllHouseholds += _AllHouseholds;
            this._HRPAge0to19 += _HRPAge0to19;
            this._HRPAge20to29 += _HRPAge20to29;
            this._HRPAge30to39 += _HRPAge30to39;
            this._HRPAge40to49 += _HRPAge40to49;
            this._HRPAge50to59 += _HRPAge50to59;
            this._HRPAge60to69 += _HRPAge60to69;
            this._HRPAge70to79 += _HRPAge70to79;
            this._HRPAge80AndOver += _HRPAge80AndOver;
            this._CEPAge0AndOver += _CEPAge0AndOver;
            this._CEPAge0 += _CEPAge0;
            this._CEPAge1 += _CEPAge1;
            this._CEPAge2 += _CEPAge2;
            this._CEPAge3 += _CEPAge3;
            this._CEPAge4 += _CEPAge4;
            this._CEPAge5 += _CEPAge5;
            this._CEPAge6 += _CEPAge6;
            this._CEPAge7 += _CEPAge7;
            this._CEPAge8 += _CEPAge8;
            this._CEPAge9 += _CEPAge9;
            this._CEPAge10 += _CEPAge10;
            this._CEPAge11 += _CEPAge11;
            this._CEPAge12 += _CEPAge12;
            this._CEPAge13 += _CEPAge13;
            this._CEPAge14 += _CEPAge14;
            this._CEPAge15 += _CEPAge15;
            this._CEPAge16to19 += _CEPAge16to19;
            this._CEPAge20to24 += _CEPAge20to24;
            this._CEPAge25to29 += _CEPAge25to29;
            this._CEPAge30to44 += _CEPAge30to44;
            this._CEPAge45to59 += _CEPAge45to59;
            this._CEPAge60to64 += _CEPAge60to64;
            this._CEPAge65to69 += _CEPAge65to69;
            this._CEPAge70to74 += _CEPAge70to74;
            this._CEPAge75to79 += _CEPAge75to79;
            this._CEPAge80to84 += _CEPAge80to84;
            this._CEPAge85to89 += _CEPAge85to89;
            this._CEPAge90AndOver += _CEPAge90AndOver;
        }
    }


}