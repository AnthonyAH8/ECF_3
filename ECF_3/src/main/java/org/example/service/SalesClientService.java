package org.example.service;

import org.example.entity.SalesClient;
import org.example.interfaces.Repository;

import java.util.List;

public class SalesClientService extends BaseService implements Repository<SalesClient> {
    @Override
    public boolean create(SalesClient o) {
        return false;
    }

    @Override
    public boolean update(SalesClient o) {
        return false;
    }

    @Override
    public boolean delete(SalesClient o) {
        return false;
    }

    @Override
    public SalesClient findById(int id) {
        return null;
    }

    @Override
    public List<SalesClient> findAll() {
        return null;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }
}
