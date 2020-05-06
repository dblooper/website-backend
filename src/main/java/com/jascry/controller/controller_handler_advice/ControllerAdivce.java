package com.jascry.controller.controller_handler_advice;

import com.jascry.exception.AuthorNotFoundException;
import com.jascry.exception.ContentSubjectNotFoundException;
import com.jascry.exception.PostDataNotProvidedException;
import org.springframework.http.HttpStatus;
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

}
