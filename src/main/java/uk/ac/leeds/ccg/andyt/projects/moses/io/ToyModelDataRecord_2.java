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

/**
 * For representing ToyModelDataRecords and providing safe access to the data.
 */
public class ToyModelDataRecord_2 extends ToyModelDataRecord {

    // protected long fitness;
    public int AGE;
    public int SEX;
    public int LLTI;
    public int HEALTH;
    public int ETHNICITY;
    public int CAROWNERSHIP;

    /** Creates a new ToyModelDataRecord */
    public ToyModelDataRecord_2() {
        init();
    }

    /**
     * Creates a new ToyModelDataRecord with fields initialised to zero for
     * aggregating
     * @param initZero
     */
    public ToyModelDataRecord_2(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new ToyModelDataRecord_2 cloned from _ToyModelDataRecord_2
     *
     * @param _ToyModelDataRecord_2
     *            The ToyModelDataRecord_2 from which this is cloned.
     */
    public ToyModelDataRecord_2(ToyModelDataRecord_2 _ToyModelDataRecord_2) {
        init(_ToyModelDataRecord_2);
        this.RecordID = _ToyModelDataRecord_2.RecordID;
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
    public ToyModelDataRecord_2(ToyModelDataHandler tToyModelDataHandler,
            String line) {
        String[] fields = line.split(",");
        Zone_Code = fields[0].toCharArray();
        this.tPersonID = tToyModelDataHandler.parseInt(fields[1]);
        this.tHouseholdID = tToyModelDataHandler.parseInt(fields[2]);
        this.tHSARDataRecordID = Long.valueOf(fields[3]);
        this.tISARDataRecordID = Long.valueOf(fields[4]);
        this.AGE = tToyModelDataHandler.parseInt(fields[5]);
        this.SEX = tToyModelDataHandler.parseInt(fields[6]);
        this.LLTI = tToyModelDataHandler.parseInt(fields[7]);
        this.HEALTH = tToyModelDataHandler.parseInt(fields[8]);
        this.ETHNICITY = tToyModelDataHandler.parseInt(fields[9]);
        this.CAROWNERSHIP = tToyModelDataHandler.parseInt(fields[10]);
    }

    /**
     * Creates a new ToyModelDataRecord as read from aRandomAccessFile
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public ToyModelDataRecord_2(RandomAccessFile aRandomAccessFile)
            throws IOException {
        this.RecordID = aRandomAccessFile.readLong();
        this.Zone_Code = new char[10];
        for (int i = 0; i < this.Zone_Code.length; i++) {
            Zone_Code[i] = aRandomAccessFile.readChar();
        }
        this.tPersonID = aRandomAccessFile.readInt();
        this.tHouseholdID = aRandomAccessFile.readInt();
        this.tHSARDataRecordID = aRandomAccessFile.readLong();
        this.tISARDataRecordID = aRandomAccessFile.readLong();
        this.AGE = aRandomAccessFile.readInt();
        this.SEX = aRandomAccessFile.readInt();
        this.LLTI = aRandomAccessFile.readInt();
        this.HEALTH = aRandomAccessFile.readInt();
        this.ETHNICITY = aRandomAccessFile.readInt();
        this.CAROWNERSHIP = aRandomAccessFile.readInt();
    }

    /**
     * Initialises all fields.
     * @param aToyModelDataRecord2
     */
    protected void init(ToyModelDataRecord_2 aToyModelDataRecord2) {
        super.init(aToyModelDataRecord2);
        this.AGE = aToyModelDataRecord2.AGE;
        this.SEX = aToyModelDataRecord2.SEX;
        this.LLTI = aToyModelDataRecord2.LLTI;
        this.HEALTH = aToyModelDataRecord2.HEALTH;
        this.ETHNICITY = aToyModelDataRecord2.ETHNICITY;
        this.CAROWNERSHIP = aToyModelDataRecord2.CAROWNERSHIP;
    }

    /**
     * Initialises all fields.
     */
    protected void init() {
        super.init();
        this.AGE = Integer.MIN_VALUE;
        this.SEX = Integer.MIN_VALUE;
        this.LLTI = Integer.MIN_VALUE;
        this.HEALTH = Integer.MIN_VALUE;
        this.ETHNICITY = Integer.MIN_VALUE;
        this.CAROWNERSHIP = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields.
     */
    protected void initZero() {
        super.init();
        this.AGE = 0;
        this.SEX = 0;
        this.LLTI = 0;
        this.HEALTH = 0;
        this.ETHNICITY = 0;
        this.CAROWNERSHIP = 0;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", AGE" + AGE + ", SEX" + SEX + ", LLTI" + LLTI + ", HEALTH" + HEALTH + ", ETHNICITY" + ETHNICITY + ", CAROWNERSHIP" + CAROWNERSHIP;
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
    @Override
    public void write(
            RandomAccessFile aRandomAccessFile,
            boolean avoidCallToSuper) {
        if (avoidCallToSuper) {
            try {
                aRandomAccessFile.writeInt(tPersonID);
                aRandomAccessFile.writeInt(tHouseholdID);
                aRandomAccessFile.writeLong(tHSARDataRecordID);
                aRandomAccessFile.writeLong(tISARDataRecordID);
                aRandomAccessFile.writeInt(AGE);
                aRandomAccessFile.writeInt(SEX);
                aRandomAccessFile.writeInt(LLTI);
                aRandomAccessFile.writeInt(HEALTH);
                aRandomAccessFile.writeInt(ETHNICITY);
                aRandomAccessFile.writeInt(CAROWNERSHIP);
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
        result += ((6L * (long) Integer.SIZE)) / getNumberOfBitsInByte();
        return result;
    }
}
