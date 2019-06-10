package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDto {
    private Integer ingredientId;
    private String name;
    private String measurementUnit;
    private Double warehousePrice;
}
