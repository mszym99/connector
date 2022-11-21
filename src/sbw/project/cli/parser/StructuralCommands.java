package sbw.project.cli.parser;

import sbw.architecture.datatype.*;
import sbw.project.cli.action.ActionCreational;
import sbw.project.cli.action.ActionStructural;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StructuralCommands {
    public void structrualParse(String newArray[]){
        //if so then check if parseArray[1] is equal to one of the following commands
        //rudder
        if(newArray[1].equalsIgnoreCase("RUDDER")){
            //Create new identifier with id at array index 3
            Identifier idController = new Identifier(newArray[3]);
            //Create mew identifier
            Identifier idRudder = new Identifier(newArray[5]);
            ActionStructural newAs = CommandParser.getAS();
            //doDeclare method
            newAs.doDeclareRudderController(idController, idRudder);
        }
        //elevator
        if(newArray[1].equalsIgnoreCase("ELEVATOR")){

        }
        //aileron
        if(newArray[1].equalsIgnoreCase("AILERON")){
            Identifier idControler = new Identifier(newArray[3]);
            List<Identifier> idAilerons = new ArrayList<Identifier>();
            Identifier adder = new Identifier(newArray[6]);
            idAilerons.add(adder);
            int i = 7;
            while(!newArray[i].equalsIgnoreCase("(PRIMARY)")){
                Identifier adder2 = new Identifier(newArray[i]);
                idAilerons.add(adder);
                i++;
            }
            Identifier idPrimary = new Identifier(newArray[i+1]);
            i = i + 1;
            List<AileronSlaveMix> slaveMixes = new ArrayList<AileronSlaveMix>();
            Identifier idMaster = new Identifier(newArray[i + 2]);
            Identifier idSlave = new Identifier(newArray[i+4]);
            Percent mix = new Percent(strToDouble(newArray[i+6]));
            slaveMixes.add(new AileronSlaveMix(idMaster, idSlave, mix));
            ActionStructural newStructure = CommandParser.getAS();
            newStructure.doDeclareAileronController(idControler, idAilerons, idPrimary, slaveMixes);
        }
        // split flap
        if(newArray[1].equalsIgnoreCase("FLAP")){
            Identifier idController = new Identifier(newArray[3]);
            System.out.println(idController);
            List<Identifier> idFlaps = new ArrayList<Identifier>();
            for(int i = 6; i < newArray.length; i++){
                System.out.println(newArray[i]);
                idFlaps.add(new Identifier(newArray[i]));
            }
            ActionStructural newStructure = CommandParser.getAS();
            newStructure.doDeclareFlapController(idController, idFlaps);
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
