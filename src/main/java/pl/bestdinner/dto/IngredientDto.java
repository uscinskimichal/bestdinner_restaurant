package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDto {
    @JsonProperty("ingredient_id")
    private Long ingredientId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("measurement_unit")
    private MeasurementUnitDto measurementUnit;
    @JsonProperty("warehouse_price")
    private Double warehousePrice;
}
