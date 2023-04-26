package com.example.BLPS.logic.controller.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ImageDto {

    @JsonProperty("image_link")
    private String imageLink;

    @JsonProperty("file_name")
    @NotNull(message = "Поле file_name не может быть null")
    @NotNull(message = "Поле file_name не может быть пустым")
    @Size(max = 100, message = "Поле file_name не может быть в длину больше 100 символов")
    private String fileName;

    @JsonProperty("file_content")
    @NotNull(message = "Поле file_content не может быть пустым")
    private byte[] imageContent;

    @JsonProperty("image_extension")
    @NotNull(message = "Поле image_extension не может быть null")
    @NotBlank(message = "Поле image_extension не может быть пустым")
    @Pattern(regexp = "^(jpg|png)$", message = "Формат фотографии может быть только jpg или png")
    private String imageExtension;
}
