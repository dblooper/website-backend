package com.jascry.mapping.dto;

import com.jascry.db_model.Comment;
import com.jascry.db_model.CommentResponse;
import com.jascry.db_model.Post;

import javax.persistence.*;
import java.util.List;

public class AuthorForCrudDto {

    private String login;

    private String password;

    public AuthorForCrudDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AuthorForCrudDto() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
