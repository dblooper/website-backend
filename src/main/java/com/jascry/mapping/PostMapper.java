package com.jascry.mapping;

import com.jascry.db_model.Post;
import com.jascry.mapping.dto.PostForCrudDto;
import com.jascry.mapping.dto.PostForSubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PostMapper {
    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private CommentMapper commentMapper;

    List<PostForSubjectDto> getPostForSubjectDtoList(List<Post> posts) {
        return posts.stream()
                .map(p -> new PostForSubjectDto(p.getId(),p.getName(), p.getImage(), p.getBody(), p.getLikes(), p.getDislikes(), p.getVisitQuantity(), authorMapper.getAuthorForPostDto(p.getAuthor()), p.getCreationDate()))
                .collect(Collectors.toList());
    }

    public PostForCrudDto getPostDtoAfterCreation(Post post) {
        return new PostForCrudDto(post.getId()
                ,post.getName()
                ,post.getImage()
                ,post.getAuthor().getLogin()
                ,post.getContentSubject().getSubjectName()
                ,post.getBody()
                ,post.getLikes()
                ,post.getDislikes()
                ,commentMapper.mapCommentsToCommentsForPostDtoList(Optional.ofNullable(post.getCommentList()).orElse(new ArrayList<>()))
                ,post.getVisitQuantity()
                ,post.getCreationDate()
                ,post.getUpdateDate()
        );
    }
    public List<PostForCrudDto> mapPostToPostForCrudDtoList(List<Post> posts) {
        return posts.stream()
                .map(p -> new PostForCrudDto(
                        p.getName()
                        ,p.getImage()
                        ,p.getAuthor().getLogin()
                        ,p.getContentSubject().getSubjectName()
                        ,p.getBody()
                        ,p.getLikes()
                        ,p.getDislikes()
                        ,p.getVisitQuantity()
                        ,p.getCreationDate()
                ))
                .collect(Collectors.toList());
    }

}
