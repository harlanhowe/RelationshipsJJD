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
    
    public String getSaveDescription()
    {
        return relationshipName+"\t"+maleType+"\t"+femaleType+"\t"+maleInverse+"\t"+femaleInverse+"\t"+inverseID;
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
    
}
