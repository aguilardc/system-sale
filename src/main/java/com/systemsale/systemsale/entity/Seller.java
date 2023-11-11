package com.systemsale.systemsale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Sellers")
@NoArgsConstructor
@Getter
@Setter
public class Seller {
    @Id
    @Column(name = "SELLER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSeller")
    @SequenceGenerator(sequenceName = "SEQ_SELLER", allocationSize = 1, name = "seqSeller")
    private Long id;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Size(min = 5, max = 210, message = "The first name is required and must have at least {min} and maximum {max} characters")
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Size(min = 5, max = 210, message = "The last name is required and must have at least {min} and maximum {max} characters")
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DNI", nullable = false)
    private String dni;

    @Column(name = "TELEPHONE", nullable = false)
    private String telephone;

    @OneToMany(mappedBy = "seller")
    Set<Sale> sales;

}
