package org.example.ihm;

import java.util.*;

import org.example.entity.Article;
import org.example.entity.Client;
import org.example.entity.SalesClient;
import org.example.service.ArticleService;
import org.example.service.ClientService;
import org.example.service.SalesClientService;
import org.example.service.SalesService;

public class Ihm {
    private ArticleService articleService;
    private ClientService clientService;
    private SalesClientService salesClientService;
    private SalesService salesService;
    private Scanner scanner;

    public Ihm(){
        scanner = new Scanner(System.in);
        articleService = new ArticleService();
        clientService = new ClientService();
        salesService = new SalesService();
        salesClientService = new SalesClientService();
    }

    public void start(){
        int choice;
        do{
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createArticle();
                    break;
                case 2:
                    findArticles();
                    break;
                case 3:
                    deleteArticleById();
                    break;
                case 4:
                    updateArticleById();
                    break;
                case 5:
                    createClient();
                    break;
                case 6:
                    showClients();
                    break;  
                case 7:
                    updateClientById();
                    break;
                case 8:
                    deleteClientById();
                    break;                    
                default:
                    continue;
            }
            
        }while(choice != 0);
    }

    private void menu() {
        System.out.println("Système de gestion d'inventaire");
    }
    private void createArticle(){
       articleService.create(new Article("t-shirt", "haut", "xl", 10.00, 10));
       articleService.create(new Article("pantalon", "bas", "42", 30.00, 10));
       articleService.create(new Article("doudoune", "haut", "xl", 59.99, 10));
    }


    private void findArticles(){
        List<Article> articleList = articleService.findAll();
        for (Article article : articleList) {
           System.out.println(article);
       }
    }

    private void deleteArticleById(){
        articleService.delete(articleService.findById(2));
    }

    private void updateArticleById(){
        Article articleUpdate = articleService.findById(1);
       if (articleUpdate != null) {
           articleUpdate.setPrice(20.00);
       } else {
           System.out.println("Article non trouvé.");
       }
       System.out.println(articleUpdate);
    }

    private void createClient(){
        clientService.create(new Client("John", "John@gmail.com", "none"));
        clientService.create(new Client("Doe", "Doe@gmail.com", "t-shirt"));
        clientService.create(new Client("John", "John@gmail.com", "doudoune"));
    }

    private void showClients(){
        List <Client> clientList = clientService.findAll();
       for (Client client : clientList){
           System.out.println(client);
       }
    }

    private void updateClientById(){
        Client clientUpdate = clientService.findById(8);
       if (clientUpdate != null) {
           clientUpdate.setClientName("Jane");
       } else {
           System.out.println("Client non trouvé.");
       }
    }

    private void deleteClientById(){
        clientService.delete(clientService.findById(6));
    }
}
