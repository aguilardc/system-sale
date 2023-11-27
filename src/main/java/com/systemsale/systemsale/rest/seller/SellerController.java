package com.systemsale.systemsale.rest.seller;

import com.systemsale.systemsale.entity.Seller;
import com.systemsale.systemsale.rest.GenericController;
import com.systemsale.systemsale.service.seller.ISellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/sellers")
public class SellerController extends GenericController implements ISellerController {

    private final ISellerService sellerService;

    public SellerController(ISellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public ResponseEntity<?> findAll() {
        try {
            return super.list(this.sellerService.findAll());
        } catch (Exception e) {
            log.error(e.getMessage());
            return super.internalError();
        }
    }

    @Override
    public ResponseEntity<?> save(Seller seller) {
        try {
            return super.created(this.sellerService.save(seller));
        } catch (Exception e) {
            log.error(e.getMessage());
            return super.internalError();
        }
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        try {
            Optional<Seller> seller = this.sellerService.findById(id);
            if (isNull(seller) || seller.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(seller, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return super.internalError();
        }
    }
}
