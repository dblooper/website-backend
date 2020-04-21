package com.jascry.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jascry.mapping.dto.ContentSubjectDto;
import com.jascry.service.ContentSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class UserController {
    @Autowired
    private ContentSubjectService contentSubjectService;

    @GetMapping(path= "/subjects")
    public List<ContentSubjectDto> fetchBlogSubjects() {
        return contentSubjectService.getContentSubjectDtoList();
    }

    @GetMapping(path = "/subject")
    public ContentSubjectDto fetchBlogSubjectWithPosts(@RequestParam(name = "name") String subjectName) {
        return contentSubjectService.getContentSubjectWithPosts(subjectName);
    }
}
