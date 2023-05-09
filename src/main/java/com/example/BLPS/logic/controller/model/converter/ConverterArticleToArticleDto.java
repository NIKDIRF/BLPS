package com.example.BLPS.logic.controller.model.converter;

import com.example.BLPS.logic.controller.model.dto.ArticleDto;
import com.example.BLPS.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ConverterArticleToArticleDto implements Converter<Article, ArticleDto>  {

    private final ConverterTagToTagDto converterTagToTagDto;
    private final ConverterImageToImageDto converterImageToImageDto;

    @Override
    public ArticleDto convert(Article source) {
        ArticleDto res = new ArticleDto();

        res.setTopic(source.getTopic());
        res.setDescription(source.getDescription());
        res.setTags(source.getTags().stream().map(converterTagToTagDto::convert).collect(Collectors.toList()));
        res.setImages(source.getImages().stream().map(converterImageToImageDto::convert).collect(Collectors.toList()));
        return res;
    }
}
