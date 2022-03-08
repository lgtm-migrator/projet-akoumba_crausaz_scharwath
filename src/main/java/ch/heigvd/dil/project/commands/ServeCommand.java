package ch.heigvd.dil.project.commands;

import picocli.CommandLine.Command;

/**
 * This class represents the command line interface for the serve command.
 */
@Command(
        name = "serve",
        description = "Serve sub-command",
        version = "1.0"
)
public class ServeCommand implements Runnable {
    @Override
    public void run() {
        System.out.println("Serve command is not implemented yet.");
    }
}
