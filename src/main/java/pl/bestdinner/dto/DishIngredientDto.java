package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishIngredientDto {


    private Integer dishIngredeintId;

    private Integer quantity;

    private IngredientDto ingredient;
}
