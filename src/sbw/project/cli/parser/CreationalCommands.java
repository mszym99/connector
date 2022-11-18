package sbw.project.cli.parser;
import java.sql.SQLOutput;
import java.util.*;

import sbw.architecture.datatype.Acceleration;
import sbw.architecture.datatype.Angle;
import sbw.architecture.datatype.Identifier;
import sbw.architecture.datatype.Speed;
import sbw.project.cli.action.ActionCreational;
import sbw.project.cli.action.ActionSet;
import sbw.project.cli.parser.CommandParser;

import javax.swing.*;

public class CreationalCommands {
    //get input from CommandParser
    static String input = CommandParser.getInput();
    public String[] toStringArray(){
        //create the parseArray which is an array of strings from input
        String data = input;
        String parseArray[] = data.split(" ");
        return parseArray;

    }
    public void testParse(){
        String newArray[] = toStringArray();
        /*for(String i : newArray){
            System.out.print(i + " " + " ");
        }*/
        //test parseArray[0] to see if its CREATE regardless of case
        if(newArray[0].equalsIgnoreCase("CREATE")){
            //if so then check if parseArray[1] is equal to one of the following commands
            //rudder
            if(newArray[1].equalsIgnoreCase("RUDDER")){
                //CREATE RUDDER R1 WITH LIMIT 100 SPEED 90 ACCELERATION 10
                Identifier idRudder = new Identifier(newArray[2]);
                Angle angle = new Angle(strToDouble(newArray[5]));
                Speed speed = new Speed(strToDouble(newArray[7]));
                Acceleration acceleration = new Acceleration(strToDouble(newArray[9]));
                //next need to send it to doCreateRudder() with the newly converted data
                ActionCreational newCreation = CommandParser.getAC();
                newCreation.doCreateRudder(idRudder, angle, speed, acceleration);
               // System.out.println("Test met");
            }
            //elevator
            if(newArray[1].equalsIgnoreCase("ELEVATOR")){
                //CREATE ELEVATOR <id> WITH LIMIT <angle> SPEED <speed> ACCELERATION <acceleration>
                Identifier idElevator = new Identifier(newArray[2]);
                Angle angle = new Angle(strToDouble(newArray[5]));
                Speed speed = new Speed(strToDouble(newArray[7]));
                Acceleration acceleration = new Acceleration(strToDouble(newArray[9]));
                ActionCreational newCreation = CommandParser.getAC();
                //next need to send it to doCreateElevator() with the newly converted data
                newCreation.doCreateRudder(idElevator, angle, speed, acceleration);
            }//We just need to implement 4 more per the specs of the project
            //aileron
            if(newArray[1].equalsIgnoreCase("AILERON")){

            }
            //flap
            if(newArray[1].equalsIgnoreCase("FLAP")){

            }
            //engine
            if(newArray[1].equalsIgnoreCase("ENGINE")){

            }
            //gear
            if(newArray[1].equalsIgnoreCase("GEAR")){

            }

        }
    }

    //setter if needed
    public void setInput(String input){
        this.input = input;
    }
    //strToDouble method for specific requirements
    public double strToDouble(String value){
        return Double.parseDouble(value);
    }




}
