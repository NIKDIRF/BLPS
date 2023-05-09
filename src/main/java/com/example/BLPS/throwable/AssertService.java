package com.example.BLPS.throwable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.BLPS.model.Tag;
import com.example.BLPS.throwable.exception.ArticleTopicExistsException;
import com.example.BLPS.throwable.exception.TagsAreDuplicatedException;

public class AssertService {

    public static void existsTopic(boolean res, String message) {
        if (res)
            throw new ArticleTopicExistsException(message);
    }

    public static void tagsAreNotDuplicated(List<Tag> tags, String topic) {
        Set<String> elements = new HashSet<>();

        List<Tag> notUnique = tags.stream()
                .filter(e -> !elements.add(e.getTagName()))
                .collect(Collectors.toList());

        if (notUnique.size() != 0)
            throw new TagsAreDuplicatedException(topic, Arrays.toString(notUnique.stream().map(Tag::getTagName).distinct().toArray()));
    }
}
