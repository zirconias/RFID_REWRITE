package com.icosnet.rfid.service;

import com.icosnet.rfid.domain.model.TransfertLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by xirconias on 02/05/15.
 */
public interface TransfertLineService {
    List<TransfertLine> findAll();
    TransfertLine findById(Long id);
    TransfertLine save(TransfertLine  transfertLine);
    Page<TransfertLine> findAllByPage(Pageable pageable);
}
