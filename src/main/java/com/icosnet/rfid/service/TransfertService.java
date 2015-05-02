package com.icosnet.rfid.service;

import com.icosnet.rfid.domain.model.Transfert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by xirconias on 02/05/15.
 */
public interface TransfertService {
    List<Transfert> findAll();
    Transfert findById(Long id);
    Transfert save(Transfert transfert);
    Page<Transfert> findAllByPage(Pageable pageable);
}
