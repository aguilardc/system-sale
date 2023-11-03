package com.systemsale.systemsale.service.customer;

import com.systemsale.systemsale.dto.CustomerDTO;
import com.systemsale.systemsale.entity.Customer;

import java.util.List;


public interface ICustomerService {
    CustomerDTO create(Customer customer);

    List<CustomerDTO> read();

    CustomerDTO readById(Long id);

    CustomerDTO update(Customer customer);

    Boolean delete(Long id);
}
