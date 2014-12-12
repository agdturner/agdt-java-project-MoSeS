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
//import java.io.Serializable;
import java.util.Random;
import java.util.StringTokenizer;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.projects.moses.utilities.StaticConverter;

/**
 * For representing a Househol SAR DAta Record and providing safe access to the
 * data.
 */
public class HSARDataRecord extends AbstractDataRecord {

    /**
     * A household identifier (int should be sufficient!)
     */
    protected int _HHID;
    /**
     * A person number within the household (up to 11)
     */
    protected short _PNUM;
    /**
     * A unique ID (Form of catenation of HHID and PNUM) (long should be fine!)
     */
    protected long _ID;

    /*
     * Alphabetical (Very similar to variables in the Individual SAR (which were
     * split between Individual, Employment, Family, Household and Imputed
     * variables and came ordered alphabetically). (Some of the names are
     * suffixed with "h" instead and there are additional variables and
     * ommisions). HSAR is all very intersting but it is not the
     * "one number census" that any sensible government would use it is an
     * aggregated product given to academics via wierd committees to keep them
     * quite. It is very difficult to evaluate if these data are fit for any
     * purpose whatsoever. Given the improvements in IT data security, surely we
     * can have the real census data... Now who would sanction that, er...
     * nobody, because it's politically too sensitive perhaps and loads of civil
     * service jobs would not be required and vested interests would prevent the
     * failed system from changing. Sigh! Time for a new system... Great! Yet
     * more work to do while our planet and society teeters worringly on the
     * brink of catastrophe! I guess this is not really the ideal place for a
     * rant, but nonetheless it is here...
     */
    /**
     * Accomodation type
     */
    protected short _ACCTYPE;
    /**
     * Age of respondents grouped
     */
    protected short _AGEH;
    /**
     * Use of bath/shower/toilet
     */
    protected short _BATHWC;
    /**
     * Cars/vans owned or available for use
     */
    protected short _CARSH;
    /**
     * Central heating
     */
    protected short _CENHEAT0;
    /**
     * Country of birth
     */
    protected short _COBIRT0;
    /**
     * Household density: number of residents per room
     */
    protected short _DENSITY;
    /**
     * Distance of move of migrant-banded
     */
    protected short _DISTMOV0;
    /**
     * Distance to work
     */
    protected short _DISTWRK0;
    /**
     * Economic activity
     */
    protected short _ECONACH;
    /**
     * Number of times information donated
     */
    protected short _EDISDONO;
    /**
     * Ethnic group for England and Wales
     */
    protected short _ETHEW;
    /**
     * Ever worked
     */
    protected short _EVERWORK;
    /**
     * Family number
     */
    protected short _FAMNUMB;
    /**
     * Family type
     */
    protected short _FAMTYP;
    /**
     * Family Reference Person
     */
    protected short _FRP;
    /**
     * Generation indicator
     */
    protected short _GENIND;
    /**
     * General health over last twelve months
     */
    protected short _HEALTH;
    /**
     * Household education indicator (England, Wales and Northern Ireland)
     */
    protected short _HEDIND;
    /**
     * No. of hhd donations to edit imputation system
     */
    protected boolean _HEDISDON;
    /**
     * Household employment indicator (England, Wales and Northern Ireland)
     */
    protected short _HEMPIND;
    /**
     * Household health and disability indicator (England, Wales and Northern
     * Ireland)
     */
    protected short _HHLTHIND;
    /**
     * Household housing indicator
     */
    protected short _HHSGIND;
    /**
     * Household migration indicator
     */
    protected short _HMIGIND;
    /**
     * Number of persons in household?
     */
    protected short _HNRESIDN;
    /**
     * Hours worked weekly
     */
    protected short _HOURSPW;
    /**
     * Household reference person
     */
    protected boolean _HRP;
    /**
     * Social grade of household reference person
     */
    protected short _HRSOCGRD;
    /**
     * Industry
     */
    protected short _INDSTRY0;
    /**
     * International standard classification of occupations (3 digit)
     */
    protected int _ISCO3;
    /**
     * Year last worked
     */
    protected short _LASTWORK;
    /**
     * Limiting long term illness
     */
    protected short _LLTI;
    /**
     * Lowest floor level of household living accomodation
     */
    protected short _LOWFLOR0;
    /**
     * Marital status
     */
    protected short _MARSTAH;
    /**
     * Migration indicator
     */
    protected short _MIGIND;
    /**
     * NS-SEC Socio-economic classifications
     */
    protected short _NSSEC;
    /**
     * One number census status
     */
    protected short _ONCPERIM;
    /**
     * Population base limiter
     */
    protected short _POPBASE;
    /**
     * Profesional qualification (England and Wales)
     */
    protected short _PROFQUAL;
    /**
     * Number of hours care provided per week
     */
    protected short _PROVCARE;
    /**
     * Level of highest qualifications (aged 16-74) (England, Wales and Northern
     * Ireland)
     */
    protected short _QUALVEWN;
    /**
     * Religion (England and Wales)
     */
    protected short _RELGEW;
    /**
     * Relationship to HRP
     */
    protected short _RELTOHR;
    /**
     * Rooms required
     */
    protected short _ROOMREQ;
    /**
     * Number of rooms in occupied household space
     */
    protected short _ROOMSNMH;
    /**
     * Accomodation self contained
     */
    protected boolean _SELFCONT;
    /**
     * Sex
     */
    protected boolean _SEX;
    /**
     * Standard occupational classification 2000-minor
     */
    protected int _SOCMIN;
    /**
     * Households with students away during term time
     */
    protected short _STAHUKH;
    /**
     * Student accomodation
     */
    protected short _STAPUK;
    /**
     * Schoolchild or student in full-time education
     */
    protected boolean _STUDENT;
    /**
     * Supervisor/foreman
     */
    protected short _SUPERVSR;
    /**
     * Tenure of accomodation
     */
    protected short _TENUREH;
    /**
     * Term time address of students or schoolchildren
     */
    protected short _TERMTIME;
    /**
     * Transport to work, UK (including to study Scotland)
     */
    protected short _TRANWRK0;
    /**
     * Size of workforce
     */
    protected short _WORKFORC;
    /**
     * Workplace (England, Wales and Scotland)
     */
    protected short _WRKPLCE0;

    /*
     * Imputation variables starting with Z are not used currently...
     */
    /** Creates a new HSARRecord */
    public HSARDataRecord() {
        _Init();
    }

    /**
     * Modifies HSARDataRecord by parsing line. Returns true if this line
     * parses into a valid HSARDataRecord. This is only the case if the
     * following can be determined:
     * _AGEH;
     * _SEX;
     * _HRP.
     * @param _RecordID The _RecordID that will be assigned.
     * @param line The Comma Seperated Value <code>String</code>.
     * @return 
     * @throws java.io.IOException 
     */
    public boolean parse(
            long _RecordID,
            String line)
            throws IOException {
        String csvline = line.replace('\t', ',');
        String[] fields = csvline.split(",");
//        if (fields.length != 60) {
//            return false;
//        }
        this._AGEH = StaticConverter.to_short(fields[4]);
        if (_AGEH == -9) {
            return false;
        }
        if (fields[49].equalsIgnoreCase("1")) {
            this._SEX = true;
        } else {
            if (fields[49].equalsIgnoreCase("2")) {
                this._SEX = false;
            } else {
                return false;
            }
        }
        if (fields[29].equalsIgnoreCase("1")) {
            this._HRP = true;
        } else {
            if (fields[29].equalsIgnoreCase("2")) {
                this._HRP = false;
            } else {
                return false;
            }
        }
        this._RecordID = _RecordID;
        this._HHID = Integer.valueOf(fields[0]);
        this._PNUM = StaticConverter.to_short(fields[1]);
        this._ID = StaticConverter.to_long(fields[2]);
        this._ACCTYPE = StaticConverter.to_short(fields[3]);
        this._BATHWC = StaticConverter.to_short(fields[5]);
        this._CARSH = StaticConverter.to_short(fields[6]);
        this._CENHEAT0 = StaticConverter.to_short(fields[7]);
        this._COBIRT0 = StaticConverter.to_short(fields[8]);
        this._DENSITY = StaticConverter.to_short(fields[9]);
        this._DISTMOV0 = StaticConverter.to_short(fields[10]);
        this._DISTWRK0 = StaticConverter.to_short(fields[11]);
        this._ECONACH = StaticConverter.to_short(fields[12]);
        this._EDISDONO = StaticConverter.to_short(fields[13]);
        this._ETHEW = StaticConverter.to_short(fields[14]);
        this._EVERWORK = StaticConverter.to_short(fields[15]);
        this._FAMNUMB = StaticConverter.to_short(fields[16]);
        this._FAMTYP = StaticConverter.to_short(fields[17]);
        this._FRP = StaticConverter.to_short(fields[18]);
        this._GENIND = StaticConverter.to_short(fields[19]);
        this._HEALTH = StaticConverter.to_short(fields[20]);
        this._HEDIND = StaticConverter.to_short(fields[21]);
        this._HEDISDON = StaticConverter.to_boolean(fields[22]);
        this._HEMPIND = StaticConverter.to_short(fields[23]);
        this._HHLTHIND = StaticConverter.to_short(fields[24]);
        this._HHSGIND = StaticConverter.to_short(fields[25]);
        this._HMIGIND = StaticConverter.to_short(fields[26]);
        this._HNRESIDN = StaticConverter.to_short(fields[27]);
        this._HOURSPW = StaticConverter.to_short(fields[28]);
        this._HRSOCGRD = StaticConverter.to_short(fields[30]);
        this._INDSTRY0 = StaticConverter.to_short(fields[31]);
        this._ISCO3 = Integer.valueOf(fields[32]);
        this._LASTWORK = StaticConverter.to_short(fields[33]);
        this._LLTI = StaticConverter.to_short(fields[34]);
        this._LOWFLOR0 = StaticConverter.to_short(fields[35]);
        this._MARSTAH = StaticConverter.to_short(fields[36]);
        this._MIGIND = StaticConverter.to_short(fields[37]);
        this._NSSEC = StaticConverter.to_short(fields[38]);
        this._ONCPERIM = StaticConverter.to_short(fields[39]);
        this._POPBASE = StaticConverter.to_short(fields[40]);
        this._PROFQUAL = StaticConverter.to_short(fields[41]);
        this._PROVCARE = StaticConverter.to_short(fields[42]);
        this._QUALVEWN = StaticConverter.to_short(fields[43]);
        this._RELGEW = StaticConverter.to_short(fields[44]);
        this._RELTOHR = StaticConverter.to_short(fields[45]);
        this._ROOMREQ = StaticConverter.to_short(fields[46]);
        this._ROOMSNMH = StaticConverter.to_short(fields[47]);
        this._SELFCONT = StaticConverter.to_boolean(fields[48]);
        this._SOCMIN = Integer.valueOf(fields[50]);
        this._STAHUKH = StaticConverter.to_short(fields[51]);
        this._STAPUK = StaticConverter.to_short(fields[52]);
        this._STUDENT = StaticConverter.to_boolean(fields[53]);
        this._SUPERVSR = StaticConverter.to_short(fields[54]);
        this._TERMTIME = StaticConverter.to_short(fields[56]);
        this._TRANWRK0 = StaticConverter.to_short(fields[57]);
        this._WORKFORC = StaticConverter.to_short(fields[58]);
        this._WRKPLCE0 = StaticConverter.to_short(fields[59]);
        return true;
    }

    /**
     * Creates a new HSARDataRecord
     *
     * @param RecordID
     * @param aStringTokenizer
     * @throws java.io.IOException
     */
    public HSARDataRecord(
            long RecordID,
            StringTokenizer aStringTokenizer)
            throws IOException {
        this._RecordID = RecordID;
        Integer.valueOf(aStringTokenizer.nextToken(" ")).intValue();
        this._HHID = Integer.MIN_VALUE;
        this._PNUM = Short.MIN_VALUE;
        this._ID = Long.valueOf(aStringTokenizer.nextToken(" ")).longValue();
        this._ACCTYPE = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._AGEH = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._BATHWC = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._CARSH = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._CENHEAT0 = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._COBIRT0 = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._DENSITY = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._DISTMOV0 = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._DISTWRK0 = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._ECONACH = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._EDISDONO = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._ETHEW = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._EVERWORK = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._FAMNUMB = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._FAMTYP = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._FRP = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._GENIND = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._HEALTH = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._HEDIND = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        if (Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue() == 0) {
            this._HEDISDON = true;
        } else {
            this._HEDISDON = false;
        }
        this._HEMPIND = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._HHLTHIND = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._HHSGIND = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._HMIGIND = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._HNRESIDN = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._HOURSPW = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        if (Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue() == 0) {
            this._HRP = true;
        } else {
            this._HRP = false;
        }
        this._HRSOCGRD = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._INDSTRY0 = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._ISCO3 = Integer.valueOf(aStringTokenizer.nextToken(" ")).intValue();
        this._LASTWORK = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._LLTI = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._LOWFLOR0 = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._MARSTAH = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._MIGIND = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._NSSEC = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._ONCPERIM = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._POPBASE = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._PROFQUAL = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._PROVCARE = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._QUALVEWN = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._RELGEW = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._RELTOHR = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._ROOMREQ = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._ROOMSNMH = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        if (Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue() == 0) {
            this._SELFCONT = true;
        } else {
            this._SELFCONT = false;
        }
        if (Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue() == 0) {
            this._SEX = true;
        } else {
            this._SEX = false;
        }
        this._SOCMIN = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._STAHUKH = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._STAPUK = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        if (Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue() == 0) {
            this._STUDENT = true;
        } else {
            this._STUDENT = false;
        }
        this._SUPERVSR = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._TENUREH = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._TERMTIME = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._TRANWRK0 = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._WORKFORC = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
        this._WRKPLCE0 = Short.valueOf(aStringTokenizer.nextToken(" ")).shortValue();
    }

    /** Creates a new HSARRecord
     * @param aRandomAccessFile */
    public HSARDataRecord(RandomAccessFile aRandomAccessFile) {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this._ID = aRandomAccessFile.readLong();
            this._HHID = aRandomAccessFile.readInt();
            this._ISCO3 = aRandomAccessFile.readInt();
            this._SOCMIN = aRandomAccessFile.readInt();
            this._HEDISDON = aRandomAccessFile.readBoolean();
            this._HRP = aRandomAccessFile.readBoolean();
            this._SELFCONT = aRandomAccessFile.readBoolean();
            this._SEX = aRandomAccessFile.readBoolean();
            this._STUDENT = aRandomAccessFile.readBoolean();
            this._ACCTYPE = aRandomAccessFile.readShort();
            this._AGEH = aRandomAccessFile.readShort();
            this._BATHWC = aRandomAccessFile.readShort();
            this._CARSH = aRandomAccessFile.readShort();
            this._CENHEAT0 = aRandomAccessFile.readShort();
            this._COBIRT0 = aRandomAccessFile.readShort();
            this._DENSITY = aRandomAccessFile.readShort();
            this._DISTMOV0 = aRandomAccessFile.readShort();
            this._DISTWRK0 = aRandomAccessFile.readShort();
            this._ECONACH = aRandomAccessFile.readShort();
            this._EDISDONO = aRandomAccessFile.readShort();
            this._ETHEW = aRandomAccessFile.readShort();
            this._EVERWORK = aRandomAccessFile.readShort();
            this._FAMNUMB = aRandomAccessFile.readShort();
            this._FAMTYP = aRandomAccessFile.readShort();
            this._FRP = aRandomAccessFile.readShort();
            this._GENIND = aRandomAccessFile.readShort();
            this._HEALTH = aRandomAccessFile.readShort();
            this._HEDIND = aRandomAccessFile.readShort();
            this._HEMPIND = aRandomAccessFile.readShort();
            this._HHLTHIND = aRandomAccessFile.readShort();
            this._HHSGIND = aRandomAccessFile.readShort();
            this._HMIGIND = aRandomAccessFile.readShort();
            this._HNRESIDN = aRandomAccessFile.readShort();
            this._HOURSPW = aRandomAccessFile.readShort();
            this._HRSOCGRD = aRandomAccessFile.readShort();
            this._INDSTRY0 = aRandomAccessFile.readShort();
            this._LASTWORK = aRandomAccessFile.readShort();
            this._LLTI = aRandomAccessFile.readShort();
            this._LOWFLOR0 = aRandomAccessFile.readShort();
            this._MARSTAH = aRandomAccessFile.readShort();
            this._MIGIND = aRandomAccessFile.readShort();
            this._NSSEC = aRandomAccessFile.readShort();
            this._ONCPERIM = aRandomAccessFile.readShort();
            this._PNUM = aRandomAccessFile.readShort();
            this._POPBASE = aRandomAccessFile.readShort();
            this._PROFQUAL = aRandomAccessFile.readShort();
            this._PROVCARE = aRandomAccessFile.readShort();
            this._QUALVEWN = aRandomAccessFile.readShort();
            this._RELGEW = aRandomAccessFile.readShort();
            this._RELTOHR = aRandomAccessFile.readShort();
            this._ROOMREQ = aRandomAccessFile.readShort();
            this._ROOMSNMH = aRandomAccessFile.readShort();
            this._STAHUKH = aRandomAccessFile.readShort();
            this._STAPUK = aRandomAccessFile.readShort();
            this._SUPERVSR = aRandomAccessFile.readShort();
            this._TENUREH = aRandomAccessFile.readShort();
            this._TERMTIME = aRandomAccessFile.readShort();
            this._TRANWRK0 = aRandomAccessFile.readShort();
            this._WORKFORC = aRandomAccessFile.readShort();
            this._WRKPLCE0 = aRandomAccessFile.readShort();
        } catch (IOException ioe0) {
            ioe0.printStackTrace();
        }
    }

    /**
     * Initialises.
     */
    @Override
    protected void _Init() {
        super._Init();
        this._ID = Long.MIN_VALUE;
        this._HHID = Integer.MIN_VALUE;
        this._ISCO3 = Integer.MIN_VALUE;
        this._SOCMIN = Integer.MIN_VALUE;
        this._HEDISDON = false;
        this._HRP = false;
        this._SELFCONT = false;
        this._SEX = false;
        this._STUDENT = false;
        this._ACCTYPE = Short.MIN_VALUE;
        this._AGEH = Short.MIN_VALUE;
        this._BATHWC = Short.MIN_VALUE;
        this._CARSH = Short.MIN_VALUE;
        this._CENHEAT0 = Short.MIN_VALUE;
        this._COBIRT0 = Short.MIN_VALUE;
        this._DENSITY = Short.MIN_VALUE;
        this._DISTMOV0 = Short.MIN_VALUE;
        this._DISTWRK0 = Short.MIN_VALUE;
        this._ECONACH = Short.MIN_VALUE;
        this._EDISDONO = Short.MIN_VALUE;
        this._ETHEW = Short.MIN_VALUE;
        this._EVERWORK = Short.MIN_VALUE;
        this._FAMNUMB = Short.MIN_VALUE;
        this._FAMTYP = Short.MIN_VALUE;
        this._FRP = Short.MIN_VALUE;
        this._GENIND = Short.MIN_VALUE;
        this._HEALTH = Short.MIN_VALUE;
        this._HEDIND = Short.MIN_VALUE;
        this._HEMPIND = Short.MIN_VALUE;
        this._HHLTHIND = Short.MIN_VALUE;
        this._HHSGIND = Short.MIN_VALUE;
        this._HMIGIND = Short.MIN_VALUE;
        this._HOURSPW = Short.MIN_VALUE;
        this._HRSOCGRD = Short.MIN_VALUE;
        this._INDSTRY0 = Short.MIN_VALUE;
        this._LASTWORK = Short.MIN_VALUE;
        this._LLTI = Short.MIN_VALUE;
        this._LOWFLOR0 = Short.MIN_VALUE;
        this._MARSTAH = Short.MIN_VALUE;
        this._MIGIND = Short.MIN_VALUE;
        this._NSSEC = Short.MIN_VALUE;
        this._ONCPERIM = Short.MIN_VALUE;
        this._PNUM = Short.MIN_VALUE;
        this._POPBASE = Short.MIN_VALUE;
        this._PROFQUAL = Short.MIN_VALUE;
        this._PROVCARE = Short.MIN_VALUE;
        this._QUALVEWN = Short.MIN_VALUE;
        this._RELGEW = Short.MIN_VALUE;
        this._RELTOHR = Short.MIN_VALUE;
        this._ROOMREQ = Short.MIN_VALUE;
        this._ROOMSNMH = Short.MIN_VALUE;
        this._STAHUKH = Short.MIN_VALUE;
        this._STAPUK = Short.MIN_VALUE;
        this._SUPERVSR = Short.MIN_VALUE;
        this._TENUREH = Short.MIN_VALUE;
        this._TERMTIME = Short.MIN_VALUE;
        this._TRANWRK0 = Short.MIN_VALUE;
        this._WORKFORC = Short.MIN_VALUE;
        this._WRKPLCE0 = Short.MIN_VALUE;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        return super.toString() +
                ",_ID " + _ID +
                ",_HHID " + _HHID +
                ",_ISCO3 " + _ISCO3 +
                ",_SOCMIN " + _SOCMIN +
                ",_HEDISDON " + _HEDISDON +
                ",_HRP " + _HRP +
                ",_SELFCONT " + _SELFCONT +
                ",_SEX " + _SEX +
                ",_STUDENT " + _STUDENT +
                ",_ACCTYPE " + _ACCTYPE +
                ",_AGEH " + _AGEH +
                ",_BATHWC " + _BATHWC +
                ",_CARSH " + _CARSH +
                ",_CENHEAT0 " + _CENHEAT0 +
                ",_COBIRT0 " + _COBIRT0 +
                ",_DENSITY " + _DENSITY +
                ",_DISTMOV0 " + _DISTMOV0 +
                ",_DISTWRK0 " + _DISTWRK0 +
                ",_ECONACH " + _ECONACH +
                ",_EDISDONO " + _EDISDONO +
                ",_ETHEW " + _ETHEW +
                ",_EVERWORK " + _EVERWORK +
                ",_FAMNUMB " + _FAMNUMB +
                ",_FAMTYP " + _FAMTYP +
                ",_FRP " + _FRP +
                ",_GENIND " + _GENIND +
                ",_HEALTH " + _HEALTH +
                ",_HEDIND " + _HEDIND +
                ",_HEMPIND " + _HEMPIND +
                ",_HHLTHIND " + _HHLTHIND +
                ",_HHSGIND " + _HHSGIND +
                ",_HMIGIND " + _HMIGIND +
                ",_HNRESIDN " + _HNRESIDN +
                ",_HOURSPW " + _HOURSPW +
                ",_HRSOCGRD " + _HRSOCGRD +
                ",_INDSTRY0 " + _INDSTRY0 +
                ",_LASTWORK " + _LASTWORK +
                ",_LLTI " + _LLTI +
                ",_LOWFLOR0 " + _LOWFLOR0 +
                ",_MARSTAH " + _MARSTAH +
                ",_MIGIND " + _MIGIND +
                ",_NSSEC " + _NSSEC +
                ",_ONCPERIM " + _ONCPERIM +
                ",_PNUM " + _PNUM +
                ",_POPBASE " + _POPBASE +
                ",_PROFQUAL " + _PROFQUAL +
                ",_PROVCARE " + _PROVCARE +
                ",_QUALVEWN " + _QUALVEWN +
                ",_RELGEW " + _RELGEW +
                ",_RELTOHR " + _RELTOHR +
                ",_ROOMREQ " + _ROOMREQ +
                ",_ROOMSNMH " + _ROOMSNMH +
                ",_STAHUKH " + _STAHUKH +
                ",_STAPUK " + _STAPUK +
                ",_SUPERVSR " + _SUPERVSR +
                ",_TENUREH " + _TENUREH +
                ",_TERMTIME " + _TERMTIME +
                ",_TRANWRK0 " + _TRANWRK0 +
                ",_WORKFORC " + _WORKFORC +
                ",_WRKPLCE0 " + _WRKPLCE0;
    }

    /**
     * Returns a copy of this._ID
     * @return 
     */
    public long get_ID() {
        return this._ID;
    }

    /**
     * Returns a copy of this._HHID
     * @return 
     */
    public int get_HHID() {
        return this._HHID;
    }

    /**
     * Returns a copy of this._ISCO3
     * @return 
     */
    public int get_ISCO3() {
        return this._ISCO3;
    }

    /**
     * Returns a copy of this._SOCMIN
     * @return 
     */
    public int get_SOCMIN() {
        return this._SOCMIN;
    }

    /**
     * Returns a copy of this._HEDISDON
     * @return 
     */
    public boolean get_HEDISDON() {
        return this._HEDISDON;
    }

    /**
     * Returns a copy of this._HEMPIND
     * @return 
     */
    public short get_HEMPIND() {
        return this._HEMPIND;
    }

    /**
     * Returns a copy of this._HRP
     * @return 
     */
    public boolean get_HRP() {
        return this._HRP;
    }

    /**
     * Returns a copy of this._SELFCONT
     * @return 
     */
    public boolean get_SELFCONT() {
        return this._SELFCONT;
    }

    /**
     * Returns a copy of this._SEX
     * @return 
     */
    public boolean get_SEX() {
        return this._SEX;
    }

    /**
     * Returns a copy of this._STUDENT
     * @return 
     */
    public boolean get_STUDENT() {
        return this._STUDENT;
    }

    /**
     * Returns a copy of this._ACCTYPE
     * @return 
     */
    public short get_ACCTYPE() {
        return this._ACCTYPE;
    }

    /**
     * Returns a copy of this.AGEH
     * @return 
     */
    public short get_AGEH() {
        return this._AGEH;
    }

    /**
     * Returns a copy of this.BATHWC
     * @return 
     */
    public short get_BATHWC() {
        return this._BATHWC;
    }

    /**
     * Returns a copy of this._CARSH
     * @return 
     */
    public short get_CARSH() {
        return this._CARSH;
    }

    /**
     * Returns a copy of this._CENHEAT0
     * @return 
     */
    public short get_CENHEAT0() {
        return this._CENHEAT0;
    }

    /**
     * Returns a copy of this._COBIRT0
     * @return 
     */
    public short get_COBIRT0() {
        return this._COBIRT0;
    }

    /**
     * Returns a copy of this._DENSITY
     * @return 
     */
    public short get_DENSITY() {
        return this._DENSITY;
    }

    /**
     * Returns a copy of this._DISTMOV0
     * @return 
     */
    public short get_DISTMOV0() {
        return this._DISTMOV0;
    }

    /**
     * Returns a copy of this._DISTWRK0
     * @return 
     */
    public short get_DISTWRK0() {
        return this._DISTWRK0;
    }

    /**
     * Returns a copy of this._ECONACH
     * @return 
     */
    public short get_ECONACH() {
        return this._ECONACH;
    }

    /**
     * Returns a copy of this._EDISDONO
     * @return 
     */
    public short get_EDISDONO() {
        return this._EDISDONO;
    }

    /**
     * Returns a copy of this._ETHEW
     * @return 
     */
    public short get_ETHEW() {
        return this._ETHEW;
    }

    /**
     * Returns a copy of this._EVERWORK
     * @return 
     */
    public short get_EVERWORK() {
        return this._EVERWORK;
    }

    /**
     * Returns a copy of this._FAMNUMB
     * @return 
     */
    public short get_FAMNUMB() {
        return this._FAMNUMB;
    }

    /**
     * Returns a copy of this._FAMTYP
     * @return 
     */
    public short get_FAMTYP() {
        return this._FAMTYP;
    }

    /**
     * Returns a copy of this._FRP
     * @return 
     */
    public short get_FRP() {
        return this._FRP;
    }

    /**
     * Returns a copy of this._GENIND
     * @return 
     */
    public short get_GENIND() {
        return this._GENIND;
    }

    /**
     * Returns a copy of this._HEALTH
     * @return 
     */
    public short get_HEALTH() {
        return this._HEALTH;
    }

    /**
     * Returns a copy of this._HEDIND
     * @return 
     */
    public short get_HEDIND() {
        return this._HEDIND;
    }

    /**
     * Returns a copy of this._HHLTHIND
     * @return 
     */
    public short get_HHLTHIND() {
        return this._HHLTHIND;
    }

    /**
     * Returns a copy of this._HHSGIND
     * @return 
     */
    public short get_HHSGIND() {
        return this._HHSGIND;
    }

    /**
     * Returns a copy of this._HMIGIND
     * @return 
     */
    public short get_HMIGIND() {
        return this._HMIGIND;
    }

    /**
     * Returns a copy of this._HNRESIDN
     * @return 
     */
    public short get_HNRESIDN() {
        return this._HNRESIDN;
    }

    /**
     * Returns a copy of this._HOURSPW
     * @return 
     */
    public short get_HOURSPW() {
        return this._HOURSPW;
    }

    /**
     * Returns a copy of this._HRSOCGRD
     * @return 
     */
    public short get_HRSOCGRD() {
        return this._HRSOCGRD;
    }

    /**
     * Returns a copy of this._INDSTRY0
     * @return 
     */
    public short get_INDSTRY0() {
        return this._INDSTRY0;
    }

    /**
     * Returns a copy of this._LASTWORK
     * @return 
     */
    public short get_LASTWORK() {
        return this._LASTWORK;
    }

    /**
     * Returns a copy of this._LLTI
     * @return 
     */
    public short get_LLTI() {
        return this._LLTI;
    }

    /**
     * Returns a copy of this._LOWFLOR0
     * @return 
     */
    public short get_LOWFLOR0() {
        return this._LOWFLOR0;
    }

    /**
     * Returns a copy of this._MARSTAH
     * @return 
     */
    public short get_MARSTAH() {
        return this._MARSTAH;
    }

    /**
     * Returns a copy of this._MIGIND
     * @return 
     */
    public short get_MIGIND() {
        return this._MIGIND;
    }

    /**
     * Returns a copy of this._NSSEC
     * @return 
     */
    public short get_NSSEC() {
        return this._NSSEC;
    }

    /**
     * Returns a copy of this._ONCPERIM
     * @return 
     */
    public short get_ONCPERIM() {
        return this._ONCPERIM;
    }

    /**
     * Returns a copy of this._PNUM
     * @return 
     */
    public short get_PNUM() {
        return this._PNUM;
    }

    /**
     * Returns a copy of this._POPBASE
     * @return 
     */
    public short get_POPBASE() {
        return this._POPBASE;
    }

    /**
     * Returns a copy of this._PROFQUAL
     * @return 
     */
    public short get_PROFQUAL() {
        return this._PROFQUAL;
    }

    /**
     * Returns a copy of this._PROVCARE
     * @return 
     */
    public short get_PROVCARE() {
        return this._PROVCARE;
    }

    /**
     * Returns a copy of this._QUALVEWN
     * @return 
     */
    public short get_QUALVEWN() {
        return this._QUALVEWN;
    }

    /**
     * Returns a copy of this._RELGEW
     * @return 
     */
    public short get_RELGEW() {
        return this._RELGEW;
    }

    /**
     * Returns a copy of this._RELTOHR
     * @return 
     */
    public short get_RELTOHR() {
        return this._RELTOHR;
    }

    /**
     * Returns a copy of this._ROOMREQ
     * @return 
     */
    public short get_ROOMREQ() {
        return this._ROOMREQ;
    }

    /**
     * Returns a copy of this._ROOMSNMH
     * @return 
     */
    public short get_ROOMSNMH() {
        return this._ROOMSNMH;
    }

    /**
     * Returns a copy of this._STAPUK
     * @return 
     */
    public short get_STAPUK() {
        return this._STAPUK;
    }

    /**
     * Returns a copy of this._STAHUKH
     * @return 
     */
    public short get_STAHUKH() {
        return this._STAHUKH;
    }

    /**
     * Returns a copy of this._SUPERVSR
     * @return 
     */
    public short get_SUPERVSR() {
        return this._SUPERVSR;
    }

    /**
     * Returns a copy of this._TENUREH
     * @return 
     */
    public short get_TENUREH() {
        return this._TENUREH;
    }

    /**
     * Returns a copy of this._TERMTIME
     * @return 
     */
    public short get_TERMTIME() {
        return this._TERMTIME;
    }

    /**
     * Returns a copy of this._TRANWRK0
     * @return 
     */
    public short get_TRANWRK0() {
        return this._TRANWRK0;
    }

    /**
     * Returns a copy of this.WORKFORC
     * @return 
     */
    public short get_WORKFORC() {
        return this._WORKFORC;
    }

    /**
     * Returns a copy of this._WRKPLCE0
     * @return 
     */
    public short get_WRKPLCE0() {
        return this._WRKPLCE0;
    }

    /**
     * AGE0 is banded as follows: For ( 0 <= AGE0 <= 15 ) or ( 75 <= AGE0 <= 94
     * ) AGE0 represent household years of age. For AGE0 = 16, ( 16 <= age <= 20
     * ). Age range = 4. For AGE0 = 20, ( 20 <= age <= 24 ). Age range = 4. For
     * AGE0 = 25, ( 25 <= age <= 29 ). Age range = 4. For AGE0 = 30, ( 30 <= age
     * <= 44 ). Age range = 14. For AGE0 = 45, ( 45 <= age <= 59 ). Age range =
     * 14. For AGE0 = 60, ( 60 <= age <= 64 ). Age range = 4. For AGE0 = 65, (
     * 65 <= age <= 69 ). Age range = 4. For AGE0 = 70, ( 70 <= age <= 74 ). Age
     * range = 4. For AGE0 = 95, ( 95 <= age ). For any banded age a random
     * number between 0 and Age range is obtained and added to AGE0. It is
     * assumed that the for the open ended age the Age range is 4, i.e. people
     * are less than 100 years old!
     * @return 
     */
    public int getAgeInt() {
        short AGE0 = this._AGEH;
        if ((0 <= AGE0 && AGE0 <= 15) || (75 <= AGE0 && AGE0 <= 94)) {
            return AGE0;
        } else {
            Random random = new Random();
            if (AGE0 == 45 || AGE0 == 30) {
                return AGE0 + random.nextInt(14);
            } else {
                return AGE0 + random.nextInt(4);
            }
        }
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
        try {
            super.write(aRandomAccessFile);
            aRandomAccessFile.writeLong(_ID);
            aRandomAccessFile.writeInt(_HHID);
            aRandomAccessFile.writeInt(_ISCO3);
            aRandomAccessFile.writeInt(_SOCMIN);
            aRandomAccessFile.writeBoolean(_HEDISDON);
            aRandomAccessFile.writeBoolean(_HRP);
            aRandomAccessFile.writeBoolean(_SELFCONT);
            aRandomAccessFile.writeBoolean(_SEX);
            aRandomAccessFile.writeBoolean(_STUDENT);
            aRandomAccessFile.writeShort(_ACCTYPE);
            aRandomAccessFile.writeShort(_AGEH);
            aRandomAccessFile.writeShort(_BATHWC);
            aRandomAccessFile.writeShort(_CARSH);
            aRandomAccessFile.writeShort(_CENHEAT0);
            aRandomAccessFile.writeShort(_COBIRT0);
            aRandomAccessFile.writeShort(_DENSITY);
            aRandomAccessFile.writeShort(_DISTMOV0);
            aRandomAccessFile.writeShort(_DISTWRK0);
            aRandomAccessFile.writeShort(_ECONACH);
            aRandomAccessFile.writeShort(_EDISDONO);
            aRandomAccessFile.writeShort(_ETHEW);
            aRandomAccessFile.writeShort(_EVERWORK);
            aRandomAccessFile.writeShort(_FAMNUMB);
            aRandomAccessFile.writeShort(_FAMTYP);
            aRandomAccessFile.writeShort(_FRP);
            aRandomAccessFile.writeShort(_GENIND);
            aRandomAccessFile.writeShort(_HEALTH);
            aRandomAccessFile.writeShort(_HEDIND);
            aRandomAccessFile.writeShort(_HEMPIND);
            aRandomAccessFile.writeShort(_HHLTHIND);
            aRandomAccessFile.writeShort(_HHSGIND);
            aRandomAccessFile.writeShort(_HMIGIND);
            aRandomAccessFile.writeShort(_HNRESIDN);
            aRandomAccessFile.writeShort(_HOURSPW);
            aRandomAccessFile.writeShort(_HRSOCGRD);
            aRandomAccessFile.writeShort(_INDSTRY0);
            aRandomAccessFile.writeShort(_LASTWORK);
            aRandomAccessFile.writeShort(_LLTI);
            aRandomAccessFile.writeShort(_LOWFLOR0);
            aRandomAccessFile.writeShort(_MARSTAH);
            aRandomAccessFile.writeShort(_MIGIND);
            aRandomAccessFile.writeShort(_NSSEC);
            aRandomAccessFile.writeShort(_ONCPERIM);
            aRandomAccessFile.writeShort(_PNUM);
            aRandomAccessFile.writeShort(_POPBASE);
            aRandomAccessFile.writeShort(_PROFQUAL);
            aRandomAccessFile.writeShort(_PROVCARE);
            aRandomAccessFile.writeShort(_QUALVEWN);
            aRandomAccessFile.writeShort(_RELGEW);
            aRandomAccessFile.writeShort(_RELTOHR);
            aRandomAccessFile.writeShort(_ROOMREQ);
            aRandomAccessFile.writeShort(_ROOMSNMH);
            aRandomAccessFile.writeShort(_STAHUKH);
            aRandomAccessFile.writeShort(_STAPUK);
            aRandomAccessFile.writeShort(_SUPERVSR);
            aRandomAccessFile.writeShort(_TENUREH);
            aRandomAccessFile.writeShort(_TERMTIME);
            aRandomAccessFile.writeShort(_TRANWRK0);
            aRandomAccessFile.writeShort(_WORKFORC);
            aRandomAccessFile.writeShort(_WRKPLCE0);
        } catch (IOException aIOException) {
            System.err.println(aIOException.getLocalizedMessage());
            System.exit(Generic_ErrorAndExceptionHandler.IOException);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this._ID ^ (this._ID >>> 32));
        return hash;
    }

    /**
     * Overrides equals in Object
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if ((object == null) || (object.getClass() != this.getClass())) {
            return false;
        }
        HSARDataRecord aHSARDataRecord = (HSARDataRecord) object;
        return this._RecordID == aHSARDataRecord._RecordID;
    }

    /**
     * Returns the size of record in bytes as a long
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result +=
                (((long) Long.SIZE +
                (3L * (long) Integer.SIZE) +
                (51L * (long) Short.SIZE)) / getNumberOfBitsInByte()) + 5L;
        return result;
    }
}
