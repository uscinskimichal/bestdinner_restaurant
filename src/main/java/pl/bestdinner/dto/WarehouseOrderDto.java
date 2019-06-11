package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class WarehouseOrderDto {

    private Integer warehouseOrderId;
    private LocalDateTime date;
    private List<WarehouseOrderItemDto> warehouseOrderItems;
    private EmployeeDto orderingPerson;
}
