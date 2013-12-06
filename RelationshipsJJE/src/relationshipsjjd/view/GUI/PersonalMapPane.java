/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relationshipsjjd.view.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import relationshipsjjd.controller.Controller;
import relationshipsjjd.model.Relationship;

/**
 *
 * @author harlan.howe
 */
public class PersonalMapPane extends JPanel 
{
    private Controller data;
    
    private int currentPersonID;
   
    private Font myFont = new Font("Times New Roman",Font.PLAIN, 20);
    // colors for the center circle, outer circles, and connecting lines.
    private Color subjectColor, objectColor, lineColor; 
    // how big the circles should be, based on the size of the window....
    private int circleDiam;
    
    private int selectedObjectId; // the id# for whichever of the surrounding 
                                  //     people is selected.
    
    private RelationshipFrame superFrame;
    
    public PersonalMapPane(Controller data, RelationshipFrame frameResidingIn)
    {
        super();
        subjectColor = new Color(128,128,255);
        objectColor = new Color(128,255,128);
        lineColor = new Color(255,128,128);
        setBackground(Color.LIGHT_GRAY);
        addMouseListener(new PanelListener()); // activates the panelListener, 
                                               // so you can collect mouse clicks.
        selectedObjectId = -1; // nobody is selected...
        this.data = data;
        
        superFrame = frameResidingIn;
    }

    
    /**
     * Receives a link to the Controller - in the example case, the controller
     * class is called RelationshipData.
     * I've deactivated this method to allow compiling, but you'll need to fix
     * it up.
     * @param inData - a link to my controller class. 
     */
    public void setData(Controller inData)
    {
        data = inData;
    }

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
            return (int)(height/2-circleDiam*4*Math.cos(2*index*Math.PI/numRelationships));
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
        // TODONE: Got num of rels
        int numRels = data.getPersonUnderID(currentPersonID).getNumberOfRelations();
        
        // TODONE: For loop through rels
        for(int i = 0; i<=numRels; i++)
        {
            if (Math.pow(x-getCenterXForObject(i,numRels),2)+Math.pow(y-getCenterYForObject(i,numRels),2)<Math.pow(circleDiam,2))
            {
                // TODONE: Get the selected id
                selectedObjectId = i;
                superFrame.selectRelationship(selectedObjectId);
                repaint();
                return;
            }
        }
        selectedObjectId = -1;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        // TODONE: Bail out if data is null
        
        if(!data.getPeople().containsKey(currentPersonID))
            return;
        
        this.selectedObjectId = superFrame.getSelectedRelationship();
        
        int width = this.getBounds().width;
        int height = this.getBounds().height;
        circleDiam = Math.min(width/10, height/10);
        int nameWidth;
        g.setFont(myFont);
        
        // TODONE: Draws the other circles and lines to them
        
        ArrayList<Relationship> rels = data.getRelationships(this.currentPersonID);
        for(int relID = 0; relID < rels.size(); relID++)
        {
            g.setColor(this.lineColor);
            g.drawLine(this.getCenterXForObject(relID, rels.size()), this.getCenterYForObject(relID, rels.size()), width/2, height/2);
            
            String relName = data.getRelationshipTypeUnderID(rels.get(relID).getIDRelationType()).getRelationshipName();
            Rectangle2D stringBounds = this.getStringSizeX(relName, g);
            g.clearRect((int)((this.getCenterXForObject(relID, rels.size())+width/2)/2-stringBounds.getWidth()/2), (int)((this.getCenterYForObject(relID, rels.size())+height/2)/2-stringBounds.getHeight()/2), (int)stringBounds.getWidth(), (int)stringBounds.getHeight());
            g.drawString(relName, (int)((this.getCenterXForObject(relID, rels.size())+width/2)/2-stringBounds.getWidth()/2), (int)((this.getCenterYForObject(relID, rels.size())+height/2)/2));
            
            g.setColor(this.objectColor);
            g.fillOval(this.getCenterXForObject(relID, rels.size())-circleDiam/2,this.getCenterYForObject(relID, rels.size())-circleDiam/2,circleDiam,circleDiam);
            
            g.setColor(Color.black);
            String name = data.getPersonUnderID(rels.get(relID).getIDPerson2()).getName();
            stringBounds = this.getStringSizeX(name, g);
            g.drawString(name,(int)(this.getCenterXForObject(relID, rels.size())-stringBounds.getWidth()/2), (int)(this.getCenterYForObject(relID, rels.size())));
            if(this.selectedObjectId == relID)
                g.drawOval(this.getCenterXForObject(relID, rels.size())-circleDiam/2,this.getCenterYForObject(relID, rels.size())-circleDiam/2,circleDiam,circleDiam);
        }
        
        g.setColor(subjectColor);
        g.fillOval(width/2-circleDiam/2,height/2-circleDiam/2,circleDiam,circleDiam);
        
        // TODONE: Got the person's name
        String mainName = data.getPersonUnderID(currentPersonID).getName();
        
        g.setColor(Color.BLACK);
        nameWidth = g.getFontMetrics().stringWidth(mainName);
        g.drawString(mainName, width/2-nameWidth/2, height/2+5);
        
    }
    
    public Rectangle2D getStringSizeX(String string, Graphics g)
    {
        FontMetrics fm = g.getFontMetrics();
        return fm.getStringBounds(string, g);
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

    public void setCurrentSelectedID(int selectedIndex)
    {
        this.selectedObjectId = selectedIndex;
    }
}
