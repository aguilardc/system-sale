package com.systemsale.systemsale.repository;

import com.systemsale.systemsale.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
