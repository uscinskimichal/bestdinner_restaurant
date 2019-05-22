package pl.bestdinner.controller;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.model.Klient;
import pl.bestdinner.model.Zamowienie;
import pl.bestdinner.repositories.KlientRepository;
import pl.bestdinner.repositories.ZamowienieRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Controller
public class ZamowienieController {

    private final ZamowienieRepository repository;
    private final KlientRepository klientRepostory;

    @PersistenceContext
    private EntityManager entityManager;

    public ZamowienieController(ZamowienieRepository repository, KlientRepository klientRepostory) {
        this.repository = repository;
        this.klientRepostory = klientRepostory;
    }

    @RequestMapping(value="/zamowienia", method = RequestMethod.GET)
    @ResponseBody
    public String getAllZamowienia(
            @RequestParam(value="status", required = false) String status,
            @RequestParam(value="clientId", required = false) Integer clientId,
            @RequestParam(value="dateFrom", required = false) String dateFrom,
            @RequestParam(value="dateTo", required = false) String dateTo,
            @RequestParam(value="type", required = false) String type) throws ParseException {

        JSONArray json = new JSONArray();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Zamowienie> query = builder.createQuery(Zamowienie.class);
        Root<Zamowienie> root = query.from(Zamowienie.class);

        ArrayList<Predicate> predicates = new ArrayList<>();

        if(status != null) {
            predicates.add(builder.equal(root.get("status"), status));
        }
        if(type != null) {
            predicates.add(builder.equal(root.get("typ"), type));
        }
        if(dateFrom != null) {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            predicates.add(builder.greaterThanOrEqualTo(root.get("data"), formatter.parse(dateFrom)));
        }
        if(dateTo != null) {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            predicates.add(builder.lessThanOrEqualTo(root.get("data"), formatter.parse(dateTo)));
        }
        if(clientId != null) {
            predicates.add(builder.isMember(klientRepostory.findById(clientId), root.get("klienci")));
        }

        query.where(builder.and(predicates.toArray(new Predicate[0])));

        for(Zamowienie zam : entityManager.createQuery(query.select(root)).getResultList()) {
            json.put(zam.toJSONObject());
        }

        return json.toString();
    }

    @RequestMapping(value="/zamowienia/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getZamowienie(@PathVariable("id") int id) {
        return repository.findById(id).toJSONObject().toString();
    }

    @RequestMapping(value="/zamowienia", method = RequestMethod.POST)
    @ResponseBody
    public String addZamowienie() {
        return "dupa";
    }
}
