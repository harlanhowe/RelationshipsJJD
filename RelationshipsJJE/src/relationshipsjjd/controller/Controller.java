package relationshipsjjd.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import relationshipsjjd.model.Person;
import relationshipsjjd.model.Relationship;
import relationshipsjjd.model.RelationshipType;

public class Controller {
    
    private static Map<Integer, Person> people;
    private static Map<Integer, RelationshipType> typeMap;
    
    /***
     * Reads through the files to get stored data Looks for people, then
     * relationship types, then relationships
     */
    public static void init()
    {
        people = new HashMap<Integer, Person>();
        typeMap = new HashMap<Integer, RelationshipType>();
        
        File peopleFile = new File("people.dat");
        File relTypeFile = new File("relTypes.dat");
        File relFile = new File("relationships.dat");
        
        try
        {
            if(!peopleFile.exists())
                peopleFile.createNewFile();
            if(!relTypeFile.exists())
                relTypeFile.createNewFile();
            if(!relFile.exists())
                relFile.createNewFile();
        }
        catch(IOException e){}
        
        try
        {
            Scanner peopleScanner = new Scanner(peopleFile);
            while(peopleScanner.hasNext())
            {
                String infoString = peopleScanner.nextLine();
                String[] items = infoString.split("\t");
                int IDNum = Integer.parseInt(items[0]);
                String firstName = items[2];
                String lastName = items[1];
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
        
        try
        {
            Scanner relTypeScanner = new Scanner(relTypeFile);
            while(relTypeScanner.hasNext())
            {
                String infoString = relTypeScanner.nextLine();
                String[] items = infoString.split("\t");
                
                int ID = Integer.parseInt(items[0]);
                String typeName = items[1];
                String maleType = items[2];
                String femaleType = items[3];
                String maleInverse = items[4];
                String femaleInverse = items[5];
                int invertID = Integer.parseInt(items[6]);
                
                RelationshipType rel = new RelationshipType(typeName, maleType, femaleType, maleInverse, femaleInverse, invertID);
                typeMap.put(ID, rel);
                System.out.println(rel);
            }
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("File not found");
            throw new RuntimeException();
        }
        
        try
        {
            Scanner relScanner = new Scanner(relFile);
            while(relScanner.hasNext())
            {
                String infoString = relScanner.nextLine();
                String[] items = infoString.split("\t");
                int person1ID = Integer.parseInt(items[1]);
                int person2ID = Integer.parseInt(items[2]);
                int relType   = Integer.parseInt(items[3]);
                if(people.containsKey(person1ID) && people.containsKey(person2ID))
                {
                    people.get(person1ID).addRelationship(new Relationship(person1ID, person2ID, relType));
                }
            }
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("File not found");
            throw new RuntimeException();
        }
        
        Set<Integer> keys = people.keySet();
        for(Integer key : keys)
        {
            System.out.println(people.get(key));
        }
        
    }
    
    /**
     * Imagine the reverse process of the above method, save the people, relTypes, and relations
     */
    public static boolean savePeepsAndRelations()
    {
        try
        {
            File peopleFile = new File("people.dat");
            File relTypeFile = new File("relTypes.dat");
            File relFile = new File("relationships.dat");
            
            
            
            {
                //The people will be written within this area, indented to have the formatting look nice
                //Also garbage collection will happen faster and thus have less memory use
                
                PrintWriter peopleWriter = new PrintWriter(peopleFile);
                Set<Integer> keys = people.keySet();
                
                for(int key : keys)
                {
                    peopleWriter.write(key + "\t" + people.get(key).getSaveDescription()+"\n");
                }
                peopleWriter.close();
            }
            
            
            {
                PrintWriter relTypeWriter = new PrintWriter(relTypeFile);
                Set<Integer> keys = typeMap.keySet();
                
                for(int key : keys)
                {
                    relTypeWriter.write(key + "\t" + typeMap.get(key).getSaveDescription());
                }
                relTypeWriter.close();
            }
            
            
            {
                PrintWriter relationWriter = new PrintWriter(relFile);
                Set<Integer> keys = people.keySet();
                
                for(int key : keys)
                {
                    for(Relationship rel : people.get(key).getRelations())
                    {
                        relationWriter.write(key + "\t" + rel.getSaveDescription());
                    }
                }
                relationWriter.close();
            }
            return true;
        }
        catch(IOException e)
        {
            System.out.println("Check out savePeepsAndRelations \nYEA!  We broke stuffs when creating new files!");
            return false;
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
     * Creates a new RelationshipType called "typeName" and the opposite Type "inverseType"
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
        people.get(personID).removeRelationship(new Relationship(personID, secondPersonID, typeID));
        people.get(secondPersonID).removeRelationship(new Relationship(secondPersonID, personID, typeMap.get(typeID).getInverseID()));
    }
    
    /***
     * Removes a RelationshipType
     * 
     * @param typeID
     */
    public static void removeRelationsihpType(int typeID)
    {
        
        Set<Integer> peopleMapKeys = people.keySet();
        for(int key : peopleMapKeys)
        {
            ArrayList<Relationship> toRemove = new ArrayList<Relationship>();
            for(Relationship rel : people.get(key).getRelations())
            {
                if(rel.getIDRelationType()==typeID || rel.getIDRelationType() == typeMap.get(typeID).getInverseID())
                {
                    toRemove.add(rel);
                }
            }
            for(Relationship rel : toRemove)
            {
                people.get(key).removeRelationship(rel);
            }
        }
        
        typeMap.remove(typeMap.get(typeID).getInverseID());
        typeMap.remove(typeID);
    }
    
    /***
     * Removes a Person
     * @param personID 
     */
    public static void removePerson(int personID)
    {
        people.remove(people.get(personID));
    }
    
    /***
     * Changes some parameter of a certain relationship type.
     * Takes in the ID of an existing RelType and changes the parameters of the RelType so that it has the given info
     *      Basically "removes" a Type and puts it back in the same spots
     *      Doesn't delete relationships between peeps
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
                femaleInverse, typeMap.get(typeID).getInverseID());
        RelationshipType relTypeInvert = new RelationshipType(inverseType, maleInverse, femaleInverse, 
                maleType, femaleType, typeID);
        typeMap.put(typeID, relTypeNorm);
        typeMap.put(relTypeNorm.getInverseID(), relTypeInvert);
    }
    
    /***
     * Goes to the indicated people and changes the RelationshipType from relIDCurr to relIDToChange
     * 
     * @param personID
     * @param secondPersonID
     * @param relIDCurr
     * @param relIDToChange
     */
    public static void editRelationship(int personID, int secondPersonID,
            int relIDCurr, int relIDToChange)
    {
        for(Relationship rel : people.get(personID).getRelations())
        {
            if(rel.getIDPerson2() == secondPersonID && rel.getIDRelationType() == relIDCurr)
            {
                rel.setIDRelationType(relIDToChange);
            }
        }
        
        for(Relationship rel : people.get(secondPersonID).getRelations())
        {
            if(rel.getIDPerson2() == personID && rel.getIDRelationType() == relIDCurr)
            {
                rel.setIDRelationType(relIDToChange);
            }
        }
    }

    /**
     * PRECONDITION:
     * That person should exist, will return null otherwise
     */
    public static Person getPersonUnderID(int personID)
    {
        return people.get(personID);
    }
    
    /**
     * PRECONDITION:
     * That relationship should exist, will return null otherwise
     */
    public static RelationshipType getRelationshipTypeUnderID(int relID)
    {
        return typeMap.get(relID);
    }

    /**
     * Creates a new RelationshipType that has an inverse which is the same.
     * @param typeName
     * @param maleType
     * @param femaleType
     * @param maleInverse
     * @param femaleInverse
     */
    public static void addReflexiveRelationshipType(String typeName,
            String maleType, String femaleType, String maleInverse, String femaleInverse)
    {
        Set<Integer> keys = typeMap.keySet();
        
        for(int key : keys)
        {
            if(typeMap.get(key).equals(new RelationshipType(typeName, maleType, femaleType, maleInverse, femaleInverse, key)))
                return;
        }
        
        int ID = -1;
        for(int i=0; ID == -1; i++)
        {
            if(!keys.contains(i))
            {
                ID =i;
                break;
            }
        }
        
        typeMap.put(ID, new RelationshipType(typeName, maleType, femaleType, maleInverse, femaleInverse, ID));
    }

    /***
     * Prints out a list of People's names
     */
    public static void printInfos()
    {
        Set<Integer> keys = people.keySet();
        for(Integer key : keys)
        {
            System.out.println(people.get(key));
        }
    }
    
    /***
     * Returns the map of People
     * @return 
     */
    public static Map<Integer, Person> getPeople()
    {
        return people;
    }
    
    /***
     * Accepts a person's ID and returns that person's relationships
     * @param ID
     * @return 
     */
    public static ArrayList<Relationship> getRelationships(int ID)
    {
       return people.get(ID).getRelations();
    }
    
    /***
     * returns all relationship types
     * @return 
     */
    public static Map<Integer, RelationshipType> getRelationshipTypes()
    {
        return typeMap;
    }
}
