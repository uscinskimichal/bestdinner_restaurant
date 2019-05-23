package pl.bestdinner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.bestdinner.model.Zamowienie;
import pl.bestdinner.repositories.KlientRepository;
import pl.bestdinner.repositories.ZamowienieRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class ZamowienieController {

    @Autowired
    ZamowienieRepository zamowienieRepository;


    @RequestMapping(value = "/zamowienia", method = RequestMethod.GET)
    @ResponseBody
    public List<Zamowienie> getAllZamowienia() {
        return zamowienieRepository.findAll();
    }

    @RequestMapping(value = "/zamowienia/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Zamowienie getZamowienie(@PathVariable("id") int id) {
        return zamowienieRepository.findById(id).get();
    }

    @RequestMapping(value = "/zamowienia", method = RequestMethod.POST)
    @ResponseBody
    public String addZamowienie() {
        return "dupa";
    }
}
