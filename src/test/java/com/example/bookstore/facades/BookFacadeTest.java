package com.example.bookstore.facades;

import com.example.bookstore.dto.BookDetailVO;
import com.example.bookstore.dto.BookShortVO;
import com.example.bookstore.entities.Book;
import com.example.bookstore.repositories.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class BookFacadeTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookFacade bookFacade;

    @Test
    public void retrieveBookList_shouldReturnAListOfBookShort() {
        // given
        List<Book> books = new ArrayList<>();

        books.add(new Book("A123456789012", "title", "authors", "publisher", "Image", "Book description"));
        books.add(new Book("B123456789012", "title", "authors", "publisher", "Image", "Book description"));
        books.add(new Book("C123456789012", "title", "authors", "publisher", "Image", "Book description"));
        Mockito.when(bookRepository.findAll()).thenReturn(books);

        // when
        List<BookShortVO> booksRetrieved = this.bookFacade.retrieveBookList();

        // then
        assertThat(booksRetrieved)
                .hasSize(books.size())
                .extracting( book -> tuple(book.getTitle(), book.getImage()))
                .contains(tuple("title", "Image"));
    }

    @Test
    public void retrieveBookDetail_shouldReturnABookDetail_whenIsbnIsGiven() {
        // given
        String isbn = "C123456789012";
        Book book = new Book("C123456789012", "title", "authors", "publisher", "Images", "Book description");
        Mockito.when(bookRepository.findByIsbn(isbn)).thenReturn(book);

        // when
        BookDetailVO result = this.bookFacade.retrieveBookDetail(isbn);

        // then
        assertThat(result.getIsbn()).isEqualTo(book.getIsbn());
    }
}