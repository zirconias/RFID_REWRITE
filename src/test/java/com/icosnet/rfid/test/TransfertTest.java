package com.icosnet.rfid.test;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.icosnet.rfid.domain.model.Article;
import com.icosnet.rfid.domain.model.Magasin;
import com.icosnet.rfid.domain.model.Transfert;
import com.icosnet.rfid.domain.model.TransfertLine;
import com.icosnet.rfid.domain.repository.*;
import org.hamcrest.core.IsNull;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.sql.Timestamp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by xirconias on 02/05/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class TransfertTest {

    Timestamp time =new java.sql.Timestamp(new java.util.Date().getTime());

    @Autowired
    TransfertRepository transfertRepository;

    //@Autowired
   // TransfertLineRepository transfertLineRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    MagasinRepository magasinRepository;

    @Test
    public void add_transfert2(){


        Article article =articleRepository.findOne(1L);
        Magasin magasinTo= magasinRepository.findOne(2L);

        TransfertLine transfertLine =new TransfertLine();
        transfertLine.setCreationDate(time);
        //transfertLine.setArticle(article);


        Transfert transfert= new Transfert();
        transfert.setCreationDate(time);
        transfert.setBonTransfer("bon001");
        transfert.setMagasinOrigin(article.getMagasin());
        transfert.setMagasinDestination(magasinTo);
       // transfert.addLine(transfertLine);

        article.setMagasin(magasinTo);
        articleRepository.save(article);

      //  transfertLineRepository.save(transfertLine);

        transfertRepository.save(transfert);
    }

    @Test
    public void add_transfert(){
        Magasin magasinTO= magasinRepository.findOne(2L);
        Magasin magasinFrom=magasinRepository.findOne(1L);
        Article article = articleRepository.findOne(2L);
        Transfert transfert=new Transfert();
        transfert.setBonTransfer("without 2");
        transfert.setCreationDate(time);
        transfert.setTransfertDate(new DateTime());

        transfert.setMagasinOrigin(magasinFrom);
        transfert.setMagasinDestination((magasinTO));
        transfert.setMotif("without 3");
        TransfertLine line = new TransfertLine();
        line.setArticle(article);
        line.setMootif("without 4 ");
        line.setCreationDate(time);
        transfert.addLine(line);
        article.setMagasin(magasinTO);
        articleRepository.save(article);
        transfertRepository.save(transfert);
    }

    @Test
    public void get_transfert(){
        Transfert transfert = transfertRepository.findOne(1L);
        assertThat(transfert,is(IsNull.notNullValue()));
    }

    @Test
    public void add_transfert_bulk_articles(){

    }

}
