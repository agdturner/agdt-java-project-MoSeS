package uk.ac.leeds.sog.moses.datamodel;

import java.io.Serializable;

public abstract class AbstractLocation 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.String id;

    /** The value of the simple wardLocation property. */
    private java.lang.String wardLocation;

    /** The value of the simple outputArea property. */
    private java.lang.String outputArea;

    /** The value of the simple areaLocation property. */
    private java.lang.String areaLocation;

    /**
     * Simple constructor of AbstractLocation instances.
     */
    public AbstractLocation()
    {
    }

    /**
     * Constructor of AbstractLocation instances given a simple primary key.
     * @param id
     */
    public AbstractLocation(java.lang.String id)
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
     * Implementation of the equals comparison on the basis of equality of the primary key values.
     * @param rhs
     * @return boolean
     */
    public boolean equals(Object rhs)
    {
        if (rhs == null)
            return false;
        if (! (rhs instanceof Location))
            return false;
        Location that = (Location) rhs;
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
