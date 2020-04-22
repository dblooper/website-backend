package com.jascry.service;

import com.jascry.db_model.Author;
import com.jascry.db_model.ContentSubject;
import com.jascry.db_model.Post;
import com.jascry.exception.AuthorNotFoundException;
import com.jascry.exception.ContentSubjectNotFoundException;
import com.jascry.exception.PostNameNotProvidedException;
import com.jascry.mapping.PostMapper;
import com.jascry.mapping.dto.PostForCRUDDto;
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

    public PostForCRUDDto savePostToDb(PostForCRUDDto postForCRUDDto) throws AuthorNotFoundException, ContentSubjectNotFoundException, PostNameNotProvidedException {
        Optional<Author> author = authorRepository.findById(postForCRUDDto.getAuthor());
        Optional<ContentSubject> contentSubject = contentSubjectRepository.findById(postForCRUDDto.getSubjectName());
        Post newPost = new Post(Optional.ofNullable(postForCRUDDto.getName()).orElseThrow(() -> new PostNameNotProvidedException("Post name is not provided."))
                , postForCRUDDto.getImage()
                ,author.orElseThrow(() -> new AuthorNotFoundException("Provided author is not found"))
                ,contentSubject.orElseThrow(() -> new ContentSubjectNotFoundException("Provided subject name does not exists!"))
                , postForCRUDDto.getBody()
                , postForCRUDDto.getLikes()
                , postForCRUDDto.getDislikes()
                , postForCRUDDto.getVisitQuantity());
        postRepository.save(newPost);
        return postMapper.getPostDtoAfterCreation(newPost);
    }
}
