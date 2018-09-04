package com.example.bookstore.dto;

import com.example.bookstore.entities.Book;

public class BookListItem {

    BookListItem(Book book) {
        this.title = book.getTitle();
        this.image = book.getImage();
    }

    String title;

    String image;
}
