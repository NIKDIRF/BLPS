package com.example.BLPS.logic.controller.model.converter;

import com.example.BLPS.logic.controller.model.dto.ArticleDto;
import com.example.BLPS.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ConverterArticleDtoToArticle implements Converter<ArticleDto, Article> {

    private final ConverterTagDtoToTag converterTagDtoToTag;
    private final ConverterImageDtoToImage converterImageDtoToImage;

    @Override
    public Article convert(ArticleDto source) {
        Article res = new Article();

        res.setTopic(source.getTopic());
        res.setDescription(source.getDescription());
        res.setTags(source.getTags().stream().map(converterTagDtoToTag::convert).collect(Collectors.toList()));
        res.setImages(source.getImages().stream().map(converterImageDtoToImage::convert).collect(Collectors.toList()));
        return res;
    }
}
