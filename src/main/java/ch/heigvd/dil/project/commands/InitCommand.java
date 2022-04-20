package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.core.FilesManager.FileManager;
import ch.heigvd.dil.project.core.PageParams;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
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
            PageParams params = PageParams.defaultPageParams();

            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            om.writeValue(new File(creationPath, indexFile), params);

            FileManager.writeToFile(
                    creationPath, indexFile, "# This is the homepage content", true);

            // Create example page (subdirectory)
            FileManager.createDirectoryStructure(creationPath + examplePageFolder);

            om.writeValue(new File(creationPath + examplePageFolder, "page.md"), params);
            FileManager.writeToFile(
                    creationPath + examplePageFolder,
                    "page.md",
                    "# This is the page content",
                    true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
