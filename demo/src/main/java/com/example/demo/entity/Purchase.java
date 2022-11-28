package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Purchase {
    @Id
    private int productId;
    private String date;
    private int price;
    private String name;

//    @ManyToOne
//    @JoinColumn(name="p_id")
//    private Product product;
    private int quantity;
}
