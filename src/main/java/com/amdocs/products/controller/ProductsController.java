package com.amdocs.products.controller;

import com.amdocs.products.entities.Products;
import com.amdocs.products.request.PricingRequest;
import com.amdocs.products.request.ProductsRequest;
import com.amdocs.products.services.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
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
    public Optional<Products> getProductById(@PathVariable Integer productId){
        return productsService.getProductById(productId);

    }


    @RequestMapping(method = RequestMethod.GET, value = "/products/name/{productName}")
    public ResponseEntity<Products> getProductByName(@PathVariable String productName) {
        Optional<Products> product = productsService.getProductByName(productName);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }





    @RequestMapping(method = RequestMethod.POST,value = "/products")
    public ResponseEntity<String> addProduct(@RequestBody ProductsRequest request){
        log.info("Product add successfull");;
        productsService.addProduct(request);
        String message = "Added product!";
        return ResponseEntity.status(HttpStatus.OK).body(message);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/products/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile image, @RequestParam("productId") String productId) {
        if (image.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No image selected");
        }

        if (productId == null || productId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product ID is missing");
        }
        try {
            String uploadDirectory = "src/main/resources/static/assets/";
            String imagesString = "";
                imagesString += productsService.saveImageToStorage(uploadDirectory, image, productId);


            return ResponseEntity.ok()
                    .cacheControl(CacheControl.noCache().cachePrivate())
                    .body("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }





}
