package com.systemsale.systemsale.mapper;

import com.systemsale.systemsale.dto.ProductDTO;
import com.systemsale.systemsale.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    public List<ProductDTO> toDTOList(List<Product> productList) {
        return productList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);

        return product;
    }
}
