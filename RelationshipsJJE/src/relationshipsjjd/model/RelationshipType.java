package relationshipsjjd.model;

public class RelationshipType {
    
    private String relationshipName;
    private String maleType;
    private String femaleType;
    private String maleInverse;
    private String femaleInverse;
    private int inverseID;
    
    /**
     * Sets up a relationship type
     * 
     * @param relationshipName
     * @param maleType
     * @param femaleType
     * @param maleInverse
     * @param femaleInverse
     */
    public RelationshipType(String relationshipName, String maleType,
            String femaleType, String maleInverse, String femaleInverse,
            int inverseID)
    {
        this.relationshipName = relationshipName;
        this.maleType = maleType;
        this.femaleType = femaleType;
        this.maleInverse = maleInverse;
        this.femaleInverse = femaleInverse;
        this.inverseID = inverseID;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s: \n\tMales are called: %s \n\tFemales are called: %s \n\tMales related to are called: %s \n\tFemales related to are called: %s", relationshipName, maleType, femaleType, maleInverse, femaleInverse);
    }
    
    /**
     * This returns the string that should setup the save file
     * in the save method the first ID should be printed first
     * @return
     */
    public String getSaveDescription()
    {
        return relationshipName+"\t"+maleType+"\t"+femaleType+"\t"+maleInverse+"\t"+femaleInverse+"\t"+inverseID+"\n";
    }
    
    public int getInverseID()
    {
        return inverseID;
    }
    
    public String getRelationshipName()
    {
        return relationshipName;
    }
    
    public String getNameForPerson(boolean isMale)
    {
        if (isMale)
            return maleType;
        return femaleType;
    }
    
    public String getNameForInverse(boolean isMale)
    {
        if (isMale)
            return maleInverse;
        return femaleInverse;
    }
    
    public boolean equals(Object obj)
    {
        if(!(obj instanceof RelationshipType))
            return false;
        if(obj.toString().equals(this.toString()))
            return true;
        return true;
    }
    
    /**
     * Hashcodes, gotta hate em
     * @return
     */
    public int hashcode()
    {
        return this.inverseID;
    }
    
}
