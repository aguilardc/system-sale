package com.systemsale.systemsale.service.seller;

import com.systemsale.systemsale.entity.Seller;
import com.systemsale.systemsale.repository.jpa.standar.ISellerRepository;
import com.systemsale.systemsale.service.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements ISellerService {

    private final ISellerRepository sellerRepository;

    public SellerServiceImpl(ISellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public List<Seller> findAll() throws ServiceException {
        try {
            return this.sellerRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Seller> findLikeObject(Seller seller) throws ServiceException {
        try {
            return null;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Seller> findById(Long id) throws ServiceException {
        try {
            return this.sellerRepository.findById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Seller save(Seller seller) throws ServiceException {
        try {
            return this.sellerRepository.save(seller);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Seller update(Seller seller) throws ServiceException {
        try {
            return this.sellerRepository.save(seller);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }
}
