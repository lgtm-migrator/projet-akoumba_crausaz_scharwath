package ch.heigvd.dil.project.core.FilesManager;

import ch.heigvd.dil.project.core.App;
import ch.heigvd.dil.project.core.Configuration;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class FTPPublisher {

    public static void publish(String sourceFolder) throws RuntimeException, IOException {

        // Check configuration
        Configuration config = App.getInstance().getRootConfig();

        assert config.getPublishUsername() != null : "Invalid publish configuration";
        assert config.getPublishPassword() != null : "Invalid publish configuration";
        assert config.getPublishServer() != null : "Invalid publish configuration";

        // Try to connect
        FTPClient client = new FTPClient();

        client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

        client.connect(config.getPublishServer());
        int reply = client.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            client.disconnect();
            throw new RuntimeException("Error while connecting to FTP Server");
        }

        client.login(config.getPublishUsername(), config.getPublishPassword());
        client.setFileType(FTP.BINARY_FILE_TYPE);

        String publishPath = config.getPublishDir() != null ? config.getPublishDir() : "/";

        // Upload folder content to destination
        Files.walkFileTree(
                Path.of(sourceFolder),
                new SimpleFileVisitor<>() {
                    private void uploadFile(Path path) throws IOException {
                        String file = new File(sourceFolder).toURI().relativize(new File(String.valueOf(path)).toURI()).getPath();
                        // TODO: Create file if has structure of folder
                        // System.out.println(file);
                        // client.makeDirectory(Path.of(file.getParent()));
                        try (InputStream in = new FileInputStream(sourceFolder + "/" + file)) {
                            client.storeFile(publishPath + file, in);
                        }
                    }

                    private void visit(Path path, BasicFileAttributes attrs) throws IOException {
                        System.out.println(attrs);
                        uploadFile(path);
                    }

                    @Override
                    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                        visit(path, attrs);
                        return FileVisitResult.CONTINUE;
                    }
                });

        client.logout();
        client.disconnect();
    }
}
