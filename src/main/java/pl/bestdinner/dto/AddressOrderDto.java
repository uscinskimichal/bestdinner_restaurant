package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressOrderDto {

    private int idAddress;
    private String city;
    private String street;
    private String buildingNumber;
    private String appartmentNumber;
}
