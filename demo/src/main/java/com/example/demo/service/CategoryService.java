package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryService {
    @Autowired
    CategoRepo categoRepo;
//     public List<Category>all(Category category){
//        List<Category>lll= categoRepo.findAll().stream().map(li-> this.match(li)).collect(Collectors.toList());
//        return lll;
//     }
     public void saveCat(Category category){
         categoRepo.save(category);
     }

//     public Category match(Category product){
//         Category category=new Category();
//         return category;
//     }
}
