package sbw.project.cli.parser;

import sbw.project.cli.action.ActionCreational;
import sbw.project.cli.action.ActionSet;

/*
All doX methods in this section are in class sbw.project.cli.action.ActionCreational. Use them as factory
methods. Teams of three choose six commands; teams of two choose three.
 */
public class CommandParser 
{
   private ActionSet actionSet;
   private String text;

   public static ActionCreational actionCreational;
   public static String input;
   public CommandParser(final ActionSet actionSet, final String text)
   {
      this.actionSet = actionSet;
      this.text = text;
      this.actionCreational = actionSet.getActionCreational(); //we will have to do this for Structural and behavioral i believe
      //parse();
   }
   public void setInput(String input){
      this.input = input;
   }
   public static String getInput(){
      return input;
   }

   public void parse()
   {
      setInput(text);
      input = getInput();
      System.out.println("YOUR PARSER: " + input);
     // CreationalCommands.toStringArray(); //changed name of method to represent the string
      //currently only works with the first instance of
      //CREATE RUDDER R1 WITH LIMIT 100 SPEED 90 ACCELERATION 10
      //entered into cmd prolly can fix with a for loop for all commands in the script we will write for testing:)
      CreationalCommands create = new CreationalCommands();
      create.testParse();
      System.out.println();
   }
   public static ActionCreational getAC(){
      return actionCreational;
   }
}
