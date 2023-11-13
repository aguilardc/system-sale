package com.systemsale.systemsale.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Generic {

    @Column(name = "STATUS", nullable = false)
    private Boolean status = true;
}
