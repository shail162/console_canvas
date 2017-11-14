package com.console.canvas.src.validator;

import com.console.canvas.src.Point;
import com.console.canvas.src.shapes.Rectangle;
import com.console.canvas.src.shapes.ShapeInterface;

public class CmdR extends Command{

    public String getName() {
        return "R";
    }

    public int execute(String[] parameters) {
        if (!this.validate(parameters)) {
            return -1;
        }
        Point p3 = new Point(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        Point p4 = new Point(Integer.parseInt(parameters[2]), Integer.parseInt(parameters[3]));
        ShapeInterface rectangle = new Rectangle(p3,p4);
        canvas.addShape(rectangle);
        canvas.printCanvas();
        return 0;
    }

    public boolean validateLength(String[] parameters) {
        if (parameters.length != RECTANGLE){
            System.out.println("Wrong parameters to draw rectangle, please check your command");
            return false;
        }
        return true;
    }
}
