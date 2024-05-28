package com.amdocs.products.services;

import com.amdocs.products.entities.Pricing;
import com.amdocs.products.entities.Products;
import com.amdocs.products.repository.PricingRepository;
import com.amdocs.products.repository.ProductsRepository;
import com.amdocs.products.request.PricingRequest;
import com.amdocs.products.request.ProductsRequest;
import jakarta.persistence.EntityNotFoundException;
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

    public List<Products> getAllProducts() {

        List<Products> products = new ArrayList<>();
        productsRepository.findAll().forEach(products::add);
        return products;
    }


    public Optional<Products> getProduct(Integer productId) {
        Optional<Products> product = productsRepository.findById(productId);
        return product;
    }


    public void addProduct(ProductsRequest productsRequest) {
        Products product = new Products();
        product.setProductName(productsRequest.getProductName());
        product.setDescription(productsRequest.getDescription());

        Pricing pricing = pricingRepository.findById(productsRequest.getPricingId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el precio con el ID: " + productsRequest.getPricingId()));
        product.setPricing(pricing);
        product.setCreationDate(LocalDate.now());
        productsRepository.save(product);
    }
}


//    public void addProduct(Products products) {
//           LocalDate date = LocalDate.now();
//            products.setCreationDate(date);
//            products.getPricing().setCreationDate(date);
//            productsRepository.save(products);
//        }
//    }




