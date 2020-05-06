package com.jascry.db_model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn(name = "authorLogin", nullable = false)
    private Author author;

    @Column
    private Integer likes;

    @Column
    private Integer dislikes;

    @OneToMany(mappedBy = "comment"
            ,fetch = FetchType.EAGER
            ,cascade = CascadeType.ALL)
    private List<CommentResponse> commentResponse;

    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

    public Comment() {
    }

    public Comment(Long id, String body, Author author, Integer likes, Integer dislikes, List<CommentResponse> commentResponse) {
        this.id = id;
        this.body = body;
        this.author = author;
        this.likes = likes;
        this.dislikes = dislikes;
        this.commentResponse = commentResponse;
    }

    public Comment(String body, Author author, Integer likes, Integer dislikes, List<CommentResponse> commentResponse, Post post) {
        this.body = body;
        this.author = author;
        this.likes = likes;
        this.dislikes = dislikes;
        this.commentResponse = commentResponse;
        this.post = post;
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

    public Integer getLikes() {
        return likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public List<CommentResponse> getCommentResponse() {
        return commentResponse;
    }

    public Post getPost() {
        return post;
    }
}
