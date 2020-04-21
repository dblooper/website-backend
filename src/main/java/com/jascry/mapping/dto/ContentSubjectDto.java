package com.jascry.mapping.dto;

import java.util.ArrayList;
import java.util.List;

public class ContentSubjectDto {
    private String subjectName;
    private String description;
    private List<PostForSubjectDto> posts = new ArrayList<>();

    public ContentSubjectDto(String subjectName, String description) {
        this.subjectName = subjectName;
        this.description = description;
    }

    public ContentSubjectDto(String subjectName, String description, List<PostForSubjectDto> posts) {
        this.subjectName = subjectName;
        this.description = description;
        this.posts = posts;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getDescription() {
        return description;
    }

    public List<PostForSubjectDto> getPosts() { return this.posts; }
}
