package com.example.bookstore.facades;

import com.example.bookstore.dto.BookDetailVO;
import com.example.bookstore.dto.BookShortVO;
import com.example.bookstore.dto.BookUpdateVO;
import com.example.bookstore.exceptions.NotFoundException;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Component
public class BookFacade {

    @Autowired
    private BookRepository bookRepository;

    public List<BookShortVO> retrieveBookList() {
        List<Book> books = this.bookRepository.findAll();
        return books.stream().map(BookShortVO::new).collect(toList());
    }

    public BookDetailVO retrieveBookDetail(String isbn) {
        Book book = this.bookRepository.findByIsbn(isbn);
        if (book == null) throw new NotFoundException();
        return new BookDetailVO(book);
    }

    public BookDetailVO updateImageAndDescription(String isbn, BookUpdateVO bookUpdateVO) {
        Book book = this.bookRepository.findByIsbn(isbn);
        if (book == null) throw new NotFoundException();
        book.updateImageAndDescription(bookUpdateVO);
        Book bookUpdated = this.bookRepository.save(book);
        return new BookDetailVO(bookUpdated);
    }
}
