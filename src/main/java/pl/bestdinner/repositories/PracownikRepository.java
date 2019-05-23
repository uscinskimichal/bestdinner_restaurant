package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.Pracownik;

import java.util.List;

@Repository
public interface PracownikRepository extends JpaRepository<Pracownik, Integer> {

    @Query("SELECT p FROM Pracownik p JOIN p.adres a ")
    List<Object> findAllPracownik();

    @Query("SELECT p FROM Pracownik p JOIN p.adres a WHERE p.id_Pracownik=?1")
    List<Object> findPracownik(int idPrac);

}
