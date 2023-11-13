package com.systemsale.systemsale.service.customer;

import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.service.IGenericService;
import jakarta.transaction.Transactional;


@Transactional()
public interface ICustomerService extends IGenericService<Customer> {
}
