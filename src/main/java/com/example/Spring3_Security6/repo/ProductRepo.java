package com.example.Spring3_Security6.repo;

import com.example.Spring3_Security6.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
