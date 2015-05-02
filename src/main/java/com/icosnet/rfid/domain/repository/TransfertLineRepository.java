package com.icosnet.rfid.domain.repository;

import com.icosnet.rfid.domain.model.TransfertLine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xirconias on 02/05/15.
 */
public interface TransfertLineRepository  extends JpaRepository<TransfertLine, Long> {
}
