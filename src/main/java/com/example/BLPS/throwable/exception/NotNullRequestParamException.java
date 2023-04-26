package com.example.BLPS.throwable.exception;

public class NotNullRequestParamException extends RuntimeException {

    private static final String NOT_NULL_REQUEST_PARAM_MESSAGE = "В request лишние get параметры: %s";

    public NotNullRequestParamException(String params) {
        super(String.format(NOT_NULL_REQUEST_PARAM_MESSAGE, params));
    }
}
