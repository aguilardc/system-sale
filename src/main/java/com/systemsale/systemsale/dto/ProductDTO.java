package com.systemsale.systemsale.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String nombre;
    private String codigo;
    private String descripcion;
    private Double precio;
    private Double precio_venta;
    private Integer stock;
}
