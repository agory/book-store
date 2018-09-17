package com.example.bookstore.controllers;

import com.example.bookstore.dto.BookDetailVO;
import com.example.bookstore.dto.BookShortVO;
import com.example.bookstore.dto.BookUpdateVO;
import com.example.bookstore.dto.QueryBookVO;
import com.example.bookstore.facades.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookFacade bookFacade;

    /***
     * return all book or return a list of book who match author or title set in the RequestParam
     * @param author
     * @param title
     * @return books
     */
    @GetMapping("/")
    public List<BookShortVO> retrieveAllBook(
        @RequestParam(value = "author", required = false)
            String author,
        @RequestParam(value = "title", required = false)
            String title
    ) {
        QueryBookVO queryBookVO = new QueryBookVO(author, title);
        return bookFacade.retrieveBookList(queryBookVO);
    }

    @GetMapping("/{isbn}")
    public BookDetailVO retrieveBookByIsbn(
        @PathVariable(value = "isbn")
        @NotNull String isbn
    ) {
        return bookFacade.retrieveBookDetail(isbn);
    }

    @PutMapping("/{isbn}")
    @RolesAllowed("ADMIN")
    public BookDetailVO updateBook(
        @PathVariable(value = "isbn")
        @NotNull String isbn,
        @RequestBody
        @Valid BookUpdateVO book
    ) {
        return bookFacade.updateImageAndDescription(isbn, book);
    }

    @DeleteMapping("/{isbn}")
    @RolesAllowed("ADMIN")
    public void deleteBook(
        @PathVariable(value = "isbn")
        @NotNull String isbn
    ) {
        bookFacade.deleteBook(isbn);
    }

}
