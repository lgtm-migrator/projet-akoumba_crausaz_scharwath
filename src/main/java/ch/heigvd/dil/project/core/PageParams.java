package ch.heigvd.dil.project.core;

public class PageParams {

    private String title;

    private String author;

    private String date;


    public PageParams(String title, String author, String date) {
        this.title = title;
        this.author = author;
        this.date = date;
    }

    public static PageParams defaultPageParams() {
        return new PageParams("", "", "");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
