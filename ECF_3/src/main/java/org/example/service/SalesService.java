package org.example.service;

import org.example.entity.Sales;
import org.example.entity.SalesEnum;
import org.example.interfaces.Repository;
import org.hibernate.Query;

import java.util.List;

public class SalesService extends BaseService implements Repository<Sales> {

    public boolean create(Sales o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Sales o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Sales o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Sales findById(int id) {
        session = sessionFactory.openSession();
        Sales sales = session.get(Sales.class, id);
        session.close();
        return sales;
    }

    @Override
    public List<Sales> findAll() {
        List <Sales> salesList = null;
        session = sessionFactory.openSession();
        Query<Sales> salesQuery = session.createQuery("from Sales ");
        salesList = salesQuery.list();
        session.close();
        return salesList;

    }

    @Override
    public void close() {
        sessionFactory.close();
    }
}
