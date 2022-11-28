package com.example.demo.controller;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoRepo;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoRepo categoRepo;

    @PostMapping("/save")
    public ResponseEntity<Product>post(@RequestBody Product product) throws Exception {
      Optional<Category> cate= categoRepo.findById(product.getCategoryId());
        if (!cate.isPresent()){
            throw new Exception("category not found");
//            return new ResponseEntity<>( product,HttpStatus.ALREADY_REPORTED);
        }
        productService.saveProduct(product,cate.get());
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

}
