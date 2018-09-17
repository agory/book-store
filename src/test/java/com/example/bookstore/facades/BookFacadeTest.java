package com.example.bookstore.facades;

import com.example.bookstore.dto.BookDetailVO;
import com.example.bookstore.dto.BookShortVO;
import com.example.bookstore.dto.BookUpdateVO;
import com.example.bookstore.dto.QueryBookVO;
import com.example.bookstore.entities.Book;
import com.example.bookstore.exceptions.ExceptionMessages;
import com.example.bookstore.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class BookFacadeTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookFacade bookFacade;

    private Book book;

    private List<Book> books;

    @Before
    public void setup() {
        this.book = new Book("C123456789012", "title", "authors", "publisher", "Images", "Book description");
        this.books = new ArrayList<>();

        books.add(new Book("A123456789012", "title", "authors", "publisher", "Image", "Book description"));
        books.add(new Book("B123456789012", "title", "authors", "publisher", "Image", "Book description"));
        books.add(new Book("C123456789012", "title", "authors", "publisher", "Image", "Book description"));
    }

    @Test
    public void retrieveBookList_shouldReturnAListOfBookShort_givenEmptyQueryBook() {
        // given
        QueryBookVO queryBookVO = Mockito.mock(QueryBookVO.class);
        Mockito.when(queryBookVO.checkEmpty()).thenReturn(true);
        Mockito.when(bookRepository.findAllByOrderByPublishDateDesc()).thenReturn(books);

        // when
        List<BookShortVO> booksRetrieved = this.bookFacade.retrieveBookList(queryBookVO);

        // then
        Mockito.verify(bookRepository).findAllByOrderByPublishDateDesc();
        Mockito.verify(queryBookVO).checkEmpty();
        assertThat(booksRetrieved)
            .hasSize(books.size())
            .extracting(book -> tuple(book.getTitle(), book.getImage()))
            .contains(tuple("title", "Image"));
    }

    @Test
    public void retrieveBookList_shouldReturnAListOfBookShort_givenNotEmptyQueryBook() {
        // given
        final String title = "title";
        final String author = "author";
        QueryBookVO queryBookVO = Mockito.mock(QueryBookVO.class);
        Mockito.when(queryBookVO.checkEmpty()).thenReturn(false);
        Mockito.when(queryBookVO.getAuthor()).thenReturn(author);
        Mockito.when(queryBookVO.getTitle()).thenReturn(title);
        Mockito.when(bookRepository.findByTitleAndAuthor(title, author)).thenReturn(books);

        // when
        List<BookShortVO> booksRetrieved = this.bookFacade.retrieveBookList(queryBookVO);

        // then
        Mockito.verify(bookRepository).findByTitleAndAuthor(title, author);
        Mockito.verify(queryBookVO).checkEmpty();
        Mockito.verify(queryBookVO).getTitle();
        Mockito.verify(queryBookVO).getAuthor();
        assertThat(booksRetrieved)
            .hasSize(books.size())
            .extracting(book -> tuple(book.getTitle(), book.getImage()))
            .contains(tuple("title", "Image"));
    }

    @Test
    public void retrieveBookDetail_shouldReturnABookDetail_whenIsbnIsGiven() {
        // given
        String isbn = "C123456789012";
        Mockito.when(this.bookRepository.findByIsbn(isbn)).thenReturn(book);

        // when
        BookDetailVO result = this.bookFacade.retrieveBookDetail(isbn);

        // then
        assertThat(result.getIsbn()).isEqualTo(book.getIsbn());
        Mockito.verify(bookRepository).findByIsbn(isbn);
    }

    @Test
    public void retrieveBookDetail_shouldThrowError_whenUnknownIsbnIsGiven() {
        // given
        String isbn = "C123456789012";
        Mockito.when(bookRepository.findByIsbn(isbn)).thenReturn(null);
        // When
        assertThatThrownBy(() -> this.bookFacade.retrieveBookDetail(isbn))

            // Then
            .hasMessage(ExceptionMessages.NotFound.toString());
        Mockito.verify(bookRepository).findByIsbn(isbn);
    }

    @Test
    public void updateBook_shouldUpdateDescriptionAndImage_whenAIsbnAndABookIsGiven() {
        // given
        BookUpdateVO update = new BookUpdateVO("New Images", "New Description");
        String isbn = "C123456789012";
        Book bookUpdated = new Book("C123456789012", "title", "authors", "publisher", update.getImage(), update.getDescription());
        Mockito.when(bookRepository.findByIsbn(isbn)).thenReturn(book);
        Mockito.when(bookRepository.save(book)).thenReturn(bookUpdated);

        // when
        BookDetailVO result = this.bookFacade.updateImageAndDescription(isbn, update);

        // then
        assertThat(result.getIsbn()).isEqualTo(book.getIsbn());
        assertThat(result.getImage()).isEqualTo(update.getImage());
        assertThat(result.getDescription()).isEqualTo(book.getDescription());
        Mockito.verify(bookRepository).findByIsbn(isbn);
        Mockito.verify(bookRepository).save(book);
    }

    @Test
    public void updateBook_shouldThrowError_whenAUnknownIsbnAndABookIsGiven() {
        // given

        BookUpdateVO update = new BookUpdateVO("New Images", "New Description");
        String isbn = "C123456789012";
        Mockito.when(bookRepository.findByIsbn(isbn)).thenReturn(null);

        // When
        assertThatThrownBy(() -> this.bookFacade.updateImageAndDescription(isbn, update))

            // Then
            .hasMessage(ExceptionMessages.NotFound.toString());
        Mockito.verify(bookRepository).findByIsbn(isbn);

    }

    @Test
    public void deleteBook_shouldRunWithoutError_whenIsbnIsGiven() {
        // Given
        String isbn = "C123456789012";
        Mockito.when(bookRepository.findByIsbn(isbn)).thenReturn(book);
        Mockito.doNothing().when(bookRepository).delete(book);

        // When
        bookFacade.deleteBook(isbn);

        // then
        Mockito.verify(bookRepository).findByIsbn(isbn);
        Mockito.verify(bookRepository).delete(book);
    }

    @Test
    public void deleteBook_shouldThrowError_whenUnknownIsbnIsGiven() {
        // Given
        String isbn = "C123456789012";
        Mockito.when(bookRepository.findByIsbn(isbn)).thenReturn(null);

        // When
        assertThatThrownBy(() -> this.bookFacade.deleteBook(isbn))

            // Then
            .hasMessage(ExceptionMessages.NotFound.toString());
        Mockito.verify(bookRepository).findByIsbn(isbn);
    }
}
