package com.icosnet.rfid.domain.repository;

import com.icosnet.rfid.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by xirconias on 30/04/15.
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
