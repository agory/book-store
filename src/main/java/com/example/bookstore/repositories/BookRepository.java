package com.example.bookstore.repositories;

import com.example.bookstore.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends Repository<Book, String> {

    List<Book> findAllByOrderByPublishDateDesc();

    Book findByIsbn(String isbn);

    Book save(Book entity);

    void delete(Book book);

    /***
     * Query that return all book that match with title or author param
     * The case is ignored
     * Order by publish date
     * @param title
     * @param author
     * @return books
     */
    @Query("Select b " +
        "from Book b " +
        "where upper(b.authors) like concat('%', upper(:author), '%') " +
        "and upper(b.title) like concat('%', upper(:title), '%') " +
        "order by b.publishDate desc ")
    List<Book> findByTitleAndAuthor(
        @Param("title") String title,
        @Param("author") String author);
}
