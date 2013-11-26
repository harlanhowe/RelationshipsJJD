/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package relationshipsjjd;


import relationshipsjjd.controller.Controller;
import relationshipsjjd.view.View;

/**
 * 
 * @author kadmin
 */
public class RelationshipsJJD {
    
    /**
     * @param args
     *            the command line arguments
     */
//        Controller.editRelationshipType(1, "spouse", "spouse", "husband", "wife", "husband", "wife");
    //student   student student teacher teacher
    public static void main(String[] args)
    {
        Controller.init();
        
        Controller.savePeepsAndRelations();
    }
}
