package com.example.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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

    public Book(String isbn, String title, String authors, String publisher, String image, String description) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.image = image;
        this.description = description;
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

}
