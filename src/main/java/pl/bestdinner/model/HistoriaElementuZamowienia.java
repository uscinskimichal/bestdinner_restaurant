package pl.bestdinner.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class HistoriaElementuZamowienia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_HistoriaElementuZamowienia")
    private int id_HistoriaElementuZamowienia;

    @Column(name = "Data", columnDefinition = "DATETIME", nullable = false)
    private Timestamp data;

    @Column(name = "Status", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "ID_ElementZamowienia", nullable = false)
    private ElementZamowienia elementZamowienia;

    @ManyToOne
    @JoinColumn(name = "ID_Pracownik", nullable = false)
    private Pracownik pracownik;


}
