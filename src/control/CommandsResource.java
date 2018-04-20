package control;

import command.*;

/**
 * All commands injected and assembled in a set order in one place.
 *
 * @author Muhammad Diallo Thomas - muhammaddiallo.thomas@gmail.com
 */
public class CommandsResource {

    /**
     * Order of commands is crucial for array index references.
     *
     * @return array of Commands in set order
     */
    public Command[] getCommands() {

        Command[] commands = {new Command0(), new Command1(),
            new Command2(), new Command3(), new Command4(), new Command5(),
            new Command6(), new Command7(), new Command8(), new Command9(),
            new CommandAdd(), new CommandClear(), new CommandDecimal(),
            new CommandDivide(), new CommandMemAdd(), new CommandMemSubtract(),
            new CommandMemRecall(), new CommandSubtract(), new CommandMultiply(),
            new CommandSolve(), new CommandMemClear(), new CommandCubed(),
            new CommandOpenPara(), new CommandClosePara()};

        return commands;
    }

}
