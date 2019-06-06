package pl.bestdinner.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Stolik {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Stolik")
    private int id_Stolik;

    @Column(name = "Status", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String status;

    @Column(name = "X", columnDefinition = "INT", nullable = false)
    private String x;

    @Column(name = "Y", columnDefinition = "INT", nullable = false)
    private String y;

    @Column(name = "Szerokosc", columnDefinition = "INT", nullable = false)
    private String szerokosc;

    @Column(name = "Wysokosc", columnDefinition = "INT", nullable = false)
    private String wysokosc;


    @OneToMany(mappedBy = "stolik")
    private Set<Zamowienie> zamowienia;

    public int getId_Stolik() {
        return id_Stolik;
    }

    public void setId_Stolik(int id_Stolik) {
        this.id_Stolik = id_Stolik;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(String szerokosc) {
        this.szerokosc = szerokosc;
    }

    public String getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(String wysokosc) {
        this.wysokosc = wysokosc;
    }

}
