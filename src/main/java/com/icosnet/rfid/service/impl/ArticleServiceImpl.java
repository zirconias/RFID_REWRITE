package com.icosnet.rfid.service.impl;

import com.icosnet.rfid.domain.model.Article;
import com.icosnet.rfid.domain.repository.ArticleRepository;
import com.icosnet.rfid.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by xirconias on 01/05/15.
 */
public class ArticleServiceImpl implements ArticleService {

    ArticleRepository articleRepository;


    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public Article findById(Long id) {
        return null;
    }

    @Override
    public Article save(Article article) {
        return null;
    }

    @Override
    public Page<Article> findAllByPage(Pageable pageable) {
        return null;
    }

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
}
