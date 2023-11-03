package com.systemsale.systemsale.mapper;

import com.systemsale.systemsale.dto.CustomerDTO;
import com.systemsale.systemsale.entity.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO clientDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, clientDTO);
        return clientDTO;
    }

    public List<CustomerDTO> toDTOList(List<Customer> customerList) {
        return customerList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);

        return customer;
    }
}
