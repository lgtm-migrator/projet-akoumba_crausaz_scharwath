package ch.heigvd.dil.project.commands;

import picocli.CommandLine.Command;

/**
 * This class represents the command line interface for the new command.
 */
@Command(
        name = "new",
        description = "New sub-command",
        version = "1.0"
)
public class NewCommand implements Runnable {
    @Override
    public void run() {
        System.out.println("New command is not implemented yet.");
    }
}
