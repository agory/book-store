package com.example.bookstore.entities;

import com.example.bookstore.dto.BookUpdateVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Book {

    @Id
    @NotNull
    private String isbn;

    @NotNull
    private String title;

    @NotNull
    private String authors;

    private String publisher;

    private String image;

    private String description;

    private Date publishDate;

    public Book() {
        super();
    }

    public Book(String isbn, String title, String authors, String publisher, String image, String description) {
        this(isbn,title,authors,publisher,image,description,null);
    }

    public Book(@NotNull String isbn, @NotNull String title, @NotNull String authors, String publisher, String image, String description, Date publish_date) {
        this();
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.image = image;
        this.description = description;
        this.publishDate = publish_date;
    }

    public void updateImageAndDescription(BookUpdateVO book) {
        this.image = book.getImage();
        this.description = book.getDescription();
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublishDate() {
        return publishDate;
    }
}
