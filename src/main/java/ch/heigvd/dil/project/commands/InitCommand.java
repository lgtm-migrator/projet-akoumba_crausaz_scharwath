package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.factories.SiteStructureFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Path pathToNewSite = Paths.get(creationPath);

        try {
            // Create main directories
            Files.createDirectories(pathToNewSite);

            // Create configuration file
            SiteStructureFactory cf = new SiteStructureFactory();
            ObjectMapper om =
                    new ObjectMapper(
                            new YAMLFactory()
                                    .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
            om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            om.writeValue(
                    new File(creationPath + "/" + configurationFile),
                    cf.generateBaseConfiguration());

            // Create index page file
            FileWriter fw = new FileWriter(creationPath + "/" + indexFile);
            fw.write("# This is the homepage content");
            fw.close();

            // Create example
            Files.createDirectory(Paths.get(creationPath + "/" + examplePageFolder));
            FileWriter fw2 = new FileWriter(creationPath + "/" + examplePageFolder + "/page.md");
            fw2.write("# This is the page content");
            fw2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
