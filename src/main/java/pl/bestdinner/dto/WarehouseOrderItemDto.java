package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseOrderItemDto {

    private Integer wareHouseOrderItemId;
    private Integer quantity;
    private IngredientDto ingredient;
}
