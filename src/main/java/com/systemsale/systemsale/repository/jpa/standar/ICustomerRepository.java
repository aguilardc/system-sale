package com.systemsale.systemsale.repository.jpa.standar;

import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.repository.jpa.standar.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends IGenericRepository<Customer, Long> {
}
