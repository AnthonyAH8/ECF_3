package org.example.service;

import org.example.entity.Sales;
import org.example.interfaces.Repository;

import java.util.List;

public class SalesService extends BaseService implements Repository<Sales> {

    @Override
    public boolean create(Sales o) {
        return false;
    }

    @Override
    public boolean update(Sales o) {
        return false;
    }

    @Override
    public boolean delete(Sales o) {
        return false;
    }

    @Override
    public Sales findById(int id) {
        return null;
    }

    @Override
    public List<Sales> findAll() {
        return null;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }
}
