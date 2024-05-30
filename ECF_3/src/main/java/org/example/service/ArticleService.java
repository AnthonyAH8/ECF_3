package org.example.service;

import org.example.entity.Article;
import org.example.interfaces.Repository;

import java.util.List;

public class ArticleService extends BaseService implements Repository<Article> {
    @Override
    public boolean create(Article o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Article o) {
        return false;
    }

    @Override
    public boolean delete(Article o) {
        return false;
    }

    @Override
    public Article findById(int id) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }
}
