package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.core.Configuration;
import ch.heigvd.dil.project.core.FilesManager.ResourcesUtils;
import ch.heigvd.dil.project.core.PageConfiguration;
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
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/** This class represents the command line interface for the new command. */
@Command(name = "init", description = "Init ", version = "1.0")
public class InitCommand extends BaseCommand {
    private static final Logger LOG = Logger.getLogger(InitCommand.class.getName());

    @CommandLine.Parameters(
            index = "0",
            description = "Path to new site",
            defaultValue = "./newsite")
    String creationPath;

    String configurationFile = "config.yml";
    String indexFile = "index.md";
    String examplePageFolder = "page";

    public void run() {
        super.run(creationPath);
        Path pathToNewSite = Paths.get(creationPath);

        try {
            // Create main directories
            Files.createDirectories(pathToNewSite);

            // Create configuration file
            ObjectMapper om =
                    new ObjectMapper(
                            new YAMLFactory()
                                    .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
            om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            om.writeValue(
                    new File(creationPath, configurationFile),
                    Configuration.defaultConfiguration());

            // Create index page file
            FileWriter fw = new FileWriter(new File(creationPath, indexFile));
            fw.write(om.writeValueAsString(PageConfiguration.defaultConfiguration()));
            fw.write("\n---\n");
            fw.write(ResourcesUtils.getFileFromJarAsString("data/index.md"));
            fw.close();

            // Create example
            File examplePageFolderFile = new File(creationPath, examplePageFolder);
            if (examplePageFolderFile.mkdir()) {
                FileWriter fw2 = new FileWriter(new File(examplePageFolderFile, "page.md"));
                fw2.write(om.writeValueAsString(PageConfiguration.defaultConfiguration()));
                fw2.write("\n---\n");
                fw2.write(ResourcesUtils.getFileFromJarAsString("data/page.md"));
                fw2.close();
            } else {
                LOG.warning("Could not create example page");
            }

            //copy photo.jpg
            ResourcesUtils.copyFromJar("data/photo.jpg", new File(creationPath, "photo.jpg").toPath());

            // Create layouts
            var layoutsDist = new File(creationPath, "layouts");
            if (layoutsDist.mkdir()) {
                ResourcesUtils.copyFromJar("layouts", layoutsDist.toPath());
            }
        } catch (Exception e) {
            LOG.warning("Could not create site");
            e.printStackTrace();
        }
    }
}
