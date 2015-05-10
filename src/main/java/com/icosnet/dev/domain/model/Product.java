package com.icosnet.dev.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xirconias on 30/04/15.
 */
@Entity
@Table(name = "PRODUCT")
public class Product extends AbstractEntity {


    private String libelle;
    private String descr;

    @Column(name = "LIBELLE", nullable = false)
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Column(name = "DESCR", nullable = false)
    public String getDescr() {
        return descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }

}
