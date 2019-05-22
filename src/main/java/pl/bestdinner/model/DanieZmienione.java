package pl.bestdinner.model;

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


}
