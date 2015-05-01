package com.icosnet.rfid.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by xirconias on 30/04/15.
 */
@Entity
@Table(name = "PRODUCT")
public class Product extends AbstractEntity {

    @Column(name = "LIBELLE", nullable = false)
    private String libelle;
    @Column(name = "DESCR", nullable = false)
    private String descr;

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescr() {
        return descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Version
    private long version;
}
