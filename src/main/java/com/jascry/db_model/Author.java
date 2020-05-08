package com.jascry.db_model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Authors")
public class Author {
    @Id
    @Column(name = "login"
            , nullable = false
            , length = 50)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "author"
            ,fetch = FetchType.LAZY
            ,cascade = CascadeType.ALL)
    private List<CommentResponse> commentResponses;

    @OneToMany(mappedBy = "author"
            ,fetch = FetchType.LAZY
            ,cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "author"
                ,fetch = FetchType.LAZY
                ,cascade = CascadeType.ALL)
    private List<Post> posts;

    public Author(String login, String password, String email, List<CommentResponse> commentResponses, List<Comment> comments, List<Post> posts) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.commentResponses = commentResponses;
        this.comments = comments;
        this.posts = posts;
    }

    public Author() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<CommentResponse> getCommentResponses() {
        return commentResponses;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
