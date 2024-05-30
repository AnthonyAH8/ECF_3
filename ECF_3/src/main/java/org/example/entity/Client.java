package org.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Créer, modifier, supprimer et consulter les informations des
//clients.
//Chaque client doit avoir un identifiant unique, un nom, une
//adresse e-mail et un historique des achats.

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    private String clientName;

    private String clientMail;

    private String orderHistory;

    @ManyToMany
    @JoinTable(
            name = "sales_client",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "sale_id")
    )
    private Set<Sales> sales = new HashSet<>();

    public Client(){

    }

    public Client(String clientName, String clientMail, String orderHistory) {
        this.clientName = clientName;
        this.clientMail = clientMail;
        this.orderHistory = orderHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientMail() {
        return clientMail;
    }

    public void setClientMail(String clientMail) {
        this.clientMail = clientMail;
    }

    public String getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(String orderHistory) {
        this.orderHistory = orderHistory;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientMail='" + clientMail + '\'' +
                ", orderHistory='" + orderHistory + '\'' +
                '}';
    }
}
