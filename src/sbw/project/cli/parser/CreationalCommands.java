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
    public void testParse(String newArray[]){
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
                //CREATE ELEVATOR R2 WITH LIMIT 10 SPEED 5 ACCELERATION 30
                Identifier idElevator = new Identifier(newArray[2]);
                Angle angle = new Angle(strToDouble(newArray[5]));
                Speed speed = new Speed(strToDouble(newArray[7]));
                Acceleration acceleration = new Acceleration(strToDouble(newArray[9]));
                ActionCreational newCreation = CommandParser.getAC();
                //next need to send it to doCreateElevator() with the newly converted data
                newCreation.doCreateElevator(idElevator, angle, speed, acceleration);
            }//We just need to implement 4 more per the specs of the project
            //aileron
            if(newArray[1].equalsIgnoreCase("AILERON")){
                Identifier idAileron = new Identifier(newArray[2]);
                Angle angleUp = new Angle(strToDouble(newArray[6]));
                Angle angleDown = new Angle(strToDouble(newArray[8]));
                Speed speed = new Speed(strToDouble(newArray[10]));
                Acceleration acceleration = new Acceleration(strToDouble(newArray[12]));
                ActionCreational newCreation = CommandParser.getAC();
                newCreation.doCreateAileron(idAileron, angleUp, angleDown, speed, acceleration);
            }
            // split flap
            if(newArray[1].equalsIgnoreCase("SPLIT") && newArray[2].equalsIgnoreCase("FLAP")){
                Identifier idFlap = new Identifier(newArray[3]);
                boolean isFowler = false;
                Angle angle = new Angle(strToDouble(newArray[6]));
                Speed speed = new Speed(strToDouble(newArray[8]));
                Acceleration acceleration = new Acceleration(strToDouble(newArray[10]));
                ActionCreational newCreation = CommandParser.getAC();
                newCreation.doCreateFlap(idFlap, isFowler, angle,speed, acceleration);
            }
            //engine
            if(newArray[1].equalsIgnoreCase("ENGINE")){
            //test ismail
            }
            //nose gear
            if(newArray[1].equalsIgnoreCase("NOSE") && newArray[2].equalsIgnoreCase("GEAR")){

            }
        }
    }

    //strToDouble method for specific requirements
    public double strToDouble(String value){
        return Double.parseDouble(value);
    }
}
