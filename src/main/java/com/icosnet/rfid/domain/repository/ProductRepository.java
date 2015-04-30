package com.icosnet.rfid.domain.repository;

import com.icosnet.rfid.domain.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by xirconias on 30/04/15.
 */
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
}
