package pl.bestdinner.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ElementZamowieniaMagazynowego {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ElementZamowieniaMagazynowego")
    private int id_ElementZamowieniaMagazynowego;

    @Column(name = "IloscMagazyn", columnDefinition = "INT", nullable = false)
    private int iloscMagazyn;

    @ManyToOne
    @JoinColumn(name = "ID_Skladnik", nullable = false)
    private Skladnik skladnik;

    @ManyToOne
    @JoinColumn(name = "ID_ZamowienieMagazynowe", nullable = false)
    private ZamowienieMagazynowe zamowienieMagazynowe;

}
