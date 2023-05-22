package com.luciano.springcloud.controller;

import com.luciano.springcloud.model.Coupon;
import com.luciano.springcloud.model.Product;
import com.luciano.springcloud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping( "/product-api" )
public class ProductRestController {

    private final ProductRepository repository;
    private final RestTemplate restTemplate;
    @Value( "${microservices.coupon.url}" )
    private String couponUrl;

    public ProductRestController( ProductRepository repository, RestTemplate restTemplate ) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @PostMapping( "/products" )
    public Product create( @RequestBody Product product ) {
        Coupon coupon = restTemplate.getForObject( couponUrl + product.getCouponCode(), Coupon.class );
        product.setPrice( product.getPrice().subtract( coupon.getDiscount() ) );
        return repository.save( product );
    }

    public Product sendErrorResponse( Product product ) {
        return product;
    }

}
