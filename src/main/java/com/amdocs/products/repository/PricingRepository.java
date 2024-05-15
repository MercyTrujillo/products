package com.amdocs.products.repository;

import com.amdocs.products.entities.Pricing;
import org.springframework.data.repository.CrudRepository;

public interface PricingRepository extends CrudRepository <Pricing, Integer> {
}
