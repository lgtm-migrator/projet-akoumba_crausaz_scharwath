package ch.heigvd.dil.project.core.FilesManager;

import ch.heigvd.dil.project.core.App;
import ch.heigvd.dil.project.core.Configuration;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.util.Objects;

public class FTPPublisher {

    public static void publish(String sourceFolder) throws RuntimeException, IOException {

        // Check configuration
        Configuration config = App.getInstance().getRootConfig();

        assert config.getPublishUsername() != null : "Invalid publish configuration";
        assert config.getPublishProtocol() != null : "Invalid publish configuration";
        assert config.getPublishPassword() != null : "Invalid publish configuration";
        assert config.getPublishServer() != null : "Invalid publish configuration";

        // Try to connect
        FTPClient client = new FTPClient();

        client.connect(config.getPublishServer());
        int reply = client.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            client.disconnect();
            throw new RuntimeException("Error while connecting to FTP Server");
        }

        client.login(config.getPublishUsername(), config.getPublishPassword());

        // Upload folder content to destination

    }
}
