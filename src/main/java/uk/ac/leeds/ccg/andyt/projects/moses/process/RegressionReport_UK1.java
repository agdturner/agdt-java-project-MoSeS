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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import org.jfree.chart.JFreeChart;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_IO;
import uk.ac.leeds.ccg.andyt.census.core.Census_CASDataHandler;
import uk.ac.leeds.ccg.andyt.census.core.Census_CASDataRecord;
import uk.ac.leeds.ccg.andyt.census.sar.Census_HSARDataHandler;
import uk.ac.leeds.ccg.andyt.census.sar.Census_HSARDataRecord;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataHandler;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataRecord;
import uk.ac.leeds.ccg.andyt.projects.moses.io.OutputDataHandler_OptimisationConstraints;

/**
 * A class for generating maps comparing CAS data with IndividualCensus outputs
 * in the form of regression plots.
 */
public class RegressionReport_UK1 extends RegressionReport {

    public RegressionReport_UK1() {
    }
    String[] _Variables;
    String _AreaLevel;
    String _Type;
    File _Directory;
    Census_CASDataHandler _CASDataHandler;
    Census_HSARDataHandler _HSARDataHandler;
    Census_ISARDataHandler _ISARDataHandler;
    Random _Random;

    /**
     * @param args
     *            the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        new RegressionReport_UK1().run();
    }

    public void run() throws Exception {
        _Directory = new File("/scratch01/Work/Projects/MoSeS/Workspace/");
        _CASDataHandler = new Census_CASDataHandler(_Directory, "");
        _ISARDataHandler = new Census_ISARDataHandler(new File(_Directory, "uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataHandler.thisFile"));
        System.out.println(
                "ISARDataHandler loaded with "
                + _ISARDataHandler.getNDataRecords() + " data records");
        runHSARHP_ISARCEP();
        //runISARHP_ISARCEP();
    }

    public void runISARHP_ISARCEP()
            throws Exception {
        // run( "ControlConstraints", "SSE" );
        // run( "OptimisationConstraints", "SSE" );
        // run( "NonConstraints", "SSE" );
        _Random = new Random(0L);
        //run("ControlConstraints", "NSSE");
        runISARHP_ISARCEP("OptimisationConstraints", "NSSE");
        //run("NonConstraints", "NSSE");
    }

    public void runHSARHP_ISARCEP()
            throws Exception {
        // run( "ControlConstraints", "SSE" );
        // run( "OptimisationConstraints", "SSE" );
        // run( "NonConstraints", "SSE" );
        _HSARDataHandler = new Census_HSARDataHandler(new File(_Directory, "uk.ac.leeds.ccg.andyt.projects.moses.io.HSARDataHandler.thisFile"));
        System.out.println(
                "HSARDataHandler loaded with "
                + _HSARDataHandler.getNDataRecords() + " data records");
        _Random = new Random(0L);
        //run("ControlConstraints", "NSSE");
        runHSARHP_ISARCEP("OptimisationConstraints", "NSSE");
        //run("NonConstraints", "NSSE");
    }

    public void runISARHP_ISARCEP(
            String _Type,
            String _ErrorFunction)
            throws Exception {
        this._Type = _Type;

        //TreeSet<File> results_Files = new TreeSet<File>();

        String outputDirectory1_String = _Directory.toString() + "/Output/OA_ISARHP_ISARCEP_1/UK/";
        //String outputDirectory1_String = _Directory.toString() + "/Output/OA_ISARHP_ISARCEP_Init/UK/";
        //String outputDirectory1_String = _Directory.toString() + "/Output/OA_ISARHP_ISARCEP_Init_UK_OA_2_10_2_2_2_2_0/UK/";

//Uncomment to write out / Comment if not needed
//        // Write out SAR aggregate statistics for optimisation constraints
//        writeAggregateStatisticsForOptimisationConstraints_ISARHP_ISARCEP(
//                outputDirectory1_String);

//Uncomment to write out / Comment if not needed
//        // Write out CAS data for optimisation constraints
//        writeCASOptimisationConstraintsISARHP_ISARCEP(
//                outputDirectory1_String);

        File a_SARFile = new File(
                outputDirectory1_String + "/OptimisationConstraints_SARs.csv");
        File a_CASFile = new File(
                outputDirectory1_String + "/OptimisationConstraints_CAS.csv");

//Uncomment to write out / Comment if not needed
//        writeOutResidualsISARHP_ISARCEP(a_SARFile, a_CASFile);

        String outputName1_String = "ISARHP_ISARCEP_2_1000_2_2_2_2_0_1";
        String outputDirectory2_String = outputDirectory1_String
                + _ErrorFunction + "/"
                + outputName1_String + "/";
        File _InputFile = new File(
                outputDirectory2_String,
                outputName1_String + ".csv");
//
//        String _InputDirectoryName = new String(
//                "/scratch01/Work/Projects/MoSeS/Workspace/");
//
//        AbstractOutputDataHandler _OutputDataHandler = null;
//        if (_Type.equalsIgnoreCase("ControlConstraints")) {
//            _OutputDataHandler = new OutputDataHandler_ControlConstraints();
//        }
//        if (_Type.equalsIgnoreCase("OptimisationConstraints")) {
//            _OutputDataHandler = new OutputDataHandler_OptimisationConstraints();
//        }
//        if (_Type.equalsIgnoreCase("NonConstraints")) {
//            _OutputDataHandler = new OutputDataHandler_NonConstraints();
//        }
//
        this._AreaLevel = "OA"; // MSOA,Ward
        String _Area = "UK"; // UK
        String outputName2_String = outputName1_String;

        this._Variables = new String[0];
        this._Variables = GeneticAlgorithm_ISARHP_ISARCEP.getVariableList().toArray(this._Variables);
        //OutputDataHandler_OptimisationConstraints.getHeader().split(",");

//        long _StartRecordID = 0;//56749L;// 0
//        long _EndRecordID = _StartRecordID + 2438L;// 175433
//        String _OutputFileName;
//
        // URL _BaseURL_1 = new URL(
        // "http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS/documentation/demography/results/2001PopulationInitialisation/"
        // );
        URL _BaseURL_2 = new URL(
                "http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS/documentation/demography/results/2001PopulationInitialisation/"
                + _ErrorFunction
                + "/"
                + outputName2_String
                + "/"
                + _Area
                + "/" + _Type + "/" + _AreaLevel + ".xhtml2.0.html");

        int chartWidth = 300;
        int chartHeight = 300;

        File outputDirectory_File = new File(
                outputDirectory2_String + "/"
                + _Area + "/"
                + _Type);
        outputDirectory_File.mkdirs();
        outputImagesISARHP_ISARCEP(
                a_SARFile,
                a_CASFile,
                outputDirectory_File, //a_SARFile.getParentFile(),
                chartWidth,
                chartHeight);
        File output_File = new File(
                outputDirectory_File.toString()
                + "/" + _AreaLevel + ".xhtml2.0.html");
        writeHTML(
                _BaseURL_2,
                outputName1_String + " " + _Area + " " + _Type + " " + _AreaLevel,
                output_File);
    }

    public void runHSARHP_ISARCEP(
            String _Type,
            String _ErrorFunction)
            throws Exception {
        this._Type = _Type;

        //TreeSet<File> results_Files = new TreeSet<File>();

        String outputDirectory1_String = _Directory.toString() + "/Output/OA_HSARHP_ISARCEP_1/UK/";

//Uncomment to write out / Comment if not needed
        // Write out SAR aggregate statistics for optimisation constraints
        writeAggregateStatisticsForOptimisationConstraints_HSARHP_ISARCEP(
                outputDirectory1_String);

//Uncomment to write out / Comment if not needed
        // Write out CAS data for optimisation constraints
        writeCASOptimisationConstraintsHSARHP_ISARCEP(
                outputDirectory1_String);

        File a_SAR_File = new File(
                outputDirectory1_String + "/OptimisationConstraints_SARs.csv");
        File a_CAS_File = new File(
                outputDirectory1_String + "/OptimisationConstraints_CAS.csv");

//Uncomment to write out / Comment if not needed
        writeOutResidualsHSARHP_ISARCEP(a_SAR_File, a_CAS_File);

        String outputName1_String = "HSARHP_ISARCEP_2_1000_2_2_2_2_0_1";
        String outputDirectory2_String = outputDirectory1_String
                + _ErrorFunction + "/"
                + outputName1_String + "/";
        File _InputFile = new File(
                outputDirectory2_String,
                outputName1_String + ".csv");
//
//        String _InputDirectoryName = new String(
//                "/scratch01/Work/Projects/MoSeS/Workspace/");
//
//        AbstractOutputDataHandler _OutputDataHandler = null;
//        if (_Type.equalsIgnoreCase("ControlConstraints")) {
//            _OutputDataHandler = new OutputDataHandler_ControlConstraints();
//        }
//        if (_Type.equalsIgnoreCase("OptimisationConstraints")) {
//            _OutputDataHandler = new OutputDataHandler_OptimisationConstraints();
//        }
//        if (_Type.equalsIgnoreCase("NonConstraints")) {
//            _OutputDataHandler = new OutputDataHandler_NonConstraints();
//        }
//
        this._AreaLevel = "OA"; // MSOA,Ward
        String _Area = "UK"; // UK
        String outputName2_String = outputName1_String;

        this._Variables = new String[0];
        this._Variables = GeneticAlgorithm_HSARHP_ISARCEP.getVariableList().toArray(this._Variables);
        //this._Variables = OutputDataHandler_OptimisationConstraints.getHeader().split(",");

//        long _StartRecordID = 0;//56749L;// 0
//        long _EndRecordID = _StartRecordID + 2438L;// 175433
//        String _OutputFileName;
//
        // URL _BaseURL_1 = new URL(
        // "http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS/documentation/demography/results/2001PopulationInitialisation/"
        // );
        URL _BaseURL_2 = new URL(
                "http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS/documentation/demography/results/2001PopulationInitialisation/"
                + _ErrorFunction
                + "/"
                + outputName2_String
                + "/"
                + _Area
                + "/" + _Type + "/" + _AreaLevel + ".xhtml2.0.html");
        int chartWidth = 500;
        int chartHeight = 500;
        File outputDirectory_File = new File(
                outputDirectory2_String + "/"
                + _Area + "/"
                + _Type);
        outputDirectory_File.mkdirs();
        outputImagesHSARHP_ISARCEP(
                a_SAR_File,
                a_CAS_File,
                outputDirectory_File, //a_SARFile.getParentFile(),
                chartWidth,
                chartHeight);
        File output_File = new File(
                outputDirectory_File.toString()
                + "/" + _AreaLevel + ".xhtml2.0.html");
        writeHTML(
                _BaseURL_2,
                outputName1_String + " " + _Area + " " + _Type + " " + _AreaLevel,
                output_File);
    }

    protected static TreeMap<String, double[]> loadCASOptimistaionConstraints(
            File dataFile)
            throws IOException {
        TreeMap<String, double[]> result = new TreeMap<String, double[]>();
        BufferedReader a_BufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(dataFile)));
        boolean read = true;
        String line = a_BufferedReader.readLine(); // read header
        String oa_code;
        String[] fields;
        double[] values;
        while (read) {
            try {
                line = a_BufferedReader.readLine();
                if (line != null) {
                    fields = line.split(",");
                    oa_code = fields[0];
                    values = new double[fields.length - 1];
                    for (int i = 0; i < fields.length - 1; i++) {
                        values[i] = new Double(fields[i + 1]);
                    }
                    result.put(oa_code, values);
                } else {
                    read = false;
                }
            } catch (IOException a_IOException) {
                // File read continue...
                read = false;
            }
        }
        return result;
    }

    /**
     *
     * @param a_SAR_File
     * @param a_CAS_File
     * @return Object[] result where;
     * result[0] is a String[] of variable names
     * result[1] is a double[number of variables][no of data items]
     * of a_SAR_data
     * result[2] is a double[number of variables][no of data items]
     * of a_CAS_data
     * @throws IOException
     */
    protected static Object[] loadDataISARHP_ISARCEP(
            File a_SAR_File,
            File a_CAS_File)
            throws IOException {
        Object[] result = new Object[3];

        TreeMap<String, double[]> a_SAROptimistaionConstraints_TreeMap = loadCASOptimistaionConstraints(a_SAR_File);
        TreeMap<String, double[]> a_CASOptimistaionConstraints_TreeMap = loadCASOptimistaionConstraints(a_CAS_File);

        Vector<String> variables = GeneticAlgorithm_ISARHP_ISARCEP.getVariableList();
        variables.add(0, "Zone_Code");
        String[] variableNames = new String[0];
        variableNames = variables.toArray(variableNames);
        result[0] = variableNames;

        // Format (Flip) data
        double[][] a_SAR_Data = new double[variables.size() - 1][a_SAROptimistaionConstraints_TreeMap.size()];
        double[][] a_CAS_Data = new double[variables.size() - 1][a_SAROptimistaionConstraints_TreeMap.size()];
        String oa;
        double[] a_SARExpectedRow;
        double[] a_CASObservedRow;
        int j = 0;
        Iterator<String> iterator_String = a_SAROptimistaionConstraints_TreeMap.keySet().iterator();
        while (iterator_String.hasNext()) {
            oa = iterator_String.next();
            a_SARExpectedRow = a_SAROptimistaionConstraints_TreeMap.get(oa);
            a_CASObservedRow = a_CASOptimistaionConstraints_TreeMap.get(oa);
            if (a_SARExpectedRow == null) {
                System.out.println("Warning a_SARExpectedRow == null in loadDataISARHP_ISARCEP(File,File) for OA " + oa);
            } else {
                if (a_CASObservedRow == null) {
                    System.out.println("Warning a_CASObservedRow == null in loadDataISARHP_ISARCEP(File,File) for OA " + oa);
                } else {
                    for (int i = 0; i < variables.size() - 1; i++) {
                        a_SAR_Data[i][j] = a_SARExpectedRow[i];
                        a_CAS_Data[i][j] = a_CASObservedRow[i];
                    }
                }
            }
            j++;
        }
        result[1] = a_SAR_Data;
        result[2] = a_CAS_Data;
        return result;
    }

    protected static Object[] loadDataHSARHP_ISARCEP(
            File a_SARFile,
            File a_CASFile)
            throws IOException {
        Object[] result = new Object[3];
        TreeMap<String, double[]> a_SAROptimistaionConstraints = loadCASOptimistaionConstraints(a_SARFile);
        TreeMap<String, double[]> a_CASOptimistaionConstraints = loadCASOptimistaionConstraints(a_CASFile);
        Vector<String> variables = GeneticAlgorithm_HSARHP_ISARCEP.getVariableList();
        variables.add(0, "Zone_Code");
        String[] variableNames = new String[0];
        variableNames = variables.toArray(variableNames);
        result[0] = variableNames;
        // Format (Flip) data
        double[][] a_SARExpectedData = new double[variables.size() - 1][a_SAROptimistaionConstraints.size()];
        double[][] a_CASObservedData = new double[variables.size() - 1][a_SAROptimistaionConstraints.size()];
        String oa;
        double[] a_SARExpectedRow;
        double[] a_CASObservedRow;
        int j = 0;
        Iterator<String> iterator_String = a_SAROptimistaionConstraints.keySet().iterator();
        while (iterator_String.hasNext()) {
            oa = iterator_String.next();
            a_SARExpectedRow = a_SAROptimistaionConstraints.get(oa);
            a_CASObservedRow = a_CASOptimistaionConstraints.get(oa);
//            if (oa.equalsIgnoreCase("00AAFQ0013")){
//                System.out.println(oa);
//            }
            if (a_SARExpectedRow == null) {
                System.out.println("Warning a_SARExpectedRow == null in loadDataHSARHP_ISARCEP(File,File) for OA " + oa);
            } else {
                if (a_CASObservedRow == null) {
                    System.out.println("Warning a_SARExpectedRow == null in loadDataHSARHP_ISARCEP(File,File) for OA " + oa);
                } else {
                    for (int i = 0; i < variables.size() - 1; i++) {
                        a_SARExpectedData[i][j] = a_SARExpectedRow[i];
                        a_CASObservedData[i][j] = a_CASObservedRow[i];
                    }
                }
            }
            j++;
        }
        result[1] = a_SARExpectedData;
        result[2] = a_CASObservedData;
        return result;
    }

    public void writeCASOptimisationConstraintsISARHP_ISARCEP(
            String a_OutputDir_String)
            throws Exception {
        File optimisationConstraints_File = new File(
                a_OutputDir_String,
                "OptimisationConstraints_CAS.csv");
        FileOutputStream a_FileOutputStream = new FileOutputStream(
                optimisationConstraints_File);
        OutputDataHandler_OptimisationConstraints.writeISARHP_ISARCEPHeader(a_FileOutputStream);
        a_FileOutputStream.flush();
        TreeSet a_OACodes_TreeSet = _CASDataHandler.getOACodes_TreeSet();
        Census_CASDataRecord a_CASDataRecord;
        Iterator a_OACodes_Iterator = a_OACodes_TreeSet.iterator();
        String a_OACode;
        while (a_OACodes_Iterator.hasNext()) {
            a_OACode = (String) a_OACodes_Iterator.next();
            a_CASDataRecord = (Census_CASDataRecord) _CASDataHandler.getDataRecord(a_OACode);
            Object[] fitnessCounts = GeneticAlgorithm_ISARHP_ISARCEP.getFitnessCounts(a_CASDataRecord);
            OutputDataHandler_OptimisationConstraints.writeISARHP_ISARCEP(
                    (HashMap<String, Integer>) fitnessCounts[0],
                    a_OACode,
                    a_FileOutputStream);
        }
        a_FileOutputStream.close();
    }

    public void writeCASOptimisationConstraintsHSARHP_ISARCEP(
            String a_OutputDir_String)
            throws Exception {
        File optimisationConstraints_File = new File(
                a_OutputDir_String,
                "OptimisationConstraints_CAS.csv");
        FileOutputStream a_FileOutputStream = new FileOutputStream(
                optimisationConstraints_File);
        OutputDataHandler_OptimisationConstraints.writeHSARHP_ISARCEPHeader(a_FileOutputStream);
        a_FileOutputStream.flush();
        TreeSet a_OACodes_TreeSet = _CASDataHandler.getOACodes_TreeSet();
        Census_CASDataRecord a_CASDataRecord;
        Iterator a_OACodes_Iterator = a_OACodes_TreeSet.iterator();
        String a_OACode;
        while (a_OACodes_Iterator.hasNext()) {
            a_OACode = (String) a_OACodes_Iterator.next();
            a_CASDataRecord = (Census_CASDataRecord) _CASDataHandler.getDataRecord(a_OACode);
            Object[] fitnessCounts = GeneticAlgorithm_HSARHP_ISARCEP.getFitnessCounts(a_CASDataRecord);
            OutputDataHandler_OptimisationConstraints.writeHSARHP_ISARCEP(
                    (HashMap<String, Integer>) fitnessCounts[0],
                    a_OACode,
                    a_FileOutputStream);
        }
        a_FileOutputStream.close();
    }

    public void writeAggregateStatisticsForOptimisationConstraints_ISARHP_ISARCEP(
            String a_OutputDir_String)
            throws Exception {
        HashMap a_ID_RecordID_HashMap = _ISARDataHandler.get_ID_RecordID_HashMap();
        File optimisationConstraints_SARs =
                new File(
                a_OutputDir_String,
                "OptimisationConstraints_SARs.csv");
        FileOutputStream a_FileOutputStream = new FileOutputStream(
                optimisationConstraints_SARs);
        OutputDataHandler_OptimisationConstraints.writeHSARHP_ISARCEPHeader(a_FileOutputStream);
        a_FileOutputStream.flush();
        Object[] fitnessCounts;
        HashMap<String, Integer> a_SARCounts = null;
        TreeSet<String> a_LADCodes_TreeSet = _CASDataHandler.getLADCodes_TreeSet();
        String s2;
        String s1;
        Iterator<String> a_Iterator_String = a_LADCodes_TreeSet.iterator();
        while (a_Iterator_String.hasNext()) {
            // Need to reorder data for each LAD as OAs not necessarily returned
            // in any order and an ordered result is wanted
            TreeMap<String, HashMap<String, Integer>> resultsForLAD =
                    new TreeMap<String, HashMap<String, Integer>>();
            boolean setPrevious_OA_String = true;
            s1 = a_Iterator_String.next();
            s2 = s1.substring(0, 3);
            File resultsFile = new File(
                    a_OutputDir_String + s2 + "/" + s1 + "/population.csv");
            // A few results are missing
            if (resultsFile.exists()) {
                System.out.println(resultsFile.toString() + " exists");
                String previous_OA_String = "";
                BufferedReader aBufferedReader =
                        new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream(resultsFile)));
                StreamTokenizer aStreamTokenizer =
                        new StreamTokenizer(aBufferedReader);
                Generic_IO.setStreamTokenizerSyntax1(aStreamTokenizer);
                String line = "";
                int tokenType = aStreamTokenizer.nextToken();
                while (tokenType != StreamTokenizer.TT_EOF) {
                    switch (tokenType) {
                        case StreamTokenizer.TT_EOL:
                            //System.out.println(line);
                            String[] lineFields = line.split(",");
                            String a_OA_String = lineFields[0];
                            if (previous_OA_String.equalsIgnoreCase(a_OA_String)) {
                                if (lineFields[1].equalsIgnoreCase("HP")) {
                                    //System.out.println("HP");
                                    long a_ISARRecordID = (Long) a_ID_RecordID_HashMap.get(new Long(lineFields[2]));
                                    Census_ISARDataRecord a_ISARDataRecord = _ISARDataHandler.getISARDataRecord(a_ISARRecordID);
                                    GeneticAlgorithm_ISARHP_ISARCEP.addToCountsHP(
                                            a_ISARDataRecord,
                                            a_SARCounts,
                                            _Random);
                                    //System.out.println(a_HSARDataRecord.toString());
                                } else {
                                    //System.out.println("CEP");
                                    // From the id of the Census_ISARDataRecord get the
                                    // ISARRecordID.
                                    long a_ISARRecordID = (Long) a_ID_RecordID_HashMap.get(new Long(lineFields[2]));
                                    Census_ISARDataRecord a_ISARDataRecord = _ISARDataHandler.getISARDataRecord(a_ISARRecordID);
                                    GeneticAlgorithm_ISARHP_ISARCEP.addToCountsCEP(
                                            a_ISARDataRecord,
                                            a_SARCounts,
                                            _Random);
                                }
                            } else {
                                // Store result
                                if (setPrevious_OA_String) {
                                    previous_OA_String = a_OA_String;
                                    setPrevious_OA_String = false;
                                } else {
                                    // Store
                                    resultsForLAD.put(
                                            previous_OA_String,
                                            a_SARCounts);
                                }
                                // Initialise/Re-initialise
                                Census_CASDataRecord a_CASDataRecord = (Census_CASDataRecord) _CASDataHandler.getDataRecord(a_OA_String);
                                fitnessCounts = GeneticAlgorithm_ISARHP_ISARCEP.getFitnessCounts(a_CASDataRecord);
                                a_SARCounts = (HashMap<String, Integer>) fitnessCounts[1];
                                // Start a new aggregation
                                if (lineFields[1].equalsIgnoreCase("HP")) {
                                    //System.out.println("HP");
                                    long a_ISARRecordID = (Long) a_ID_RecordID_HashMap.get(new Long(lineFields[2]));
                                    Census_ISARDataRecord a_ISARDataRecord = _ISARDataHandler.getISARDataRecord(a_ISARRecordID);
                                    GeneticAlgorithm_ISARHP_ISARCEP.addToCountsHP(
                                            a_ISARDataRecord,
                                            a_SARCounts,
                                            _Random);
                                    //System.out.println(a_HSARDataRecord.toString());
                                } else {
                                    //System.out.println("CEP");
                                    // From the id of the Census_ISARDataRecord get the
                                    // ISARRecordID.
                                    long a_ISARRecordID = (Long) a_ID_RecordID_HashMap.get(new Long(lineFields[2]));
                                    Census_ISARDataRecord a_ISARDataRecord = _ISARDataHandler.getISARDataRecord(a_ISARRecordID);
                                    GeneticAlgorithm_ISARHP_ISARCEP.addToCountsCEP(
                                            a_ISARDataRecord,
                                            a_SARCounts,
                                            _Random);
                                    //System.out.println(a_ISARDataRecord.toString());
                                }
                                //a_OA_String = lineFields[0];
                            }
                            previous_OA_String = a_OA_String;
                            break;
                        case StreamTokenizer.TT_WORD:
                            line = aStreamTokenizer.sval;
                            break;
                    }
                    tokenType = aStreamTokenizer.nextToken();
                }
            } else {
                System.out.println(resultsFile.toString() + " !exists");
            }
            Iterator<String> string_Iterator = resultsForLAD.keySet().iterator();
            while (string_Iterator.hasNext()) {
                String oa_Code = string_Iterator.next();
                a_SARCounts = resultsForLAD.get(oa_Code);
                //GeneticAlgorithm_ISARHP_ISARCEP.addToCountsCEP(null, a_ID_RecordID_HashMap, _Random)
                OutputDataHandler_OptimisationConstraints.writeISARHP_ISARCEP(
                        a_SARCounts,
                        oa_Code,
                        a_FileOutputStream);
            }
        }
        a_FileOutputStream.close();
    }

    public void writeAggregateStatisticsForOptimisationConstraints_HSARHP_ISARCEP(
            String a_OutputDir_String)
            throws Exception {
        HashMap a_HID_HSARDataRecordVector_HashMap = _HSARDataHandler.get_HID_HSARDataRecordVector_HashMap();
        HashMap a_ID_RecordID_HashMap = _ISARDataHandler.get_ID_RecordID_HashMap();
        File optimisationConstraints_SARs =
                new File(
                a_OutputDir_String,
                "OptimisationConstraints_SARs.csv");
        FileOutputStream a_FileOutputStream = new FileOutputStream(
                optimisationConstraints_SARs);
        OutputDataHandler_OptimisationConstraints.writeHSARHP_ISARCEPHeader(a_FileOutputStream);
        a_FileOutputStream.flush();
        HashMap<String, Integer> a_SARCounts = null;
        Census_CASDataRecord a_CASDataRecord;
        TreeSet<String> a_LADCodes_TreeSet = _CASDataHandler.getLADCodes_TreeSet();
        String s2;
        String s1;
        Iterator<String> a_Iterator_String = a_LADCodes_TreeSet.iterator();
        while (a_Iterator_String.hasNext()) {
            // Need to reorder data for each LAD as OAs not necessarily returned
            // in any order and an ordered result is wanted
            TreeMap<String, HashMap<String, Integer>> resultsForLAD =
                    new TreeMap<String, HashMap<String, Integer>>();
            boolean setPrevious_OA_String = true;
            s1 = a_Iterator_String.next();
            s2 = s1.substring(0, 3);
            File resultsFile = new File(
                    a_OutputDir_String + s2 + "/" + s1 + "/population.csv");
            // A few results are missing
            if (resultsFile.exists()) {
                System.out.println(resultsFile.toString() + " exists");
                String previous_OA_String = "";
                BufferedReader aBufferedReader =
                        new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream(resultsFile)));
                StreamTokenizer aStreamTokenizer =
                        new StreamTokenizer(aBufferedReader);
                Generic_IO.setStreamTokenizerSyntax1(aStreamTokenizer);
                String line = "";
                int tokenType = aStreamTokenizer.nextToken();
                while (tokenType != StreamTokenizer.TT_EOF) {
                    switch (tokenType) {
                        case StreamTokenizer.TT_EOL:
                            //System.out.println(line);
                            String[] lineFields = line.split(",");
                            String a_OA_String = lineFields[0];
                            if (previous_OA_String.equalsIgnoreCase(a_OA_String)) {
                                if (lineFields[1].equalsIgnoreCase("HP")) {
                                    //System.out.println("HP");
                                    // From the id of a household get a Vector 
                                    // of HSARDataRecords
                                    Vector household = (Vector) a_HID_HSARDataRecordVector_HashMap.get(new Integer(lineFields[2]));
                                    Census_HSARDataRecord a_HSARDataRecord;
                                    for (int i = 0; i < household.size(); i++) {
                                        a_HSARDataRecord = (Census_HSARDataRecord) household.elementAt(i);
                                        GeneticAlgorithm_HSARHP_ISARCEP.addToCounts(
                                                a_HSARDataRecord,
                                                a_SARCounts,
                                                _Random);
                                    }
                                    //System.out.println(a_HSARDataRecord.toString());
                                } else {
                                    //System.out.println("CEP");
                                    // From the id of the Census_ISARDataRecord get the
                                    // ISARRecordID.
                                    long a_ISARRecordID = (Long) a_ID_RecordID_HashMap.get(new Long(lineFields[2]));
                                    Census_ISARDataRecord a_ISARDataRecord = _ISARDataHandler.getISARDataRecord(a_ISARRecordID);
                                    GeneticAlgorithm_HSARHP_ISARCEP.addToCountsCEP(
                                            a_ISARDataRecord,
                                            a_SARCounts,
                                            _Random);
                                }
                            } else {
                                // Store result
                                if (setPrevious_OA_String) {
                                    previous_OA_String = a_OA_String;
                                    setPrevious_OA_String = false;
                                } else {
                                    // Store
                                    resultsForLAD.put(
                                            previous_OA_String,
                                            a_SARCounts);
                                }
                                // Initialise/Re-initialise
                                a_CASDataRecord = (Census_CASDataRecord) _CASDataHandler.getDataRecord(a_OA_String);
                                Object[] fitnessCounts = GeneticAlgorithm_HSARHP_ISARCEP.getFitnessCounts(a_CASDataRecord);
                                a_SARCounts = (HashMap<String, Integer>) fitnessCounts[1];
                                // Start a new aggregation
                                if (lineFields[1].equalsIgnoreCase("HP")) {
                                    //System.out.println("HP");
                                    // From the id of a household get a Vector
                                    // of HSARDataRecords
                                    Vector household = (Vector) a_HID_HSARDataRecordVector_HashMap.get(new Integer(lineFields[2]));
                                    Census_HSARDataRecord a_HSARDataRecord;
                                    for (int i = 0; i < household.size(); i++) {
                                        a_HSARDataRecord = (Census_HSARDataRecord) household.elementAt(i);
                                        GeneticAlgorithm_HSARHP_ISARCEP.addToCounts(
                                                a_HSARDataRecord,
                                                a_SARCounts,
                                                _Random);
                                    }
                                    //System.out.println(a_HSARDataRecord.toString());
                                } else {
                                    //System.out.println("CEP");
                                    // From the id of the Census_ISARDataRecord get the
                                    // ISARRecordID.
                                    long a_ISARRecordID = (Long) a_ID_RecordID_HashMap.get(new Long(lineFields[2]));
                                    Census_ISARDataRecord a_ISARDataRecord = _ISARDataHandler.getISARDataRecord(a_ISARRecordID);
                                    GeneticAlgorithm_HSARHP_ISARCEP.addToCountsCEP(
                                            a_ISARDataRecord,
                                            a_SARCounts,
                                            _Random);
                                    //System.out.println(a_ISARDataRecord.toString());
                                }
                                //a_OA_String = lineFields[0];
                            }
                            previous_OA_String = a_OA_String;
                            break;
                        case StreamTokenizer.TT_WORD:
                            line = aStreamTokenizer.sval;
                            break;
                    }
                    tokenType = aStreamTokenizer.nextToken();
                }
            } else {
                System.out.println(resultsFile.toString() + " !exists");
            }
            Iterator<String> string_Iterator = resultsForLAD.keySet().iterator();
            while (string_Iterator.hasNext()) {
                String oa_Code = string_Iterator.next();
                OutputDataHandler_OptimisationConstraints.writeHSARHP_ISARCEP(
                        resultsForLAD.get(oa_Code),
                        oa_Code,
                        a_FileOutputStream);
            }
        }
        a_FileOutputStream.close();
    }

    public void writeOutResidualsISARHP_ISARCEP(
            File observed_File,
            File expected_File)
            throws Exception {
        File outputFile = new File(observed_File.getParentFile(), "residuals.csv");
        FileOutputStream a_FileOutputStream = new FileOutputStream(outputFile);
        TreeMap<String, double[]> a_SAROptimistaionConstraints = loadCASOptimistaionConstraints(observed_File);
        TreeMap<String, double[]> a_CASOptimistaionConstraints = loadCASOptimistaionConstraints(expected_File);
        String line = OutputDataHandler_OptimisationConstraints.getISARHP_ISARCEPHeader();
        String[] variableNames = line.split(",");
        a_FileOutputStream.write(line.getBytes());
        a_FileOutputStream.write(StreamTokenizer.TT_EOL);
        a_FileOutputStream.flush();
        String oa;
        double[] a_SARExpectedRow;
        double[] a_CASObservedRow;
        double[] a_Residual;
        Iterator<String> iterator_String = a_SAROptimistaionConstraints.keySet().iterator();
        while (iterator_String.hasNext()) {
            oa = iterator_String.next();
            line = oa + ",";
            a_SARExpectedRow = a_SAROptimistaionConstraints.get(oa);
            a_CASObservedRow = a_CASOptimistaionConstraints.get(oa);
            a_Residual = new double[a_SARExpectedRow.length];
            for (int i = 0; i < a_SARExpectedRow.length; i++) {
                a_Residual[i] = a_SARExpectedRow[i] - a_CASObservedRow[i];
                if (i == a_SARExpectedRow.length - 1) {
                    line += a_Residual[i];
                } else {
                    line += a_Residual[i] + ",";
                }
            }
            a_FileOutputStream.write(line.getBytes());
            a_FileOutputStream.write(StreamTokenizer.TT_EOL);
            a_FileOutputStream.flush();
        }
    }

    public void writeOutResidualsHSARHP_ISARCEP(
            File observed_File,
            File expected_File)
            throws Exception {
        File outputFile = new File(observed_File.getParentFile(), "residuals.csv");
        FileOutputStream a_FileOutputStream = new FileOutputStream(outputFile);
        TreeMap<String, double[]> a_SAROptimistaionConstraints = loadCASOptimistaionConstraints(observed_File);
        TreeMap<String, double[]> a_CASOptimistaionConstraints = loadCASOptimistaionConstraints(expected_File);
        String line = OutputDataHandler_OptimisationConstraints.getHSARHP_ISARCEPHeader();
        String[] variableNames = line.split(",");
        a_FileOutputStream.write(line.getBytes());
        a_FileOutputStream.write(StreamTokenizer.TT_EOL);
        a_FileOutputStream.flush();
        String oa;
        double[] a_SARExpectedRow;
        double[] a_CASObservedRow;
        double[] a_Residual;
        Iterator<String> iterator_String = a_SAROptimistaionConstraints.keySet().iterator();
        while (iterator_String.hasNext()) {
            oa = iterator_String.next();
            line = oa + ",";
            a_SARExpectedRow = a_SAROptimistaionConstraints.get(oa);
            a_CASObservedRow = a_CASOptimistaionConstraints.get(oa);
            a_Residual = new double[a_SARExpectedRow.length];
            for (int i = 0; i < a_SARExpectedRow.length; i++) {
                a_Residual[i] = a_SARExpectedRow[i] - a_CASObservedRow[i];
                if (i == a_SARExpectedRow.length - 1) {
                    line += a_Residual[i];
                } else {
                    line += a_Residual[i] + ",";
                }
            }
            a_FileOutputStream.write(line.getBytes());
            a_FileOutputStream.write(StreamTokenizer.TT_EOL);
            a_FileOutputStream.flush();
        }
    }

    public void outputImagesHSARHP_ISARCEP(
            File a_SAR_File,
            File a_CAS_File,
            File outputDirectory,
            int chartWidth,
            int chartHeight)
            throws Exception {
        Object[] data = loadDataHSARHP_ISARCEP(a_SAR_File, a_CAS_File);
        this._Variables = (String[]) data[0];
        double[][] a_SARExpectedData = (double[][]) data[1];
        double[][] a_CASObservedData = (double[][]) data[2];
        String xAxisLabel_String = "Model estimate (X)";
        String yAxisLabel_String = "Constraint (Y)";
        JFreeChart[] _ScatterPlots = createScatterPlots(
                this._Variables,
                a_SARExpectedData,
                a_CASObservedData,
                xAxisLabel_String,
                yAxisLabel_String);
        Object[] t_RegressionParametersAndCreateXYLineCharts =
                getRegressionParametersAndCreateXYLineCharts(
                this._Variables,
                a_SARExpectedData,
                a_CASObservedData);
        JFreeChart[] t_RegressionCharts = createRegressionCharts(_ScatterPlots,
                t_RegressionParametersAndCreateXYLineCharts);
        String type = "PNG";
        outputImages(
                t_RegressionCharts, this._Variables, chartWidth,
                chartHeight, this._AreaLevel, outputDirectory, type);
        type = "TIFF";
        outputImages(
                t_RegressionCharts, this._Variables, chartWidth,
                chartHeight, this._AreaLevel, outputDirectory, type);
    }

    public void outputImagesISARHP_ISARCEP(
            File a_SAR_File, // Model estimate
            File a_CAS_File, // Constraint
            File outputDirectory,
            int chartWidth,
            int chartHeight)
            throws Exception {
        Object[] data = loadDataISARHP_ISARCEP(
                a_SAR_File,
                a_CAS_File);
        this._Variables = (String[]) data[0];
        double[][] a_SARExpectedData = (double[][]) data[1];
        double[][] a_CASObservedData = (double[][]) data[2];
        String xAxisLabel_String = "Model estimate (X)";
        String yAxisLabel_String = "Constraint (Y)";
        JFreeChart[] t_ScatterPlots = createScatterPlots(
                this._Variables,
                a_SARExpectedData,
                a_CASObservedData,
                xAxisLabel_String,
                yAxisLabel_String);
        Object[] t_RegressionParametersAndCreateXYLineCharts =
                getRegressionParametersAndCreateXYLineCharts(
                this._Variables,
                a_SARExpectedData,
                a_CASObservedData);
        JFreeChart[] t_RegressionCharts = createRegressionCharts(
                t_ScatterPlots,
                t_RegressionParametersAndCreateXYLineCharts);
        String type = "PNG";
        outputImages(
                t_RegressionCharts,
                this._Variables,
                chartWidth,
                chartHeight,
                this._AreaLevel,
                outputDirectory,
                type);
        type = "TIFF";
        outputImages(
                t_RegressionCharts, this._Variables, chartWidth,
                chartHeight, this._AreaLevel, outputDirectory, type);
    }

    public void runOA(
            String baseURL,
            String directoryCASObserved,
            String directory,
            String filenamePrefix,
            String filenameSuffix,
            String aOutputName,
            int int_MainBodyControlSwitch)
            throws Exception {
        String filenameMidfix = "_" + aOutputName + "OA";
        Object[] _Data = loadData(
                new File(directory + filenamePrefix,
                filenamePrefix + filenameMidfix + ".csv"),
                new File(
                directoryCASObserved, aOutputName + "OA.csv"));
        String[] _Variables = (String[]) _Data[0];
        double[][] _SARExpectedData = (double[][]) _Data[1];
        double[][] _CASObservedData = (double[][]) _Data[2];
        String xAxisLabel = "CAS Estimation (Observed)";
        String yAxisLabel = "SAR Prediction (Expected)";
        JFreeChart[] _ScatterPlots = createScatterPlots(_Variables,
                _SARExpectedData, _CASObservedData, xAxisLabel, yAxisLabel);
        Object[] _RegressionParametersAndCreateXYLineCharts = getRegressionParametersAndCreateXYLineCharts(
                _Variables, _SARExpectedData, _CASObservedData);
        JFreeChart[] _RegressionCharts = createRegressionCharts(_ScatterPlots,
                _RegressionParametersAndCreateXYLineCharts);
        String type = "PNG";
        // outputImages( _ScatterPlots, directory + filenamePrefix +
        // "_ScatterPlot", type );
        // outputImages( _XYLineCharts, directory + filenamePrefix + "/" +
        // filenamePrefix + "_XYLineChart", type );
        outputImages(
                _RegressionCharts, 500, 500, directory + filenamePrefix
                + "/", filenamePrefix + filenameMidfix + "_RegressionChart",
                type);
        writeHTML(
                baseURL, directory + filenamePrefix + "/", filenamePrefix
                + filenameMidfix, filenameSuffix, int_MainBodyControlSwitch);
    }

    public void writeHTMLBodyMain(
            byte[] _LineSeparator,
            URL _BaseURL,
            FileOutputStream a_FileOutputStream)
            throws IOException {
        writeHTMLBodyMain1(
                _LineSeparator,
                _BaseURL,
                a_FileOutputStream);
    }

    public void writeHTMLBodyMain(byte[] _LineSeparator, String _BaseURL,
            String filenamePrefix, String filenameSuffix,
            FileOutputStream a_FileOutputStream, int int_MainBodyControlSwitch)
            throws IOException {
        if (int_MainBodyControlSwitch == 1) {
            writeHTMLBodyMain1(_LineSeparator, _BaseURL, filenamePrefix,
                    filenameSuffix, a_FileOutputStream);
        }
    }

    public void writeHTMLBodyMain1(byte[] _LineSeparator, String _BaseURL,
            String filenamePrefix, String filenameSuffix,
            FileOutputStream a_FileOutputStream) throws IOException {
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("<div>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("<ul>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write(("<li><h2>" + filenamePrefix
                + "</h2>").getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("<ul>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("<li><h3>Control constraints</h3>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("<ul>".getBytes());
        for (int i = 0; i
                < 38; i++) {
            a_FileOutputStream.write(_LineSeparator);
            a_FileOutputStream.write(("<li><img src=\""
                    + filenamePrefix + "_RegressionChart" + i
                    + ".PNG\" /></li>").getBytes());
            a_FileOutputStream.write(_LineSeparator);
        }
        a_FileOutputStream.write("</ul></li>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("</ul>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("</div>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
    }

    public void writeHTMLBodyMain1(byte[] _LineSeparator, URL _BaseURL,
            FileOutputStream a_FileOutputStream) throws IOException {
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("<div>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("<ul>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write(("<li><h2>" + this._Type + "</h2>").getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("<ul>".getBytes());
        for (int i = 0; i < this._Variables.length - 1; i++) {
            a_FileOutputStream.write(_LineSeparator);
            a_FileOutputStream.write(("<li><img src=\""
                    + this._AreaLevel + this._Variables[i + 1]
                    + ".PNG\" /></li>").getBytes());
            a_FileOutputStream.write(_LineSeparator);
        }
        a_FileOutputStream.write("</ul></li>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("</ul>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
        a_FileOutputStream.write("</div>".getBytes());
        a_FileOutputStream.write(_LineSeparator);
    }
}
