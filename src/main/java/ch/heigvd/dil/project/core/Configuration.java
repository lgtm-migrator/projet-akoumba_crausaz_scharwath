package ch.heigvd.dil.project.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;

/**
 * Defines a site configuration
 *
 * <p>A site configuration can be injected in templates and define global configuration
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public class Configuration {
    private static final Logger LOG = Logger.getLogger(Configuration.class.getName());

    private String title;

    private String url;

    private String language;

    private String publishDir;

    private String publishServer;

    private String publishUsername;

    private String publishPassword;

    /**
     * Creates an empty site configuration
     *
     * <p>Empty constructor is needed for YAML conversion
     */
    public Configuration() {}

    /**
     * Creates a site configuration
     *
     * @param url site url
     * @param language site language
     * @param title site title
     */
    public Configuration(String url, String language, String title) {
        this.url = url;
        this.language = language;
        this.title = title;
        this.publishDir = "/";
        this.publishServer = "";
        this.publishUsername = "";
        this.publishPassword = "";
    }

    /**
     * Get site url
     *
     * @return site url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Get site language
     *
     * @return site language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Get site title
     *
     * @return site title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the path of publish in the remote server
     *
     * @return path of publish
     */
    public String getPublishDir() {
        return publishDir;
    }

    /**
     * Get the username for publishing
     *
     * @return username
     */
    public String getPublishUsername() {
        return publishUsername;
    }

    /**
     * Get the password for publishing
     *
     * @return password
     */
    public String getPublishPassword() {
        return publishPassword;
    }

    /**
     * Get the destination publish server
     *
     * @return publish server
     */
    public String getPublishServer() {
        return publishServer;
    }

    @JsonIgnore
    public URI getURI() {
        try {
            // regex optional scheme + host + optional port
            Pattern pattern = Pattern.compile("^(?:([a-zA-Z]+)://)?([^:/]+):?(\\d+)?$");
            Matcher matcher = pattern.matcher(url);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Invalid URL");
            }
            // build URI
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

    public static Configuration getFromFile(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        return mapper.readValue(file, Configuration.class);
    }

    public static Configuration defaultConfiguration() {
        return new Configuration("localhost:8080", "en", "my nice website");
    }
}
