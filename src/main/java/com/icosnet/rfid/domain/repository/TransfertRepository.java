package com.icosnet.rfid.domain.repository;

import com.icosnet.rfid.domain.model.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xirconias on 02/05/15.
 */
public interface TransfertRepository  extends JpaRepository<Transfert, Long> {
}
