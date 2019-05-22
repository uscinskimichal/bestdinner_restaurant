package pl.bestdinner.model;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Zamowienie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Zamowienie")
    private Integer id_Zamowienie;

    @Column(name = "Status", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String status;

    @Column(name = "Data", columnDefinition = "DATETIME", nullable = false)
    private Timestamp data;

    @Column(name = "Typ", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String typ;

    @ManyToOne
    @JoinColumn(name = "ID_Adres", nullable = false)
    private Adres adres;

    @ManyToOne
    @JoinColumn(name = "ID_Stolik", nullable = false)
    private Stolik stolik;

    @OneToMany(mappedBy = "zamowienie")
    private Set<ElementZamowienia> elementyZamowienia;

    @OneToMany(mappedBy = "zamowienie")
    private Set<HistoriaZamowienia> historieZamowienia;

    @ManyToMany(mappedBy = "zamowienia")
    private Set<Klient> klienci = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "ID_Pracownik", nullable = false)
    private Pracownik pracownik;

    public JSONObject toJSONObject() {

        JSONObject object = new JSONObject();
        JSONArray elementy = new JSONArray();

        for(ElementZamowienia ez : elementyZamowienia) {
            elementy.put(ez.toJSONObject());
        }

        object.put("Status", status);
        object.put("Data", data);
        object.put("Typ", typ);
        object.put("ElementyZamowienia", elementy);

        return object;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
}
