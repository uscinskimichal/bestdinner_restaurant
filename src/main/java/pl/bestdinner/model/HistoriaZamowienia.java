package pl.bestdinner.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class HistoriaZamowienia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_HistoriaStatusu")
    private int id_HistoriaStatusu;

    @Column(name = "Data", columnDefinition = "DATETIME", nullable = false)
    private Timestamp data;

    @Column(name = "Status", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "ID_Pracownik", nullable = false)
    private Pracownik pracownik;

    @ManyToOne
    @JoinColumn(name = "ID_Zamowienie", nullable = false)
    private Zamowienie zamowienie;


}
