package com.amdocs.products.services;

import com.amdocs.products.entities.Products;
import com.amdocs.products.repository.PricingRepository;
import com.amdocs.products.repository.ProductsRepository;
import com.amdocs.products.request.ProductsRequest;
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


    public Optional<Products> getProductById(Integer productId) {
        Optional<Products> product = productsRepository.findById(productId);
        return product;
    }



    public void addProduct(ProductsRequest productsRequest) {
        Products product = new Products();
        product.setProductName(productsRequest.getProductName());
        product.setDescription(productsRequest.getDescription());
        product.setPricing(productsRequest.getPricing());
        product.setCreationDate(LocalDate.now());
        product.getPricing().setCreationDate(LocalDate.now());
        pricingRepository.save(productsRequest.getPricing());
        productsRepository.save(product);
    }
}





