package org.example.service;

import org.example.entity.Client;
import org.example.interfaces.Repository;
import org.hibernate.Query;

import java.util.List;

public class ClientService extends BaseService implements Repository<Client> {
    @Override
    public boolean create(Client o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Client o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Client o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Client findById(int id) {
        session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    @Override
    public List<Client> findAll() {
       List <Client> clientList = null;
       session = sessionFactory.openSession();
        Query <Client> clientQuery = session.createQuery("from Client");
        clientList = clientQuery.list();
        session.close();
        return clientList;
    }

    @Override
    public void close() {

    }
}
