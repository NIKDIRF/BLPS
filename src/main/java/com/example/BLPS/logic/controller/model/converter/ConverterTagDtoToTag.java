package com.example.BLPS.logic.controller.model.converter;

import com.example.BLPS.logic.controller.model.dto.TagDto;
import com.example.BLPS.entity.Tag;
import org.springframework.core.convert.converter.Converter;

public class ConverterTagDtoToTag implements Converter<TagDto, Tag>  {
    @Override
    public Tag convert(TagDto source) {
        Tag res = new Tag();

        res.setTagName(source.getTagName());
        return res;
    }
}
