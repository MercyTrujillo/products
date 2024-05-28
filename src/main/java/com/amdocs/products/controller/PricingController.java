package com.amdocs.products.controller;

import com.amdocs.products.ProductsApplication;
import com.amdocs.products.entities.Pricing;
import com.amdocs.products.request.PricingRequest;
import com.amdocs.products.services.PricingService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

  //This endpoint adds a Price to DB
//    @RequestMapping(method = RequestMethod.POST, value = "/pricing")
//    public void addPrice(@RequestBody Pricing pricing){
//        pricingService.addPrice(pricing);
//    }


    @RequestMapping(method = RequestMethod.POST, value = "/pricing")
    public ResponseEntity<String> addPrice(@RequestBody PricingRequest request){
        log.info("Price add successfull");
        pricingService.addPrice(request);
        String message = "ok!!!!!";
        return ResponseEntity.status(HttpStatus.OK).body(message);

    }
}
