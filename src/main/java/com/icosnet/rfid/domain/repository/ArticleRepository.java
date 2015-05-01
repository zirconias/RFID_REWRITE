package com.icosnet.rfid.domain.repository;

import com.icosnet.rfid.domain.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xirconias on 01/05/15.
 */
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
