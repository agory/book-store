package com.example.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Book {

    @Id
    @NotEmpty
    private String isbn;

    @NotEmpty
    private String title;

    @NotEmpty
    private String authors;

    private String publisher;

    private String image;

    private String description;


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
