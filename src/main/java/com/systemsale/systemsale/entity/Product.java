package com.systemsale.systemsale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "products")
@Table(name = "PRODUCTS")
public class Product extends Generic implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 8, max = 8, message = "The code is required and must have at least {min} and maximum {max} characters")
    @Column(name = "CODE", nullable = false) // PROD000001
    private String code;

    @Size(min = 5, max = 100, message = "The name is required and must have at least {min} and maximum {max} characters")
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "BRAND", nullable = false)
    private String brand;

    @Column(name = "PRICE", nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;

    @Column(name = "SALE_PRICE", nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal salePrice;

    @Column(name = "STOCK", nullable = false, columnDefinition = "SMALLINT")
    private Short stock;

    @Column(name = "STATUS", nullable = false)
    private Boolean status = true;

//    @OneToMany(mappedBy = "products")
//    Set<SaleDetails> saleDetails;

}
