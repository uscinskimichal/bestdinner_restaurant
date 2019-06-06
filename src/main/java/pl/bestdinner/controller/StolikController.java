package pl.bestdinner.controller;

import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.bestdinner.model.Danie;
import pl.bestdinner.model.Pracownik;
import pl.bestdinner.model.Stolik;
import pl.bestdinner.repositories.DanieRepository;
import pl.bestdinner.repositories.PracownikRepository;
import pl.bestdinner.repositories.StolikRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class StolikController {

    @Autowired
    StolikRepository stolikRepository;

    @RequestMapping(value = "/stoliki", method = RequestMethod.GET)
    @ResponseBody
    public List<Stolik> getStoliki() {
        return stolikRepository.findAll();
    }


    @RequestMapping(value = "/stoliki/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getStolik(@PathVariable("id") int id) {
        return stolikRepository.findStolik(id);
    }


}
