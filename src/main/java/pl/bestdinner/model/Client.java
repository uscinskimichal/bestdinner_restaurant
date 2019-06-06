package pl.bestdinner.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Table
@Entity(name = "Klient")
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Klient")
    private Integer idClient;

    @Column(name = "Imie", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String name;

    @Column(name = "Nazwisko", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String lastName;

    @Column(name = "Login", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String login;

    @Column(name = "Email", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String email;

    @Column(name = "Haslo", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String password;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)

    private Konto account;

    @ManyToOne
    @JoinColumn(name = "ID_Adres", nullable = false)
    private Adres address;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Klient_Zamowienie",
            joinColumns = {@JoinColumn(name = "ID_Klient")},
            inverseJoinColumns = {@JoinColumn(name = "ID_Zamowienie")}
    )
    Set<Zamowienie> orders = new HashSet<>();

}
