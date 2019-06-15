package pl.bestdinner.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name= "employee")
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id")
    private Long idEmployee;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "employee")
    private Set<Order> orders;

    @OneToMany(mappedBy = "employee")
    private Set<OrderHistory> orderHistorySet;

    @OneToMany(mappedBy = "employee")
    private Set<OrderItemHistory> orderItemHistorySet;
}
