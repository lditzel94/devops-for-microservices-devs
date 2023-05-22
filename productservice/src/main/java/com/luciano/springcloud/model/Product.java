package com.luciano.springcloud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Product {

    @Id
    @GeneratedValue( strategy = IDENTITY )
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    @Transient
    private String couponCode;

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode( String couponCode ) {
        this.couponCode = couponCode;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice( BigDecimal price ) {
        this.price = price;
    }
}
