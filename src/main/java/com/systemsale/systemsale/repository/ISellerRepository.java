package com.systemsale.systemsale.repository;

import com.systemsale.systemsale.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISellerRepository extends JpaRepository<Seller, Long> {
}
