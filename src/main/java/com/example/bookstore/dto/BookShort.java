package com.example.bookstore.dto;

import com.example.bookstore.entities.Book;

public class BookShort {

    String title;
    String image;

    public BookShort(Book book) {
        this.title = book.getTitle();
        this.image = book.getImage();
    }

}
