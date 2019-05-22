package pl.bestdinner.model;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Danie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Danie")
    private int id_Danie;

    @Column(name = "Nazwa", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String nazwa;

    @Column(name = "Cena", columnDefinition = "DECIMAL(7,2)", nullable = false)
    private float cena;

    @Column(name = "Zdjecie", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String zdjecie;

    @OneToMany(mappedBy = "danie")
    private Set<SkladnikDania> skladnikiDania;

    @OneToMany(mappedBy = "danie")
    private Set<DanieZmienione> daniaZmienione;

    @OneToMany(mappedBy = "danie")
    private Set<ElementZamowienia> elementyZamowienia;

    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        JSONArray listaSkladnikow = new JSONArray();

        for(SkladnikDania sd : skladnikiDania) {
            listaSkladnikow.put(sd.getJSONObject());
        }

        object.put("Nazwa", nazwa);
        object.put("Cena", cena);
        object.put("ListaSkladnikow", listaSkladnikow);

        return object;
    }
}