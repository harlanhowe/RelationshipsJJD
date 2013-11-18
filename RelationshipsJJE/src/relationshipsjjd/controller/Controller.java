package relationshipsjjd.controller;

import java.util.ArrayList;
import relationshipsjjd.model.Person;
import relationshipsjjd.model.RelationshipType;


public class Controller 
{
    private static ArrayList<Person> people;
    private static ArrayList<RelationshipType> typeList;
    
    /***
     * Reads through the files to get stored data
     * Looks for people,
     * Then relationship types,
     * Then relationships
     */
    public static void init()
    {
        
    }
    
    /***
     * Creates a new Person, "name"
     * Adds person to people
     * @param name 
     */
    public static void addPerson(String name)
    {
        
    }
    
    /***
     * Creates a new relationship
     * @param firstID
     * @param secondID
     * @param relType 
     */
    public static void addRelationship(int firstID, int secondID, int relType)
    {
        
    }
    
    /***
     * Creates a new RelationshipType, "typeName"
     * @param typeName
     * @param inverseType
     * @param maleType
     * @param femaleType
     * @param maleInverse
     * @param femaleInverse 
     */
    public static void addRelationshipType(String typeName, String inverseType, String maleType,
            String femaleType, String maleInverse, String femaleInverse)
    {
        
    }
    
    /***
     * Removes a relationship
     * @param personID
     * @param secondPersonID
     * @param typeID 
     */
    public static void removeRelationship(int personID, int secondPersonID, int typeID)
    {
        
    }
    
    /***
     * Removes a RelationshipType
     * @param typeID 
     */
    public static void removeRelationsihpType(int typeID)
    {
        
    }
}
