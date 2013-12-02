/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relationshipsjjd.view.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author harlan.howe
 */
public class PersonalMapPane extends JPanel 
{
    // you'll want a link to your controller here.
    // TODO: add a variable to the class that holds your Controller.
    // private RelationshipData data;
    
    
    private int currentPersonID;
   
    private Font myFont = new Font("Times New Roman",Font.PLAIN, 10);
    // colors for the center circle, outer circles, and connecting lines.
    private Color subjectColor, objectColor, lineColor; 
    // how big the circles should be, based on the size of the window....
    private int circleDiam;
    
    private int selectedObjectId; // the id# for whichever of the surrounding 
                                  //     people is selected.
    
    public PersonalMapPane()
    {
        super();
        subjectColor = new Color(128,128,255);
        objectColor = new Color(128,255,128);
        lineColor = new Color(255,128,128);
        setBackground(Color.LIGHT_GRAY);
        addMouseListener(new PanelListener()); // activates the panelListener, 
                                               // so you can collect mouse clicks.
        selectedObjectId = -1; // nobody is selected...
    }

    
    /**
     * Receives a link to the Controller - in the example case, the controller
     * class is called RelationshipData.
     * I've deactivated this method to allow compiling, but you'll need to fix
     * it up.
     * @param inData - a link to my controller class. 
     */
    // TODO: you do this! (write the setData method.)
    
//    public void setData(RelationshipData inData)
//    {
//        data = inData;
//    }

    public int getSelectedObjectId() {
        return selectedObjectId;
    }

    public int getCurrentPersonID() {
        return currentPersonID;
    }

    /**
     * changes which person is at the center of the pane and refreshes the pane.
     * @param currentPersonID - the id# of the current person.
     */
    public void setCurrentPersonID(int currentPersonID) {
        this.currentPersonID = currentPersonID;
        
        repaint();
    }
    /**
     * gets the location of where you should draw the center of the circle for
     * the person at the end of a particular relationship, based on which number
     * relationship this is in the current person's list of relations. The circle
     * is divided into even wedges, defined by how many current relationships there are.
     * @param index - which position on the list of current relationships we 
     *                  are talking about
     * @param numRelationships - how many relationships there are for the current
     *                              person.
     * @return the x-coordinate of the center of the circle to be drawn, or -1 
     *          if there is a problem.
     */
    int getCenterXForObject(int index, int numRelationships)
    {
        int width = this.getBounds().width;
        int height = this.getBounds().height;
        circleDiam = Math.min(width/10, height/10);
        if (numRelationships>0)
            return (int)(width/2-circleDiam*4*Math.sin(2*index*Math.PI/numRelationships));
        return -1;
    }
    /**
     * gets the location of where you should draw the center of the circle for
     * the person at the end of a particular relationship, based on which number
     * relationship this is in the current person's list of relations. The circle
     * is divided into even wedges, defined by how many current relationships there are.
     * @param index - which position on the list of current relationships we 
     *                  are talking about
     * @param numRelationships - how many relationships there are for the current
     *                              person. This should be >0.
     * @return the x-coordinate of the center of the circle to be drawn, or -1 
     *          if there is a problem.
     */
    int getCenterYForObject(int index, int numRelationships)
    {
        int width = this.getBounds().width;
        int height = this.getBounds().height;
        circleDiam = Math.min(width/10, height/10);        
        if (numRelationships>0)
            return (int)(width/2-circleDiam*4*Math.cos(2*index*Math.PI/numRelationships));
        return -1;
    }
    
    /**
     * Respond to the user clicking at (x,y) - if there is a relationship circle
     * nearby, select it.
     * @param x
     * @param y 
     */
    public void handleMouseClick(int x, int y)
    {
        int numRelationships = 1;
        if (numRelationships ==0)
            return;
        int i=0;
        // define the number of relationships for the current person.
        // TODO: you do this (handleMouseClick countRels)
        int numRels = 0;
        
        // loop over all the relationships for the current person...
        // TODO: you do this! (handleMouseClick loop) - just write the "for"
        //       or "while" statement.
        {
            if (Math.pow(x-getCenterXForObject(i,numRels),2)+Math.pow(y-getCenterYForObject(i,numRels),2)<Math.pow(circleDiam,2))
            {
                // TODO: you do this! (handleMouseClick selectedID) - set the selectedObjectID to the id of the
                //          target of this iteration's relationship.
                //selectedObjectId = ?????
                
                
                
                repaint();
                return;
            }
            i++;
        }
        selectedObjectId = -1;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // bail out if data is null, or if nobody is selected.....
        // TODO: you do this! (paintComponent - bail)

        
        
        int width = this.getBounds().width;
        int height = this.getBounds().height;
        circleDiam = Math.min(width/10, height/10);
        int nameWidth;
        g.setFont(myFont);
        // loop through each of the relationships - you'll need to draw:
        //   1) the line for the relationship
        //   2) a string with a relationshipType for the line
        //   3) a circle for the related person
        //     3b) an outline for the related person, if this one is selected.
        //   4) the name of the related person
        //  You'll want to make use of getCenterXForObject(), getCenterYForObject(),
        //  lineColor, objectColor, 
        // TODO: you do this! (paintComponent - loop through relations)
        
        g.setColor(subjectColor);
        g.fillOval(width/2-circleDiam/2,height/2-circleDiam/2,circleDiam,circleDiam);
        
        // Get the name of the current person, and set 'mainName' to it.
        // TODO: You do this! (paintComponent - mainName)
        String mainName = "Somebody";
        
        g.setColor(Color.BLACK);
        nameWidth = g.getFontMetrics().stringWidth(mainName);
        g.drawString(mainName, width/2-nameWidth/2, height/2+5);
        
    }
    
    /**
     * a custom "internal class" to deal with the mouse. It simply defers the
     *   click to the handleMouseClick() method in PersonalMapPane.
     */
    public class PanelListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent evt)
        {
            handleMouseClick(evt.getX(),evt.getY());
        }
    }
}
