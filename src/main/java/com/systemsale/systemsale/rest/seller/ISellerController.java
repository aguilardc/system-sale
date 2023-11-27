package com.systemsale.systemsale.rest.seller;

import com.systemsale.systemsale.entity.Seller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ISellerController {
    @GetMapping
    public ResponseEntity<?> findAll();

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Seller seller);

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id);
}
