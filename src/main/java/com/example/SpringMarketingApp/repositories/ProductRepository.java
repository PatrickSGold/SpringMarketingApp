package com.example.SpringMarketingApp.repositories;

import com.example.SpringMarketingApp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
