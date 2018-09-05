package com.example.bookstore.controllers;

import com.example.bookstore.dto.BookDetailVO;
import com.example.bookstore.dto.BookShortVO;
import com.example.bookstore.facades.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookFacade bookFacade;

    @RequestMapping("/")
    public List<BookShortVO> retrieveAllBook(){
        return bookFacade.retrieveBookList();
    }

    @RequestMapping("/{isbn}")
    public BookDetailVO retrieveBookByIsbn(@PathVariable(value="isbn") String isbn){
        return bookFacade.retrieveBookDetail(isbn);
    }
}
