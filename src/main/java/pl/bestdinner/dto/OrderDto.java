package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Integer orderId;
    private String status;
    private LocalDateTime date;
    private String type;
    private String comment;
    private TableOrderDto table;
    private List<ClientDto> clients;
    private List<OrderItemDto> orderItems;
    private AddressOrderDto address;
    private EmployeeOrderDto supplier;
}
