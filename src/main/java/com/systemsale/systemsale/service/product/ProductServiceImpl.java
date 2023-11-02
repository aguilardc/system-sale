package com.systemsale.systemsale.service.product;

import com.systemsale.systemsale.dto.ProductDTO;
import com.systemsale.systemsale.entity.Product;
import com.systemsale.systemsale.mapper.ProductMapper;
import com.systemsale.systemsale.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDTO create(Product product) {
        Product product1 = productRepository.save(product);
        return productMapper.toDTO(product1);
    }

    @Override
    public List<ProductDTO> read() {
        var products = productRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return productMapper.toDTOList(products);
    }

    @Override
    public ProductDTO readById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(value -> productMapper.toDTO((Product) value)).orElse(null);

    }

    @Override
    public ProductDTO update(Product product) {
        Product product1 = productRepository.save(product);
        return productMapper.toDTO(product1);
    }

    @Override
    public Boolean delete(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
