package sbw.project.cli.parser;

import sbw.project.cli.action.ActionBehavioral;
import sbw.project.cli.action.ActionMiscellaneous;
import sbw.project.cli.action.command.misc.CommandDoExit;

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

        if(newArray[0].equalsIgnoreCase("@RUN")){

        }

    }
    private double strToDouble(String value) {
        return Double.parseDouble(value);
    }
}
