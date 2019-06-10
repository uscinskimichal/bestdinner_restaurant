package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableOrderDto {

    private Integer tableId;
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private Integer status;
    private String name;
}
