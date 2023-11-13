package com.systemsale.systemsale.repository.jpa.standar;

import com.systemsale.systemsale.entity.Seller;
import com.systemsale.systemsale.repository.jpa.standar.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISellerRepository extends IGenericRepository<Seller, Long> {
}
