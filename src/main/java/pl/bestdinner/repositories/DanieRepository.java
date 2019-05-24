package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.bestdinner.model.Danie;

import java.util.List;

public interface DanieRepository extends JpaRepository<Danie, Integer> {

    @Query("SELECT d FROM Danie d JOIN d.skladnikiDania sd WHERE d.id_Danie=?1")
    Object findDanie(int id);
}
