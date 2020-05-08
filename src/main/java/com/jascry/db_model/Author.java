package com.jascry.db_model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jascry.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Authors")
public class Author implements UserDetails {

    @Id
    @Column(name = "login"
            , nullable = false
            , length = 50)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name="email")
    private String email;

    private Boolean isAdmin = false;

    private Boolean isActive = true;

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

    private String token;

    public Author(String login, String password, String email, List<CommentResponse> commentResponses, List<Comment> comments, List<Post> posts) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.commentResponses = commentResponses;
        this.comments = comments;
        this.posts = posts;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Author() {
    }

    public String getLogin() {
        return login;
    }

    @JsonIgnore
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return !this.token.equals("");
    }

    @Override
    public boolean isEnabled() {
        return this.isActive;
    }

    public String getToken() {
        return token;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
