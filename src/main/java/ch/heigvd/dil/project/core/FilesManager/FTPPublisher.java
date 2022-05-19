package ch.heigvd.dil.project.core.FilesManager;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPPublisher {

    FTPClient client;

    public FTPPublisher() {
        client = new FTPClient();
    }
}
