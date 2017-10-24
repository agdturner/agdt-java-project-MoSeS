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
package uk.ac.leeds.ccg.andyt.projects.moses.extensions;

import java.math.BigInteger;
import java.util.Random;
import uk.ac.leeds.ccg.andyt.census.sar.Census_ISARDataRecord;
import uk.ac.leeds.sog.moses.agent.AdultDependent;
import uk.ac.leeds.sog.moses.agent.AreaModel;
import uk.ac.leeds.sog.moses.agent.Child;
import uk.ac.leeds.sog.moses.agent.ElderlyDependent;
import uk.ac.leeds.sog.moses.agent.HRP;
import uk.ac.leeds.sog.moses.agent.Person;
import uk.ac.leeds.sog.moses.agent.Spouse;

/**
 * An extension of <code>uk.ac.leeds.sog.moses.agent.AreaModel</code> for
 * performing Household assignment for <code>IndividualSARDataRecords</code>.
 * @version 1.0.0, 2006-08-10
 */
public class AreaModelExtension extends AreaModel {

	/**
	 * For storing the total number of children
	 */
	private int tNumberOfChildren;

	/**
	 * For storing the total number of spouses
	 */
	private int tNumberOfSpouses;

	/**
	 * For storing the total number of elderly dependents
	 */
	private int tNumberOfElderlyDependents;

	/**
	 * For storing the total number of adult dependents
	 */
	private int tNumberOfAdultDependents;

	/**
	 * A reference for getting tRandom numbers
	 */
	private Random tRandom;

	/**
	 * For stores the Census Area Statistic Zone Code
	 */
	String zoneCode;

	/** Creates a new instance of AreaModelExtension
     * @param tRandom
     * @param zoneCode */
	public AreaModelExtension(Random tRandom, String zoneCode) {
		super(zoneCode);
		// i_peopleData = new ArrayList();
		// i_persons = new ArrayList();
		// i_hrp = new ArrayList();
		// i_childDependent = new ArrayList();
		// i_elderlyDependent = new ArrayList();
		// i_spouse = new ArrayList();
		// i_adultDependent = new ArrayList();
		// i_unknownTypePerson = new ArrayList();
		// i_assignedHRP = new ArrayList();
		// i_unassignedHRP = new ArrayList();
		// i_totalNumPersons = 0;
		// i_households = new ArrayList();
		// i_vacantHouseholds = new ArrayList();
		this.tRandom = tRandom;
		this.zoneCode = zoneCode;
	}

	/**
     * @param tISARDataRecords
	 * @return BigInteger which is a measure of how well households have been
	 *         formed.
	 */
	public BigInteger getFitness(Census_ISARDataRecord[] tISARDataRecords) {
		BigInteger result = new BigInteger("0");
		createAgents(tISARDataRecords);
		buildHouseholds();
		// Number of unassigned hrps
		result = result.add(BigInteger.valueOf(this.i_unassignedHRP.size() * 10));
		// Number of unassigned child dependents
		// result = result.add( BigInteger.valueOf( this.tNumberOfChildren -
		// this.i_childDependent.size() ) );
		result = result.add(BigInteger.valueOf(this.i_childDependent.size()));
		// Number of unassigned spouses
		// result = result.add( BigInteger.valueOf( this.tNumberOfSpouses -
		// this.i_spouse.size() ) );
		result = result.add(BigInteger.valueOf(this.i_spouse.size()));
		// Number of unassigned spouses
		// result = result.add( BigInteger.valueOf(
		// this.tNumberOfElderlyDependents - this.i_elderlyDependent.size() ) );
		result = result.add(BigInteger.valueOf(this.i_elderlyDependent.size()));
		// Number of unassigned spouses
		// result = result.add( BigInteger.valueOf(
		// this.tNumberOfAdultDependents - this.i_adultDependent.size() ) );
		result = result.add(BigInteger.valueOf(this.i_adultDependent.size()));
		// Number of unclassified persons
		result = result.add(BigInteger.valueOf(this.i_unknownTypePerson.size()));
		return result;
	}

	/**
	 * This method creates different agents by consideration of their attributes
     * @param tISARDataRecords
	 */
	public void createAgents(Census_ISARDataRecord[] tISARDataRecords) {
		this.tNumberOfChildren = 0;
		this.tNumberOfSpouses = 0;
		this.tNumberOfElderlyDependents = 0;
		this.tNumberOfAdultDependents = 0;
		Person[] persons = new Person[tISARDataRecords.length];
		int[] personIDHouseholdID = new int[2];
		personIDHouseholdID[0] = 0;
		personIDHouseholdID[1] = 0;
		for (int i = 0; i < tISARDataRecords.length; i++) {
			if (tISARDataRecords[i].get_RELTOHR() == 1) {
				// create a HRP
				persons[i] = new HRP((int) tISARDataRecords[i].get_ID());
			} else if (tISARDataRecords[i].get_AGE0() < 16) {
				// create a child
				persons[i] = new Child((int) tISARDataRecords[i].get_ID());
				this.tNumberOfChildren++;
			} else if ((tISARDataRecords[i].get_MARSTAT() == 2)
					|| (tISARDataRecords[i].get_MARSTAT() == 3)) {
				// create a spouse
				persons[i] = new Spouse((int) tISARDataRecords[i].get_ID());
				this.tNumberOfSpouses++;
			} else if (tISARDataRecords[i].get_AGE0() >= 65) {
				// create an elderly dependent
				persons[i] = new ElderlyDependent((int) tISARDataRecords[i]
						.get_ID());
				this.tNumberOfElderlyDependents++;
			} else {
				// create an adult dependent
				persons[i] = new AdultDependent((int) tISARDataRecords[i]
						.get_ID());
				this.tNumberOfAdultDependents++;
			}
			// add person into list according to their types
			if (persons[i] instanceof HRP) {
				i_hrp.add(persons[i]);
			} else if (persons[i] instanceof Child) {
				i_childDependent.add(persons[i]);
			} else if (persons[i] instanceof ElderlyDependent) {
				i_elderlyDependent.add(persons[i]);
			} else if (persons[i] instanceof Spouse) {
				i_spouse.add(persons[i]);
			} else if (persons[i] instanceof AdultDependent) {
				i_adultDependent.add(persons[i]);
			} else {
				i_unknownTypePerson.add(persons[i]);
			}
			// set other person characteristics
			setCharacteristics(persons[i], tISARDataRecords[i],
					personIDHouseholdID);
			// put all people in the toal population list
			i_persons.add(persons[i]);
			// add to the number of total population
			i_totalNumPersons++;
		}
		// sort by age
		sortByAge();
	}

	/**
	 * Sets characterisitcs of person from IndividualSARRecord[] TODO: Coding
	 * for social class, location and fitness.
	 */
	private void setCharacteristics(Person person,
			Census_ISARDataRecord tISARDataRecord, int[] personIDHouseholdID) {
		int ageInt;
		long tISARDataRecordID;
		long ID;
		short HRSOCGRD;
		boolean SEX;
		int SEXint;
		short MARSTAT;
		int MARSTATReclassed;
		short LLTI;
		short HEALTH;
		short RELTOHR;
		short PROVCARE;
		short CETYPE;
		short FNDEPCH;
		short HNRESDNT;
		short HNELDERS;
		personIDHouseholdID[0]++;
		person.setIndSARRecID((int) tISARDataRecord.get_RecordID());
		person.setId((int) tISARDataRecord.get_ID());
		person.setAge(tISARDataRecord.get_AGE0());
		HRSOCGRD = tISARDataRecord.get_HRSOCGRD();
		if (HRSOCGRD == -9) {
			// HRSOCGRD = new Integer( tRandom.nextInt( 4 ) + 1 ).shortValue();
			HRSOCGRD = (short) (tRandom.nextInt(4) + 1);
		}
		person.setSocialClass("" + HRSOCGRD);
		SEX = tISARDataRecord.get_SEX();
		if (SEX) {
			person.setGender(1);
		} else {
			person.setGender(2);
		}
		MARSTAT = tISARDataRecord.get_MARSTAT();
		if ((MARSTAT == 2) || (MARSTAT == 3)) {
			person.setMaritalStatus(1);
		} else {
			person.setMaritalStatus(0);
		}
		LLTI = tISARDataRecord.get_LLTI();
		LLTI--;
		if (LLTI == -10) {
			LLTI = (short) (tRandom.nextInt(2));
		}
		person.setIntIllness(LLTI);
		HEALTH = tISARDataRecord.get_HEALTH();
		if (HEALTH == -9) {
			HEALTH = (short) (tRandom.nextInt(2) + 1);
		}
		person.setHealth(HEALTH);
		person.setLocation(zoneCode);
		// StringBuffer buff = new StringBuffer( zoneCode );
		// StringBuffer temp1 = new StringBuffer();
		// for(int j=0; j<=7; j++) {
		// temp1.append(buff.charAt(j));
		// }
		// StringBuffer temp2 = new StringBuffer();
		// temp2.append(buff.charAt(8));
		// temp2.append(buff.charAt(9));
		// String wardLocation = temp1.toString();
		// String oLocation = temp2.toString();
		// person.setWLocation( wardLocation );
		// person.setOLocation( oLocation );
		person.setWLocation(zoneCode.substring(0, 7));
		person.setOLocation(zoneCode.substring(8, 9));
		RELTOHR = tISARDataRecord.get_RELTOHR();
		if (RELTOHR != 1) {
			RELTOHR = 0;
		}
		person.setHrpStatus(RELTOHR);
		if (RELTOHR == 1) {
			personIDHouseholdID[1]++;
			person.setHouseID(personIDHouseholdID[1]);
		} else {
			person.setHouseID(-1);
		}
		PROVCARE = tISARDataRecord.get_PROVCARE();
		if (PROVCARE == -9) {
			PROVCARE = 0;
		}
		if (PROVCARE == 1) {
			PROVCARE = 0;
		} else {
			PROVCARE = 1;
		}
		person.setCarer(PROVCARE);
		CETYPE = tISARDataRecord.get_CETYPE();
		if (CETYPE > 0) {
			CETYPE = 1;
		} else {
			CETYPE = 0;
		}
		person.setFormalCare(CETYPE);
		FNDEPCH = tISARDataRecord.get_FNDEPCH();
		if (FNDEPCH == 1) {
			FNDEPCH = 1;
		} else {
			FNDEPCH = 0;
		}
		person.setChildDependentFlag(FNDEPCH);
		HNRESDNT = tISARDataRecord.get_HNRESDNT();
		if (HNRESDNT == -9 || HNRESDNT == 0) {
			HNRESDNT = 1;
		}
		person.setHouseholdSize(HNRESDNT);
		HNELDERS = tISARDataRecord.get_HNELDERS();
		if (HNELDERS == -9) {
			HNELDERS = 0;
		}
		person.setNumElderly(HNELDERS);
		// toyModelRecord = toyModelRecord + fitness;
	}

}