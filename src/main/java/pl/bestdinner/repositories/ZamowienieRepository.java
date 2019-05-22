package pl.bestdinner.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.bestdinner.model.Zamowienie;

public interface ZamowienieRepository extends Repository<Zamowienie, Long> {

    <S extends Zamowienie> Iterable<S> findAll(Example<S> example);

    @Query("from Zamowienie where ID_Zamowienie = ?1")
    Zamowienie findById(int ID_Zamowienie);
}
