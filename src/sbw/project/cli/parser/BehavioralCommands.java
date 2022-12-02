package sbw.project.cli.parser;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionCreational;
import sbw.project.cli.action.command.behavioral.*;

public class BehavioralCommands {
    public void behavioralParse(String newArray[]) {

        //if so then check if parseArray[1] is equal to one of the following commands
        //rudder
        //DO <id> DEFLECT RUDDER <angle> LEFT|RIGHT
        if (newArray[1].equalsIgnoreCase("RUDDER")) {
            //for left
            if (newArray[5].equalsIgnoreCase("LEFT")) {
                Identifier id = new Identifier(newArray[1]);
                Angle angle = new Angle(strToDouble(newArray[4]));
                CommandDoDeflectRudder command = new CommandDoDeflectRudder(id, angle, false);
                //This calls submitCommand() with instance of CommandDoX
                ActionBehavioral newAB = CommandParser.getAB();
                newAB.submitCommand(command);
            }//for right
            if (newArray[5].equalsIgnoreCase("RIGHT")) {
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
        if (newArray[1].equalsIgnoreCase("ELEVATOR")) {
            //for up
            if (newArray[5].equalsIgnoreCase("UP")) {
                Identifier id = new Identifier(newArray[1]);
                Angle angle = new Angle(strToDouble(newArray[4]));
                //new command
                CommandDoDeflectElevator command = new CommandDoDeflectElevator(id, angle, false);
                //call submitCommand()
                ActionBehavioral newAB = CommandParser.getAB();
                newAB.submitCommand(command);
            }
            //for down
            if (newArray[5].equalsIgnoreCase("DOWN")) {
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
        if (newArray[3].equalsIgnoreCase("AILERON")) {
            boolean isDown;
            Identifier id = new Identifier(newArray[1]);
            Angle angle = new Angle(strToDouble(newArray[4]));
            if (newArray[5].equalsIgnoreCase("DOWN")) {
                isDown = true;
            } else {
                isDown = false;
            }

            CommandDoDeflectAilerons command = new CommandDoDeflectAilerons(id, angle, isDown);
            ActionBehavioral newBehavioral = CommandParser.getAB();
            newBehavioral.submitCommand(command);
        }
        // split flap
        if (newArray[3].equalsIgnoreCase("FLAP")) {
            Identifier id = new Identifier(newArray[1]);
            Position position = new Position(Position.getEnum(Integer.parseInt(newArray[4])));

            CommandDoSetFlaps command = new CommandDoSetFlaps(id, position);
            ActionBehavioral newBehavioral = CommandParser.getAB();
            newBehavioral.submitCommand(command);
        }
        //engine
        //DO <id> SET POWER <power>
        //DO <id1> SET POWER <power> ENGINE <id2>
        if (newArray[5].equalsIgnoreCase("ENGINE")) {
            Identifier id = new Identifier(newArray[1]);
            Power power = new Power(Double.parseDouble(newArray[4]));
            Identifier idEngine = new Identifier(newArray[6]);
            CommandDoSetEnginePowerAll command_all = new CommandDoSetEnginePowerAll(id, power);
            CommandDoSetEnginePowerSingle command_single = new CommandDoSetEnginePowerSingle(id, power, idEngine);
            ActionBehavioral newBehavioral = CommandParser.getAB();
            newBehavioral.submitCommand(command_all);
            newBehavioral.submitCommand(command_single);
        }
        //nose gear
        //DO <id> GEAR UP|DOWN
        if (newArray[2].equalsIgnoreCase("GEAR")) {

            if (newArray[3].equalsIgnoreCase("UP")) {
                Identifier id = new Identifier(newArray[1]);
                CommandDoSelectGear command = new CommandDoSelectGear(id, false);
                ActionBehavioral newAB = CommandParser.getAB();
                newAB.submitCommand(command);
            }
            if (newArray[3].equalsIgnoreCase("DOWN")) {
                Identifier id = new Identifier(newArray[1]);
                CommandDoSelectGear command = new CommandDoSelectGear(id, true);
                ActionBehavioral newAB = CommandParser.getAB();
                newAB.submitCommand(command);
            }
        }
            //HALT case is met per spec
        /*
        HALT <id>*/
            if (newArray[0].equalsIgnoreCase("HALT")) {
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


