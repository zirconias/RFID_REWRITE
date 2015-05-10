package com.icosnet.dev;


import com.icosnet.dev.domain.model.ProProduct;
import com.icosnet.dev.domain.repository.PersistenceConfig;
import com.icosnet.dev.domain.repository.ProProductRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by xirconias on 04/05/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class
})
public class ProductRepositoryIntegrationTest {

    @Autowired
    private ProProductRepository repository;

    @Test
    public void findsAllProducts() {

        List<ProProduct> products = repository.findAll();
        assertThat(products, hasSize(2));
    }

    @Test
    public void findsAllAppleProductPaged() {

        Page<ProProduct> products = repository.findByDescriptionContaining("Apple", new PageRequest(0, 1));

        Assert.assertThat(products.isFirst(), is(true));
        Assert.assertThat(products.hasNext(), is(true));
        Assert.assertThat(products, Matchers.<ProProduct>hasItem(hasProperty("name", is("iPad"))));
        Assert.assertThat(products, not(Matchers.<ProProduct>hasItem(hasProperty("name", is("MacBook")))));
    }



}
