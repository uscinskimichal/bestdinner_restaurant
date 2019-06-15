package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusDto {
    @JsonProperty("status_id")
    private Long roomId;

    @JsonProperty("name")
    private String name;
}
