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
import java.util.HashMap;
import uk.ac.leeds.ccg.andyt.generic.core.Generic_ErrorAndExceptionHandler;
import uk.ac.leeds.ccg.andyt.projects.moses.utilities.StaticConverter;

/**
 * A <code>class</code> for representing a CAS001 Data Record and providing safe
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
 * @see CAS001DataHandler
 */
public class CAS001DataRecord extends AbstractCASDataRecord {

    /*
     * Table CS001 Age by Sex and Resident Type: All People Footnotes and
     * Comments for Table CS001 1 Communal Establishment residents includes
     * staff and their families, other residents and people sleeping rough.
     */
    /**
     * CS0010001 = allPeople
     */
    protected int allPeople;
    /**
     * CS0010002 = householdResidentsMales
     */
    protected int householdResidentsMales;
    /**
     * CS0010003 = householdResidentsFemales
     */
    protected int householdResidentsFemales;
    /**
     * CS0010004 = communalEstablishmentResidentsMales
     */
    protected int communalEstablishmentResidentsMales;
    /**
     * CS0010005 = communalEstablishmentResidentsFemales
     */
    protected int communalEstablishmentResidentsFemales;
    /**
     * CS0010006 = allPeopleAge0to4
     */
    protected int allPeopleAge0to4;
    /**
     * CS0010007 = householdResidentsMalesAge0to4
     */
    protected int householdResidentsMalesAge0to4;
    /**
     * CS0010008 = householdResidentsFemalesAge0to4
     */
    protected int householdResidentsFemalesAge0to4;
    /**
     * CS0010009 = communalEstablishmentResidentsMalesAge0to4
     */
    protected int communalEstablishmentResidentsMalesAge0to4;
    /**
     * CS0010010 = communalEstablishmentResidentsFemalesAge0to4
     */
    protected int communalEstablishmentResidentsFemalesAge0to4;
    /**
     * CS0010011 = allPeopleAge0
     */
    protected int allPeopleAge0;
    /**
     * CS0010012 = householdResidentsMalesAge0
     */
    protected int householdResidentsMalesAge0;
    /**
     * CS0010013 = householdResidentsFemalesAge0
     */
    protected int householdResidentsFemalesAge0;
    /**
     * CS0010014 = communalEstablishmentResidentsMalesAge0
     */
    protected int communalEstablishmentResidentsMalesAge0;
    /**
     * CS0010015 = communalEstablishmentResidentsFemalesAge0
     */
    protected int communalEstablishmentResidentsFemalesAge0;
    /**
     * CS0010016 = allPeopleAge1
     */
    protected int allPeopleAge1;
    /**
     * CS0010017 = householdResidentsMalesAge1
     */
    protected int householdResidentsMalesAge1;
    /**
     * CS0010018 = householdResidentsFemalesAge1
     */
    protected int householdResidentsFemalesAge1;
    /**
     * CS0010019 = communalEstablishmentResidentsMalesAge1
     */
    protected int communalEstablishmentResidentsMalesAge1;
    /**
     * CS0010020 = communalEstablishmentResidentsFemalesAge1
     */
    protected int communalEstablishmentResidentsFemalesAge1;
    /**
     * CS0010021 = allPeopleAge2
     */
    protected int allPeopleAge2;
    /**
     * CS0010022 = householdResidentsMalesAge2
     */
    protected int householdResidentsMalesAge2;
    /**
     * CS0010023 = householdResidentsFemalesAge2
     */
    protected int householdResidentsFemalesAge2;
    /**
     * CS0010024 = communalEstablishmentResidentsMalesAge2
     */
    protected int communalEstablishmentResidentsMalesAge2;
    /**
     * CS0010025 = communalEstablishmentResidentsFemalesAge2
     */
    protected int communalEstablishmentResidentsFemalesAge2;
    /**
     * CS0010026 = allPeopleAge3
     */
    protected int allPeopleAge3;
    /**
     * CS0010027 = householdResidentsMalesAge3
     */
    protected int householdResidentsMalesAge3;
    /**
     * CS0010028 = householdResidentsFemalesAge3
     */
    protected int householdResidentsFemalesAge3;
    /**
     * CS0010029 = communalEstablishmentResidentsMalesAge3
     */
    protected int communalEstablishmentResidentsMalesAge3;
    /**
     * CS0010030 = communalEstablishmentResidentsFemalesAge3
     */
    protected int communalEstablishmentResidentsFemalesAge3;
    /**
     * CS0010031 = allPeopleAge4
     */
    protected int allPeopleAge4;
    /**
     * CS0010032 = householdResidentsMalesAge4
     */
    protected int householdResidentsMalesAge4;
    /**
     * CS0010033 = householdResidentsFemalesAge4
     */
    protected int householdResidentsFemalesAge4;
    /**
     * CS0010034 = communalEstablishmentResidentsMalesAge4
     */
    protected int communalEstablishmentResidentsMalesAge4;
    /**
     * CS0010035 = communalEstablishmentResidentsFemalesAge4
     */
    protected int communalEstablishmentResidentsFemalesAge4;
    /**
     * CS0010036 = allPeopleAge5to9
     */
    protected int allPeopleAge5to9;
    /**
     * CS0010037 = householdResidentsMalesAge5to9
     */
    protected int householdResidentsMalesAge5to9;
    /**
     * CS0010038 = householdResidentsFemalesAge5to9
     */
    protected int householdResidentsFemalesAge5to9;
    /**
     * CS0010039 = communalEstablishmentResidentsMalesAge5to9
     */
    protected int communalEstablishmentResidentsMalesAge5to9;
    /**
     * CS0010040 = communalEstablishmentResidentsFemalesAge5to9
     */
    protected int communalEstablishmentResidentsFemalesAge5to9;
    /**
     * CS0010041 = allPeopleAge5
     */
    protected int allPeopleAge5;
    /**
     * CS0010042 = householdResidentsMalesAge5
     */
    protected int householdResidentsMalesAge5;
    /**
     * CS0010043 = householdResidentsFemalesAge5
     */
    protected int householdResidentsFemalesAge5;
    /**
     * CS0010044 = communalEstablishmentResidentsMalesAge5
     */
    protected int communalEstablishmentResidentsMalesAge5;
    /**
     * CS0010045 = communalEstablishmentResidentsFemalesAge5
     */
    protected int communalEstablishmentResidentsFemalesAge5;
    /**
     * CS0010046 = allPeopleAge6
     */
    protected int allPeopleAge6;
    /**
     * CS0010047 = householdResidentsMalesAge6
     */
    protected int householdResidentsMalesAge6;
    /**
     * CS0010048 = householdResidentsFemalesAge6
     */
    protected int householdResidentsFemalesAge6;
    /**
     * CS0010049 = communalEstablishmentResidentsMalesAge6
     */
    protected int communalEstablishmentResidentsMalesAge6;
    /**
     * CS0010050 = communalEstablishmentResidentsFemalesAge6
     */
    protected int communalEstablishmentResidentsFemalesAge6;
    /**
     * CS0010051 = allPeopleAge7
     */
    protected int allPeopleAge7;
    /**
     * CS0010052 = householdResidentsMalesAge7
     */
    protected int householdResidentsMalesAge7;
    /**
     * CS0010053 = householdResidentsFemalesAge7
     */
    protected int householdResidentsFemalesAge7;
    /**
     * CS0010054 = communalEstablishmentResidentsMalesAge7
     */
    protected int communalEstablishmentResidentsMalesAge7;
    /**
     * CS0010055 = communalEstablishmentResidentsFemalesAge7
     */
    protected int communalEstablishmentResidentsFemalesAge7;
    /**
     * CS0010056 = allPeopleAge8
     */
    protected int allPeopleAge8;
    /**
     * CS0010057 = householdResidentsMalesAge8
     */
    protected int householdResidentsMalesAge8;
    /**
     * CS0010058 = householdResidentsFemalesAge8
     */
    protected int householdResidentsFemalesAge8;
    /**
     * CS0010059 = communalEstablishmentResidentsMalesAge8
     */
    protected int communalEstablishmentResidentsMalesAge8;
    /**
     * CS0010060 = communalEstablishmentResidentsFemalesAge8
     */
    protected int communalEstablishmentResidentsFemalesAge8;
    /**
     * CS0010061 = allPeopleAge9
     */
    protected int allPeopleAge9;
    /**
     * CS0010062 = householdResidentsMalesAge9
     */
    protected int householdResidentsMalesAge9;
    /**
     * CS0010063 = householdResidentsFemalesAge9
     */
    protected int householdResidentsFemalesAge9;
    /**
     * CS0010064 = communalEstablishmentResidentsMalesAge9
     */
    protected int communalEstablishmentResidentsMalesAge9;
    /**
     * CS0010065 = communalEstablishmentResidentsFemalesAge9
     */
    protected int communalEstablishmentResidentsFemalesAge9;
    /**
     * CS0010066 = allPeopleAge10to14
     */
    protected int allPeopleAge10to14;
    /**
     * CS0010067 = householdResidentsMalesAge10to14
     */
    protected int householdResidentsMalesAge10to14;
    /**
     * CS0010068 = householdResidentsFemalesAge10to14
     */
    protected int householdResidentsFemalesAge10to14;
    /**
     * CS0010069 = communalEstablishmentResidentsMalesAge10to14
     */
    protected int communalEstablishmentResidentsMalesAge10to14;
    /**
     * CS0010070 = communalEstablishmentResidentsFemalesAge10to14
     */
    protected int communalEstablishmentResidentsFemalesAge10to14;
    /**
     * CS0010071 = allPeopleAge10
     */
    protected int allPeopleAge10;
    /**
     * CS0010072 = householdResidentsMalesAge10
     */
    protected int householdResidentsMalesAge10;
    /**
     * CS0010073 = householdResidentsFemalesAge10
     */
    protected int householdResidentsFemalesAge10;
    /**
     * CS0010074 = communalEstablishmentResidentsMalesAge10
     */
    protected int communalEstablishmentResidentsMalesAge10;
    /**
     * CS0010075 = communalEstablishmentResidentsFemalesAge10
     */
    protected int communalEstablishmentResidentsFemalesAge10;
    /**
     * CS0010076 = allPeopleAge11
     */
    protected int allPeopleAge11;
    /**
     * CS0010077 = householdResidentsMalesAge11
     */
    protected int householdResidentsMalesAge11;
    /**
     * CS0010078 = householdResidentsFemalesAge11
     */
    protected int householdResidentsFemalesAge11;
    /**
     * CS0010079 = communalEstablishmentResidentsMalesAge11
     */
    protected int communalEstablishmentResidentsMalesAge11;
    /**
     * CS0010080 = communalEstablishmentResidentsFemalesAge11
     */
    protected int communalEstablishmentResidentsFemalesAge11;
    /**
     * CS0010081 = allPeopleAge12
     */
    protected int allPeopleAge12;
    /**
     * CS0010082 = householdResidentsMalesAge12
     */
    protected int householdResidentsMalesAge12;
    /**
     * CS0010083 = householdResidentsFemalesAge12
     */
    protected int householdResidentsFemalesAge12;
    /**
     * CS0010084 = communalEstablishmentResidentsMalesAge12
     */
    protected int communalEstablishmentResidentsMalesAge12;
    /**
     * CS0010085 = communalEstablishmentResidentsFemalesAge12
     */
    protected int communalEstablishmentResidentsFemalesAge12;
    /**
     * CS0010086 = allPeopleAge13
     */
    protected int allPeopleAge13;
    /**
     * CS0010087 = householdResidentsMalesAge13
     */
    protected int householdResidentsMalesAge13;
    /**
     * CS0010088 = householdResidentsFemalesAge13
     */
    protected int householdResidentsFemalesAge13;
    /**
     * CS0010089 = communalEstablishmentResidentsMalesAge13
     */
    protected int communalEstablishmentResidentsMalesAge13;
    /**
     * CS0010090 = communalEstablishmentResidentsFemalesAge13
     */
    protected int communalEstablishmentResidentsFemalesAge13;
    /**
     * CS0010091 = allPeopleAge14
     */
    protected int allPeopleAge14;
    /**
     * CS0010092 = householdResidentsMalesAge14
     */
    protected int householdResidentsMalesAge14;
    /**
     * CS0010093 = householdResidentsFemalesAge14
     */
    protected int householdResidentsFemalesAge14;
    /**
     * CS0010094 = communalEstablishmentResidentsMalesAge14
     */
    protected int communalEstablishmentResidentsMalesAge14;
    /**
     * CS0010095 = communalEstablishmentResidentsFemalesAge14
     */
    protected int communalEstablishmentResidentsFemalesAge14;
    /**
     * CS0010096 = allPeopleAge15to19
     */
    protected int allPeopleAge15to19;
    /**
     * CS0010097 = householdResidentsMalesAge15to19
     */
    protected int householdResidentsMalesAge15to19;
    /**
     * CS0010098 = householdResidentsFemalesAge15to19
     */
    protected int householdResidentsFemalesAge15to19;
    /**
     * CS0010099 = communalEstablishmentResidentsMalesAge15to19
     */
    protected int communalEstablishmentResidentsMalesAge15to19;
    /**
     * CS0010100 = communalEstablishmentResidentsFemalesAge15to19
     */
    protected int communalEstablishmentResidentsFemalesAge15to19;
    /**
     * CS0010101 = allPeopleAge15
     */
    protected int allPeopleAge15;
    /**
     * CS0010102 = householdResidentsMalesAge15
     */
    protected int householdResidentsMalesAge15;
    /**
     * CS0010103 = householdResidentsFemalesAge15
     */
    protected int householdResidentsFemalesAge15;
    /**
     * CS0010104 = communalEstablishmentResidentsMalesAge15
     */
    protected int communalEstablishmentResidentsMalesAge15;
    /**
     * CS0010105 = communalEstablishmentResidentsFemalesAge15
     */
    protected int communalEstablishmentResidentsFemalesAge15;
    /**
     * CS0010106 = allPeopleAge16
     */
    protected int allPeopleAge16;
    /**
     * CS0010107 = householdResidentsMalesAge16
     */
    protected int householdResidentsMalesAge16;
    /**
     * CS0010108 = householdResidentsFemalesAge16
     */
    protected int householdResidentsFemalesAge16;
    /**
     * CS0010109 = communalEstablishmentResidentsMalesAge16
     */
    protected int communalEstablishmentResidentsMalesAge16;
    /**
     * CS0010110 = communalEstablishmentResidentsFemalesAge16
     */
    protected int communalEstablishmentResidentsFemalesAge16;
    /**
     * CS0010111 = allPeopleAge17
     */
    protected int allPeopleAge17;
    /**
     * CS0010112 = householdResidentsMalesAge17
     */
    protected int householdResidentsMalesAge17;
    /**
     * CS0010113 = householdResidentsFemalesAge17
     */
    protected int householdResidentsFemalesAge17;
    /**
     * CS0010114 = communalEstablishmentResidentsMalesAge17
     */
    protected int communalEstablishmentResidentsMalesAge17;
    /**
     * CS0010115 = communalEstablishmentResidentsFemalesAge17
     */
    protected int communalEstablishmentResidentsFemalesAge17;
    /**
     * CS0010116 = allPeopleAge18
     */
    protected int allPeopleAge18;
    /**
     * CS0010117 = householdResidentsMalesAge18
     */
    protected int householdResidentsMalesAge18;
    /**
     * CS0010118 = householdResidentsFemalesAge18
     */
    protected int householdResidentsFemalesAge18;
    /**
     * CS0010119 = communalEstablishmentResidentsMalesAge18
     */
    protected int communalEstablishmentResidentsMalesAge18;
    /**
     * CS0010120 = communalEstablishmentResidentsFemalesAge18
     */
    protected int communalEstablishmentResidentsFemalesAge18;
    /**
     * CS0010121 = allPeopleAge19
     */
    protected int allPeopleAge19;
    /**
     * CS0010122 = householdResidentsMalesAge19
     */
    protected int householdResidentsMalesAge19;
    /**
     * CS0010123 = householdResidentsFemalesAge19
     */
    protected int householdResidentsFemalesAge19;
    /**
     * CS0010124 = communalEstablishmentResidentsMalesAge19
     */
    protected int communalEstablishmentResidentsMalesAge19;
    /**
     * CS0010125 = communalEstablishmentResidentsFemalesAge19
     */
    protected int communalEstablishmentResidentsFemalesAge19;
    /**
     * CS0010126 = allPeopleAge20to24
     */
    protected int allPeopleAge20to24;
    /**
     * CS0010127 = householdResidentsMalesAge20to24
     */
    protected int householdResidentsMalesAge20to24;
    /**
     * CS0010128 = householdResidentsFemalesAge20to24
     */
    protected int householdResidentsFemalesAge20to24;
    /**
     * CS0010129 = communalEstablishmentResidentsMalesAge20to24
     */
    protected int communalEstablishmentResidentsMalesAge20to24;
    /**
     * CS0010130 = communalEstablishmentResidentsFemalesAge20to24
     */
    protected int communalEstablishmentResidentsFemalesAge20to24;
    /**
     * CS0010131 = allPeopleAge20
     */
    protected int allPeopleAge20;
    /**
     * CS0010132 = householdResidentsMalesAge20
     */
    protected int householdResidentsMalesAge20;
    /**
     * CS0010133 = householdResidentsFemalesAge20
     */
    protected int householdResidentsFemalesAge20;
    /**
     * CS0010134 = communalEstablishmentResidentsMalesAge20
     */
    protected int communalEstablishmentResidentsMalesAge20;
    /**
     * CS0010135 = communalEstablishmentResidentsFemalesAge20
     */
    protected int communalEstablishmentResidentsFemalesAge20;
    /**
     * CS0010136 = allPeopleAge21
     */
    protected int allPeopleAge21;
    /**
     * CS0010137 = householdResidentsMalesAge21
     */
    protected int householdResidentsMalesAge21;
    /**
     * CS0010138 = householdResidentsFemalesAge21
     */
    protected int householdResidentsFemalesAge21;
    /**
     * CS0010139 = communalEstablishmentResidentsMalesAge21
     */
    protected int communalEstablishmentResidentsMalesAge21;
    /**
     * CS0010140 = communalEstablishmentResidentsFemalesAge21
     */
    protected int communalEstablishmentResidentsFemalesAge21;
    /**
     * CS0010141 = allPeopleAge22
     */
    protected int allPeopleAge22;
    /**
     * CS0010142 = householdResidentsMalesAge22
     */
    protected int householdResidentsMalesAge22;
    /**
     * CS0010143 = householdResidentsFemalesAge22
     */
    protected int householdResidentsFemalesAge22;
    /**
     * CS0010144 = communalEstablishmentResidentsMalesAge22
     */
    protected int communalEstablishmentResidentsMalesAge22;
    /**
     * CS0010145 = communalEstablishmentResidentsFemalesAge22
     */
    protected int communalEstablishmentResidentsFemalesAge22;
    /**
     * CS0010146 = allPeopleAge23
     */
    protected int allPeopleAge23;
    /**
     * CS0010147 = householdResidentsMalesAge23
     */
    protected int householdResidentsMalesAge23;
    /**
     * CS0010148 = householdResidentsFemalesAge23
     */
    protected int householdResidentsFemalesAge23;
    /**
     * CS0010149 = communalEstablishmentResidentsMalesAge23
     */
    protected int communalEstablishmentResidentsMalesAge23;
    /**
     * CS0010150 = communalEstablishmentResidentsFemalesAge23
     */
    protected int communalEstablishmentResidentsFemalesAge23;
    /**
     * CS0010151 = allPeopleAge24
     */
    protected int allPeopleAge24;
    /**
     * CS0010152 = householdResidentsMalesAge24
     */
    protected int householdResidentsMalesAge24;
    /**
     * CS0010153 = householdResidentsFemalesAge24
     */
    protected int householdResidentsFemalesAge24;
    /**
     * CS0010154 = communalEstablishmentResidentsMalesAge24
     */
    protected int communalEstablishmentResidentsMalesAge24;
    /**
     * CS0010155 = communalEstablishmentResidentsFemalesAge24
     */
    protected int communalEstablishmentResidentsFemalesAge24;
    /**
     * CS0010156 = allPeopleAge25to29
     */
    protected int allPeopleAge25to29;
    /**
     * CS0010157 = householdResidentsMalesAge25to29
     */
    protected int householdResidentsMalesAge25to29;
    /**
     * CS0010158 = householdResidentsFemalesAge25to29
     */
    protected int householdResidentsFemalesAge25to29;
    /**
     * CS0010159 = communalEstablishmentResidentsMalesAge25to29
     */
    protected int communalEstablishmentResidentsMalesAge25to29;
    /**
     * CS0010160 = communalEstablishmentResidentsFemalesAge25to29
     */
    protected int communalEstablishmentResidentsFemalesAge25to29;
    /**
     * CS0010161 = allPeopleAge30to34
     */
    protected int allPeopleAge30to34;
    /**
     * CS0010162 = householdResidentsMalesAge30to34
     */
    protected int householdResidentsMalesAge30to34;
    /**
     * CS0010163 = householdResidentsFemalesAge30to34
     */
    protected int householdResidentsFemalesAge30to34;
    /**
     * CS0010164 = communalEstablishmentResidentsMalesAge30to34
     */
    protected int communalEstablishmentResidentsMalesAge30to34;
    /**
     * CS0010165 = communalEstablishmentResidentsFemalesAge30to34
     */
    protected int communalEstablishmentResidentsFemalesAge30to34;
    /**
     * CS0010166 = allPeopleAge35to39
     */
    protected int allPeopleAge35to39;
    /**
     * CS0010167 = householdResidentsMalesAge35to39
     */
    protected int householdResidentsMalesAge35to39;
    /**
     * CS0010168 = householdResidentsFemalesAge35to39
     */
    protected int householdResidentsFemalesAge35to39;
    /**
     * CS0010169 = communalEstablishmentResidentsMalesAge35to39
     */
    protected int communalEstablishmentResidentsMalesAge35to39;
    /**
     * CS0010170 = communalEstablishmentResidentsFemalesAge35to39
     */
    protected int communalEstablishmentResidentsFemalesAge35to39;
    /**
     * CS0010171 = allPeopleAge40to44
     */
    protected int allPeopleAge40to44;
    /**
     * CS0010172 = householdResidentsMalesAge40to44
     */
    protected int householdResidentsMalesAge40to44;
    /**
     * CS0010173 = householdResidentsFemalesAge40to44
     */
    protected int householdResidentsFemalesAge40to44;
    /**
     * CS0010174 = communalEstablishmentResidentsMalesAge40to44
     */
    protected int communalEstablishmentResidentsMalesAge40to44;
    /**
     * CS0010175 = communalEstablishmentResidentsFemalesAge40to44
     */
    protected int communalEstablishmentResidentsFemalesAge40to44;
    /**
     * CS0010176 = allPeopleAge45to49
     */
    protected int allPeopleAge45to49;
    /**
     * CS0010177 = householdResidentsMalesAge45to49
     */
    protected int householdResidentsMalesAge45to49;
    /**
     * CS0010178 = householdResidentsFemalesAge45to49
     */
    protected int householdResidentsFemalesAge45to49;
    /**
     * CS0010179 = communalEstablishmentResidentsMalesAge45to49
     */
    protected int communalEstablishmentResidentsMalesAge45to49;
    /**
     * CS0010180 = communalEstablishmentResidentsFemalesAge45to49
     */
    protected int communalEstablishmentResidentsFemalesAge45to49;
    /**
     * CS0010181 = allPeopleAge50to54
     */
    protected int allPeopleAge50to54;
    /**
     * CS0010182 = householdResidentsMalesAge50to54
     */
    protected int householdResidentsMalesAge50to54;
    /**
     * CS0010183 = householdResidentsFemalesAge50to54
     */
    protected int householdResidentsFemalesAge50to54;
    /**
     * CS0010184 = communalEstablishmentResidentsMalesAge50to54
     */
    protected int communalEstablishmentResidentsMalesAge50to54;
    /**
     * CS0010185 = communalEstablishmentResidentsFemalesAge50to54
     */
    protected int communalEstablishmentResidentsFemalesAge50to54;
    /**
     * CS0010186 = allPeopleAge55to59
     */
    protected int allPeopleAge55to59;
    /**
     * CS0010187 = householdResidentsMalesAge55to59
     */
    protected int householdResidentsMalesAge55to59;
    /**
     * CS0010188 = householdResidentsFemalesAge55to59
     */
    protected int householdResidentsFemalesAge55to59;
    /**
     * CS0010189 = communalEstablishmentResidentsMalesAge55to59
     */
    protected int communalEstablishmentResidentsMalesAge55to59;
    /**
     * CS0010190 = communalEstablishmentResidentsFemalesAge55to59
     */
    protected int communalEstablishmentResidentsFemalesAge55to59;
    /**
     * CS0010191 = allPeopleAge60to64
     */
    protected int allPeopleAge60to64;
    /**
     * CS0010192 = householdResidentsMalesAge60to64
     */
    protected int householdResidentsMalesAge60to64;
    /**
     * CS0010193 = householdResidentsFemalesAge60to64
     */
    protected int householdResidentsFemalesAge60to64;
    /**
     * CS0010194 = communalEstablishmentResidentsMalesAge60to64
     */
    protected int communalEstablishmentResidentsMalesAge60to64;
    /**
     * CS0010195 = communalEstablishmentResidentsFemalesAge60to64
     */
    protected int communalEstablishmentResidentsFemalesAge60to64;
    /**
     * CS0010196 = allPeopleAge65to69
     */
    protected int allPeopleAge65to69;
    /**
     * CS0010197 = householdResidentsMalesAge65to69
     */
    protected int householdResidentsMalesAge65to69;
    /**
     * CS0010198 = householdResidentsFemalesAge65to69
     */
    protected int householdResidentsFemalesAge65to69;
    /**
     * CS0010199 = communalEstablishmentResidentsMalesAge65to69
     */
    protected int communalEstablishmentResidentsMalesAge65to69;
    /**
     * CS0010200 = communalEstablishmentResidentsFemalesAge65to69
     */
    protected int communalEstablishmentResidentsFemalesAge65to69;
    /**
     * CS0010201 = allPeopleAge70to74
     */
    protected int allPeopleAge70to74;
    /**
     * CS0010202 = householdResidentsMalesAge70to74
     */
    protected int householdResidentsMalesAge70to74;
    /**
     * CS0010203 = householdResidentsFemalesAge70to74
     */
    protected int householdResidentsFemalesAge70to74;
    /**
     * CS0010204 = communalEstablishmentResidentsMalesAge70to74
     */
    protected int communalEstablishmentResidentsMalesAge70to74;
    /**
     * CS0010205 = communalEstablishmentResidentsFemalesAge70to74
     */
    protected int communalEstablishmentResidentsFemalesAge70to74;
    /**
     * CS0010206 = allPeopleAge75to79
     */
    protected int allPeopleAge75to79;
    /**
     * CS0010207 = householdResidentsMalesAge75to79
     */
    protected int householdResidentsMalesAge75to79;
    /**
     * CS0010208 = householdResidentsFemalesAge75to79
     */
    protected int householdResidentsFemalesAge75to79;
    /**
     * CS0010209 = communalEstablishmentResidentsMalesAge75to79
     */
    protected int communalEstablishmentResidentsMalesAge75to79;
    /**
     * CS0010210 = communalEstablishmentResidentsFemalesAge75to79
     */
    protected int communalEstablishmentResidentsFemalesAge75to79;
    /**
     * CS0010211 = allPeopleAge80to84
     */
    protected int allPeopleAge80to84;
    /**
     * CS0010212 = householdResidentsMalesAge80to84
     */
    protected int householdResidentsMalesAge80to84;
    /**
     * CS0010213 = householdResidentsFemalesAge80to84
     */
    protected int householdResidentsFemalesAge80to84;
    /**
     * CS0010214 = communalEstablishmentResidentsMalesAge80to84
     */
    protected int communalEstablishmentResidentsMalesAge80to84;
    /**
     * CS0010215 = communalEstablishmentResidentsFemalesAge80to84
     */
    protected int communalEstablishmentResidentsFemalesAge80to84;
    /**
     * CS0010216 = allPeopleAge85to89
     */
    protected int allPeopleAge85to89;
    /**
     * CS0010217 = householdResidentsMalesAge85to89
     */
    protected int householdResidentsMalesAge85to89;
    /**
     * CS0010218 = householdResidentsFemalesAge85to89
     */
    protected int householdResidentsFemalesAge85to89;
    /**
     * CS0010219 = communalEstablishmentResidentsMalesAge85to89
     */
    protected int communalEstablishmentResidentsMalesAge85to89;
    /**
     * CS0010220 = communalEstablishmentResidentsFemalesAge85to89
     */
    protected int communalEstablishmentResidentsFemalesAge85to89;
    /**
     * CS0010221 = allPeopleAge90AndOver
     */
    protected int allPeopleAge90AndOver;
    /**
     * CS0010222 = householdResidentsMalesAge90AndOver
     */
    protected int householdResidentsMalesAge90AndOver;
    /**
     * CS0010223 = householdResidentsFemalesAge90AndOver
     */
    protected int householdResidentsFemalesAge90AndOver;
    /**
     * CS0010224 = communalEstablishmentResidentsMalesAge90AndOver
     */
    protected int communalEstablishmentResidentsMalesAge90AndOver;
    /**
     * CS0010225 = communalEstablishmentResidentsFemalesAge90AndOver
     */
    protected int communalEstablishmentResidentsFemalesAge90AndOver;

    /** Creates a new CAS001DataRecord */
    public CAS001DataRecord() {
        _Init();
    }

    /**
     * Creates a new CAS001DataRecord cloned from aCAS001DataRecord
     *
     * @param aCAS001DataRecord
     *            The CAS001DataRecord from which this is cloned.
     */
    public CAS001DataRecord(CAS001DataRecord aCAS001DataRecord) {
        init(aCAS001DataRecord);
    }

    /**
     * Creates a new CAS001DataRecord
     *
     * @param initZero
     *            To ensure initZero() is used instead of _Init()
     */
    public CAS001DataRecord(boolean initZero) {
        initZero();
    }

    /**
     * Creates a new CAS001DataRecord
     *
     * @param RecordID
     *            The RecordID to be assigned to this
     * @param line
     *            The Comma Seperated Value <code>String</code>
     * @throws java.io.IOException
     */
    public CAS001DataRecord(long RecordID, String line) throws IOException {
        String[] fields = line.split(",");
        // String[] fieldsDummy = line.split( "," );
        // String[] fields = new String[ 226 ];
        // for ( int i = 0; i < fields.length; i ++ ) {
        // fields[ i ] = "";
        // }
        // System.arraycopy( fieldsDummy, 0, fields, 0, fields.length );
        this._RecordID = RecordID;
        this.Zone_Code = fields[0].substring(1, 11).toCharArray();
        // From Table CAS001
        this.allPeople = StaticConverter.to_int(fields[1]);
        this.householdResidentsMales = StaticConverter.to_int(fields[2]);
        this.householdResidentsFemales = StaticConverter.to_int(fields[3]);
        this.communalEstablishmentResidentsMales = StaticConverter.to_int(fields[4]);
        this.communalEstablishmentResidentsFemales = StaticConverter.to_int(fields[5]);
        this.allPeopleAge0to4 = StaticConverter.to_int(fields[6]);
        this.householdResidentsMalesAge0to4 = StaticConverter.to_int(fields[7]);
        this.householdResidentsFemalesAge0to4 = StaticConverter.to_int(fields[8]);
        this.communalEstablishmentResidentsMalesAge0to4 = StaticConverter.to_int(fields[9]);
        this.communalEstablishmentResidentsFemalesAge0to4 = StaticConverter.to_int(fields[10]);
        this.allPeopleAge0 = StaticConverter.to_int(fields[11]);
        this.householdResidentsMalesAge0 = StaticConverter.to_int(fields[12]);
        this.householdResidentsFemalesAge0 = StaticConverter.to_int(fields[13]);
        this.communalEstablishmentResidentsMalesAge0 = StaticConverter.to_int(fields[14]);
        this.communalEstablishmentResidentsFemalesAge0 = StaticConverter.to_int(fields[15]);
        this.allPeopleAge1 = StaticConverter.to_int(fields[16]);
        this.householdResidentsMalesAge1 = StaticConverter.to_int(fields[17]);
        this.householdResidentsFemalesAge1 = StaticConverter.to_int(fields[18]);
        this.communalEstablishmentResidentsMalesAge1 = StaticConverter.to_int(fields[19]);
        this.communalEstablishmentResidentsFemalesAge1 = StaticConverter.to_int(fields[20]);
        this.allPeopleAge2 = StaticConverter.to_int(fields[21]);
        this.householdResidentsMalesAge2 = StaticConverter.to_int(fields[22]);
        this.householdResidentsFemalesAge2 = StaticConverter.to_int(fields[23]);
        this.communalEstablishmentResidentsMalesAge2 = StaticConverter.to_int(fields[24]);
        this.communalEstablishmentResidentsFemalesAge2 = StaticConverter.to_int(fields[25]);
        this.allPeopleAge3 = StaticConverter.to_int(fields[26]);
        this.householdResidentsMalesAge3 = StaticConverter.to_int(fields[27]);
        this.householdResidentsFemalesAge3 = StaticConverter.to_int(fields[28]);
        this.communalEstablishmentResidentsMalesAge3 = StaticConverter.to_int(fields[29]);
        this.communalEstablishmentResidentsFemalesAge3 = StaticConverter.to_int(fields[30]);
        this.allPeopleAge4 = StaticConverter.to_int(fields[31]);
        this.householdResidentsMalesAge4 = StaticConverter.to_int(fields[32]);
        this.householdResidentsFemalesAge4 = StaticConverter.to_int(fields[33]);
        this.communalEstablishmentResidentsMalesAge4 = StaticConverter.to_int(fields[34]);
        this.communalEstablishmentResidentsFemalesAge4 = StaticConverter.to_int(fields[35]);
        this.allPeopleAge5to9 = StaticConverter.to_int(fields[36]);
        this.householdResidentsMalesAge5to9 = StaticConverter.to_int(fields[37]);
        this.householdResidentsFemalesAge5to9 = StaticConverter.to_int(fields[38]);
        this.communalEstablishmentResidentsMalesAge5to9 = StaticConverter.to_int(fields[39]);
        this.communalEstablishmentResidentsFemalesAge5to9 = StaticConverter.to_int(fields[40]);
        this.allPeopleAge5 = StaticConverter.to_int(fields[41]);
        this.householdResidentsMalesAge5 = StaticConverter.to_int(fields[42]);
        this.householdResidentsFemalesAge5 = StaticConverter.to_int(fields[43]);
        this.communalEstablishmentResidentsMalesAge5 = StaticConverter.to_int(fields[44]);
        this.communalEstablishmentResidentsFemalesAge5 = StaticConverter.to_int(fields[45]);
        this.allPeopleAge6 = StaticConverter.to_int(fields[46]);
        this.householdResidentsMalesAge6 = StaticConverter.to_int(fields[47]);
        this.householdResidentsFemalesAge6 = StaticConverter.to_int(fields[48]);
        this.communalEstablishmentResidentsMalesAge6 = StaticConverter.to_int(fields[49]);
        this.communalEstablishmentResidentsFemalesAge6 = StaticConverter.to_int(fields[50]);
        this.allPeopleAge7 = StaticConverter.to_int(fields[51]);
        this.householdResidentsMalesAge7 = StaticConverter.to_int(fields[52]);
        this.householdResidentsFemalesAge7 = StaticConverter.to_int(fields[53]);
        this.communalEstablishmentResidentsMalesAge7 = StaticConverter.to_int(fields[54]);
        this.communalEstablishmentResidentsFemalesAge7 = StaticConverter.to_int(fields[55]);
        this.allPeopleAge8 = StaticConverter.to_int(fields[56]);
        this.householdResidentsMalesAge8 = StaticConverter.to_int(fields[57]);
        this.householdResidentsFemalesAge8 = StaticConverter.to_int(fields[58]);
        this.communalEstablishmentResidentsMalesAge8 = StaticConverter.to_int(fields[59]);
        this.communalEstablishmentResidentsFemalesAge8 = StaticConverter.to_int(fields[60]);
        this.allPeopleAge9 = StaticConverter.to_int(fields[61]);
        this.householdResidentsMalesAge9 = StaticConverter.to_int(fields[62]);
        this.householdResidentsFemalesAge9 = StaticConverter.to_int(fields[63]);
        this.communalEstablishmentResidentsMalesAge9 = StaticConverter.to_int(fields[64]);
        this.communalEstablishmentResidentsFemalesAge9 = StaticConverter.to_int(fields[65]);
        this.allPeopleAge10to14 = StaticConverter.to_int(fields[66]);
        this.householdResidentsMalesAge10to14 = StaticConverter.to_int(fields[67]);
        this.householdResidentsFemalesAge10to14 = StaticConverter.to_int(fields[68]);
        this.communalEstablishmentResidentsMalesAge10to14 = StaticConverter.to_int(fields[69]);
        this.communalEstablishmentResidentsFemalesAge10to14 = StaticConverter.to_int(fields[70]);
        this.allPeopleAge10 = StaticConverter.to_int(fields[71]);
        this.householdResidentsMalesAge10 = StaticConverter.to_int(fields[72]);
        this.householdResidentsFemalesAge10 = StaticConverter.to_int(fields[73]);
        this.communalEstablishmentResidentsMalesAge10 = StaticConverter.to_int(fields[74]);
        this.communalEstablishmentResidentsFemalesAge10 = StaticConverter.to_int(fields[75]);
        this.allPeopleAge11 = StaticConverter.to_int(fields[76]);
        this.householdResidentsMalesAge11 = StaticConverter.to_int(fields[77]);
        this.householdResidentsFemalesAge11 = StaticConverter.to_int(fields[78]);
        this.communalEstablishmentResidentsMalesAge11 = StaticConverter.to_int(fields[79]);
        this.communalEstablishmentResidentsFemalesAge11 = StaticConverter.to_int(fields[80]);
        this.allPeopleAge12 = StaticConverter.to_int(fields[81]);
        this.householdResidentsMalesAge12 = StaticConverter.to_int(fields[82]);
        this.householdResidentsFemalesAge12 = StaticConverter.to_int(fields[83]);
        this.communalEstablishmentResidentsMalesAge12 = StaticConverter.to_int(fields[84]);
        this.communalEstablishmentResidentsFemalesAge12 = StaticConverter.to_int(fields[85]);
        this.allPeopleAge13 = StaticConverter.to_int(fields[86]);
        this.householdResidentsMalesAge13 = StaticConverter.to_int(fields[87]);
        this.householdResidentsFemalesAge13 = StaticConverter.to_int(fields[88]);
        this.communalEstablishmentResidentsMalesAge13 = StaticConverter.to_int(fields[89]);
        this.communalEstablishmentResidentsFemalesAge13 = StaticConverter.to_int(fields[90]);
        this.allPeopleAge14 = StaticConverter.to_int(fields[91]);
        this.householdResidentsMalesAge14 = StaticConverter.to_int(fields[92]);
        this.householdResidentsFemalesAge14 = StaticConverter.to_int(fields[93]);
        this.communalEstablishmentResidentsMalesAge14 = StaticConverter.to_int(fields[94]);
        this.communalEstablishmentResidentsFemalesAge14 = StaticConverter.to_int(fields[95]);
        this.allPeopleAge15to19 = StaticConverter.to_int(fields[96]);
        this.householdResidentsMalesAge15to19 = StaticConverter.to_int(fields[97]);
        this.householdResidentsFemalesAge15to19 = StaticConverter.to_int(fields[98]);
        this.communalEstablishmentResidentsMalesAge15to19 = StaticConverter.to_int(fields[99]);
        this.communalEstablishmentResidentsFemalesAge15to19 = StaticConverter.to_int(fields[100]);
        this.allPeopleAge15 = StaticConverter.to_int(fields[101]);
        this.householdResidentsMalesAge15 = StaticConverter.to_int(fields[102]);
        this.householdResidentsFemalesAge15 = StaticConverter.to_int(fields[103]);
        this.communalEstablishmentResidentsMalesAge15 = StaticConverter.to_int(fields[104]);
        this.communalEstablishmentResidentsFemalesAge15 = StaticConverter.to_int(fields[105]);
        this.allPeopleAge16 = StaticConverter.to_int(fields[106]);
        this.householdResidentsMalesAge16 = StaticConverter.to_int(fields[107]);
        this.householdResidentsFemalesAge16 = StaticConverter.to_int(fields[108]);
        this.communalEstablishmentResidentsMalesAge16 = StaticConverter.to_int(fields[109]);
        this.communalEstablishmentResidentsFemalesAge16 = StaticConverter.to_int(fields[110]);
        this.allPeopleAge17 = StaticConverter.to_int(fields[111]);
        this.householdResidentsMalesAge17 = StaticConverter.to_int(fields[112]);
        this.householdResidentsFemalesAge17 = StaticConverter.to_int(fields[113]);
        this.communalEstablishmentResidentsMalesAge17 = StaticConverter.to_int(fields[114]);
        this.communalEstablishmentResidentsFemalesAge17 = StaticConverter.to_int(fields[115]);
        this.allPeopleAge18 = StaticConverter.to_int(fields[116]);
        this.householdResidentsMalesAge18 = StaticConverter.to_int(fields[117]);
        this.householdResidentsFemalesAge18 = StaticConverter.to_int(fields[118]);
        this.communalEstablishmentResidentsMalesAge18 = StaticConverter.to_int(fields[119]);
        this.communalEstablishmentResidentsFemalesAge18 = StaticConverter.to_int(fields[120]);
        this.allPeopleAge19 = StaticConverter.to_int(fields[121]);
        this.householdResidentsMalesAge19 = StaticConverter.to_int(fields[122]);
        this.householdResidentsFemalesAge19 = StaticConverter.to_int(fields[123]);
        this.communalEstablishmentResidentsMalesAge19 = StaticConverter.to_int(fields[124]);
        this.communalEstablishmentResidentsFemalesAge19 = StaticConverter.to_int(fields[125]);
        this.allPeopleAge20to24 = StaticConverter.to_int(fields[126]);
        this.householdResidentsMalesAge20to24 = StaticConverter.to_int(fields[127]);
        this.householdResidentsFemalesAge20to24 = StaticConverter.to_int(fields[128]);
        this.communalEstablishmentResidentsMalesAge20to24 = StaticConverter.to_int(fields[129]);
        this.communalEstablishmentResidentsFemalesAge20to24 = StaticConverter.to_int(fields[130]);
        this.allPeopleAge20 = StaticConverter.to_int(fields[131]);
        this.householdResidentsMalesAge20 = StaticConverter.to_int(fields[132]);
        this.householdResidentsFemalesAge20 = StaticConverter.to_int(fields[133]);
        this.communalEstablishmentResidentsMalesAge20 = StaticConverter.to_int(fields[134]);
        this.communalEstablishmentResidentsFemalesAge20 = StaticConverter.to_int(fields[135]);
        this.allPeopleAge21 = StaticConverter.to_int(fields[136]);
        this.householdResidentsMalesAge21 = StaticConverter.to_int(fields[137]);
        this.householdResidentsFemalesAge21 = StaticConverter.to_int(fields[138]);
        this.communalEstablishmentResidentsMalesAge21 = StaticConverter.to_int(fields[139]);
        this.communalEstablishmentResidentsFemalesAge21 = StaticConverter.to_int(fields[140]);
        this.allPeopleAge22 = StaticConverter.to_int(fields[141]);
        this.householdResidentsMalesAge22 = StaticConverter.to_int(fields[142]);
        this.householdResidentsFemalesAge22 = StaticConverter.to_int(fields[143]);
        this.communalEstablishmentResidentsMalesAge22 = StaticConverter.to_int(fields[144]);
        this.communalEstablishmentResidentsFemalesAge22 = StaticConverter.to_int(fields[145]);
        this.allPeopleAge23 = StaticConverter.to_int(fields[146]);
        this.householdResidentsMalesAge23 = StaticConverter.to_int(fields[147]);
        this.householdResidentsFemalesAge23 = StaticConverter.to_int(fields[148]);
        this.communalEstablishmentResidentsMalesAge23 = StaticConverter.to_int(fields[149]);
        this.communalEstablishmentResidentsFemalesAge23 = StaticConverter.to_int(fields[150]);
        this.allPeopleAge24 = StaticConverter.to_int(fields[151]);
        this.householdResidentsMalesAge24 = StaticConverter.to_int(fields[152]);
        this.householdResidentsFemalesAge24 = StaticConverter.to_int(fields[153]);
        this.communalEstablishmentResidentsMalesAge24 = StaticConverter.to_int(fields[154]);
        this.communalEstablishmentResidentsFemalesAge24 = StaticConverter.to_int(fields[155]);
        this.allPeopleAge25to29 = StaticConverter.to_int(fields[156]);
        this.householdResidentsMalesAge25to29 = StaticConverter.to_int(fields[157]);
        this.householdResidentsFemalesAge25to29 = StaticConverter.to_int(fields[158]);
        this.communalEstablishmentResidentsMalesAge25to29 = StaticConverter.to_int(fields[159]);
        this.communalEstablishmentResidentsFemalesAge25to29 = StaticConverter.to_int(fields[160]);
        this.allPeopleAge30to34 = StaticConverter.to_int(fields[161]);
        this.householdResidentsMalesAge30to34 = StaticConverter.to_int(fields[162]);
        this.householdResidentsFemalesAge30to34 = StaticConverter.to_int(fields[163]);
        this.communalEstablishmentResidentsMalesAge30to34 = StaticConverter.to_int(fields[164]);
        this.communalEstablishmentResidentsFemalesAge30to34 = StaticConverter.to_int(fields[165]);
        this.allPeopleAge35to39 = StaticConverter.to_int(fields[166]);
        this.householdResidentsMalesAge35to39 = StaticConverter.to_int(fields[167]);
        this.householdResidentsFemalesAge35to39 = StaticConverter.to_int(fields[168]);
        this.communalEstablishmentResidentsMalesAge35to39 = StaticConverter.to_int(fields[169]);
        this.communalEstablishmentResidentsFemalesAge35to39 = StaticConverter.to_int(fields[170]);
        this.allPeopleAge40to44 = StaticConverter.to_int(fields[171]);
        this.householdResidentsMalesAge40to44 = StaticConverter.to_int(fields[172]);
        this.householdResidentsFemalesAge40to44 = StaticConverter.to_int(fields[173]);
        this.communalEstablishmentResidentsMalesAge40to44 = StaticConverter.to_int(fields[174]);
        this.communalEstablishmentResidentsFemalesAge40to44 = StaticConverter.to_int(fields[175]);
        this.allPeopleAge45to49 = StaticConverter.to_int(fields[176]);
        this.householdResidentsMalesAge45to49 = StaticConverter.to_int(fields[177]);
        this.householdResidentsFemalesAge45to49 = StaticConverter.to_int(fields[178]);
        this.communalEstablishmentResidentsMalesAge45to49 = StaticConverter.to_int(fields[179]);
        this.communalEstablishmentResidentsFemalesAge45to49 = StaticConverter.to_int(fields[180]);
        this.allPeopleAge50to54 = StaticConverter.to_int(fields[181]);
        this.householdResidentsMalesAge50to54 = StaticConverter.to_int(fields[182]);
        this.householdResidentsFemalesAge50to54 = StaticConverter.to_int(fields[183]);
        this.communalEstablishmentResidentsMalesAge50to54 = StaticConverter.to_int(fields[184]);
        this.communalEstablishmentResidentsFemalesAge50to54 = StaticConverter.to_int(fields[185]);
        this.allPeopleAge55to59 = StaticConverter.to_int(fields[186]);
        this.householdResidentsMalesAge55to59 = StaticConverter.to_int(fields[187]);
        this.householdResidentsFemalesAge55to59 = StaticConverter.to_int(fields[188]);
        this.communalEstablishmentResidentsMalesAge55to59 = StaticConverter.to_int(fields[189]);
        this.communalEstablishmentResidentsFemalesAge55to59 = StaticConverter.to_int(fields[190]);
        this.allPeopleAge60to64 = StaticConverter.to_int(fields[191]);
        this.householdResidentsMalesAge60to64 = StaticConverter.to_int(fields[192]);
        this.householdResidentsFemalesAge60to64 = StaticConverter.to_int(fields[193]);
        this.communalEstablishmentResidentsMalesAge60to64 = StaticConverter.to_int(fields[194]);
        this.communalEstablishmentResidentsFemalesAge60to64 = StaticConverter.to_int(fields[195]);
        this.allPeopleAge65to69 = StaticConverter.to_int(fields[196]);
        this.householdResidentsMalesAge65to69 = StaticConverter.to_int(fields[197]);
        this.householdResidentsFemalesAge65to69 = StaticConverter.to_int(fields[198]);
        this.communalEstablishmentResidentsMalesAge65to69 = StaticConverter.to_int(fields[199]);
        this.communalEstablishmentResidentsFemalesAge65to69 = StaticConverter.to_int(fields[200]);
        this.allPeopleAge70to74 = StaticConverter.to_int(fields[201]);
        this.householdResidentsMalesAge70to74 = StaticConverter.to_int(fields[202]);
        this.householdResidentsFemalesAge70to74 = StaticConverter.to_int(fields[203]);
        this.communalEstablishmentResidentsMalesAge70to74 = StaticConverter.to_int(fields[204]);
        this.communalEstablishmentResidentsFemalesAge70to74 = StaticConverter.to_int(fields[205]);
        this.allPeopleAge75to79 = StaticConverter.to_int(fields[206]);
        this.householdResidentsMalesAge75to79 = StaticConverter.to_int(fields[207]);
        this.householdResidentsFemalesAge75to79 = StaticConverter.to_int(fields[208]);
        this.communalEstablishmentResidentsMalesAge75to79 = StaticConverter.to_int(fields[209]);
        this.communalEstablishmentResidentsFemalesAge75to79 = StaticConverter.to_int(fields[210]);
        this.allPeopleAge80to84 = StaticConverter.to_int(fields[211]);
        this.householdResidentsMalesAge80to84 = StaticConverter.to_int(fields[212]);
        this.householdResidentsFemalesAge80to84 = StaticConverter.to_int(fields[213]);
        this.communalEstablishmentResidentsMalesAge80to84 = StaticConverter.to_int(fields[214]);
        this.communalEstablishmentResidentsFemalesAge80to84 = StaticConverter.to_int(fields[215]);
        this.allPeopleAge85to89 = StaticConverter.to_int(fields[216]);
        this.householdResidentsMalesAge85to89 = StaticConverter.to_int(fields[217]);
        this.householdResidentsFemalesAge85to89 = StaticConverter.to_int(fields[218]);
        this.communalEstablishmentResidentsMalesAge85to89 = StaticConverter.to_int(fields[219]);
        this.communalEstablishmentResidentsFemalesAge85to89 = StaticConverter.to_int(fields[220]);
        this.allPeopleAge90AndOver = StaticConverter.to_int(fields[221]);
        this.householdResidentsMalesAge90AndOver = StaticConverter.to_int(fields[222]);
        this.householdResidentsFemalesAge90AndOver = StaticConverter.to_int(fields[223]);
        this.communalEstablishmentResidentsMalesAge90AndOver = StaticConverter.to_int(fields[224]);
        this.communalEstablishmentResidentsFemalesAge90AndOver = StaticConverter.to_int(fields[225]);
    }

    /**
     * Creates a new <code>CAS001DataRecord</code> from
     * <code>aRandomAccessFile</code>. The
     * <code>aRandomAccessFile.getFilePointer()</code> changes only as the
     * <code>CAS001DataRecord</code> is read.
     *
     * @param aRandomAccessFile
     *            The <code>RandomAccessFile</code> from which this is created.
     * @throws java.io.IOException
     */
    public CAS001DataRecord(RandomAccessFile aRandomAccessFile)
            throws IOException {
        try {
            this._RecordID = aRandomAccessFile.readLong();
            this.Zone_Code = new char[10];
            for (int i = 0; i < this.Zone_Code.length; i++) {
                Zone_Code[i] = aRandomAccessFile.readChar();
            }
            this.allPeople = aRandomAccessFile.readInt();
            this.householdResidentsMales = aRandomAccessFile.readInt();
            this.householdResidentsFemales = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMales = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemales = aRandomAccessFile.readInt();
            this.allPeopleAge0to4 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge0to4 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge0to4 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge0to4 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge0to4 = aRandomAccessFile.readInt();
            this.allPeopleAge0 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge0 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge0 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge0 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge0 = aRandomAccessFile.readInt();
            this.allPeopleAge1 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge1 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge1 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge1 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge1 = aRandomAccessFile.readInt();
            this.allPeopleAge2 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge2 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge2 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge2 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge2 = aRandomAccessFile.readInt();
            this.allPeopleAge3 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge3 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge3 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge3 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge3 = aRandomAccessFile.readInt();
            this.allPeopleAge4 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge4 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge4 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge4 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge4 = aRandomAccessFile.readInt();
            this.allPeopleAge5to9 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge5to9 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge5to9 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge5to9 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge5to9 = aRandomAccessFile.readInt();
            this.allPeopleAge5 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge5 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge5 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge5 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge5 = aRandomAccessFile.readInt();
            this.allPeopleAge6 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge6 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge6 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge6 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge6 = aRandomAccessFile.readInt();
            this.allPeopleAge7 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge7 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge7 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge7 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge7 = aRandomAccessFile.readInt();
            this.allPeopleAge8 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge8 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge8 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge8 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge8 = aRandomAccessFile.readInt();
            this.allPeopleAge9 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge9 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge9 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge9 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge9 = aRandomAccessFile.readInt();
            this.allPeopleAge10to14 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge10to14 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge10to14 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge10to14 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge10to14 = aRandomAccessFile.readInt();
            this.allPeopleAge10 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge10 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge10 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge10 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge10 = aRandomAccessFile.readInt();
            this.allPeopleAge11 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge11 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge11 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge11 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge11 = aRandomAccessFile.readInt();
            this.allPeopleAge12 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge12 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge12 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge12 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge12 = aRandomAccessFile.readInt();
            this.allPeopleAge13 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge13 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge13 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge13 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge13 = aRandomAccessFile.readInt();
            this.allPeopleAge14 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge14 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge14 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge14 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge14 = aRandomAccessFile.readInt();
            this.allPeopleAge15to19 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge15to19 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge15to19 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge15to19 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge15to19 = aRandomAccessFile.readInt();
            this.allPeopleAge15 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge15 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge15 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge15 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge15 = aRandomAccessFile.readInt();
            this.allPeopleAge16 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge16 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge16 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge16 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge16 = aRandomAccessFile.readInt();
            this.allPeopleAge17 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge17 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge17 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge17 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge17 = aRandomAccessFile.readInt();
            this.allPeopleAge18 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge18 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge18 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge18 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge18 = aRandomAccessFile.readInt();
            this.allPeopleAge19 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge19 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge19 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge19 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge19 = aRandomAccessFile.readInt();
            this.allPeopleAge20to24 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge20to24 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge20to24 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge20to24 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge20to24 = aRandomAccessFile.readInt();
            this.allPeopleAge20 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge20 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge20 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge20 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge20 = aRandomAccessFile.readInt();
            this.allPeopleAge21 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge21 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge21 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge21 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge21 = aRandomAccessFile.readInt();
            this.allPeopleAge22 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge22 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge22 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge22 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge22 = aRandomAccessFile.readInt();
            this.allPeopleAge23 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge23 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge23 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge23 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge23 = aRandomAccessFile.readInt();
            this.allPeopleAge24 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge24 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge24 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge24 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge24 = aRandomAccessFile.readInt();
            this.allPeopleAge25to29 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge25to29 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge25to29 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge25to29 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge25to29 = aRandomAccessFile.readInt();
            this.allPeopleAge30to34 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge30to34 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge30to34 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge30to34 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge30to34 = aRandomAccessFile.readInt();
            this.allPeopleAge35to39 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge35to39 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge35to39 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge35to39 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge35to39 = aRandomAccessFile.readInt();
            this.allPeopleAge40to44 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge40to44 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge40to44 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge40to44 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge40to44 = aRandomAccessFile.readInt();
            this.allPeopleAge45to49 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge45to49 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge45to49 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge45to49 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge45to49 = aRandomAccessFile.readInt();
            this.allPeopleAge50to54 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge50to54 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge50to54 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge50to54 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge50to54 = aRandomAccessFile.readInt();
            this.allPeopleAge55to59 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge55to59 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge55to59 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge55to59 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge55to59 = aRandomAccessFile.readInt();
            this.allPeopleAge60to64 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge60to64 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge60to64 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge60to64 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge60to64 = aRandomAccessFile.readInt();
            this.allPeopleAge65to69 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge65to69 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge65to69 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge65to69 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge65to69 = aRandomAccessFile.readInt();
            this.allPeopleAge70to74 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge70to74 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge70to74 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge70to74 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge70to74 = aRandomAccessFile.readInt();
            this.allPeopleAge75to79 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge75to79 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge75to79 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge75to79 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge75to79 = aRandomAccessFile.readInt();
            this.allPeopleAge80to84 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge80to84 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge80to84 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge80to84 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge80to84 = aRandomAccessFile.readInt();
            this.allPeopleAge85to89 = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge85to89 = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge85to89 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge85to89 = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge85to89 = aRandomAccessFile.readInt();
            this.allPeopleAge90AndOver = aRandomAccessFile.readInt();
            this.householdResidentsMalesAge90AndOver = aRandomAccessFile.readInt();
            this.householdResidentsFemalesAge90AndOver = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsMalesAge90AndOver = aRandomAccessFile.readInt();
            this.communalEstablishmentResidentsFemalesAge90AndOver = aRandomAccessFile.readInt();
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
        this.allPeople = Integer.MIN_VALUE;
        this.householdResidentsMales = Integer.MIN_VALUE;
        this.householdResidentsFemales = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMales = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemales = Integer.MIN_VALUE;
        this.allPeopleAge0to4 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge0to4 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge0to4 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge0to4 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge0to4 = Integer.MIN_VALUE;
        this.allPeopleAge0 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge0 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge0 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge0 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge0 = Integer.MIN_VALUE;
        this.allPeopleAge1 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge1 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge1 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge1 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge1 = Integer.MIN_VALUE;
        this.allPeopleAge2 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge2 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge2 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge2 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge2 = Integer.MIN_VALUE;
        this.allPeopleAge3 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge3 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge3 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge3 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge3 = Integer.MIN_VALUE;
        this.allPeopleAge4 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge4 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge4 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge4 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge4 = Integer.MIN_VALUE;
        this.allPeopleAge5to9 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge5to9 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge5to9 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge5to9 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge5to9 = Integer.MIN_VALUE;
        this.allPeopleAge5 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge5 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge5 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge5 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge5 = Integer.MIN_VALUE;
        this.allPeopleAge6 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge6 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge6 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge6 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge6 = Integer.MIN_VALUE;
        this.allPeopleAge7 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge7 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge7 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge7 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge7 = Integer.MIN_VALUE;
        this.allPeopleAge8 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge8 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge8 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge8 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge8 = Integer.MIN_VALUE;
        this.allPeopleAge9 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge9 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge9 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge9 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge9 = Integer.MIN_VALUE;
        this.allPeopleAge10to14 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge10to14 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge10to14 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge10to14 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge10to14 = Integer.MIN_VALUE;
        this.allPeopleAge10 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge10 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge10 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge10 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge10 = Integer.MIN_VALUE;
        this.allPeopleAge11 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge11 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge11 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge11 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge11 = Integer.MIN_VALUE;
        this.allPeopleAge12 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge12 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge12 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge12 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge12 = Integer.MIN_VALUE;
        this.allPeopleAge13 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge13 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge13 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge13 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge13 = Integer.MIN_VALUE;
        this.allPeopleAge14 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge14 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge14 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge14 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge14 = Integer.MIN_VALUE;
        this.allPeopleAge15to19 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge15to19 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge15to19 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge15to19 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge15to19 = Integer.MIN_VALUE;
        this.allPeopleAge15 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge15 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge15 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge15 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge15 = Integer.MIN_VALUE;
        this.allPeopleAge16 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge16 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge16 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge16 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge16 = Integer.MIN_VALUE;
        this.allPeopleAge17 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge17 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge17 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge17 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge17 = Integer.MIN_VALUE;
        this.allPeopleAge18 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge18 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge18 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge18 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge18 = Integer.MIN_VALUE;
        this.allPeopleAge19 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge19 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge19 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge19 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge19 = Integer.MIN_VALUE;
        this.allPeopleAge20to24 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge20to24 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge20to24 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge20to24 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge20to24 = Integer.MIN_VALUE;
        this.allPeopleAge20 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge20 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge20 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge20 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge20 = Integer.MIN_VALUE;
        this.allPeopleAge21 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge21 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge21 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge21 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge21 = Integer.MIN_VALUE;
        this.allPeopleAge22 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge22 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge22 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge22 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge22 = Integer.MIN_VALUE;
        this.allPeopleAge23 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge23 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge23 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge23 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge23 = Integer.MIN_VALUE;
        this.allPeopleAge24 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge24 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge24 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge24 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge24 = Integer.MIN_VALUE;
        this.allPeopleAge25to29 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge25to29 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge25to29 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge25to29 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge25to29 = Integer.MIN_VALUE;
        this.allPeopleAge30to34 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge30to34 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge30to34 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge30to34 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge30to34 = Integer.MIN_VALUE;
        this.allPeopleAge35to39 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge35to39 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge35to39 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge35to39 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge35to39 = Integer.MIN_VALUE;
        this.allPeopleAge40to44 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge40to44 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge40to44 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge40to44 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge40to44 = Integer.MIN_VALUE;
        this.allPeopleAge45to49 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge45to49 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge45to49 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge45to49 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge45to49 = Integer.MIN_VALUE;
        this.allPeopleAge50to54 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge50to54 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge50to54 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge50to54 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge50to54 = Integer.MIN_VALUE;
        this.allPeopleAge55to59 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge55to59 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge55to59 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge55to59 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge55to59 = Integer.MIN_VALUE;
        this.allPeopleAge60to64 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge60to64 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge60to64 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge60to64 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge60to64 = Integer.MIN_VALUE;
        this.allPeopleAge65to69 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge65to69 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge65to69 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge65to69 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge65to69 = Integer.MIN_VALUE;
        this.allPeopleAge70to74 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge70to74 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge70to74 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge70to74 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge70to74 = Integer.MIN_VALUE;
        this.allPeopleAge75to79 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge75to79 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge75to79 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge75to79 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge75to79 = Integer.MIN_VALUE;
        this.allPeopleAge80to84 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge80to84 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge80to84 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge80to84 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge80to84 = Integer.MIN_VALUE;
        this.allPeopleAge85to89 = Integer.MIN_VALUE;
        this.householdResidentsMalesAge85to89 = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge85to89 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge85to89 = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge85to89 = Integer.MIN_VALUE;
        this.allPeopleAge90AndOver = Integer.MIN_VALUE;
        this.householdResidentsMalesAge90AndOver = Integer.MIN_VALUE;
        this.householdResidentsFemalesAge90AndOver = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsMalesAge90AndOver = Integer.MIN_VALUE;
        this.communalEstablishmentResidentsFemalesAge90AndOver = Integer.MIN_VALUE;
    }

    /**
     * Initialises all fields to zero.
     */
    protected void initZero() {
        super._Init();
        this.allPeople = 0;
        this.householdResidentsMales = 0;
        this.householdResidentsFemales = 0;
        this.communalEstablishmentResidentsMales = 0;
        this.communalEstablishmentResidentsFemales = 0;
        this.allPeopleAge0to4 = 0;
        this.householdResidentsMalesAge0to4 = 0;
        this.householdResidentsFemalesAge0to4 = 0;
        this.communalEstablishmentResidentsMalesAge0to4 = 0;
        this.communalEstablishmentResidentsFemalesAge0to4 = 0;
        this.allPeopleAge0 = 0;
        this.householdResidentsMalesAge0 = 0;
        this.householdResidentsFemalesAge0 = 0;
        this.communalEstablishmentResidentsMalesAge0 = 0;
        this.communalEstablishmentResidentsFemalesAge0 = 0;
        this.allPeopleAge1 = 0;
        this.householdResidentsMalesAge1 = 0;
        this.householdResidentsFemalesAge1 = 0;
        this.communalEstablishmentResidentsMalesAge1 = 0;
        this.communalEstablishmentResidentsFemalesAge1 = 0;
        this.allPeopleAge2 = 0;
        this.householdResidentsMalesAge2 = 0;
        this.householdResidentsFemalesAge2 = 0;
        this.communalEstablishmentResidentsMalesAge2 = 0;
        this.communalEstablishmentResidentsFemalesAge2 = 0;
        this.allPeopleAge3 = 0;
        this.householdResidentsMalesAge3 = 0;
        this.householdResidentsFemalesAge3 = 0;
        this.communalEstablishmentResidentsMalesAge3 = 0;
        this.communalEstablishmentResidentsFemalesAge3 = 0;
        this.allPeopleAge4 = 0;
        this.householdResidentsMalesAge4 = 0;
        this.householdResidentsFemalesAge4 = 0;
        this.communalEstablishmentResidentsMalesAge4 = 0;
        this.communalEstablishmentResidentsFemalesAge4 = 0;
        this.allPeopleAge5to9 = 0;
        this.householdResidentsMalesAge5to9 = 0;
        this.householdResidentsFemalesAge5to9 = 0;
        this.communalEstablishmentResidentsMalesAge5to9 = 0;
        this.communalEstablishmentResidentsFemalesAge5to9 = 0;
        this.allPeopleAge5 = 0;
        this.householdResidentsMalesAge5 = 0;
        this.householdResidentsFemalesAge5 = 0;
        this.communalEstablishmentResidentsMalesAge5 = 0;
        this.communalEstablishmentResidentsFemalesAge5 = 0;
        this.allPeopleAge6 = 0;
        this.householdResidentsMalesAge6 = 0;
        this.householdResidentsFemalesAge6 = 0;
        this.communalEstablishmentResidentsMalesAge6 = 0;
        this.communalEstablishmentResidentsFemalesAge6 = 0;
        this.allPeopleAge7 = 0;
        this.householdResidentsMalesAge7 = 0;
        this.householdResidentsFemalesAge7 = 0;
        this.communalEstablishmentResidentsMalesAge7 = 0;
        this.communalEstablishmentResidentsFemalesAge7 = 0;
        this.allPeopleAge8 = 0;
        this.householdResidentsMalesAge8 = 0;
        this.householdResidentsFemalesAge8 = 0;
        this.communalEstablishmentResidentsMalesAge8 = 0;
        this.communalEstablishmentResidentsFemalesAge8 = 0;
        this.allPeopleAge9 = 0;
        this.householdResidentsMalesAge9 = 0;
        this.householdResidentsFemalesAge9 = 0;
        this.communalEstablishmentResidentsMalesAge9 = 0;
        this.communalEstablishmentResidentsFemalesAge9 = 0;
        this.allPeopleAge10to14 = 0;
        this.householdResidentsMalesAge10to14 = 0;
        this.householdResidentsFemalesAge10to14 = 0;
        this.communalEstablishmentResidentsMalesAge10to14 = 0;
        this.communalEstablishmentResidentsFemalesAge10to14 = 0;
        this.allPeopleAge10 = 0;
        this.householdResidentsMalesAge10 = 0;
        this.householdResidentsFemalesAge10 = 0;
        this.communalEstablishmentResidentsMalesAge10 = 0;
        this.communalEstablishmentResidentsFemalesAge10 = 0;
        this.allPeopleAge11 = 0;
        this.householdResidentsMalesAge11 = 0;
        this.householdResidentsFemalesAge11 = 0;
        this.communalEstablishmentResidentsMalesAge11 = 0;
        this.communalEstablishmentResidentsFemalesAge11 = 0;
        this.allPeopleAge12 = 0;
        this.householdResidentsMalesAge12 = 0;
        this.householdResidentsFemalesAge12 = 0;
        this.communalEstablishmentResidentsMalesAge12 = 0;
        this.communalEstablishmentResidentsFemalesAge12 = 0;
        this.allPeopleAge13 = 0;
        this.householdResidentsMalesAge13 = 0;
        this.householdResidentsFemalesAge13 = 0;
        this.communalEstablishmentResidentsMalesAge13 = 0;
        this.communalEstablishmentResidentsFemalesAge13 = 0;
        this.allPeopleAge14 = 0;
        this.householdResidentsMalesAge14 = 0;
        this.householdResidentsFemalesAge14 = 0;
        this.communalEstablishmentResidentsMalesAge14 = 0;
        this.communalEstablishmentResidentsFemalesAge14 = 0;
        this.allPeopleAge15to19 = 0;
        this.householdResidentsMalesAge15to19 = 0;
        this.householdResidentsFemalesAge15to19 = 0;
        this.communalEstablishmentResidentsMalesAge15to19 = 0;
        this.communalEstablishmentResidentsFemalesAge15to19 = 0;
        this.allPeopleAge15 = 0;
        this.householdResidentsMalesAge15 = 0;
        this.householdResidentsFemalesAge15 = 0;
        this.communalEstablishmentResidentsMalesAge15 = 0;
        this.communalEstablishmentResidentsFemalesAge15 = 0;
        this.allPeopleAge16 = 0;
        this.householdResidentsMalesAge16 = 0;
        this.householdResidentsFemalesAge16 = 0;
        this.communalEstablishmentResidentsMalesAge16 = 0;
        this.communalEstablishmentResidentsFemalesAge16 = 0;
        this.allPeopleAge17 = 0;
        this.householdResidentsMalesAge17 = 0;
        this.householdResidentsFemalesAge17 = 0;
        this.communalEstablishmentResidentsMalesAge17 = 0;
        this.communalEstablishmentResidentsFemalesAge17 = 0;
        this.allPeopleAge18 = 0;
        this.householdResidentsMalesAge18 = 0;
        this.householdResidentsFemalesAge18 = 0;
        this.communalEstablishmentResidentsMalesAge18 = 0;
        this.communalEstablishmentResidentsFemalesAge18 = 0;
        this.allPeopleAge19 = 0;
        this.householdResidentsMalesAge19 = 0;
        this.householdResidentsFemalesAge19 = 0;
        this.communalEstablishmentResidentsMalesAge19 = 0;
        this.communalEstablishmentResidentsFemalesAge19 = 0;
        this.allPeopleAge20to24 = 0;
        this.householdResidentsMalesAge20to24 = 0;
        this.householdResidentsFemalesAge20to24 = 0;
        this.communalEstablishmentResidentsMalesAge20to24 = 0;
        this.communalEstablishmentResidentsFemalesAge20to24 = 0;
        this.allPeopleAge20 = 0;
        this.householdResidentsMalesAge20 = 0;
        this.householdResidentsFemalesAge20 = 0;
        this.communalEstablishmentResidentsMalesAge20 = 0;
        this.communalEstablishmentResidentsFemalesAge20 = 0;
        this.allPeopleAge21 = 0;
        this.householdResidentsMalesAge21 = 0;
        this.householdResidentsFemalesAge21 = 0;
        this.communalEstablishmentResidentsMalesAge21 = 0;
        this.communalEstablishmentResidentsFemalesAge21 = 0;
        this.allPeopleAge22 = 0;
        this.householdResidentsMalesAge22 = 0;
        this.householdResidentsFemalesAge22 = 0;
        this.communalEstablishmentResidentsMalesAge22 = 0;
        this.communalEstablishmentResidentsFemalesAge22 = 0;
        this.allPeopleAge23 = 0;
        this.householdResidentsMalesAge23 = 0;
        this.householdResidentsFemalesAge23 = 0;
        this.communalEstablishmentResidentsMalesAge23 = 0;
        this.communalEstablishmentResidentsFemalesAge23 = 0;
        this.allPeopleAge24 = 0;
        this.householdResidentsMalesAge24 = 0;
        this.householdResidentsFemalesAge24 = 0;
        this.communalEstablishmentResidentsMalesAge24 = 0;
        this.communalEstablishmentResidentsFemalesAge24 = 0;
        this.allPeopleAge25to29 = 0;
        this.householdResidentsMalesAge25to29 = 0;
        this.householdResidentsFemalesAge25to29 = 0;
        this.communalEstablishmentResidentsMalesAge25to29 = 0;
        this.communalEstablishmentResidentsFemalesAge25to29 = 0;
        this.allPeopleAge30to34 = 0;
        this.householdResidentsMalesAge30to34 = 0;
        this.householdResidentsFemalesAge30to34 = 0;
        this.communalEstablishmentResidentsMalesAge30to34 = 0;
        this.communalEstablishmentResidentsFemalesAge30to34 = 0;
        this.allPeopleAge35to39 = 0;
        this.householdResidentsMalesAge35to39 = 0;
        this.householdResidentsFemalesAge35to39 = 0;
        this.communalEstablishmentResidentsMalesAge35to39 = 0;
        this.communalEstablishmentResidentsFemalesAge35to39 = 0;
        this.allPeopleAge40to44 = 0;
        this.householdResidentsMalesAge40to44 = 0;
        this.householdResidentsFemalesAge40to44 = 0;
        this.communalEstablishmentResidentsMalesAge40to44 = 0;
        this.communalEstablishmentResidentsFemalesAge40to44 = 0;
        this.allPeopleAge45to49 = 0;
        this.householdResidentsMalesAge45to49 = 0;
        this.householdResidentsFemalesAge45to49 = 0;
        this.communalEstablishmentResidentsMalesAge45to49 = 0;
        this.communalEstablishmentResidentsFemalesAge45to49 = 0;
        this.allPeopleAge50to54 = 0;
        this.householdResidentsMalesAge50to54 = 0;
        this.householdResidentsFemalesAge50to54 = 0;
        this.communalEstablishmentResidentsMalesAge50to54 = 0;
        this.communalEstablishmentResidentsFemalesAge50to54 = 0;
        this.allPeopleAge55to59 = 0;
        this.householdResidentsMalesAge55to59 = 0;
        this.householdResidentsFemalesAge55to59 = 0;
        this.communalEstablishmentResidentsMalesAge55to59 = 0;
        this.communalEstablishmentResidentsFemalesAge55to59 = 0;
        this.allPeopleAge60to64 = 0;
        this.householdResidentsMalesAge60to64 = 0;
        this.householdResidentsFemalesAge60to64 = 0;
        this.communalEstablishmentResidentsMalesAge60to64 = 0;
        this.communalEstablishmentResidentsFemalesAge60to64 = 0;
        this.allPeopleAge65to69 = 0;
        this.householdResidentsMalesAge65to69 = 0;
        this.householdResidentsFemalesAge65to69 = 0;
        this.communalEstablishmentResidentsMalesAge65to69 = 0;
        this.communalEstablishmentResidentsFemalesAge65to69 = 0;
        this.allPeopleAge70to74 = 0;
        this.householdResidentsMalesAge70to74 = 0;
        this.householdResidentsFemalesAge70to74 = 0;
        this.communalEstablishmentResidentsMalesAge70to74 = 0;
        this.communalEstablishmentResidentsFemalesAge70to74 = 0;
        this.allPeopleAge75to79 = 0;
        this.householdResidentsMalesAge75to79 = 0;
        this.householdResidentsFemalesAge75to79 = 0;
        this.communalEstablishmentResidentsMalesAge75to79 = 0;
        this.communalEstablishmentResidentsFemalesAge75to79 = 0;
        this.allPeopleAge80to84 = 0;
        this.householdResidentsMalesAge80to84 = 0;
        this.householdResidentsFemalesAge80to84 = 0;
        this.communalEstablishmentResidentsMalesAge80to84 = 0;
        this.communalEstablishmentResidentsFemalesAge80to84 = 0;
        this.allPeopleAge85to89 = 0;
        this.householdResidentsMalesAge85to89 = 0;
        this.householdResidentsFemalesAge85to89 = 0;
        this.communalEstablishmentResidentsMalesAge85to89 = 0;
        this.communalEstablishmentResidentsFemalesAge85to89 = 0;
        this.allPeopleAge90AndOver = 0;
        this.householdResidentsMalesAge90AndOver = 0;
        this.householdResidentsFemalesAge90AndOver = 0;
        this.communalEstablishmentResidentsMalesAge90AndOver = 0;
        this.communalEstablishmentResidentsFemalesAge90AndOver = 0;
    }

    /**
     * Initialises from <code>aCAS001DataRecord</code>.
     *
     * @param aCAS001DataRecord
     *            The <code>CAS001DataRecord</code> used to initialise
     *            <code>this</code>.
     */
    protected void init(CAS001DataRecord aCAS001DataRecord) {
        super.init(aCAS001DataRecord);
        this.allPeople = aCAS001DataRecord.allPeople;
        this.householdResidentsMales = aCAS001DataRecord.householdResidentsMales;
        this.householdResidentsFemales = aCAS001DataRecord.householdResidentsFemales;
        this.communalEstablishmentResidentsMales = aCAS001DataRecord.communalEstablishmentResidentsMales;
        this.communalEstablishmentResidentsFemales = aCAS001DataRecord.communalEstablishmentResidentsFemales;
        this.allPeopleAge0to4 = aCAS001DataRecord.allPeopleAge0to4;
        this.householdResidentsMalesAge0to4 = aCAS001DataRecord.householdResidentsMalesAge0to4;
        this.householdResidentsFemalesAge0to4 = aCAS001DataRecord.householdResidentsFemalesAge0to4;
        this.communalEstablishmentResidentsMalesAge0to4 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge0to4;
        this.communalEstablishmentResidentsFemalesAge0to4 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge0to4;
        this.allPeopleAge0 = aCAS001DataRecord.allPeopleAge0;
        this.householdResidentsMalesAge0 = aCAS001DataRecord.householdResidentsMalesAge0;
        this.householdResidentsFemalesAge0 = aCAS001DataRecord.householdResidentsFemalesAge0;
        this.communalEstablishmentResidentsMalesAge0 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge0;
        this.communalEstablishmentResidentsFemalesAge0 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge0;
        this.allPeopleAge1 = aCAS001DataRecord.allPeopleAge1;
        this.householdResidentsMalesAge1 = aCAS001DataRecord.householdResidentsMalesAge1;
        this.householdResidentsFemalesAge1 = aCAS001DataRecord.householdResidentsFemalesAge1;
        this.communalEstablishmentResidentsMalesAge1 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge1;
        this.communalEstablishmentResidentsFemalesAge1 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge1;
        this.allPeopleAge2 = aCAS001DataRecord.allPeopleAge2;
        this.householdResidentsMalesAge2 = aCAS001DataRecord.householdResidentsMalesAge2;
        this.householdResidentsFemalesAge2 = aCAS001DataRecord.householdResidentsFemalesAge2;
        this.communalEstablishmentResidentsMalesAge2 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge2;
        this.communalEstablishmentResidentsFemalesAge2 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge2;
        this.allPeopleAge3 = aCAS001DataRecord.allPeopleAge3;
        this.householdResidentsMalesAge3 = aCAS001DataRecord.householdResidentsMalesAge3;
        this.householdResidentsFemalesAge3 = aCAS001DataRecord.householdResidentsFemalesAge3;
        this.communalEstablishmentResidentsMalesAge3 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge3;
        this.communalEstablishmentResidentsFemalesAge3 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge3;
        this.allPeopleAge4 = aCAS001DataRecord.allPeopleAge4;
        this.householdResidentsMalesAge4 = aCAS001DataRecord.householdResidentsMalesAge4;
        this.householdResidentsFemalesAge4 = aCAS001DataRecord.householdResidentsFemalesAge4;
        this.communalEstablishmentResidentsMalesAge4 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge4;
        this.communalEstablishmentResidentsFemalesAge4 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge4;
        this.allPeopleAge5to9 = aCAS001DataRecord.allPeopleAge5to9;
        this.householdResidentsMalesAge5to9 = aCAS001DataRecord.householdResidentsMalesAge5to9;
        this.householdResidentsFemalesAge5to9 = aCAS001DataRecord.householdResidentsFemalesAge5to9;
        this.communalEstablishmentResidentsMalesAge5to9 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge5to9;
        this.communalEstablishmentResidentsFemalesAge5to9 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge5to9;
        this.allPeopleAge5 = aCAS001DataRecord.allPeopleAge5;
        this.householdResidentsMalesAge5 = aCAS001DataRecord.householdResidentsMalesAge5;
        this.householdResidentsFemalesAge5 = aCAS001DataRecord.householdResidentsFemalesAge5;
        this.communalEstablishmentResidentsMalesAge5 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge5;
        this.communalEstablishmentResidentsFemalesAge5 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge5;
        this.allPeopleAge6 = aCAS001DataRecord.allPeopleAge6;
        this.householdResidentsMalesAge6 = aCAS001DataRecord.householdResidentsMalesAge6;
        this.householdResidentsFemalesAge6 = aCAS001DataRecord.householdResidentsFemalesAge6;
        this.communalEstablishmentResidentsMalesAge6 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge6;
        this.communalEstablishmentResidentsFemalesAge6 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge6;
        this.allPeopleAge7 = aCAS001DataRecord.allPeopleAge7;
        this.householdResidentsMalesAge7 = aCAS001DataRecord.householdResidentsMalesAge7;
        this.householdResidentsFemalesAge7 = aCAS001DataRecord.householdResidentsFemalesAge7;
        this.communalEstablishmentResidentsMalesAge7 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge7;
        this.communalEstablishmentResidentsFemalesAge7 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge7;
        this.allPeopleAge8 = aCAS001DataRecord.allPeopleAge8;
        this.householdResidentsMalesAge8 = aCAS001DataRecord.householdResidentsMalesAge8;
        this.householdResidentsFemalesAge8 = aCAS001DataRecord.householdResidentsFemalesAge8;
        this.communalEstablishmentResidentsMalesAge8 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge8;
        this.communalEstablishmentResidentsFemalesAge8 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge8;
        this.allPeopleAge9 = aCAS001DataRecord.allPeopleAge9;
        this.householdResidentsMalesAge9 = aCAS001DataRecord.householdResidentsMalesAge9;
        this.householdResidentsFemalesAge9 = aCAS001DataRecord.householdResidentsFemalesAge9;
        this.communalEstablishmentResidentsMalesAge9 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge9;
        this.communalEstablishmentResidentsFemalesAge9 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge9;
        this.allPeopleAge10to14 = aCAS001DataRecord.allPeopleAge10to14;
        this.householdResidentsMalesAge10to14 = aCAS001DataRecord.householdResidentsMalesAge10to14;
        this.householdResidentsFemalesAge10to14 = aCAS001DataRecord.householdResidentsFemalesAge10to14;
        this.communalEstablishmentResidentsMalesAge10to14 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge10to14;
        this.communalEstablishmentResidentsFemalesAge10to14 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge10to14;
        this.allPeopleAge10 = aCAS001DataRecord.allPeopleAge10;
        this.householdResidentsMalesAge10 = aCAS001DataRecord.householdResidentsMalesAge10;
        this.householdResidentsFemalesAge10 = aCAS001DataRecord.householdResidentsFemalesAge10;
        this.communalEstablishmentResidentsMalesAge10 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge10;
        this.communalEstablishmentResidentsFemalesAge10 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge10;
        this.allPeopleAge11 = aCAS001DataRecord.allPeopleAge11;
        this.householdResidentsMalesAge11 = aCAS001DataRecord.householdResidentsMalesAge11;
        this.householdResidentsFemalesAge11 = aCAS001DataRecord.householdResidentsFemalesAge11;
        this.communalEstablishmentResidentsMalesAge11 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge11;
        this.communalEstablishmentResidentsFemalesAge11 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge11;
        this.allPeopleAge12 = aCAS001DataRecord.allPeopleAge12;
        this.householdResidentsMalesAge12 = aCAS001DataRecord.householdResidentsMalesAge12;
        this.householdResidentsFemalesAge12 = aCAS001DataRecord.householdResidentsFemalesAge12;
        this.communalEstablishmentResidentsMalesAge12 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge12;
        this.communalEstablishmentResidentsFemalesAge12 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge12;
        this.allPeopleAge13 = aCAS001DataRecord.allPeopleAge13;
        this.householdResidentsMalesAge13 = aCAS001DataRecord.householdResidentsMalesAge13;
        this.householdResidentsFemalesAge13 = aCAS001DataRecord.householdResidentsFemalesAge13;
        this.communalEstablishmentResidentsMalesAge13 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge13;
        this.communalEstablishmentResidentsFemalesAge13 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge13;
        this.allPeopleAge14 = aCAS001DataRecord.allPeopleAge14;
        this.householdResidentsMalesAge14 = aCAS001DataRecord.householdResidentsMalesAge14;
        this.householdResidentsFemalesAge14 = aCAS001DataRecord.householdResidentsFemalesAge14;
        this.communalEstablishmentResidentsMalesAge14 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge14;
        this.communalEstablishmentResidentsFemalesAge14 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge14;
        this.allPeopleAge15to19 = aCAS001DataRecord.allPeopleAge15to19;
        this.householdResidentsMalesAge15to19 = aCAS001DataRecord.householdResidentsMalesAge15to19;
        this.householdResidentsFemalesAge15to19 = aCAS001DataRecord.householdResidentsFemalesAge15to19;
        this.communalEstablishmentResidentsMalesAge15to19 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge15to19;
        this.communalEstablishmentResidentsFemalesAge15to19 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge15to19;
        this.allPeopleAge15 = aCAS001DataRecord.allPeopleAge15;
        this.householdResidentsMalesAge15 = aCAS001DataRecord.householdResidentsMalesAge15;
        this.householdResidentsFemalesAge15 = aCAS001DataRecord.householdResidentsFemalesAge15;
        this.communalEstablishmentResidentsMalesAge15 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge15;
        this.communalEstablishmentResidentsFemalesAge15 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge15;
        this.allPeopleAge16 = aCAS001DataRecord.allPeopleAge16;
        this.householdResidentsMalesAge16 = aCAS001DataRecord.householdResidentsMalesAge16;
        this.householdResidentsFemalesAge16 = aCAS001DataRecord.householdResidentsFemalesAge16;
        this.communalEstablishmentResidentsMalesAge16 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge16;
        this.communalEstablishmentResidentsFemalesAge16 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge16;
        this.allPeopleAge17 = aCAS001DataRecord.allPeopleAge17;
        this.householdResidentsMalesAge17 = aCAS001DataRecord.householdResidentsMalesAge17;
        this.householdResidentsFemalesAge17 = aCAS001DataRecord.householdResidentsFemalesAge17;
        this.communalEstablishmentResidentsMalesAge17 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge17;
        this.communalEstablishmentResidentsFemalesAge17 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge17;
        this.allPeopleAge18 = aCAS001DataRecord.allPeopleAge18;
        this.householdResidentsMalesAge18 = aCAS001DataRecord.householdResidentsMalesAge18;
        this.householdResidentsFemalesAge18 = aCAS001DataRecord.householdResidentsFemalesAge18;
        this.communalEstablishmentResidentsMalesAge18 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge18;
        this.communalEstablishmentResidentsFemalesAge18 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge18;
        this.allPeopleAge19 = aCAS001DataRecord.allPeopleAge19;
        this.householdResidentsMalesAge19 = aCAS001DataRecord.householdResidentsMalesAge19;
        this.householdResidentsFemalesAge19 = aCAS001DataRecord.householdResidentsFemalesAge19;
        this.communalEstablishmentResidentsMalesAge19 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge19;
        this.communalEstablishmentResidentsFemalesAge19 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge19;
        this.allPeopleAge20to24 = aCAS001DataRecord.allPeopleAge20to24;
        this.householdResidentsMalesAge20to24 = aCAS001DataRecord.householdResidentsMalesAge20to24;
        this.householdResidentsFemalesAge20to24 = aCAS001DataRecord.householdResidentsFemalesAge20to24;
        this.communalEstablishmentResidentsMalesAge20to24 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge20to24;
        this.communalEstablishmentResidentsFemalesAge20to24 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge20to24;
        this.allPeopleAge20 = aCAS001DataRecord.allPeopleAge20;
        this.householdResidentsMalesAge20 = aCAS001DataRecord.householdResidentsMalesAge20;
        this.householdResidentsFemalesAge20 = aCAS001DataRecord.householdResidentsFemalesAge20;
        this.communalEstablishmentResidentsMalesAge20 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge20;
        this.communalEstablishmentResidentsFemalesAge20 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge20;
        this.allPeopleAge21 = aCAS001DataRecord.allPeopleAge21;
        this.householdResidentsMalesAge21 = aCAS001DataRecord.householdResidentsMalesAge21;
        this.householdResidentsFemalesAge21 = aCAS001DataRecord.householdResidentsFemalesAge21;
        this.communalEstablishmentResidentsMalesAge21 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge21;
        this.communalEstablishmentResidentsFemalesAge21 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge21;
        this.allPeopleAge22 = aCAS001DataRecord.allPeopleAge22;
        this.householdResidentsMalesAge22 = aCAS001DataRecord.householdResidentsMalesAge22;
        this.householdResidentsFemalesAge22 = aCAS001DataRecord.householdResidentsFemalesAge22;
        this.communalEstablishmentResidentsMalesAge22 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge22;
        this.communalEstablishmentResidentsFemalesAge22 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge22;
        this.allPeopleAge23 = aCAS001DataRecord.allPeopleAge23;
        this.householdResidentsMalesAge23 = aCAS001DataRecord.householdResidentsMalesAge23;
        this.householdResidentsFemalesAge23 = aCAS001DataRecord.householdResidentsFemalesAge23;
        this.communalEstablishmentResidentsMalesAge23 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge23;
        this.communalEstablishmentResidentsFemalesAge23 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge23;
        this.allPeopleAge24 = aCAS001DataRecord.allPeopleAge24;
        this.householdResidentsMalesAge24 = aCAS001DataRecord.householdResidentsMalesAge24;
        this.householdResidentsFemalesAge24 = aCAS001DataRecord.householdResidentsFemalesAge24;
        this.communalEstablishmentResidentsMalesAge24 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge24;
        this.communalEstablishmentResidentsFemalesAge24 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge24;
        this.allPeopleAge25to29 = aCAS001DataRecord.allPeopleAge25to29;
        this.householdResidentsMalesAge25to29 = aCAS001DataRecord.householdResidentsMalesAge25to29;
        this.householdResidentsFemalesAge25to29 = aCAS001DataRecord.householdResidentsFemalesAge25to29;
        this.communalEstablishmentResidentsMalesAge25to29 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge25to29;
        this.communalEstablishmentResidentsFemalesAge25to29 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge25to29;
        this.allPeopleAge30to34 = aCAS001DataRecord.allPeopleAge30to34;
        this.householdResidentsMalesAge30to34 = aCAS001DataRecord.householdResidentsMalesAge30to34;
        this.householdResidentsFemalesAge30to34 = aCAS001DataRecord.householdResidentsFemalesAge30to34;
        this.communalEstablishmentResidentsMalesAge30to34 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge30to34;
        this.communalEstablishmentResidentsFemalesAge30to34 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge30to34;
        this.allPeopleAge35to39 = aCAS001DataRecord.allPeopleAge35to39;
        this.householdResidentsMalesAge35to39 = aCAS001DataRecord.householdResidentsMalesAge35to39;
        this.householdResidentsFemalesAge35to39 = aCAS001DataRecord.householdResidentsFemalesAge35to39;
        this.communalEstablishmentResidentsMalesAge35to39 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge35to39;
        this.communalEstablishmentResidentsFemalesAge35to39 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge35to39;
        this.allPeopleAge40to44 = aCAS001DataRecord.allPeopleAge40to44;
        this.householdResidentsMalesAge40to44 = aCAS001DataRecord.householdResidentsMalesAge40to44;
        this.householdResidentsFemalesAge40to44 = aCAS001DataRecord.householdResidentsFemalesAge40to44;
        this.communalEstablishmentResidentsMalesAge40to44 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge40to44;
        this.communalEstablishmentResidentsFemalesAge40to44 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge40to44;
        this.allPeopleAge45to49 = aCAS001DataRecord.allPeopleAge45to49;
        this.householdResidentsMalesAge45to49 = aCAS001DataRecord.householdResidentsMalesAge45to49;
        this.householdResidentsFemalesAge45to49 = aCAS001DataRecord.householdResidentsFemalesAge45to49;
        this.communalEstablishmentResidentsMalesAge45to49 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge45to49;
        this.communalEstablishmentResidentsFemalesAge45to49 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge45to49;
        this.allPeopleAge50to54 = aCAS001DataRecord.allPeopleAge50to54;
        this.householdResidentsMalesAge50to54 = aCAS001DataRecord.householdResidentsMalesAge50to54;
        this.householdResidentsFemalesAge50to54 = aCAS001DataRecord.householdResidentsFemalesAge50to54;
        this.communalEstablishmentResidentsMalesAge50to54 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge50to54;
        this.communalEstablishmentResidentsFemalesAge50to54 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge50to54;
        this.allPeopleAge55to59 = aCAS001DataRecord.allPeopleAge55to59;
        this.householdResidentsMalesAge55to59 = aCAS001DataRecord.householdResidentsMalesAge55to59;
        this.householdResidentsFemalesAge55to59 = aCAS001DataRecord.householdResidentsFemalesAge55to59;
        this.communalEstablishmentResidentsMalesAge55to59 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge55to59;
        this.communalEstablishmentResidentsFemalesAge55to59 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge55to59;
        this.allPeopleAge60to64 = aCAS001DataRecord.allPeopleAge60to64;
        this.householdResidentsMalesAge60to64 = aCAS001DataRecord.householdResidentsMalesAge60to64;
        this.householdResidentsFemalesAge60to64 = aCAS001DataRecord.householdResidentsFemalesAge60to64;
        this.communalEstablishmentResidentsMalesAge60to64 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge60to64;
        this.communalEstablishmentResidentsFemalesAge60to64 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge60to64;
        this.allPeopleAge65to69 = aCAS001DataRecord.allPeopleAge65to69;
        this.householdResidentsMalesAge65to69 = aCAS001DataRecord.householdResidentsMalesAge65to69;
        this.householdResidentsFemalesAge65to69 = aCAS001DataRecord.householdResidentsFemalesAge65to69;
        this.communalEstablishmentResidentsMalesAge65to69 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge65to69;
        this.communalEstablishmentResidentsFemalesAge65to69 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge65to69;
        this.allPeopleAge70to74 = aCAS001DataRecord.allPeopleAge70to74;
        this.householdResidentsMalesAge70to74 = aCAS001DataRecord.householdResidentsMalesAge70to74;
        this.householdResidentsFemalesAge70to74 = aCAS001DataRecord.householdResidentsFemalesAge70to74;
        this.communalEstablishmentResidentsMalesAge70to74 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge70to74;
        this.communalEstablishmentResidentsFemalesAge70to74 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge70to74;
        this.allPeopleAge75to79 = aCAS001DataRecord.allPeopleAge75to79;
        this.householdResidentsMalesAge75to79 = aCAS001DataRecord.householdResidentsMalesAge75to79;
        this.householdResidentsFemalesAge75to79 = aCAS001DataRecord.householdResidentsFemalesAge75to79;
        this.communalEstablishmentResidentsMalesAge75to79 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge75to79;
        this.communalEstablishmentResidentsFemalesAge75to79 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge75to79;
        this.allPeopleAge80to84 = aCAS001DataRecord.allPeopleAge80to84;
        this.householdResidentsMalesAge80to84 = aCAS001DataRecord.householdResidentsMalesAge80to84;
        this.householdResidentsFemalesAge80to84 = aCAS001DataRecord.householdResidentsFemalesAge80to84;
        this.communalEstablishmentResidentsMalesAge80to84 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge80to84;
        this.communalEstablishmentResidentsFemalesAge80to84 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge80to84;
        this.allPeopleAge85to89 = aCAS001DataRecord.allPeopleAge85to89;
        this.householdResidentsMalesAge85to89 = aCAS001DataRecord.householdResidentsMalesAge85to89;
        this.householdResidentsFemalesAge85to89 = aCAS001DataRecord.householdResidentsFemalesAge85to89;
        this.communalEstablishmentResidentsMalesAge85to89 = aCAS001DataRecord.communalEstablishmentResidentsMalesAge85to89;
        this.communalEstablishmentResidentsFemalesAge85to89 = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge85to89;
        this.allPeopleAge90AndOver = aCAS001DataRecord.allPeopleAge90AndOver;
        this.householdResidentsMalesAge90AndOver = aCAS001DataRecord.householdResidentsMalesAge90AndOver;
        this.householdResidentsFemalesAge90AndOver = aCAS001DataRecord.householdResidentsFemalesAge90AndOver;
        this.communalEstablishmentResidentsMalesAge90AndOver = aCAS001DataRecord.communalEstablishmentResidentsMalesAge90AndOver;
        this.communalEstablishmentResidentsFemalesAge90AndOver = aCAS001DataRecord.communalEstablishmentResidentsFemalesAge90AndOver;
    }

    /**
     * Returns a string description of this;
     * @return 
     */
    public String toString() {
        String result = super.toString();
        result += ",allPeople " + allPeople + ",householdResidentsMales " + householdResidentsMales + ",householdResidentsFemales " + householdResidentsFemales + ",communalEstablishmentResidentsMales " + communalEstablishmentResidentsMales + ",communalEstablishmentResidentsFemales " + communalEstablishmentResidentsFemales + ",allPeopleAge0to4 " + allPeopleAge0to4 + ",householdResidentsMalesAge0to4 " + householdResidentsMalesAge0to4 + ",householdResidentsFemalesAge0to4 " + householdResidentsFemalesAge0to4 + ",communalEstablishmentResidentsMalesAge0to4 " + communalEstablishmentResidentsMalesAge0to4 + ",communalEstablishmentResidentsFemalesAge0to4 " + communalEstablishmentResidentsFemalesAge0to4 + ",allPeopleAge0 " + allPeopleAge0 + ",householdResidentsMalesAge0 " + householdResidentsMalesAge0 + ",householdResidentsFemalesAge0 " + householdResidentsFemalesAge0 + ",communalEstablishmentResidentsMalesAge0 " + communalEstablishmentResidentsMalesAge0 + ",communalEstablishmentResidentsFemalesAge0 " + communalEstablishmentResidentsFemalesAge0 + ",allPeopleAge1 " + allPeopleAge1 + ",householdResidentsMalesAge1 " + householdResidentsMalesAge1 + ",householdResidentsFemalesAge1 " + householdResidentsFemalesAge1 + ",communalEstablishmentResidentsMalesAge1 " + communalEstablishmentResidentsMalesAge1 + ",communalEstablishmentResidentsFemalesAge1 " + communalEstablishmentResidentsFemalesAge1 + ",allPeopleAge2 " + allPeopleAge2 + ",householdResidentsMalesAge2 " + householdResidentsMalesAge2 + ",householdResidentsFemalesAge2 " + householdResidentsFemalesAge2 + ",communalEstablishmentResidentsMalesAge2 " + communalEstablishmentResidentsMalesAge2 + ",communalEstablishmentResidentsFemalesAge2 " + communalEstablishmentResidentsFemalesAge2 + ",allPeopleAge3 " + allPeopleAge3 + ",householdResidentsMalesAge3 " + householdResidentsMalesAge3 + ",householdResidentsFemalesAge3 " + householdResidentsFemalesAge3 + ",communalEstablishmentResidentsMalesAge3 " + communalEstablishmentResidentsMalesAge3 + ",communalEstablishmentResidentsFemalesAge3 " + communalEstablishmentResidentsFemalesAge3 + ",allPeopleAge4 " + allPeopleAge4 + ",householdResidentsMalesAge4 " + householdResidentsMalesAge4 + ",householdResidentsFemalesAge4 " + householdResidentsFemalesAge4 + ",communalEstablishmentResidentsMalesAge4 " + communalEstablishmentResidentsMalesAge4 + ",communalEstablishmentResidentsFemalesAge4 " + communalEstablishmentResidentsFemalesAge4 + ",allPeopleAge5to9 " + allPeopleAge5to9 + ",householdResidentsMalesAge5to9 " + householdResidentsMalesAge5to9 + ",householdResidentsFemalesAge5to9 " + householdResidentsFemalesAge5to9 + ",communalEstablishmentResidentsMalesAge5to9 " + communalEstablishmentResidentsMalesAge5to9 + ",communalEstablishmentResidentsFemalesAge5to9 " + communalEstablishmentResidentsFemalesAge5to9 + ",allPeopleAge5 " + allPeopleAge5 + ",householdResidentsMalesAge5 " + householdResidentsMalesAge5 + ",householdResidentsFemalesAge5 " + householdResidentsFemalesAge5 + ",communalEstablishmentResidentsMalesAge5 " + communalEstablishmentResidentsMalesAge5 + ",communalEstablishmentResidentsFemalesAge5 " + communalEstablishmentResidentsFemalesAge5 + ",allPeopleAge6 " + allPeopleAge6 + ",householdResidentsMalesAge6 " + householdResidentsMalesAge6 + ",householdResidentsFemalesAge6 " + householdResidentsFemalesAge6 + ",communalEstablishmentResidentsMalesAge6 " + communalEstablishmentResidentsMalesAge6 + ",communalEstablishmentResidentsFemalesAge6 " + communalEstablishmentResidentsFemalesAge6 + ",allPeopleAge7 " + allPeopleAge7 + ",householdResidentsMalesAge7 " + householdResidentsMalesAge7 + ",householdResidentsFemalesAge7 " + householdResidentsFemalesAge7 + ",communalEstablishmentResidentsMalesAge7 " + communalEstablishmentResidentsMalesAge7 + ",communalEstablishmentResidentsFemalesAge7 " + communalEstablishmentResidentsFemalesAge7 + ",allPeopleAge8 " + allPeopleAge8 + ",householdResidentsMalesAge8 " + householdResidentsMalesAge8 + ",householdResidentsFemalesAge8 " + householdResidentsFemalesAge8 + ",communalEstablishmentResidentsMalesAge8 " + communalEstablishmentResidentsMalesAge8 + ",communalEstablishmentResidentsFemalesAge8 " + communalEstablishmentResidentsFemalesAge8 + ",allPeopleAge9 " + allPeopleAge9 + ",householdResidentsMalesAge9 " + householdResidentsMalesAge9 + ",householdResidentsFemalesAge9 " + householdResidentsFemalesAge9 + ",communalEstablishmentResidentsMalesAge9 " + communalEstablishmentResidentsMalesAge9 + ",communalEstablishmentResidentsFemalesAge9 " + communalEstablishmentResidentsFemalesAge9 + ",allPeopleAge10to14 " + allPeopleAge10to14 + ",householdResidentsMalesAge10to14 " + householdResidentsMalesAge10to14 + ",householdResidentsFemalesAge10to14 " + householdResidentsFemalesAge10to14 + ",communalEstablishmentResidentsMalesAge10to14 " + communalEstablishmentResidentsMalesAge10to14 + ",communalEstablishmentResidentsFemalesAge10to14 " + communalEstablishmentResidentsFemalesAge10to14 + ",allPeopleAge10 " + allPeopleAge10 + ",householdResidentsMalesAge10 " + householdResidentsMalesAge10 + ",householdResidentsFemalesAge10 " + householdResidentsFemalesAge10 + ",communalEstablishmentResidentsMalesAge10 " + communalEstablishmentResidentsMalesAge10 + ",communalEstablishmentResidentsFemalesAge10 " + communalEstablishmentResidentsFemalesAge10 + ",allPeopleAge11 " + allPeopleAge11 + ",householdResidentsMalesAge11 " + householdResidentsMalesAge11 + ",householdResidentsFemalesAge11 " + householdResidentsFemalesAge11 + ",communalEstablishmentResidentsMalesAge11 " + communalEstablishmentResidentsMalesAge11 + ",communalEstablishmentResidentsFemalesAge11 " + communalEstablishmentResidentsFemalesAge11 + ",allPeopleAge12 " + allPeopleAge12 + ",householdResidentsMalesAge12 " + householdResidentsMalesAge12 + ",householdResidentsFemalesAge12 " + householdResidentsFemalesAge12 + ",communalEstablishmentResidentsMalesAge12 " + communalEstablishmentResidentsMalesAge12 + ",communalEstablishmentResidentsFemalesAge12 " + communalEstablishmentResidentsFemalesAge12 + ",allPeopleAge13 " + allPeopleAge13 + ",householdResidentsMalesAge13 " + householdResidentsMalesAge13 + ",householdResidentsFemalesAge13 " + householdResidentsFemalesAge13 + ",communalEstablishmentResidentsMalesAge13 " + communalEstablishmentResidentsMalesAge13 + ",communalEstablishmentResidentsFemalesAge13 " + communalEstablishmentResidentsFemalesAge13 + ",allPeopleAge14 " + allPeopleAge14 + ",householdResidentsMalesAge14 " + householdResidentsMalesAge14 + ",householdResidentsFemalesAge14 " + householdResidentsFemalesAge14 + ",communalEstablishmentResidentsMalesAge14 " + communalEstablishmentResidentsMalesAge14 + ",communalEstablishmentResidentsFemalesAge14 " + communalEstablishmentResidentsFemalesAge14 + ",allPeopleAge15to19 " + allPeopleAge15to19 + ",householdResidentsMalesAge15to19 " + householdResidentsMalesAge15to19 + ",householdResidentsFemalesAge15to19 " + householdResidentsFemalesAge15to19 + ",communalEstablishmentResidentsMalesAge15to19 " + communalEstablishmentResidentsMalesAge15to19 + ",communalEstablishmentResidentsFemalesAge15to19 " + communalEstablishmentResidentsFemalesAge15to19 + ",allPeopleAge15 " + allPeopleAge15 + ",householdResidentsMalesAge15 " + householdResidentsMalesAge15 + ",householdResidentsFemalesAge15 " + householdResidentsFemalesAge15 + ",communalEstablishmentResidentsMalesAge15 " + communalEstablishmentResidentsMalesAge15 + ",communalEstablishmentResidentsFemalesAge15 " + communalEstablishmentResidentsFemalesAge15 + ",allPeopleAge16 " + allPeopleAge16 + ",householdResidentsMalesAge16 " + householdResidentsMalesAge16 + ",householdResidentsFemalesAge16 " + householdResidentsFemalesAge16 + ",communalEstablishmentResidentsMalesAge16 " + communalEstablishmentResidentsMalesAge16 + ",communalEstablishmentResidentsFemalesAge16 " + communalEstablishmentResidentsFemalesAge16 + ",allPeopleAge17 " + allPeopleAge17 + ",householdResidentsMalesAge17 " + householdResidentsMalesAge17 + ",householdResidentsFemalesAge17 " + householdResidentsFemalesAge17 + ",communalEstablishmentResidentsMalesAge17 " + communalEstablishmentResidentsMalesAge17 + ",communalEstablishmentResidentsFemalesAge17 " + communalEstablishmentResidentsFemalesAge17 + ",allPeopleAge18 " + allPeopleAge18 + ",householdResidentsMalesAge18 " + householdResidentsMalesAge18 + ",householdResidentsFemalesAge18 " + householdResidentsFemalesAge18 + ",communalEstablishmentResidentsMalesAge18 " + communalEstablishmentResidentsMalesAge18 + ",communalEstablishmentResidentsFemalesAge18 " + communalEstablishmentResidentsFemalesAge18 + ",allPeopleAge19 " + allPeopleAge19 + ",householdResidentsMalesAge19 " + householdResidentsMalesAge19 + ",householdResidentsFemalesAge19 " + householdResidentsFemalesAge19 + ",communalEstablishmentResidentsMalesAge19 " + communalEstablishmentResidentsMalesAge19 + ",communalEstablishmentResidentsFemalesAge19 " + communalEstablishmentResidentsFemalesAge19 + ",allPeopleAge20to24 " + allPeopleAge20to24 + ",householdResidentsMalesAge20to24 " + householdResidentsMalesAge20to24 + ",householdResidentsFemalesAge20to24 " + householdResidentsFemalesAge20to24 + ",communalEstablishmentResidentsMalesAge20to24 " + communalEstablishmentResidentsMalesAge20to24 + ",communalEstablishmentResidentsFemalesAge20to24 " + communalEstablishmentResidentsFemalesAge20to24 + ",allPeopleAge20 " + allPeopleAge20 + ",householdResidentsMalesAge20 " + householdResidentsMalesAge20 + ",householdResidentsFemalesAge20 " + householdResidentsFemalesAge20 + ",communalEstablishmentResidentsMalesAge20 " + communalEstablishmentResidentsMalesAge20 + ",communalEstablishmentResidentsFemalesAge20 " + communalEstablishmentResidentsFemalesAge20 + ",allPeopleAge21 " + allPeopleAge21 + ",householdResidentsMalesAge21 " + householdResidentsMalesAge21 + ",householdResidentsFemalesAge21 " + householdResidentsFemalesAge21 + ",communalEstablishmentResidentsMalesAge21 " + communalEstablishmentResidentsMalesAge21 + ",communalEstablishmentResidentsFemalesAge21 " + communalEstablishmentResidentsFemalesAge21 + ",allPeopleAge22 " + allPeopleAge22 + ",householdResidentsMalesAge22 " + householdResidentsMalesAge22 + ",householdResidentsFemalesAge22 " + householdResidentsFemalesAge22 + ",communalEstablishmentResidentsMalesAge22 " + communalEstablishmentResidentsMalesAge22 + ",communalEstablishmentResidentsFemalesAge22 " + communalEstablishmentResidentsFemalesAge22 + ",allPeopleAge23 " + allPeopleAge23 + ",householdResidentsMalesAge23 " + householdResidentsMalesAge23 + ",householdResidentsFemalesAge23 " + householdResidentsFemalesAge23 + ",communalEstablishmentResidentsMalesAge23 " + communalEstablishmentResidentsMalesAge23 + ",communalEstablishmentResidentsFemalesAge23 " + communalEstablishmentResidentsFemalesAge23 + ",allPeopleAge24 " + allPeopleAge24 + ",householdResidentsMalesAge24 " + householdResidentsMalesAge24 + ",householdResidentsFemalesAge24 " + householdResidentsFemalesAge24 + ",communalEstablishmentResidentsMalesAge24 " + communalEstablishmentResidentsMalesAge24 + ",communalEstablishmentResidentsFemalesAge24 " + communalEstablishmentResidentsFemalesAge24 + ",allPeopleAge25to29 " + allPeopleAge25to29 + ",householdResidentsMalesAge25to29 " + householdResidentsMalesAge25to29 + ",householdResidentsFemalesAge25to29 " + householdResidentsFemalesAge25to29 + ",communalEstablishmentResidentsMalesAge25to29 " + communalEstablishmentResidentsMalesAge25to29 + ",communalEstablishmentResidentsFemalesAge25to29 " + communalEstablishmentResidentsFemalesAge25to29 + ",allPeopleAge30to34 " + allPeopleAge30to34 + ",householdResidentsMalesAge30to34 " + householdResidentsMalesAge30to34 + ",householdResidentsFemalesAge30to34 " + householdResidentsFemalesAge30to34 + ",communalEstablishmentResidentsMalesAge30to34 " + communalEstablishmentResidentsMalesAge30to34 + ",communalEstablishmentResidentsFemalesAge30to34 " + communalEstablishmentResidentsFemalesAge30to34 + ",allPeopleAge35to39 " + allPeopleAge35to39 + ",householdResidentsMalesAge35to39 " + householdResidentsMalesAge35to39 + ",householdResidentsFemalesAge35to39 " + householdResidentsFemalesAge35to39 + ",communalEstablishmentResidentsMalesAge35to39 " + communalEstablishmentResidentsMalesAge35to39 + ",communalEstablishmentResidentsFemalesAge35to39 " + communalEstablishmentResidentsFemalesAge35to39 + ",allPeopleAge40to44 " + allPeopleAge40to44 + ",householdResidentsMalesAge40to44 " + householdResidentsMalesAge40to44 + ",householdResidentsFemalesAge40to44 " + householdResidentsFemalesAge40to44 + ",communalEstablishmentResidentsMalesAge40to44 " + communalEstablishmentResidentsMalesAge40to44 + ",communalEstablishmentResidentsFemalesAge40to44 " + communalEstablishmentResidentsFemalesAge40to44 + ",allPeopleAge45to49 " + allPeopleAge45to49 + ",householdResidentsMalesAge45to49 " + householdResidentsMalesAge45to49 + ",householdResidentsFemalesAge45to49 " + householdResidentsFemalesAge45to49 + ",communalEstablishmentResidentsMalesAge45to49 " + communalEstablishmentResidentsMalesAge45to49 + ",communalEstablishmentResidentsFemalesAge45to49 " + communalEstablishmentResidentsFemalesAge45to49 + ",allPeopleAge50to54 " + allPeopleAge50to54 + ",householdResidentsMalesAge50to54 " + householdResidentsMalesAge50to54 + ",householdResidentsFemalesAge50to54 " + householdResidentsFemalesAge50to54 + ",communalEstablishmentResidentsMalesAge50to54 " + communalEstablishmentResidentsMalesAge50to54 + ",communalEstablishmentResidentsFemalesAge50to54 " + communalEstablishmentResidentsFemalesAge50to54 + ",allPeopleAge55to59 " + allPeopleAge55to59 + ",householdResidentsMalesAge55to59 " + householdResidentsMalesAge55to59 + ",householdResidentsFemalesAge55to59 " + householdResidentsFemalesAge55to59 + ",communalEstablishmentResidentsMalesAge55to59 " + communalEstablishmentResidentsMalesAge55to59 + ",communalEstablishmentResidentsFemalesAge55to59 " + communalEstablishmentResidentsFemalesAge55to59 + ",allPeopleAge60to64 " + allPeopleAge60to64 + ",householdResidentsMalesAge60to64 " + householdResidentsMalesAge60to64 + ",householdResidentsFemalesAge60to64 " + householdResidentsFemalesAge60to64 + ",communalEstablishmentResidentsMalesAge60to64 " + communalEstablishmentResidentsMalesAge60to64 + ",communalEstablishmentResidentsFemalesAge60to64 " + communalEstablishmentResidentsFemalesAge60to64 + ",allPeopleAge65to69 " + allPeopleAge65to69 + ",householdResidentsMalesAge65to69 " + householdResidentsMalesAge65to69 + ",householdResidentsFemalesAge65to69 " + householdResidentsFemalesAge65to69 + ",communalEstablishmentResidentsMalesAge65to69 " + communalEstablishmentResidentsMalesAge65to69 + ",communalEstablishmentResidentsFemalesAge65to69 " + communalEstablishmentResidentsFemalesAge65to69 + ",allPeopleAge70to74 " + allPeopleAge70to74 + ",householdResidentsMalesAge70to74 " + householdResidentsMalesAge70to74 + ",householdResidentsFemalesAge70to74 " + householdResidentsFemalesAge70to74 + ",communalEstablishmentResidentsMalesAge70to74 " + communalEstablishmentResidentsMalesAge70to74 + ",communalEstablishmentResidentsFemalesAge70to74 " + communalEstablishmentResidentsFemalesAge70to74 + ",allPeopleAge75to79 " + allPeopleAge75to79 + ",householdResidentsMalesAge75to79 " + householdResidentsMalesAge75to79 + ",householdResidentsFemalesAge75to79 " + householdResidentsFemalesAge75to79 + ",communalEstablishmentResidentsMalesAge75to79 " + communalEstablishmentResidentsMalesAge75to79 + ",communalEstablishmentResidentsFemalesAge75to79 " + communalEstablishmentResidentsFemalesAge75to79 + ",allPeopleAge80to84 " + allPeopleAge80to84 + ",householdResidentsMalesAge80to84 " + householdResidentsMalesAge80to84 + ",householdResidentsFemalesAge80to84 " + householdResidentsFemalesAge80to84 + ",communalEstablishmentResidentsMalesAge80to84 " + communalEstablishmentResidentsMalesAge80to84 + ",communalEstablishmentResidentsFemalesAge80to84 " + communalEstablishmentResidentsFemalesAge80to84 + ",allPeopleAge85to89 " + allPeopleAge85to89 + ",householdResidentsMalesAge85to89 " + householdResidentsMalesAge85to89 + ",householdResidentsFemalesAge85to89 " + householdResidentsFemalesAge85to89 + ",communalEstablishmentResidentsMalesAge85to89 " + communalEstablishmentResidentsMalesAge85to89 + ",communalEstablishmentResidentsFemalesAge85to89 " + communalEstablishmentResidentsFemalesAge85to89 + ",allPeopleAge90AndOver " + allPeopleAge90AndOver + ",householdResidentsMalesAge90AndOver " + householdResidentsMalesAge90AndOver + ",householdResidentsFemalesAge90AndOver " + householdResidentsFemalesAge90AndOver + ",communalEstablishmentResidentsMalesAge90AndOver " + communalEstablishmentResidentsMalesAge90AndOver + ",communalEstablishmentResidentsFemalesAge90AndOver " + communalEstablishmentResidentsFemalesAge90AndOver;
        return result;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the values
     *         of the <code>Fields</code> of <code>this</code>.
     */
    @Override
    public String toCSVString() {
        String result = super.toCSVString();
        result += "," + this.allPeople;
        result += "," + this.householdResidentsMales;
        result += "," + this.householdResidentsFemales;
        result += "," + this.communalEstablishmentResidentsMales;
        result += "," + this.communalEstablishmentResidentsFemales;
        result += "," + this.allPeopleAge0to4;
        result += "," + this.householdResidentsMalesAge0to4;
        result += "," + this.householdResidentsFemalesAge0to4;
        result += "," + this.communalEstablishmentResidentsMalesAge0to4;
        result += "," + this.communalEstablishmentResidentsFemalesAge0to4;
        result += "," + this.allPeopleAge0;
        result += "," + this.householdResidentsMalesAge0;
        result += "," + this.householdResidentsFemalesAge0;
        result += "," + this.communalEstablishmentResidentsMalesAge0;
        result += "," + this.communalEstablishmentResidentsFemalesAge0;
        result += "," + this.allPeopleAge1;
        result += "," + this.householdResidentsMalesAge1;
        result += "," + this.householdResidentsFemalesAge1;
        result += "," + this.communalEstablishmentResidentsMalesAge1;
        result += "," + this.communalEstablishmentResidentsFemalesAge1;
        result += "," + this.allPeopleAge2;
        result += "," + this.householdResidentsMalesAge2;
        result += "," + this.householdResidentsFemalesAge2;
        result += "," + this.communalEstablishmentResidentsMalesAge2;
        result += "," + this.communalEstablishmentResidentsFemalesAge2;
        result += "," + this.allPeopleAge3;
        result += "," + this.householdResidentsMalesAge3;
        result += "," + this.householdResidentsFemalesAge3;
        result += "," + this.communalEstablishmentResidentsMalesAge3;
        result += "," + this.communalEstablishmentResidentsFemalesAge3;
        result += "," + this.allPeopleAge4;
        result += "," + this.householdResidentsMalesAge4;
        result += "," + this.householdResidentsFemalesAge4;
        result += "," + this.communalEstablishmentResidentsMalesAge4;
        result += "," + this.communalEstablishmentResidentsFemalesAge4;
        result += "," + this.allPeopleAge5to9;
        result += "," + this.householdResidentsMalesAge5to9;
        result += "," + this.householdResidentsFemalesAge5to9;
        result += "," + this.communalEstablishmentResidentsMalesAge5to9;
        result += "," + this.communalEstablishmentResidentsFemalesAge5to9;
        result += "," + this.allPeopleAge5;
        result += "," + this.householdResidentsMalesAge5;
        result += "," + this.householdResidentsFemalesAge5;
        result += "," + this.communalEstablishmentResidentsMalesAge5;
        result += "," + this.communalEstablishmentResidentsFemalesAge5;
        result += "," + this.allPeopleAge6;
        result += "," + this.householdResidentsMalesAge6;
        result += "," + this.householdResidentsFemalesAge6;
        result += "," + this.communalEstablishmentResidentsMalesAge6;
        result += "," + this.communalEstablishmentResidentsFemalesAge6;
        result += "," + this.allPeopleAge7;
        result += "," + this.householdResidentsMalesAge7;
        result += "," + this.householdResidentsFemalesAge7;
        result += "," + this.communalEstablishmentResidentsMalesAge7;
        result += "," + this.communalEstablishmentResidentsFemalesAge7;
        result += "," + this.allPeopleAge8;
        result += "," + this.householdResidentsMalesAge8;
        result += "," + this.householdResidentsFemalesAge8;
        result += "," + this.communalEstablishmentResidentsMalesAge8;
        result += "," + this.communalEstablishmentResidentsFemalesAge8;
        result += "," + this.allPeopleAge9;
        result += "," + this.householdResidentsMalesAge9;
        result += "," + this.householdResidentsFemalesAge9;
        result += "," + this.communalEstablishmentResidentsMalesAge9;
        result += "," + this.communalEstablishmentResidentsFemalesAge9;
        result += "," + this.allPeopleAge10to14;
        result += "," + this.householdResidentsMalesAge10to14;
        result += "," + this.householdResidentsFemalesAge10to14;
        result += "," + this.communalEstablishmentResidentsMalesAge10to14;
        result += "," + this.communalEstablishmentResidentsFemalesAge10to14;
        result += "," + this.allPeopleAge10;
        result += "," + this.householdResidentsMalesAge10;
        result += "," + this.householdResidentsFemalesAge10;
        result += "," + this.communalEstablishmentResidentsMalesAge10;
        result += "," + this.communalEstablishmentResidentsFemalesAge10;
        result += "," + this.allPeopleAge11;
        result += "," + this.householdResidentsMalesAge11;
        result += "," + this.householdResidentsFemalesAge11;
        result += "," + this.communalEstablishmentResidentsMalesAge11;
        result += "," + this.communalEstablishmentResidentsFemalesAge11;
        result += "," + this.allPeopleAge12;
        result += "," + this.householdResidentsMalesAge12;
        result += "," + this.householdResidentsFemalesAge12;
        result += "," + this.communalEstablishmentResidentsMalesAge12;
        result += "," + this.communalEstablishmentResidentsFemalesAge12;
        result += "," + this.allPeopleAge13;
        result += "," + this.householdResidentsMalesAge13;
        result += "," + this.householdResidentsFemalesAge13;
        result += "," + this.communalEstablishmentResidentsMalesAge13;
        result += "," + this.communalEstablishmentResidentsFemalesAge13;
        result += "," + this.allPeopleAge14;
        result += "," + this.householdResidentsMalesAge14;
        result += "," + this.householdResidentsFemalesAge14;
        result += "," + this.communalEstablishmentResidentsMalesAge14;
        result += "," + this.communalEstablishmentResidentsFemalesAge14;
        result += "," + this.allPeopleAge15to19;
        result += "," + this.householdResidentsMalesAge15to19;
        result += "," + this.householdResidentsFemalesAge15to19;
        result += "," + this.communalEstablishmentResidentsMalesAge15to19;
        result += "," + this.communalEstablishmentResidentsFemalesAge15to19;
        result += "," + this.allPeopleAge15;
        result += "," + this.householdResidentsMalesAge15;
        result += "," + this.householdResidentsFemalesAge15;
        result += "," + this.communalEstablishmentResidentsMalesAge15;
        result += "," + this.communalEstablishmentResidentsFemalesAge15;
        result += "," + this.allPeopleAge16;
        result += "," + this.householdResidentsMalesAge16;
        result += "," + this.householdResidentsFemalesAge16;
        result += "," + this.communalEstablishmentResidentsMalesAge16;
        result += "," + this.communalEstablishmentResidentsFemalesAge16;
        result += "," + this.allPeopleAge17;
        result += "," + this.householdResidentsMalesAge17;
        result += "," + this.householdResidentsFemalesAge17;
        result += "," + this.communalEstablishmentResidentsMalesAge17;
        result += "," + this.communalEstablishmentResidentsFemalesAge17;
        result += "," + this.allPeopleAge18;
        result += "," + this.householdResidentsMalesAge18;
        result += "," + this.householdResidentsFemalesAge18;
        result += "," + this.communalEstablishmentResidentsMalesAge18;
        result += "," + this.communalEstablishmentResidentsFemalesAge18;
        result += "," + this.allPeopleAge19;
        result += "," + this.householdResidentsMalesAge19;
        result += "," + this.householdResidentsFemalesAge19;
        result += "," + this.communalEstablishmentResidentsMalesAge19;
        result += "," + this.communalEstablishmentResidentsFemalesAge19;
        result += "," + this.allPeopleAge20to24;
        result += "," + this.householdResidentsMalesAge20to24;
        result += "," + this.householdResidentsFemalesAge20to24;
        result += "," + this.communalEstablishmentResidentsMalesAge20to24;
        result += "," + this.communalEstablishmentResidentsFemalesAge20to24;
        result += "," + this.allPeopleAge20;
        result += "," + this.householdResidentsMalesAge20;
        result += "," + this.householdResidentsFemalesAge20;
        result += "," + this.communalEstablishmentResidentsMalesAge20;
        result += "," + this.communalEstablishmentResidentsFemalesAge20;
        result += "," + this.allPeopleAge21;
        result += "," + this.householdResidentsMalesAge21;
        result += "," + this.householdResidentsFemalesAge21;
        result += "," + this.communalEstablishmentResidentsMalesAge21;
        result += "," + this.communalEstablishmentResidentsFemalesAge21;
        result += "," + this.allPeopleAge22;
        result += "," + this.householdResidentsMalesAge22;
        result += "," + this.householdResidentsFemalesAge22;
        result += "," + this.communalEstablishmentResidentsMalesAge22;
        result += "," + this.communalEstablishmentResidentsFemalesAge22;
        result += "," + this.allPeopleAge23;
        result += "," + this.householdResidentsMalesAge23;
        result += "," + this.householdResidentsFemalesAge23;
        result += "," + this.communalEstablishmentResidentsMalesAge23;
        result += "," + this.communalEstablishmentResidentsFemalesAge23;
        result += "," + this.allPeopleAge24;
        result += "," + this.householdResidentsMalesAge24;
        result += "," + this.householdResidentsFemalesAge24;
        result += "," + this.communalEstablishmentResidentsMalesAge24;
        result += "," + this.communalEstablishmentResidentsFemalesAge24;
        result += "," + this.allPeopleAge25to29;
        result += "," + this.householdResidentsMalesAge25to29;
        result += "," + this.householdResidentsFemalesAge25to29;
        result += "," + this.communalEstablishmentResidentsMalesAge25to29;
        result += "," + this.communalEstablishmentResidentsFemalesAge25to29;
        result += "," + this.allPeopleAge30to34;
        result += "," + this.householdResidentsMalesAge30to34;
        result += "," + this.householdResidentsFemalesAge30to34;
        result += "," + this.communalEstablishmentResidentsMalesAge30to34;
        result += "," + this.communalEstablishmentResidentsFemalesAge30to34;
        result += "," + this.allPeopleAge35to39;
        result += "," + this.householdResidentsMalesAge35to39;
        result += "," + this.householdResidentsFemalesAge35to39;
        result += "," + this.communalEstablishmentResidentsMalesAge35to39;
        result += "," + this.communalEstablishmentResidentsFemalesAge35to39;
        result += "," + this.allPeopleAge40to44;
        result += "," + this.householdResidentsMalesAge40to44;
        result += "," + this.householdResidentsFemalesAge40to44;
        result += "," + this.communalEstablishmentResidentsMalesAge40to44;
        result += "," + this.communalEstablishmentResidentsFemalesAge40to44;
        result += "," + this.allPeopleAge45to49;
        result += "," + this.householdResidentsMalesAge45to49;
        result += "," + this.householdResidentsFemalesAge45to49;
        result += "," + this.communalEstablishmentResidentsMalesAge45to49;
        result += "," + this.communalEstablishmentResidentsFemalesAge45to49;
        result += "," + this.allPeopleAge50to54;
        result += "," + this.householdResidentsMalesAge50to54;
        result += "," + this.householdResidentsFemalesAge50to54;
        result += "," + this.communalEstablishmentResidentsMalesAge50to54;
        result += "," + this.communalEstablishmentResidentsFemalesAge50to54;
        result += "," + this.allPeopleAge55to59;
        result += "," + this.householdResidentsMalesAge55to59;
        result += "," + this.householdResidentsFemalesAge55to59;
        result += "," + this.communalEstablishmentResidentsMalesAge55to59;
        result += "," + this.communalEstablishmentResidentsFemalesAge55to59;
        result += "," + this.allPeopleAge60to64;
        result += "," + this.householdResidentsMalesAge60to64;
        result += "," + this.householdResidentsFemalesAge60to64;
        result += "," + this.communalEstablishmentResidentsMalesAge60to64;
        result += "," + this.communalEstablishmentResidentsFemalesAge60to64;
        result += "," + this.allPeopleAge65to69;
        result += "," + this.householdResidentsMalesAge65to69;
        result += "," + this.householdResidentsFemalesAge65to69;
        result += "," + this.communalEstablishmentResidentsMalesAge65to69;
        result += "," + this.communalEstablishmentResidentsFemalesAge65to69;
        result += "," + this.allPeopleAge70to74;
        result += "," + this.householdResidentsMalesAge70to74;
        result += "," + this.householdResidentsFemalesAge70to74;
        result += "," + this.communalEstablishmentResidentsMalesAge70to74;
        result += "," + this.communalEstablishmentResidentsFemalesAge70to74;
        result += "," + this.allPeopleAge75to79;
        result += "," + this.householdResidentsMalesAge75to79;
        result += "," + this.householdResidentsFemalesAge75to79;
        result += "," + this.communalEstablishmentResidentsMalesAge75to79;
        result += "," + this.communalEstablishmentResidentsFemalesAge75to79;
        result += "," + this.allPeopleAge80to84;
        result += "," + this.householdResidentsMalesAge80to84;
        result += "," + this.householdResidentsFemalesAge80to84;
        result += "," + this.communalEstablishmentResidentsMalesAge80to84;
        result += "," + this.communalEstablishmentResidentsFemalesAge80to84;
        result += "," + this.allPeopleAge85to89;
        result += "," + this.householdResidentsMalesAge85to89;
        result += "," + this.householdResidentsFemalesAge85to89;
        result += "," + this.communalEstablishmentResidentsMalesAge85to89;
        result += "," + this.communalEstablishmentResidentsFemalesAge85to89;
        result += "," + this.allPeopleAge90AndOver;
        result += "," + this.householdResidentsMalesAge90AndOver;
        result += "," + this.householdResidentsFemalesAge90AndOver;
        result += "," + this.communalEstablishmentResidentsMalesAge90AndOver;
        result += "," + this.communalEstablishmentResidentsFemalesAge90AndOver;
        return result;
    }

    /**
     * @return A Comma Seperated Version (CSV) <code>String</code> of the names
     *         of the <code>Fields</code> of <code>this</code>
     */
    @Override
    public String toCSVStringFields() {
        String result = super.toCSVStringFields();
        result += ",allPeople";
        result += ",householdResidentsMales";
        result += ",householdResidentsFemales";
        result += ",communalEstablishmentResidentsMales";
        result += ",communalEstablishmentResidentsFemales";
        result += ",allPeopleAge0to4";
        result += ",householdResidentsMalesAge0to4";
        result += ",householdResidentsFemalesAge0to4";
        result += ",communalEstablishmentResidentsMalesAge0to4";
        result += ",communalEstablishmentResidentsFemalesAge0to4";
        result += ",allPeopleAge0";
        result += ",householdResidentsMalesAge0";
        result += ",householdResidentsFemalesAge0";
        result += ",communalEstablishmentResidentsMalesAge0";
        result += ",communalEstablishmentResidentsFemalesAge0";
        result += ",allPeopleAge1";
        result += ",householdResidentsMalesAge1";
        result += ",householdResidentsFemalesAge1";
        result += ",communalEstablishmentResidentsMalesAge1";
        result += ",communalEstablishmentResidentsFemalesAge1";
        result += ",allPeopleAge2";
        result += ",householdResidentsMalesAge2";
        result += ",householdResidentsFemalesAge2";
        result += ",communalEstablishmentResidentsMalesAge2";
        result += ",communalEstablishmentResidentsFemalesAge2";
        result += ",allPeopleAge3";
        result += ",householdResidentsMalesAge3";
        result += ",householdResidentsFemalesAge3";
        result += ",communalEstablishmentResidentsMalesAge3";
        result += ",communalEstablishmentResidentsFemalesAge3";
        result += ",allPeopleAge4";
        result += ",householdResidentsMalesAge4";
        result += ",householdResidentsFemalesAge4";
        result += ",communalEstablishmentResidentsMalesAge4";
        result += ",communalEstablishmentResidentsFemalesAge4";
        result += ",allPeopleAge5to9";
        result += ",householdResidentsMalesAge5to9";
        result += ",householdResidentsFemalesAge5to9";
        result += ",communalEstablishmentResidentsMalesAge5to9";
        result += ",communalEstablishmentResidentsFemalesAge5to9";
        result += ",allPeopleAge5";
        result += ",householdResidentsMalesAge5";
        result += ",householdResidentsFemalesAge5";
        result += ",communalEstablishmentResidentsMalesAge5";
        result += ",communalEstablishmentResidentsFemalesAge5";
        result += ",allPeopleAge6";
        result += ",householdResidentsMalesAge6";
        result += ",householdResidentsFemalesAge6";
        result += ",communalEstablishmentResidentsMalesAge6";
        result += ",communalEstablishmentResidentsFemalesAge6";
        result += ",allPeopleAge7";
        result += ",householdResidentsMalesAge7";
        result += ",householdResidentsFemalesAge7";
        result += ",communalEstablishmentResidentsMalesAge7";
        result += ",communalEstablishmentResidentsFemalesAge7";
        result += ",allPeopleAge8";
        result += ",householdResidentsMalesAge8";
        result += ",householdResidentsFemalesAge8";
        result += ",communalEstablishmentResidentsMalesAge8";
        result += ",communalEstablishmentResidentsFemalesAge8";
        result += ",allPeopleAge9";
        result += ",householdResidentsMalesAge9";
        result += ",householdResidentsFemalesAge9";
        result += ",communalEstablishmentResidentsMalesAge9";
        result += ",communalEstablishmentResidentsFemalesAge9";
        result += ",allPeopleAge10to14";
        result += ",householdResidentsMalesAge10to14";
        result += ",householdResidentsFemalesAge10to14";
        result += ",communalEstablishmentResidentsMalesAge10to14";
        result += ",communalEstablishmentResidentsFemalesAge10to14";
        result += ",allPeopleAge10";
        result += ",householdResidentsMalesAge10";
        result += ",householdResidentsFemalesAge10";
        result += ",communalEstablishmentResidentsMalesAge10";
        result += ",communalEstablishmentResidentsFemalesAge10";
        result += ",allPeopleAge11";
        result += ",householdResidentsMalesAge11";
        result += ",householdResidentsFemalesAge11";
        result += ",communalEstablishmentResidentsMalesAge11";
        result += ",communalEstablishmentResidentsFemalesAge11";
        result += ",allPeopleAge12";
        result += ",householdResidentsMalesAge12";
        result += ",householdResidentsFemalesAge12";
        result += ",communalEstablishmentResidentsMalesAge12";
        result += ",communalEstablishmentResidentsFemalesAge12";
        result += ",allPeopleAge13";
        result += ",householdResidentsMalesAge13";
        result += ",householdResidentsFemalesAge13";
        result += ",communalEstablishmentResidentsMalesAge13";
        result += ",communalEstablishmentResidentsFemalesAge13";
        result += ",allPeopleAge14";
        result += ",householdResidentsMalesAge14";
        result += ",householdResidentsFemalesAge14";
        result += ",communalEstablishmentResidentsMalesAge14";
        result += ",communalEstablishmentResidentsFemalesAge14";
        result += ",allPeopleAge15to19";
        result += ",householdResidentsMalesAge15to19";
        result += ",householdResidentsFemalesAge15to19";
        result += ",communalEstablishmentResidentsMalesAge15to19";
        result += ",communalEstablishmentResidentsFemalesAge15to19";
        result += ",allPeopleAge15";
        result += ",householdResidentsMalesAge15";
        result += ",householdResidentsFemalesAge15";
        result += ",communalEstablishmentResidentsMalesAge15";
        result += ",communalEstablishmentResidentsFemalesAge15";
        result += ",allPeopleAge16";
        result += ",householdResidentsMalesAge16";
        result += ",householdResidentsFemalesAge16";
        result += ",communalEstablishmentResidentsMalesAge16";
        result += ",communalEstablishmentResidentsFemalesAge16";
        result += ",allPeopleAge17";
        result += ",householdResidentsMalesAge17";
        result += ",householdResidentsFemalesAge17";
        result += ",communalEstablishmentResidentsMalesAge17";
        result += ",communalEstablishmentResidentsFemalesAge17";
        result += ",allPeopleAge18";
        result += ",householdResidentsMalesAge18";
        result += ",householdResidentsFemalesAge18";
        result += ",communalEstablishmentResidentsMalesAge18";
        result += ",communalEstablishmentResidentsFemalesAge18";
        result += ",allPeopleAge19";
        result += ",householdResidentsMalesAge19";
        result += ",householdResidentsFemalesAge19";
        result += ",communalEstablishmentResidentsMalesAge19";
        result += ",communalEstablishmentResidentsFemalesAge19";
        result += ",allPeopleAge20to24";
        result += ",householdResidentsMalesAge20to24";
        result += ",householdResidentsFemalesAge20to24";
        result += ",communalEstablishmentResidentsMalesAge20to24";
        result += ",communalEstablishmentResidentsFemalesAge20to24";
        result += ",allPeopleAge20";
        result += ",householdResidentsMalesAge20";
        result += ",householdResidentsFemalesAge20";
        result += ",communalEstablishmentResidentsMalesAge20";
        result += ",communalEstablishmentResidentsFemalesAge20";
        result += ",allPeopleAge21";
        result += ",householdResidentsMalesAge21";
        result += ",householdResidentsFemalesAge21";
        result += ",communalEstablishmentResidentsMalesAge21";
        result += ",communalEstablishmentResidentsFemalesAge21";
        result += ",allPeopleAge22";
        result += ",householdResidentsMalesAge22";
        result += ",householdResidentsFemalesAge22";
        result += ",communalEstablishmentResidentsMalesAge22";
        result += ",communalEstablishmentResidentsFemalesAge22";
        result += ",allPeopleAge23";
        result += ",householdResidentsMalesAge23";
        result += ",householdResidentsFemalesAge23";
        result += ",communalEstablishmentResidentsMalesAge23";
        result += ",communalEstablishmentResidentsFemalesAge23";
        result += ",allPeopleAge24";
        result += ",householdResidentsMalesAge24";
        result += ",householdResidentsFemalesAge24";
        result += ",communalEstablishmentResidentsMalesAge24";
        result += ",communalEstablishmentResidentsFemalesAge24";
        result += ",allPeopleAge25to29";
        result += ",householdResidentsMalesAge25to29";
        result += ",householdResidentsFemalesAge25to29";
        result += ",communalEstablishmentResidentsMalesAge25to29";
        result += ",communalEstablishmentResidentsFemalesAge25to29";
        result += ",allPeopleAge30to34";
        result += ",householdResidentsMalesAge30to34";
        result += ",householdResidentsFemalesAge30to34";
        result += ",communalEstablishmentResidentsMalesAge30to34";
        result += ",communalEstablishmentResidentsFemalesAge30to34";
        result += ",allPeopleAge35to39";
        result += ",householdResidentsMalesAge35to39";
        result += ",householdResidentsFemalesAge35to39";
        result += ",communalEstablishmentResidentsMalesAge35to39";
        result += ",communalEstablishmentResidentsFemalesAge35to39";
        result += ",allPeopleAge40to44";
        result += ",householdResidentsMalesAge40to44";
        result += ",householdResidentsFemalesAge40to44";
        result += ",communalEstablishmentResidentsMalesAge40to44";
        result += ",communalEstablishmentResidentsFemalesAge40to44";
        result += ",allPeopleAge45to49";
        result += ",householdResidentsMalesAge45to49";
        result += ",householdResidentsFemalesAge45to49";
        result += ",communalEstablishmentResidentsMalesAge45to49";
        result += ",communalEstablishmentResidentsFemalesAge45to49";
        result += ",allPeopleAge50to54";
        result += ",householdResidentsMalesAge50to54";
        result += ",householdResidentsFemalesAge50to54";
        result += ",communalEstablishmentResidentsMalesAge50to54";
        result += ",communalEstablishmentResidentsFemalesAge50to54";
        result += ",allPeopleAge55to59";
        result += ",householdResidentsMalesAge55to59";
        result += ",householdResidentsFemalesAge55to59";
        result += ",communalEstablishmentResidentsMalesAge55to59";
        result += ",communalEstablishmentResidentsFemalesAge55to59";
        result += ",allPeopleAge60to64";
        result += ",householdResidentsMalesAge60to64";
        result += ",householdResidentsFemalesAge60to64";
        result += ",communalEstablishmentResidentsMalesAge60to64";
        result += ",communalEstablishmentResidentsFemalesAge60to64";
        result += ",allPeopleAge65to69";
        result += ",householdResidentsMalesAge65to69";
        result += ",householdResidentsFemalesAge65to69";
        result += ",communalEstablishmentResidentsMalesAge65to69";
        result += ",communalEstablishmentResidentsFemalesAge65to69";
        result += ",allPeopleAge70to74";
        result += ",householdResidentsMalesAge70to74";
        result += ",householdResidentsFemalesAge70to74";
        result += ",communalEstablishmentResidentsMalesAge70to74";
        result += ",communalEstablishmentResidentsFemalesAge70to74";
        result += ",allPeopleAge75to79";
        result += ",householdResidentsMalesAge75to79";
        result += ",householdResidentsFemalesAge75to79";
        result += ",communalEstablishmentResidentsMalesAge75to79";
        result += ",communalEstablishmentResidentsFemalesAge75to79";
        result += ",allPeopleAge80to84";
        result += ",householdResidentsMalesAge80to84";
        result += ",householdResidentsFemalesAge80to84";
        result += ",communalEstablishmentResidentsMalesAge80to84";
        result += ",communalEstablishmentResidentsFemalesAge80to84";
        result += ",allPeopleAge85to89";
        result += ",householdResidentsMalesAge85to89";
        result += ",householdResidentsFemalesAge85to89";
        result += ",communalEstablishmentResidentsMalesAge85to89";
        result += ",communalEstablishmentResidentsFemalesAge85to89";
        result += ",allPeopleAge90AndOver";
        result += ",householdResidentsMalesAge90AndOver";
        result += ",householdResidentsFemalesAge90AndOver";
        result += ",communalEstablishmentResidentsMalesAge90AndOver";
        result += ",communalEstablishmentResidentsFemalesAge90AndOver";
        return result;
    }

    /**
     * Returns a copy of this.allPeople
     * @return 
     */
    public int getAllPeople() {
        return this.allPeople;
    }

    /**
     * Returns a copy of this.householdResidentsMales
     * @return 
     */
    public int getHouseholdResidentsMales() {
        return this.householdResidentsMales;
    }

    /**
     * Returns a copy of this.householdResidentsFemales
     * @return 
     */
    public int getHouseholdResidentsFemales() {
        return this.householdResidentsFemales;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMales
     * @return 
     */
    public int getCommunalEstablishmentResidentsMales() {
        return this.communalEstablishmentResidentsMales;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemales
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemales() {
        return this.communalEstablishmentResidentsFemales;
    }

// It seems this is not worth having as the age groups in the census are a bit of a muddle... 
//
//    /**
//     * Returns a count of all people in the age group (startAge, endAge);
//     */
//    public int getAllPeople(
//            int startAge,
//            int endAge) {
//        if (startAge == 0) {
//            if (endAge == 0)
//        }
//        return this.allPeopleAge0to4;
//    }

    /**
     * Returns a copy of this.allPeopleAge0to4
     * @return 
     */
    public int getAllPeopleAge0to4() {
        return this.allPeopleAge0to4;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge0to4
     * @return 
     */
    public int getHouseholdResidentsMalesAge0to4() {
        return this.householdResidentsMalesAge0to4;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge0to4
     * @return 
     */
    public int getHouseholdResidentsFemalesAge0to4() {
        return this.householdResidentsFemalesAge0to4;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge0to4
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge0to4() {
        return this.communalEstablishmentResidentsMalesAge0to4;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge0to4
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge0to4() {
        return this.communalEstablishmentResidentsFemalesAge0to4;
    }

    /**
     * Returns a copy of this.allPeopleAge0
     * @return 
     */
    public int getAllPeopleAge0() {
        return this.allPeopleAge0;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge0
     * @return 
     */
    public int getHouseholdResidentsMalesAge0() {
        return this.householdResidentsMalesAge0;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge0
     * @return 
     */
    public int getHouseholdResidentsFemalesAge0() {
        return this.householdResidentsFemalesAge0;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge0
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge0() {
        return this.communalEstablishmentResidentsMalesAge0;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge0
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge0() {
        return this.communalEstablishmentResidentsFemalesAge0;
    }

    /**
     * Returns a copy of this.allPeopleAge1
     * @return 
     */
    public int getAllPeopleAge1() {
        return this.allPeopleAge1;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge1
     * @return 
     */
    public int getHouseholdResidentsMalesAge1() {
        return this.householdResidentsMalesAge1;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge1
     * @return 
     */
    public int getHouseholdResidentsFemalesAge1() {
        return this.householdResidentsFemalesAge1;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge1
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge1() {
        return this.communalEstablishmentResidentsMalesAge1;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge1
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge1() {
        return this.communalEstablishmentResidentsFemalesAge1;
    }

    /**
     * Returns a copy of this.allPeopleAge2
     * @return 
     */
    public int getAllPeopleAge2() {
        return this.allPeopleAge2;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge2
     * @return 
     */
    public int getHouseholdResidentsMalesAge2() {
        return this.householdResidentsMalesAge2;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge2
     * @return 
     */
    public int getHouseholdResidentsFemalesAge2() {
        return this.householdResidentsFemalesAge2;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge2
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge2() {
        return this.communalEstablishmentResidentsMalesAge2;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge0
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge2() {
        return this.communalEstablishmentResidentsFemalesAge2;
    }

    /**
     * Returns a copy of this.allPeopleAge3
     * @return 
     */
    public int getAllPeopleAge3() {
        return this.allPeopleAge3;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge3
     * @return 
     */
    public int getHouseholdResidentsMalesAge3() {
        return this.householdResidentsMalesAge3;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge3
     * @return 
     */
    public int getHouseholdResidentsFemalesAge3() {
        return this.householdResidentsFemalesAge3;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge3
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge3() {
        return this.communalEstablishmentResidentsMalesAge3;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge3
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge3() {
        return this.communalEstablishmentResidentsFemalesAge3;
    }

    /**
     * Returns a copy of this.allPeopleAge0
     * @return 
     */
    public int getAllPeopleAge4() {
        return this.allPeopleAge4;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge4
     * @return 
     */
    public int getHouseholdResidentsMalesAge4() {
        return this.householdResidentsMalesAge4;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge4
     * @return 
     */
    public int getHouseholdResidentsFemalesAge4() {
        return this.householdResidentsFemalesAge4;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge4
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge4() {
        return this.communalEstablishmentResidentsMalesAge4;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge4
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge4() {
        return this.communalEstablishmentResidentsFemalesAge4;
    }

    /**
     * Returns a copy of this.allPeopleAge5to9
     * @return 
     */
    public int getAllPeopleAge5to9() {
        return this.allPeopleAge5to9;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge5to9
     * @return 
     */
    public int getHouseholdResidentsMalesAge5to9() {
        return this.householdResidentsMalesAge5to9;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge5to9
     * @return 
     */
    public int getHouseholdResidentsFemalesAge5to9() {
        return this.householdResidentsFemalesAge5to9;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge5to9
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge5to9() {
        return this.communalEstablishmentResidentsMalesAge5to9;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge5to9
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge5to9() {
        return this.communalEstablishmentResidentsFemalesAge5to9;
    }

    /**
     * Returns a copy of this.allPeopleAge5
     * @return 
     */
    public int getAllPeopleAge5() {
        return this.allPeopleAge5;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge5
     * @return 
     */
    public int getHouseholdResidentsMalesAge5() {
        return this.householdResidentsMalesAge5;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge5
     * @return 
     */
    public int getHouseholdResidentsFemalesAge5() {
        return this.householdResidentsFemalesAge5;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge5
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge5() {
        return this.communalEstablishmentResidentsMalesAge5;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge5
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge5() {
        return this.communalEstablishmentResidentsFemalesAge5;
    }

    /**
     * Returns a copy of this.allPeopleAge6
     * @return 
     */
    public int getAllPeopleAge6() {
        return this.allPeopleAge6;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge6
     * @return 
     */
    public int getHouseholdResidentsMalesAge6() {
        return this.householdResidentsMalesAge6;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge6
     * @return 
     */
    public int getHouseholdResidentsFemalesAge6() {
        return this.householdResidentsFemalesAge6;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge6
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge6() {
        return this.communalEstablishmentResidentsMalesAge6;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge6
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge6() {
        return this.communalEstablishmentResidentsFemalesAge6;
    }

    /**
     * Returns a copy of this.allPeopleAge7
     * @return 
     */
    public int getAllPeopleAge7() {
        return this.allPeopleAge7;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge7
     * @return 
     */
    public int getHouseholdResidentsMalesAge7() {
        return this.householdResidentsMalesAge7;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge7
     * @return 
     */
    public int getHouseholdResidentsFemalesAge7() {
        return this.householdResidentsFemalesAge7;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge7
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge7() {
        return this.communalEstablishmentResidentsMalesAge7;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge7
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge7() {
        return this.communalEstablishmentResidentsFemalesAge7;
    }

    /**
     * Returns a copy of this.allPeopleAge8
     * @return 
     */
    public int getAllPeopleAge8() {
        return this.allPeopleAge8;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge8
     * @return 
     */
    public int getHouseholdResidentsMalesAge8() {
        return this.householdResidentsMalesAge8;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge8
     * @return 
     */
    public int getHouseholdResidentsFemalesAge8() {
        return this.householdResidentsFemalesAge8;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge8
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge8() {
        return this.communalEstablishmentResidentsMalesAge8;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge8
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge8() {
        return this.communalEstablishmentResidentsFemalesAge8;
    }

    /**
     * Returns a copy of this.allPeopleAge9
     * @return 
     */
    public int getAllPeopleAge9() {
        return this.allPeopleAge9;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge9
     * @return 
     */
    public int getHouseholdResidentsMalesAge9() {
        return this.householdResidentsMalesAge9;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge9
     * @return 
     */
    public int getHouseholdResidentsFemalesAge9() {
        return this.householdResidentsFemalesAge9;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge9
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge9() {
        return this.communalEstablishmentResidentsMalesAge9;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge9
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge9() {
        return this.communalEstablishmentResidentsFemalesAge9;
    }

    /**
     * Returns a copy of this.allPeopleAge10to14
     * @return 
     */
    public int getAllPeopleAge10to14() {
        return this.allPeopleAge10to14;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge10to14
     * @return 
     */
    public int getHouseholdResidentsMalesAge10to14() {
        return this.householdResidentsMalesAge10to14;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge10to14
     * @return 
     */
    public int getHouseholdResidentsFemalesAge10to14() {
        return this.householdResidentsFemalesAge10to14;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge10to14
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge10to14() {
        return this.communalEstablishmentResidentsMalesAge10to14;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge10to14
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge10to14() {
        return this.communalEstablishmentResidentsFemalesAge10to14;
    }

    /**
     * Returns a copy of this.allPeopleAge10
     * @return 
     */
    public int getAllPeopleAge10() {
        return this.allPeopleAge10;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge10
     * @return 
     */
    public int getHouseholdResidentsMalesAge10() {
        return this.householdResidentsMalesAge10;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge10
     * @return 
     */
    public int getHouseholdResidentsFemalesAge10() {
        return this.householdResidentsFemalesAge10;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge10
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge10() {
        return this.communalEstablishmentResidentsMalesAge10;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge10
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge10() {
        return this.communalEstablishmentResidentsFemalesAge10;
    }

    /**
     * Returns a copy of this.allPeopleAge11
     * @return 
     */
    public int getAllPeopleAge11() {
        return this.allPeopleAge11;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge11
     * @return 
     */
    public int getHouseholdResidentsMalesAge11() {
        return this.householdResidentsMalesAge11;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge11
     * @return 
     */
    public int getHouseholdResidentsFemalesAge11() {
        return this.householdResidentsFemalesAge11;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge11
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge11() {
        return this.communalEstablishmentResidentsMalesAge11;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge11
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge11() {
        return this.communalEstablishmentResidentsFemalesAge11;
    }

    /**
     * Returns a copy of this.allPeopleAge12
     * @return 
     */
    public int getAllPeopleAge12() {
        return this.allPeopleAge12;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge12
     * @return 
     */
    public int getHouseholdResidentsMalesAge12() {
        return this.householdResidentsMalesAge12;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge12
     * @return 
     */
    public int getHouseholdResidentsFemalesAge12() {
        return this.householdResidentsFemalesAge12;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge12
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge12() {
        return this.communalEstablishmentResidentsMalesAge12;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge12
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge12() {
        return this.communalEstablishmentResidentsFemalesAge12;
    }

    /**
     * Returns a copy of this.allPeopleAge13
     * @return 
     */
    public int getAllPeopleAge13() {
        return this.allPeopleAge13;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge13
     * @return 
     */
    public int getHouseholdResidentsMalesAge13() {
        return this.householdResidentsMalesAge13;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge13
     * @return 
     */
    public int getHouseholdResidentsFemalesAge13() {
        return this.householdResidentsFemalesAge13;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge13
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge13() {
        return this.communalEstablishmentResidentsMalesAge13;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge13
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge13() {
        return this.communalEstablishmentResidentsFemalesAge13;
    }

    /**
     * Returns a copy of this.allPeopleAge14
     * @return 
     */
    public int getAllPeopleAge14() {
        return this.allPeopleAge14;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge14
     * @return 
     */
    public int getHouseholdResidentsMalesAge14() {
        return this.householdResidentsMalesAge14;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge14
     * @return 
     */
    public int getHouseholdResidentsFemalesAge14() {
        return this.householdResidentsFemalesAge14;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge14
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge14() {
        return this.communalEstablishmentResidentsMalesAge14;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge14
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge14() {
        return this.communalEstablishmentResidentsFemalesAge14;
    }

    /**
     * Returns a copy of this.allPeopleAge15to19
     * @return 
     */
    public int getAllPeopleAge15to19() {
        return this.allPeopleAge15to19;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge15to19
     * @return 
     */
    public int getHouseholdResidentsMalesAge15to19() {
        return this.householdResidentsMalesAge15to19;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge15to19
     * @return 
     */
    public int getHouseholdResidentsFemalesAge15to19() {
        return this.householdResidentsFemalesAge15to19;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge15to19
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge15to19() {
        return this.communalEstablishmentResidentsMalesAge15to19;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge15to19
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge15to19() {
        return this.communalEstablishmentResidentsFemalesAge15to19;
    }

    /**
     * Returns a copy of this.allPeopleAge15
     * @return 
     */
    public int getAllPeopleAge15() {
        return this.allPeopleAge15;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge15
     * @return 
     */
    public int getHouseholdResidentsMalesAge15() {
        return this.householdResidentsMalesAge15;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge15
     * @return 
     */
    public int getHouseholdResidentsFemalesAge15() {
        return this.householdResidentsFemalesAge15;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge15
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge15() {
        return this.communalEstablishmentResidentsMalesAge15;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge15
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge15() {
        return this.communalEstablishmentResidentsFemalesAge15;
    }

    /**
     * Returns a copy of this.allPeopleAge16
     * @return 
     */
    public int getAllPeopleAge16() {
        return this.allPeopleAge16;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge16
     * @return 
     */
    public int getHouseholdResidentsMalesAge16() {
        return this.householdResidentsMalesAge16;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge16
     * @return 
     */
    public int getHouseholdResidentsFemalesAge16() {
        return this.householdResidentsFemalesAge16;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge16
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge16() {
        return this.communalEstablishmentResidentsMalesAge16;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge16
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge16() {
        return this.communalEstablishmentResidentsFemalesAge16;
    }

    /**
     * Returns a copy of this.allPeopleAge17
     * @return 
     */
    public int getAllPeopleAge17() {
        return this.allPeopleAge17;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge17
     * @return 
     */
    public int getHouseholdResidentsMalesAge17() {
        return this.householdResidentsMalesAge17;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge17
     * @return 
     */
    public int getHouseholdResidentsFemalesAge17() {
        return this.householdResidentsFemalesAge17;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge17
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge17() {
        return this.communalEstablishmentResidentsMalesAge17;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge17
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge17() {
        return this.communalEstablishmentResidentsFemalesAge17;
    }

    /**
     * Returns a copy of this.allPeopleAge18
     * @return 
     */
    public int getAllPeopleAge18() {
        return this.allPeopleAge18;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge18
     * @return 
     */
    public int getHouseholdResidentsMalesAge18() {
        return this.householdResidentsMalesAge18;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge18
     * @return 
     */
    public int getHouseholdResidentsFemalesAge18() {
        return this.householdResidentsFemalesAge18;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge18
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge18() {
        return this.communalEstablishmentResidentsMalesAge18;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge18
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge18() {
        return this.communalEstablishmentResidentsFemalesAge18;
    }

    /**
     * Returns a copy of this.allPeopleAge19
     * @return 
     */
    public int getAllPeopleAge19() {
        return this.allPeopleAge19;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge19
     * @return 
     */
    public int getHouseholdResidentsMalesAge19() {
        return this.householdResidentsMalesAge19;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge19
     * @return 
     */
    public int getHouseholdResidentsFemalesAge19() {
        return this.householdResidentsFemalesAge19;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge19
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge19() {
        return this.communalEstablishmentResidentsMalesAge19;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge19
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge19() {
        return this.communalEstablishmentResidentsFemalesAge19;
    }

    /**
     * Returns a copy of this.allPeopleAge20to24
     * @return 
     */
    public int getAllPeopleAge20to24() {
        return this.allPeopleAge20to24;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge20to24
     * @return 
     */
    public int getHouseholdResidentsMalesAge20to24() {
        return this.householdResidentsMalesAge20to24;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge20to24
     * @return 
     */
    public int getHouseholdResidentsFemalesAge20to24() {
        return this.householdResidentsFemalesAge20to24;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge20to24
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge20to24() {
        return this.communalEstablishmentResidentsMalesAge20to24;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge20to24
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge20to24() {
        return this.communalEstablishmentResidentsFemalesAge20to24;
    }

    /**
     * Returns a copy of this.allPeopleAge20
     * @return 
     */
    public int getAllPeopleAge20() {
        return this.allPeopleAge20;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge20
     * @return 
     */
    public int getHouseholdResidentsMalesAge20() {
        return this.householdResidentsMalesAge20;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge20
     * @return 
     */
    public int getHouseholdResidentsFemalesAge20() {
        return this.householdResidentsFemalesAge20;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge20
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge20() {
        return this.communalEstablishmentResidentsMalesAge20;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge20
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge20() {
        return this.communalEstablishmentResidentsFemalesAge20;
    }

    /**
     * Returns a copy of this.allPeopleAge21
     * @return 
     */
    public int getAllPeopleAge21() {
        return this.allPeopleAge21;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge21
     * @return 
     */
    public int getHouseholdResidentsMalesAge21() {
        return this.householdResidentsMalesAge21;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge21
     * @return 
     */
    public int getHouseholdResidentsFemalesAge21() {
        return this.householdResidentsFemalesAge21;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge21
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge21() {
        return this.communalEstablishmentResidentsMalesAge21;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge21
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge21() {
        return this.communalEstablishmentResidentsFemalesAge21;
    }

    /**
     * Returns a copy of this.allPeopleAge22
     * @return 
     */
    public int getAllPeopleAge22() {
        return this.allPeopleAge22;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge22
     * @return 
     */
    public int getHouseholdResidentsMalesAge22() {
        return this.householdResidentsMalesAge22;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge22
     * @return 
     */
    public int getHouseholdResidentsFemalesAge22() {
        return this.householdResidentsFemalesAge22;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge22
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge22() {
        return this.communalEstablishmentResidentsMalesAge22;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge22
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge22() {
        return this.communalEstablishmentResidentsFemalesAge22;
    }

    /**
     * Returns a copy of this.allPeopleAge23
     * @return 
     */
    public int getAllPeopleAge23() {
        return this.allPeopleAge23;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge23
     * @return 
     */
    public int getHouseholdResidentsMalesAge23() {
        return this.householdResidentsMalesAge23;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge23
     * @return 
     */
    public int getHouseholdResidentsFemalesAge23() {
        return this.householdResidentsFemalesAge23;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge23
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge23() {
        return this.communalEstablishmentResidentsMalesAge23;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge23
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge23() {
        return this.communalEstablishmentResidentsFemalesAge23;
    }

    /**
     * Returns a copy of this.allPeopleAge24
     * @return 
     */
    public int getAllPeopleAge24() {
        return this.allPeopleAge24;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge24
     * @return 
     */
    public int getHouseholdResidentsMalesAge24() {
        return this.householdResidentsMalesAge24;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge24
     * @return 
     */
    public int getHouseholdResidentsFemalesAge24() {
        return this.householdResidentsFemalesAge24;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge24
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge24() {
        return this.communalEstablishmentResidentsMalesAge24;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge24
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge24() {
        return this.communalEstablishmentResidentsFemalesAge24;
    }

    /**
     * Returns a copy of this.allPeopleAge25to29
     * @return 
     */
    public int getAllPeopleAge25to29() {
        return this.allPeopleAge25to29;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge25to29
     * @return 
     */
    public int getHouseholdResidentsMalesAge25to29() {
        return this.householdResidentsMalesAge25to29;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge25to29
     * @return 
     */
    public int getHouseholdResidentsFemalesAge25to29() {
        return this.householdResidentsFemalesAge25to29;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge25to29
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge25to29() {
        return this.communalEstablishmentResidentsMalesAge25to29;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge25to29
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge25to29() {
        return this.communalEstablishmentResidentsFemalesAge25to29;
    }

    /**
     * Returns a copy of this.allPeopleAge30to34
     * @return 
     */
    public int getAllPeopleAge30to34() {
        return this.allPeopleAge30to34;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge30to34
     * @return 
     */
    public int getHouseholdResidentsMalesAge30to34() {
        return this.householdResidentsMalesAge30to34;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge30to34
     * @return 
     */
    public int getHouseholdResidentsFemalesAge30to34() {
        return this.householdResidentsFemalesAge30to34;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge30to34
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge30to34() {
        return this.communalEstablishmentResidentsMalesAge30to34;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge30to34
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge30to34() {
        return this.communalEstablishmentResidentsFemalesAge30to34;
    }

    /**
     * Returns a copy of this.allPeopleAge35to39
     * @return 
     */
    public int getAllPeopleAge35to39() {
        return this.allPeopleAge35to39;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge35to39
     * @return 
     */
    public int getHouseholdResidentsMalesAge35to39() {
        return this.householdResidentsMalesAge35to39;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge35to39
     * @return 
     */
    public int getHouseholdResidentsFemalesAge35to39() {
        return this.householdResidentsFemalesAge35to39;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge35to39
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge35to39() {
        return this.communalEstablishmentResidentsMalesAge35to39;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge35to39
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge35to39() {
        return this.communalEstablishmentResidentsFemalesAge35to39;
    }

    /**
     * Returns a copy of this.allPeopleAge40to44
     * @return 
     */
    public int getAllPeopleAge40to44() {
        return this.allPeopleAge40to44;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge40to44
     * @return 
     */
    public int getHouseholdResidentsMalesAge40to44() {
        return this.householdResidentsMalesAge40to44;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge40to44
     * @return 
     */
    public int getHouseholdResidentsFemalesAge40to44() {
        return this.householdResidentsFemalesAge40to44;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge40to44
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge40to44() {
        return this.communalEstablishmentResidentsMalesAge40to44;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge40to44
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge40to44() {
        return this.communalEstablishmentResidentsFemalesAge40to44;
    }

    /**
     * Returns a copy of this.allPeopleAge45to49
     * @return 
     */
    public int getAllPeopleAge45to49() {
        return this.allPeopleAge45to49;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge45to49
     * @return 
     */
    public int getHouseholdResidentsMalesAge45to49() {
        return this.householdResidentsMalesAge45to49;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge45to49
     * @return 
     */
    public int getHouseholdResidentsFemalesAge45to49() {
        return this.householdResidentsFemalesAge45to49;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge45to49
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge45to49() {
        return this.communalEstablishmentResidentsMalesAge45to49;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge45to49
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge45to49() {
        return this.communalEstablishmentResidentsFemalesAge45to49;
    }

    /**
     * Returns a copy of this.allPeopleAge50to54
     * @return 
     */
    public int getAllPeopleAge50to54() {
        return this.allPeopleAge50to54;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge50to54
     * @return 
     */
    public int getHouseholdResidentsMalesAge50to54() {
        return this.householdResidentsMalesAge50to54;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge50to54
     * @return 
     */
    public int getHouseholdResidentsFemalesAge50to54() {
        return this.householdResidentsFemalesAge50to54;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge50to54
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge50to54() {
        return this.communalEstablishmentResidentsMalesAge50to54;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge50to54
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge50to54() {
        return this.communalEstablishmentResidentsFemalesAge50to54;
    }

    /**
     * Returns a copy of this.allPeopleAge55to59
     * @return 
     */
    public int getAllPeopleAge55to59() {
        return this.allPeopleAge55to59;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge55to59
     * @return 
     */
    public int getHouseholdResidentsMalesAge55to59() {
        return this.householdResidentsMalesAge55to59;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge55to59
     * @return 
     */
    public int getHouseholdResidentsFemalesAge55to59() {
        return this.householdResidentsFemalesAge55to59;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge55to59
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge55to59() {
        return this.communalEstablishmentResidentsMalesAge55to59;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge55to59
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge55to59() {
        return this.communalEstablishmentResidentsFemalesAge55to59;
    }

    /**
     * Returns a copy of this.allPeopleAge60to64
     * @return 
     */
    public int getAllPeopleAge60to64() {
        return this.allPeopleAge60to64;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge60to64
     * @return 
     */
    public int getHouseholdResidentsMalesAge60to64() {
        return this.householdResidentsMalesAge60to64;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge60to64
     * @return 
     */
    public int getHouseholdResidentsFemalesAge60to64() {
        return this.householdResidentsFemalesAge60to64;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge60to64
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge60to64() {
        return this.communalEstablishmentResidentsMalesAge60to64;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge60to64
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge60to64() {
        return this.communalEstablishmentResidentsFemalesAge60to64;
    }

    /**
     * Returns a copy of this.allPeopleAge65to69
     * @return 
     */
    public int getAllPeopleAge65to69() {
        return this.allPeopleAge65to69;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge65to69
     * @return 
     */
    public int getHouseholdResidentsMalesAge65to69() {
        return this.householdResidentsMalesAge65to69;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge65to69
     * @return 
     */
    public int getHouseholdResidentsFemalesAge65to69() {
        return this.householdResidentsFemalesAge65to69;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge65to69
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge65to69() {
        return this.communalEstablishmentResidentsMalesAge65to69;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge65to69
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge65to69() {
        return this.communalEstablishmentResidentsFemalesAge65to69;
    }

    /**
     * Returns a copy of this.allPeopleAge70to74
     * @return 
     */
    public int getAllPeopleAge70to74() {
        return this.allPeopleAge70to74;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge70to74
     * @return 
     */
    public int getHouseholdResidentsMalesAge70to74() {
        return this.householdResidentsMalesAge70to74;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge70to74
     * @return 
     */
    public int getHouseholdResidentsFemalesAge70to74() {
        return this.householdResidentsFemalesAge70to74;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge70to74
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge70to74() {
        return this.communalEstablishmentResidentsMalesAge70to74;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge70to74
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge70to74() {
        return this.communalEstablishmentResidentsFemalesAge70to74;
    }

    /**
     * Returns a copy of this.allPeopleAge75to79
     * @return 
     */
    public int getAllPeopleAge75to79() {
        return this.allPeopleAge75to79;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge75to79
     * @return 
     */
    public int getHouseholdResidentsMalesAge75to79() {
        return this.householdResidentsMalesAge75to79;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge75to79
     * @return 
     */
    public int getHouseholdResidentsFemalesAge75to79() {
        return this.householdResidentsFemalesAge75to79;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge75to79
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge75to79() {
        return this.communalEstablishmentResidentsMalesAge75to79;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge75to79
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge75to79() {
        return this.communalEstablishmentResidentsFemalesAge75to79;
    }

    /**
     * Returns a copy of this.allPeopleAge80to84
     * @return 
     */
    public int getAllPeopleAge80to84() {
        return this.allPeopleAge80to84;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge80to84
     * @return 
     */
    public int getHouseholdResidentsMalesAge80to84() {
        return this.householdResidentsMalesAge80to84;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge80to84
     * @return 
     */
    public int getHouseholdResidentsFemalesAge80to84() {
        return this.householdResidentsFemalesAge80to84;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge80to84
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge80to84() {
        return this.communalEstablishmentResidentsMalesAge80to84;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge80to84
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge80to84() {
        return this.communalEstablishmentResidentsFemalesAge80to84;
    }

    /**
     * Returns a copy of this.allPeopleAge85to89
     * @return 
     */
    public int getAllPeopleAge85to89() {
        return this.allPeopleAge85to89;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge85to89
     * @return 
     */
    public int getHouseholdResidentsMalesAge85to89() {
        return this.householdResidentsMalesAge85to89;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge85to89
     * @return 
     */
    public int getHouseholdResidentsFemalesAge85to89() {
        return this.householdResidentsFemalesAge85to89;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge85to89
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge85to89() {
        return this.communalEstablishmentResidentsMalesAge85to89;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge85to89
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge85to89() {
        return this.communalEstablishmentResidentsFemalesAge85to89;
    }

    /**
     * Returns a copy of this.allPeopleAge90AndOver
     * @return 
     */
    public int getAllPeopleAge90AndOver() {
        return this.allPeopleAge90AndOver;
    }

    /**
     * Returns a copy of this.householdResidentsMalesAge90AndOver
     * @return 
     */
    public int getHouseholdResidentsMalesAge90AndOver() {
        return this.householdResidentsMalesAge90AndOver;
    }

    /**
     * Returns a copy of this.householdResidentsFemalesAge90AndOver
     * @return 
     */
    public int getHouseholdResidentsFemalesAge90AndOver() {
        return this.householdResidentsFemalesAge90AndOver;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsMalesAge90AndOver
     * @return 
     */
    public int getCommunalEstablishmentResidentsMalesAge90AndOver() {
        return this.communalEstablishmentResidentsMalesAge90AndOver;
    }

    /**
     * Returns a copy of this.communalEstablishmentResidentsFemalesAge90AndOver
     * @return 
     */
    public int getCommunalEstablishmentResidentsFemalesAge90AndOver() {
        return this.communalEstablishmentResidentsFemalesAge90AndOver;
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
    public void write(
            RandomAccessFile aRandomAccessFile,
            boolean avoidCallToSuper) {
        if (avoidCallToSuper) {
            try {
                aRandomAccessFile.writeInt(this.allPeople);
                aRandomAccessFile.writeInt(this.householdResidentsMales);
                aRandomAccessFile.writeInt(this.householdResidentsFemales);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMales);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemales);
                aRandomAccessFile.writeInt(this.allPeopleAge0to4);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge0to4);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge0to4);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge0to4);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge0to4);
                aRandomAccessFile.writeInt(this.allPeopleAge0);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge0);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge0);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge0);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge0);
                aRandomAccessFile.writeInt(this.allPeopleAge1);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge1);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge1);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge1);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge1);
                aRandomAccessFile.writeInt(this.allPeopleAge2);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge2);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge2);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge2);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge2);
                aRandomAccessFile.writeInt(this.allPeopleAge3);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge3);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge3);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge3);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge3);
                aRandomAccessFile.writeInt(this.allPeopleAge4);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge4);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge4);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge4);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge4);
                aRandomAccessFile.writeInt(this.allPeopleAge5to9);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge5to9);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge5to9);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge5to9);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge5to9);
                aRandomAccessFile.writeInt(this.allPeopleAge5);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge5);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge5);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge5);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge5);
                aRandomAccessFile.writeInt(this.allPeopleAge6);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge6);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge6);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge6);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge6);
                aRandomAccessFile.writeInt(this.allPeopleAge7);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge7);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge7);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge7);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge7);
                aRandomAccessFile.writeInt(this.allPeopleAge8);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge8);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge8);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge8);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge8);
                aRandomAccessFile.writeInt(this.allPeopleAge9);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge9);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge9);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge9);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge9);
                aRandomAccessFile.writeInt(this.allPeopleAge10to14);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge10to14);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge10to14);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge10to14);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge10to14);
                aRandomAccessFile.writeInt(this.allPeopleAge10);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge10);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge10);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge10);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge10);
                aRandomAccessFile.writeInt(this.allPeopleAge11);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge11);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge11);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge11);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge11);
                aRandomAccessFile.writeInt(this.allPeopleAge12);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge12);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge12);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge12);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge12);
                aRandomAccessFile.writeInt(this.allPeopleAge13);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge13);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge13);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge13);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge13);
                aRandomAccessFile.writeInt(this.allPeopleAge14);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge14);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge14);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge14);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge14);
                aRandomAccessFile.writeInt(this.allPeopleAge15to19);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge15to19);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge15to19);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge15to19);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge15to19);
                aRandomAccessFile.writeInt(this.allPeopleAge15);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge15);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge15);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge15);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge15);
                aRandomAccessFile.writeInt(this.allPeopleAge16);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge16);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge16);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge16);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge16);
                aRandomAccessFile.writeInt(this.allPeopleAge17);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge17);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge17);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge17);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge17);
                aRandomAccessFile.writeInt(this.allPeopleAge18);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge18);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge18);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge18);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge18);
                aRandomAccessFile.writeInt(this.allPeopleAge19);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge19);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge19);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge19);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge19);
                aRandomAccessFile.writeInt(this.allPeopleAge20to24);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge20to24);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge20to24);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge20to24);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge20to24);
                aRandomAccessFile.writeInt(this.allPeopleAge20);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge20);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge20);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge20);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge20);
                aRandomAccessFile.writeInt(this.allPeopleAge21);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge21);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge21);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge21);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge21);
                aRandomAccessFile.writeInt(this.allPeopleAge22);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge22);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge22);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge22);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge22);
                aRandomAccessFile.writeInt(this.allPeopleAge23);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge23);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge23);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge23);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge23);
                aRandomAccessFile.writeInt(this.allPeopleAge24);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge24);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge24);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge24);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge24);
                aRandomAccessFile.writeInt(this.allPeopleAge25to29);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge25to29);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge25to29);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge25to29);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge25to29);
                aRandomAccessFile.writeInt(this.allPeopleAge30to34);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge30to34);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge30to34);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge30to34);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge30to34);
                aRandomAccessFile.writeInt(this.allPeopleAge35to39);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge35to39);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge35to39);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge35to39);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge35to39);
                aRandomAccessFile.writeInt(this.allPeopleAge40to44);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge40to44);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge40to44);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge40to44);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge40to44);
                aRandomAccessFile.writeInt(this.allPeopleAge45to49);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge45to49);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge45to49);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge45to49);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge45to49);
                aRandomAccessFile.writeInt(this.allPeopleAge50to54);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge50to54);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge50to54);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge50to54);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge50to54);
                aRandomAccessFile.writeInt(this.allPeopleAge55to59);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge55to59);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge55to59);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge55to59);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge55to59);
                aRandomAccessFile.writeInt(this.allPeopleAge60to64);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge60to64);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge60to64);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge60to64);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge60to64);
                aRandomAccessFile.writeInt(this.allPeopleAge65to69);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge65to69);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge65to69);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge65to69);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge65to69);
                aRandomAccessFile.writeInt(this.allPeopleAge70to74);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge70to74);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge70to74);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge70to74);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge70to74);
                aRandomAccessFile.writeInt(this.allPeopleAge75to79);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge75to79);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge75to79);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge75to79);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge75to79);
                aRandomAccessFile.writeInt(this.allPeopleAge80to84);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge80to84);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge80to84);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge80to84);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge80to84);
                aRandomAccessFile.writeInt(this.allPeopleAge85to89);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge85to89);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge85to89);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge85to89);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge85to89);
                aRandomAccessFile.writeInt(this.allPeopleAge90AndOver);
                aRandomAccessFile.writeInt(this.householdResidentsMalesAge90AndOver);
                aRandomAccessFile.writeInt(this.householdResidentsFemalesAge90AndOver);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsMalesAge90AndOver);
                aRandomAccessFile.writeInt(this.communalEstablishmentResidentsFemalesAge90AndOver);
            } catch (IOException aIOException) {
                System.err.println(aIOException.getLocalizedMessage());
                System.exit(Generic_ErrorAndExceptionHandler.IOException);
            }
        } else {
            write(aRandomAccessFile);
        }
    }

    /**
     * @return An aggregated <code>CAS001DataRecord</code> where:
     *         <code>RecordID = this.RecordID</code>
     *         <code>Zone_Code = this.Zone_Code</code> For aggregating
     *         <code>CAS001DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCAS001DataRecord
     *            The <code>CAS001DataRecord</code> to be aggregated with
     *            <code>this</code>.
     */
    public CAS001DataRecord aggregate(
            CAS001DataRecord aCAS001DataRecord) {
        CAS001DataRecord newCAS001DataRecord = new CAS001DataRecord(
                aCAS001DataRecord);
        newCAS001DataRecord.allPeople += getAllPeople();
        newCAS001DataRecord.allPeopleAge0 += getAllPeopleAge0();
        newCAS001DataRecord.householdResidentsMales += getHouseholdResidentsMales();
        newCAS001DataRecord.householdResidentsFemales += getHouseholdResidentsFemales();
        newCAS001DataRecord.communalEstablishmentResidentsMales += getCommunalEstablishmentResidentsMales();
        newCAS001DataRecord.communalEstablishmentResidentsFemales += getCommunalEstablishmentResidentsFemales();
        newCAS001DataRecord.allPeopleAge0to4 += getAllPeopleAge0to4();
        newCAS001DataRecord.householdResidentsMalesAge0to4 += getHouseholdResidentsMalesAge0to4();
        newCAS001DataRecord.householdResidentsFemalesAge0to4 += getHouseholdResidentsFemalesAge0to4();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge0to4 += getCommunalEstablishmentResidentsMalesAge0to4();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge0to4 += getCommunalEstablishmentResidentsFemalesAge0to4();
        newCAS001DataRecord.allPeopleAge0 += getAllPeopleAge0();
        newCAS001DataRecord.householdResidentsMalesAge0 += getHouseholdResidentsMalesAge0();
        newCAS001DataRecord.householdResidentsFemalesAge0 += getHouseholdResidentsFemalesAge0();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge0 += getCommunalEstablishmentResidentsMalesAge0();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge0 += getCommunalEstablishmentResidentsFemalesAge0();
        newCAS001DataRecord.allPeopleAge1 += getAllPeopleAge1();
        newCAS001DataRecord.householdResidentsMalesAge1 += getHouseholdResidentsMalesAge1();
        newCAS001DataRecord.householdResidentsFemalesAge1 += getHouseholdResidentsFemalesAge1();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge1 += getCommunalEstablishmentResidentsMalesAge1();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge1 += getCommunalEstablishmentResidentsFemalesAge1();
        newCAS001DataRecord.allPeopleAge2 += getAllPeopleAge2();
        newCAS001DataRecord.householdResidentsMalesAge2 += getHouseholdResidentsMalesAge2();
        newCAS001DataRecord.householdResidentsFemalesAge2 += getHouseholdResidentsFemalesAge2();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge2 += getCommunalEstablishmentResidentsMalesAge2();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge2 += getCommunalEstablishmentResidentsFemalesAge2();
        newCAS001DataRecord.allPeopleAge3 += getAllPeopleAge3();
        newCAS001DataRecord.householdResidentsMalesAge3 += getHouseholdResidentsMalesAge3();
        newCAS001DataRecord.householdResidentsFemalesAge3 += getHouseholdResidentsFemalesAge3();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge3 += getCommunalEstablishmentResidentsMalesAge3();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge3 += getCommunalEstablishmentResidentsFemalesAge3();
        newCAS001DataRecord.allPeopleAge4 += getAllPeopleAge4();
        newCAS001DataRecord.householdResidentsMalesAge4 += getHouseholdResidentsMalesAge4();
        newCAS001DataRecord.householdResidentsFemalesAge4 += getHouseholdResidentsFemalesAge4();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge4 += getCommunalEstablishmentResidentsMalesAge4();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge4 += getCommunalEstablishmentResidentsFemalesAge4();
        newCAS001DataRecord.allPeopleAge5to9 += getAllPeopleAge5to9();
        newCAS001DataRecord.householdResidentsMalesAge5to9 += getHouseholdResidentsMalesAge5to9();
        newCAS001DataRecord.householdResidentsFemalesAge5to9 += getHouseholdResidentsFemalesAge5to9();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge5to9 += getCommunalEstablishmentResidentsMalesAge5to9();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge5to9 += getCommunalEstablishmentResidentsFemalesAge5to9();
        newCAS001DataRecord.allPeopleAge5 += getAllPeopleAge5();
        newCAS001DataRecord.householdResidentsMalesAge5 += getHouseholdResidentsMalesAge5();
        newCAS001DataRecord.householdResidentsFemalesAge5 += getHouseholdResidentsFemalesAge5();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge5 += getCommunalEstablishmentResidentsMalesAge5();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge5 += getCommunalEstablishmentResidentsFemalesAge5();
        newCAS001DataRecord.allPeopleAge6 += getAllPeopleAge6();
        newCAS001DataRecord.householdResidentsMalesAge6 += getHouseholdResidentsMalesAge6();
        newCAS001DataRecord.householdResidentsFemalesAge6 += getHouseholdResidentsFemalesAge6();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge6 += getCommunalEstablishmentResidentsMalesAge6();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge6 += getCommunalEstablishmentResidentsFemalesAge6();
        newCAS001DataRecord.allPeopleAge7 += getAllPeopleAge7();
        newCAS001DataRecord.householdResidentsMalesAge7 += getHouseholdResidentsMalesAge7();
        newCAS001DataRecord.householdResidentsFemalesAge7 += getHouseholdResidentsFemalesAge7();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge7 += getCommunalEstablishmentResidentsMalesAge7();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge7 += getCommunalEstablishmentResidentsFemalesAge7();
        newCAS001DataRecord.allPeopleAge8 += getAllPeopleAge8();
        newCAS001DataRecord.householdResidentsMalesAge8 += getHouseholdResidentsMalesAge8();
        newCAS001DataRecord.householdResidentsFemalesAge8 += getHouseholdResidentsFemalesAge8();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge8 += getCommunalEstablishmentResidentsMalesAge8();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge8 += getCommunalEstablishmentResidentsFemalesAge8();
        newCAS001DataRecord.allPeopleAge9 += getAllPeopleAge9();
        newCAS001DataRecord.householdResidentsMalesAge9 += getHouseholdResidentsMalesAge9();
        newCAS001DataRecord.householdResidentsFemalesAge9 += getHouseholdResidentsFemalesAge9();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge9 += getCommunalEstablishmentResidentsMalesAge9();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge9 += getCommunalEstablishmentResidentsFemalesAge9();
        newCAS001DataRecord.allPeopleAge10to14 += getAllPeopleAge10to14();
        newCAS001DataRecord.householdResidentsMalesAge10to14 += getHouseholdResidentsMalesAge10to14();
        newCAS001DataRecord.householdResidentsFemalesAge10to14 += getHouseholdResidentsFemalesAge10to14();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge10to14 += getCommunalEstablishmentResidentsMalesAge10to14();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge10to14 += getCommunalEstablishmentResidentsFemalesAge10to14();
        newCAS001DataRecord.allPeopleAge10 += getAllPeopleAge10();
        newCAS001DataRecord.householdResidentsMalesAge10 += getHouseholdResidentsMalesAge10();
        newCAS001DataRecord.householdResidentsFemalesAge10 += getHouseholdResidentsFemalesAge10();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge10 += getCommunalEstablishmentResidentsMalesAge10();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge10 += getCommunalEstablishmentResidentsFemalesAge10();
        newCAS001DataRecord.allPeopleAge11 += getAllPeopleAge11();
        newCAS001DataRecord.householdResidentsMalesAge11 += getHouseholdResidentsMalesAge11();
        newCAS001DataRecord.householdResidentsFemalesAge11 += getHouseholdResidentsFemalesAge11();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge11 += getCommunalEstablishmentResidentsMalesAge11();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge11 += getCommunalEstablishmentResidentsFemalesAge11();
        newCAS001DataRecord.allPeopleAge12 += getAllPeopleAge12();
        newCAS001DataRecord.householdResidentsMalesAge12 += getHouseholdResidentsMalesAge12();
        newCAS001DataRecord.householdResidentsFemalesAge12 += getHouseholdResidentsFemalesAge12();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge12 += getCommunalEstablishmentResidentsMalesAge12();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge12 += getCommunalEstablishmentResidentsFemalesAge12();
        newCAS001DataRecord.allPeopleAge13 += getAllPeopleAge13();
        newCAS001DataRecord.householdResidentsMalesAge13 += getHouseholdResidentsMalesAge13();
        newCAS001DataRecord.householdResidentsFemalesAge13 += getHouseholdResidentsFemalesAge13();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge13 += getCommunalEstablishmentResidentsMalesAge13();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge13 += getCommunalEstablishmentResidentsFemalesAge13();
        newCAS001DataRecord.allPeopleAge14 += getAllPeopleAge14();
        newCAS001DataRecord.householdResidentsMalesAge14 += getHouseholdResidentsMalesAge14();
        newCAS001DataRecord.householdResidentsFemalesAge14 += getHouseholdResidentsFemalesAge14();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge14 += getCommunalEstablishmentResidentsMalesAge14();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge14 += getCommunalEstablishmentResidentsFemalesAge14();
        newCAS001DataRecord.allPeopleAge15to19 += getAllPeopleAge15to19();
        newCAS001DataRecord.householdResidentsMalesAge15to19 += getHouseholdResidentsMalesAge15to19();
        newCAS001DataRecord.householdResidentsFemalesAge15to19 += getHouseholdResidentsFemalesAge15to19();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge15to19 += getCommunalEstablishmentResidentsMalesAge15to19();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge15to19 += getCommunalEstablishmentResidentsFemalesAge15to19();
        newCAS001DataRecord.allPeopleAge15 += getAllPeopleAge15();
        newCAS001DataRecord.householdResidentsMalesAge15 += getHouseholdResidentsMalesAge15();
        newCAS001DataRecord.householdResidentsFemalesAge15 += getHouseholdResidentsFemalesAge15();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge15 += getCommunalEstablishmentResidentsMalesAge15();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge15 += getCommunalEstablishmentResidentsFemalesAge15();
        newCAS001DataRecord.allPeopleAge16 += getAllPeopleAge16();
        newCAS001DataRecord.householdResidentsMalesAge16 += getHouseholdResidentsMalesAge16();
        newCAS001DataRecord.householdResidentsFemalesAge16 += getHouseholdResidentsFemalesAge16();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge16 += getCommunalEstablishmentResidentsMalesAge16();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge16 += getCommunalEstablishmentResidentsFemalesAge16();
        newCAS001DataRecord.allPeopleAge17 += getAllPeopleAge17();
        newCAS001DataRecord.householdResidentsMalesAge17 += getHouseholdResidentsMalesAge17();
        newCAS001DataRecord.householdResidentsFemalesAge17 += getHouseholdResidentsFemalesAge17();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge17 += getCommunalEstablishmentResidentsMalesAge17();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge17 += getCommunalEstablishmentResidentsFemalesAge17();
        newCAS001DataRecord.allPeopleAge18 += getAllPeopleAge18();
        newCAS001DataRecord.householdResidentsMalesAge18 += getHouseholdResidentsMalesAge18();
        newCAS001DataRecord.householdResidentsFemalesAge18 += getHouseholdResidentsFemalesAge18();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge18 += getCommunalEstablishmentResidentsMalesAge18();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge18 += getCommunalEstablishmentResidentsFemalesAge18();
        newCAS001DataRecord.allPeopleAge19 += getAllPeopleAge19();
        newCAS001DataRecord.householdResidentsMalesAge19 += getHouseholdResidentsMalesAge19();
        newCAS001DataRecord.householdResidentsFemalesAge19 += getHouseholdResidentsFemalesAge19();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge19 += getCommunalEstablishmentResidentsMalesAge19();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge19 += getCommunalEstablishmentResidentsFemalesAge19();
        newCAS001DataRecord.allPeopleAge20to24 += getAllPeopleAge20to24();
        newCAS001DataRecord.householdResidentsMalesAge20to24 += getHouseholdResidentsMalesAge20to24();
        newCAS001DataRecord.householdResidentsFemalesAge20to24 += getHouseholdResidentsFemalesAge20to24();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge20to24 += getCommunalEstablishmentResidentsMalesAge20to24();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge20to24 += getCommunalEstablishmentResidentsFemalesAge20to24();
        newCAS001DataRecord.allPeopleAge20 += getAllPeopleAge20();
        newCAS001DataRecord.householdResidentsMalesAge20 += getHouseholdResidentsMalesAge20();
        newCAS001DataRecord.householdResidentsFemalesAge20 += getHouseholdResidentsFemalesAge20();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge20 += getCommunalEstablishmentResidentsMalesAge20();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge20 += getCommunalEstablishmentResidentsFemalesAge20();
        newCAS001DataRecord.allPeopleAge21 += getAllPeopleAge21();
        newCAS001DataRecord.householdResidentsMalesAge21 += getHouseholdResidentsMalesAge21();
        newCAS001DataRecord.householdResidentsFemalesAge21 += getHouseholdResidentsFemalesAge21();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge21 += getCommunalEstablishmentResidentsMalesAge21();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge21 += getCommunalEstablishmentResidentsFemalesAge21();
        newCAS001DataRecord.allPeopleAge22 += getAllPeopleAge22();
        newCAS001DataRecord.householdResidentsMalesAge22 += getHouseholdResidentsMalesAge22();
        newCAS001DataRecord.householdResidentsFemalesAge22 += getHouseholdResidentsFemalesAge22();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge22 += getCommunalEstablishmentResidentsMalesAge22();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge22 += getCommunalEstablishmentResidentsFemalesAge22();
        newCAS001DataRecord.allPeopleAge23 += getAllPeopleAge23();
        newCAS001DataRecord.householdResidentsMalesAge23 += getHouseholdResidentsMalesAge23();
        newCAS001DataRecord.householdResidentsFemalesAge23 += getHouseholdResidentsFemalesAge23();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge23 += getCommunalEstablishmentResidentsMalesAge23();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge23 += getCommunalEstablishmentResidentsFemalesAge23();
        newCAS001DataRecord.allPeopleAge24 += getAllPeopleAge24();
        newCAS001DataRecord.householdResidentsMalesAge24 += getHouseholdResidentsMalesAge24();
        newCAS001DataRecord.householdResidentsFemalesAge24 += getHouseholdResidentsFemalesAge24();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge24 += getCommunalEstablishmentResidentsMalesAge24();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge24 += getCommunalEstablishmentResidentsFemalesAge24();
        newCAS001DataRecord.allPeopleAge25to29 += getAllPeopleAge25to29();
        newCAS001DataRecord.householdResidentsMalesAge25to29 += getHouseholdResidentsMalesAge25to29();
        newCAS001DataRecord.householdResidentsFemalesAge25to29 += getHouseholdResidentsFemalesAge25to29();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge25to29 += getCommunalEstablishmentResidentsMalesAge25to29();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge25to29 += getCommunalEstablishmentResidentsFemalesAge25to29();
        newCAS001DataRecord.allPeopleAge30to34 += getAllPeopleAge30to34();
        newCAS001DataRecord.householdResidentsMalesAge30to34 += getHouseholdResidentsMalesAge30to34();
        newCAS001DataRecord.householdResidentsFemalesAge30to34 += getHouseholdResidentsFemalesAge30to34();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge30to34 += getCommunalEstablishmentResidentsMalesAge30to34();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge30to34 += getCommunalEstablishmentResidentsFemalesAge30to34();
        newCAS001DataRecord.allPeopleAge35to39 += getAllPeopleAge35to39();
        newCAS001DataRecord.householdResidentsMalesAge35to39 += getHouseholdResidentsMalesAge35to39();
        newCAS001DataRecord.householdResidentsFemalesAge35to39 += getHouseholdResidentsFemalesAge35to39();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge35to39 += getCommunalEstablishmentResidentsMalesAge35to39();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge35to39 += getCommunalEstablishmentResidentsFemalesAge35to39();
        newCAS001DataRecord.allPeopleAge40to44 += getAllPeopleAge40to44();
        newCAS001DataRecord.householdResidentsMalesAge40to44 += getHouseholdResidentsMalesAge40to44();
        newCAS001DataRecord.householdResidentsFemalesAge40to44 += getHouseholdResidentsFemalesAge40to44();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge40to44 += getCommunalEstablishmentResidentsMalesAge40to44();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge40to44 += getCommunalEstablishmentResidentsFemalesAge40to44();
        newCAS001DataRecord.allPeopleAge45to49 += getAllPeopleAge45to49();
        newCAS001DataRecord.householdResidentsMalesAge45to49 += getHouseholdResidentsMalesAge45to49();
        newCAS001DataRecord.householdResidentsFemalesAge45to49 += getHouseholdResidentsFemalesAge45to49();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge45to49 += getCommunalEstablishmentResidentsMalesAge45to49();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge45to49 += getCommunalEstablishmentResidentsFemalesAge45to49();
        newCAS001DataRecord.allPeopleAge50to54 += getAllPeopleAge50to54();
        newCAS001DataRecord.householdResidentsMalesAge50to54 += getHouseholdResidentsMalesAge50to54();
        newCAS001DataRecord.householdResidentsFemalesAge50to54 += getHouseholdResidentsFemalesAge50to54();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge50to54 += getCommunalEstablishmentResidentsMalesAge50to54();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge50to54 += getCommunalEstablishmentResidentsFemalesAge50to54();
        newCAS001DataRecord.allPeopleAge55to59 += getAllPeopleAge55to59();
        newCAS001DataRecord.householdResidentsMalesAge55to59 += getHouseholdResidentsMalesAge55to59();
        newCAS001DataRecord.householdResidentsFemalesAge55to59 += getHouseholdResidentsFemalesAge55to59();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge55to59 += getCommunalEstablishmentResidentsMalesAge55to59();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge55to59 += getCommunalEstablishmentResidentsFemalesAge55to59();
        newCAS001DataRecord.allPeopleAge60to64 += getAllPeopleAge60to64();
        newCAS001DataRecord.householdResidentsMalesAge60to64 += getHouseholdResidentsMalesAge60to64();
        newCAS001DataRecord.householdResidentsFemalesAge60to64 += getHouseholdResidentsFemalesAge60to64();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge60to64 += getCommunalEstablishmentResidentsMalesAge60to64();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge60to64 += getCommunalEstablishmentResidentsFemalesAge60to64();
        newCAS001DataRecord.allPeopleAge65to69 += getAllPeopleAge65to69();
        newCAS001DataRecord.householdResidentsMalesAge65to69 += getHouseholdResidentsMalesAge65to69();
        newCAS001DataRecord.householdResidentsFemalesAge65to69 += getHouseholdResidentsFemalesAge65to69();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge65to69 += getCommunalEstablishmentResidentsMalesAge65to69();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge65to69 += getCommunalEstablishmentResidentsFemalesAge65to69();
        newCAS001DataRecord.allPeopleAge70to74 += getAllPeopleAge70to74();
        newCAS001DataRecord.householdResidentsMalesAge70to74 += getHouseholdResidentsMalesAge70to74();
        newCAS001DataRecord.householdResidentsFemalesAge70to74 += getHouseholdResidentsFemalesAge70to74();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge70to74 += getCommunalEstablishmentResidentsMalesAge70to74();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge70to74 += getCommunalEstablishmentResidentsFemalesAge70to74();
        newCAS001DataRecord.allPeopleAge75to79 += getAllPeopleAge75to79();
        newCAS001DataRecord.householdResidentsMalesAge75to79 += getHouseholdResidentsMalesAge75to79();
        newCAS001DataRecord.householdResidentsFemalesAge75to79 += getHouseholdResidentsFemalesAge75to79();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge75to79 += getCommunalEstablishmentResidentsMalesAge75to79();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge75to79 += getCommunalEstablishmentResidentsFemalesAge75to79();
        newCAS001DataRecord.allPeopleAge80to84 += getAllPeopleAge80to84();
        newCAS001DataRecord.householdResidentsMalesAge80to84 += getHouseholdResidentsMalesAge80to84();
        newCAS001DataRecord.householdResidentsFemalesAge80to84 += getHouseholdResidentsFemalesAge80to84();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge80to84 += getCommunalEstablishmentResidentsMalesAge80to84();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge80to84 += getCommunalEstablishmentResidentsFemalesAge80to84();
        newCAS001DataRecord.allPeopleAge85to89 += getAllPeopleAge85to89();
        newCAS001DataRecord.householdResidentsMalesAge85to89 += getHouseholdResidentsMalesAge85to89();
        newCAS001DataRecord.householdResidentsFemalesAge85to89 += getHouseholdResidentsFemalesAge85to89();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge85to89 += getCommunalEstablishmentResidentsMalesAge85to89();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge85to89 += getCommunalEstablishmentResidentsFemalesAge85to89();
        newCAS001DataRecord.allPeopleAge90AndOver += getAllPeopleAge90AndOver();
        newCAS001DataRecord.householdResidentsMalesAge90AndOver += getHouseholdResidentsMalesAge90AndOver();
        newCAS001DataRecord.householdResidentsFemalesAge90AndOver += getHouseholdResidentsFemalesAge90AndOver();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge90AndOver += getCommunalEstablishmentResidentsMalesAge90AndOver();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge90AndOver += getCommunalEstablishmentResidentsFemalesAge90AndOver();
        return newCAS001DataRecord;
    }

    /**
     * @return An aggregated <code>CAS001DataRecord</code> where:
     *         <code>RecordID = newRecordID</code>
     *         <code>Zone_Code = newZone_Code</code> For aggregating
     *         <code>CAS001DataRecords</code>. User needs to take care in
     *         aggregating to ensure aggregation does not compromise (introduce
     *         error) based on the numbers used (i.e. numbers may not be precise
     *         or have sufficient magnitude).
     * @param aCAS001DataRecord
     *            The <code>CAS001DataRecord</code> to be aggregated with
     *            <code>this</code>.
     * @param newRecordID
     *            The <code>RecordID</code> assigned to result.
     * @param newZone_Code
     *            The <code>Zone_Code</code> assigned to result.
     */
    public CAS001DataRecord aggregate(
            CAS001DataRecord aCAS001DataRecord,
            long newRecordID,
            char[] newZone_Code) {
        CAS001DataRecord newCAS001DataRecord = new CAS001DataRecord(this);
        newCAS001DataRecord._RecordID = newRecordID;
        // newCAS001DataRecord.Zone_Code = aCAS001DataRecord.Zone_Code;
        int aZone_CodeID = 0;
        for (int Zone_CodeID = 0; Zone_CodeID < newZone_Code.length; Zone_CodeID++) {
            newCAS001DataRecord.Zone_Code[Zone_CodeID] = newZone_Code[Zone_CodeID];
            aZone_CodeID = Zone_CodeID;
        }
        for (int Zone_CodeID = aZone_CodeID; Zone_CodeID < Zone_Code.length; Zone_CodeID++) {
            newCAS001DataRecord.Zone_Code[Zone_CodeID] = ' ';
        }
        newCAS001DataRecord.allPeople += getAllPeople();
        newCAS001DataRecord.allPeopleAge0 += getAllPeopleAge0();
        newCAS001DataRecord.householdResidentsMales += getHouseholdResidentsMales();
        newCAS001DataRecord.householdResidentsFemales += getHouseholdResidentsFemales();
        newCAS001DataRecord.communalEstablishmentResidentsMales += getCommunalEstablishmentResidentsMales();
        newCAS001DataRecord.communalEstablishmentResidentsFemales += getCommunalEstablishmentResidentsFemales();
        newCAS001DataRecord.allPeopleAge0to4 += getAllPeopleAge0to4();
        newCAS001DataRecord.householdResidentsMalesAge0to4 += getHouseholdResidentsMalesAge0to4();
        newCAS001DataRecord.householdResidentsFemalesAge0to4 += getHouseholdResidentsFemalesAge0to4();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge0to4 += getCommunalEstablishmentResidentsMalesAge0to4();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge0to4 += getCommunalEstablishmentResidentsFemalesAge0to4();
        newCAS001DataRecord.allPeopleAge0 += getAllPeopleAge0();
        newCAS001DataRecord.householdResidentsMalesAge0 += getHouseholdResidentsMalesAge0();
        newCAS001DataRecord.householdResidentsFemalesAge0 += getHouseholdResidentsFemalesAge0();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge0 += getCommunalEstablishmentResidentsMalesAge0();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge0 += getCommunalEstablishmentResidentsFemalesAge0();
        newCAS001DataRecord.allPeopleAge1 += getAllPeopleAge1();
        newCAS001DataRecord.householdResidentsMalesAge1 += getHouseholdResidentsMalesAge1();
        newCAS001DataRecord.householdResidentsFemalesAge1 += getHouseholdResidentsFemalesAge1();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge1 += getCommunalEstablishmentResidentsMalesAge1();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge1 += getCommunalEstablishmentResidentsFemalesAge1();
        newCAS001DataRecord.allPeopleAge2 += getAllPeopleAge2();
        newCAS001DataRecord.householdResidentsMalesAge2 += getHouseholdResidentsMalesAge2();
        newCAS001DataRecord.householdResidentsFemalesAge2 += getHouseholdResidentsFemalesAge2();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge2 += getCommunalEstablishmentResidentsMalesAge2();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge2 += getCommunalEstablishmentResidentsFemalesAge2();
        newCAS001DataRecord.allPeopleAge3 += getAllPeopleAge3();
        newCAS001DataRecord.householdResidentsMalesAge3 += getHouseholdResidentsMalesAge3();
        newCAS001DataRecord.householdResidentsFemalesAge3 += getHouseholdResidentsFemalesAge3();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge3 += getCommunalEstablishmentResidentsMalesAge3();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge3 += getCommunalEstablishmentResidentsFemalesAge3();
        newCAS001DataRecord.allPeopleAge4 += getAllPeopleAge4();
        newCAS001DataRecord.householdResidentsMalesAge4 += getHouseholdResidentsMalesAge4();
        newCAS001DataRecord.householdResidentsFemalesAge4 += getHouseholdResidentsFemalesAge4();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge4 += getCommunalEstablishmentResidentsMalesAge4();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge4 += getCommunalEstablishmentResidentsFemalesAge4();
        newCAS001DataRecord.allPeopleAge5to9 += getAllPeopleAge5to9();
        newCAS001DataRecord.householdResidentsMalesAge5to9 += getHouseholdResidentsMalesAge5to9();
        newCAS001DataRecord.householdResidentsFemalesAge5to9 += getHouseholdResidentsFemalesAge5to9();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge5to9 += getCommunalEstablishmentResidentsMalesAge5to9();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge5to9 += getCommunalEstablishmentResidentsFemalesAge5to9();
        newCAS001DataRecord.allPeopleAge5 += getAllPeopleAge5();
        newCAS001DataRecord.householdResidentsMalesAge5 += getHouseholdResidentsMalesAge5();
        newCAS001DataRecord.householdResidentsFemalesAge5 += getHouseholdResidentsFemalesAge5();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge5 += getCommunalEstablishmentResidentsMalesAge5();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge5 += getCommunalEstablishmentResidentsFemalesAge5();
        newCAS001DataRecord.allPeopleAge6 += getAllPeopleAge6();
        newCAS001DataRecord.householdResidentsMalesAge6 += getHouseholdResidentsMalesAge6();
        newCAS001DataRecord.householdResidentsFemalesAge6 += getHouseholdResidentsFemalesAge6();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge6 += getCommunalEstablishmentResidentsMalesAge6();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge6 += getCommunalEstablishmentResidentsFemalesAge6();
        newCAS001DataRecord.allPeopleAge7 += getAllPeopleAge7();
        newCAS001DataRecord.householdResidentsMalesAge7 += getHouseholdResidentsMalesAge7();
        newCAS001DataRecord.householdResidentsFemalesAge7 += getHouseholdResidentsFemalesAge7();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge7 += getCommunalEstablishmentResidentsMalesAge7();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge7 += getCommunalEstablishmentResidentsFemalesAge7();
        newCAS001DataRecord.allPeopleAge8 += getAllPeopleAge8();
        newCAS001DataRecord.householdResidentsMalesAge8 += getHouseholdResidentsMalesAge8();
        newCAS001DataRecord.householdResidentsFemalesAge8 += getHouseholdResidentsFemalesAge8();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge8 += getCommunalEstablishmentResidentsMalesAge8();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge8 += getCommunalEstablishmentResidentsFemalesAge8();
        newCAS001DataRecord.allPeopleAge9 += getAllPeopleAge9();
        newCAS001DataRecord.householdResidentsMalesAge9 += getHouseholdResidentsMalesAge9();
        newCAS001DataRecord.householdResidentsFemalesAge9 += getHouseholdResidentsFemalesAge9();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge9 += getCommunalEstablishmentResidentsMalesAge9();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge9 += getCommunalEstablishmentResidentsFemalesAge9();
        newCAS001DataRecord.allPeopleAge10to14 += getAllPeopleAge10to14();
        newCAS001DataRecord.householdResidentsMalesAge10to14 += getHouseholdResidentsMalesAge10to14();
        newCAS001DataRecord.householdResidentsFemalesAge10to14 += getHouseholdResidentsFemalesAge10to14();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge10to14 += getCommunalEstablishmentResidentsMalesAge10to14();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge10to14 += getCommunalEstablishmentResidentsFemalesAge10to14();
        newCAS001DataRecord.allPeopleAge10 += getAllPeopleAge10();
        newCAS001DataRecord.householdResidentsMalesAge10 += getHouseholdResidentsMalesAge10();
        newCAS001DataRecord.householdResidentsFemalesAge10 += getHouseholdResidentsFemalesAge10();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge10 += getCommunalEstablishmentResidentsMalesAge10();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge10 += getCommunalEstablishmentResidentsFemalesAge10();
        newCAS001DataRecord.allPeopleAge11 += getAllPeopleAge11();
        newCAS001DataRecord.householdResidentsMalesAge11 += getHouseholdResidentsMalesAge11();
        newCAS001DataRecord.householdResidentsFemalesAge11 += getHouseholdResidentsFemalesAge11();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge11 += getCommunalEstablishmentResidentsMalesAge11();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge11 += getCommunalEstablishmentResidentsFemalesAge11();
        newCAS001DataRecord.allPeopleAge12 += getAllPeopleAge12();
        newCAS001DataRecord.householdResidentsMalesAge12 += getHouseholdResidentsMalesAge12();
        newCAS001DataRecord.householdResidentsFemalesAge12 += getHouseholdResidentsFemalesAge12();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge12 += getCommunalEstablishmentResidentsMalesAge12();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge12 += getCommunalEstablishmentResidentsFemalesAge12();
        newCAS001DataRecord.allPeopleAge13 += getAllPeopleAge13();
        newCAS001DataRecord.householdResidentsMalesAge13 += getHouseholdResidentsMalesAge13();
        newCAS001DataRecord.householdResidentsFemalesAge13 += getHouseholdResidentsFemalesAge13();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge13 += getCommunalEstablishmentResidentsMalesAge13();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge13 += getCommunalEstablishmentResidentsFemalesAge13();
        newCAS001DataRecord.allPeopleAge14 += getAllPeopleAge14();
        newCAS001DataRecord.householdResidentsMalesAge14 += getHouseholdResidentsMalesAge14();
        newCAS001DataRecord.householdResidentsFemalesAge14 += getHouseholdResidentsFemalesAge14();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge14 += getCommunalEstablishmentResidentsMalesAge14();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge14 += getCommunalEstablishmentResidentsFemalesAge14();
        newCAS001DataRecord.allPeopleAge15to19 += getAllPeopleAge15to19();
        newCAS001DataRecord.householdResidentsMalesAge15to19 += getHouseholdResidentsMalesAge15to19();
        newCAS001DataRecord.householdResidentsFemalesAge15to19 += getHouseholdResidentsFemalesAge15to19();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge15to19 += getCommunalEstablishmentResidentsMalesAge15to19();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge15to19 += getCommunalEstablishmentResidentsFemalesAge15to19();
        newCAS001DataRecord.allPeopleAge15 += getAllPeopleAge15();
        newCAS001DataRecord.householdResidentsMalesAge15 += getHouseholdResidentsMalesAge15();
        newCAS001DataRecord.householdResidentsFemalesAge15 += getHouseholdResidentsFemalesAge15();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge15 += getCommunalEstablishmentResidentsMalesAge15();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge15 += getCommunalEstablishmentResidentsFemalesAge15();
        newCAS001DataRecord.allPeopleAge16 += getAllPeopleAge16();
        newCAS001DataRecord.householdResidentsMalesAge16 += getHouseholdResidentsMalesAge16();
        newCAS001DataRecord.householdResidentsFemalesAge16 += getHouseholdResidentsFemalesAge16();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge16 += getCommunalEstablishmentResidentsMalesAge16();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge16 += getCommunalEstablishmentResidentsFemalesAge16();
        newCAS001DataRecord.allPeopleAge17 += getAllPeopleAge17();
        newCAS001DataRecord.householdResidentsMalesAge17 += getHouseholdResidentsMalesAge17();
        newCAS001DataRecord.householdResidentsFemalesAge17 += getHouseholdResidentsFemalesAge17();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge17 += getCommunalEstablishmentResidentsMalesAge17();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge17 += getCommunalEstablishmentResidentsFemalesAge17();
        newCAS001DataRecord.allPeopleAge18 += getAllPeopleAge18();
        newCAS001DataRecord.householdResidentsMalesAge18 += getHouseholdResidentsMalesAge18();
        newCAS001DataRecord.householdResidentsFemalesAge18 += getHouseholdResidentsFemalesAge18();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge18 += getCommunalEstablishmentResidentsMalesAge18();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge18 += getCommunalEstablishmentResidentsFemalesAge18();
        newCAS001DataRecord.allPeopleAge19 += getAllPeopleAge19();
        newCAS001DataRecord.householdResidentsMalesAge19 += getHouseholdResidentsMalesAge19();
        newCAS001DataRecord.householdResidentsFemalesAge19 += getHouseholdResidentsFemalesAge19();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge19 += getCommunalEstablishmentResidentsMalesAge19();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge19 += getCommunalEstablishmentResidentsFemalesAge19();
        newCAS001DataRecord.allPeopleAge20to24 += getAllPeopleAge20to24();
        newCAS001DataRecord.householdResidentsMalesAge20to24 += getHouseholdResidentsMalesAge20to24();
        newCAS001DataRecord.householdResidentsFemalesAge20to24 += getHouseholdResidentsFemalesAge20to24();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge20to24 += getCommunalEstablishmentResidentsMalesAge20to24();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge20to24 += getCommunalEstablishmentResidentsFemalesAge20to24();
        newCAS001DataRecord.allPeopleAge20 += getAllPeopleAge20();
        newCAS001DataRecord.householdResidentsMalesAge20 += getHouseholdResidentsMalesAge20();
        newCAS001DataRecord.householdResidentsFemalesAge20 += getHouseholdResidentsFemalesAge20();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge20 += getCommunalEstablishmentResidentsMalesAge20();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge20 += getCommunalEstablishmentResidentsFemalesAge20();
        newCAS001DataRecord.allPeopleAge21 += getAllPeopleAge21();
        newCAS001DataRecord.householdResidentsMalesAge21 += getHouseholdResidentsMalesAge21();
        newCAS001DataRecord.householdResidentsFemalesAge21 += getHouseholdResidentsFemalesAge21();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge21 += getCommunalEstablishmentResidentsMalesAge21();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge21 += getCommunalEstablishmentResidentsFemalesAge21();
        newCAS001DataRecord.allPeopleAge22 += getAllPeopleAge22();
        newCAS001DataRecord.householdResidentsMalesAge22 += getHouseholdResidentsMalesAge22();
        newCAS001DataRecord.householdResidentsFemalesAge22 += getHouseholdResidentsFemalesAge22();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge22 += getCommunalEstablishmentResidentsMalesAge22();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge22 += getCommunalEstablishmentResidentsFemalesAge22();
        newCAS001DataRecord.allPeopleAge23 += getAllPeopleAge23();
        newCAS001DataRecord.householdResidentsMalesAge23 += getHouseholdResidentsMalesAge23();
        newCAS001DataRecord.householdResidentsFemalesAge23 += getHouseholdResidentsFemalesAge23();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge23 += getCommunalEstablishmentResidentsMalesAge23();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge23 += getCommunalEstablishmentResidentsFemalesAge23();
        newCAS001DataRecord.allPeopleAge24 += getAllPeopleAge24();
        newCAS001DataRecord.householdResidentsMalesAge24 += getHouseholdResidentsMalesAge24();
        newCAS001DataRecord.householdResidentsFemalesAge24 += getHouseholdResidentsFemalesAge24();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge24 += getCommunalEstablishmentResidentsMalesAge24();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge24 += getCommunalEstablishmentResidentsFemalesAge24();
        newCAS001DataRecord.allPeopleAge25to29 += getAllPeopleAge25to29();
        newCAS001DataRecord.householdResidentsMalesAge25to29 += getHouseholdResidentsMalesAge25to29();
        newCAS001DataRecord.householdResidentsFemalesAge25to29 += getHouseholdResidentsFemalesAge25to29();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge25to29 += getCommunalEstablishmentResidentsMalesAge25to29();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge25to29 += getCommunalEstablishmentResidentsFemalesAge25to29();
        newCAS001DataRecord.allPeopleAge30to34 += getAllPeopleAge30to34();
        newCAS001DataRecord.householdResidentsMalesAge30to34 += getHouseholdResidentsMalesAge30to34();
        newCAS001DataRecord.householdResidentsFemalesAge30to34 += getHouseholdResidentsFemalesAge30to34();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge30to34 += getCommunalEstablishmentResidentsMalesAge30to34();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge30to34 += getCommunalEstablishmentResidentsFemalesAge30to34();
        newCAS001DataRecord.allPeopleAge35to39 += getAllPeopleAge35to39();
        newCAS001DataRecord.householdResidentsMalesAge35to39 += getHouseholdResidentsMalesAge35to39();
        newCAS001DataRecord.householdResidentsFemalesAge35to39 += getHouseholdResidentsFemalesAge35to39();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge35to39 += getCommunalEstablishmentResidentsMalesAge35to39();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge35to39 += getCommunalEstablishmentResidentsFemalesAge35to39();
        newCAS001DataRecord.allPeopleAge40to44 += getAllPeopleAge40to44();
        newCAS001DataRecord.householdResidentsMalesAge40to44 += getHouseholdResidentsMalesAge40to44();
        newCAS001DataRecord.householdResidentsFemalesAge40to44 += getHouseholdResidentsFemalesAge40to44();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge40to44 += getCommunalEstablishmentResidentsMalesAge40to44();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge40to44 += getCommunalEstablishmentResidentsFemalesAge40to44();
        newCAS001DataRecord.allPeopleAge45to49 += getAllPeopleAge45to49();
        newCAS001DataRecord.householdResidentsMalesAge45to49 += getHouseholdResidentsMalesAge45to49();
        newCAS001DataRecord.householdResidentsFemalesAge45to49 += getHouseholdResidentsFemalesAge45to49();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge45to49 += getCommunalEstablishmentResidentsMalesAge45to49();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge45to49 += getCommunalEstablishmentResidentsFemalesAge45to49();
        newCAS001DataRecord.allPeopleAge50to54 += getAllPeopleAge50to54();
        newCAS001DataRecord.householdResidentsMalesAge50to54 += getHouseholdResidentsMalesAge50to54();
        newCAS001DataRecord.householdResidentsFemalesAge50to54 += getHouseholdResidentsFemalesAge50to54();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge50to54 += getCommunalEstablishmentResidentsMalesAge50to54();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge50to54 += getCommunalEstablishmentResidentsFemalesAge50to54();
        newCAS001DataRecord.allPeopleAge55to59 += getAllPeopleAge55to59();
        newCAS001DataRecord.householdResidentsMalesAge55to59 += getHouseholdResidentsMalesAge55to59();
        newCAS001DataRecord.householdResidentsFemalesAge55to59 += getHouseholdResidentsFemalesAge55to59();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge55to59 += getCommunalEstablishmentResidentsMalesAge55to59();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge55to59 += getCommunalEstablishmentResidentsFemalesAge55to59();
        newCAS001DataRecord.allPeopleAge60to64 += getAllPeopleAge60to64();
        newCAS001DataRecord.householdResidentsMalesAge60to64 += getHouseholdResidentsMalesAge60to64();
        newCAS001DataRecord.householdResidentsFemalesAge60to64 += getHouseholdResidentsFemalesAge60to64();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge60to64 += getCommunalEstablishmentResidentsMalesAge60to64();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge60to64 += getCommunalEstablishmentResidentsFemalesAge60to64();
        newCAS001DataRecord.allPeopleAge65to69 += getAllPeopleAge65to69();
        newCAS001DataRecord.householdResidentsMalesAge65to69 += getHouseholdResidentsMalesAge65to69();
        newCAS001DataRecord.householdResidentsFemalesAge65to69 += getHouseholdResidentsFemalesAge65to69();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge65to69 += getCommunalEstablishmentResidentsMalesAge65to69();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge65to69 += getCommunalEstablishmentResidentsFemalesAge65to69();
        newCAS001DataRecord.allPeopleAge70to74 += getAllPeopleAge70to74();
        newCAS001DataRecord.householdResidentsMalesAge70to74 += getHouseholdResidentsMalesAge70to74();
        newCAS001DataRecord.householdResidentsFemalesAge70to74 += getHouseholdResidentsFemalesAge70to74();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge70to74 += getCommunalEstablishmentResidentsMalesAge70to74();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge70to74 += getCommunalEstablishmentResidentsFemalesAge70to74();
        newCAS001DataRecord.allPeopleAge75to79 += getAllPeopleAge75to79();
        newCAS001DataRecord.householdResidentsMalesAge75to79 += getHouseholdResidentsMalesAge75to79();
        newCAS001DataRecord.householdResidentsFemalesAge75to79 += getHouseholdResidentsFemalesAge75to79();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge75to79 += getCommunalEstablishmentResidentsMalesAge75to79();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge75to79 += getCommunalEstablishmentResidentsFemalesAge75to79();
        newCAS001DataRecord.allPeopleAge80to84 += getAllPeopleAge80to84();
        newCAS001DataRecord.householdResidentsMalesAge80to84 += getHouseholdResidentsMalesAge80to84();
        newCAS001DataRecord.householdResidentsFemalesAge80to84 += getHouseholdResidentsFemalesAge80to84();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge80to84 += getCommunalEstablishmentResidentsMalesAge80to84();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge80to84 += getCommunalEstablishmentResidentsFemalesAge80to84();
        newCAS001DataRecord.allPeopleAge85to89 += getAllPeopleAge85to89();
        newCAS001DataRecord.householdResidentsMalesAge85to89 += getHouseholdResidentsMalesAge85to89();
        newCAS001DataRecord.householdResidentsFemalesAge85to89 += getHouseholdResidentsFemalesAge85to89();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge85to89 += getCommunalEstablishmentResidentsMalesAge85to89();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge85to89 += getCommunalEstablishmentResidentsFemalesAge85to89();
        newCAS001DataRecord.allPeopleAge90AndOver += getAllPeopleAge90AndOver();
        newCAS001DataRecord.householdResidentsMalesAge90AndOver += getHouseholdResidentsMalesAge90AndOver();
        newCAS001DataRecord.householdResidentsFemalesAge90AndOver += getHouseholdResidentsFemalesAge90AndOver();
        newCAS001DataRecord.communalEstablishmentResidentsMalesAge90AndOver += getCommunalEstablishmentResidentsMalesAge90AndOver();
        newCAS001DataRecord.communalEstablishmentResidentsFemalesAge90AndOver += getCommunalEstablishmentResidentsFemalesAge90AndOver();
        return newCAS001DataRecord;
    }

    /**
     * Returns the size of this CAS001DataRecord in bytes as a long. This does
     * not account for serialVersionUID. A boolean is assumed to be the same
     * size as an int in bytes.
     * @return 
     */
    @Override
    public long getSizeInBytes() {
        long result = super.getSizeInBytes();
        result += (225L * (long) Integer.SIZE) / getNumberOfBitsInByte();
        return result;
    }

    /**
     * @return An AgeGenderPopulation keys are minAge and maxAge, values are female then male counts for this.
     */
    public HashMap<Integer[],Integer[]> getAgeGenderPopulation(){
        HashMap<Integer[],Integer[]> ageGenderPopulation = new HashMap<Integer[],Integer[]>();
        Integer[] a_MinAge_MaxAge;
        Integer[] a_FemalePopulation_MalePopulation;
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 0;
        a_MinAge_MaxAge[1] = 0;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge0() + getHouseholdResidentsFemalesAge0();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge0() + getHouseholdResidentsMalesAge0();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 1;
        a_MinAge_MaxAge[1] = 1;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge1() + getHouseholdResidentsFemalesAge1();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge1() + getHouseholdResidentsMalesAge1();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 2;
        a_MinAge_MaxAge[1] = 2;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge2() + getHouseholdResidentsFemalesAge2();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge2() + getHouseholdResidentsMalesAge3();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 3;
        a_MinAge_MaxAge[1] = 3;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge3() + getHouseholdResidentsFemalesAge3();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge3() + getHouseholdResidentsMalesAge3();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 4;
        a_MinAge_MaxAge[1] = 4;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge4() + getHouseholdResidentsFemalesAge4();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge4() + getHouseholdResidentsMalesAge4();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 5;
        a_MinAge_MaxAge[1] = 5;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge5() + getHouseholdResidentsFemalesAge5();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge5() + getHouseholdResidentsMalesAge5();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 6;
        a_MinAge_MaxAge[1] = 6;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge6() + getHouseholdResidentsFemalesAge6();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge6() + getHouseholdResidentsMalesAge6();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 7;
        a_MinAge_MaxAge[1] = 7;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge7() + getHouseholdResidentsFemalesAge7();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge7() + getHouseholdResidentsMalesAge7();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 8;
        a_MinAge_MaxAge[1] = 8;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge8() + getHouseholdResidentsFemalesAge8();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge8() + getHouseholdResidentsMalesAge8();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 9;
        a_MinAge_MaxAge[1] = 9;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge9() + getHouseholdResidentsFemalesAge9();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge9() + getHouseholdResidentsMalesAge9();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 10;
        a_MinAge_MaxAge[1] = 10;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge10() + getHouseholdResidentsFemalesAge10();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge10() + getHouseholdResidentsMalesAge10();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 11;
        a_MinAge_MaxAge[1] = 11;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge11() + getHouseholdResidentsFemalesAge11();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge11() + getHouseholdResidentsMalesAge11();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 12;
        a_MinAge_MaxAge[1] = 12;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge12() + getHouseholdResidentsFemalesAge12();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge12() + getHouseholdResidentsMalesAge12();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 13;
        a_MinAge_MaxAge[1] = 13;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge13() + getHouseholdResidentsFemalesAge13();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge13() + getHouseholdResidentsMalesAge13();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 14;
        a_MinAge_MaxAge[1] = 14;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge14() + getHouseholdResidentsFemalesAge14();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge14() + getHouseholdResidentsMalesAge14();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 15;
        a_MinAge_MaxAge[1] = 15;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge15() + getHouseholdResidentsFemalesAge15();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge15() + getHouseholdResidentsMalesAge15();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 16;
        a_MinAge_MaxAge[1] = 16;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge16() + getHouseholdResidentsFemalesAge16();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge16() + getHouseholdResidentsMalesAge16();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 17;
        a_MinAge_MaxAge[1] = 17;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge17() + getHouseholdResidentsFemalesAge17();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge17() + getHouseholdResidentsMalesAge17();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 18;
        a_MinAge_MaxAge[1] = 18;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge18() + getHouseholdResidentsFemalesAge18();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge18() + getHouseholdResidentsMalesAge18();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 19;
        a_MinAge_MaxAge[1] = 19;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge19() + getHouseholdResidentsFemalesAge19();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge19() + getHouseholdResidentsMalesAge19();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 20;
        a_MinAge_MaxAge[1] = 20;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge20() + getHouseholdResidentsFemalesAge20();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge20() + getHouseholdResidentsMalesAge20();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 21;
        a_MinAge_MaxAge[1] = 21;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge21() + getHouseholdResidentsFemalesAge21();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge21() + getHouseholdResidentsMalesAge21();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 22;
        a_MinAge_MaxAge[1] = 22;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge22() + getHouseholdResidentsFemalesAge22();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge22() + getHouseholdResidentsMalesAge22();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 23;
        a_MinAge_MaxAge[1] = 23;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge23() + getHouseholdResidentsFemalesAge23();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge23() + getHouseholdResidentsMalesAge23();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 24;
        a_MinAge_MaxAge[1] = 24;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge24() + getHouseholdResidentsFemalesAge24();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge24() + getHouseholdResidentsMalesAge24();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 25;
        a_MinAge_MaxAge[1] = 29;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge25to29() + getHouseholdResidentsFemalesAge25to29();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge25to29() + getHouseholdResidentsMalesAge25to29();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 30;
        a_MinAge_MaxAge[1] = 34;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge30to34() + getHouseholdResidentsFemalesAge30to34();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge30to34() + getHouseholdResidentsMalesAge30to34();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 35;
        a_MinAge_MaxAge[1] = 39;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge35to39() + getHouseholdResidentsFemalesAge35to39();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge35to39() + getHouseholdResidentsMalesAge35to39();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 40;
        a_MinAge_MaxAge[1] = 44;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge40to44() + getHouseholdResidentsFemalesAge40to44();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge40to44() + getHouseholdResidentsMalesAge40to44();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 45;
        a_MinAge_MaxAge[1] = 49;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge45to49() + getHouseholdResidentsFemalesAge45to49();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge45to49() + getHouseholdResidentsMalesAge45to49();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 50;
        a_MinAge_MaxAge[1] = 54;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge50to54() + getHouseholdResidentsFemalesAge50to54();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge50to54() + getHouseholdResidentsMalesAge50to54();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 55;
        a_MinAge_MaxAge[1] = 59;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge55to59() + getHouseholdResidentsFemalesAge55to59();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge55to59() + getHouseholdResidentsMalesAge55to59();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 60;
        a_MinAge_MaxAge[1] = 64;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge60to64() + getHouseholdResidentsFemalesAge60to64();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge60to64() + getHouseholdResidentsMalesAge60to64();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 65;
        a_MinAge_MaxAge[1] = 69;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge65to69() + getHouseholdResidentsFemalesAge65to69();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge65to69() + getHouseholdResidentsMalesAge65to69();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 70;
        a_MinAge_MaxAge[1] = 74;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge70to74() + getHouseholdResidentsFemalesAge70to74();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge70to74() + getHouseholdResidentsMalesAge70to74();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 75;
        a_MinAge_MaxAge[1] = 79;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge75to79() + getHouseholdResidentsFemalesAge75to79();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge75to79() + getHouseholdResidentsMalesAge75to79();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 80;
        a_MinAge_MaxAge[1] = 84;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge80to84() + getHouseholdResidentsFemalesAge80to84();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge80to84() + getHouseholdResidentsMalesAge80to84();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 85;
        a_MinAge_MaxAge[1] = 89;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge85to89() + getHouseholdResidentsFemalesAge85to89();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge85to89() + getHouseholdResidentsMalesAge85to89();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        a_MinAge_MaxAge = new Integer[2];
        a_MinAge_MaxAge[0] = 90;
        a_MinAge_MaxAge[1] = 104;
        a_FemalePopulation_MalePopulation = new Integer[2];
        a_FemalePopulation_MalePopulation[0] = getCommunalEstablishmentResidentsFemalesAge90AndOver() + getHouseholdResidentsFemalesAge90AndOver();
        a_FemalePopulation_MalePopulation[1] = getCommunalEstablishmentResidentsMalesAge90AndOver() + getHouseholdResidentsMalesAge90AndOver();
        ageGenderPopulation.put(a_MinAge_MaxAge, a_FemalePopulation_MalePopulation);
        return ageGenderPopulation;
    }
}
