package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.bestdinner.model.Stolik;

import java.util.List;

public interface StolikRepository extends JpaRepository<Stolik,Integer> {

    @Query("SELECT s FROM Stolik s WHERE s.id_Stolik=?1")
    Object findStolik(int id);
}
