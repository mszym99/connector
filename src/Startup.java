import sbw.project.cli.CommandLineInterface;

public class Startup
{
   public Startup(){

   }
   public static void main(String[] args)
   {
      CommandLineInterface cli = new CommandLineInterface();
      /*
      Read next line I.E "CREATE RUDDER <id> WITH LIMIT <angle> SPEED <speed> ACCELERATION <acceleration>"
       */
      cli.execute();      
   }
}
