package com.systemsale.systemsale.rest.customer;

import com.systemsale.systemsale.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICustomerController {

    @GetMapping
    public ResponseEntity<?> findAll();

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Customer customer);

    @GetMapping
    public ResponseEntity<?> findById(@PathVariable Long id);
}
