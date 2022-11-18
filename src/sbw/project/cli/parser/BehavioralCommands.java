package sbw.project.cli.parser;

import sbw.architecture.datatype.Acceleration;
import sbw.architecture.datatype.Angle;
import sbw.architecture.datatype.Identifier;
import sbw.architecture.datatype.Speed;
import sbw.project.cli.action.ActionCreational;

public class BehavioralCommands {
    static String input = CommandParser.getInput();

    public void behavioralParse(String newArray[]){

            //if so then check if parseArray[1] is equal to one of the following commands
            //rudder
        if(newArray[1].equalsIgnoreCase("RUDDER")){

        }
            //elevator
        if(newArray[1].equalsIgnoreCase("ELEVATOR")){

        }
            //aileron
        if(newArray[1].equalsIgnoreCase("AILERON")){

        }
            // split flap
        if(newArray[1].equalsIgnoreCase("SPLIT") && newArray[2].equalsIgnoreCase("FLAP")){

        }
            //engine
        if(newArray[1].equalsIgnoreCase("ENGINE")){

        }
            //nose gear
        if(newArray[1].equalsIgnoreCase("NOSE") && newArray[2].equalsIgnoreCase("GEAR")){

        }
    }

    private double strToDouble(String value) {
        return Double.parseDouble(value);
    }
}
