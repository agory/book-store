package com.example.bookstore.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super(ExceptionMessages.NotFound.toString());
    }
}
