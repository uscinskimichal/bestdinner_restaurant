package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.Table;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<Table,Long> {
    List<Table> findAll();
}
