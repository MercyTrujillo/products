package com.amdocs.products.response;

import com.amdocs.products.entities.Pricing;

import java.time.LocalDate;
import java.util.UUID;

public class ProductsResponse {


    private String productName;
    private String description;

    private Pricing pricing;

    private LocalDate date;

    private Integer pricingId;


    public ProductsResponse(String productName, String description, Pricing pricing, LocalDate date, Integer pricingId) {

        this.productName = productName;
        this.description = description;
        this.pricing = pricing;
        this.date = date;
        this.pricingId =pricingId;

    }




    public Integer getPricingId() {
        return pricingId;
    }

    public void setPricingId(Integer pricingId) {
        this.pricingId = pricingId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public Pricing getPricing() {
        return pricing;
    }


    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



}
