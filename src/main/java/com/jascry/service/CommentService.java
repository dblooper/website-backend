package com.jascry.service;

import com.jascry.db_model.Author;
import com.jascry.db_model.Comment;
import com.jascry.db_model.Post;
import com.jascry.exception.AuthorNotFoundException;
import com.jascry.exception.PostDataNotProvidedException;
import com.jascry.mapping.AuthorMapper;
import com.jascry.mapping.CommentMapper;
import com.jascry.mapping.dto.CommentForCrudDto;
import com.jascry.repository.AuthorRepository;
import com.jascry.repository.CommentRepository;
import com.jascry.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PostRepository postRepository;

    public CommentForCrudDto saveCommentToDb(CommentForCrudDto commentForCrudDto) throws AuthorNotFoundException, PostDataNotProvidedException {
        Optional<Author> author = authorRepository.findById(commentForCrudDto.getAuthor());
        Optional<Post> post = postRepository.findById(commentForCrudDto.getPostId());
        Comment commentToSave = new Comment(
                commentForCrudDto.getBody()
                ,author.orElseThrow(() -> new AuthorNotFoundException("Please provide the proper Author login"))
                , commentForCrudDto.getLikes()
                , commentForCrudDto.getDislikes()
                ,new ArrayList<>()
                ,post.orElseThrow(() -> new PostDataNotProvidedException("Post Id does not exist in database"))
        );
        return commentMapper.mapCommentToCommentToCreateDto(commentRepository.save(commentToSave));
    }
}
