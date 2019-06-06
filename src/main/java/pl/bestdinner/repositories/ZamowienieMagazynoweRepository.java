package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.bestdinner.model.ZamowienieMagazynowe;

import java.sql.Date;
import java.util.List;

public interface ZamowienieMagazynoweRepository extends JpaRepository<ZamowienieMagazynowe, Integer> {


    @Query("SELECT zm FROM ZamowienieMagazynowe zm JOIN zm.elementyZamowieniaMagazynowego ezm JOIN ezm.skladnik s JOIN zm.pracownik p WHERE zm.id_ZamowienieMagazynowe=?1")
    Object findZamowienieMagazynowe(int id);

    @Query("SELECT zm FROM ZamowienieMagazynowe zm WHERE zm.data>?1")
    List<Object> findByDataAfter(Date data);

    @Query("SELECT zm FROM ZamowienieMagazynowe zm WHERE zm.data<?1")
    List<Object> findByDataBefore(Date data);

}
