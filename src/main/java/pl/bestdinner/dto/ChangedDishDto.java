package pl.bestdinner.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChangedDishDto {

    @JsonProperty("changed_dish_id")
    private Long changedDishId;
    @JsonProperty("dish")
    private DishDto dish;
    @JsonProperty("changed_dish_ingredient")
    private List<ChangedDishIngredientDto> changedDishIngredientSet;
}
