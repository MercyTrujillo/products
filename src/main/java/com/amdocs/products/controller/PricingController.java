package com.amdocs.products.controller;

import com.amdocs.products.ProductsApplication;
import com.amdocs.products.entities.Pricing;
import com.amdocs.products.entities.Products;
import com.amdocs.products.request.PricingRequest;
import com.amdocs.products.services.PricingService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class PricingController {



    @Autowired
    private PricingService pricingService;
    private static final Logger log = LoggerFactory.getLogger(PricingController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/pricing")
    public List<Pricing> getAllPricings(){
        return pricingService.getAllPricings();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/pricing/{id}")
    public Optional<Pricing> getPriceById(@PathVariable Integer id){
        return pricingService.getPriceById(id);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/pricing")
    public ResponseEntity<String> addPrice(@RequestBody PricingRequest request){
        log.info("Price add successfull");
        pricingService.addPrice(request);
        String message = "ok!!!!!";
        return ResponseEntity.status(HttpStatus.OK).body(message);

    }
}
