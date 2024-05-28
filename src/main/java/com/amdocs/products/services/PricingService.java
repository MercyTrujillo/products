package com.amdocs.products.services;

import com.amdocs.products.entities.Pricing;
import com.amdocs.products.request.PricingRequest;
import com.amdocs.products.repository.PricingRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PricingService {

    private static final Logger log = LoggerFactory.getLogger(PricingService.class);

    @Autowired
    public PricingRepository pricingRepository;

    public List<Pricing> getAllPricings() {
        List<Pricing> pricings = new ArrayList<>();
        pricingRepository.findAll().forEach(pricings:: add);
        return pricings;
    }

    public void addPrice(PricingRequest pricingRequest) {

        Pricing pricing = new Pricing();

        pricing.setPrice(pricingRequest.getPrice());
        pricing.setTax(pricingRequest.getTax());
        pricing.setDiscount(pricingRequest.getDiscount());
        pricing.setCreationDate(LocalDate.now());

        pricingRepository.save(pricing);
    }
}
