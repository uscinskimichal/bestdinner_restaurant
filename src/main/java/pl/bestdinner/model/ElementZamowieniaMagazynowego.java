package pl.bestdinner.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

    public int getId_ElementZamowieniaMagazynowego() {
        return id_ElementZamowieniaMagazynowego;
    }

    public void setId_ElementZamowieniaMagazynowego(int id_ElementZamowieniaMagazynowego) {
        this.id_ElementZamowieniaMagazynowego = id_ElementZamowieniaMagazynowego;
    }

    public int getIloscMagazyn() {
        return iloscMagazyn;
    }

    public void setIloscMagazyn(int iloscMagazyn) {
        this.iloscMagazyn = iloscMagazyn;
    }

    public Skladnik getSkladnik() {
        return skladnik;
    }
}
