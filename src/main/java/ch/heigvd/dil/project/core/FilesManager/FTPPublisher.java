package ch.heigvd.dil.project.core.FilesManager;

import ch.heigvd.dil.project.core.App;
import ch.heigvd.dil.project.core.Configuration;
import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * Utility class for FTP operations
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public class FTPPublisher {

    /**
     * Publish a folder content to a remote FTP server
     *
     * <p>Will ignore empty folders
     *
     * @param sourceFolder folder which content will be published
     * @throws IOException If connection or publish failed
     */
    public static void publish(String sourceFolder) throws IOException {

        // Check configuration
        Configuration config = App.getInstance().getRootConfig();

        assert config.getPublishUsername() != null : "Invalid publish configuration";
        assert config.getPublishPassword() != null : "Invalid publish configuration";
        assert config.getPublishServer() != null : "Invalid publish configuration";

        // Try to connect
        FTPClient client = new FTPClient();

        client.connect(config.getPublishServer());
        int reply = client.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            client.disconnect();
            throw new IOException("Error while connecting to FTP Server");
        }

        client.login(config.getPublishUsername(), config.getPublishPassword());
        client.setFileType(FTP.BINARY_FILE_TYPE);

        String publishPath = config.getPublishDir() != null ? config.getPublishDir() : "/";

        // Upload folder content to destination
        Files.walkFileTree(
                Path.of(sourceFolder),
                new SimpleFileVisitor<>() {
                    private void uploadFile(Path path) throws IOException {
                        String file =
                                new File(sourceFolder)
                                        .toURI()
                                        .relativize(new File(String.valueOf(path)).toURI())
                                        .getPath();

                        createDirectoryStructure(FilenameUtils.getPath(file), client);

                        try (InputStream in = new FileInputStream(sourceFolder + "/" + file)) {
                            client.storeFile(publishPath + file, in);
                        }
                    }

                    private void visit(Path path, BasicFileAttributes attrs) throws IOException {
                        System.out.println(attrs);
                        uploadFile(path);
                    }

                    @Override
                    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs)
                            throws IOException {
                        visit(path, attrs);
                        return FileVisitResult.CONTINUE;
                    }
                });

        client.logout();
        client.disconnect();
    }

    /**
     * Created a hierachy of folders on a remote FTP server
     *
     * @param dirsPath Path of folders
     * @param client FTP client
     * @throws IOException If error while creating the folders
     */
    private static void createDirectoryStructure(String dirsPath, FTPClient client)
            throws IOException {
        String[] directories = dirsPath.split("/");
        if (directories.length == 0) return;

        client.changeWorkingDirectory("/");

        for (String dir : directories) {
            if (!dir.isEmpty()) {
                if (!client.changeWorkingDirectory(dir)) {
                    if (!client.makeDirectory(dir)) {
                        throw new IOException("Unable to create remote directory");
                    }
                    if (!client.changeWorkingDirectory(dir)) {
                        throw new IOException(
                                "Unable to change into newly created remote directory");
                    }
                }
            }
        }
    }
}
