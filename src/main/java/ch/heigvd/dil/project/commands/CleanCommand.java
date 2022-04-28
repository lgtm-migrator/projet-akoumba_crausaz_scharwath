package ch.heigvd.dil.project.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/** This class represents the command line interface for the clean command. */
@Command(name = "clean", description = "Clean sub-command", version = "1.0")
public class CleanCommand implements Runnable {
    static private final Logger LOG = Logger.getLogger(CleanCommand.class.getName());

    @CommandLine.Parameters(index = "0", description = "Path to project to clean")
    String deletionPath;

    @Override
    public void run() {

        // If no build folder, skip command
        if (!new File(deletionPath,"build").exists()){
            LOG.severe("No build folder found, skipping clean command");
            return;
        }

        // If we find no configuration file in the folder, we assume that this is not a statique
        // folder
        // so we do not delete it to avoid problems with other programs.
        if (!new File(deletionPath,"config.yml").exists()){
            LOG.severe("No configuration file found or it is not a valid project, skipping clean command");
            return;
        }

        // Folder deletion
        try {
            FileUtils.deleteDirectory(new File(deletionPath, "build"));
        } catch (IOException e) {
            LOG.severe("Error while deleting build folder");
            LOG.severe(e.getMessage());
            e.printStackTrace();
        }
    }
}
