package sbw.project.cli.parser;

import sbw.project.cli.action.ActionSet;
import java.util.*;
/*
All doX methods in this section are in class sbw.project.cli.action.ActionCreational. Use them as factory
methods. Teams of three choose six commands; teams of two choose three.
 */
public class CommandParser 
{
   String input;
   public CommandParser(final ActionSet actionSet, final String text)
   {
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      System.out.println("YOUR PARSER:" + input);

   }
   public static String getInput(String input){
      return input;
   }

   public void parse()
   {
      System.out.println("YOUR PARSER:" + CreationalCommands.testReturn(input));
   }
   //Testing push for matt
   //Testing push for Hannah
}
