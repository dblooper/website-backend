package com.jascry.controller;

import com.jascry.db_model.ContentSubject;
import com.jascry.exception.AuthorNotFoundException;
import com.jascry.exception.ContentSubjectNotFoundException;
import com.jascry.exception.PostDataNotProvidedException;
import com.jascry.mapping.CommentMapper;
import com.jascry.mapping.PostMapper;
import com.jascry.mapping.dto.CommentForCrudDto;
import com.jascry.mapping.dto.ContentSubjectDto;
import com.jascry.mapping.dto.PostForCrudDto;
import com.jascry.repository.PostRepository;
import com.jascry.service.CommentService;
import com.jascry.service.ContentSubjectService;
import com.jascry.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/blog")
public class PublicBlogController {
    @Autowired
    private ContentSubjectService contentSubjectService;

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository post;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    CommentService commentService;

    @GetMapping(path= "/subjects")
    public List<ContentSubjectDto> fetchBlogSubjects(@RequestParam(name = "postQty") Byte postQty) {
        return contentSubjectService.getContentSubjectDtoList(postQty);
    }

    @GetMapping(path = "/subject")
    ContentSubjectDto fetchBlogSubjectWithPosts(@RequestParam(name = "name") String subjectName) {
        return contentSubjectService.getContentSubjectWithPosts(subjectName);
    }

    @GetMapping(path = "/posts")
    List<PostForCrudDto> getPosts(@RequestParam String subject, @RequestParam(required = false) Byte limit) {
        return postMapper.mapPostToPostForCrudDtoList(post.getLastPostsBySubject(new ContentSubject(subject,"",new ArrayList<>())
                                                                                ,PageRequest.of(0, Optional.ofNullable(limit).orElse(new Byte("100")))
                                                                                ));
    }

}
