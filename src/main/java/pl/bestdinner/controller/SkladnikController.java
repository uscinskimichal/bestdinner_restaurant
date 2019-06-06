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
import pl.bestdinner.model.Skladnik;
import pl.bestdinner.repositories.DanieRepository;
import pl.bestdinner.repositories.PracownikRepository;
import pl.bestdinner.repositories.SkladnikRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class SkladnikController {

    @Autowired
    SkladnikRepository skladnikRepository;

    @RequestMapping(value = "/skladniki", method = RequestMethod.GET)
    @ResponseBody
    public List<Skladnik> getSkladniki() {
        return skladnikRepository.findAll();
    }


    @RequestMapping(value = "/skladniki/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getSkladnik(@PathVariable("id") int id) {
        return skladnikRepository.findSkladnik(id);
    }


}
