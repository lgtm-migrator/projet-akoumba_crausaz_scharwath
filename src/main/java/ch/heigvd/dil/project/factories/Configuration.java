package ch.heigvd.dil.project.factories;

import com.github.jknack.handlebars.TypeSafeTemplate;

public class Configuration {
    private String url;
    private String author;
    private String language;

    public Configuration(String url, String author, String language) {
        this.url = url;
        this.author = author;
        this.language = language;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
