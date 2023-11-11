package com.systemsale.systemsale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailsKey implements Serializable {

    @Column(name = "sale_id")
    Long saleId;

    @Column(name = "product_id")
    Long productId;
}
