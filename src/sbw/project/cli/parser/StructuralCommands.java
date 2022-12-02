package sbw.project.cli.parser;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionCreational;
import sbw.project.cli.action.ActionStructural;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StructuralCommands {
    public boolean committed = false;
    public void structrualParse(String newArray[]){
        //if so then check if parseArray[1] is equal to one of the following commands
        //rudder
        //This is required per spec to move onto behavioral

        if(newArray[0].equalsIgnoreCase("COMMIT")){
            ActionStructural newStructure = CommandParser.getAS();
            //just call doCommit()
            newStructure.doCommit();
        }
        else {
            if (newArray[1].equalsIgnoreCase("RUDDER")) {
                //Create new identifier with id at array index 3
                Identifier idController = new Identifier(newArray[3]);
                //Create mew identifier
                Identifier idRudder = new Identifier(newArray[6]);
                ActionStructural newAs = CommandParser.getAS();
                //doDeclare method
                newAs.doDeclareRudderController(idController, idRudder);
            }
            //elevator
            if (newArray[1].equalsIgnoreCase("ELEVATOR")) {
                //DECLARE ELEVATOR CONTROLLER E1 WITH ELEVATORS E2 E3
                //Create idController, Left and Right Elevators
                Identifier idController = new Identifier(newArray[3]);
                Identifier idElevatorLeft = new Identifier(newArray[6]);
                Identifier idElevatorRight = new Identifier(newArray[7]);
                //call doDeclareElevatorController
                ActionStructural newAS = CommandParser.getAS();
                newAS.doDeclareElevatorController(idController, idElevatorLeft, idElevatorRight);

            }
            //aileron
            if (newArray[1].equalsIgnoreCase("AILERON")) {
                Identifier idControler = new Identifier(newArray[3]);
                List<Identifier> idAilerons = new ArrayList<Identifier>();
                Identifier adder = new Identifier(newArray[6]);
                idAilerons.add(adder);
                int i = 7;
                while (!newArray[i].equalsIgnoreCase("(PRIMARY)")) {
                    Identifier adder2 = new Identifier(newArray[i]);
                    idAilerons.add(adder);
                    i++;
                }
                Identifier idPrimary = new Identifier(newArray[i + 1]);
                i = i + 1;
                List<AileronSlaveMix> slaveMixes = new ArrayList<AileronSlaveMix>();
                Identifier idMaster = new Identifier(newArray[i + 2]);
                Identifier idSlave = new Identifier(newArray[i + 4]);
                Percent mix = new Percent(strToDouble(newArray[i + 6]));
                slaveMixes.add(new AileronSlaveMix(idMaster, idSlave, mix));
                ActionStructural newStructure = CommandParser.getAS();
                newStructure.doDeclareAileronController(idControler, idAilerons, idPrimary, slaveMixes);
            }
            // split flap
            if (newArray[1].equalsIgnoreCase("FLAP")) {
                Identifier idController = new Identifier(newArray[3]);
                List<Identifier> idFlaps = new ArrayList<Identifier>();
                idFlaps.add(new Identifier(newArray[6]));
                idFlaps.add(new Identifier(newArray[7]));
            /*
            for(int i = 6; i < newArray.length; i++){
                idFlaps.add(new Identifier(newArray[i]));
            }

             */
                ActionStructural newStructure = CommandParser.getAS();
                newStructure.doDeclareFlapController(idController, idFlaps);
            }
            //engine
            //DECLARE ENGINE CONTROLLER <id1> WITH ENGINE[S] <idn>+
            if (newArray[1].equalsIgnoreCase("ENGINE")) {
                Identifier idController = new Identifier(newArray[3]);
                List<Identifier> idEngine = new ArrayList<Identifier>();
                Identifier adder = new Identifier(newArray[6]);
                idEngine.add(adder);
                ActionStructural newStructure = CommandParser.getAS();
                newStructure.doDeclareEngineController(idController, idEngine);
            }
            //nose gear
            //DECLARE GEAR CONTROLLER <id1> WITH GEAR NOSE <id2> MAIN <id3> <id4>
            if (newArray[1].equalsIgnoreCase("NOSE") && newArray[2].equalsIgnoreCase("GEAR")) {
                Identifier idController = new Identifier(newArray[3]);
                Identifier idNose = new Identifier(newArray[7]);
                Identifier idMainLeft = new Identifier(newArray[9]);
                Identifier idMainRight = new Identifier(newArray[10]);
                ActionStructural newAS = CommandParser.getAS();
                newAS.doDeclareGearController(idController, idNose, idMainLeft, idMainRight);
            }

        }

    }
    private double strToDouble(String value) {
        return Double.parseDouble(value);
    }
}
