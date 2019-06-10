package pl.bestdinner.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChangedDishDto {

    private int changedDishId;
    private DishDto dish;
    private List<ChangedDishIngredientDto> changedDishIngredient;
}
