package com.systemsale.systemsale.service.seller;

import com.systemsale.systemsale.dto.SellerDTO;
import com.systemsale.systemsale.entity.Seller;

import java.util.List;

public interface ISellerService {
    SellerDTO create(Seller seller);

    List<SellerDTO> read();

    SellerDTO readById(Long id);

    SellerDTO update(Seller seller);

    Boolean delete(Long id);
}
