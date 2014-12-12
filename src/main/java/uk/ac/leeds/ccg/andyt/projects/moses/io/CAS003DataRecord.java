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
 * A <code>class</code> for representing a CAS003 Data Record and providing safe
 * access to the data.
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
 * @see CAS003DataHandler
 */
public class CAS003DataRecord extends AbstractCASDataRecord {

    /*
     * Table CS003 Age of Household Reference Person (HRP) by Sex and Marital
     * Status (Headship): All Households NB: This table contains counts of
     * Households
     */
    /**
     * CS0030001 = allHouseholdsTotal
     */
    protected int allHouseholdsTotal;
    /**
     * CS0030002 = allHouseholdsMarried
     */
    protected int allHouseholdsMarried;
    /**
     * CS0030003 = allHouseholdsSingle
     */
    protected int allHouseholdsSingle;
    /**
     * CS0030004 = maleHRPHouseholdsTotal
     */
    protected int maleHRPHouseholdsTotal;
    /**
     * CS0030005 = maleHRPHouseholdsMarried
     */
    protected int maleHRPHouseholdsMarried;
    /**
     * CS0030006 = maleHRPHouseholdsSingle
     */
    protected int maleHRPHouseholdsSingle;
    /**
     * CS0030007 = femaleHRPHouseholdsTotal
     */
    protected int femaleHRPHouseholdsTotal;
    /**
     * CS0030008 = femaleHRPHouseholdsMarried
     */
    protected int femaleHRPHouseholdsMarried;
    /**
     * CS0030009 = femaleHRPHouseholdsSingle
     */
    protected int femaleHRPHouseholdsSingle;
    /**
     * CS0030010 = allHouseholdsAge19AndUnder
     */
    protected int allHouseholdsTotalAge19AndUnder;
    /**
     * CS0030011 = allHouseholdsMarriedAge19AndUnder
     */
    protected int allHouseholdsMarriedAge19AndUnder;
    /**
     * CS0030012 = allHouseholdsSingleAge19AndUnder
     */
    protected int allHouseholdsSingleAge19AndUnder;
    /**
     * CS0030013 = maleHRPHouseholdsTotalAge19AndUnder
     */
    protected int maleHRPHouseholdsTotalAge19AndUnder;
    /**
     * CS0030014 = maleHRPHouseholdsMarriedAge19AndUnder
     */
    protected int maleHRPHouseholdsMarriedAge19AndUnder;
    /**
     * CS0030015 = maleHRPHouseholdsSingleAge19AndUnder
     */
    protected int maleHRPHouseholdsSingleAge19AndUnder;
    /**
     * CS0030016 = femaleHRPHouseholdsTotalAge19AndUnder
     */
    protected int femaleHRPHouseholdsTotalAge19AndUnder;
    /**
     * CS0030017 = femaleHRPHouseholdsMarriedAge19AndUnder
     */
    protected int femaleHRPHouseholdsMarriedAge19AndUnder;
    /**
     * CS0030018 = femaleHRPHouseholdsSingleAge19AndUnder
     */
    protected int femaleHRPHouseholdsSingleAge19AndUnder;
    /**
     * CS0030019 = allHouseholdsAge20to24
     */
    protected int allHouseholdsTotalAge20to24;
    /**
     * CS0030020 = allHouseholdsMarriedAge20to24
     */
    protected int allHouseholdsMarriedAge20to24;
    /**
     * CS0030021 = allHouseholdsSingleAge20to24
     */
    protected int allHouseholdsSingleAge20to24;
    /**
     * CS0030022 = maleHRPHouseholdsTotalAge20to24
     */
    protected int maleHRPHouseholdsTotalAge20to24;
    /**
     * CS0030023 = maleHRPHouseholdsMarriedAge20to24
     */
    protected int maleHRPHouseholdsMarriedAge20to24;
    /**
     * CS0030024 = maleHRPHouseholdsSingleAge20to24
     */
    protected int maleHRPHouseholdsSingleAge20to24;
    /**
     * CS0030025 = femaleHRPHouseholdsTotalAge20to24
     */
    protected int femaleHRPHouseholdsTotalAge20to24;
    /**
     * CS0030026 = femaleHRPHouseholdsMarriedAge20to24
     */
    protected int femaleHRPHouseholdsMarriedAge20to24;
    /**
     * CS0030027 = femaleHRPHouseholdsSingleAge20to24
     */
    protected int femaleHRPHouseholdsSingleAge20to24;
    /**
     * CS0030028 = allHouseholdsAge25to29
     */
    protected int allHouseholdsTotalAge25to29;
    /**
     * CS0030029 = allHouseholdsMarriedAge25to29
     */
    protected int allHouseholdsMarriedAge25to29;
    /**
     * CS0030030 = allHouseholdsSingleAge25to29
     */
    protected int allHouseholdsSingleAge25to29;
    /**
     * CS0030031 = maleHRPHouseholdsTotalAge25to29
     */
    protected int maleHRPHouseholdsTotalAge25to29;
    /**
     * CS0030032 = maleHRPHouseholdsMarriedAge25to29
     */
    protected int maleHRPHouseholdsMarriedAge25to29;
    /**
     * CS0030033 = maleHRPHouseholdsSingleAge25to29
     */
    protected int maleHRPHouseholdsSingleAge25to29;
    /**
     * CS0030034 = femaleHRPHouseholdsTotalAge25to29
     */
    protected int femaleHRPHouseholdsTotalAge25to29;
    /**
     * CS0030035 = femaleHRPHouseholdsMarriedAge25to29
     */
    protected int femaleHRPHouseholdsMarriedAge25to29;
    /**
     * CS0030036 = femaleHRPHouseholdsSingleAge25to29
     */
    protected int femaleHRPHouseholdsSingleAge25to29;
    /**
     * CS0030037 For Northern Ireland CS0030037 + CS0030046 + CS0030055 For
     * England, Wales, Scotland. allHouseholdsAge30to44
     */
    protected int allHouseholdsTotalAge30to44;
    /**
     * CS0030038 For Northern Ireland CS0030038 + CS0030047 + CS0030056 For
     * England, Wales, Scotland. allHouseholdsMarriedAge30to44
     */
    protected int allHouseholdsMarriedAge30to44;
    /**
     * CS0030039 For Northern Ireland CS0030039 + CS0030048 + CS0030057 For
     * England, Wales, Scotland. allHouseholdsSingleAge30to44
     */
    protected int allHouseholdsSingleAge30to44;
    /**
     * CS0030040 For Northern Ireland CS0030040 + CS0030049 + CS0030058 For
     * England, Wales, Scotland. maleHRPHouseholdsTotalAge30to44
     */
    protected int maleHRPHouseholdsTotalAge30to44;
    /**
     * CS0030041 For Northern Ireland CS0030041 + CS0030050 + CS0030059 For
     * England, Wales, Scotland. maleHRPHouseholdsMarriedAge30to44
     */
    protected int maleHRPHouseholdsMarriedAge30to44;
    /**
     * CS0030042 For Northern Ireland CS0030042 + CS0030051 + CS0030060 For
     * England, Wales, Scotland. maleHRPHouseholdsSingleAge30to44
     */
    protected int maleHRPHouseholdsSingleAge30to44;
    /**
     * CS0030043 For Northern Ireland CS0030043 + CS0030052 + CS0030061 For
     * England, Wales, Scotland. femaleHRPHouseholdsTotalAge30to44
     */
    protected int femaleHRPHouseholdsTotalAge30to44;
    /**
     * CS0030044 For Northern Ireland CS0030044 + CS0030053 + CS0030062 For
     * England, Wales, Scotland. femaleHRPHouseholdsMarriedAge30to44
     */
    protected int femaleHRPHouseholdsMarriedAge30to44;
    /**
     * CS0030045 For Northern Ireland CS0030045 + CS0030054 + CS0030063 For
     * England, Wales, Scotland. femaleHRPHouseholdsSingleAge30to44
     */
    protected int femaleHRPHouseholdsSingleAge30to44;
    /**
     * CS0030046 For Northern Ireland CS0030064 + CS0030073 + CS0030082 For
     * England, Wales, Scotland. allHouseholdsAge45to59
     */
    protected int allHouseholdsTotalAge45to59;
    /**
     * CS0030047 For Northern Ireland CS0030065 + CS0030074 + CS0030083 For
     * England, Wales, Scotland. allHouseholdsMarriedAge45to59
     */
    protected int allHouseholdsMarriedAge45to59;
    /**
     * CS0030048 For Northern Ireland CS0030066 + CS0030075 + CS0030084 For
     * England, Wales, Scotland. allHouseholdsSingleAge45to59
     */
    protected int allHouseholdsSingleAge45to59;
    /**
     * CS0030049 For Northern Ireland CS0030067 + CS0030076 + CS0030085 For
     * England, Wales, Scotland. maleHRPHouseholdsTotalAge45to59
     */
    protected int maleHRPHouseholdsTotalAge45to59;
    /**
     * CS0030050 For Northern Ireland CS0030068 + CS0030077 + CS0030086 For
     * England, Wales, Scotland. maleHRPHouseholdsMarriedAge45to59
     */
    protected int maleHRPHouseholdsMarriedAge45to59;
    /**
     * CS0030051 For Northern Ireland CS0030069 + CS0030078 + CS0030087 For
     * England, Wales, Scotland. maleHRPHouseholdsSingleAge45to59
     */
    protected int maleHRPHouseholdsSingleAge45to59;
    /**
     * CS0030052 For Northern Ireland CS0030070 + CS0030079 + CS0030088 For
     * England, Wales, Scotland. femaleHRPHouseholdsTotalAge45to59
     */
    protected int femaleHRPHouseholdsTotalAge45to59;
    /**
     * CS0030053 For Northern Ireland CS0030071 + CS0030080 + CS0030089 For
     * England, Wales, Scotland. femaleHRPHouseholdsMarriedAge45to59
     */
    protected int femaleHRPHouseholdsMarriedAge45to59;
    /**
     * CS0030054 For Northern Ireland CS0030072 + CS0030081 + CS0030090 For
     * England, Wales, Scotland. femaleHRPHouseholdsSingleAge45to59
     */
    protected int femaleHRPHouseholdsSingleAge45to59;
    /**
     * CS0030055 For Northern Ireland. CS0030091 For England, Wales, Scotland.
     * allHouseholdsAge60to64
     */
    protected int allHouseholdsTotalAge60to64;
    /**
     * CS0030056 For Northern Ireland. CS0030092 For England, Wales, Scotland.
     * allHouseholdsMarriedAge60to64
     */
    protected int allHouseholdsMarriedAge60to64;
    /**
     * CS0030057 For Northern Ireland. CS0030093 For England, Wales, Scotland.
     * allHouseholdsSingleAge60to64
     */
    protected int allHouseholdsSingleAge60to64;
    /**
     * CS0030058 For Northern Ireland. CS0030094 For England, Wales, Scotland.
     * maleHRPHouseholdsTotalAge60to64
     */
    protected int maleHRPHouseholdsTotalAge60to64;
    /**
     * CS0030059 For Northern Ireland. CS0030095 For England, Wales, Scotland.
     * maleHRPHouseholdsMarriedAge60to64
     */
    protected int maleHRPHouseholdsMarriedAge60to64;
    /**
     * CS0030060 For Northern Ireland. CS0030096 For England, Wales, Scotland.
     * maleHRPHouseholdsSingleAge60to64
     */
    protected int maleHRPHouseholdsSingleAge60to64;
    /**
     * CS0030061 For Northern Ireland. CS0030097 For England, Wales, Scotland.
     * femaleHRPHouseholdsTotalAge60to64
     */
    protected int femaleHRPHouseholdsTotalAge60to64;
    /**
     * CS0030062 For Northern Ireland. CS0030098 For England, Wales, Scotland.
     * femaleHRPHouseholdsMarriedAge60to64
     */
    protected int femaleHRPHouseholdsMarriedAge60to64;
    /**
     * CS0030063 For Northern Ireland. CS0030099 For England, Wales, Scotland.
     * femaleHRPHouseholdsSingleAge60to64
     */
    protected int femaleHRPHouseholdsSingleAge60to64;
    /**
     * CS0030064 For Northern Ireland. CS0030100 + CS0030109 For England, Wales,
     * Scotland. allHouseholdsAge65to74
     */
    protected int allHouseholdsTotalAge65to74;
    /**
     * CS0030065 For Northern Ireland. CS0030101 + CS0030110 For England, Wales,
     * Scotland. allHouseholdsMarriedAge65to74
     */
    protected int allHouseholdsMarriedAge65to74;
    /**
     * CS0030066 For Northern Ireland. CS0030102 + CS0030111 For England, Wales,
     * Scotland. allHouseholdsSingleAge65to74
     */
    protected int allHouseholdsSingleAge65to74;
    /**
     * CS0030067 For Northern Ireland. CS0030103 + CS0030112 For England, Wales,
     * Scotland. maleHRPHouseholdsTotalAge65to74
     */
    protected int maleHRPHouseholdsTotalAge65to74;
    /**
     * CS0030068 For Northern Ireland. CS0030104 + CS0030113 For England, Wales,
     * Scotland. maleHRPHouseholdsMarriedAge65to74
     */
    protected int maleHRPHouseholdsMarriedAge65to74;
    /**
     * CS0030069 For Northern Ireland. CS0030105 + CS0030114 For England, Wales,
     * Scotland. maleHRPHouseholdsSingleAge65to74
     */
    protected int maleHRPHouseholdsSingleAge65to74;
    /**
     * CS0030070 For Northern Ireland. CS0030106 + CS0030115 For England, Wales,
     * Scotland. femaleHRPHouseholdsTotalAge65to74
     */
    protected int femaleHRPHouseholdsTotalAge65to74;
    /**
     * CS0030071 For Northern Ireland. CS0030107 + CS0030116 For England, Wales,
     * Scotland. femaleHRPHouseholdsMarriedAge65to74
     */
    protected int femaleHRPHouseholdsMarriedAge65to74;
    /**
     * CS0030072 For Northern Ireland. CS0030108 + CS0030117 For England, Wales,
     * Scotland. femaleHRPHouseholdsSingleAge65to74
     */
    protected int femaleHRPHouseholdsSingleAge65to74;
    /**
     * CS0030073 For Northern Ireland. CS0030118 + CS0030127 For England, Wales,
     * Scotland. allHouseholdsAge75to84
     */
    protected int allHouseholdsTotalAge75to84;
    /**
     * CS0030074 For Northern Ireland. CS0030119 + CS0030128 For England, Wales,
     * Scotland. allHouseholdsMarriedAge75to84
     */
    protected int allHouseholdsMarriedAge75to84;
    /**
     * CS0030075 For Northern Ireland. CS0030120 + CS0030129 For England, Wales,
     * Scotland. allHouseholdsSingleAge75to84
     */
    protected int allHouseholdsSingleAge75to84;
    /**
     * CS0030076 For Northern Ireland. CS0030121 + CS0030130 For England, Wales,
     * Scotland. maleHRPHouseholdsTotalAge75to84
     */
    protected int maleHRPHouseholdsTotalAge75to84;
    /**
     * CS0030077 For Northern Ireland. CS0030122 + CS0030131 For England, Wales,
     * Scotland. maleHRPHouseholdsMarriedAge75to84
     */
    protected int maleHRPHouseholdsMarriedAge75to84;
    /**
     * CS0030078 For Northern Ireland. CS0030123 + CS0030132 For England, Wales,
     * Scotland. maleHRPHouseholdsSingleAge75to84
     */
    protected int maleHRPHouseholdsSingleAge75to84;
    /**
     * CS0030079 For Northern Ireland. CS0030124 + CS0030133 For England, Wales,
     * Scotland. femaleHRPHouseholdsTotalAge75to84
     */
    protected int femaleHRPHouseholdsTotalAge75to84;
    /**
     * CS0030080 For Northern Ireland. CS0030125 + CS0030134 For England, Wales,
     * Scotland. femaleHRPHouseholdsMarriedAge75to84
     */
    protected int femaleHRPHouseholdsMarriedAge75to84;
    /**
     * CS0030081 For Northern Ireland. CS0030126 + CS0030135 For England, Wales,
     * Scotland. femaleHRPHouseholdsSingleAge75to84
     */
    protected int femaleHRPHouseholdsSingleAge75to84;
    /**
     * CS0030082 For Northern Ireland. CS0030136 + CS0030145 For England, Wales,
     * Scotland. allHouseholdsAge85AndOver
     */
    protected int allHouseholdsTotalAge85AndOver;
    /**
     * CS0030083 For Northern Ireland. CS0030137 + CS0030146 For England, Wales,
     * Scotland. allHouseholdsMarriedAge85AndOver
     */
    protected int allHouseholdsMarriedAge85AndOver;
    /**
     * CS0030084 For Northern Ireland. CS0030138 + CS0030147 For England, Wales,
     * Scotland. allHouseholdsSingleAge85AndOver
     */
    protected int allHouseholdsSingleAge85AndOver;
    /**
     * CS0030085 For Northern Ireland. CS0030139 + CS0030148 For England, Wales,
     * Scotland. maleHRPHouseholdsTotalAge85AndOver
     */
    protected int maleHRPHouseholdsTotalAge85AndOver;
    /**
     * CS0030086 For Northern Ireland. CS0030140 + CS0030149 For England, Wales,
     * Scotland. maleHRPHouseholdsMarriedAge85AndOver
     */
    protected int maleHRPHouseholdsMarriedAge85AndOver;
    /**
     * CS0030087 For Northern Ireland. CS0030141 + CS0030150 For England, Wales,
     * Scotland. maleHRPHouseholdsSingleAge85AndOver
     */
    protected int maleHRPHouseholdsSingleAge85AndOver;
    /**
     * CS0030088 For Northern Ireland. CS0030142 + CS0030151 For England, Wales,
     * Scotland. femaleHRPHouseholdsTotalAge85AndOver
     */
    protected int femaleHRPHouseholdsTotalAge85AndOver;
    /**
     * CS0030089 For Northern Ireland. CS0030143 + CS0030152 For England, Wales,
     * Scotland. femaleHRPHouseholdsMarriedAge85AndOver
     */
    protected int femaleHRPHouseholdsMarriedAge85AndOver;
    /**
     * CS0030090 For Northern Ireland. CS0030144 + CS0030153 For England, Wales,
     * Scotland. femaleHRPHouseholdsSingleAge85AndOver
     */
    protected int femaleHRPHouseholdsSingleAge85AndOver;

    /** Creates a new CAS003Record */
    public CAS003DataRecord() {
        _Init();
    }

    /**
     * Creates a new CAS003Record cloned from cAS003Record
     *
     * @param cAS003Record
     *            The CAS003Record from which this is cloned.
     */
    public CAS003DataRecord(CAS003DataRecord cAS003Record) {
        init(cAS003Record);
    }

    /**
     * Creates a new CAS003Record
     *
     * @param initZero
     *            To ensure initZero() is used instead of _Init()
     */
    public CAS003DataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new CAS003DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public CAS003DataRecord(long RecordID, String line) throws IOException {
        String[] fieldsDummy = line.split(",");
        // System.out.println(fieldsDummy.length);
        // for (int i = 0; i < fieldsDummy.length; i ++ ){
        // System.out.println(fieldsDummy[i]);
        // }
        String[] fields = new String[154];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = "";
        }
        System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
        this._RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table CAS003
        this.allHouseholdsTotal = StaticConverter.to_int(fields[1]);
        this.allHouseholdsMarried = StaticConverter.to_int(fields[2]);
        this.allHouseholdsSingle = StaticConverter.to_int(fields[3]);
        this.maleHRPHouseholdsTotal = StaticConverter.to_int(fields[4]);
        this.maleHRPHouseholdsMarried = StaticConverter.to_int(fields[5]);
        this.maleHRPHouseholdsSingle = StaticConverter.to_int(fields[6]);
        this.femaleHRPHouseholdsTotal = StaticConverter.to_int(fields[7]);
        this.femaleHRPHouseholdsMarried = StaticConverter.to_int(fields[8]);
        this.femaleHRPHouseholdsSingle = StaticConverter.to_int(fields[9]);
        this.allHouseholdsTotalAge19AndUnder = StaticConverter.to_int(fields[10]);
        this.allHouseholdsMarriedAge19AndUnder = StaticConverter.to_int(fields[11]);
        this.allHouseholdsSingleAge19AndUnder = StaticConverter.to_int(fields[12]);
        this.maleHRPHouseholdsTotalAge19AndUnder = StaticConverter.to_int(fields[13]);
        this.maleHRPHouseholdsMarriedAge19AndUnder = StaticConverter.to_int(fields[14]);
        this.maleHRPHouseholdsSingleAge19AndUnder = StaticConverter.to_int(fields[15]);
        this.femaleHRPHouseholdsTotalAge19AndUnder = StaticConverter.to_int(fields[16]);
        this.femaleHRPHouseholdsMarriedAge19AndUnder = StaticConverter.to_int(fields[17]);
        this.femaleHRPHouseholdsSingleAge19AndUnder = StaticConverter.to_int(fields[18]);
        this.allHouseholdsTotalAge20to24 = StaticConverter.to_int(fields[19]);
        this.allHouseholdsMarriedAge20to24 = StaticConverter.to_int(fields[20]);
        this.allHouseholdsSingleAge20to24 = StaticConverter.to_int(fields[21]);
        this.maleHRPHouseholdsTotalAge20to24 = StaticConverter.to_int(fields[22]);
        this.maleHRPHouseholdsMarriedAge20to24 = StaticConverter.to_int(fields[23]);
        this.maleHRPHouseholdsSingleAge20to24 = StaticConverter.to_int(fields[24]);
        this.femaleHRPHouseholdsTotalAge20to24 = StaticConverter.to_int(fields[25]);
        this.femaleHRPHouseholdsMarriedAge20to24 = StaticConverter.to_int(fields[26]);
        this.femaleHRPHouseholdsSingleAge20to24 = StaticConverter.to_int(fields[27]);
        this.allHouseholdsTotalAge25to29 = StaticConverter.to_int(fields[28]);
        this.allHouseholdsMarriedAge25to29 = StaticConverter.to_int(fields[29]);
        this.allHouseholdsSingleAge25to29 = StaticConverter.to_int(fields[30]);
        this.maleHRPHouseholdsTotalAge25to29 = StaticConverter.to_int(fields[31]);
        this.maleHRPHouseholdsMarriedAge25to29 = StaticConverter.to_int(fields[32]);
        this.maleHRPHouseholdsSingleAge25to29 = StaticConverter.to_int(fields[33]);
        this.femaleHRPHouseholdsTotalAge25to29 = StaticConverter.to_int(fields[34]);
        this.femaleHRPHouseholdsMarriedAge25to29 = StaticConverter.to_int(fields[35]);
        this.femaleHRPHouseholdsSingleAge25to29 = StaticConverter.to_int(fields[36]);
        this.allHouseholdsTotalAge30to44 = StaticConverter.to_int(fields[37]) + StaticConverter.to_int(fields[46]) + StaticConverter.to_int(fields[55]);
        this.allHouseholdsMarriedAge30to44 = StaticConverter.to_int(fields[38]) + StaticConverter.to_int(fields[47]) + StaticConverter.to_int(fields[56]);
        this.allHouseholdsSingleAge30to44 = StaticConverter.to_int(fields[39]) + StaticConverter.to_int(fields[48]) + StaticConverter.to_int(fields[57]);
        this.maleHRPHouseholdsTotalAge30to44 = StaticConverter.to_int(fields[40]) + StaticConverter.to_int(fields[49]) + StaticConverter.to_int(fields[58]);
        this.maleHRPHouseholdsMarriedAge30to44 = StaticConverter.to_int(fields[41]) + StaticConverter.to_int(fields[50]) + StaticConverter.to_int(fields[59]);
        this.maleHRPHouseholdsSingleAge30to44 = StaticConverter.to_int(fields[42]) + StaticConverter.to_int(fields[51]) + StaticConverter.to_int(fields[60]);
        this.femaleHRPHouseholdsTotalAge30to44 = StaticConverter.to_int(fields[43]) + StaticConverter.to_int(fields[52]) + StaticConverter.to_int(fields[61]);
        this.femaleHRPHouseholdsMarriedAge30to44 = StaticConverter.to_int(fields[44]) + StaticConverter.to_int(fields[53]) + StaticConverter.to_int(fields[62]);
        this.femaleHRPHouseholdsSingleAge30to44 = StaticConverter.to_int(fields[45]) + StaticConverter.to_int(fields[54]) + StaticConverter.to_int(fields[63]);
        this.allHouseholdsTotalAge45to59 = StaticConverter.to_int(fields[64]) + StaticConverter.to_int(fields[73]) + StaticConverter.to_int(fields[82]);
        this.allHouseholdsMarriedAge45to59 = StaticConverter.to_int(fields[65]) + StaticConverter.to_int(fields[74]) + StaticConverter.to_int(fields[83]);
        this.allHouseholdsSingleAge45to59 = StaticConverter.to_int(fields[66]) + StaticConverter.to_int(fields[75]) + StaticConverter.to_int(fields[84]);
        this.maleHRPHouseholdsTotalAge45to59 = StaticConverter.to_int(fields[67]) + StaticConverter.to_int(fields[76]) + StaticConverter.to_int(fields[85]);
        this.maleHRPHouseholdsMarriedAge45to59 = StaticConverter.to_int(fields[68]) + StaticConverter.to_int(fields[77]) + StaticConverter.to_int(fields[86]);
        this.maleHRPHouseholdsSingleAge45to59 = StaticConverter.to_int(fields[69]) + StaticConverter.to_int(fields[78]) + StaticConverter.to_int(fields[87]);
        this.femaleHRPHouseholdsTotalAge45to59 = StaticConverter.to_int(fields[70]) + StaticConverter.to_int(fields[79]) + StaticConverter.to_int(fields[88]);
        this.femaleHRPHouseholdsMarriedAge45to59 = StaticConverter.to_int(fields[71]) + StaticConverter.to_int(fields[80]) + StaticConverter.to_int(fields[89]);
        this.femaleHRPHouseholdsSingleAge45to59 = StaticConverter.to_int(fields[72]) + StaticConverter.to_int(fields[81]) + StaticConverter.to_int(fields[90]);
        this.allHouseholdsTotalAge60to64 = StaticConverter.to_int(fields[91]);
        this.allHouseholdsMarriedAge60to64 = StaticConverter.to_int(fields[92]);
        this.allHouseholdsSingleAge60to64 = StaticConverter.to_int(fields[93]);
        this.maleHRPHouseholdsTotalAge60to64 = StaticConverter.to_int(fields[94]);
        this.maleHRPHouseholdsMarriedAge60to64 = StaticConverter.to_int(fields[95]);
        this.maleHRPHouseholdsSingleAge60to64 = StaticConverter.to_int(fields[96]);
        this.femaleHRPHouseholdsTotalAge60to64 = StaticConverter.to_int(fields[97]);
        this.femaleHRPHouseholdsMarriedAge60to64 = StaticConverter.to_int(fields[98]);
        this.femaleHRPHouseholdsSingleAge60to64 = StaticConverter.to_int(fields[99]);
        this.allHouseholdsTotalAge65to74 = StaticConverter.to_int(fields[100]) + StaticConverter.to_int(fields[109]);
        this.allHouseholdsMarriedAge65to74 = StaticConverter.to_int(fields[101]) + StaticConverter.to_int(fields[110]);
        this.allHouseholdsSingleAge65to74 = StaticConverter.to_int(fields[102]) + StaticConverter.to_int(fields[111]);
        this.maleHRPHouseholdsTotalAge65to74 = StaticConverter.to_int(fields[103]) + StaticConverter.to_int(fields[112]);
        this.maleHRPHouseholdsMarriedAge65to74 = StaticConverter.to_int(fields[104]) + StaticConverter.to_int(fields[113]);
        this.maleHRPHouseholdsSingleAge65to74 = StaticConverter.to_int(fields[105]) + StaticConverter.to_int(fields[114]);
        this.femaleHRPHouseholdsTotalAge65to74 = StaticConverter.to_int(fields[106]) + StaticConverter.to_int(fields[115]);
        this.femaleHRPHouseholdsMarriedAge65to74 = StaticConverter.to_int(fields[107]) + StaticConverter.to_int(fields[116]);
        this.femaleHRPHouseholdsSingleAge65to74 = StaticConverter.to_int(fields[108]) + StaticConverter.to_int(fields[117]);
        this.allHouseholdsTotalAge75to84 = StaticConverter.to_int(fields[118]) + StaticConverter.to_int(fields[127]);
        this.allHouseholdsMarriedAge75to84 = StaticConverter.to_int(fields[119]) + StaticConverter.to_int(fields[128]);
        this.allHouseholdsSingleAge75to84 = StaticConverter.to_int(fields[120]) + StaticConverter.to_int(fields[129]);
        this.maleHRPHouseholdsTotalAge75to84 = StaticConverter.to_int(fields[121]) + StaticConverter.to_int(fields[130]);
        this.maleHRPHouseholdsMarriedAge75to84 = StaticConverter.to_int(fields[122]) + StaticConverter.to_int(fields[131]);
        this.maleHRPHouseholdsSingleAge75to84 = StaticConverter.to_int(fields[123]) + StaticConverter.to_int(fields[132]);
        this.femaleHRPHouseholdsTotalAge75to84 = StaticConverter.to_int(fields[124]) + StaticConverter.to_int(fields[133]);
        this.femaleHRPHouseholdsMarriedAge75to84 = StaticConverter.to_int(fields[125]) + StaticConverter.to_int(fields[134]);
        this.femaleHRPHouseholdsSingleAge75to84 = StaticConverter.to_int(fields[126]) + StaticConverter.to_int(fields[135]);
        this.allHouseholdsTotalAge85AndOver = StaticConverter.to_int(fields[136]) + StaticConverter.to_int(fields[145]);
        this.allHouseholdsMarriedAge85AndOver = StaticConverter.to_int(fields[137]) + StaticConverter.to_int(fields[146]);
        this.allHouseholdsSingleAge85AndOver = StaticConverter.to_int(fields[138]) + StaticConverter.to_int(fields[147]);
        this.maleHRPHouseholdsTotalAge85AndOver = StaticConverter.to_int(fields[139]) + StaticConverter.to_int(fields[148]);
        this.maleHRPHouseholdsMarriedAge85AndOver = StaticConverter.to_int(fields[140]) + StaticConverter.to_int(fields[149]);
        this.maleHRPHouseholdsSingleAge85AndOver = StaticConverter.to_int(fields[141]) + StaticConverter.to_int(fields[150]);
        this.femaleHRPHouseholdsTotalAge85AndOver = StaticConverter.to_int(fields[142]) + StaticConverter.to_int(fields[151]);
        this.femaleHRPHouseholdsMarriedAge85AndOver = StaticConverter.to_int(fields[143]) + StaticConverter.to_int(fields[152]);
        this.femaleHRPHouseholdsSingleAge85AndOver = StaticConverter.to_int(fields[144]) + StaticConverter.to_int(fields[153]);
    }

    /**
     * Creates a new CAS003DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @param NorthernIreland
     * @throws java.io.IOException
     */
    public CAS003DataRecord(long RecordID, String line, boolean NorthernIreland)
            throws IOException {
        String[] fieldsDummy = line.split(",");
        // System.out.println(fieldsDummy.length);
        // for (int i = 0; i < fieldsDummy.length; i ++ ){
        // System.out.println(fieldsDummy[i]);
        // }
        String[] fields = new String[91];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = "";
        }
        System.arraycopy(fieldsDummy, 0, fields, 0, fields.length);
        this._RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table CAS003
        this.allHouseholdsTotal = StaticConverter.to_int(fields[1]);
        this.allHouseholdsMarried = StaticConverter.to_int(fields[2]);
        this.allHouseholdsSingle = StaticConverter.to_int(fields[3]);
        this.maleHRPHouseholdsTotal = StaticConverter.to_int(fields[4]);
        this.maleHRPHouseholdsMarried = StaticConverter.to_int(fields[5]);
        this.maleHRPHouseholdsSingle = StaticConverter.to_int(fields[6]);
        this.femaleHRPHouseholdsTotal = StaticConverter.to_int(fields[7]);
        this.femaleHRPHouseholdsMarried = StaticConverter.to_int(fields[8]);
        this.femaleHRPHouseholdsSingle = StaticConverter.to_int(fields[9]);
        this.allHouseholdsTotalAge19AndUnder = StaticConverter.to_int(fields[10]);
        this.allHouseholdsMarriedAge19AndUnder = StaticConverter.to_int(fields[11]);
        this.allHouseholdsSingleAge19AndUnder = StaticConverter.to_int(fields[12]);
        this.maleHRPHouseholdsTotalAge19AndUnder = StaticConverter.to_int(fields[13]);
        this.maleHRPHouseholdsMarriedAge19AndUnder = StaticConverter.to_int(fields[14]);
        this.maleHRPHouseholdsSingleAge19AndUnder = StaticConverter.to_int(fields[15]);
        this.femaleHRPHouseholdsTotalAge19AndUnder = StaticConverter.to_int(fields[16]);
        this.femaleHRPHouseholdsMarriedAge19AndUnder = StaticConverter.to_int(fields[17]);
        this.femaleHRPHouseholdsSingleAge19AndUnder = StaticConverter.to_int(fields[18]);
        this.allHouseholdsTotalAge20to24 = StaticConverter.to_int(fields[19]);
        this.allHouseholdsMarriedAge20to24 = StaticConverter.to_int(fields[20]);
        this.allHouseholdsSingleAge20to24 = StaticConverter.to_int(fields[21]);
        this.maleHRPHouseholdsTotalAge20to24 = StaticConverter.to_int(fields[22]);
        this.maleHRPHouseholdsMarriedAge20to24 = StaticConverter.to_int(fields[23]);
        this.maleHRPHouseholdsSingleAge20to24 = StaticConverter.to_int(fields[24]);
        this.femaleHRPHouseholdsTotalAge20to24 = StaticConverter.to_int(fields[25]);
        this.femaleHRPHouseholdsMarriedAge20to24 = StaticConverter.to_int(fields[26]);
        this.femaleHRPHouseholdsSingleAge20to24 = StaticConverter.to_int(fields[27]);
        this.allHouseholdsTotalAge25to29 = StaticConverter.to_int(fields[28]);
        this.allHouseholdsMarriedAge25to29 = StaticConverter.to_int(fields[29]);
        this.allHouseholdsSingleAge25to29 = StaticConverter.to_int(fields[30]);
        this.maleHRPHouseholdsTotalAge25to29 = StaticConverter.to_int(fields[31]);
        this.maleHRPHouseholdsMarriedAge25to29 = StaticConverter.to_int(fields[32]);
        this.maleHRPHouseholdsSingleAge25to29 = StaticConverter.to_int(fields[33]);
        this.femaleHRPHouseholdsTotalAge25to29 = StaticConverter.to_int(fields[34]);
        this.femaleHRPHouseholdsMarriedAge25to29 = StaticConverter.to_int(fields[35]);
        this.femaleHRPHouseholdsSingleAge25to29 = StaticConverter.to_int(fields[36]);
        this.allHouseholdsTotalAge30to44 = StaticConverter.to_int(fields[37]);
        this.allHouseholdsMarriedAge30to44 = StaticConverter.to_int(fields[38]);
        this.allHouseholdsSingleAge30to44 = StaticConverter.to_int(fields[39]);
        this.maleHRPHouseholdsTotalAge30to44 = StaticConverter.to_int(fields[40]);
        this.maleHRPHouseholdsMarriedAge30to44 = StaticConverter.to_int(fields[41]);
        this.maleHRPHouseholdsSingleAge30to44 = StaticConverter.to_int(fields[42]);
        this.femaleHRPHouseholdsTotalAge30to44 = StaticConverter.to_int(fields[43]);
        this.femaleHRPHouseholdsMarriedAge30to44 = StaticConverter.to_int(fields[44]);
        this.femaleHRPHouseholdsSingleAge30to44 = StaticConverter.to_int(fields[45]);
        this.allHouseholdsTotalAge45to59 = StaticConverter.to_int(fields[46]);
        this.allHouseholdsMarriedAge45to59 = StaticConverter.to_int(fields[47]);
        this.allHouseholdsSingleAge45to59 = StaticConverter.to_int(fields[48]);
        this.maleHRPHouseholdsTotalAge45to59 = StaticConverter.to_int(fields[49]);
        this.maleHRPHouseholdsMarriedAge45to59 = StaticConverter.to_int(fields[50]);
        this.maleHRPHouseholdsSingleAge45to59 = StaticConverter.to_int(fields[51]);
        this.femaleHRPHouseholdsTotalAge45to59 = StaticConverter.to_int(fields[52]);
        this.femaleHRPHouseholdsMarriedAge45to59 = StaticConverter.to_int(fields[53]);
        this.femaleHRPHouseholdsSingleAge45to59 = StaticConverter.to_int(fields[54]);
        this.allHouseholdsTotalAge60to64 = StaticConverter.to_int(fields[55]);
        this.allHouseholdsMarriedAge60to64 = StaticConverter.to_int(fields[56]);
        this.allHouseholdsSingleAge60to64 = StaticConverter.to_int(fields[57]);
        this.maleHRPHouseholdsTotalAge60to64 = StaticConverter.to_int(fields[58]);
        this.maleHRPHouseholdsMarriedAge60to64 = StaticConverter.to_int(fields[59]);
        this.maleHRPHouseholdsSingleAge60to64 = StaticConverter.to_int(fields[60]);
        this.femaleHRPHouseholdsTotalAge60to64 = StaticConverter.to_int(fields[61]);
        this.femaleHRPHouseholdsMarriedAge60to64 = StaticConverter.to_int(fields[62]);
        this.femaleHRPHouseholdsSingleAge60to64 = StaticConverter.to_int(fields[63]);
        this.allHouseholdsTotalAge65to74 = StaticConverter.to_int(fields[64]);
        this.allHouseholdsMarriedAge65to74 = StaticConverter.to_int(fields[65]);
        this.allHouseholdsSingleAge65to74 = StaticConverter.to_int(fields[66]);
        this.maleHRPHouseholdsTotalAge65to74 = StaticConverter.to_int(fields[67]);
        this.maleHRPHouseholdsMarriedAge65to74 = StaticConverter.to_int(fields[68]);
        this.maleHRPHouseholdsSingleAge65to74 = StaticConverter.to_int(fields[69]);
        this.femaleHRPHouseholdsTotalAge65to74 = StaticConverter.to_int(fields[70]);
        this.femaleHRPHouseholdsMarriedAge65to74 = StaticConverter.to_int(fields[71]);
        this.femaleHRPHouseholdsSingleAge65to74 = StaticConverter.to_int(fields[72]);
        this.allHouseholdsTotalAge75to84 = StaticConverter.to_int(fields[73]);
        this.allHouseholdsMarriedAge75to84 = StaticConverter.to_int(fields[74]);
        this.allHouseholdsSingleAge75to84 = StaticConverter.to_int(fields[75]);
        this.maleHRPHouseholdsTotalAge75to84 = StaticConverter.to_int(fields[76]);
        this.maleHRPHouseholdsMarriedAge75to84 = StaticConverter.to_int(fields[77]);
        this.maleHRPHouseholdsSingleAge75to84 = StaticConverter.to_int(fields[78]);
        this.femaleHRPHouseholdsTotalAge75to84 = StaticConverter.to_int(fields[79]);
        this.femaleHRPHouseholdsMarriedAge75to84 = StaticConverter.to_int(fields[80]);
        this.femaleHRPHouseholdsSingleAge75to84 = StaticConverter.to_int(fields[81]);
        this.allHouseholdsTotalAge85AndOver = StaticConverter.to_int(fields[82]);
        this.allHouseholdsMarriedAge85AndOver = StaticConverter.to_int(fields[83]);
        this.allHouseholdsSingleAge85AndOver = StaticConverter.to_int(fields[84]);
        this.maleHRPHouseholdsTotalAge85AndOver = StaticConverter.to_int(fields[85]);
        this.maleHRPHouseholdsMarriedAge85AndOver = StaticConverter.to_int(fields[86]);
        this.maleHRPHouseholdsSingleAge85AndOver = StaticConverter.to_int(fields[87]);
        this.femaleHRPHouseholdsTotalAge85AndOver = StaticConverter.to_int(fields[88]);
        this.femaleHRPHouseholdsMarriedAge85AndOver = StaticConverter.to_int(fields[89]);
        this.femaleHRPHouseholdsSingleAge85AndOver = StaticConverter.to_int(fields[90]);
    }

    /**
     * Creates a new <code>CAS003DataRecord</code> from
     * <code>aRandomAccessFile</code>. The
     * <code>aRandomAccessFile.getFilePointer()</code> changes only as the
     * <code>CAS003DataRecord</code> is read.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> from which this is created.
     * @throws java.io.IOException
     */
    public CAS003DataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        this._RecordID = aRandomAccessFile.readLong();
        this.Zone_Code = new char[10];
        for (int i = 0; i < this.Zone_Code.length; i++) {
            Zone_Code[i] = aRandomAccessFile.readChar();
        }
        this.allHouseholdsTotal = aRandomAccessFile.readInt();
        this.allHouseholdsMarried = aRandomAccessFile.readInt();
        this.allHouseholdsSingle = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsTotal = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsMarried = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsSingle = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsTotal = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsMarried = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsSingle = aRandomAccessFile.readInt();
        this.allHouseholdsTotalAge19AndUnder = aRandomAccessFile.readInt();
        this.allHouseholdsMarriedAge19AndUnder = aRandomAccessFile.readInt();
        this.allHouseholdsSingleAge19AndUnder = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsTotalAge19AndUnder = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsMarriedAge19AndUnder = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsSingleAge19AndUnder = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsTotalAge19AndUnder = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsMarriedAge19AndUnder = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsSingleAge19AndUnder = aRandomAccessFile.readInt();
        this.allHouseholdsTotalAge20to24 = aRandomAccessFile.readInt();
        this.allHouseholdsMarriedAge20to24 = aRandomAccessFile.readInt();
        this.allHouseholdsSingleAge20to24 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsTotalAge20to24 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsMarriedAge20to24 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsSingleAge20to24 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsTotalAge20to24 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsMarriedAge20to24 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsSingleAge20to24 = aRandomAccessFile.readInt();
        this.allHouseholdsTotalAge25to29 = aRandomAccessFile.readInt();
        this.allHouseholdsMarriedAge25to29 = aRandomAccessFile.readInt();
        this.allHouseholdsSingleAge25to29 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsTotalAge25to29 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsMarriedAge25to29 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsSingleAge25to29 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsTotalAge25to29 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsMarriedAge25to29 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsSingleAge25to29 = aRandomAccessFile.readInt();
        this.allHouseholdsTotalAge30to44 = aRandomAccessFile.readInt();
        this.allHouseholdsMarriedAge30to44 = aRandomAccessFile.readInt();
        this.allHouseholdsSingleAge30to44 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsTotalAge30to44 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsMarriedAge30to44 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsSingleAge30to44 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsTotalAge30to44 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsMarriedAge30to44 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsSingleAge30to44 = aRandomAccessFile.readInt();
        this.allHouseholdsTotalAge45to59 = aRandomAccessFile.readInt();
        this.allHouseholdsMarriedAge45to59 = aRandomAccessFile.readInt();
        this.allHouseholdsSingleAge45to59 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsTotalAge45to59 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsMarriedAge45to59 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsSingleAge45to59 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsTotalAge45to59 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsMarriedAge45to59 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsSingleAge45to59 = aRandomAccessFile.readInt();
        this.allHouseholdsTotalAge65to74 = aRandomAccessFile.readInt();
        this.allHouseholdsMarriedAge65to74 = aRandomAccessFile.readInt();
        this.allHouseholdsSingleAge65to74 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsTotalAge65to74 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsMarriedAge65to74 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsSingleAge65to74 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsTotalAge65to74 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsMarriedAge65to74 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsSingleAge65to74 = aRandomAccessFile.readInt();
        this.allHouseholdsTotalAge75to84 = aRandomAccessFile.readInt();
        this.allHouseholdsMarriedAge75to84 = aRandomAccessFile.readInt();
        this.allHouseholdsSingleAge75to84 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsTotalAge75to84 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsMarriedAge75to84 = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsSingleAge75to84 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsTotalAge75to84 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsMarriedAge75to84 = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsSingleAge75to84 = aRandomAccessFile.readInt();
        this.allHouseholdsTotalAge85AndOver = aRandomAccessFile.readInt();
        this.allHouseholdsMarriedAge85AndOver = aRandomAccessFile.readInt();
        this.allHouseholdsSingleAge85AndOver = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsTotalAge85AndOver = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsMarriedAge85AndOver = aRandomAccessFile.readInt();
        this.maleHRPHouseholdsSingleAge85AndOver = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsTotalAge85AndOver = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsMarriedAge85AndOver = aRandomAccessFile.readInt();
        this.femaleHRPHouseholdsSingleAge85AndOver = aRandomAccessFile.readInt();
    }

    /**
     * Initialises all fields.
     */
    protected void _Init() {
        super._Init();
        this.allHouseholdsTotal = Integer.MIN_VALUE;
        this.allHouseholdsMarried = Integer.MIN_VALUE;
        this.allHouseholdsSingle = Integer.MIN_VALUE;
        this.maleHRPHouseholdsTotal = Integer.MIN_VALUE;
        this.maleHRPHouseholdsMarried = Integer.MIN_VALUE;
        this.maleHRPHouseholdsSingle = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsTotal = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsMarried = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsSingle = Integer.MIN_VALUE;
        this.allHouseholdsTotalAge19AndUnder = Integer.MIN_VALUE;
        this.allHouseholdsMarriedAge19AndUnder = Integer.MIN_VALUE;
        this.allHouseholdsSingleAge19AndUnder = Integer.MIN_VALUE;
        this.maleHRPHouseholdsTotalAge19AndUnder = Integer.MIN_VALUE;
        this.maleHRPHouseholdsMarriedAge19AndUnder = Integer.MIN_VALUE;
        this.maleHRPHouseholdsSingleAge19AndUnder = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsTotalAge19AndUnder = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsMarriedAge19AndUnder = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsSingleAge19AndUnder = Integer.MIN_VALUE;
        this.allHouseholdsTotalAge20to24 = Integer.MIN_VALUE;
        this.allHouseholdsMarriedAge20to24 = Integer.MIN_VALUE;
        this.allHouseholdsSingleAge20to24 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsTotalAge20to24 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsMarriedAge20to24 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsSingleAge20to24 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsTotalAge20to24 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsMarriedAge20to24 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsSingleAge20to24 = Integer.MIN_VALUE;
        this.allHouseholdsTotalAge25to29 = Integer.MIN_VALUE;
        this.allHouseholdsMarriedAge25to29 = Integer.MIN_VALUE;
        this.allHouseholdsSingleAge25to29 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsTotalAge25to29 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsMarriedAge25to29 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsSingleAge25to29 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsTotalAge25to29 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsMarriedAge25to29 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsSingleAge25to29 = Integer.MIN_VALUE;
        this.allHouseholdsTotalAge30to44 = Integer.MIN_VALUE;
        this.allHouseholdsMarriedAge30to44 = Integer.MIN_VALUE;
        this.allHouseholdsSingleAge30to44 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsTotalAge30to44 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsMarriedAge30to44 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsSingleAge30to44 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsTotalAge30to44 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsMarriedAge30to44 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsSingleAge30to44 = Integer.MIN_VALUE;
        this.allHouseholdsTotalAge45to59 = Integer.MIN_VALUE;
        this.allHouseholdsMarriedAge45to59 = Integer.MIN_VALUE;
        this.allHouseholdsSingleAge45to59 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsTotalAge45to59 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsMarriedAge45to59 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsSingleAge45to59 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsTotalAge45to59 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsMarriedAge45to59 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsSingleAge45to59 = Integer.MIN_VALUE;
        this.allHouseholdsTotalAge65to74 = Integer.MIN_VALUE;
        this.allHouseholdsMarriedAge65to74 = Integer.MIN_VALUE;
        this.allHouseholdsSingleAge65to74 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsTotalAge65to74 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsMarriedAge65to74 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsSingleAge65to74 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsTotalAge65to74 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsMarriedAge65to74 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsSingleAge65to74 = Integer.MIN_VALUE;
        this.allHouseholdsTotalAge75to84 = Integer.MIN_VALUE;
        this.allHouseholdsMarriedAge75to84 = Integer.MIN_VALUE;
        this.allHouseholdsSingleAge75to84 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsTotalAge75to84 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsMarriedAge75to84 = Integer.MIN_VALUE;
        this.maleHRPHouseholdsSingleAge75to84 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsTotalAge75to84 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsMarriedAge75to84 = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsSingleAge75to84 = Integer.MIN_VALUE;
        this.allHouseholdsTotalAge85AndOver = Integer.MIN_VALUE;
        this.allHouseholdsMarriedAge85AndOver = Integer.MIN_VALUE;
        this.allHouseholdsSingleAge85AndOver = Integer.MIN_VALUE;
        this.maleHRPHouseholdsTotalAge85AndOver = Integer.MIN_VALUE;
        this.maleHRPHouseholdsMarriedAge85AndOver = Integer.MIN_VALUE;
        this.maleHRPHouseholdsSingleAge85AndOver = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsTotalAge85AndOver = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsMarriedAge85AndOver = Integer.MIN_VALUE;
        this.femaleHRPHouseholdsSingleAge85AndOver = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields as zero.
     */
    protected void initZero() {
        super._Init();
        this.allHouseholdsTotal = 0;
        this.allHouseholdsMarried = 0;
        this.allHouseholdsSingle = 0;
        this.maleHRPHouseholdsTotal = 0;
        this.maleHRPHouseholdsMarried = 0;
        this.maleHRPHouseholdsSingle = 0;
        this.femaleHRPHouseholdsTotal = 0;
        this.femaleHRPHouseholdsMarried = 0;
        this.femaleHRPHouseholdsSingle = 0;
        this.allHouseholdsTotalAge19AndUnder = 0;
        this.allHouseholdsMarriedAge19AndUnder = 0;
        this.allHouseholdsSingleAge19AndUnder = 0;
        this.maleHRPHouseholdsTotalAge19AndUnder = 0;
        this.maleHRPHouseholdsMarriedAge19AndUnder = 0;
        this.maleHRPHouseholdsSingleAge19AndUnder = 0;
        this.femaleHRPHouseholdsTotalAge19AndUnder = 0;
        this.femaleHRPHouseholdsMarriedAge19AndUnder = 0;
        this.femaleHRPHouseholdsSingleAge19AndUnder = 0;
        this.allHouseholdsTotalAge20to24 = 0;
        this.allHouseholdsMarriedAge20to24 = 0;
        this.allHouseholdsSingleAge20to24 = 0;
        this.maleHRPHouseholdsTotalAge20to24 = 0;
        this.maleHRPHouseholdsMarriedAge20to24 = 0;
        this.maleHRPHouseholdsSingleAge20to24 = 0;
        this.femaleHRPHouseholdsTotalAge20to24 = 0;
        this.femaleHRPHouseholdsMarriedAge20to24 = 0;
        this.femaleHRPHouseholdsSingleAge20to24 = 0;
        this.allHouseholdsTotalAge25to29 = 0;
        this.allHouseholdsMarriedAge25to29 = 0;
        this.allHouseholdsSingleAge25to29 = 0;
        this.maleHRPHouseholdsTotalAge25to29 = 0;
        this.maleHRPHouseholdsMarriedAge25to29 = 0;
        this.maleHRPHouseholdsSingleAge25to29 = 0;
        this.femaleHRPHouseholdsTotalAge25to29 = 0;
        this.femaleHRPHouseholdsMarriedAge25to29 = 0;
        this.femaleHRPHouseholdsSingleAge25to29 = 0;
        this.allHouseholdsTotalAge30to44 = 0;
        this.allHouseholdsMarriedAge30to44 = 0;
        this.allHouseholdsSingleAge30to44 = 0;
        this.maleHRPHouseholdsTotalAge30to44 = 0;
        this.maleHRPHouseholdsMarriedAge30to44 = 0;
        this.maleHRPHouseholdsSingleAge30to44 = 0;
        this.femaleHRPHouseholdsTotalAge30to44 = 0;
        this.femaleHRPHouseholdsMarriedAge30to44 = 0;
        this.femaleHRPHouseholdsSingleAge30to44 = 0;
        this.allHouseholdsTotalAge45to59 = 0;
        this.allHouseholdsMarriedAge45to59 = 0;
        this.allHouseholdsSingleAge45to59 = 0;
        this.maleHRPHouseholdsTotalAge45to59 = 0;
        this.maleHRPHouseholdsMarriedAge45to59 = 0;
        this.maleHRPHouseholdsSingleAge45to59 = 0;
        this.femaleHRPHouseholdsTotalAge45to59 = 0;
        this.femaleHRPHouseholdsMarriedAge45to59 = 0;
        this.femaleHRPHouseholdsSingleAge45to59 = 0;
        this.allHouseholdsTotalAge65to74 = 0;
        this.allHouseholdsMarriedAge65to74 = 0;
        this.allHouseholdsSingleAge65to74 = 0;
        this.maleHRPHouseholdsTotalAge65to74 = 0;
        this.maleHRPHouseholdsMarriedAge65to74 = 0;
        this.maleHRPHouseholdsSingleAge65to74 = 0;
        this.femaleHRPHouseholdsTotalAge65to74 = 0;
        this.femaleHRPHouseholdsMarriedAge65to74 = 0;
        this.femaleHRPHouseholdsSingleAge65to74 = 0;
        this.allHouseholdsTotalAge75to84 = 0;
        this.allHouseholdsMarriedAge75to84 = 0;
        this.allHouseholdsSingleAge75to84 = 0;
        this.maleHRPHouseholdsTotalAge75to84 = 0;
        this.maleHRPHouseholdsMarriedAge75to84 = 0;
        this.maleHRPHouseholdsSingleAge75to84 = 0;
        this.femaleHRPHouseholdsTotalAge75to84 = 0;
        this.femaleHRPHouseholdsMarriedAge75to84 = 0;
        this.femaleHRPHouseholdsSingleAge75to84 = 0;
        this.allHouseholdsTotalAge85AndOver = 0;
        this.allHouseholdsMarriedAge85AndOver = 0;
        this.allHouseholdsSingleAge85AndOver = 0;
        this.maleHRPHouseholdsTotalAge85AndOver = 0;
        this.maleHRPHouseholdsMarriedAge85AndOver = 0;
        this.maleHRPHouseholdsSingleAge85AndOver = 0;
        this.femaleHRPHouseholdsTotalAge85AndOver = 0;
        this.femaleHRPHouseholdsMarriedAge85AndOver = 0;
        this.femaleHRPHouseholdsSingleAge85AndOver = 0;
    }

    /**
     * Initialises from <code>aCAS003DataRecord</code>.
     *
     * @param aCAS003DataRecord
     *            The <code>CAS003DataRecord</code> used to initialise
     *            <code>this</code>.
     */
    protected void init(CAS003DataRecord aCAS003DataRecord) {
        super.init(aCAS003DataRecord);
        this.allHouseholdsTotal = aCAS003DataRecord.allHouseholdsTotal;
        this.allHouseholdsMarried = aCAS003DataRecord.allHouseholdsMarried;
        this.allHouseholdsSingle = aCAS003DataRecord.allHouseholdsSingle;
        this.maleHRPHouseholdsTotal = aCAS003DataRecord.maleHRPHouseholdsTotal;
        this.maleHRPHouseholdsMarried = aCAS003DataRecord.maleHRPHouseholdsMarried;
        this.maleHRPHouseholdsSingle = aCAS003DataRecord.maleHRPHouseholdsSingle;
        this.femaleHRPHouseholdsTotal = aCAS003DataRecord.femaleHRPHouseholdsTotal;
        this.femaleHRPHouseholdsMarried = aCAS003DataRecord.femaleHRPHouseholdsMarried;
        this.femaleHRPHouseholdsSingle = aCAS003DataRecord.femaleHRPHouseholdsSingle;
        this.allHouseholdsTotalAge19AndUnder = aCAS003DataRecord.allHouseholdsTotalAge19AndUnder;
        this.allHouseholdsMarriedAge19AndUnder = aCAS003DataRecord.allHouseholdsMarriedAge19AndUnder;
        this.allHouseholdsSingleAge19AndUnder = aCAS003DataRecord.allHouseholdsSingleAge19AndUnder;
        this.maleHRPHouseholdsTotalAge19AndUnder = aCAS003DataRecord.maleHRPHouseholdsTotalAge19AndUnder;
        this.maleHRPHouseholdsMarriedAge19AndUnder = aCAS003DataRecord.maleHRPHouseholdsMarriedAge19AndUnder;
        this.maleHRPHouseholdsSingleAge19AndUnder = aCAS003DataRecord.maleHRPHouseholdsSingleAge19AndUnder;
        this.femaleHRPHouseholdsTotalAge19AndUnder = aCAS003DataRecord.femaleHRPHouseholdsTotalAge19AndUnder;
        this.femaleHRPHouseholdsMarriedAge19AndUnder = aCAS003DataRecord.femaleHRPHouseholdsMarriedAge19AndUnder;
        this.femaleHRPHouseholdsSingleAge19AndUnder = aCAS003DataRecord.femaleHRPHouseholdsSingleAge19AndUnder;
        this.allHouseholdsTotalAge20to24 = aCAS003DataRecord.allHouseholdsTotalAge20to24;
        this.allHouseholdsMarriedAge20to24 = aCAS003DataRecord.allHouseholdsMarriedAge20to24;
        this.allHouseholdsSingleAge20to24 = aCAS003DataRecord.allHouseholdsSingleAge20to24;
        this.maleHRPHouseholdsTotalAge20to24 = aCAS003DataRecord.maleHRPHouseholdsTotalAge20to24;
        this.maleHRPHouseholdsMarriedAge20to24 = aCAS003DataRecord.maleHRPHouseholdsMarriedAge20to24;
        this.maleHRPHouseholdsSingleAge20to24 = aCAS003DataRecord.maleHRPHouseholdsSingleAge20to24;
        this.femaleHRPHouseholdsTotalAge20to24 = aCAS003DataRecord.femaleHRPHouseholdsTotalAge20to24;
        this.femaleHRPHouseholdsMarriedAge20to24 = aCAS003DataRecord.femaleHRPHouseholdsMarriedAge20to24;
        this.femaleHRPHouseholdsSingleAge20to24 = aCAS003DataRecord.femaleHRPHouseholdsSingleAge20to24;
        this.allHouseholdsTotalAge25to29 = aCAS003DataRecord.allHouseholdsTotalAge25to29;
        this.allHouseholdsMarriedAge25to29 = aCAS003DataRecord.allHouseholdsMarriedAge25to29;
        this.allHouseholdsSingleAge25to29 = aCAS003DataRecord.allHouseholdsSingleAge25to29;
        this.maleHRPHouseholdsTotalAge25to29 = aCAS003DataRecord.maleHRPHouseholdsTotalAge25to29;
        this.maleHRPHouseholdsMarriedAge25to29 = aCAS003DataRecord.maleHRPHouseholdsMarriedAge25to29;
        this.maleHRPHouseholdsSingleAge25to29 = aCAS003DataRecord.maleHRPHouseholdsSingleAge25to29;
        this.femaleHRPHouseholdsTotalAge25to29 = aCAS003DataRecord.femaleHRPHouseholdsTotalAge25to29;
        this.femaleHRPHouseholdsMarriedAge25to29 = aCAS003DataRecord.femaleHRPHouseholdsMarriedAge25to29;
        this.femaleHRPHouseholdsSingleAge25to29 = aCAS003DataRecord.femaleHRPHouseholdsSingleAge25to29;
        this.allHouseholdsTotalAge30to44 = aCAS003DataRecord.allHouseholdsTotalAge30to44;
        this.allHouseholdsMarriedAge30to44 = aCAS003DataRecord.allHouseholdsMarriedAge30to44;
        this.allHouseholdsSingleAge30to44 = aCAS003DataRecord.allHouseholdsSingleAge30to44;
        this.maleHRPHouseholdsTotalAge30to44 = aCAS003DataRecord.maleHRPHouseholdsTotalAge30to44;
        this.maleHRPHouseholdsMarriedAge30to44 = aCAS003DataRecord.maleHRPHouseholdsMarriedAge30to44;
        this.maleHRPHouseholdsSingleAge30to44 = aCAS003DataRecord.maleHRPHouseholdsSingleAge30to44;
        this.femaleHRPHouseholdsTotalAge30to44 = aCAS003DataRecord.femaleHRPHouseholdsTotalAge30to44;
        this.femaleHRPHouseholdsMarriedAge30to44 = aCAS003DataRecord.femaleHRPHouseholdsMarriedAge30to44;
        this.femaleHRPHouseholdsSingleAge30to44 = aCAS003DataRecord.femaleHRPHouseholdsSingleAge30to44;
        this.allHouseholdsTotalAge45to59 = aCAS003DataRecord.allHouseholdsTotalAge45to59;
        this.allHouseholdsMarriedAge45to59 = aCAS003DataRecord.allHouseholdsMarriedAge45to59;
        this.allHouseholdsSingleAge45to59 = aCAS003DataRecord.allHouseholdsSingleAge45to59;
        this.maleHRPHouseholdsTotalAge45to59 = aCAS003DataRecord.maleHRPHouseholdsTotalAge45to59;
        this.maleHRPHouseholdsMarriedAge45to59 = aCAS003DataRecord.maleHRPHouseholdsMarriedAge45to59;
        this.maleHRPHouseholdsSingleAge45to59 = aCAS003DataRecord.maleHRPHouseholdsSingleAge45to59;
        this.femaleHRPHouseholdsTotalAge45to59 = aCAS003DataRecord.femaleHRPHouseholdsTotalAge45to59;
        this.femaleHRPHouseholdsMarriedAge45to59 = aCAS003DataRecord.femaleHRPHouseholdsMarriedAge45to59;
        this.femaleHRPHouseholdsSingleAge45to59 = aCAS003DataRecord.femaleHRPHouseholdsSingleAge45to59;
        this.allHouseholdsTotalAge60to64 = aCAS003DataRecord.allHouseholdsTotalAge60to64;
        this.allHouseholdsMarriedAge60to64 = aCAS003DataRecord.allHouseholdsMarriedAge60to64;
        this.allHouseholdsSingleAge60to64 = aCAS003DataRecord.allHouseholdsSingleAge60to64;
        this.maleHRPHouseholdsTotalAge60to64 = aCAS003DataRecord.maleHRPHouseholdsTotalAge60to64;
        this.maleHRPHouseholdsMarriedAge60to64 = aCAS003DataRecord.maleHRPHouseholdsMarriedAge60to64;
        this.maleHRPHouseholdsSingleAge60to64 = aCAS003DataRecord.maleHRPHouseholdsSingleAge60to64;
        this.femaleHRPHouseholdsTotalAge60to64 = aCAS003DataRecord.femaleHRPHouseholdsTotalAge60to64;
        this.femaleHRPHouseholdsMarriedAge60to64 = aCAS003DataRecord.femaleHRPHouseholdsMarriedAge60to64;
        this.femaleHRPHouseholdsSingleAge60to64 = aCAS003DataRecord.femaleHRPHouseholdsSingleAge60to64;
        this.allHouseholdsTotalAge65to74 = aCAS003DataRecord.allHouseholdsTotalAge65to74;
        this.allHouseholdsMarriedAge65to74 = aCAS003DataRecord.allHouseholdsMarriedAge65to74;
        this.allHouseholdsSingleAge65to74 = aCAS003DataRecord.allHouseholdsSingleAge65to74;
        this.maleHRPHouseholdsTotalAge65to74 = aCAS003DataRecord.maleHRPHouseholdsTotalAge65to74;
        this.maleHRPHouseholdsMarriedAge65to74 = aCAS003DataRecord.maleHRPHouseholdsMarriedAge65to74;
        this.maleHRPHouseholdsSingleAge65to74 = aCAS003DataRecord.maleHRPHouseholdsSingleAge65to74;
        this.femaleHRPHouseholdsTotalAge65to74 = aCAS003DataRecord.femaleHRPHouseholdsTotalAge65to74;
        this.femaleHRPHouseholdsMarriedAge65to74 = aCAS003DataRecord.femaleHRPHouseholdsMarriedAge65to74;
        this.femaleHRPHouseholdsSingleAge65to74 = aCAS003DataRecord.femaleHRPHouseholdsSingleAge65to74;
        this.allHouseholdsTotalAge75to84 = aCAS003DataRecord.allHouseholdsTotalAge75to84;
        this.allHouseholdsMarriedAge75to84 = aCAS003DataRecord.allHouseholdsMarriedAge75to84;
        this.allHouseholdsSingleAge75to84 = aCAS003DataRecord.allHouseholdsSingleAge75to84;
        this.maleHRPHouseholdsTotalAge75to84 = aCAS003DataRecord.maleHRPHouseholdsTotalAge75to84;
        this.maleHRPHouseholdsMarriedAge75to84 = aCAS003DataRecord.maleHRPHouseholdsMarriedAge75to84;
        this.maleHRPHouseholdsSingleAge75to84 = aCAS003DataRecord.maleHRPHouseholdsSingleAge75to84;
        this.femaleHRPHouseholdsTotalAge75to84 = aCAS003DataRecord.femaleHRPHouseholdsTotalAge75to84;
        this.femaleHRPHouseholdsMarriedAge75to84 = aCAS003DataRecord.femaleHRPHouseholdsMarriedAge75to84;
        this.femaleHRPHouseholdsSingleAge75to84 = aCAS003DataRecord.femaleHRPHouseholdsSingleAge75to84;
        this.allHouseholdsTotalAge85AndOver = aCAS003DataRecord.allHouseholdsTotalAge85AndOver;
        this.allHouseholdsMarriedAge85AndOver = aCAS003DataRecord.allHouseholdsMarriedAge85AndOver;
        this.allHouseholdsSingleAge85AndOver = aCAS003DataRecord.allHouseholdsSingleAge85AndOver;
        this.maleHRPHouseholdsTotalAge85AndOver = aCAS003DataRecord.maleHRPHouseholdsTotalAge85AndOver;
        this.maleHRPHouseholdsMarriedAge85AndOver = aCAS003DataRecord.maleHRPHouseholdsMarriedAge85AndOver;
        this.maleHRPHouseholdsSingleAge85AndOver = aCAS003DataRecord.maleHRPHouseholdsSingleAge85AndOver;
        this.femaleHRPHouseholdsTotalAge85AndOver = aCAS003DataRecord.femaleHRPHouseholdsTotalAge85AndOver;
        this.femaleHRPHouseholdsMarriedAge85AndOver = aCAS003DataRecord.femaleHRPHouseholdsMarriedAge85AndOver;
        this.femaleHRPHouseholdsSingleAge85AndOver = aCAS003DataRecord.femaleHRPHouseholdsSingleAge85AndOver;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        String string = super.toString() + ", allHouseholdsTotal " + allHouseholdsTotal + ", allHouseholdsMarried " + allHouseholdsMarried + ", allHouseholdsSingle " + allHouseholdsSingle + ", maleHRPHouseholdsTotal " + maleHRPHouseholdsTotal + ", maleHRPHouseholdsMarried " + maleHRPHouseholdsMarried + ", maleHRPHouseholdsSingle " + maleHRPHouseholdsSingle + ", femaleHRPHouseholdsTotal " + femaleHRPHouseholdsTotal + ", femaleHRPHouseholdsMarried " + femaleHRPHouseholdsMarried + ", femaleHRPHouseholdsSingle " + femaleHRPHouseholdsSingle + ", allHouseholdsTotalAge19AndUnder " + allHouseholdsTotalAge19AndUnder + ", allHouseholdsMarriedAge19AndUnder " + allHouseholdsMarriedAge19AndUnder + ", allHouseholdsSingleAge19AndUnder " + allHouseholdsSingleAge19AndUnder + ", maleHRPHouseholdsTotalAge19AndUnder " + maleHRPHouseholdsTotalAge19AndUnder + ", maleHRPHouseholdsMarriedAge19AndUnder " + maleHRPHouseholdsMarriedAge19AndUnder + ", maleHRPHouseholdsSingleAge19AndUnder " + maleHRPHouseholdsSingleAge19AndUnder + ", femaleHRPHouseholdsTotalAge19AndUnder " + femaleHRPHouseholdsTotalAge19AndUnder + ", femaleHRPHouseholdsMarriedAge19AndUnder " + femaleHRPHouseholdsMarriedAge19AndUnder + ", femaleHRPHouseholdsSingleAge19AndUnder " + femaleHRPHouseholdsSingleAge19AndUnder + ", allHouseholdsTotalAge20to24 " + allHouseholdsTotalAge20to24 + ", allHouseholdsMarriedAge20to24 " + allHouseholdsMarriedAge20to24 + ", allHouseholdsSingleAge20to24 " + allHouseholdsSingleAge20to24 + ", maleHRPHouseholdsTotalAge20to24 " + maleHRPHouseholdsTotalAge20to24 + ", maleHRPHouseholdsMarriedAge20to24 " + maleHRPHouseholdsMarriedAge20to24 + ", maleHRPHouseholdsSingleAge20to24 " + maleHRPHouseholdsSingleAge20to24 + ", femaleHRPHouseholdsTotalAge20to24 " + femaleHRPHouseholdsTotalAge20to24 + ", femaleHRPHouseholdsMarriedAge20to24 " + femaleHRPHouseholdsMarriedAge20to24 + ", femaleHRPHouseholdsSingleAge20to24 " + femaleHRPHouseholdsSingleAge20to24 + ", allHouseholdsTotalAge25to29 " + allHouseholdsTotalAge25to29 + ", allHouseholdsMarriedAge25to29 " + allHouseholdsMarriedAge25to29 + ", allHouseholdsSingleAge25to29 " + allHouseholdsSingleAge25to29 + ", maleHRPHouseholdsTotalAge25to29 " + maleHRPHouseholdsTotalAge25to29 + ", maleHRPHouseholdsMarriedAge25to29 " + maleHRPHouseholdsMarriedAge25to29 + ", maleHRPHouseholdsSingleAge25to29 " + maleHRPHouseholdsSingleAge25to29 + ", femaleHRPHouseholdsTotalAge25to29 " + femaleHRPHouseholdsTotalAge25to29 + ", femaleHRPHouseholdsMarriedAge25to29 " + femaleHRPHouseholdsMarriedAge25to29 + ", femaleHRPHouseholdsSingleAge25to29 " + femaleHRPHouseholdsSingleAge25to29 + ", allHouseholdsTotalAge30to44 " + allHouseholdsTotalAge30to44 + ", allHouseholdsMarriedAge30to44 " + allHouseholdsMarriedAge30to44 + ", allHouseholdsSingleAge30to44 " + allHouseholdsSingleAge30to44 + ", maleHRPHouseholdsTotalAge30to44 " + maleHRPHouseholdsTotalAge30to44 + ", maleHRPHouseholdsMarriedAge30to44 " + maleHRPHouseholdsMarriedAge30to44 + ", maleHRPHouseholdsSingleAge30to44 " + maleHRPHouseholdsSingleAge30to44 + ", femaleHRPHouseholdsTotalAge30to44 " + femaleHRPHouseholdsTotalAge30to44 + ", femaleHRPHouseholdsMarriedAge30to44 " + femaleHRPHouseholdsMarriedAge30to44 + ", femaleHRPHouseholdsSingleAge30to44 " + femaleHRPHouseholdsSingleAge30to44 + ", allHouseholdsTotalAge45to59 " + allHouseholdsTotalAge45to59 + ", allHouseholdsMarriedAge45to59 " + allHouseholdsMarriedAge45to59 + ", allHouseholdsSingleAge45to59 " + allHouseholdsSingleAge45to59 + ", maleHRPHouseholdsTotalAge45to59 " + maleHRPHouseholdsTotalAge45to59 + ", maleHRPHouseholdsMarriedAge45to59 " + maleHRPHouseholdsMarriedAge45to59 + ", maleHRPHouseholdsSingleAge45to59 " + maleHRPHouseholdsSingleAge45to59 + ", femaleHRPHouseholdsTotalAge45to59 " + femaleHRPHouseholdsTotalAge45to59 + ", femaleHRPHouseholdsMarriedAge45to59 " + femaleHRPHouseholdsMarriedAge45to59 + ", femaleHRPHouseholdsSingleAge45to59 " + femaleHRPHouseholdsSingleAge45to59 + ", allHouseholdsTotalAge60to64 " + allHouseholdsTotalAge60to64 + ", allHouseholdsMarriedAge60to64 " + allHouseholdsMarriedAge60to64 + ", allHouseholdsSingleAge60to64 " + allHouseholdsSingleAge60to64 + ", maleHRPHouseholdsTotalAge60to64 " + maleHRPHouseholdsTotalAge60to64 + ", maleHRPHouseholdsMarriedAge60to64 " + maleHRPHouseholdsMarriedAge60to64 + ", maleHRPHouseholdsSingleAge60to64 " + maleHRPHouseholdsSingleAge60to64 + ", femaleHRPHouseholdsTotalAge60to64 " + femaleHRPHouseholdsTotalAge60to64 + ", femaleHRPHouseholdsMarriedAge60to64 " + femaleHRPHouseholdsMarriedAge60to64 + ", femaleHRPHouseholdsSingleAge60to64 " + femaleHRPHouseholdsSingleAge60to64 + ", allHouseholdsTotalAge65to74 " + allHouseholdsTotalAge65to74 + ", allHouseholdsMarriedAge65to74 " + allHouseholdsMarriedAge65to74 + ", allHouseholdsSingleAge65to74 " + allHouseholdsSingleAge65to74 + ", maleHRPHouseholdsTotalAge65to74 " + maleHRPHouseholdsTotalAge65to74 + ", maleHRPHouseholdsMarriedAge65to74 " + maleHRPHouseholdsMarriedAge65to74 + ", maleHRPHouseholdsSingleAge65to74 " + maleHRPHouseholdsSingleAge65to74 + ", femaleHRPHouseholdsTotalAge65to74 " + femaleHRPHouseholdsTotalAge65to74 + ", femaleHRPHouseholdsMarriedAge65to74 " + femaleHRPHouseholdsMarriedAge65to74 + ", femaleHRPHouseholdsSingleAge65to74 " + femaleHRPHouseholdsSingleAge65to74 + ", allHouseholdsTotalAge75to84 " + allHouseholdsTotalAge75to84 + ", allHouseholdsMarriedAge75to84 " + allHouseholdsMarriedAge75to84 + ", allHouseholdsSingleAge75to84 " + allHouseholdsSingleAge75to84 + ", maleHRPHouseholdsTotalAge75to84 " + maleHRPHouseholdsTotalAge75to84 + ", maleHRPHouseholdsMarriedAge75to84 " + maleHRPHouseholdsMarriedAge75to84 + ", maleHRPHouseholdsSingleAge75to84 " + maleHRPHouseholdsSingleAge75to84 + ", femaleHRPHouseholdsTotalAge75to84 " + femaleHRPHouseholdsTotalAge75to84 + ", femaleHRPHouseholdsMarriedAge75to84 " + femaleHRPHouseholdsMarriedAge75to84 + ", femaleHRPHouseholdsSingleAge75to84 " + femaleHRPHouseholdsSingleAge75to84 + ", allHouseholdsTotalAge85AndOver " + allHouseholdsTotalAge85AndOver + ", allHouseholdsMarriedAge85AndOver " + allHouseholdsMarriedAge85AndOver + ", allHouseholdsSingleAge85AndOver " + allHouseholdsSingleAge85AndOver + ", maleHRPHouseholdsTotalAge85AndOver " + maleHRPHouseholdsTotalAge85AndOver + ", maleHRPHouseholdsMarriedAge85AndOver " + maleHRPHouseholdsMarriedAge85AndOver + ", maleHRPHouseholdsSingleAge85AndOver " + maleHRPHouseholdsSingleAge85AndOver + ", femaleHRPHouseholdsTotalAge85AndOver " + femaleHRPHouseholdsTotalAge85AndOver + ", femaleHRPHouseholdsMarriedAge85AndOver " + femaleHRPHouseholdsMarriedAge85AndOver + ", femaleHRPHouseholdsSingleAge85AndOver " + femaleHRPHouseholdsSingleAge85AndOver;
        return string;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        String result = super.toCSVString();
        result += "," + this.allHouseholdsTotal;
        result += "," + this.allHouseholdsMarried;
        result += "," + this.allHouseholdsSingle;
        result += "," + this.maleHRPHouseholdsTotal;
        result += "," + this.maleHRPHouseholdsMarried;
        result += "," + this.maleHRPHouseholdsSingle;
        result += "," + this.femaleHRPHouseholdsTotal;
        result += "," + this.femaleHRPHouseholdsMarried;
        result += "," + this.femaleHRPHouseholdsSingle;
        result += "," + this.allHouseholdsTotalAge19AndUnder;
        result += "," + this.allHouseholdsMarriedAge19AndUnder;
        result += "," + this.allHouseholdsSingleAge19AndUnder;
        result += "," + this.maleHRPHouseholdsTotalAge19AndUnder;
        result += "," + this.maleHRPHouseholdsMarriedAge19AndUnder;
        result += "," + this.maleHRPHouseholdsSingleAge19AndUnder;
        result += "," + this.femaleHRPHouseholdsTotalAge19AndUnder;
        result += "," + this.femaleHRPHouseholdsMarriedAge19AndUnder;
        result += "," + this.femaleHRPHouseholdsSingleAge19AndUnder;
        result += "," + this.allHouseholdsTotalAge20to24;
        result += "," + this.allHouseholdsMarriedAge20to24;
        result += "," + this.allHouseholdsSingleAge20to24;
        result += "," + this.maleHRPHouseholdsTotalAge20to24;
        result += "," + this.maleHRPHouseholdsMarriedAge20to24;
        result += "," + this.maleHRPHouseholdsSingleAge20to24;
        result += "," + this.femaleHRPHouseholdsTotalAge20to24;
        result += "," + this.femaleHRPHouseholdsMarriedAge20to24;
        result += "," + this.femaleHRPHouseholdsSingleAge20to24;
        result += "," + this.allHouseholdsTotalAge25to29;
        result += "," + this.allHouseholdsMarriedAge25to29;
        result += "," + this.allHouseholdsSingleAge25to29;
        result += "," + this.maleHRPHouseholdsTotalAge25to29;
        result += "," + this.maleHRPHouseholdsMarriedAge25to29;
        result += "," + this.maleHRPHouseholdsSingleAge25to29;
        result += "," + this.femaleHRPHouseholdsTotalAge25to29;
        result += "," + this.femaleHRPHouseholdsMarriedAge25to29;
        result += "," + this.femaleHRPHouseholdsSingleAge25to29;
        result += "," + this.allHouseholdsTotalAge30to44;
        result += "," + this.allHouseholdsMarriedAge30to44;
        result += "," + this.allHouseholdsSingleAge30to44;
        result += "," + this.maleHRPHouseholdsTotalAge30to44;
        result += "," + this.maleHRPHouseholdsMarriedAge30to44;
        result += "," + this.maleHRPHouseholdsSingleAge30to44;
        result += "," + this.femaleHRPHouseholdsTotalAge30to44;
        result += "," + this.femaleHRPHouseholdsMarriedAge30to44;
        result += "," + this.femaleHRPHouseholdsSingleAge30to44;
        result += "," + this.allHouseholdsTotalAge45to59;
        result += "," + this.allHouseholdsMarriedAge45to59;
        result += "," + this.allHouseholdsSingleAge45to59;
        result += "," + this.maleHRPHouseholdsTotalAge45to59;
        result += "," + this.maleHRPHouseholdsMarriedAge45to59;
        result += "," + this.maleHRPHouseholdsSingleAge45to59;
        result += "," + this.femaleHRPHouseholdsTotalAge45to59;
        result += "," + this.femaleHRPHouseholdsMarriedAge45to59;
        result += "," + this.femaleHRPHouseholdsSingleAge45to59;
        result += "," + this.allHouseholdsTotalAge60to64;
        result += "," + this.allHouseholdsMarriedAge60to64;
        result += "," + this.allHouseholdsSingleAge60to64;
        result += "," + this.maleHRPHouseholdsTotalAge60to64;
        result += "," + this.maleHRPHouseholdsMarriedAge60to64;
        result += "," + this.maleHRPHouseholdsSingleAge60to64;
        result += "," + this.femaleHRPHouseholdsTotalAge60to64;
        result += "," + this.femaleHRPHouseholdsMarriedAge60to64;
        result += "," + this.femaleHRPHouseholdsSingleAge60to64;
        result += "," + this.allHouseholdsTotalAge65to74;
        result += "," + this.allHouseholdsMarriedAge65to74;
        result += "," + this.allHouseholdsSingleAge65to74;
        result += "," + this.maleHRPHouseholdsTotalAge65to74;
        result += "," + this.maleHRPHouseholdsMarriedAge65to74;
        result += "," + this.maleHRPHouseholdsSingleAge65to74;
        result += "," + this.femaleHRPHouseholdsTotalAge65to74;
        result += "," + this.femaleHRPHouseholdsMarriedAge65to74;
        result += "," + this.femaleHRPHouseholdsSingleAge65to74;
        result += "," + this.allHouseholdsTotalAge75to84;
        result += "," + this.allHouseholdsMarriedAge75to84;
        result += "," + this.allHouseholdsSingleAge75to84;
        result += "," + this.maleHRPHouseholdsTotalAge75to84;
        result += "," + this.maleHRPHouseholdsMarriedAge75to84;
        result += "," + this.maleHRPHouseholdsSingleAge75to84;
        result += "," + this.femaleHRPHouseholdsTotalAge75to84;
        result += "," + this.femaleHRPHouseholdsMarriedAge75to84;
        result += "," + this.femaleHRPHouseholdsSingleAge75to84;
        result += "," + this.allHouseholdsTotalAge85AndOver;
        result += "," + this.allHouseholdsMarriedAge85AndOver;
        result += "," + this.allHouseholdsSingleAge85AndOver;
        result += "," + this.maleHRPHouseholdsTotalAge85AndOver;
        result += "," + this.maleHRPHouseholdsMarriedAge85AndOver;
        result += "," + this.maleHRPHouseholdsSingleAge85AndOver;
        result += "," + this.femaleHRPHouseholdsTotalAge85AndOver;
        result += "," + this.femaleHRPHouseholdsMarriedAge85AndOver;
        result += "," + this.femaleHRPHouseholdsSingleAge85AndOver;
        return result;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        String result = super.toCSVStringFields();
        result += ",allHouseholdsTotal";
        result += ",allHouseholdsMarried";
        result += ",allHouseholdsSingle";
        result += ",maleHRPHouseholdsTotal";
        result += ",maleHRPHouseholdsMarried";
        result += ",maleHRPHouseholdsSingle";
        result += ",femaleHRPHouseholdsTotal";
        result += ",femaleHRPHouseholdsMarried";
        result += ",femaleHRPHouseholdsSingle";
        result += ",allHouseholdsTotalAge19AndUnder";
        result += ",allHouseholdsMarriedAge19AndUnder";
        result += ",allHouseholdsSingleAge19AndUnder";
        result += ",maleHRPHouseholdsTotalAge19AndUnder";
        result += ",maleHRPHouseholdsMarriedAge19AndUnder";
        result += ",maleHRPHouseholdsSingleAge19AndUnder";
        result += ",femaleHRPHouseholdsTotalAge19AndUnder";
        result += ",femaleHRPHouseholdsMarriedAge19AndUnder";
        result += ",femaleHRPHouseholdsSingleAge19AndUnder";
        result += ",allHouseholdsTotalAge20to24";
        result += ",allHouseholdsMarriedAge20to24";
        result += ",allHouseholdsSingleAge20to24";
        result += ",maleHRPHouseholdsTotalAge20to24";
        result += ",maleHRPHouseholdsMarriedAge20to24";
        result += ",maleHRPHouseholdsSingleAge20to24";
        result += ",femaleHRPHouseholdsTotalAge20to24";
        result += ",femaleHRPHouseholdsMarriedAge20to24";
        result += ",femaleHRPHouseholdsSingleAge20to24";
        result += ",allHouseholdsTotalAge25to29";
        result += ",allHouseholdsMarriedAge25to29";
        result += ",allHouseholdsSingleAge25to29";
        result += ",maleHRPHouseholdsTotalAge25to29";
        result += ",maleHRPHouseholdsMarriedAge25to29";
        result += ",maleHRPHouseholdsSingleAge25to29";
        result += ",femaleHRPHouseholdsTotalAge25to29";
        result += ",femaleHRPHouseholdsMarriedAge25to29";
        result += ",femaleHRPHouseholdsSingleAge25to29";
        result += ",allHouseholdsTotalAge30to44";
        result += ",allHouseholdsMarriedAge30to44";
        result += ",allHouseholdsSingleAge30to44";
        result += ",maleHRPHouseholdsTotalAge30to44";
        result += ",maleHRPHouseholdsMarriedAge30to44";
        result += ",maleHRPHouseholdsSingleAge30to44";
        result += ",femaleHRPHouseholdsTotalAge30to44";
        result += ",femaleHRPHouseholdsMarriedAge30to44";
        result += ",femaleHRPHouseholdsSingleAge30to44";
        result += ",allHouseholdsTotalAge45to59";
        result += ",allHouseholdsMarriedAge45to59";
        result += ",allHouseholdsSingleAge45to59";
        result += ",maleHRPHouseholdsTotalAge45to59";
        result += ",maleHRPHouseholdsMarriedAge45to59";
        result += ",maleHRPHouseholdsSingleAge45to59";
        result += ",femaleHRPHouseholdsTotalAge45to59";
        result += ",femaleHRPHouseholdsMarriedAge45to59";
        result += ",femaleHRPHouseholdsSingleAge45to59";
        result += ",allHouseholdsTotalAge60to64";
        result += ",allHouseholdsMarriedAge60to64";
        result += ",allHouseholdsSingleAge60to64";
        result += ",maleHRPHouseholdsTotalAge60to64";
        result += ",maleHRPHouseholdsMarriedAge60to64";
        result += ",maleHRPHouseholdsSingleAge60to64";
        result += ",femaleHRPHouseholdsTotalAge60to64";
        result += ",femaleHRPHouseholdsMarriedAge60to64";
        result += ",femaleHRPHouseholdsSingleAge60to64";
        result += ",allHouseholdsTotalAge65to74";
        result += ",allHouseholdsMarriedAge65to74";
        result += ",allHouseholdsSingleAge65to74";
        result += ",maleHRPHouseholdsTotalAge65to74";
        result += ",maleHRPHouseholdsMarriedAge65to74";
        result += ",maleHRPHouseholdsSingleAge65to74";
        result += ",femaleHRPHouseholdsTotalAge65to74";
        result += ",femaleHRPHouseholdsMarriedAge65to74";
        result += ",femaleHRPHouseholdsSingleAge65to74";
        result += ",allHouseholdsTotalAge75to84";
        result += ",allHouseholdsMarriedAge75to84";
        result += ",allHouseholdsSingleAge75to84";
        result += ",maleHRPHouseholdsTotalAge75to84";
        result += ",maleHRPHouseholdsMarriedAge75to84";
        result += ",maleHRPHouseholdsSingleAge75to84";
        result += ",femaleHRPHouseholdsTotalAge75to84";
        result += ",femaleHRPHouseholdsMarriedAge75to84";
        result += ",femaleHRPHouseholdsSingleAge75to84";
        result += ",allHouseholdsTotalAge85AndOver";
        result += ",allHouseholdsMarriedAge85AndOver";
        result += ",allHouseholdsSingleAge85AndOver";
        result += ",maleHRPHouseholdsTotalAge85AndOver";
        result += ",maleHRPHouseholdsMarriedAge85AndOver";
        result += ",maleHRPHouseholdsSingleAge85AndOver";
        result += ",femaleHRPHouseholdsTotalAge85AndOver";
        result += ",femaleHRPHouseholdsMarriedAge85AndOver";
        result += ",femaleHRPHouseholdsSingleAge85AndOver";
        return result;
    }

    /**
     * Returns a copy of this.allHouseholdsTotal
     * @return 
     */
    public int getAllHouseholdsTotal() {
        return this.allHouseholdsTotal;
    }

    /**
     * Returns a copy of this.allHouseholdsMarried
     * @return 
     */
    public int getAllHouseholdsMarried() {
        return this.allHouseholdsMarried;
    }

    /**
     * Returns a copy of this.allHouseholdsSingle
     * @return 
     */
    public int getAllHouseholdsSingle() {
        return this.allHouseholdsSingle;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsTotal
     * @return 
     */
    public int getMaleHRPHouseholdsTotal() {
        return this.maleHRPHouseholdsTotal;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsMarried
     * @return 
     */
    public int getMaleHRPHouseholdsMarried() {
        return this.maleHRPHouseholdsMarried;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsSingle
     * @return 
     */
    public int getMaleHRPHouseholdsSingle() {
        return this.maleHRPHouseholdsSingle;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsTotal
     * @return 
     */
    public int getFemaleHRPHouseholdsTotal() {
        return this.femaleHRPHouseholdsTotal;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsMarried
     * @return 
     */
    public int getFemaleHRPHouseholdsMarried() {
        return this.femaleHRPHouseholdsMarried;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsSingle
     * @return 
     */
    public int getFemaleHRPHouseholdsSingle() {
        return this.femaleHRPHouseholdsSingle;
    }

    /**
     * Returns a copy of this.allHouseholdsTotalAge19AndUnder
     * @return 
     */
    public int getAllHouseholdsTotalAge19AndUnder() {
        return this.allHouseholdsTotalAge19AndUnder;
    }

    /**
     * Returns a copy of this.allHouseholdsMarriedAge19AndUnder
     * @return 
     */
    public int getAllHouseholdsMarriedAge19AndUnder() {
        return this.allHouseholdsMarriedAge19AndUnder;
    }

    /**
     * Returns a copy of this.allHouseholdsSingleAge19AndUnder
     * @return 
     */
    public int getAllHouseholdsSingleAge19AndUnder() {
        return this.allHouseholdsSingleAge19AndUnder;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsTotalAge19AndUnder
     * @return 
     */
    public int getMaleHRPHouseholdsTotalAge19AndUnder() {
        return this.maleHRPHouseholdsTotalAge19AndUnder;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsMarriedAge19AndUnder
     * @return 
     */
    public int getMaleHRPHouseholdsMarriedAge19AndUnder() {
        return this.maleHRPHouseholdsMarriedAge19AndUnder;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsSingleAge19AndUnder
     * @return 
     */
    public int getMaleHRPHouseholdsSingleAge19AndUnder() {
        return this.maleHRPHouseholdsSingleAge19AndUnder;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsTotalAge19AndUnder
     * @return 
     */
    public int getFemaleHRPHouseholdsTotalAge19AndUnder() {
        return this.femaleHRPHouseholdsTotalAge19AndUnder;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsMarriedAge19AndUnder
     * @return 
     */
    public int getFemaleHRPHouseholdsMarriedAge19AndUnder() {
        return this.femaleHRPHouseholdsMarriedAge19AndUnder;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsSingleAge19AndUnder
     * @return 
     */
    public int getFemaleHRPHouseholdsSingleAge19AndUnder() {
        return this.femaleHRPHouseholdsSingleAge19AndUnder;
    }

    /**
     * Returns a copy of this.allHouseholdsTotalAge20to24
     * @return 
     */
    public int getAllHouseholdsTotalAge20to24() {
        return this.allHouseholdsTotalAge20to24;
    }

    /**
     * Returns a copy of this.allHouseholdsMarriedAge20to24
     * @return 
     */
    public int getAllHouseholdsMarriedAge20to24() {
        return this.allHouseholdsMarriedAge20to24;
    }

    /**
     * Returns a copy of this.allHouseholdsSingleAge20to24
     * @return 
     */
    public int getAllHouseholdsSingleAge20to24() {
        return this.allHouseholdsSingleAge20to24;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsTotalAge20to24
     * @return 
     */
    public int getMaleHRPHouseholdsTotalAge20to24() {
        return this.maleHRPHouseholdsTotalAge20to24;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsMarriedAge20to24
     * @return 
     */
    public int getMaleHRPHouseholdsMarriedAge20to24() {
        return this.maleHRPHouseholdsMarriedAge20to24;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsSingleAge20to24
     * @return 
     */
    public int getMaleHRPHouseholdsSingleAge20to24() {
        return this.maleHRPHouseholdsSingleAge20to24;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsTotalAge20to24
     * @return 
     */
    public int getFemaleHRPHouseholdsTotalAge20to24() {
        return this.femaleHRPHouseholdsTotalAge20to24;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsMarriedAge20to24
     * @return 
     */
    public int getFemaleHRPHouseholdsMarriedAge20to24() {
        return this.femaleHRPHouseholdsMarriedAge20to24;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsSingleAge20to24
     * @return 
     */
    public int getFemaleHRPHouseholdsSingleAge20to24() {
        return this.femaleHRPHouseholdsSingleAge20to24;
    }

    /**
     * Returns a copy of this.allHouseholdsTotalAge25to29
     * @return 
     */
    public int getAllHouseholdsTotalAge25to29() {
        return this.allHouseholdsTotalAge25to29;
    }

    /**
     * Returns a copy of this.allHouseholdsMarriedAge25to29
     * @return 
     */
    public int getAllHouseholdsMarriedAge25to29() {
        return this.allHouseholdsMarriedAge25to29;
    }

    /**
     * Returns a copy of this.allHouseholdsSingleAge25to29
     * @return 
     */
    public int getAllHouseholdsSingleAge25to29() {
        return this.allHouseholdsSingleAge25to29;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsTotalAge25to29
     * @return 
     */
    public int getMaleHRPHouseholdsTotalAge25to29() {
        return this.maleHRPHouseholdsTotalAge25to29;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsMarriedAge25to29
     * @return 
     */
    public int getMaleHRPHouseholdsMarriedAge25to29() {
        return this.maleHRPHouseholdsMarriedAge25to29;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsSingleAge25to29
     * @return 
     */
    public int getMaleHRPHouseholdsSingleAge25to29() {
        return this.maleHRPHouseholdsSingleAge25to29;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsTotalAge25to29
     * @return 
     */
    public int getFemaleHRPHouseholdsTotalAge25to29() {
        return this.femaleHRPHouseholdsTotalAge25to29;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsMarriedAge25to29
     * @return 
     */
    public int getFemaleHRPHouseholdsMarriedAge25to29() {
        return this.femaleHRPHouseholdsMarriedAge25to29;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsSingleAge25to29
     * @return 
     */
    public int getFemaleHRPHouseholdsSingleAge25to29() {
        return this.femaleHRPHouseholdsSingleAge25to29;
    }

    /**
     * Returns a copy of this.allHouseholdsTotalAge30to44
     * @return 
     */
    public int getAllHouseholdsTotalAge30to44() {
        return this.allHouseholdsTotalAge30to44;
    }

    /**
     * Returns a copy of this.allHouseholdsMarriedAge30to44
     * @return 
     */
    public int getAllHouseholdsMarriedAge30to44() {
        return this.allHouseholdsMarriedAge30to44;
    }

    /**
     * Returns a copy of this.allHouseholdsSingleAge30to44
     * @return 
     */
    public int getAllHouseholdsSingleAge30to44() {
        return this.allHouseholdsSingleAge30to44;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsTotalAge30to44
     * @return 
     */
    public int getMaleHRPHouseholdsTotalAge30to44() {
        return this.maleHRPHouseholdsTotalAge30to44;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsMarriedAge30to44
     * @return 
     */
    public int getMaleHRPHouseholdsMarriedAge30to44() {
        return this.maleHRPHouseholdsMarriedAge30to44;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsSingleAge30to44
     * @return 
     */
    public int getMaleHRPHouseholdsSingleAge30to44() {
        return this.maleHRPHouseholdsSingleAge30to44;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsTotalAge30to44
     * @return 
     */
    public int getFemaleHRPHouseholdsTotalAge30to44() {
        return this.femaleHRPHouseholdsTotalAge30to44;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsMarriedAge30to44
     * @return 
     */
    public int getFemaleHRPHouseholdsMarriedAge30to44() {
        return this.femaleHRPHouseholdsMarriedAge30to44;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsSingleAge30to44
     * @return 
     */
    public int getFemaleHRPHouseholdsSingleAge30to44() {
        return this.femaleHRPHouseholdsSingleAge30to44;
    }

    /**
     * Returns a copy of this.allHouseholdsTotalAge45to59
     * @return 
     */
    public int getAllHouseholdsTotalAge45to59() {
        return this.allHouseholdsTotalAge45to59;
    }

    /**
     * Returns a copy of this.allHouseholdsMarriedAge45to59
     * @return 
     */
    public int getAllHouseholdsMarriedAge45to59() {
        return this.allHouseholdsMarriedAge45to59;
    }

    /**
     * Returns a copy of this.allHouseholdsSingleAge45to59
     * @return 
     */
    public int getAllHouseholdsSingleAge45to59() {
        return this.allHouseholdsSingleAge45to59;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsTotalAge45to59
     * @return 
     */
    public int getMaleHRPHouseholdsTotalAge45to59() {
        return this.maleHRPHouseholdsTotalAge45to59;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsMarriedAge45to59
     * @return 
     */
    public int getMaleHRPHouseholdsMarriedAge45to59() {
        return this.maleHRPHouseholdsMarriedAge45to59;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsSingleAge45to59
     * @return 
     */
    public int getMaleHRPHouseholdsSingleAge45to59() {
        return this.maleHRPHouseholdsSingleAge45to59;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsTotalAge45to59
     * @return 
     */
    public int getFemaleHRPHouseholdsTotalAge45to59() {
        return this.femaleHRPHouseholdsTotalAge45to59;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsMarriedAge45to59
     * @return 
     */
    public int getFemaleHRPHouseholdsMarriedAge45to59() {
        return this.femaleHRPHouseholdsMarriedAge45to59;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsSingleAge45to59
     * @return 
     */
    public int getFemaleHRPHouseholdsSingleAge45to59() {
        return this.femaleHRPHouseholdsSingleAge45to59;
    }

    /**
     * Returns a copy of this.allHouseholdsTotalAge60to64
     * @return 
     */
    public int getAllHouseholdsTotalAge60to64() {
        return this.allHouseholdsTotalAge60to64;
    }

    /**
     * Returns a copy of this.allHouseholdsMarriedAge60to64
     * @return 
     */
    public int getAllHouseholdsMarriedAge60to64() {
        return this.allHouseholdsMarriedAge60to64;
    }

    /**
     * Returns a copy of this.allHouseholdsSingleAge60to64
     * @return 
     */
    public int getAllHouseholdsSingleAge60to64() {
        return this.allHouseholdsSingleAge60to64;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsTotalAge60to64
     * @return 
     */
    public int getMaleHRPHouseholdsTotalAge60to64() {
        return this.maleHRPHouseholdsTotalAge60to64;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsMarriedAge60to64
     * @return 
     */
    public int getMaleHRPHouseholdsMarriedAge60to64() {
        return this.maleHRPHouseholdsMarriedAge60to64;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsSingleAge60to64
     * @return 
     */
    public int getMaleHRPHouseholdsSingleAge60to64() {
        return this.maleHRPHouseholdsSingleAge60to64;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsTotalAge60to64
     * @return 
     */
    public int getFemaleHRPHouseholdsTotalAge60to64() {
        return this.femaleHRPHouseholdsTotalAge60to64;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsMarriedAge60to64
     * @return 
     */
    public int getFemaleHRPHouseholdsMarriedAge60to64() {
        return this.femaleHRPHouseholdsMarriedAge60to64;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsSingleAge60to64
     * @return 
     */
    public int getFemaleHRPHouseholdsSingleAge60to64() {
        return this.femaleHRPHouseholdsSingleAge60to64;
    }

    /**
     * Returns a copy of this.allHouseholdsTotalAge65to74
     * @return 
     */
    public int getAllHouseholdsTotalAge65to74() {
        return this.allHouseholdsTotalAge65to74;
    }

    /**
     * Returns a copy of this.allHouseholdsMarriedAge65to74
     * @return 
     */
    public int getAllHouseholdsMarriedAge65to74() {
        return this.allHouseholdsMarriedAge65to74;
    }

    /**
     * Returns a copy of this.allHouseholdsSingleAge65to74
     * @return 
     */
    public int getAllHouseholdsSingleAge65to74() {
        return this.allHouseholdsSingleAge65to74;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsTotalAge65to74
     * @return 
     */
    public int getMaleHRPHouseholdsTotalAge65to74() {
        return this.maleHRPHouseholdsTotalAge65to74;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsMarriedAge65to74
     * @return 
     */
    public int getMaleHRPHouseholdsMarriedAge65to74() {
        return this.maleHRPHouseholdsMarriedAge65to74;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsSingleAge65to74
     * @return 
     */
    public int getMaleHRPHouseholdsSingleAge65to74() {
        return this.maleHRPHouseholdsSingleAge65to74;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsTotalAge65to74
     * @return 
     */
    public int getFemaleHRPHouseholdsTotalAge65to74() {
        return this.femaleHRPHouseholdsTotalAge65to74;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsMarriedAge65to74
     * @return 
     */
    public int getFemaleHRPHouseholdsMarriedAge65to74() {
        return this.femaleHRPHouseholdsMarriedAge65to74;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsSingleAge65to74
     * @return 
     */
    public int getFemaleHRPHouseholdsSingleAge65to74() {
        return this.femaleHRPHouseholdsSingleAge65to74;
    }

    /**
     * Returns a copy of this.allHouseholdsTotalAge75to84
     * @return 
     */
    public int getAllHouseholdsTotalAge75to84() {
        return this.allHouseholdsTotalAge75to84;
    }

    /**
     * Returns a copy of this.allHouseholdsMarriedAge75to84
     * @return 
     */
    public int getAllHouseholdsMarriedAge75to84() {
        return this.allHouseholdsMarriedAge75to84;
    }

    /**
     * Returns a copy of this.allHouseholdsSingleAge75to84
     * @return 
     */
    public int getAllHouseholdsSingleAge75to84() {
        return this.allHouseholdsSingleAge75to84;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsTotalAge75to84
     * @return 
     */
    public int getMaleHRPHouseholdsTotalAge75to84() {
        return this.maleHRPHouseholdsTotalAge75to84;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsMarriedAge75to84
     * @return 
     */
    public int getMaleHRPHouseholdsMarriedAge75to84() {
        return this.maleHRPHouseholdsMarriedAge75to84;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsSingleAge75to84
     * @return 
     */
    public int getMaleHRPHouseholdsSingleAge75to84() {
        return this.maleHRPHouseholdsSingleAge75to84;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsTotalAge75to84
     * @return 
     */
    public int getFemaleHRPHouseholdsTotalAge75to84() {
        return this.femaleHRPHouseholdsTotalAge75to84;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsMarriedAge75to84
     * @return 
     */
    public int getFemaleHRPHouseholdsMarriedAge75to84() {
        return this.femaleHRPHouseholdsMarriedAge75to84;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsSingleAge75to84
     * @return 
     */
    public int getFemaleHRPHouseholdsSingleAge75to84() {
        return this.femaleHRPHouseholdsSingleAge75to84;
    }

    /**
     * Returns a copy of this.allHouseholdsTotalAge85AndOver
     * @return 
     */
    public int getAllHouseholdsTotalAge85AndOver() {
        return this.allHouseholdsTotalAge85AndOver;
    }

    /**
     * Returns a copy of this.allHouseholdsMarriedAge85AndOver
     * @return 
     */
    public int getAllHouseholdsMarriedAge85AndOver() {
        return this.allHouseholdsMarriedAge85AndOver;
    }

    /**
     * Returns a copy of this.allHouseholdsSingleAge85AndOver
     * @return 
     */
    public int getAllHouseholdsSingleAge85AndOver() {
        return this.allHouseholdsSingleAge85AndOver;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsTotalAge85AndOver
     * @return 
     */
    public int getMaleHRPHouseholdsTotalAge85AndOver() {
        return this.maleHRPHouseholdsTotalAge85AndOver;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsMarriedAge85AndOver
     * @return 
     */
    public int getMaleHRPHouseholdsMarriedAge85AndOver() {
        return this.maleHRPHouseholdsMarriedAge85AndOver;
    }

    /**
     * Returns a copy of this.maleHRPHouseholdsSingleAge85AndOver
     * @return 
     */
    public int getMaleHRPHouseholdsSingleAge85AndOver() {
        return this.maleHRPHouseholdsSingleAge85AndOver;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsTotalAge85AndOver
     * @return 
     */
    public int getFemaleHRPHouseholdsTotalAge85AndOver() {
        return this.femaleHRPHouseholdsTotalAge85AndOver;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsMarriedAge85AndOver
     * @return 
     */
    public int getFemaleHRPHouseholdsMarriedAge85AndOver() {
        return this.femaleHRPHouseholdsMarriedAge85AndOver;
    }

    /**
     * Returns a copy of this.femaleHRPHouseholdsSingleAge85AndOver
     * @return 
     */
    public int getFemaleHRPHouseholdsSingleAge85AndOver() {
        return this.femaleHRPHouseholdsSingleAge85AndOver;
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
                aRandomAccessFile.writeInt(this.allHouseholdsTotal);
                aRandomAccessFile.writeInt(this.allHouseholdsMarried);
                aRandomAccessFile.writeInt(this.allHouseholdsSingle);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsTotal);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsMarried);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsSingle);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsTotal);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsMarried);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsSingle);
                aRandomAccessFile.writeInt(this.allHouseholdsTotalAge19AndUnder);
                aRandomAccessFile.writeInt(this.allHouseholdsMarriedAge19AndUnder);
                aRandomAccessFile.writeInt(this.allHouseholdsSingleAge19AndUnder);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsTotalAge19AndUnder);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsMarriedAge19AndUnder);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsSingleAge19AndUnder);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsTotalAge19AndUnder);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsMarriedAge19AndUnder);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsSingleAge19AndUnder);
                aRandomAccessFile.writeInt(this.allHouseholdsTotalAge20to24);
                aRandomAccessFile.writeInt(this.allHouseholdsMarriedAge20to24);
                aRandomAccessFile.writeInt(this.allHouseholdsSingleAge20to24);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsTotalAge20to24);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsMarriedAge20to24);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsSingleAge20to24);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsTotalAge20to24);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsMarriedAge20to24);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsSingleAge20to24);
                aRandomAccessFile.writeInt(this.allHouseholdsTotalAge25to29);
                aRandomAccessFile.writeInt(this.allHouseholdsMarriedAge25to29);
                aRandomAccessFile.writeInt(this.allHouseholdsSingleAge25to29);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsTotalAge25to29);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsMarriedAge25to29);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsSingleAge25to29);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsTotalAge25to29);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsMarriedAge25to29);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsSingleAge25to29);
                aRandomAccessFile.writeInt(this.allHouseholdsTotalAge30to44);
                aRandomAccessFile.writeInt(this.allHouseholdsMarriedAge30to44);
                aRandomAccessFile.writeInt(this.allHouseholdsSingleAge30to44);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsTotalAge30to44);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsMarriedAge30to44);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsSingleAge30to44);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsTotalAge30to44);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsMarriedAge30to44);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsSingleAge30to44);
                aRandomAccessFile.writeInt(this.allHouseholdsTotalAge45to59);
                aRandomAccessFile.writeInt(this.allHouseholdsMarriedAge45to59);
                aRandomAccessFile.writeInt(this.allHouseholdsSingleAge45to59);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsTotalAge45to59);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsMarriedAge45to59);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsSingleAge45to59);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsTotalAge45to59);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsMarriedAge45to59);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsSingleAge45to59);
                aRandomAccessFile.writeInt(this.allHouseholdsTotalAge60to64);
                aRandomAccessFile.writeInt(this.allHouseholdsMarriedAge60to64);
                aRandomAccessFile.writeInt(this.allHouseholdsSingleAge60to64);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsTotalAge60to64);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsMarriedAge60to64);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsSingleAge60to64);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsTotalAge60to64);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsMarriedAge60to64);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsSingleAge60to64);
                aRandomAccessFile.writeInt(this.allHouseholdsTotalAge65to74);
                aRandomAccessFile.writeInt(this.allHouseholdsMarriedAge65to74);
                aRandomAccessFile.writeInt(this.allHouseholdsSingleAge65to74);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsTotalAge65to74);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsMarriedAge65to74);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsSingleAge65to74);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsTotalAge65to74);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsMarriedAge65to74);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsSingleAge65to74);
                aRandomAccessFile.writeInt(this.allHouseholdsTotalAge75to84);
                aRandomAccessFile.writeInt(this.allHouseholdsMarriedAge75to84);
                aRandomAccessFile.writeInt(this.allHouseholdsSingleAge75to84);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsTotalAge75to84);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsMarriedAge75to84);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsSingleAge75to84);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsTotalAge75to84);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsMarriedAge75to84);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsSingleAge75to84);
                aRandomAccessFile.writeInt(this.allHouseholdsTotalAge85AndOver);
                aRandomAccessFile.writeInt(this.allHouseholdsMarriedAge85AndOver);
                aRandomAccessFile.writeInt(this.allHouseholdsSingleAge85AndOver);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsTotalAge85AndOver);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsMarriedAge85AndOver);
                aRandomAccessFile.writeInt(this.maleHRPHouseholdsSingleAge85AndOver);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsTotalAge85AndOver);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsMarriedAge85AndOver);
                aRandomAccessFile.writeInt(this.femaleHRPHouseholdsSingleAge85AndOver);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>CAS003DataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CAS003DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCAS003DataRecord
     *            The <code>CAS003DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public CAS003DataRecord aggregate(
            CAS003DataRecord aCAS003DataRecord) {
        CAS003DataRecord newCAS003DataRecord = new CAS003DataRecord(
                aCAS003DataRecord);
        newCAS003DataRecord.allHouseholdsTotal += getAllHouseholdsTotal();
        newCAS003DataRecord.allHouseholdsMarried += getAllHouseholdsMarried();
        newCAS003DataRecord.allHouseholdsSingle += getAllHouseholdsSingle();
        newCAS003DataRecord.maleHRPHouseholdsTotal += getMaleHRPHouseholdsTotal();
        newCAS003DataRecord.maleHRPHouseholdsMarried += getMaleHRPHouseholdsMarried();
        newCAS003DataRecord.maleHRPHouseholdsSingle += getMaleHRPHouseholdsSingle();
        newCAS003DataRecord.femaleHRPHouseholdsTotal += getFemaleHRPHouseholdsTotal();
        newCAS003DataRecord.femaleHRPHouseholdsMarried += getFemaleHRPHouseholdsMarried();
        newCAS003DataRecord.femaleHRPHouseholdsSingle += getFemaleHRPHouseholdsSingle();
        newCAS003DataRecord.allHouseholdsTotalAge19AndUnder += getAllHouseholdsTotalAge19AndUnder();
        newCAS003DataRecord.allHouseholdsMarriedAge19AndUnder += getAllHouseholdsMarriedAge19AndUnder();
        newCAS003DataRecord.allHouseholdsSingleAge19AndUnder += getAllHouseholdsSingleAge19AndUnder();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge19AndUnder += getMaleHRPHouseholdsTotalAge19AndUnder();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge19AndUnder += getMaleHRPHouseholdsMarriedAge19AndUnder();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge19AndUnder += getMaleHRPHouseholdsSingleAge19AndUnder();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge19AndUnder += getFemaleHRPHouseholdsTotalAge19AndUnder();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge19AndUnder += getFemaleHRPHouseholdsMarriedAge19AndUnder();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge19AndUnder += getFemaleHRPHouseholdsSingleAge19AndUnder();
        newCAS003DataRecord.allHouseholdsTotalAge20to24 += getAllHouseholdsTotalAge20to24();
        newCAS003DataRecord.allHouseholdsMarriedAge20to24 += getAllHouseholdsMarriedAge20to24();
        newCAS003DataRecord.allHouseholdsSingleAge20to24 += getAllHouseholdsSingleAge20to24();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge20to24 += getMaleHRPHouseholdsTotalAge20to24();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge20to24 += getMaleHRPHouseholdsMarriedAge20to24();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge20to24 += getMaleHRPHouseholdsSingleAge20to24();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge20to24 += getFemaleHRPHouseholdsTotalAge20to24();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge20to24 += getFemaleHRPHouseholdsMarriedAge20to24();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge20to24 += getFemaleHRPHouseholdsSingleAge20to24();
        newCAS003DataRecord.allHouseholdsTotalAge25to29 += getAllHouseholdsTotalAge25to29();
        newCAS003DataRecord.allHouseholdsMarriedAge25to29 += getAllHouseholdsMarriedAge25to29();
        newCAS003DataRecord.allHouseholdsSingleAge25to29 += getAllHouseholdsSingleAge25to29();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge25to29 += getMaleHRPHouseholdsTotalAge25to29();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge25to29 += getMaleHRPHouseholdsMarriedAge25to29();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge25to29 += getMaleHRPHouseholdsSingleAge25to29();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge25to29 += getFemaleHRPHouseholdsTotalAge25to29();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge25to29 += getFemaleHRPHouseholdsMarriedAge25to29();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge25to29 += getFemaleHRPHouseholdsSingleAge25to29();
        newCAS003DataRecord.allHouseholdsTotalAge30to44 += getAllHouseholdsTotalAge30to44();
        newCAS003DataRecord.allHouseholdsMarriedAge30to44 += getAllHouseholdsMarriedAge30to44();
        newCAS003DataRecord.allHouseholdsSingleAge30to44 += getAllHouseholdsSingleAge30to44();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge30to44 += getMaleHRPHouseholdsTotalAge30to44();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge30to44 += getMaleHRPHouseholdsMarriedAge30to44();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge30to44 += getMaleHRPHouseholdsSingleAge30to44();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge30to44 += getFemaleHRPHouseholdsTotalAge30to44();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge30to44 += getFemaleHRPHouseholdsMarriedAge30to44();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge30to44 += getFemaleHRPHouseholdsSingleAge30to44();
        newCAS003DataRecord.allHouseholdsTotalAge45to59 += getAllHouseholdsTotalAge45to59();
        newCAS003DataRecord.allHouseholdsMarriedAge45to59 += getAllHouseholdsMarriedAge45to59();
        newCAS003DataRecord.allHouseholdsSingleAge45to59 += getAllHouseholdsSingleAge45to59();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge45to59 += getMaleHRPHouseholdsTotalAge45to59();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge45to59 += getMaleHRPHouseholdsMarriedAge45to59();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge45to59 += getMaleHRPHouseholdsSingleAge45to59();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge45to59 += getFemaleHRPHouseholdsTotalAge45to59();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge45to59 += getFemaleHRPHouseholdsMarriedAge45to59();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge45to59 += getFemaleHRPHouseholdsSingleAge45to59();
        newCAS003DataRecord.allHouseholdsTotalAge60to64 += getAllHouseholdsTotalAge60to64();
        newCAS003DataRecord.allHouseholdsMarriedAge60to64 += getAllHouseholdsMarriedAge60to64();
        newCAS003DataRecord.allHouseholdsSingleAge60to64 += getAllHouseholdsSingleAge60to64();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge60to64 += getMaleHRPHouseholdsTotalAge60to64();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge60to64 += getMaleHRPHouseholdsMarriedAge60to64();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge60to64 += getMaleHRPHouseholdsSingleAge60to64();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge60to64 += getFemaleHRPHouseholdsTotalAge60to64();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge60to64 += getFemaleHRPHouseholdsMarriedAge60to64();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge60to64 += getFemaleHRPHouseholdsSingleAge60to64();
        newCAS003DataRecord.allHouseholdsTotalAge65to74 += getAllHouseholdsTotalAge65to74();
        newCAS003DataRecord.allHouseholdsMarriedAge65to74 += getAllHouseholdsMarriedAge65to74();
        newCAS003DataRecord.allHouseholdsSingleAge65to74 += getAllHouseholdsSingleAge65to74();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge65to74 += getMaleHRPHouseholdsTotalAge65to74();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge65to74 += getMaleHRPHouseholdsMarriedAge65to74();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge65to74 += getMaleHRPHouseholdsSingleAge65to74();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge65to74 += getFemaleHRPHouseholdsTotalAge65to74();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge65to74 += getFemaleHRPHouseholdsMarriedAge65to74();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge65to74 += getFemaleHRPHouseholdsSingleAge65to74();
        newCAS003DataRecord.allHouseholdsTotalAge75to84 += getAllHouseholdsTotalAge75to84();
        newCAS003DataRecord.allHouseholdsMarriedAge75to84 += getAllHouseholdsMarriedAge75to84();
        newCAS003DataRecord.allHouseholdsSingleAge75to84 += getAllHouseholdsSingleAge75to84();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge75to84 += getMaleHRPHouseholdsTotalAge75to84();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge75to84 += getMaleHRPHouseholdsMarriedAge75to84();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge75to84 += getMaleHRPHouseholdsSingleAge75to84();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge75to84 += getFemaleHRPHouseholdsTotalAge75to84();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge75to84 += getFemaleHRPHouseholdsMarriedAge75to84();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge75to84 += getFemaleHRPHouseholdsSingleAge75to84();
        newCAS003DataRecord.allHouseholdsTotalAge85AndOver += getAllHouseholdsTotalAge85AndOver();
        newCAS003DataRecord.allHouseholdsMarriedAge85AndOver += getAllHouseholdsMarriedAge85AndOver();
        newCAS003DataRecord.allHouseholdsSingleAge85AndOver += getAllHouseholdsSingleAge85AndOver();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge85AndOver += getMaleHRPHouseholdsTotalAge85AndOver();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge85AndOver += getMaleHRPHouseholdsMarriedAge85AndOver();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge85AndOver += getMaleHRPHouseholdsSingleAge85AndOver();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge85AndOver += getFemaleHRPHouseholdsTotalAge85AndOver();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge85AndOver += getFemaleHRPHouseholdsMarriedAge85AndOver();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge85AndOver += getFemaleHRPHouseholdsSingleAge85AndOver();
        return newCAS003DataRecord;
    }

    /**
     * @return An aggregated <code>CAS003DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CAS003DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCAS003DataRecord
     *            The <code>CAS003DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public CAS003DataRecord aggregate(CAS003DataRecord aCAS003DataRecord,
            long newRecordID, char[] newZone_Code) {
        CAS003DataRecord newCAS003DataRecord = new CAS003DataRecord(this);
        newCAS003DataRecord._RecordID = newRecordID;
        // newCAS003DataRecord.Zone_Code = aCAS003DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCAS003DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCAS003DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCAS003DataRecord.allHouseholdsTotal += getAllHouseholdsTotal();
        newCAS003DataRecord.allHouseholdsMarried += getAllHouseholdsMarried();
        newCAS003DataRecord.allHouseholdsSingle += getAllHouseholdsSingle();
        newCAS003DataRecord.maleHRPHouseholdsTotal += getMaleHRPHouseholdsTotal();
        newCAS003DataRecord.maleHRPHouseholdsMarried += getMaleHRPHouseholdsMarried();
        newCAS003DataRecord.maleHRPHouseholdsSingle += getMaleHRPHouseholdsSingle();
        newCAS003DataRecord.femaleHRPHouseholdsTotal += getFemaleHRPHouseholdsTotal();
        newCAS003DataRecord.femaleHRPHouseholdsMarried += getFemaleHRPHouseholdsMarried();
        newCAS003DataRecord.femaleHRPHouseholdsSingle += getFemaleHRPHouseholdsSingle();
        newCAS003DataRecord.allHouseholdsTotalAge19AndUnder += getAllHouseholdsTotalAge19AndUnder();
        newCAS003DataRecord.allHouseholdsMarriedAge19AndUnder += getAllHouseholdsMarriedAge19AndUnder();
        newCAS003DataRecord.allHouseholdsSingleAge19AndUnder += getAllHouseholdsSingleAge19AndUnder();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge19AndUnder += getMaleHRPHouseholdsTotalAge19AndUnder();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge19AndUnder += getMaleHRPHouseholdsMarriedAge19AndUnder();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge19AndUnder += getMaleHRPHouseholdsSingleAge19AndUnder();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge19AndUnder += getFemaleHRPHouseholdsTotalAge19AndUnder();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge19AndUnder += getFemaleHRPHouseholdsMarriedAge19AndUnder();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge19AndUnder += getFemaleHRPHouseholdsSingleAge19AndUnder();
        newCAS003DataRecord.allHouseholdsTotalAge20to24 += getAllHouseholdsTotalAge20to24();
        newCAS003DataRecord.allHouseholdsMarriedAge20to24 += getAllHouseholdsMarriedAge20to24();
        newCAS003DataRecord.allHouseholdsSingleAge20to24 += getAllHouseholdsSingleAge20to24();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge20to24 += getMaleHRPHouseholdsTotalAge20to24();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge20to24 += getMaleHRPHouseholdsMarriedAge20to24();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge20to24 += getMaleHRPHouseholdsSingleAge20to24();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge20to24 += getFemaleHRPHouseholdsTotalAge20to24();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge20to24 += getFemaleHRPHouseholdsMarriedAge20to24();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge20to24 += getFemaleHRPHouseholdsSingleAge20to24();
        newCAS003DataRecord.allHouseholdsTotalAge25to29 += getAllHouseholdsTotalAge25to29();
        newCAS003DataRecord.allHouseholdsMarriedAge25to29 += getAllHouseholdsMarriedAge25to29();
        newCAS003DataRecord.allHouseholdsSingleAge25to29 += getAllHouseholdsSingleAge25to29();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge25to29 += getMaleHRPHouseholdsTotalAge25to29();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge25to29 += getMaleHRPHouseholdsMarriedAge25to29();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge25to29 += getMaleHRPHouseholdsSingleAge25to29();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge25to29 += getFemaleHRPHouseholdsTotalAge25to29();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge25to29 += getFemaleHRPHouseholdsMarriedAge25to29();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge25to29 += getFemaleHRPHouseholdsSingleAge25to29();
        newCAS003DataRecord.allHouseholdsTotalAge30to44 += getAllHouseholdsTotalAge30to44();
        newCAS003DataRecord.allHouseholdsMarriedAge30to44 += getAllHouseholdsMarriedAge30to44();
        newCAS003DataRecord.allHouseholdsSingleAge30to44 += getAllHouseholdsSingleAge30to44();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge30to44 += getMaleHRPHouseholdsTotalAge30to44();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge30to44 += getMaleHRPHouseholdsMarriedAge30to44();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge30to44 += getMaleHRPHouseholdsSingleAge30to44();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge30to44 += getFemaleHRPHouseholdsTotalAge30to44();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge30to44 += getFemaleHRPHouseholdsMarriedAge30to44();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge30to44 += getFemaleHRPHouseholdsSingleAge30to44();
        newCAS003DataRecord.allHouseholdsTotalAge45to59 += getAllHouseholdsTotalAge45to59();
        newCAS003DataRecord.allHouseholdsMarriedAge45to59 += getAllHouseholdsMarriedAge45to59();
        newCAS003DataRecord.allHouseholdsSingleAge45to59 += getAllHouseholdsSingleAge45to59();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge45to59 += getMaleHRPHouseholdsTotalAge45to59();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge45to59 += getMaleHRPHouseholdsMarriedAge45to59();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge45to59 += getMaleHRPHouseholdsSingleAge45to59();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge45to59 += getFemaleHRPHouseholdsTotalAge45to59();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge45to59 += getFemaleHRPHouseholdsMarriedAge45to59();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge45to59 += getFemaleHRPHouseholdsSingleAge45to59();
        newCAS003DataRecord.allHouseholdsTotalAge60to64 += getAllHouseholdsTotalAge60to64();
        newCAS003DataRecord.allHouseholdsMarriedAge60to64 += getAllHouseholdsMarriedAge60to64();
        newCAS003DataRecord.allHouseholdsSingleAge60to64 += getAllHouseholdsSingleAge60to64();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge60to64 += getMaleHRPHouseholdsTotalAge60to64();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge60to64 += getMaleHRPHouseholdsMarriedAge60to64();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge60to64 += getMaleHRPHouseholdsSingleAge60to64();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge60to64 += getFemaleHRPHouseholdsTotalAge60to64();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge60to64 += getFemaleHRPHouseholdsMarriedAge60to64();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge60to64 += getFemaleHRPHouseholdsSingleAge60to64();
        newCAS003DataRecord.allHouseholdsTotalAge65to74 += getAllHouseholdsTotalAge65to74();
        newCAS003DataRecord.allHouseholdsMarriedAge65to74 += getAllHouseholdsMarriedAge65to74();
        newCAS003DataRecord.allHouseholdsSingleAge65to74 += getAllHouseholdsSingleAge65to74();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge65to74 += getMaleHRPHouseholdsTotalAge65to74();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge65to74 += getMaleHRPHouseholdsMarriedAge65to74();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge65to74 += getMaleHRPHouseholdsSingleAge65to74();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge65to74 += getFemaleHRPHouseholdsTotalAge65to74();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge65to74 += getFemaleHRPHouseholdsMarriedAge65to74();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge65to74 += getFemaleHRPHouseholdsSingleAge65to74();
        newCAS003DataRecord.allHouseholdsTotalAge75to84 += getAllHouseholdsTotalAge75to84();
        newCAS003DataRecord.allHouseholdsMarriedAge75to84 += getAllHouseholdsMarriedAge75to84();
        newCAS003DataRecord.allHouseholdsSingleAge75to84 += getAllHouseholdsSingleAge75to84();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge75to84 += getMaleHRPHouseholdsTotalAge75to84();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge75to84 += getMaleHRPHouseholdsMarriedAge75to84();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge75to84 += getMaleHRPHouseholdsSingleAge75to84();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge75to84 += getFemaleHRPHouseholdsTotalAge75to84();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge75to84 += getFemaleHRPHouseholdsMarriedAge75to84();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge75to84 += getFemaleHRPHouseholdsSingleAge75to84();
        newCAS003DataRecord.allHouseholdsTotalAge85AndOver += getAllHouseholdsTotalAge85AndOver();
        newCAS003DataRecord.allHouseholdsMarriedAge85AndOver += getAllHouseholdsMarriedAge85AndOver();
        newCAS003DataRecord.allHouseholdsSingleAge85AndOver += getAllHouseholdsSingleAge85AndOver();
        newCAS003DataRecord.maleHRPHouseholdsTotalAge85AndOver += getMaleHRPHouseholdsTotalAge85AndOver();
        newCAS003DataRecord.maleHRPHouseholdsMarriedAge85AndOver += getMaleHRPHouseholdsMarriedAge85AndOver();
        newCAS003DataRecord.maleHRPHouseholdsSingleAge85AndOver += getMaleHRPHouseholdsSingleAge85AndOver();
        newCAS003DataRecord.femaleHRPHouseholdsTotalAge85AndOver += getFemaleHRPHouseholdsTotalAge85AndOver();
        newCAS003DataRecord.femaleHRPHouseholdsMarriedAge85AndOver += getFemaleHRPHouseholdsMarriedAge85AndOver();
        newCAS003DataRecord.femaleHRPHouseholdsSingleAge85AndOver += getFemaleHRPHouseholdsSingleAge85AndOver();
        return newCAS003DataRecord;
    }

    /**
     * Returns the size of this CAS003DataRecord in bytes as a long. This does
     * not account for serialVersionUID. A boolean is assumed to be the same
     * size as an int in bytes.
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (90L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }
}