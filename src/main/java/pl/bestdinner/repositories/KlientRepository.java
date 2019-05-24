package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.bestdinner.model.Klient;

import java.util.List;

public interface KlientRepository extends JpaRepository<Klient, Integer> {

    @Query("SELECT k FROM Klient k JOIN k.adres a WHERE k.id_Klient=?1")
    Object findKlient(int id);

    @Query("SELECT k FROM Klient k JOIN k.adres a")
    List<Object> findKlienci();
}
