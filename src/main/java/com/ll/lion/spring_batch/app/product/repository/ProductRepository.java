package com.ll.lion.spring_batch.app.product.repository;

import com.ll.lion.spring_batch.app.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
