package com.systemsale.systemsale.repository.jpa.custom.customer;

import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.repository.jpa.custom.RepositoryException;

import java.util.List;
import java.util.Optional;

public class CustomerUSPRepositoryImpl implements ICustomerUSPRepository {

    public CustomerUSPRepositoryImpl() {
    }

    @Override
    public List<Customer> findAll() throws RepositoryException {
        return null;
    }

    @Override
    public List<Customer> findLikeObject(Customer customer) throws RepositoryException {
        return null;
    }

    @Override
    public Optional<Customer> findById(Customer customer) throws RepositoryException {
        return Optional.empty();
    }

    @Override
    public Customer save(Customer customer) throws RepositoryException {
        return null;
    }

    @Override
    public Customer update(Customer customer) throws RepositoryException {
        return null;
    }

    @Override
    public Boolean findAll(Customer customer) throws RepositoryException {
        return null;
    }
}
