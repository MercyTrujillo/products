package com.amdocs.products.request;

import com.amdocs.products.entities.Pricing;

public class ProductsRequest {

    private String productName;
    private String description;

    private Pricing pricing;

    private PricingRequest pricingRequest;

    public ProductsRequest(String productName, String description, PricingRequest pricingRequest, Pricing pricing) {
        this.productName = productName;
        this.description = description;
        this.pricing = pricing;
        this.pricingRequest = pricingRequest;
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

    public PricingRequest pricingRequest() {
        return pricingRequest;
    }

    public void setPricingRequest(PricingRequest pricingRequest) {
        this.pricingRequest = pricingRequest;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing){
         this.pricing = pricing;
    }

}
