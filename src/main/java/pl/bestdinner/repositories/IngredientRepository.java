package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bestdinner.model.Ingredient;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findAll();

}
