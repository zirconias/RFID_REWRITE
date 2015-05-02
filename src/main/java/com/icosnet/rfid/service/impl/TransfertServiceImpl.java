package com.icosnet.rfid.service.impl;

import com.icosnet.rfid.domain.model.Transfert;
import com.icosnet.rfid.domain.repository.TransfertRepository;
import com.icosnet.rfid.service.TransfertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by xirconias on 02/05/15.
 */
public class TransfertServiceImpl implements TransfertService {

    @Autowired
    TransfertRepository repository;

    @Override
    public List<Transfert> findAll() {
        return repository.findAll();
    }

    @Override
    public Transfert findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Transfert save(Transfert transfert) {
        return repository.save(transfert);
    }

    @Override
    public Page<Transfert> findAllByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
