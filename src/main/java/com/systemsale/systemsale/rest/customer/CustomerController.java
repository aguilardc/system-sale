package com.systemsale.systemsale.rest.customer;


import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.rest.GenericController;
import com.systemsale.systemsale.rest.constants.APIEndPoint;
import com.systemsale.systemsale.service.customer.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(APIEndPoint.API_CUSTOMERS)
public class CustomerController extends GenericController implements ICustomerController {
    private final ICustomerService customerService;

    public CustomerController(final ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return super.list(this.customerService.findAll());
        } catch (Exception e) {
            log.error(e.getMessage());
            return super.internalError();
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Customer customer) {
        try {
            return super.created(this.customerService.save(customer));
        } catch (Exception e) {
            log.error(e.getMessage());
            return super.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Optional<Customer> customer = this.customerService.findById(id);
            if (isNull(customer) || customer.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return super.internalError();
        }
    }


}
