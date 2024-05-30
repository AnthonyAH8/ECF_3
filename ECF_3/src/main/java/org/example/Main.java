package org.example;

import org.example.entity.Article;
import org.example.service.ArticleService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();


        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        session.getTransaction().begin();

//        Article article1 = new Article();
//
//        article1.setDescription("T-shirt");
//        article1.setCategory("Haut");
//        article1.setHeight("xl");
//        article1.setPrice(249.99);
//        article1.setStock(10);
//
//        session.save(article1);

        Article article2 = new Article();

        article2.setDescription("Pantalon chino");
        article2.setCategory("Bas");
        article2.setHeight("42");
        article2.setPrice(39.99);
        article2.setStock(50);

        session.save(article2);

        transaction.commit();

        session.close();
        sessionFactory.close();

    }
}