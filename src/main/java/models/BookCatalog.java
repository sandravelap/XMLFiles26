package models;

import java.util.ArrayList;

public class BookCatalog {
    private String bookshopName;
    private ArrayList<Book> books;

    public BookCatalog() {
    }
    public String getBookshopName() {
        return bookshopName;
    }

    public void setBookshopName(String bookshopName) {
        this.bookshopName = bookshopName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
