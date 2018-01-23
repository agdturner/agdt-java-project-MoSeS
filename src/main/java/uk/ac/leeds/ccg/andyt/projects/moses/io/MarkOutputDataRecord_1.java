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

import uk.ac.leeds.ccg.andyt.census.core.Census_AbstractDataRecord;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataRecord;
import java.io.RandomAccessFile;

/**
 * A class for storing a format of data record wanted by Mark Birkin.
 */
public class MarkOutputDataRecord_1 extends Census_AbstractDataRecord {

    // see ISAR reltohr
    protected int allHouseholds; // reltohr == 1

    // see ISAR ethew, ethn, eths
    protected int ethnicGroupWhite; // ethew == 1,2,3
    protected int ethnicGroupMixed; // ethew == 4,5,6,7
    protected int ethnicGroupAsian; // ethew == 8,9,10,11
    protected int ethnicGroupBlack; // ethew == 12,13,14
    protected int ethnicGroupOther; // ethew == 15,16

    // see ISAR acctype
    protected int accomodationTypeDetached; // acctype == 1
    protected int accomodationTypeSemiDetatched; // acctype == 2
    protected int accomodationTypeTerracedOrBungalow; // acctype == 3
    protected int accomodationTypeFlats; // acctype == 4,5,6
    protected int accomodationTypeOther; // acctype == -9,7

    // see ISAR tenurew, tenuresn
    protected int tenureOwnerOccupied; // tenurew == 1,2
    protected int tenureRented; // tenurew == 4,5,6

    // see ISAR econact, nssec
    protected int econactUnemployed; // econact == 7,8
    protected int nssecProfessional; // nssec == 1-12
    protected int nssecIntermediate; // nssec == 13-30
    protected int nssecManual; // nssec == 31-35

    // see ISAR age0
    protected int age0to15; // age0 == 0-15
    protected int age16to24; // age0 == 16,20
    protected int age25to44; // age0 == 25,30
    protected int age45to64; // age0 == 45,60
    protected int age65AndOver; // age0 == 65-95

    // see ISAR sex
    protected int sexMales; // sex == 1
    protected int sexFemales; // sex == 2

    // see ISAR nssec, student, econact
    protected int nssecStudents; // nssec == 38
    protected int students; // student == 1
    protected int econactStudents; // econact == 10

    // see ISAR marstat, reltohr, famtype
    protected int marstatMarried; // marstat == 2,3,4
    protected int reltohrCoHabiting; // reltohr == 3 (partner to hrp)
    protected int marstatSingle; // marstat == 1,5,6
    protected int famtypeSingleParent; // famtype == 1,2
    protected int famtypeMarried; // famtype == 3,4,5
    protected int famtypeCoHabiting; // famtype == 6,7,8

    // see ISAR llti
    protected int llti; // llti == 1

    // see ISAR qualvewn, qualvs
    protected int qualvewNone; // qualvew == 1
    protected int qualvewLevel1; // qualvew == 2
    protected int qualvewLevel2; // qualvew == 3
    protected int qualvewLevel3; // qualvew == 4
    protected int qualvewLevel4; // qualvew == 5

    // see ISAR cars0
    protected double averageCarOwnership; // cars0 == 0,1,2,3 averaged

    // see ISAR tranwrk0
    protected int tranwrkPublic; // tranwrk0 == 2,3,4
    protected int tranwrkOwnVehicle; // tranwrk0 == 5,6,7,8
    protected int tranwrkWalk; // tranwrk0 == 9,10

    // see ISAR econact
    protected int econactPartTime; // econact == 1,3,5,
    protected int econactFullTime; // econact == 2,4,6

    // see ISAR roomsnum
    protected double roomsnumAverage; // roomsnum == 1,2,3,4 averaged (1 1-2
    // rooms,2 3-4 rooms,3 5-6 rooms,4 7+
    // rooms)

    /** Creates a new CASKS002Record */
    public MarkOutputDataRecord_1() {
        init();
    }

    /**
     * Initialises all fields.
     */
    protected void init() {
        super.init();
        this.allHouseholds = Integer.MIN_VALUE;
        this.ethnicGroupWhite = Integer.MIN_VALUE;
        this.ethnicGroupMixed = Integer.MIN_VALUE;
        this.ethnicGroupAsian = Integer.MIN_VALUE;
        this.ethnicGroupBlack = Integer.MIN_VALUE;
        this.ethnicGroupOther = Integer.MIN_VALUE;
        this.accomodationTypeDetached = Integer.MIN_VALUE;
        this.accomodationTypeSemiDetatched = Integer.MIN_VALUE;
        this.accomodationTypeTerracedOrBungalow = Integer.MIN_VALUE;
        this.accomodationTypeFlats = Integer.MIN_VALUE;
        this.accomodationTypeOther = Integer.MIN_VALUE;
        this.tenureOwnerOccupied = Integer.MIN_VALUE;
        this.tenureRented = Integer.MIN_VALUE;
        this.econactUnemployed = Integer.MIN_VALUE;
        this.nssecProfessional = Integer.MIN_VALUE;
        this.nssecIntermediate = Integer.MIN_VALUE;
        this.nssecManual = Integer.MIN_VALUE;
        this.age0to15 = Integer.MIN_VALUE;
        this.age16to24 = Integer.MIN_VALUE;
        this.age25to44 = Integer.MIN_VALUE;
        this.age45to64 = Integer.MIN_VALUE;
        this.age65AndOver = Integer.MIN_VALUE;
        this.sexMales = Integer.MIN_VALUE;
        this.sexFemales = Integer.MIN_VALUE;
        this.nssecStudents = Integer.MIN_VALUE;
        this.students = Integer.MIN_VALUE;
        this.econactStudents = Integer.MIN_VALUE;
        this.marstatMarried = Integer.MIN_VALUE;
        this.reltohrCoHabiting = Integer.MIN_VALUE;
        this.marstatSingle = Integer.MIN_VALUE;
        this.famtypeSingleParent = Integer.MIN_VALUE;
        this.famtypeMarried = Integer.MIN_VALUE;
        this.famtypeCoHabiting = Integer.MIN_VALUE;
        this.llti = Integer.MIN_VALUE;
        this.qualvewNone = Integer.MIN_VALUE;
        this.qualvewLevel1 = Integer.MIN_VALUE;
        this.qualvewLevel2 = Integer.MIN_VALUE;
        this.qualvewLevel3 = Integer.MIN_VALUE;
        this.qualvewLevel4 = Integer.MIN_VALUE;
        this.averageCarOwnership = Double.MIN_VALUE;
        this.tranwrkPublic = Integer.MIN_VALUE;
        this.tranwrkOwnVehicle = Integer.MIN_VALUE;
        this.tranwrkWalk = Integer.MIN_VALUE;
        this.econactPartTime = Integer.MIN_VALUE;
        this.econactFullTime = Integer.MIN_VALUE;
        this.roomsnumAverage = Double.MIN_VALUE;
    }

    /**
     * Initialises all fields.
     * @param individualSARDataRecord
     */
    protected void init(Census_ISARDataRecord individualSARDataRecord) {
        short RELTOHR = individualSARDataRecord.get_RELTOHR();
        if (RELTOHR == 1) {
            this.allHouseholds = 1;
        } else {
            this.allHouseholds = 0;
        }
        short ETHEW = individualSARDataRecord.get_ETHEW();
        if (ETHEW == 1 || ETHEW == 2 || ETHEW == 3) {
            this.ethnicGroupWhite = 1;
        } else {
            this.ethnicGroupWhite = 0;
        }
        if (ETHEW == 4 || ETHEW == 5 || ETHEW == 6 || ETHEW == 7) {
            this.ethnicGroupMixed = 1;
        } else {
            this.ethnicGroupMixed = 0;
        }
        if (ETHEW == 8 || ETHEW == 9 || ETHEW == 10 || ETHEW == 11) {
            this.ethnicGroupAsian = 1;
        } else {
            this.ethnicGroupAsian = 0;
        }
        if (ETHEW == 12 || ETHEW == 13 || ETHEW == 14) {
            this.ethnicGroupBlack = 1;
        } else {
            this.ethnicGroupBlack = 0;
        }
        if (ETHEW == 15 || ETHEW == 16) {
            this.ethnicGroupOther = 1;
        } else {
            this.ethnicGroupOther = 0;
        }
        short ACCTYPE = individualSARDataRecord.get_ACCTYPE();
        if (ACCTYPE == 1) {
            this.accomodationTypeDetached = 1;
        } else {
            this.accomodationTypeDetached = 0;
        }
        if (ACCTYPE == 2) {
            this.accomodationTypeSemiDetatched = 1;
        } else {
            this.accomodationTypeSemiDetatched = 0;
        }
        if (ACCTYPE == 3) {
            this.accomodationTypeTerracedOrBungalow = 1;
        } else {
            this.accomodationTypeTerracedOrBungalow = 0;
        }
        if (ACCTYPE == 4 || ACCTYPE == 5 || ACCTYPE == 6) {
            this.accomodationTypeFlats = 1;
        } else {
            this.accomodationTypeFlats = 0;
        }
        if (ACCTYPE == -9 || ACCTYPE == 7) {
            this.accomodationTypeOther = 1;
        } else {
            this.accomodationTypeOther = 0;
        }
        short TENUREW = individualSARDataRecord.get_TENUREW();
        if (TENUREW == 1 || TENUREW == 2) {
            this.tenureOwnerOccupied = 1;
        } else {
            this.tenureOwnerOccupied = 0;
        }
        if (TENUREW == 4 || TENUREW == 5 || TENUREW == 6) {
            this.tenureRented = 1;
        } else {
            this.tenureRented = 0;
        }
        short ECONACT = individualSARDataRecord.get_ECONACT();
        if (ECONACT == 7 || ECONACT == 8) {
            this.econactUnemployed = 1;
        } else {
            this.econactUnemployed = 0;
        }
        short NSSEC = individualSARDataRecord.get_NSSEC();
        if (NSSEC >= 1 && NSSEC <= 12) {
            this.nssecProfessional = 1;
        } else {
            this.nssecProfessional = 0;
        }
        if (NSSEC >= 13 && NSSEC <= 30) {
            this.nssecIntermediate = 1;
        } else {
            this.nssecIntermediate = 0;
        }
        if (NSSEC >= 31 && NSSEC <= 35) {
            this.nssecManual = 1;
        } else {
            this.nssecManual = 0;
        }
        short AGE0 = individualSARDataRecord.get_AGE0();
        if (AGE0 >= 0 && AGE0 <= 15) {
            this.age0to15 = 1;
        } else {
            this.age0to15 = 0;
        }
        if (AGE0 >= 16 && AGE0 <= 24) {
            this.age16to24 = 1;
        } else {
            this.age16to24 = 0;
        }
        if (AGE0 >= 25 && AGE0 <= 44) {
            this.age25to44 = 1;
        } else {
            this.age25to44 = 0;
        }
        if (AGE0 >= 45 && AGE0 <= 64) {
            this.age45to64 = 1;
        } else {
            this.age45to64 = 0;
        }
        if (AGE0 >= 65) {
            this.age65AndOver = 1;
        } else {
            this.age65AndOver = 0;
        }
        boolean SEX = individualSARDataRecord.get_SEX();
        if (SEX) {
            this.sexMales = 1;
            this.sexFemales = 0;
        } else {
            this.sexMales = 0;
            this.sexFemales = 1;
        }
        if (NSSEC == 38) {
            this.nssecStudents = 1;
        } else {
            this.nssecStudents = 0;
        }
        boolean STUDENT = individualSARDataRecord.get_STUDENT();
        if (STUDENT) {
            this.students = 1;
        } else {
            this.students = 0;
        }
        if (ECONACT == 10) {
            this.econactStudents = 1;
        } else {
            this.econactStudents = 0;
        }
        short MARSTAT = individualSARDataRecord.get_MARSTAT();
        if (MARSTAT == 2 || MARSTAT == 3 || MARSTAT == 4) {
            this.marstatMarried = 1;
        } else {
            this.marstatMarried = 0;
        }
        if (RELTOHR == 3) {
            this.reltohrCoHabiting = 1;
        } else {
            this.reltohrCoHabiting = 0;
        }
        if (MARSTAT == 1 || MARSTAT == 5 || MARSTAT == 6) {
            this.marstatSingle = 1;
        } else {
            this.marstatSingle = 0;
        }
        short FAMTYPE = individualSARDataRecord.get_FAMTYP();
        if (FAMTYPE == 1 || FAMTYPE == 2) {
            this.famtypeSingleParent = 1;
        } else {
            this.famtypeSingleParent = 0;
        }
        if (FAMTYPE == 3 || FAMTYPE == 4 || FAMTYPE == 5) {
            this.famtypeMarried = 1;
        } else {
            this.famtypeMarried = 0;
        }
        if (FAMTYPE == 6 || FAMTYPE == 7 || FAMTYPE == 8) {
            this.famtypeCoHabiting = 1;
        } else {
            this.famtypeCoHabiting = 0;
        }
        short LLTI = individualSARDataRecord.get_LLTI();
        if (LLTI == 1) {
            this.llti = 1;
        } else {
            this.llti = 0;
        }
        short QUALVEWN = individualSARDataRecord.get_QUALVEWN();
        if (QUALVEWN == 1) {
            this.qualvewNone = 1;
        } else {
            this.qualvewNone = 0;
        }
        if (QUALVEWN == 2) {
            this.qualvewLevel1 = 1;
        } else {
            this.qualvewLevel1 = 0;
        }
        if (QUALVEWN == 3) {
            this.qualvewLevel2 = 1;
        } else {
            this.qualvewLevel2 = 0;
        }
        if (QUALVEWN == 4) {
            this.qualvewLevel3 = 1;
        } else {
            this.qualvewLevel3 = 0;
        }
        if (QUALVEWN == 5) {
            this.qualvewLevel4 = 1;
        } else {
            this.qualvewLevel4 = 0;
        }
        short CARS0 = individualSARDataRecord.get_CARS0();
        this.averageCarOwnership = CARS0;
        short TRANWRK0 = individualSARDataRecord.get_TRANWRK0();
        if (TRANWRK0 == 2 || TRANWRK0 == 3 || TRANWRK0 == 4) {
            this.tranwrkPublic = 1;
        } else {
            this.tranwrkPublic = 0;
        }
        if (TRANWRK0 == 5 || TRANWRK0 == 6 || TRANWRK0 == 7 || TRANWRK0 == 8) {
            this.tranwrkOwnVehicle = 1;
        } else {
            this.tranwrkOwnVehicle = 0;
        }
        if (TRANWRK0 == 9 || TRANWRK0 == 10) {
            this.tranwrkWalk = 1;
        } else {
            this.tranwrkWalk = 0;
        }
        // short ECONACT = individualSARDataRecord.getECONACT();
        if (ECONACT == 1 || ECONACT == 3 || ECONACT == 5) {
            this.econactPartTime = 1;
        } else {
            this.econactPartTime = 0;
        }
        if (ECONACT == 2 || ECONACT == 4 || ECONACT == 6) {
            this.econactFullTime = 1;
        } else {
            this.econactFullTime = 0;
        }
        short ROOMSNUM = individualSARDataRecord.get_ROOMSNUM();
        this.roomsnumAverage = ROOMSNUM;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", allHouseholds " + allHouseholds + ", ethnicGroupWhite " + ethnicGroupWhite + ", ethnicGroupMixed " + ethnicGroupMixed + ", ethnicGroupAsian " + ethnicGroupAsian + ", ethnicGroupBlack " + ethnicGroupBlack + ", ethnicGroupOther " + ethnicGroupOther + ", accomodationTypeDetached " + accomodationTypeDetached + ", accomodationTypeSemiDetatched " + accomodationTypeSemiDetatched + ", accomodationTypeTerracedOrBungalow " + accomodationTypeTerracedOrBungalow + ", accomodationTypeFlats " + accomodationTypeFlats + ", accomodationTypeOther " + accomodationTypeOther + ", tenureOwnerOccupied " + tenureOwnerOccupied + ", tenureRented " + tenureRented + ", econactUnemployed " + econactUnemployed + ", nssecProfessional " + nssecProfessional + ", nssecIntermediate " + nssecIntermediate + ", nssecManual " + nssecManual + ", age0to15 " + age0to15 + ", age16to24 " + age16to24 + ", age25to44 " + age25to44 + ", age45to64 " + age45to64 + ", age65AndOver " + age65AndOver + ", sexMales " + sexMales + ", sexFemales " + sexFemales + ", nssecStudents " + nssecStudents + ", students " + students + ", econactStudents " + econactStudents + ", marstatMarried " + marstatMarried + ", reltohrCoHabiting " + reltohrCoHabiting + ", marstatSingle " + marstatSingle + ", famtypeSingleParent " + famtypeSingleParent + ", famtypeMarried " + famtypeMarried + ", famtypeCoHabiting " + famtypeCoHabiting + ", llti " + llti + ", qualvewNone " + qualvewNone + ", qualvewLevel1 " + qualvewLevel1 + ", qualvewLevel2 " + qualvewLevel2 + ", qualvewLevel3 " + qualvewLevel3 + ", qualvewLevel4 " + qualvewLevel4 + ", averageCarOwnership " + averageCarOwnership + ", tranwrkPublic " + tranwrkPublic + ", tranwrkOwnVehicle " + tranwrkOwnVehicle + ", tranwrkWalk " + tranwrkWalk + ", econactPartTime " + econactPartTime + ", econactFullTime " + econactFullTime + ", roomsnumAverage " + roomsnumAverage;
    }

    /**
     * Writes <code>this</code> to <code>aRandomAccessFile</code> at the current
     * position.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> this is written to.
     */
    @Override
    public void write(RandomAccessFile aRandomAccessFile) {
        super.write(aRandomAccessFile);
        write(aRandomAccessFile, false);
    }

    /**
     * Writes <code>this</code> to <code>aRandomAccessFile</code> at the current
     * position.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> this is written to.
     * @param avoidCallToSuper
     *            If true super.write() is not called
     */
    public void write(RandomAccessFile aRandomAccessFile,
            boolean avoidCallToSuper) {
        if (avoidCallToSuper) {
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * Returns the size of this CASKS2002Record in bytes as a long. This does
     * not account for serialVersionUID.
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (17L * (long) Integer.SIZE) / this.getNumberOfBitsInByte();
        return result;
    }
}
