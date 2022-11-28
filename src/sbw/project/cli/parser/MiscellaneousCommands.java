package sbw.project.cli.parser;

import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.command.misc.CommandDoExit;
import sbw.project.cli.action.command.misc.CommandDoRunCommandFile;

public class MiscellaneousCommands {
    public void miscellaneousParse(String newArray[]) {

        if(newArray[0].equalsIgnoreCase("@CLOCK")){

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
