package com.example.BLPS.logic.controller.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class ArticleDto {

    @JsonProperty("topic")
    @NotNull(message = "Поле topic не может быть null")
    @NotBlank(message = "Поле topic не может быть пустым")
    @Size(max = 500, message = "Размер поля topic не должен превышать 500 символов")
    private String topic;

    @JsonProperty("description")
    @NotNull(message = "Поле description не может быть null")
    @NotBlank(message = "Поле description не может быть пустым")
    @Size(max = 2000, message = "Размер поля description не должен превышать 2000 символов")
    private String description;

    @JsonProperty("tags")
    @NotNull(message = "Поле tags не может быть null")
    private List<TagDto> tags;

    @JsonProperty("images")
    @NotNull(message = "Поле images не может быть null")
    private List<ImageDto> images;
}
