# ECF_3

# Système de gestion d'inventaires pour un magasin de vêtements

## Commencement

### Introduction

L'objectif de ce projet est de créer une application pour gérer l'inventaire d'un magasin de vêtements. 
Les employés pourront :
- Créer de nouveaux profils relatifs aux clients
- Consulter et mettre à jour les stocks de vêtements disponibles et les fiches clients
- Mettre à jour le profil d'un client
- Supprimer le profil d'un client

### Fonctionnalités

- Créer, lire, mettre à jour et supprimer des clients
- Créer, lire, mettre à jour et supprimer des ventes
- Gérer la relation many-to-many entre les clients et les ventes
- Générer des reçus de vente

### Technologies utilisées

![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)  
![Markdown](https://img.shields.io/badge/Markdown-000000?style=for-the-badge&logo=markdown&logoColor=white)  
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)  
![MySQL](https://img.shields.io/badge/MySQL-blue?style=for-the-badge&logo=mysql&logoColor=white)  

### Pré-requis

- JDK 17
- Maven 3.6.3
- MySQL 8.0.28
- Hibernate 5.6.15.Final

### Réalisé avec 

Ce projet a été réalisé avec l'IDE IntelliJ IDEA.

## Initiation projet

### Création d'un projet

Afin de commencer le projet, il faut créer un projet avec l'IDE intelliJ.  
Ensuite, il faut installer les dépendances Hibernate et MySQL dans le fichier **pom.xml**.

```bash
    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-entitymanager</artifactId>
            <version>5.6.15.Final</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.28</version>
        </dependency>

    </dependencies>
```

Après avoir installé les dépendances dans le fichier **pom.xml**, il faut créer un fichier **hibernate.cfg.xml** dans le dossier *ressource* dans lequel il faudra ajouter les dépendances Hibernate:

```bash
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD//EN"
        "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <mapping class="org.example.entity.nomEntite"/>
        <mapping class="org.example.entity.nomEntite"/>
        <mapping class="org.example.entity.nomEntite"/>
        <mapping class="org.example.entity.nomEntite"/>
    </session-factory>
</hibernate-configuration>
```

Toujours dans le dossier *ressource*, il faudra créer un fichier hibernate.properties dans lequel il faudra indiquer les informations de connexion MySQL :

```bash
## MYSQL
#hibernate.dialect = org.hibernate.dialect.MariaDBDialect
hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
hibernate.connection.driver_class = com.mysql.jdbc.Driver
hibernate.connection.url = jdbc:mysql://localhost/"bddname"
hibernate.connection.username = username
hibernate.connection.password = password
hibernate.show_sql = true
hibernate.hbm2ddl.auto = update
hibernate.connection.autocommit = false
```


Tout cela réalisé, il faut créer la base de données grâce à MySQL Workbench. Les tables vont être crées dans les fichiers dans le dossier *entity*.

Exemple de création d'article avec la table article:

```bash
articleService.create(new Article("t-shirt", "haut", "xl", 10.00, 10));

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    private String description;

    private String category;

    private String height;

    private double price;

    private int stock;

    public Article(String description, String category, String height, double price, int stock){
        this.description = description;
        this.category = category;
        this.height = height;
        this.price = price;
        this.stock = stock;
    }
}
```

### Auteur

[AnthonyAH8](https://github.com/AnthonyAH8)

### License

Ce projet est sous licence MIT.
