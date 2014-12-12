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
 * For representing CAS KS020 Records and providing safe access to the data.
 */
public class CASKS020DataRecord extends AbstractCASDataRecord {

    /*
     * Table KS020 Household composition: All households Footnotes and Comments
     * for Table KS020 1. A dependent child is a person in a household aged 0 to
     * 15 (whether or not in a family) or a person aged 16 to 18 who is a
     * full-time student in a family with parent(s).
     */
    /**
     * KS0200001 = allHouseholds
     */
    protected int allHouseholds;
    /**
     * KS0200002 = householdsComprisingOnePensioner
     */
    protected int householdsComprisingOnePensioner;
    /**
     * KS0200003 = householdsComprisingOnePersonOtherThanPensioner
     */
    protected int householdsComprisingOnePersonOtherThanPensioner;
    /**
     * KS0200004 = householdsComprisingOneFamilyAndNoOthersAllPensioners
     */
    protected int householdsComprisingOneFamilyAndNoOthersAllPensioners;
    /**
     * KS0200005 =
     * householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren
     */
    protected int householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren;
    /**
     * KS0200006 =householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren
     */
    protected int householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren;
    /**
     * KS0200007 =householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent
     */
    protected int householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent;
    /**
     * KS0200020 =
     * householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren
     */
    protected int householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren;
    /**
     * KS0200009 =householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren
     */
    protected int householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren;
    /**
     * KS0200010 =householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent
     */
    protected int householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent;
    /**
     * KS0200011 =householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren
     */
    protected int householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren;
    /**
     * KS0200012 =householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent
     */
    protected int householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent;
    /**
     * KS0200013 = householdsComprisingOtherThanOneFamilyWithDependentChildren
     */
    protected int householdsComprisingOtherThanOneFamilyWithDependentChildren;
    /**
     * KS0200014 = householdsComprisingOtherThanOneFamilyAllStudent
     */
    protected int householdsComprisingOtherThanOneFamilyAllStudent;
    /**
     * KS0200015 = householdsComprisingOtherThanOneFamilyAllPensioner
     */
    protected int householdsComprisingOtherThanOneFamilyAllPensioner;
    /**
     * KS0200016 = householdsComprisingOtherThanOneFamilyOther
     */
    protected int householdsComprisingOtherThanOneFamilyOther;

    /** Creates a new CASKS020Record */
    public CASKS020DataRecord() {
        _Init();
    }

    /**
     * Creates a new CASKS020Record cloned from aCASKS020Record
     *
     * @param aCASKS020Record
     *            The CASKS020Record from which this is cloned.
     */
    public CASKS020DataRecord(CASKS020DataRecord aCASKS020Record) {
        init(aCASKS020Record);
    }

    /**
     * Creates a new CASKS020DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public CASKS020DataRecord(long RecordID, String line) throws IOException {
        String[] fieldsDummy = line.split(",");
        // System.out.println(fieldsDummy.length);
        // for (int i = 0; i < fieldsDummy.length; i ++ ){
        // System.out.println(fieldsDummy[i]);
        // }
        String[] fields = new String[17];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = "";
        }
        System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
        this._RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table KS020
        this.allHouseholds = StaticConverter.to_int(fields[1]);
        this.householdsComprisingOnePensioner = StaticConverter.to_int(fields[2]);
        this.householdsComprisingOnePersonOtherThanPensioner = StaticConverter.to_int(fields[3]);
        this.householdsComprisingOneFamilyAndNoOthersAllPensioners = StaticConverter.to_int(fields[4]);
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren = StaticConverter.to_int(fields[5]);
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren = StaticConverter.to_int(fields[6]);
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent = StaticConverter.to_int(fields[7]);
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren = StaticConverter.to_int(fields[8]);
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren = StaticConverter.to_int(fields[9]);
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent = StaticConverter.to_int(fields[10]);
        this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren = StaticConverter.to_int(fields[11]);
        this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent = StaticConverter.to_int(fields[12]);
        this.householdsComprisingOtherThanOneFamilyWithDependentChildren = StaticConverter.to_int(fields[13]);
        this.householdsComprisingOtherThanOneFamilyAllStudent = StaticConverter.to_int(fields[14]);
        this.householdsComprisingOtherThanOneFamilyAllPensioner = StaticConverter.to_int(fields[15]);
        this.householdsComprisingOtherThanOneFamilyOther = StaticConverter.to_int(fields[16]);
    }

    /**
     * Creates a new CASKS020Record
     *
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public CASKS020DataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.allHouseholds = aRandomAccessFile.readInt();
            this.householdsComprisingOnePensioner = aRandomAccessFile.readInt();
            this.householdsComprisingOnePersonOtherThanPensioner = aRandomAccessFile.readInt();
            this.householdsComprisingOneFamilyAndNoOthersAllPensioners = aRandomAccessFile.readInt();
            this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren = aRandomAccessFile.readInt();
            this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren = aRandomAccessFile.readInt();
            this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent = aRandomAccessFile.readInt();
            this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren = aRandomAccessFile.readInt();
            this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren = aRandomAccessFile.readInt();
            this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent = aRandomAccessFile.readInt();
            this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren = aRandomAccessFile.readInt();
            this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent = aRandomAccessFile.readInt();
            this.householdsComprisingOtherThanOneFamilyWithDependentChildren = aRandomAccessFile.readInt();
            this.householdsComprisingOtherThanOneFamilyAllStudent = aRandomAccessFile.readInt();
            this.householdsComprisingOtherThanOneFamilyAllPensioner = aRandomAccessFile.readInt();
            this.householdsComprisingOtherThanOneFamilyOther = aRandomAccessFile.readInt();
        } catch (IOException ioe0) {
            // ioe0.printStackTrace();
            throw ioe0;
        }
    }

    /**
     * Initialise.
     */
    protected void _Init() {
        super._Init();
        this.allHouseholds = Integer.MIN_VALUE;
        this.householdsComprisingOnePensioner = Integer.MIN_VALUE;
        this.householdsComprisingOnePersonOtherThanPensioner = Integer.MIN_VALUE;
        this.householdsComprisingOneFamilyAndNoOthersAllPensioners = Integer.MIN_VALUE;
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren = Integer.MIN_VALUE;
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren = Integer.MIN_VALUE;
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent = Integer.MIN_VALUE;
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren = Integer.MIN_VALUE;
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren = Integer.MIN_VALUE;
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent = Integer.MIN_VALUE;
        this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren = Integer.MIN_VALUE;
        this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent = Integer.MIN_VALUE;
        this.householdsComprisingOtherThanOneFamilyWithDependentChildren = Integer.MIN_VALUE;
        this.householdsComprisingOtherThanOneFamilyAllStudent = Integer.MIN_VALUE;
        this.householdsComprisingOtherThanOneFamilyAllPensioner = Integer.MIN_VALUE;
        this.householdsComprisingOtherThanOneFamilyOther = Integer.MIN_VALUE;
    }

    /**
     * Initialise to zero.
     */
    protected void initZero() {
        super._Init();
        this.allHouseholds = 0;
        this.householdsComprisingOnePensioner = 0;
        this.householdsComprisingOnePersonOtherThanPensioner = 0;
        this.householdsComprisingOneFamilyAndNoOthersAllPensioners = 0;
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren = 0;
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren = 0;
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent = 0;
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren = 0;
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren = 0;
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent = 0;
        this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren = 0;
        this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent = 0;
        this.householdsComprisingOtherThanOneFamilyWithDependentChildren = 0;
        this.householdsComprisingOtherThanOneFamilyAllStudent = 0;
        this.householdsComprisingOtherThanOneFamilyAllPensioner = 0;
        this.householdsComprisingOtherThanOneFamilyOther = 0;
    }

    /**
     * Initialises all fields from those in cASKS020Record.
     *
     * @param cASKS020Record
     *            The CASKS020Record thats fields are used to initialise this.
     */
    protected void init(CASKS020DataRecord cASKS020Record) {
        super.init(cASKS020Record);
        this.allHouseholds = cASKS020Record.allHouseholds;
        this.householdsComprisingOnePensioner = cASKS020Record.householdsComprisingOnePensioner;
        this.householdsComprisingOnePersonOtherThanPensioner = cASKS020Record.householdsComprisingOnePersonOtherThanPensioner;
        this.householdsComprisingOneFamilyAndNoOthersAllPensioners = cASKS020Record.householdsComprisingOneFamilyAndNoOthersAllPensioners;
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren = cASKS020Record.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren;
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren = cASKS020Record.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren;
        this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent = cASKS020Record.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent;
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren = cASKS020Record.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren;
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren = cASKS020Record.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren;
        this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent = cASKS020Record.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent;
        this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren = cASKS020Record.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren;
        this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent = cASKS020Record.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent;
        this.householdsComprisingOtherThanOneFamilyWithDependentChildren = cASKS020Record.householdsComprisingOtherThanOneFamilyWithDependentChildren;
        this.householdsComprisingOtherThanOneFamilyAllStudent = cASKS020Record.householdsComprisingOtherThanOneFamilyAllStudent;
        this.householdsComprisingOtherThanOneFamilyAllPensioner = cASKS020Record.householdsComprisingOtherThanOneFamilyAllPensioner;
        this.householdsComprisingOtherThanOneFamilyOther = cASKS020Record.householdsComprisingOtherThanOneFamilyOther;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", allHouseholds " + allHouseholds + ", householdsComprisingOnePensioner " + householdsComprisingOnePensioner + ", householdsComprisingOnePersonOtherThanPensioner " + householdsComprisingOnePersonOtherThanPensioner + ", householdsComprisingOneFamilyAndNoOthersAllPensioners " + householdsComprisingOneFamilyAndNoOthersAllPensioners + ", householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren " + householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren + ", householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren " + householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren + ", householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent " + householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent + ", householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren " + householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren + ", householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren " + householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren + ", householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent " + householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent + ", householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren " + householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren + ", householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent " + householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent + ", householdsComprisingOtherThanOneFamilyWithDependentChildren " + householdsComprisingOtherThanOneFamilyWithDependentChildren + ", householdsComprisingOtherThanOneFamilyAllStudent " + householdsComprisingOtherThanOneFamilyAllStudent + ", householdsComprisingOtherThanOneFamilyAllPensioner " + householdsComprisingOtherThanOneFamilyAllPensioner + ", householdsComprisingOtherThanOneFamilyOther " + householdsComprisingOtherThanOneFamilyOther;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + allHouseholds + "," + householdsComprisingOnePensioner + "," + householdsComprisingOnePersonOtherThanPensioner + "," + householdsComprisingOneFamilyAndNoOthersAllPensioners + "," + householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren + "," + householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren + "," + householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent + "," + householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren + "," + householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren + "," + householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent + "," + householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren + "," + householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent + "," + householdsComprisingOtherThanOneFamilyWithDependentChildren + "," + householdsComprisingOtherThanOneFamilyAllStudent + "," + householdsComprisingOtherThanOneFamilyAllPensioner + "," + householdsComprisingOtherThanOneFamilyOther;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        return super.toCSVStringFields() + ",allHouseholds" + ",householdsComprisingOnePensioner" + ",householdsComprisingOnePersonOtherThanPensioner" + ",householdsComprisingOneFamilyAndNoOthersAllPensioners" + ",householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren" + ",householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren" + ",householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent" + ",householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren" + ",householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren" + ",householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent" + ",householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren" + ",householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent" + ",householdsComprisingOtherThanOneFamilyWithDependentChildren" + ",householdsComprisingOtherThanOneFamilyAllStudent" + ",householdsComprisingOtherThanOneFamilyAllPensioner" + ",householdsComprisingOtherThanOneFamilyOther";
    }

    /**
     * Returns a copy of this.allHouseholds
     * @return 
     */
    public int getAllHouseholds() {
        return this.allHouseholds;
    }

    /**
     * Returns a copy of this.householdsComprisingOnePensioner
     * @return 
     */
    public int getHouseholdsComprisingOnePensioner() {
        return this.householdsComprisingOnePensioner;
    }

    /**
     * Returns a copy of this.householdsComprisingOnePersonOtherThanPensioner
     * @return 
     */
    public int getHouseholdsComprisingOnePersonOtherThanPensioner() {
        return this.householdsComprisingOnePersonOtherThanPensioner;
    }

    /**
     * Returns a copy of
     * this.householdsComprisingOneFamilyAndNoOthersAllPensioners
     * @return 
     */
    public int getHouseholdsComprisingOneFamilyAndNoOthersAllPensioners() {
        return this.householdsComprisingOneFamilyAndNoOthersAllPensioners;
    }

    /**
     * Returns a copy of this.
     * householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren
     * @return 
     */
    public int getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren() {
        return this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren;
    }

    /**
     * Returns a copy of this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren
     * @return 
     */
    public int getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren() {
        return this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren;
    }

    /**
     * Returns a copy of this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent
     * @return 
     */
    public int getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent() {
        return this.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent;
    }

    /**
     * Returns a copy of this.
     * householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren
     * @return 
     */
    public int getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren() {
        return this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren;
    }

    /**
     * Returns a copy of this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren
     * @return 
     */
    public int getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren() {
        return this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren;
    }

    /**
     * Returns a copy of this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent
     * @return 
     */
    public int getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent() {
        return this.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent;
    }

    /**
     * Returns a copy of this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren
     * @return 
     */
    public int getHouseholdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren() {
        return this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren;
    }

    /**
     * Returns a copy of this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent
     * @return 
     */
    public int getHouseholdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent() {
        return this.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent;
    }

    /**
     * Returns a copy of
     * this.householdsComprisingOtherThanOneFamilyWithDependentChildren
     * @return 
     */
    public int getHouseholdsComprisingOtherThanOneFamilyWithDependentChildren() {
        return this.householdsComprisingOtherThanOneFamilyWithDependentChildren;
    }

    /**
     * Returns a copy of this.householdsComprisingOtherThanOneFamilyAllStudent
     * @return 
     */
    public int getHouseholdsComprisingOtherThanOneFamilyAllStudent() {
        return this.householdsComprisingOtherThanOneFamilyAllStudent;
    }

    /**
     * Returns a copy of this.householdsComprisingOtherThanOneFamilyAllPensioner
     * @return 
     */
    public int getHouseholdsComprisingOtherThanOneFamilyAllPensioner() {
        return this.householdsComprisingOtherThanOneFamilyAllPensioner;
    }

    /**
     * Returns a copy of this.householdsComprisingOtherThanOneFamilyOther
     * @return 
     */
    public int getHouseholdsComprisingOtherThanOneFamilyOther() {
        return this.householdsComprisingOtherThanOneFamilyOther;
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
                aRandomAccessFile.writeInt(allHouseholds);
                aRandomAccessFile.writeInt(householdsComprisingOnePensioner);
                aRandomAccessFile.writeInt(householdsComprisingOnePersonOtherThanPensioner);
                aRandomAccessFile.writeInt(householdsComprisingOneFamilyAndNoOthersAllPensioners);
                aRandomAccessFile.writeInt(householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren);
                aRandomAccessFile.writeInt(householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren);
                aRandomAccessFile.writeInt(householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent);
                aRandomAccessFile.writeInt(householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren);
                aRandomAccessFile.writeInt(householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren);
                aRandomAccessFile.writeInt(householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent);
                aRandomAccessFile.writeInt(householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren);
                aRandomAccessFile.writeInt(householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent);
                aRandomAccessFile.writeInt(householdsComprisingOtherThanOneFamilyWithDependentChildren);
                aRandomAccessFile.writeInt(householdsComprisingOtherThanOneFamilyAllStudent);
                aRandomAccessFile.writeInt(householdsComprisingOtherThanOneFamilyAllPensioner);
                aRandomAccessFile.writeInt(householdsComprisingOtherThanOneFamilyOther);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>CASKS020DataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CASKS020DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS020DataRecord
     *            The <code>CASKS020DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public CASKS020DataRecord aggregate(
            CASKS020DataRecord aCASKS020DataRecord) {
        CASKS020DataRecord newCASKS020DataRecord = new CASKS020DataRecord(
                aCASKS020DataRecord);
        newCASKS020DataRecord.allHouseholds += getAllHouseholds();
        newCASKS020DataRecord.householdsComprisingOnePensioner += getHouseholdsComprisingOnePensioner();
        newCASKS020DataRecord.householdsComprisingOnePersonOtherThanPensioner += getHouseholdsComprisingOnePersonOtherThanPensioner();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersAllPensioners += getHouseholdsComprisingOneFamilyAndNoOthersAllPensioners();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren += getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren += getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent += getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren += getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren += getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent += getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren += getHouseholdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent += getHouseholdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent();
        newCASKS020DataRecord.householdsComprisingOtherThanOneFamilyWithDependentChildren += getHouseholdsComprisingOtherThanOneFamilyWithDependentChildren();
        newCASKS020DataRecord.householdsComprisingOtherThanOneFamilyAllStudent += getHouseholdsComprisingOtherThanOneFamilyAllStudent();
        newCASKS020DataRecord.householdsComprisingOtherThanOneFamilyAllPensioner += getHouseholdsComprisingOtherThanOneFamilyAllPensioner();
        newCASKS020DataRecord.householdsComprisingOtherThanOneFamilyOther += getHouseholdsComprisingOtherThanOneFamilyOther();
        return newCASKS020DataRecord;
    }

    /**
     * @return An aggregated <code>CASKS020DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS020DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS020DataRecord
     *            The <code>CASKS020DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public CASKS020DataRecord aggregate(CASKS020DataRecord aCASKS020DataRecord,
            long newRecordID, char[] newZone_Code) {
        CASKS020DataRecord newCASKS020DataRecord = new CASKS020DataRecord(this);
        newCASKS020DataRecord._RecordID = newRecordID;
        // newCASKS020DataRecord.Zone_Code = aCASKS020DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS020DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS020DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS020DataRecord.allHouseholds += getAllHouseholds();
        newCASKS020DataRecord.householdsComprisingOnePensioner += getHouseholdsComprisingOnePensioner();
        newCASKS020DataRecord.householdsComprisingOnePersonOtherThanPensioner += getHouseholdsComprisingOnePersonOtherThanPensioner();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersAllPensioners += getHouseholdsComprisingOneFamilyAndNoOthersAllPensioners();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren += getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsNoChildren();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren += getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsWithDependentChildren();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent += getHouseholdsComprisingOneFamilyAndNoOthersMarriedCoupleHouseholdsAllChildrenNonDependent();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren += getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsNoChildren();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren += getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsWithDependentChildren();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent += getHouseholdsComprisingOneFamilyAndNoOthersCohabitingCoupleHouseholdsAllChildrenNonDependent();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren += getHouseholdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsWithDependentChildren();
        newCASKS020DataRecord.householdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent += getHouseholdsComprisingOneFamilyAndNoOthersLoneParentHouseholdsAllChildrenNonDependent();
        newCASKS020DataRecord.householdsComprisingOtherThanOneFamilyWithDependentChildren += getHouseholdsComprisingOtherThanOneFamilyWithDependentChildren();
        newCASKS020DataRecord.householdsComprisingOtherThanOneFamilyAllStudent += getHouseholdsComprisingOtherThanOneFamilyAllStudent();
        newCASKS020DataRecord.householdsComprisingOtherThanOneFamilyAllPensioner += getHouseholdsComprisingOtherThanOneFamilyAllPensioner();
        newCASKS020DataRecord.householdsComprisingOtherThanOneFamilyOther += getHouseholdsComprisingOtherThanOneFamilyOther();
        return newCASKS020DataRecord;
    }

    /**
     * Returns the size of this Record in bytes as a long. This does not account
     * for serialVersionUID. A boolean is assumed to be the same size as an int
     * in bytes.
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (16L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}
