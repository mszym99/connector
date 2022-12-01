package sbw.project.cli.parser;

import sbw.project.cli.action.*;
import java.io.*;
import java.io.FileReader;
import java.util.Scanner;

/*
All doX methods in this section are in class sbw.project.cli.action.ActionCreational. Use them as factory
methods. Teams of three choose six commands; teams of two choose three.
 */
public class CommandParser 
{
   private ActionSet actionSet;
   private String text;

   public static ActionCreational actionCreational;
   public static ActionStructural actionStructural;
   public static ActionBehavioral actionBehavioral;
   public static ActionMiscellaneous actionMiscellaneous;
   public static String input;
   public CommandParser(final ActionSet actionSet, final String text)
   {
      this.actionSet = actionSet;
      this.text = text;
      this.actionCreational = actionSet.getActionCreational();//we will have to do this for Structural and behavioral i believe
      this.actionStructural = actionSet.getActionStructural();
      this.actionBehavioral = actionSet.getActionBehavioral();
      this.actionMiscellaneous = actionSet.getActionMiscellaneous();
      //parse();
   }
   public void setInput(String input){
      this.input = input;
   }
   public static String getInput(){
      return input;
   }

   public void parse() throws FileNotFoundException {
      //String testFile = "C:\\Users\\MSzym\\Downloads\\connector\\src\\sbw\\project\\cli\\parser\\creationalTests.txt";
      //File newFile = new File(testFile);
      //Scanner scanner = new Scanner(newFile);
      int linenum = 0;
     // while(scanner.hasNextLine()){
         //String temp = scanner.nextLine();
        // text = temp;
         setInput(text);
         input = getInput();
         System.out.println("YOUR PARSER: " + input);

         //Creates a string array to store command line inputs
         String newArray[] = toStringArray();
         //Created for loop to loop through every input and then direct to needed parser.
         for(String str : newArray) {
            if (newArray[0].equalsIgnoreCase("CREATE")) {
               //Creates a new instance of the Creational Commands Class
               CreationalCommands create = new CreationalCommands();
               //calls the method that parses the String array and calls the appropriate action class based on input
               create.testParse(newArray);
               System.out.println();
               return;
            } else if (newArray[0].equalsIgnoreCase("DECLARE") || newArray[0].equalsIgnoreCase("COMMIT")) {
               //Creates a new instance of the Behavioral Commands class and for commit if case is met
               StructuralCommands create = new StructuralCommands();
               //calls the method that parses the String array and calls the appropriate action class based on input
               create.structrualParse(newArray);
               System.out.println();
               return;
            } else if (newArray[0].equalsIgnoreCase("DO") || newArray[0].equalsIgnoreCase("HALT")) {
               //Creates a new instance of the Structural Commands class or HALT case
               BehavioralCommands create = new BehavioralCommands();
               //calls the method that parses the String array and calls the appropriate action class based on input
               create.behavioralParse(newArray);
               System.out.println();
               return;
            } else if (newArray[0].equalsIgnoreCase("@CLOCK") || newArray[0].equalsIgnoreCase("@RUN")
                    || newArray[0].equals("@EXIT")) {
               //Creates a new instance of the Miscellaneous Commands class
               MiscellaneousCommands create = new MiscellaneousCommands();
               //calls the method that parses the String array and calls the appropriate action class based on input
               create.miscellaneousParse(newArray);
               System.out.println();
               return;
            } else {
               //Prints out that the command line input is not a valid input
               System.out.println("Invalid Input: " + newArray[0] + " does not exist");
               return;
            }
         }
     // }

   }

   public static ActionCreational getAC(){
      return actionCreational;
   }

   public static ActionStructural getAS(){
      return actionStructural;
   }

   public static ActionBehavioral getAB(){
      return actionBehavioral;
   }

   public static ActionMiscellaneous getAM(){
      return actionMiscellaneous;
   }

   public String[] toStringArray(){
      //create the parseArray which is an array of strings from input
      String data = input;
      String parseArray[] = data.split(" ");
      return parseArray;

   }
}
