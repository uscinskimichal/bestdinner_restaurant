package pl.bestdinner.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity(name = "client")
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "client_id")
    private Long idClient;

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

/*    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)

    private Konto account;*/

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;


@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "client_order",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id")}
    )
    Set<Order> orders = new HashSet<>();

}
