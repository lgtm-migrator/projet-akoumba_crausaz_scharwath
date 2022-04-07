package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.core.FilesManager.TreeBuilder;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.File;
import java.io.IOException;

/**
 * This class represents the command line interface for the build command.
 */
@Command(name = "build", description = "Build sub-command", version = "1.0")
public class BuildCommand implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Path to the site to build")
    String creationPath;

    @Override
    public void run() {
        // Check if the source projet exists
        var srcDir = new File(creationPath);
        var destDir = new File(srcDir.getParent(), "build");
        if (!srcDir.exists()) return;

        // Build the site into build folder
        var treeBuilder = new TreeBuilder(srcDir, destDir);
        treeBuilder.build();
    }
}
