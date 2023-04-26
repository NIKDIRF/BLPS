package com.example.BLPS.throwable.exception;

public class GetArticleValidateRequestParamException extends RuntimeException {

    private static final String NOT_NULL_REQUEST_PARAM_MESSAGE = "В request либо лишние, либо некорректные get параметры. Для этого запроса доступны только: %s";

    public GetArticleValidateRequestParamException(String params) {
        super(String.format(NOT_NULL_REQUEST_PARAM_MESSAGE, params));
    }
}
