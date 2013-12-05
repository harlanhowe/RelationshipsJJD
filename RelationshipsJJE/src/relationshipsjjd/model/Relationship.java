package relationshipsjjd.model;

import relationshipsjjd.controller.Controller;
import relationshipsjjd.view.GUI.RelationshipFrame;

public class Relationship {
    
    private int IDPerson1;
    private int IDPerson2;
    private int IDRelationType;
    private Controller myControl;
    
    /**
     * 
     * @param IDPerson1
     * @param IDPerson2
     * @param IDRelationType
     */
    public Relationship(int IDPerson1, int IDPerson2, int IDRelationType, Controller myControl)
    {
        this.setIDPerson1(IDPerson1);
        this.IDPerson2 = IDPerson2;
        this.IDRelationType = IDRelationType;
        this.myControl = myControl;
    }
    
    /**
     * Creates the string that will display relationships 
     * ie. --> John has aTeacher named Harlan
     */
    @Override
    public String toString()
    {
        return String.format("%s has a %s named %s", myControl.getPersonUnderID(IDPerson1).getName(),
                myControl.getRelationshipTypeUnderID(IDRelationType).getNameForInverse(myControl.getPersonUnderID(IDPerson2).isMale), myControl.getPersonUnderID(IDPerson2).getName());
    }
    
    /**
     * Short hand version of toString, use this in a situation like below
     * John Churay
     *      has a Teacher named Harlan Howe
     * @return
     */
    public String shorthandToString()
    {
        return String.format("\thas a %s named %s", myControl.getRelationshipTypeUnderID(IDRelationType).getNameForPerson(myControl.getPersonUnderID(IDPerson2).isMale), 
                myControl.getPersonUnderID(IDPerson2).getName());
    }
    
    /**
     * This returns the string that should setup the save file
     * in the save method the first ID should be printed first
     * @return
     */
    public String getSaveDescription()
    {
        return IDPerson1 + "\t"+IDPerson2+"\t"+IDRelationType+"\n";
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
    
    public int hashCode()
    {
        return this.toString().hashCode();
    }
    
    @Override
    public boolean equals(Object obj)
    {
        return obj.toString().equals(this.toString());
    }
    
}
