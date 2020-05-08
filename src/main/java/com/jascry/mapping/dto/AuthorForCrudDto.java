package com.jascry.mapping.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jascry.db_model.Comment;
import com.jascry.db_model.CommentResponse;
import com.jascry.db_model.Post;

import javax.persistence.*;
import java.util.List;

public class AuthorForCrudDto {

    private String login;

    private String password;

    private String email;

    private String firstToken;

    private boolean created;

    private String role;

    public AuthorForCrudDto(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
    public AuthorForCrudDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AuthorForCrudDto(String login, boolean created, String role, String firstToken) {
        this.login = login;
        this.created = created;
        this.firstToken = firstToken;
        this.role = role;
    }

    public AuthorForCrudDto() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean getCreated() {
        return this.created;
    }

    public String getFirstToken() {
        return this.firstToken;
    }

    public String getRole() {
        return role;
    }
}
