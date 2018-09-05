package com.example.bookstore.facades;

import com.example.bookstore.dto.BookDetailVO;
import com.example.bookstore.dto.BookShortVO;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Component
public class BookFacade {


    BookRepository bookRepository;

    @Autowired
    public BookFacade(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookShortVO> retrieveBookList() {
        List<Book> books = this.bookRepository.findAll();
        return books.stream().map(BookShortVO::new).collect(toList());
    }

    public BookDetailVO retrieveBookDetail(String isbn) {
        Book book = this.bookRepository.findOne(isbn);
        return new BookDetailVO(book);
    }
}
