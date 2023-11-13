package com.systemsale.systemsale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Sellers")
public class Seller extends Generic implements Serializable {
    @Id
    @Column(name = "SELLER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSeller")
    @SequenceGenerator(sequenceName = "SEQ_SELLERS", allocationSize = 1, name = "seqSeller")
    private Long id;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Size(min = 5, max = 100, message = "The first name is required and must have at least {min} and maximum {max} characters")
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Size(min = 5, max = 100, message = "The last name is required and must have at least {min} and maximum {max} characters")
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DNI", nullable = false)
    private String dni;

    @Column(name = "TELEPHONE", nullable = false)
    private String telephone;


//    @OneToMany(mappedBy = "seller")
//    Set<Sale> sales;

}
