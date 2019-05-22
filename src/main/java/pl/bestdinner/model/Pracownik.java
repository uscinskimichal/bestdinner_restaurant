package pl.bestdinner.model;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pracownik {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Pracownik")
    private int id_Pracownik;

    @Column(name = "Imie", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String imie;

    @Column(name = "Nazwisko", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String nazwisko;

    @Column(name = "Login", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String login;

    @Column(name = "Email", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String email;

    @Column(name = "Haslo", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String haslo;

    @Column(name = "Rola", columnDefinition = "VARCHAR(1024)", nullable = false)
    private String rola;

    @ManyToOne
    @JoinColumn(name = "ID_Adres", nullable = false)
    private Adres adres;

    @OneToMany(mappedBy = "pracownik")
    private Set<HistoriaElementuZamowienia> historieElementuZamowienia;

    @OneToMany(mappedBy = "pracownik")
    private Set<ZamowienieMagazynowe> zamowieniaMagazynowe;

    @OneToMany(mappedBy = "pracownik")
    private Set<Zamowienie> zamowienia;

    @OneToMany(mappedBy = "pracownik")
    private Set<HistoriaZamowienia> historieZamowienia;

    public int getId_Pracownik() {
        return id_Pracownik;
    }

    public JSONObject toJSONObject() {

        JSONObject object = new JSONObject();

        object.put("Imie", imie);
        object.put("Nazwisko", nazwisko);
        object.put("Login", login);
        object.put("Email", email);
        object.put("Haslo",haslo);
        object.put("Rola",rola);

        return object;
    }
}
