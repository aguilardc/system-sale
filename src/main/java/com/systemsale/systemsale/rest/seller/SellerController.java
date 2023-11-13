package com.systemsale.systemsale.rest.seller;

import com.systemsale.systemsale.entity.Seller;
import com.systemsale.systemsale.rest.GenericController;
import com.systemsale.systemsale.service.seller.SellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/vendedores")
public class SellerController extends GenericController implements ISellerController {
    @Override
    public ResponseEntity<?> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> save(Seller seller) {
        return null;
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        return null;
    }
}
