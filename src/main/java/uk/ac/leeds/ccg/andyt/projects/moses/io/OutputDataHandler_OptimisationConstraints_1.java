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
 * Class for handling output that compares some optimisation constraint
 * variables in the CAS and IndividualCensus outputs.
 * (For IPS and GA run comparisons.)
 */
public class OutputDataHandler_OptimisationConstraints_1 extends AbstractOutputDataHandler {

    public OutputDataHandler_OptimisationConstraints_1() {
    }

    /**
     * @param args
     *            the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        new OutputDataHandler_OptimisationConstraints_1().run();
    }

    public void run() throws IOException {
    }

    /**
     * Writes out header.
     * @throws java.io.IOException
     */
    public void writeHeader() throws IOException {
        String header = "_ZoneCode," + "_PeopleWhoseGeneralHealthWasGood,_PeopleWhoseGeneralHealthWasFairlyGood,_PeopleWhoseGeneralHealthWasNotGood," + "_Ethnicity_White,_Ethnicity_Asian,_Ethnicity_Black,_EthnicityOther," + "_HRP_NSSEC_HigherManagerialAndProfessionalOccupations," + "_HRP_NSSEC_LowerManagerialAndProfessionalOccupations," + "_HRP_NSSEC_IntermediateOccupations," + "_HRP_NSSEC_SmallEmployersAndOwnAccountWorkers," + "_HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations," + "_HRP_NSSEC_SemiRoutineOccupations," + "_HRP_NSSEC_RoutineOccupations," + "_HRP_NSSEC_NeverWorkedOrLongTermUnemployed";
        System.out.println(header);
        this._FileOutputStream.write(header.getBytes());
        this._FileOutputStream.write(StreamTokenizer.TT_EOL);
        this._FileOutputStream.flush();
    }

    @Override
    public void writeObserved(
            String _CASDataDirectory,
            String _OutputFileName,
            long _StartRecordID,
            long _EndRecordID,
            String _AreaLevel,
            Census_ISARDataHandler tISARDataHandler)
            throws IOException {
//        this._OutputFile = new File(_OutputFileName);
//        this._OutputFile.getParentFile().mkdir();
//        // this._OutputFile = new File(
//        // "C:/Work/Projects/MoSeS/Workspace/Leeds/MarkOutputConstraintsOA.csv"
//        // );
//        _FileOutputStream = new FileOutputStream(_OutputFile);
//        this._CASDataHandler_1 = new CASDataHandler_GA_IPS(new File(
//                _CASDataDirectory), _AreaLevel);
//        // this._CASDataHandler = new Census_CASDataHandler( new File(
//        // _CASDataDirectory ), "" );
//        // this._CASDataHandler = new Census_CASDataHandler( new File(
//        // "C:/Work/Projects/MoSeS/Workspace/" ), "" );
//        writeHeader();
//        CASDataRecord_1 _CASDataRecord_1;
//        CAS003DataRecord _CAS003DataRecord;
//        CAS001DataRecord _CAS001DataRecord;
//        Counts _Counts = new Counts();
//        HashMap _CAS003AgeCountConstraintHashMap;
//        HashMap _CAS001AgeCountHPConstraintHashMap;
//        HashMap _CAS001AgeCountCEPConstraintHashMap;
//
//        //GA_IPS_GeneticAlgorithm_HSARHP_ISARCEP _GeneticAlgorithm_SWR_HSARHP_ISARCEP_1;
//        Object[] _FitnessCountsHSARHP;
//        HashMap _CASCounts;
//
//        for (long RecordID = _StartRecordID; RecordID <= _EndRecordID; RecordID++) {
//            _CASDataRecord_1 = (CASDataRecord_1) this._CASDataHandler_1.getDataRecord(RecordID);
//            _GeneticAlgorithm_SWR_HSARHP_ISARCEP_1 = new GA_IPS_GeneticAlgorithm_HSARHP_ISARCEP(
//                    _CASDataRecord_1);
//            _FitnessCountsHSARHP = _GeneticAlgorithm_SWR_HSARHP_ISARCEP_1.getFitnessCounts();
//            _CASCounts = (HashMap) _FitnessCountsHSARHP[0];
//            // Health
//            _Counts._PeopleWhoseGeneralHealthWasGood = (Integer) _CASCounts.get("_PeopleWhoseGeneralHealthWasGood");
//            _Counts._PeopleWhoseGeneralHealthWasFairlyGood = (Integer) _CASCounts.get("_PeopleWhoseGeneralHealthWasFairlyGood");
//            _Counts._PeopleWhoseGeneralHealthWasNotGood = (Integer) _CASCounts.get("_PeopleWhoseGeneralHealthWasNotGood");
//            // Ethnicity
//            _Counts._EthnicityWhite = (Integer) _CASCounts.get("_White");
//            _Counts._EthnicityAsian = (Integer) _CASCounts.get("_Asian");
//            _Counts._EthnicityBlack = (Integer) _CASCounts.get("_Black");
//            _Counts._EthnicityOther = (Integer) _CASCounts.get("_Other");
//            // HRP NSSEC
//            _Counts._HRP_NSSEC_HigherManagerialAndProfessionalOccupations = (Integer) _CASCounts.get("_HRP_HigherManagerialAndProfessionalOccupations");
//            _Counts._HRP_NSSEC_LowerManagerialAndProfessionalOccupations = (Integer) _CASCounts.get("_HRP_LowerManagerialAndProfessionalOccupations");
//            _Counts._HRP_NSSEC_IntermediateOccupations = (Integer) _CASCounts.get("_HRP_IntermediateOccupations");
//            _Counts._HRP_NSSEC_SmallEmployersAndOwnAccountWorkers = (Integer) _CASCounts.get("_HRP_SmallEmployersAndOwnAccountWorkers");
//            _Counts._HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations = (Integer) _CASCounts.get("_HRP_LowerSupervisoryAndTechnicalOccupations");
//            _Counts._HRP_NSSEC_SemiRoutineOccupations = (Integer) _CASCounts.get("_HRP_SemiRoutineOccupations");
//            _Counts._HRP_NSSEC_RoutineOccupations = (Integer) _CASCounts.get("_HRP_RoutineOccupations");
//            _Counts._HRP_NSSEC_NeverWorkedOrLongTermUnemployed = (Integer) _CASCounts.get("_HRP_NeverWorkedOrLongTermUnemployed");
//            write(_Counts, String.valueOf(_CASDataRecord_1.getZone_Code()));
//        }
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
    public void writeEstimated_HSARHP(String directory, String filenamePrefix,
            String filenameSuffix, String _Aggregation) throws IOException {
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
    public void writeEstimated_HSARHP(File _InputFile, File _OutputFile,
            String _Aggregation) throws IOException {
        ToyModelDataHandler tToyModelDataHandler = new ToyModelDataHandler();
        _OutputFile.getParentFile().mkdirs();
        this._FileOutputStream = new FileOutputStream(_OutputFile);
        writeHeader();
        Census_CASDataRecord _CASDataRecord;
        int _PeopleWhoseGeneralHealthWasGood;
        int _PeopleWhoseGeneralHealthWasFairlyGood;
        int _PeopleWhoseGeneralHealthWasNotGood;
        int _EthnicityWhite;
        int _EthnicityAsian;
        int _EthnicityBlack;
        int _EthnicityOther;
        int _HRP_NSSEC_HigherManagerialAndProfessionalOccupations;
        int _HRP_NSSEC_LowerManagerialAndProfessionalOccupations;
        int _HRP_NSSEC_IntermediateOccupations;
        int _HRP_NSSEC_SmallEmployersAndOwnAccountWorkers;
        int _HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations;
        int _HRP_NSSEC_SemiRoutineOccupations;
        int _HRP_NSSEC_RoutineOccupations;
        int _HRP_NSSEC_NeverWorkedOrLongTermUnemployed;
        Census_HSARDataHandler tHSARDataHandler = new Census_HSARDataHandler(
                new File("C:/Work/Projects/MoSeS/Workspace/",
                "uk.ac.leeds.ccg.andyt.projects.moses.io.HSARDataHandler.thisFile"));
        Census_ISARDataHandler tISARDataHandler = new Census_ISARDataHandler(
                new File("C:/Work/Projects/MoSeS/Workspace/",
                "uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataHandler_AGE0Indexed.thisFile"));
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
        short _ISARDataRecordETHEW;
        short _ISARDataRecordETHN;
        short _ISARDataRecordETHS;
        short _HEALTH;
        Counts _Counts;
        TreeMap result = new TreeMap();
        while (tokenType != StreamTokenizer.TT_EOF) {
            switch (tokenType) {
                case StreamTokenizer.TT_WORD:
                    _PeopleWhoseGeneralHealthWasGood = 0;
                    _PeopleWhoseGeneralHealthWasFairlyGood = 0;
                    _PeopleWhoseGeneralHealthWasNotGood = 0;
                    _EthnicityWhite = 0;
                    _EthnicityAsian = 0;
                    _EthnicityBlack = 0;
                    _EthnicityOther = 0;
                    _HRP_NSSEC_HigherManagerialAndProfessionalOccupations = 0;
                    _HRP_NSSEC_LowerManagerialAndProfessionalOccupations = 0;
                    _HRP_NSSEC_IntermediateOccupations = 0;
                    _HRP_NSSEC_SmallEmployersAndOwnAccountWorkers = 0;
                    _HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations = 0;
                    _HRP_NSSEC_SemiRoutineOccupations = 0;
                    _HRP_NSSEC_RoutineOccupations = 0;
                    _HRP_NSSEC_NeverWorkedOrLongTermUnemployed = 0;
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
                            short _HSARDataRecordNSSEC = _HSARDataRecord.get_NSSEC();
                            if (_HSARDataRecordNSSEC > 0 && _HSARDataRecordNSSEC < 7) {
                                _HRP_NSSEC_HigherManagerialAndProfessionalOccupations = 1;
                            }
                            if (_HSARDataRecordNSSEC > 6 && _HSARDataRecordNSSEC < 13) {
                                _HRP_NSSEC_LowerManagerialAndProfessionalOccupations = 1;
                            }
                            if (_HSARDataRecordNSSEC > 12 && _HSARDataRecordNSSEC < 17) {
                                _HRP_NSSEC_IntermediateOccupations = 1;
                            }
                            if (_HSARDataRecordNSSEC > 16 && _HSARDataRecordNSSEC < 21) {
                                _HRP_NSSEC_SmallEmployersAndOwnAccountWorkers = 1;
                            }
                            if (_HSARDataRecordNSSEC > 20 && _HSARDataRecordNSSEC < 24) {
                                _HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations = 1;
                            }
                            if (_HSARDataRecordNSSEC > 23 && _HSARDataRecordNSSEC < 31) {
                                _HRP_NSSEC_SemiRoutineOccupations = 1;
                            }
                            if (_HSARDataRecordNSSEC > 30 && _HSARDataRecordNSSEC < 36) {
                                _HRP_NSSEC_RoutineOccupations = 1;
                            }
                            if (_HSARDataRecordNSSEC > 35 && _HSARDataRecordNSSEC < 38) {
                                _HRP_NSSEC_NeverWorkedOrLongTermUnemployed = 1;
                            }
                        }
                        _HSARDataRecordETHEW = _HSARDataRecord.get_ETHEW();
                        if (_HSARDataRecordETHEW < 4) {
                            _EthnicityWhite = 1;
                        } else {
                            if (_HSARDataRecordETHEW == 6 || _HSARDataRecordETHEW == 8 || _HSARDataRecordETHEW == 9 || _HSARDataRecordETHEW == 10 || _HSARDataRecordETHEW == 11) {
                                _EthnicityAsian = 1;
                            } else {
                                if (_HSARDataRecordETHEW == 4 || _HSARDataRecordETHEW == 5 || _HSARDataRecordETHEW == 12 || _HSARDataRecordETHEW == 13 || _HSARDataRecordETHEW == 14) {
                                    _EthnicityBlack = 1;
                                } else {
                                    _EthnicityOther = 1;
                                }
                            }
                        }
                        _HEALTH = _HSARDataRecord.get_HEALTH();
                    } else {
                        _ISARDataRecord = (Census_ISARDataRecord) tISARDataHandler.getDataRecord(aToyModelDataRecord2.tISARDataRecordID);
                        _ISARDataRecordETHEW = _ISARDataRecord.get_ETHEW();
                        _ISARDataRecordETHS = _ISARDataRecord.get_ETHS();
                        _ISARDataRecordETHN = _ISARDataRecord.get_ETHN();
                        if (_ISARDataRecordETHEW == -9) {
                            if (_ISARDataRecordETHN == -9) {
                                if (_ISARDataRecordETHS < 5) {
                                    _EthnicityWhite = 1;
                                } else {
                                    if (_ISARDataRecordETHS == 6 || _ISARDataRecordETHS == 7 || _ISARDataRecordETHS == 8 || _ISARDataRecordETHS == 9) {
                                        _EthnicityAsian = 1;
                                    } else {
                                        if (_ISARDataRecordETHS == 10 || _ISARDataRecordETHS == 11 || _ISARDataRecordETHS == 12) {
                                            _EthnicityBlack = 1;
                                        } else {
                                            _EthnicityOther = 1;
                                        }
                                    }
                                }
                            } else {
                                if (_ISARDataRecordETHN == 1) {
                                    _EthnicityWhite = 1;
                                } else {
                                    _EthnicityOther = 1; // This could bias things
                                // adversely a
                                // probabilitic
                                // assignment is
                                // probably better,
                                // hopefully this is a
                                // minor detail
                                }
                            }
                        } else {
                            if (_ISARDataRecordETHEW < 4) {
                                _EthnicityWhite = 1;
                            } else {
                                if (_ISARDataRecordETHEW == 6 || _ISARDataRecordETHEW == 8 || _ISARDataRecordETHEW == 9 || _ISARDataRecordETHEW == 10 || _ISARDataRecordETHEW == 11) {
                                    _EthnicityAsian = 1;
                                } else {
                                    if (_ISARDataRecordETHEW == 4 || _ISARDataRecordETHEW == 5 || _ISARDataRecordETHEW == 12 || _ISARDataRecordETHEW == 13 || _ISARDataRecordETHEW == 14) {
                                        _EthnicityBlack = 1;
                                    } else {
                                        _EthnicityOther = 1;
                                    }
                                }
                            }
                        }
                        _HEALTH = _ISARDataRecord.get_HEALTH();
                    }
                    if (_HEALTH == (short) 1) {
                        _PeopleWhoseGeneralHealthWasGood = 1;
                    }
                    if (_HEALTH == (short) 2) {
                        _PeopleWhoseGeneralHealthWasFairlyGood = 1;
                    }
                    if (_HEALTH == (short) 3) {
                        _PeopleWhoseGeneralHealthWasNotGood = 1;
                    }
                    if (result.containsKey(aZoneCode)) {
                        _Counts = (Counts) result.get(aZoneCode);
                        result.remove(aZoneCode);
                        _Counts.addToCounts(
                                _PeopleWhoseGeneralHealthWasGood,
                                _PeopleWhoseGeneralHealthWasFairlyGood,
                                _PeopleWhoseGeneralHealthWasNotGood,
                                _EthnicityWhite,
                                _EthnicityAsian,
                                _EthnicityBlack,
                                _EthnicityOther,
                                _HRP_NSSEC_HigherManagerialAndProfessionalOccupations,
                                _HRP_NSSEC_LowerManagerialAndProfessionalOccupations,
                                _HRP_NSSEC_IntermediateOccupations,
                                _HRP_NSSEC_SmallEmployersAndOwnAccountWorkers,
                                _HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations,
                                _HRP_NSSEC_SemiRoutineOccupations,
                                _HRP_NSSEC_RoutineOccupations,
                                _HRP_NSSEC_NeverWorkedOrLongTermUnemployed);
                        result.put(aZoneCode, _Counts);
                    } else {
                        _Counts = new Counts();
                        _Counts.addToCounts(
                                _PeopleWhoseGeneralHealthWasGood,
                                _PeopleWhoseGeneralHealthWasFairlyGood,
                                _PeopleWhoseGeneralHealthWasNotGood,
                                _EthnicityWhite,
                                _EthnicityAsian,
                                _EthnicityBlack,
                                _EthnicityOther,
                                _HRP_NSSEC_HigherManagerialAndProfessionalOccupations,
                                _HRP_NSSEC_LowerManagerialAndProfessionalOccupations,
                                _HRP_NSSEC_IntermediateOccupations,
                                _HRP_NSSEC_SmallEmployersAndOwnAccountWorkers,
                                _HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations,
                                _HRP_NSSEC_SemiRoutineOccupations,
                                _HRP_NSSEC_RoutineOccupations,
                                _HRP_NSSEC_NeverWorkedOrLongTermUnemployed);
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
        String record = _ZoneCode + "," + _Counts._PeopleWhoseGeneralHealthWasGood + "," + _Counts._PeopleWhoseGeneralHealthWasFairlyGood + "," + _Counts._PeopleWhoseGeneralHealthWasNotGood + "," + _Counts._EthnicityWhite + "," + _Counts._EthnicityAsian + "," + _Counts._EthnicityBlack + "," + _Counts._EthnicityOther + "," + _Counts._EthnicityOther + "," + _Counts._HRP_NSSEC_HigherManagerialAndProfessionalOccupations + "," + _Counts._HRP_NSSEC_LowerManagerialAndProfessionalOccupations + "," + _Counts._HRP_NSSEC_IntermediateOccupations + "," + _Counts._HRP_NSSEC_SmallEmployersAndOwnAccountWorkers + "," + _Counts._HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations + "," + _Counts._HRP_NSSEC_SemiRoutineOccupations + "," + _Counts._HRP_NSSEC_RoutineOccupations + "," + _Counts._HRP_NSSEC_NeverWorkedOrLongTermUnemployed;
        System.out.println(record);
        this._FileOutputStream.write(record.getBytes());
        this._FileOutputStream.write(StreamTokenizer.TT_EOL);
        this._FileOutputStream.flush();
    }

    public class Counts {

        int _PeopleWhoseGeneralHealthWasGood;
        int _PeopleWhoseGeneralHealthWasFairlyGood;
        int _PeopleWhoseGeneralHealthWasNotGood;
        int _EthnicityWhite;
        int _EthnicityAsian;
        int _EthnicityBlack;
        int _EthnicityOther;
        int _HRP_NSSEC_HigherManagerialAndProfessionalOccupations;
        int _HRP_NSSEC_LowerManagerialAndProfessionalOccupations;
        int _HRP_NSSEC_IntermediateOccupations;
        int _HRP_NSSEC_SmallEmployersAndOwnAccountWorkers;
        int _HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations;
        int _HRP_NSSEC_SemiRoutineOccupations;
        int _HRP_NSSEC_RoutineOccupations;
        int _HRP_NSSEC_NeverWorkedOrLongTermUnemployed;

        public Counts() {
            _PeopleWhoseGeneralHealthWasGood = 0;
            _PeopleWhoseGeneralHealthWasFairlyGood = 0;
            _PeopleWhoseGeneralHealthWasNotGood = 0;
            _EthnicityWhite = 0;
            _EthnicityAsian = 0;
            _EthnicityBlack = 0;
            _EthnicityOther = 0;
            _HRP_NSSEC_HigherManagerialAndProfessionalOccupations = 0;
            _HRP_NSSEC_LowerManagerialAndProfessionalOccupations = 0;
            _HRP_NSSEC_IntermediateOccupations = 0;
            _HRP_NSSEC_SmallEmployersAndOwnAccountWorkers = 0;
            _HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations = 0;
            _HRP_NSSEC_SemiRoutineOccupations = 0;
            _HRP_NSSEC_RoutineOccupations = 0;
            _HRP_NSSEC_NeverWorkedOrLongTermUnemployed = 0;
        }

        public void addToCounts(int _PeopleWhoseGeneralHealthWasGood,
                int _PeopleWhoseGeneralHealthWasFairlyGood,
                int _PeopleWhoseGeneralHealthWasNotGood, int _EthnicityWhite,
                int _EthnicityAsian, int _EthnicityBlack, int _EthnicityOther,
                int _HRP_NSSEC_HigherManagerialAndProfessionalOccupations,
                int _HRP_NSSEC_LowerManagerialAndProfessionalOccupations,
                int _HRP_NSSEC_IntermediateOccupations,
                int _HRP_NSSEC_SmallEmployersAndOwnAccountWorkers,
                int _HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations,
                int _HRP_NSSEC_SemiRoutineOccupations,
                int _HRP_NSSEC_RoutineOccupations,
                int _HRP_NSSEC_NeverWorkedOrLongTermUnemployed) {
            this._PeopleWhoseGeneralHealthWasGood += _PeopleWhoseGeneralHealthWasGood;
            this._PeopleWhoseGeneralHealthWasFairlyGood += _PeopleWhoseGeneralHealthWasFairlyGood;
            this._PeopleWhoseGeneralHealthWasNotGood += _PeopleWhoseGeneralHealthWasNotGood;
            this._HRP_NSSEC_HigherManagerialAndProfessionalOccupations += _HRP_NSSEC_HigherManagerialAndProfessionalOccupations;
            this._HRP_NSSEC_LowerManagerialAndProfessionalOccupations += _HRP_NSSEC_LowerManagerialAndProfessionalOccupations;
            this._HRP_NSSEC_IntermediateOccupations += _HRP_NSSEC_SmallEmployersAndOwnAccountWorkers;
            this._HRP_NSSEC_SmallEmployersAndOwnAccountWorkers += _HRP_NSSEC_SmallEmployersAndOwnAccountWorkers;
            this._HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations += _HRP_NSSEC_LowerSupervisoryAndTechnicalOccupations;
            this._HRP_NSSEC_SemiRoutineOccupations += _HRP_NSSEC_SemiRoutineOccupations;
            this._HRP_NSSEC_RoutineOccupations += _HRP_NSSEC_RoutineOccupations;
            this._HRP_NSSEC_NeverWorkedOrLongTermUnemployed += _HRP_NSSEC_NeverWorkedOrLongTermUnemployed;
            this._EthnicityWhite += _EthnicityWhite;
            this._EthnicityAsian += _EthnicityAsian;
            this._EthnicityBlack += _EthnicityBlack;
            this._EthnicityOther += _EthnicityOther;

        }
    }
}