package com.icosnet.rfid.test;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.icosnet.rfid.domain.model.Product;
import com.icosnet.rfid.domain.repository.PersistenceConfig;
import com.icosnet.rfid.domain.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

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
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class ProTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void search_Product() {
        Product product = repository.findOne(11L);
        assertThat(product.getDescr(), is("xxx"));
    }

    @Test
    public void findByDescr() {
        Product product = repository.findByDescr("aa");
        assertThat(product.getLibelle(), is("xx"));
    }

    @Test
    public void findByDescrAndLibelle(){
        Product product = repository.findByDescrAndLibelle("aa","xx");
        assertThat(product.getLibelle(), is("xx"));
    }
}
