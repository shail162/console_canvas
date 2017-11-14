package com.console.canvas.src.validator;

import com.console.canvas.src.Point;
import com.console.canvas.src.shapes.Line;
import com.console.canvas.src.shapes.ShapeInterface;

public class CmdL extends Command{

    public String getName() {
        return "L";
    }

    public int execute(String[] parameters) {
        if (!this.validate(parameters)) {
            return -1;
        }

        Point p1 = new Point(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        Point p2 = new Point(Integer.parseInt(parameters[2]), Integer.parseInt(parameters[3]));
        ShapeInterface line = new Line(p1, p2);
        canvas.addShape(line);
        canvas.printCanvas();
        return 0;
    }

    public boolean validateLength(String[] parameters) {
        if (parameters.length != LINE){
            System.out.println("Wrong parameters to draw line, please check your command");
            return false;
        }
        return true;
    }
}
