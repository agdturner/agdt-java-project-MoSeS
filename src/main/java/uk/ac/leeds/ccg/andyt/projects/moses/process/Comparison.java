/**
 * A component of a library for
 * <a href="http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS">MoSeS</a>.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.
 */
package uk.ac.leeds.ccg.andyt.projects.moses.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import org.jfree.chart.JFreeChart;
import uk.ac.leeds.ccg.andyt.math.Math_BigDecimal;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS001DataHandler;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS001DataRecord;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS002DataHandler;
import uk.ac.leeds.ccg.andyt.census.cas.Census_CAS002DataRecord;
import uk.ac.leeds.ccg.andyt.census.core.Census_CASDataHandler;
import uk.ac.leeds.ccg.andyt.census.cas.uv.Census_CASUV003DataHandler;
import uk.ac.leeds.ccg.andyt.census.cas.uv.Census_CASUV003DataRecord;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_IO;
import uk.ac.leeds.ccg.andyt.projects.moses.io.ToyModelDataHandler;
import uk.ac.leeds.ccg.andyt.projects.moses.io.ToyModelDataRecord_2;

/**
 * For producing a set of comparison regression reports.
 */
public class Comparison extends RegressionReport {

    /**
     * Creates a new instance of OAPopulationComparison
     */
    public Comparison() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Comparison().run();
    }

    public void run() {
        try {
            compareCAS001WithCAS002();
            // compareCASUV003WithCAS001();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    public void compareCAS001WithCAS002() throws Exception {
        String directory = "C:/Work/Projects/MoSeS/Workspace/";
		// Census_CAS001DataHandler tCAS001DataHandler = new Census_CAS001DataHandler( new
        // File( directory, "CAS001DataRecordsMSOA.dat" ) );
        // Census_CAS002DataHandler tCAS002DataHandler = new Census_CAS002DataHandler( new
        // File( directory, "CAS002DataRecordsMSOA.dat" ) );
        Census_CAS001DataHandler tCAS001DataHandler = new Census_CAS001DataHandler(new File(
                directory, "CAS001DataRecords.dat"));
        Census_CAS002DataHandler tCAS002DataHandler = new Census_CAS002DataHandler(new File(
                directory, "CAS002DataRecords.dat"));
		// String filenamePrefix = new String(
        // "ToyModel_SWR_OA_HSARHP_ISARCEP_0_5_1000_3_30_12_20_MarkOutput2" );
        String filenameSuffix = "";
        String filenamePrefix = "CAS001vCAS002AgeGroupComparison";
		// // Prepare aggregate data
        // MarkOutput2DataHandler a_MarkOutput2DataHandler = new
        // MarkOutput2DataHandler();
        // a_MarkOutput2DataHandler.writeEstimated_HSARHP( directory,
        // filenamePrefix, true );
        // a_MarkOutput2DataHandler.writeEstimated_HSARHP( directory,
        // filenamePrefix, false );
        String baseURL = "http://www.geog.leeds.ac.uk/people/a.turner/projects/MoSeS/documentation/demography/results/tests/sourceData/"
                + filenamePrefix + "/";
        long RecordID = 0L;
        // RegressionReport _RegressionReport = new RegressionReport();
        long nRecords = tCAS001DataHandler.getNDataRecords();
        Census_CAS001DataRecord aCAS001DataRecord;
        Census_CAS002DataRecord aCAS002DataRecord;
        int t_NumberNumericalVariables = 14;
        String[] t_Variables = new String[t_NumberNumericalVariables + 1];
        t_Variables[1] = "PeopleAge0to15";
        t_Variables[2] = "PeopleAge16to19";
        t_Variables[3] = "PeopleAge20to24";
        t_Variables[4] = "PeopleAge25to29";
        t_Variables[5] = "PeopleAge30to34";
        t_Variables[6] = "PeopleAge35to39";
        t_Variables[7] = "PeopleAge40to44";
        t_Variables[8] = "PeopleAge45to49";
        t_Variables[9] = "PeopleAge50to54";
        t_Variables[10] = "PeopleAge55to59";
        t_Variables[11] = "PeopleAge60to64";
        t_Variables[12] = "PeopleAge65to74";
        t_Variables[13] = "PeopleAge75to79";
        t_Variables[14] = "PeopleAge80AndOver";
        int tCAS001_PeopleAge0to15;
        int tCAS001_PeopleAge16to19;
        int tCAS001_PeopleAge20to24;
        int tCAS001_PeopleAge25to29;
        int tCAS001_PeopleAge30to34;
        int tCAS001_PeopleAge35to39;
        int tCAS001_PeopleAge40to44;
        int tCAS001_PeopleAge45to49;
        int tCAS001_PeopleAge50to54;
        int tCAS001_PeopleAge55to59;
        int tCAS001_PeopleAge60to64;
        int tCAS001_PeopleAge65to74;
        int tCAS001_PeopleAge75to79;
        int tCAS001_PeopleAge80AndOver;
        int tCAS002_PeopleAge0to15;
        int tCAS002_PeopleAge16to19;
        int tCAS002_PeopleAge20to24;
        int tCAS002_PeopleAge25to29;
        int tCAS002_PeopleAge30to34;
        int tCAS002_PeopleAge35to39;
        int tCAS002_PeopleAge40to44;
        int tCAS002_PeopleAge45to49;
        int tCAS002_PeopleAge50to54;
        int tCAS002_PeopleAge55to59;
        int tCAS002_PeopleAge60to64;
        int tCAS002_PeopleAge65to74;
        int tCAS002_PeopleAge75to79;
        int tCAS002_PeopleAge80AndOver;
        double[][] t_CAS001DataRecords = new double[t_NumberNumericalVariables][(int) nRecords];
        double[][] t_CAS002DataRecords = new double[t_NumberNumericalVariables][(int) nRecords];
        for (RecordID = 0; RecordID < nRecords; RecordID++) {
            aCAS001DataRecord = tCAS001DataHandler
                    .getCAS001DataRecord(RecordID);
            aCAS002DataRecord = tCAS002DataHandler
                    .getCAS002DataRecord(RecordID);
            tCAS001_PeopleAge0to15 = aCAS001DataRecord.getAllPeopleAge0to4()
                    + aCAS001DataRecord.getAllPeopleAge5to9()
                    + aCAS001DataRecord.getAllPeopleAge10to14()
                    + aCAS001DataRecord.getAllPeopleAge15();
            tCAS001_PeopleAge16to19 = aCAS001DataRecord.getAllPeopleAge16()
                    + aCAS001DataRecord.getAllPeopleAge17()
                    + aCAS001DataRecord.getAllPeopleAge18()
                    + aCAS001DataRecord.getAllPeopleAge19();
            tCAS001_PeopleAge20to24 = aCAS001DataRecord.getAllPeopleAge20to24();
            tCAS001_PeopleAge25to29 = aCAS001DataRecord.getAllPeopleAge25to29();
            tCAS001_PeopleAge30to34 = aCAS001DataRecord.getAllPeopleAge30to34();
            tCAS001_PeopleAge35to39 = aCAS001DataRecord.getAllPeopleAge35to39();
            tCAS001_PeopleAge40to44 = aCAS001DataRecord.getAllPeopleAge40to44();
            tCAS001_PeopleAge45to49 = aCAS001DataRecord.getAllPeopleAge45to49();
            tCAS001_PeopleAge50to54 = aCAS001DataRecord.getAllPeopleAge50to54();
            tCAS001_PeopleAge55to59 = aCAS001DataRecord.getAllPeopleAge55to59();
            tCAS001_PeopleAge60to64 = aCAS001DataRecord.getAllPeopleAge60to64();
            tCAS001_PeopleAge65to74 = aCAS001DataRecord.getAllPeopleAge65to69()
                    + aCAS001DataRecord.getAllPeopleAge70to74();
            tCAS001_PeopleAge75to79 = aCAS001DataRecord.getAllPeopleAge75to79();
            tCAS001_PeopleAge80AndOver = aCAS001DataRecord
                    .getAllPeopleAge80to84()
                    + aCAS001DataRecord.getAllPeopleAge85to89()
                    + aCAS001DataRecord.getAllPeopleAge90AndOver();
            tCAS002_PeopleAge0to15 = aCAS002DataRecord
                    .getAllPeopleTotalAge0to15();
            tCAS002_PeopleAge16to19 = aCAS002DataRecord
                    .getAllPeopleTotalAge16to19();
            tCAS002_PeopleAge20to24 = aCAS002DataRecord
                    .getAllPeopleTotalAge20to24();
            tCAS002_PeopleAge25to29 = aCAS002DataRecord
                    .getAllPeopleTotalAge25to29();
            tCAS002_PeopleAge30to34 = aCAS002DataRecord
                    .getAllPeopleTotalAge30to34();
            tCAS002_PeopleAge35to39 = aCAS002DataRecord
                    .getAllPeopleTotalAge35to39();
            tCAS002_PeopleAge40to44 = aCAS002DataRecord
                    .getAllPeopleTotalAge40to44();
            tCAS002_PeopleAge45to49 = aCAS002DataRecord
                    .getAllPeopleTotalAge45to49();
            tCAS002_PeopleAge50to54 = aCAS002DataRecord
                    .getAllPeopleTotalAge50to54();
            tCAS002_PeopleAge55to59 = aCAS002DataRecord
                    .getAllPeopleTotalAge55to59();
            tCAS002_PeopleAge60to64 = aCAS002DataRecord
                    .getAllPeopleTotalAge60to64();
            tCAS002_PeopleAge65to74 = aCAS002DataRecord
                    .getAllPeopleTotalAge65to74();
            tCAS002_PeopleAge75to79 = aCAS002DataRecord
                    .getAllPeopleTotalAge75to79();
            tCAS002_PeopleAge80AndOver = aCAS002DataRecord
                    .getAllPeopleTotalAge80to84()
                    + aCAS002DataRecord.getAllPeopleTotalAge85to89()
                    + aCAS002DataRecord.getAllPeopleTotalAge90AndOver();
            t_CAS001DataRecords[0][(int) RecordID] = tCAS001_PeopleAge0to15;
            t_CAS001DataRecords[1][(int) RecordID] = tCAS001_PeopleAge16to19;
            t_CAS001DataRecords[2][(int) RecordID] = tCAS001_PeopleAge20to24;
            t_CAS001DataRecords[3][(int) RecordID] = tCAS001_PeopleAge25to29;
            t_CAS001DataRecords[4][(int) RecordID] = tCAS001_PeopleAge30to34;
            t_CAS001DataRecords[5][(int) RecordID] = tCAS001_PeopleAge35to39;
            t_CAS001DataRecords[6][(int) RecordID] = tCAS001_PeopleAge40to44;
            t_CAS001DataRecords[7][(int) RecordID] = tCAS001_PeopleAge45to49;
            t_CAS001DataRecords[8][(int) RecordID] = tCAS001_PeopleAge50to54;
            t_CAS001DataRecords[9][(int) RecordID] = tCAS001_PeopleAge55to59;
            t_CAS001DataRecords[10][(int) RecordID] = tCAS001_PeopleAge60to64;
            t_CAS001DataRecords[11][(int) RecordID] = tCAS001_PeopleAge65to74;
            t_CAS001DataRecords[12][(int) RecordID] = tCAS001_PeopleAge75to79;
            t_CAS001DataRecords[13][(int) RecordID] = tCAS001_PeopleAge80AndOver;
            t_CAS002DataRecords[0][(int) RecordID] = tCAS002_PeopleAge0to15;
            t_CAS002DataRecords[1][(int) RecordID] = tCAS002_PeopleAge16to19;
            t_CAS002DataRecords[2][(int) RecordID] = tCAS002_PeopleAge20to24;
            t_CAS002DataRecords[3][(int) RecordID] = tCAS002_PeopleAge25to29;
            t_CAS002DataRecords[4][(int) RecordID] = tCAS002_PeopleAge30to34;
            t_CAS002DataRecords[5][(int) RecordID] = tCAS002_PeopleAge35to39;
            t_CAS002DataRecords[6][(int) RecordID] = tCAS002_PeopleAge40to44;
            t_CAS002DataRecords[7][(int) RecordID] = tCAS002_PeopleAge45to49;
            t_CAS002DataRecords[8][(int) RecordID] = tCAS002_PeopleAge50to54;
            t_CAS002DataRecords[9][(int) RecordID] = tCAS002_PeopleAge55to59;
            t_CAS002DataRecords[10][(int) RecordID] = tCAS002_PeopleAge60to64;
            t_CAS002DataRecords[11][(int) RecordID] = tCAS002_PeopleAge65to74;
            t_CAS002DataRecords[12][(int) RecordID] = tCAS002_PeopleAge75to79;
            t_CAS002DataRecords[13][(int) RecordID] = tCAS002_PeopleAge80AndOver;
        }
        String xAxisLabel = "CAS001";
        String yAxisLabel = "CAS002";
        JFreeChart[] t_ScatterPlots = RegressionReport.createScatterPlots(
                t_Variables, t_CAS001DataRecords, t_CAS002DataRecords,
                xAxisLabel, yAxisLabel);
        Object[] t_RegressionParametersAndCreateXYLineCharts = RegressionReport
                .getRegressionParametersAndCreateXYLineCharts(t_Variables,
                        t_CAS001DataRecords, t_CAS002DataRecords);
        JFreeChart[] t_RegressionCharts = RegressionReport
                .createRegressionCharts(t_ScatterPlots,
                        t_RegressionParametersAndCreateXYLineCharts);
        String type = "PNG";
		// outputImages( t_ScatterPlots, directory + filenamePrefix +
        // "_ScatterPlot", type );
        // outputImages( t_XYLineCharts, directory + filenamePrefix +
        // "_XYLineChart", type );
        RegressionReport.outputImages(t_RegressionCharts, 1000, 1000, directory
                + filenamePrefix + "/", filenamePrefix + "_RegressionChart",
                type);
        // URL baseURL = new URL()
        int int_MainBodyControlSwitch = 0;
        writeHTML(baseURL, directory + filenamePrefix + "/", filenamePrefix,
                filenameSuffix, int_MainBodyControlSwitch);
    }

    public void writeHTMLBodyMain(byte[] lineSeparator, String baseURL,
            String filenamePrefix, String filenameSuffix,
            FileOutputStream a_FileOutputStream) throws IOException {
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write("<div>".getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write("<ul>".getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><h2>" + filenamePrefix
                + "</h2>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write("<ul>".getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart0.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart1.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart2.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart3.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart4.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart5.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart6.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart7.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart8.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart9.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart10.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart11.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart12.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write(("<li><img src=\"" + filenamePrefix
                + "_RegressionChart13.PNG\" /></li>").getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write("</ul></li>".getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write("</ul>".getBytes());
        a_FileOutputStream.write(lineSeparator);
        a_FileOutputStream.write("</div>".getBytes());
        a_FileOutputStream.write(lineSeparator);
    }

    public void compareCASUV003WithCAS001() throws Exception {
        File infile;
        infile = new File("C:/Work/Projects/MoSeS/Workspace/UV003.dat");
        Census_CASUV003DataHandler cASUV003DataHandler = new Census_CASUV003DataHandler(
                infile);
        infile = new File("C:/Work/Projects/MoSeS/Workspace/CAS001.dat");
        Census_CAS001DataHandler tCAS001DataHandler = new Census_CAS001DataHandler(infile);

        Census_CASUV003DataRecord aCASUV003DataRecord;
        Census_CAS001DataRecord aCAS001DataRecord;
        long difference;
        long maxDifference = Long.MIN_VALUE;
        long sumOfSquaredDifference = 0L;
        long totalDifference = 0L;
        long absoluteDifference = 0L;
        long totalAbsoluteDifference = 0L;
        long RecordID;
        long nRecords = cASUV003DataHandler.getNDataRecords();
        for (RecordID = 0; RecordID < nRecords; RecordID++) {
            aCASUV003DataRecord = cASUV003DataHandler
                    .getCASUV003DataRecord(RecordID);
            aCAS001DataRecord = tCAS001DataHandler
                    .getCAS001DataRecord(RecordID);
            difference = (long) (aCASUV003DataRecord.getAllPeople() - aCAS001DataRecord
                    .getAllPeople());
            if (difference < 0) {
                absoluteDifference = difference * -1L;
            }
            sumOfSquaredDifference += (difference * difference);
            maxDifference = Math.max(maxDifference, difference);
            totalDifference += difference;
            totalAbsoluteDifference += absoluteDifference;
        }
        int scale = 100;
        int roundingMode = BigDecimal.ROUND_HALF_EVEN;
        BigDecimal nRecordsBigDecimal = new BigDecimal(nRecords);
        BigDecimal meanDifferenceBigDecimal = new BigDecimal(maxDifference)
                .divide(nRecordsBigDecimal, scale, roundingMode);
        System.out.println("nRecords " + nRecords);
        System.out.println("meanDifferenceBigDecimal "
                + meanDifferenceBigDecimal.toString());
        System.out.println("sumOfSquaredDifference " + sumOfSquaredDifference);
        System.out.println("maxDifference " + maxDifference);
        System.out
                .println("totalAbsoluteDifference " + totalAbsoluteDifference);
        System.out.println("totalDifference " + totalDifference);
        BigDecimal standardDeviationOfDifferenceBigDecimal = new BigDecimal("0");
        BigDecimal differenceBigDecimal;
        for (RecordID = 0; RecordID < nRecords; RecordID++) {
            aCASUV003DataRecord = cASUV003DataHandler
                    .getCASUV003DataRecord(RecordID);
            aCAS001DataRecord = tCAS001DataHandler
                    .getCAS001DataRecord(RecordID);
            differenceBigDecimal = new BigDecimal(aCASUV003DataRecord
                    .getAllPeople()
                    - aCAS001DataRecord.getAllPeople());
            standardDeviationOfDifferenceBigDecimal = differenceBigDecimal
                    .multiply(differenceBigDecimal);
        }
        standardDeviationOfDifferenceBigDecimal = standardDeviationOfDifferenceBigDecimal
                .divide(nRecordsBigDecimal.subtract(BigDecimal.ONE), scale,
                        roundingMode);
        standardDeviationOfDifferenceBigDecimal = Math_BigDecimal.sqrt(
                standardDeviationOfDifferenceBigDecimal,
                scale,
                RoundingMode.HALF_EVEN);
        System.out.println("standardDeviationOfDifferenceBigDecimal "
                + standardDeviationOfDifferenceBigDecimal);
    }

    /**
     * Aim is to produce an aggregated data set for comparison totalling males
 and females by MSOA to compare with Census_CASUV003DataRecord
     */
    private void run3() throws IOException {
        boolean aggregateToMSOA = true;
        // boolean aggregateToMSOA = false;
        ToyModelDataHandler tToyModelDataHandler = new ToyModelDataHandler();
        String startOfFilename = "C:/Work/Projects/MoSeS/Workspace/Leeds/ToyModel_SWR_OA_HSARHP_ISARCEP_0_5_5000_3_30_12_20";
		// String startOfFilename = new String(
        // "C:/Work/Projects/MoSeS/Workspace/Leeds/ToyModel_SWR_OA_HSARHP_ISARCEP_0_5_1000_3_30_12_20"
        // );
        // String startOfFilename = new String(
        // "C:/Work/Projects/MoSeS/Workspace/Leeds/ToyModel_SWR_OA_ISARHP_ISARCEP_0_5_200_3_30_12_20"
        // );
        File tToyModelDataRecord2CSVFile = new File(startOfFilename + ".csv");
        File tToyModelDataRecordMaleFemaleComparisonFile;
        if (aggregateToMSOA) {
            tToyModelDataRecordMaleFemaleComparisonFile = new File(
                    startOfFilename + "_MSOAMaleFemaleComparison.csv");
        } else {
            tToyModelDataRecordMaleFemaleComparisonFile = new File(
                    startOfFilename + "_OAMaleFemaleComparison.csv");
        }
        if (!tToyModelDataRecordMaleFemaleComparisonFile.exists()) {
            tToyModelDataRecordMaleFemaleComparisonFile.createNewFile();
        }
        PrintWriter tToyModelDataRecordMaleFemaleComparisonFilePrintWriter = new PrintWriter(
                tToyModelDataRecordMaleFemaleComparisonFile);
		// Census_CASUV003DataHandler tCASUV003DataHandler = new Census_CASUV003DataHandler(
        // new File(
        // "C:/Work/Projects/MoSeS/Workspace/Leeds/CASUV003DataRecordsMSOA.dat"
        // ) );
        Census_CASUV003DataHandler tCASUV003DataHandler;
        Census_CAS001DataHandler tCAS001DataHandler;
        if (aggregateToMSOA) {
            tCASUV003DataHandler = new Census_CASUV003DataHandler(
                    new File(
                            "C:/Work/Projects/MoSeS/Workspace/Leeds/CASUV003DataRecordsMSOA.dat"));
            tCAS001DataHandler = new Census_CAS001DataHandler(
                    new File(
                            "C:/Work/Projects/MoSeS/Workspace/Leeds/CAS001DataRecordsMSOA.dat"));
        } else {
            tCASUV003DataHandler = new Census_CASUV003DataHandler(new File(
                    "C:/Work/Projects/MoSeS/Workspace/CASUV003DataRecords.dat"));
            tCAS001DataHandler = new Census_CAS001DataHandler(new File(
                    "C:/Work/Projects/MoSeS/Workspace/CAS001DataRecords.dat"));
        }
        Census_CASUV003DataRecord aCASUV003DataRecord;
        Census_CAS001DataRecord aCAS001DataRecord;
        BufferedReader tBufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(
                                tToyModelDataRecord2CSVFile)));
        StreamTokenizer tStreamTokenizer = new StreamTokenizer(tBufferedReader);
        Generic_IO.setStreamTokenizerSyntax1(tStreamTokenizer);
        // Initialise
        int tMaleCount;
        int tFemaleCount;
        int tMaleCEPCount;
        int tMaleHPCount;
        int tFemaleCEPCount;
        int tFemaleHPCount;
        int tokenType = tStreamTokenizer.nextToken();
        ToyModelDataRecord_2 aToyModelDataRecord2;
        String aZoneCode;
        HashMap tLookUpMSOAfromOAHashMap = null;
        Census_CASDataHandler tCASDataHandler = new Census_CASDataHandler();
        if (aggregateToMSOA) {
            tLookUpMSOAfromOAHashMap = tCASDataHandler
                    .get_LookUpMSOAfromOAHashMap();
        }
        Counts aCounts;
        tToyModelDataRecordMaleFemaleComparisonFilePrintWriter
                .println("ZoneCode,CAS001HPFemales,CAS001CEPFemales,CAS001Females,CASUV003Females,ToyModelFemales,ToyModelHPFemales,ToyModelCEPFemales,CAS001HPMales,CAS001CEPMales,CAS001Males,CASUV003Males,ToyModelMales,ToyModelHPMales,ToyModelCEPMales");
        TreeMap result = new TreeMap();
        while (tokenType != StreamTokenizer.TT_EOF) {
            switch (tokenType) {
                case StreamTokenizer.TT_WORD:
                    aToyModelDataRecord2 = new ToyModelDataRecord_2(
                            tToyModelDataHandler, tStreamTokenizer.sval);
                    if (aggregateToMSOA) {
                        aZoneCode = (String) tLookUpMSOAfromOAHashMap
                                .get(new String(aToyModelDataRecord2.getZone_Code()));
                    } else {
                        aZoneCode = String.valueOf(aToyModelDataRecord2
                                .getZone_Code());
                    }
                    if (aToyModelDataRecord2.SEX == 0) {
                        tFemaleCount = 1;
                        if (aToyModelDataRecord2.tHouseholdID != -9) {
                            tFemaleHPCount = 1;
                            tFemaleCEPCount = 0;
                        } else {
                            tFemaleHPCount = 0;
                            tFemaleCEPCount = 1;
                        }
                        tMaleCount = 0;
                        tMaleHPCount = 0;
                        tMaleCEPCount = 0;
                    } else {
                        tMaleCount = 1;
                        if (aToyModelDataRecord2.tHouseholdID != -9) {
                            tMaleHPCount = 1;
                            tMaleCEPCount = 0;
                        } else {
                            tMaleHPCount = 0;
                            tMaleCEPCount = 1;
                        }
                        tFemaleCount = 0;
                        tFemaleHPCount = 0;
                        tFemaleCEPCount = 0;
                    }
                    if (result.containsKey(aZoneCode)) {
                        aCounts = (Counts) result.get(aZoneCode);
                        result.remove(aZoneCode);
                        aCounts.addToCounts(tMaleCount, tMaleCEPCount,
                                tMaleHPCount, tFemaleCount, tFemaleCEPCount,
                                tFemaleHPCount);
                        result.put(aZoneCode, aCounts);
                    } else {
                        aCounts = new Counts();
                        aCounts.addToCounts(tMaleCount, tMaleCEPCount,
                                tMaleHPCount, tFemaleCount, tFemaleCEPCount,
                                tFemaleHPCount);
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
            aCASUV003DataRecord = (Census_CASUV003DataRecord) tCASUV003DataHandler
                    .getDataRecord(aZoneCode);
            aCAS001DataRecord = (Census_CAS001DataRecord) tCAS001DataHandler
                    .getDataRecord(aZoneCode);
            tToyModelDataRecordMaleFemaleComparisonFilePrintWriter
                    .println(""
                            + aZoneCode
                            + ", "
                            + aCAS001DataRecord.getHouseholdResidentsFemales()
                            + ", "
                            + aCAS001DataRecord
                            .getCommunalEstablishmentResidentsFemales()
                            + ", "
                            + (aCAS001DataRecord.getHouseholdResidentsFemales() + aCAS001DataRecord
                            .getCommunalEstablishmentResidentsFemales())
                            + ", "
                            + aCASUV003DataRecord.getFemales()
                            + ", "
                            + aCounts.tFemaleCount
                            + ", "
                            + aCounts.tFemaleHPCount
                            + ", "
                            + aCounts.tFemaleCEPCount
                            + ", "
                            + aCAS001DataRecord.getHouseholdResidentsMales()
                            + ", "
                            + aCAS001DataRecord
                            .getCommunalEstablishmentResidentsMales()
                            + ", "
                            + (aCAS001DataRecord.getHouseholdResidentsMales() + aCAS001DataRecord
                            .getCommunalEstablishmentResidentsMales())
                            + ", " + aCASUV003DataRecord.getMales() + ", "
                            + aCounts.tMaleCount + ", " + aCounts.tMaleHPCount
                            + ", " + aCounts.tMaleCEPCount);
        }
        tBufferedReader.close();
        tToyModelDataRecordMaleFemaleComparisonFilePrintWriter.close();
    }

    @Override
    public void writeHTMLBodyMain(byte[] lineSeparator, String baseURL,
            String filenamePrefix, String filenameSuffix,
            FileOutputStream a_FileOutputStream, int int_MainBodyControlSwitch)
            throws IOException {
    }

    @Override
    public void writeHTMLBodyMain(byte[] lineSeparator, URL baseURL,
            FileOutputStream a_FileOutputStream) throws IOException {
    }

    public class Counts {

        int tMaleCount;
        int tMaleHPCount;
        int tMaleCEPCount;
        int tFemaleCount;
        int tFemaleHPCount;
        int tFemaleCEPCount;

        /**
         * Creates a new instance of OAPopulationComparison
         */
        public Counts() {
            init();
        }

        private void init() {
            this.tMaleCount = 0;
            this.tMaleHPCount = 0;
            this.tMaleCEPCount = 0;
            this.tFemaleCount = 0;
            this.tFemaleHPCount = 0;
            this.tFemaleCEPCount = 0;
        }

        public void addToCounts(int tMaleCount, int tMaleCEPCount,
                int tMaleHPCount, int tFemaleCount, int tFemaleCEPCount,
                int tFemaleHPCount) {
            this.tMaleCount += tMaleCount;
            this.tMaleCEPCount += tMaleCEPCount;
            this.tMaleHPCount += tMaleHPCount;
            this.tFemaleCount += tFemaleCount;
            this.tFemaleCEPCount += tFemaleCEPCount;
            this.tFemaleHPCount += tFemaleHPCount;
        }
    }

}
