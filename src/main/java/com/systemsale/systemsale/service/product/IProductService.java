package com.systemsale.systemsale.service.product;

import com.systemsale.systemsale.dto.ProductDTO;
import com.systemsale.systemsale.entity.Product;

import java.util.List;

public interface IProductService {
    ProductDTO create(Product client);

    List<ProductDTO> read();

    ProductDTO readById(Long id);

    ProductDTO update(Product client);

    Boolean delete(Long id);
}
