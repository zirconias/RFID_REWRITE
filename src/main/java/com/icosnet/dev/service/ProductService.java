package com.icosnet.dev.service;

import com.icosnet.dev.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by xirconias on 30/04/15.
 */
public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    Page<Product> findAllByPage(Pageable pageable);
}
