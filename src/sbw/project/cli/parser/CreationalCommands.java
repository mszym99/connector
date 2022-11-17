package sbw.project.cli.parser;
import java.sql.SQLOutput;
import java.util.*;
import sbw.project.cli.parser.CommandParser;

public class CreationalCommands {
    //get input from CommandParser
    static String input = CommandParser.getInput();
    public static void toStringArray(){
        //create the parseArray which is an array of strings from input
        String data = input;
        String parseArray[] = data.split(" ");

        //for testing purposes for each string in parseArray will print with extra space resembling the array
        for(String i : parseArray){
            System.out.print(i + " " + " ");
        }

    }
    //setter if needed
    public void setInput(String input){
        this.input = input;
    }
    //testReturn will be called for testing in CommandParser
    public static String testReturn(String input){
        return input;
    }
}
