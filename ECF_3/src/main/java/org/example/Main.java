package org.example;

import org.example.entity.Article;
import org.example.entity.Client;
import org.example.entity.Sales;
import org.example.entity.SalesEnum;
import org.example.service.ArticleService;
import org.example.service.ClientService;
import org.example.service.SalesService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       ArticleService articleService = new ArticleService();
       articleService.create(new Article("t-shirt", "haut", "xl", 10.00, 10));
       articleService.create(new Article("pantalon", "bas", "42", 30.00, 10));
       articleService.create(new Article("doudoune", "haut", "xl", 59.99, 10));


       List<Article> articleList = articleService.findAll();
       for (Article article : articleList) {
           System.out.println(article);
       }

       articleService.delete(articleService.findById(2));

       Article articleUpdate = articleService.findById(1);
       if (articleUpdate != null) {
           articleUpdate.setPrice(20.00);
       } else {
           System.out.println("Article non trouvé.");
       }
       System.out.println(articleUpdate);

       articleService.close();

       System.out.println("=====================================");

       ClientService clientService = new ClientService();
       clientService.create(new Client("John", "John@gmail.com", "none"));
       clientService.create(new Client("Doe", "Doe@gmail.com", "t-shirt"));
       clientService.create(new Client("John", "John@gmail.com", "doudoune"));

       List <Client> clientList = clientService.findAll();
       for (Client client : clientList){
           System.out.println(client);
       }

       Client clientUpdate = clientService.findById(8);
       if (clientUpdate != null) {
           clientUpdate.setClientName("Jane");
       } else {
           System.out.println("Client non trouvé.");
       }

       clientService.delete(clientService.findById(6));

       clientService.close();

       System.out.println("=====================================");

        SalesService salesService = new SalesService();

        salesService.create(new Sales(SalesEnum.DONE, "receipt", Client.class,6));

        salesService.close();
        }
    }