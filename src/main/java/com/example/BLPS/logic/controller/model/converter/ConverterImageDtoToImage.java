package com.example.BLPS.logic.controller.model.converter;

import com.example.BLPS.logic.controller.model.dto.ImageDto;
import com.example.BLPS.model.Image;
import org.springframework.core.convert.converter.Converter;

public class ConverterImageDtoToImage implements Converter<ImageDto, Image>  {
    @Override
    public Image convert(ImageDto source) {
        Image res = new Image();

        res.setFileName(source.getFileName());
        res.setImageLink(source.getImageLink());
        res.setImageContent(source.getImageContent());
        res.setImageExtension(source.getImageExtension());
        return res;
    }
}