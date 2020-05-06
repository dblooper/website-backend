package com.jascry.service;

import com.jascry.db_model.Author;
import com.jascry.db_model.ContentSubject;
import com.jascry.db_model.Post;
import com.jascry.exception.AuthorNotFoundException;
import com.jascry.exception.ContentSubjectNotFoundException;
import com.jascry.exception.PostDataNotProvidedException;
import com.jascry.mapping.PostMapper;
import com.jascry.mapping.dto.PostForCrudDto;
import com.jascry.repository.AuthorRepository;
import com.jascry.repository.ContentSubjectRepository;
import com.jascry.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ContentSubjectRepository contentSubjectRepository;

    @Autowired
    private PostMapper postMapper;

    public PostForCrudDto savePostToDb(PostForCrudDto postForCRUDDto) throws AuthorNotFoundException, ContentSubjectNotFoundException, PostDataNotProvidedException {
        Optional<Author> author = authorRepository.findById(postForCRUDDto.getAuthor());
        Optional<ContentSubject> contentSubject = contentSubjectRepository.findById(postForCRUDDto.getSubjectName());
        Post newPost = new Post(Optional.ofNullable(postForCRUDDto.getName()).orElseThrow(() -> new PostDataNotProvidedException("Post name is not provided."))
                ,postForCRUDDto.getImage()
                ,author.orElseThrow(() -> new AuthorNotFoundException("Provided author is not found"))
                ,contentSubject.orElseThrow(() -> new ContentSubjectNotFoundException("Provided subject name does not exists!"))
                ,postForCRUDDto.getBody()
                , postForCRUDDto.getLikes()
                , postForCRUDDto.getDislikes()
                , postForCRUDDto.getVisitQuantity());

        return postMapper.getPostDtoAfterCreation(postRepository.save(newPost));
    }

    public PostForCrudDto updatePost(PostForCrudDto postForCRUDDto) throws PostDataNotProvidedException {
        Post postForUpdate = postRepository.findById(Optional.ofNullable(postForCRUDDto.getPostId()).orElseThrow(() -> new PostDataNotProvidedException("Please provide post ID before update")))
                                            .orElseThrow(() -> new PostDataNotProvidedException("Post not found in Database!"));
        Post newPost = new Post(
                postForUpdate.getId()
                ,Optional.ofNullable(postForCRUDDto.getName()).orElse(postForUpdate.getName())
                ,Optional.ofNullable(postForCRUDDto.getImage()).orElse(postForUpdate.getImage())
                ,postForUpdate.getAuthor()
                ,postForUpdate.getContentSubject()
                ,Optional.ofNullable(postForCRUDDto.getBody()).orElse(postForUpdate.getBody())
                ,postForUpdate.getCommentList()
                ,Optional.ofNullable(postForCRUDDto.getLikes()).orElse(postForUpdate.getLikes())
                ,Optional.ofNullable(postForCRUDDto.getDislikes()).orElse(postForUpdate.getDislikes())
                ,Optional.ofNullable(postForCRUDDto.getVisitQuantity()).orElse(postForUpdate.getVisitQuantity())
                ,postForUpdate.getCreationDate()
        );

        return postMapper.getPostDtoAfterCreation(postRepository.save(newPost));
    }
}
