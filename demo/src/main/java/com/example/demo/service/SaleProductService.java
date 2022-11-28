package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.SaleProduct;
import com.example.demo.entity.Stock;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.SaleRepo;
import com.example.demo.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleProductService {
    @Autowired
    SaleRepo saleRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    StockRepo stockRepo;

    public List<SaleProduct> getallP() {
        List<Product> saaa = this.productRepo.findAll();

      List<SaleProduct>was=saaa.stream().map(li->this.tow(li)).collect(Collectors.toList());
      return was;
    }

    public SaleProduct tow(Product productof) {
        SaleProduct product = new SaleProduct();

        product.setPrice(productof.getPrice());
        product.setQuantity(productof.getQuantity());
        product.setId(productof.getId());
        product.setItemName(productof.getItemName());
        saleRepo.save(product);
        return product;
    }
     public List<SaleProduct>allSale(){
       return saleRepo.findAll();

    }
    public String saveSAle(SaleProduct saleProduct){
       Stock stock=stockRepo.findById(saleProduct.getProductId()).orElse(null);


       String message = new String();
        if (stock!=null) {
            if (saleProduct.getQuantity()<= stock.getQuantity()) {
                saleProduct.setTotalAmount(saleProduct.getQuantity()* saleProduct.getPrice());
                saleProduct.setItemName(stock.getName());
                stock.setQuantity(stock.getQuantity()-saleProduct.getQuantity());
                stock.setTotalAmount(stock.getQuantity()* stock.getPrice());
                saleRepo.save(saleProduct);


                stockRepo.save(stock);
                message="hurraayy order success";


            }else {
                System.out.println("not enough quantity");
                message="oops not enough quantity";

            }

        }

        return message;
    }

}
