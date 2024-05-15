package com.amdocs.products.controller;

import com.amdocs.products.entities.Pricing;
import com.amdocs.products.services.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @RequestMapping(method = RequestMethod.GET, value = "/pricing")
    public List<Pricing> getAllPricings(){
        return pricingService.getAllPricings();
    }

  //This endpoint adds a Price to DB
    @RequestMapping(method = RequestMethod.POST, value = "/pricing")
    public void addPrice(@RequestBody Pricing pricing){
        pricingService.addPrice(pricing);
    }

}
