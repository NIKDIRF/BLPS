package com.example.BLPS.logic.controller.model;

import com.example.BLPS.logic.controller.model.converter.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        ConverterTagToTagDto converterTagToTagDto = new ConverterTagToTagDto();
        ConverterTagDtoToTag converterTagDtoToTag = new ConverterTagDtoToTag();
        ConverterImageToImageDto converterImageToImageDto = new ConverterImageToImageDto();
        ConverterImageDtoToImage converterImageDtoToImage = new ConverterImageDtoToImage();
        ConverterArticleToArticleDto converterArticleToArticleDto = new ConverterArticleToArticleDto(converterTagToTagDto, converterImageToImageDto);
        ConverterArticleDtoToArticle converterArticleDtoToArticle = new ConverterArticleDtoToArticle(converterTagDtoToTag, converterImageDtoToImage);

        registry.addConverter(converterTagToTagDto);
        registry.addConverter(converterTagDtoToTag);
        registry.addConverter(converterImageToImageDto);
        registry.addConverter(converterImageDtoToImage);
        registry.addConverter(converterArticleToArticleDto);
        registry.addConverter(converterArticleDtoToArticle);
    }
}
