package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishIngredientDto {

    @JsonProperty("dish_ingredient_id")
    private Long dishIngredientId;
    @JsonProperty("quantity")
    private Long quantity;
    @JsonProperty("ingredient")
    private IngredientDto ingredient;
}
