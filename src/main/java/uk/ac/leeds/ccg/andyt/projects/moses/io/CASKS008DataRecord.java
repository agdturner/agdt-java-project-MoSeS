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
 * For representing CAS KS008 Records and providing safe access to the data.
 */
public class CASKS008DataRecord extends AbstractCASDataRecord {

    /**
     * Table KS0008 National Statistics - Socio Economic Classification -
     * females aged 16-74 Footnotes and Comments for Table KS0008 1. Limiting
     * long-term illness covers any long-term illness, health problem or
     * disability which limits daily activities or work. 2. Working age
     * population is 16 to 64 years inclusive for men and 16 to 59 years
     * inclusive for women. 3. General health refers to health over the 12
     * months prior to Census day (29 April 2001). 4. Provision of unpaid care:
     * looking after, giving help or support to family members, friends,
     * neighbours or others because of long-term physical or mental ill-health
     * or disability or problems relating to old age.
     */
    /**
     * KS00080001 = allPeople
     */
    protected int allPeople;
    /**
     * KS00080002 = peopleWithLimitingLongTermIllness
     */
    protected int peopleWithLimitingLongTermIllness;
    /**
     * KS00080003 = peopleOfWorkingAgeWithLimitingLongTermIllness
     */
    protected int peopleOfWorkingAgeWithLimitingLongTermIllness;
    /**
     * KS00080004 = peopleWhoseGeneralHealthWasGood
     */
    protected int peopleWhoseGeneralHealthWasGood;
    /**
     * KS00080005 = peopleWhoseGeneralHealthWasFairlyGood
     */
    protected int peopleWhoseGeneralHealthWasFairlyGood;
    /**
     * KS00080006 = peopleWhoseGeneralHealthWasNotGood
     */
    protected int peopleWhoseGeneralHealthWasNotGood;
    /**
     * KS00080007 = peopleWhoProvideUnpaidCare1to19HoursAWeek
     */
    protected int peopleWhoProvideUnpaidCare1to19HoursAWeek;
    /**
     * KS00080008 = peopleWhoProvideUnpaidCare20to49HoursAWeek
     */
    protected int peopleWhoProvideUnpaidCare20to49HoursAWeek;
    /**
     * KS00080009 = peopleWhoProvideUnpaidCare50rMoreHoursAWeek
     */
    protected int peopleWhoProvideUnpaidCare50rMoreHoursAWeek;

    /** Creates a new CASKS008Record */
    public CASKS008DataRecord() {
        _Init();
    }

    /**
     * Creates a new CASKS008Record
     *
     * @param initZero
     *            To ensure initZero() is used instead of _Init()
     */
    public CASKS008DataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new CASKS008DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public CASKS008DataRecord(
            long RecordID,
            String line) throws IOException {
        String[] fieldsDummy = line.split(",");
        // System.out.println(fieldsDummy.length);
        // for (int i = 0; i < fieldsDummy.length; i ++ ){
        // System.out.println(fieldsDummy[i]);
        // }
        String[] fields = new String[10];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = "";
        }
        System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
        this._RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table KS008
        this.allPeople = StaticConverter.to_int(fields[1]);
        this.peopleWithLimitingLongTermIllness = StaticConverter.to_int(fields[2]);
        this.peopleOfWorkingAgeWithLimitingLongTermIllness = StaticConverter.to_int(fields[3]);
        this.peopleWhoseGeneralHealthWasGood = StaticConverter.to_int(fields[4]);
        this.peopleWhoseGeneralHealthWasFairlyGood = StaticConverter.to_int(fields[5]);
        this.peopleWhoseGeneralHealthWasNotGood = StaticConverter.to_int(fields[6]);
        this.peopleWhoProvideUnpaidCare1to19HoursAWeek = StaticConverter.to_int(fields[7]);
        this.peopleWhoProvideUnpaidCare20to49HoursAWeek = StaticConverter.to_int(fields[8]);
        this.peopleWhoProvideUnpaidCare50rMoreHoursAWeek = StaticConverter.to_int(fields[9]);
    }

    /**
     * Creates a new CASKS008Record cloned from aCASKS008DataRecord
     *
     * @param aCASKS008DataRecord
     *            The CASKS008Record from which this is cloned.
     */
    public CASKS008DataRecord(CASKS008DataRecord aCASKS008DataRecord) {
        init(aCASKS008DataRecord);
    }

    /**
     * Creates a new CASKS008Record
     *
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public CASKS008DataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.allPeople = aRandomAccessFile.readInt();
            this.peopleWithLimitingLongTermIllness = aRandomAccessFile.readInt();
            this.peopleOfWorkingAgeWithLimitingLongTermIllness = aRandomAccessFile.readInt();
            this.peopleWhoseGeneralHealthWasGood = aRandomAccessFile.readInt();
            this.peopleWhoseGeneralHealthWasFairlyGood = aRandomAccessFile.readInt();
            this.peopleWhoseGeneralHealthWasNotGood = aRandomAccessFile.readInt();
            this.peopleWhoProvideUnpaidCare1to19HoursAWeek = aRandomAccessFile.readInt();
            this.peopleWhoProvideUnpaidCare20to49HoursAWeek = aRandomAccessFile.readInt();
            this.peopleWhoProvideUnpaidCare50rMoreHoursAWeek = aRandomAccessFile.readInt();
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
        this.allPeople = Integer.MIN_VALUE;
        this.peopleWithLimitingLongTermIllness = Integer.MIN_VALUE;
        this.peopleOfWorkingAgeWithLimitingLongTermIllness = Integer.MIN_VALUE;
        this.peopleWhoseGeneralHealthWasGood = Integer.MIN_VALUE;
        this.peopleWhoseGeneralHealthWasFairlyGood = Integer.MIN_VALUE;
        this.peopleWhoseGeneralHealthWasNotGood = Integer.MIN_VALUE;
        this.peopleWhoProvideUnpaidCare1to19HoursAWeek = Integer.MIN_VALUE;
        this.peopleWhoProvideUnpaidCare20to49HoursAWeek = Integer.MIN_VALUE;
        this.peopleWhoProvideUnpaidCare50rMoreHoursAWeek = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields to zero.
     */
    protected void initZero() {
        super._Init();
        this.allPeople = 0;
        this.peopleWithLimitingLongTermIllness = 0;
        this.peopleOfWorkingAgeWithLimitingLongTermIllness = 0;
        this.peopleWhoseGeneralHealthWasGood = 0;
        this.peopleWhoseGeneralHealthWasFairlyGood = 0;
        this.peopleWhoseGeneralHealthWasNotGood = 0;
        this.peopleWhoProvideUnpaidCare1to19HoursAWeek = 0;
        this.peopleWhoProvideUnpaidCare20to49HoursAWeek = 0;
        this.peopleWhoProvideUnpaidCare50rMoreHoursAWeek = 0;
    }

    /**
     * Initialises all fields from those in aCASKS008DataRecord.
     *
     * @param aCASKS008DataRecord
     *            The CASKS008Record thats fields are used to initialise this.
     */
    protected void init(CASKS008DataRecord aCASKS008DataRecord) {
        super.init(aCASKS008DataRecord);
        this.allPeople = aCASKS008DataRecord.allPeople;
        this.peopleWithLimitingLongTermIllness = aCASKS008DataRecord.peopleWithLimitingLongTermIllness;
        this.peopleOfWorkingAgeWithLimitingLongTermIllness = aCASKS008DataRecord.peopleOfWorkingAgeWithLimitingLongTermIllness;
        this.peopleWhoseGeneralHealthWasGood = aCASKS008DataRecord.peopleWhoseGeneralHealthWasGood;
        this.peopleWhoseGeneralHealthWasFairlyGood = aCASKS008DataRecord.peopleWhoseGeneralHealthWasFairlyGood;
        this.peopleWhoseGeneralHealthWasNotGood = aCASKS008DataRecord.peopleWhoseGeneralHealthWasNotGood;
        this.peopleWhoProvideUnpaidCare1to19HoursAWeek = aCASKS008DataRecord.peopleWhoProvideUnpaidCare1to19HoursAWeek;
        this.peopleWhoProvideUnpaidCare20to49HoursAWeek = aCASKS008DataRecord.peopleWhoProvideUnpaidCare20to49HoursAWeek;
        this.peopleWhoProvideUnpaidCare50rMoreHoursAWeek = aCASKS008DataRecord.peopleWhoProvideUnpaidCare50rMoreHoursAWeek;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", allPeople " + allPeople + ", peopleWithLimitingLongTermIllness " + peopleWithLimitingLongTermIllness + ", peopleOfWorkingAgeWithLimitingLongTermIllness " + peopleOfWorkingAgeWithLimitingLongTermIllness + ", peopleWhoseGeneralHealthWasGood " + peopleWhoseGeneralHealthWasGood + ", peopleWhoseGeneralHealthWasFairlyGood " + peopleWhoseGeneralHealthWasFairlyGood + ", peopleWhoseGeneralHealthWasNotGood " + peopleWhoseGeneralHealthWasNotGood + ", peopleWhoProvideUnpaidCare1to19HoursAWeek" + peopleWhoProvideUnpaidCare1to19HoursAWeek + ", peopleWhoProvideUnpaidCare20to49HoursAWeek " + peopleWhoProvideUnpaidCare20to49HoursAWeek + ", peopleWhoProvideUnpaidCare50rMoreHoursAWeek " + peopleWhoProvideUnpaidCare50rMoreHoursAWeek;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + allPeople + "," + peopleWithLimitingLongTermIllness + "," + peopleOfWorkingAgeWithLimitingLongTermIllness + "," + peopleWhoseGeneralHealthWasGood + "," + peopleWhoseGeneralHealthWasFairlyGood + "," + peopleWhoseGeneralHealthWasNotGood + "," + peopleWhoProvideUnpaidCare1to19HoursAWeek + "," + peopleWhoProvideUnpaidCare20to49HoursAWeek + "," + peopleWhoProvideUnpaidCare50rMoreHoursAWeek;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        return super.toCSVStringFields() + ",allPeople" + ",peopleWithLimitingLongTermIllness" + ",peopleOfWorkingAgeWithLimitingLongTermIllness" + ",peopleWhoseGeneralHealthWasGood" + ",peopleWhoseGeneralHealthWasFairlyGood" + ",peopleWhoseGeneralHealthWasNotGood" + ",peopleWhoProvideUnpaidCare1to19HoursAWeek" + ",peopleWhoProvideUnpaidCare20to49HoursAWeek" + ",peopleWhoProvideUnpaidCare50rMoreHoursAWeek";
    }

    /**
     * Returns a copy of this.allPeople
     * @return 
     */
    public int getAllPeople() {
        return this.allPeople;
    }

    /**
     * Returns a copy of this.peopleWithLimitingLongTermIllness
     * @return 
     */
    public int getPeopleWithLimitingLongTermIllness() {
        return this.peopleWithLimitingLongTermIllness;
    }

    /**
     * Returns a copy of this.peopleOfWorkingAgeWithLimitingLongTermIllness
     * @return 
     */
    public int getPeopleOfWorkingAgeWithLimitingLongTermIllness() {
        return this.peopleOfWorkingAgeWithLimitingLongTermIllness;
    }

    /**
     * Returns a copy of this.peopleWhoseGeneralHealthWasGood
     * @return 
     */
    public int getPeopleWhoseGeneralHealthWasGood() {
        return this.peopleWhoseGeneralHealthWasGood;
    }

    /**
     * Returns a copy of this.peopleWhoseGeneralHealthWasFairlyGood
     * @return 
     */
    public int getPeopleWhoseGeneralHealthWasFairlyGood() {
        return this.peopleWhoseGeneralHealthWasFairlyGood;
    }

    /**
     * Returns a copy of this.peopleWhoseGeneralHealthWasNotGood
     * @return 
     */
    public int getPeopleWhoseGeneralHealthWasNotGood() {
        return this.peopleWhoseGeneralHealthWasNotGood;
    }

    /**
     * Returns a copy of this.peopleWhoProvideUnpaidCare1to19HoursAWeek
     * @return 
     */
    public int getPeopleWhoProvideUnpaidCare1to19HoursAWeek() {
        return this.peopleWhoProvideUnpaidCare1to19HoursAWeek;
    }

    /**
     * Returns a copy of this.peopleWhoProvideUnpaidCare20to49HoursAWeek
     * @return 
     */
    public int getPeopleWhoProvideUnpaidCare20to49HoursAWeek() {
        return this.peopleWhoProvideUnpaidCare20to49HoursAWeek;
    }

    /**
     * Returns a copy of this.peopleWhoProvideUnpaidCare50rMoreHoursAWeek
     * @return 
     */
    public int getPeopleWhoProvideUnpaidCare50rMoreHoursAWeek() {
        return this.peopleWhoProvideUnpaidCare50rMoreHoursAWeek;
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
        write(
                aRandomAccessFile,
                true);
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
    public void write(
            RandomAccessFile aRandomAccessFile,
            boolean avoidCallToSuper) {
        if (avoidCallToSuper) {
            try {
                aRandomAccessFile.writeInt(allPeople);
                aRandomAccessFile.writeInt(peopleWithLimitingLongTermIllness);
                aRandomAccessFile.writeInt(peopleOfWorkingAgeWithLimitingLongTermIllness);
                aRandomAccessFile.writeInt(peopleWhoseGeneralHealthWasGood);
                aRandomAccessFile.writeInt(peopleWhoseGeneralHealthWasFairlyGood);
                aRandomAccessFile.writeInt(peopleWhoseGeneralHealthWasNotGood);
                aRandomAccessFile.writeInt(peopleWhoProvideUnpaidCare1to19HoursAWeek);
                aRandomAccessFile.writeInt(peopleWhoProvideUnpaidCare20to49HoursAWeek);
                aRandomAccessFile.writeInt(peopleWhoProvideUnpaidCare50rMoreHoursAWeek);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>CASKS008DataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CASKS008DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS008DataRecord
     *            The <code>CASKS008DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public CASKS008DataRecord aggregate(CASKS008DataRecord aCASKS008DataRecord) {
        CASKS008DataRecord newCASKS008DataRecord = new CASKS008DataRecord(
                aCASKS008DataRecord);
        newCASKS008DataRecord.allPeople += getAllPeople();
        newCASKS008DataRecord.peopleWithLimitingLongTermIllness += getPeopleWithLimitingLongTermIllness();
        newCASKS008DataRecord.peopleOfWorkingAgeWithLimitingLongTermIllness += getPeopleOfWorkingAgeWithLimitingLongTermIllness();
        newCASKS008DataRecord.peopleWhoseGeneralHealthWasGood += getPeopleWhoseGeneralHealthWasGood();
        newCASKS008DataRecord.peopleWhoseGeneralHealthWasFairlyGood += getPeopleWhoseGeneralHealthWasFairlyGood();
        newCASKS008DataRecord.peopleWhoseGeneralHealthWasNotGood += getPeopleWhoseGeneralHealthWasNotGood();
        newCASKS008DataRecord.peopleWhoProvideUnpaidCare1to19HoursAWeek += getPeopleWhoProvideUnpaidCare1to19HoursAWeek();
        newCASKS008DataRecord.peopleWhoProvideUnpaidCare20to49HoursAWeek += getPeopleWhoProvideUnpaidCare20to49HoursAWeek();
        newCASKS008DataRecord.peopleWhoProvideUnpaidCare50rMoreHoursAWeek += getPeopleWhoProvideUnpaidCare50rMoreHoursAWeek();
        return newCASKS008DataRecord;
    }

    /**
     * @return An aggregated <code>CASKS008DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS008DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS008DataRecord
     *            The <code>CASKS008DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public CASKS008DataRecord aggregate(
            CASKS008DataRecord aCASKS008DataRecord,
            long newRecordID,
            char[] newZone_Code) {
        CASKS008DataRecord newCASKS008DataRecord = new CASKS008DataRecord(this);
        newCASKS008DataRecord._RecordID = newRecordID;
        // newCASKS008DataRecord.Zone_Code = aCASKS008DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS008DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS008DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS008DataRecord.allPeople += aCASKS008DataRecord.getAllPeople();
        newCASKS008DataRecord.peopleWithLimitingLongTermIllness += aCASKS008DataRecord.getPeopleWithLimitingLongTermIllness();
        newCASKS008DataRecord.peopleOfWorkingAgeWithLimitingLongTermIllness += aCASKS008DataRecord.getPeopleOfWorkingAgeWithLimitingLongTermIllness();
        newCASKS008DataRecord.peopleWhoseGeneralHealthWasGood += aCASKS008DataRecord.getPeopleWhoseGeneralHealthWasGood();
        newCASKS008DataRecord.peopleWhoseGeneralHealthWasFairlyGood += aCASKS008DataRecord.getPeopleWhoseGeneralHealthWasFairlyGood();
        newCASKS008DataRecord.peopleWhoseGeneralHealthWasNotGood += aCASKS008DataRecord.getPeopleWhoseGeneralHealthWasNotGood();
        newCASKS008DataRecord.peopleWhoProvideUnpaidCare1to19HoursAWeek += aCASKS008DataRecord.getPeopleWhoProvideUnpaidCare1to19HoursAWeek();
        newCASKS008DataRecord.peopleWhoProvideUnpaidCare20to49HoursAWeek += aCASKS008DataRecord.getPeopleWhoProvideUnpaidCare20to49HoursAWeek();
        newCASKS008DataRecord.peopleWhoProvideUnpaidCare50rMoreHoursAWeek += aCASKS008DataRecord.getPeopleWhoProvideUnpaidCare50rMoreHoursAWeek();
        return newCASKS008DataRecord;
    }

    /**
     * Returns the size of this CASKS008Record in bytes as a long. This does not
     * account for serialVersionUID. A boolean is assumed to be the same size as
     * an int in bytes.
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (9L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}
