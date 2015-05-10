package com.icosnet.dev;


import com.icosnet.dev.domain.model.Magasin;
import com.icosnet.dev.domain.model.MagasinType;
import com.icosnet.dev.domain.repository.MagasinRepository;
import com.icosnet.dev.domain.repository.PersistenceConfig;
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

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by xirconias on 01/05/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class
})
public class MagasinTest {

    @Autowired
    private MagasinRepository repository;

    @Test
    public void add_Magasin(){
        MagasinType type = MagasinType.PRINCIPAL;

        Magasin magasin = new Magasin("libelle lt","my descr",type,"loc loc");
        magasin.setCreationDate(new java.sql.Timestamp(new java.util.Date().getTime()));
        assertThat(magasin,is(repository.save(magasin)));
        //second magasin
        type= MagasinType.MOBILE;
        Magasin mag2= new Magasin("libelle lt "+new DateTime(),"my descr"+new DateTime(),type,"loc loc"+new DateTime());
        mag2.setType(type);
        mag2.setCreationDate(new java.sql.Timestamp(new java.util.Date().getTime()));
        mag2.setDescr("descr 2");
        mag2.setLibelle("libelle 3");
        mag2.setLocalisation("my location 3");
        assertThat(mag2,is(repository.save(mag2)));
    }

    @Test
    public void search_Magasin() {
        Magasin magasin= repository.findOne(1L);
        assertThat(magasin.getDescr(), is("descr 1"));
    }

    @Test
    public void countMagasinsByType(){
        List<Magasin> magasins = repository.findByType(MagasinType.MOBILE);
        System.out.println(magasins.size());
    }

}
