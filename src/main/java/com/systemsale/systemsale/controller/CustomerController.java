package com.systemsale.systemsale.controller;


import com.systemsale.systemsale.dto.CustomerDTO;
import com.systemsale.systemsale.entity.Customer;
import com.systemsale.systemsale.service.customer.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/clientes")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody Customer customer) {
        try {
            CustomerDTO objCustomer = customerService.create(customer);
            return ResponseEntity.created(new URI("/api/clientes" + objCustomer.getId())).body(objCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> read() {
        return ResponseEntity.ok(customerService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readById(@PathVariable Long id) {
        CustomerDTO customer = customerService.readById(id);
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(customer);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Customer customer) {
        var customer1 = this.customerService.readById(id);
        if (customer1 == null) return  ResponseEntity.notFound().build();
        customer.setId(customer1.getId());
        CustomerDTO objCustomer = customerService.update(customer);
        return  ResponseEntity.ok(objCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        var customer = customerService.readById(id);
        if (customer == null) return ResponseEntity.notFound().build();
        if(customerService.delete(customer.getId())) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
