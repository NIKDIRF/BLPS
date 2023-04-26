package com.example.BLPS.throwable.exception;

public class TagsAreDuplicatedException extends RuntimeException {

    private static final String TAGS_ARE_DUPLICATED_EXCEPTION_MESSAGE = "В статье { %s } дублируются теги: %s";

    public TagsAreDuplicatedException(String topic, String tags) {
        super(String.format(TAGS_ARE_DUPLICATED_EXCEPTION_MESSAGE, topic, tags));
    }
}
