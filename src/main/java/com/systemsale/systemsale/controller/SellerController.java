package com.systemsale.systemsale.controller;

import com.systemsale.systemsale.dto.SellerDTO;
import com.systemsale.systemsale.entity.Seller;
import com.systemsale.systemsale.service.seller.SellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/vendedores")
public class SellerController {
    @Autowired
    private SellerServiceImpl sellerService;

    @PostMapping
    public ResponseEntity<SellerDTO> create(@RequestBody Seller seller) {
        try {
            SellerDTO objSeller = sellerService.create(seller);
            return ResponseEntity.created(new URI("/api/vendedores" + objSeller.getId())).body(objSeller);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<SellerDTO>> read() {
        return ResponseEntity.ok(sellerService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readById(@PathVariable Long id) {
        SellerDTO seller = sellerService.readById(id);
        if (seller == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seller);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Seller seller) {
        var seller1 = sellerService.readById(id);
        if (seller1 == null) return ResponseEntity.notFound().build();
        seller.setId(seller1.getId());
        SellerDTO objSeller = sellerService.update(seller);
        return ResponseEntity.ok(objSeller);
    }

}
