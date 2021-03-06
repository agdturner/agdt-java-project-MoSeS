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
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;
import uk.ac.leeds.ccg.andyt.projects.moses.process.GeneticAlgorithm_HSARHP_ISARCEP;
import uk.ac.leeds.ccg.andyt.projects.moses.process.GeneticAlgorithm_ISARHP_ISARCEP;

/**
 * Class for handling output that compares some optimisation constraint
 * variables in the CAS and IndividualCensus outputs.
 */
//public class OutputDataHandler_OptimisationConstraints extends AbstractOutputDataHandler {
public class OutputDataHandler_OptimisationConstraints {

    Census_CASDataHandler _CASDataHandler;

    public OutputDataHandler_OptimisationConstraints(
            Census_CASDataHandler a_CASDataHandler) {
        this._CASDataHandler = a_CASDataHandler;
    }

    /**
     * @param args
     *            the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        new OutputDataHandler_ControlConstraints().run();
    }

    public void run() throws IOException {
    }

    /**
     * Writes out header using this._FileOutputStream.
     * @throws java.io.IOException
     */
    public void writeHeader() throws IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Writes out header.
     * @param a_FileOutputStream
     * @throws java.io.IOException
     */
    public static void writeISARHP_ISARCEPHeader(
            FileOutputStream a_FileOutputStream)
            throws IOException {
        String header = getISARHP_ISARCEPHeader();
        System.out.println(header);
        a_FileOutputStream.write(header.getBytes());
        a_FileOutputStream.write(StreamTokenizer.TT_EOL);
        a_FileOutputStream.flush();
    }

    public static String getISARHP_ISARCEPHeader() {
        String header = "ZoneCode,";
        Vector<String> variableList = GeneticAlgorithm_ISARHP_ISARCEP.getVariableList();
        for (int i = 0; i < variableList.size() - 1; i++) {
            header += variableList.elementAt(i) + ",";
        }
        header += variableList.elementAt(variableList.size() - 1);
        return header;
    }

    /**
     * Writes out header.
     * @param a_FileOutputStream
     * @throws java.io.IOException
     */
    public static void writeHSARHP_ISARCEPHeader(
            FileOutputStream a_FileOutputStream)
            throws IOException {
        String header = getHSARHP_ISARCEPHeader();
        System.out.println(header);
        a_FileOutputStream.write(header.getBytes());
        a_FileOutputStream.write(StreamTokenizer.TT_EOL);
        a_FileOutputStream.flush();
    }

    /**
     * Writes out header.
     * @return 
     */
    public static String getHSARHP_ISARCEPHeader() {
        String header = "ZoneCode,";
        Vector<String> variableList = GeneticAlgorithm_HSARHP_ISARCEP.getVariableList();
        for (int i = 0; i < variableList.size() - 1; i++) {
            header += variableList.elementAt(i) + ",";
        }
        header += variableList.elementAt(variableList.size() - 1);
        return header;
    }

//    /**
//     * Writes out header using this._FileOutputStream.
//     */
//    public static String getHeader() {
//        return "ZoneCode,"
//                + "PeopleWhoseGeneralHealthWasGood,"
//                + "PeopleWhoseGeneralHealthWasFairlyGood,"
//                + "PeopleWhoseGeneralHealthWasNotGood,"
//                + "PeopleWithLimitingLongTermIllness,"
//                + "LoneParentHouseholdsWithChildren,"
//                + "OneFamilyAndNoChildren,"
//                + "MarriedOrCohabitingCoupleWithChildren,"
//                + "FemalesAge0to4,"
//                + "FemalesAge5to9,"
//                + "FemalesAge10to14,"
//                + "FemalesAge15to19,"
//                + "FemalesAge20to24,"
//                + "FemalesAge25to29,"
//                + "FemalesAge30to34,"
//                + "FemalesAge35to39,"
//                + "FemalesAge40to44,"
//                + "FemalesAge45to49,"
//                + "FemalesAge50to54,"
//                + "FemalesAge55to59,"
//                + "FemalesAge60to64,"
//                + "FemalesAge65to69,"
//                + "FemalesAge70to74,"
//                + "FemalesAge75to79,"
//                + "FemalesAge80AndOver,"
//                + "FemalesMarriedAge0to15,"
//                + "FemalesMarriedAge16to19,"
//                + "FemalesMarriedAge20to24,"
//                + "FemalesMarriedAge25to29,"
//                + "FemalesMarriedAge30to34,"
//                + "FemalesMarriedAge35to39,"
//                + "FemalesMarriedAge40to44,"
//                + "FemalesMarriedAge45to49,"
//                + "FemalesMarriedAge50to54,"
//                + "FemalesMarriedAge55to59,"
//                + "FemalesMarriedAge60to64,"
//                + "FemalesMarriedAge65to74,"
//                + "FemalesMarriedAge75to79,"
//                + "FemalesMarriedAge80AndOver,"
//                + "FemalesAge16to24Unemployed,"
//                + "FemalesAge16to74,"
//                + "FemalesAge16to74EconomicallyActiveEmployed,"
//                + "FemalesAge16to74EconomicallyActiveUnemployed,"
//                //+ "FemalesAge16to74EconomicallyInactive,"
//                + "FemalesAge50AndOverUnemployed,"
//                + "MalesAge0to4,"
//                + "MalesAge5to9,"
//                + "MalesAge10to14,"
//                + "MalesAge15to19,"
//                + "MalesAge20to24,"
//                + "MalesAge25to29,"
//                + "MalesAge30to34,"
//                + "MalesAge35to39,"
//                + "MalesAge40to44,"
//                + "MalesAge45to49,"
//                + "MalesAge50to54,"
//                + "MalesAge55to59,"
//                + "MalesAge60to64,"
//                + "MalesAge65to69,"
//                + "MalesAge70to74,"
//                + "MalesAge75to79,"
//                + "MalesAge80AndOver,"
//                + "MalesMarriedAge0to15,"
//                + "MalesMarriedAge16to19,"
//                + "MalesMarriedAge20to24,"
//                + "MalesMarriedAge25to29,"
//                + "MalesMarriedAge30to34,"
//                + "MalesMarriedAge35to39,"
//                + "MalesMarriedAge40to44,"
//                + "MalesMarriedAge45to49,"
//                + "MalesMarriedAge50to54,"
//                + "MalesMarriedAge55to59,"
//                + "MalesMarriedAge60to64,"
//                + "MalesMarriedAge65to74,"
//                + "MalesMarriedAge75to79,"
//                + "MalesMarriedAge80AndOver,"
//                + "MalesAge16to24Unemployed,"
//                + "MalesAge16to74,"
//                + "MalesAge16to74EconomicallyActiveEmployed,"
//                + "MalesAge16to74EconomicallyActiveUnemployed,"
//                //+ "MalesAge16to74EconomicallyInactive,"
//                + "MalesAge50AndOverUnemployed";
//    }
//    public void writeObserved(
//            Census_CASDataHandler a_CASDataHandler,
//            String _OutputFileName)
//            throws IOException {
//        long _StartRecordID = 0;
//        this._CASDataHandler = a_CASDataHandler;
//        long _EndRecordID = this._CASDataHandler.getNDataRecords();
//        String _AreaLevel = "OA";
//        writeObservedISARHP_ISARCEP(
//                _OutputFileName,
//                _StartRecordID,
//                _EndRecordID,
//                _AreaLevel,
//                null);
//    }
//
//    @Override
//    public void writeObserved(
//            String _CASDataDirectory,
//            String _OutputFileName,
//            long _StartRecordID,
//            long _EndRecordID,
//            String _AreaLevel,
//            Census_ISARDataHandler tISARDataHandler)
//            throws IOException {
//        this._CASDataHandler = new Census_CASDataHandler(
//                new File(_CASDataDirectory),
//                "");
//        writeObservedISARHP_ISARCEP(
//                _OutputFileName,
//                _StartRecordID,
//                _EndRecordID,
//                _AreaLevel,
//                tISARDataHandler);
//
//    }

    public void writeObservedISARHP_ISARCEP(
            String a_OutputFileName,
            Census_CASDataHandler a_CASDataHandler,
            Census_ISARDataHandler tISARDataHandler)
            throws IOException {
        File outputFile = new File(a_OutputFileName);
        outputFile.getParentFile().mkdir();
        FileOutputStream a_FileOutputStream = new FileOutputStream(outputFile);
        writeHSARHP_ISARCEPHeader(a_FileOutputStream);
        TreeSet oa_Codes = a_CASDataHandler.getOACodes_TreeSet();
        Census_CASDataRecord a_CASDataRecord;
        GeneticAlgorithm_ISARHP_ISARCEP a_GeneticAlgorithm_ISARHP_ISARCEP;
        Object[] a_FitnessCountsISARHP_ISARCEP;
        HashMap<String, Integer> a_CASCounts;
        String oa_Code;
        Iterator iterator = oa_Codes.iterator();
        while (iterator.hasNext()){
            oa_Code = (String) iterator.next();
            a_CASDataRecord = (Census_CASDataRecord) a_CASDataHandler.getDataRecord(oa_Code);
            a_GeneticAlgorithm_ISARHP_ISARCEP = new GeneticAlgorithm_ISARHP_ISARCEP(
                    a_CASDataRecord);
            a_FitnessCountsISARHP_ISARCEP = a_GeneticAlgorithm_ISARHP_ISARCEP.getFitnessCounts();
            a_CASCounts = (HashMap<String, Integer>) a_FitnessCountsISARHP_ISARCEP[0];
            writeISARHP_ISARCEP(a_CASCounts, oa_Code, a_FileOutputStream);
        }
        a_FileOutputStream.close();
    }

    public void writeObservedHSARHP_ISARCEP(
            String a_OutputFileName,
            Census_CASDataHandler a_CASDataHandler,
            Census_ISARDataHandler tISARDataHandler)
            throws IOException {
        File outputFile = new File(a_OutputFileName);
        outputFile.getParentFile().mkdir();
        FileOutputStream a_FileOutputStream = new FileOutputStream(outputFile);
        writeHSARHP_ISARCEPHeader(a_FileOutputStream);
        TreeSet oa_Codes = a_CASDataHandler.getOACodes_TreeSet();
        Census_CASDataRecord a_CASDataRecord;
        GeneticAlgorithm_HSARHP_ISARCEP a_GeneticAlgorithm_HSARHP_ISARCEP;
        Object[] a_FitnessCountsHSARHP_ISARCEP;
        HashMap<String, Integer> a_CASCounts;
        String oa_Code;
        Iterator iterator = oa_Codes.iterator();
        while (iterator.hasNext()){
            oa_Code = (String) iterator.next();
            a_CASDataRecord = (Census_CASDataRecord) a_CASDataHandler.getDataRecord(oa_Code);
            a_GeneticAlgorithm_HSARHP_ISARCEP = new GeneticAlgorithm_HSARHP_ISARCEP(
                    a_CASDataRecord);
            a_FitnessCountsHSARHP_ISARCEP = a_GeneticAlgorithm_HSARHP_ISARCEP.getFitnessCounts();
            a_CASCounts = (HashMap<String, Integer>) a_FitnessCountsHSARHP_ISARCEP[0];
            writeHSARHP_ISARCEP(a_CASCounts, oa_Code, a_FileOutputStream);
        }
        a_FileOutputStream.close();
    }

//    /**
//     * writeEstimated_HSARHP
//     *
//     * @param _Aggregation
//     *            OA, MSOA, Ward
//     */
//    public void writeEstimated_HSARHP(
//            String directory,
//            String filenamePrefix,
//            String filenameSuffix,
//            String _Aggregation)
//            throws IOException {
//        this._OutputFile =
//                new File(directory + filenamePrefix + filenameSuffix);
//        this._OutputFile.createNewFile();
//        File _InputFile = new File(directory + filenamePrefix + ".csv");
//        writeEstimated_HSARHP(_InputFile, _OutputFile, _Aggregation);
//    }
//
//    /**
//     * writeEstimated_HSARHP
//     */
//    public void writeEstimated_HSARHP(
//            File _InputFile,
//            File _OutputFile,
//            String _Aggregation)
//            throws IOException {
//        ToyModelDataHandler tToyModelDataHandler = new ToyModelDataHandler();
//        _OutputFile.getParentFile().mkdirs();
//        this._FileOutputStream = new FileOutputStream(_OutputFile);
//        writeHeader();
//        Census_CASDataRecord _CASDataRecord;
//        int _PeopleWhoseGeneralHealthWasGood;
//        int _PeopleWhoseGeneralHealthWasFairlyGood;
//        int _PeopleWhoseGeneralHealthWasNotGood;
//        int _PeopleWithLimitingLongTermIllness;
//        int _LoneParentHouseholdsWithChildren;
//        int _OneFamilyAndNoChildren;
//        int _MarriedOrCohabitingCoupleWithChildren;
//        int _FemalesAge0to4;
//        int _FemalesAge5to9;
//        int _FemalesAge10to14;
//        int _FemalesAge15to19;
//        int _FemalesAge20to24;
//        int _FemalesAge25to29;
//        int _FemalesAge30to34;
//        int _FemalesAge35to39;
//        int _FemalesAge40to44;
//        int _FemalesAge45to49;
//        int _FemalesAge50to54;
//        int _FemalesAge55to59;
//        int _FemalesAge60to64;
//        int _FemalesAge65to69;
//        int _FemalesAge70to74;
//        int _FemalesAge75to79;
//        int _FemalesAge80AndOver;
//        int _FemalesMarriedAge0to15;
//        int _FemalesMarriedAge16to19;
//        int _FemalesMarriedAge20to24;
//        int _FemalesMarriedAge25to29;
//        int _FemalesMarriedAge30to34;
//        int _FemalesMarriedAge35to39;
//        int _FemalesMarriedAge40to44;
//        int _FemalesMarriedAge45to49;
//        int _FemalesMarriedAge50to54;
//        int _FemalesMarriedAge55to59;
//        int _FemalesMarriedAge60to64;
//        int _FemalesMarriedAge65to74;
//        int _FemalesMarriedAge75to79;
//        int _FemalesMarriedAge80AndOver;
//        int _FemalesAge16to24Unemployed;
//        int _FemalesAge16to74;
//        int _FemalesAge16to74EconomicallyActiveEmployed;
//        int _FemalesAge16to74EconomicallyActiveUnemployed;
//        int _FemalesAge16to74EconomicallyInactive;
//        int _FemalesAge50AndOverUnemployed;
//        int _MalesAge0to4;
//        int _MalesAge5to9;
//        int _MalesAge10to14;
//        int _MalesAge15to19;
//        int _MalesAge20to24;
//        int _MalesAge25to29;
//        int _MalesAge30to34;
//        int _MalesAge35to39;
//        int _MalesAge40to44;
//        int _MalesAge45to49;
//        int _MalesAge50to54;
//        int _MalesAge55to59;
//        int _MalesAge60to64;
//        int _MalesAge65to69;
//        int _MalesAge70to74;
//        int _MalesAge75to79;
//        int _MalesAge80AndOver;
//        int _MalesMarriedAge0to15;
//        int _MalesMarriedAge16to19;
//        int _MalesMarriedAge20to24;
//        int _MalesMarriedAge25to29;
//        int _MalesMarriedAge30to34;
//        int _MalesMarriedAge35to39;
//        int _MalesMarriedAge40to44;
//        int _MalesMarriedAge45to49;
//        int _MalesMarriedAge50to54;
//        int _MalesMarriedAge55to59;
//        int _MalesMarriedAge60to64;
//        int _MalesMarriedAge65to74;
//        int _MalesMarriedAge75to79;
//        int _MalesMarriedAge80AndOver;
//        int _MalesAge16to24Unemployed;
//        int _MalesAge16to74;
//        int _MalesAge16to74EconomicallyActiveEmployed;
//        int _MalesAge16to74EconomicallyActiveUnemployed;
//        int _MalesAge16to74EconomicallyInactive;
//        int _MalesAge50AndOverUnemployed;
//        HSARDataHandler tHSARDataHandler = new HSARDataHandler(
//                new File("C:/Work/Projects/MoSeS/Workspace/",
//                "uk.ac.leeds.ccg.andyt.projects.moses.io.HSARDataHandler.thisFile"));
//        Census_ISARDataHandler tISARDataHandler = new Census_ISARDataHandler(
//                new File("C:/Work/Projects/MoSeS/Workspace/",
//                "uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataHandler_AGE0Indexed.thisFile"));
//        HSARDataRecord _HSARDataRecord;
//        ISARDataRecord _ISARDataRecord;
//        BufferedReader tBufferedReader = new BufferedReader(
//                new InputStreamReader(new FileInputStream(_InputFile)));
//        StreamTokenizer tStreamTokenizer = new StreamTokenizer(tBufferedReader);
//        Generic_IO.setStreamTokenizerSyntax1(tStreamTokenizer);
//        int tokenType = tStreamTokenizer.nextToken();
//        ToyModelDataRecord_2 aToyModelDataRecord2;
//        String aZoneCode;
//        HashMap tLookUpMSOAfromOAHashMap = null;
//        Census_CASDataHandler tCASDataHandler = new Census_CASDataHandler();
//        if (_Aggregation.equalsIgnoreCase("MSOA")) {
//            tLookUpMSOAfromOAHashMap = tCASDataHandler.get_LookUpMSOAfromOAHashMap();
//        }
//        short _HSARDataRecordAGEH;
//        short _HSARDataRecordECONACH;
//        short _HSARDataRecordMARSTAH;
//        short _ISARDataRecordAGE0;
//        short _ISARDataRecordECONACT;
//        short _ISARDataRecordMARSTAT;
//        boolean _SEX;
//        short _HEALTH;
//        Counts _Counts;
//        TreeMap result = new TreeMap();
//        while (tokenType != StreamTokenizer.TT_EOF) {
//            switch (tokenType) {
//                case StreamTokenizer.TT_WORD:
//                    _PeopleWhoseGeneralHealthWasGood = 0;
//                    _PeopleWhoseGeneralHealthWasFairlyGood = 0;
//                    _PeopleWhoseGeneralHealthWasNotGood = 0;
//                    _PeopleWithLimitingLongTermIllness = 0;
//                    _LoneParentHouseholdsWithChildren = 0;
//                    _OneFamilyAndNoChildren = 0;
//                    _MarriedOrCohabitingCoupleWithChildren = 0;
//                    _FemalesAge0to4 = 0;
//                    _FemalesAge5to9 = 0;
//                    _FemalesAge10to14 = 0;
//                    _FemalesAge15to19 = 0;
//                    _FemalesAge20to24 = 0;
//                    _FemalesAge25to29 = 0;
//                    _FemalesAge30to34 = 0;
//                    _FemalesAge35to39 = 0;
//                    _FemalesAge40to44 = 0;
//                    _FemalesAge45to49 = 0;
//                    _FemalesAge50to54 = 0;
//                    _FemalesAge55to59 = 0;
//                    _FemalesAge60to64 = 0;
//                    _FemalesAge65to69 = 0;
//                    _FemalesAge70to74 = 0;
//                    _FemalesAge75to79 = 0;
//                    _FemalesAge80AndOver = 0;
//                    _FemalesMarriedAge0to15 = 0;
//                    _FemalesMarriedAge16to19 = 0;
//                    _FemalesMarriedAge20to24 = 0;
//                    _FemalesMarriedAge25to29 = 0;
//                    _FemalesMarriedAge30to34 = 0;
//                    _FemalesMarriedAge35to39 = 0;
//                    _FemalesMarriedAge40to44 = 0;
//                    _FemalesMarriedAge45to49 = 0;
//                    _FemalesMarriedAge50to54 = 0;
//                    _FemalesMarriedAge55to59 = 0;
//                    _FemalesMarriedAge60to64 = 0;
//                    _FemalesMarriedAge65to74 = 0;
//                    _FemalesMarriedAge75to79 = 0;
//                    _FemalesMarriedAge80AndOver = 0;
//                    _FemalesAge16to24Unemployed = 0;
//                    _FemalesAge16to74 = 0;
//                    _FemalesAge16to74EconomicallyActiveEmployed = 0;
//                    _FemalesAge16to74EconomicallyActiveUnemployed = 0;
//                    _FemalesAge16to74EconomicallyInactive = 0;
//                    _FemalesAge50AndOverUnemployed = 0;
//                    _MalesAge0to4 = 0;
//                    _MalesAge5to9 = 0;
//                    _MalesAge10to14 = 0;
//                    _MalesAge15to19 = 0;
//                    _MalesAge20to24 = 0;
//                    _MalesAge25to29 = 0;
//                    _MalesAge30to34 = 0;
//                    _MalesAge35to39 = 0;
//                    _MalesAge40to44 = 0;
//                    _MalesAge45to49 = 0;
//                    _MalesAge50to54 = 0;
//                    _MalesAge55to59 = 0;
//                    _MalesAge60to64 = 0;
//                    _MalesAge65to69 = 0;
//                    _MalesAge70to74 = 0;
//                    _MalesAge75to79 = 0;
//                    _MalesAge80AndOver = 0;
//                    _MalesMarriedAge0to15 = 0;
//                    _MalesMarriedAge16to19 = 0;
//                    _MalesMarriedAge20to24 = 0;
//                    _MalesMarriedAge25to29 = 0;
//                    _MalesMarriedAge30to34 = 0;
//                    _MalesMarriedAge35to39 = 0;
//                    _MalesMarriedAge40to44 = 0;
//                    _MalesMarriedAge45to49 = 0;
//                    _MalesMarriedAge50to54 = 0;
//                    _MalesMarriedAge55to59 = 0;
//                    _MalesMarriedAge60to64 = 0;
//                    _MalesMarriedAge65to74 = 0;
//                    _MalesMarriedAge75to79 = 0;
//                    _MalesMarriedAge80AndOver = 0;
//                    _MalesAge16to24Unemployed = 0;
//                    _MalesAge16to74 = 0;
//                    _MalesAge16to74EconomicallyActiveEmployed = 0;
//                    _MalesAge16to74EconomicallyActiveUnemployed = 0;
//                    _MalesAge16to74EconomicallyInactive = 0;
//                    _MalesAge50AndOverUnemployed = 0;
//                    aToyModelDataRecord2 = new ToyModelDataRecord_2(
//                            tToyModelDataHandler, tStreamTokenizer.sval);
//                    if (_Aggregation.equalsIgnoreCase("MSOA")) {
//                        aZoneCode = (String) tLookUpMSOAfromOAHashMap.get(
//                                new String(aToyModelDataRecord2.getZone_Code()));
//                    } else {
//                        aZoneCode = String.valueOf(aToyModelDataRecord2.getZone_Code());
//                        if (_Aggregation.equalsIgnoreCase("Ward")) {
//                            aZoneCode = aZoneCode.substring(0, 6);
//                        }
//                    }
//                    if (aToyModelDataRecord2.tHSARDataRecordID != -9) {
//                        _HSARDataRecord =
//                                (HSARDataRecord) tHSARDataHandler.getDataRecord(
//                                aToyModelDataRecord2.tHSARDataRecordID);
//                        _HSARDataRecordAGEH = _HSARDataRecord.get_AGEH();
//                        if (_HSARDataRecord.get_HRP()) {
//                            short _HSARDataRecordFAMTYPE =
//                                    _HSARDataRecord.get_FAMTYP();
//                            if (_HSARDataRecordFAMTYPE > 0
//                                    && _HSARDataRecordFAMTYPE < 3) {
//                                _LoneParentHouseholdsWithChildren = 1;
//                            }
//                            if (_HSARDataRecordFAMTYPE == (short) 3
//                                    || _HSARDataRecordFAMTYPE == (short) 6) {
//                                _OneFamilyAndNoChildren = 1;
//                            }
//                            if (_HSARDataRecordFAMTYPE == (short) 4
//                                    || _HSARDataRecordFAMTYPE == (short) 5
//                                    || _HSARDataRecordFAMTYPE == (short) 7
//                                    || _HSARDataRecordFAMTYPE == (short) 8) {
//                                _MarriedOrCohabitingCoupleWithChildren = 1;
//                            }
//                        }
//                        _SEX = _HSARDataRecord.get_SEX();
//                        _HSARDataRecordECONACH = _HSARDataRecord.get_ECONACH();
//                        _HSARDataRecordMARSTAH = _HSARDataRecord.get_MARSTAH();
//                        _HEALTH = _HSARDataRecord.get_HEALTH();
//                        if (_HSARDataRecord.get_LLTI() == (short) 1) {
//                            _PeopleWithLimitingLongTermIllness = 1;
//                        }
//                        if (_SEX) {
//                            // Male
//                            if (_HSARDataRecordAGEH < 5) {
//                                _MalesAge0to4 = 1;
//                            } else {
//                                if (_HSARDataRecordAGEH < 10) {
//                                    _MalesAge5to9 = 1;
//                                } else {
//                                    if (_HSARDataRecordAGEH < 15) {
//                                        _MalesAge10to14 = 1;
//                                    } else {
//                                        if (_HSARDataRecordAGEH < 20) {
//                                            _MalesAge15to19 = 1;
//                                        } else {
//                                            if (_HSARDataRecordAGEH < 25) {
//                                                _MalesAge20to24 = 1;
//                                            } else {
//                                                if (_HSARDataRecordAGEH < 30) {
//                                                    _MalesAge25to29 = 1;
//                                                } else {
//                                                    if (_HSARDataRecordAGEH < 35) {
//                                                        _MalesAge30to34 = 1;
//                                                    } else {
//                                                        if (_HSARDataRecordAGEH < 40) {
//                                                            _MalesAge35to39 = 1;
//                                                        } else {
//                                                            if (_HSARDataRecordAGEH < 45) {
//                                                                _MalesAge40to44 = 1;
//                                                            } else {
//                                                                if (_HSARDataRecordAGEH < 50) {
//                                                                    _MalesAge45to49 = 1;
//                                                                } else {
//                                                                    if (_HSARDataRecordAGEH < 55) {
//                                                                        _MalesAge50to54 = 1;
//                                                                    } else {
//                                                                        if (_HSARDataRecordAGEH < 60) {
//                                                                            _MalesAge55to59 = 1;
//                                                                        } else {
//                                                                            if (_HSARDataRecordAGEH < 65) {
//                                                                                _MalesAge60to64 = 1;
//                                                                            } else {
//                                                                                if (_HSARDataRecordAGEH < 70) {
//                                                                                    _MalesAge65to69 = 1;
//                                                                                } else {
//                                                                                    if (_HSARDataRecordAGEH < 75) {
//                                                                                        _MalesAge70to74 = 1;
//                                                                                    } else {
//                                                                                        if (_HSARDataRecordAGEH < 80) {
//                                                                                            _MalesAge75to79 = 1;
//                                                                                        } else {
//                                                                                            _MalesAge80AndOver = 1;
//                                                                                        }
//                                                                                    }
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                            // Married
//                            if (_HSARDataRecordMARSTAH == (short) 2) {
//                                if (_HSARDataRecordAGEH < 16) {
//                                    _MalesMarriedAge0to15 = 1;
//                                } else {
//                                    if (_HSARDataRecordAGEH < 20) {
//                                        _MalesMarriedAge16to19 = 1;
//                                    } else {
//                                        if (_HSARDataRecordAGEH < 25) {
//                                            _MalesMarriedAge20to24 = 1;
//                                        } else {
//                                            if (_HSARDataRecordAGEH < 30) {
//                                                _MalesMarriedAge25to29 = 1;
//                                            } else {
//                                                if (_HSARDataRecordAGEH < 35) {
//                                                    _MalesMarriedAge30to34 = 1;
//                                                } else {
//                                                    if (_HSARDataRecordAGEH < 40) {
//                                                        _MalesMarriedAge35to39 = 1;
//                                                    } else {
//                                                        if (_HSARDataRecordAGEH < 45) {
//                                                            _MalesMarriedAge40to44 = 1;
//                                                        } else {
//                                                            if (_HSARDataRecordAGEH < 50) {
//                                                                _MalesMarriedAge45to49 = 1;
//                                                            } else {
//                                                                if (_HSARDataRecordAGEH < 55) {
//                                                                    _MalesMarriedAge50to54 = 1;
//                                                                } else {
//                                                                    if (_HSARDataRecordAGEH < 60) {
//                                                                        _MalesMarriedAge55to59 = 1;
//                                                                    } else {
//                                                                        if (_HSARDataRecordAGEH < 65) {
//                                                                            _MalesMarriedAge60to64 = 1;
//                                                                        } else {
//                                                                            if (_HSARDataRecordAGEH < 70) {
//                                                                                _MalesMarriedAge65to74 = 1;
//                                                                            } else {
//                                                                                if (_HSARDataRecordAGEH < 80) {
//                                                                                    _MalesMarriedAge75to79 = 1;
//                                                                                } else {
//                                                                                    _MalesMarriedAge80AndOver = 1;
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                            // Unemployed
//                            if (_HSARDataRecordECONACH == (short) 2) {
//                                if (_HSARDataRecordAGEH > 15) {
//                                    if (_HSARDataRecordAGEH < 25) {
//                                        _MalesAge16to24Unemployed = 1;
//                                    }
//                                    if (_HSARDataRecordAGEH < 75) {
//                                        _MalesAge16to74EconomicallyActiveUnemployed = 1;
//                                        // if ( _HSARDataRecordAGEH > 49 ) {
//                                        // _MalesAge50AndOverUnemployed = 1;
//                                        // }
//                                    }
//                                }
//                                if (_HSARDataRecordAGEH > 49) {
//                                    _MalesAge50AndOverUnemployed = 1;
//                                }
//                            } else {
//                                if (_HSARDataRecordAGEH > 15 && _HSARDataRecordAGEH < 75) {
//                                    _MalesAge16to74 = 1;
//                                    if (_HSARDataRecordECONACH == (short) 1) {
//                                        _MalesAge16to74EconomicallyActiveEmployed = 1;
//                                    }
//                                    if (_HSARDataRecordECONACH > 2) {
//                                        _MalesAge16to74EconomicallyInactive = 1;
//                                    }
//                                }
//                            }
//                        } else {
//                            // Female
//                            if (_HSARDataRecordAGEH < 5) {
//                                _FemalesAge0to4 = 1;
//                            } else {
//                                if (_HSARDataRecordAGEH < 10) {
//                                    _FemalesAge5to9 = 1;
//                                } else {
//                                    if (_HSARDataRecordAGEH < 15) {
//                                        _FemalesAge10to14 = 1;
//                                    } else {
//                                        if (_HSARDataRecordAGEH < 20) {
//                                            _FemalesAge15to19 = 1;
//                                        } else {
//                                            if (_HSARDataRecordAGEH < 25) {
//                                                _FemalesAge20to24 = 1;
//                                            } else {
//                                                if (_HSARDataRecordAGEH < 30) {
//                                                    _FemalesAge25to29 = 1;
//                                                } else {
//                                                    if (_HSARDataRecordAGEH < 35) {
//                                                        _FemalesAge30to34 = 1;
//                                                    } else {
//                                                        if (_HSARDataRecordAGEH < 40) {
//                                                            _FemalesAge35to39 = 1;
//                                                        } else {
//                                                            if (_HSARDataRecordAGEH < 45) {
//                                                                _FemalesAge40to44 = 1;
//                                                            } else {
//                                                                if (_HSARDataRecordAGEH < 50) {
//                                                                    _FemalesAge45to49 = 1;
//                                                                } else {
//                                                                    if (_HSARDataRecordAGEH < 55) {
//                                                                        _FemalesAge50to54 = 1;
//                                                                    } else {
//                                                                        if (_HSARDataRecordAGEH < 60) {
//                                                                            _FemalesAge55to59 = 1;
//                                                                        } else {
//                                                                            if (_HSARDataRecordAGEH < 65) {
//                                                                                _FemalesAge60to64 = 1;
//                                                                            } else {
//                                                                                if (_HSARDataRecordAGEH < 70) {
//                                                                                    _FemalesAge65to69 = 1;
//                                                                                } else {
//                                                                                    if (_HSARDataRecordAGEH < 75) {
//                                                                                        _FemalesAge70to74 = 1;
//                                                                                    } else {
//                                                                                        if (_HSARDataRecordAGEH < 80) {
//                                                                                            _FemalesAge75to79 = 1;
//                                                                                        } else {
//                                                                                            _FemalesAge80AndOver = 1;
//                                                                                        }
//                                                                                    }
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                            // Married
//                            if (_HSARDataRecordMARSTAH == (short) 2) {
//                                if (_HSARDataRecordAGEH < 16) {
//                                    _FemalesMarriedAge0to15 = 1;
//                                } else {
//                                    if (_HSARDataRecordAGEH < 20) {
//                                        _FemalesMarriedAge16to19 = 1;
//                                    } else {
//                                        if (_HSARDataRecordAGEH < 25) {
//                                            _FemalesMarriedAge20to24 = 1;
//                                        } else {
//                                            if (_HSARDataRecordAGEH < 30) {
//                                                _FemalesMarriedAge25to29 = 1;
//                                            } else {
//                                                if (_HSARDataRecordAGEH < 35) {
//                                                    _FemalesMarriedAge30to34 = 1;
//                                                } else {
//                                                    if (_HSARDataRecordAGEH < 40) {
//                                                        _FemalesMarriedAge35to39 = 1;
//                                                    } else {
//                                                        if (_HSARDataRecordAGEH < 45) {
//                                                            _FemalesMarriedAge40to44 = 1;
//                                                        } else {
//                                                            if (_HSARDataRecordAGEH < 50) {
//                                                                _FemalesMarriedAge45to49 = 1;
//                                                            } else {
//                                                                if (_HSARDataRecordAGEH < 55) {
//                                                                    _FemalesMarriedAge50to54 = 1;
//                                                                } else {
//                                                                    if (_HSARDataRecordAGEH < 60) {
//                                                                        _FemalesMarriedAge55to59 = 1;
//                                                                    } else {
//                                                                        if (_HSARDataRecordAGEH < 65) {
//                                                                            _FemalesMarriedAge60to64 = 1;
//                                                                        } else {
//                                                                            if (_HSARDataRecordAGEH < 70) {
//                                                                                _FemalesMarriedAge65to74 = 1;
//                                                                            } else {
//                                                                                if (_HSARDataRecordAGEH < 80) {
//                                                                                    _FemalesMarriedAge75to79 = 1;
//                                                                                } else {
//                                                                                    _FemalesMarriedAge80AndOver = 1;
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                            // Unemployed
//                            if (_HSARDataRecordECONACH == (short) 2) {
//                                if (_HSARDataRecordAGEH > 15) {
//                                    if (_HSARDataRecordAGEH < 25) {
//                                        _FemalesAge16to24Unemployed = 1;
//                                    }
//                                    if (_HSARDataRecordAGEH < 75) {
//                                        _FemalesAge16to74EconomicallyActiveUnemployed = 1;
//                                        // if ( _HSARDataRecordAGEH > 49 ) {
//                                        // _FemalesAge50AndOverUnemployed = 1;
//                                        // }
//                                    }
//                                }
//                                if (_HSARDataRecordAGEH > 49) {
//                                    _FemalesAge50AndOverUnemployed = 1;
//                                }
//                            } else {
//                                if (_HSARDataRecordAGEH > 15 && _HSARDataRecordAGEH < 75) {
//                                    _FemalesAge16to74 = 1;
//                                    if (_HSARDataRecordECONACH == (short) 1) {
//                                        _FemalesAge16to74EconomicallyActiveEmployed = 1;
//                                    }
//                                    if (_HSARDataRecordECONACH > 2) {
//                                        _FemalesAge16to74EconomicallyInactive = 1;
//                                    }
//                                }
//                            }
//                        }
//                    } else {
//                        _ISARDataRecord = (ISARDataRecord) tISARDataHandler.getDataRecord(aToyModelDataRecord2.tISARDataRecordID);
//                        _ISARDataRecordAGE0 = _ISARDataRecord.get_AGE0();
//                        _SEX = _ISARDataRecord.get_SEX();
//                        _ISARDataRecordECONACT = _ISARDataRecord.get_ECONACT();
//                        _ISARDataRecordMARSTAT = _ISARDataRecord.get_MARSTAT();
//                        _HEALTH = _ISARDataRecord.get_HEALTH();
//                        if (_ISARDataRecord.get_LLTI() == (short) 1) {
//                            _PeopleWithLimitingLongTermIllness = 1;
//                        }
//                        if (_SEX) {
//                            // Male
//                            if (_ISARDataRecordAGE0 < 5) {
//                                _MalesAge0to4 = 1;
//                            } else {
//                                if (_ISARDataRecordAGE0 < 10) {
//                                    _MalesAge5to9 = 1;
//                                } else {
//                                    if (_ISARDataRecordAGE0 < 15) {
//                                        _MalesAge10to14 = 1;
//                                    } else {
//                                        if (_ISARDataRecordAGE0 < 20) {
//                                            _MalesAge15to19 = 1;
//                                        } else {
//                                            if (_ISARDataRecordAGE0 < 25) {
//                                                _MalesAge20to24 = 1;
//                                            } else {
//                                                if (_ISARDataRecordAGE0 < 30) {
//                                                    _MalesAge25to29 = 1;
//                                                } else {
//                                                    if (_ISARDataRecordAGE0 < 35) {
//                                                        _MalesAge30to34 = 1;
//                                                    } else {
//                                                        if (_ISARDataRecordAGE0 < 40) {
//                                                            _MalesAge35to39 = 1;
//                                                        } else {
//                                                            if (_ISARDataRecordAGE0 < 45) {
//                                                                _MalesAge40to44 = 1;
//                                                            } else {
//                                                                if (_ISARDataRecordAGE0 < 50) {
//                                                                    _MalesAge45to49 = 1;
//                                                                } else {
//                                                                    if (_ISARDataRecordAGE0 < 55) {
//                                                                        _MalesAge50to54 = 1;
//                                                                    } else {
//                                                                        if (_ISARDataRecordAGE0 < 60) {
//                                                                            _MalesAge55to59 = 1;
//                                                                        } else {
//                                                                            if (_ISARDataRecordAGE0 < 65) {
//                                                                                _MalesAge60to64 = 1;
//                                                                            } else {
//                                                                                if (_ISARDataRecordAGE0 < 70) {
//                                                                                    _MalesAge65to69 = 1;
//                                                                                } else {
//                                                                                    if (_ISARDataRecordAGE0 < 75) {
//                                                                                        _MalesAge70to74 = 1;
//                                                                                    } else {
//                                                                                        if (_ISARDataRecordAGE0 < 80) {
//                                                                                            _MalesAge75to79 = 1;
//                                                                                        } else {
//                                                                                            _MalesAge80AndOver = 1;
//                                                                                        }
//                                                                                    }
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                            // Married
//                            if (_ISARDataRecordMARSTAT == (short) 2 || _ISARDataRecordMARSTAT == (short) 3) {
//                                if (_ISARDataRecordAGE0 < 16) {
//                                    _MalesMarriedAge0to15 = 1;
//                                } else {
//                                    if (_ISARDataRecordAGE0 < 20) {
//                                        _MalesMarriedAge16to19 = 1;
//                                    } else {
//                                        if (_ISARDataRecordAGE0 < 25) {
//                                            _MalesMarriedAge20to24 = 1;
//                                        } else {
//                                            if (_ISARDataRecordAGE0 < 30) {
//                                                _MalesMarriedAge25to29 = 1;
//                                            } else {
//                                                if (_ISARDataRecordAGE0 < 35) {
//                                                    _MalesMarriedAge30to34 = 1;
//                                                } else {
//                                                    if (_ISARDataRecordAGE0 < 40) {
//                                                        _MalesMarriedAge35to39 = 1;
//                                                    } else {
//                                                        if (_ISARDataRecordAGE0 < 45) {
//                                                            _MalesMarriedAge40to44 = 1;
//                                                        } else {
//                                                            if (_ISARDataRecordAGE0 < 50) {
//                                                                _MalesMarriedAge45to49 = 1;
//                                                            } else {
//                                                                if (_ISARDataRecordAGE0 < 55) {
//                                                                    _MalesMarriedAge50to54 = 1;
//                                                                } else {
//                                                                    if (_ISARDataRecordAGE0 < 60) {
//                                                                        _MalesMarriedAge55to59 = 1;
//                                                                    } else {
//                                                                        if (_ISARDataRecordAGE0 < 65) {
//                                                                            _MalesMarriedAge60to64 = 1;
//                                                                        } else {
//                                                                            if (_ISARDataRecordAGE0 < 70) {
//                                                                                _MalesMarriedAge65to74 = 1;
//                                                                            } else {
//                                                                                if (_ISARDataRecordAGE0 < 80) {
//                                                                                    _MalesMarriedAge75to79 = 1;
//                                                                                } else {
//                                                                                    _MalesMarriedAge80AndOver = 1;
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                            // Unemployed
//                            if (_ISARDataRecordECONACT > 5 && _ISARDataRecordECONACT < 9) {
//                                if (_ISARDataRecordAGE0 > 15) {
//                                    if (_ISARDataRecordAGE0 < 25) {
//                                        _MalesAge16to24Unemployed = 1;
//                                    }
//                                    if (_ISARDataRecordAGE0 < 75) {
//                                        _MalesAge16to74EconomicallyActiveUnemployed = 1;
//                                        // if ( _ISARDataRecordAGE0 > 49 ) {
//                                        // _MalesAge50AndOverUnemployed = 1;
//                                        // }
//                                    }
//                                }
//                                if (_ISARDataRecordAGE0 > 49) {
//                                    _MalesAge50AndOverUnemployed = 1;
//                                }
//                            } else {
//                                if (_ISARDataRecordAGE0 > 15 && _ISARDataRecordAGE0 < 75) {
//                                    if (_ISARDataRecordECONACT > 0 && _ISARDataRecordECONACT < 7) {
//                                        _MalesAge16to74EconomicallyActiveEmployed = 1;
//                                    }
//                                    if (_ISARDataRecordECONACT > 8) {
//                                        _MalesAge16to74EconomicallyInactive = 1;
//                                    }
//                                }
//                            }
//                        } else {
//                            // Female
//                            if (_ISARDataRecordAGE0 < 5) {
//                                _FemalesAge0to4 = 1;
//                            } else {
//                                if (_ISARDataRecordAGE0 < 10) {
//                                    _FemalesAge5to9 = 1;
//                                } else {
//                                    if (_ISARDataRecordAGE0 < 15) {
//                                        _FemalesAge10to14 = 1;
//                                    } else {
//                                        if (_ISARDataRecordAGE0 < 20) {
//                                            _FemalesAge15to19 = 1;
//                                        } else {
//                                            if (_ISARDataRecordAGE0 < 25) {
//                                                _FemalesAge20to24 = 1;
//                                            } else {
//                                                if (_ISARDataRecordAGE0 < 30) {
//                                                    _FemalesAge25to29 = 1;
//                                                } else {
//                                                    if (_ISARDataRecordAGE0 < 35) {
//                                                        _FemalesAge30to34 = 1;
//                                                    } else {
//                                                        if (_ISARDataRecordAGE0 < 40) {
//                                                            _FemalesAge35to39 = 1;
//                                                        } else {
//                                                            if (_ISARDataRecordAGE0 < 45) {
//                                                                _FemalesAge40to44 = 1;
//                                                            } else {
//                                                                if (_ISARDataRecordAGE0 < 50) {
//                                                                    _FemalesAge45to49 = 1;
//                                                                } else {
//                                                                    if (_ISARDataRecordAGE0 < 55) {
//                                                                        _FemalesAge50to54 = 1;
//                                                                    } else {
//                                                                        if (_ISARDataRecordAGE0 < 60) {
//                                                                            _FemalesAge55to59 = 1;
//                                                                        } else {
//                                                                            if (_ISARDataRecordAGE0 < 65) {
//                                                                                _FemalesAge60to64 = 1;
//                                                                            } else {
//                                                                                if (_ISARDataRecordAGE0 < 70) {
//                                                                                    _FemalesAge65to69 = 1;
//                                                                                } else {
//                                                                                    if (_ISARDataRecordAGE0 < 75) {
//                                                                                        _FemalesAge70to74 = 1;
//                                                                                    } else {
//                                                                                        if (_ISARDataRecordAGE0 < 80) {
//                                                                                            _FemalesAge75to79 = 1;
//                                                                                        } else {
//                                                                                            _FemalesAge80AndOver = 1;
//                                                                                        }
//                                                                                    }
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                            // Married
//                            if (_ISARDataRecordMARSTAT == (short) 2 || _ISARDataRecordMARSTAT == (short) 3) {
//                                if (_ISARDataRecordAGE0 < 16) {
//                                    _FemalesMarriedAge0to15 = 1;
//                                } else {
//                                    if (_ISARDataRecordAGE0 < 20) {
//                                        _FemalesMarriedAge16to19 = 1;
//                                    } else {
//                                        if (_ISARDataRecordAGE0 < 25) {
//                                            _FemalesMarriedAge20to24 = 1;
//                                        } else {
//                                            if (_ISARDataRecordAGE0 < 30) {
//                                                _FemalesMarriedAge25to29 = 1;
//                                            } else {
//                                                if (_ISARDataRecordAGE0 < 35) {
//                                                    _FemalesMarriedAge30to34 = 1;
//                                                } else {
//                                                    if (_ISARDataRecordAGE0 < 40) {
//                                                        _FemalesMarriedAge35to39 = 1;
//                                                    } else {
//                                                        if (_ISARDataRecordAGE0 < 45) {
//                                                            _FemalesMarriedAge40to44 = 1;
//                                                        } else {
//                                                            if (_ISARDataRecordAGE0 < 50) {
//                                                                _FemalesMarriedAge45to49 = 1;
//                                                            } else {
//                                                                if (_ISARDataRecordAGE0 < 55) {
//                                                                    _FemalesMarriedAge50to54 = 1;
//                                                                } else {
//                                                                    if (_ISARDataRecordAGE0 < 60) {
//                                                                        _FemalesMarriedAge55to59 = 1;
//                                                                    } else {
//                                                                        if (_ISARDataRecordAGE0 < 65) {
//                                                                            _FemalesMarriedAge60to64 = 1;
//                                                                        } else {
//                                                                            if (_ISARDataRecordAGE0 < 70) {
//                                                                                _FemalesMarriedAge65to74 = 1;
//                                                                            } else {
//                                                                                if (_ISARDataRecordAGE0 < 80) {
//                                                                                    _FemalesMarriedAge75to79 = 1;
//                                                                                } else {
//                                                                                    _FemalesMarriedAge80AndOver = 1;
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                            // Unemployed
//                            if (_ISARDataRecordECONACT > 5 && _ISARDataRecordECONACT < 9) {
//                                if (_ISARDataRecordAGE0 > 15) {
//                                    if (_ISARDataRecordAGE0 < 25) {
//                                        _FemalesAge16to24Unemployed = 1;
//                                    }
//                                    if (_ISARDataRecordAGE0 < 75) {
//                                        _FemalesAge16to74EconomicallyActiveUnemployed = 1;
//                                        // if ( _ISARDataRecordAGE0 > 49 ) {
//                                        // _FemalesAge50AndOverUnemployed = 1;
//                                        // }
//                                    }
//                                }
//                                if (_ISARDataRecordAGE0 > 49) {
//                                    _FemalesAge50AndOverUnemployed = 1;
//                                }
//                            } else {
//                                if (_ISARDataRecordAGE0 > 15 && _ISARDataRecordAGE0 < 75) {
//                                    if (_ISARDataRecordECONACT > 0 && _ISARDataRecordECONACT < 7) {
//                                        _FemalesAge16to74EconomicallyActiveEmployed = 1;
//                                    }
//                                    if (_ISARDataRecordECONACT > 8) {
//                                        _FemalesAge16to74EconomicallyInactive = 1;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    if (_HEALTH == (short) 1) {
//                        _PeopleWhoseGeneralHealthWasGood = 1;
//                    }
//                    if (_HEALTH == (short) 2) {
//                        _PeopleWhoseGeneralHealthWasFairlyGood = 1;
//                    }
//                    if (_HEALTH == (short) 3) {
//                        _PeopleWhoseGeneralHealthWasNotGood = 1;
//                    }
//                    if (result.containsKey(aZoneCode)) {
//                        _Counts = (Counts) result.get(aZoneCode);
//                        result.remove(aZoneCode);
//                        _Counts.addToCounts(
//                                _PeopleWhoseGeneralHealthWasGood,
//                                _PeopleWhoseGeneralHealthWasFairlyGood,
//                                _PeopleWhoseGeneralHealthWasNotGood,
//                                _PeopleWithLimitingLongTermIllness,
//                                _LoneParentHouseholdsWithChildren,
//                                _OneFamilyAndNoChildren,
//                                _MarriedOrCohabitingCoupleWithChildren,
//                                _FemalesAge0to4,
//                                _FemalesAge5to9,
//                                _FemalesAge10to14,
//                                _FemalesAge15to19,
//                                _FemalesAge20to24,
//                                _FemalesAge25to29,
//                                _FemalesAge30to34,
//                                _FemalesAge35to39,
//                                _FemalesAge40to44,
//                                _FemalesAge45to49,
//                                _FemalesAge50to54,
//                                _FemalesAge55to59,
//                                _FemalesAge60to64,
//                                _FemalesAge65to69,
//                                _FemalesAge70to74,
//                                _FemalesAge75to79,
//                                _FemalesAge80AndOver,
//                                _FemalesMarriedAge0to15,
//                                _FemalesMarriedAge16to19,
//                                _FemalesMarriedAge20to24,
//                                _FemalesMarriedAge25to29,
//                                _FemalesMarriedAge30to34,
//                                _FemalesMarriedAge35to39,
//                                _FemalesMarriedAge40to44,
//                                _FemalesMarriedAge45to49,
//                                _FemalesMarriedAge50to54,
//                                _FemalesMarriedAge55to59,
//                                _FemalesMarriedAge60to64,
//                                _FemalesMarriedAge65to74,
//                                _FemalesMarriedAge75to79,
//                                _FemalesMarriedAge80AndOver,
//                                _FemalesAge16to24Unemployed, _FemalesAge16to74,
//                                _FemalesAge16to74EconomicallyActiveEmployed,
//                                _FemalesAge16to74EconomicallyActiveUnemployed,
//                                //_FemalesAge16to74EconomicallyInactive,
//                                _FemalesAge50AndOverUnemployed,
//                                _MalesAge0to4,
//                                _MalesAge5to9,
//                                _MalesAge10to14,
//                                _MalesAge15to19,
//                                _MalesAge20to24,
//                                _MalesAge25to29,
//                                _MalesAge30to34,
//                                _MalesAge35to39,
//                                _MalesAge40to44,
//                                _MalesAge45to49,
//                                _MalesAge50to54,
//                                _MalesAge55to59,
//                                _MalesAge60to64,
//                                _MalesAge65to69,
//                                _MalesAge70to74,
//                                _MalesAge75to79,
//                                _MalesAge80AndOver,
//                                _MalesMarriedAge0to15,
//                                _MalesMarriedAge16to19,
//                                _MalesMarriedAge20to24,
//                                _MalesMarriedAge25to29,
//                                _MalesMarriedAge30to34,
//                                _MalesMarriedAge35to39,
//                                _MalesMarriedAge40to44,
//                                _MalesMarriedAge45to49,
//                                _MalesMarriedAge50to54,
//                                _MalesMarriedAge55to59,
//                                _MalesMarriedAge60to64,
//                                _MalesMarriedAge65to74,
//                                _MalesMarriedAge75to79,
//                                _MalesMarriedAge80AndOver,
//                                _MalesAge16to24Unemployed, _MalesAge16to74,
//                                _MalesAge16to74EconomicallyActiveEmployed,
//                                _MalesAge16to74EconomicallyActiveUnemployed,
//                                //_MalesAge16to74EconomicallyInactive,
//                                _MalesAge50AndOverUnemployed);
//                        result.put(aZoneCode, _Counts);
//                    } else {
//                        _Counts = new Counts();
//                        _Counts.addToCounts(_PeopleWhoseGeneralHealthWasGood,
//                                _PeopleWhoseGeneralHealthWasFairlyGood,
//                                _PeopleWhoseGeneralHealthWasNotGood,
//                                _PeopleWithLimitingLongTermIllness,
//                                _LoneParentHouseholdsWithChildren,
//                                _OneFamilyAndNoChildren,
//                                _MarriedOrCohabitingCoupleWithChildren,
//                                _FemalesAge0to4, _FemalesAge5to9,
//                                _FemalesAge10to14, _FemalesAge15to19,
//                                _FemalesAge20to24, _FemalesAge25to29,
//                                _FemalesAge30to34, _FemalesAge35to39,
//                                _FemalesAge40to44, _FemalesAge45to49,
//                                _FemalesAge50to54, _FemalesAge55to59,
//                                _FemalesAge60to64, _FemalesAge65to69,
//                                _FemalesAge70to74, _FemalesAge75to79,
//                                _FemalesAge80AndOver,
//                                _FemalesMarriedAge0to15,
//                                _FemalesMarriedAge16to19,
//                                _FemalesMarriedAge20to24,
//                                _FemalesMarriedAge25to29,
//                                _FemalesMarriedAge30to34,
//                                _FemalesMarriedAge35to39,
//                                _FemalesMarriedAge40to44,
//                                _FemalesMarriedAge45to49,
//                                _FemalesMarriedAge50to54,
//                                _FemalesMarriedAge55to59,
//                                _FemalesMarriedAge60to64,
//                                _FemalesMarriedAge65to74,
//                                _FemalesMarriedAge75to79,
//                                _FemalesMarriedAge80AndOver,
//                                _FemalesAge16to24Unemployed, _FemalesAge16to74,
//                                _FemalesAge16to74EconomicallyActiveEmployed,
//                                _FemalesAge16to74EconomicallyActiveUnemployed,
//                                //_FemalesAge16to74EconomicallyInactive,
//                                _FemalesAge50AndOverUnemployed,
//                                _MalesAge0to4,
//                                _MalesAge5to9, _MalesAge10to14,
//                                _MalesAge15to19,
//                                _MalesAge20to24,
//                                _MalesAge25to29,
//                                _MalesAge30to34,
//                                _MalesAge35to39,
//                                _MalesAge40to44,
//                                _MalesAge45to49,
//                                _MalesAge50to54,
//                                _MalesAge55to59,
//                                _MalesAge60to64,
//                                _MalesAge65to69,
//                                _MalesAge70to74,
//                                _MalesAge75to79,
//                                _MalesAge80AndOver,
//                                _MalesMarriedAge0to15,
//                                _MalesMarriedAge16to19,
//                                _MalesMarriedAge20to24,
//                                _MalesMarriedAge25to29,
//                                _MalesMarriedAge30to34,
//                                _MalesMarriedAge35to39,
//                                _MalesMarriedAge40to44,
//                                _MalesMarriedAge45to49,
//                                _MalesMarriedAge50to54,
//                                _MalesMarriedAge55to59,
//                                _MalesMarriedAge60to64,
//                                _MalesMarriedAge65to74,
//                                _MalesMarriedAge75to79,
//                                _MalesMarriedAge80AndOver,
//                                _MalesAge16to24Unemployed, _MalesAge16to74,
//                                _MalesAge16to74EconomicallyActiveEmployed,
//                                _MalesAge16to74EconomicallyActiveUnemployed,
//                                //_MalesAge16to74EconomicallyInactive,
//                                _MalesAge50AndOverUnemployed);
//                        result.put(aZoneCode, _Counts);
//                    }
//            }
//            tokenType = tStreamTokenizer.nextToken();
//        }
//        Iterator aIterator = result.keySet().iterator();
//        Object key;
//        while (aIterator.hasNext()) {
//            key = aIterator.next();
//            _Counts = (Counts) result.get(key);
//            aZoneCode = (String) key;
//            write(_Counts, aZoneCode);
//        }
//        this._FileOutputStream.close();
//    }

    public static void writeHSARHP_ISARCEP(
            HashMap<String, Integer> a_Counts,
            String a_ZoneCode,
            FileOutputStream a_FileOutputStream)
            throws IOException {
        String line = a_ZoneCode + ",";
        Vector<String> variableList = GeneticAlgorithm_HSARHP_ISARCEP.getVariableList();
        for (int i = 0; i < variableList.size() - 1; i++) {
            line += a_Counts.get(variableList.elementAt(i)) + ",";
        }
        line += a_Counts.get(variableList.elementAt(variableList.size() - 1));
        System.out.println(line);
        a_FileOutputStream.write(line.getBytes());
        a_FileOutputStream.write(StreamTokenizer.TT_EOL);
        a_FileOutputStream.flush();
    }

    public static void writeISARHP_ISARCEP(
            HashMap<String, Integer> a_Counts,
            String a_ZoneCode,
            FileOutputStream a_FileOutputStream)
            throws IOException {
        String line = a_ZoneCode + ",";
        Vector<String> variableList = GeneticAlgorithm_ISARHP_ISARCEP.getVariableList();
        for (int i = 0; i < variableList.size() - 1; i++) {
            line += a_Counts.get(variableList.elementAt(i)) + ",";
        }
        line += a_Counts.get(variableList.elementAt(variableList.size() - 1));
        System.out.println(line);
        a_FileOutputStream.write(line.getBytes());
        a_FileOutputStream.write(StreamTokenizer.TT_EOL);
        a_FileOutputStream.flush();
    }

//     protected void write(
//            Counts a_Counts,
//            String a_ZoneCode)
//            throws IOException {
//        write(
//                a_Counts,
//                a_ZoneCode,
//                this._FileOutputStream);
//    }
//    public static void write(
//            Counts a_Counts,
//            String a_ZoneCode,
//            FileOutputStream a_FileOutputStream)
//            throws IOException {
//        String record =
//                a_ZoneCode + ","
//                + a_Counts._PeopleWhoseGeneralHealthWasGood + ","
//                + a_Counts._PeopleWhoseGeneralHealthWasFairlyGood + ","
//                + a_Counts._PeopleWhoseGeneralHealthWasNotGood + ","
//                + a_Counts._PeopleWithLimitingLongTermIllness + ","
//                + a_Counts._LoneParentHouseholdsWithChildren + ","
//                + a_Counts._OneFamilyAndNoChildren + ","
//                + a_Counts._MarriedOrCohabitingCoupleWithChildren + ","
//                + a_Counts._FemalesAge0to4 + ","
//                + a_Counts._FemalesAge5to9 + ","
//                + a_Counts._FemalesAge10to14 + ","
//                + a_Counts._FemalesAge15to19 + ","
//                + a_Counts._FemalesAge20to24 + ","
//                + a_Counts._FemalesAge25to29 + ","
//                + a_Counts._FemalesAge30to34 + ","
//                + a_Counts._FemalesAge35to39 + ","
//                + a_Counts._FemalesAge40to44 + ","
//                + a_Counts._FemalesAge45to49 + ","
//                + a_Counts._FemalesAge50to54 + ","
//                + a_Counts._FemalesAge55to59 + ","
//                + a_Counts._FemalesAge60to64 + ","
//                + a_Counts._FemalesAge65to69 + ","
//                + a_Counts._FemalesAge70to74 + ","
//                + a_Counts._FemalesAge75to79 + ","
//                + a_Counts._FemalesAge80AndOver + ","
//                + a_Counts._FemalesMarriedAge0to15 + ","
//                + a_Counts._FemalesMarriedAge16to19 + ","
//                + a_Counts._FemalesMarriedAge20to24 + ","
//                + a_Counts._FemalesMarriedAge25to29 + ","
//                + a_Counts._FemalesMarriedAge30to34 + ","
//                + a_Counts._FemalesMarriedAge35to39 + ","
//                + a_Counts._FemalesMarriedAge40to44 + ","
//                + a_Counts._FemalesMarriedAge45to49 + ","
//                + a_Counts._FemalesMarriedAge50to54 + ","
//                + a_Counts._FemalesMarriedAge55to59 + ","
//                + a_Counts._FemalesMarriedAge60to64 + ","
//                + a_Counts._FemalesMarriedAge65to74 + ","
//                + a_Counts._FemalesMarriedAge75to79 + ","
//                + a_Counts._FemalesMarriedAge80AndOver + ","
//                + a_Counts._FemalesAge16to24Unemployed + ","
//                + a_Counts._FemalesAge16to74 + ","
//                + a_Counts._FemalesAge16to74EconomicallyActiveEmployed + ","
//                + a_Counts._FemalesAge16to74EconomicallyActiveUnemployed + ","
//                //+ a_Counts._FemalesAge16to74EconomicallyInactive + ","
//                + a_Counts._FemalesAge50AndOverUnemployed + ","
//                + a_Counts._MalesAge0to4 + ","
//                + a_Counts._MalesAge5to9 + ","
//                + a_Counts._MalesAge10to14 + ","
//                + a_Counts._MalesAge15to19 + ","
//                + a_Counts._MalesAge20to24 + ","
//                + a_Counts._MalesAge25to29 + ","
//                + a_Counts._MalesAge30to34 + ","
//                + a_Counts._MalesAge35to39 + ","
//                + a_Counts._MalesAge40to44 + ","
//                + a_Counts._MalesAge45to49 + ","
//                + a_Counts._MalesAge50to54 + ","
//                + a_Counts._MalesAge55to59 + ","
//                + a_Counts._MalesAge60to64 + ","
//                + a_Counts._MalesAge65to69 + ","
//                + a_Counts._MalesAge70to74 + ","
//                + a_Counts._MalesAge75to79 + ","
//                + a_Counts._MalesAge80AndOver + ","
//                + a_Counts._MalesMarriedAge0to15 + ","
//                + a_Counts._MalesMarriedAge16to19 + ","
//                + a_Counts._MalesMarriedAge20to24 + ","
//                + a_Counts._MalesMarriedAge25to29 + ","
//                + a_Counts._MalesMarriedAge30to34 + ","
//                + a_Counts._MalesMarriedAge35to39 + ","
//                + a_Counts._MalesMarriedAge40to44 + ","
//                + a_Counts._MalesMarriedAge45to49 + ","
//                + a_Counts._MalesMarriedAge50to54 + ","
//                + a_Counts._MalesMarriedAge55to59 + ","
//                + a_Counts._MalesMarriedAge60to64 + ","
//                + a_Counts._MalesMarriedAge65to74 + ","
//                + a_Counts._MalesMarriedAge75to79 + ","
//                + a_Counts._MalesMarriedAge80AndOver + ","
//                + a_Counts._MalesAge16to24Unemployed + ","
//                + a_Counts._MalesAge16to74 + ","
//                + a_Counts._MalesAge16to74EconomicallyActiveEmployed + ","
//                + a_Counts._MalesAge16to74EconomicallyActiveUnemployed + ","
//                //+ a_Counts._MalesAge16to74EconomicallyInactive + ","
//                + a_Counts._MalesAge50AndOverUnemployed;
//        System.out.println(record);
//        a_FileOutputStream.write(record.getBytes());
//        a_FileOutputStream.write(StreamTokenizer.TT_EOL);
//        a_FileOutputStream.flush();
//    }
//    public class Counts {
//
//        int _PeopleWhoseGeneralHealthWasGood;
//        int _PeopleWhoseGeneralHealthWasFairlyGood;
//        int _PeopleWhoseGeneralHealthWasNotGood;
//        int _PeopleWithLimitingLongTermIllness;
//        int _LoneParentHouseholdsWithChildren;
//        int _OneFamilyAndNoChildren;
//        int _MarriedOrCohabitingCoupleWithChildren;
//        int _FemalesAge0to4;
//        int _FemalesAge5to9;
//        int _FemalesAge10to14;
//        int _FemalesAge15to19;
//        int _FemalesAge20to24;
//        int _FemalesAge25to29;
//        int _FemalesAge30to34;
//        int _FemalesAge35to39;
//        int _FemalesAge40to44;
//        int _FemalesAge45to49;
//        int _FemalesAge50to54;
//        int _FemalesAge55to59;
//        int _FemalesAge60to64;
//        int _FemalesAge65to69;
//        int _FemalesAge70to74;
//        int _FemalesAge75to79;
//        int _FemalesAge80AndOver;
//        int _FemalesMarriedAge0to15;
//        int _FemalesMarriedAge16to19;
//        int _FemalesMarriedAge20to24;
//        int _FemalesMarriedAge25to29;
//        int _FemalesMarriedAge30to34;
//        int _FemalesMarriedAge35to39;
//        int _FemalesMarriedAge40to44;
//        int _FemalesMarriedAge45to49;
//        int _FemalesMarriedAge50to54;
//        int _FemalesMarriedAge55to59;
//        int _FemalesMarriedAge60to64;
//        int _FemalesMarriedAge65to74;
//        int _FemalesMarriedAge75to79;
//        int _FemalesMarriedAge80AndOver;
//        int _FemalesAge16to24Unemployed;
//        int _FemalesAge16to74;
//        int _FemalesAge16to74EconomicallyActiveEmployed;
//        int _FemalesAge16to74EconomicallyActiveUnemployed;
//        //int _FemalesAge16to74EconomicallyInactive;
//        int _FemalesAge50AndOverUnemployed;
//        int _MalesAge0to4;
//        int _MalesAge5to9;
//        int _MalesAge10to14;
//        int _MalesAge15to19;
//        int _MalesAge20to24;
//        int _MalesAge25to29;
//        int _MalesAge30to34;
//        int _MalesAge35to39;
//        int _MalesAge40to44;
//        int _MalesAge45to49;
//        int _MalesAge50to54;
//        int _MalesAge55to59;
//        int _MalesAge60to64;
//        int _MalesAge65to69;
//        int _MalesAge70to74;
//        int _MalesAge75to79;
//        int _MalesAge80AndOver;
//        int _MalesMarriedAge0to15;
//        int _MalesMarriedAge16to19;
//        int _MalesMarriedAge20to24;
//        int _MalesMarriedAge25to29;
//        int _MalesMarriedAge30to34;
//        int _MalesMarriedAge35to39;
//        int _MalesMarriedAge40to44;
//        int _MalesMarriedAge45to49;
//        int _MalesMarriedAge50to54;
//        int _MalesMarriedAge55to59;
//        int _MalesMarriedAge60to64;
//        int _MalesMarriedAge65to74;
//        int _MalesMarriedAge75to79;
//        int _MalesMarriedAge80AndOver;
//        int _MalesAge16to24Unemployed;
//        int _MalesAge16to74;
//        int _MalesAge16to74EconomicallyActiveEmployed;
//        int _MalesAge16to74EconomicallyActiveUnemployed;
//        //int _MalesAge16to74EconomicallyInactive;
//        int _MalesAge50AndOverUnemployed;
//
//        public Counts(HashMap<String, Integer> counts_HashMap) {
//            _PeopleWhoseGeneralHealthWasGood = counts_HashMap.get("peopleWhoseGeneralHealthWasGood");
//            _PeopleWhoseGeneralHealthWasFairlyGood = counts_HashMap.get("peopleWhoseGeneralHealthWasFairlyGood");
//            _PeopleWhoseGeneralHealthWasNotGood = counts_HashMap.get("peopleWhoseGeneralHealthWasNotGood");
//            _PeopleWithLimitingLongTermIllness = counts_HashMap.get("peopleWithLimitingLongTermIllness");
//            _LoneParentHouseholdsWithChildren = counts_HashMap.get("loneParentHouseholdsWithChildren");
//            _OneFamilyAndNoChildren = counts_HashMap.get("oneFamilyAndNoChildren");
//            _MarriedOrCohabitingCoupleWithChildren = counts_HashMap.get("marriedOrCohabitingCoupleWithChildren");
//            _FemalesAge0to4 = counts_HashMap.get("femalesAge0to4");
//            _FemalesAge5to9 = counts_HashMap.get("femalesAge5to9");
//            _FemalesAge10to14 = counts_HashMap.get("femalesAge10to14");
//            _FemalesAge15to19 = counts_HashMap.get("femalesAge15to19");
//            _FemalesAge20to24 = counts_HashMap.get("femalesAge20to24");
//            _FemalesAge25to29 = counts_HashMap.get("femalesAge25to29");
//            _FemalesAge30to34 = counts_HashMap.get("femalesAge30to34");
//            _FemalesAge35to39 = counts_HashMap.get("femalesAge35to39");
//            _FemalesAge40to44 = counts_HashMap.get("femalesAge40to44");
//            _FemalesAge45to49 = counts_HashMap.get("femalesAge45to49");
//            _FemalesAge50to54 = counts_HashMap.get("femalesAge50to54");
//            _FemalesAge55to59 = counts_HashMap.get("femalesAge55to59");
//            _FemalesAge60to64 = counts_HashMap.get("femalesAge60to64");
//            _FemalesAge65to69 = counts_HashMap.get("femalesAge65to69");
//            _FemalesAge70to74 = counts_HashMap.get("femalesAge70to74");
//            _FemalesAge75to79 = counts_HashMap.get("femalesAge75to79");
//            _FemalesAge80AndOver = counts_HashMap.get("femalesAge80AndOver");
//            _FemalesMarriedAge0to15 = counts_HashMap.get("femalesMarriedAge0to15");
//            _FemalesMarriedAge16to19 = counts_HashMap.get("femalesMarriedAge16to19");
//            _FemalesMarriedAge20to24 = counts_HashMap.get("femalesMarriedAge20to24");
//            _FemalesMarriedAge25to29 = counts_HashMap.get("femalesMarriedAge25to29");
//            _FemalesMarriedAge30to34 = counts_HashMap.get("femalesMarriedAge30to34");
//            _FemalesMarriedAge35to39 = counts_HashMap.get("femalesMarriedAge35to39");
//            _FemalesMarriedAge40to44 = counts_HashMap.get("femalesMarriedAge40to44");
//            _FemalesMarriedAge45to49 = counts_HashMap.get("femalesMarriedAge45to49");
//            _FemalesMarriedAge50to54 = counts_HashMap.get("femalesMarriedAge50to54");
//            _FemalesMarriedAge55to59 = counts_HashMap.get("femalesMarriedAge55to59");
//            _FemalesMarriedAge60to64 = counts_HashMap.get("femalesMarriedAge60to64");
//            _FemalesMarriedAge65to74 = counts_HashMap.get("femalesMarriedAge65to74");
//            _FemalesMarriedAge75to79 = counts_HashMap.get("femalesMarriedAge75to79");
//            _FemalesMarriedAge80AndOver = counts_HashMap.get("femalesMarriedAge80AndOver");
//            _FemalesAge16to24Unemployed = counts_HashMap.get("femalesAge16to24Unemployed");
//            _FemalesAge16to74 = counts_HashMap.get("femalesAge16to74");
//            _FemalesAge16to74EconomicallyActiveEmployed = counts_HashMap.get("femalesAge16to74EconomicallyActiveEmployed");
//            _FemalesAge16to74EconomicallyActiveUnemployed = counts_HashMap.get("femalesAge16to74EconomicallyActiveUnemployed");
//            //_FemalesAge16to74EconomicallyInactive = counts_HashMap.get("femalesAge16to74EconomicallyInactive");
//            _FemalesAge50AndOverUnemployed = counts_HashMap.get("femalesAge50AndOverUnemployed");
//            _MalesAge0to4 = counts_HashMap.get("malesAge0to4");
//            _MalesAge5to9 = counts_HashMap.get("malesAge5to9");
//            _MalesAge10to14 = counts_HashMap.get("malesAge10to14");
//            _MalesAge15to19 = counts_HashMap.get("malesAge15to19");
//            _MalesAge20to24 = counts_HashMap.get("malesAge20to24");
//            _MalesAge25to29 = counts_HashMap.get("malesAge25to29");
//            _MalesAge30to34 = counts_HashMap.get("malesAge30to34");
//            _MalesAge35to39 = counts_HashMap.get("malesAge35to39");
//            _MalesAge40to44 = counts_HashMap.get("malesAge40to44");
//            _MalesAge45to49 = counts_HashMap.get("malesAge45to49");
//            _MalesAge50to54 = counts_HashMap.get("malesAge50to54");
//            _MalesAge55to59 = counts_HashMap.get("malesAge55to59");
//            _MalesAge60to64 = counts_HashMap.get("malesAge60to64");
//            _MalesAge65to69 = counts_HashMap.get("malesAge65to69");
//            _MalesAge70to74 = counts_HashMap.get("malesAge70to74");
//            _MalesAge75to79 = counts_HashMap.get("malesAge75to79");
//            _MalesAge80AndOver = counts_HashMap.get("malesAge80AndOver");
//            _MalesMarriedAge0to15 = counts_HashMap.get("malesMarriedAge0to15");
//            _MalesMarriedAge16to19 = counts_HashMap.get("malesMarriedAge16to19");
//            _MalesMarriedAge20to24 = counts_HashMap.get("malesMarriedAge20to24");
//            _MalesMarriedAge25to29 = counts_HashMap.get("malesMarriedAge25to29");
//            _MalesMarriedAge30to34 = counts_HashMap.get("malesMarriedAge30to34");
//            _MalesMarriedAge35to39 = counts_HashMap.get("malesMarriedAge35to39");
//            _MalesMarriedAge40to44 = counts_HashMap.get("malesMarriedAge40to44");
//            _MalesMarriedAge45to49 = counts_HashMap.get("malesMarriedAge45to49");
//            _MalesMarriedAge50to54 = counts_HashMap.get("malesMarriedAge50to54");
//            _MalesMarriedAge55to59 = counts_HashMap.get("malesMarriedAge55to59");
//            _MalesMarriedAge60to64 = counts_HashMap.get("malesMarriedAge60to64");
//            _MalesMarriedAge65to74 = counts_HashMap.get("malesMarriedAge65to74");
//            _MalesMarriedAge75to79 = counts_HashMap.get("malesMarriedAge75to79");
//            _MalesMarriedAge80AndOver = counts_HashMap.get("malesMarriedAge80AndOver");
//            _MalesAge16to24Unemployed = counts_HashMap.get("malesAge16to24Unemployed");
//            _MalesAge16to74 = counts_HashMap.get("malesAge16to74");
//            _MalesAge16to74EconomicallyActiveEmployed = counts_HashMap.get("malesAge16to74EconomicallyActiveEmployed");
//            _MalesAge16to74EconomicallyActiveUnemployed = counts_HashMap.get("malesAge16to74EconomicallyActiveUnemployed");
//            //_MalesAge16to74EconomicallyInactive = counts_HashMap.get("malesAge16to74EconomicallyInactive");
//            _MalesAge50AndOverUnemployed = counts_HashMap.get("malesAge50AndOverUnemployed");
//        }
//
//        public Counts() {
//            _PeopleWhoseGeneralHealthWasGood = 0;
//            _PeopleWhoseGeneralHealthWasFairlyGood = 0;
//            _PeopleWhoseGeneralHealthWasNotGood = 0;
//            _PeopleWithLimitingLongTermIllness = 0;
//            _LoneParentHouseholdsWithChildren = 0;
//            _OneFamilyAndNoChildren = 0;
//            _MarriedOrCohabitingCoupleWithChildren = 0;
//            _FemalesAge0to4 = 0;
//            _FemalesAge5to9 = 0;
//            _FemalesAge10to14 = 0;
//            _FemalesAge15to19 = 0;
//            _FemalesAge20to24 = 0;
//            _FemalesAge25to29 = 0;
//            _FemalesAge30to34 = 0;
//            _FemalesAge35to39 = 0;
//            _FemalesAge40to44 = 0;
//            _FemalesAge45to49 = 0;
//            _FemalesAge50to54 = 0;
//            _FemalesAge55to59 = 0;
//            _FemalesAge60to64 = 0;
//            _FemalesAge65to69 = 0;
//            _FemalesAge70to74 = 0;
//            _FemalesAge75to79 = 0;
//            _FemalesAge80AndOver = 0;
//            _FemalesMarriedAge0to15 = 0;
//            _FemalesMarriedAge16to19 = 0;
//            _FemalesMarriedAge20to24 = 0;
//            _FemalesMarriedAge25to29 = 0;
//            _FemalesMarriedAge30to34 = 0;
//            _FemalesMarriedAge35to39 = 0;
//            _FemalesMarriedAge40to44 = 0;
//            _FemalesMarriedAge45to49 = 0;
//            _FemalesMarriedAge50to54 = 0;
//            _FemalesMarriedAge55to59 = 0;
//            _FemalesMarriedAge60to64 = 0;
//            _FemalesMarriedAge65to74 = 0;
//            _FemalesMarriedAge75to79 = 0;
//            _FemalesMarriedAge80AndOver = 0;
//            _FemalesAge16to24Unemployed = 0;
//            _FemalesAge16to74 = 0;
//            _FemalesAge16to74EconomicallyActiveEmployed = 0;
//            _FemalesAge16to74EconomicallyActiveUnemployed = 0;
//            //_FemalesAge16to74EconomicallyInactive = 0;
//            _FemalesAge50AndOverUnemployed = 0;
//            _MalesAge0to4 = 0;
//            _MalesAge5to9 = 0;
//            _MalesAge10to14 = 0;
//            _MalesAge15to19 = 0;
//            _MalesAge20to24 = 0;
//            _MalesAge25to29 = 0;
//            _MalesAge30to34 = 0;
//            _MalesAge35to39 = 0;
//            _MalesAge40to44 = 0;
//            _MalesAge45to49 = 0;
//            _MalesAge50to54 = 0;
//            _MalesAge55to59 = 0;
//            _MalesAge60to64 = 0;
//            _MalesAge65to69 = 0;
//            _MalesAge70to74 = 0;
//            _MalesAge75to79 = 0;
//            _MalesAge80AndOver = 0;
//            _MalesMarriedAge0to15 = 0;
//            _MalesMarriedAge16to19 = 0;
//            _MalesMarriedAge20to24 = 0;
//            _MalesMarriedAge25to29 = 0;
//            _MalesMarriedAge30to34 = 0;
//            _MalesMarriedAge35to39 = 0;
//            _MalesMarriedAge40to44 = 0;
//            _MalesMarriedAge45to49 = 0;
//            _MalesMarriedAge50to54 = 0;
//            _MalesMarriedAge55to59 = 0;
//            _MalesMarriedAge60to64 = 0;
//            _MalesMarriedAge65to74 = 0;
//            _MalesMarriedAge75to79 = 0;
//            _MalesMarriedAge80AndOver = 0;
//            _MalesAge16to24Unemployed = 0;
//            _MalesAge16to74 = 0;
//            _MalesAge16to74EconomicallyActiveEmployed = 0;
//            _MalesAge16to74EconomicallyActiveUnemployed = 0;
//            //_MalesAge16to74EconomicallyInactive = 0;
//            _MalesAge50AndOverUnemployed = 0;
//        }
//
//        /**
//         * keys are Strings
//         * Keys with values derived from CAS001:
//         * malesAge0to4
//         * malesAge5to9
//         * malesAge10to14
//         * malesAge15to19
//         * malesAge20to24
//         * malesAge25to29
//         * malesAge30to34
//         * malesAge35to39
//         * malesAge40to44
//         * malesAge45to49
//         * malesAge50to54
//         * malesAge55to59
//         * malesAge60to64
//         * malesAge65to69
//         * malesAge70to74
//         * malesAge75to79
//         * malesAge80AndOver
//         * femalesAge0to4
//         * femalesAge5to9
//         * femalesAge10to14
//         * femalesAge15to19
//         * femalesAge20to24
//         * femalesAge25to29
//         * femalesAge30to34
//         * femalesAge35to39
//         * femalesAge40to44
//         * femalesAge45to49
//         * femalesAge50to54
//         * femalesAge55to59
//         * femalesAge60to64
//         * femalesAge65to69
//         * femalesAge70to74
//         * femalesAge75to79
//         * femalesAge80AndOver
//         *
//         * Keys with values derived from CAS002:
//         * malesMarriedAge0to15
//         * malesMarriedAge16to19
//         * malesMarriedAge20to24
//         * malesMarriedAge25to29
//         * malesMarriedAge30to34
//         * malesMarriedAge35to39
//         * malesMarriedAge40to44
//         * malesMarriedAge45to49
//         * malesMarriedAge50to54
//         * malesMarriedAge55to59
//         * malesMarriedAge60to64
//         * malesMarriedAge65to74
//         * malesMarriedAge75to79
//         * malesMarriedAge80AndOver
//         * femalesMarriedAge0to15
//         * femalesMarriedAge16to19
//         * femalesMarriedAge20to24
//         * femalesMarriedAge25to29
//         * femalesMarriedAge30to34
//         * femalesMarriedAge35to39
//         * femalesMarriedAge40to44
//         * femalesMarriedAge45to49
//         * femalesMarriedAge50to54
//         * femalesMarriedAge55to59
//         * femalesMarriedAge60to64
//         * femalesMarriedAge65to74
//         * femalesMarriedAge75to79
//         * femalesMarriedAge80AndOver
//         *
//         * Keys with values derived from CASKS008
//         * peopleWhoseGeneralHealthWasGood
//         * peopleWhoseGeneralHealthWasFairlyGood
//         * peopleWhoseGeneralHealthWasNotGood
//         * peopleWithLimitingLongTermIllness
//         *
//         * Keys with values derived from CASKS020DataRecord
//         * oneFamilyAndNoChildren
//         * marriedOrCohabitingCoupleWithChildren
//         * loneParentHouseholdsWithChildren
//         *
//         * Keys with values derived from CASKS09bDataRecord
//         * malesAge16to24Unemployed
//         * malesAge16to74
//         * malesAge16to74EconomicallyActiveEmployed
//         * malesAge16to74EconomicallyActiveUnemployed
//         * malesAge50AndOverUnemployed
//         *
//         * Keys with values derived from CASKS09cDataRecord
//         * femalesAge16to24Unemployed
//         * femalesAge16to74
//         * femalesAge16to74EconomicallyActiveEmployed
//         * femalesAge16to74EconomicallyActiveUnemployed
//         * femalesAge50AndOverUnemployed
//         *
//         * tFitnessCounts[1] is a HashMap where;
//         * keys are Strings as in tFitnessCounts[0]
//         * values are all 0.
//         */
//        public HashMap<String, Integer> init_SARCounts() {
//            HashMap<String, Integer> a_SARCounts_HashMap = new HashMap<String, Integer>();
//            String s_malesAge0to4 = "malesAge0to4";
//            String s_malesAge5to9 = "malesAge5to9";
//            String s_malesAge10to14 = "malesAge10to14";
//            String s_malesAge15to19 = "malesAge15to19";
//            String s_malesAge20to24 = "malesAge20to24";
//            String s_malesAge25to29 = "malesAge25to29";
//            String s_malesAge30to34 = "malesAge30to34";
//            String s_malesAge35to39 = "malesAge35to39";
//            String s_malesAge40to44 = "malesAge40to44";
//            String s_malesAge45to49 = "malesAge45to49";
//            String s_malesAge50to54 = "malesAge50to54";
//            String s_malesAge55to59 = "malesAge55to59";
//            String s_malesAge60to64 = "malesAge60to64";
//            String s_malesAge65to69 = "malesAge65to69";
//            String s_malesAge70to74 = "malesAge70to74";
//            String s_malesAge75to79 = "malesAge75to79";
//            String s_malesAge80AndOver = "malesAge80AndOver";
//            a_SARCounts_HashMap.put(s_malesAge0to4, 0);
//            a_SARCounts_HashMap.put(s_malesAge5to9, 0);
//            a_SARCounts_HashMap.put(s_malesAge10to14, 0);
//            a_SARCounts_HashMap.put(s_malesAge15to19, 0);
//            a_SARCounts_HashMap.put(s_malesAge20to24, 0);
//            a_SARCounts_HashMap.put(s_malesAge25to29, 0);
//            a_SARCounts_HashMap.put(s_malesAge30to34, 0);
//            a_SARCounts_HashMap.put(s_malesAge35to39, 0);
//            a_SARCounts_HashMap.put(s_malesAge40to44, 0);
//            a_SARCounts_HashMap.put(s_malesAge45to49, 0);
//            a_SARCounts_HashMap.put(s_malesAge50to54, 0);
//            a_SARCounts_HashMap.put(s_malesAge55to59, 0);
//            a_SARCounts_HashMap.put(s_malesAge60to64, 0);
//            a_SARCounts_HashMap.put(s_malesAge65to69, 0);
//            a_SARCounts_HashMap.put(s_malesAge70to74, 0);
//            a_SARCounts_HashMap.put(s_malesAge75to79, 0);
//            a_SARCounts_HashMap.put(s_malesAge80AndOver, 0);
//            String s_femalesAge0to4 = "femalesAge0to4";
//            String s_femalesAge5to9 = "femalesAge5to9";
//            String s_femalesAge10to14 = "femalesAge10to14";
//            String s_femalesAge15to19 = "femalesAge15to19";
//            String s_femalesAge20to24 = "femalesAge20to24";
//            String s_femalesAge25to29 = "femalesAge25to29";
//            String s_femalesAge30to34 = "femalesAge30to34";
//            String s_femalesAge35to39 = "femalesAge35to39";
//            String s_femalesAge40to44 = "femalesAge40to44";
//            String s_femalesAge45to49 = "femalesAge45to49";
//            String s_femalesAge50to54 = "femalesAge50to54";
//            String s_femalesAge55to59 = "femalesAge55to59";
//            String s_femalesAge60to64 = "femalesAge60to64";
//            String s_femalesAge65to69 = "femalesAge65to69";
//            String s_femalesAge70to74 = "femalesAge70to74";
//            String s_femalesAge75to79 = "femalesAge75to79";
//            String s_femalesAge80AndOver = "femalesAge80AndOver";
//            a_SARCounts_HashMap.put(s_femalesAge0to4, 0);
//            a_SARCounts_HashMap.put(s_femalesAge5to9, 0);
//            a_SARCounts_HashMap.put(s_femalesAge10to14, 0);
//            a_SARCounts_HashMap.put(s_femalesAge15to19, 0);
//            a_SARCounts_HashMap.put(s_femalesAge20to24, 0);
//            a_SARCounts_HashMap.put(s_femalesAge25to29, 0);
//            a_SARCounts_HashMap.put(s_femalesAge30to34, 0);
//            a_SARCounts_HashMap.put(s_femalesAge35to39, 0);
//            a_SARCounts_HashMap.put(s_femalesAge40to44, 0);
//            a_SARCounts_HashMap.put(s_femalesAge45to49, 0);
//            a_SARCounts_HashMap.put(s_femalesAge50to54, 0);
//            a_SARCounts_HashMap.put(s_femalesAge55to59, 0);
//            a_SARCounts_HashMap.put(s_femalesAge60to64, 0);
//            a_SARCounts_HashMap.put(s_femalesAge65to69, 0);
//            a_SARCounts_HashMap.put(s_femalesAge70to74, 0);
//            a_SARCounts_HashMap.put(s_femalesAge75to79, 0);
//            a_SARCounts_HashMap.put(s_femalesAge80AndOver, 0);
//            String s_malesMarriedAge0to15 = "malesMarriedAge0to15";
//            String s_malesMarriedAge16to19 = "malesMarriedAge16to19";
//            String s_malesMarriedAge20to24 = "malesMarriedAge20to24";
//            String s_malesMarriedAge25to29 = "malesMarriedAge25to29";
//            String s_malesMarriedAge30to34 = "malesMarriedAge30to34";
//            String s_malesMarriedAge35to39 = "malesMarriedAge35to39";
//            String s_malesMarriedAge40to44 = "malesMarriedAge40to44";
//            String s_malesMarriedAge45to49 = "malesMarriedAge45to49";
//            String s_malesMarriedAge50to54 = "malesMarriedAge50to54";
//            String s_malesMarriedAge55to59 = "malesMarriedAge55to59";
//            String s_malesMarriedAge60to64 = "malesMarriedAge60to64";
//            String s_malesMarriedAge65to74 = "malesMarriedAge65to74";
//            String s_malesMarriedAge75to79 = "malesMarriedAge75to79";
//            String s_malesMarriedAge80AndOver = "malesMarriedAge80AndOver";
//            a_SARCounts_HashMap.put(s_malesMarriedAge0to15, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge16to19, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge20to24, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge25to29, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge30to34, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge35to39, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge40to44, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge45to49, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge50to54, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge55to59, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge60to64, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge65to74, 0);
//            a_SARCounts_HashMap.put(s_malesMarriedAge75to79, 0);
//            // _SARCounts.put( s_malesMarriedAge80to84, 0 );
//            // _SARCounts.put( s_malesMarriedAge85to89, 0 );
//            // _SARCounts.put( s_malesMarriedAge90AndOver, 0 );
//            a_SARCounts_HashMap.put(s_malesMarriedAge80AndOver, 0);
//            String s_femalesMarriedAge0to15 = "femalesMarriedAge0to15";
//            String s_femalesMarriedAge16to19 = "femalesMarriedAge16to19";
//            String s_femalesMarriedAge20to24 = "femalesMarriedAge20to24";
//            String s_femalesMarriedAge25to29 = "femalesMarriedAge25to29";
//            String s_femalesMarriedAge30to34 = "femalesMarriedAge30to34";
//            String s_femalesMarriedAge35to39 = "femalesMarriedAge35to39";
//            String s_femalesMarriedAge40to44 = "femalesMarriedAge40to44";
//            String s_femalesMarriedAge45to49 = "femalesMarriedAge45to49";
//            String s_femalesMarriedAge50to54 = "femalesMarriedAge50to54";
//            String s_femalesMarriedAge55to59 = "femalesMarriedAge55to59";
//            String s_femalesMarriedAge60to64 = "femalesMarriedAge60to64";
//            String s_femalesMarriedAge65to74 = "femalesMarriedAge65to74";
//            String s_femalesMarriedAge75to79 = "femalesMarriedAge75to79";
//            String s_femalesMarriedAge80AndOver = "femalesMarriedAge80AndOver";
//            a_SARCounts_HashMap.put(s_femalesMarriedAge0to15, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge16to19, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge20to24, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge25to29, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge30to34, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge35to39, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge40to44, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge45to49, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge50to54, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge55to59, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge60to64, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge65to74, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge75to79, 0);
//            a_SARCounts_HashMap.put(s_femalesMarriedAge80AndOver, 0);
//            // Initialise health variables from CASKS008DataRecord
//            String s_peopleWhoseGeneralHealthWasGood = "peopleWhoseGeneralHealthWasGood";
//            String s_peopleWhoseGeneralHealthWasFairlyGood = "peopleWhoseGeneralHealthWasFairlyGood";
//            String s_peopleWhoseGeneralHealthWasNotGood = "peopleWhoseGeneralHealthWasNotGood";
//            String s_peopleWithLimitingLongTermIllness = "peopleWithLimitingLongTermIllness";
//            a_SARCounts_HashMap.put(s_peopleWhoseGeneralHealthWasGood, 0);
//            a_SARCounts_HashMap.put(s_peopleWhoseGeneralHealthWasFairlyGood, 0);
//            a_SARCounts_HashMap.put(s_peopleWhoseGeneralHealthWasNotGood, 0);
//            a_SARCounts_HashMap.put(s_peopleWithLimitingLongTermIllness, 0);
//            // Initialise Household Composition variables from
//            // CASKS020DataRecord
//            String s_oneFamilyAndNoChildren = "oneFamilyAndNoChildren";
//            String s_marriedOrCohabitingCoupleWithChildren = "marriedOrCohabitingCoupleWithChildren";
//            String s_loneParentHouseholdsWithChildren = "loneParentHouseholdsWithChildren";
//            a_SARCounts_HashMap.put(s_oneFamilyAndNoChildren, 0);
//            a_SARCounts_HashMap.put(s_marriedOrCohabitingCoupleWithChildren, 0);
//            a_SARCounts_HashMap.put(s_loneParentHouseholdsWithChildren, 0);
//            // Initialise Employment variables from CASKS09bDataRecord
//            String s_malesAge16to24Unemployed = "malesAge16to24Unemployed";
//            String s_malesAge16to74 = "malesAge16to74";
//            String s_malesAge16to74EconomicallyActiveEmployed = "malesAge16to74EconomicallyActiveEmployed";
//            String s_malesAge16to74EconomicallyActiveUnemployed = "malesAge16to74EconomicallyActiveUnemployed";
//            String s_malesAge50AndOverUnemployed = "malesAge50AndOverUnemployed";
//            a_SARCounts_HashMap.put(s_malesAge16to24Unemployed, 0);
//            a_SARCounts_HashMap.put(s_malesAge16to74, 0);
//            a_SARCounts_HashMap.put(s_malesAge16to74EconomicallyActiveEmployed, 0);
//            a_SARCounts_HashMap.put(s_malesAge16to74EconomicallyActiveUnemployed, 0);
//            a_SARCounts_HashMap.put(s_malesAge50AndOverUnemployed, 0);
//            // Initialise Employment variables from CASKS09cDataRecord
//            String s_femalesAge16to24Unemployed = "femalesAge16to24Unemployed";
//            String s_femalesAge16to74 = "femalesAge16to74";
//            String s_femalesAge16to74EconomicallyActiveEmployed = "femalesAge16to74EconomicallyActiveEmployed";
//            String s_femalesAge16to74EconomicallyActiveUnemployed = "femalesAge16to74EconomicallyActiveUnemployed";
//            String s_femalesAge50AndOverUnemployed = "femalesAge50AndOverUnemployed";
//            a_SARCounts_HashMap.put(s_femalesAge16to24Unemployed, 0);
//            a_SARCounts_HashMap.put(s_femalesAge16to74, 0);
//            a_SARCounts_HashMap.put(s_femalesAge16to74EconomicallyActiveEmployed, 0);
//            a_SARCounts_HashMap.put(s_femalesAge16to74EconomicallyActiveUnemployed, 0);
//            a_SARCounts_HashMap.put(s_femalesAge50AndOverUnemployed, 0);
//            return a_SARCounts_HashMap;
//        }
//
//        public void addToCounts(
//                int _PeopleWhoseGeneralHealthWasGood,
//                int _PeopleWhoseGeneralHealthWasFairlyGood,
//                int _PeopleWhoseGeneralHealthWasNotGood,
//                int _PeopleWithLimitingLongTermIllness,
//                int _LoneParentHouseholdsWithChildren,
//                int _OneFamilyAndNoChildren,
//                int _MarriedOrCohabitingCoupleWithChildren,
//                int _FemalesAge0to4,
//                int _FemalesAge5to9,
//                int _FemalesAge10to14,
//                int _FemalesAge15to19,
//                int _FemalesAge20to24,
//                int _FemalesAge25to29,
//                int _FemalesAge30to34,
//                int _FemalesAge35to39,
//                int _FemalesAge40to44,
//                int _FemalesAge45to49,
//                int _FemalesAge50to54,
//                int _FemalesAge55to59,
//                int _FemalesAge60to64,
//                int _FemalesAge65to69,
//                int _FemalesAge70to74,
//                int _FemalesAge75to79,
//                int _FemalesAge80AndOver,
//                int _FemalesMarriedAge0to15,
//                int _FemalesMarriedAge16to19,
//                int _FemalesMarriedAge20to24,
//                int _FemalesMarriedAge25to29,
//                int _FemalesMarriedAge30to34,
//                int _FemalesMarriedAge35to39,
//                int _FemalesMarriedAge40to44,
//                int _FemalesMarriedAge45to49,
//                int _FemalesMarriedAge50to54,
//                int _FemalesMarriedAge55to59,
//                int _FemalesMarriedAge60to64,
//                int _FemalesMarriedAge65to74,
//                int _FemalesMarriedAge75to79,
//                int _FemalesMarriedAge80AndOver,
//                int _FemalesAge16to24Unemployed,
//                int _FemalesAge16to74,
//                int _FemalesAge16to74EconomicallyActiveEmployed,
//                int _FemalesAge16to74EconomicallyActiveUnemployed,
//                //int _FemalesAge16to74EconomicallyInactive,
//                int _FemalesAge50AndOverUnemployed,
//                int _MalesAge0to4,
//                int _MalesAge5to9,
//                int _MalesAge10to14,
//                int _MalesAge15to19,
//                int _MalesAge20to24,
//                int _MalesAge25to29,
//                int _MalesAge30to34,
//                int _MalesAge35to39,
//                int _MalesAge40to44,
//                int _MalesAge45to49,
//                int _MalesAge50to54,
//                int _MalesAge55to59,
//                int _MalesAge60to64,
//                int _MalesAge65to69,
//                int _MalesAge70to74,
//                int _MalesAge75to79,
//                int _MalesAge80AndOver,
//                int _MalesMarriedAge0to15,
//                int _MalesMarriedAge16to19,
//                int _MalesMarriedAge20to24,
//                int _MalesMarriedAge25to29,
//                int _MalesMarriedAge30to34,
//                int _MalesMarriedAge35to39,
//                int _MalesMarriedAge40to44,
//                int _MalesMarriedAge45to49,
//                int _MalesMarriedAge50to54,
//                int _MalesMarriedAge55to59,
//                int _MalesMarriedAge60to64,
//                int _MalesMarriedAge65to74,
//                int _MalesMarriedAge75to79,
//                int _MalesMarriedAge80AndOver,
//                int _MalesAge16to24Unemployed,
//                int _MalesAge16to74,
//                int _MalesAge16to74EconomicallyActiveEmployed,
//                int _MalesAge16to74EconomicallyActiveUnemployed,
//                //int _MalesAge16to74EconomicallyInactive,
//                int _MalesAge50AndOverUnemployed) {
//            this._PeopleWhoseGeneralHealthWasGood += _PeopleWhoseGeneralHealthWasGood;
//            this._PeopleWhoseGeneralHealthWasFairlyGood += _PeopleWhoseGeneralHealthWasFairlyGood;
//            this._PeopleWhoseGeneralHealthWasNotGood += _PeopleWhoseGeneralHealthWasNotGood;
//            this._PeopleWithLimitingLongTermIllness += _PeopleWithLimitingLongTermIllness;
//            // Household Composition:
//            this._LoneParentHouseholdsWithChildren += _LoneParentHouseholdsWithChildren;
//            this._OneFamilyAndNoChildren += _OneFamilyAndNoChildren;
//            this._MarriedOrCohabitingCoupleWithChildren += _MarriedOrCohabitingCoupleWithChildren;
//            // Female:
//            // Age:
//            this._FemalesAge0to4 += _FemalesAge0to4;
//            this._FemalesAge5to9 += _FemalesAge5to9;
//            this._FemalesAge10to14 += _FemalesAge10to14;
//            this._FemalesAge15to19 += _FemalesAge15to19;
//            this._FemalesAge20to24 += _FemalesAge20to24;
//            this._FemalesAge25to29 += _FemalesAge25to29;
//            this._FemalesAge30to34 += _FemalesAge30to34;
//            this._FemalesAge35to39 += _FemalesAge35to39;
//            this._FemalesAge40to44 += _FemalesAge40to44;
//            this._FemalesAge45to49 += _FemalesAge45to49;
//            this._FemalesAge50to54 += _FemalesAge50to54;
//            this._FemalesAge55to59 += _FemalesAge55to59;
//            this._FemalesAge60to64 += _FemalesAge60to64;
//            this._FemalesAge65to69 += _FemalesAge65to69;
//            this._FemalesAge70to74 += _FemalesAge70to74;
//            this._FemalesAge75to79 += _FemalesAge75to79;
//            this._FemalesAge80AndOver += _FemalesAge80AndOver;
//            // Marriage Age:
//            this._FemalesMarriedAge0to15 += _FemalesMarriedAge0to15;
//            this._FemalesMarriedAge16to19 += _FemalesMarriedAge16to19;
//            this._FemalesMarriedAge20to24 += _FemalesMarriedAge20to24;
//            this._FemalesMarriedAge25to29 += _FemalesMarriedAge25to29;
//            this._FemalesMarriedAge30to34 += _FemalesMarriedAge30to34;
//            this._FemalesMarriedAge35to39 += _FemalesMarriedAge35to39;
//            this._FemalesMarriedAge40to44 += _FemalesMarriedAge40to44;
//            this._FemalesMarriedAge45to49 += _FemalesMarriedAge45to49;
//            this._FemalesMarriedAge50to54 += _FemalesMarriedAge50to54;
//            this._FemalesMarriedAge55to59 += _FemalesMarriedAge55to59;
//            this._FemalesMarriedAge60to64 += _FemalesMarriedAge60to64;
//            this._FemalesMarriedAge65to74 += _FemalesMarriedAge65to74;
//            this._FemalesMarriedAge75to79 += _FemalesMarriedAge75to79;
//            this._FemalesMarriedAge80AndOver += _FemalesMarriedAge80AndOver;
//            // Economic Activity:
//            this._FemalesAge16to24Unemployed += _FemalesAge16to24Unemployed;
//            this._FemalesAge16to74 += _FemalesAge16to74;
//            this._FemalesAge16to74EconomicallyActiveEmployed += _FemalesAge16to74EconomicallyActiveEmployed;
//            this._FemalesAge16to74EconomicallyActiveUnemployed += _FemalesAge16to74EconomicallyActiveUnemployed;
//            //this._FemalesAge16to74EconomicallyInactive += _FemalesAge16to74EconomicallyInactive;
//            this._FemalesAge50AndOverUnemployed += _FemalesAge50AndOverUnemployed;
//            // Male:
//            // Age:
//            this._MalesAge0to4 += _MalesAge0to4;
//            this._MalesAge5to9 += _MalesAge5to9;
//            this._MalesAge10to14 += _MalesAge10to14;
//            this._MalesAge15to19 += _MalesAge15to19;
//            this._MalesAge20to24 += _MalesAge20to24;
//            this._MalesAge25to29 += _MalesAge25to29;
//            this._MalesAge30to34 += _MalesAge30to34;
//            this._MalesAge35to39 += _MalesAge35to39;
//            this._MalesAge40to44 += _MalesAge40to44;
//            this._MalesAge45to49 += _MalesAge45to49;
//            this._MalesAge50to54 += _MalesAge50to54;
//            this._MalesAge55to59 += _MalesAge55to59;
//            this._MalesAge60to64 += _MalesAge60to64;
//            this._MalesAge65to69 += _MalesAge65to69;
//            this._MalesAge70to74 += _MalesAge70to74;
//            this._MalesAge75to79 += _MalesAge75to79;
//            this._MalesAge80AndOver += _MalesAge80AndOver;
//            // Marriage Age:
//            this._MalesMarriedAge0to15 += _MalesMarriedAge0to15;
//            this._MalesMarriedAge16to19 += _MalesMarriedAge16to19;
//            this._MalesMarriedAge20to24 += _MalesMarriedAge20to24;
//            this._MalesMarriedAge25to29 += _MalesMarriedAge25to29;
//            this._MalesMarriedAge30to34 += _MalesMarriedAge30to34;
//            this._MalesMarriedAge35to39 += _MalesMarriedAge35to39;
//            this._MalesMarriedAge40to44 += _MalesMarriedAge40to44;
//            this._MalesMarriedAge45to49 += _MalesMarriedAge45to49;
//            this._MalesMarriedAge50to54 += _MalesMarriedAge50to54;
//            this._MalesMarriedAge55to59 += _MalesMarriedAge55to59;
//            this._MalesMarriedAge60to64 += _MalesMarriedAge60to64;
//            this._MalesMarriedAge65to74 += _MalesMarriedAge65to74;
//            this._MalesMarriedAge75to79 += _MalesMarriedAge75to79;
//            this._MalesMarriedAge80AndOver += _MalesMarriedAge80AndOver;
//            // Economic Activity:
//            this._MalesAge16to24Unemployed += _MalesAge16to24Unemployed;
//            this._MalesAge16to74 += _MalesAge16to74;
//            this._MalesAge16to74EconomicallyActiveEmployed += _MalesAge16to74EconomicallyActiveEmployed;
//            this._MalesAge16to74EconomicallyActiveUnemployed += _MalesAge16to74EconomicallyActiveUnemployed;
//            //this._MalesAge16to74EconomicallyInactive += _MalesAge16to74EconomicallyInactive;
//            this._MalesAge50AndOverUnemployed += _MalesAge50AndOverUnemployed;
//        }
//    }
}
