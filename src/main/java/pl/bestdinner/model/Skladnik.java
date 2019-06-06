package pl.bestdinner.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Skladnik {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Skladnik")
    private int id_skladnik;

    @Column(name = "Nazwa", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String nazwa;

    @Column(name = "Typ", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String typ;

    @Column(name = "IloscMagazyn", columnDefinition = "INT", nullable = false)
    private int iloscMagazyn;

    @Column(name = "JednostkaMiary", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String jednostkaMiary;

    @Column(name = "CenaKlient", columnDefinition = "DECIMAL(7,2)", nullable = false)
    private float cenaKlient;

    @Column(name = "CenaMagazyn", columnDefinition = "DECIMAL(7,2)", nullable = false)
    private float cenaMagazyn;


    @OneToMany(mappedBy = "skladnik")
    private Set<ElementZamowieniaMagazynowego> elementyZamowieniaMagazynowego;


    @OneToMany(mappedBy = "skladnik")
    private Set<SkladnikDania> skladnikiDania;


    @OneToMany(mappedBy = "skladnik")
    private Set<SkladnikDaniaZmienionego> skladnikiDaniaZmienionego;

    public int getId_skladnik() {
        return id_skladnik;
    }

    public void setId_skladnik(int id_skladnik) {
        this.id_skladnik = id_skladnik;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getIloscMagazyn() {
        return iloscMagazyn;
    }

    public void setIloscMagazyn(int iloscMagazyn) {
        this.iloscMagazyn = iloscMagazyn;
    }

    public String getJednostkaMiary() {
        return jednostkaMiary;
    }

    public void setJednostkaMiary(String jednostkaMiary) {
        this.jednostkaMiary = jednostkaMiary;
    }

    public float getCenaKlient() {
        return cenaKlient;
    }

    public void setCenaKlient(float cenaKlient) {
        this.cenaKlient = cenaKlient;
    }

    public float getCenaMagazyn() {
        return cenaMagazyn;
    }

    public void setCenaMagazyn(float cenaMagazyn) {
        this.cenaMagazyn = cenaMagazyn;
    }
}
