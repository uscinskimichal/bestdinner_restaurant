package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.DishType;

@Repository
public interface DishTypeRepository extends JpaRepository<DishType, Long> {
}
