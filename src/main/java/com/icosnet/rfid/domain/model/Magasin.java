package com.icosnet.rfid.domain.model;

import com.icosnet.rfid.util.MagasinConverter;
import com.icosnet.rfid.util.MagasinType;

import javax.persistence.*;

/**
 * Created by xirconias on 01/05/15.
 */
@Entity
@Table(name = "MAGASIN")
public class Magasin extends AbstractEntity {

    private String libelle;
    private String descr;
    private MagasinType type;
    private String localisation;

    @Column(name = "LIBELLE", nullable = false)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Column(name = "DESCR")
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    //@Enumerated(EnumType.STRING)
    @Convert(converter = MagasinConverter.class)
    public MagasinType getType() {
        return type;
    }

    public void setType(MagasinType type) {
        this.type = type;
    }

    @Column(name = "LOCATION")
    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
