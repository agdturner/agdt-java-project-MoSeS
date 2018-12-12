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
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataRecord;
import uk.ac.leeds.ccg.andyt.census.core.Census_CASDataHandler;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataHandler;
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
 * A class for handling output data wanted by Mark Birkin.
 */
public class MarkOutputDataHandler_2 extends Census_AbstractDataHandler {

    /**
     * A File for writing output to.
     */
    protected File aOutputFile;
    /**
     * A FileOutputStream for File.
     */
    protected FileOutputStream aFileOutputStream;
    protected Census_CASDataHandler tCASDataHandler;

    /**
     * Creates a new instance of MarkOutputDataHandler_2
     */
    public MarkOutputDataHandler_2() {
    }

    /**
     * @param args
     *            the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        MarkOutputDataHandler_2 tMarkOutput2DataHandler = new MarkOutputDataHandler_2();
        tMarkOutput2DataHandler.run();
    }

    /**
     * TODO docs
     * @throws java.io.IOException
     */
    public void run() throws IOException {
        writeObservedWard();
        writeObservedMSOA();
    // writeObservedOA();
    // String directory = new String(
    // "C:/Work/Projects/MoSeS/Workspace/Leeds/" );
    // String aggregation;
    // //String filenamePrefix = new String(
    // "ToyModel_SWR_OA_HSARHP_ISARCEP_0_5_1000_3_30_12_20" );
    // String filenamePrefix = new String(
    // "ToyModel_SWR_OA_HSARHP_ISARCEP_0_100_10000_2_100_12_10" );
    // // String aggregation = "MSOA";
    // // writeEstimated_HSARHP( directory, filenamePrefix,
    // "_MarkOutput2MSOA.csv", aggregateToMSOA );
    // aggregation = "OA";
    // writeEstimated_HSARHP( directory, filenamePrefix,
    // "_MarkOutput2MSOA.csv", aggregation );
    // //writeEstimated_ISARHP();
    }

    /**
     * Writes out header.
     * @throws java.io.IOException
     */
    public void writeHeader() throws IOException {
        String header = "ZoneCode," + "AllPeople," + "AllHousehold," + "Proportion_PeopleAge0to4_of_AllPeople," + "PeopleAge0to4," + "Proportion_PeopleAge5to9_of_AllPeople," + "PeopleAge5to9," + "Proportion_PeopleAge10to14_of_AllPeople," + "PeopleAge10to14," + "Proportion_PeopleAge15to19_of_AllPeople," + "PeopleAge15to19," + "Proportion_PeopleAge20to24_of_AllPeople," + "PeopleAge20to24," + "Proportion_PeopleAge25to29_of_AllPeople," + "AllPeopleAge25to29," + "Proportion_PeopleAge30to44_of_AllPeople," + "PeopleAge30to44," + "Proportion_PeopleAge45to59_of_AllPeople," + "PeopleAge45to59," + "Proportion_PeopleAge60to64_of_AllPeople," + "PeopleAge60to64," + "Proportion_PeopleAge65to69_of_AllPeople," + "PeopleAge65to69," + "Proportion_PeopleAge70to74_of_AllPeople," + "PeopleAge70to74," + "Proportion_PeopleAge75to79_of_AllPeople," + "PeopleAge75to79," + "Proportion_PeopleAge80AndOver_of_AllPeople," + "PeopleAge80AndOver," + "Proportion_PeopleAge16to74_of_AllPeople," + "PeopleAge16to74," + "Proportion_MalesAge16to74_of_AllPeople," + "MalesAge16to74," + "Proportion_FemalesAge16to74_of_AllPeople," + "FemalesAge16to74," + "Proportion_UnemployedAge16to74_of_PeopleAge16to74," + "UnemployedAge16to74," +
                // "Proportion_RetiredAge16to74_of_PeopleAge16-74," +
                // "RetiredAge16-74," +
                "Proportion_MalesEconomicallyActiveAge16to74_of_MalesAge16to74," + "MalesEconomicallyActiveAge16to74," + "Proportion_FemalesEconomicallyActiveAge16to74_of_FemalesAge16to74," + "FemalesEconomicallyActiveAge16to74," + "Proportion_EthnicityWhite_of_AllPeople," + "EthnicityWhite," + "Proportion_NoCarOwnershipHouseholds_of_AllHouseholds," + "NoCarOwnershipHouseholds";
        System.out.println(header);
        this.aFileOutputStream.write(header.getBytes());
        this.aFileOutputStream.write(StreamTokenizer.TT_EOL);
        this.aFileOutputStream.flush();
    }

    /**
     * Writes out MarkOutput1DataRecord but with zoneCode as Zone_Code
     * @throws java.io.IOException
     */
    public void writeObservedMSOA() throws IOException {
        this.aOutputFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/MarkOutput2MSOA.csv");
        aFileOutputStream = new FileOutputStream(aOutputFile);
        this.tCASDataHandler = new Census_CASDataHandler(new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/"), "MSOA");
        writeHeader();
        long startRecordID = 0;
        long endRecordID = this.tCASDataHandler.getNDataRecords() - 1;
        Census_CASDataRecord aCASDataRecord;
        Counts aCounts = new Counts();
        for (long RecordID = startRecordID; RecordID <= endRecordID; RecordID++) {
            // System.out.println("RecordID " + RecordID);
            aCASDataRecord = (Census_CASDataRecord) this.tCASDataHandler.getDataRecord(RecordID);
            aCounts.allPeople = aCASDataRecord.getCAS001DataRecord().getAllPeople();
            aCounts.allHouseholds = aCASDataRecord.getCAS003DataRecord().getAllHouseholdsTotal();
            aCounts.allPeopleAge0to4 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge0to4();
            aCounts.allPeopleAge5to9 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge5to9();
            aCounts.allPeopleAge10to14 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge10to14();
            aCounts.allPeopleAge15to19 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge15to19();
            aCounts.allPeopleAge20to24 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge20to24();
            aCounts.allPeopleAge25to29 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge25to29();
            aCounts.allPeopleAge30to44 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge30to34()
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge35to39() 
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge40to44();
            // aCounts.allPeopleAge30to44 =
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge30to34() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge35to39() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge40to44();
            aCounts.allPeopleAge45to59 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge45to49() 
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge50to54() 
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge55to59();
            aCounts.allPeopleAge60to64 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge60to64();
            aCounts.allPeopleAge65to69 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge65to69();
            aCounts.allPeopleAge70to74 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge70to74();
            aCounts.allPeopleAge75to79 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge75to79();
            aCounts.allPeopleAge80AndOver = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge80to84() 
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge85to89()
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge90AndOver();
            // aCounts.allPeopleAge80AndOver =
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge80to84() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge85to89() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge90AndOver();
            aCounts.allPeopleAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74();
            aCounts.malesAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74();
            aCounts.femalesAge16to74 = aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74();
            aCounts.unemployedAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveUnemployed() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74UnemployedWhoHaveNeverWorked() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74WhoAreLongTermUnemployed()
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveUnemployed() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74UnemployedWhoHaveNeverWorked() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74WhoAreLongTermUnemployed();
            // aCounts.retiredAge16to74 =
            // aCASDataRecord.tCASKS09bDataRecord.malesAged16to74EconomicallyInactiveRetired
            // +
            // aCASDataRecord.tCASKS09cDataRecord.femalesAged16to74EconomicallyInactiveRetired;
            aCounts.maleEconomicallyActiveAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveEmployeesFullTime() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveEmployeesPartTime() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveFullTimeStudent() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveSelfEmployed() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveUnemployed();
            aCounts.femaleEconomicallyActiveAge16to74 = aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveEmployeesFullTime()
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveEmployeesPartTime() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveFullTimeStudent()
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveSelfEmployed()
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveUnemployed();
            aCounts.ethnicityWhite = aCASDataRecord.getCASKS006DataRecord().getWhiteOtherWhite()
                    + aCASDataRecord.getCASKS006DataRecord().getWhiteWhiteBritish() 
                    + aCASDataRecord.getCASKS006DataRecord().getWhiteWhiteIrish();
            aCounts.noCarOwnership = aCASDataRecord.getCASKS017DataRecord().getHouseholdsWith0CarsOrVans();
            write(aCounts, String.valueOf(aCASDataRecord.getZone_Code()));
        }
    }

    /**
     * Writes out MarkOutput1DataRecord but with zoneCode as Zone_Code
     * @throws java.io.IOException
     */
    public void writeObservedWard() throws IOException {
        this.aOutputFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/MarkOutput2Ward.csv");
        aFileOutputStream = new FileOutputStream(aOutputFile);
        this.tCASDataHandler = new Census_CASDataHandler(new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/"), "Ward");
        // this.tCASDataHandler = new Census_CASDataHandler( new File(
        // "C:/Work/Projects/MoSeS/Workspace/" ), "Ward" );
        writeHeader();
        // long startRecordID = 56749L;
        // long endRecordID = startRecordID + 2438L;
        long startRecordID = 0L;
        long endRecordID = startRecordID + 32L;
        Census_CASDataRecord aCASDataRecord;
        Counts aCounts = new Counts();
        for (long RecordID = startRecordID; RecordID <= endRecordID; RecordID++) {
            // System.out.println("RecordID " + RecordID);
            aCASDataRecord = (Census_CASDataRecord) this.tCASDataHandler.getDataRecord(RecordID);
            aCounts.allPeople = aCASDataRecord.getCAS001DataRecord().getAllPeople();
            aCounts.allHouseholds = aCASDataRecord.getCAS003DataRecord().getAllHouseholdsTotal();
            aCounts.allPeopleAge0to4 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge0to4();
            aCounts.allPeopleAge5to9 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge5to9();
            aCounts.allPeopleAge10to14 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge10to14();
            aCounts.allPeopleAge15to19 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge15to19();
            aCounts.allPeopleAge20to24 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge20to24();
            aCounts.allPeopleAge25to29 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge25to29();
            aCounts.allPeopleAge30to44 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge30to34() 
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge35to39() 
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge40to44();
            // aCounts.allPeopleAge30to44 =
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge30to34() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge35to39() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge40to44();
            aCounts.allPeopleAge45to59 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge45to49() 
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge50to54() 
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge55to59();
            aCounts.allPeopleAge60to64 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge60to64();
            aCounts.allPeopleAge65to69 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge65to69();
            aCounts.allPeopleAge70to74 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge70to74();
            aCounts.allPeopleAge75to79 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge75to79();
            aCounts.allPeopleAge80AndOver = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge80to84()
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge85to89()
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge90AndOver();
            // aCounts.allPeopleAge80AndOver =
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge80to84() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge85to89() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge90AndOver();
            aCounts.allPeopleAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74();
            aCounts.malesAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74();
            aCounts.femalesAge16to74 = aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74();
            aCounts.unemployedAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveUnemployed() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74UnemployedWhoHaveNeverWorked()
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74WhoAreLongTermUnemployed() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveUnemployed() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74UnemployedWhoHaveNeverWorked() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74WhoAreLongTermUnemployed();
            // aCounts.retiredAge16to74 =
            // aCASDataRecord.tCASKS09bDataRecord.malesAged16to74EconomicallyInactiveRetired
            // +
            // aCASDataRecord.tCASKS09cDataRecord.femalesAged16to74EconomicallyInactiveRetired;
            aCounts.maleEconomicallyActiveAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveEmployeesFullTime()
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveEmployeesPartTime()
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveFullTimeStudent() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveSelfEmployed()
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveUnemployed();
            aCounts.femaleEconomicallyActiveAge16to74 = aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveEmployeesFullTime()
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveEmployeesPartTime() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveFullTimeStudent()
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveSelfEmployed() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveUnemployed();
            aCounts.ethnicityWhite = aCASDataRecord.getCASKS006DataRecord().getWhiteOtherWhite() 
                    + aCASDataRecord.getCASKS006DataRecord().getWhiteWhiteBritish()
                    + aCASDataRecord.getCASKS006DataRecord().getWhiteWhiteIrish();
            aCounts.noCarOwnership = aCASDataRecord.getCASKS017DataRecord().getHouseholdsWith0CarsOrVans();
            write(aCounts, String.valueOf(aCASDataRecord.getZone_Code()));
        }
    }

    /**
     * Writes out MarkOutput1DataRecord but with zoneCode as Zone_Code
     * @throws java.io.IOException
     */
    public void writeObservedOA() throws IOException {
        this.aOutputFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/Leeds/MarkOutput2OA.csv");
        aFileOutputStream = new FileOutputStream(aOutputFile);
        this.tCASDataHandler = new Census_CASDataHandler(new File(
                "C:/Work/Projects/MoSeS/Workspace/"), "");
        writeHeader();
        long startRecordID = 56749L;
        long endRecordID = startRecordID + 2438L;
        Census_CASDataRecord aCASDataRecord;
        Counts aCounts = new Counts();
        for (long RecordID = startRecordID; RecordID <= endRecordID; RecordID++) {
            // System.out.println("RecordID " + RecordID);
            aCASDataRecord = (Census_CASDataRecord) this.tCASDataHandler.getDataRecord(RecordID);
            aCounts.allPeople = aCASDataRecord.getCAS001DataRecord().getAllPeople();
            aCounts.allHouseholds = aCASDataRecord.getCAS003DataRecord().getAllHouseholdsTotal();
            aCounts.allPeopleAge0to4 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge0to4();
            aCounts.allPeopleAge5to9 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge5to9();
            aCounts.allPeopleAge10to14 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge10to14();
            aCounts.allPeopleAge15to19 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge15to19();
            aCounts.allPeopleAge20to24 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge20to24();
            aCounts.allPeopleAge25to29 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge25to29();
            aCounts.allPeopleAge30to44 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge30to34() 
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge35to39() +
                    aCASDataRecord.getCAS001DataRecord().getAllPeopleAge40to44();
            // aCounts.allPeopleAge30to44 =
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge30to34() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge35to39() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge40to44();
            aCounts.allPeopleAge45to59 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge45to49() 
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge50to54() + 
                    aCASDataRecord.getCAS001DataRecord().getAllPeopleAge55to59();
            aCounts.allPeopleAge60to64 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge60to64();
            aCounts.allPeopleAge65to69 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge65to69();
            aCounts.allPeopleAge70to74 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge70to74();
            aCounts.allPeopleAge75to79 = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge75to79();
            aCounts.allPeopleAge80AndOver = aCASDataRecord.getCAS001DataRecord().getAllPeopleAge80to84()
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge85to89() 
                    + aCASDataRecord.getCAS001DataRecord().getAllPeopleAge90AndOver();
            // aCounts.allPeopleAge80AndOver =
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge80to84() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge85to89() +
            // aCASDataRecord.tCAS002DataRecord.getAllPeopleTotalAge90AndOver();
            aCounts.allPeopleAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74()
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74();
            aCounts.malesAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74();
            aCounts.femalesAge16to74 = aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74();
            aCounts.unemployedAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveUnemployed() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74UnemployedWhoHaveNeverWorked() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74WhoAreLongTermUnemployed()
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveUnemployed() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74UnemployedWhoHaveNeverWorked()
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74WhoAreLongTermUnemployed();
            // aCounts.retiredAge16to74 =
            // aCASDataRecord.tCASKS09bDataRecord.malesAged16to74EconomicallyInactiveRetired
            // +
            // aCASDataRecord.tCASKS09cDataRecord.femalesAged16to74EconomicallyInactiveRetired;
            aCounts.maleEconomicallyActiveAge16to74 = aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveEmployeesFullTime() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveEmployeesPartTime()
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveFullTimeStudent() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveSelfEmployed() 
                    + aCASDataRecord.getCASKS09bDataRecord().getMalesAged16to74EconomicallyActiveUnemployed();
            aCounts.femaleEconomicallyActiveAge16to74 = aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveEmployeesFullTime() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveEmployeesPartTime() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveFullTimeStudent() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveSelfEmployed() 
                    + aCASDataRecord.getCASKS09cDataRecord().getFemalesAged16to74EconomicallyActiveUnemployed();
            aCounts.ethnicityWhite = aCASDataRecord.getCASKS006DataRecord().getWhiteOtherWhite()
                    + aCASDataRecord.getCASKS006DataRecord().getWhiteWhiteBritish() 
                    + aCASDataRecord.getCASKS006DataRecord().getWhiteWhiteIrish();
            aCounts.noCarOwnership = aCASDataRecord.getCASKS017DataRecord().getHouseholdsWith0CarsOrVans();
            write(aCounts, String.valueOf(aCASDataRecord.getZone_Code()));
        }
    }

    public Census_AbstractDataRecord getDataRecord(long RecordID) {
        return null;
    }

    /**
     * writeEstimated_HSARHP
     *
     * @param aggregation
     *            OA, MSOA, Ward
     * @param filenamePrefix
     * @param filenameSuffix
     * @throws java.io.IOException
     */
    public void writeEstimated_HSARHP(String directory, String filenamePrefix,
            String filenameSuffix, String aggregation) throws IOException {
        ToyModelDataHandler tToyModelDataHandler = new ToyModelDataHandler();
        File tToyModelDataRecord2CSVFile = new File(directory + filenamePrefix + ".csv");
        File tToyModelDataRecordMaleFemaleComparisonFile;
        this.aOutputFile = new File(directory + filenamePrefix + filenameSuffix);
        if (!this.aOutputFile.exists()) {
            this.aOutputFile.createNewFile();
        }
        this.aFileOutputStream = new FileOutputStream(aOutputFile);
        writeHeader();
        Census_CASDataRecord aCASDataRecord;
        int allPeople = 0;
        int allHouseholds = 0;
        int allPeopleAge0to4 = 0;
        int allPeopleAge5to9 = 0;
        int allPeopleAge10to14 = 0;
        int allPeopleAge15to19 = 0;
        int allPeopleAge20to24 = 0;
        int allPeopleAge25to29 = 0;
        int allPeopleAge30to44 = 0;
        int allPeopleAge45to59 = 0;
        int allPeopleAge60to64 = 0;
        int allPeopleAge65to69 = 0;
        int allPeopleAge70to74 = 0;
        int allPeopleAge75to79 = 0;
        int allPeopleAge80AndOver = 0;
        int allPeopleAge16to74 = 0;
        int malesAge16to74 = 0;
        int femalesAge16to74 = 0;
        int unemployedAge16to74 = 0;
        // int retiredAge16to74 = 0;
        int maleEconomicallyActiveAge16to74 = 0;
        int femaleEconomicallyActiveAge16to74 = 0;
        int ethnicityWhite = 0;
        int noCarOwnership = 0;
        Census_HSARDataHandler tHSARDataHandler = new Census_HSARDataHandler(
                new File("C:/Work/Projects/MoSeS/Workspace/",
                "uk.ac.leeds.ccg.andyt.projects.moses.io.HSARDataHandler.thisFile"));
        Census_ISARDataHandler _ISARDataHandler_AGE0HRPOrdered = new Census_ISARDataHandler(
                new File("C:/Work/Projects/MoSeS/Workspace/",
                "uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataHandler.thisFile"));
        Census_HSARDataRecord aHSARDataRecord;
        Census_ISARDataRecord aISARDataRecord;
        BufferedReader tBufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(
                tToyModelDataRecord2CSVFile)));
        StreamTokenizer tStreamTokenizer = new StreamTokenizer(tBufferedReader);
        Generic_IO.setStreamTokenizerSyntax1(tStreamTokenizer);
        int tokenType = tStreamTokenizer.nextToken();
        ToyModelDataRecord_2 aToyModelDataRecord2;
        String aZoneCode;
        HashMap tLookUpMSOAfromOAHashMap = null;
        Census_CASDataHandler tCASDataHandler = new Census_CASDataHandler();
        if (aggregation.equalsIgnoreCase("MSOA")) {
            tLookUpMSOAfromOAHashMap = tCASDataHandler.get_LookUpMSOAfromOAHashMap();
        }
        short aHSARDataRecordAGEH;
        short aHSARDataRecordETHEW;
        short aISARDataRecordAGE0;
        short aISARDataRecordECONACT;
        short aISARDataRecordETHEW;
        short aISARDataRecordETHN;
        short aISARDataRecordETHS;
        Counts aCounts;
        TreeMap result = new TreeMap();
        while (tokenType != StreamTokenizer.TT_EOF) {
            switch (tokenType) {
                case StreamTokenizer.TT_WORD:
                    allPeople = 1;
                    allHouseholds = 0;
                    allPeopleAge0to4 = 0;
                    allPeopleAge5to9 = 0;
                    allPeopleAge10to14 = 0;
                    allPeopleAge15to19 = 0;
                    allPeopleAge20to24 = 0;
                    allPeopleAge25to29 = 0;
                    allPeopleAge30to44 = 0;
                    allPeopleAge45to59 = 0;
                    allPeopleAge60to64 = 0;
                    allPeopleAge65to69 = 0;
                    allPeopleAge70to74 = 0;
                    allPeopleAge75to79 = 0;
                    allPeopleAge80AndOver = 0;
                    allPeopleAge16to74 = 0;
                    malesAge16to74 = 0;
                    femalesAge16to74 = 0;
                    unemployedAge16to74 = 0;
                    maleEconomicallyActiveAge16to74 = 0;
                    femaleEconomicallyActiveAge16to74 = 0;
                    ethnicityWhite = 0;
                    noCarOwnership = 0;
                    aToyModelDataRecord2 = new ToyModelDataRecord_2(
                            tToyModelDataHandler, tStreamTokenizer.sval);
                    if (aggregation.equalsIgnoreCase("MSOA")) {
                        aZoneCode = (String) tLookUpMSOAfromOAHashMap.get(new String(aToyModelDataRecord2.getZone_Code()));
                    } else {
                        aZoneCode = String.valueOf(aToyModelDataRecord2.getZone_Code());
                        if (aggregation.equalsIgnoreCase("Ward")) {
                            aZoneCode = aZoneCode.substring(0, 6);
                        }
                    }
                    if (aToyModelDataRecord2.tHSARDataRecordID != -9) {
                        aHSARDataRecord = (Census_HSARDataRecord) tHSARDataHandler.getDataRecord(aToyModelDataRecord2.tHSARDataRecordID);
                        if (aHSARDataRecord.get_HRP()) {
                            allHouseholds = 1;
                        }
                        aHSARDataRecordAGEH = aHSARDataRecord.get_AGEH();
                        if (aHSARDataRecordAGEH < 5) {
                            allPeopleAge0to4 = 1;
                        } else {
                            if (aHSARDataRecordAGEH < 10) {
                                allPeopleAge5to9 = 1;
                            } else {
                                if (aHSARDataRecordAGEH < 15) {
                                    allPeopleAge10to14 = 1;
                                } else {
                                    if (aHSARDataRecordAGEH < 20) {
                                        allPeopleAge15to19 = 1;
                                    } else {
                                        if (aHSARDataRecordAGEH < 25) {
                                            allPeopleAge20to24 = 1;
                                        } else {
                                            if (aHSARDataRecordAGEH < 30) {
                                                allPeopleAge25to29 = 1;
                                            } else {
                                                if (aHSARDataRecordAGEH < 45) {
                                                    allPeopleAge30to44 = 1;
                                                } else {
                                                    if (aHSARDataRecordAGEH < 60) {
                                                        allPeopleAge45to59 = 1;
                                                    } else {
                                                        if (aHSARDataRecordAGEH < 65) {
                                                            allPeopleAge60to64 = 1;
                                                        } else {
                                                            if (aHSARDataRecordAGEH < 70) {
                                                                allPeopleAge65to69 = 1;
                                                            } else {
                                                                if (aHSARDataRecordAGEH < 75) {
                                                                    allPeopleAge70to74 = 1;
                                                                } else {
                                                                    if (aHSARDataRecordAGEH < 80) {
                                                                        allPeopleAge75to79 = 1;
                                                                    } else {
                                                                        allPeopleAge80AndOver = 1;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (aHSARDataRecordAGEH < 75) {
                                        allPeopleAge16to74 = 1;
                                        if (aHSARDataRecord.get_SEX()) {
                                            malesAge16to74 = 1;
                                            if (aHSARDataRecord.get_ECONACH() > 0 && aHSARDataRecord.get_ECONACH() < 3) {
                                                // if ( aHSARDataRecord.getECONACH()
                                                // == 1 ) {
                                                maleEconomicallyActiveAge16to74 = 1;
                                            }
                                        } else {
                                            femalesAge16to74 = 1;
                                            if (aHSARDataRecord.get_ECONACH() > 0 && aHSARDataRecord.get_ECONACH() < 3) {
                                                // if ( aHSARDataRecord.getECONACH()
                                                // == 1 ) {
                                                femaleEconomicallyActiveAge16to74 = 1;
                                            }
                                        }
                                        if (aHSARDataRecord.get_ECONACH() == (short) 2) {
                                            unemployedAge16to74 = 1;
                                        }
                                    }
                                }
                            }
                        }
                        aHSARDataRecordETHEW = aHSARDataRecord.get_ETHEW();
                        if (aHSARDataRecordETHEW > 0 && aHSARDataRecordETHEW < 4) {
                            ethnicityWhite = 1;
                        }
                        if (aHSARDataRecord.get_CARSH() == 0) {
                            if (aHSARDataRecord.get_HRP()) {
                                noCarOwnership = 1;
                            }
                        }
                    } else {
                        aISARDataRecord = (Census_ISARDataRecord) _ISARDataHandler_AGE0HRPOrdered.getDataRecord(aToyModelDataRecord2.tISARDataRecordID);
                        aISARDataRecordAGE0 = aISARDataRecord.get_AGE0();
                        if (aISARDataRecordAGE0 < 5) {
                            allPeopleAge0to4 = 1;
                        } else {
                            if (aISARDataRecordAGE0 < 10) {
                                allPeopleAge5to9 = 1;
                            } else {
                                if (aISARDataRecordAGE0 < 15) {
                                    allPeopleAge10to14 = 1;
                                } else {
                                    if (aISARDataRecordAGE0 < 20) {
                                        allPeopleAge15to19 = 1;
                                    } else {
                                        if (aISARDataRecordAGE0 < 25) {
                                            allPeopleAge20to24 = 1;
                                        } else {
                                            if (aISARDataRecordAGE0 < 30) {
                                                allPeopleAge25to29 = 1;
                                            } else {
                                                if (aISARDataRecordAGE0 < 45) {
                                                    allPeopleAge30to44 = 1;
                                                } else {
                                                    if (aISARDataRecordAGE0 < 60) {
                                                        allPeopleAge45to59 = 1;
                                                    } else {
                                                        if (aISARDataRecordAGE0 < 65) {
                                                            allPeopleAge60to64 = 1;
                                                        } else {
                                                            if (aISARDataRecordAGE0 < 70) {
                                                                allPeopleAge65to69 = 1;
                                                            } else {
                                                                if (aISARDataRecordAGE0 < 75) {
                                                                    allPeopleAge70to74 = 1;
                                                                } else {
                                                                    if (aISARDataRecordAGE0 < 80) {
                                                                        allPeopleAge75to79 = 1;
                                                                    } else {
                                                                        allPeopleAge80AndOver = 1;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (aISARDataRecordAGE0 < 75) {
                                        allPeopleAge16to74 = 1;
                                        aISARDataRecordECONACT = aISARDataRecord.get_ECONACT();
                                        if (aISARDataRecord.get_SEX()) {
                                            malesAge16to74 = 1;
                                            if (aISARDataRecordECONACT > 0 && aISARDataRecordECONACT < 9) {
                                                maleEconomicallyActiveAge16to74 = 1;
                                            }
                                        } else {
                                            femalesAge16to74 = 1;
                                            if (aISARDataRecordECONACT > 0 && aISARDataRecordECONACT < 9) {
                                                femaleEconomicallyActiveAge16to74 = 1;
                                            }
                                        }
                                        // if ( aISARDataRecordECONACT == 7 ||
                                        // aISARDataRecordECONACT == 8 ) {
                                        if (aISARDataRecordECONACT > 6 && aISARDataRecordECONACT < 9) {
                                            unemployedAge16to74 = 1;
                                        }
                                    }
                                }
                            }
                        }
                        aISARDataRecordETHEW = aISARDataRecord.get_ETHEW();
                        aISARDataRecordETHN = aISARDataRecord.get_ETHN();
                        aISARDataRecordETHS = aISARDataRecord.get_ETHS();
                        if (aISARDataRecordETHEW == -9) {
                            if (aISARDataRecordETHN == -9) {
                                if (aISARDataRecordETHS < 5) {
                                    ethnicityWhite = 1;
                                }
                            } else {
                                if (aISARDataRecordETHN == 1) {
                                    ethnicityWhite = 1;
                                }
                            }
                        } else {
                            if (aISARDataRecordETHEW < 4) {
                                ethnicityWhite = 1;
                            }
                        }
                    // Because ISAR record implies this is not a household,
                    // noCarOwnership unchanged.
                    // This will need modifying if ISAR records are used to
                    // build households.
                    // if ( aISARDataRecord.getCARS0() == 0 ) {
                    // if ( aISARDataRecord.get_RELTOHR() == 1 ) {
                    // noCarOwnership = 1;
                    // }
                    // }
                    }
                    if (result.containsKey(aZoneCode)) {
                        aCounts = (Counts) result.get(aZoneCode);
                        result.remove(aZoneCode);
                        aCounts.addToCounts(allPeople, allHouseholds,
                                allPeopleAge0to4, allPeopleAge5to9,
                                allPeopleAge10to14, allPeopleAge15to19,
                                allPeopleAge20to24, allPeopleAge25to29,
                                allPeopleAge30to44, allPeopleAge45to59,
                                allPeopleAge60to64, allPeopleAge65to69,
                                allPeopleAge70to74, allPeopleAge75to79,
                                allPeopleAge80AndOver, allPeopleAge16to74,
                                malesAge16to74, femalesAge16to74,
                                unemployedAge16to74,
                                maleEconomicallyActiveAge16to74,
                                femaleEconomicallyActiveAge16to74, ethnicityWhite,
                                noCarOwnership);
                        result.put(aZoneCode, aCounts);
                    } else {
                        aCounts = new Counts();
                        aCounts.addToCounts(allPeople, allHouseholds,
                                allPeopleAge0to4, allPeopleAge5to9,
                                allPeopleAge10to14, allPeopleAge15to19,
                                allPeopleAge20to24, allPeopleAge25to29,
                                allPeopleAge30to44, allPeopleAge45to59,
                                allPeopleAge60to64, allPeopleAge65to69,
                                allPeopleAge70to74, allPeopleAge75to79,
                                allPeopleAge80AndOver, allPeopleAge16to74,
                                malesAge16to74, femalesAge16to74,
                                unemployedAge16to74,
                                maleEconomicallyActiveAge16to74,
                                femaleEconomicallyActiveAge16to74, ethnicityWhite,
                                noCarOwnership);
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
            write(aCounts, aZoneCode);
        }
        this.aFileOutputStream.close();
    }

    /**
     * Writes out MarkOutput1DataRecord but with zoneCode as Zone_Code
     * @throws java.io.IOException
     */
    public void writeEstimated_ISARHP() throws IOException {
        boolean aggregateToMSOA = true;
        // boolean aggregateToMSOA = false;
        ToyModelDataHandler tToyModelDataHandler = new ToyModelDataHandler();
        String startOfFilename = "C:/Work/Projects/MoSeS/Workspace/Leeds/ToyModel_SWR_OA_ISARHP_ISARCEP_0_5_200_3_30_12_20";
        File tToyModelDataRecord2CSVFile = new File(startOfFilename + ".csv");
        File tToyModelDataRecordMaleFemaleComparisonFile;
        if (aggregateToMSOA) {
            this.aOutputFile = new File(startOfFilename + "_MarkOutput2MSOA.csv");
        } else {
            this.aOutputFile = new File(startOfFilename + "_MarkOutput2OA.csv");
        }
        if (!this.aOutputFile.exists()) {
            this.aOutputFile.createNewFile();
        }
        this.aFileOutputStream = new FileOutputStream(aOutputFile);
        writeHeader();
        Census_CASDataRecord aCASDataRecord;
        int allPeople = 0;
        int allHouseholds = 0;
        int allPeopleAge0to4 = 0;
        int allPeopleAge5to9 = 0;
        int allPeopleAge10to14 = 0;
        int allPeopleAge15to19 = 0;
        int allPeopleAge20to24 = 0;
        int allPeopleAge25to29 = 0;
        int allPeopleAge30to44 = 0;
        int allPeopleAge45to59 = 0;
        int allPeopleAge60to64 = 0;
        int allPeopleAge65to69 = 0;
        int allPeopleAge70to74 = 0;
        int allPeopleAge75to79 = 0;
        int allPeopleAge80AndOver = 0;
        int allPeopleAge16to74 = 0;
        int malesAge16to74 = 0;
        int femalesAge16to74 = 0;
        int unemployedAge16to74 = 0;
        // int retiredAge16to74 = 0;
        int maleEconomicallyActiveAge16to74 = 0;
        int femaleEconomicallyActiveAge16to74 = 0;
        int ethnicityWhite = 0;
        int noCarOwnership = 0;
        Census_ISARDataHandler _ISARDataHandler_AGE0HRPOrdered = new Census_ISARDataHandler(
                new File("C:/Work/Projects/MoSeS/Workspace/",
                "uk.ac.leeds.ccg.andyt.projects.moses.io.ISARDataHandler.thisFile"));
        Census_ISARDataRecord aISARDataRecord;
        BufferedReader tBufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(
                tToyModelDataRecord2CSVFile)));
        StreamTokenizer tStreamTokenizer = new StreamTokenizer(tBufferedReader);
        Generic_IO.setStreamTokenizerSyntax1(tStreamTokenizer);
        int tokenType = tStreamTokenizer.nextToken();
        ToyModelDataRecord_2 aToyModelDataRecord2;
        String aZoneCode;
        HashMap tLookUpMSOAfromOAHashMap = null;
        Census_CASDataHandler tCASDataHandler = new Census_CASDataHandler();
        if (aggregateToMSOA) {
            tLookUpMSOAfromOAHashMap = tCASDataHandler.get_LookUpMSOAfromOAHashMap();
        }
        short aHSARDataRecordAGEH;
        short aHSARDataRecordETHEW;
        short aISARDataRecordAGE0;
        short aISARDataRecordECONACT;
        short aISARDataRecordETHEW;
        short aISARDataRecordETHN;
        short aISARDataRecordETHS;
        Counts aCounts;
        TreeMap result = new TreeMap();
        while (tokenType != StreamTokenizer.TT_EOF) {
            switch (tokenType) {
                case StreamTokenizer.TT_WORD:
                    allPeople = 1;
                    allHouseholds = 0;
                    allPeopleAge0to4 = 0;
                    allPeopleAge5to9 = 0;
                    allPeopleAge10to14 = 0;
                    allPeopleAge15to19 = 0;
                    allPeopleAge20to24 = 0;
                    allPeopleAge25to29 = 0;
                    allPeopleAge30to44 = 0;
                    allPeopleAge45to59 = 0;
                    allPeopleAge60to64 = 0;
                    allPeopleAge65to69 = 0;
                    allPeopleAge70to74 = 0;
                    allPeopleAge75to79 = 0;
                    allPeopleAge80AndOver = 0;
                    allPeopleAge16to74 = 0;
                    malesAge16to74 = 0;
                    femalesAge16to74 = 0;
                    unemployedAge16to74 = 0;
                    // retiredAge16to74 = 0;
                    maleEconomicallyActiveAge16to74 = 0;
                    femaleEconomicallyActiveAge16to74 = 0;
                    ethnicityWhite = 0;
                    noCarOwnership = 0;
                    aToyModelDataRecord2 = new ToyModelDataRecord_2(
                            tToyModelDataHandler, tStreamTokenizer.sval);
                    if (aggregateToMSOA) {
                        aZoneCode = (String) tLookUpMSOAfromOAHashMap.get(new String(aToyModelDataRecord2.getZone_Code()));
                    } else {
                        aZoneCode = String.valueOf(aToyModelDataRecord2.getZone_Code());
                    }
                    if (aToyModelDataRecord2.tHouseholdID > 0) {
                        aISARDataRecord = (Census_ISARDataRecord) _ISARDataHandler_AGE0HRPOrdered.getDataRecord(aToyModelDataRecord2.tISARDataRecordID);
                        if (aISARDataRecord.get_RELTOHR() == 1) {
                            allHouseholds = 1;
                        }
                        aISARDataRecordAGE0 = aISARDataRecord.get_AGE0();
                        if (aISARDataRecordAGE0 < 5) {
                            allPeopleAge0to4 = 1;
                        } else {
                            if (aISARDataRecordAGE0 < 10) {
                                allPeopleAge5to9 = 1;
                            } else {
                                if (aISARDataRecordAGE0 < 15) {
                                    allPeopleAge10to14 = 1;
                                } else {
                                    if (aISARDataRecordAGE0 < 20) {
                                        allPeopleAge15to19 = 1;
                                    } else {
                                        if (aISARDataRecordAGE0 < 25) {
                                            allPeopleAge20to24 = 1;
                                        } else {
                                            if (aISARDataRecordAGE0 < 30) {
                                                allPeopleAge25to29 = 1;
                                            } else {
                                                if (aISARDataRecordAGE0 < 45) {
                                                    allPeopleAge30to44 = 1;
                                                } else {
                                                    if (aISARDataRecordAGE0 < 60) {
                                                        allPeopleAge45to59 = 1;
                                                    } else {
                                                        if (aISARDataRecordAGE0 < 65) {
                                                            allPeopleAge60to64 = 1;
                                                        } else {
                                                            if (aISARDataRecordAGE0 < 70) {
                                                                allPeopleAge65to69 = 1;
                                                            } else {
                                                                if (aISARDataRecordAGE0 < 75) {
                                                                    allPeopleAge70to74 = 1;
                                                                } else {
                                                                    if (aISARDataRecordAGE0 < 80) {
                                                                        allPeopleAge75to79 = 1;
                                                                    } else {
                                                                        allPeopleAge80AndOver = 1;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (aISARDataRecordAGE0 < 75) {
                                        aISARDataRecordECONACT = aISARDataRecord.get_ECONACT();
                                        if (aISARDataRecord.get_SEX()) {
                                            malesAge16to74 = 1;
                                            if (aISARDataRecordECONACT > 0 && aISARDataRecordECONACT < 9) {
                                                maleEconomicallyActiveAge16to74 = 1;
                                            }
                                        } else {
                                            femalesAge16to74 = 1;
                                            if (aISARDataRecordECONACT > 0 && aISARDataRecordECONACT < 9) {
                                                femaleEconomicallyActiveAge16to74 = 1;
                                            }
                                        }
                                        if (aISARDataRecordECONACT > 6 && aISARDataRecordECONACT < 9) {
                                            unemployedAge16to74 = 1;
                                        }
                                    }
                                }
                            }
                        }
                        aISARDataRecordETHEW = aISARDataRecord.get_ETHEW();
                        aISARDataRecordETHN = aISARDataRecord.get_ETHN();
                        aISARDataRecordETHS = aISARDataRecord.get_ETHS();
                        if (aISARDataRecordETHEW == -9) {
                            if (aISARDataRecordETHN == -9) {
                                if (aISARDataRecordETHS < 5) {
                                    ethnicityWhite = 1;
                                }
                            } else {
                                if (aISARDataRecordETHN == 1) {
                                    ethnicityWhite = 1;
                                }
                            }
                        } else {
                            if (aISARDataRecordETHEW < 4) {
                                ethnicityWhite = 1;
                            }
                        }
                        if (aISARDataRecord.get_CARS0() == 0) {
                            noCarOwnership = 1;
                        }
                    } else {
                        aISARDataRecord = (Census_ISARDataRecord) _ISARDataHandler_AGE0HRPOrdered.getDataRecord(aToyModelDataRecord2.tISARDataRecordID);
                        aISARDataRecordAGE0 = aISARDataRecord.get_AGE0();
                        if (aISARDataRecordAGE0 < 5) {
                            allPeopleAge0to4 = 1;
                        } else {
                            if (aISARDataRecordAGE0 < 10) {
                                allPeopleAge5to9 = 1;
                            } else {
                                if (aISARDataRecordAGE0 < 15) {
                                    allPeopleAge10to14 = 1;
                                } else {
                                    if (aISARDataRecordAGE0 < 20) {
                                        allPeopleAge15to19 = 1;
                                    } else {
                                        if (aISARDataRecordAGE0 < 25) {
                                            allPeopleAge20to24 = 1;
                                        } else {
                                            if (aISARDataRecordAGE0 < 30) {
                                                allPeopleAge25to29 = 1;
                                            } else {
                                                if (aISARDataRecordAGE0 < 45) {
                                                    allPeopleAge30to44 = 1;
                                                } else {
                                                    if (aISARDataRecordAGE0 < 60) {
                                                        allPeopleAge45to59 = 1;
                                                    } else {
                                                        if (aISARDataRecordAGE0 < 65) {
                                                            allPeopleAge60to64 = 1;
                                                        } else {
                                                            if (aISARDataRecordAGE0 < 70) {
                                                                allPeopleAge65to69 = 1;
                                                            } else {
                                                                if (aISARDataRecordAGE0 < 75) {
                                                                    allPeopleAge70to74 = 1;
                                                                } else {
                                                                    if (aISARDataRecordAGE0 < 80) {
                                                                        allPeopleAge75to79 = 1;
                                                                    } else {
                                                                        allPeopleAge80AndOver = 1;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (aISARDataRecordAGE0 < 75) {
                                        aISARDataRecordECONACT = aISARDataRecord.get_ECONACT();
                                        if (aISARDataRecord.get_SEX()) {
                                            malesAge16to74 = 1;
                                            if (aISARDataRecordECONACT > 0 && aISARDataRecordECONACT < 9) {
                                                maleEconomicallyActiveAge16to74 = 1;
                                            }
                                        } else {
                                            femalesAge16to74 = 1;
                                            if (aISARDataRecordECONACT > 0 && aISARDataRecordECONACT < 9) {
                                                femaleEconomicallyActiveAge16to74 = 1;
                                            }
                                        }
                                        if (aISARDataRecordECONACT > 6 && aISARDataRecordECONACT < 9) {
                                            unemployedAge16to74 = 1;
                                        }
                                    }
                                }
                            }
                        }
                        aISARDataRecordETHEW = aISARDataRecord.get_ETHEW();
                        aISARDataRecordETHN = aISARDataRecord.get_ETHN();
                        aISARDataRecordETHS = aISARDataRecord.get_ETHS();
                        if (aISARDataRecordETHEW == -9) {
                            if (aISARDataRecordETHN == -9) {
                                if (aISARDataRecordETHS < 5) {
                                    ethnicityWhite = 1;
                                }
                            } else {
                                if (aISARDataRecordETHN == 1) {
                                    ethnicityWhite = 1;
                                }
                            }
                        } else {
                            if (aISARDataRecordETHEW < 4) {
                                ethnicityWhite = 1;
                            }
                        }
                        if (aISARDataRecord.get_CARS0() == 0) {
                            noCarOwnership = 1;
                        }
                    }
                    if (result.containsKey(aZoneCode)) {
                        aCounts = (Counts) result.get(aZoneCode);
                        result.remove(aZoneCode);
                        aCounts.addToCounts(allPeople, allHouseholds,
                                allPeopleAge0to4, allPeopleAge5to9,
                                allPeopleAge10to14, allPeopleAge15to19,
                                allPeopleAge20to24, allPeopleAge25to29,
                                allPeopleAge30to44, allPeopleAge45to59,
                                allPeopleAge60to64, allPeopleAge65to69,
                                allPeopleAge70to74, allPeopleAge75to79,
                                allPeopleAge80AndOver, allPeopleAge16to74,
                                malesAge16to74, femalesAge16to74,
                                unemployedAge16to74,
                                maleEconomicallyActiveAge16to74,
                                femaleEconomicallyActiveAge16to74, ethnicityWhite,
                                noCarOwnership);
                        result.put(aZoneCode, aCounts);
                    } else {
                        aCounts = new Counts();
                        aCounts.addToCounts(allPeople, allHouseholds,
                                allPeopleAge0to4, allPeopleAge5to9,
                                allPeopleAge10to14, allPeopleAge15to19,
                                allPeopleAge20to24, allPeopleAge25to29,
                                allPeopleAge30to44, allPeopleAge45to59,
                                allPeopleAge60to64, allPeopleAge65to69,
                                allPeopleAge70to74, allPeopleAge75to79,
                                allPeopleAge80AndOver, allPeopleAge16to74,
                                malesAge16to74, femalesAge16to74,
                                unemployedAge16to74,
                                maleEconomicallyActiveAge16to74,
                                femaleEconomicallyActiveAge16to74, ethnicityWhite,
                                noCarOwnership);
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
            write(aCounts, aZoneCode);
        }
        this.aFileOutputStream.close();
    }

    private void write(Counts aCounts, String aZoneCode) throws IOException {
        String record = aZoneCode + "," + aCounts.allPeople + "," + aCounts.allHouseholds + "," + (aCounts.allPeopleAge0to4 / aCounts.allPeople) + "," + aCounts.allPeopleAge0to4 + "," + (aCounts.allPeopleAge5to9 / aCounts.allPeople) + "," + aCounts.allPeopleAge5to9 + "," + (aCounts.allPeopleAge10to14 / aCounts.allPeople) + "," + aCounts.allPeopleAge10to14 + "," + (aCounts.allPeopleAge15to19 / aCounts.allPeople) + "," + aCounts.allPeopleAge15to19 + "," + (aCounts.allPeopleAge20to24 / aCounts.allPeople) + "," + aCounts.allPeopleAge20to24 + "," + (aCounts.allPeopleAge25to29 / aCounts.allPeople) + "," + aCounts.allPeopleAge25to29 + "," + (aCounts.allPeopleAge30to44 / aCounts.allPeople) + "," + aCounts.allPeopleAge30to44 + "," + (aCounts.allPeopleAge45to59 / aCounts.allPeople) + "," + aCounts.allPeopleAge45to59 + "," + (aCounts.allPeopleAge60to64 / aCounts.allPeople) + "," + aCounts.allPeopleAge60to64 + "," + (aCounts.allPeopleAge65to69 / aCounts.allPeople) + "," + aCounts.allPeopleAge65to69 + "," + (aCounts.allPeopleAge70to74 / aCounts.allPeople) + "," + aCounts.allPeopleAge70to74 + "," + (aCounts.allPeopleAge75to79 / aCounts.allPeople) + "," + aCounts.allPeopleAge75to79 + "," + (aCounts.allPeopleAge80AndOver / aCounts.allPeople) + "," + aCounts.allPeopleAge80AndOver + "," + (aCounts.allPeopleAge16to74 / aCounts.allPeople) + "," + aCounts.allPeopleAge16to74 + "," + (aCounts.malesAge16to74 / aCounts.allPeople) + "," + aCounts.malesAge16to74 + "," + (aCounts.femalesAge16to74 / aCounts.allPeople) + "," + aCounts.femalesAge16to74 + "," + (aCounts.unemployedAge16to74 / aCounts.allPeopleAge16to74) + "," + aCounts.unemployedAge16to74 + "," +
                // ( aCounts.retiredAge16to74 /
                // aCounts.allPeopleAge16to74 ) + "," +
                // aCounts.retiredAge16to74 + "," +
                (aCounts.maleEconomicallyActiveAge16to74 / aCounts.malesAge16to74) + "," + aCounts.maleEconomicallyActiveAge16to74 + "," + (aCounts.femaleEconomicallyActiveAge16to74 / aCounts.femalesAge16to74) + "," + aCounts.femaleEconomicallyActiveAge16to74 + "," + (aCounts.ethnicityWhite / aCounts.allPeople) + "," + aCounts.ethnicityWhite + "," + (aCounts.noCarOwnership / aCounts.allHouseholds) + "," + aCounts.noCarOwnership;
        System.out.println(record);
        this.aFileOutputStream.write(record.getBytes());
        this.aFileOutputStream.write(StreamTokenizer.TT_EOL);
        this.aFileOutputStream.flush();
    }

    public class Counts {

        double allPeople;
        double allHouseholds;
        double allPeopleAge0to4;
        double allPeopleAge5to9;
        double allPeopleAge10to14;
        double allPeopleAge15to19;
        double allPeopleAge20to24;
        double allPeopleAge25to29;
        double allPeopleAge30to44;
        double allPeopleAge45to59;
        double allPeopleAge60to64;
        double allPeopleAge65to69;
        double allPeopleAge70to74;
        double allPeopleAge75to79;
        double allPeopleAge80AndOver;
        double allPeopleAge16to74;
        double malesAge16to74;
        double femalesAge16to74;
        double unemployedAge16to74;
        // double retiredAge16to74;
        double maleEconomicallyActiveAge16to74;
        double femaleEconomicallyActiveAge16to74;
        double ethnicityWhite;
        double noCarOwnership;

        public Counts() {
            allPeople = 0;
            allHouseholds = 0;
            allPeopleAge0to4 = 0;
            allPeopleAge5to9 = 0;
            allPeopleAge10to14 = 0;
            allPeopleAge15to19 = 0;
            allPeopleAge20to24 = 0;
            allPeopleAge25to29 = 0;
            allPeopleAge30to44 = 0;
            allPeopleAge45to59 = 0;
            allPeopleAge60to64 = 0;
            allPeopleAge65to69 = 0;
            allPeopleAge70to74 = 0;
            allPeopleAge75to79 = 0;
            allPeopleAge80AndOver = 0;
            allPeopleAge16to74 = 0;
            malesAge16to74 = 0;
            femalesAge16to74 = 0;
            unemployedAge16to74 = 0;
            // retiredAge16to74 = 0;
            maleEconomicallyActiveAge16to74 = 0;
            femaleEconomicallyActiveAge16to74 = 0;
            ethnicityWhite = 0;
            noCarOwnership = 0;
        }

        public void addToCounts(int allPeople, int allHouseholds,
                int allPeopleAge0to4, int allPeopleAge5to9,
                int allPeopleAge10to14, int allPeopleAge15to19,
                int allPeopleAge20to24, int allPeopleAge25to29,
                int allPeopleAge30to44, int allPeopleAge45to59,
                int allPeopleAge60to64, int allPeopleAge65to69,
                int allPeopleAge70to74, int allPeopleAge75to79,
                int allPeopleAge80AndOver, int allPeopleAge16to74,
                int malesAge16to74,
                int femalesAge16to74,
                int unemployedAge16to74,
                // int retiredAge16to74,
                int maleEconomicallyActiveAge16to74,
                int femaleEconomicallyActiveAge16to74, int ethnicityWhite,
                int noCarOwnership) {
            this.allPeople += allPeople;
            this.allHouseholds += allHouseholds;
            this.allPeopleAge0to4 += allPeopleAge0to4;
            this.allPeopleAge5to9 += allPeopleAge5to9;
            this.allPeopleAge10to14 += allPeopleAge10to14;
            this.allPeopleAge15to19 += allPeopleAge15to19;
            this.allPeopleAge20to24 += allPeopleAge20to24;
            this.allPeopleAge25to29 += allPeopleAge25to29;
            this.allPeopleAge30to44 += allPeopleAge30to44;
            this.allPeopleAge45to59 += allPeopleAge45to59;
            this.allPeopleAge60to64 += allPeopleAge60to64;
            this.allPeopleAge65to69 += allPeopleAge65to69;
            this.allPeopleAge70to74 += allPeopleAge70to74;
            this.allPeopleAge75to79 += allPeopleAge75to79;
            this.allPeopleAge80AndOver += allPeopleAge80AndOver;
            this.allPeopleAge16to74 += allPeopleAge16to74;
            this.malesAge16to74 += malesAge16to74;
            this.femalesAge16to74 += femalesAge16to74;
            this.unemployedAge16to74 += unemployedAge16to74;
            // this.retiredAge16to74 += retiredAge16to74;
            this.maleEconomicallyActiveAge16to74 += maleEconomicallyActiveAge16to74;
            this.femaleEconomicallyActiveAge16to74 += femaleEconomicallyActiveAge16to74;
            this.ethnicityWhite += ethnicityWhite;
            this.noCarOwnership += noCarOwnership;
        }
    }
}