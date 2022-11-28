package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.Purchase;
import com.example.demo.entity.Stock;
import com.example.demo.exception.productnotFoundException;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.StockRepo;
import com.example.demo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController

public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    StockRepo stockRepo;


//    @PostMapping("/add")
//
//    public ResponseEntity<Purchase> addPur(@RequestBody Purchase purchase) throws productnotFoundException {
//        Optional<Product> product = productRepo.findById(purchase.getProductId());
//
//        if (product.isEmpty()) {
//            throw new productnotFoundException("no product found");
//        }
//
//        purchaseService.addPurchase(purchase, product.get());
//        return new ResponseEntity<>(purchase, HttpStatus.ACCEPTED);
//    }

    @PostMapping("/stock")
    public ResponseEntity<Purchase> addpur1(@RequestBody Purchase purchase) {
        Product product = productRepo.findById(purchase.getProductId()).get();
       purchaseService.addPurchase(purchase);

       //to check product exist or not
        if (product!=null) {
            Stock stockAdd = stockRepo.findById(purchase.getProductId()).orElse(null);

//            to check ordered item is in stock or not
            if (stockAdd!=null) {
                Stock stock=new Stock();
                stock.setQuantity(purchase.getQuantity()+stockAdd.getQuantity());
                stock.setPrice(purchase.getPrice()+stockAdd.getPrice());
                stock.setName(purchase.getName());
                stock.setProductId(purchase.getProductId());
                stock.setId(purchase.getProductId());
                stock.setTotalAmount((purchase.getPrice()+stockAdd.getPrice())*(stockAdd.getQuantity()+ purchase.getQuantity()));
                stockRepo.save(stock);

            }else if (stockAdd==null) {
                Stock stock = new Stock();

                stock.setQuantity(purchase.getQuantity());

                stock.setTotalAmount(purchase.getPrice()*purchase.getQuantity());

                stock.setProductId(purchase.getProductId());
                stock.setPrice(purchase.getPrice());
                stock.setName(purchase.getName());
                stock.setId(purchase.getProductId());
                stockRepo.save(stock);
            }

        }
        return new ResponseEntity<>(purchase,HttpStatus.ACCEPTED);
    }
}
