package com.jascry.mapping.dto;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

public class PostForCrudDto {
    private Long postId;
    private String name;
    private Blob image;
    private String author;
    private String subjectName;
    private String body;
    private Integer likes = 0;
    private Integer dislikes = 0;
    private Long visitQuantity = 0L;
    private List<CommentForPostDto> commentsForPostDto;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public PostForCrudDto(String name, Blob image, String author, String subjectName, String body, Integer likes, Integer dislikes, Long visitQuantity, LocalDateTime creationDate) {
        this.name = name;
        this.image = image;
        this.author = author;
        this.subjectName = subjectName;
        this.body = body;
        this.likes = likes;
        this.dislikes = dislikes;
        this.visitQuantity = visitQuantity;
        this.creationDate = creationDate;
    }

    public PostForCrudDto(Long postId, String name, Blob image, String author, String subjectName, String body, Integer likes, Integer dislikes, List<CommentForPostDto> commentsForPostDto, Long visitQuantity, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.postId = postId;
        this.name = name;
        this.image = image;
        this.author = author;
        this.subjectName = subjectName;
        this.body = body;
        this.likes = likes;
        this.dislikes = dislikes;
        this.visitQuantity = visitQuantity;
        this.commentsForPostDto = commentsForPostDto;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public PostForCrudDto(String name, Blob image, String author, String subjectName, String body) {
        this.name = name;
        this.image = image;
        this.author = author;
        this.subjectName = subjectName;
        this.body = body;
    }

    public PostForCrudDto() {
    }

    public Long getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public Blob getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubjectName() {
        return subjectName;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public List<CommentForPostDto> getCommentsForPostDto() {
        return commentsForPostDto;
    }
}
