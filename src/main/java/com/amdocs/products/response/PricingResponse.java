package com.amdocs.products.response;

public class PricingResponse {

    private double price;


    private double discount;


    public PricingResponse(double price, double discount) {
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount(){
        return discount;
    }

    public void setDiscount(double discount){
        this.discount = discount;
    }
}
