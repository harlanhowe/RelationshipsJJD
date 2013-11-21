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
     * Returns one string that is made up of all of this person's relationships
     * 
     * @return
     */
    @Override
    public String toString()
    {
        String theString = "";
        for(int i=0; i<relationships.size(); i++)
        {
            theString.concat(relationships.get(i).toString() + "\n");
        }
        return theString;
    }
}
