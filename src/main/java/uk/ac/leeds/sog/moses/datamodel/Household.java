package uk.ac.leeds.sog.moses.datamodel;

import java.io.Serializable;

import uk.ac.leeds.sog.moses.datamodel.AbstractHousehold;

/**
 * A class that represents a row in the 'household' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Household
    extends AbstractHousehold
    implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1026050075835695447L;

	/**
     * Simple constructor of Household instances.
     */
    public Household()
    {
    }

    /**
     * Constructor of Household instances given a simple primary key.
     * @param id
     */
    public Household(java.lang.String id)
    {
        super(id);
    }

    /* Add customized code below */
    public int compareTo(Object object) {
    	Household another = (Household) object;
		if(this.getHouseholdId().longValue() < another.getHouseholdId().longValue()) {
			return -1;
		} else if(this.getHouseholdId().longValue() == another.getHouseholdId().longValue()) {
			return 0;
		} else {
			return 1;
		}
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
}
