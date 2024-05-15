package com.amdocs.products.services;

import com.amdocs.products.entities.Pricing;
import com.amdocs.products.repository.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PricingService {

    @Autowired
    public PricingRepository pricingRepository;

    public List<Pricing> getAllPricings() {
        List<Pricing> pricings = new ArrayList<>();
        pricingRepository.findAll().forEach(pricings:: add);
        return pricings;
    }

    public void addPrice(Pricing pricing) {
        pricing.setCreationDate(LocalDate.now());


        pricingRepository.save(pricing);
    }
}
