package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressClientDto {
    @JsonProperty("address_id")
    private Long idAddress;
    @JsonProperty("city")
    private String city;
    @JsonProperty("street")
    private String street;
    @JsonProperty("building_number")
    private String buildingNumber;
    @JsonProperty("apartment_number")
    private String apartmentNumber;

}
