package com.icosnet.dev.service;


import com.icosnet.dev.domain.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by xirconias on 01/05/15.
 */
public interface ArticleService {
    List<Article> findAll();
    Article findById(Long id);
    Article save(Article article);
    Page<Article> findAllByPage(Pageable pageable);
}
