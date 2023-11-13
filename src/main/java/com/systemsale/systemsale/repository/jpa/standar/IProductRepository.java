package com.systemsale.systemsale.repository.jpa.standar;

import com.systemsale.systemsale.entity.Product;
import com.systemsale.systemsale.repository.jpa.standar.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends IGenericRepository<Product, Long> {
}
