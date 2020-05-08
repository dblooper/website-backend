package com.jascry.controller;

import com.jascry.db_model.Author;
import com.jascry.exception.AuthorNotFoundException;
import com.jascry.exception.ContentSubjectNotFoundException;
import com.jascry.exception.PostDataNotProvidedException;
import com.jascry.mapping.CommentMapper;
import com.jascry.mapping.PostMapper;
import com.jascry.mapping.dto.CommentForCrudDto;
import com.jascry.mapping.dto.PostForCrudDto;
import com.jascry.repository.PostRepository;
import com.jascry.security.UserAuthenticationService;
import com.jascry.service.CommentService;
import com.jascry.service.ContentSubjectService;
import com.jascry.service.PostService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.jascry.db_model.User;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;


@RestController
@RequestMapping("/secured/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class SecuredUserController {
    @NonNull
    UserAuthenticationService authentication;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    CommentService commentService;

    @GetMapping("/current")
    Author getCurrent(@AuthenticationPrincipal final Author user) {
        return user;
    }

    @GetMapping("/logout")
    boolean logout(@AuthenticationPrincipal final Author user) {
        authentication.logout(user);
        return true;
    }

    @PostMapping(path="/comment")
    @ResponseStatus(HttpStatus.CREATED)
    CommentForCrudDto addComment(@RequestBody CommentForCrudDto commentForCrudDto) throws AuthorNotFoundException, PostDataNotProvidedException {
        return commentService.saveCommentToDb(commentForCrudDto);
    }
}
