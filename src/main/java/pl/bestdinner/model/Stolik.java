package pl.bestdinner.model;

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
}
