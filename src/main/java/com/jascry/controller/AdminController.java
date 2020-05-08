package com.jascry.controller;

import com.jascry.db_model.Author;
import com.jascry.exception.AuthorNotFoundException;
import com.jascry.exception.ContentSubjectNotFoundException;
import com.jascry.exception.PostDataNotProvidedException;
import com.jascry.mapping.PostMapper;
import com.jascry.mapping.dto.PostForCrudDto;
import com.jascry.repository.AuthorRepository;
import com.jascry.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/admin/blog")
public class AdminController {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PostService postService;

    @GetMapping(path = "/users")
    public List<Author> getUsers() {
        return this.authorRepository.findAll();
    }

    @PostMapping(path="/post")
    @ResponseStatus(HttpStatus.CREATED)
    PostForCrudDto addPost(@RequestBody PostForCrudDto postForCRUDDto) throws AuthorNotFoundException, ContentSubjectNotFoundException, PostDataNotProvidedException {
        return postService.savePostToDb(postForCRUDDto);
    }

    @PutMapping(path = "/post")
    PostForCrudDto updatePost(@RequestBody PostForCrudDto postForCRUDDto) throws PostDataNotProvidedException {
        return postService.updatePost(postForCRUDDto);
    }

}
