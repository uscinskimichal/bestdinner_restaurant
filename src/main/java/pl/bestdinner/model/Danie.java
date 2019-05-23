package pl.bestdinner.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Danie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Danie")
    private int id_Danie;

    @Column(name = "Nazwa", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String nazwa;

    @Column(name = "Cena", columnDefinition = "DECIMAL(7,2)", nullable = false)
    private float cena;

    @Column(name = "Zdjecie", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String zdjecie;


    @OneToMany(mappedBy = "danie")
    private Set<SkladnikDania> skladnikiDania;


    @OneToMany(mappedBy = "danie")
    private Set<DanieZmienione> daniaZmienione;


    @OneToMany(mappedBy = "danie")
    private Set<ElementZamowienia> elementyZamowienia;

    public int getId_Danie() {
        return id_Danie;
    }

    public void setId_Danie(int id_Danie) {
        this.id_Danie = id_Danie;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public String getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(String zdjecie) {
        this.zdjecie = zdjecie;
    }


    public Set<SkladnikDania> getSkladnikiDania() {
        return skladnikiDania;
    }
}