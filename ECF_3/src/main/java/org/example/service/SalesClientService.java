package org.example.service;

import org.example.entity.Article;
import org.example.entity.SalesClient;
import org.example.interfaces.Repository;
import org.hibernate.Query;

import java.util.List;

public class SalesClientService extends BaseService implements Repository<SalesClient> {
    @Override
    public boolean create(SalesClient o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(SalesClient o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(SalesClient o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public SalesClient findById(int id) {
        session = sessionFactory.openSession();
        SalesClient salesClient = session.get(SalesClient.class, id);
        session.close();
        return salesClient;
    }

    @Override
    public List<SalesClient> findAll() {
        List <SalesClient> salesClientList = null;
        session = sessionFactory.openSession();
        Query <SalesClient> salesClientQuery = session.createQuery("from SalesClient ");
        salesClientList = salesClientQuery.list();
        session.close();
        return salesClientList;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }
}
