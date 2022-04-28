package ch.heigvd.dil.project;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Logger;

@SuppressWarnings("restriction")
public class StaticFileHandler implements HttpHandler {
    private static Logger LOG = Logger.getLogger(StaticFileHandler.class.getName());
    private final Path baseDir;

    public StaticFileHandler(Path baseDir) {
        this.baseDir = baseDir;
    }

    @Override
    public void handle(HttpExchange ex) throws IOException {
        URI uri = ex.getRequestURI();
        String path = uri.getPath();
        Path file = Path.of(baseDir.toString(), path);
        if (Files.isDirectory(file)) {
            file = file.resolve("index.html");
        }
        if (!Files.exists(file)) {
            LOG.warning("File " + file.toAbsolutePath() + " does not exist");
            ex.sendResponseHeaders(404, -1);
            return;
        }
        BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
        if (attrs.isDirectory()) {
            ex.sendResponseHeaders(403, -1);
            return;
        }
        Headers headers = ex.getResponseHeaders();
        headers.add("Content-Type", Files.probeContentType(file));
        headers.add("Content-Length", Long.toString(attrs.size()));
        ex.sendResponseHeaders(200, 0);
        try (OutputStream os = ex.getResponseBody()) {
            Files.copy(file, os);
        }catch (IOException e) {
            LOG.warning("Error while serving file " + file);
            ex.sendResponseHeaders(500, -1);
        }
    }
}
