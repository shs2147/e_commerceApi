package com.example.demo.controller;

import com.example.demo.entity.SaleProduct;
import com.example.demo.service.SaleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleController {
    @Autowired
    SaleProductService saleProductService;


    @GetMapping("/service")
    public List<SaleProduct> sale(){
        List<SaleProduct>ssss= saleProductService.getallP();
        return ssss;

    }
    @PostMapping("/sale")
    public ResponseEntity<String>saleInfo(@RequestBody SaleProduct saleProduct){
        String a=saleProductService.saveSAle(saleProduct);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }
}
