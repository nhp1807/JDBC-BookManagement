package entity;

public class Book {
    private int id;
    private String title;
    private String category;
    private String author;
    private int quantity;
    private String published_date;

    public Book() {
    }

    public Book(int id, String title, String category, String author, int quantity, String published_date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.quantity = quantity;
        this.published_date = published_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                ", published_date='" + published_date + '\'' +
                '}';
    }
}
