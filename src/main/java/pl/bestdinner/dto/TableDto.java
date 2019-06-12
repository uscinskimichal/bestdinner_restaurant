package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TableDto {
    private Integer idTable;
    private Integer x, y;
    private Integer width, height;
    private Integer status;
    private String  name;
    private List<OrderDto> orders;
    private RoomDto room;
}
