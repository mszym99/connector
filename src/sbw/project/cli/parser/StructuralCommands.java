package sbw.project.cli.parser;

public class StructuralCommands {
    public void structrualParse(String newArray[]){
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
