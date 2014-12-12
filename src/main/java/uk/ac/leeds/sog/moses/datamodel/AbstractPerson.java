package uk.ac.leeds.sog.moses.datamodel;

import java.io.Serializable;

public abstract class AbstractPerson 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.String id;

    /** The value of the simple pid property. */
    private java.lang.Long pid;

    /** The value of the simple sarrecordId property. */
    private java.lang.Long sarrecordId;

    /** The value of the simple dataId property. */
    private java.lang.Long dataId;

    /** The value of the simple age property. */
    private java.lang.Integer age;

    /** The value of the simple birthYear property. */
    private java.lang.String birthYear;

    /** The value of the simple gender property. */
    private java.lang.String gender;

    /** The value of the simple socalClass property. */
    private java.lang.String socialClass;

    /** The value of the simple maritalStatus property. */
    private java.lang.String maritalStatus;

    /** The value of the simple careerStatus property. */
    private java.lang.String careerStatus;
    
    /** The value of the simple student property. */
    private java.lang.String student;

    /** The value of the simple healthStatus property. */
    private java.lang.Integer healthStatus;

    /** The value of the simple withLongTermIllness property. */
    private java.lang.String withLongTermIllness;

    /** The value of the simple inFormalCare property. */
    private java.lang.String inFormalCare;

    /** The value of the simple deathStatus property. */
    private java.lang.String deathStatus;

    /** The value of the simple hrpStatus property. */
    private java.lang.String hrpStatus;

    /** The value of the simple householdId property. */
    private java.lang.Long householdId;

    /** The value of the simple householdSize property. */
    private java.lang.Integer householdSize;

    /** The value of the simple hasChildDependent property. */
    private java.lang.String hasChildDependent;
    
    /** The value of the simple hasMigrated property. */
    private java.lang.String hasMigrated;
    
    /** The value of the simple hasMicroSimulated property. */
    private java.lang.String hasMicroSimulated;
    
    /** The value of the simple hasAgentSimulated property. */
    private java.lang.String hasAgentSimulated;

    /** The value of the simple numberElderly property. */
    private java.lang.Integer numberElderly;

    /** The value of the simple wardLocation property. */
    private java.lang.String wardLocation;

    /** The value of the simple outputArea property. */
    private java.lang.String outputArea;

    /** The value of the simple location property. */
    private java.lang.String location;

    /** The value of the simple fitness property. */
    private java.lang.String fitness;

    /** The value of the simple familyRole property. */
    private java.lang.String familyRole;

    /** The value of the simple comments property. */
    private java.lang.String comments;
    
    /** The student type: Undergraduate/MSc/PhD */
    private java.lang.String StudentType;
    
    /** year in university: undergraduate: 1/2/3; MSc: 1 PhD: 1/2/3 */
    private java.lang.String yearInUniversity;
    
    /** year of entering unversity */
    private java.lang.String yearEnteringUnversity;
    
    /** year of leaving university */
    private java.lang.String yearLeavingUnversity;
    
    /** first migration */
    private java.lang.String firstMigration;
    
    /** raw string */
    private String rawString;

    /**
     * Simple constructor of AbstractPerson instances.
     */
    public AbstractPerson()
    {
    }

    /**
     * Constructor of AbstractPerson instances given a simple primary key.
     * @param id
     */
    public AbstractPerson(java.lang.String id)
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
     * Return the value of the pid column.
     * @return java.lang.Long
     */
    public java.lang.Long getPid()
    {
        return this.pid;
    }

    /**
     * Set the value of the pid column.
     * @param pid
     */
    public void setPid(java.lang.Long pid)
    {
        this.pid = pid;
    }

    /**
     * Return the value of the sarrecord_id column.
     * @return java.lang.Long
     */
    public java.lang.Long getSarrecordId()
    {
        return this.sarrecordId;
    }

    /**
     * Set the value of the sarrecord_id column.
     * @param sarrecordId
     */
    public void setSarrecordId(java.lang.Long sarrecordId)
    {
        this.sarrecordId = sarrecordId;
    }

    /**
     * Return the value of the data_id column.
     * @return java.lang.Long
     */
    public java.lang.Long getDataId()
    {
        return this.dataId;
    }

    /**
     * Set the value of the data_id column.
     * @param dataId
     */
    public void setDataId(java.lang.Long dataId)
    {
        this.dataId = dataId;
    }

    /**
     * Return the value of the age column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getAge()
    {
        return this.age;
    }

    /**
     * Set the value of the age column.
     * @param age
     */
    public void setAge(java.lang.Integer age)
    {
        this.age = age;
    }

    /**
     * Return the value of the birth_year column.
     * @return java.lang.String
     */
    public java.lang.String getBirthYear()
    {
        return this.birthYear;
    }

    /**
     * Set the value of the birth_year column.
     * @param birthYear
     */
    public void setBirthYear(java.lang.String birthYear)
    {
        this.birthYear = birthYear;
    }

    /**
     * Return the value of the gender column.
     * @return java.lang.String
     */
    public java.lang.String getGender()
    {
        return this.gender;
    }

    /**
     * Set the value of the gender column.
     * @param gender
     */
    public void setGender(java.lang.String gender)
    {
        this.gender = gender;
    }

    /**
     * Return the value of the socal_class column.
     * @return java.lang.String
     */
    public java.lang.String getSocialClass()
    {
        return this.socialClass;
    }

    /**
     * Set the value of the socal_class column.
     * @param socalClass
     */
    public void setSocialClass(java.lang.String socialClass)
    {
        this.socialClass = socialClass;
    }

    /**
     * Return the value of the marital_status column.
     * @return java.lang.String
     */
    public java.lang.String getMaritalStatus()
    {
        return this.maritalStatus;
    }

    /**
     * Set the value of the marital_status column.
     * @param maritalStatus
     */
    public void setMaritalStatus(java.lang.String maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }

    /**
     * Return the value of the career_status column.
     * @return java.lang.String
     */
    public java.lang.String getCareerStatus()
    {
        return this.careerStatus;
    }

    /**
     * Set the value of the career_status column.
     * @param careerStatus
     */
    public void setCareerStatus(java.lang.String careerStatus)
    {
        this.careerStatus = careerStatus;
    }

    /**
     * Return the value of the health_status column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getHealthStatus()
    {
        return this.healthStatus;
    }

    /**
     * Set the value of the health_status column.
     * @param healthStatus
     */
    public void setHealthStatus(java.lang.Integer healthStatus)
    {
        this.healthStatus = healthStatus;
    }

    /**
     * Return the value of the with_long_term_illness column.
     * @return java.lang.String
     */
    public java.lang.String getWithLongTermIllness()
    {
        return this.withLongTermIllness;
    }

    /**
     * Set the value of the with_long_term_illness column.
     * @param withLongTermIllness
     */
    public void setWithLongTermIllness(java.lang.String withLongTermIllness)
    {
        this.withLongTermIllness = withLongTermIllness;
    }

    /**
     * Return the value of the in_formal_care column.
     * @return java.lang.String
     */
    public java.lang.String getInFormalCare()
    {
        return this.inFormalCare;
    }

    /**
     * Set the value of the in_formal_care column.
     * @param inFormalCare
     */
    public void setInFormalCare(java.lang.String inFormalCare)
    {
        this.inFormalCare = inFormalCare;
    }

    /**
     * Return the value of the death_status column.
     * @return java.lang.String
     */
    public java.lang.String getDeathStatus()
    {
        return this.deathStatus;
    }

    /**
     * Set the value of the death_status column.
     * @param deathStatus
     */
    public void setDeathStatus(java.lang.String deathStatus)
    {
        this.deathStatus = deathStatus;
    }

    /**
     * Return the value of the hrp_status column.
     * @return java.lang.String
     */
    public java.lang.String getHrpStatus()
    {
        return this.hrpStatus;
    }

    /**
     * Set the value of the hrp_status column.
     * @param hrpStatus
     */
    public void setHrpStatus(java.lang.String hrpStatus)
    {
        this.hrpStatus = hrpStatus;
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
     * Return the value of the household_size column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getHouseholdSize()
    {
        return this.householdSize;
    }

    /**
     * Set the value of the household_size column.
     * @param householdSize
     */
    public void setHouseholdSize(java.lang.Integer householdSize)
    {
        this.householdSize = householdSize;
    }

    /**
     * Return the value of the has_child_dependent column.
     * @return java.lang.String
     */
    public java.lang.String getHasChildDependent()
    {
        return this.hasChildDependent;
    }

    /**
     * Set the value of the has_child_dependent column.
     * @param hasChildDependent
     */
    public void setHasChildDependent(java.lang.String hasChildDependent)
    {
        this.hasChildDependent = hasChildDependent;
    }
    
    /**
     * Return the value of the has_child_dependent column.
     * @return java.lang.String
     */
    public java.lang.String getHasMigrated()
    {
        return this.hasMigrated;
    }

    /**
     * Set the value of the has_child_dependent column.
     * @param hasChildDependent
     */
    public void setHasMigrated(java.lang.String hasMigrated)
    {
        this.hasMigrated = hasMigrated;
    }

    /**
     * Return the value of the number_elderly column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getNumberElderly()
    {
        return this.numberElderly;
    }

    /**
     * Set the value of the number_elderly column.
     * @param numberElderly
     */
    public void setNumberElderly(java.lang.Integer numberElderly)
    {
        this.numberElderly = numberElderly;
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
     * Return the value of the location column.
     * @return java.lang.String
     */
    public java.lang.String getLocation()
    {
        return this.location;
    }

    /**
     * Set the value of the location column.
     * @param location
     */
    public void setLocation(java.lang.String location)
    {
        this.location = location;
    }

    /**
     * Return the value of the fitness column.
     * @return java.lang.String
     */
    public java.lang.String getFitness()
    {
        return this.fitness;
    }

    /**
     * Set the value of the fitness column.
     * @param fitness
     */
    public void setFitness(java.lang.String fitness)
    {
        this.fitness = fitness;
    }

    /**
     * Return the value of the family_role column.
     * @return java.lang.String
     */
    public java.lang.String getFamilyRole()
    {
        return this.familyRole;
    }

    /**
     * Set the value of the family_role column.
     * @param familyRole
     */
    public void setFamilyRole(java.lang.String familyRole)
    {
        this.familyRole = familyRole;
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
        if (! (rhs instanceof Person))
            return false;
        Person that = (Person) rhs;
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

	public java.lang.String getHasMicroSimulated() {
		return hasMicroSimulated;
	}

	public void setHasMicroSimulated(java.lang.String hasMicroSimulated) {
		this.hasMicroSimulated = hasMicroSimulated;
	}

	public String getRawString() {
		return rawString;
	}

	public void setRawString(String rawString) {
		this.rawString = rawString;
	}

	public java.lang.String getHasAgentSimulated() {
		return hasAgentSimulated;
	}

	public void setHasAgentSimulated(java.lang.String hasAgentSimulated) {
		this.hasAgentSimulated = hasAgentSimulated;
	}

	public java.lang.String getStudent() {
		return student;
	}

	public void setStudent(java.lang.String student) {
		this.student = student;
	}

	public java.lang.String getStudentType() {
		return StudentType;
	}

	public void setStudentType(java.lang.String studentType) {
		StudentType = studentType;
	}

	public java.lang.String getYearInUniversity() {
		return yearInUniversity;
	}

	public void setYearInUniversity(java.lang.String yearInUniversity) {
		this.yearInUniversity = yearInUniversity;
	}

	public java.lang.String getYearEnteringUnversity() {
		return yearEnteringUnversity;
	}

	public void setYearEnteringUnversity(java.lang.String yearEnteringUnversity) {
		this.yearEnteringUnversity = yearEnteringUnversity;
	}

	public java.lang.String getYearLeavingUnversity() {
		return yearLeavingUnversity;
	}

	public void setYearLeavingUnversity(java.lang.String yearLeavingUnversity) {
		this.yearLeavingUnversity = yearLeavingUnversity;
	}

	public java.lang.String getFirstMigration() {
		return firstMigration;
	}

	public void setFirstMigration(java.lang.String firstMigration) {
		this.firstMigration = firstMigration;
	}
}
