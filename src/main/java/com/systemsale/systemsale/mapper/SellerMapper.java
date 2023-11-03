package com.systemsale.systemsale.mapper;

import com.systemsale.systemsale.dto.SellerDTO;
import com.systemsale.systemsale.entity.Seller;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SellerMapper {
    public SellerDTO toDTO(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO();
        BeanUtils.copyProperties(seller, sellerDTO);
        return sellerDTO;
    }

    public List<SellerDTO> toDTOList(List<Seller> sellerList) {
        return sellerList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Seller toEntity(SellerDTO sellerDTO) {
        Seller seller = new Seller();
        BeanUtils.copyProperties(sellerDTO, seller);
        return seller;
    }
}
