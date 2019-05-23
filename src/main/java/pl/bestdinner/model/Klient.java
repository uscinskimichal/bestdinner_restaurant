package pl.bestdinner.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Klient {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Klient")
    private int id_Klient;

    @Column(name = "Imie", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String imie;

    @Column(name = "Nazwisko", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String nazwisko;

    @Column(name = "Login", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String login;

    @Column(name = "Email", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String email;

    @Column(name = "Haslo", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String haslo;

    @OneToOne(mappedBy = "klient", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)

    private Konto konto;

    @ManyToOne
    @JoinColumn(name = "ID_Adres", nullable = false)
    private Adres adres;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Klient_Zamowienie",
            joinColumns = {@JoinColumn(name = "ID_Klient")},
            inverseJoinColumns = {@JoinColumn(name = "ID_Zamowienie")}
    )
    Set<Zamowienie> zamowienia = new HashSet<>();


    public int getId_Klient() {
        return id_Klient;
    }

    public void setId_Klient(int id_Klient) {
        this.id_Klient = id_Klient;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

}
