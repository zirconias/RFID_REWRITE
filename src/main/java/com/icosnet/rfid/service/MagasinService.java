package com.icosnet.rfid.service;

import com.icosnet.rfid.domain.model.Magasin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by xirconias on 01/05/15.
 */
public interface MagasinService {
    List<Magasin> findAll();
    Magasin findById(Long id);
    Magasin save(Magasin magasin);
    Page<Magasin> findAllByPage(Pageable pageable);
}
