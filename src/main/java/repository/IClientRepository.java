package repository;

import entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface IClientRepository extends JpaRepository<Client, Long> {
}
