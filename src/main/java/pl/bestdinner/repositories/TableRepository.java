package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bestdinner.model.Table;

import java.util.List;

public interface TableRepository extends JpaRepository<Table,Integer> {
    List<Table> findAll();
}
