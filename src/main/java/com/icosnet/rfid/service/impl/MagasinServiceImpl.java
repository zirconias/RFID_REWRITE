package com.icosnet.rfid.service.impl;

import com.icosnet.rfid.domain.model.Magasin;
import com.icosnet.rfid.domain.repository.MagasinRepository;
import com.icosnet.rfid.service.MagasinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by xirconias on 01/05/15.
 */
public class MagasinServiceImpl implements MagasinService {

    private MagasinRepository repository;

    @Override
    public List<Magasin> findAll() {
        return repository.findAll();
    }

    @Override
    public Magasin findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Magasin save(Magasin magasin) {
        return repository.save(magasin);
    }

    @Override
    public Page<Magasin> findAllByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Autowired
    public void setRepository(MagasinRepository repository) {
        this.repository = repository;
    }
}
