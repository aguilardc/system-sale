package com.systemsale.systemsale.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

/** Matricular el Store Procedure */
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name="customers.insert",
                procedureName = "PKG_CUSTOMERS.USP_REGISTRAR",
                parameters = {
                        @StoredProcedureParameter(mode=ParameterMode.OUT, name = "P_CUSTOMER_ID", type = Long.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name = "P_FIRST_NAME", type = String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name = "P_LAST_NAME", type = String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name = "P_DNI", type = String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name = "P_TELEPHONE", type = String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name = "P_EMAIL", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name="customers.find",
                procedureName = "PKG_CUSTOMERS.USP_BUSCAR",
                resultClasses = Customer.class,
                parameters = {
                        @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR, name = "P_CURSOR", type = Void.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name = "P_DNI", type = String.class)
                }
        )
})


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
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DNI", nullable = false)
    private String dni;

    @Column(name = "TELEPHONE", nullable = false)
    private String telephone;

    @Column(name = "EMAIL")
    private String email;

//    @OneToMany(mappedBy = "customer")
//    Set<Sale> sales;
}
