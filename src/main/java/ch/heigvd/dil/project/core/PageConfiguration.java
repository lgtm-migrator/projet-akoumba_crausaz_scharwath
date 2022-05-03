package ch.heigvd.dil.project.core;

public class PageConfiguration {
    private String title;

    private String author;

    private String date;

    public PageConfiguration() {}

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

    public static PageConfiguration defaultConfiguration() {
        return new PageConfiguration("Title page", "My author", "2022-02-02");
    }
}
