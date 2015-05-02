package com.icosnet.rfid.service.impl;

import com.icosnet.rfid.domain.model.TransfertLine;
import com.icosnet.rfid.domain.repository.TransfertLineRepository;
import com.icosnet.rfid.service.TransfertLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

/**
 * Created by xirconias on 02/05/15.
 */
public class TransfertLineServiceImpl implements TransfertLineService {

    @Autowired
    TransfertLineRepository repository;

    @Override
    public List<TransfertLine> findAll() {
        return repository.findAll();
    }

    @Override
    public TransfertLine findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public TransfertLine save(TransfertLine transfertLine) {
        return repository.save(transfertLine);
    }

    @Override
    public Page<TransfertLine> findAllByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
