package com.systemsale.systemsale.rest;


import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.service.customer.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final ICustomerService customerService;

    public CustomerController(final ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            List<Customer> lstCustomer = this.customerService.findAll();
            if (isNull(lstCustomer) || lstCustomer.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lstCustomer, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
