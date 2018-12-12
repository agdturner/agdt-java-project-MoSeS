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
package uk.ac.leeds.ccg.andyt.projects.moses.process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.logging.Level;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataHandler;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS001DataHandler;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS001DataRecord;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS003DataHandler;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS003DataRecord;
import uk.ac.leeds.ccg.andyt.census.core.Census_CASDataHandler;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataHandler;
import uk.ac.leeds.ccg.andyt.projects.moses.io.ToyModelDataHandler;
import uk.ac.leeds.ccg.andyt.generic.logging.Generic_AbstractLog;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_IO;

/**
 * Abstract class
 */
public abstract class IndividualCensus extends Generic_AbstractLog {

    /**
     * This at minimum stores the fields for: _InitialPopulationSize;
     * _MaxNumberOfSolutions; _ConvergenceThreshold;
     * _MaxNumberOfMutationsPerChild; _MaxNumberOfMutationsPerParent;
     * _NumberOfOptimisationIterations;
     */
    public GeneticAlgorithm _GeneticAlgorithm;
    /**
     * Stores the base of file input/output
     */
    public File _Directory;
    /**
     * Stores the base of file input/output
     */
    // public File _InputDirectory;
    /**
     * Stores the Area being computed, this is usually usedin filenames. Often
     * used examples include "UK" and "Leeds"
     */
    public String _Area;
    /**
     * Stores the _CASLevel "OA" or "" is for Output Area "MSOA" is for Middle
     * Layer Super Output Area "Ward" is for Ward "LAD" is for Local Authority
     * District
     */
    public String _CASLevel;
    /**
     * Stores the output directory where the results are written
     */
    public File _OutputDirectory;
    /**
     * Stores the output directory name where the results are written
     */
    @Deprecated
    public String _OutputDirectory_Name;
    /**
     * Stores part of the name of the output file where the results are written
     */
    public String _OutputName;
//    /**
//     * Stores part of the name of the output file where the results are written
//     */
//    public String _OutputName1;
    /**
     * Reference to the File for storing Output0
     */
    protected File _Output_File_0;
    /**
     * Reference to the File for storing Output1
     */
    protected File _Output_File_1;
    /**
     * Reference to the ToyModelDataHandler for handling Toy Model data
     */
    protected ToyModelDataHandler _ToyModelDataHandler;
    /**
     * Reference to the File for reading Input
     */
    protected File _Input_File;
    /**
     * Stores the start time of the processing.
     */
    protected long _StartTime;
    /**
     * For holding a reference to the AbstractISARDataHandler
     */
    protected Census_ISARDataHandler _ISARDataHandler;
    /**
     * Stores the number of ISARDataRecords as a long
     */
    protected long _LongNumberOfISARDataRecords;
    /**
     * Stores the number of HSARDataRecords as a long
     */
    protected long _LongNumberOfHSARDataRecords;
    /**
     * Reference to the Census_CASDataHandler for handling CASDataRecords
     */
    protected Census_CASDataHandler _CASDataHandler;
    /**
     * Reference to the Census_CASDataHandler for handling CASDataRecords
     */
    //protected CASDataHandler_GA_IPS _CASDataHandler_GA_IPS;
    // /**
    // * Stores the seed for _Random
    // */
    // public long _RandomSeed;
    // /**
    // * Holds a reference to a Random instance
    // */
    // protected Random _Random;
    // HashSet to restrict variables included in fitness measure
    protected HashSet _IncludedVariablesHashSet;
    /**
     * A HashSet for storing a list of what are probably LAD codes. These are
     * the first 4 characters in the string _ZoneCode.
     */
    protected TreeSet _ZoneCodeSubstring_TreeSet;
    /**
     * A HashMap for storing population where: Each key is a String - first 4
     * digits of _ZoneCode; Each value is another HashMap where: Each key is the
     * String _ZoneCode; Each value is an Object[] _Pop where: _Pop[ 0 ] is a
     * Vector of _Household Population Household Reference Person Household SAR
     * RecordIDs; _Pop[ 1 ] is a Vector of _Communal Establishment Population
     * Individual SAR RecordIDs
     */
    protected HashMap _Population_HashMap;
    /**
     * Each key is a String and each value a long[2] keys are Census Area Codes
     * values are _StartRecordID_EndRecordID
     */
    protected HashMap _ZoneCode_StartRecordID_EndRecordID_HashMap;

    @Override
    public String toString() {
        String _Result = super.toString();
        _Result += "_Area " + this._Area;
        _Result += ", _CASLevel " + this._CASLevel;
        _Result += ", _OutputName " + this._OutputName;
        //_Result += ", _OutputName1 " + this._OutputName1;
        _Result += ", _CASDataHandler" + this._CASDataHandler;
        //_Result += ", _CASDataHandler_GA_IPS " + this._CASDataHandler_GA_IPS;
        _Result += ", _Directory " + this._Directory;
        _Result += ", _GeneticAlgorithm " + this._GeneticAlgorithm;
        _Result += ", _ISARDataHandler " + this._ISARDataHandler;
        _Result += ", _IncludedVariablesHashSet " + this._IncludedVariablesHashSet;
        _Result += ", _LongNumberOfHSARDataRecords " + this._LongNumberOfHSARDataRecords;
        _Result += ", _LongNumberOfISARDataRecords " + this._LongNumberOfISARDataRecords;
        _Result += ", _OutputDirectory " + this._OutputDirectory;
        _Result += ", _PopulationHashMap " + this._Population_HashMap;
        _Result += ", _StartTime " + this._StartTime;
        _Result += ", _ToyModelDataHandler " + this._ToyModelDataHandler;
        //_Result += ", _Output_file " + this._Output_File0;
        _Result += ", _ZoneCode_StartRecordID_EndRecordID_HashMap " + this._ZoneCode_StartRecordID_EndRecordID_HashMap;
        _Result += ", _ZoneCodeSubstring_TreeSet " + this._ZoneCodeSubstring_TreeSet;
        return _Result;
    }

    /**
     * For initialisation of this
     */
    public void init() {
        init_IncludedVariablesHashSet();
    }

    protected void initLogFile() {
        initLogFile(Level.FINE);
    }

    protected void initLogFile(
            Level aLevel) {
        String filename = "log.xml";
        init_Logger(
                aLevel,
                _OutputDirectory,
                filename);
    }

    protected void initLogFile(
            int log_int) {
        initLogFile(
                Level.FINE,
                log_int);
    }

    protected void initLogFile(
            Level aLevel,
            int log_int) {
        String filename = "log" + log_int + ".xml";
        init_Logger(
                aLevel,
                _OutputDirectory,
                filename);
    }

    protected boolean initOutputFiles() {
        _Logger.entering(
                this.getClass().getName(),
                "initOutputFiles()");
         /*
         * _OutputDirectory usually exists, but is changed when running for
         * multiple LADs
         */
        _OutputDirectory.mkdirs();
        String _OutputFilename;
        _OutputFilename = "population.csv";
        _Output_File_0 = new File(
                _OutputDirectory,
                _OutputFilename);
        if (_Output_File_0.exists()) {
            log("Result exists " + _Output_File_0);
            _Logger.exiting(
                    this.getClass().getName(),
                    "initOutputFiles()");
            return true;
        } else {
            try {
                _Output_File_0.createNewFile();
            } catch (IOException aIOException) {
                log(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        }
        // Initialise ToyModelDataHandler.
        init_ToyModelDataHandler(_Output_File_0);
        _OutputFilename = "population_HashMap.thisFile";
        _Output_File_1 = new File(
                _OutputDirectory,
                _OutputFilename);
        if (_Output_File_1.exists()) {
            log("Overwriting " + _Output_File_1);
        } else {
            try {
                _Output_File_1.createNewFile();
            } catch (IOException aIOException) {
                log(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        }
        _Logger.exiting(
                this.getClass().getName(),
                "initOutputFiles()");
        return false;
    }

    /**
     * For returning the _CASDataHandler to be used
     * @return 
     */
    public Census_AbstractDataHandler get_CASDataHandler() {
        return this._CASDataHandler;
    }

    /**
     * Initialise this._IncludedVariablesHashSet (if not already initialised),
     * then returns this._IncludedVariablesHashSet.
     * @return _IncludedVariablesHashSet
     */
    public HashSet init_IncludedVariablesHashSet() {
        if (_IncludedVariablesHashSet == null) {
            _IncludedVariablesHashSet = new HashSet();
            _IncludedVariablesHashSet.add("malesAge0to4");
            _IncludedVariablesHashSet.add("malesAge5to9");
            _IncludedVariablesHashSet.add("malesAge10to14");
            _IncludedVariablesHashSet.add("malesAge15to19");
            _IncludedVariablesHashSet.add("malesAge20to24");
            _IncludedVariablesHashSet.add("malesAge25to29");
            _IncludedVariablesHashSet.add("malesAge30to34");
            _IncludedVariablesHashSet.add("malesAge35to39");
            _IncludedVariablesHashSet.add("malesAge40to44");
            _IncludedVariablesHashSet.add("malesAge45to49");
            _IncludedVariablesHashSet.add("malesAge50to54");
            _IncludedVariablesHashSet.add("malesAge55to59");
            _IncludedVariablesHashSet.add("malesAge60to64");
            _IncludedVariablesHashSet.add("malesAge65to69");
            _IncludedVariablesHashSet.add("malesAge70to74");
            _IncludedVariablesHashSet.add("malesAge75to79");
            _IncludedVariablesHashSet.add("malesAge80AndOver");
            _IncludedVariablesHashSet.add("femalesAge0to4");
            _IncludedVariablesHashSet.add("femalesAge5to9");
            _IncludedVariablesHashSet.add("femalesAge10to14");
            _IncludedVariablesHashSet.add("femalesAge15to19");
            _IncludedVariablesHashSet.add("femalesAge20to24");
            _IncludedVariablesHashSet.add("femalesAge25to29");
            _IncludedVariablesHashSet.add("femalesAge30to34");
            _IncludedVariablesHashSet.add("femalesAge35to39");
            _IncludedVariablesHashSet.add("femalesAge40to44");
            _IncludedVariablesHashSet.add("femalesAge45to49");
            _IncludedVariablesHashSet.add("femalesAge50to54");
            _IncludedVariablesHashSet.add("femalesAge55to59");
            _IncludedVariablesHashSet.add("femalesAge60to64");
            _IncludedVariablesHashSet.add("femalesAge65to69");
            _IncludedVariablesHashSet.add("femalesAge70to74");
            _IncludedVariablesHashSet.add("femalesAge75to79");
            _IncludedVariablesHashSet.add("femalesAge80AndOver");
        }
        return _IncludedVariablesHashSet;
    }

    /**
     * Initialises _CASDataHandler
     * @param directory
     * The directory in which input data reside.
     * @param tCASLevel
     * The aggregate level of input data ("" for OA, "MSOA" for MSOA)
     */
    public void init_CASDataHandler(
            File directory,
            String tCASLevel) {
        this._CASDataHandler = new Census_CASDataHandler(
                directory,
                tCASLevel);
    }

    /**
     * Initialises _ISARDataHandler and _LongNumberOfISARDataRecords.
     * @param directory
     * The directory in which input data reside.
     * @throws java.io.IOException
     */
    public abstract void init_ISARDataHandler(
            File directory)
            throws IOException;

    /**
     * Initialises _ToyModelDataHandler
     * @param aFile
     * File for storing results.
     */
    public void init_ToyModelDataHandler(
            File aFile) {
        this._ToyModelDataHandler = new ToyModelDataHandler();
        try {
            this._ToyModelDataHandler._ToyModelFileOutputStream = new FileOutputStream(
                    aFile);
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    /**
     * @return Object[] _GeneralPopulationContraints:
 _GeneralPopulationContraints[0] is a HashMap
 _ZoneCode_AllHouseholdsTotal_HashMap with keys as String Zone_Code and
 values being Integer counts of Total Household Population from the
 respective Census_CAS003DataRecord.
 (Number of Households)
 _GeneralPopulationContraints[1] is a HashMap
 _ZoneCode_CommunalEstablishmentPopulation_HashMap with keys as String
 Zone_Code and values being Integer counts of Total Communal Establishment
 Population from the respective Census_CAS001DataRecord.
     */
    public Object[] loadGeneralPopulationContraints() {
        _Logger.entering(
                this.getClass().getName(),
                "loadGeneralPopulationContraints(){");
        Object[] _GeneralPopulationContraints = new Object[2];
        File _ZoneCode_AllHouseholdsTotal_HashMap_File = new File(
                _Directory,
                "_ZoneCode_AllHouseholdsTotal_HashMap.thisFile");
        File _ZoneCode_CommunalEstablishmentPopulation_HashMap_File = new File(
                _Directory,
                "_ZoneCode_CommunalEstablishmentPopulation_HashMap.thisFile");
        if (_ZoneCode_AllHouseholdsTotal_HashMap_File.exists() && _ZoneCode_CommunalEstablishmentPopulation_HashMap_File.exists()) {
            _GeneralPopulationContraints[0] = Generic_IO.readObject(_ZoneCode_AllHouseholdsTotal_HashMap_File);
            _GeneralPopulationContraints[1] = Generic_IO.readObject(_ZoneCode_CommunalEstablishmentPopulation_HashMap_File);
        } else {
            _GeneralPopulationContraints = getGeneralPopulationContraints();
            Generic_IO.writeObject(_GeneralPopulationContraints[0],
                    _ZoneCode_AllHouseholdsTotal_HashMap_File);
            Generic_IO.writeObject(_GeneralPopulationContraints[1],
                    _ZoneCode_CommunalEstablishmentPopulation_HashMap_File);
        }
        _Logger.exiting(
                this.getClass().getName(),
                "loadGeneralPopulationContraints(){");
        return _GeneralPopulationContraints;
    }

    /**
     * @return Object[] _Result where: _Result[ 0 ] is a HashMap of
     *         _ZoneCode_AllHouseholdsTotal_HashMap (Number of Households)
     *         _Result[ 1 ] is a HashMap of
     *         _ZoneCode_CommunalEstablishmentPopulation_HashMap (Population in
     *         Communal Establishments)
     */
    public Object[] getGeneralPopulationContraints() {
        long _StartRecordID = 0;
        long _EndRecordID = this.get_CASDataHandler().getNDataRecords() - 1L;
        return getGeneralPopulationContraints(_StartRecordID, _EndRecordID);
    }

    /**
     * @param _StartRecordID
     * @param _EndRecordID
     * @return Object[] _GeneralPopulationContraints:
 _GeneralPopulationContraints[0] is a HashMap
 _ZoneCode_AllHouseholdsTotal_HashMap with keys as String Zone_Code and
 values being Integer counts of Total Household Population from the
 respective Census_CAS003DataRecord.
 (Number of Households)
 _GeneralPopulationContraints[1] is a HashMap
 _ZoneCode_CommunalEstablishmentPopulation_HashMap with keys as String
 Zone_Code and values being Integer counts of Total Communal Establishment
 Population from the respective Census_CAS001DataRecord.
     */
    public Object[] getGeneralPopulationContraints(
            long _StartRecordID,
            long _EndRecordID) {
        _Logger.entering(
                this.getClass().getCanonicalName(),
                "getGeneralPopulationContraints(long,long)");
        Object[] _Result = new Object[2];
        String _ZoneCode;
        HashMap _ZoneCode_AllHouseholdsTotal_HashMap = new HashMap();
        HashMap _ZoneCode_CommunalEstablishmentPopulation_HashMap = new HashMap();
        int _AllHouseholdsTotal;
        int _CommunalEstablishmentPopulation;
        Census_CAS001DataRecord _CAS001DataRecord = null;
        Census_CAS003DataRecord _CAS003DataRecord = null;
        Census_CAS001DataHandler _CAS001DataHandler = this.get_CASDataHandler().getCAS001DataHandler();
        Census_CAS003DataHandler _CAS003DataHandler = this.get_CASDataHandler().getCAS003DataHandler();
        long _RecordID;
        for (_RecordID = _StartRecordID; _RecordID <= _EndRecordID; _RecordID++) {
            _CAS001DataRecord = _CAS001DataHandler.getCAS001DataRecord(_RecordID);
            _CAS003DataRecord = _CAS003DataHandler.getCAS003DataRecord(_RecordID);
            _ZoneCode = new String(_CAS003DataRecord.getZone_Code());
            // _RecordID = _CAS001DataRecord.getRecordID();
            _AllHouseholdsTotal = _CAS003DataRecord.getAllHouseholdsTotal();
            _CommunalEstablishmentPopulation = _CAS001DataRecord.getCommunalEstablishmentResidentsFemales() + _CAS001DataRecord.getCommunalEstablishmentResidentsMales();
            // _RecordIDZoneCodeHashMap.put( _RecordID, Zone_Code );
            _ZoneCode_AllHouseholdsTotal_HashMap.put(
                    _ZoneCode,
                    _AllHouseholdsTotal);
            _ZoneCode_CommunalEstablishmentPopulation_HashMap.put(
                    _ZoneCode, _CommunalEstablishmentPopulation);
            if (_RecordID % 10000 == 0) {
                log("Got populations totals for Record " + (_RecordID - _StartRecordID) + " out of " + (_EndRecordID - _StartRecordID));
            }
        }
        _Result[0] = _ZoneCode_AllHouseholdsTotal_HashMap;
        _Result[1] = _ZoneCode_CommunalEstablishmentPopulation_HashMap;
        _Logger.exiting(
                this.getClass().getCanonicalName(),
                "getGeneralPopulationContraints(long,long)");
        return _Result;
    }

    /**
     * Initialises this._ZoneCode_substring_HashSet
     */
    public void init_ZoneCodeSubstring_TreeSet() {
        try {
            _ZoneCodeSubstring_TreeSet = _CASDataHandler.getLADCodes_TreeSet();
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    public void init_Population_HashMap() {
        this._Population_HashMap = new HashMap();
    }

    public HashSet get_UK_OA_ID_HashSet() throws IOException {
        HashSet result = new HashSet();
        // Census_AbstractDataHandler _CASDataHandler = this.getCASDataHandler();
        long _NDataRecords = _CASDataHandler.getNDataRecords();
        System.out.println("_NDataRecords " + _NDataRecords);
        String _ZoneCode;
        for (long _RecordID = 0; _RecordID < _NDataRecords; _RecordID++) {
            _ZoneCode = new String(_CASDataHandler.getDataRecord(_RecordID).getZone_Code());
            System.out.println("_ZoneCode " + _ZoneCode);
            result.add(_ZoneCode);
        }
        return result;
    }

    /**
     * @return HashMap of RecordID keys and ZoneCode values where each key is
     *         entered as a long and each value is a String.
     */
    public HashMap get_RecordID_ZoneCode_HashMap() {
        long _StartRecordID = 0L;
        long _EndRecordID = this.get_CASDataHandler().getNDataRecords() - 1;
        return get_RecordID_ZoneCode_HashMap(_StartRecordID, _EndRecordID);
    }

    /**
     * @param _StartRecordID
     * @param _EndRecordID
     * @return HashMap of RecordID keys and ZoneCode values where each key is
     *         entered as a long and each value is a String.
     */
    public HashMap get_RecordID_ZoneCode_HashMap(long _StartRecordID,
            long _EndRecordID) {
        HashMap result = new HashMap();
        for (long _RecordID = _StartRecordID; _RecordID <= _EndRecordID; _RecordID++) {
            result.put(_RecordID, new String(this._CASDataHandler.getDataRecord(_RecordID).getZone_Code()));
        }
        return result;
    }

    /**
     * @param _StartRecordID
     * @param _EndRecordID
     * @return HashMap of ZoneCode keys and RecordID values
     * @throws java.io.IOException
     */
    public HashMap get_ZoneCode_RecordID_HashMap(
            long _StartRecordID,
            long _EndRecordID) throws IOException {
        HashMap result = new HashMap();
        for (long _RecordID = _StartRecordID; _RecordID <= _EndRecordID; _RecordID++) {
            result.put(new String(this._CASDataHandler.getDataRecord(_RecordID).getZone_Code()), _RecordID);
        }
        return result;
    }

    public void init_ZoneCode_StartRecordID_EndRecordID_HashMap() {
        // try to load from file
        File _ZoneCode_StartRecordID_EndRecordID_HashMap_File = new File(
                this._Directory.toString() + System.getProperty("file.separator") +
                "ZoneCode_StartRecordID_EndRecordID_HashMap.thisFile");
        if (_ZoneCode_StartRecordID_EndRecordID_HashMap_File.exists()) {
            _ZoneCode_StartRecordID_EndRecordID_HashMap = (HashMap) Generic_IO.readObject(_ZoneCode_StartRecordID_EndRecordID_HashMap_File);
        } else {
            _ZoneCode_StartRecordID_EndRecordID_HashMap = new HashMap();
            long[] _StartRecordID_EndRecordID;
            HashMap _RecordID_ZoneCode_HashMap = get_RecordID_ZoneCode_HashMap();
            Iterator _Iterator = _RecordID_ZoneCode_HashMap.keySet().iterator();
            Object key0;
            Object key1;
            Object value0;
            Object value1;
            long _RecordID;
            String _ZoneCode;
            String _ZoneCode_Substring;
            while (_Iterator.hasNext()) {
                key0 = _Iterator.next();
                _RecordID = (Long) key0;
                value0 = _RecordID_ZoneCode_HashMap.get(key0);
                key1 = value0;
                // For OA
                value1 = _ZoneCode_StartRecordID_EndRecordID_HashMap.get(key1);
                if (value1 == null) {
                    _StartRecordID_EndRecordID = new long[2];
                    _StartRecordID_EndRecordID[0] = _RecordID;
                    _StartRecordID_EndRecordID[1] = _RecordID;
                    _ZoneCode_StartRecordID_EndRecordID_HashMap.put(key1,
                            _StartRecordID_EndRecordID);
                } else {
                    _StartRecordID_EndRecordID = (long[]) value1;
                    _StartRecordID_EndRecordID[0] = Math.min(
                            _StartRecordID_EndRecordID[0], _RecordID);
                    _StartRecordID_EndRecordID[1] = Math.max(
                            _StartRecordID_EndRecordID[1], _RecordID);
                    _ZoneCode_StartRecordID_EndRecordID_HashMap.put(key1,
                            _StartRecordID_EndRecordID);
                }
                // For LAD
                _ZoneCode = (String) value0;
                _ZoneCode_Substring = _ZoneCode.substring(0, 4);
                value1 = _ZoneCode_StartRecordID_EndRecordID_HashMap.get(_ZoneCode_Substring);
                if (value1 == null) {
                    _StartRecordID_EndRecordID = new long[2];
                    _StartRecordID_EndRecordID[0] = _RecordID;
                    _StartRecordID_EndRecordID[1] = _RecordID;
                    _ZoneCode_StartRecordID_EndRecordID_HashMap.put(
                            _ZoneCode_Substring, _StartRecordID_EndRecordID);
                } else {
                    _StartRecordID_EndRecordID = (long[]) value1;
                    _StartRecordID_EndRecordID[0] = Math.min(
                            _StartRecordID_EndRecordID[0], _RecordID);
                    _StartRecordID_EndRecordID[1] = Math.max(
                            _StartRecordID_EndRecordID[1], _RecordID);
                    _ZoneCode_StartRecordID_EndRecordID_HashMap.put(
                            _ZoneCode_Substring, _StartRecordID_EndRecordID);
                }
            }
            Generic_IO.writeObject(_ZoneCode_StartRecordID_EndRecordID_HashMap,
                    _ZoneCode_StartRecordID_EndRecordID_HashMap_File);
        }
    }

    /**
     * Find _StartRecordID and _EndRecordID for _LADCode
     * @param _ZoneCode
     * @return 
     */
    public long[] get_StartRecordID_EndRecordID(String _ZoneCode) {
        if (_ZoneCode_StartRecordID_EndRecordID_HashMap == null) {
            init_ZoneCode_StartRecordID_EndRecordID_HashMap();
        }
        Object value = _ZoneCode_StartRecordID_EndRecordID_HashMap.get(_ZoneCode);
        long[] _StartRecordID_EndRecordID = (long[]) value;
        return _StartRecordID_EndRecordID;
    }

    public void output_Population_HashMap() {
        Generic_IO.writeObject(
                _Population_HashMap,
                _Output_File_1);
    }

    public void load_Population_HashMap() {
        _Logger.entering(
                this.getClass().getName(),
                "load_Population_HashMap");
        _Population_HashMap = (HashMap) Generic_IO.readObject(_Input_File);
        _Logger.exiting(
                this.getClass().getName(),
                "load_Population_HashMap");
    }
}