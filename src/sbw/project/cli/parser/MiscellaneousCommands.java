package sbw.project.cli.parser;

import sbw.architecture.datatype.Rate;
import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.command.misc.CommandDoExit;
import sbw.project.cli.action.command.misc.CommandDoRunCommandFile;
import sbw.project.cli.action.command.misc.CommandDoSetClockRate;

public class MiscellaneousCommands {
    public void miscellaneousParse(String newArray[]) {

        if(newArray[0].equalsIgnoreCase("@CLOCK")){
            //@CLOCK <rate>
            /*
            Sets the system clock speed to rate ticks per second.
            This calls submitCommand() with an instance of CommandDoSetClockRate.
             */
            Rate rate = new Rate(Integer.parseInt(newArray[1]));
            CommandDoSetClockRate clockCommand = new CommandDoSetClockRate(rate);
            ActionMiscellaneous newAM = CommandParser.getAM();
            newAM.submitCommand(clockCommand);
        }

        if(newArray[0].equalsIgnoreCase("@EXIT")){
            CommandDoExit exitCommand = new CommandDoExit();
            //create new instance of Action Miscellaneous
            ActionMiscellaneous newMiscellaneous = CommandParser.getAM();
            newMiscellaneous.submitCommand(exitCommand);
        }

        //@RUN "<filename>"
        if(newArray[0].equalsIgnoreCase("@RUN")){
            CommandDoRunCommandFile command = new CommandDoRunCommandFile(newArray[1]);
            ActionMiscellaneous newAM = CommandParser.getAM();
            newAM.submitCommand(command);
        }

    }
    private double strToDouble(String value) {
        return Double.parseDouble(value);
    }
}
