package relationshipsjjd.view;

import java.util.Scanner;


public class View 
{
	public static void displayMenuChoices()
        {
            System.out.println("Would you like to:\n");
            System.out.println("add a new person?");
            System.out.println("add a new relationship?");
            System.out.println("add a new relationship type?");
            System.out.println("delete a relationship?");
            System.out.println("delete a relationship type?");
            System.out.println("edit a relationship?");
            System.out.println("edit a relationship type?\n");
            
            Scanner input = new Scanner(System.in);
            String choiceInput = input.nextLine();
        }
        
        public String addPerson(String choiceInput)
        {
            if (choiceInput == "add a new person")
            {
                System.out.println("What is the new person's name?");
                Scanner input = new Scanner(System.in);
                String nameInput = input.nextLine();
                System.out.println("What is" + nameInput + "'s gender");
            }
            
            return null;
            
        }
}
