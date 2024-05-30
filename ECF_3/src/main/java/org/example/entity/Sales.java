package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Enregistrer les ventes réalisées en magasin.
//Suivre l'état des ventes (en cours, finalisée, annulée).
//Générer des reçus de vente pour les clients

@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    private SalesEnum salesEnum;

    private String receipt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SalesEnum getSalesEnum() {
        return salesEnum;
    }

    public void setSalesEnum(SalesEnum salesEnum) {
        this.salesEnum = salesEnum;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }
}
