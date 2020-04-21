package com.jascry.mapping;

import com.jascry.db_model.Post;
import com.jascry.mapping.dto.PostForSubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {
    @Autowired
    private AuthorMapper authorMapper;

    List<PostForSubjectDto> getPostForSubjectDtoList(List<Post> posts) {
        return posts.stream()
                .map(p -> new PostForSubjectDto(p.getId(),p.getName(), p.getImage(), p.getBody(), p.getLikes(), p.getDislikes(), p.getVisitQuantity(), authorMapper.getAuthorForPostDto(p.getAuthor())))
                .collect(Collectors.toList());
    }
}
