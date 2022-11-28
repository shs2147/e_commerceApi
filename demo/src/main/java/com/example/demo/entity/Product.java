package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int id;
    private String category;
    private int categoryId;
    private String itemName;
    private int price;
    private String description;
    private int quantity;

//    @ManyToOne
//    @JoinColumn(name="category_pid")
//    Category categories;

}
