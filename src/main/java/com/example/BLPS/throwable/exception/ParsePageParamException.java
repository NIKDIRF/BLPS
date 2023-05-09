package com.example.BLPS.throwable.exception;

public class ParsePageParamException extends RuntimeException {

    private static final String PARSE_PAGE_PARAM_MESSAGE = "Ошибка типа данных page в get параметре";

    public ParsePageParamException() {
        super(PARSE_PAGE_PARAM_MESSAGE);
    }
}
