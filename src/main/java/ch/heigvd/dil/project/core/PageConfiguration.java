package ch.heigvd.dil.project.core;

/**
 * Defines a page configuration
 *
 * <p>A page configuration can be injected in templates and define a header structure for page
 * files.
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public class PageConfiguration {
    private String title;

    private String author;

    private String date;

    /**
     * Creates an empty page configuration
     *
     * <p>Empty constructor is needed for YAML conversion
     */
    public PageConfiguration() {}

    /**
     * Creates a page configuration
     *
     * @param title page title
     * @param author page author
     * @param date page date
     */
    public PageConfiguration(String title, String author, String date) {
        this.title = title;
        this.author = author;
        this.date = date;
    }

    /**
     * Get the page title
     *
     * @return page title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the page author
     *
     * @return page author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Get the page publication date
     *
     * @return page publication date
     */
    public String getDate() {
        return date;
    }

    /**
     * Get a sample configuration
     *
     * @return default sample configuration
     */
    public static PageConfiguration defaultConfiguration() {
        return new PageConfiguration("Title page", "My author", "2022-02-02");
    }
}
