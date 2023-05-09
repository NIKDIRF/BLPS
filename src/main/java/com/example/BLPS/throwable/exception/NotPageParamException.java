package com.example.BLPS.throwable.exception;

public class NotPageParamException extends RuntimeException {

    private static final String NOT_PAGE_PARAM_MESSAGE = "В request нет параметра page";

    public NotPageParamException() {
        super(NOT_PAGE_PARAM_MESSAGE);
    }
}
