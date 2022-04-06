package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.FilesManager.TreeBuilder;
import java.io.File;
import java.io.IOException;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/** This class represents the command line interface for the build command. */
@Command(name = "build", description = "Build sub-command", version = "1.0")
public class BuildCommand implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Path to the site to build")
    String creationPath;

    @Override
    public void run() {
        // Check if the source projet exists
        if (!new File(creationPath).exists()) return;

        // Build the site into build folder
        var treeBuilder =
                new TreeBuilder(new File(creationPath), new File(creationPath + "/build"));
        try {
            treeBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
