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
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
import mpi.MPIException;
import mpi.MPI;
import mpi.Request;
import mpi.Status;
import uk.ac.leeds.ccg.andyt.census.core.Census_CASDataRecord;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;
import uk.ac.leeds.ccg.andyt.projects.moses.io.ParameterFileParser;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.projects.moses.mpj.MPJRun;

/**
 * Like IndividualCensus_HSARHP_ISARCEP_PC, but for distributed processing on
 * the UK National Grid Service (NGS).
 */
class IndividualCensus_HSARHP_ISARCEP_NGS extends IndividualCensus_HSARHP_ISARCEP_MPJ {

    public File _Input_Parameter_File;

    public IndividualCensus_HSARHP_ISARCEP_NGS() {
        _MPJRun = new MPJRun();
    }

    public IndividualCensus_HSARHP_ISARCEP_NGS(
            File _Input_Parameter_File) {
        _MPJRun = new MPJRun();
        init(_Input_Parameter_File);
    }

    @Override
    public void init(
            File _Input_Parameter_File) {
        this._Input_Parameter_File = _Input_Parameter_File;
        Object[] tInput_Parameters = ParameterFileParser.parse(_Input_Parameter_File);
        _Directory = (File) tInput_Parameters[0];
        _Area = (String) tInput_Parameters[1];
        _CASLevel = (String) tInput_Parameters[2];
        if (_CASLevel.equalsIgnoreCase("")) {
            _OutputName = "OA_HSARHP_ISARCEP" + "_" + (String) tInput_Parameters[10];
        } else {
            _OutputName = _CASLevel + "_HSARHP_ISARCEP" + "_" + (String) tInput_Parameters[10];
        }
        _Input_File = new File((String) tInput_Parameters[11] + "population_HashMap.thisFile");
        try {
            _OutputDirectory = new File(
                    _Directory.getCanonicalPath() +
                    System.getProperty("file.separator") + "Output" +
                    System.getProperty("file.separator") + _OutputName +
                    System.getProperty("file.separator") + _Area);
        } catch (IOException aIOException) {
            System.err.println(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        if (!_OutputDirectory.exists()) {
            _OutputDirectory.mkdirs();
        }
        initLogFile();
    }

    public void init_Slave(
            int rank) {
        Object[] tInput_Parameters = ParameterFileParser.parse(_Input_Parameter_File);
        _Directory = (File) tInput_Parameters[0];
        _Area = (String) tInput_Parameters[1];
        _CASLevel = (String) tInput_Parameters[2];
        if (_CASLevel.equalsIgnoreCase("")) {
            _OutputName = "OA_HSARHP_ISARCEP" + "_" + (String) tInput_Parameters[10];
        } else {
            _OutputName = _CASLevel + "_HSARHP_ISARCEP" + "_" + (String) tInput_Parameters[10];
        }
        int _InitialPopulationSize = (Integer) tInput_Parameters[3];
        int _NumberOfOptimisationIterations = (Integer) tInput_Parameters[4];
        int _MaxNumberOfSolutions = (Integer) tInput_Parameters[5];
        int _ConvergenceThreshold = (Integer) tInput_Parameters[6];
        int _MaxNumberOfMutationsPerChild = (Integer) tInput_Parameters[7];
        int _MaxNumberOfMutationsPerParent = (Integer) tInput_Parameters[8];
        long _RandomSeed = (Long) tInput_Parameters[9];
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
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        if (!_OutputDirectory.exists()) {
            _OutputDirectory.mkdirs();
        }
        initLogFile(rank);
//        if (_Input_File.exists()) {
//            load_Population_HashMap();
//        } else {
//            _Population_HashMap = new HashMap();
//        }
        // Initialise Census_CASDataHandler.
        init_CASDataHandler(_Directory, _CASLevel);
        // Initialise ISARDataHandler.
        init_ISARDataHandler(_Directory);
        // Initialise HSARDataHandler.
        init_HSARDataHandler(_Directory);
    }

    public void init_Master(
            int rank) {
        Object[] tInput_Parameters = ParameterFileParser.parse(_Input_Parameter_File);
        _Directory = (File) tInput_Parameters[0];
        _Area = (String) tInput_Parameters[1];
        _CASLevel = (String) tInput_Parameters[2];
        if (_CASLevel.equalsIgnoreCase("")) {
            _OutputName = "OA_HSARHP_ISARCEP" + "_" + (String) tInput_Parameters[10];
        } else {
            _OutputName = _CASLevel + "_HSARHP_ISARCEP" + "_" + (String) tInput_Parameters[10];
        }
        int _InitialPopulationSize = (Integer) tInput_Parameters[3];
        int _NumberOfOptimisationIterations = (Integer) tInput_Parameters[4];
        int _MaxNumberOfSolutions = (Integer) tInput_Parameters[5];
        int _ConvergenceThreshold = (Integer) tInput_Parameters[6];
        int _MaxNumberOfMutationsPerChild = (Integer) tInput_Parameters[7];
        int _MaxNumberOfMutationsPerParent = (Integer) tInput_Parameters[8];
        long _RandomSeed = (Long) tInput_Parameters[9];
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
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        if (!_OutputDirectory.exists()) {
            _OutputDirectory.mkdirs();
        }
        initLogFile(rank);
        initOutputFiles();
        // Initialise _InputFile
        _Input_File = new File((String) tInput_Parameters[11] + "population_HashMap.thisFile");
        // if _InputFile.exists() then this run will be loading in a prior result and re-optimising
        // Copy Parameter file to _OutputDirectory as metadata
        Generic_StaticIO.copy(
                _Input_Parameter_File,
                _OutputDirectory);
        // Initialise Census_CASDataHandler.
        init_CASDataHandler(_Directory, _CASLevel);
        // Initialise ToyModelDataHandler.
        init_ToyModelDataHandler(_Output_File_0);
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        //File _User_Home_Directory = new File(System.getProperty("user.home"));
        File _Input_Parameter_File = new File(
                //_User_Home_Directory.getCanonicalPath() + System.getProperty("file.separator") +
                System.getProperty("file.separator") +
                "home" + System.getProperty("file.separator") +
                "ngs0093" + System.getProperty("file.separator") +
                "projects" + System.getProperty("file.separator") +
                "MoSeS" + System.getProperty("file.separator") +
                "Workspace" + System.getProperty("file.separator") +
                "ParameterFiles" + System.getProperty("file.separator") +
                "UK" + System.getProperty("file.separator") +
                //"00DA" + System.getProperty("file.separator") +
                "OA_HSARHP_ISARCEP" + System.getProperty("file.separator") +
                //"2_10_2_2_2_2_0_Init.txt");
                "2_1000_2_2_2_2_0_1.txt");
        try {
            System.out.println(
                    "_Input_Parameter_File " + _Input_Parameter_File.getCanonicalPath() +
                    " exists " + _Input_Parameter_File.exists());
        } catch (IOException aIOException) {
            System.err.print(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        IndividualCensus_HSARHP_ISARCEP_NGS _IndividualCensus_HSARHP_ISARCEP_NGS = new IndividualCensus_HSARHP_ISARCEP_NGS(
                _Input_Parameter_File);
        _IndividualCensus_HSARHP_ISARCEP_NGS.run(args);
    }

    @Override
    public String toString() {
        String _Result = super.toString();
        return _Result;
    }

    public void run(String[] args) {
        try {
            if (_Input_File.exists()) {
                reloadOptimise(args);
            } else {
                initialOptimise(args);
            }
        } catch (Exception aException) {
            log(aException.getLocalizedMessage());
            System.err.println(aException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.Exception);
        } catch (Error aError) {
            log(aError.getLocalizedMessage());
            System.err.println(aError.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.Error);
        }
    }

    public void initialOptimise(String[] args) {
        _Logger.entering(
                this.getClass().getCanonicalName(),
                "initialOptimise(String[])");
        _MPJRun.initMPI(args);
        int tag = 50; // Message tag
        int size = _MPJRun.get_Size();
        int rank = _MPJRun.get_Rank();
        if (rank == 0) {
            init_Master(rank);
            optimise_Master(
                    size,
                    rank,
                    tag);
        } else {
            init_Slave(rank);
            initialOptimise_Slave(
                    size,
                    rank,
                    tag);
        }
        _MPJRun.finalizeMPI();
        _Logger.exiting(
                this.getClass().getCanonicalName(),
                "initialOptimise(String[])");
    }

    public void reloadOptimise(String[] args) {
        _Logger.entering(
                this.getClass().getCanonicalName(),
                "initialOptimise()");
        _MPJRun.initMPI(args);
        int tag = 50; // Message tag
        int size = _MPJRun.get_Size();
        int rank = _MPJRun.get_Rank();
        if (rank == 0) {
            init_Master(rank);
            optimise_Master(
                    size,
                    rank,
                    tag);
        } else {
            init_Slave(rank);
            reloadOptimise_Slave(
                    size,
                    rank,
                    tag);
        }
        _MPJRun.finalizeMPI();
        _Logger.exiting(
                this.getClass().getCanonicalName(),
                "initialOptimise()");
    }

    public void reloadOptimise_Slave(
            int size,
            int rank,
            int tag) {
        File _Input_File0 = null;
        try {
            _Input_File0 = _Input_File.getCanonicalFile();
        } catch (IOException aIOException) {
            log("Exception on " + rank);
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.FileNotFoundException);
        }
        String aLAD = "";
        String bLAD;
        Census_CASDataRecord aCASDataRecord = null;
        Object[] aResult = null;
        Object[] bResult = null;
        Object[] cResult = new Object[1];
        Object[] input = new Object[1];
        init_CASDataHandler(_Directory, _CASLevel);
        init_ISARDataHandler(_Directory);
        initLogFile(rank);
        boolean worktodo = true;
        while (worktodo) {
            try {
                MPI.COMM_WORLD.Recv(input, 0, 1, MPI.OBJECT, 0, tag);
            } catch (MPIException _MPIException) {
                log("Exception on " + rank + " with MPI.COMM_WORLD.Recv(input, 0, 1, MPI.OBJECT, 0, tag);");
                _MPIException.printStackTrace();
                System.exit(Generic_ErrorAndExceptionHandler.MPIException);
            }
            if (!(input[0] instanceof Census_CASDataRecord)) {
                worktodo = false;
            } else {
                aCASDataRecord = (Census_CASDataRecord) input[0];
            }
            if (worktodo) {
                log("Received " + String.valueOf(aCASDataRecord.getZone_Code()) + " to process");
                GeneticAlgorithm_HSARHP_ISARCEP aGeneticAlgorithm_HSARHP_ISARCEP = new GeneticAlgorithm_HSARHP_ISARCEP(
                        this,
                        aCASDataRecord);
                // Get constraints and set up to run from existing population
                String aZoneCode = new String(aCASDataRecord.getZone_Code());
                bLAD = aZoneCode.substring(0, 4);
                if (!bLAD.equalsIgnoreCase(aLAD)) {
                    try {
                        _Input_File = new File(
                                _Input_File0.getParentFile().getCanonicalPath() +
                                System.getProperty("file.separator") +
                                System.getProperty("file.separator") + bLAD.substring(0, bLAD.length() - 1) +
                                System.getProperty("file.separator") + bLAD +
                                System.getProperty("file.separator") + "population_HashMap.thisFile");
                    } catch (IOException aIOException) {
                        log(aIOException.getLocalizedMessage());
                        System.exit(Generic_ErrorAndExceptionHandler.FileNotFoundException);
                    }
                    if (!_Input_File.exists()) {
                        log("Result " + _Input_File.toString() + " missing for " + bLAD);
                        log("bLAD " + bLAD + " aZoneCode " + aZoneCode);
                        System.exit(Generic_ErrorAndExceptionHandler.FileNotFoundException);
                    } else {
                        load_Population_HashMap();
                    }
                }
                aLAD = bLAD;
                Object[] constraints = getConstraints_HSARHP_ISARCEP(aCASDataRecord);
                Object[] population = (Object[]) this._Population_HashMap.get(aZoneCode);
                Object[] aConstraintsAndPopulation = new Object[2];
                aConstraintsAndPopulation[0] = constraints;
                aConstraintsAndPopulation[1] = population;
                TreeMap existingSolution_TreeMap = new TreeMap();
                BigDecimal fitness = aGeneticAlgorithm_HSARHP_ISARCEP.getFitness(
                        aConstraintsAndPopulation);
                HashSet existingSolution_HashSet = new HashSet();
                existingSolution_HashSet.add(aConstraintsAndPopulation);
                existingSolution_TreeMap.put(fitness, existingSolution_HashSet);
                aResult = aGeneticAlgorithm_HSARHP_ISARCEP.getOptimisedResult_ObjectArray(existingSolution_TreeMap);
                bResult = new Object[2];
                bResult[0] = aCASDataRecord;
                bResult[1] = aResult;
                cResult[0] = bResult;
                try {
                    MPI.COMM_WORLD.Send(
                            cResult,
                            0,
                            1,
                            MPI.OBJECT,
                            0,
                            tag);
                } catch (MPIException _MPIException) {
                    log("Exception on " + rank + " with MPI.COMM_WORLD.Send(cResult, 0, 1, MPI.OBJECT, 0, tag);");
                    _MPIException.printStackTrace();
                }
                log("Sent result for " + String.valueOf(aCASDataRecord.getZone_Code()));
            }
        }
    }

    public void initialOptimise_Slave(
            int size,
            int rank,
            int tag) {
        Census_CASDataRecord aCASDataRecord = null;
        Object[] aResult = null;
        Object[] bResult = null;
        Object[] cResult = new Object[1];
        Object[] input = new Object[1];
        initLogFile(rank);
        boolean worktodo = true;
        while (worktodo) {
            try {
                MPI.COMM_WORLD.Recv(
                        input,
                        0,
                        1,
                        MPI.OBJECT,
                        0,
                        tag);
            } catch (MPIException aMPIException) {
                log("Exception on " + rank +
                        " MPI.COMM_WORLD.Recv(Object[],0,1,MPI.OBJECT,0,tag)");
                log(aMPIException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.MPIException);
            }
            if (input[0] instanceof Census_CASDataRecord) {
                aCASDataRecord = (Census_CASDataRecord) input[0];
            } else {
                worktodo = false;
                log("Completed processing on rank " + rank);
            }
            if (worktodo) {
                log("Received " + String.valueOf(aCASDataRecord.getZone_Code()) + " to process");
                GeneticAlgorithm_HSARHP_ISARCEP aGeneticAlgorithm_HSARHP_ISARCEP = new GeneticAlgorithm_HSARHP_ISARCEP(
                        this,
                        aCASDataRecord);
                aResult = aGeneticAlgorithm_HSARHP_ISARCEP.getOptimisedResult_ObjectArray();
                if (aResult == null) {
                    log("aResult == null");
                }
                bResult = new Object[2];
                bResult[0] = aCASDataRecord;
                bResult[1] = aResult;
                cResult[0] = bResult;
                try {
                    MPI.COMM_WORLD.Send(
                            cResult,
                            0,
                            1,
                            MPI.OBJECT,
                            0,
                            tag);
                } catch (MPIException aMPIException) {
                    log("Exception on " + rank +
                            " MPI.COMM_WORLD.Send(Object[],0,1,MPI.OBJECT,0,tag)");
                    log(aMPIException.getLocalizedMessage());
                    System.exit(Generic_ErrorAndExceptionHandler.MPIException);
                }
                log("Sent result for " + String.valueOf(aCASDataRecord.getZone_Code()));
            }
        }
    }

    public void optimise_Master(
            int size,
            int rank,
            int tag,
            long[] _StartRecordID_EndRecordID) {
        _Logger.entering(
                this.getClass().getCanonicalName(),
                "initialOptimise_Master(int,int,int,long[])");
        int source;
        long _StartRecordID = _StartRecordID_EndRecordID[0];
        long _EndRecordID = _StartRecordID_EndRecordID[1];
        Census_CASDataRecord aCASDataRecord = null;
        Object[] aResult = null;
        Object[] bResult = null;
        Object[] cResult = new Object[1];
        Status aStatus = null;
        Object[] aConstraintAndPopulation;
        Object[] population;
        Object[] input = new Object[2];
        BigDecimal fitness;
        boolean resultExists = initOutputFiles();
        if (!resultExists) {
            initLogFile(rank);
            long RecordID = _StartRecordID;
            // If fewer jobs than slaves then reduce size
            if ((_EndRecordID - _StartRecordID) < size) {
                log("Number of slave jobs < Number of slaves");
                size = (int) (_EndRecordID - _StartRecordID) + 2;
                log("Size reduced to " + size);
            }
            Request[] tRecvRequests = new Request[size - 1];

            // Send first batch of processing
            for (source = 1; source < size; source++) {
                aCASDataRecord = (Census_CASDataRecord) this._CASDataHandler.getDataRecord(RecordID);
                input[0] = aCASDataRecord;
                log("Send input " + String.valueOf(aCASDataRecord.getZone_Code()) +
                        " to " + source + " and set up receive...");
                try {
                    MPI.COMM_WORLD.Isend(
                            input,
                            0,
                            1,
                            MPI.OBJECT,
                            source,
                            tag);
                } catch (MPIException aMPIException) {
                    log("Exception on " + rank +
                            " MPI.COMM_WORLD.Isend(Object[],0,1,MPI.OBJECT," + source + ",tag)");
                    log(aMPIException.getLocalizedMessage());
                    System.exit(Generic_ErrorAndExceptionHandler.MPIException);
                }
                try {
                    tRecvRequests[source - 1] = MPI.COMM_WORLD.Irecv(
                            cResult,
                            0,
                            1,
                            MPI.OBJECT,
                            source,
                            tag);
                } catch (MPIException aMPIException) {
                    log("Exception on " + rank +
                            " MPI.COMM_WORLD.Irecv(Object[],0,1,MPI.OBJECT," + source + ",tag)");
                    log(aMPIException.getLocalizedMessage());
                    System.exit(Generic_ErrorAndExceptionHandler.MPIException);
                }
                RecordID++;
            }

            // Until process completed loop recieving a result and sending a job
            while (RecordID <= _EndRecordID) {
                aStatus = Request.Waitany(tRecvRequests);
                // source = aStatus.index;
                source = aStatus.source;
                log("Received output from rank " + source);
                bResult = (Object[]) cResult[0];
                aCASDataRecord = (Census_CASDataRecord) bResult[0];
                // aResult is tConstraintAndPopulation and fitness
                aResult = (Object[]) bResult[1];
                aConstraintAndPopulation = (Object[]) aResult[0];
                population = (Object[]) aConstraintAndPopulation[1];
                fitness = (BigDecimal) aResult[1];
                log("Adding result to _Population_HashMap...");
                _Population_HashMap.put(
                        new String(aCASDataRecord.getZone_Code()),
                        population);
                log("Added result to _Population_HashMap.");
//            log(
//                "population.length " + population.length +
//                "population[0] instanceof HashMap " + (population[0] instanceof HashMap) +
//                "population[1] instanceof Vector " + (population[1] instanceof Vector) +
//                "population[2] instanceof HashMap " + (population[2] instanceof HashMap) +
//                "population[3] instanceof Vector " + (population[3] instanceof Vector) +
//                "population[4] instanceof Vector " + (population[4] instanceof Vector) +
//                "population[5] instanceof HashMap " + (population[5] instanceof HashMap) +
//                "population[6] instanceof Vector " + (population[6] instanceof Vector) +
//                "population[7] instanceof HashMap " + (population[7] instanceof HashMap) +
//                "population[8] instanceof Vector " + (population[8] instanceof Vector));
                write_HSARHP_ISARCEP(
                        population,
                        aCASDataRecord,
                        fitness);
                log("Written result for " + String.valueOf(aCASDataRecord.getZone_Code()) +
                        " with fitness " + fitness);
                if (RecordID <= _EndRecordID) {
                    aCASDataRecord = (Census_CASDataRecord) this._CASDataHandler.getDataRecord(RecordID);
                    input[0] = aCASDataRecord;
                    log("Send input " + String.valueOf(aCASDataRecord.getZone_Code()) +
                            " to " + source + " and set up receive...");
                    try {
                        MPI.COMM_WORLD.Isend(
                                input,
                                0,
                                1,
                                MPI.OBJECT,
                                source,
                                tag);
                    } catch (MPIException aMPIException) {
                        log("Exception on " + rank +
                                " MPI.COMM_WORLD.Isend(Object[],0,1,MPI.OBJECT," + source + ",tag)");
                        log(aMPIException.getLocalizedMessage());
                        System.exit(Generic_ErrorAndExceptionHandler.MPIException);
                    }
                    try {
                        tRecvRequests[source - 1] = MPI.COMM_WORLD.Irecv(
                                cResult,
                                0,
                                1,
                                MPI.OBJECT,
                                source,
                                tag);
                    } catch (MPIException aMPIException) {
                        log("Exception on " + rank +
                                " MPI.COMM_WORLD.Irecv(Object[],0,1,MPI.OBJECT," + source + ",tag)");
                        log(aMPIException.getLocalizedMessage());
                        System.exit(Generic_ErrorAndExceptionHandler.MPIException);
                    }
                }
                RecordID++;
            }

            // Collate last jobs
            for (int lastJobs = 1; lastJobs < size; lastJobs++) {
                aStatus = Request.Waitany(tRecvRequests);
                source = aStatus.source;
                log("Received output from rank " + source);
                bResult = (Object[]) cResult[0];
                aCASDataRecord = (Census_CASDataRecord) bResult[0];
                // aResult is tConstraintAndPopulation and fitness
                aResult = (Object[]) bResult[1];
                aConstraintAndPopulation = (Object[]) aResult[0];
                population = (Object[]) aConstraintAndPopulation[1];
                fitness = (BigDecimal) aResult[1];
                _Population_HashMap.put(
                        new String(aCASDataRecord.getZone_Code()),
                        population);
                write_HSARHP_ISARCEP(
                        population,
                        aCASDataRecord,
                        fitness);
                log("Written result for " + String.valueOf(aCASDataRecord.getZone_Code()) +
                        " with fitness " + fitness);
            }
            output_Population_HashMap();
            log("Written out all results for " + _Area);
        }
        _Logger.exiting(
                this.getClass().getCanonicalName(),
                "initialOptimise_Master(int,int,int,long[])");
    }

    public void optimise_Master(
            int size,
            int rank,
            int tag) {
        _Logger.entering(
                this.getClass().getCanonicalName(),
                "initialOptimise_Master(int,int,int)");
        long[] _StartRecordID_EndRecordID;
        TreeSet tLADCodes = null;
        try {
            tLADCodes = _CASDataHandler.getLADCodes_TreeSet();
        } catch (IOException aIOException) {
            log(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
        String aLADCode;
        if (tLADCodes.contains(_Area)) {
            if (_Area == null) {
                log("_Area == null");
            }
            log(_Area);
            init_Population_HashMap();
            _StartRecordID_EndRecordID = get_StartRecordID_EndRecordID(_Area);
            optimise_Master(
                    size,
                    rank,
                    tag,
                    _StartRecordID_EndRecordID);
        } else {
            String _Area0 = _Area;
            boolean doAll = false;
            if (_Area0.equalsIgnoreCase("UK")) {
                doAll = true;
            }
            File _OutputDirectory0 = null;
            try {
                _OutputDirectory0 = _OutputDirectory.getCanonicalFile();
            } catch (IOException aIOException) {
                log(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
            Iterator aIterator = tLADCodes.iterator();
            while (aIterator.hasNext()) {
                aLADCode = (String) aIterator.next();
                if (aLADCode.startsWith(_Area0) || doAll) {
                    log(aLADCode);
                    init_Population_HashMap();
                    try {
                        _OutputDirectory = new File(
                                _OutputDirectory0.getCanonicalPath() +
                                System.getProperty("file.separator") + aLADCode.substring(0, aLADCode.length() - 1) +
                                System.getProperty("file.separator") + aLADCode);
                    } catch (IOException aIOException) {
                        log(aIOException.getLocalizedMessage());
                        System.exit(Generic_ErrorAndExceptionHandler.IOException);
                    }
                    _Area = aLADCode;
                    _StartRecordID_EndRecordID = get_StartRecordID_EndRecordID(_Area);
                    optimise_Master(
                            size,
                            rank,
                            tag,
                            _StartRecordID_EndRecordID);
                }
            }
        }
        // Send halt request...
        Object[] input = new Object[1];
        boolean halt = true;
        input[0] = halt;
        //input[0] can be anything so long as it does not resolve as an instanceof Census_CASDataRecord
        for (int source = 1; source < size; source++) {
            try {
                MPI.COMM_WORLD.Isend(
                        input,
                        0,
                        1,
                        MPI.OBJECT,
                        source,
                        tag);
            } catch (MPIException aMPIException) {
                log("Exception on " + rank +
                        " MPI.COMM_WORLD.Isend(Object[],0,1,MPI.OBJECT," + source + ",tag)");
                log(aMPIException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.MPIException);
            }
            log("Sent halt request to rank " + source);
        }
        _Logger.exiting(
                this.getClass().getCanonicalName(),
                "initialOptimise_Master(int,int,int)");
    }
}
