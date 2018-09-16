package com.example.bookstore.controllers;


import com.example.bookstore.dto.RegisterVO;
import com.example.bookstore.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RolesAllowed("ADMIN")
public class AuthController {

    @Autowired
    UserFacade userFacade;

    @PostMapping("/register")
    public void register(
            @RequestBody
            @Valid RegisterVO registerVO
    ) {
        this.userFacade.register(registerVO);
    }
}
