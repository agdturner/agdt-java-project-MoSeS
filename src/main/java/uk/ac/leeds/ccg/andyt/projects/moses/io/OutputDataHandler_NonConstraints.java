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
import uk.ac.leeds.ccg.andyt.census.cas.ks.Census_CASKS006DataRecord;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_IO;

/**
 * Class for handling output that compares some non-constraint variables in the
 * CAS and IndividualCensus outputs.
 */
public class OutputDataHandler_NonConstraints extends AbstractOutputDataHandler {

    public OutputDataHandler_NonConstraints() {
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
        String header = "_ZoneCode," + "_EthnicityWhite,_NoCarOwnershipHouseholds";
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
            Census_ISARDataHandler tISARDataHandler)
            throws IOException {
        this._OutputFile = new File(_OutputFileName);
        this._OutputFile.getParentFile().mkdir();
        _FileOutputStream = new FileOutputStream(_OutputFile);
        this._CASDataHandler = new Census_CASDataHandler(
                new File(_CASDataDirectory),
                "");
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
            Census_CASKS006DataRecord aCASKS006DataRecord;
            aCASKS006DataRecord = _CASDataRecord.getCASKS006DataRecord();
            _Counts._EthnicityWhite = _CASDataRecord.getCASKS006DataRecord().getWhiteOtherWhite()
                    + aCASKS006DataRecord.getWhiteWhiteBritish() + aCASKS006DataRecord.getWhiteWhiteIrish();
            _Counts._NoCarOwnershipHouseholds = _CASDataRecord.getCASKS017DataRecord().getHouseholdsWith0CarsOrVans();
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
        Census_CASDataRecord aCASDataRecord;
        int _EthnicityWhite;
        int _NoCarOwnershipHouseholds;
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
        short _HSARDataRecordETHEW;
        short _ISARDataRecordETHEW;
        short _ISARDataRecordETHN;
        short _ISARDataRecordETHS;
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
                    if (aToyModelDataRecord2.tHSARDataRecordID != -9) {
                        _HSARDataRecord = (Census_HSARDataRecord) tHSARDataHandler.getDataRecord(aToyModelDataRecord2.tHSARDataRecordID);
                        _HSARDataRecordETHEW = _HSARDataRecord.get_ETHEW();
                        if (_HSARDataRecordETHEW > 0 && _HSARDataRecordETHEW < 4) {
                            _EthnicityWhite = 1;
                        }
                        if (_HSARDataRecord.get_CARSH() == 0) {
                            if (_HSARDataRecord.get_HRP()) {
                                _NoCarOwnershipHouseholds = 1;
                            }
                        }
                    } else {
                        _ISARDataRecord = (Census_ISARDataRecord) tISARDataHandler.getDataRecord(
                                aToyModelDataRecord2.tISARDataRecordID);
                        _ISARDataRecordETHEW = _ISARDataRecord.get_ETHEW();
                        _ISARDataRecordETHN = _ISARDataRecord.get_ETHN();
                        _ISARDataRecordETHS = _ISARDataRecord.get_ETHS();
                        if (_ISARDataRecordETHEW == -9) {
                            if (_ISARDataRecordETHN == -9) {
                                if (_ISARDataRecordETHS < 5) {
                                    _EthnicityWhite = 1;
                                }
                            } else {
                                if (_ISARDataRecordETHN == 1) {
                                    _EthnicityWhite = 1;
                                }
                            }
                        } else {
                            if (_ISARDataRecordETHEW < 4) {
                                _EthnicityWhite = 1;
                            }
                        }
                    }
                    if (result.containsKey(aZoneCode)) {
                        _Counts = (Counts) result.get(aZoneCode);
                        result.remove(aZoneCode);
                        _Counts.addToCounts(_EthnicityWhite,
                                _NoCarOwnershipHouseholds);
                        result.put(aZoneCode, _Counts);
                    } else {
                        _Counts = new Counts();
                        _Counts.addToCounts(_EthnicityWhite,
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
        String record = _ZoneCode + "," + _Counts._EthnicityWhite + "," + _Counts._NoCarOwnershipHouseholds;
        System.out.println(record);
        this._FileOutputStream.write(record.getBytes());
        this._FileOutputStream.write(StreamTokenizer.TT_EOL);
        this._FileOutputStream.flush();
    }

    public class Counts {

        int _EthnicityWhite;
        int _NoCarOwnershipHouseholds;

        public Counts() {
            _EthnicityWhite = 0;
            _NoCarOwnershipHouseholds = 0;
        }

        public void addToCounts(int _EthnicityWhite,
                int _NoCarOwnershipHouseholds) {
            this._EthnicityWhite += _EthnicityWhite;
            this._NoCarOwnershipHouseholds += _NoCarOwnershipHouseholds;
        }
    }
}