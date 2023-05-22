package com.luciano.springcloud.repository;

import com.luciano.springcloud.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findByCode( String code );
}
