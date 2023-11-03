package com.systemsale.systemsale.controller;

import com.systemsale.systemsale.dto.ProductDTO;
import com.systemsale.systemsale.entity.Product;
import com.systemsale.systemsale.service.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody Product product) {
        try {
            ProductDTO objProduct = productService.create(product);
            return ResponseEntity.created(new URI("/api/productos" + objProduct.getId())).body(objProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> read() {
        return ResponseEntity.ok(productService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readById(@PathVariable Long id) {
        ProductDTO product = productService.readById(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Product product) {
        var product1 = productService.readById(id);
        if (product1 == null) return ResponseEntity.notFound().build();
        product.setId(product1.getId());
        ProductDTO objProduct = productService.update(product);
        return ResponseEntity.ok(objProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        var product = productService.readById(id);
        if (product == null) return ResponseEntity.notFound().build();
        if (productService.delete(product.getId())) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
