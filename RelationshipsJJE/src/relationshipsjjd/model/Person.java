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
    
    private String name;
    private ArrayList<Relationship> relationships;
    private int ID;
    boolean isMale;
    
    /***
     * Constructor. Is given a person's name and ID
     * 
     * @param personName
     * @param personID
     */
    public Person(String personName, int personID)
    {
        name = personName;
        ID = personID;
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
        return "";
    }
}
