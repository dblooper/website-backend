package com.jascry.service;

import com.jascry.db_model.Author;
import com.jascry.exception.AuthorExistsException;
import com.jascry.mapping.dto.AuthorForCrudDto;
import com.jascry.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public boolean saveAuthor(AuthorForCrudDto authorForCrudDto) throws AuthorExistsException {
        if (authorRepository.findById(authorForCrudDto.getLogin()).isPresent()) {
            throw new AuthorExistsException("Login exists!");
        }
        authorRepository.save(new Author(
                authorForCrudDto.getLogin()
                ,authorForCrudDto.getPassword() //TODO - write an encryption
                ,authorForCrudDto.getEmail()
                ,new ArrayList<>()
                ,new ArrayList<>()
                ,new ArrayList<>()
        ));
        return true;
    }
}
