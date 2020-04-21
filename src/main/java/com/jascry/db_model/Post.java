package com.jascry.db_model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="Posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column
    private Blob image;

    @ManyToOne
    @JoinColumn(name="authorLogin", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "subjectName", nullable = false)
    private ContentSubject contentSubject;

    @Column(columnDefinition="TEXT")
    private String body;

    @Column
    private Integer likes;

    @Column
    private Integer dislikes;

    @Column
    private Long visitQuantity;

    public Post() {
    }

    public Post(Long id, String name, Blob image, Author author, ContentSubject contentSubject, String body, Integer likes, Integer dislikes, Long visitQuantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.author = author;
        this.contentSubject = contentSubject;
        this.body = body;
        this.likes = likes;
        this.dislikes = dislikes;
        this.visitQuantity = visitQuantity;
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

    public Author getAuthor() {
        return author;
    }

    public ContentSubject getContentSubject() {
        return contentSubject;
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
}
