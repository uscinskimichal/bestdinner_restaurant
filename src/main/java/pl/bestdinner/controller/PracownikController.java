package pl.bestdinner.controller;

import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.bestdinner.model.Pracownik;
import pl.bestdinner.repositories.PracownikRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class PracownikController {

    @Autowired
    PracownikRepository pracownikRepository;

    @RequestMapping(value = "/pracownicy", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getPracownik() {
        return pracownikRepository.findAllPracownik();
    }


    @RequestMapping(value = "/pracownicy/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getPracownik(@PathVariable("id") int id) {
        return pracownikRepository.findPracownik(id);
    }


    @RequestMapping(value = "/pracownicy", method = RequestMethod.POST)
    @ResponseBody
    public String addPracownik() {
        return "dupa";
    }
}
