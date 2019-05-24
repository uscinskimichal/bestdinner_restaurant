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
import pl.bestdinner.repositories.DanieRepository;
import pl.bestdinner.repositories.PracownikRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class DanieController {

    @Autowired
    DanieRepository danieRepository;

    @RequestMapping(value = "/dania", method = RequestMethod.GET)
    @ResponseBody
    public List<Danie> getDania() {
        return danieRepository.findAll();
    }


    @RequestMapping(value = "/dania/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getDanie(@PathVariable("id") int id) {
        return danieRepository.findDanie(id);
    }


}
