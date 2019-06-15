package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


//Adnotacje lomboka, generują nam Gettery, Settery itd poniżej kilka przykładowych
@Getter
@Setter
public class ClientDto {

    @JsonProperty("id_client")
    private Long idClient;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("login")
    private String login;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("balance")
    private Double balance;
    @JsonProperty("address")
    private AddressClientDto address;
}
