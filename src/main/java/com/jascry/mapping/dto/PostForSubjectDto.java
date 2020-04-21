package com.jascry.mapping.dto;

import java.sql.Blob;

public class PostForSubjectDto {
    private Long id;
    private String name;
    private Blob image;
    private String body;
    private Integer likes;
    private Integer dislikes;
    private Long visitQuantity;
    private AuthorForPostDto author;

    public PostForSubjectDto() {
    }

    public PostForSubjectDto(Long id, String name, Blob image, String body, Integer likes, Integer dislikes, Long visitQuantity, AuthorForPostDto author) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.body = body;
        this.likes = likes;
        this.dislikes = dislikes;
        this.visitQuantity = visitQuantity;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Blob getImage() {
        return image;
    }

    public String getBody() {
        return body;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public Long getVisitQuantity() {
        return visitQuantity;
    }

    public AuthorForPostDto getAuthor() {
        return author;
    }
}
