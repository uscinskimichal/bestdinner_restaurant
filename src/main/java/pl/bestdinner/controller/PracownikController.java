package pl.bestdinner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.bestdinner.repositories.PracownikRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
public class PracownikController {

    private final PracownikRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public PracownikController(PracownikRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value="/pracownicy/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getPracownik(@PathVariable("id") int id){
        return repository.findById(id).toJSONObject().toString();
    }
    @RequestMapping(value="/pracownicy", method = RequestMethod.POST)
    @ResponseBody
    public String addPracownik() {
        return "dupa";
    }
}
