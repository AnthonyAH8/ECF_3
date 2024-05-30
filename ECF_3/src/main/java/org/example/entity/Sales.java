package org.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "sales")
    private Set<Client> clients = new HashSet<>();

    public Sales(int id, SalesEnum salesEnum, String receipt, Set<Client> clients) {
        this.id = id;
        this.salesEnum = salesEnum;
        this.receipt = receipt;
        this.clients = clients;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

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
