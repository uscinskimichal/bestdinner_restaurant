package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishStatusDTO {
    @JsonProperty("dish_status_id")
    private Long dishStatusId;

    @JsonProperty("name")
    private String name;
}
