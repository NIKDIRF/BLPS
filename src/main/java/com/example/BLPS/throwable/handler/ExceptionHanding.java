package com.example.BLPS.throwable.handler;

import com.example.BLPS.throwable.exception.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHanding {

    @Getter
    @RequiredArgsConstructor
    public static class ErrorResponse {
        private final String message;
    }

    @ExceptionHandler(SaveImageException.class)
    public ResponseEntity<ErrorResponse> handleSaveImageException(SaveImageException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(NotNullRequestParamException.class)
    public ResponseEntity<ErrorResponse> handleNotNullRequestParamException(NotNullRequestParamException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(ArticleTopicExistsException.class)
    public ResponseEntity<ErrorResponse> handleArticleTopicExistsException(ArticleTopicExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(TagsAreDuplicatedException.class)
    public ResponseEntity<ErrorResponse> handleTagsAreDuplicatedException(TagsAreDuplicatedException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(GetArticleValidateRequestParamException.class)
    public ResponseEntity<ErrorResponse> handleGetArticleValidateRequestParamException(GetArticleValidateRequestParamException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalStateException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(NotPageParamException.class)
    public ResponseEntity<ErrorResponse> handleNotPageParamException(NotPageParamException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(ParsePageParamException.class)
    public ResponseEntity<ErrorResponse> handleParsePageParamException(ParsePageParamException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }
}
