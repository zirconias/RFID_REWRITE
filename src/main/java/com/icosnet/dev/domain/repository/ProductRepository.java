package com.icosnet.dev.domain.repository;


import com.icosnet.dev.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by xirconias on 30/04/15.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByDescr(String escr);

    Product findByDescrAndLibelle(String escr, String ibelle);

    @Query("select p from Product p where p.libelle like %?1%")
    List<Product> searchWithQuery(String libelle);

    @Query(value = "SELECT * FROM PRODUCT WHERE libelle = ?1", nativeQuery = true)
    List<Product> findByNativeQueryLibelle(String libelle);

    @Query("select u from Product u where u.descr = :descr or u.libelle = :libelle")
    List<Product> findByDescrOrLibelleNamedParams(@Param("descr") String descr,
                                                  @Param("libelle") String libelle);
}
