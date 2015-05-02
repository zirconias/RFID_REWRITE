package com.icosnet.rfid.domain.model;

import com.icosnet.rfid.util.MagasinConverter;
import com.icosnet.rfid.util.MagasinType;
import org.springframework.util.Assert;

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

    protected Magasin(){}

    /**
     * Creates a new {@link Magasin} from the given libelle,descr, location and type.
     *
     * @param libelle must not be {@literal null} or empty.
     * @param descr must not be {@literal null} or empty.
     * @param localisation must not be {@literal null} or empty.
     * @param type must not be null.
     */
    public Magasin(String libelle, String descr, MagasinType type, String localisation) {
        Assert.hasText(libelle);
        Assert.hasText(descr);
        Assert.hasText(localisation);
        Assert.notNull(type);

        this.libelle = libelle;
        this.descr = descr;
        this.type = type;
        this.localisation = localisation;
    }

    /**
     * gets  {@link Magasin}'s libelle
     * @return
     */
    @Column(name = "LIBELLE", nullable = false)
    public String getLibelle() {
        return libelle;
    }

    /**
     * sets {@link Magasin}'s libelle
     * @param libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * returns {@link Magasin}'s description
     * @return
     */
    @Column(name = "DESCR")
    public String getDescr() {
        return descr;
    }

    /**
     * sets {@link Magasin}'s description
     * @param descr
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    //@Enumerated(EnumType.STRING)
    @Convert(converter = MagasinConverter.class)
    public MagasinType getType() {
        return type;
    }

    /**
     * sets {@link Magasin}'s type
     * @param type
     */
    public void setType(MagasinType type) {
        this.type = type;
    }

    /**
     * returns {@link Magasin}'s location
     *
     * @return
     */
    @Column(name = "LOCATION")
    public String getLocalisation() {
        return localisation;
    }

    /**
     * sets {@link Magasin}'s location
     * @param localisation
     */
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
