package sbw.project.cli.parser;

import sbw.project.cli.action.ActionSet;
import java.util.*;
/*
All doX methods in this section are in class sbw.project.cli.action.ActionCreational. Use them as factory
methods. Teams of three choose six commands; teams of two choose three.
 */
public class CommandParser 
{
   private ActionSet actionSet;
   private String text;
   public static String input;
   public CommandParser(final ActionSet actionSet, final String text)
   {
      this.actionSet = actionSet;
      this.text = text;
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
      CreationalCommands.toStringArray(); //changed name of method to represent the string
      System.out.println();
   }
}
