package relationshipsjjd.view.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class ViewFrame extends JFrame {
    
    private JPanel peopleViewPanel;
        private JButton addPerson;
        private JButton removePerson;
        private JButton addRelationship;
        private JButton removeRelationship;
        private JButton addRelationshipType;
        private JButton removeRelationshipType;
        private JButton changeRelationship;
        private JButton editRelationshipType;
        
        private JTextField firstNameField;
        private JTextField lastNameField;
        private JRadioButton[] isMale = new JRadioButton[2];
    private JPanel editPanel;
    private JPanel relationViewPanel;
    
    
    public ViewFrame()
    {
        this.peopleViewPanel = new JPanel();
        peopleViewPanel.setSize(1000, 500);
        
    }
    
}
