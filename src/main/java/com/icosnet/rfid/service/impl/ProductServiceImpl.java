package com.icosnet.rfid.service.impl;

import com.google.common.collect.Lists;
import com.icosnet.rfid.domain.model.Product;
import com.icosnet.rfid.domain.repository.ProductRepository;
import com.icosnet.rfid.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xirconias on 30/04/15.
 */
@Repository
@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return Lists.newArrayList(productRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Product> findAllByPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    //inection by constructor
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
