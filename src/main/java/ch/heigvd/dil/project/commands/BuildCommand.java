package ch.heigvd.dil.project.commands;

import picocli.CommandLine.Command;

/**
 * This class represents the command line interface for the build command.
 */
@Command(
        name = "build",
        description = "Build sub-command",
        version = "1.0"
)
public class BuildCommand implements Runnable {
    @Override
    public void run() {
        System.out.println("Build command is not implemented yet.");
    }
}
