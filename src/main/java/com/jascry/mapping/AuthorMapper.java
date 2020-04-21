package com.jascry.mapping;

import com.jascry.db_model.Author;
import com.jascry.mapping.dto.AuthorForPostDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {

    public List<AuthorForPostDto> getAuthorDtoList(List<Author> authors) {
        return authors.stream()
                .map(a -> new AuthorForPostDto(a.getLogin()))
                .collect(Collectors.toList());
    }

    public AuthorForPostDto getAuthorForPostDto(Author author) {
        return new AuthorForPostDto(author.getLogin());
    }
    
    public String getAuthorLogin(Author author) {
        return author.getLogin();
    }
}
