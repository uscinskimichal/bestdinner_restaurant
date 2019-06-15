package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pl.bestdinner.model.Status;

@Getter
@Setter
public class TableOrderDto {

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
    @JsonProperty("status")
    private StatusDto status;
    @JsonProperty("name")
    private String name;
}
