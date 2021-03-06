package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto {

    @JsonProperty("room_id")
    private Long roomId;
    @JsonProperty("width")
    private Long width;
    @JsonProperty("height")
    private Long height;
}
