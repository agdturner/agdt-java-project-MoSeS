package uk.ac.leeds.sog.moses.datamodel;

import java.io.Serializable;

/**
 * A class that represents a row in the 'person' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Person
    extends AbstractPerson
    implements Serializable, Comparable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2624948943460016212L;

	/**
     * Simple constructor of Person instances.
     */
    public Person()
    {
    }

    /**
     * Constructor of Person instances given a simple primary key.
     * @param id
     */
    public Person(java.lang.String id)
    {
        super(id);
    }

    /* Add customized code below */
    /*public int compareTo(Object object) {
		Person another = (Person) object;
		if(getAge().intValue() < another.getAge().intValue()) {
			return -1;
		} else if(getAge().intValue() == another.getAge().intValue()) {
			return 0;
		} else {
			return 1;
		}
	}*/
    
    public int compareTo(Object object) {
		Person another = (Person) object;
		if(this.getHouseholdId().longValue() < another.getHouseholdId().longValue()) {
			return -1;
		} else if(this.getHouseholdId().longValue() == another.getHouseholdId().longValue()) {
			return 0;
		} else {
			return 1;
		}
	}
    
    public Object clone() {
    	Person clone = new Person();
    	clone.setPid(this.getPid());
    	clone.setAge(this.getAge());
    	clone.setBirthYear(this.getBirthYear());
    	clone.setGender(this.getGender());
    	clone.setMaritalStatus(this.getMaritalStatus());
    	clone.setSocialClass(this.getSocialClass());
    	clone.setCareerStatus(this.getCareerStatus());
    	clone.setHealthStatus(this.getHealthStatus());
    	clone.setWithLongTermIllness(this.getWithLongTermIllness());
    	clone.setInFormalCare(this.getInFormalCare());
    	clone.setDeathStatus(this.getDeathStatus());
    	clone.setHrpStatus(this.getHrpStatus());
    	clone.setHouseholdId(this.getHouseholdId());
    	clone.setHouseholdSize(this.getHouseholdSize());
    	clone.setHasChildDependent(this.getHasChildDependent());
    	clone.setNumberElderly(this.getNumberElderly());
    	clone.setLocation(this.getLocation());
    	clone.setWardLocation(this.getWardLocation());
    	clone.setOutputArea(this.getOutputArea());
    	clone.setFamilyRole(this.getFamilyRole());
    	clone.setFitness(this.getFitness());
    	clone.setSarrecordId(null);
    	clone.setDataId(null);
    	
    	return clone;
    }
    
    public void setComment(java.lang.String comments)
    {
        String oldComments = super.getComments();
        String newComments = null;
        
        if(oldComments == null || oldComments.length() == 0) {
        	newComments = comments;
        } else {
        	newComments = oldComments + ";" + comments;
        }
        
        String storedComments = newComments;
        if(newComments != null && newComments.length() >= 255) {
        	storedComments = newComments.substring(newComments.length() - 255);
        }
        
        if(storedComments == null) {
        	storedComments = "";
        }
        super.setComments(storedComments);
    }
    
    public String toString() {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("id=" + super.getId() + " ");
    	buffer.append("pid=" + super.getPid().longValue() + " ");
    	if(super.getHouseholdId() != null) {
    	    buffer.append("household_id=" + super.getHouseholdId().longValue() + " ");
    	}
    	if(super.getHouseholdSize() != null) {
    	    buffer.append("household_size=" + super.getHouseholdSize().intValue() + " ");
    	}
    	return buffer.toString();
    }
}
