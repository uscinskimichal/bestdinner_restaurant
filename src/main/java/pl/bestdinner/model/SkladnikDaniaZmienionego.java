package pl.bestdinner.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SkladnikDaniaZmienionego implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ilosc")
    private int ilosc;

    @ManyToOne
    @Id
    @JoinColumn(name = "ID_Skladnik", nullable = false)
    private Skladnik skladnik;

    @ManyToOne
    @Id
    @JoinColumn(name = "ID_DanieZmienione", nullable = false)
    private DanieZmienione danieZmienione;

}
