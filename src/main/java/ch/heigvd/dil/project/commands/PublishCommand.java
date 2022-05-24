package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.core.FilesManager.FTPPublisher;
import java.io.File;
import java.util.logging.Logger;
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
    String buildPath;

    private static final Logger LOG = Logger.getLogger(PublishCommand.class.getName());

    @Override
    protected String getRootPath() {
        return buildPath;
    }

    @Override
    protected void execute() {
        if (!new File(buildPath, "build").exists()) {
            LOG.severe("No build folder found, skipping publish");
            return;
        }

        try {
            FTPPublisher.publish(buildPath + "/build");
        } catch (Exception e) {
            LOG.severe(e.toString());
        }
    }
}
