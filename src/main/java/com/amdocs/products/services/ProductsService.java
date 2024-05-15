package com.amdocs.products.services;

import com.amdocs.products.entities.Pricing;
import com.amdocs.products.entities.Products;
import com.amdocs.products.repository.PricingRepository;
import com.amdocs.products.repository.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductsService {

    @Autowired
    public ProductsRepository productsRepository;



    @Autowired
    public PricingRepository pricingRepository;

    public List<Products> getAllProducts(){
        List<Products> products = new ArrayList<>();
        productsRepository.findAll().forEach(products::add);
        return products;
    }


    public Optional<Products> getProduct(Integer productId) {
        Optional<Products> product = productsRepository.findById(productId);
        return product;
    }




    public void addProduct(Products products) {
           LocalDate date = LocalDate.now();
            products.setCreationDate(date);
            products.getPricing().setCreationDate(date);
            productsRepository.save(products);
        }
    }




