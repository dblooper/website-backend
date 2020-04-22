package com.jascry.db_model;

import org.hibernate.annotations.NamedQuery;


import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;

@NamedQuery(
        name="Post.getLastPostsBySubject",
        query="FROM Post WHERE contentSubject = :SUBJECT ORDER BY creationDate DESC"
)

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

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime updateDate;

    @PrePersist
    protected void fillCreateDate() {
        if(this.creationDate == null) this.creationDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void fillUpdateDate() {
        if(this.updateDate == null) this.updateDate = LocalDateTime.now();
    }

    public Post() {
    }

    public Post(String name, Blob image, Author author, ContentSubject contentSubject, String body, Integer likes, Integer dislikes, Long visitQuantity) {
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
}
