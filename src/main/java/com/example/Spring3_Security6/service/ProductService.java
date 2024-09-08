package com.example.Spring3_Security6.service;

import com.example.Spring3_Security6.dto.Product;
import com.example.Spring3_Security6.entity.UserInfo;
import com.example.Spring3_Security6.repo.ProductRepo;
import com.example.Spring3_Security6.repo.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        @Autowired
        private ProductRepo repo;


    /*@PostConstruct
    public void loadProductsFromDB() {
        List<Product> productList=null;
        productList = Stream.of(new Product(1, "Swathi", 4, 20000.00),
                new Product(2, "varu", 3, 30000.00)
        ).collect(Collectors.toList());
    }*/

    public com.example.Spring3_Security6.entity.Product save(com.example.Spring3_Security6.entity.Product product){
       return repo.save(product);
    }
        public List<com.example.Spring3_Security6.entity.Product> getProducts() {
            return repo.findAll();
        }

       /* public Product getProduct(Integer productId) {
            return productList.stream()
                    .filter(product -> product.getProductId() == productId)
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("product " + productId+ " not found"));
        }*/
    public com.example.Spring3_Security6.entity.Product getProduct(Integer productId){
        Optional<com.example.Spring3_Security6.entity.Product> byId = repo.findById(productId);
        if(byId.isPresent()){
            return byId.get();
        }else{
            repo.findAll();
        }
        return null;
    }


        public String addUser(UserInfo userInfo) {
            userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
            repository.save(userInfo);
            return "user added to system ";
        }
    }

