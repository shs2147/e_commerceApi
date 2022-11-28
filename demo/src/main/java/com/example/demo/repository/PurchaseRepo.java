package com.example.demo.repository;

import com.example.demo.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface PurchaseRepo extends JpaRepository<Purchase,Integer> {
}
