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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class BookFacadeTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    @Autowired
    BookFacade bookFacade;

    @Test
    public void retrieveBookList_shouldReturnAListOfBookShort() {
        // given
        List<Book> data = new ArrayList<>();
        data.add(new Book("A123456789012","title","authors","publisher", "Images", "Book description"));
        data.add(new Book("B123456789012","title","authors","publisher", "Images", "Book description"));
        data.add(new Book("C123456789012","title","authors","publisher", "Images", "Book description"));
        // when
        Mockito.when(bookRepository.findAll()).thenReturn(data);
        List<BookShortVO> books = this.bookFacade.retrieveBookList();
        // then
        assertEquals(books.size(),data.size());
        assertEquals(books.get(1).getTitle(),data.get(1).getTitle());
        assertEquals(books.get(1).getImage(),data.get(1).getImage());
    }

    @Test
    public void retrieveBookDetail_shouldReturnABookDetail_whenIsbnIsGiven() {
        // given
        String isbn = "C123456789012";
        Book book =new Book("C123456789012","title","authors","publisher", "Images", "Book description");
        // when
        Mockito.when(bookRepository.findOne(isbn)).thenReturn(book);
        BookDetailVO result = this.bookFacade.retrieveBookDetail(isbn);
        // then
        assertEquals(result.getIsbn(),book.getIsbn());
    }
}