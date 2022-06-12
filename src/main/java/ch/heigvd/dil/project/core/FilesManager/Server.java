package ch.heigvd.dil.project.core.FilesManager;

import ch.heigvd.dil.project.StaticFileHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;

/** Class that represent a local static files server */
public class Server {

    private final HttpServer server;

    /**
     * Creates a new static files server
     *
     * @param port port to make the server reachable
     * @param pathToServe directory to serve
     * @throws IOException if server creation failed
     */
    public Server(int port, String pathToServe) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        // Add the static file handler to the server
        server.createContext("/", new StaticFileHandler(Path.of(pathToServe, "build")));
        server.setExecutor(null); // creates a default executor
    }

    /** Start the server */
    public void start() {
        server.start();
    }
}
