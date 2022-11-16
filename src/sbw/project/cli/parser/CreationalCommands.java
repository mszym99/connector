package sbw.project.cli.parser;
import java.sql.SQLOutput;
import java.util.*;
import sbw.project.cli.parser.CommandParser;

public class CreationalCommands {
    //get input from CommandParser
    static String input = CommandParser.getInput();
    public static void stringToCharArray(){
        //create the parseArray which is an array of chars from input
        char[] parseArray = new char[input.length()];
        //for loop to fill the arry with characters from input
        for (int i = 0; i < input.length(); i++){
            parseArray[i] = input.charAt(i);
        }
    //for testing purposes for each character in parseArray will print with space resembling the array
        for(char c : parseArray){
            System.out.print(c + " ");
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
