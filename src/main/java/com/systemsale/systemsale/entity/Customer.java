package com.systemsale.systemsale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;


@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name = "customers")
@Table(name = "CUSTOMERS")
public class Customer extends Generic implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CUSTOMER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCustomer")
    @SequenceGenerator(sequenceName = "SEQ_CUSTOMERS", allocationSize = 1, name = "seqCustomer")
    private Long id;

    @Size(min = 5, max = 100, message = "The first name is required and must have at least {min} and maximum {max} characters")
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    //@CustomValidation
    @Size(min = 5, max = 100, message = "The last name is required and must have at least {min} and maximum {max} characters")
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DNI", nullable = false)
    private String dni;

    @Column(name = "TELEPHONE", nullable = false)
    private String telephone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "STATUS", nullable = false)
    private Boolean status = true;

//    @OneToMany(mappedBy = "customer")
//    Set<Sale> sales;
}
