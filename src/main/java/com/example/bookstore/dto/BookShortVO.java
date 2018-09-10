package com.example.bookstore.dto;

import com.example.bookstore.entities.Book;

import java.io.Serializable;

public class BookShortVO implements Serializable {

    private final String isbn;
    private final String title;
    private final String image;

    public BookShortVO(Book book) {
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.image = book.getImage();
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getIsbn() {
        return isbn;
    }
}
