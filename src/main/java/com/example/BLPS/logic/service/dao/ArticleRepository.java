package com.example.BLPS.logic.service.dao;

import com.example.BLPS.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

    boolean existsByTopic(String topic);

    List<Article> findAll();

    List<Article> findAllByTags_tagNameIn(List<String> tags);

    List<Article> findAllByTopicIgnoreCaseContaining(String topic);

    List<Article> findAllByTopicIgnoreCaseContainingAndTags_tagNameIn(String topic, List<String> tags);
}
