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
import uk.ac.leeds.ccg.andyt.census.sar.Census_HSARDataRecord;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

/**
 * For representing ToyModelDataRecords and providing safe access to the data.
 */
public class ToyModelHSARDataRecord extends Census_AbstractDataRecord {

    public Census_HSARDataRecord t_HSARDataRecord;

    /** Creates a new ToyModelDataRecord */
    public ToyModelHSARDataRecord() {
        init();
    }

    /**
     * Creates a new ToyModelDataRecord_2 cloned from _ToyModelDataRecord_2
     *
     * @param _ToyModelDataRecord_2
     *            The ToyModelDataRecord_2 from which this is cloned.
     */
    public ToyModelHSARDataRecord(
            ToyModelDataRecord_2 _ToyModelDataRecord_2) {
        init(_ToyModelDataRecord_2);
        this.RecordID = _ToyModelDataRecord_2.getRecordID();
    }

    /**
     * Creates a new ToyModelDataRecord_2 from the String line
     * AREACODE,HSARRECORD
     * @param aStringTokenizer
     * @param zoneCode
     * @throws java.io.IOException
     */
    public ToyModelHSARDataRecord(
            long RecordID,
            String zoneCode,
            StringTokenizer aStringTokenizer)
            throws IOException {
        char[] Zone_Code = zoneCode.toCharArray();
        this.Zone_Code = new char[10];
        for (int i = 0; i < Zone_Code.length; i++) {
            this.Zone_Code[i] = Zone_Code[i];
        }
        this.RecordID = RecordID;
        this.t_HSARDataRecord = new Census_HSARDataRecord(RecordID, aStringTokenizer);
    }

    /**
     * Creates a new ToyModelDataRecord as read from aRandomAccessFile
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public ToyModelHSARDataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        this.RecordID = aRandomAccessFile.readLong();
        this.Zone_Code = new char[10];
        for (int i = 0; i < this.Zone_Code.length; i++) {
            Zone_Code[i] = aRandomAccessFile.readChar();
        }
        this.t_HSARDataRecord = new Census_HSARDataRecord(aRandomAccessFile);
    }

    /**
     * Initialises all fields.
     * @param a_ToyModelHSARDataRecord
     */
    protected void init(ToyModelHSARDataRecord a_ToyModelHSARDataRecord) {
        super.init(a_ToyModelHSARDataRecord);
        this.t_HSARDataRecord = a_ToyModelHSARDataRecord.t_HSARDataRecord;
    }

    /**
     * Initialises all fields.
     */
    protected void init() {
        super.init();
        this.t_HSARDataRecord = new Census_HSARDataRecord();
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", HSARDataRecord " + t_HSARDataRecord;
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
            t_HSARDataRecord.write(aRandomAccessFile);
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
        result += t_HSARDataRecord.getSizeInBytes();
        // result += (
        // ( 2L * ( long ) Long.SIZE ) +
        // ( 8L * ( long ) Integer.SIZE ) )
        // / getNumberOfBitsInByte();
        return result;
    }
}
