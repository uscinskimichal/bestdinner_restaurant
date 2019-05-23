package pl.bestdinner.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Konto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Konto")
    private int id_konto;

    @Column(name = "Saldo", columnDefinition = "DECIMAL(7,2)", nullable = false)
    private float saldo;

    @Column(name = "Data", columnDefinition = "DATETIME", nullable = false)
    private Timestamp data;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Klient")
    private Klient klient;

    public int getId_konto() {
        return id_konto;
    }

    public void setId_konto(int id_konto) {
        this.id_konto = id_konto;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

}
