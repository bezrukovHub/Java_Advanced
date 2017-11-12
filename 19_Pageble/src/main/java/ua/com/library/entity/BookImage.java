package ua.com.library.entity;

import javax.persistence.*;

/**
 * Created by admin on 23.12.2016.
 */
@Entity
public class BookImage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;

    @ManyToOne
    private Book book;

    public BookImage() {
    }


    public BookImage(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
