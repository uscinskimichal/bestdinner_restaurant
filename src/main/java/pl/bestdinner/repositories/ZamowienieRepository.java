package pl.bestdinner.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.Zamowienie;

@Repository
public interface ZamowienieRepository extends JpaRepository<Zamowienie, Integer> {

}
