package com.jascry.controller;

import com.jascry.db_model.ContentSubject;
import com.jascry.exception.AuthorNotFoundException;
import com.jascry.exception.ContentSubjectNotFoundException;
import com.jascry.exception.PostNameNotProvidedException;
import com.jascry.mapping.PostMapper;
import com.jascry.mapping.dto.ContentSubjectDto;
import com.jascry.mapping.dto.PostForCRUDDto;
import com.jascry.repository.PostRepository;
import com.jascry.service.ContentSubjectService;
import com.jascry.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class UserController {
    @Autowired
    private ContentSubjectService contentSubjectService;

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository post;

    @Autowired
    private PostMapper postMapper;

    @GetMapping(path= "/subjects")
    public List<ContentSubjectDto> fetchBlogSubjects(@RequestParam(name = "postQty") Byte postQty) {
        return contentSubjectService.getContentSubjectDtoList(postQty);
    }

    @GetMapping(path = "/subject")
    public ContentSubjectDto fetchBlogSubjectWithPosts(@RequestParam(name = "name") String subjectName) {
        return contentSubjectService.getContentSubjectWithPosts(subjectName);
    }

    @PostMapping(path="/post")
    @ResponseStatus(HttpStatus.CREATED)
    PostForCRUDDto addPost(@RequestBody PostForCRUDDto postForCRUDDto) throws AuthorNotFoundException, ContentSubjectNotFoundException, PostNameNotProvidedException {
            return postService.savePostToDb(postForCRUDDto);
    }

    @GetMapping(path = "/posts")
    List<PostForCRUDDto> getPosts(@RequestParam String subject, @RequestParam Byte limit) {
        return postMapper.mapPostToPostForCrudDtoList(post.getLastPostsBySubject(new ContentSubject(subject,"",new ArrayList<>())
                                                                                ,PageRequest.of(0, limit)
                                                                                ));
    }
}
