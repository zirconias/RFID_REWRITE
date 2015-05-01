package com.icosnet.rfid.domain.repository;

import com.icosnet.rfid.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xirconias on 30/04/15.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByDescr(String  escr);

    Product findByDescrAndLibelle(String escr,String ibelle);
}
