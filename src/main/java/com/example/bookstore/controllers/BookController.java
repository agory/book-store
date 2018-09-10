package com.example.bookstore.controllers;

import com.example.bookstore.dto.BookDetailVO;
import com.example.bookstore.dto.BookShortVO;
import com.example.bookstore.dto.BookUpdateVO;
import com.example.bookstore.facades.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookFacade bookFacade;

    @GetMapping("/")
    public List<BookShortVO> retrieveAllBook(){
        return bookFacade.retrieveBookList();
    }

    @GetMapping("/{isbn}")
    public BookDetailVO retrieveBookByIsbn(
            @PathVariable(value="isbn")
            @NotNull String isbn
    ){
        return bookFacade.retrieveBookDetail(isbn);
    }

    @PutMapping("/{isbn}")
    public BookDetailVO updateImageAndDescription(
            @PathVariable(value="isbn")
            @NotNull String isbn,
            @RequestBody
            @Valid BookUpdateVO book
    ) {
        return bookFacade.updateImageAndDescription(isbn,book);
    }
}
