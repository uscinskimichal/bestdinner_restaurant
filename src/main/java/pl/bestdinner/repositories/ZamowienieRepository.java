package pl.bestdinner.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.Zamowienie;

import java.sql.Date;

import java.util.List;

@Repository
public interface ZamowienieRepository extends JpaRepository<Zamowienie, Integer> {

    interface ZamowienieRepositoryCustom {
         List<Object> executeQuery(String status, String idKlient, Date dateFrom, Date dateTo, String type);
    }

    List<Object> findByStatus(String status);
    List<Object> findByTyp(String typ);

    @Query("SELECT z FROM Zamowienie z JOIN z.klienci k WHERE k.id_Klient=?1")
    List<Object> findByIdKlient(int idKlient);

    @Query("SELECT z FROM Zamowienie z WHERE z.data>?1")
    List<Object> findByDataAfter(Date data);

    @Query("SELECT z FROM Zamowienie z WHERE z.data<?1")
    List<Object> findByDataBefore(Date data);

}
