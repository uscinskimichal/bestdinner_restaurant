package pl.bestdinner.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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


    public int getId_HistoriaElementuZamowienia() {
        return id_HistoriaElementuZamowienia;
    }

    public void setId_HistoriaElementuZamowienia(int id_HistoriaElementuZamowienia) {
        this.id_HistoriaElementuZamowienia = id_HistoriaElementuZamowienia;
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
