package pl.bestdinner.dto;

import lombok.*;


//Adnotacje lomboka, generują nam Gettery, Settery itd poniżej kilka przykładowych
@Getter
@Setter
public class ClientDto {
    private Integer idClient;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
    private Double balance;
    private AddressClientDto address;


}
