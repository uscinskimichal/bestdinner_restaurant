package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableDto {

    @JsonProperty("table_id")
    private Long tableId;
    @JsonProperty("x")
    private Long x;
    @JsonProperty("y")
    private Long y;
    @JsonProperty("width")
    private Long width;
    @JsonProperty("height")
    private Long height;
    @JsonProperty("occupied")
    private Boolean occupied; //TODO co to są statusy stolików
    @JsonProperty("name")
    private String  name;
    /*@JsonProperty("orders")
    private List<OrderDto> orders;*/
    @JsonProperty("room")
    private RoomDto room;
}
