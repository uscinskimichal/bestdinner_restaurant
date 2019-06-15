package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pl.bestdinner.model.Table;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    @JsonProperty("order_id")
    private Long orderId;
    @JsonProperty("status")
    private StatusDto status;
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("employee")
    private EmployeeOrderDto employee;
    @JsonProperty("type")
    private String type;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("table")
    private TableDto table;
    @JsonProperty("clients")
    private List<ClientDto> clients;
    @JsonProperty("order_items")
    private List<OrderItemDto> orderItems;
    @JsonProperty("address")
    private AddressOrderDto address;
}
