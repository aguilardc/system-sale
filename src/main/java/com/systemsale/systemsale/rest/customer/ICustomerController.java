package com.systemsale.systemsale.rest.customer;

import com.systemsale.systemsale.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ICustomerController {

    @GetMapping
    ResponseEntity<?> findAll();

    @PostMapping
    ResponseEntity<?> save(@RequestBody Customer customer);

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable Long id);

    @GetMapping("/find")
    ResponseEntity<?> findByLike(@RequestParam String dni);
}
