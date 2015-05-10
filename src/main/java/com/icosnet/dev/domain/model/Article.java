package com.icosnet.dev.domain.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

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

    @Column(name = "TAKEN", nullable = false)
    @Type(type = "yes_no")
    private boolean taken = false;

    @Column(name = "BLOCKED", nullable = false)
    @Type(type = "yes_no")
    private boolean blocked = false;

    public String getIdRFID() {
        return idRFID;
    }

    public void setIdRFID(String idRFID) {
        this.idRFID = idRFID;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MAGASIN")
    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
