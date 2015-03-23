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

import uk.ac.leeds.ccg.andyt.agdtcensus.cas.AbstractCASDataRecord;
import java.io.IOException;
import java.io.RandomAccessFile;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;

/**
 * For representing ToyModelDataRecords and providing safe access to the data.
 */
public class ToyModelDataRecord extends AbstractCASDataRecord {

    public long tISARDataRecordID;
    public long tHSARDataRecordID;
    public int tPersonID;
    public int tHouseholdID;

    /** Creates a new ToyModelDataRecord */
    public ToyModelDataRecord() {
        _Init();
    }

    /**
     * Creates a new ToyModelDataRecord with fields initialised to zero for
     * aggregating
     * @param initZero
     */
    public ToyModelDataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new ToyModelDataRecord_2 cloned from _ToyModelDataRecord_2
     *
     * @param _ToyModelDataRecord_2
     *            The ToyModelDataRecord_2 from which this is cloned.
     */
    public ToyModelDataRecord(ToyModelDataRecord_2 _ToyModelDataRecord_2) {
        init(_ToyModelDataRecord_2);
        this._RecordID = _ToyModelDataRecord_2._RecordID;
    }

    /**
     * Creates a new ToyModelDataRecord_2 cloned from _ToyModelDataRecord_2
     *
     * @param _ToyModelDataRecord_3
     *            The ToyModelDataRecord_2 from which this is cloned.
     */
    public ToyModelDataRecord(ToyModelDataRecord _ToyModelDataRecord_3) {
        init(_ToyModelDataRecord_3);
        this._RecordID = _ToyModelDataRecord_3._RecordID;
    }

    /**
     * Creates a new ToyModelDataRecord_2 from the String line
     * AREACODE,PERSONID,
     * HOUSEHOLDID,HSARRECORDID,INDIVIDUALSARRECORDID,AGE,SEX,LLTI
     * ,HEALTH,ETHNICITY,CAROWNERSHIP PersonID is a number for each tPerson
     * inside a tHousehold or for those in communal establishments (grouped)
     * HouseholdID is a sequencial number for each tHousehold
     * HSARDataRecord.RECORDID is the HSARDataRecord RECORDID or -9 if not an
     * HSARDataRecord ISARDataRecord.RECORDID is the ISARDataRecord RECORDID or
     * -9 if not an ISARDataRecord TODO: Docs
     * @param tToyModelDataHandler
     * @param line
     */
    public ToyModelDataRecord(ToyModelDataHandler tToyModelDataHandler,
            String line) {
        String[] fields = line.split(",");
        Zone_Code = fields[0].toCharArray();
        this.tPersonID = tToyModelDataHandler.parseInt(fields[1]);
        this.tHouseholdID = tToyModelDataHandler.parseInt(fields[2]);
        this.tHSARDataRecordID = Long.valueOf(fields[3]);
        this.tISARDataRecordID = Long.valueOf(fields[4]);
    }

    /**
     * Creates a new ToyModelDataRecord as read from aRandomAccessFile
     * @param aRandomAccessFile
     */
    public ToyModelDataRecord(RandomAccessFile aRandomAccessFile) {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.tPersonID = aRandomAccessFile.readInt();
            this.tHouseholdID = aRandomAccessFile.readInt();
            this.tHSARDataRecordID = aRandomAccessFile.readLong();
            this.tISARDataRecordID = aRandomAccessFile.readLong();
        } catch (IOException aIOException) {
            System.err.println(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    /**
     * Initialises all fields.
     * @param aToyModelDataRecord3
     */
    protected void init(ToyModelDataRecord aToyModelDataRecord3) {
        super.init(aToyModelDataRecord3);
        this.tPersonID = aToyModelDataRecord3.tPersonID;
        this.tHouseholdID = aToyModelDataRecord3.tHouseholdID;
        this.tHSARDataRecordID = aToyModelDataRecord3.tHSARDataRecordID;
        this.tISARDataRecordID = aToyModelDataRecord3.tISARDataRecordID;
    }

    /**
     * Initialises all fields.
     * @param aToyModelDataRecord2
     */
    protected void init(ToyModelDataRecord_2 aToyModelDataRecord2) {
        super.init(aToyModelDataRecord2);
        this.tPersonID = aToyModelDataRecord2.tPersonID;
        this.tHouseholdID = aToyModelDataRecord2.tHouseholdID;
        this.tHSARDataRecordID = aToyModelDataRecord2.tHSARDataRecordID;
        this.tISARDataRecordID = aToyModelDataRecord2.tISARDataRecordID;
    }

    /**
     * Initialises all fields.
     */
    protected void _Init() {
        super._Init();
        this.tPersonID = Integer.MIN_VALUE;
        this.tHouseholdID = Integer.MIN_VALUE;
        this.tHSARDataRecordID = Long.MIN_VALUE;
        this.tISARDataRecordID = Long.MIN_VALUE;
    }

    /**
     * Initialises all fields.
     */
    protected void initZero() {
        super._Init();
        this.tPersonID = 0;
        this.tHouseholdID = 0;
        this.tISARDataRecordID = 0;
        this.tHSARDataRecordID = 0;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", HSARDataRecordID " + tHSARDataRecordID + ", ISARDataRecordID " + tISARDataRecordID + ", PersonID " + tPersonID + ", HouseholdID" + tHouseholdID;
    }

    /**
     * Writes <code>this</code> to <code>aRandomAccessFile</code> at the current
     * position.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> this is written to.
     */
    @Override
    public void write(
            RandomAccessFile aRandomAccessFile) {
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
                aRandomAccessFile.writeInt(tPersonID);
                aRandomAccessFile.writeInt(tHouseholdID);
                aRandomAccessFile.writeLong(tHSARDataRecordID);
                aRandomAccessFile.writeLong(tISARDataRecordID);
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
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += ((2L * (long) Long.SIZE) + (2L * (long) Integer.SIZE)) / getNumberOfBitsInByte();
        return result;
    }
}
