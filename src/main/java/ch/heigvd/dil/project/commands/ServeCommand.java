package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.StaticFileHandler;
import ch.heigvd.dil.project.core.App;
import ch.heigvd.dil.project.core.FilesManager.Server;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * This class represents the command line interface for the serve command.
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
@Command(
        name = "serve",
        description = "Starts the server on the specified port for the specified project.",
        version = "1.0",
        mixinStandardHelpOptions = true)
public class ServeCommand extends BaseCommand {
    private static final Logger LOG = Logger.getLogger(ServeCommand.class.getName());
    private static final int DEFAULT_PORT = 8080;

    @CommandLine.Parameters(index = "0", description = "Path to site", defaultValue = "./newsite")
    String websitePath;

    @CommandLine.Option(
            names = {"-p", "--port"},
            description = "Port to listen on",
            defaultValue = "-1")
    int port;

    @Override
    protected String getRootPath() {
        return websitePath;
    }

    @Override
    public void execute() {
        URI url = App.getInstance().getRootConfig().getURI();
        int configPort = url.getPort();
        if (port == -1) { // If no port is specified, use the one from the config
            // If no port is specified, use the default one
            port = configPort == -1 ? DEFAULT_PORT : configPort;
        }

        try {
            Server srv = new Server(port, websitePath);
            srv.start();

            LOG.info(String.format("Server started on port %d", port));
            LOG.info(String.format("Open %s in your browser", url));

        } catch (IOException e) {
            LOG.severe(String.format("Could not start server on port %d", port));
            throw new RuntimeException(e);
        }
    }
}
