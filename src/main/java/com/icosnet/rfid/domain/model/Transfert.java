package com.icosnet.rfid.domain.model;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by xirconias on 01/05/15.
 */
@Entity
@Table(name = "TRANSFERT")
public class Transfert extends AbstractEntity  {

    private String bonTransfer;
    private DateTime transfertDate;

    private Magasin magasinOrigin;
    private Magasin magasinDestination;

    private String motif;


    @Column(name = "TRANSFERT_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    public DateTime getTransfertDate() {
        return transfertDate;
    }
    public void setTransfertDate(DateTime transfertDate) {
        this.transfertDate= transfertDate;
    }

    @Column(name = "BON_TRANSFERT")
    public String getBonTransfer() {
        return bonTransfer;
    }
    public void setBonTransfer(String bonTransfer) {
        this.bonTransfer = bonTransfer;
    }

    @Column(name = "MOTIF")
    public String getMotif() {
        return motif;
    }
    public void setMotif(String motif) {
        this.motif = motif;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = false)
    public Magasin getMagasinOrigin() {
        return magasinOrigin;
    }
    public void setMagasinOrigin(Magasin magasinOrigin) {
        this.magasinOrigin = magasinOrigin;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = false)
    public Magasin getMagasinDestination() {
        return magasinDestination;
    }
    public void setMagasinDestination(Magasin magasinDestination) {
        this.magasinDestination = magasinDestination;
    }


    @Transient
    public String getTransfertDateString() {
        String transfertDate = "";
        if (this.transfertDate != null)
            transfertDate = org.joda.time.format.DateTimeFormat
                    .forPattern("yyyy-MM-dd").print(this.transfertDate);
        return transfertDate;
    }
}
