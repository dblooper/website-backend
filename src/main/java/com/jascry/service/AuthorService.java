package com.jascry.service;

import com.jascry.db_model.Author;
import com.jascry.db_model.User;
import com.jascry.exception.AuthorExistsException;
import com.jascry.mapping.dto.AuthorForCrudDto;
import com.jascry.repository.AuthorRepository;
import com.jascry.security.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthorForCrudDto saveAuthor(AuthorForCrudDto authorForCrudDto) throws AuthorExistsException {
        if (authorRepository.findById(authorForCrudDto.getLogin()).isPresent()) {
            throw new AuthorExistsException("Login exists!");
        }

        Author newAuthor = new Author(
                authorForCrudDto.getLogin()
                ,passwordEncoder.encode(authorForCrudDto.getPassword())
                ,authorForCrudDto.getEmail()
                ,new ArrayList<>()
                ,new ArrayList<>()
                ,new ArrayList<>()
        );
        authorRepository.save(newAuthor);
        AuthorForCrudDto authorCreated = new AuthorForCrudDto(
            authorForCrudDto.getLogin()
            ,true
            ,login(authorForCrudDto.getLogin(), authorForCrudDto.getPassword())
        );
        newAuthor.setToken(authorCreated.getFirstToken());
        authorRepository.save(newAuthor);
        return authorCreated;
    }

    private String login(String username, String password) {
        return userAuthenticationService
                .login(username, password)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }
}
