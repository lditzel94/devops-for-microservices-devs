package com.luciano.springcloud.repository;

import com.luciano.springcloud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
