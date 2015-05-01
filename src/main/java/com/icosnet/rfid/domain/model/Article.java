package com.icosnet.rfid.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xirconias on 01/05/15.
 */
@Entity
@Table(name = "ARTICLE")
public class Article extends AbstractEntity {

    private String idRFID;
    private String numSerie;
    private Product product;
    private Magasin magasin;

}
