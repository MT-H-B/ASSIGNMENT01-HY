package ch06.date03.numberSeven;

public class Book {

    public String author;
    public String isbn;
    public int price;
    public String title;

    public Book(){}

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
