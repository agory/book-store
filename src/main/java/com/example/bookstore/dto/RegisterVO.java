package com.example.bookstore.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterVO {
    @Size(min = 4)
    private String username;
    @Size(min = 4)
    private String password;

    public RegisterVO() {
        super();
    }

    public RegisterVO(@NotNull String username, @NotNull String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
