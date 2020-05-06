package com.jascry.mapping.dto;

import java.util.ArrayList;
import java.util.List;

public class CommentForCrudDto {

    private Long id;
    private String body;
    private String author;
    private Integer likes = 0;
    private Integer dislikes = 0;
    private List<CommentResponseDto> commentResponse = new ArrayList<>();
    private Long postId;

    public CommentForCrudDto() {
    }

    public CommentForCrudDto(Long postId, String body, String author) {
        this.postId = postId;
        this.body = body;
        this.author = author;
    }

    public CommentForCrudDto(Long id, String body, String author, Integer likes, Integer dislikes, List<CommentResponseDto> commentResponse, Long postId) {
        this.id = id;
        this.body = body;
        this.author = author;
        this.likes = likes;
        this.dislikes = dislikes;
        this.commentResponse = commentResponse;
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public Long getId() {
        return id;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public List<CommentResponseDto> getCommentResponse() {
        return commentResponse;
    }
}
