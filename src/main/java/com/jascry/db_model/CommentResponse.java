package com.jascry.db_model;

import javax.persistence.*;

@Entity
@Table(name = "CommentResponses")
public class CommentResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn(name = "login", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    @Column
    private Integer likes;

    @Column
    private Integer dislikes;

    public CommentResponse() {
    }

    public CommentResponse(Long id, String body, Author author, Comment comment, Integer likes, Integer dislikes) {
        this.id = id;
        this.body = body;
        this.author = author;
        this.comment = comment;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Author getAuthor() {
        return author;
    }

    public Comment getComment() {
        return comment;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }
}
