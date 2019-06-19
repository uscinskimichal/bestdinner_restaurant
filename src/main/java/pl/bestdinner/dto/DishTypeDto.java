package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishTypeDto {

    @JsonProperty("dishType_id")
    private Long dishTypeId;

    @JsonProperty("name")
    private String name;

}
