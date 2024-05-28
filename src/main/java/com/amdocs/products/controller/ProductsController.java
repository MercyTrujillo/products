package com.amdocs.products.controller;

import com.amdocs.products.entities.Pricing;
import com.amdocs.products.entities.Products;
import com.amdocs.products.repository.ProductsRepository;
import com.amdocs.products.request.PricingRequest;
import com.amdocs.products.request.ProductsRequest;
import com.amdocs.products.services.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    private static final Logger log = LoggerFactory.getLogger(PricingController.class);

    //TODOS LOS PRODUCTOS
    @RequestMapping(method = RequestMethod.GET,value = "/products")
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }

    //UN PRODUCTO POR ID
    @RequestMapping(method = RequestMethod.GET,value = "/products/{productId}")
    public Optional<Products> getProduct(@PathVariable Integer productId){
        return productsService.getProduct(productId);

    }


//    @RequestMapping(method = RequestMethod.POST, value = "/products")
//    public void addProduct(@RequestBody Products products){
//
//        productsService.addProduct(products);
//
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public ResponseEntity<String> addProduct(@RequestBody ProductsRequest request){
        log.info("Product add successfull");
        productsService.addProduct(request);
        String message = "ok!!!!!";
        return ResponseEntity.status(HttpStatus.OK).body(message);

    }


}
