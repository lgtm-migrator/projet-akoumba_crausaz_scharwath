package ch.heigvd.dil.project.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * This class represents the command line interface for the new command.
 */
@Command(
        name = "init",
        description = "Init ",
        version = "1.0"
)
public class InitCommand implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Path to new site", defaultValue = "./")
    String creationPath;

    String configurationFile = "config.yml";
    String indexFile = "index.md";

    @CommandLine.Parameters(index = "1", description = "Ship user interaction", defaultValue = "")
    String shouldSkip;

    public class Configuration {
        public String url;
        public String author;
        public String language;
    }

    @Override
    public void run() {

        Path pathToNewSite = Paths.get(creationPath);

        // Creates directory
        try {
            Files.createDirectory(pathToNewSite);

            // Creates configuration files
            Configuration config = new Configuration();
            config.author = "Nicolas Crausaz";
            config.url = "localhost";
            config.language = "fr";

            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            // om.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
            om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            om.writeValue(new File(creationPath + "/" + indexFile), config);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean shouldSkipUserInteraction () {
        return Objects.equals(shouldSkip, "--skip");
    }
}
