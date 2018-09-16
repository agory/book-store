package com.example.bookstore.dto;

import com.example.bookstore.entities.Book;

import java.io.Serializable;
import java.util.Date;

public class BookDetailVO implements Serializable {

    private final String isbn;
    private final String title;
    private final String authors;
    private final String publisher;
    private final String image;
    private final String description;
    private final Date publishDate;

    public BookDetailVO(Book book) {
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.authors = book.getAuthors();
        this.publisher = book.getPublisher();
        this.image = book.getImage();
        this.description = book.getDescription();
        this.publishDate = book.getPublishDate();
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
