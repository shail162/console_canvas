package test.java.com.console.canvas;

import com.console.canvas.src.factory.CommandFactory;
import com.console.canvas.src.Canvas;
import com.console.canvas.src.validator.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest
        extends TestCase {

    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testCommandC() {
        CommandFactory commandFactory = new CommandFactory();
        Command cmd = commandFactory.getCommand('C');

        assertTrue(cmd instanceof CmdC);
        String[] parameters1 = {"10", "5"};
        String[] parameters2 = {"10", "5", "4"};
        String[] parameters3 = {"10", "f"};
        assertTrue(cmd.execute(parameters2) == -1);
        assertTrue(cmd.execute(parameters3) == -1);
        assertTrue(cmd.execute(null) == -1);
        assertTrue(cmd.execute(parameters1) == 0);
    }

    public void testCommandL() {
        Canvas canvas;
        CommandFactory commandFactory = new CommandFactory();
        Command cmdC = commandFactory.getCommand('C');
        Command cmdL = commandFactory.getCommand('L');

        assertTrue(cmdC instanceof CmdC);
        assertTrue(cmdL instanceof CmdL);
        String[] parametersC = {"20", "4"};
        String[] parametersL1 = {"1", "2", "6", "2"}; // correct parameters
        String[] parametersL2 = {"1", "2", "6", "2", "2"};
        String[] parametersL3 = {"1", "2", "6", "L"};
        String[] parametersL4 = {"1", "2", "6"};
        String[] parametersL5 = {"6", "3", "6", "4"}; // correct parameters

        assertTrue(cmdL.execute(parametersL1) == -1);
        cmdC.execute(parametersC);
        canvas = cmdC.getCanvas();
        cmdL.setCanvas(canvas);
        assertTrue(cmdL.execute(parametersL2) == -1);
        assertTrue(cmdL.execute(parametersL3) == -1);
        assertTrue(cmdL.execute(parametersL4) == -1);
        assertTrue(cmdL.execute(parametersL1) == 0);
        assertTrue(cmdL.execute(parametersL5) == 0);
    }

    public void testCommandR() {
        Canvas canvas;
        CommandFactory commandFactory = new CommandFactory();
        Command cmdC = commandFactory.getCommand('C');
        Command cmdL = commandFactory.getCommand('R');

        assertTrue(cmdC instanceof CmdC);
        assertTrue(cmdL instanceof CmdR);
        String[] parametersC = {"20", "4"};
        String[] parametersR1 = {"16", "1", "20", "3"}; // correct parameters
        String[] parametersR2 = {"16", "1", "20", "3", "2"};
        String[] parametersR3 = {"16", "1", "20", "L"};
        String[] parametersR4 = {"16", "1", "20"};

        assertTrue(cmdL.execute(parametersR1) == -1);
        cmdC.execute(parametersC);
        canvas = cmdC.getCanvas();
        cmdL.setCanvas(canvas);
        assertTrue(cmdL.execute(parametersR2) == -1);
        assertTrue(cmdL.execute(parametersR3) == -1);
        assertTrue(cmdL.execute(parametersR4) == -1);

        assertTrue(cmdL.execute(parametersR1) == 0);
    }

    public void testCommandB() {
        Canvas canvas;
        CommandFactory commandFactory = new CommandFactory();
        Command cmdC = commandFactory.getCommand('C');
        Command cmdB = commandFactory.getCommand('B');

        assertTrue(cmdC instanceof CmdC);
        assertTrue(cmdB instanceof CmdB);
        String[] parametersC = {"20", "4"};
        String[] parametersB1 = {"10", "3", "O"}; // correct parameters
        String[] parametersB2 = {"10", "3", "O", "2"};
        String[] parametersB3 = {"10", "B", "O"};
        String[] parametersB4 = {"10", "3"};

        assertTrue(cmdB.execute(parametersB1) == -1);
        cmdC.execute(parametersC);
        canvas = cmdC.getCanvas();
        cmdB.setCanvas(canvas);
        assertTrue(cmdB.execute(parametersB2) == -1);
        assertTrue(cmdB.execute(parametersB3) == -1);
        assertTrue(cmdB.execute(parametersB4) == -1);
        assertTrue( cmdB.execute(parametersB1) == 0);
    }

    public void testApp() {
        Canvas canvas;
        CommandFactory commandFactory = new CommandFactory();
        Command cmd = commandFactory.getCommand('C');

        assertTrue(cmd instanceof CmdC);

        String[] parametersC = {"20", "4"};
        String[] parametersL1 = {"1", "2", "6", "2"};
        String[] parametersL2 = {"6", "3", "6", "4"};
        String[] parametersR = {"16", "1", "20", "3"};
        String[] parametersB = {"10", "3", "o"};

        // create
        assertTrue(cmd.execute(parametersC) == 0);
        canvas = cmd.getCanvas();

        // line
        cmd = commandFactory.getCommand('L');
        assertTrue(cmd instanceof CmdL);
        cmd.setCanvas(canvas);
        assertTrue(cmd.execute(parametersL1) == 0);
        assertTrue(cmd.execute(parametersL2) == 0);

        // rectangle
        cmd = commandFactory.getCommand('R');
        assertTrue(cmd instanceof CmdR);
        cmd.setCanvas(canvas);
        assertTrue(cmd.execute(parametersR) == 0);

        // bucket fill
        cmd = commandFactory.getCommand('B');
        assertTrue(cmd instanceof CmdB);
        cmd.setCanvas(canvas);
        assertTrue(cmd.execute(parametersB) == 0);
    }
}
