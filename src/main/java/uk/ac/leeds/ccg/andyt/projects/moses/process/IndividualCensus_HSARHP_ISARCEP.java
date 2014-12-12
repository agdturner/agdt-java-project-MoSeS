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
import java.io.IOException;
import java.io.StreamTokenizer;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CAS001DataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CAS003DataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CASDataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.HSARDataHandler;
import uk.ac.leeds.ccg.andyt.projects.moses.io.HSARDataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataHandler;
import uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataHandler.AgeSexType;
import uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.misc.AgeConverter;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;
import uk.ac.leeds.ccg.andyt.projects.moses.io.ParameterFileParser;

public abstract class IndividualCensus_HSARHP_ISARCEP extends IndividualCensus {

    public HSARDataHandler _HSARDataHandler;

    public void init(
            File _Input_Parameter_File) {
        Object[] _Input_Parameters = ParameterFileParser.parse(_Input_Parameter_File);
        _Directory = (File) _Input_Parameters[0];
        _Area = (String) _Input_Parameters[1];
        _CASLevel = (String) _Input_Parameters[2];
        if (_CASLevel.equalsIgnoreCase("")) {
            _OutputName = "OA_HSARHP_ISARCEP" + "_" + (String) _Input_Parameters[10];
        } else {
            _OutputName = _CASLevel + "_HSARHP_ISARCEP" + "_" + (String) _Input_Parameters[10];
        }
        int _InitialPopulationSize = (Integer) _Input_Parameters[3];
        int _NumberOfOptimisationIterations = (Integer) _Input_Parameters[4];
        int _MaxNumberOfSolutions = (Integer) _Input_Parameters[5];
        int _ConvergenceThreshold = (Integer) _Input_Parameters[6];
        int _MaxNumberOfMutationsPerChild = (Integer) _Input_Parameters[7];
        int _MaxNumberOfMutationsPerParent = (Integer) _Input_Parameters[8];
        long _RandomSeed = (Long) _Input_Parameters[9];
        _GeneticAlgorithm = new GeneticAlgorithm(
                _InitialPopulationSize,
                _NumberOfOptimisationIterations,
                _MaxNumberOfSolutions,
                _ConvergenceThreshold,
                _MaxNumberOfMutationsPerChild,
                _MaxNumberOfMutationsPerParent,
                _RandomSeed);
        try {
            _OutputDirectory = new File(
                    _Directory.getCanonicalPath() +
                    System.getProperty("file.separator") + "Output" +
                    System.getProperty("file.separator") + _OutputName +
                    System.getProperty("file.separator") + _Area);
        } catch (IOException _IOException) {
            log(_IOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        if (!_OutputDirectory.exists()) {
            _OutputDirectory.mkdirs();
        }
        initLogFile();
        initOutputFiles();
        // Copy Parameter file to _OutputDirectory as metadata
        Generic_StaticIO.copy(
                _Input_Parameter_File,
                _OutputDirectory);
        // Initialise _InputFile
        _Input_File = new File((String) _Input_Parameters[11] + "population_HashMap.thisFile");
        // if _InputFile.exists() then this run will be loading in a prior result and re-optimising
        if (_Input_File.exists()) {
            load_Population_HashMap();
        } else {
            _Population_HashMap = new HashMap();
        }
        // Initialise CASDataHandler.
        init_CASDataHandler(_Directory, _CASLevel);
        // Initialise ISARDataHandler.
        init_ISARDataHandler(_Directory);
        // Initialise ISARDataHandler.
        init_HSARDataHandler(_Directory);
        // Initialise ToyModelDataHandler.
        init_ToyModelDataHandler(_Output_File_0);
    }

    public void init(
            IndividualCensus_HSARHP_ISARCEP _IndividualCensus_HSARHP_ISARCEP) {
        this._CASDataHandler = _IndividualCensus_HSARHP_ISARCEP._CASDataHandler;
        this._CASLevel = _IndividualCensus_HSARHP_ISARCEP._CASLevel;
        this._GeneticAlgorithm = _IndividualCensus_HSARHP_ISARCEP._GeneticAlgorithm;
        this._IncludedVariablesHashSet = _IndividualCensus_HSARHP_ISARCEP._IncludedVariablesHashSet;
        this._Directory = _IndividualCensus_HSARHP_ISARCEP._Directory;
        this._ISARDataHandler = _IndividualCensus_HSARHP_ISARCEP._ISARDataHandler;
        this._HSARDataHandler = _IndividualCensus_HSARHP_ISARCEP._HSARDataHandler;
        this._LongNumberOfHSARDataRecords = _IndividualCensus_HSARHP_ISARCEP._LongNumberOfHSARDataRecords;
        this._LongNumberOfISARDataRecords = _IndividualCensus_HSARHP_ISARCEP._LongNumberOfISARDataRecords;
        this._OutputDirectory = _IndividualCensus_HSARHP_ISARCEP._OutputDirectory;
        this._OutputName = _IndividualCensus_HSARHP_ISARCEP._OutputName;
        this._StartTime = _IndividualCensus_HSARHP_ISARCEP._StartTime;
        this._ToyModelDataHandler = _IndividualCensus_HSARHP_ISARCEP._ToyModelDataHandler;
    }

    public Object[] getConstraints_HSARHP_ISARCEP(
            CASDataRecord aCASDataRecord) {
        Object[] constraints = new Object[4];
        CAS001DataRecord aCAS001DataRecord = aCASDataRecord.getCAS001DataRecord();
        CAS003DataRecord aCAS003DataRecord = aCASDataRecord.getCAS003DataRecord();
        /*
         * constraintCAS003HPHRPAgeFemaleCount_HashMap
         * constraintCAS003HPHRPAgeFemaleCount_HashMap
         * Provide counts for the following ages:
         * 0,20,30,60
         */
        HashMap constraintCAS003HPHRPAgeFemaleCount_HashMap =
                _CASDataHandler.getCAS003DataHandler().getCAS003HPHRPAgeFemaleCount_HashMap(
                aCAS003DataRecord);
        HashMap constraintCAS003HPHRPAgeMaleCount_HashMap =
                _CASDataHandler.getCAS003DataHandler().getCAS003HPHRPAgeMaleCount_HashMap(
                aCAS003DataRecord);
        /*
         * aCAS001AgeCountFemaleCEPHashMap3
         * aCAS001AgeCountMaleCEPHashMap3
         * Provide counts for the following ages:
         * 0,16,20,25,30,45,60,65,75,85,90
         */
        HashMap constraintCAS001CEPAgeFemaleCount3_HashMap =
                _CASDataHandler.getCAS001DataHandler().getCAS001CEPAgeFemaleCount4_HashMap(
                aCAS001DataRecord);
        HashMap constraintCAS001CEPAgeMaleCount3_HashMap =
                _CASDataHandler.getCAS001DataHandler().getCAS001CEPAgeMaleCount4_HashMap(
                aCAS001DataRecord);
        constraints[0] = constraintCAS003HPHRPAgeFemaleCount_HashMap;
        constraints[1] = constraintCAS003HPHRPAgeMaleCount_HashMap;
        constraints[2] = constraintCAS001CEPAgeFemaleCount3_HashMap;
        constraints[3] = constraintCAS001CEPAgeMaleCount3_HashMap;
        return constraints;
    }

    /**
     * @return An Object[] tConstraintsAndPopulation_HSARHP_ISARCEP:
     * tConstraintsAndPopulation_HSARHP_ISARCEP[0] constraints:
     * constraints[0] = constraintCAS003HPHRPAgeFemaleCount_HashMap;
     * constraints[1] = constraintCAS003HPHRPAgeMaleCount_HashMap;
     * constraints[2] = constraintCAS001CEPAgeFemaleCount3_HashMap;
     * constraints[3] = constraintCAS001CEPAgeMaleCount3_HashMap;
     * tConstraintsAndPopulation_HSARHP_ISARCEP[2] population:
     * population[0] = tHPHRPFemale_Age_Vector_HashMap;
     * population[1] = tHPHRPFemale_Vector;
     * population[2] = tHPHRPMale_Age_Vector_HashMap;
     * population[3] = tHPHRPMale_Vector;
     * population[4] = tCEPFemale_Age_Vector_HashMap;
     * population[5] = tCEPFemale_Vector;
     * population[6] = tCEPMale_Age_Vector_HashMap;
     * population[7] = tCEPMale_Vector;
     * @param aCASDataRecord
     *            The CASDataRecord being processed.
     */
    public Object[] getConstraintsAndPopulation_HSARHP_ISARCEP(
            CASDataRecord aCASDataRecord) {
        _Logger.entering(
                this.getClass().getName(),
                "getConstraintsAndPopulation_HSARHP_ISARCEP(CASDataRecord)");
        Random aRandom = this._GeneticAlgorithm._Random;
        // Initialise result
        Object[] result = new Object[2];
        Object[] constraints = getConstraints_HSARHP_ISARCEP(aCASDataRecord);
        HashMap constraintCAS003HPHRPAgeFemaleCount_HashMap = (HashMap) constraints[0];
        HashMap constraintCAS003HPHRPAgeMaleCount_HashMap = (HashMap) constraints[1];
        HashMap constraintCAS001CEPAgeFemaleCount3_HashMap = (HashMap) constraints[2];
        HashMap constraintCAS001CEPAgeMaleCount3_HashMap = (HashMap) constraints[3];
        Object[] population = new Object[9];
        result[0] = constraints;
        result[1] = population;
        HashMap tHPHRPFemale_Age_Vector_HashMap = new HashMap();
        Vector tHPHRPFemale_Vector = new Vector();
        HashMap tHPHRPMale_Age_Vector_HashMap = new HashMap();
        Vector tHPHRPMale_Vector = new Vector();
        HashMap tCEPFemale_Age_Vector_HashMap = new HashMap();
        Vector tCEPFemale_Vector = new Vector();
        HashMap tCEPMale_Age_Vector_HashMap = new HashMap();
        Vector tCEPMale_Vector = new Vector();
        population[0] = tHPHRPFemale_Age_Vector_HashMap;
        population[1] = tHPHRPFemale_Vector;
        population[2] = tHPHRPMale_Age_Vector_HashMap;
        population[3] = tHPHRPMale_Vector;
        population[4] = tCEPFemale_Age_Vector_HashMap;
        population[5] = tCEPFemale_Vector;
        population[6] = tCEPMale_Age_Vector_HashMap;
        population[7] = tCEPMale_Vector;
        Iterator iterator;
        Object key;
        //Object value;
        int age;
        boolean sex;
        short type;
        HSARDataHandler.AgeSex aAgeSex;
        HSARDataRecord aHSARDataRecord;
        ISARDataHandler.AgeSexType aAgeSexType;
        ISARDataRecord aISARDataRecord;
        int aConstraint;

        log("Initialise tHPHRPFemale_Age_Vector_HashMap and tHPHRPFemale_Vector.");
        // 0,20,30,60
        int tHPHRPFemaleCount = 0;
        sex = false;
        type = 1;
        iterator = constraintCAS003HPHRPAgeFemaleCount_HashMap.keySet().iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            age = (Short) key;
            aConstraint = (Integer) constraintCAS003HPHRPAgeFemaleCount_HashMap.get(key);
            if (aConstraint > 0) {
                Vector aHSARDataRecord_Vector = new Vector();
                tHPHRPFemale_Age_Vector_HashMap.put(
                        key,
                        aHSARDataRecord_Vector);
                while (aHSARDataRecord_Vector.size() < aConstraint) {
                    boolean constrained = false;
                    int iterationCount = 0;
                    do {
                        aAgeSex = _HSARDataHandler.new AgeSex(
                                (short) AgeConverter.getAgeClassHSARDataRecord(
                                AgeConverter.getAge5(age, aRandom)),
                                sex);
                        aHSARDataRecord = _HSARDataHandler.getHSARDataRecord(
                                aRandom,
                                aAgeSex);
                        if (aHSARDataRecord != null) {
                            aHSARDataRecord_Vector.add(aHSARDataRecord);
                            tHPHRPFemale_Vector.add(aHSARDataRecord);
                            constrained = true;
                            tHPHRPFemaleCount++;
                        } else {
                            iterationCount++;
                        }
                        if (iterationCount > 1000) {
                            log("Getting stuck initialising tHPHRPFemale_Age_Vector_HashMap" +
                                    " for age " + age +
                                    " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code()) +
                                    " iterationCount = " + iterationCount);
                            System.exit(Generic_ErrorAndExceptionHandler.Error);
                        }
                    } while (!constrained);
                }
            }
        }
        constraints[1] = tHPHRPFemaleCount;

        log("Assigned " + tHPHRPFemaleCount + " in tHPHRPFemale_Age_Vector_HashMap");

        log("Initialise tHPHRPMale_Age_Vector_HashMap and tHPHRPMale_Vector.");
        // 0,20,30,60
        int tHPHRPMaleCount = 0;
        sex = false;
        type = 1;
        iterator = constraintCAS003HPHRPAgeMaleCount_HashMap.keySet().iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            age = (Short) key;
            aConstraint = (Integer) constraintCAS003HPHRPAgeMaleCount_HashMap.get(key);
            if (aConstraint > 0) {
                Vector aHSARDataRecord_Vector = new Vector();
                tHPHRPMale_Age_Vector_HashMap.put(
                        key,
                        aHSARDataRecord_Vector);
                while (aHSARDataRecord_Vector.size() < aConstraint) {
                    boolean constrained = false;
                    int iterationCount = 0;
                    do {
                        aAgeSex = _HSARDataHandler.new AgeSex(
                                (short) AgeConverter.getAgeClassHSARDataRecord(
                                AgeConverter.getAge5(age, aRandom)),
                                sex);
                        aHSARDataRecord = _HSARDataHandler.getHSARDataRecord(
                                aRandom,
                                aAgeSex);
                        if (aHSARDataRecord != null) {
                            aHSARDataRecord_Vector.add(aHSARDataRecord);
                            tHPHRPMale_Vector.add(aHSARDataRecord);
                            constrained = true;
                            tHPHRPMaleCount++;
                        } else {
                            iterationCount++;
                        }
                        if (iterationCount > 1000) {
                            log("Getting stuck initialising tHPHRPMale_Age_Vector_HashMap" +
                                    " for age " + age +
                                    " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code()) +
                                    " iterationCount = " + iterationCount);
                            System.exit(Generic_ErrorAndExceptionHandler.Error);
                        }
                    } while (!constrained);
                }
            }
        }
        log("Assigned " + tHPHRPMaleCount + " in tHPHRPMale_Age_Vector_HashMap");

        log("Initialise tCEPFemale_Age_Vector_HashMap and tCEPFemale_Vector.");
        // 0-15,16,20,25,30,45,60,65,75,85,90
        int tCEPFemaleCount = 0;
        sex = false;
        type = 3;
        iterator = constraintCAS001CEPAgeFemaleCount3_HashMap.keySet().iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            age = (Integer) key;
            aConstraint = (Integer) constraintCAS001CEPAgeFemaleCount3_HashMap.get(key);
            if (aConstraint > 0) {
                Vector aISARDataRecord_Vector = new Vector();
                tCEPFemale_Age_Vector_HashMap.put(
                        key,
                        aISARDataRecord_Vector);
                while (aISARDataRecord_Vector.size() < aConstraint) {
                    boolean constrained = false;
                    int iterationCount = 0;
                    do {
                        aAgeSexType = _ISARDataHandler.new AgeSexType(
                                (short) AgeConverter.getAgeClassISARDataRecord(
                                AgeConverter.getAge7(age, aRandom)),
                                sex,
                                type);
                        aISARDataRecord = _ISARDataHandler.getISARDataRecord(
                                aRandom,
                                aAgeSexType);
                        if (aISARDataRecord != null) {
                            aISARDataRecord_Vector.add(aISARDataRecord);
                            tCEPFemale_Vector.add(aISARDataRecord);
                            constrained = true;
                            tCEPFemaleCount++;
                        } else {
                            iterationCount++;
                        }
                        if (iterationCount > 1000) {
                            type = 2;
                            if (iterationCount == 1001) {
                                log("Getting stuck initialising tCEPFemale_Age_Vector_HashMap" +
                                        " for age " + age +
                                        " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code()) +
                                        " iterationCount = " + iterationCount +
                                        " trying type = " + type);
                            }
                            if (iterationCount > 2000) {
                                type = 1;
                                if (iterationCount == 2001) {
                                    log("Getting stuck initialising tCEPFemale_Age_Vector_HashMap" +
                                            " for age " + age +
                                            " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code()) +
                                            " iterationCount = " + iterationCount +
                                            " trying type = " + type);
                                }
                                if (iterationCount > 3001) {
                                    log("Getting stuck initialising tCEPFemale_Age_Vector_HashMap" +
                                            " for age " + age +
                                            " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code()) +
                                            " iterationCount = " + iterationCount);
                                  System.exit(Generic_ErrorAndExceptionHandler.Error);
                                }
                            }
                        }
                    } while (!constrained);
                }
            }
        }
        log("Assigned " + tCEPFemaleCount + " to tCEPFemale_Age_Vector_HashMap.");

        log("Initialise tCEPMale_Age_Vector_HashMap and tCEPMale_Vector.");
        // 0,5,8,10,15,16,20,25,30,45,60,65,75,85,90
        int tCEPMaleCount = 0;
        sex = false;
        type = 3;
        iterator = constraintCAS001CEPAgeMaleCount3_HashMap.keySet().iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            age = (Integer) key;
            aConstraint = (Integer) constraintCAS001CEPAgeMaleCount3_HashMap.get(key);
            if (aConstraint > 0) {
                Vector aISARDataRecord_Vector = new Vector();
                tCEPMale_Age_Vector_HashMap.put(
                        key,
                        aISARDataRecord_Vector);
                while (aISARDataRecord_Vector.size() < aConstraint) {
                    boolean constrained = false;
                    int iterationCount = 0;
                    do {
                        aAgeSexType = _ISARDataHandler.new AgeSexType(
                                (short) AgeConverter.getAgeClassISARDataRecord(
                                AgeConverter.getAge7(age, aRandom)),
                                sex,
                                type);
                        aISARDataRecord = _ISARDataHandler.getISARDataRecord(
                                aRandom,
                                aAgeSexType);
                        if (aISARDataRecord != null) {
                            aISARDataRecord_Vector.add(aISARDataRecord);
                            tCEPMale_Vector.add(aISARDataRecord);
                            tCEPMaleCount++;
                            constrained = true;
                        } else {
                            iterationCount++;
                        }
                        if (iterationCount > 1000) {
                            type = 2;
                            if (iterationCount == 1001) {
                                log("Getting stuck initialising tCEPMale_Age_Vector_HashMap" +
                                        " for age " + age +
                                        " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code()) +
                                        " iterationCount = " + iterationCount +
                                        " trying type = " + type);
                            }
                            if (iterationCount > 2000) {
                                type = 1;
                                if (iterationCount == 2001) {
                                    log("Getting stuck initialising tCEPMale_Age_Vector_HashMap" +
                                            " for age " + age +
                                            " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code()) +
                                            " iterationCount = " + iterationCount +
                                            " trying type = " + type);
                                }
                                if (iterationCount > 3001) {
                                    log("Getting stuck initialising tCEPMale_Age_Vector_HashMap" +
                                            " for age " + age +
                                            " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code()) +
                                            " iterationCount = " + iterationCount);
                                System.exit(Generic_ErrorAndExceptionHandler.Error);
                                }
                            }
                        }
                    } while (!constrained);
                }
            }
        }
        log("Assigned " + tCEPMaleCount + " to tCEPMale_Age_Vector_HashMap");
        _Logger.exiting(
                this.getClass().getName(),
                "getConstraintsAndPopulation_HSARHP_ISARCEP(CASDataRecord)");

        return result;
    }

    /**
     * Initialises _ISARDataHandler and _LongNumberOfISARDataRecords
     * @param directory
     * The directory from which ISARDataHandler is loaded.
     */
    public void init_ISARDataHandler(
            File directory) {
        _Logger.entering(
                this.getClass().getName(),
                "init_ISARDataHandler(File)");
        File file = new File(
                directory,
                ISARDataHandler.class.getCanonicalName() + ".thisFile");
        this._ISARDataHandler = new ISARDataHandler(file);
        this._LongNumberOfISARDataRecords = this._ISARDataHandler.getNDataRecords();
        _Logger.exiting(
                this.getClass().getName(),
                "init_ISARDataHandler(File)");
    }

    /**
     * Initialises _HSARDataHandler and _LongNumberOfHSARDataRecords
     * @param directory
     * The directory from which HSARDataHandler is loaded.
     */
    public void init_HSARDataHandler(
            File directory) {
        _Logger.entering(
                this.getClass().getName(),
                "init_HSARDataHandler(File)");
        File file = new File(
                directory,
                HSARDataHandler.class.getCanonicalName() + ".thisFile");
        this._HSARDataHandler = new HSARDataHandler(file);
        this._LongNumberOfHSARDataRecords = this._HSARDataHandler.getNDataRecords();
        _Logger.exiting(
                this.getClass().getName(),
                "init_ISARDataHandler(File)");
    }

    /**
     * @param population Object[]:
     * population[0] = tHPHRPFemale_AgeSexType_Vector_HashMap;
     * population[1] = tHPHRPFemale_Vector;
     * population[2] = tHPHRPMale_AgeSexType_Vector_HashMap;
     * population[3] = tHPHRPMale_Vector;
     * population[4] = tCEPFemale_AgeSexType_Vector_HashMap;
     * population[5] = tCEPFemale_Vector;
     * population[6] = tCEPMale_AgeSexType_Vector_HashMap;
     * population[7] = tCEPMale_Vector;
     * @param aCASDataRecord
     * @param fitness
     */
    public void write_HSARHP_ISARCEP(
            Object[] population,
            CASDataRecord aCASDataRecord,
            BigDecimal fitness) {
        _Logger.entering(
                this.getClass().getCanonicalName(),
                "write_HSARHP_ISARCEP(Object[],CASDataRecord,BigDecimal)");
        String line;
        String aZoneCode = new String(aCASDataRecord.getZone_Code());
        Vector tHPHRPFemale_Vector = (Vector) population[1];
        for (int i = 0; i < tHPHRPFemale_Vector.size(); i++) {
            line = aZoneCode +
                    ",HP," +
                    ((HSARDataRecord) tHPHRPFemale_Vector.elementAt(i)).get_HHID();
            try {
                this._ToyModelDataHandler._ToyModelFileOutputStream.write(line.getBytes());
                this._ToyModelDataHandler._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
            } catch (IOException aIOException) {
                log(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        }
        Vector tHPHRPMale_Vector = (Vector) population[3];
        for (int i = 0; i < tHPHRPMale_Vector.size(); i++) {
            line = aZoneCode +
                    ",HP," +
                    ((HSARDataRecord) tHPHRPMale_Vector.elementAt(i)).get_HHID();
            try {
                this._ToyModelDataHandler._ToyModelFileOutputStream.write(line.getBytes());
                this._ToyModelDataHandler._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
            } catch (IOException aIOException) {
                log(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        }
        Vector tCEPFemale_Vector = (Vector) population[5];
        for (int i = 0; i < tCEPFemale_Vector.size(); i++) {
            line = aZoneCode +
                    ",CEP," +
                    ((ISARDataRecord) tCEPFemale_Vector.elementAt(i)).get_ID();
            try {
                this._ToyModelDataHandler._ToyModelFileOutputStream.write(line.getBytes());
                this._ToyModelDataHandler._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
            } catch (IOException aIOException) {
                log(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        }
        Vector tCEPMale_Vector = (Vector) population[7];
        for (int i = 0; i < tCEPMale_Vector.size(); i++) {
            line = aZoneCode +
                    ",CEP," +
                    ((ISARDataRecord) tCEPMale_Vector.elementAt(i)).get_ID();
            try {
                this._ToyModelDataHandler._ToyModelFileOutputStream.write(line.getBytes());
                this._ToyModelDataHandler._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
            } catch (IOException aIOException) {
                log(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        }
        try {
            this._ToyModelDataHandler._ToyModelFileOutputStream.flush();
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        _Logger.exiting(
                this.getClass().getCanonicalName(),
                "write_HSARHP_ISARCEP(Object[],CASDataRecord,BigDecimal)");
    }
}