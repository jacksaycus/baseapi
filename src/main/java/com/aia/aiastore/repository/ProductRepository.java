package com.aia.aiastore.repository;

import com.aia.aiastore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  }