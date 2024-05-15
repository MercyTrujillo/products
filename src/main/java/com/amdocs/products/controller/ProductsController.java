package com.amdocs.products.controller;

import com.amdocs.products.entities.Pricing;
import com.amdocs.products.entities.Products;
import com.amdocs.products.repository.ProductsRepository;
import com.amdocs.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;


    @RequestMapping(method = RequestMethod.GET,value = "/products")
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/products/{productId}")
    public Optional<Products> getProduct(@PathVariable Integer productId){
        return productsService.getProduct(productId);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public void addProduct(@RequestBody Products products){

        productsService.addProduct(products);

    }


}
