package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.Client;

import java.util.List;
import java.util.Optional;

@Repository //  stereotyp Springa (inne Controller, Service, Component)
public interface ClientRepository extends JpaRepository<Client, Integer> {

  //  @Query("SELECT k FROM Client k JOIN k.adres a WHERE k.id_Klient=?1")
  //  Optional<Object> findClient(int id); //Optional nam zapewnia, że jeżeli nie znajdziemy takiego rekordu to nie walnie nam MullPointera, robimy kod null safety

  //  @Query("SELECT k FROM Client k JOIN k.adres a")
  //  List<Client> findClients();

    List<Client> findAll(); //zwraca wszystkich klientów
}
