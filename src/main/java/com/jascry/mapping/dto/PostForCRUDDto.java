package com.jascry.mapping.dto;

import com.jascry.db_model.Author;
import com.jascry.db_model.ContentSubject;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PostForCRUDDto {
    private String name;
    private Blob image;
    private String author;
    private String subjectName;
    private String body;
    private Integer likes = 0;
    private Integer dislikes = 0;
    private Long visitQuantity = 0L;
    private LocalDateTime creationDate;

    public PostForCRUDDto(String name, Blob image, String author, String subjectName, String body, Integer likes, Integer dislikes, Long visitQuantity, LocalDateTime creationDate) {
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

    public PostForCRUDDto(String name, Blob image, String author, String subjectName, String body) {
        this.name = name;
        this.image = image;
        this.author = author;
        this.subjectName = subjectName;
        this.body = body;
    }

    public PostForCRUDDto() {
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
}
