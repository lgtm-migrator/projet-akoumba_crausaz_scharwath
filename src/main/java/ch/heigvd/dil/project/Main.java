package ch.heigvd.dil.project;

import ch.heigvd.dil.project.commands.*;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * Main entry point for the application
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
@Command(
        mixinStandardHelpOptions = true,
        name = "dil",
        description = "DIL project",
        versionProvider = ManifestVersionProvider.class,
        subcommands = {
            InitCommand.class,
            CleanCommand.class,
            BuildCommand.class,
            ServeCommand.class,
            PublishCommand.class
        })
public class Main {

    /**
     * Executes the wished command
     *
     * @param args command and args
     */
    public static void main(String[] args) {
        new CommandLine(new Main()).execute(args);
    }
}
