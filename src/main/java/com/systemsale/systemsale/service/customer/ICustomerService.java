package com.systemsale.systemsale.service.customer;

import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.service.ServiceException;

import java.util.List;
import java.util.Optional;


public interface ICustomerService {
    List<Customer> findAll() throws ServiceException;

    List<Customer> findLikeObject(String name) throws ServiceException;

    Optional<Customer> findById(Long id) throws ServiceException;

    Customer save(Customer customer) throws ServiceException;

    Customer update(Customer customer) throws ServiceException;

    Boolean delete(Customer customer) throws ServiceException;
}
