/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package relationshipsjjd.model;

import java.util.ArrayList;

/**
 * 
 * @author joshua.kassab
 */
public class Person {
    
    private String firstName;
    private String lastName;
    private ArrayList<Relationship> relationships;
    private int ID;
    boolean isMale;
    
    /***
     * Constructor. Is given a person's name and ID
     * 
     * @param personName
     * @param personID
     */
    public Person(String personFirstName, String personLastName, int personID, boolean isMale)
    {
        firstName= personFirstName;
        lastName=personLastName;
        ID = personID;
        this.isMale = isMale;
        relationships = new ArrayList<Relationship>();
    }
    
    /***
     * Returns a list of relationships pertaining to this person
     * 
     * @return
     */
    public ArrayList<Relationship> getRelations()
    {
        return relationships;
    }
    
    /***
     * Returns this person's ID
     * 
     * @return
     */
    public int getID()
    {
        return ID;
    }
    
    /***
     * Adds a relationship to the list of relations
     * 
     * @param relation
     */
    public void addRelationship(Relationship relation)
    {
        relationships.add(relation);
    }
    
    /***
     * Returns one string that is made up of all of this person's relationships in the form of:
     * Josh Kassab:
     *      has a Teacher named Harlan Howe
     * @return
     */
    @Override
    public String toString()
    {
        String theString = this.getName() + ":\n";
        for(Relationship rel : relationships)
        {
            theString += rel.shorthandToString() + "\n";
        }
        return theString;
    }

    /***
     * Returns the person's name
     * @return 
     */
    public String getName()
    {
        return firstName + " "+lastName;
    }
    
    /**
     * Removes this relationship from the ArrayList<Relationship> relationships
     * @param relationship
     */
    public void removeRelationship(Relationship relationship)
    {
        
    }
    /**
     * So, this should return a string saying lastName, firstName, isMale
     * @return
     */
    public String getSaveDescription()
    {
        String theString = new String();
        theString += lastName + ", " + firstName + ", " + isMale;
        return theString;
    }
}
