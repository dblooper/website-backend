package com.jascry.controller;

import com.jascry.db_model.Author;
import com.jascry.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/jascry/admin")
public class AdminController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping(path = "/users")
    public List<Author> getUsers() {
        return this.authorRepository.findAll();
    }

}
