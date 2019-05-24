package pl.bestdinner.controller;

import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.model.Danie;
import pl.bestdinner.model.Klient;
import pl.bestdinner.model.Pracownik;
import pl.bestdinner.model.ZamowienieMagazynowe;
import pl.bestdinner.repositories.DanieRepository;
import pl.bestdinner.repositories.KlientRepository;
import pl.bestdinner.repositories.PracownikRepository;
import pl.bestdinner.repositories.ZamowienieMagazynoweRepository;
import pl.bestdinner.service.ZamowienieMagazynoweRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

@Controller
public class ZamowienieMagazynoweController {

    @Autowired
    ZamowienieMagazynoweRepositoryImpl zamowienieMagazynoweRepositoryImpl;


    @RequestMapping(value = "/zamowieniaMagazynowe", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getZamowieniaMagazynowe(
            @RequestParam(required = false) Date dateFrom,
            @RequestParam(required = false) Date dateTo) {
        return zamowienieMagazynoweRepositoryImpl.executeQuery(dateFrom,dateTo);
    }


    @RequestMapping(value = "/zamowieniaMagazynowe/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getZamowienieMagazynowe(@PathVariable("id") int id) {
        return zamowienieMagazynoweRepositoryImpl.findZamowienieMagazynoweById(id);
    }


}
