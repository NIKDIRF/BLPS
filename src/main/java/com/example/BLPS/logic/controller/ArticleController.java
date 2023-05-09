package com.example.BLPS.logic.controller;

import com.example.BLPS.logic.controller.model.dto.ArticleDto;
import com.example.BLPS.logic.service.ArticleService;
import com.example.BLPS.model.Article;
import com.example.BLPS.throwable.AssertController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ConversionService conversionService;

    @GetMapping
    public List<ArticleDto> getNews(@RequestParam Map<String, String> requestParam) {
        AssertController.getArticleValidateRequestParam(requestParam);

        return articleService.getArticle(requestParam).stream().map(e -> conversionService.convert(e, ArticleDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/createNew")
    public void createNew(@Validated @RequestBody ArticleDto articleDto, @RequestParam Map<String, String> requestParam) {
        AssertController.nullRequestParam(requestParam);

        articleService.createNew(conversionService.convert(articleDto, Article.class));
    }
}
