package com.amdocs.products.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="products")
public class Products {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement ID
    @Column(name = "product_id")
    private Integer productId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pricing_id", referencedColumnName = "id")
    private Pricing pricing;

    private String productName;
    private String description;




    private String image;




    @CreatedDate
    @Column(name = "creation_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    public Products() {

    }

    public Products(Pricing pricing, String productName, String description, LocalDate creationDate, String image) {
        this.pricing = pricing;
        this.productName = productName;
        this.description = description;
        this.creationDate = creationDate;
        this.image = image;

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    @JsonManagedReference
    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

