package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Stock {

    @Id

    private int id;
    private int productId;
    private int price;
    private String name;
    private int quantity;
    private int totalAmount;
}
