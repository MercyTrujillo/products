package com.amdocs.products.services;

import com.amdocs.products.entities.Products;
import com.amdocs.products.repository.PricingRepository;
import com.amdocs.products.repository.ProductsRepository;
import com.amdocs.products.request.ProductsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.StreamUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.*;

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


    public Optional<Products> getProductByName(String productName) {
        return productsRepository.findByProductName(productName);
    }

    public String saveImageToStorage(String uploadDirectory, MultipartFile image, String productId)  throws IOException {
        String uniqueFileName = productId;

        Path uploadPath = Path.of(uploadDirectory);
        Path filePath = uploadPath.resolve(uniqueFileName);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return uniqueFileName;
    }

}




