package com.systemsale.systemsale.repository.jpa.custom.product;

import com.systemsale.systemsale.entity.Product;
import com.systemsale.systemsale.repository.jpa.custom.RepositoryException;

import java.util.List;
import java.util.Optional;

public class ProductUSPRepository implements IProductUSPRepository {

    public ProductUSPRepository() {
    }

    @Override
    public List<Product> findAll() throws RepositoryException {
        return null;
    }

    @Override
    public List<Product> findLikeObject(Product product) throws RepositoryException {
        return null;
    }

    @Override
    public Optional<Product> findById(Product product) throws RepositoryException {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) throws RepositoryException {
        return null;
    }

    @Override
    public Product update(Product product) throws RepositoryException {
        return null;
    }

    @Override
    public Boolean findAll(Product product) throws RepositoryException {
        return null;
    }
}
