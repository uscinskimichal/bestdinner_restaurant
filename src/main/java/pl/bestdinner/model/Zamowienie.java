package pl.bestdinner.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Zamowienie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Zamowienie")
    private Integer id_Zamowienie;

    @Column(name = "Status", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String status;

    @Column(name = "Data", columnDefinition = "DATETIME", nullable = false)
    private Timestamp data;

    @Column(name = "Typ", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String typ;

    @ManyToOne
    @JoinColumn(name = "ID_Adres", nullable = false)
    private Adres adres;

    @ManyToOne
    @JoinColumn(name = "ID_Stolik", nullable = false)
    private Stolik stolik;


    @OneToMany(mappedBy = "zamowienie")
    private Set<ElementZamowienia> elementyZamowienia;


    @OneToMany(mappedBy = "zamowienie")
    private Set<HistoriaZamowienia> historieZamowienia;

    @ManyToMany(mappedBy = "orders")
    private Set<Client> klienci = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "ID_Pracownik", nullable = false)
    private Pracownik pracownik;

    public Integer getId_Zamowienie() {
        return id_Zamowienie;
    }

    public void setId_Zamowienie(Integer id_Zamowienie) {
        this.id_Zamowienie = id_Zamowienie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }


    public Set<ElementZamowienia> getElementyZamowienia() {
        return elementyZamowienia;
    }

    public Stolik getStolik() {
        return stolik;
    }

    public Adres getAdres() {
        return adres;
    }

    public Set<Client> getKlienci() {
        return klienci;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }
}
