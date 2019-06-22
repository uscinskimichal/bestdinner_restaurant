package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RestaurantAccountDto {

    @JsonProperty("restaurant_id")
    private Long idRestaurant;
    @JsonProperty("balance")
    private Double balance;

}
