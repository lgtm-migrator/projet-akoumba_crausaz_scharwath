package ch.heigvd.dil.project.commands;

import picocli.CommandLine;

/**
 * This class represents the command line interface for the publish command.
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
@CommandLine.Command(
        name = "publish",
        description = "Publish builded files to a remove server",
        version = "1.0",
        mixinStandardHelpOptions = true)
public class PublishCommand extends BaseCommand {
    @CommandLine.Parameters(index = "0", description = "Path to the site to publish")
    String creationPath;

    @Override
    protected String getRootPath() {
        return creationPath;
    }

    @Override
    protected void execute() {

    }
}
