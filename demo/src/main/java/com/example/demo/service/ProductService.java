package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.exception.productnotFoundException;
import com.example.demo.repository.CategoRepo;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoRepo categoRepo;
    public void saveProduct(Product product,Category category) {

        product.setCategoryId(category.getId());


            productRepo.save(product);

    //    }else
      //      System.out.println("duplicate");
    }

//    public Product findById(int productId) throws productnotFoundException {
////        Product product=new Product();
//        Optional<Product> byId;
//        byId = productRepo.findById(productId);
//
//        if (byId.isEmpty()){
//
//            throw new productnotFoundException("not a valid product:"+productId);
//        }
//        return byId.get();
//
//    }
}
