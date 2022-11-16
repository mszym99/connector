package sbw.project.cli.parser;

import sbw.project.cli.parser.CommandParser;

public class CreationalCommands {
    String input = "";
    String parse = CommandParser.getInput(input);
    
    //String[] parseArray;
    public void setInput(String input){
        this.input = input;
    }

    public static String testReturn(String input){
        return input;
    }
}
