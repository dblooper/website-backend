package com.jascry.controller.controller_handler_advice;

import com.jascry.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdivce {
    @ResponseBody
    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String authorNotFoundHandler(AuthorNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ContentSubjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String contentSubjectNotFoundException(ContentSubjectNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PostDataNotProvidedException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String postNameNotFoundException(PostDataNotProvidedException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(AuthorExistsException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String autorExistsException(AuthorExistsException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String usernameNotFoundException(UsernameNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(WrongPasswordException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String wrongPasswordException(WrongPasswordException ex) {
        return ex.getMessage();
    }
}
