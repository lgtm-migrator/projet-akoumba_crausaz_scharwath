package ch.heigvd.dil.project.core.FilesManager;

import ch.heigvd.dil.project.core.Configuration;
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

public class FileManager {

    /**
     * Creates a folder hierarchy from path
     *
     * @param path path of folder
     */
    public static Path createDirectoryStructure(String path) throws IOException {
        Path pathToFolder = Paths.get(path);
        Files.createDirectories(pathToFolder);
        return pathToFolder;
    }

    public static void generateConfigurationFile(String path, String filename, Configuration config) throws IOException {
        if (config == null) {
            config = Configuration.defaultConfiguration();
        }

        ObjectMapper om =
                new ObjectMapper(
                        new YAMLFactory()
                                .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.writeValue(
                new File(path, filename),
                config);

    }

    public static File writeToFile(String path, String filename, String content) throws IOException {
        File file = new File(path, filename);
        FileWriter fw = new FileWriter(file);
        fw.write(content);
        fw.close();
        return file;
    }
}
