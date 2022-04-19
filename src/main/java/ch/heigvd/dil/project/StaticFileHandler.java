package ch.heigvd.dil.project;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

@SuppressWarnings("restriction")
public class StaticFileHandler implements HttpHandler {

    private final String baseDir;

    public StaticFileHandler(String baseDir) {
        this.baseDir = baseDir;
    }

    @Override
    public void handle(HttpExchange ex) throws IOException {
        URI uri = ex.getRequestURI();
        String path = uri.getPath();
        if (path.equals("/")) {
            path = "/index.html";
        }
        File file = new File(baseDir, path.substring(1));
        BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        if (basicFileAttributes.isRegularFile()) {
            Headers h = ex.getResponseHeaders();
            h.set("Content-Type", Files.probeContentType(file.toPath()));
            ex.sendResponseHeaders(200, basicFileAttributes.size());
            OutputStream os = ex.getResponseBody();
            Files.copy(file.toPath(), os);
            os.close();
        } else {
            ex.sendResponseHeaders(404, -1);
        }
    }

}