package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.core.Configuration;
import ch.heigvd.dil.project.core.FilesManager.ResourcesUtils;
import ch.heigvd.dil.project.core.PageConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * This class represents the command line interface for the new command.
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
@Command(
        name = "init",
        description = "Initialize a new project with a default configuration and structure.",
        version = "1.0"
)
public class InitCommand extends BaseCommand {
    private static final Logger LOG = Logger.getLogger(InitCommand.class.getName());
    private final static String CONFIGURATION_FILE = "config.yml";
    private final static String INDEX_FILE = "index.md";
    private final static String EXAMPLE_PAGE_FOLDER = "page";
    @CommandLine.Parameters(
            index = "0",
            description = "Path to new site",
            defaultValue = "./my-super-site"
    )
    String creationPath;

    @Override
    protected String getRootPath() {
        return creationPath;
    }

    @Override
    public void execute() {
        Path pathToNewSite = Paths.get(creationPath);

        // Create main directories
        try {
            Files.createDirectories(pathToNewSite);
        } catch (IOException e) {
            LOG.severe("Error while creating directories: " + e.getMessage());
            return;
        }

        ObjectMapper om = new ObjectMapper(
                new YAMLFactory()
                        .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
        );
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Create configuration file
        try {
            om.writeValue(
                    new File(creationPath, CONFIGURATION_FILE),
                    Configuration.defaultConfiguration()
            );
        } catch (IOException e) {
            LOG.severe("Error while creating configuration file: " + e.getMessage());
            return;
        }

        // Create index page file and copy example page from resources
        try {
            FileWriter fw = new FileWriter(new File(creationPath, INDEX_FILE));
            fw.write(om.writeValueAsString(PageConfiguration.defaultConfiguration()));
            fw.write("\n---\n");
            fw.write(ResourcesUtils.getFileFromJarAsString("data/index.md"));
            fw.close();
        } catch (Exception e) {
            LOG.warning("Error while creating index page file: " + e.getMessage());
        }

        // Create example page from resources
        try {
            File examplePageFolderFile = new File(creationPath, EXAMPLE_PAGE_FOLDER);
            if (!examplePageFolderFile.mkdir()) throw new IOException("Error while creating example page folder");
            FileWriter fw2 = new FileWriter(new File(examplePageFolderFile, "page.md"));
            fw2.write(om.writeValueAsString(PageConfiguration.defaultConfiguration()));
            fw2.write("\n---\n");
            fw2.write(ResourcesUtils.getFileFromJarAsString("data/page.md"));
            fw2.close();
        } catch (Exception e) {
            LOG.warning("Error while creating example page: " + e.getMessage());
        }

        //copy photo.jpg
        try {
            ResourcesUtils.copyFromJar("data/photo.jpg", new File(creationPath, "photo.jpg").toPath());
        } catch (Exception e) {
            LOG.warning("Error while copying photo.jpg: " + e.getMessage());
        }

        // Create layouts
        try {
            var layoutsDist = new File(creationPath, "layouts");
            if (!layoutsDist.mkdir()) throw new IOException("Error while creating layouts folder");
            ResourcesUtils.copyFromJar("layouts", layoutsDist.toPath());
        } catch (Exception e) {
            LOG.warning("Error while creating layouts: " + e.getMessage());
        }
    }
}
