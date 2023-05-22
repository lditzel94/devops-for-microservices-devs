package com.luciano.springcloud.controller;

import com.luciano.springcloud.model.Coupon;
import com.luciano.springcloud.repository.CouponRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/coupon-api" )
public class CouponRestController {

    private final CouponRepository repository;

    public CouponRestController( CouponRepository repository ) {
        this.repository = repository;
    }

    @PostMapping( "/coupons" )
    public Coupon create( @RequestBody Coupon coupon ) {
        return repository.save( coupon );
    }

    @GetMapping( "/coupons/{code}" )
    public Coupon getCoupon( @PathVariable String code ) {
        return repository.findByCode( code );
    }
}
