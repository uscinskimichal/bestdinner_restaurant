package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.bestdinner.model.Pracownik;

public interface PracownikRepository extends Repository<Pracownik, Long> {
    @Query("from Pracownik where ID_Pracownik = ?1")
    Pracownik findById(int ID_Pracownik);
}
