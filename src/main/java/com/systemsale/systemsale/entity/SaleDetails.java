package com.systemsale.systemsale.entity;

import jakarta.persistence.*;

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

    private Integer cantidad;
    private String descripcion;
    private Double precio_unitario;
    private Double importe;
}
