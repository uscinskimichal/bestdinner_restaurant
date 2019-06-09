package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bestdinner.model.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findAll();
}
