package com.example.bookstore.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="role", schema = "public")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @NotNull
    private String name;

    public Role() {
        super();
    }

    public Role(@NotNull Long id, @NotNull String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
