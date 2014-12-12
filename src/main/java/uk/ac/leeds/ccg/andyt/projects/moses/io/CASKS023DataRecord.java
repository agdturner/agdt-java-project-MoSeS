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
 * For representing CAS KS023 Records and providing safe access to the data.
 */
public class CASKS023DataRecord extends AbstractCASDataRecord {

    /*
     * Table KS023 Communal establishment residents: All communal establishment
     * residents NB: This table contains counts of Communal establishments;
     * Persons Footnotes and Comments for Table KS023 1 'Residents' excludes
     * staff and families of staff. 2 The number of residents in medical and
     * care establishments who have a limiting long-term illness is expressed as
     * a percentage of the number of residents in medical and care
     * establishments. The number of residents in other establishments who have
     * a limiting long-term illness is expressed as a percentage of the number
     * of residents in other establishments.
     *
     * Table for Northern Ireland has differences owing to differentiation of
     * educational establishents.
     */
    /**
     * KS0230001 = allCommunalEstablishments
     */
    protected int allCommunalEstablishments;
    /**
     * KS0230002 = householdsComprisingOnePensioner
     */
    protected int numberOfResidents;

    // /**
    // * KS0230003 = residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric
    // */
    // protected int
    // residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric;
    //
    // /**
    // * KS0230004 = residentsLivingInMedicalAndCareEstablishmentsNHSOther
    // */
    // protected int residentsLivingInMedicalAndCareEstablishmentsNHSOther;
    //
    // /**
    // * KS0230005 =
    // residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome
    // */
    // protected int
    // residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome;
    //
    // /**
    // * KS0230006 =
    // residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther
    // */
    // protected int
    // residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther;
    //
    // /**
    // * KS0230007 =
    // residentsLivingInMedicalAndCareEstablishmentsHousingAssociation
    // */
    // protected int
    // residentsLivingInMedicalAndCareEstablishmentsHousingAssociation;
    //
    // /**
    // * KS0230020 =
    // residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes
    // */
    // protected int
    // residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes;
    //
    // /**
    // * KS0230009 =
    // residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes
    // */
    // protected int
    // residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes;
    //
    // /**
    // * KS0230010 =
    // residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes
    // */
    // protected int
    // residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes;
    //
    // /**
    // * KS0230011 = residentsLivingInMedicalAndCareEstablishmentsOtherOther;
    // */
    // protected int residentsLivingInMedicalAndCareEstablishmentsOtherOther;
    //
    // /**
    // * KS0230012 = residentsLivingInOtherEstablishments
    // */
    // protected int residentsLivingInOtherEstablishments;
    //
    // /**
    // * KS0230013 =
    // residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments
    // */
    // protected int
    // residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments
    // ;
    //
    // /**
    // * KS0230014 =
    // residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments
    // */
    // protected int
    // residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments;
    /** Creates a new CASKS023Record */
    public CASKS023DataRecord() {
        _Init();
    }

    /**
     * Creates a new CASKS023Record cloned from cASKS023Record
     *
     * @param cASKS023Record
     *            The CASKS023Record from which this is cloned.
     */
    public CASKS023DataRecord(CASKS023DataRecord cASKS023Record) {
        init(cASKS023Record);
    }

    /**
     * Creates a new CASKS023DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public CASKS023DataRecord(long RecordID, String line) throws IOException {
        String[] fields = line.split(",");
        this._RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table KS023
        this.allCommunalEstablishments = StaticConverter.to_int(fields[1]);
        this.numberOfResidents = StaticConverter.to_int(fields[2]);
    // aCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric
    // = toInt( fields[ 3 ] );
    // aCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsNHSOther
    // = toInt( fields[ 4 ] );
    // aCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome
    // = toInt( fields[ 5 ] );
    // aCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther
    // = toInt( fields[ 6 ] );
    // aCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsHousingAssociation
    // = toInt( fields[ 7 ] );
    // aCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes
    // = toInt( fields[ 8 ] );
    // aCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes
    // = toInt( fields[ 9 ] );
    // aCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes
    // = toInt( fields[ 10 ] );
    // aCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherOther
    // = toInt( fields[ 11 ] );
    // aCASKS023DataRecord.residentsLivingInOtherEstablishments = toInt(
    // fields[ 12 ] );
    // aCASKS023DataRecord.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments
    // = toInt( fields[ 13 ] );
    // aCASKS023DataRecord.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments
    // = toInt( fields[ 14 ] );
    }

    /**
     * Creates a new CASKS017Record
     *
     * @param aRandomAccessFile
     * @throws java.io.IOException
     */
    public CASKS023DataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.allCommunalEstablishments = aRandomAccessFile.readInt();
            this.numberOfResidents = aRandomAccessFile.readInt();
        // this.residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric
        // = aRandomAccessFile.readInt();
        // this.residentsLivingInMedicalAndCareEstablishmentsNHSOther =
        // aRandomAccessFile.readInt();
        // this.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome
        // = aRandomAccessFile.readInt();
        // this.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther
        // = aRandomAccessFile.readInt();
        // this.residentsLivingInMedicalAndCareEstablishmentsHousingAssociation
        // = aRandomAccessFile.readInt();
        // this.residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes
        // = aRandomAccessFile.readInt();
        // this.residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes
        // = aRandomAccessFile.readInt();
        // this.residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes
        // = aRandomAccessFile.readInt();
        // this.residentsLivingInMedicalAndCareEstablishmentsOtherOther =
        // aRandomAccessFile.readInt();
        // this.residentsLivingInOtherEstablishments =
        // aRandomAccessFile.readInt();
        // this.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments
        // = aRandomAccessFile.readInt();
        // this.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments
        // = aRandomAccessFile.readInt();
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
        this.allCommunalEstablishments = Integer.MIN_VALUE;
        this.numberOfResidents = Integer.MIN_VALUE;
    // this.residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric =
    // Integer.MIN_VALUE;
    // this.residentsLivingInMedicalAndCareEstablishmentsNHSOther =
    // Integer.MIN_VALUE;
    // this.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome
    // = Integer.MIN_VALUE;
    // this.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther
    // = Integer.MIN_VALUE;
    // this.residentsLivingInMedicalAndCareEstablishmentsHousingAssociation
    // = Integer.MIN_VALUE;
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes =
    // Integer.MIN_VALUE;
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes
    // = Integer.MIN_VALUE;
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes
    // = Integer.MIN_VALUE;
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherOther =
    // Integer.MIN_VALUE;
    // this.residentsLivingInOtherEstablishments = Integer.MIN_VALUE;
    // this.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments
    // = Integer.MIN_VALUE;
    // this.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments
    // = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields from those in cASKS023Record.
     *
     * @param cASKS023Record
     *            The CASKS023Record thats fields are used to initialise this.
     */
    protected void init(CASKS023DataRecord cASKS023Record) {
        super.init(cASKS023Record);
        this.allCommunalEstablishments = cASKS023Record.allCommunalEstablishments;
        this.numberOfResidents = cASKS023Record.numberOfResidents;
    // this.residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric =
    // cASKS023Record.residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric;
    // this.residentsLivingInMedicalAndCareEstablishmentsNHSOther =
    // cASKS023Record.residentsLivingInMedicalAndCareEstablishmentsNHSOther;
    // this.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome
    // =
    // cASKS023Record.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome;
    // this.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther
    // =
    // cASKS023Record.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther;
    // this.residentsLivingInMedicalAndCareEstablishmentsHousingAssociation
    // =
    // cASKS023Record.residentsLivingInMedicalAndCareEstablishmentsHousingAssociation;
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes =
    // cASKS023Record.residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes;
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes
    // =
    // cASKS023Record.residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes;
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes
    // =
    // cASKS023Record.residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes;
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherOther =
    // cASKS023Record.residentsLivingInMedicalAndCareEstablishmentsOtherOther;
    // this.residentsLivingInOtherEstablishments =
    // cASKS023Record.residentsLivingInOtherEstablishments;
    // this.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments
    // =
    // cASKS023Record.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments;
    // this.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments
    // =
    // cASKS023Record.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() + ", " + ", allCommunalEstablishments " + allCommunalEstablishments + ", numberOfResidents " + numberOfResidents;
    // ", numberOfResidents " + numberOfResidents +
    // ", residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric " +
    // residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric +
    // ", residentsLivingInMedicalAndCareEstablishmentsNHSOther " +
    // residentsLivingInMedicalAndCareEstablishmentsNHSOther +
    // ", residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome "
    // +
    // residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome
    // +
    // ", residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther "
    // + residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther +
    // ", residentsLivingInMedicalAndCareEstablishmentsHousingAssociation "
    // + residentsLivingInMedicalAndCareEstablishmentsHousingAssociation +
    // ", residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes " +
    // residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes +
    // ", residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes "
    // +
    // residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes
    // +
    // ", residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes "
    // + residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes +
    // ", residentsLivingInMedicalAndCareEstablishmentsOtherOther " +
    // residentsLivingInMedicalAndCareEstablishmentsOtherOther +
    // ", residentsLivingInOtherEstablishments " +
    // residentsLivingInOtherEstablishments +
    // ", residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments "
    // +
    // residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments
    // +
    // ", residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments "
    // +
    // residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + allCommunalEstablishments + "," + numberOfResidents;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        return super.toCSVStringFields() + ",allCommunalEstablishments" + ",numberOfResidents";
    }

    /**
     * Returns a copy of this.allCommunalEstablishments
     * @return 
     */
    public int getAllCommunalEstablishments() {
        return this.allCommunalEstablishments;
    }

    /**
     * Returns a copy of this.numberOfResidents
     * @return 
     */
    public int getNumberOfResidents() {
        return this.numberOfResidents;
    }

    // /**
    // * Returns a copy of
    // this.residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric
    // */
    // public int
    // getResidentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric() {
    // return this.residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric;
    // }
    //
    // /**
    // * Returns a copy of
    // this.residentsLivingInMedicalAndCareEstablishmentsNHSOther
    // */
    // public int getResidentsLivingInMedicalAndCareEstablishmentsNHSOther() {
    // return this.residentsLivingInMedicalAndCareEstablishmentsNHSOther;
    // }
    //
    // /**
    // * Returns a copy of
    // this.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome
    // */
    // public int
    // getResidentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome()
    // {
    // return
    // this.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome;
    // }
    //
    // /**
    // * Returns a copy of
    // this.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther
    // */
    // public int
    // getResidentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther() {
    // return
    // this.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther;
    // }
    //
    // /**
    // * Returns a copy of
    // this.residentsLivingInMedicalAndCareEstablishmentsHousingAssociation
    // */
    // public int
    // getResidentsLivingInMedicalAndCareEstablishmentsHousingAssociation() {
    // return
    // this.residentsLivingInMedicalAndCareEstablishmentsHousingAssociation;
    // }
    //
    // /**
    // * Returns a copy of
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes
    // */
    // public int
    // getResidentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes() {
    // return
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes;
    // }
    //
    // /**
    // * Returns a copy of
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes
    // */
    // public int
    // getResidentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes()
    // {
    // return
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes;
    // }
    //
    // /**
    // * Returns a copy of
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes
    // */
    // public int
    // getResidentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes() {
    // return
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes;
    // }
    //
    // /**
    // * Returns a copy of
    // this.residentsLivingInMedicalAndCareEstablishmentsOtherOther
    // */
    // public int getResidentsLivingInMedicalAndCareEstablishmentsOtherOther() {
    // return this.residentsLivingInMedicalAndCareEstablishmentsOtherOther;
    // }
    //
    // /**
    // * Returns a copy of this.residentsLivingInOtherEstablishments
    // */
    // public int getResidentsLivingInOtherEstablishments() {
    // return this.residentsLivingInOtherEstablishments;
    // }
    //
    // /**
    // * Returns a copy of
    // this.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments
    // */
    // public int
    // getResidentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments()
    // {
    // return
    // this.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments;
    // }
    // /**
    // * Returns a copy of
    // this.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments
    // */
    // public int
    // getResidentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments()
    // {
    // return
    // this.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments;
    // }
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
                aRandomAccessFile.writeInt(allCommunalEstablishments);
                aRandomAccessFile.writeInt(numberOfResidents);
            // aRandomAccessFile.writeInt(
            // residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric );
            // aRandomAccessFile.writeInt(
            // residentsLivingInMedicalAndCareEstablishmentsNHSOther );
            // aRandomAccessFile.writeInt(
            // residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome
            // );
            // aRandomAccessFile.writeInt(
            // residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther
            // );
            // aRandomAccessFile.writeInt(
            // residentsLivingInMedicalAndCareEstablishmentsHousingAssociation
            // );
            // aRandomAccessFile.writeInt(
            // residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes );
            // aRandomAccessFile.writeInt(
            // residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes
            // );
            // aRandomAccessFile.writeInt(
            // residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes
            // );
            // aRandomAccessFile.writeInt(
            // residentsLivingInMedicalAndCareEstablishmentsOtherOther );
            // aRandomAccessFile.writeInt( residentsLivingInOtherEstablishments
            // );
            // aRandomAccessFile.writeInt(
            // residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments
            // );
            // aRandomAccessFile.writeInt(
            // residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments
            // );
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>CASKS023DataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CASKS023DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS023DataRecord
     *            The <code>CASKS023DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public CASKS023DataRecord aggregate(CASKS023DataRecord aCASKS023DataRecord) {
        CASKS023DataRecord newCASKS023DataRecord = new CASKS023DataRecord(
                aCASKS023DataRecord);
        newCASKS023DataRecord.allCommunalEstablishments += getAllCommunalEstablishments();
        newCASKS023DataRecord.numberOfResidents += getNumberOfResidents();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric
        // += getResidentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsNHSOther
        // += getResidentsLivingInMedicalAndCareEstablishmentsNHSOther();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsHousingAssociation
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsHousingAssociation();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherOther
        // += getResidentsLivingInMedicalAndCareEstablishmentsOtherOther();
        // newCASKS023DataRecord.residentsLivingInOtherEstablishments +=
        // getResidentsLivingInOtherEstablishments();
        // newCASKS023DataRecord.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments
        // +=
        // getResidentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments();
        // newCASKS023DataRecord.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments
        // +=
        // getResidentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments();
        return newCASKS023DataRecord;
    }

    /**
     * @return An aggregated <code>CASKS023DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CASKS023DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCASKS023DataRecord
     *            The <code>CASKS023DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public CASKS023DataRecord aggregate(
            CASKS023DataRecord aCASKS023DataRecord,
            long newRecordID,
            char[] newZone_Code) {
        CASKS023DataRecord newCASKS023DataRecord = new CASKS023DataRecord(this);
        newCASKS023DataRecord._RecordID = newRecordID;
        // newCASKS023DataRecord.Zone_Code = aCASKS023DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCASKS023DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCASKS023DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCASKS023DataRecord.allCommunalEstablishments += getAllCommunalEstablishments();
        newCASKS023DataRecord.numberOfResidents += getNumberOfResidents();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric
        // += getResidentsLivingInMedicalAndCareEstablishmentsNHSPsychiatric();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsNHSOther
        // += getResidentsLivingInMedicalAndCareEstablishmentsNHSOther();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsLocalAuthorityChildrensHome();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsLocalAuthorityOther();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsHousingAssociation
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsHousingAssociation();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsOtherNursingHomes();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsOtherResidentialCareHomes();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes
        // +=
        // getResidentsLivingInMedicalAndCareEstablishmentsOtherChildrensHomes();
        // newCASKS023DataRecord.residentsLivingInMedicalAndCareEstablishmentsOtherOther
        // += getResidentsLivingInMedicalAndCareEstablishmentsOtherOther();
        // newCASKS023DataRecord.residentsLivingInOtherEstablishments +=
        // getResidentsLivingInOtherEstablishments();
        // newCASKS023DataRecord.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments
        // +=
        // getResidentsInCommunalEstablishmentsWithLimitingLongTermIllnessMedicalAndCareEstablishments();
        // newCASKS023DataRecord.residentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments
        // +=
        // getResidentsInCommunalEstablishmentsWithLimitingLongTermIllnessOtherEstablishments();
        return newCASKS023DataRecord;
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
        result += (2L * (long) Integer.SIZE) // 14L
                / getNumberOfBitsInByte();
        return result;
    }
}
