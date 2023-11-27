package com.systemsale.systemsale.repository.jpa.custom.customer;

import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.repository.jpa.custom.RepositoryException;

import java.util.List;

public interface ICustomerUSPRepository {
    Boolean insert(Customer customer) throws RepositoryException;

    List<Customer> find(Customer customer) throws RepositoryException;
}
