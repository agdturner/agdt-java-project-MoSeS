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
import java.io.IOException;
import java.io.RandomAccessFile;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;

/**
 * For representing ToyModelDataRecords and providing safe access to the data.
 */
public class ToyModelDataRecord_1 extends Census_AbstractDataRecord {

    // protected long PID; // this.RecordID
    protected long ISARDataRecordID;
    protected long ID;
    protected int age;
    protected int socialClass;
    protected int gender;
    protected int maritalStatus;
    protected int limitingLongTermIllness;
    protected int healthStatus;
    // protected char[] location; // this.Zone_Code
    protected int householdReferencePerson;
    protected int householdID;
    protected int carer;
    protected int inFormalCare;
    protected int householdContainsDependentChildren;
    protected int numberOfUsualResidents;
    protected int numberOfOver65YearOldsInHousehold;
    protected long fitness;

    /** Creates a new ToyModelDataRecord */
    public ToyModelDataRecord_1() {
        _Init();
    }

    /**
     * Creates a new ToyModelDataRecord cloned from toyModelDataRecord
     *
     * @param toyModelDataRecord
     *            The ToyModelDataRecord from which this is cloned.
     */
    public ToyModelDataRecord_1(ToyModelDataRecord_1 toyModelDataRecord) {
        init(toyModelDataRecord);
    }

    /**
     * Creates a new ToyModelDataRecord from the String line
     * @param tToyModelDataHandler
     * @param line
     */
    public ToyModelDataRecord_1(ToyModelDataHandler tToyModelDataHandler,
            String line) {
        String[] fields = line.split(",");
        _RecordID = Long.valueOf(fields[0]);
        Zone_Code = fields[9].toCharArray();
        ISARDataRecordID = Long.valueOf(fields[1]);
        ID = Long.valueOf(fields[2]);
        age = tToyModelDataHandler.parseInt(fields[3]);
        socialClass = tToyModelDataHandler.parseInt(fields[4]);
        gender = tToyModelDataHandler.parseInt(fields[5]);
        maritalStatus = tToyModelDataHandler.parseInt(fields[6]);
        limitingLongTermIllness = tToyModelDataHandler.parseInt(fields[7]);
        healthStatus = tToyModelDataHandler.parseInt(fields[8]);
        householdReferencePerson = tToyModelDataHandler.parseInt(fields[10]);
        householdID = tToyModelDataHandler.parseInt(fields[11]);
        carer = tToyModelDataHandler.parseInt(fields[12]);
        inFormalCare = tToyModelDataHandler.parseInt(fields[13]);
        householdContainsDependentChildren = tToyModelDataHandler.parseInt(fields[14]);
        numberOfUsualResidents = tToyModelDataHandler.parseInt(fields[15]);
        numberOfOver65YearOldsInHousehold = tToyModelDataHandler.parseInt(fields[16]);
        fitness = tToyModelDataHandler.parseInt(fields[17]);
    }

    /**
     * Creates a new ToyModelDataRecord as read from aRandomAccessFile
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public ToyModelDataRecord_1(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.ID = aRandomAccessFile.readLong();
            this.ISARDataRecordID = aRandomAccessFile.readLong();
            this.age = aRandomAccessFile.readInt();
            this.socialClass = aRandomAccessFile.readInt();
            this.gender = aRandomAccessFile.readInt();
            this.maritalStatus = aRandomAccessFile.readInt();
            this.limitingLongTermIllness = aRandomAccessFile.readInt();
            this.healthStatus = aRandomAccessFile.readInt();
            this.householdReferencePerson = aRandomAccessFile.readInt();
            this.householdID = aRandomAccessFile.readInt();
            this.carer = aRandomAccessFile.readInt();
            this.inFormalCare = aRandomAccessFile.readInt();
            this.householdContainsDependentChildren = aRandomAccessFile.readInt();
            this.numberOfUsualResidents = aRandomAccessFile.readInt();
            this.numberOfOver65YearOldsInHousehold = aRandomAccessFile.readInt();
            this.fitness = aRandomAccessFile.readLong();
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
        this.ISARDataRecordID = Long.MIN_VALUE;
        this.ID = Long.MIN_VALUE;
        this.age = Integer.MIN_VALUE;
        this.socialClass = Integer.MIN_VALUE;
        this.gender = Integer.MIN_VALUE;
        this.maritalStatus = Integer.MIN_VALUE;
        this.limitingLongTermIllness = Integer.MIN_VALUE;
        this.healthStatus = Integer.MIN_VALUE;
        this.householdReferencePerson = Integer.MIN_VALUE;
        this.householdID = Integer.MIN_VALUE;
        this.carer = Integer.MIN_VALUE;
        this.inFormalCare = Integer.MIN_VALUE;
        this.householdContainsDependentChildren = Integer.MIN_VALUE;
        this.numberOfUsualResidents = Integer.MIN_VALUE;
        this.numberOfOver65YearOldsInHousehold = Integer.MIN_VALUE;
        this.fitness = Long.MIN_VALUE;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", ID " + ID + ", ISARDataRecordID " + ISARDataRecordID + ", Age" + age + ", Social Class" + socialClass + ", Gender" + gender + ", Marital Status" + maritalStatus + ", With long term illness" + limitingLongTermIllness + ", Health Status" + healthStatus + ", HRP (Household Reference Person)" + householdReferencePerson + ", Household ID" + householdID + ", Carer" + carer + ", In formal care" + inFormalCare + ", Household contains dependent children" + householdContainsDependentChildren + ", Number of usual residents" + numberOfUsualResidents + ", Number of Over 65 year olds in household" + numberOfOver65YearOldsInHousehold + ", Fitness" + fitness;
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
                false);
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
                aRandomAccessFile.writeLong(ID);
                aRandomAccessFile.writeLong(ISARDataRecordID);
                aRandomAccessFile.writeInt(age);
                aRandomAccessFile.writeInt(socialClass);
                aRandomAccessFile.writeInt(gender);
                aRandomAccessFile.writeInt(maritalStatus);
                aRandomAccessFile.writeInt(limitingLongTermIllness);
                aRandomAccessFile.writeInt(healthStatus);
                aRandomAccessFile.writeInt(householdReferencePerson);
                aRandomAccessFile.writeInt(householdID);
                aRandomAccessFile.writeInt(carer);
                aRandomAccessFile.writeInt(inFormalCare);
                aRandomAccessFile.writeInt(householdContainsDependentChildren);
                aRandomAccessFile.writeInt(numberOfUsualResidents);
                aRandomAccessFile.writeInt(numberOfOver65YearOldsInHousehold);
                aRandomAccessFile.writeLong(fitness);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * Returns the size of this record in bytes.
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += ((3L * (long) Long.SIZE) + (13L * (long) Integer.SIZE)) / getNumberOfBitsInByte();
        return result;
    }
}
