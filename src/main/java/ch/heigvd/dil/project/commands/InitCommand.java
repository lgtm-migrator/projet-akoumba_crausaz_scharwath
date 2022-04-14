package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.core.FilesManager.FileManager;
import java.io.IOException;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/** This class represents the command line interface for the new command. */
@Command(name = "init", description = "Init ", version = "1.0")
public class InitCommand implements Runnable {

    @CommandLine.Parameters(
            index = "0",
            description = "Path to new site",
            defaultValue = "./newsite")
    String creationPath;

    String configurationFile = "config.yml";
    String indexFile = "index.md";
    String examplePageFolder = "/page";

    @CommandLine.Parameters(index = "1", description = "Skip user interaction", defaultValue = "")
    String shouldSkip;

    @Override
    public void run() {
        try {
            // Create main directories
            FileManager.createDirectoryStructure(creationPath);

            // Create configuration file
            FileManager.generateConfigurationFile(creationPath, configurationFile, null);

            // Create index page file
            FileManager.writeToFile(creationPath, indexFile, "# This is the homepage content");

            // Create example page (subdirectory)
            FileManager.createDirectoryStructure(creationPath + examplePageFolder);
            FileManager.writeToFile(
                    creationPath + examplePageFolder, "page.md", "# This is the page content");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
