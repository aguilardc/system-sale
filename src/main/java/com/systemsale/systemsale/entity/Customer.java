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
@Table(name = "Customers")
public class Customer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CUSTOMER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCustomer")
    @SequenceGenerator(sequenceName = "SEQ_CUSTOMER", allocationSize = 1, name = "seqCustomer")
    private Long id;

    @Size(min = 5, max = 210, message = "The first name is required and must have at least {min} and maximum {max} characters")
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    //@CustomValidation
    @Size(min = 5, max = 210, message = "The last name is required and must have at least {min} and maximum {max} characters")
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DNI", nullable = false)
    private String dni;

    @Column(name = "TELEPHONE", nullable = false)
    private String telephone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "STATUS")
    @ColumnDefault("true")
    private Boolean status;

    @OneToMany(mappedBy = "customer")
    Set<Sale> sales;
}
