package com.example.bookstore.dto;

public class QueryBookVO {
    private final String author;
    private final String title;

    public QueryBookVO(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public boolean checkEmpty() {
        return this.author == null && this.title == null;
    }

    public String getAuthor() {
        return author == null ? "" : author;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }
}
