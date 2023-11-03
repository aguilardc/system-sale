package com.systemsale.systemsale.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Products")
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;
    private String descripcion;
    private String marca;
    private Double precio;
    private Double precio_venta;
    private Integer stock;

    @OneToMany(mappedBy = "products")
    Set<SaleDetails> saleDetails;

}
