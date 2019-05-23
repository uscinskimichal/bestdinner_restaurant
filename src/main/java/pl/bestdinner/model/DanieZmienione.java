package pl.bestdinner.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DanieZmienione {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_DanieZmienione")
    private int id_DanieZmienione;

    @ManyToOne
    @JoinColumn(name = "ID_Danie", nullable = false)
    private Danie danie;

    @OneToMany(mappedBy = "danieZmienione")
    private Set<SkladnikDaniaZmienionego> skladnikiDaniaZmienionego;

    @OneToMany(mappedBy = "danieZmienione")
    private Set<ElementZamowienia> elementyZamowienia;

    public int getId_DanieZmienione() {
        return id_DanieZmienione;
    }

    public void setId_DanieZmienione(int id_DanieZmienione) {
        this.id_DanieZmienione = id_DanieZmienione;
    }

    //@JsonManagedReference
    public Danie getDanie() {
        return danie;
    }

    public Set<SkladnikDaniaZmienionego> getSkladnikiDaniaZmienionego() {
        return skladnikiDaniaZmienionego;
    }
}
