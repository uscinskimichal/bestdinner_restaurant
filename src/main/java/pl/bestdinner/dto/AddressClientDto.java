package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressClientDto {
    @JsonProperty("address_id")
    private Long addressId;
    @JsonProperty("city")
    private String city;
    @JsonProperty("street")
    private String street;
    @JsonProperty("street_number")
    private String streetNumber;
    @JsonProperty("apartment_number")
    private String apartmentNumber;

}
