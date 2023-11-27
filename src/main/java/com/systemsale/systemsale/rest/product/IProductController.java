package com.systemsale.systemsale.rest.product;


import com.systemsale.systemsale.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IProductController {
    @GetMapping
    public ResponseEntity<?> findAll();

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product product);

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id);
}
