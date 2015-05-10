package com.icosnet.dev.domain.repository;


import com.icosnet.dev.domain.model.ProProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xirconias on 04/05/15.
 */
public interface ProProductRepository extends JpaRepository<ProProduct, Long> {
    Page<ProProduct> findByDescriptionContaining(String description, Pageable pageable);
}
