package models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement(name="catalogo_libros")
public class BookCatalog {
    private String bookshopName;
    private ArrayList<Book> books;

    public BookCatalog() {
    }
    @XmlElement(name="libreria")
    public String getBookshopName() {
        return bookshopName;
    }

    public void setBookshopName(String bookshopName) {
        this.bookshopName = bookshopName;
    }

    @XmlElementWrapper(name="libros")
    @XmlElement(name="libro")
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
