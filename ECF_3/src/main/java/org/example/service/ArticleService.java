package org.example.service;

import org.example.entity.Article;
import org.example.interfaces.Repository;
import org.hibernate.Query;

import com.mysql.cj.Session;

import java.util.List;

public class ArticleService extends BaseService implements Repository<Article> {
    public ArticleService(){
        super();
    }

    @Override
    public void close() {

        sessionFactory.close();
    }

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
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Article o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Article findById(int id) {
        session = sessionFactory.openSession();
        Article article = session.get(Article.class, id);
        session.close();
        return article;
    }

    @Override
    public List<Article> findAll() {
        List <Article> articleList = null;
        session = sessionFactory.openSession();
        Query <Article> articleQuery = session.createQuery("from Article ");
        articleList = articleQuery.list();
        session.close();
        return articleList;
    }

    public List<Article> getAvailableStock() {
        session = sessionFactory.openSession();
        Query<Article> query = session.createQuery("from Article where stock > 0", Article.class);
        List<Article> article = query.list();
        session.close();
        return article;
    }
}
