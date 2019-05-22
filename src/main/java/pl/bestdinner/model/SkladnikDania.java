package pl.bestdinner.model;

import org.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SkladnikDania implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ilosc")
    private int ilosc;

    @ManyToOne
    @Id
    @JoinColumn(name = "ID_Skladnik", nullable = false)
    private Skladnik skladnik;

    @ManyToOne
    @Id
    @JoinColumn(name = "ID_Danie", nullable = false)
    private Danie danie;

    public JSONObject getJSONObject() {

        JSONObject object = new JSONObject();
        object.put("ilosc", ilosc);
        object.put("nazwa", skladnik.getNazwa());

        return object;
    }
}
