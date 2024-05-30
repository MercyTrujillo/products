package com.amdocs.products.request;

public class PricingRequest {

    private double price;

    private double tax;

    private double discount;


    public PricingRequest(double price, double tax, double discount) {
        this.price = price;
        this.tax = tax;
        this.discount = discount;

    }
    public PricingRequest(){

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }



    @Override
    public String toString() {
        return "PricingRequest{" +
                "price=" + price +
                ", tax=" + tax +
                ", discount=" + discount +
                '}';
    }
}
