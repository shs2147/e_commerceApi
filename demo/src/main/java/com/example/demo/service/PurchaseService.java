package com.example.demo.service;

import com.example.demo.entity.Purchase;
import com.example.demo.repository.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepo purchaseRepo;
    @Autowired
    ProductService productService;

    public void addPurchase (Purchase purchase) {
//      Product product=productService.findById(purchase.getProductId());

//
//        purchase.setProductId(product.getId());
//      Purchase purchase1=new Purchase();
//      purchase1.setProduct(product);
//      purchase1.setDate("");

      purchaseRepo.save(purchase);
    }

}
