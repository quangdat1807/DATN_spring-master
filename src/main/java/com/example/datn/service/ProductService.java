package com.example.datn.service;

import com.example.datn.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    

    @Autowired
    ProductRepository productRepository;
}
