package uk.ac.leeds.sog.moses.datamodel;

import java.io.Serializable;

public abstract class AbstractSimulationcontrol 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.String id;

    /** The value of the simple sardataInputComplete property. */
    private java.lang.String sardataInputComplete;

    /** The value of the simple simulationStarted property. */
    private java.lang.String simulationStarted;

    /** The value of the simple simulationStopped property. */
    private java.lang.String simulationStopped;

    /** The value of the simple simulationPaused property. */
    private java.lang.String simulationPaused;

    /** The value of the simple simulationYear property. */
    private java.lang.String simulationYear;
    
    /** The value of the simple next property. */
    private java.lang.Long nextPID;
    
    /** The value of the simple next property. */
    private java.lang.Long nextHouseholdID;
    
    /** The value of the simple next property. */
    private int totalNumberOfPeople;

    /**
     * Simple constructor of AbstractSimulationcontrol instances.
     */
    public AbstractSimulationcontrol()
    {
    }

    /**
     * Constructor of AbstractSimulationcontrol instances given a simple primary key.
     * @param id
     */
    public AbstractSimulationcontrol(java.lang.String id)
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
     * Return the value of the sardata_input_complete column.
     * @return java.lang.String
     */
    public java.lang.String getSardataInputComplete()
    {
        return this.sardataInputComplete;
    }

    /**
     * Set the value of the sardata_input_complete column.
     * @param sardataInputComplete
     */
    public void setSardataInputComplete(java.lang.String sardataInputComplete)
    {
        this.sardataInputComplete = sardataInputComplete;
    }

    /**
     * Return the value of the simulation_started column.
     * @return java.lang.String
     */
    public java.lang.String getSimulationStarted()
    {
        return this.simulationStarted;
    }

    /**
     * Set the value of the simulation_started column.
     * @param simulationStarted
     */
    public void setSimulationStarted(java.lang.String simulationStarted)
    {
        this.simulationStarted = simulationStarted;
    }

    /**
     * Return the value of the simulation_stopped column.
     * @return java.lang.String
     */
    public java.lang.String getSimulationStopped()
    {
        return this.simulationStopped;
    }

    /**
     * Set the value of the simulation_stopped column.
     * @param simulationStopped
     */
    public void setSimulationStopped(java.lang.String simulationStopped)
    {
        this.simulationStopped = simulationStopped;
    }

    /**
     * Return the value of the simulation_paused column.
     * @return java.lang.String
     */
    public java.lang.String getSimulationPaused()
    {
        return this.simulationPaused;
    }

    /**
     * Set the value of the simulation_paused column.
     * @param simulationPaused
     */
    public void setSimulationPaused(java.lang.String simulationPaused)
    {
        this.simulationPaused = simulationPaused;
    }

    /**
     * Return the value of the simulation_year column.
     * @return java.lang.String
     */
    public java.lang.String getSimulationYear()
    {
        return this.simulationYear;
    }

    /**
     * Set the value of the simulation_year column.
     * @param simulationYear
     */
    public void setSimulationYear(java.lang.String simulationYear)
    {
        this.simulationYear = simulationYear;
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
        if (! (rhs instanceof Simulationcontrol))
            return false;
        Simulationcontrol that = (Simulationcontrol) rhs;
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

	public java.lang.Long getNextPID() {
		Long next = nextPID;
		nextPID = new Long(nextPID.longValue() + 1L);
		return next;
	}

	public void setNextPID(java.lang.Long nextPID) {
		this.nextPID = nextPID;
	}

	public java.lang.Long getNextHouseholdID() {
		Long next = nextHouseholdID;
		nextHouseholdID = new Long(nextHouseholdID.longValue() + 1L);
		return next;
	}

	public void setNextHouseholdID(java.lang.Long nextHouseholdID) {
		this.nextHouseholdID = nextHouseholdID;
	}

	public int getTotalNumberOfPeople() {
		return totalNumberOfPeople;
	}

	public void setTotalNumberOfPeople(int totalNumberOfPeople) {
		this.totalNumberOfPeople = totalNumberOfPeople;
	}
}
