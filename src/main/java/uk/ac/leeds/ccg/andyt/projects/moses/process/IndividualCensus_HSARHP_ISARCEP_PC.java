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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import uk.ac.leeds.ccg.andyt.projects.moses.io.CASDataRecord;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;

/**
 * Class for creating an individual census using sampling with replacement.
 *
 * The Household Population (HP) is comprised from HSARDataRecords.
 * The Communal Establishment Population (CEP) is comprised from
 * ISARDataRecords.
 *
 * The main method is for invoking on an individual PC and reads and writes
 * files from a single directory as specified in a configuration file along with
 * other parameters.
 *
 * JVM Options:
 * -Xmx1200m
 * This ensures there is a minimum sufficient memory.
 *
 * Additional requirements:
 * At least 6GB Disk for a full UK run.
 * This is with the default logging level, and default output formats. More disk
 * may be needed for finer logging levels depending on how much optimisation is
 * done.
 * Running this class requires a configuration file which can be specified via
 * the argument passed into the main method.
 *
 * Either an existing solution is re-optimised or a new solution is generated
 * from scratch. Which is attempted depends on the configuration file.
 *
 * The configuration file is a text file of which the first 10 lines are as
 * follows (quotation marks are not expected, they are added here for clarity
 * along with a brief explanation of each parameter):
 * line 1:
 * A workspace directory (e.g. "C:/Workspace/")
 * line 2:
 * A Local Authority District (LAD) Code (e.g. "00DA") or a region code
 * (e.g. "00D"), or "UK" in which case all LAD in the UK are processed.
 * line 3:
 * Output Level (e.g. "OA")
 * (Currently only OA for Output Areas is supported.)
 * Lines 4,5,6,7,8 and 9 are integer (int) Genetic Algorithm parameters:
 * Line 4:
 * _InitialPopulationSize the initial population size for an optimisation
 * (NB. This has to be 1 or more. The larger this is, the slower the first part
 * of the optimisation will be and the more resources will be required. A value
 * greater than 100 is not advised and a suggested value is 10.)
 * Line 5:
 * _NumberOfOptimisationIterations the number of optimisation iterations of an
 * optimisation
 * Line 6:
 * _MaxNumberOfSolutions the maximum number of solutions stored during an
 * optimisation.
 * (NB. This has to be 1 or more. The larger this is, the slower the
 * optimisation will be and the more resources will be required. A value
 * greater than 100 is not advised and a suggested value is 10.)
 * Line 7:
 * _ConvergenceThreshold the convergence threshold used during an optimisation.
 * If after this many iterations around the optimisation loop no better solution
 * is found, the program breaks out of the optimisation loop.
 * (NB. Sensibly this is greater than 1 and less than 100)
 * Line 8:
 * _MaxNumberOfMutationsPerChild the maximum number of mutations or changes per 
 * child used during an optimisation
 * Line 9:
 * _MaxNumberOfMutationsPerParent the maximum number of mutations or changes per 
 * parent used during an optimisation
 * Line 10:
 * _RandomSeed the seed for random number generation.
 * Line 11:
 * A String name to be used to specify the top level output directory.
 * Line 12:
 * The abstract file location of a file which is a result previously generated 
 * output file in the form of a Serialized HashMap. It is expected this is
 * called population_HashMap.thisFile. If the file specified exists, it is
 * reloaded and used as an initial population for re-optimising.
 *
 * The HP is created in 4 parts:
 * Household Reference Persons (HRP) for females,
 * HRP for males,
 * non-HRP for females,
 * non-HRP for males.
 * The CEP is created in 2 parts:
 * female,
 * males.
 * Each of these parts of the population are control constrained:
 * The HRP HP are constrained for each gender using age classes (0,20,30,60)
 * as in CAS003;
 * The non-HRP HP are constrained for each gender for household resident count
 * as in CAS001 (the total HRP HP for each gender is taken from the CAS001
 * count);
 * The CEP are constrained for each gender using age classes
 * (0,16,20,25,30,45,60,65,70,75,80,85,90).
 * By default all CEP have the expected ISARDataRecord.get_RELTOHR() type.
 * However, where necessary other such types are used.
 */
public class IndividualCensus_HSARHP_ISARCEP_PC extends IndividualCensus_HSARHP_ISARCEP {

    public IndividualCensus_HSARHP_ISARCEP_PC() {
    }

    public IndividualCensus_HSARHP_ISARCEP_PC(
            File _Input_Parameter_File) {
        init(_Input_Parameter_File);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File _Input_Parameter_File;
            if (args.length == 0) {
                _Input_Parameter_File = new File(
                "/scratch01/Work/Projects/MoSeS/Workspace/ParameterFiles/UK/OA_HSARHP_ISARCEP/2_1000_2_2_2_2_0_1.txt");
                //"/scratch01/Work/Projects/MoSeS/Workspace/ParameterFiles/UK/OA_HSARHP_ISARCEP/2_10_2_2_2_2_0_Init.txt");
                //"C:/Work/Projects/MoSeS/Workspace/ParameterFiles/UK/OA_HSARHP_ISARCEP/2_10_2_2_2_2_0_Init.txt");
                //"C:/Work/Projects/MoSeS/Workspace/ParameterFiles/UK/OA_HSARHP_ISARCEP/2_10_2_2_2_2_0_1.txt");
                //"C:/Work/Projects/MoSeS/Workspace/ParameterFiles/UK/OA_HSARHP_ISARCEP/2_1000_2_2_2_2_0_1.txt");
                //"C:/Work/Projects/MoSeS/Workspace/ParameterFiles/UK/OA_HSARHP_ISARCEP/2_1000_10_10_10_10_0_1.txt");
                //"C:/Work/Projects/MoSeS/Workspace/ParameterFiles/UK/00D/00DA/OA_HSARHP_ISARCEP/2_10_2_2_2_2_0_Init.txt");
                //"C:/Work/Projects/MoSeS/Workspace/ParameterFiles/UK/00D/00DA/OA_HSARHP_ISARCEP/2_10_2_2_2_2_0_1.txt");
                //"C:/Work/Projects/MoSeS/Workspace/ParameterFiles/UK/00D/00DA/OA_HSARHP_ISARCEP/2_1000_2_2_2_2_0_1.txt");
            } else {
                _Input_Parameter_File = new File(
                        args[0]);
            }
            IndividualCensus_HSARHP_ISARCEP_PC _IndividualCensus_HSARHP_ISARCEP_PC = new IndividualCensus_HSARHP_ISARCEP_PC(
                    _Input_Parameter_File);
            _IndividualCensus_HSARHP_ISARCEP_PC.run(args);
        } catch (Exception aException) {
            aException.printStackTrace();
            System.exit(Generic_ErrorAndExceptionHandler.Exception);
        } catch (Error aError) {
            aError.printStackTrace();
            System.exit(Generic_ErrorAndExceptionHandler.Error);
        }
    }

    /**
     * Top level control for controlling which type of run is performed and
     * setting parameters.
     * @param args
     * @throws java.io.IOException
     */
    public void run(String[] args) throws IOException {
        TreeSet tLADCodes = _CASDataHandler.getLADCodes_TreeSet();
        Level aLevel = Level.FINE;

        //_Area = "95VV";
        //_Area = "95ZZ";

        if (tLADCodes.contains(_Area)) {
            if (_Input_File.exists()) {
                reloadAndOptimise();
            } else {
                initialOptimise();
            }
        } else {
            String _Area0 = _Area;
            boolean doAll = false;
            if (_Area0.equalsIgnoreCase("UK")) {
                doAll = true;
            }
            File _Input_File0 = _Input_File.getCanonicalFile();
            File _OutputDirectory0 = _OutputDirectory.getCanonicalFile();
            Iterator aIterator = tLADCodes.iterator();
            String aLADCode;
            while (aIterator.hasNext()) {
                aLADCode = (String) aIterator.next();
                if (aLADCode.startsWith(_Area0) || doAll) {
                    log(aLADCode);
                    _OutputDirectory = new File(
                            _OutputDirectory0.getCanonicalPath() +
                            System.getProperty("file.separator") + aLADCode.substring(0, aLADCode.length() - 1) +
                            System.getProperty("file.separator") + aLADCode);
                    _Area = aLADCode;
                    boolean resultExists = initOutputFiles();
                    if (!resultExists) {
                        initLogFile(aLevel);
                        _Input_File = new File(
                                _Input_File0.getParentFile().getCanonicalPath() +
                                System.getProperty("file.separator") +
                                System.getProperty("file.separator") + aLADCode.substring(0, aLADCode.length() - 1) +
                                System.getProperty("file.separator") + aLADCode +
                                System.getProperty("file.separator") + "population_HashMap.thisFile");
                        if (_Input_File.exists()) {
                            load_Population_HashMap();
                            reloadAndOptimise();
                        } else {
                            _Population_HashMap = new HashMap();
                            initialOptimise();
                        }
                    }
                }
            }
        }
    }

    public void initialOptimise() throws IOException {
        _Logger.entering(
                this.getClass().getCanonicalName(),
                "initialOptimise()");
        // Get_StartRecordID and _EndRecordID for _Area
        long[] _StartRecordID_EndRecordID = get_StartRecordID_EndRecordID(_Area);
        CASDataRecord aCASDataRecord;
        Object[] result;
        Object[] solution;
        Object[] population;
        BigDecimal fitness;
        for (long RecordID = _StartRecordID_EndRecordID[0]; RecordID <= _StartRecordID_EndRecordID[1]; RecordID++) {
            aCASDataRecord = (CASDataRecord) this._CASDataHandler.getDataRecord(RecordID);
            String aZoneCode = String.valueOf(aCASDataRecord.getZone_Code());
            GeneticAlgorithm_HSARHP_ISARCEP _GeneticAlgorithm_HSARHP_ISARCEP = new GeneticAlgorithm_HSARHP_ISARCEP(
                    this,
                    aCASDataRecord);
            result = _GeneticAlgorithm_HSARHP_ISARCEP.getOptimisedResult_ObjectArray();
            solution = (Object[]) result[0];
            population = (Object[]) solution[1];
            fitness = (BigDecimal) result[1];
            _Population_HashMap.put(aZoneCode, population);
            write_HSARHP_ISARCEP(
                    population,
                    aCASDataRecord,
                    fitness);
            log("Done optimising " + aZoneCode + " with " + aCASDataRecord.getCASKS020DataRecord().getAllHouseholds() + " households.");
        }
        output_Population_HashMap();
        _Logger.exiting(
                this.getClass().getCanonicalName(),
                "initialOptimise()");
    }

    public void reloadAndOptimise()
            throws IOException {
        _Logger.entering(
                this.getClass().getCanonicalName(),
                "reloadAndOptimise()");
        // Find _StartRecordID and _EndRecordID for _Area
        long[] _StartRecordID_EndRecordID = get_StartRecordID_EndRecordID(_Area);
        CASDataRecord aCASDataRecord;
        Object[] result;
        Object[] solution;
        Object[] population;
        BigDecimal fitness;
        //LoadPopulationHashMap this._Population_HashMap =
        for (long RecordID = _StartRecordID_EndRecordID[0]; RecordID <= _StartRecordID_EndRecordID[1]; RecordID++) {
            aCASDataRecord = (CASDataRecord) this._CASDataHandler.getDataRecord(RecordID);
            String aZoneCode = String.valueOf(aCASDataRecord.getZone_Code());
            GeneticAlgorithm_HSARHP_ISARCEP aGeneticAlgorithm_HSARHP_ISARCEP = new GeneticAlgorithm_HSARHP_ISARCEP(
                    this,
                    aCASDataRecord);
            // Get constraints and set up to run from existing population
            TreeMap existingSolution_TreeMap = new TreeMap();
            Object[] constraints = getConstraints_HSARHP_ISARCEP(aCASDataRecord);
            population = (Object[]) this._Population_HashMap.get(aZoneCode);
            Object[] aConstraintsAndPopulation = new Object[2];
            aConstraintsAndPopulation[0] = constraints;
            aConstraintsAndPopulation[1] = population;
            fitness = aGeneticAlgorithm_HSARHP_ISARCEP.getFitness(aConstraintsAndPopulation);
            HashSet existingSolution_HashSet = new HashSet();
            existingSolution_HashSet.add(aConstraintsAndPopulation);
            existingSolution_TreeMap.put(fitness, existingSolution_HashSet);
            // Get result
            result = aGeneticAlgorithm_HSARHP_ISARCEP.getOptimisedResult_ObjectArray(existingSolution_TreeMap);
            solution = (Object[]) result[0];
            population = (Object[]) solution[1];
            fitness = (BigDecimal) result[1];
            _Population_HashMap.put(aZoneCode, population);
            write_HSARHP_ISARCEP(
                    population,
                    aCASDataRecord,
                    fitness);
            log("Done re-optimising " + aZoneCode + " with " + aCASDataRecord.getCASKS020DataRecord().getAllHouseholds() + " households.");
        }
        output_Population_HashMap();
        _Logger.exiting(
                this.getClass().getCanonicalName(),
                "reloadAndOptimise()");
    }
}