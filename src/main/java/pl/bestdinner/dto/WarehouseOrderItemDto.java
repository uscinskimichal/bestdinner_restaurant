package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseOrderItemDto {

    @JsonProperty("ware_house_order_item_id")
    private Long wareHouseOrderItemId;
    @JsonProperty("quantity")
    private Long quantity;
    @JsonProperty("ingredient")
    private IngredientDto ingredient;
}
