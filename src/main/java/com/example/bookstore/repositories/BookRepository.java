package com.example.bookstore.repositories;

import com.example.bookstore.entities.Book;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookRepository extends Repository<Book, String> {

    List<Book> findAll();

    Book findByIsbn(String isbn);

    Book save(Book entity);
}