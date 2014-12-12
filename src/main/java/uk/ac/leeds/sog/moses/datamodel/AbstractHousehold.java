package uk.ac.leeds.sog.moses.datamodel;

import java.io.Serializable;


/**
 * A class that represents a row in the household table. 
 */
public abstract class AbstractHousehold 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.String id;

    /** The value of the simple householdId property. */
    private java.lang.Long householdId;

    /** The value of the simple householdHrpPid property. */
    private java.lang.Long householdHrpPid;

    /** The value of the simple year property. */
    // private java.lang.Integer year;

    /** The value of the simple status property. */
    private java.lang.Integer status;

    /** The value of the simple size property. */
    private java.lang.Integer size;

    /** The value of the simple wardLocation property. */
    private java.lang.String wardLocation;

    /** The value of the simple outputArea property. */
    private java.lang.String outputArea;

    /** The value of the simple areaLocation property. */
    private java.lang.String areaLocation;

    /** The value of the simple comments property. */
    private java.lang.String comments;

    /**
     * Simple constructor of AbstractHousehold instances.
     */
    public AbstractHousehold()
    {
    }

    /**
     * Constructor of AbstractHousehold instances given a simple primary key.
     * @param id
     */
    public AbstractHousehold(java.lang.String id)
    {
        this.setId(id);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.String
     */
    public java.lang.String getId()
    {
        return id;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param id
     */
    public void setId(java.lang.String id)
    {
        this.hashValue = 0;
        this.id = id;
    }

    /**
     * Return the value of the household_id column.
     * @return java.lang.Long
     */
    public java.lang.Long getHouseholdId()
    {
        return this.householdId;
    }

    /**
     * Set the value of the household_id column.
     * @param householdId
     */
    public void setHouseholdId(java.lang.Long householdId)
    {
        this.householdId = householdId;
    }

    /**
     * Return the value of the household_hrp_pid column.
     * @return java.lang.Long
     */
    public java.lang.Long getHouseholdHrpPid()
    {
        return this.householdHrpPid;
    }

    /**
     * Set the value of the household_hrp_pid column.
     * @param householdHrpPid
     */
    public void setHouseholdHrpPid(java.lang.Long householdHrpPid)
    {
        this.householdHrpPid = householdHrpPid;
    }

    /**
     * Return the value of the year column.
     * @return java.lang.Integer
     */
   /* public java.lang.Integer getYear()
    {
        return this.year;
    }*/

    /**
     * Set the value of the year column.
     * @param year
     */
    /*public void setYear(java.lang.Integer year)
    {
        this.year = year;
    }*/

    /**
     * Return the value of the status column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getStatus()
    {
        return this.status;
    }

    /**
     * Set the value of the status column.
     * @param status
     */
    public void setStatus(java.lang.Integer status)
    {
        this.status = status;
    }

    /**
     * Return the value of the size column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getSize()
    {
        return this.size;
    }

    /**
     * Set the value of the size column.
     * @param size
     */
    public void setSize(java.lang.Integer size)
    {
        this.size = size;
    }

    /**
     * Return the value of the ward_location column.
     * @return java.lang.String
     */
    public java.lang.String getWardLocation()
    {
        return this.wardLocation;
    }

    /**
     * Set the value of the ward_location column.
     * @param wardLocation
     */
    public void setWardLocation(java.lang.String wardLocation)
    {
        this.wardLocation = wardLocation;
    }

    /**
     * Return the value of the output_area column.
     * @return java.lang.String
     */
    public java.lang.String getOutputArea()
    {
        return this.outputArea;
    }

    /**
     * Set the value of the output_area column.
     * @param outputArea
     */
    public void setOutputArea(java.lang.String outputArea)
    {
        this.outputArea = outputArea;
    }

    /**
     * Return the value of the area_location column.
     * @return java.lang.String
     */
    public java.lang.String getAreaLocation()
    {
        return this.areaLocation;
    }

    /**
     * Set the value of the area_location column.
     * @param areaLocation
     */
    public void setAreaLocation(java.lang.String areaLocation)
    {
        this.areaLocation = areaLocation;
    }

    /**
     * Return the value of the comments column.
     * @return java.lang.String
     */
    public java.lang.String getComments()
    {
        return this.comments;
    }

    /**
     * Set the value of the comments column.
     * @param comments
     */
    public void setComments(java.lang.String comments)
    {
        this.comments = comments;
    }

    /**
     * Implementation of the equals comparison on the basis of equality of the primary key values.
     * @param rhs
     * @return boolean
     */
    public boolean equals(Object rhs)
    {
        if (rhs == null)
            return false;
        if (! (rhs instanceof Household))
            return false;
        Household that = (Household) rhs;
        if (this.getId() == null || that.getId() == null)
            return false;
        return (this.getId().equals(that.getId()));
    }

    /**
     * Implementation of the hashCode method conforming to the Bloch pattern with
     * the exception of array properties (these are very unlikely primary key types).
     * @return int
     */
    public int hashCode()
    {
        if (this.hashValue == 0)
        {
            int result = 17;
            int idValue = this.getId() == null ? 0 : this.getId().hashCode();
            result = result * 37 + idValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}
