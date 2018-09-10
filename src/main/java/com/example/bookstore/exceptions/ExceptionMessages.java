package com.example.bookstore.exceptions;

public enum ExceptionMessages {
    NotFound("Element not found");

    private String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
