package sbw.project.cli.parser;

import sbw.architecture.datatype.Acceleration;
import sbw.architecture.datatype.Angle;
import sbw.architecture.datatype.Identifier;
import sbw.architecture.datatype.Speed;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionCreational;
import sbw.project.cli.action.command.behavioral.CommandDoDeflectElevator;
import sbw.project.cli.action.command.behavioral.CommandDoDeflectRudder;
import sbw.project.cli.action.command.behavioral.CommandDoHalt;

public class BehavioralCommands {
    public void behavioralParse(String newArray[]){

        //if so then check if parseArray[1] is equal to one of the following commands
        //rudder
        //DO <id> DEFLECT RUDDER <angle> LEFT|RIGHT
        if(newArray[1].equalsIgnoreCase("RUDDER")){
          //for left
            if(newArray[5].equalsIgnoreCase("LEFT")){
                Identifier id = new Identifier(newArray[1]);
                Angle angle = new Angle(strToDouble(newArray[4]));
                CommandDoDeflectRudder command = new CommandDoDeflectRudder(id, angle, false);
                //This calls submitCommand() with instance of CommandDoX
                ActionBehavioral newAB = CommandParser.getAB();
                newAB.submitCommand(command);
            }//for right
            if(newArray[5].equalsIgnoreCase("RIGHT")){
                Identifier id = new Identifier(newArray[1]);
                Angle angle = new Angle(strToDouble(newArray[4]));
                CommandDoDeflectRudder command = new CommandDoDeflectRudder(id, angle, true);
                //This calls submitCommand() with instance of CommandDoX
                ActionBehavioral newAB = CommandParser.getAB();
                newAB.submitCommand(command);
            }
        }
        //elevator
        //DO <id> DEFLECT ELEVATOR <angle> UP|DOWN
        if(newArray[1].equalsIgnoreCase("ELEVATOR")){
            //for up
            if(newArray[5].equalsIgnoreCase("UP")){
                Identifier id = new Identifier(newArray[1]);
                Angle angle = new Angle(strToDouble(newArray[4]));
                //new command
                CommandDoDeflectElevator command = new CommandDoDeflectElevator(id, angle, false);
                //call submitCommand()
                ActionBehavioral newAB = CommandParser.getAB();
                newAB.submitCommand(command);
            }
            //for down
            if(newArray[5].equalsIgnoreCase("DOWN")){
                Identifier id = new Identifier(newArray[1]);
                Angle angle = new Angle(strToDouble(newArray[4]));
                //new command
                CommandDoDeflectElevator command = new CommandDoDeflectElevator(id, angle, true);
                //call submitCommand()
                ActionBehavioral newAB = CommandParser.getAB();
                newAB.submitCommand(command);
            }
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
        //HALT case is met per spec
        /*
        HALT <id>*/
        if(newArray[0].equalsIgnoreCase("HALT")){
            Identifier id = new Identifier(newArray[1]);
            CommandDoHalt commandDoHalt = new CommandDoHalt(id);
            ActionBehavioral newAB = CommandParser.getAB();
            newAB.submitCommand(commandDoHalt);
        }
    }

    private double strToDouble(String value) {
        return Double.parseDouble(value);
    }
}
