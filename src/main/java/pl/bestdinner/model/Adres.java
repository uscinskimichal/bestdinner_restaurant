package pl.bestdinner.model;

import com.fasterxml.jackson.annotation.*;

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

    public void setId_Adres(int id_Adres) {
        this.id_Adres = id_Adres;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumer_domu() {
        return numer_domu;
    }

    public void setNumer_domu(String numer_domu) {
        this.numer_domu = numer_domu;
    }

    public String getNumer_lokalu() {
        return numer_lokalu;
    }

    public void setNumer_lokalu(String numer_lokalu) {
        this.numer_lokalu = numer_lokalu;
    }

}
