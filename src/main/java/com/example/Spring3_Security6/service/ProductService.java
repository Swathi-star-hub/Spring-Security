package com.example.Spring3_Security6.service;

import com.example.Spring3_Security6.dto.Product;
import com.example.Spring3_Security6.entity.UserInfo;
import com.example.Spring3_Security6.repo.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@Service
    public class ProductService {

        List<Product> productList = null;

        @Autowired
        private UserInfoRepository repository;

        @Autowired
        private PasswordEncoder passwordEncoder;



    @PostConstruct
    public void loadProductsFromDB() {
        List<Product> productList=null;
        productList = Stream.of(new Product(1, "Swathi", 4, 20000.00),
                new Product(2, "varu", 3, 30000.00)
        ).collect(Collectors.toList());
    }
        public List<Product> getProducts() {
            //return repository.findAll();
            return productList;
        }

        public Product getProduct(int productId) {
            return productList.stream()
                    .filter(product -> product.getProductId() == productId)
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("product " + productId+ " not found"));
        }


        public String addUser(UserInfo userInfo) {
            userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
            repository.save(userInfo);
            return "user added to system ";
        }
    }

