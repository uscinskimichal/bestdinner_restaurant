package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Integer orderId;
    private String status;
    private Date date;
    private EmployeeOrderDto employee;
    private String type;
    private String comment;
    private TableOrderDto table;
    private List<ClientDto> clients;
    private List<OrderItemDto> orderItems;
    private AddressOrderDto address;
}
