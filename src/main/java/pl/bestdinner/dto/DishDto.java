package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DishDto {

    @JsonProperty("id_dish")
    private Long idDish;
    @JsonProperty("dish_type")
    private DishTypeDto dishType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("dish_ingredient_set")
    private List<DishIngredientDto> dishIngredientSet;

}
