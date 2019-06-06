package pl.bestdinner.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ElementZamowienia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ElementZamowienia")
    private int id_ElementZamowienia;

    @Column(name = "Status", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "ID_Zamowienie", nullable = false)
    private Zamowienie zamowienie;

    @ManyToOne
    @JoinColumn(name = "ID_Danie")
    private Danie danie;

    @ManyToOne
    @JoinColumn(name = "ID_DanieZmienione")
    private DanieZmienione danieZmienione;


    @OneToMany(mappedBy = "elementZamowienia")
    private Set<HistoriaElementuZamowienia> historieElementuZamowienia;

    public int getId_ElementZamowienia() {
        return id_ElementZamowienia;
    }

    public void setId_ElementZamowienia(int id_ElementZamowienia) {
        this.id_ElementZamowienia = id_ElementZamowienia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Danie getDanie() {
        return danie;
    }

    public DanieZmienione getDanieZmienione() {
        return danieZmienione;
    }
}
