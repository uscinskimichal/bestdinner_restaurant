package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderItemDto {

    @JsonProperty("order_item_id")
    private Long orderItemId;
    @JsonProperty("status")
    private StatusDto status;
    @JsonProperty("changed_dish")
    private ChangedDishDto changedDish;
    @JsonProperty("dish")
    private DishDto dish;
}
