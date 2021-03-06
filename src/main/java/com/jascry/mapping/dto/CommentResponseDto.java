package com.jascry.mapping.dto;

public class CommentResponseDto {

    private Long id;

    private String body;

    private AuthorForPostDto author;

    private Integer likes;

    private Integer dislikes;

    public CommentResponseDto(Long id, String body, AuthorForPostDto author, Integer likes, Integer dislikes) {
        this.id = id;
        this.body = body;
        this.author = author;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public AuthorForPostDto getAuthor() {
        return author;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }
}
