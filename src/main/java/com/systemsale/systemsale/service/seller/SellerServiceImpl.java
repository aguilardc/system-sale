package com.systemsale.systemsale.service.seller;

import com.systemsale.systemsale.dto.SellerDTO;
import com.systemsale.systemsale.entity.Seller;
import com.systemsale.systemsale.mapper.SellerMapper;
import com.systemsale.systemsale.repository.ISellerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements ISellerService {

    private final ISellerRepository sellerRepository;
    private final SellerMapper sellerMapper;

    public SellerServiceImpl(ISellerRepository sellerRepository, SellerMapper sellerMapper) {
        this.sellerRepository = sellerRepository;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public SellerDTO create(Seller seller) {
        Seller seller1 = sellerRepository.save(seller);
        return sellerMapper.toDTO(seller1);

    }

    @Override
    public List<SellerDTO> read() {
        var sellers = sellerRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return this.sellerMapper.toDTOList(sellers);
    }

    @Override
    public SellerDTO readById(Long id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        return seller.map(value -> sellerMapper.toDTO((Seller) value)).orElse(null);
    }

    @Override
    public SellerDTO update(Seller seller) {
        Seller seller1 = sellerRepository.save(seller);
        return sellerMapper.toDTO(seller1);
    }

    @Override
    public Boolean delete(Long id) {
        try {
            sellerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
