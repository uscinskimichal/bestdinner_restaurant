package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class WarehouseOrderDto {

    @JsonProperty("warehouse_order_id")
    private Long warehouseOrderId;
    @JsonProperty("date")
    private LocalDateTime date;
    @JsonProperty("warehouse_order_items")
    private List<WarehouseOrderItemDto> warehouseOrderItems;
    @JsonProperty("ordering_person")
    private EmployeeDto orderingPerson;
}
