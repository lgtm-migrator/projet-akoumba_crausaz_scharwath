package ch.heigvd.dil.project.core;

public class PageConfiguration {
    private final String title;

    private final String author;

    private final String date;

    public PageConfiguration(String title, String author, String date) {
        this.title = title;
        this.author = author;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }
}
