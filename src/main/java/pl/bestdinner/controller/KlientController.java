package pl.bestdinner.controller;

import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.bestdinner.model.Danie;
import pl.bestdinner.model.Klient;
import pl.bestdinner.model.Pracownik;
import pl.bestdinner.repositories.DanieRepository;
import pl.bestdinner.repositories.KlientRepository;
import pl.bestdinner.repositories.PracownikRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class KlientController {

    @Autowired
    KlientRepository klientRepository;


    @RequestMapping(value = "/klienci", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getKlienci() {
        return klientRepository.findKlienci();
    }


    @RequestMapping(value = "/klienci/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getKlient(@PathVariable("id") int id) {
        return klientRepository.findKlient(id);
    }


}
