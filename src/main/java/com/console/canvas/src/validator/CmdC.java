package com.console.canvas.src.validator;

import com.console.canvas.src.Canvas;

public class CmdC extends Command {

    public String getName() {
        return "C";
    }

    public int execute(String[] parameters) {
        if (!this.validate(parameters)) {
            return -1;
        }

        super.canvas = new Canvas(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        canvas.printCanvas();
        return 0;
    }

    public boolean validateLength(String[] parameters) {
        if (parameters.length != CREATE) {
            System.out.println("Wrong parameters to create the canvas, please check your command");
            return false;
        }
        return true;
    }

    @Override
    public boolean validate(String[] parameters) {
        // check if it's null to avoid NullPointerException
        try {
            return validateParams(parameters) && validateLength(parameters) && validateTypes(parameters);
        } catch (NullPointerException e) {
            return false;
//        }
        }
    }
}