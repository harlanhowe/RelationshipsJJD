package relationshipsjjd.controller;

import java.util.ArrayList;

import relationshipsjjd.model.Person;
import relationshipsjjd.model.Relationship;
import relationshipsjjd.model.RelationshipType;

public class Controller {
    
    private static ArrayList<Person> people;
    private static ArrayList<RelationshipType> typeList;
    
    /***
     * Reads through the files to get stored data Looks for people, Then
     * relationship types, Then relationships
     */
    public static void init()
    {
        
    }
    
    /***
     * Creates a new Person, "name" Adds person to people
     * 
     * @param name
     */
    public static void addPerson(String name)
    {
        
    }
    
    /***
     * Creates a new relationship
     * 
     * @param firstID
     * @param secondID
     * @param relType
     */
    public static void addRelationship(int firstID, int secondID, int relType)
    {
        if (relType < typeList.size())
        {
            if (firstID < people.size() && secondID < people.size())
            {
                people.get(firstID).addRelationship(new Relationship(firstID, secondID, relType));
                people.get(secondID).addRelationship(new Relationship(secondID, firstID, 
                        typeList.get(relType).getInverseID()));
            }
        }
    }
    
    /***
     * Creates a new RelationshipType, "typeName"
     * 
     * @param typeName
     * @param inverseType
     * @param maleType
     * @param femaleType
     * @param maleInverse
     * @param femaleInverse
     */
    public static void addRelationshipType(String typeName, String inverseType,
            String maleType, String femaleType, String maleInverse,
            String femaleInverse)
    {
        RelationshipType relTypeNorm = new RelationshipType(typeName, maleType, femaleType, maleInverse, 
                femaleInverse, typeList.size() + 1);
        RelationshipType relTypeInvert = new RelationshipType(inverseType, maleInverse, femaleInverse, 
                maleType, femaleType, typeList.size());
        typeList.add(relTypeNorm);
        typeList.add(relTypeInvert);
    }
    
    /***
     * Removes a relationship
     * 
     * @param personID
     * @param secondPersonID
     * @param typeID
     */
    public static void removeRelationship(int personID, int secondPersonID,
            int typeID)
    {
        
    }
    
    /***
     * Removes a RelationshipType
     * 
     * @param typeID
     */
    public static void removeRelationsihpType(int typeID)
    {
        
    }
    
    /***
     * Changes some parameter of a certain relationship type.
     * 
     * @param typeID
     * @param newTypeName
     * @param inverseType
     * @param maleType
     * @param femaleType
     * @param maleInverse
     * @param femaleInverse
     */
    public static void editRelationshipType(int typeID, String newTypeName,
            String inverseType, String maleType, String femaleType,
            String maleInverse, String femaleInverse)
    {
        
    }
    
    /***
     * Goes to the indicated people and changes the RelationshipType
     * 
     * @param personID
     * @param secondPersonID
     * @param relIDCurr
     * @param relIDToChange
     */
    public static void editRelationship(int personID, int secondPersonID,
            int relIDCurr, int relIDToChange)
    {
        
    }
}
