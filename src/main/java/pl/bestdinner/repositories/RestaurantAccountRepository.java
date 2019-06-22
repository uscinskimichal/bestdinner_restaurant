package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bestdinner.model.RestaurantAccount;

import java.util.List;

public interface RestaurantAccountRepository extends JpaRepository<RestaurantAccount, Long> {
    List<RestaurantAccount> findAll();
}
