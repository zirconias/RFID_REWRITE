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

    @Column(name = "LIBELLE", nullable = false)
    private String libelle;

    @Column(name = "DESCR")
    private String descr;


    @Convert(converter = MagasinConverter.class)
    private MagasinType type;

    @Column(name = "LOCATION")
    private String localisation;

    @Version
    private long version;

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

    public MagasinType getType() {
        return type;
    }

    public void setType(MagasinType type) {
        this.type = type;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
