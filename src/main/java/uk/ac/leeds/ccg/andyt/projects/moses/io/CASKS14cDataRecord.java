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

import java.io.IOException;
import java.io.RandomAccessFile;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.projects.moses.utilities.StaticConverter;

/**
 * For representing CAS KS14c Records and providing safe access to the data.
 */
public class CASKS14cDataRecord extends AbstractCASDataRecord {

    /**
     * Table KS014c National Statistics - Socio Economic Classification -
     * females aged 16-74 Footnotes and Comments for Table KS014c 1. For
     * long-term unemployed year last worked is 1999 or earlier. 2. In the
     * NS-SeC classification, all full-time students are recorded in the
     * 'full-time students' category regardless of whether they are economically
     * active or not. 3. Not classifiable for other reasons' includes people
     * whose occupation has not been coded.
     */
    /**
     * KS014c0001 = femalesAged16to74
     */
    protected int femalesAged16to74;
    /**
     * KS014c0002 =
     * femalesAged16to74LargeEmployersAndHigherManagerialOccupations
     */
    protected int femalesAged16to74LargeEmployersAndHigherManagerialOccupations;
    /**
     * KS014c0003 = femalesAged16to74HigherProfessionalOccupations
     */
    protected int femalesAged16to74HigherProfessionalOccupations;
    /**
     * KS014c0004 =
     * femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate
     */
    protected int femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate;
    /**
     * KS014c0005 = femalesAged16to74IntermediateOccupations
     */
    protected int femalesAged16to74IntermediateOccupations;
    /**
     * KS014c0006 = femalesAged16to74SmallEmployersAndOwnAccountWorkers
     */
    protected int femalesAged16to74SmallEmployersAndOwnAccountWorkers;
    /**
     * KS014c0007 = femalesAged16to74LowerSupervisoryAndTechnicalOccupations
     */
    protected int femalesAged16to74LowerSupervisoryAndTechnicalOccupations;
    /**
     * KS014c014c = femalesAged16to74SemiRoutineOccupations
     */
    protected int femalesAged16to74SemiRoutineOccupations;
    /**
     * KS014c0009 = femalesAged16to74RoutineOccupations
     */
    protected int femalesAged16to74RoutineOccupations;
    /**
     * KS014c0010 = femalesAged16to74NeverWorked
     */
    protected int femalesAged16to74NeverWorked;
    /**
     * KS014c0011 = femalesAged16to74LongTermUnemployed
     */
    protected int femalesAged16to74LongTermUnemployed;
    /**
     * KS014c0012 = femalesAged16to74FullTimeStudents
     */
    protected int femalesAged16to74FullTimeStudents;

    // Taken out as not in Northern Ireland
    // /**
    // * KS014c0013 = femalesAged16to74NotClassifiableForOtherReasons
    // */
    // protected int femalesAged16to74NotClassifiableForOtherReasons;
    /** Creates a new CASKS14cRecord */
    public CASKS14cDataRecord() {
        _Init();
    }

    /**
     * Creates a new CASKS14cRecord cloned from aCASKS14cRecord
     *
     * @param aCASKS14cRecord
     *            The CASKS14cRecord from which this is cloned.
     */
    public CASKS14cDataRecord(CASKS14cDataRecord aCASKS14cRecord) {
        init(aCASKS14cRecord);
    }

    /**
     * Creates a new CASKS14cDataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public CASKS14cDataRecord(long RecordID, String line) throws IOException {
        String[] fieldsDummy = line.split(",");
        // System.out.println(fieldsDummy.length);
        // for (int i = 0; i < fieldsDummy.length; i ++ ){
        // System.out.println(fieldsDummy[i]);
        // }
        String[] fields = new String[13];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = "";
        }
        System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
        this._RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table KS14c
        this.femalesAged16to74 = StaticConverter.to_int(fields[1]);
        this.femalesAged16to74LargeEmployersAndHigherManagerialOccupations = StaticConverter.to_int(fields[2]);
        this.femalesAged16to74HigherProfessionalOccupations = StaticConverter.to_int(fields[3]);
        this.femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate = StaticConverter.to_int(fields[4]);
        this.femalesAged16to74IntermediateOccupations = StaticConverter.to_int(fields[5]);
        this.femalesAged16to74SmallEmployersAndOwnAccountWorkers = StaticConverter.to_int(fields[6]);
        this.femalesAged16to74LowerSupervisoryAndTechnicalOccupations = StaticConverter.to_int(fields[7]);
        this.femalesAged16to74SemiRoutineOccupations = StaticConverter.to_int(fields[8]);
        this.femalesAged16to74RoutineOccupations = StaticConverter.to_int(fields[9]);
        this.femalesAged16to74NeverWorked = StaticConverter.to_int(fields[10]);
        this.femalesAged16to74LongTermUnemployed = StaticConverter.to_int(fields[11]);
        this.femalesAged16to74FullTimeStudents = StaticConverter.to_int(fields[12]);
    // this.femalesAged16to74NotClassifiableForOtherReasons =
    // StaticConverter.to_int( fields[ 13 ] );
    }

    /**
     * Creates a new CASKS14cRecord
     *
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public CASKS14cDataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.femalesAged16to74 = aRandomAccessFile.readInt();
            this.femalesAged16to74LargeEmployersAndHigherManagerialOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74HigherProfessionalOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate = aRandomAccessFile.readInt();
            this.femalesAged16to74IntermediateOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74SmallEmployersAndOwnAccountWorkers = aRandomAccessFile.readInt();
            this.femalesAged16to74LowerSupervisoryAndTechnicalOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74SemiRoutineOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74RoutineOccupations = aRandomAccessFile.readInt();
            this.femalesAged16to74NeverWorked = aRandomAccessFile.readInt();
            this.femalesAged16to74LongTermUnemployed = aRandomAccessFile.readInt();
            this.femalesAged16to74FullTimeStudents = aRandomAccessFile.readInt();
        } catch (IOException ioe0) {
            // ioe0.printStackTrace();
            System.out.println("RecordID " + _RecordID + " zoneCode " + new String(Zone_Code));
            throw ioe0;
        }
    }

    /**
     * Initialises all fields.
     */
    protected void _Init() {
        super._Init();
        this.femalesAged16to74 = Integer.MIN_VALUE;
        this.femalesAged16to74LargeEmployersAndHigherManagerialOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74HigherProfessionalOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate = Integer.MIN_VALUE;
        this.femalesAged16to74IntermediateOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74SmallEmployersAndOwnAccountWorkers = Integer.MIN_VALUE;
        this.femalesAged16to74LowerSupervisoryAndTechnicalOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74SemiRoutineOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74RoutineOccupations = Integer.MIN_VALUE;
        this.femalesAged16to74NeverWorked = Integer.MIN_VALUE;
        this.femalesAged16to74LongTermUnemployed = Integer.MIN_VALUE;
        this.femalesAged16to74FullTimeStudents = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields from those in cASKS14cRecord.
     *
     * @param cASKS14cRecord
     *            The CASKS14cRecord thats fields are used to initialise this.
     */
    protected void init(CASKS14cDataRecord cASKS14cRecord) {
        super.init(cASKS14cRecord);
        this.femalesAged16to74 = cASKS14cRecord.femalesAged16to74;
        this.femalesAged16to74LargeEmployersAndHigherManagerialOccupations = cASKS14cRecord.femalesAged16to74LargeEmployersAndHigherManagerialOccupations;
        this.femalesAged16to74HigherProfessionalOccupations = cASKS14cRecord.femalesAged16to74HigherProfessionalOccupations;
        this.femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate = cASKS14cRecord.femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate;
        this.femalesAged16to74IntermediateOccupations = cASKS14cRecord.femalesAged16to74IntermediateOccupations;
        this.femalesAged16to74SmallEmployersAndOwnAccountWorkers = cASKS14cRecord.femalesAged16to74SmallEmployersAndOwnAccountWorkers;
        this.femalesAged16to74LowerSupervisoryAndTechnicalOccupations = cASKS14cRecord.femalesAged16to74LowerSupervisoryAndTechnicalOccupations;
        this.femalesAged16to74SemiRoutineOccupations = cASKS14cRecord.femalesAged16to74SemiRoutineOccupations;
        this.femalesAged16to74RoutineOccupations = cASKS14cRecord.femalesAged16to74RoutineOccupations;
        this.femalesAged16to74NeverWorked = cASKS14cRecord.femalesAged16to74NeverWorked;
        this.femalesAged16to74LongTermUnemployed = cASKS14cRecord.femalesAged16to74LongTermUnemployed;
        this.femalesAged16to74FullTimeStudents = cASKS14cRecord.femalesAged16to74FullTimeStudents;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", femalesAged16to74 " + femalesAged16to74 + ", femalesAged16to74LargeEmployersAndHigherManagerialOccupations " + femalesAged16to74LargeEmployersAndHigherManagerialOccupations + ", femalesAged16to74HigherProfessionalOccupations " + femalesAged16to74HigherProfessionalOccupations + ", femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate " + femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate + ", femalesAged16to74IntermediateOccupations " + femalesAged16to74IntermediateOccupations + ", femalesAged16to74SmallEmployersAndOwnAccountWorkers " + femalesAged16to74SmallEmployersAndOwnAccountWorkers + ", femalesAged16to74LowerSupervisoryAndTechnicalOccupations" + femalesAged16to74LowerSupervisoryAndTechnicalOccupations + ", femalesAged16to74SemiRoutineOccupations " + femalesAged16to74SemiRoutineOccupations + ", femalesAged16to74RoutineOccupations " + femalesAged16to74RoutineOccupations + ", femalesAged16to74NeverWorked " + femalesAged16to74NeverWorked + ", femalesAged16to74LongTermUnemployed " + femalesAged16to74LongTermUnemployed + ", femalesAged16to74FullTimeStudents " + femalesAged16to74FullTimeStudents;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + femalesAged16to74 + "," + femalesAged16to74LargeEmployersAndHigherManagerialOccupations + "," + femalesAged16to74HigherProfessionalOccupations + "," + femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate + "," + femalesAged16to74IntermediateOccupations + "," + femalesAged16to74SmallEmployersAndOwnAccountWorkers + "," + femalesAged16to74LowerSupervisoryAndTechnicalOccupations + "," + femalesAged16to74SemiRoutineOccupations + "," + femalesAged16to74RoutineOccupations + "," + femalesAged16to74NeverWorked + "," + femalesAged16to74LongTermUnemployed + "," + femalesAged16to74FullTimeStudents;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        return super.toCSVStringFields() + ",femalesAged16to74" + ",femalesAged16to74LargeEmployersAndHigherManagerialOccupations" + ",femalesAged16to74HigherProfessionalOccupations" + ",femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate" + ",femalesAged16to74IntermediateOccupations" + ",femalesAged16to74SmallEmployersAndOwnAccountWorkers" + ",femalesAged16to74LowerSupervisoryAndTechnicalOccupations" + ",femalesAged16to74SemiRoutineOccupations" + ",femalesAged16to74RoutineOccupations" + ",femalesAged16to74NeverWorked" + ",femalesAged16to74LongTermUnemployed" + ",femalesAged16to74FullTimeStudents";
    }

    /**
     * Returns a copy of this.femalesAged16to74
     * @return 
     */
    public int getFemalesAged16to74() {
        return this.femalesAged16to74;
    }

    /**
     * Returns a copy of
     * this.femalesAged16to74LargeEmployersAndHigherManagerialOccupations
     * @return 
     */
    public int getFemalesAged16to74LargeEmployersAndHigherManagerialOccupations() {
        return this.femalesAged16to74LargeEmployersAndHigherManagerialOccupations;
    }

    /**
     * Returns a copy of this.femalesAged16to74HigherProfessionalOccupations
     * @return 
     */
    public int getFemalesAged16to74HigherProfessionalOccupations() {
        return this.femalesAged16to74HigherProfessionalOccupations;
    }

    /**
     * Returns a copy of this.
     * femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate
     * @return 
     */
    public int getFemalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate() {
        return this.femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate;
    }

    /**
     * Returns a copy of this.femalesAged16to74IntermediateOccupations
     * @return 
     */
    public int getFemalesAged16to74IntermediateOccupations() {
        return this.femalesAged16to74IntermediateOccupations;
    }

    /**
     * Returns a copy of
     * this.femalesAged16to74SmallEmployersAndOwnAccountWorkers
     * @return 
     */
    public int getFemalesAged16to74SmallEmployersAndOwnAccountWorkers() {
        return this.femalesAged16to74SmallEmployersAndOwnAccountWorkers;
    }

    /**
     * Returns a copy of
     * this.femalesAged16to74LowerSupervisoryAndTechnicalOccupations
     * @return 
     */
    public int getFemalesAged16to74LowerSupervisoryAndTechnicalOccupations() {
        return this.femalesAged16to74LowerSupervisoryAndTechnicalOccupations;
    }

    /**
     * Returns a copy of this.femalesAged16to74SemiRoutineOccupations
     * @return 
     */
    public int getFemalesAged16to74SemiRoutineOccupations() {
        return this.femalesAged16to74SemiRoutineOccupations;
    }

    /**
     * Returns a copy of this.femalesAged16to74RoutineOccupations
     * @return 
     */
    public int getFemalesAged16to74RoutineOccupations() {
        return this.femalesAged16to74RoutineOccupations;
    }

    /**
     * Returns a copy of this.femalesAged16to74NeverWorked
     * @return 
     */
    public int getFemalesAged16to74NeverWorked() {
        return this.femalesAged16to74NeverWorked;
    }

    /**
     * Returns a copy of this.femalesAged16to74LongTermUnemployed
     * @return 
     */
    public int getFemalesAged16to74LongTermUnemployed() {
        return this.femalesAged16to74LongTermUnemployed;
    }

    /**
     * Returns a copy of this.femalesAged16to74FullTimeStudents
     * @return 
     */
    public int getFemalesAged16to74FullTimeStudents() {
        return this.femalesAged16to74FullTimeStudents;
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
        write(aRandomAccessFile, true);
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
            try {
                aRandomAccessFile.writeInt(femalesAged16to74);
                aRandomAccessFile.writeInt(femalesAged16to74LargeEmployersAndHigherManagerialOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74HigherProfessionalOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate);
                aRandomAccessFile.writeInt(femalesAged16to74IntermediateOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74SmallEmployersAndOwnAccountWorkers);
                aRandomAccessFile.writeInt(femalesAged16to74LowerSupervisoryAndTechnicalOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74SemiRoutineOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74RoutineOccupations);
                aRandomAccessFile.writeInt(femalesAged16to74NeverWorked);
                aRandomAccessFile.writeInt(femalesAged16to74LongTermUnemployed);
                aRandomAccessFile.writeInt(femalesAged16to74FullTimeStudents);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>CASKS14cDataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CASKS14cDataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS14cDataRecord
     *            The <code>CASKS14cDataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public CASKS14cDataRecord aggregate(CASKS14cDataRecord aCASKS14cDataRecord) {
        CASKS14cDataRecord newCASKS14cDataRecord = new CASKS14cDataRecord(
                aCASKS14cDataRecord);
        newCASKS14cDataRecord.femalesAged16to74 += getFemalesAged16to74();
        newCASKS14cDataRecord.femalesAged16to74LargeEmployersAndHigherManagerialOccupations += getFemalesAged16to74LargeEmployersAndHigherManagerialOccupations();
        newCASKS14cDataRecord.femalesAged16to74HigherProfessionalOccupations += getFemalesAged16to74HigherProfessionalOccupations();
        newCASKS14cDataRecord.femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate += getFemalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate();
        newCASKS14cDataRecord.femalesAged16to74IntermediateOccupations += getFemalesAged16to74IntermediateOccupations();
        newCASKS14cDataRecord.femalesAged16to74SmallEmployersAndOwnAccountWorkers += getFemalesAged16to74SmallEmployersAndOwnAccountWorkers();
        newCASKS14cDataRecord.femalesAged16to74LowerSupervisoryAndTechnicalOccupations += getFemalesAged16to74LowerSupervisoryAndTechnicalOccupations();
        newCASKS14cDataRecord.femalesAged16to74SemiRoutineOccupations += getFemalesAged16to74SemiRoutineOccupations();
        newCASKS14cDataRecord.femalesAged16to74RoutineOccupations += getFemalesAged16to74RoutineOccupations();
        newCASKS14cDataRecord.femalesAged16to74NeverWorked += getFemalesAged16to74NeverWorked();
        newCASKS14cDataRecord.femalesAged16to74LongTermUnemployed += getFemalesAged16to74LongTermUnemployed();
        newCASKS14cDataRecord.femalesAged16to74FullTimeStudents += getFemalesAged16to74FullTimeStudents();
        return newCASKS14cDataRecord;
    }

    /**
     * @return An aggregated <code>CASKS14cDataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS14cDataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS14cDataRecord
     *            The <code>CASKS14cDataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public CASKS14cDataRecord aggregate(CASKS14cDataRecord aCASKS14cDataRecord,
            long newRecordID, char[] newZone_Code) {
        CASKS14cDataRecord newCASKS14cDataRecord = new CASKS14cDataRecord(this);
        newCASKS14cDataRecord._RecordID = newRecordID;
        // newCASKS14cDataRecord.Zone_Code = aCASKS14cDataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS14cDataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS14cDataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS14cDataRecord.femalesAged16to74 += getFemalesAged16to74();
        newCASKS14cDataRecord.femalesAged16to74LargeEmployersAndHigherManagerialOccupations += getFemalesAged16to74LargeEmployersAndHigherManagerialOccupations();
        newCASKS14cDataRecord.femalesAged16to74HigherProfessionalOccupations += getFemalesAged16to74HigherProfessionalOccupations();
        newCASKS14cDataRecord.femalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate += getFemalesAged16to74LowerManagerialAndProfessionalOccupationsIntermediate();
        newCASKS14cDataRecord.femalesAged16to74IntermediateOccupations += getFemalesAged16to74IntermediateOccupations();
        newCASKS14cDataRecord.femalesAged16to74SmallEmployersAndOwnAccountWorkers += getFemalesAged16to74SmallEmployersAndOwnAccountWorkers();
        newCASKS14cDataRecord.femalesAged16to74LowerSupervisoryAndTechnicalOccupations += getFemalesAged16to74LowerSupervisoryAndTechnicalOccupations();
        newCASKS14cDataRecord.femalesAged16to74SemiRoutineOccupations += getFemalesAged16to74SemiRoutineOccupations();
        newCASKS14cDataRecord.femalesAged16to74RoutineOccupations += getFemalesAged16to74RoutineOccupations();
        newCASKS14cDataRecord.femalesAged16to74NeverWorked += getFemalesAged16to74NeverWorked();
        newCASKS14cDataRecord.femalesAged16to74LongTermUnemployed += getFemalesAged16to74LongTermUnemployed();
        newCASKS14cDataRecord.femalesAged16to74FullTimeStudents += getFemalesAged16to74FullTimeStudents();
        return newCASKS14cDataRecord;
    }

    /**
     * Returns the size of this CASKS14cRecord in bytes as a long. This does not
     * account for serialVersionUID. A boolean is assumed to be the same size as
     * an int in bytes.
     * @return 
     */
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (12L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}
