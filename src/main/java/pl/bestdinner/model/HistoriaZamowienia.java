package pl.bestdinner.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

    public int getId_HistoriaStatusu() {
        return id_HistoriaStatusu;
    }

    public void setId_HistoriaStatusu(int id_HistoriaStatusu) {
        this.id_HistoriaStatusu = id_HistoriaStatusu;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
