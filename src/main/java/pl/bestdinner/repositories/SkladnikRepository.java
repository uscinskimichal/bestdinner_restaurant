package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.bestdinner.model.Skladnik;

import java.util.List;

public interface SkladnikRepository extends JpaRepository<Skladnik,Integer> {

//    @Query("SELECT s FROM Skladnik s WHERE s.id_skladnik=?1")
//    Object findSkladnik(int id);
}
