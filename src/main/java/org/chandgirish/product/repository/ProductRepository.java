package org.chandgirish.product.repository;

import org.chandgirish.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //for admins to search based on sku
    Optional<Product> findBySku(String sku);
}
