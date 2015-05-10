package com.icosnet.dev.service.impl;


import com.icosnet.dev.domain.model.Article;
import com.icosnet.dev.domain.repository.ArticleRepository;
import com.icosnet.dev.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xirconias on 01/05/15.
 */
@Repository
@Transactional
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    ArticleRepository articleRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Article> findAll() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Article findById(Long id) {
        return null;
    }

    @Override
    public Article save(Article article) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Article> findAllByPage(Pageable pageable) {
        return null;
    }

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
}
