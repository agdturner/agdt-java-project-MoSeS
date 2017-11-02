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
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS001DataRecord;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS003DataRecord;
import uk.ac.leeds.ccg.andyt.census.core.Census_CASDataRecord;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataHandler;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataHandler.AgeSexType;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataRecord;
import uk.ac.leeds.ccg.andyt.generic.execution.Generic_AgeConverter;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;
import uk.ac.leeds.ccg.andyt.projects.moses.io.ParameterFileParser;

/**
 * A class for integrating the 2001 UK Population Census Individual SAR and
 * Census Area Statistics to create an individual level census data set for the
 * UK.
 */
public abstract class IndividualCensus_ISARHP_ISARCEP extends IndividualCensus {

    /**
     * Initialisation method
     * @param inputParameter_File
     */
    protected void init(
            File inputParameter_File) {
        Object[] _Input_Parameters = ParameterFileParser.parse(inputParameter_File);
        _Directory = (File) _Input_Parameters[0];
        _Area = (String) _Input_Parameters[1];
        _CASLevel = (String) _Input_Parameters[2];
        if (_CASLevel.equalsIgnoreCase("")) {
            _OutputName = "OA_ISARHP_ISARCEP" + "_" + (String) _Input_Parameters[10];
        } else {
            _OutputName = _CASLevel + "_ISARHP_ISARCEP" + "_" + (String) _Input_Parameters[10];
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
                    _Directory.getCanonicalPath()
                    + System.getProperty("file.separator") + "Output"
                    + System.getProperty("file.separator") + _OutputName
                    + System.getProperty("file.separator") + _Area);
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
                inputParameter_File,
                _OutputDirectory);
        // Initialise _InputFile
        _Input_File = new File((String) _Input_Parameters[11] + "population_HashMap.thisFile");
        // if _InputFile.exists() then this run will be loading in a prior result and re-optimising
        if (_Input_File.exists()) {
            load_Population_HashMap();
        } else {
            _Population_HashMap = new HashMap();
        }
        // Initialise Census_CASDataHandler.
        init_CASDataHandler(_Directory, _CASLevel);
        // Initialise Census_ISARDataHandler.
        init_ISARDataHandler(_Directory);
        // Initialise ToyModelDataHandler.
        init_ToyModelDataHandler(_Output_File_0);
    }

    public void init(
            IndividualCensus_ISARHP_ISARCEP _IndividualCensus_ISARHP_ISARCEP) {
        this._CASDataHandler = _IndividualCensus_ISARHP_ISARCEP._CASDataHandler;
        this._CASLevel = _IndividualCensus_ISARHP_ISARCEP._CASLevel;
        this._GeneticAlgorithm = _IndividualCensus_ISARHP_ISARCEP._GeneticAlgorithm;
        this._IncludedVariablesHashSet = _IndividualCensus_ISARHP_ISARCEP._IncludedVariablesHashSet;
        this._Directory = _IndividualCensus_ISARHP_ISARCEP._Directory;
        this._ISARDataHandler = _IndividualCensus_ISARHP_ISARCEP._ISARDataHandler;
        this._LongNumberOfHSARDataRecords = _IndividualCensus_ISARHP_ISARCEP._LongNumberOfHSARDataRecords;
        this._LongNumberOfISARDataRecords = _IndividualCensus_ISARHP_ISARCEP._LongNumberOfISARDataRecords;
        this._OutputDirectory = _IndividualCensus_ISARHP_ISARCEP._OutputDirectory;
        this._OutputName = _IndividualCensus_ISARHP_ISARCEP._OutputName;
        this._StartTime = _IndividualCensus_ISARHP_ISARCEP._StartTime;
        this._ToyModelDataHandler = _IndividualCensus_ISARHP_ISARCEP._ToyModelDataHandler;
    }

    public Object[] getConstraints_ISARHP_ISARCEP(
            Census_CASDataRecord aCASDataRecord) {
        Object[] constraints = new Object[4];
        Census_CAS001DataRecord aCAS001DataRecord = aCASDataRecord.getCAS001DataRecord();
        Census_CAS003DataRecord aCAS003DataRecord = aCASDataRecord.getCAS003DataRecord();
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
     * @return An Object[] tConstraintsAndPopulation_ISARHP_ISARCEP:
     * tConstraintsAndPopulation_ISARHP_ISARCEP[0] constraints:
     * constraints[0] = constraintCAS003HPHRPAgeFemaleCount_HashMap;
     * constraints[1] = constraintCAS003HPHRPAgeMaleCount_HashMap;
     * constraints[2] = constraintCAS001CEPAgeFemaleCount3_HashMap;
     * constraints[3] = constraintCAS001CEPAgeMaleCount3_HashMap;
     * tConstraintsAndPopulation_ISARHP_ISARCEP[2] population:
     * population[0] = tHPHRPFemale_Age_Vector_HashMap;
     * population[1] = tHPHRPFemale_Vector;
     * population[2] = tHPHRPMale_Age_Vector_HashMap;
     * population[3] = tHPHRPMale_Vector;
     * population[4] = tHPNonHRP_Vector;
     * population[5] = tCEPFemale_Age_Vector_HashMap;
     * population[6] = tCEPFemale_Vector;
     * population[7] = tCEPMale_Age_Vector_HashMap;
     * population[8] = tCEPMale_Vector;
     * @param aCASDataRecord
     *            The Census_CASDataRecord being processed.
     */
    public Object[] getConstraintsAndPopulation_ISARHP_ISARCEP(
            Census_CASDataRecord aCASDataRecord) {
        _Logger.entering(
                this.getClass().getName(),
                "getConstraintsAndPopulation_ISARHP_ISARCEP(CASDataRecord)");
        Random aRandom = this._GeneticAlgorithm._Random;
        // Initialise result
        Object[] result = new Object[2];
        Object[] constraints = getConstraints_ISARHP_ISARCEP(aCASDataRecord);
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
        Vector tHPNonHRP_Vector = new Vector();
        HashMap tCEPFemale_Age_Vector_HashMap = new HashMap();
        Vector tCEPFemale_Vector = new Vector();
        HashMap tCEPMale_Age_Vector_HashMap = new HashMap();
        Vector tCEPMale_Vector = new Vector();
        population[0] = tHPHRPFemale_Age_Vector_HashMap;
        population[1] = tHPHRPFemale_Vector;
        population[2] = tHPHRPMale_Age_Vector_HashMap;
        population[3] = tHPHRPMale_Vector;
        population[4] = tHPNonHRP_Vector;
        population[5] = tCEPFemale_Age_Vector_HashMap;
        population[6] = tCEPFemale_Vector;
        population[7] = tCEPMale_Age_Vector_HashMap;
        population[8] = tCEPMale_Vector;
        Iterator iterator;
        Object key;
        //Object value;
        int age;
        boolean sex;
        short type;
        Census_ISARDataHandler.AgeSexType aAgeSexType;
        Census_ISARDataRecord aISARDataRecord;
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
                Vector aISARDataRecord_Vector = new Vector();
                tHPHRPFemale_Age_Vector_HashMap.put(
                        key,
                        aISARDataRecord_Vector);
                while (aISARDataRecord_Vector.size() < aConstraint) {
                    boolean constrained = false;
                    int iterationCount = 0;
                    do {
                        aAgeSexType = _ISARDataHandler.new AgeSexType(
                                (short) Generic_AgeConverter.getAgeClassISARDataRecord(Generic_AgeConverter.getAge5(age, aRandom)),
                                sex,
                                type);
                        aISARDataRecord = _ISARDataHandler.getISARDataRecord(
                                aRandom,
                                aAgeSexType);
                        if (aISARDataRecord != null) {
                            aISARDataRecord_Vector.add(aISARDataRecord);
                            tHPHRPFemale_Vector.add(aISARDataRecord);
                            constrained = true;
                            tHPHRPFemaleCount++;
                        } else {
                            iterationCount++;
                        }
                        if (iterationCount > 1000) {
                            log("Getting stuck initialising tHPHRPFemale_Age_Vector_HashMap"
                                    + " for age " + age
                                    + " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code())
                                    + " iterationCount = " + iterationCount);
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
        sex = true;
        type = 1;
        iterator = constraintCAS003HPHRPAgeMaleCount_HashMap.keySet().iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            age = (Short) key;
            aConstraint = (Integer) constraintCAS003HPHRPAgeMaleCount_HashMap.get(key);
            if (aConstraint > 0) {
                Vector aISARDataRecord_Vector = new Vector();
                tHPHRPMale_Age_Vector_HashMap.put(
                        key,
                        aISARDataRecord_Vector);
                while (aISARDataRecord_Vector.size() < aConstraint) {
                    boolean constrained = false;
                    int iterationCount = 0;
                    do {
                        aAgeSexType = _ISARDataHandler.new AgeSexType(
                                (short) Generic_AgeConverter.getAgeClassISARDataRecord(Generic_AgeConverter.getAge5(age, aRandom)),
                                sex,
                                type);
                        aISARDataRecord = _ISARDataHandler.getISARDataRecord(
                                aRandom,
                                aAgeSexType);
                        if (aISARDataRecord != null) {
                            aISARDataRecord_Vector.add(aISARDataRecord);
                            tHPHRPMale_Vector.add(aISARDataRecord);
                            constrained = true;
                            tHPHRPMaleCount++;
                        } else {
                            iterationCount++;
                        }
                        if (iterationCount > 1000) {
                            log("Getting stuck initialising tHPHRPMale_Age_Vector_HashMap"
                                    + " for age " + age
                                    + " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code())
                                    + " iterationCount = " + iterationCount);
                            System.exit(Generic_ErrorAndExceptionHandler.Error);
                        }
                    } while (!constrained);
                }
            }
        }
        log("Assigned " + tHPHRPMaleCount + " in tHPHRPMale_Age_Vector_HashMap");

        log("Initialise tHPNonHRP_Vector");
        Census_CAS001DataRecord tCAS001DataRecord = aCASDataRecord.getCAS001DataRecord();
        // Females
        int tHouseholdResidentsFemales = tCAS001DataRecord.getHouseholdResidentsFemales();
        int tFemalesHPNonHRP = tHouseholdResidentsFemales - tHPHRPFemaleCount;
        sex = false;
        type = 2;
        for (int i = 0; i < tFemalesHPNonHRP; i++) {
            int iterationCount = 0;
            boolean assigned = false;
            do {
                age = aRandom.nextInt(100);
//                if (age >= 35 && age < 40) {
//                    int debug = 1;
//                }
                aAgeSexType = _ISARDataHandler.new AgeSexType(
                        (short) Generic_AgeConverter.getAgeClassISARDataRecord(age),
                        sex,
                        type);
                aISARDataRecord = _ISARDataHandler.getISARDataRecord(
                        aRandom,
                        aAgeSexType);
                if (aISARDataRecord != null) {
                    tHPNonHRP_Vector.add(aISARDataRecord);
                    assigned = true;
                } else {
                    iterationCount++;
                }
                if (iterationCount > 1000) {
                    log("Getting stuck initialising females for tHPNonHRP_Vector"
                            + " for age " + age
                            + " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code())
                            + " iterationCount = " + iterationCount);
                    System.exit(Generic_ErrorAndExceptionHandler.Error);
                }
            } while (!assigned);
        }
        log("Assigned " + tFemalesHPNonHRP + " Females to tHPNonHRP_Vector");
        // Males
        int tHouseholdResidentsMales = tCAS001DataRecord.getHouseholdResidentsMales();
        int tMalesHPNonHRP = tHouseholdResidentsMales - tHPHRPMaleCount;
        sex = true;
        type = 2;
        for (int i = 0; i < tMalesHPNonHRP; i++) {
            int iterationCount = 0;
            boolean assigned = false;
            do {
                age = aRandom.nextInt(100);
                age = aRandom.nextInt(100);
//                if (age >= 35 && age < 40) {
//                    int debug = 1;
//                }
                aAgeSexType = _ISARDataHandler.new AgeSexType(
                        (short) Generic_AgeConverter.getAgeClassISARDataRecord(age),
                        sex,
                        type);
                aISARDataRecord = _ISARDataHandler.getISARDataRecord(
                        aRandom,
                        aAgeSexType);
                if (aISARDataRecord != null) {
                    tHPNonHRP_Vector.add(aISARDataRecord);
                    assigned = true;
                } else {
                    iterationCount++;
                }
                if (iterationCount > 1000) {
                    log("Getting stuck initialising males for tHPNonHRP_Vector"
                            + " for age " + age
                            + " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code())
                            + " iterationCount = " + iterationCount);
                    System.exit(Generic_ErrorAndExceptionHandler.Error);
                }
            } while (!assigned);
        }
        log("Assigned " + tMalesHPNonHRP + " Males to tHPNonHRP_Vector");

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
                                (short) Generic_AgeConverter.getAgeClassISARDataRecord(Generic_AgeConverter.getAge7(age, aRandom)),
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
                                log("Getting stuck initialising tCEPFemale_Age_Vector_HashMap"
                                        + " for age " + age
                                        + " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code())
                                        + " iterationCount = " + iterationCount
                                        + " trying type = " + type);
                            }
                            if (iterationCount > 2000) {
                                type = 1;
                                if (iterationCount == 2001) {
                                    log("Getting stuck initialising tCEPFemale_Age_Vector_HashMap"
                                            + " for age " + age
                                            + " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code())
                                            + " iterationCount = " + iterationCount
                                            + " trying type = " + type);
                                }
                                if (iterationCount > 3001) {
                                    log("Getting stuck initialising tCEPFemale_Age_Vector_HashMap"
                                            + " for age " + age
                                            + " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code())
                                            + " iterationCount = " + iterationCount);
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
        // 0-15,16,20,25,30,45,60,65,75,85,90
        int tCEPMaleCount = 0;
        sex = true;
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
                                (short) Generic_AgeConverter.getAgeClassISARDataRecord(Generic_AgeConverter.getAge7(age, aRandom)),
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
                                log("Getting stuck initialising tCEPMale_Age_Vector_HashMap "
                                        + " for age " + age
                                        + " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code())
                                        + " iterationCount = " + iterationCount
                                        + " trying type = " + type);
                            }
                            if (iterationCount > 2000) {
                                type = 1;
                                if (iterationCount == 2001) {
                                    log("Getting stuck initialising tCEPMale_Age_Vector_HashMap  "
                                            + " for age " + age
                                            + " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code())
                                            + " iterationCount = " + iterationCount
                                            + " trying type = " + type);
                                }
                                if (iterationCount > 3001) {
                                    log("Getting stuck initialising tCEPMale_Age_Vector_HashMap "
                                            + " for age " + age
                                            + " for CASDataRecord " + String.valueOf(aCASDataRecord.getZone_Code())
                                            + " iterationCount = " + iterationCount);
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
                "getConstraintsAndPopulation_ISARHP_ISARCEP(CASDataRecord)");

        return result;
    }

    /**
     * Initialises _ISARDataHandler and _LongNumberOfISARDataRecords
     * @param directory
     * The directory from which Census_ISARDataHandler is loaded.
     */
    public void init_ISARDataHandler(
            File directory) {
        _Logger.entering(
                this.getClass().getName(),
                "init_ISARDataHandler(File)");
        File file = new File(
                directory,
                Census_ISARDataHandler.class.getCanonicalName() + ".thisFile");
        this._ISARDataHandler = new Census_ISARDataHandler(file);
        this._LongNumberOfISARDataRecords = this._ISARDataHandler.getNDataRecords();
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
     * population[4] = tHPNonHRP_Vector;
     * population[5] = tCEPFemale_AgeSexType_Vector_HashMap;
     * population[6] = tCEPFemale_Vector;
     * population[7] = tCEPMale_AgeSexType_Vector_HashMap;
     * population[8] = tCEPMale_Vector;
     * @param aCASDataRecord
     * @param fitness
     */
    public void write_ISARHP_ISARCEP(
            Object[] population,
            Census_CASDataRecord aCASDataRecord,
            BigDecimal fitness) {
        _Logger.entering(
                this.getClass().getCanonicalName(),
                "write_ISARHP_ISARCEP(Object[],CASDataRecord,BigDecimal)");
        String line;
        String aZoneCode = new String(aCASDataRecord.getZone_Code());
        if (population[1] != null) {
            if (population[1] instanceof Vector) {
                Vector tHPHRPFemale_Vector = (Vector) population[1];
                for (int i = 0; i < tHPHRPFemale_Vector.size(); i++) {
                    line = aZoneCode
                            + ",HP,"
                            + ((Census_ISARDataRecord) tHPHRPFemale_Vector.elementAt(i)).get_ID();
                    try {
                        this._ToyModelDataHandler._ToyModelFileOutputStream.write(line.getBytes());
                        this._ToyModelDataHandler._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
                    } catch (IOException aIOException) {
                        log(aIOException.getLocalizedMessage());
                        System.exit(Generic_ErrorAndExceptionHandler.IOException);
                    }
                }
            } else {
                log("Expecting Vector");
            }
        }
        if (population[3] != null) {
            if (population[3] instanceof Vector) {
                Vector tHPHRPMale_Vector = (Vector) population[3];
                for (int i = 0; i < tHPHRPMale_Vector.size(); i++) {
                    line = aZoneCode
                            + ",HP,"
                            + ((Census_ISARDataRecord) tHPHRPMale_Vector.elementAt(i)).get_ID();
                    try {
                        this._ToyModelDataHandler._ToyModelFileOutputStream.write(line.getBytes());
                        this._ToyModelDataHandler._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
                    } catch (IOException aIOException) {
                        log(aIOException.getLocalizedMessage());
                        System.exit(Generic_ErrorAndExceptionHandler.IOException);
                    }
                }
            } else {
                log("Expecting Vector");
            }
        }
        if (population[4] != null) {
            if (population[4] instanceof Vector) {
                Vector tHPNonHRP_Vector = (Vector) population[4];
                for (int i = 0; i < tHPNonHRP_Vector.size(); i++) {
                    line = aZoneCode
                            + ",HP,"
                            + ((Census_ISARDataRecord) tHPNonHRP_Vector.elementAt(i)).get_ID();
                    try {
                        this._ToyModelDataHandler._ToyModelFileOutputStream.write(line.getBytes());
                        this._ToyModelDataHandler._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
                    } catch (IOException aIOException) {
                        log(aIOException.getLocalizedMessage());
                        System.exit(Generic_ErrorAndExceptionHandler.IOException);
                    }
                }
            } else {
                log("Expecting Vector");
            }
        }
        if (population[6] != null) {
            if (population[6] instanceof Vector) {
                Vector tCEPFemale_Vector = (Vector) population[6];
                for (int i = 0; i < tCEPFemale_Vector.size(); i++) {
                    line = aZoneCode
                            + ",CEP,"
                            + ((Census_ISARDataRecord) tCEPFemale_Vector.elementAt(i)).get_ID();
                    try {
                        this._ToyModelDataHandler._ToyModelFileOutputStream.write(line.getBytes());
                        this._ToyModelDataHandler._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
                    } catch (IOException aIOException) {
                        log(aIOException.getLocalizedMessage());
                        System.exit(Generic_ErrorAndExceptionHandler.IOException);
                    }
                }
            } else {
                log("Expecting Vector");
            }
        }
        if (population[8] != null) {
            if (population[8] instanceof Vector) {
                Vector tCEPMale_Vector = (Vector) population[8];
                for (int i = 0; i < tCEPMale_Vector.size(); i++) {
                    line = aZoneCode
                            + ",CEP,"
                            + ((Census_ISARDataRecord) tCEPMale_Vector.elementAt(i)).get_ID();
                    try {
                        this._ToyModelDataHandler._ToyModelFileOutputStream.write(line.getBytes());
                        this._ToyModelDataHandler._ToyModelFileOutputStream.write(StreamTokenizer.TT_EOL);
                    } catch (IOException aIOException) {
                        log(aIOException.getLocalizedMessage());
                        System.exit(Generic_ErrorAndExceptionHandler.IOException);
                    }
                }
            } else {
                log("Expecting Vector");
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
                "write_ISARHP_ISARCEP(Object[],CASDataRecord,BigDecimal)");
    }
}
