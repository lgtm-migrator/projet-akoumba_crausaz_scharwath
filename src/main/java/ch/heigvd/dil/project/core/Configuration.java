package ch.heigvd.dil.project.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import okhttp3.HttpUrl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Configuration {
    private static final Logger LOG = Logger.getLogger(Configuration.class.getName());
    @JsonProperty("url")
    private String url;
    @JsonProperty("author")
    private String author;
    @JsonProperty("language")
    private String language;

    public Configuration() {
    }

    public Configuration(String url, String author, String language) {
        this.url = url;
        this.author = author;
        this.language = language;
    }

    public static Configuration defaultConfiguration() {
        return new Configuration("localhost:8080", "John Doe", "en");
    }

    public static Configuration getFromFile(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        return mapper.readValue(file, Configuration.class);
    }

    public String getUrl() {
        return url;
    }

    public URI getURI() {
        try {
            // regex optional scheme + host + optional port
            Pattern pattern = Pattern.compile("^(?:([a-zA-Z]+)://)?([^:/]+):?(\\d+)?$");
            Matcher matcher = pattern.matcher(url);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Invalid URL");
            }
            //build URI
            return new HttpUrl.Builder()
                    .scheme(matcher.group(1) != null ? matcher.group(1) : "http")
                    .host(matcher.group(2) != null ? matcher.group(2) : "localhost")
                    .port(matcher.group(3) != null ? Integer.parseInt(matcher.group(3)) : 80)
                    .build()
                    .uri();
        } catch (Exception e) {
            LOG.warning("Invalid URI: " + url);
            return null;
        }
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }
}
