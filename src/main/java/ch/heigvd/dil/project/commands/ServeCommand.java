package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.StaticFileHandler;
import ch.heigvd.dil.project.core.App;
import com.sun.net.httpserver.HttpServer;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.logging.Logger;

/** This class represents the command line interface for the serve command. */
@Command(
        name = "serve",
        description = "Serve sub-command",
        version = "1.0",
        mixinStandardHelpOptions = true)
public class ServeCommand extends BaseCommand {
    private static final Logger LOG = Logger.getLogger(ServeCommand.class.getName());

    @CommandLine.Parameters(index = "0", description = "Path to site", defaultValue = "./newsite")
    String websitePath;

    @CommandLine.Option(
            names = {"-p", "--port"},
            description = "Port to listen on",
            defaultValue = "-1"
    )
    int port;

    public void run() {
        super.run(websitePath);
        try {
            int configPort = App.getInstance().getRootConfig().getURI().getPort();
            LOG.info("Configured port: " + App.getInstance().getRootConfig().getURI().toString());
            if (port == -1) {
                port = configPort == -1 ? 8080 : configPort;
            }
            var server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/", new StaticFileHandler(Path.of(websitePath, "build")));
            server.setExecutor(null); // creates a default executor
            server.start();
            LOG.info(String.format("Server started on port %d", port));
        } catch (IOException e) {
            LOG.severe(String.format("Could not start server on port %d", port));
            throw new RuntimeException(e);
        }
    }
}
