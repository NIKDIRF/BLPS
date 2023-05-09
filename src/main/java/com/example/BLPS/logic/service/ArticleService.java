package com.example.BLPS.logic.service;

import com.example.BLPS.logic.service.dao.ArticleRepository;
import com.example.BLPS.logic.service.dao.ImageRepository;
import com.example.BLPS.logic.service.dao.TagRepository;
import com.example.BLPS.logic.service.util.ImageUtil;
import com.example.BLPS.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.BLPS.throwable.AssertService.*;

@Service
public class ArticleService {

    @Autowired
    private ImageUtil imageUtil;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ArticleRepository articleRepository;

    private static final Integer DEFAULT_PAGE_SIZE = 10;

    public Page<Article> getArticle(Map<String, String> requestParam) {
        if (requestParam.containsKey("name") && requestParam.containsKey("tags") && requestParam.size() == 2) {
            List<String> tags = Arrays.stream(requestParam.get("tags").split(" ")).collect(Collectors.toList());

            return articleRepository.findAllByTopicIgnoreCaseContainingAndTags_tagNameIn(requestParam.get("name"), tags, PageRequest.of(Integer.parseInt(requestParam.get("page")), DEFAULT_PAGE_SIZE));
        }
        if (requestParam.containsKey("name") && requestParam.size() == 1)
            return articleRepository.findAllByTopicIgnoreCaseContaining(requestParam.get("name"), PageRequest.of(Integer.parseInt(requestParam.get("page")), DEFAULT_PAGE_SIZE));
        if (requestParam.containsKey("tags") && requestParam.size() == 1) {
            List<String> tags = Arrays.stream(requestParam.get("tags").split(" ")).collect(Collectors.toList());
            return articleRepository.findAllByTags_tagNameIn(tags, PageRequest.of(Integer.parseInt(requestParam.get("page")), DEFAULT_PAGE_SIZE));
        }
        return articleRepository.findAll(PageRequest.of(Integer.parseInt(requestParam.get("page")), DEFAULT_PAGE_SIZE));
    }

    public void createNew(Article article) {
        tagsAreNotDuplicated(article.getTags(), article.getTopic());
        existsTopic(articleRepository.existsByTopic(article.getTopic()), article.getTopic());

        article.getImages().forEach(e -> imageUtil.saveImage(e, article.getTopic()));
        article.setCreationDate(new Date());

        articleRepository.save(article);
        article.getTags().forEach(e -> e.setArticle(article));
        article.getTags().forEach(e -> e.setTagName(e.getTagName().toLowerCase()));
        article.getImages().forEach(e -> e.setArticle(article));

        tagRepository.saveAll(article.getTags());
        imageRepository.saveAll(article.getImages());
    }
}
