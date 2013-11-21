package relationshipsjjd.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import relationshipsjjd.model.Person;
import relationshipsjjd.model.Relationship;
import relationshipsjjd.model.RelationshipType;

public class Controller {
    
    private static HashMap<Integer, Person> people;
    private static HashMap<Integer, RelationshipType> typeMap;
    
    /***
     * Reads through the files to get stored data Looks for people, then
     * relationship types, then relationships
     */
    public static void init()
    {
        File peopleFile = new File("people.dat");
        try
        {
            Scanner peopleScanner = new Scanner(peopleFile);
            while(peopleScanner.hasNext())
            {
                String infoString = peopleScanner.nextLine();
                String[] items = infoString.split("\t");
                int IDNum = Integer.parseInt(items[0]);
                String firstName = items[1];
                String lastName = items[2];
                boolean isMale = Boolean.parseBoolean(items[3]);
                
                Person tempPerson = new Person(firstName, lastName, IDNum, isMale);
                people.put(IDNum, tempPerson);
            }
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("File not found");
            throw new RuntimeException();
        }
        
        File relTypeFile = new File("relTypes.dat");
        try
        {
            Scanner relTypeScanner = new Scanner(relTypeFile);
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("File not found");
            throw new RuntimeException();
        }
        
        File relFile = new File("relationships.dat");
        try
        {
            Scanner relScanner = new Scanner(relFile);
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("File not found");
            throw new RuntimeException();
        }
    }
    
    /***
     * Creates a new Person, firstName, lastName
     * 
     * @param firstName
     * @param lastName 
     */
    public static void addPerson(String firstName, String lastName, boolean isMale)
    {
        Set<Integer> keys = people.keySet();
        int ID = 0;
        for(int i=0; i !=-1; i++)
        {
            if(!keys.contains(i))
            {
                ID =i;
                break;
            }
        }
        people.put(ID, new Person(firstName, lastName, ID, isMale));
    }
    
    /***
     * Creates a new relationship
     *      Adds the relationship to both parties under the inverse for the second party going to the first
     * @param firstID
     * @param secondID
     * @param relType
     */
    public static void addRelationship(int firstID, int secondID, int relType)
    {
        if (relType < typeMap.size())
        {
            if (firstID < people.size() && secondID < people.size())
            {
                people.get(firstID).addRelationship(new Relationship(firstID, secondID, relType));
                people.get(secondID).addRelationship(new Relationship(secondID, firstID, 
                        typeMap.get(relType).getInverseID()));
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
        Set<Integer> mapKeys = typeMap.keySet();
        int numOfKeysFound = 0;
        int[] keys = new int[2];
        for(int key = 0; numOfKeysFound < 2; key++)
        {
            if(!mapKeys.contains(key))
            {
                keys[numOfKeysFound] = key;
                numOfKeysFound++;
            }
        }
        
        RelationshipType relTypeNorm = new RelationshipType(typeName, maleType, femaleType, maleInverse, 
                femaleInverse, keys[1]);
        RelationshipType relTypeInvert = new RelationshipType(inverseType, maleInverse, femaleInverse, 
                maleType, femaleType, keys[0]);
        typeMap.put(keys[0], relTypeNorm);
        typeMap.put(keys[1], relTypeInvert);
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
        typeMap.remove(typeMap.get(typeID).getInverseID());
        typeMap.remove(typeID);
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
    public static void editRelationshipType(int typeID, String typeName,
            String inverseType, String maleType, String femaleType,
            String maleInverse, String femaleInverse)
    {
        RelationshipType relTypeNorm = new RelationshipType(typeName, maleType, femaleType, maleInverse, 
                femaleInverse, typeMap.get(typeMap).getInverseID());
        RelationshipType relTypeInvert = new RelationshipType(inverseType, maleInverse, femaleInverse, 
                maleType, femaleType, typeID);
        typeMap.put(typeID, relTypeNorm);
        typeMap.put(relTypeNorm.getInverseID(), relTypeInvert);
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
