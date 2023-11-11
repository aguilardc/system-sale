package com.systemsale.systemsale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduct")
    @SequenceGenerator(sequenceName = "SEQ_PRODUCT", allocationSize = 1, name = "seqProduct")
    private Long id;

    @Size(min = 10, max = 10, message = "The code is required and must have at least {min} and maximum {max} characters")
    @Column(name = "CODE", nullable = false) // PROD000001
    private String code;

    @Size(min = 5, max = 100, message = "The name is required and must have at least {min} and maximum {max} characters")
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Size(message = "The brand is required")
    @Column(name = "BRAND", nullable = false)
    private String brand;

    @Size(message = "The price is required")
    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Size(message = "The sale price is required")
    @Column(name = "SALE_PRICE", nullable = false)
    private Double salePrice;

    @Size(message = "The stock is required")
    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "STATUS")
    private Boolean status = true;

    @OneToMany(mappedBy = "products")
    Set<SaleDetails> saleDetails;

}
