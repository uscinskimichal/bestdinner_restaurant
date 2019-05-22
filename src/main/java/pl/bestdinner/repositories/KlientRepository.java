package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.bestdinner.model.Klient;

public interface KlientRepository extends Repository<Klient, Long> {

    @Query("from Klient where ID_Klient = ?1")
    Klient findById(int ID_Klient);
}
