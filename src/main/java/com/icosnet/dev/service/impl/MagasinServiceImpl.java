package com.icosnet.dev.service.impl;


import com.icosnet.dev.domain.model.Magasin;
import com.icosnet.dev.domain.repository.MagasinRepository;
import com.icosnet.dev.service.MagasinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xirconias on 01/05/15.
 */
@Repository
@Transactional
@Service("magasinService")
public class MagasinServiceImpl implements MagasinService {

    private MagasinRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Magasin> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Magasin findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Magasin save(Magasin magasin) {
        return repository.save(magasin);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Magasin> findAllByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Autowired
    public void setRepository(MagasinRepository repository) {
        this.repository = repository;
    }
}
