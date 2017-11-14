package com.console.canvas;

import com.console.canvas.src.factory.CommandFactory;
import com.console.canvas.src.Canvas;
import com.console.canvas.src.validator.Command;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Canvas - Console
 */
public class App 
{
    private static final String availableCmd = "CLRBQ";

    public static void main( String[] args )
    {
        Canvas canvas= null;
        printMenu();
        Scanner console = new Scanner(System.in);

        while (Boolean.TRUE){
            String userInput = console.nextLine().trim();

            if (!userInput.equals("")){
                String[] splitCmd = userInput.split(" ");
                Character cmd = splitCmd[0].charAt(0);
                String[] parameters = Arrays.copyOfRange(splitCmd,1, splitCmd.length);

                CommandFactory commandFactory = new CommandFactory();
                Command command;
                // check if the command exists
                if (availableCmd.indexOf(cmd) > -1) {
                    switch (cmd){
                        case 'C':
                            // command Create
                            command = commandFactory.getCommand(cmd);
                            command.execute(parameters);
                            canvas = command.getCanvas();
                            break;
                        case 'L' :
                            // command Line
                            command = commandFactory.getCommand(cmd);
                            command.setCanvas(canvas);
                            command.execute(parameters);
                            break;
                        case 'R' :
                            // command Rectangle
                            command = commandFactory.getCommand(cmd);
                            command.setCanvas(canvas);
                            command.execute(parameters);
                            break;
                        case 'B' :
                            // command bucket fill
                            command = commandFactory.getCommand(cmd);
                            command.setCanvas(canvas);
                            command.execute(parameters);
                            break;
                        case 'Q' :
                            // command exit
                            command = commandFactory.getCommand(cmd);
                            command.execute(parameters);
                            break;
                    }
                } else {
                    System.out.println("WRONG COMMAND TRY AGAIN");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("0) C w h          to create a convas ");
        System.out.println("1) L x1 y1 x2 y2  to draw a line     ");
        System.out.println("2) R x1 y1 x2 y2  to draw rectangle  ");
        System.out.println("3) B x1 y1 color  to refill          ");
        System.out.println("******************************************");
        System.out.println(" 3) Q              to Exit            ");
    }
}
