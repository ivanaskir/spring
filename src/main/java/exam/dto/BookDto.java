package exam.dto;

public class BookDto {

    private String title;
    private String author;
    private String description;
    private int published;

    protected BookDto(){}

    public BookDto(String title, String author, String description, int published) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.published = published;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }
}





