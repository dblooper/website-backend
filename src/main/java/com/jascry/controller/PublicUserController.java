package com.jascry.controller;

import com.jascry.db_model.Author;
import com.jascry.exception.AuthorExistsException;
import com.jascry.exception.WrongPasswordException;
import com.jascry.mapping.dto.AuthorForCrudDto;
import com.jascry.repository.AuthorRepository;
import com.jascry.repository.UserRepository;
import com.jascry.security.UserAuthenticationService;
import com.jascry.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.jascry.db_model.User;

import java.util.ArrayList;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/public/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class PublicUserController {
    @Autowired
    UserAuthenticationService userAuthenticationService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorService authorService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    AuthorForCrudDto register(@RequestBody AuthorForCrudDto authorForCrudDto) throws AuthorExistsException {
            return authorService.saveAuthor(authorForCrudDto);
        }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    String login(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) throws UsernameNotFoundException, WrongPasswordException {
        return userAuthenticationService
                .login(username, password)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }
}
