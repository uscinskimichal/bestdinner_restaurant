package pl.bestdinner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

    @JsonProperty("id_employee")
    private Long idEmployee;
    @JsonProperty("first_name")
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("login")
    private String login;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("role")
    private String role;
}
