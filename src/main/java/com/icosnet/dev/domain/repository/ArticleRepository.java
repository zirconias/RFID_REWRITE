package com.icosnet.dev.domain.repository;

import com.icosnet.dev.domain.model.Article;
import com.icosnet.dev.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xirconias on 01/05/15.
 */
public interface ArticleRepository extends JpaRepository<Article,Long> {

    List<Article> findArticlesByProduct(Product product);
}
