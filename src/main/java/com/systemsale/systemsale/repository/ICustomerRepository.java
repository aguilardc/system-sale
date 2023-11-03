package com.systemsale.systemsale.repository;

import com.systemsale.systemsale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
