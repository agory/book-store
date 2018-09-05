package com.example.bookstore.dto;

import com.example.bookstore.entities.Book;

import java.io.Serializable;

public class BookShortVO implements Serializable {

    final String title;
    final String image;

    public BookShortVO(Book book) {
        this.title = book.getTitle();
        this.image = book.getImage();
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
