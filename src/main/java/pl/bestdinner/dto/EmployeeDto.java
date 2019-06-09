package pl.bestdinner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private Integer idEmployee;
    private String name;
    private String lastName;
    private String login;
    private String email;
    private String password;
    private String role;
}
