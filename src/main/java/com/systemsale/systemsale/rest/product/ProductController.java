package com.systemsale.systemsale.rest.product;

import com.systemsale.systemsale.entity.Product;
import com.systemsale.systemsale.rest.GenericController;
import com.systemsale.systemsale.service.product.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/products")
public class ProductController extends GenericController implements IProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return super.list(this.productService.findAll());
        } catch (Exception e) {
            log.error(e.getMessage());
            return super.internalError();
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product product) {
        try {
            return super.created(this.productService.save(product));
        } catch (Exception e) {
            log.error(e.getMessage());
            return super.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Optional<Product> product = this.productService.findById(id);
            if (isNull(product) || product.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return super.internalError();
        }
    }
}
