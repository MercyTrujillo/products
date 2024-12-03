package com.amdocs.products.response;

public class PricingResponse {

    private double price;


    private double discount;

    private double tax;

    private String image;

    public PricingResponse(double price, double discount, double tax, String image) {
        this.price = price;
        this.discount = discount;
        this.tax = tax;
        this.image = image;
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

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
