package com.systemsale.systemsale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SaleDetails {
    @EmbeddedId
    SaleDetailsKey id;

    @ManyToOne
    @MapsId("SaleId")
    @JoinColumn(name = "sale_id")
    Sale sales;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product products;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "UNIT_PRICE", nullable = false)
    private Double unitPrice;

    @Column(name = "TOTAL_PRICE", nullable = false)
    private Double totalPrice;
}
