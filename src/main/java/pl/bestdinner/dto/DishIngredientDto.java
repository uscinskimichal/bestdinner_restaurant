package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishIngredientDto {


    private Integer dishIngredientId;

    private Integer quantity;

    private IngredientDto ingredient;
}
