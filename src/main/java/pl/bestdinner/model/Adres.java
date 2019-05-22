package pl.bestdinner.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Adres {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Adres")
    private int id_Adres;

    @Column(name = "Miasto", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String miasto;

    @Column(name = "Ulica", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String ulica;

    @Column(name = "Numer_domu", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String numer_domu;

    @Column(name = "Numer_lokalu", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String numer_lokalu;

    @OneToMany(mappedBy = "adres")
    private Set<Klient> klienci;

    @OneToMany(mappedBy = "adres")
    private Set<Pracownik> pracownicy;

    @OneToMany(mappedBy = "adres")
    private Set<Zamowienie> zamowienia;

    public int getId_Adres() {
        return id_Adres;
    }
}
