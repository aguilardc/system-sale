package com.systemsale.systemsale.service;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T> {

    List<T> findAll() throws ServiceException;

    List<T> findLikeObject(T t) throws ServiceException;

    Optional<T> findById(Long id) throws ServiceException;

    T save(T t) throws ServiceException;

    T update(T t) throws ServiceException;

    Boolean delete(Long id) throws ServiceException;
}
