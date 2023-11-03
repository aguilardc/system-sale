package com.systemsale.systemsale.service.customer;


import com.systemsale.systemsale.dto.CustomerDTO;
import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.mapper.CustomerMapper;
import com.systemsale.systemsale.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerDTO create(Customer customer) {
        Customer customer1 = customerRepository.save(customer);
        return customerMapper.toDTO(customer1);
    }

    public List<CustomerDTO> read() {
        var customer = customerRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return customerMapper.toDTOList(customer);
    }


    public CustomerDTO readById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(value -> customerMapper.toDTO((Customer) value)).orElse(null);
    }

    public CustomerDTO update(Customer customer) {
        Customer customer1 = customerRepository.save(customer);
        return customerMapper.toDTO(customer1);
    }

    public Boolean delete(Long id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
