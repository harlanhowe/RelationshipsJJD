package relationshipsjjd.view;

import java.util.ArrayList;
import java.util.Scanner;


public class View 
{
    public static final int CANCEL_OPTION = -1;

    /**
     * Displays a text-based menu and gets the user's response; returns the number
     * of the option chosen by the user, or -1 if the user cancels. The user will
     * be asked repeatedly, until a valid option is chosen.
     * @param title - a string to display at the top of the menu
     * @param options - a list of strings to display as choices
     * @param prompt - the string to display below the menu, asking the user to choose.
     * @param allowCancel - whether the user is given the option to cancel
     * @return - the number of the menu option chosen, or CANCEL_OPTION if canceling
     */
    public int displayMenuAndGetResponse(String title, ArrayList<String> options, String prompt, boolean allowCancel)
    {
        if (title != null)
            System.out.println("--------------------------------\n"+title);
        
        System.out.println("--------------------------------");
        
        for (int i = 0; i < options.size(); i++)
        {
            System.out.println((i+1) + "\t" + options.get(i));
        }
        
        System.out.println("--------------------------------");
        
        boolean goodAnswer = false;
        int selection = 0;
        
        do
        {
            if (prompt != null)
                System.out.print(prompt);
            
            if (allowCancel)
                System.out.print(" (Type zero to cancel)");
            
            System.out.print(" ");
            
            Scanner input = new Scanner(System.in);

            try
            {
                selection = input.nextInt();
                
                if (allowCancel && selection == 0)
                    return CANCEL_OPTION;
                
                if (selection<1 || selection>options.size())
                    System.out.println("That number is out of range. Please try again.");
                
                else
                    goodAnswer=true;
            }
            
            catch (NumberFormatException nfe)
            {
                System.out.println("That was not a valid numeric choice. Please try again.");
            }
            
        } while (!goodAnswer);
        
        return selection -1;
    }
    
    /**
     * Asks the user a question and gives a list of Strings that the user can pick from;
     * repeats questions until one of the chosen options is selected (ignoring 
     * upper/lower case). For example if prompt is "Play again?" and options are
     * {"Y","N"}, the user will see:<p>Play again? (Y,N)<p> Examples of what this
     * function might return from this call would be: "Y", "N", "y", "n". You would
     * not receive "Yes", "Maybe", "", or "m".
     * @param prompt - the message that the user sees, sans options
     * @param options - an array of possible strings the user could enter
     * @return a string that matches one of the options strings, ignoring case
     */
    public String displayStringChoiceAndGetResponse(String prompt, String[] options)
    {
        String optionList = "(";
        
        for (int i =0; i<options.length; i++)
        {
            optionList+= options[i];
            
            if (i<options.length-1)
                optionList+=", ";
        }
        
        optionList+=")";
        System.out.print(prompt+" "+optionList+" ");
        
        boolean goodAnswer=false;
        
        do
        {
            Scanner input = new Scanner(System.in);
            
            String response = input.nextLine();
            
            for (String s:options)
                if (s.equalsIgnoreCase(response))
                    return s;
            
            System.out.println("That is not one of your options. Please choose from " + optionList + " ");
            
        } while (!goodAnswer);
        
        return null;
        
    }

public static class DummyClass 
{
    private int id;
    private String name;
    private Boolean isGood;
    private static int lastID= 0; // this variable is "static" shared between all
                               // DummyClass instances. It is what we will use
                               // to make sure they have unique ids....
    
    public DummyClass()
    {
        name = "";
        isGood = true;
        id = lastID + 1; 
        lastID++; // lastID is the highest-valued id for any DummyClass instance
                  // created so far in this program.
    }
    
    /**
     * overloaded constructor that takes a tab-delimited line of format
     * int-tab-String-tab-boolean and builds an instance of this class with
     * corresponding values.
     * Note: assumes that duplicate ids don't exist from previous new DummyClass
     * objects - if you are reading a file, make sure that any list of 
     * DummyClass items is empty first, and that there aren't duplicate ids.
     * @param inputString - a single line string of the prescribed format.
     */
    public DummyClass(String inputString)
    {
        String[] part = inputString.split("\t"); // splits this string into an
                                                 // array of smaller strings.
                                                 // The splits happen where
                                                 // there are tabs (\t).
        // Note: I should catch NumberFormatExceptions here... I'll do
        //  that right after they announce the lottery numbers.
        id = Integer.parseInt(part[0]);
        if (id>lastID)
            lastID = id;
        name = part[1];
        isGood = Boolean.parseBoolean(part[2]);
    }
}

//	public static void displayMenuChoices()
//        {
//            System.out.println("Would you like to:\n");
//            System.out.println("add a new person?");
//            System.out.println("add a new relationship?");
//            System.out.println("add a new relationship type?");
//            System.out.println("delete a relationship?");
//            System.out.println("delete a relationship type?");
//            System.out.println("edit a relationship?");
//            System.out.println("edit a relationship type?\n");
//            
//            Scanner input = new Scanner(System.in);
//            String choiceInput = input.nextLine();
//        }
//        
//        public String addPerson(String choiceInput)
//        {
//            if (choiceInput == "add a new person")
//            {
//                System.out.println("What is the new person's name?");
//                Scanner input = new Scanner(System.in);
//                String nameInput = input.nextLine();
//                System.out.println("What is" + nameInput + "'s gender?");
//                
//            }
//            
//            return null;
//            
//        }
}
