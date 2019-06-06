package pl.bestdinner.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pracownik {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Pracownik")
    private int id_Pracownik;

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

    @Column(name = "Rola", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String rola;

    @ManyToOne
    @JoinColumn(name = "ID_Adres", nullable = false)
    private Adres adres;


    @OneToMany(mappedBy = "pracownik")
    private Set<HistoriaElementuZamowienia> historieElementuZamowienia;


    @OneToMany(mappedBy = "pracownik")
    private Set<ZamowienieMagazynowe> zamowieniaMagazynowe;


    @OneToMany(mappedBy = "pracownik")
    private Set<Zamowienie> zamowienia;


    @OneToMany(mappedBy = "pracownik")
    private Set<HistoriaZamowienia> historieZamowienia;

    public int getId_Pracownik() {
        return id_Pracownik;
    }

    public void setId_Pracownik(int id_Pracownik) {
        this.id_Pracownik = id_Pracownik;
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

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public Adres getAdres() {
        return adres;
    }
}
