package com.icosnet.dev.domain.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<TransfertLine> lines = new ArrayList<>();



    @Column(name = "TRANSFERT_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso= ISO.DATE)
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

    @OneToOne
    @JoinColumn(name = "MAGASIN_ORIGIN")
    public Magasin getMagasinOrigin() {
        return magasinOrigin;
    }
    public void setMagasinOrigin(Magasin magasinOrigin) {
        this.magasinOrigin = magasinOrigin;
    }

    @OneToOne
    @JoinColumn(name = "MAGASIN_DESTINATION")
    public Magasin getMagasinDestination() {
        return magasinDestination;
    }
    public void setMagasinDestination(Magasin magasinDestination) {
        this.magasinDestination = magasinDestination;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="TRANSFERT_ID")
    public List<TransfertLine> getLines() {
        return lines;
    }

    public void setLines(List<TransfertLine> lines) {
        this.lines = lines;
    }

    public Transfert addLine(TransfertLine line){
        this.lines.add(line);
        return this;
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
