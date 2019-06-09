package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bestdinner.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
