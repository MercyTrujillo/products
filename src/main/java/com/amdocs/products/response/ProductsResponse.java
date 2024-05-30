package com.amdocs.products.response;

import com.amdocs.products.entities.Pricing;

import java.time.LocalDate;

public class ProductsResponse {

    private String productName;
    private String description;

    private Pricing pricing;

    private LocalDate date;

    public ProductsResponse(String productName, String description, Pricing pricing, LocalDate date) {
        this.productName = productName;
        this.description = description;
        this.pricing = pricing;
        this.date = date;
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
