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
 * A <code>class</code> collection of the following
 * <code>AbstractCASDataRecords</code>:
 * <ul>
 * <li>CAS001DataRecord</li>
 * <li>CAS002DataRecord</li>
 * <li>CAS003DataRecord</li>
 * <li>CASKS002DataRecord</li>
 * <li>CASKS008DataRecord</li>
 * <li>CASKS010DataRecord</li>
 * <li>CASKS017DataRecord</li>
 * <li>CASKS020DataRecord</li>
 * <li>CASKS09bDataRecord</li>
 * <li>CASKS09cDataRecord</li>
 * <li>CASKS12bDataRecord</li>
 * <li>CASKS12cDataRecord</li>
 * <li>CASKS14bDataRecord</li>
 * <li>CASKS14cDataRecord</li>
 * </ul>
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
 * @see CASDataHandler
 */
public class CASDataRecord extends AbstractCASDataRecord {

	/**
	 * CAS001DataRecord
	 */
	protected CAS001DataRecord tCAS001DataRecord;

	/**
	 * CAS002DataRecord
	 */
	protected CAS002DataRecord tCAS002DataRecord;

	/**
	 * CAS003DataRecord
	 */
	protected CAS003DataRecord tCAS003DataRecord;

	/**
	 * CASKS002DataRecord
	 */
	protected CASKS002DataRecord tCASKS002DataRecord;

	/**
	 * CASKS006DataRecord
	 */
	protected CASKS006DataRecord tCASKS006DataRecord;

	/**
	 * CASKS008DataRecord
	 */
	protected CASKS008DataRecord tCASKS008DataRecord;

	/**
	 * CASKS010DataRecord
	 */
	protected CASKS010DataRecord tCASKS010DataRecord;

	/**
	 * CASKS017DataRecord
	 */
	protected CASKS017DataRecord tCASKS017DataRecord;

	/**
	 * CASKS020DataRecord
	 */
	protected CASKS020DataRecord tCASKS020DataRecord;

	/**
	 * CASKS09bDataRecord
	 */
	protected CASKS09bDataRecord tCASKS09bDataRecord;

	/**
	 * CASKS09cDataRecord
	 */
	protected CASKS09cDataRecord tCASKS09cDataRecord;

	/**
	 * CASKS12bDataRecord
	 */
	protected CASKS12bDataRecord tCASKS12bDataRecord;

	/**
	 * CASKS12cDataRecord
	 */
	protected CASKS12cDataRecord tCASKS12cDataRecord;

	/**
	 * CASKS14bDataRecord
	 */
	protected CASKS14bDataRecord tCASKS14bDataRecord;

	/**
	 * CASKS14cDataRecord
	 */
	protected CASKS14cDataRecord tCASKS14cDataRecord;

	/** Creates a new CASKSSelection1Record */
	public CASDataRecord() {
		_Init();
	}

	/** Creates a new CASKSSelection1Record
     * @param tCASDataHandler
     * @param tRecordID */
	public CASDataRecord(
            CASDataHandler tCASDataHandler,
            long tRecordID) {
        init(tCASDataHandler,
                tRecordID);
    }

	/**
	 * Initialises all fields.
	 */
	protected void _Init() {
		this.tCAS001DataRecord = new CAS001DataRecord();
		this.tCAS002DataRecord = new CAS002DataRecord();
		this.tCAS003DataRecord = new CAS003DataRecord();
		this.tCASKS002DataRecord = new CASKS002DataRecord();
		this.tCASKS008DataRecord = new CASKS008DataRecord();
		this.tCASKS010DataRecord = new CASKS010DataRecord();
		this.tCASKS017DataRecord = new CASKS017DataRecord();
		this.tCASKS020DataRecord = new CASKS020DataRecord();
		this.tCASKS09bDataRecord = new CASKS09bDataRecord();
		this.tCASKS09cDataRecord = new CASKS09cDataRecord();
		this.tCASKS12bDataRecord = new CASKS12bDataRecord();
		this.tCASKS12cDataRecord = new CASKS12cDataRecord();
		this.tCASKS14bDataRecord = new CASKS14bDataRecord();
		this.tCASKS14cDataRecord = new CASKS14cDataRecord();
	}

	/**
	 * Initialises all fields.
     * @param tCASDataHandler
     * @param tRecordID
	 */
	protected void init(
            CASDataHandler tCASDataHandler,
            long tRecordID) {
		this.tCAS001DataRecord = (CAS001DataRecord) tCASDataHandler
				.getCAS001DataHandler().getDataRecord(tRecordID);
		this.tCAS002DataRecord = (CAS002DataRecord) tCASDataHandler
				.getCAS002DataHandler().getDataRecord(tRecordID);
		this.tCAS003DataRecord = (CAS003DataRecord) tCASDataHandler
				.getCAS003DataHandler().getDataRecord(tRecordID);
		this.tCASKS002DataRecord = (CASKS002DataRecord) tCASDataHandler
				.getCASKS002DataHandler().getDataRecord(tRecordID);
		this.tCASKS008DataRecord = (CASKS008DataRecord) tCASDataHandler
				.getCASKS008DataHandler().getDataRecord(tRecordID);
		this.tCASKS010DataRecord = (CASKS010DataRecord) tCASDataHandler
				.getCASKS010DataHandler().getDataRecord(tRecordID);
		this.tCASKS017DataRecord = (CASKS017DataRecord) tCASDataHandler
				.getCASKS017DataHandler().getDataRecord(tRecordID);
		this.tCASKS020DataRecord = (CASKS020DataRecord) tCASDataHandler
				.getCASKS020DataHandler().getDataRecord(tRecordID);
		this.tCASKS09bDataRecord = (CASKS09bDataRecord) tCASDataHandler
				.getCASKS09bDataHandler().getDataRecord(tRecordID);
		this.tCASKS09cDataRecord = (CASKS09cDataRecord) tCASDataHandler
				.getCASKS09cDataHandler().getDataRecord(tRecordID);
		this.tCASKS12bDataRecord = (CASKS12bDataRecord) tCASDataHandler
				.getCASKS12bDataHandler().getDataRecord(tRecordID);
		this.tCASKS12cDataRecord = (CASKS12cDataRecord) tCASDataHandler
				.getCASKS12cDataHandler().getDataRecord(tRecordID);
		this.tCASKS14bDataRecord = (CASKS14bDataRecord) tCASDataHandler
				.getCASKS14bDataHandler().getDataRecord(tRecordID);
		this.tCASKS14cDataRecord = (CASKS14cDataRecord) tCASDataHandler
				.getCASKS14cDataHandler().getDataRecord(tRecordID);
	}

	/**
	 * Returns a string description of this;
     * @return 
	 */
	public String toString() {
		return "CAS001DataRecord " + tCAS001DataRecord.toString() + ", "
				+ "CAS002DataRecord " + tCAS002DataRecord.toString() + ", "
				+ "CAS003DataRecord " + tCAS003DataRecord.toString() + ", "
				+ "CASKS002DataRecord " + tCASKS002DataRecord.toString() + ", "
				+ "CASKS008DataRecord " + tCASKS008DataRecord.toString() + ", "
				+ "CASKS010DataRecord " + tCASKS010DataRecord.toString() + ", "
				+ "CASKS017DataRecord " + tCASKS017DataRecord.toString() + ", "
				+ "CASKS020DataRecord " + tCASKS020DataRecord.toString() + ", "
				+ "CASKS09bDataRecord " + tCASKS09bDataRecord.toString() + ", "
				+ "CASKS09cDataRecord " + tCASKS09cDataRecord.toString() + ", "
				+ "CASKS12bDataRecord " + tCASKS12bDataRecord.toString() + ", "
				+ "CASKS12cDataRecord " + tCASKS12cDataRecord.toString() + ", "
				+ "CASKS14bDataRecord " + tCASKS14bDataRecord.toString() + ", "
				+ "CASKS14cDataRecord " + tCASKS14cDataRecord.toString();
	}

	/**
	 * Returns the size of this CASDataRecord in bytes as a long. This does not
	 * account for serialVersionUID. A boolean is assumed to be the same size as
	 * an int in bytes.
     * @return 
	 */
	public long getSizeInBytes() {
		return tCAS001DataRecord.getSizeInBytes()
				+ tCAS002DataRecord.getSizeInBytes()
				+ tCAS003DataRecord.getSizeInBytes()
				+ tCASKS002DataRecord.getSizeInBytes()
				+ tCASKS008DataRecord.getSizeInBytes()
				+ tCASKS010DataRecord.getSizeInBytes()
				+ tCASKS017DataRecord.getSizeInBytes()
				+ tCASKS020DataRecord.getSizeInBytes()
				+ tCASKS09bDataRecord.getSizeInBytes()
				+ tCASKS09cDataRecord.getSizeInBytes()
				+ tCASKS12bDataRecord.getSizeInBytes()
				+ tCASKS12cDataRecord.getSizeInBytes()
				+ tCASKS14bDataRecord.getSizeInBytes()
				+ tCASKS14cDataRecord.getSizeInBytes();
	}

	/**
	 * Returns this.tCAS001DataRecord
     * @return 
	 */
	public CAS001DataRecord getCAS001DataRecord() {
		return this.tCAS001DataRecord;
	}

	/**
	 * Returns this.tCAS002DataRecord
     * @return 
	 */
	public CAS002DataRecord getCAS002DataRecord() {
		return this.tCAS002DataRecord;
	}

	/**
	 * Returns this.tCAS003DataRecord
     * @return 
	 */
	public CAS003DataRecord getCAS003DataRecord() {
		return this.tCAS003DataRecord;
	}

	/**
	 * Returns this.tCASKS002DataRecord
     * @return 
	 */
	public CASKS002DataRecord getCASKS002DataRecord() {
		return this.tCASKS002DataRecord;
	}

	/**
	 * Returns this.tCASKS006DataRecord
     * @return 
	 */
	public CASKS006DataRecord getCASKS006DataRecord() {
		return this.tCASKS006DataRecord;
	}

	/**
	 * Returns this.tCASKS008DataRecord
     * @return 
	 */
	public CASKS008DataRecord getCASKS008DataRecord() {
		return this.tCASKS008DataRecord;
	}

	/**
	 * Returns this.tCASKS010DataRecord
     * @return 
	 */
	public CASKS010DataRecord getCASKS010DataRecord() {
		return this.tCASKS010DataRecord;
	}

	/**
	 * Returns this.tCASKS017DataRecord
     * @return 
	 */
	public CASKS017DataRecord getCASKS017DataRecord() {
		return this.tCASKS017DataRecord;
	}

	/**
	 * Returns this.tCASKS020DataRecord
     * @return 
	 */
	public CASKS020DataRecord getCASKS020DataRecord() {
		return this.tCASKS020DataRecord;
	}

	/**
	 * Returns this.tCASKS09bDataRecord
     * @return 
	 */
	public CASKS09bDataRecord getCASKS09bDataRecord() {
		return this.tCASKS09bDataRecord;
	}

	/**
	 * Returns this.tCASKS09cDataRecord
     * @return 
	 */
	public CASKS09cDataRecord getCASKS09cDataRecord() {
		return this.tCASKS09cDataRecord;
	}

	/**
	 * Returns this.tCASKS12bDataRecord
     * @return 
	 */
	public CASKS12bDataRecord getCASKS12bDataRecord() {
		return this.tCASKS12bDataRecord;
	}

	/**
	 * Returns this.tCASKS12cDataRecord
     * @return 
	 */
	public CASKS12cDataRecord getCASKS12cDataRecord() {
		return this.tCASKS12cDataRecord;
	}

	/**
	 * Returns this.tCASKS14bDataRecord
     * @return 
	 */
	public CASKS14bDataRecord getCASKS14bDataRecord() {
		return this.tCASKS14bDataRecord;
	}

	/**
	 * Returns this.tCASKS14cDataRecord
     * @return 
	 */
	public CASKS14cDataRecord getCASKS14cDataRecord() {
		return this.tCASKS14cDataRecord;
	}

	/**
	 * Returns a copy of this.Zone_Code
     * @return 
	 */
	public @Override
	char[] getZone_Code() {
		return getCASKS002DataRecord().getZone_Code();
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
	public void write(
            RandomAccessFile aRandomAccessFile,
			boolean avoidCallToSuper) {
		if (avoidCallToSuper) {
		} else {
			write(aRandomAccessFile);
		}
	}
}
