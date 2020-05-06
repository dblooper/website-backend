package com.jascry.mapping;

import com.jascry.db_model.Comment;
import com.jascry.db_model.CommentResponse;
import com.jascry.mapping.dto.CommentForPostDto;
import com.jascry.mapping.dto.CommentResponseDto;
import com.jascry.mapping.dto.CommentForCrudDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentMapper {
    @Autowired
    private AuthorMapper authorMapper;

    public CommentForPostDto mapCommentToCommentForPostDto(Comment comment) {
        return new CommentForPostDto(
                comment.getId()
                ,comment.getBody()
                ,authorMapper.getAuthorForPostDto(comment.getAuthor())
                ,comment.getLikes()
                ,comment.getDislikes()
        );
    }

    public List<CommentForPostDto> mapCommentsToCommentsForPostDtoList(List<Comment> comments) {
        return comments.stream()
                        .map(comment -> mapCommentToCommentForPostDto(comment))
                        .collect(Collectors.toList());
    }

    public CommentResponseDto mapCommentResponseToCommentResponseDto(CommentResponse commentResponse) {
        return new CommentResponseDto(commentResponse.getId(),
                commentResponse.getBody()
                ,authorMapper.getAuthorForPostDto(commentResponse.getAuthor())
                ,commentResponse.getLikes()
                ,commentResponse.getDislikes());
    }

    public List<CommentResponseDto> mapCommentResponsesToCommentResponseDtoList(List<CommentResponse> commentResponses) {
        return commentResponses.stream()
                .map(commentResponse -> mapCommentResponseToCommentResponseDto(commentResponse))
                .collect(Collectors.toList());
    }


    public CommentForCrudDto mapCommentToCommentToCreateDto(Comment comment) {
        return new CommentForCrudDto(comment.getId(),
                comment.getBody()
                ,comment.getAuthor().getLogin()
                ,comment.getLikes()
                ,comment.getDislikes()
                ,mapCommentResponsesToCommentResponseDtoList(comment.getCommentResponse())
                ,comment.getPost().getId()
        );
    }
}
