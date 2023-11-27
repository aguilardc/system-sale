package com.systemsale.systemsale.service.customer;

import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.service.IGenericService;
import com.systemsale.systemsale.service.ServiceException;
import jakarta.transaction.Transactional;

import java.util.List;


@Transactional()
public interface ICustomerService extends IGenericService<Customer> {

    Boolean saveUSP(Customer customer) throws ServiceException;
}
