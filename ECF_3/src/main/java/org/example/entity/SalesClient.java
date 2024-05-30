package org.example.entity;

import javax.persistence.*;

@Entity
public class SalesClient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sales sales;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
