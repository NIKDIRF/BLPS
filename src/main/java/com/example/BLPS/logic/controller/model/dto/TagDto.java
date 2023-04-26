package com.example.BLPS.logic.controller.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TagDto {

    @JsonProperty("tag_name")
    @NotNull(message = "Поле tag_name не может быть null")
    @NotBlank(message = "Поле tag_name не может быть пустым")
    @Size(max = 30, message = "Размер поля tag_name не должен превышать 30 символов")
    private String tagName;
}
