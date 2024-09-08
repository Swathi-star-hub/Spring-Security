package com.example.Spring3_Security6.controller;

import com.example.Spring3_Security6.dto.AuthRequest;
import com.example.Spring3_Security6.entity.Product;
import com.example.Spring3_Security6.entity.UserInfo;
import com.example.Spring3_Security6.service.JwtService;
import com.example.Spring3_Security6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    @PostMapping("/save")
    public com.example.Spring3_Security6.entity.Product save(@RequestBody com.example.Spring3_Security6.entity.Product product) {
        return service.save(product);
    }

    @GetMapping("/all")
    public List<com.example.Spring3_Security6.entity.Product> getAllTheProducts() {
        return service.getProducts();
    }

    @GetMapping("/fetch/{productId}")
    public Product getProductById(@PathVariable Integer productId) {
        return service.getProduct(productId);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("user is invalid!!!");
        }
    }
}


