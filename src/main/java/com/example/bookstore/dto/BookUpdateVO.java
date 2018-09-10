package com.example.bookstore.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class BookUpdateVO implements Serializable {
    @NotNull
    private String image;

    @NotNull
    private String description;

    public BookUpdateVO() {
        super();
    }

    public BookUpdateVO(@NotNull String image, @NotNull String description) {
        this();
        this.image = image;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

}
