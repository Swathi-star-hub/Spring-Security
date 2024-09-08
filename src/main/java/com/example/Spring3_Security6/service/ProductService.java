package com.example.Spring3_Security6.service;
import com.example.Spring3_Security6.dto.Product;
import com.example.Spring3_Security6.entity.UserInfo;
import com.example.Spring3_Security6.repo.ProductRepo;
import com.example.Spring3_Security6.repo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
    public class ProductService {
        List<Product> productList = null;
        @Autowired
        private UserInfoRepository repository;
        @Autowired
        private PasswordEncoder passwordEncoder;
        @Autowired
        private ProductRepo repo;
        public com.example.Spring3_Security6.entity.Product save(com.example.Spring3_Security6.entity.Product product){
        return repo.save(product);
        }
        public List<com.example.Spring3_Security6.entity.Product> getProducts() {
            return repo.findAll();
        }
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

