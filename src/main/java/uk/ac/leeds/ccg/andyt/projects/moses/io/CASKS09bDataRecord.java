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
 * For representing CAS KS09b Records and providing safe access to the data.
 */
public class CASKS09bDataRecord extends AbstractCASDataRecord {

    /*
     * Table KS009b Economic activity - males: All males aged 16-74 Footnotes
     * and Comments for Table KS009c 1. For the Census, part-time is defined as
     * working 30 hours or less a week. Full-time is defined as working 31 or
     * more hours a week. 2. 'Long-term unemployed' are those who stated that
     * they have not worked since 1999 or earlier.
     */
    /**
     * KS009b0001 = malesAged16to74
     */
    protected int malesAged16to74;
    /**
     * KS009b0002 = malesAged16to74EconomicallyActiveEmployeesPartTime
     */
    protected int malesAged16to74EconomicallyActiveEmployeesPartTime;
    /**
     * KS009b0003 = malesAged16to74EconomicallyActiveEmployeesFullTime
     */
    protected int malesAged16to74EconomicallyActiveEmployeesFullTime;
    /**
     * KS009b0004 = malesAged16to74EconomicallyActiveSelfEmployed
     */
    protected int malesAged16to74EconomicallyActiveSelfEmployed;
    /**
     * KS009b0005 = malesAged16to74EconomicallyActiveUnemployed
     */
    protected int malesAged16to74EconomicallyActiveUnemployed;
    /**
     * KS009b0006 = malesAged16to74EconomicallyActiveFullTimeStudent
     */
    protected int malesAged16to74EconomicallyActiveFullTimeStudent;
    /**
     * KS009b0007 = malesAged16to74EconomicallyInactiveRetired
     */
    protected int malesAged16to74EconomicallyInactiveRetired;
    /**
     * KS009b009b = malesAged16to74EconomicallyInactiveStudent
     */
    protected int malesAged16to74EconomicallyInactiveStudent;
    /**
     * KS009b0009 = malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily
     */
    protected int malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily;
    /**
     * KS009b0010 = malesAged16to74EconomicallyInactivePermanentlySickOrDisabled
     */
    protected int malesAged16to74EconomicallyInactivePermanentlySickOrDisabled;
    /**
     * KS009b0011 = malesAged16to74EconomicallyInactiveOther
     */
    protected int malesAged16to74EconomicallyInactiveOther;
    /**
     * KS009b0012 = malesAged16to24Unemployed
     */
    protected int malesAged16to24Unemployed;
    /**
     * KS009b0013 = malesAged50AndOverUnemployed
     */
    protected int malesAged50AndOverUnemployed;
    /**
     * KS009b0014 = malesAged16to74UnemployedWhoHaveNeverWorked
     */
    protected int malesAged16to74UnemployedWhoHaveNeverWorked;
    /**
     * KS009b0015 = malesAged16to74WhoAreLongTermUnemployed
     */
    protected int malesAged16to74WhoAreLongTermUnemployed;

    /** Creates a new CASKS09bRecord */
    public CASKS09bDataRecord() {
        _Init();
    }

    /**
     * Creates a new CASKS09bRecord
     *
     * @param initZero
     *            To ensure initZero() is used instead of _Init()
     */
    public CASKS09bDataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new CASKS09bRecord cloned from cASKS09bRecord
     *
     * @param cASKS09bRecord
     *            The CASKS09bRecord from which this is cloned.
     */
    public CASKS09bDataRecord(CASKS09bDataRecord cASKS09bRecord) {
        init(cASKS09bRecord);
    }

    /**
     * Creates a new CASKS09bDataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public CASKS09bDataRecord(long RecordID, String line) throws IOException {
        String[] fieldsDummy = line.split(",");
        // System.out.println(fieldsDummy.length);
        // for (int i = 0; i < fieldsDummy.length; i ++ ){
        // System.out.println(fieldsDummy[i]);
        // }
        String[] fields = new String[15];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = "";
        }
        System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
        this._RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table KS09b
        this.malesAged16to74 = StaticConverter.to_int(fields[1]);
        this.malesAged16to74EconomicallyActiveEmployeesPartTime = StaticConverter.to_int(fields[2]);
        this.malesAged16to74EconomicallyActiveEmployeesFullTime = StaticConverter.to_int(fields[3]);
        this.malesAged16to74EconomicallyActiveSelfEmployed = StaticConverter.to_int(fields[4]);
        this.malesAged16to74EconomicallyActiveUnemployed = StaticConverter.to_int(fields[5]);
        this.malesAged16to74EconomicallyInactiveRetired = StaticConverter.to_int(fields[6]);
        this.malesAged16to74EconomicallyActiveFullTimeStudent = StaticConverter.to_int(fields[7]);
        this.malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily = StaticConverter.to_int(fields[8]);
        this.malesAged16to74EconomicallyInactivePermanentlySickOrDisabled = StaticConverter.to_int(fields[9]);
        this.malesAged16to74EconomicallyInactiveOther = StaticConverter.to_int(fields[10]);
        this.malesAged16to24Unemployed = StaticConverter.to_int(fields[11]);
        this.malesAged50AndOverUnemployed = StaticConverter.to_int(fields[12]);
        this.malesAged16to74UnemployedWhoHaveNeverWorked = StaticConverter.to_int(fields[13]);
        this.malesAged16to74WhoAreLongTermUnemployed = StaticConverter.to_int(fields[14]);
    }

    /**
     * Creates a new CASKS09bRecord
     *
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public CASKS09bDataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.malesAged16to74 = aRandomAccessFile.readInt();
            this.malesAged16to74EconomicallyActiveEmployeesPartTime = aRandomAccessFile.readInt();
            this.malesAged16to74EconomicallyActiveEmployeesFullTime = aRandomAccessFile.readInt();
            this.malesAged16to74EconomicallyActiveSelfEmployed = aRandomAccessFile.readInt();
            this.malesAged16to74EconomicallyActiveUnemployed = aRandomAccessFile.readInt();
            this.malesAged16to74EconomicallyActiveFullTimeStudent = aRandomAccessFile.readInt();
            this.malesAged16to74EconomicallyInactiveRetired = aRandomAccessFile.readInt();
            this.malesAged16to74EconomicallyInactiveStudent = aRandomAccessFile.readInt();
            this.malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily = aRandomAccessFile.readInt();
            this.malesAged16to74EconomicallyInactivePermanentlySickOrDisabled = aRandomAccessFile.readInt();
            this.malesAged16to74EconomicallyInactiveOther = aRandomAccessFile.readInt();
            this.malesAged16to24Unemployed = aRandomAccessFile.readInt();
            this.malesAged50AndOverUnemployed = aRandomAccessFile.readInt();
            this.malesAged16to74UnemployedWhoHaveNeverWorked = aRandomAccessFile.readInt();
            this.malesAged16to74WhoAreLongTermUnemployed = aRandomAccessFile.readInt();
        } catch (IOException ioe0) {
            // ioe0.printStackTrace();
            throw ioe0;
        }
    }

    /**
     * Initialises all fields.
     */
    protected void _Init() {
        super._Init();
        this.malesAged16to74 = Integer.MIN_VALUE;
        this.malesAged16to74EconomicallyActiveEmployeesPartTime = Integer.MIN_VALUE;
        this.malesAged16to74EconomicallyActiveEmployeesFullTime = Integer.MIN_VALUE;
        this.malesAged16to74EconomicallyActiveSelfEmployed = Integer.MIN_VALUE;
        this.malesAged16to74EconomicallyActiveUnemployed = Integer.MIN_VALUE;
        this.malesAged16to74EconomicallyActiveFullTimeStudent = Integer.MIN_VALUE;
        this.malesAged16to74EconomicallyInactiveRetired = Integer.MIN_VALUE;
        this.malesAged16to74EconomicallyInactiveStudent = Integer.MIN_VALUE;
        this.malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily = Integer.MIN_VALUE;
        this.malesAged16to74EconomicallyInactivePermanentlySickOrDisabled = Integer.MIN_VALUE;
        this.malesAged16to74EconomicallyInactiveOther = Integer.MIN_VALUE;
        this.malesAged16to24Unemployed = Integer.MIN_VALUE;
        this.malesAged50AndOverUnemployed = Integer.MIN_VALUE;
        this.malesAged16to74UnemployedWhoHaveNeverWorked = Integer.MIN_VALUE;
        this.malesAged16to74WhoAreLongTermUnemployed = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields.
     */
    protected void initZero() {
        super._Init();
        this.malesAged16to74 = 0;
        this.malesAged16to74EconomicallyActiveEmployeesPartTime = 0;
        this.malesAged16to74EconomicallyActiveEmployeesFullTime = 0;
        this.malesAged16to74EconomicallyActiveSelfEmployed = 0;
        this.malesAged16to74EconomicallyActiveUnemployed = 0;
        this.malesAged16to74EconomicallyActiveFullTimeStudent = 0;
        this.malesAged16to74EconomicallyInactiveRetired = 0;
        this.malesAged16to74EconomicallyInactiveStudent = 0;
        this.malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily = 0;
        this.malesAged16to74EconomicallyInactivePermanentlySickOrDisabled = 0;
        this.malesAged16to74EconomicallyInactiveOther = 0;
        this.malesAged16to24Unemployed = 0;
        this.malesAged50AndOverUnemployed = 0;
        this.malesAged16to74UnemployedWhoHaveNeverWorked = 0;
        this.malesAged16to74WhoAreLongTermUnemployed = 0;
    }

    /**
     * Initialises all fields from those in cASKS09bRecord.
     *
     * @param cASKS09bRecord
     *            The CASKS09bRecord thats fields are used to initialise this.
     */
    protected void init(CASKS09bDataRecord cASKS09bRecord) {
        super.init(cASKS09bRecord);
        this.malesAged16to74 = cASKS09bRecord.malesAged16to74;
        this.malesAged16to74EconomicallyActiveEmployeesPartTime = cASKS09bRecord.malesAged16to74EconomicallyActiveEmployeesPartTime;
        this.malesAged16to74EconomicallyActiveEmployeesFullTime = cASKS09bRecord.malesAged16to74EconomicallyActiveEmployeesFullTime;
        this.malesAged16to74EconomicallyActiveSelfEmployed = cASKS09bRecord.malesAged16to74EconomicallyActiveSelfEmployed;
        this.malesAged16to74EconomicallyActiveUnemployed = cASKS09bRecord.malesAged16to74EconomicallyActiveUnemployed;
        this.malesAged16to74EconomicallyActiveFullTimeStudent = cASKS09bRecord.malesAged16to74EconomicallyActiveFullTimeStudent;
        this.malesAged16to74EconomicallyInactiveRetired = cASKS09bRecord.malesAged16to74EconomicallyInactiveRetired;
        this.malesAged16to74EconomicallyInactiveStudent = cASKS09bRecord.malesAged16to74EconomicallyInactiveStudent;
        this.malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily = cASKS09bRecord.malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily;
        this.malesAged16to74EconomicallyInactivePermanentlySickOrDisabled = cASKS09bRecord.malesAged16to74EconomicallyInactivePermanentlySickOrDisabled;
        this.malesAged16to74EconomicallyInactiveOther = cASKS09bRecord.malesAged16to74EconomicallyInactiveOther;
        this.malesAged16to24Unemployed = cASKS09bRecord.malesAged16to24Unemployed;
        this.malesAged50AndOverUnemployed = cASKS09bRecord.malesAged50AndOverUnemployed;
        this.malesAged16to74UnemployedWhoHaveNeverWorked = cASKS09bRecord.malesAged16to74UnemployedWhoHaveNeverWorked;
        this.malesAged16to74WhoAreLongTermUnemployed = cASKS09bRecord.malesAged16to74WhoAreLongTermUnemployed;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", malesAged16to74 " + malesAged16to74 + ", malesAged16to74EconomicallyActiveEmployeesPartTime " + malesAged16to74EconomicallyActiveEmployeesPartTime + ", malesAged16to74EconomicallyActiveEmployeesFullTime " + malesAged16to74EconomicallyActiveEmployeesFullTime + ", malesAged16to74EconomicallyActiveSelfEmployed " + malesAged16to74EconomicallyActiveSelfEmployed + ", malesAged16to74EconomicallyActiveUnemployed " + malesAged16to74EconomicallyActiveUnemployed + ", malesAged16to74EconomicallyInactiveRetired " + malesAged16to74EconomicallyInactiveRetired + ", malesAged16to74EconomicallyActiveFullTimeStudent" + malesAged16to74EconomicallyActiveFullTimeStudent + ", malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily " + malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily + ", malesAged16to74EconomicallyInactivePermanentlySickOrDisabled " + malesAged16to74EconomicallyInactivePermanentlySickOrDisabled + ", malesAged16to74EconomicallyInactiveOther " + malesAged16to74EconomicallyInactiveOther + ", malesAged16to24Unemployed " + malesAged16to24Unemployed + ", malesAged50AndOverUnemployed " + malesAged50AndOverUnemployed + ", malesAged16to74UnemployedWhoHaveNeverWorked " + malesAged16to74UnemployedWhoHaveNeverWorked + ", malesAged16to74WhoAreLongTermUnemployed " + malesAged16to74WhoAreLongTermUnemployed;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + malesAged16to74 + "," + malesAged16to74EconomicallyActiveEmployeesPartTime + "," + malesAged16to74EconomicallyActiveEmployeesFullTime + "," + malesAged16to74EconomicallyActiveSelfEmployed + "," + malesAged16to74EconomicallyActiveUnemployed + "," + malesAged16to74EconomicallyInactiveRetired + "," + malesAged16to74EconomicallyActiveFullTimeStudent + "," + malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily + "," + malesAged16to74EconomicallyInactivePermanentlySickOrDisabled + "," + malesAged16to74EconomicallyInactiveOther + "," + malesAged16to24Unemployed + "," + malesAged50AndOverUnemployed + "," + malesAged16to74UnemployedWhoHaveNeverWorked + "," + malesAged16to74WhoAreLongTermUnemployed;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        return super.toCSVStringFields() + ",malesAged16to74" + ",malesAged16to74EconomicallyActiveEmployeesPartTime" + ",malesAged16to74EconomicallyActiveEmployeesFullTime" + ",malesAged16to74EconomicallyActiveSelfEmployed" + ",malesAged16to74EconomicallyActiveUnemployed" + ",malesAged16to74EconomicallyInactiveRetired" + ",malesAged16to74EconomicallyActiveFullTimeStudent" + ",malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily" + ",malesAged16to74EconomicallyInactivePermanentlySickOrDisabled" + ",malesAged16to74EconomicallyInactiveOther" + ",malesAged16to24Unemployed" + ",malesAged50AndOverUnemployed" + ",malesAged16to74UnemployedWhoHaveNeverWorked" + ",malesAged16to74WhoAreLongTermUnemployed";
    }

    /**
     * Returns a copy of this.malesAged16to74
     * @return 
     */
    public int getMalesAged16to74() {
        return this.malesAged16to74;
    }

    /**
     * Returns a copy of this.malesAged16to74EconomicallyActiveEmployeesPartTime
     * @return 
     */
    public int getMalesAged16to74EconomicallyActiveEmployeesPartTime() {
        return this.malesAged16to74EconomicallyActiveEmployeesPartTime;
    }

    /**
     * Returns a copy of this.malesAged16to74EconomicallyActiveEmployeesFullTime
     * @return 
     */
    public int getMalesAged16to74EconomicallyActiveEmployeesFullTime() {
        return this.malesAged16to74EconomicallyActiveEmployeesFullTime;
    }

    /**
     * Returns a copy of this.malesAged16to74EconomicallyActiveSelfEmployed
     * @return 
     */
    public int getMalesAged16to74EconomicallyActiveSelfEmployed() {
        return this.malesAged16to74EconomicallyActiveSelfEmployed;
    }

    /**
     * Returns a copy of this.malesAged16to74EconomicallyActiveUnemployed
     * @return 
     */
    public int getMalesAged16to74EconomicallyActiveUnemployed() {
        return this.malesAged16to74EconomicallyActiveUnemployed;
    }

    /**
     * Returns a copy of this.malesAged16to74EconomicallyInactiveRetired
     * @return 
     */
    public int getMalesAged16to74EconomicallyInactiveRetired() {
        return this.malesAged16to74EconomicallyInactiveRetired;
    }

    /**
     * Returns a copy of this.malesAged16to74EconomicallyActiveFullTimeStudent
     * @return 
     */
    public int getMalesAged16to74EconomicallyActiveFullTimeStudent() {
        return this.malesAged16to74EconomicallyActiveFullTimeStudent;
    }

    /**
     * Returns a copy of
     * this.malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily
     * @return 
     */
    public int getMalesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily() {
        return this.malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily;
    }

    /**
     * Returns a copy of
     * this.malesAged16to74EconomicallyInactivePermanentlySickOrDisabled
     * @return 
     */
    public int getMalesAged16to74EconomicallyInactivePermanentlySickOrDisabled() {
        return this.malesAged16to74EconomicallyInactivePermanentlySickOrDisabled;
    }

    /**
     * Returns a copy of this.malesAged16to74EconomicallyInactiveOther
     * @return 
     */
    public int getMalesAged16to74EconomicallyInactiveOther() {
        return this.malesAged16to74EconomicallyInactiveOther;
    }

    /**
     * Returns a copy of this.malesAged16to24Unemployed
     * @return 
     */
    public int getMalesAged16to24Unemployed() {
        return this.malesAged16to24Unemployed;
    }

    /**
     * Returns a copy of this.malesAged50AndOverUnemployed
     * @return 
     */
    public int getMalesAged50AndOverUnemployed() {
        return this.malesAged50AndOverUnemployed;
    }

    /**
     * Returns a copy of this.malesAged16to74UnemployedWhoHaveNeverWorked
     * @return 
     */
    public int getMalesAged16to74UnemployedWhoHaveNeverWorked() {
        return this.malesAged16to74UnemployedWhoHaveNeverWorked;
    }

    /**
     * Returns a copy of this.malesAged16to74WhoAreLongTermUnemployed
     * @return 
     */
    public int getMalesAged16to74WhoAreLongTermUnemployed() {
        return this.malesAged16to74WhoAreLongTermUnemployed;
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
                aRandomAccessFile.writeInt(malesAged16to74);
                aRandomAccessFile.writeInt(malesAged16to74EconomicallyActiveEmployeesPartTime);
                aRandomAccessFile.writeInt(malesAged16to74EconomicallyActiveEmployeesFullTime);
                aRandomAccessFile.writeInt(malesAged16to74EconomicallyActiveSelfEmployed);
                aRandomAccessFile.writeInt(malesAged16to74EconomicallyActiveUnemployed);
                aRandomAccessFile.writeInt(malesAged16to74EconomicallyActiveFullTimeStudent);
                aRandomAccessFile.writeInt(malesAged16to74EconomicallyInactiveRetired);
                aRandomAccessFile.writeInt(malesAged16to74EconomicallyInactiveStudent);
                aRandomAccessFile.writeInt(malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily);
                aRandomAccessFile.writeInt(malesAged16to74EconomicallyInactivePermanentlySickOrDisabled);
                aRandomAccessFile.writeInt(malesAged16to74EconomicallyInactiveOther);
                aRandomAccessFile.writeInt(malesAged16to24Unemployed);
                aRandomAccessFile.writeInt(malesAged50AndOverUnemployed);
                aRandomAccessFile.writeInt(malesAged16to74UnemployedWhoHaveNeverWorked);
                aRandomAccessFile.writeInt(malesAged16to74WhoAreLongTermUnemployed);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * User needs to take care in aggregating to ensure aggregation does not
     * compromise (introduce error) based on the numbers used.
     * @param aCASKS09bDataRecord
     * @return 
     */
    public CASKS09bDataRecord aggregate(CASKS09bDataRecord aCASKS09bDataRecord) {
        CASKS09bDataRecord newCASKS09bDataRecord = new CASKS09bDataRecord(
                aCASKS09bDataRecord);
        newCASKS09bDataRecord.malesAged16to74 += getMalesAged16to74();
        newCASKS09bDataRecord.malesAged16to74EconomicallyActiveEmployeesPartTime += getMalesAged16to74EconomicallyActiveEmployeesPartTime();
        newCASKS09bDataRecord.malesAged16to74EconomicallyActiveEmployeesFullTime += getMalesAged16to74EconomicallyActiveEmployeesFullTime();
        newCASKS09bDataRecord.malesAged16to74EconomicallyActiveSelfEmployed += getMalesAged16to74EconomicallyActiveSelfEmployed();
        newCASKS09bDataRecord.malesAged16to74EconomicallyActiveUnemployed += getMalesAged16to74EconomicallyActiveUnemployed();
        newCASKS09bDataRecord.malesAged16to74EconomicallyInactiveRetired += getMalesAged16to74EconomicallyInactiveRetired();
        newCASKS09bDataRecord.malesAged16to74EconomicallyActiveFullTimeStudent += getMalesAged16to74EconomicallyActiveFullTimeStudent();
        newCASKS09bDataRecord.malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily += getMalesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily();
        newCASKS09bDataRecord.malesAged16to74EconomicallyInactivePermanentlySickOrDisabled += getMalesAged16to74EconomicallyInactivePermanentlySickOrDisabled();
        newCASKS09bDataRecord.malesAged16to74EconomicallyInactiveOther += getMalesAged16to74EconomicallyInactiveOther();
        newCASKS09bDataRecord.malesAged16to24Unemployed += getMalesAged16to24Unemployed();
        newCASKS09bDataRecord.malesAged50AndOverUnemployed += getMalesAged50AndOverUnemployed();
        newCASKS09bDataRecord.malesAged16to74UnemployedWhoHaveNeverWorked += getMalesAged16to74UnemployedWhoHaveNeverWorked();
        newCASKS09bDataRecord.malesAged16to74WhoAreLongTermUnemployed += getMalesAged16to74WhoAreLongTermUnemployed();
        return newCASKS09bDataRecord;
    }

    /**
     * User needs to take care in aggregating to ensure aggregation does not
     * compromise (introduce error) based on the numbers used.
     * @param newZone_Code
     * @param newRecordID
     * @return 
     */
    public CASKS09bDataRecord aggregate(
            CASKS09bDataRecord aCASKS09bDataRecord,
            long newRecordID,
            char[] newZone_Code) {
        CASKS09bDataRecord newCASKS09bDataRecord = new CASKS09bDataRecord(this);
        newCASKS09bDataRecord._RecordID = newRecordID;
        // newCASKS09bDataRecord.Zone_Code = aCASKS09bDataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS09bDataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS09bDataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS09bDataRecord.malesAged16to74 += getMalesAged16to74();
        newCASKS09bDataRecord.malesAged16to74EconomicallyActiveEmployeesPartTime += getMalesAged16to74EconomicallyActiveEmployeesPartTime();
        newCASKS09bDataRecord.malesAged16to74EconomicallyActiveEmployeesFullTime += getMalesAged16to74EconomicallyActiveEmployeesFullTime();
        newCASKS09bDataRecord.malesAged16to74EconomicallyActiveSelfEmployed += getMalesAged16to74EconomicallyActiveSelfEmployed();
        newCASKS09bDataRecord.malesAged16to74EconomicallyActiveUnemployed += getMalesAged16to74EconomicallyActiveUnemployed();
        newCASKS09bDataRecord.malesAged16to74EconomicallyInactiveRetired += getMalesAged16to74EconomicallyInactiveRetired();
        newCASKS09bDataRecord.malesAged16to74EconomicallyActiveFullTimeStudent += getMalesAged16to74EconomicallyActiveFullTimeStudent();
        newCASKS09bDataRecord.malesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily += getMalesAged16to74EconomicallyInactiveLookingAfterHomeOrFamily();
        newCASKS09bDataRecord.malesAged16to74EconomicallyInactivePermanentlySickOrDisabled += getMalesAged16to74EconomicallyInactivePermanentlySickOrDisabled();
        newCASKS09bDataRecord.malesAged16to74EconomicallyInactiveOther += getMalesAged16to74EconomicallyInactiveOther();
        newCASKS09bDataRecord.malesAged16to24Unemployed += getMalesAged16to24Unemployed();
        newCASKS09bDataRecord.malesAged50AndOverUnemployed += getMalesAged50AndOverUnemployed();
        newCASKS09bDataRecord.malesAged16to74UnemployedWhoHaveNeverWorked += getMalesAged16to74UnemployedWhoHaveNeverWorked();
        newCASKS09bDataRecord.malesAged16to74WhoAreLongTermUnemployed += getMalesAged16to74WhoAreLongTermUnemployed();
        return newCASKS09bDataRecord;
    }

    /**
     * Returns the size of this CASKS09bRecord in bytes as a long. This does not
     * account for serialVersionUID. A boolean is assumed to be the same size as
     * an int in bytes.
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (15L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}
