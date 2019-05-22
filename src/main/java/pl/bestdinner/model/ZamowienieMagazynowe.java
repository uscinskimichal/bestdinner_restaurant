package pl.bestdinner.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
public class ZamowienieMagazynowe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ZamowienieMagazynowe")
    private int id_ZamowienieMagazynowe;

    @Column(name = "Data", columnDefinition = "DATETIME", nullable = false)
    private Timestamp data;

    @OneToMany(mappedBy = "zamowienieMagazynowe")
    private Set<ElementZamowieniaMagazynowego> elementyZamowieniaMagazynowego;

    @ManyToOne
    @JoinColumn(name = "ID_Pracownik", nullable = false)
    private Pracownik pracownik;

}
