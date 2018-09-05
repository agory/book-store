package com.example.bookstore.dto;

import com.example.bookstore.entities.Book;

import java.io.Serializable;

public class BookDetailVO implements Serializable {

    final String isbn;
    final String title;
    final String authors;
    final String publisher;
    final String image;
    final String description;

    public BookDetailVO(Book book) {
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.authors = book.getAuthors();
        this.publisher = book.getPublisher();
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
}
