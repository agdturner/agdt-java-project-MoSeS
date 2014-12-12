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
import java.io.Serializable;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;

/**
 * An <code>abstract class</code> for a Census Area Statistic (CAS) Data Record.
 * <ul>
 * <li>Developed for <a href="http://www.ncess.ac.uk/moses">MoSeS</a>.</li>
 * <li>Copyright (C) 2006 <a
 * href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy Turner</a>, <a
 * href="http://www.leeds.ac.uk//">University of Leeds</a>.</li>
 * </ul>
 * 
 * @author <a href="http://www.geog.leeds.ac.uk/people/a.turner/">Andy
 *         Turner</a>
 * @version 1.0.0, 2006-08-10
 * @see AbstractDataHandler
 */
public abstract class AbstractCASDataRecord
        extends AbstractDataRecord
        implements Serializable, Comparable {

    /**
     * Serializable class version number for swapping
     * (serialization/deserialization)
     */
//	private static final long serialVersionUID = 1L;
    /**
     * For storing Census Area Zone Code as a <code>char[]</code>
     */
    protected char[] Zone_Code;

    /**
     * Initialise from aCASDataRecord
     *
     * @param aCASDataRecord
     *            The <code>AbstractCASDataRecord</code> used to initialise.
     */
    protected void init(AbstractCASDataRecord aCASDataRecord) {
        super._Init(aCASDataRecord);
        this.Zone_Code = new char[aCASDataRecord.getZone_Code().length];
        for (int i = 0; i < Zone_Code.length; i++) {
            Zone_Code[i] = aCASDataRecord.Zone_Code[i];
        }
    }

    /**
     * Initialises.
     */
    @Override
    protected void _Init() {
        super._Init();
        this.Zone_Code = new char[10];
        for (int i = 0; i < Zone_Code.length; i++) {
            // Zone_Code[ i ] = 'X';
            Zone_Code[i] = ' ';
        }
    }

    /**
     * @return A <code>String</code> description of this.
     */
    @Override
    public String toString() {
        String result = super.toString();
        result += ", Zone_Code " + new String(Zone_Code);
        return result;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        String result = super.toCSVString();
        result += "," + new String(Zone_Code);
        return result;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        String result = super.toCSVStringFields();
        result += ",Zone_Code";
        return result;
    }

    /**
     * Calls super.write(RandomAccessFile) then writes out:
     * <ul>
     * <li><code>this.Zone_Code</code> as a sequence of <code>chars</code></li>
     * </ul>
     * to aRandomAccessFile.
     *
     * @see AbstractDataRecord#write(RandomAccessFile)
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> written to.
     */
    @Override
    public void write(
            RandomAccessFile aRandomAccessFile) {
        try {
            super.write(aRandomAccessFile);
            for (int Zone_CodeID = 0; Zone_CodeID < this.Zone_Code.length; Zone_CodeID++) {
                aRandomAccessFile.writeChar(this.Zone_Code[Zone_CodeID]);
            }
        } catch (IOException aIOException) {
            System.err.println(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    /**
     * Writes <code>this</code> to <code>aRandomAccessFile</code> at the current
     * position using RecordID as the RecordID, hashCode as hashCode and
     * zoneCode as zoneCode.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> this is written to.
     * @param RecordID
     *            The RecordID to be written.
     * @param hashCode
     *            The hashCode to be written.
     * @param zoneCode
     *            The zoneCode to be written.
     */
    public void write(
            RandomAccessFile aRandomAccessFile,
            long RecordID,
            int hashCode,
            String zoneCode) {
        try {
            aRandomAccessFile.writeLong(RecordID);
            aRandomAccessFile.writeInt(hashCode);
            char[] Zone_Code = zoneCode.toCharArray();
            for (int Zone_CodeID = 0; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
                aRandomAccessFile.writeChar(Zone_Code[Zone_CodeID]);
            }
            for (int Zone_CodeID = 0; Zone_CodeID < this.Zone_Code.length - Zone_Code.length; Zone_CodeID++) {
                aRandomAccessFile.writeChar(' ');
            }
            write(aRandomAccessFile);
        } catch (IOException aIOException) {
            System.err.println(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    /**
     * @param object
     * @see java.lang.Object#equals(Object)
     */
    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            AbstractCASDataRecord aAbstractCASDataRecord = (AbstractCASDataRecord) object;
            if (this.Zone_Code.length == aAbstractCASDataRecord.Zone_Code.length) {
                for (int i0 = 0; i0 < this.Zone_Code.length; i0++) {
                    if (this.Zone_Code[i0] != aAbstractCASDataRecord.Zone_Code[i0]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.Zone_Code != null ? this.Zone_Code.hashCode() : 0);
        return hash;
    }

    /**
     * @return The size (in <code>bytes</code>) of this as a <code>long</code>.
     *         This does not account for the private Fields
     *         <code>serialVersionUID</code>.
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += ((long) (Zone_Code.length * Character.SIZE)) / getNumberOfBitsInByte();
        return result;
    }

    /**
     * Returns a copy of this.Zone_Code
     * @return 
     */
    public char[] getZone_Code() {
        int Zone_CodeLength = this.Zone_Code.length;
        char[] tZone_Code = new char[Zone_CodeLength];
        for (int i = 0; i < Zone_CodeLength; i++) {
            tZone_Code[i] = this.Zone_Code[i];
        }
        return tZone_Code;
    }
}
