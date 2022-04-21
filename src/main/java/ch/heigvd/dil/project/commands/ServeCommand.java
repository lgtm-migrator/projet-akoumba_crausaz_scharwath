package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.StaticFileHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/** This class represents the command line interface for the serve command. */
@Command(
        name = "serve",
        description = "Serve sub-command",
        version = "1.0",
        mixinStandardHelpOptions = true)
public class ServeCommand implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Path to site", defaultValue = "./newsite")
    String websitePath;

    @CommandLine.Option(
            names = {"-p", "--port"},
            description = "Port to listen on",
            defaultValue = "8080")
    int port;

    @Override
    public void run() {
        try {
            var server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/", new StaticFileHandler(websitePath));
            server.setExecutor(null); // creates a default executor
            server.start();
            System.out.println("Server started on port " + port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
