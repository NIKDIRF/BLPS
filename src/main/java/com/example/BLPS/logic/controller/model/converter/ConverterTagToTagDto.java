package com.example.BLPS.logic.controller.model.converter;

import com.example.BLPS.logic.controller.model.dto.TagDto;
import com.example.BLPS.entity.Tag;
import org.springframework.core.convert.converter.Converter;

public class ConverterTagToTagDto implements Converter<Tag, TagDto>  {
    @Override
    public TagDto convert(Tag source) {
        TagDto res = new TagDto();

        res.setTagName(source.getTagName());
        return res;
    }
}
