package com.jascry.mapping.dto;

import com.jascry.db_model.Comment;
import com.jascry.db_model.CommentResponse;
import java.util.List;

public class AuthorForPostDto {
    private String login;

    public AuthorForPostDto(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
