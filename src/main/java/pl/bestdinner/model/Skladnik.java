package pl.bestdinner.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Skladnik {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Skladnik")
    private int id_skladnik;

    @Column(name = "Nazwa", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String nazwa;

    @Column(name = "Typ", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String typ;

    @Column(name = "IloscMagazyn", columnDefinition = "INT", nullable = false)
    private int iloscMagazyn;

    @Column(name = "JednostkaMiary", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String jednostkaMiary;

    @Column(name = "CenaKlient", columnDefinition = "DECIMAL(7,2)", nullable = false)
    private float cenaKlient;

    @Column(name = "CenaMagazyn", columnDefinition = "DECIMAL(7,2)", nullable = false)
    private float cenaMagazyn;

    @OneToMany(mappedBy = "skladnik")
    private Set<ElementZamowieniaMagazynowego> elementyZamowieniaMagazynowego;

    @OneToMany(mappedBy = "skladnik")
    private Set<SkladnikDania> skladnikiDania;

    @OneToMany(mappedBy = "skladnik")
    private Set<SkladnikDaniaZmienionego> skladnikiDaniaZmienionego;

    public String getNazwa() {
        return nazwa;
    }
}
