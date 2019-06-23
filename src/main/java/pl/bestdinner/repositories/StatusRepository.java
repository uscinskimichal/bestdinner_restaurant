package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
