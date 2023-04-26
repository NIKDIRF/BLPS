package com.example.BLPS.throwable.exception;

public class ArticleTopicExistsException extends RuntimeException{

    private static final String ARTICLE_TOPIC_EXISTS_MESSAGE = "Топик с названием { %s } уже существует";

    public ArticleTopicExistsException(String topicName) {
        super(String.format(ARTICLE_TOPIC_EXISTS_MESSAGE, topicName));
    }
}
