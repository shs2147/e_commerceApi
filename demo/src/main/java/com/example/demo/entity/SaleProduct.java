package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int productId;
    private int totalAmount;
    private String itemName;
    private int price;

    private int quantity;

}
