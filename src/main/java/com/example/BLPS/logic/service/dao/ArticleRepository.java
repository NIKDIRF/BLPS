package com.example.BLPS.logic.service.dao;

import com.example.BLPS.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

    boolean existsByTopic(String topic);

    Page<Article> findAll(Pageable pageable);

    Page<Article> findAllByTags_tagNameIn(List<String> tags, Pageable pageable);

    Page<Article> findAllByTopicIgnoreCaseContaining(String topic, Pageable pageable);

    Page<Article> findAllByTopicIgnoreCaseContainingAndTags_tagNameIn(String topic, List<String> tags, Pageable pageable);
}
