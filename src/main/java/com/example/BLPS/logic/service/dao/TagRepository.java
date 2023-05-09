package com.example.BLPS.logic.service.dao;

import com.example.BLPS.model.Article;
import com.example.BLPS.model.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Integer>  {
}
