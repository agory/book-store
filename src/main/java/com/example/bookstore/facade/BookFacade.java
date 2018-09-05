package com.example.bookstore.facade;

import com.example.bookstore.dto.BookDetail;
import com.example.bookstore.dto.BookShort;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class BookFacade {

    @Autowired
    BookRepository bookRepository;

    public List<BookShort> retrieveBookList() {
        List<Book> books = this.bookRepository.findAll();
        return books.stream().map(BookShort::new).collect(toList());
    }

    public BookDetail retrieveBookDetail(String isbn) {
        Book books = this.bookRepository.findOne(isbn);
        return new BookDetail(book);
    }
}
