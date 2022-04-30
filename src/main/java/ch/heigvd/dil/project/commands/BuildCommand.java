package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.core.FilesManager.TreeBuilder;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import picocli.CommandLine;
import picocli.CommandLine.Command;

/** This class represents the command line interface for the build command. */
@Command(name = "build", description = "Build sub-command", version = "1.0")
public class BuildCommand implements Runnable {
    private static final Logger LOG = Logger.getLogger(BuildCommand.class.getName());
    @CommandLine.Parameters(index = "0", description = "Path to the site to build")
    String creationPath;

    @Override
    public void run() {
        // Check if the source projet exists
        var srcDir = new File(creationPath);
        var destDir = new File(srcDir, "build");
        if (!srcDir.exists()){
            LOG.severe("The source directory does not exist");
            return;
        }

        // Build the site into build folder
        var treeBuilder = new TreeBuilder(srcDir, destDir);
        try {
            treeBuilder.build();
        } catch (IOException e) {
            LOG.severe("An error occurred while building the site");
            LOG.severe(e.getMessage());
            e.printStackTrace();
        }
    }
}
