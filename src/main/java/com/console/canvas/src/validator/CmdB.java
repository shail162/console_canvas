package com.console.canvas.src.validator;

import com.console.canvas.src.Point;
import com.console.canvas.src.shapes.Fill;
import com.console.canvas.src.shapes.ShapeInterface;

public class CmdB extends Command{


    public String getName() {
        return "B";
    }

    public int execute(String[] parameters) {
        if (!this.validate(parameters)) {
            return -1;
        }
        Point p = new Point(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        ShapeInterface fill = new Fill(p, (byte)parameters[2].charAt(0));
        canvas.addShape(fill);
        canvas.printCanvas();
        return 0;
    }

    public boolean validateLength(String[] parameters) {
        if (parameters.length != FILL){
            System.out.println("Wrong parameters to Fill canvas, please check your command");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateTypes(String[] parameters) {
        for (int i = 0; i < parameters.length-1; i++) {
            if (!isInteger(parameters[i])) {
                System.out.println("Parameter (" + parameters[i] + ") is not and integer");
                return false;
            }
        }
        return true;
    }

}
