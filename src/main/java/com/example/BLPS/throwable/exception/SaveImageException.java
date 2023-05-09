package com.example.BLPS.throwable.exception;

public class SaveImageException extends RuntimeException {

    private static final String SAVE_IMAGE_EXCEPTION_MESSAGE = "Не удалось сохранить файл c именем { %s }";

    public SaveImageException(String fileName) {
        super(String.format(SAVE_IMAGE_EXCEPTION_MESSAGE, fileName));
    }
}
