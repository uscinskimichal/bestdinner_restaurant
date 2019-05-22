package pl.bestdinner.model;

import org.json.JSONObject;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ElementZamowienia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ElementZamowienia")
    private int id_ElementZamowienia;

    @Column(name = "Status", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "ID_Zamowienie", nullable = false)
    private Zamowienie zamowienie;

    @ManyToOne
    @JoinColumn(name = "ID_Danie")
    private Danie danie;

    @ManyToOne
    @JoinColumn(name = "ID_DanieZmienione")
    private DanieZmienione danieZmienione;

    @OneToMany(mappedBy = "elementZamowienia")
    private Set<HistoriaElementuZamowienia> historieElementuZamowienia;

    public JSONObject toJSONObject() {

        JSONObject object = new JSONObject();
        object.put("ID_ElementZamowienia", id_ElementZamowienia);
        object.put("Danie", danie.toJSONObject());
        object.put("Status", status);

        return object;
    }
}
