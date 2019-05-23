package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.bestdinner.model.Klient;

public interface KlientRepository extends JpaRepository<Klient, Integer> {

}
