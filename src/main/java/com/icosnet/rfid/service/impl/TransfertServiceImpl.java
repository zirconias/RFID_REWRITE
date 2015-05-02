package com.icosnet.rfid.service.impl;

import com.icosnet.rfid.domain.model.Transfert;
import com.icosnet.rfid.domain.repository.TransfertRepository;
import com.icosnet.rfid.service.TransfertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xirconias on 02/05/15.
 */
@Repository
@Transactional
@Service("transfertService")
public class TransfertServiceImpl implements TransfertService {

    @Autowired
    TransfertRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Transfert> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Transfert findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Transfert save(Transfert transfert) {
        return repository.save(transfert);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Transfert> findAllByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
