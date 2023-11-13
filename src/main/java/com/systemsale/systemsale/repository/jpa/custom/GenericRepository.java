package com.systemsale.systemsale.repository.jpa.custom;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T> {
    List<T> findAll() throws RepositoryException;

    List<T> findLikeObject(T t) throws RepositoryException;

    Optional<T> findById(T t) throws RepositoryException;

    T save(T t) throws RepositoryException;

    T update(T t) throws RepositoryException;

    Boolean findAll(T t) throws RepositoryException;
}
