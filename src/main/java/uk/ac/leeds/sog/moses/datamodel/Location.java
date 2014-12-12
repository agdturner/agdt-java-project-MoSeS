package uk.ac.leeds.sog.moses.datamodel;

import java.io.Serializable;

/**
 * A class that represents a row in the 'location' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Location
    extends AbstractLocation
    implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7598607168849002322L;

	/**
     * Simple constructor of Location instances.
     */
    public Location()
    {
    }

    /**
     * Constructor of Location instances given a simple primary key.
     * @param id
     */
    public Location(java.lang.String id)
    {
        super(id);
    }

    /* Add customized code below */
    public Object clone() {
    	Location location = new Location();
    	location.setAreaLocation(this.getAreaLocation());
    	location.setOutputArea(this.getOutputArea());
    	location.setWardLocation(this.getWardLocation());
    	location.setId(this.getId());
    	return location;
    }
    
    public boolean equals(Object obj)
    {
      if (obj instanceof Location)
      {
        Location thatLocation = (Location) obj;

        return this == thatLocation || 
          (this.getAreaLocation() != null && 
            this.getAreaLocation().equals(thatLocation.getAreaLocation()));
      }
      return false;
    }
    
    public String toString() {
    	return getAreaLocation();
    }
}
