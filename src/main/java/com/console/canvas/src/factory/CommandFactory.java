package com.console.canvas.src.factory;

import com.console.canvas.src.validator.*;

/**
 * Factory design pattern
 */
public class CommandFactory {
    public Command getCommand(Character cmd) {
        if(cmd == null){
            return null;
        }

        if (cmd.equals('C')){
            return new CmdC();
        } else if (cmd.equals('L')){
            return new CmdL();
        } else if (cmd.equals('R')){
            return new CmdR();
        } else if (cmd.equals('B')){
            return new CmdB();
        }  else if (cmd.equals('Q')){
            return new CmdQ();
        }
        return null;
    }
}
