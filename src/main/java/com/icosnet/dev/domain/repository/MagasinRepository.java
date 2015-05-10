package com.icosnet.dev.domain.repository;


import com.icosnet.dev.domain.model.Magasin;
import com.icosnet.dev.domain.model.MagasinType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xirconias on 01/05/15.
 */
public interface MagasinRepository extends JpaRepository<Magasin,Long> {

    List<Magasin> findByType(MagasinType type);
}
