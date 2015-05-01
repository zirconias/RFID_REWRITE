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

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.AllOf.allOf;

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
public class ProductTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void search_Product() {
        Product product = repository.findOne(11L);
        assertThat(product.getDescr(), is("xxx"));
    }

    @Test
    public void findByDescr() {
        Product product = repository.findByDescr("xa");
        assertThat(product.getLibelle(), is("xa"));
    }

    @Test
    public void findByDescrAndLibelle() {
        Product product = repository.findByDescrAndLibelle("xa", "xa");
        assertThat(product.getLibelle(), is("xa"));
    }

    @Test
    public void findAllCount() {
        List<Product> products = repository.findAll();
        assertThat(products.size(), is(2));
    }

    @Test
    public void searchWithQuery_OneProductEntryFound_ShouldReturnAListOfOneEntry() {
        List<Product> products = repository.searchWithQuery("xa");
        assertThat(products.size(), is(1));

        assertThat(products.get(0), allOf(
                hasProperty("id", is(22L)),
                hasProperty("libelle", is("xa"))
        ));
    }

    @Test
    public void searchWithQuery_TwoProductEntriesFound_ShouldReturnAListOfTwoEntries() {
        List<Product> products = repository.searchWithQuery("x");

        assertThat(products.size(), is(2));
        assertThat(products, contains(
                allOf(
                        hasProperty("id", is(11L)),
                        hasProperty("descr", is("xxx")),
                        hasProperty("libelle", is("xxx"))
                ),
                allOf(
                        hasProperty("id", is(22L)),
                        hasProperty("descr", is("xa")),
                        hasProperty("libelle", is("xa"))
                )
        ));
    }

    @Test
    public void findByNativeQueryLibelle(){
        List<Product> products =repository.findByNativeQueryLibelle("xxx");
        assertThat(products.size(),is(1));
    }

    @Test
    public void findByDescrOrLibelleNamedParams(){
        List<Product> products = repository.findByDescrOrLibelleNamedParams("xxx","xa");
        System.out.println(products.size());
    }

}
