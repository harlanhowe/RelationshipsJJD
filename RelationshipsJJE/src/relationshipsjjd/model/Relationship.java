package relationshipsjjd.model;

public class Relationship {
    
    private int IDPerson1;
    private int IDPerson2;
    private int IDRelationType;
    
    /**
     * 
     * @param IDPerson1
     * @param IDPerson2
     * @param IDRelationType
     */
    public Relationship(int IDPerson1, int IDPerson2, int IDRelationType)
    {
        this.setIDPerson1(IDPerson1);
        this.IDPerson2 = IDPerson2;
        this.IDRelationType = IDRelationType;
    }
    
    /**
     * Creates the string that will display relationships ie. --> John has a
     * Teacher named Harlan
     */
    @Override
    public String toString()
    {
        return String.format("%s has a %s named %s", this.IDPerson1,
                this.IDRelationType, this.IDPerson2);
    }
    
    public int getIDPerson1()
    {
        return IDPerson1;
    }
    
    public void setIDPerson1(int iDPerson1)
    {
        IDPerson1 = iDPerson1;
    }
    
    public int getIDPerson2()
    {
        return IDPerson2;
    }
    
    public void setIDPerson2(int iDPerson2)
    {
        IDPerson2 = iDPerson2;
    }
    
    public int getIDRelationType()
    {
        return IDRelationType;
    }
    
    public void setIDRelationType(int iDRelationType)
    {
        IDRelationType = iDRelationType;
    }
    
}
