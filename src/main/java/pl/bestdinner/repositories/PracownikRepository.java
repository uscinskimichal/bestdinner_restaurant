package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.Pracownik;

@Repository
public interface PracownikRepository extends JpaRepository<Pracownik, Integer> {


}
