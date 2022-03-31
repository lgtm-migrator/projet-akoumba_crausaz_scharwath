package ch.heigvd.dil.project.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    @CommandLine.Parameters(index = "0")
    String creationPath;

    String configurationFile = "config.yml";
    String indexFile = "index.md";

    public class Configuration {
        String url;
        String author;
        String language;
    }

    @Override
    public void run() {

        // if (Objects.equals(creationPath, "__skip"));

        Path pathToNewSite = Paths.get(creationPath);

        // Creates directory

        if (!Files.exists(pathToNewSite)) {
            try {
                Files.createDirectory(pathToNewSite);

                // Creates configuration files
                Configuration config = new Configuration();
                config.author = "Nicolas Crausaz";
                config.url = "localhost";
                config.language = "fr";

                ObjectMapper om = new ObjectMapper(new YAMLFactory());
                om.writeValue(new File(creationPath + indexFile), configuration);




            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(creationPath);
    }
}
