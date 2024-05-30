package org.example.entity;

import javax.persistence.*;
import java.util.List;

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

    public Article(){

    }

    public  Article(String description, String category, String height, double price, int stock){
        this.description = description;
        this.category = category;
        this.height = height;
        this.price = price;
        this.stock = stock;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", height='" + height + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
