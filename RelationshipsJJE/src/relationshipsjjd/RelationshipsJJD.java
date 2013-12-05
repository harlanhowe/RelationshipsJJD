/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package relationshipsjjd;

import relationshipsjjd.controller.Controller;

/**
 * 
 * @author kadmin
 */
public class RelationshipsJJD {
    
    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args)
    {
        
        Controller control = new Controller();
        control.printInfos();
        control.addPerson("Jim", "Todd", false);
        control.addPerson("Lindzi", "Todd", false);
        control.addReflexiveRelationshipType("spouse", "husband", "wife", "husband", "wife");
        control.addRelationship(0, 1, 0);
        control.printInfos();
        control.savePeepsAndRelations();
    }
}
