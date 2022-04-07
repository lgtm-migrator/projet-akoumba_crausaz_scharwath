package ch.heigvd.dil.project.core.FilesManager;

/**
 * This class is used to build the header of the files.
 * And used with yaml header.
 */
class HeaderBuilder {
    private String title;
    private String author;
    private String date;

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

    /**
     * This method is used to build the header of the files.
     *
     * @return the header of the files without <head></head>
     */
    public String build() {
        return String.format(
                "<title>%s</title>\n"
                        + "<meta charset=\"UTF-8\">\n"
                        + "<meta name=\"author\" content=\"%s\">\n"
                        + "<meta name=\"date\" content=\"%s\">",
                title, author, date);
    }
}
