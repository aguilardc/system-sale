package com.systemsale.systemsale.service.product;

import com.systemsale.systemsale.entity.Product;
import com.systemsale.systemsale.repository.jpa.standar.IProductRepository;
import com.systemsale.systemsale.service.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() throws ServiceException {
        try {
            return this.productRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> findLikeObject(Product product) throws ServiceException {
        try {
            return null;
        } catch (Exception e) {
            throw new ServiceException();
        }
    }

    @Override
    public Optional<Product> findById(Long id) throws ServiceException {
        try {
            return this.productRepository.findById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Product save(Product product) throws ServiceException {
        try {
            return this.productRepository.save(product);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Product update(Product product) throws ServiceException {
        try {
            return this.productRepository.save(product);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }
}
