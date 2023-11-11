package com.systemsale.systemsale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Timestamp;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Sales")
public class Sale {
    @Id
    @Column(name = "SALE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSale")
    @SequenceGenerator(sequenceName = "SEQ_SALE", allocationSize = 1, name = "seqSale")
    private Long id;

    @Size(min = 10, max = 10, message = "The code is required and must have at least {min} and maximum {max} characters")
    @Column(name = "CODE", nullable = false) // SALE000001
    private String code;

    @Column(name = "DATE", nullable = false)
    private Timestamp date;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    @OneToMany(mappedBy = "sales")
    Set<SaleDetails> saleDetails;

    @ManyToOne()
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    @ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
