package com.example.bookstore.dto;

import com.example.bookstore.entities.Book;

public class BookDetail {

    public BookDetail(Book book) {
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.authors = book.getAuthors();
        this.publisher = book.getPublisher();
        this.image = book.getImage();
        this.description = book.getDescription();
    }

    String isbn;

    String title;

    String authors;

    String publisher;

    String image;

    String description;
}
