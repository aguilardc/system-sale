package com.systemsale.systemsale.service.customer;


import com.systemsale.systemsale.dto.CustomerDTO;
import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.repository.ICustomerRepository;
import com.systemsale.systemsale.service.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerServiceImpl(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() throws ServiceException {
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Customer> findLikeObject(String name) throws ServiceException {
        try {
            return null;
        } catch (Exception e) {
            throw new ServiceException();
        }
    }

    @Override
    public Optional<Customer> findById(Long id) throws ServiceException {
        try {
            return customerRepository.findById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Customer save(Customer customer) throws ServiceException {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Customer update(Customer customer) throws ServiceException {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Boolean delete(Customer customer) throws ServiceException {
        return null;
    }
}
