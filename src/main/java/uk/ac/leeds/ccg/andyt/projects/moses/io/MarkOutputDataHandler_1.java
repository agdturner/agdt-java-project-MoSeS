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
package uk.ac.leeds.ccg.andyt.projects.moses.io;

import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataRecord;
import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataHandler;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataHandler;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A class for handling output data wanted by Mark Birkin.
 */
public class MarkOutputDataHandler_1 extends Census_AbstractDataHandler {

    /**
     * A File for writing output to.
     */
    protected File outputFile;
    /**
     * A FileOutputStream for File.
     */
    protected FileOutputStream fileOutputStream;
    /**
     * A Toy Model data handler.
     */
    protected ToyModelDataHandler toyModelDataHandler;

    /**
     * Creates a new instance of MarkOutputDataHandler_1
     */
    public MarkOutputDataHandler_1() {
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        MarkOutputDataHandler_1 markOutput1DataHandler = new MarkOutputDataHandler_1();
        // markOutput1DataHandler.runWard();
        // markOutput1DataHandler.runMSOA();
        markOutput1DataHandler.runOA();
    }

    /**
     * TODO docs
     *
     * @throws java.io.IOException
     */
    public void runWard() throws IOException {
        initWard();
        writeHeader();
        aggregateAndWriteMSOA();
    }

    /**
     * TODO docs
     *
     * @throws java.io.IOException
     */
    public void runMSOA() throws IOException {
        initMSOA();
        writeHeader();
        aggregateAndWriteMSOA();
    }

    /**
     * TODO docs
     *
     * @throws java.io.IOException
     */
    public void runOA() throws IOException {
        initOA();
        writeHeader();
        aggregateAndWriteOA();
    }

    /**
     * Initialises.
     *
     * @throws java.io.IOException
     */
    public void initOA() throws IOException {
        this.outputFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/MarkOutputOA.csv");
        try {
            fileOutputStream = new FileOutputStream(outputFile);
        } catch (FileNotFoundException fnfe0) {
            fnfe0.printStackTrace();
        }
        // this.toyModelDataHandler = new ToyModelDataHandler( new File(
        // "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile3.dat" ) );
        this.toyModelDataHandler = new ToyModelDataHandler(
                new ToyModelDataRecord_1(),
                new File(
                        "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile0.4.1.dat"));
    }

    /**
     * Initialises.
     *
     * @throws java.io.IOException
     */
    public void initMSOA() throws IOException {
        this.outputFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/MarkOutputMSOA.csv");
        try {
            fileOutputStream = new FileOutputStream(outputFile);
        } catch (FileNotFoundException fnfe0) {
            fnfe0.printStackTrace();
        }
        // this.toyModelDataHandler = new ToyModelDataHandler( new File(
        // "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile3.dat" ) );
        this.toyModelDataHandler = new ToyModelDataHandler(
                new ToyModelDataRecord_1(),
                new File(
                        "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile0.4.1.dat"));
    }

    /**
     * Initialises.
     *
     * @throws java.io.IOException
     */
    public void initWard() throws IOException {
        this.outputFile = new File(
                "C:/Work/Projects/MoSeS/Workspace/MarkOutputWard.csv");
        fileOutputStream = new FileOutputStream(outputFile);
        // this.toyModelDataHandler = new ToyModelDataHandler( new File(
        // "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile3.dat" ) );
        this.toyModelDataHandler = new ToyModelDataHandler(
                new ToyModelDataRecord_1(),
                new File(
                        "C:/Work/Projects/MoSeS/Workspace/ToyModelOutfile0.4.1.dat"));
    }

    /**
     * Writes out header.
     */
    public void writeHeader() {
        try {
            String header = "ZoneCode," + "AllHouseholds," + "White,Mixed,Asian,Black,Other," + "Detached,Semi-Detached,Terraced or Bungalow,Flats," + "OwnerOccupied,rented," + "Unemployed,Professional,intermediate,manual," + "Under16's,16-24,25-44,45-64,65+," + "Males,Females," + "Students," + "Married,Co-habiting,Single," + "Single-Parents," + "Long-term ill," + "No Qual's,Level1,Level2,Level3,Level4," + "AveCarOwnership,Public Transport,Own Vehicle,Walk," + "part time,full time," + "AvgNumberofRooms";
            this.fileOutputStream.write(header.getBytes());
            this.fileOutputStream.write(StreamTokenizer.TT_EOL);
            this.fileOutputStream.flush();
        } catch (IOException ioe0) {
            ioe0.printStackTrace();
        }
    }

    /**
     * Writes out MarkOutputDataRecord_1.
     *
     * @param markOutput1DataRecord
     */
    public void write(MarkOutputDataRecord_1 markOutput1DataRecord) {
        try {
            String record = String.valueOf(
                    markOutput1DataRecord.getZone_Code()) + ","
                    + markOutput1DataRecord.allHouseholds + ","
                    + markOutput1DataRecord.ethnicGroupWhite + ","
                    + markOutput1DataRecord.ethnicGroupMixed + ","
                    + markOutput1DataRecord.ethnicGroupAsian + ","
                    + markOutput1DataRecord.ethnicGroupBlack + ","
                    + markOutput1DataRecord.ethnicGroupOther + ","
                    + markOutput1DataRecord.accomodationTypeDetached + ","
                    + markOutput1DataRecord.accomodationTypeSemiDetatched + ","
                    + markOutput1DataRecord.accomodationTypeTerracedOrBungalow + ","
                    + markOutput1DataRecord.accomodationTypeFlats + ","
                    + markOutput1DataRecord.tenureOwnerOccupied + ","
                    + markOutput1DataRecord.tenureRented + ","
                    + markOutput1DataRecord.econactUnemployed + ","
                    + markOutput1DataRecord.nssecProfessional + ","
                    + markOutput1DataRecord.nssecIntermediate + ","
                    + markOutput1DataRecord.nssecManual + ","
                    + markOutput1DataRecord.age0to15 + ","
                    + markOutput1DataRecord.age16to24 + ","
                    + markOutput1DataRecord.age25to44 + ","
                    + markOutput1DataRecord.age45to64 + ","
                    + markOutput1DataRecord.age65AndOver + ","
                    + markOutput1DataRecord.sexMales + ","
                    + markOutput1DataRecord.sexFemales + ","
                    + markOutput1DataRecord.econactStudents + ","
                    // + markOutput1DataRecord.students + ","
                    // + markOutput1DataRecord.nssecStudents + ","
                    + markOutput1DataRecord.marstatMarried + ","
                    + markOutput1DataRecord.famtypeCoHabiting + ","
                    + markOutput1DataRecord.marstatSingle + ","
                    + markOutput1DataRecord.famtypeSingleParent + ","
                    + markOutput1DataRecord.llti + ","
                    + markOutput1DataRecord.qualvewNone + ","
                    + markOutput1DataRecord.qualvewLevel1 + ","
                    + markOutput1DataRecord.qualvewLevel2 + ","
                    + markOutput1DataRecord.qualvewLevel3 + ","
                    + markOutput1DataRecord.qualvewLevel4 + ","
                    + markOutput1DataRecord.averageCarOwnership + ","
                    + markOutput1DataRecord.tranwrkPublic + ","
                    + markOutput1DataRecord.tranwrkOwnVehicle + ","
                    + markOutput1DataRecord.tranwrkWalk + ","
                    + markOutput1DataRecord.econactPartTime + ","
                    + markOutput1DataRecord.econactFullTime + ","
                    + markOutput1DataRecord.roomsnumAverage;
            System.out.println(record);
            this.fileOutputStream.write(record.getBytes());
            this.fileOutputStream.write(StreamTokenizer.TT_EOL);
            this.fileOutputStream.flush();
        } catch (IOException ioe0) {
            ioe0.printStackTrace();
        }
    }

    /**
     * Writes out MarkOutputDataRecord_1 but with zoneCode as Zone_Code
     *
     * @param markOutput1DataRecord
     * @param zoneCode
     */
    public void write(MarkOutputDataRecord_1 markOutput1DataRecord,
            String zoneCode) {
        try {
            String record = zoneCode + "," + markOutput1DataRecord.allHouseholds + "," + markOutput1DataRecord.ethnicGroupWhite + "," + markOutput1DataRecord.ethnicGroupMixed + "," + markOutput1DataRecord.ethnicGroupAsian + "," + markOutput1DataRecord.ethnicGroupBlack + "," + markOutput1DataRecord.ethnicGroupOther + "," + markOutput1DataRecord.accomodationTypeDetached + "," + markOutput1DataRecord.accomodationTypeSemiDetatched + "," + markOutput1DataRecord.accomodationTypeTerracedOrBungalow + "," + markOutput1DataRecord.accomodationTypeFlats + "," + markOutput1DataRecord.tenureOwnerOccupied + "," + markOutput1DataRecord.tenureRented + "," + markOutput1DataRecord.econactUnemployed + "," + markOutput1DataRecord.nssecProfessional + "," + markOutput1DataRecord.nssecIntermediate + "," + markOutput1DataRecord.nssecManual + "," + markOutput1DataRecord.age0to15 + "," + markOutput1DataRecord.age16to24 + "," + markOutput1DataRecord.age25to44 + "," + markOutput1DataRecord.age45to64 + "," + markOutput1DataRecord.age65AndOver + "," + markOutput1DataRecord.sexMales + "," + markOutput1DataRecord.sexFemales + "," + markOutput1DataRecord.econactStudents + "," + // markOutput1DataRecord.students
                    // //markOutput1DataRecord.nssecStudents + "," +
                    markOutput1DataRecord.marstatMarried + "," + markOutput1DataRecord.famtypeCoHabiting + "," + markOutput1DataRecord.marstatSingle + "," + markOutput1DataRecord.famtypeSingleParent + "," + markOutput1DataRecord.llti + "," + markOutput1DataRecord.qualvewNone + "," + markOutput1DataRecord.qualvewLevel1 + "," + markOutput1DataRecord.qualvewLevel2 + "," + markOutput1DataRecord.qualvewLevel3 + "," + markOutput1DataRecord.qualvewLevel4 + "," + markOutput1DataRecord.averageCarOwnership + "," + markOutput1DataRecord.tranwrkPublic + "," + markOutput1DataRecord.tranwrkOwnVehicle + "," + markOutput1DataRecord.tranwrkWalk + "," + markOutput1DataRecord.econactPartTime + "," + markOutput1DataRecord.econactFullTime + "," + markOutput1DataRecord.roomsnumAverage;
            System.out.println(record);
            this.fileOutputStream.write(record.getBytes());
            this.fileOutputStream.write(StreamTokenizer.TT_EOL);
            this.fileOutputStream.flush();
        } catch (IOException ioe0) {
            ioe0.printStackTrace();
        }
    }

    /**
     * Aggregates estimates to wards
     *
     * @throws java.io.IOException
     */
    public void aggregateAndWriteWards() throws IOException {
        // Initialise
        long RecordID = 0;
        ToyModelDataRecord_1 toyModelDataRecord = null;
        long toyModelDataHandlerRandomAccessFileLength;
        toyModelDataRecord = this.toyModelDataHandler.getToyModelDataRecord1(RecordID);
        long toyModelDataNRecords = toyModelDataHandler.getNDataRecords();
        Census_ISARDataHandler _ISARDataHandler_AGE0HRPOrdered = new Census_ISARDataHandler(
                _File);
        long individualSARDataRecordID = toyModelDataRecord.ISARDataRecordID;
        Census_ISARDataRecord individualSARDataRecord = _ISARDataHandler_AGE0HRPOrdered.getISARDataRecord(individualSARDataRecordID);
        MarkOutputDataRecord_1 markOutput1DataRecord = new MarkOutputDataRecord_1();
        String zoneCode = String.valueOf(toyModelDataRecord.getZone_Code()).substring(0, 6);
        markOutput1DataRecord.setZone_Code(zoneCode.toCharArray());
        short RELTOHR = individualSARDataRecord.get_RELTOHR();
        if (RELTOHR == 1) {
            markOutput1DataRecord.allHouseholds = 1;
        } else {
            markOutput1DataRecord.allHouseholds = 0;
        }
        short ETHEW = individualSARDataRecord.get_ETHEW();
        if (ETHEW == 1 || ETHEW == 2 || ETHEW == 3) {
            markOutput1DataRecord.ethnicGroupWhite = 1;
        } else {
            markOutput1DataRecord.ethnicGroupWhite = 0;
        }
        if (ETHEW == 4 || ETHEW == 5 || ETHEW == 6 || ETHEW == 7) {
            markOutput1DataRecord.ethnicGroupMixed = 1;
        } else {
            markOutput1DataRecord.ethnicGroupMixed = 0;
        }
        if (ETHEW == 8 || ETHEW == 9 || ETHEW == 10 || ETHEW == 11) {
            markOutput1DataRecord.ethnicGroupAsian = 1;
        } else {
            markOutput1DataRecord.ethnicGroupAsian = 0;
        }
        if (ETHEW == 12 || ETHEW == 13 || ETHEW == 14) {
            markOutput1DataRecord.ethnicGroupBlack = 1;
        } else {
            markOutput1DataRecord.ethnicGroupBlack = 0;
        }
        if (ETHEW == 15 || ETHEW == 16) {
            markOutput1DataRecord.ethnicGroupOther = 1;
        } else {
            markOutput1DataRecord.ethnicGroupOther = 0;
        }
        short ACCTYPE = individualSARDataRecord.get_ACCTYPE();
        if (ACCTYPE == 1) {
            markOutput1DataRecord.accomodationTypeDetached = 1;
        } else {
            markOutput1DataRecord.accomodationTypeDetached = 0;
        }
        if (ACCTYPE == 2) {
            markOutput1DataRecord.accomodationTypeSemiDetatched = 1;
        } else {
            markOutput1DataRecord.accomodationTypeSemiDetatched = 0;
        }
        if (ACCTYPE == 3) {
            markOutput1DataRecord.accomodationTypeTerracedOrBungalow = 1;
        } else {
            markOutput1DataRecord.accomodationTypeTerracedOrBungalow = 0;
        }
        if (ACCTYPE == 4 || ACCTYPE == 5 || ACCTYPE == 6) {
            markOutput1DataRecord.accomodationTypeFlats = 1;
        } else {
            markOutput1DataRecord.accomodationTypeFlats = 0;
        }
        if (ACCTYPE == -9 || ACCTYPE == 7) {
            markOutput1DataRecord.accomodationTypeOther = 1;
        } else {
            markOutput1DataRecord.accomodationTypeOther = 0;
        }
        short TENUREW = individualSARDataRecord.get_TENUREW();
        if (TENUREW == 1 || TENUREW == 2) {
            markOutput1DataRecord.tenureOwnerOccupied = 1;
        } else {
            markOutput1DataRecord.tenureOwnerOccupied = 0;
        }
        if (TENUREW == 4 || TENUREW == 5 || TENUREW == 6) {
            markOutput1DataRecord.tenureRented = 1;
        } else {
            markOutput1DataRecord.tenureRented = 0;
        }
        short ECONACT = individualSARDataRecord.get_ECONACT();
        if (ECONACT == 7 || ECONACT == 8) {
            markOutput1DataRecord.econactUnemployed = 1;
        } else {
            markOutput1DataRecord.econactUnemployed = 0;
        }
        short NSSEC = individualSARDataRecord.get_NSSEC();
        if (NSSEC >= 1 && NSSEC <= 12) {
            markOutput1DataRecord.nssecProfessional = 1;
        } else {
            markOutput1DataRecord.nssecProfessional = 0;
        }
        if (NSSEC >= 13 && NSSEC <= 30) {
            markOutput1DataRecord.nssecIntermediate = 1;
        } else {
            markOutput1DataRecord.nssecIntermediate = 0;
        }
        if (NSSEC >= 31 && NSSEC <= 35) {
            markOutput1DataRecord.nssecManual = 1;
        } else {
            markOutput1DataRecord.nssecManual = 0;
        }
        short AGE0 = individualSARDataRecord.get_AGE0();
        if (AGE0 >= 0 && AGE0 <= 15) {
            markOutput1DataRecord.age0to15 = 1;
        } else {
            markOutput1DataRecord.age0to15 = 0;
        }
        if (AGE0 >= 16 && AGE0 <= 24) {
            markOutput1DataRecord.age16to24 = 1;
        } else {
            markOutput1DataRecord.age16to24 = 0;
        }
        if (AGE0 >= 25 && AGE0 <= 44) {
            markOutput1DataRecord.age25to44 = 1;
        } else {
            markOutput1DataRecord.age25to44 = 0;
        }
        if (AGE0 >= 45 && AGE0 <= 64) {
            markOutput1DataRecord.age45to64 = 1;
        } else {
            markOutput1DataRecord.age45to64 = 0;
        }
        if (AGE0 >= 65) {
            markOutput1DataRecord.age65AndOver = 1;
        } else {
            markOutput1DataRecord.age65AndOver = 0;
        }
        boolean SEX = individualSARDataRecord.get_SEX();
        if (SEX) {
            markOutput1DataRecord.sexMales = 1;
            markOutput1DataRecord.sexFemales = 0;
        } else {
            markOutput1DataRecord.sexMales = 0;
            markOutput1DataRecord.sexFemales = 1;
        }
        if (NSSEC == 38) {
            markOutput1DataRecord.nssecStudents = 1;
        } else {
            markOutput1DataRecord.nssecStudents = 0;
        }
        boolean STUDENT = individualSARDataRecord.get_STUDENT();
        if (STUDENT) {
            markOutput1DataRecord.students = 1;
        } else {
            markOutput1DataRecord.students = 0;
        }
        if (ECONACT == 10) {
            markOutput1DataRecord.econactStudents = 1;
        } else {
            markOutput1DataRecord.econactStudents = 0;
        }
        short MARSTAT = individualSARDataRecord.get_MARSTAT();
        if (MARSTAT == 2 || MARSTAT == 3 || MARSTAT == 4) {
            markOutput1DataRecord.marstatMarried = 1;
        } else {
            markOutput1DataRecord.marstatMarried = 0;
        }
        if (RELTOHR == 3) {
            markOutput1DataRecord.reltohrCoHabiting = 1;
        } else {
            markOutput1DataRecord.reltohrCoHabiting = 0;
        }
        if (MARSTAT == 1 || MARSTAT == 5 || MARSTAT == 6) {
            markOutput1DataRecord.marstatSingle = 1;
        } else {
            markOutput1DataRecord.marstatSingle = 0;
        }
        short FAMTYPE = individualSARDataRecord.get_FAMTYP();
        if (FAMTYPE == 1 || FAMTYPE == 2) {
            markOutput1DataRecord.famtypeSingleParent = 1;
        } else {
            markOutput1DataRecord.famtypeSingleParent = 0;
        }
        if (FAMTYPE == 3 || FAMTYPE == 4 || FAMTYPE == 5) {
            markOutput1DataRecord.famtypeMarried = 1;
        } else {
            markOutput1DataRecord.famtypeMarried = 0;
        }
        if (FAMTYPE == 6 || FAMTYPE == 7 || FAMTYPE == 8) {
            markOutput1DataRecord.famtypeCoHabiting = 1;
        } else {
            markOutput1DataRecord.famtypeCoHabiting = 0;
        }
        short LLTI = individualSARDataRecord.get_LLTI();
        if (LLTI == 1) {
            markOutput1DataRecord.llti = 1;
        } else {
            markOutput1DataRecord.llti = 0;
        }
        short QUALVEWN = individualSARDataRecord.get_QUALVEWN();
        if (QUALVEWN == 1) {
            markOutput1DataRecord.qualvewNone = 1;
        } else {
            markOutput1DataRecord.qualvewNone = 0;
        }
        if (QUALVEWN == 2) {
            markOutput1DataRecord.qualvewLevel1 = 1;
        } else {
            markOutput1DataRecord.qualvewLevel1 = 0;
        }
        if (QUALVEWN == 3) {
            markOutput1DataRecord.qualvewLevel2 = 1;
        } else {
            markOutput1DataRecord.qualvewLevel2 = 0;
        }
        if (QUALVEWN == 4) {
            markOutput1DataRecord.qualvewLevel3 = 1;
        } else {
            markOutput1DataRecord.qualvewLevel3 = 0;
        }
        if (QUALVEWN == 5) {
            markOutput1DataRecord.qualvewLevel4 = 1;
        } else {
            markOutput1DataRecord.qualvewLevel4 = 0;
        }
        short CARS0 = individualSARDataRecord.get_CARS0();
        markOutput1DataRecord.averageCarOwnership = CARS0;
        short TRANWRK0 = individualSARDataRecord.get_TRANWRK0();
        if (TRANWRK0 == 2 || TRANWRK0 == 3 || TRANWRK0 == 4) {
            markOutput1DataRecord.tranwrkPublic = 1;
        } else {
            markOutput1DataRecord.tranwrkPublic = 0;
        }
        if (TRANWRK0 == 5 || TRANWRK0 == 6 || TRANWRK0 == 7 || TRANWRK0 == 8) {
            markOutput1DataRecord.tranwrkOwnVehicle = 1;
        } else {
            markOutput1DataRecord.tranwrkOwnVehicle = 0;
        }
        if (TRANWRK0 == 9 || TRANWRK0 == 10) {
            markOutput1DataRecord.tranwrkWalk = 1;
        } else {
            markOutput1DataRecord.tranwrkWalk = 0;
        }
        // short ECONACT = individualSARDataRecord.getECONACT();
        if (ECONACT == 1 || ECONACT == 3 || ECONACT == 5) {
            markOutput1DataRecord.econactPartTime = 1;
        } else {
            markOutput1DataRecord.econactPartTime = 0;
        }
        if (ECONACT == 2 || ECONACT == 4 || ECONACT == 6) {
            markOutput1DataRecord.econactFullTime = 1;
        } else {
            markOutput1DataRecord.econactFullTime = 0;
        }
        short ROOMSNUM = individualSARDataRecord.get_ROOMSNUM();
        markOutput1DataRecord.roomsnumAverage = ROOMSNUM;
        for (RecordID = 1L; RecordID < toyModelDataNRecords; RecordID++) {
            try {
                toyModelDataRecord = this.toyModelDataHandler.getToyModelDataRecord1(RecordID);
            } catch (IOException ioe0) {
                ioe0.printStackTrace();
            }
            individualSARDataRecordID = toyModelDataRecord.ISARDataRecordID;
            individualSARDataRecord = _ISARDataHandler_AGE0HRPOrdered.getISARDataRecord(individualSARDataRecordID);
            RELTOHR = individualSARDataRecord.get_RELTOHR();
            ETHEW = individualSARDataRecord.get_ETHEW();
            ACCTYPE = individualSARDataRecord.get_ACCTYPE();
            TENUREW = individualSARDataRecord.get_TENUREW();
            ECONACT = individualSARDataRecord.get_ECONACT();
            NSSEC = individualSARDataRecord.get_NSSEC();
            AGE0 = individualSARDataRecord.get_AGE0();
            SEX = individualSARDataRecord.get_SEX();
            STUDENT = individualSARDataRecord.get_STUDENT();
            MARSTAT = individualSARDataRecord.get_MARSTAT();
            FAMTYPE = individualSARDataRecord.get_FAMTYP();
            LLTI = individualSARDataRecord.get_LLTI();
            QUALVEWN = individualSARDataRecord.get_QUALVEWN();
            CARS0 = individualSARDataRecord.get_CARS0();
            TRANWRK0 = individualSARDataRecord.get_TRANWRK0();
            ROOMSNUM = individualSARDataRecord.get_ROOMSNUM();

            if (String.valueOf(toyModelDataRecord.getZone_Code()).substring(0, 6).equalsIgnoreCase(zoneCode)) {

                if (RELTOHR == 1) {
                    markOutput1DataRecord.allHouseholds++;
                }
                if (ETHEW == 1 || ETHEW == 2 || ETHEW == 3) {
                    markOutput1DataRecord.ethnicGroupWhite++;
                }
                if (ETHEW == 4 || ETHEW == 5 || ETHEW == 6 || ETHEW == 7) {
                    markOutput1DataRecord.ethnicGroupMixed++;
                }
                if (ETHEW == 8 || ETHEW == 9 || ETHEW == 10 || ETHEW == 11) {
                    markOutput1DataRecord.ethnicGroupAsian++;
                }
                if (ETHEW == 12 || ETHEW == 13 || ETHEW == 14) {
                    markOutput1DataRecord.ethnicGroupBlack++;
                }
                if (ETHEW == 15 || ETHEW == 16) {
                    markOutput1DataRecord.ethnicGroupOther++;
                }
                if (ACCTYPE == 1) {
                    markOutput1DataRecord.accomodationTypeDetached++;
                }
                if (ACCTYPE == 2) {
                    markOutput1DataRecord.accomodationTypeSemiDetatched++;
                }
                if (ACCTYPE == 3) {
                    markOutput1DataRecord.accomodationTypeTerracedOrBungalow++;
                }
                if (ACCTYPE == 4 || ACCTYPE == 5 || ACCTYPE == 6) {
                    markOutput1DataRecord.accomodationTypeFlats++;
                }
                if (ACCTYPE == -9 || ACCTYPE == 7) {
                    markOutput1DataRecord.accomodationTypeOther++;
                }
                if (TENUREW == 1 || TENUREW == 2) {
                    markOutput1DataRecord.tenureOwnerOccupied++;
                }
                if (TENUREW == 4 || TENUREW == 5 || TENUREW == 6) {
                    markOutput1DataRecord.tenureRented++;
                }
                if (ECONACT == 7 || ECONACT == 8) {
                    markOutput1DataRecord.econactUnemployed++;
                }
                if (NSSEC >= 1 && NSSEC <= 12) {
                    markOutput1DataRecord.nssecProfessional++;
                }
                if (NSSEC >= 13 && NSSEC <= 30) {
                    markOutput1DataRecord.nssecIntermediate++;
                }
                if (NSSEC >= 31 && NSSEC <= 35) {
                    markOutput1DataRecord.nssecManual++;
                }
                if (AGE0 >= 0 && AGE0 <= 15) {
                    markOutput1DataRecord.age0to15++;
                }
                if (AGE0 >= 16 && AGE0 <= 24) {
                    markOutput1DataRecord.age16to24++;
                }
                if (AGE0 >= 25 && AGE0 <= 44) {
                    markOutput1DataRecord.age25to44++;
                }
                if (AGE0 >= 45 && AGE0 <= 64) {
                    markOutput1DataRecord.age45to64++;
                }
                if (AGE0 >= 65) {
                    markOutput1DataRecord.age65AndOver++;
                }
                if (SEX) {
                    markOutput1DataRecord.sexMales++;
                } else {
                    markOutput1DataRecord.sexFemales++;
                }
                if (NSSEC == 38) {
                    markOutput1DataRecord.nssecStudents++;
                }
                if (STUDENT) {
                    markOutput1DataRecord.students++;
                } else {
                    markOutput1DataRecord.students = 0;
                }
                if (ECONACT == 10) {
                    markOutput1DataRecord.econactStudents++;
                }
                if (MARSTAT == 2 || MARSTAT == 3 || MARSTAT == 4) {
                    markOutput1DataRecord.marstatMarried++;
                }
                if (RELTOHR == 3) {
                    markOutput1DataRecord.reltohrCoHabiting++;
                }
                if (MARSTAT == 1 || MARSTAT == 5 || MARSTAT == 6) {
                    markOutput1DataRecord.marstatSingle++;
                }
                if (FAMTYPE == 1 || FAMTYPE == 2) {
                    markOutput1DataRecord.famtypeSingleParent++;
                }
                if (FAMTYPE == 3 || FAMTYPE == 4 || FAMTYPE == 5) {
                    markOutput1DataRecord.famtypeMarried++;
                }
                if (FAMTYPE == 6 || FAMTYPE == 7 || FAMTYPE == 8) {
                    markOutput1DataRecord.famtypeCoHabiting++;
                }
                if (LLTI == 1) {
                    markOutput1DataRecord.llti++;
                }
                if (QUALVEWN == 1) {
                    markOutput1DataRecord.qualvewNone++;
                }
                if (QUALVEWN == 2) {
                    markOutput1DataRecord.qualvewLevel1++;
                }
                if (QUALVEWN == 3) {
                    markOutput1DataRecord.qualvewLevel2++;
                }
                if (QUALVEWN == 4) {
                    markOutput1DataRecord.qualvewLevel3++;
                }
                if (QUALVEWN == 5) {
                    markOutput1DataRecord.qualvewLevel4++;
                }
                markOutput1DataRecord.averageCarOwnership += CARS0;
                if (TRANWRK0 == 2 || TRANWRK0 == 3 || TRANWRK0 == 4) {
                    markOutput1DataRecord.tranwrkPublic++;
                }
                if (TRANWRK0 == 5 || TRANWRK0 == 6 || TRANWRK0 == 7 || TRANWRK0 == 8) {
                    markOutput1DataRecord.tranwrkOwnVehicle++;
                }
                if (TRANWRK0 == 9 || TRANWRK0 == 10) {
                    markOutput1DataRecord.tranwrkWalk++;
                }
                if (ECONACT == 1 || ECONACT == 3 || ECONACT == 5) {
                    markOutput1DataRecord.econactPartTime++;
                }
                if (ECONACT == 2 || ECONACT == 4 || ECONACT == 6) {
                    markOutput1DataRecord.econactFullTime++;
                }
                markOutput1DataRecord.roomsnumAverage += ROOMSNUM;
            } else {
                markOutput1DataRecord.averageCarOwnership = markOutput1DataRecord.averageCarOwnership / (double) markOutput1DataRecord.allHouseholds;
                markOutput1DataRecord.roomsnumAverage = markOutput1DataRecord.roomsnumAverage / (double) markOutput1DataRecord.allHouseholds;
                write(markOutput1DataRecord);
                zoneCode = String.valueOf(toyModelDataRecord.getZone_Code()).substring(0, 6);
                markOutput1DataRecord = new MarkOutputDataRecord_1();
                markOutput1DataRecord.setZone_Code(zoneCode.toCharArray());
                if (RELTOHR == 1) {
                    markOutput1DataRecord.allHouseholds = 1;
                } else {
                    markOutput1DataRecord.allHouseholds = 0;
                }
                if (ETHEW == 1 || ETHEW == 2 || ETHEW == 3) {
                    markOutput1DataRecord.ethnicGroupWhite = 1;
                } else {
                    markOutput1DataRecord.ethnicGroupWhite = 0;
                }
                if (ETHEW == 4 || ETHEW == 5 || ETHEW == 6 || ETHEW == 7) {
                    markOutput1DataRecord.ethnicGroupMixed = 1;
                } else {
                    markOutput1DataRecord.ethnicGroupMixed = 0;
                }
                if (ETHEW == 8 || ETHEW == 9 || ETHEW == 10 || ETHEW == 11) {
                    markOutput1DataRecord.ethnicGroupAsian = 1;
                } else {
                    markOutput1DataRecord.ethnicGroupAsian = 0;
                }
                if (ETHEW == 12 || ETHEW == 13 || ETHEW == 14) {
                    markOutput1DataRecord.ethnicGroupBlack = 1;
                } else {
                    markOutput1DataRecord.ethnicGroupBlack = 0;
                }
                if (ETHEW == 15 || ETHEW == 16) {
                    markOutput1DataRecord.ethnicGroupOther = 1;
                } else {
                    markOutput1DataRecord.ethnicGroupOther = 0;
                }
                if (ACCTYPE == 1) {
                    markOutput1DataRecord.accomodationTypeDetached = 1;
                } else {
                    markOutput1DataRecord.accomodationTypeDetached = 0;
                }
                if (ACCTYPE == 2) {
                    markOutput1DataRecord.accomodationTypeSemiDetatched = 1;
                } else {
                    markOutput1DataRecord.accomodationTypeSemiDetatched = 0;
                }
                if (ACCTYPE == 3) {
                    markOutput1DataRecord.accomodationTypeTerracedOrBungalow = 1;
                } else {
                    markOutput1DataRecord.accomodationTypeTerracedOrBungalow = 0;
                }
                if (ACCTYPE == 4 || ACCTYPE == 5 || ACCTYPE == 6) {
                    markOutput1DataRecord.accomodationTypeFlats = 1;
                } else {
                    markOutput1DataRecord.accomodationTypeFlats = 0;
                }
                if (ACCTYPE == -9 || ACCTYPE == 7) {
                    markOutput1DataRecord.accomodationTypeOther = 1;
                } else {
                    markOutput1DataRecord.accomodationTypeOther = 0;
                }
                if (TENUREW == 1 || TENUREW == 2) {
                    markOutput1DataRecord.tenureOwnerOccupied = 1;
                } else {
                    markOutput1DataRecord.tenureOwnerOccupied = 0;
                }
                if (TENUREW == 4 || TENUREW == 5 || TENUREW == 6) {
                    markOutput1DataRecord.tenureRented = 1;
                } else {
                    markOutput1DataRecord.tenureRented = 0;
                }
                if (ECONACT == 7 || ECONACT == 8) {
                    markOutput1DataRecord.econactUnemployed = 1;
                } else {
                    markOutput1DataRecord.econactUnemployed = 0;
                }
                if (NSSEC >= 1 && NSSEC <= 12) {
                    markOutput1DataRecord.nssecProfessional = 1;
                } else {
                    markOutput1DataRecord.nssecProfessional = 0;
                }
                if (NSSEC >= 13 && NSSEC <= 30) {
                    markOutput1DataRecord.nssecIntermediate = 1;
                } else {
                    markOutput1DataRecord.nssecIntermediate = 0;
                }
                if (NSSEC >= 31 && NSSEC <= 35) {
                    markOutput1DataRecord.nssecManual = 1;
                } else {
                    markOutput1DataRecord.nssecManual = 0;
                }
                if (AGE0 >= 0 && AGE0 <= 15) {
                    markOutput1DataRecord.age0to15 = 1;
                } else {
                    markOutput1DataRecord.age0to15 = 0;
                }
                if (AGE0 >= 16 && AGE0 <= 24) {
                    markOutput1DataRecord.age16to24 = 1;
                } else {
                    markOutput1DataRecord.age16to24 = 0;
                }
                if (AGE0 >= 25 && AGE0 <= 44) {
                    markOutput1DataRecord.age25to44 = 1;
                } else {
                    markOutput1DataRecord.age25to44 = 0;
                }
                if (AGE0 >= 45 && AGE0 <= 64) {
                    markOutput1DataRecord.age45to64 = 1;
                } else {
                    markOutput1DataRecord.age45to64 = 0;
                }
                if (AGE0 >= 65) {
                    markOutput1DataRecord.age65AndOver = 1;
                } else {
                    markOutput1DataRecord.age65AndOver = 0;
                }
                if (SEX) {
                    markOutput1DataRecord.sexMales = 1;
                    markOutput1DataRecord.sexFemales = 0;
                } else {
                    markOutput1DataRecord.sexMales = 0;
                    markOutput1DataRecord.sexFemales = 1;
                }
                if (NSSEC == 38) {
                    markOutput1DataRecord.nssecStudents = 1;
                } else {
                    markOutput1DataRecord.nssecStudents = 0;
                }
                if (STUDENT) {
                    markOutput1DataRecord.students = 1;
                } else {
                    markOutput1DataRecord.students = 0;
                }
                if (ECONACT == 10) {
                    markOutput1DataRecord.econactStudents = 1;
                } else {
                    markOutput1DataRecord.econactStudents = 0;
                }
                if (MARSTAT == 2 || MARSTAT == 3 || MARSTAT == 4) {
                    markOutput1DataRecord.marstatMarried = 1;
                } else {
                    markOutput1DataRecord.marstatMarried = 0;
                }
                if (RELTOHR == 3) {
                    markOutput1DataRecord.reltohrCoHabiting = 1;
                } else {
                    markOutput1DataRecord.reltohrCoHabiting = 0;
                }
                if (MARSTAT == 1 || MARSTAT == 5 || MARSTAT == 6) {
                    markOutput1DataRecord.marstatSingle = 1;
                } else {
                    markOutput1DataRecord.marstatSingle = 0;
                }
                if (FAMTYPE == 1 || FAMTYPE == 2) {
                    markOutput1DataRecord.famtypeSingleParent = 1;
                } else {
                    markOutput1DataRecord.famtypeSingleParent = 0;
                }
                if (FAMTYPE == 3 || FAMTYPE == 4 || FAMTYPE == 5) {
                    markOutput1DataRecord.famtypeMarried = 1;
                } else {
                    markOutput1DataRecord.famtypeMarried = 0;
                }
                if (FAMTYPE == 6 || FAMTYPE == 7 || FAMTYPE == 8) {
                    markOutput1DataRecord.famtypeCoHabiting = 1;
                } else {
                    markOutput1DataRecord.famtypeCoHabiting = 0;
                }
                if (LLTI == 1) {
                    markOutput1DataRecord.llti = 1;
                } else {
                    markOutput1DataRecord.llti = 0;
                }
                if (QUALVEWN == 1) {
                    markOutput1DataRecord.qualvewNone = 1;
                } else {
                    markOutput1DataRecord.qualvewNone = 0;
                }
                if (QUALVEWN == 2) {
                    markOutput1DataRecord.qualvewLevel1 = 1;
                } else {
                    markOutput1DataRecord.qualvewLevel1 = 0;
                }
                if (QUALVEWN == 3) {
                    markOutput1DataRecord.qualvewLevel2 = 1;
                } else {
                    markOutput1DataRecord.qualvewLevel2 = 0;
                }
                if (QUALVEWN == 4) {
                    markOutput1DataRecord.qualvewLevel3 = 1;
                } else {
                    markOutput1DataRecord.qualvewLevel3 = 0;
                }
                if (QUALVEWN == 5) {
                    markOutput1DataRecord.qualvewLevel4 = 1;
                } else {
                    markOutput1DataRecord.qualvewLevel4 = 0;
                }
                markOutput1DataRecord.averageCarOwnership = CARS0;
                if (TRANWRK0 == 2 || TRANWRK0 == 3 || TRANWRK0 == 4) {
                    markOutput1DataRecord.tranwrkPublic = 1;
                } else {
                    markOutput1DataRecord.tranwrkPublic = 0;
                }
                if (TRANWRK0 == 5 || TRANWRK0 == 6 || TRANWRK0 == 7 || TRANWRK0 == 8) {
                    markOutput1DataRecord.tranwrkOwnVehicle = 1;
                } else {
                    markOutput1DataRecord.tranwrkOwnVehicle = 0;
                }
                if (TRANWRK0 == 9 || TRANWRK0 == 10) {
                    markOutput1DataRecord.tranwrkWalk = 1;
                } else {
                    markOutput1DataRecord.tranwrkWalk = 0;
                }
                if (ECONACT == 1 || ECONACT == 3 || ECONACT == 5) {
                    markOutput1DataRecord.econactPartTime = 1;
                } else {
                    markOutput1DataRecord.econactPartTime = 0;
                }
                if (ECONACT == 2 || ECONACT == 4 || ECONACT == 6) {
                    markOutput1DataRecord.econactFullTime = 1;
                } else {
                    markOutput1DataRecord.econactFullTime = 0;
                }
                markOutput1DataRecord.roomsnumAverage = ROOMSNUM;
            }
        }
        markOutput1DataRecord.averageCarOwnership = markOutput1DataRecord.averageCarOwnership / (double) markOutput1DataRecord.allHouseholds;
        markOutput1DataRecord.roomsnumAverage = markOutput1DataRecord.roomsnumAverage / (double) markOutput1DataRecord.allHouseholds;
        write(markOutput1DataRecord);
    }

    /**
     * Aggregates estimates to MSOA MSOAs do not appear in any particular order,
     * so this is non-trivial.
     *
     * @throws java.io.IOException
     */
    public void aggregateAndWriteMSOA() throws IOException {
        // Initialise
        HashMap aggregateHashMap = new HashMap();
        HashMap lookUpMSOAfromOAHashMap = get_LookUpMSOAfromOAHashMap();
        long RecordID = 0;
        ToyModelDataRecord_1 toyModelDataRecord = null;
        long toyModelDataHandlerRandomAccessFileLength;
        toyModelDataRecord = this.toyModelDataHandler.getToyModelDataRecord1(RecordID);
        long toyModelDataNRecords = toyModelDataHandler.getNDataRecords();
        Census_ISARDataHandler _ISARDataHandler_AGE0HRPOrdered = new Census_ISARDataHandler();
        long individualSARDataRecordID = toyModelDataRecord.ISARDataRecordID;
        Census_ISARDataRecord individualSARDataRecord = _ISARDataHandler_AGE0HRPOrdered.getISARDataRecord(individualSARDataRecordID);
        MarkOutputDataRecord_1 markOutput1DataRecord = new MarkOutputDataRecord_1();
        // String zoneCode = String.valueOf( toyModelDataRecord.Zone_Code
        // ).substring( 0, 6 );
        String zoneCode = (String) lookUpMSOAfromOAHashMap.get(String.valueOf(toyModelDataRecord.getZone_Code()));
        String thisZoneCode;
        markOutput1DataRecord.setZone_Code(zoneCode.toCharArray());
        markOutput1DataRecord.init(individualSARDataRecord);
        int RELTOHR;
        int ETHEW;
        int ACCTYPE;
        int TENUREW;
        int ECONACT;
        int NSSEC;
        int AGE0;
        boolean SEX;
        boolean STUDENT;
        int MARSTAT;
        int FAMTYPE;
        int LLTI;
        int QUALVEWN;
        int CARS0;
        int TRANWRK0;
        int ROOMSNUM;
        aggregateHashMap.put(zoneCode, markOutput1DataRecord);
        for (RecordID = 1L; RecordID < toyModelDataNRecords; RecordID++) {
            try {
                toyModelDataRecord = this.toyModelDataHandler.getToyModelDataRecord1(RecordID);
            } catch (IOException ioe0) {
                ioe0.printStackTrace();
            }
            individualSARDataRecordID = toyModelDataRecord.ISARDataRecordID;
            individualSARDataRecord = _ISARDataHandler_AGE0HRPOrdered.getISARDataRecord(individualSARDataRecordID);
            RELTOHR = individualSARDataRecord.get_RELTOHR();
            ETHEW = individualSARDataRecord.get_ETHEW();
            ACCTYPE = individualSARDataRecord.get_ACCTYPE();
            TENUREW = individualSARDataRecord.get_TENUREW();
            ECONACT = individualSARDataRecord.get_ECONACT();
            NSSEC = individualSARDataRecord.get_NSSEC();
            AGE0 = individualSARDataRecord.get_AGE0();
            SEX = individualSARDataRecord.get_SEX();
            STUDENT = individualSARDataRecord.get_STUDENT();
            MARSTAT = individualSARDataRecord.get_MARSTAT();
            FAMTYPE = individualSARDataRecord.get_FAMTYP();
            LLTI = individualSARDataRecord.get_LLTI();
            QUALVEWN = individualSARDataRecord.get_QUALVEWN();
            CARS0 = individualSARDataRecord.get_CARS0();
            TRANWRK0 = individualSARDataRecord.get_TRANWRK0();
            ROOMSNUM = individualSARDataRecord.get_ROOMSNUM();

            thisZoneCode = ((String) lookUpMSOAfromOAHashMap.get(String.valueOf(toyModelDataRecord.getZone_Code())));
            if (aggregateHashMap.get(thisZoneCode) == null) {
                markOutput1DataRecord = new MarkOutputDataRecord_1();
                markOutput1DataRecord.init(individualSARDataRecord);
                aggregateHashMap.put(thisZoneCode, markOutput1DataRecord);
                System.out.println("Encountered " + thisZoneCode + " MSOA ");
            } else {
                markOutput1DataRecord = (MarkOutputDataRecord_1) aggregateHashMap.get(thisZoneCode);
            }
            if (RELTOHR == 1) {
                markOutput1DataRecord.allHouseholds++;
            }
            if (ETHEW == 1 || ETHEW == 2 || ETHEW == 3) {
                markOutput1DataRecord.ethnicGroupWhite++;
            }
            if (ETHEW == 4 || ETHEW == 5 || ETHEW == 6 || ETHEW == 7) {
                markOutput1DataRecord.ethnicGroupMixed++;
            }
            if (ETHEW == 8 || ETHEW == 9 || ETHEW == 10 || ETHEW == 11) {
                markOutput1DataRecord.ethnicGroupAsian++;
            }
            if (ETHEW == 12 || ETHEW == 13 || ETHEW == 14) {
                markOutput1DataRecord.ethnicGroupBlack++;
            }
            if (ETHEW == 15 || ETHEW == 16) {
                markOutput1DataRecord.ethnicGroupOther++;
            }
            if (ACCTYPE == 1) {
                markOutput1DataRecord.accomodationTypeDetached++;
            }
            if (ACCTYPE == 2) {
                markOutput1DataRecord.accomodationTypeSemiDetatched++;
            }
            if (ACCTYPE == 3) {
                markOutput1DataRecord.accomodationTypeTerracedOrBungalow++;
            }
            if (ACCTYPE == 4 || ACCTYPE == 5 || ACCTYPE == 6) {
                markOutput1DataRecord.accomodationTypeFlats++;
            }
            if (ACCTYPE == -9 || ACCTYPE == 7) {
                markOutput1DataRecord.accomodationTypeOther++;
            }
            if (TENUREW == 1 || TENUREW == 2) {
                markOutput1DataRecord.tenureOwnerOccupied++;
            }
            if (TENUREW == 4 || TENUREW == 5 || TENUREW == 6) {
                markOutput1DataRecord.tenureRented++;
            }
            if (ECONACT == 7 || ECONACT == 8) {
                markOutput1DataRecord.econactUnemployed++;
            }
            if (NSSEC >= 1 && NSSEC <= 12) {
                markOutput1DataRecord.nssecProfessional++;
            }
            if (NSSEC >= 13 && NSSEC <= 30) {
                markOutput1DataRecord.nssecIntermediate++;
            }
            if (NSSEC >= 31 && NSSEC <= 35) {
                markOutput1DataRecord.nssecManual++;
            }
            if (AGE0 >= 0 && AGE0 <= 15) {
                markOutput1DataRecord.age0to15++;
            }
            if (AGE0 >= 16 && AGE0 <= 24) {
                markOutput1DataRecord.age16to24++;
            }
            if (AGE0 >= 25 && AGE0 <= 44) {
                markOutput1DataRecord.age25to44++;
            }
            if (AGE0 >= 45 && AGE0 <= 64) {
                markOutput1DataRecord.age45to64++;
            }
            if (AGE0 >= 65) {
                markOutput1DataRecord.age65AndOver++;
            }
            if (SEX) {
                markOutput1DataRecord.sexMales++;
            } else {
                markOutput1DataRecord.sexFemales++;
            }
            if (NSSEC == 38) {
                markOutput1DataRecord.nssecStudents++;
            }
            if (STUDENT) {
                markOutput1DataRecord.students++;
            } else {
                markOutput1DataRecord.students = 0;
            }
            if (ECONACT == 10) {
                markOutput1DataRecord.econactStudents++;
            }
            if (MARSTAT == 2 || MARSTAT == 3 || MARSTAT == 4) {
                markOutput1DataRecord.marstatMarried++;
            }
            if (RELTOHR == 3) {
                markOutput1DataRecord.reltohrCoHabiting++;
            }
            if (MARSTAT == 1 || MARSTAT == 5 || MARSTAT == 6) {
                markOutput1DataRecord.marstatSingle++;
            }
            if (FAMTYPE == 1 || FAMTYPE == 2) {
                markOutput1DataRecord.famtypeSingleParent++;
            }
            if (FAMTYPE == 3 || FAMTYPE == 4 || FAMTYPE == 5) {
                markOutput1DataRecord.famtypeMarried++;
            }
            if (FAMTYPE == 6 || FAMTYPE == 7 || FAMTYPE == 8) {
                markOutput1DataRecord.famtypeCoHabiting++;
            }
            if (LLTI == 1) {
                markOutput1DataRecord.llti++;
            }
            if (QUALVEWN == 1) {
                markOutput1DataRecord.qualvewNone++;
            }
            if (QUALVEWN == 2) {
                markOutput1DataRecord.qualvewLevel1++;
            }
            if (QUALVEWN == 3) {
                markOutput1DataRecord.qualvewLevel2++;
            }
            if (QUALVEWN == 4) {
                markOutput1DataRecord.qualvewLevel3++;
            }
            if (QUALVEWN == 5) {
                markOutput1DataRecord.qualvewLevel4++;
            }
            markOutput1DataRecord.averageCarOwnership += CARS0;
            if (TRANWRK0 == 2 || TRANWRK0 == 3 || TRANWRK0 == 4) {
                markOutput1DataRecord.tranwrkPublic++;
            }
            if (TRANWRK0 == 5 || TRANWRK0 == 6 || TRANWRK0 == 7 || TRANWRK0 == 8) {
                markOutput1DataRecord.tranwrkOwnVehicle++;
            }
            if (TRANWRK0 == 9 || TRANWRK0 == 10) {
                markOutput1DataRecord.tranwrkWalk++;
            }
            if (ECONACT == 1 || ECONACT == 3 || ECONACT == 5) {
                markOutput1DataRecord.econactPartTime++;
            }
            if (ECONACT == 2 || ECONACT == 4 || ECONACT == 6) {
                markOutput1DataRecord.econactFullTime++;
            }
            markOutput1DataRecord.roomsnumAverage += ROOMSNUM;
            aggregateHashMap.put(thisZoneCode, markOutput1DataRecord);
            // System.out.println("Done " + RecordID );
        }
        write2(aggregateHashMap);
    }

    /**
     * Aggregates estimates to OA MSOAs do not appear in any particular order,
     * so this is non-trivial.
     *
     * @throws java.io.IOException
     */
    public void aggregateAndWriteOA() throws IOException {
        // Initialise
        HashMap aggregateHashMap = new HashMap();
        long RecordID = 0;
        ToyModelDataRecord_1 toyModelDataRecord = null;
        long toyModelDataHandlerRandomAccessFileLength;
        try {
            toyModelDataRecord = this.toyModelDataHandler.getToyModelDataRecord1(RecordID);
        } catch (IOException ioe0) {
            ioe0.printStackTrace();
        }
        long toyModelDataNRecords = toyModelDataHandler.getNDataRecords();
        Census_ISARDataHandler _ISARDataHandler_AGE0HRPOrdered = new Census_ISARDataHandler();
        long individualSARDataRecordID = toyModelDataRecord.ISARDataRecordID;
        Census_ISARDataRecord individualSARDataRecord = _ISARDataHandler_AGE0HRPOrdered.getISARDataRecord(individualSARDataRecordID);
        MarkOutputDataRecord_1 markOutput1DataRecord = new MarkOutputDataRecord_1();
        String zoneCode = new String(toyModelDataRecord.getZone_Code());
        String thisZoneCode;
        markOutput1DataRecord.setZone_Code(zoneCode.toCharArray());
        markOutput1DataRecord.init(individualSARDataRecord);
        int RELTOHR;
        int ETHEW;
        int ACCTYPE;
        int TENUREW;
        int ECONACT;
        int NSSEC;
        int AGE0;
        boolean SEX;
        boolean STUDENT;
        int MARSTAT;
        int FAMTYPE;
        int LLTI;
        int QUALVEWN;
        int CARS0;
        int TRANWRK0;
        int ROOMSNUM;
        aggregateHashMap.put(zoneCode, markOutput1DataRecord);
        for (RecordID = 1L; RecordID < toyModelDataNRecords; RecordID++) {
            try {
                toyModelDataRecord = this.toyModelDataHandler.getToyModelDataRecord1(RecordID);
            } catch (IOException ioe0) {
                ioe0.printStackTrace();
            }
            individualSARDataRecordID = toyModelDataRecord.ISARDataRecordID;
            individualSARDataRecord = _ISARDataHandler_AGE0HRPOrdered.getISARDataRecord(individualSARDataRecordID);
            RELTOHR = individualSARDataRecord.get_RELTOHR();
            ETHEW = individualSARDataRecord.get_ETHEW();
            ACCTYPE = individualSARDataRecord.get_ACCTYPE();
            TENUREW = individualSARDataRecord.get_TENUREW();
            ECONACT = individualSARDataRecord.get_ECONACT();
            NSSEC = individualSARDataRecord.get_NSSEC();
            AGE0 = individualSARDataRecord.get_AGE0();
            SEX = individualSARDataRecord.get_SEX();
            STUDENT = individualSARDataRecord.get_STUDENT();
            MARSTAT = individualSARDataRecord.get_MARSTAT();
            FAMTYPE = individualSARDataRecord.get_FAMTYP();
            LLTI = individualSARDataRecord.get_LLTI();
            QUALVEWN = individualSARDataRecord.get_QUALVEWN();
            CARS0 = individualSARDataRecord.get_CARS0();
            TRANWRK0 = individualSARDataRecord.get_TRANWRK0();
            ROOMSNUM = individualSARDataRecord.get_ROOMSNUM();

            thisZoneCode = new String(toyModelDataRecord.getZone_Code());
            if (aggregateHashMap.get(thisZoneCode) == null) {
                markOutput1DataRecord = new MarkOutputDataRecord_1();
                markOutput1DataRecord.init(individualSARDataRecord);
                aggregateHashMap.put(thisZoneCode, markOutput1DataRecord);
                System.out.println("Encountered " + thisZoneCode + " OA ");
            } else {
                markOutput1DataRecord = (MarkOutputDataRecord_1) aggregateHashMap.get(thisZoneCode);
            }
            if (RELTOHR == 1) {
                markOutput1DataRecord.allHouseholds++;
            }
            if (ETHEW == 1 || ETHEW == 2 || ETHEW == 3) {
                markOutput1DataRecord.ethnicGroupWhite++;
            }
            if (ETHEW == 4 || ETHEW == 5 || ETHEW == 6 || ETHEW == 7) {
                markOutput1DataRecord.ethnicGroupMixed++;
            }
            if (ETHEW == 8 || ETHEW == 9 || ETHEW == 10 || ETHEW == 11) {
                markOutput1DataRecord.ethnicGroupAsian++;
            }
            if (ETHEW == 12 || ETHEW == 13 || ETHEW == 14) {
                markOutput1DataRecord.ethnicGroupBlack++;
            }
            if (ETHEW == 15 || ETHEW == 16) {
                markOutput1DataRecord.ethnicGroupOther++;
            }
            if (ACCTYPE == 1) {
                markOutput1DataRecord.accomodationTypeDetached++;
            }
            if (ACCTYPE == 2) {
                markOutput1DataRecord.accomodationTypeSemiDetatched++;
            }
            if (ACCTYPE == 3) {
                markOutput1DataRecord.accomodationTypeTerracedOrBungalow++;
            }
            if (ACCTYPE == 4 || ACCTYPE == 5 || ACCTYPE == 6) {
                markOutput1DataRecord.accomodationTypeFlats++;
            }
            if (ACCTYPE == -9 || ACCTYPE == 7) {
                markOutput1DataRecord.accomodationTypeOther++;
            }
            if (TENUREW == 1 || TENUREW == 2) {
                markOutput1DataRecord.tenureOwnerOccupied++;
            }
            if (TENUREW == 4 || TENUREW == 5 || TENUREW == 6) {
                markOutput1DataRecord.tenureRented++;
            }
            if (ECONACT == 7 || ECONACT == 8) {
                markOutput1DataRecord.econactUnemployed++;
            }
            if (NSSEC >= 1 && NSSEC <= 12) {
                markOutput1DataRecord.nssecProfessional++;
            }
            if (NSSEC >= 13 && NSSEC <= 30) {
                markOutput1DataRecord.nssecIntermediate++;
            }
            if (NSSEC >= 31 && NSSEC <= 35) {
                markOutput1DataRecord.nssecManual++;
            }
            if (AGE0 >= 0 && AGE0 <= 15) {
                markOutput1DataRecord.age0to15++;
            }
            if (AGE0 >= 16 && AGE0 <= 24) {
                markOutput1DataRecord.age16to24++;
            }
            if (AGE0 >= 25 && AGE0 <= 44) {
                markOutput1DataRecord.age25to44++;
            }
            if (AGE0 >= 45 && AGE0 <= 64) {
                markOutput1DataRecord.age45to64++;
            }
            if (AGE0 >= 65) {
                markOutput1DataRecord.age65AndOver++;
            }
            if (SEX) {
                markOutput1DataRecord.sexMales++;
            } else {
                markOutput1DataRecord.sexFemales++;
            }
            if (NSSEC == 38) {
                markOutput1DataRecord.nssecStudents++;
            }
            if (STUDENT) {
                markOutput1DataRecord.students++;
            } else {
                markOutput1DataRecord.students = 0;
            }
            if (ECONACT == 10) {
                markOutput1DataRecord.econactStudents++;
            }
            if (MARSTAT == 2 || MARSTAT == 3 || MARSTAT == 4) {
                markOutput1DataRecord.marstatMarried++;
            }
            if (RELTOHR == 3) {
                markOutput1DataRecord.reltohrCoHabiting++;
            }
            if (MARSTAT == 1 || MARSTAT == 5 || MARSTAT == 6) {
                markOutput1DataRecord.marstatSingle++;
            }
            if (FAMTYPE == 1 || FAMTYPE == 2) {
                markOutput1DataRecord.famtypeSingleParent++;
            }
            if (FAMTYPE == 3 || FAMTYPE == 4 || FAMTYPE == 5) {
                markOutput1DataRecord.famtypeMarried++;
            }
            if (FAMTYPE == 6 || FAMTYPE == 7 || FAMTYPE == 8) {
                markOutput1DataRecord.famtypeCoHabiting++;
            }
            if (LLTI == 1) {
                markOutput1DataRecord.llti++;
            }
            if (QUALVEWN == 1) {
                markOutput1DataRecord.qualvewNone++;
            }
            if (QUALVEWN == 2) {
                markOutput1DataRecord.qualvewLevel1++;
            }
            if (QUALVEWN == 3) {
                markOutput1DataRecord.qualvewLevel2++;
            }
            if (QUALVEWN == 4) {
                markOutput1DataRecord.qualvewLevel3++;
            }
            if (QUALVEWN == 5) {
                markOutput1DataRecord.qualvewLevel4++;
            }
            markOutput1DataRecord.averageCarOwnership += CARS0;
            if (TRANWRK0 == 2 || TRANWRK0 == 3 || TRANWRK0 == 4) {
                markOutput1DataRecord.tranwrkPublic++;
            }
            if (TRANWRK0 == 5 || TRANWRK0 == 6 || TRANWRK0 == 7 || TRANWRK0 == 8) {
                markOutput1DataRecord.tranwrkOwnVehicle++;
            }
            if (TRANWRK0 == 9 || TRANWRK0 == 10) {
                markOutput1DataRecord.tranwrkWalk++;
            }
            if (ECONACT == 1 || ECONACT == 3 || ECONACT == 5) {
                markOutput1DataRecord.econactPartTime++;
            }
            if (ECONACT == 2 || ECONACT == 4 || ECONACT == 6) {
                markOutput1DataRecord.econactFullTime++;
            }
            markOutput1DataRecord.roomsnumAverage += ROOMSNUM;
            aggregateHashMap.put(thisZoneCode, markOutput1DataRecord);
        }
        write2(aggregateHashMap);
    }

    /**
     * TODO docs
     *
     * @param aggregateHashMap
     */
    public void write1(HashMap aggregateHashMap) {
        Iterator iterator = aggregateHashMap.keySet().iterator();
        Object key;
        MarkOutputDataRecord_1 markOutput1DataRecord;
        while (iterator.hasNext()) {
            key = iterator.next();
            markOutput1DataRecord = (MarkOutputDataRecord_1) aggregateHashMap.get(key);
            write(markOutput1DataRecord);
        }
    }

    /**
     * TODO docs
     *
     * @param aggregateHashMap
     */
    public void write2(HashMap aggregateHashMap) {
        Iterator iterator = aggregateHashMap.keySet().iterator();
        Object key;
        MarkOutputDataRecord_1 markOutput1DataRecord;
        while (iterator.hasNext()) {
            key = iterator.next();
            markOutput1DataRecord = (MarkOutputDataRecord_1) aggregateHashMap.get(key);
            write(markOutput1DataRecord, (String) key);
        }
    }

    public Census_AbstractDataRecord getDataRecord(long RecordID) {
        return null;
    }
}
