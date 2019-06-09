package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressClientDto {
    private Integer addressId;
    private String city;
    private String street;private String streetNumber;
    private String appartmentNumber;

}
