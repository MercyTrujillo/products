package com.amdocs.products.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="pricing")
public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement ID]
    @Column(name = "id")
    private Integer id;


    @OneToOne(mappedBy = "pricing")
    private Products product;


    private double price;

    private double tax;

    private double discount;

    @CreatedDate
    @Column(name = "creationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;


    public Pricing() {
    }


    public Pricing(double price, double tax, double discount, LocalDate creationDate) {
        this.price = price;
        this.tax = tax;
        this.discount = discount;
        this.creationDate = creationDate;
    }

    public Integer getPricingId() {
        return id;
    }

    public void setPricingId(Integer pricingId) {
        this.id = pricingId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}