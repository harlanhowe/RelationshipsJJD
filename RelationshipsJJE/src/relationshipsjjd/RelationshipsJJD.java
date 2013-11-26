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
    public static void main(String[] args)
    {
        Controller.init();
        Controller.editPerson(1, "Harlan", "Howe", true);
        Controller.savePeepsAndRelations();
        View.Run();
    }
}
