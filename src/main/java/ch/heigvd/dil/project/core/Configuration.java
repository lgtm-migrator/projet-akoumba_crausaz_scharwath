package ch.heigvd.dil.project.core;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

public class Configuration {
    private static final Logger LOG = Logger.getLogger(Configuration.class.getName());
    private String url;
    private String author;
    private String language;

    public Configuration(String url, String author, String language) {
        this.url = url;
        this.author = author;
        this.language = language;
    }

    public static Configuration defaultConfiguration() {
        return new Configuration("localhost:8080", "John Doe", "en");
    }

    public static Configuration getFromFile(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, Configuration.class);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public URI getURI() {
        try {
            return new URI(url);
        } catch (Exception e) {
            LOG.warning("Invalid URI: " + url);
            return null;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}