package com.systemsale.systemsale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Timestamp;


@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Sales")
public class Sale extends Generic implements Serializable {
    @Id
    @Column(name = "SALE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSale")
    @SequenceGenerator(sequenceName = "SEQ_SALES", allocationSize = 1, name = "seqSale")
    private Long id;

    @Size(min = 10, max = 10, message = "The code is required and must have at least {min} and maximum {max} characters")
    @Column(name = "CODE", nullable = false) // SALE000001
    private String code;

    @Column(name = "DATE", nullable = false)
    private Timestamp date;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

//    @OneToMany(mappedBy = "sales")
//    Set<SaleDetails> saleDetails;
//
//    @ManyToOne()
//    @JoinColumn(name = "SELLER_ID", nullable = false)
//    private Seller seller;
//
//    @ManyToOne()
//    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
//    private Customer customer;
}
