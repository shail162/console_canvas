/*
 * Canvas class
 */
package com.console.canvas.src;

import com.console.canvas.src.shapes.ShapeInterface;

import java.util.ArrayList;
import java.util.List;

public class Canvas {

    private int height;
    private int width;
    private List<ShapeInterface> shapes;

    /**
     * For the canvas borders, we add two columns and two rows
     *
     * @param width  int
     * @param height int
     */
    public Canvas(int width, int height) {
        this.height = height + 2;
        this.width = width + 2;
        this.shapes = new ArrayList<ShapeInterface>();
        this.canvasByteArray = new byte[this.height][this.width];
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private byte[][] canvasByteArray = new byte[height][width];

    public boolean addShape(ShapeInterface shapeInterface) {
        return shapes.add(shapeInterface);
    }

    /**
     * Method to render the canvas in the console
     */
    public void printCanvas() {

        // create borders.
        for (int row = 0; row < canvasByteArray.length; row++) {
            for (int col = 0; col < canvasByteArray[row].length; col++) {
                if (row == 0 || row == canvasByteArray.length - 1) {
                    canvasByteArray[row][col] = '-';
                } else if (col == 0 || col == canvasByteArray[row].length - 1) {
                    canvasByteArray[row][col] = '|';
                } else {
                    canvasByteArray[row][col] = ' ';
                }
            }
        }

        // append shapes one by one.
        for (ShapeInterface shapeInterface : shapes) {
            canvasByteArray = shapeInterface.draw(canvasByteArray);
        }

        // print to console.
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print((char) canvasByteArray[i][j]);
            }
            System.out.println();
        }
    }
}

/**
 *
 * String n_squares(int n) {
 StringBuffer s = new StringBuffer("0");
 int n_squared = n*n;
 for (int i=0; i<n_squared; i++) {
 s.append (", " + i);
 }
 return s.toString();
 }
 */