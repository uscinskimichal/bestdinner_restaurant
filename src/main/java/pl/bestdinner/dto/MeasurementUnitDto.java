package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementUnitDto {
    @JsonProperty("measurement_unit_id")
    private Long measurementUnitId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("must_be_integer")
    private Boolean mustBeInteger;
}
