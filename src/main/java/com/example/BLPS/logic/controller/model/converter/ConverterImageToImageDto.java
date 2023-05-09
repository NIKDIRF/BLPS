package com.example.BLPS.logic.controller.model.converter;

import com.example.BLPS.logic.controller.model.dto.ImageDto;
import com.example.BLPS.model.Image;
import org.springframework.core.convert.converter.Converter;

public class ConverterImageToImageDto implements Converter<Image, ImageDto>  {
    @Override
    public ImageDto convert(Image source) {
        ImageDto res = new ImageDto();

        res.setImageLink(source.getImageLink());
        return res;
    }
}
