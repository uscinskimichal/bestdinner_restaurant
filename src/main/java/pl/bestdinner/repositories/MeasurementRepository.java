package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.MeasurementUnit;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementUnit, Long> {
}
