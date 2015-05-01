package com.icosnet.rfid.test;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.icosnet.rfid.domain.model.Article;
import com.icosnet.rfid.domain.model.Magasin;
import com.icosnet.rfid.domain.model.Product;
import com.icosnet.rfid.domain.repository.ArticleRepository;
import com.icosnet.rfid.domain.repository.MagasinRepository;
import com.icosnet.rfid.domain.repository.PersistenceConfig;
import com.icosnet.rfid.domain.repository.ProductRepository;
import com.icosnet.rfid.util.MagasinType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by xirconias on 01/05/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class ArticleTest {

    @Autowired
    private ArticleRepository repository;

    @Autowired
    private MagasinRepository magasinRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void add_article(){

        Article article = new Article();
        article.setCreationDate(new java.sql.Timestamp(new java.util.Date().getTime()));
        article.setIdRFID("xxxx111xxx");
        article.setNumSerie("xsss111sss");
        article.setBlocked(false);
        article.setTaken(true);
        Magasin mag=magasinRepository.findOne(3L);
        article.setMagasin(mag);
        Product product=productRepository.findOne(22L);
        article.setProduct(product);
        assertThat(article,is(repository.save(article)));
    }

    @Test
    public void findArticlesByProduct(){
        Product product=productRepository.findOne(11L);
        List<Article> articles =repository.findArticlesByProduct(product);
        assertThat(articles.size(),is(1));
    }
}
