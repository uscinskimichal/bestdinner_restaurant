package pl.bestdinner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.bestdinner.service.ZamowienieRepositoryService;

import java.sql.Date;
import java.util.List;

@Controller
public class ZamowienieController {

    @Autowired
    ZamowienieRepositoryService zamowienieRepositoryService;

    @RequestMapping(value = "/zamowienia", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> getAllZamowienia(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String idKlient,
            @RequestParam(required = false) Date dateFrom,
            @RequestParam(required = false) Date dateTo,
            @RequestParam(required = false) String type) {
        return zamowienieRepositoryService.executeQuery(status, idKlient, dateFrom, dateTo, type);
    }


    @RequestMapping(value = "/zamowienia/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getZamowienie(@PathVariable("id") int id) {
        return zamowienieRepositoryService.findById(id).get();
    }

    @RequestMapping(value = "/zamowienia", method = RequestMethod.POST)
    @ResponseBody
    public String addZamowienie() {
        return "dupa";
    }
}
