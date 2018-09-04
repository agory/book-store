package com.example.bookstore.facade;

import com.example.bookstore.dto.BookDetail;
import com.example.bookstore.dto.BookListItem;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.entities.Book;

import java.awt.print.Book;
import java.util.List;


public class BookFacade {
    BookRepository dao;

    List<BookListItem> getBookList() {
        List<Book> books = this.dao.findAll();
        return books.stream().map(book -> new BookListItem(book));
    }

    BookDetail getBookDetail(String isbn) {
        Book books = this.dao.findOne(isbn);
        return new BookDetail(book);
    }
}
