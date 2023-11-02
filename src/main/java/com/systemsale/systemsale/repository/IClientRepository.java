package com.systemsale.systemsale.repository;

import com.systemsale.systemsale.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
