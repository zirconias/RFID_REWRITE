package com.icosnet.dev.domain.model;

import javax.persistence.*;

/**
 * Created by xirconias on 01/05/15.
 */
@Entity
@Table(name = "TRANSFERT_LINE")
public class TransfertLine extends AbstractEntity  {

    private String mootif;

    @Column(name = "MOTIF")
    public String getMootif() {
        return mootif;
    }

    public void setMootif(String mootif) {
        this.mootif = mootif;
    }

    private Article article;
    //private Transfert transfert;

    @OneToOne
    @JoinColumn(name="ARTICLE_ID")
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

/*
    @ManyToOne
    public Transfert getTransfert() {
        return transfert;
    }

    public void setTransfert(Transfert transfert) {
        this.transfert = transfert;
    }*/
}
